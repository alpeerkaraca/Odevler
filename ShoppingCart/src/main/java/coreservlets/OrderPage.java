package coreservlets;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.*;
import java.text.*;

@WebServlet("/coreservlets.OrderPage")
public class OrderPage extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ShoppingCart cart;
        synchronized(session) {
            cart = (ShoppingCart) session.getAttribute("shoppingCart");
            if (cart == null) {
                cart = new ShoppingCart();
                session.setAttribute("shoppingCart", cart);
            }

            String itemID = request.getParameter("itemID");
            if (itemID != null) {
                String numItemsString = request.getParameter("numItems");
                if (numItemsString == null) {
                    cart.addItem(itemID);
                } else {
                    int numItems;
                    try {
                        numItems = Integer.parseInt(numItemsString);
                    } catch (NumberFormatException nfe) {
                        numItems = 1;
                    }
                    cart.setNumOrdered(itemID, numItems);
                }
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Status of Your Order";
        String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";

        out.println(docType +
                    "<HTML>\n" +
                    "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                    "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                    "<H1 ALIGN=\"CENTER\">" + title + "</H1>");

        synchronized(session) {
            List<ItemOrder> itemsOrdered = cart.getItemsOrdered();
            if (itemsOrdered.size() == 0) {
                out.println("<H2><I>No items in your cart...</I></H2>");
            } else {
                NumberFormat formatter = NumberFormat.getCurrencyInstance();

                out.println("<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
                            "<TR BGCOLOR=\"#FFAD00\">\n" +
                            " <TH>Item ID<TH>Description\n" +
                            " <TH>Unit Cost<TH>Number<TH>Total Cost");

                for (ItemOrder order : itemsOrdered) {
                    out.println("<TR>\n" +
                                " <TD>" + order.getItemID() + "\n" +
                                " <TD>" + order.getShortDescription() + "\n" +
                                " <TD>" + formatter.format(order.getUnitCost()) + "\n" +
                                " <TD>" +
                                "<FORM>\n" +
                                "<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\"\n" +
                                " VALUE=\"" + order.getItemID() + "\">\n" +
                                "<INPUT TYPE=\"TEXT\" NAME=\"numItems\"\n" +
                                " SIZE=3 VALUE=\"" + order.getNumItems() + "\">\n" +
                                "<SMALL>\n" +
                                "<INPUT TYPE=\"SUBMIT\" VALUE=\"Update Order\">\n" +
                                "</SMALL>\n" +
                                "</FORM>\n" +
                                " <TD>" + formatter.format(order.getTotalCost()));
                }

                String checkoutURL = response.encodeURL("Checkout.html");
                out.println("</TABLE>\n" +
                            "<FORM ACTION=\"" + checkoutURL + "\">\n" +
                            "<BIG><CENTER>\n" +
                            "<INPUT TYPE=\"SUBMIT\" VALUE=\"Proceed to Checkout\">\n" +
                            "</CENTER></BIG></FORM>");
            }
            out.println("</BODY></HTML>");
        }
    }
}

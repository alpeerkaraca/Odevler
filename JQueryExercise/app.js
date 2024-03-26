
$(document).ready(function() {
    $('#register-form').submit(function(e) {
        var error = false;

        // E-posta kontrolü
        var email = $('#email').val();
        if (!isValidEmail(email)) {
            $('#email').addClass('error');
            error = true;
        } else {
            $('#email').removeClass('error');
        }

        // Diğer alanların boş olup olmadığını kontrol et
        $('input[type="text"], input[type="tel"], input[type="password"]').each(function() {
            if ($(this).val() === '') {
                $(this).addClass('error');
                error = true;
            } else {
                $(this).removeClass('error');
            }
        });

        // Şifrelerin eşleşip eşleşmediğini kontrol et
        var password = $('#password').val();
        var passAgain = $('#pass-again').val();
        console.log(password, passAgain)
        if (password !== passAgain) {
            $('#pass-again').addClass('error');
            $('#pass-error').text('Şifreler uyuşmuyor');
            error = true;
        } else {
            $('#sifre_tekrar').removeClass('error');
            $('#pass-error').text('');
        }
        $('#pass-again').click(function() {
            console.log('click')

        // Hata varsa formun gönderilmesini engelle
        if (error) {
            e.preventDefault();
        } else {
            alert('Kayıt başarıyla tamamlandı!\n\nE-posta: ' + email + '\nAd: ' + $('#ad').val() + '\nSoyad: ' + $('#soyad').val() + '\nCep Telefonu: ' + $('#cep_telefonu').val());
        }
    });

    // E-posta doğrulama işlevi
    function isValidEmail(email) {
        var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);
    }
});
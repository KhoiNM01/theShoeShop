document.getElementById('registrationForm').addEventListener('submit', function (event) {
    event.preventDefault(); // Ngăn việc gửi biểu mẫu

    const contactInfo = document.getElementById('contactInfo').value;
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmPassword').value;

    // Kiểm tra độ dài mật khẩu và mạnh mẽ của mật khẩu
    // ... (Những kiểm tra khác)

     if (!isValidEmailOrPhone(contactInfo)) {
        alert('Email hoặc số điện thoại không hợp lệ');
       
    } else if (!doPasswordsMatch(password, confirmPassword)) {
        alert('Mật khẩu và mật khẩu xác nhận không hợp lệ');
    }
    
    else if (contactInfo && password && confirmPassword) {
        // Xác định trạng thái đăng ký thành công
        isRegistrationSuccess = true;

        // Hiển thị thông báo đăng ký thành công
        const successMessage = document.getElementById('successMessage');
        successMessage.style.display = 'block';

          setTimeout(function () {
             successMessage.style.display = 'none';
         }, 3000);

    }
});

function isValidEmailOrPhone(contactInfo) {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const phoneRegex = /^\d{10}$/; // Ví dụ: Kiểm tra xem có 10 chữ số

    return emailRegex.test(contactInfo) || phoneRegex.test(contactInfo);
}

function doPasswordsMatch(password, confirmPassword) {
    return password === confirmPassword && password.length >=1 ;;
}


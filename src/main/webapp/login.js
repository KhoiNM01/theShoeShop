document.getElementById('loginForm').addEventListener('submit', function (event) {
    event.preventDefault(); // Ngăn chặn việc gửi biểu mẫu

    // Lấy thông tin người dùng từ biểu mẫu
    const email = document.getElementById('contactInfo').value;
    const password = document.getElementById('password').value;

    // Gửi thông tin người dùng đến máy chủ để kiểm tra
    // Điều này có thể thực hiện thông qua một yêu cầu AJAX hoặc fetch API

    // Ví dụ kiểm tra email và mật khẩu trong cơ sở dữ liệu
    fetch('/api/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ email, password })
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            // Đăng nhập thành công, chuyển hướng người dùng đến trang home
            window.location.href = 'home.html';
        } else {
            // Đăng nhập không thành công, hiển thị thông báo lỗi
            alert('Email hoặc mật khẩu không đúng');
        }
    })
    .catch(error => {
        console.error('Lỗi khi kiểm tra đăng nhập:', error);
        alert('Đã xảy ra lỗi khi kiểm tra đăng nhập. Vui lòng thử lại sau.');
    });
});

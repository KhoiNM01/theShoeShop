const stars = document.querySelectorAll(".star");

stars.forEach((star) => {
    star.addEventListener("click", () => {
        const rating = parseInt(star.getAttribute("data-rating"));
        const productId = star.getAttribute("data-product-id");

        const selectedRating = document.getElementById(`rating-${productId}`);

        // Tô màu các ngôi sao từ đầu đến ngôi sao được chọn
        stars.forEach((s) => {
            const sProductId = s.getAttribute("data-product-id");
            if (sProductId === productId) {
                const sRating = parseInt(s.getAttribute("data-rating"));
                if (sRating <= rating) {
                    s.classList.add("active");
                } else {
                    s.classList.remove("active");
                }
            }
        });

        selectedRating.textContent = rating;
    });
});
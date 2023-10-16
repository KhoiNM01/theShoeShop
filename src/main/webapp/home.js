



const stars = document.querySelectorAll(".star");

stars.forEach((star) => {
    star.addEventListener("click", () => {
        const rating = parseInt(star.getAttribute("data-rating"));
        const productId = star.getAttribute("data-product-id");

        const selectedRating = document.getElementById(`rating-${productId}`);
        const averageRating = document.getElementById(`average-rating-${productId}`);

        const currentRating = parseInt(selectedRating.textContent);
        const currentAverageRating = parseFloat(averageRating.textContent);

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

        // Tính điểm trung bình mới
        const newTotalRating = rating;
        const newAverageRating = newTotalRating;

        selectedRating.textContent = rating;
        averageRating.textContent = newAverageRating.toFixed(1);
    });
});

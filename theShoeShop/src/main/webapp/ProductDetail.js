const plus = document.querySelector(".plus"),
minus = document.querySelector(".minus"),
num = document.querySelector(".num"),
notify = document.querySelector(".notify");

let a = 1;
let n = "Số lượng không thể vượt quá 99"


plus.addEventListener("click",()=>{
    if(a < 99){
    a++;
    a = (a < 10) ? "0" + a : a;
    num.innerHTML = a;
    console.log(a);
} else {
}
});

minus.addEventListener("click",()=>{
    if(a >= 1) {
    if(a > 1){
    a--;
    a = (a < 10) ? "0" + a : a;
    num.innerHTML = a;
    console.log(a);
    }
} else {}
});

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



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



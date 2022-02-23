const menu = document.querySelector("#menu-bars");
const navbar = document.querySelector(".navbar");
const comment = document.querySelector(".talk-content-foot-etc");
const talk = document.querySelector(".talk-content-comment");

menu.onclick = () => {
  menu.classList.toggle("fa-times");
  navbar.classList.toggle("active");
};

/*comment.onclick = () => {
  talk.classList.toggle("active");
};*/

 const notice = document.querySelector(".notice");
 const notice1 = document.querySelector(".notice-heading1");
 const notice1_i = document.querySelector(".notice-heading1 i");
 const notice1_box = document.querySelector(".notice-box1");
 const notice1_content = document.querySelector(".notice-content1");
 const notice2 = document.querySelector(".notice-heading2");
 const notice2_i = document.querySelector(".notice-heading2 i");
 const notice2_box = document.querySelector(".notice-box2");
 const notice2_content = document.querySelector(".notice-content2");


/* notice1.onclick = () => {
	   notice.classList.toggle("active");
	   notice1_i.classList.toggle("fa-angle-up");
	   notice1_content.classList.toggle("active");
	   notice1_box.classList.toggle("active");
	 };
	 */
/* notice2.onclick = () => {
   notice.classList.toggle("active");
   notice2_i.classList.toggle("fa-angle-up");
   notice2_content.classList.toggle("active");
   notice2_box.classList.toggle("active");
 };
*/
var swiper = new Swiper(".book-box", {
  loop: true,
  grabCursor: true,
  spaceBetween: 20,
  breakpoints: {
    0: {
      slidesPerView: 2.3,
    },
    640: {
      slidesPerView: 2.3,
    },
    768: {
      slidesPerView: 2.3,
    },
    1024: {
      slidesPerView: 8,
    },
  },
});

var swiper = new Swiper(".bookboard-box", {
  loop: true,
  grabCursor: true,
  spaceBetween: 20,
  breakpoints: {
    0: {
      slidesPerView: 2.3,
    },
    640: {
      slidesPerView: 2.3,
    },
    768: {
      slidesPerView: 2.3,
    },
    1024: {
      slidesPerView: 8,
    },
  },
});




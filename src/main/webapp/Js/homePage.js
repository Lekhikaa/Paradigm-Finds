let contain=0;

function controller(x){
    contain=contain+x;
    // if we click on right, controller passes variable by adding +1//
    slideshow(contain);



}


slideshow(contain);

function slideshow(num){
    let slides = document.getElementsByClassName('slide');
    if(num == slides.length){
        contain=0;
        num=0;
    }
    if(num<0){
        contain=slides.length-1;
        num=slides.length-1;

    }


    for(let y of slides){

        y.style.display="none"
    }

    slides[num].style.display="block";
    
}






















































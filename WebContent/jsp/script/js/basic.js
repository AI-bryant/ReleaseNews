/**
 * Created by Administrator on 2016/10/13.
 */
var lists = document.getElementById("list").getElementsByTagName("li");
var goTop = document.getElementById("goTop");

function webAdaptTransition(x,ms){
    x.style.transition="all "+ms+"ms";
    x.style.oTransition="all "+ms+"ms";
    x.style.mozTransition="all "+ms+"ms";
    x.style.webkitTransition="all "+ms+"ms";
}

function changeBorder(num){
    for(var i = 0;i<lists.length;i++){
        if(num==i){
            lists[i].style.borderBottom="solid 2px #5087f8";
            lists[i].style.width="150px";
            lists[i].style.backgroundColor="#f4f4f4";
            webAdaptTransition(lists[i],1000);
        }
    }
}

function backBorder(num){
    for(var i = 0;i<lists.length;i++){
        if(num==i){
            lists[i].style.borderBottom="solid 2px #ffffff";
            lists[i].style.width="100px";
            lists[i].style.backgroundColor="#ffffff";
            webAdaptTransition(lists[i],1000);
        }
    }
}









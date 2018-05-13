$(function () {
    $(".validImg").click(function () {
        $(this).attr("src",ctx+"/image?time="+new Date());
    })
})
/**
 * Created by wangzhao on 2019/6/27.
 */
//****************关于 placeholder 兼容问题修改****************
$(function() {

    if(!placeholderSupport()){   // 判断浏览器是否支持 placeholder 不支持则执行以下代码
        $('[placeholder]').focus(function() {
            var input = $(this);
            var span = input.prev();
            if (span.text() == input.attr('placeholder')) {
                input.removeClass('placeholder');
                span.css('display','none');
            }
        }).blur(function() {
            var input = $(this);
            var span = input.prev();
            if (input.val() == '') {
                input.addClass('placeholder');
                if(typeof(input.attr("readonly"))!="undefined"){
                    //选择框特殊处理
                    span.css('z-index','100');
                }
                change_span(span);
                span.css('display','');
            }else{
                span.css('display','none');
            }
        }).blur();
        //选择框变化处理
        $('input').bind('input propertychange', function(){
            var input = $(this);
            var span = input.prev();
            if (input.val() != '') {
                input.removeClass('placeholder');
                span.css('display','none');
            }
        })
    }
})

//判断 placeholder 属性是否可以使用的方法
function placeholderSupport() {
    return 'placeholder' in document.createElement('input');
}

//修正提示信息位置
function change_span(node){
    node.css('width','176px');
    node.css('height','34px');
    node.css('line-height','34px');
}
//****************关于 placeholder 兼容问题修改 end ****************
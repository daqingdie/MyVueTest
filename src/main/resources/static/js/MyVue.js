var app5 = new Vue({
    el: '#app5',
    data: {
        message: '测试vue'
    }
});

const sum=function(){
    console.log("测试打印内容");
};

//模块化导出格式为:export{属性名/方法名/类名...}
export {
    sum
}

//也可以用export var 属性名/方法名=定义,的格式导出
export var flag = '测试内容';

//使用export default导出可以让导入方自定义名称,但只能导出一个
var message = "默认导出内容";
export default message;
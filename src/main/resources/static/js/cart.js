const app = new Vue({
    el: "#app",
    data:{
        message:'购物车演示',
        books:[{id:1,name:"JAVA开发",btime:"2019.03",price:23.99,num:1},
                {id:2,name:"C++开发",btime:"2019.04",price:22.99,num:1},
                {id:3,name:"Python开发",btime:"2019.05",price:28.99,num:1},
                {id:4,name:"PHP开发",btime:"2019.06",price:24.99,num:1},
        ],
        nums: [1, 2, 3, 4, 5,],
        isBooks:false,
    },
    computed:{
        sumP:function() {
            return this.books.reduce((pre, b) => pre + b.price*b.num,1);
        },
        sum:function () {
            return 1;
        }
    },
    methods: {
        arm(id) {
            for(let i=0;i<this.books.length;i++){
                if(this.books[i].id==id){
                    this.books.splice(i, 1);
                    if(this.books.length==0)
                        this.isBooks=true;
                }
            }
            //window.alert("移除成功");
        },
        change(num,id) {
            if(num<=1){
                window.alert("数量不可以小于1");
            }else {
                for(let b of this.books)
                    if(b.id==id)
                        b.num--;
            }

        }
    },
    //filters过滤器格式，方法名(过滤的参数){},调用时在属性后面加“|过滤器”，会自动将该属性作为参数传进来
    filters:{
        showPrice(price) {
            return "￥"+price.toFixed(2)  //toFixed可以限制小数点后位数
        },
    },

})

//模块化导入的格式为 import {方法名/属性名} from "路径(如./MyVue.js)";
import {flag, sum} from "./MyVue.js";

//导入默认,可自定义名称
import mymessage from "./MyVue.js"

//导入全部数据,格式为import * as 名字 from "路径",调用时采用名字.属性调用
import * as aa from "./MyVue.js"

const mysum=function () {
    console.log(flag);
    console.log(mymessage);
    sum();
    console.log(aa.flag);
}()
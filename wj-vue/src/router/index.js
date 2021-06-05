import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import App from "../App";
import Appindex from "../components/home/Appindex";
import Login from "../components/Login";
import Data from "../components/home/Data";
import Index from "../components/Index"
import PageOne from "../components/PageOne";
import PageTwo from "../components/PageTwo";
import PageThree from "../components/PageThree";
import PageFour from "../components/PageFour";
import Nac from "../components/Nav"
Vue.use(Router)

export default new Router({
  mode: "history",
  routes: [
    {
      path: '/',
      name: '图书管理',
      component: Index,
      redirect:'/PageOne',
      children:[
        {
          path:'/PageOne',
          name:"查询图书",
          component:PageOne,
          show:true
        },
        {
          path:'/PageTwo',
          name:"添加图书",
          component:PageTwo,
          show:true
        },
        {
          path:'/update',
          name:"更新图书",
          component:PageThree,
          show:false
        }
      ]
    },

    // {
    //   path:'/nav',
    //   name:"导航2",
    //   component:Index,
    //   children:[
    //     {
    //       path:'/PageThree',
    //       name:"PageThree",
    //       component:PageThree
    //     },
    //     {
    //       path:'/PageFour',
    //       name:"PageFour",
    //       component:PageFour
    //     }
    //   ]
    // }
    // {
    //   path:'/login',
    //   name:'Login',
    //   component:Login
    // },
    // {
    //   path:'/index',
    //   name:'AppIndex',
    //   component:Appindex,
    //   meta: {
    //     requireAuth: true
    //   }
    // },
    // {
    //   path:'/data',
    //   name:'Data',
    //   component:Data
    // }
  ]
})

package com.lq.demo.controller;

import com.lq.demo.domain.User;
import com.lq.demo.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    @Autowired
    private DemoMapper demoMapper;

    @RequestMapping("/hello")
    public String index(Model model) {
        StringBuilder data = new StringBuilder();
        for (User user : demoMapper.grtAll()) {
            data.append("\n用户ID" + user.getId());
            data.append("\n用户名称" + user.getUserName());
            data.append("\n用户密码" + user.getPassword());
            data.append("\n用户权限" + user.getPower());
        }
        model.addAttribute("user", demoMapper.grtAll().get(0));
        model.addAttribute("data", data);
//        return data.toString();
        return "hello";
    }

    @RequestMapping("/vue")
    public String vueTest(Model model) {
        return "vue_test/vueTest1";
    }

    @RequestMapping("/vue2")
    public String vueTest2(Model model) {
        return "vue_test/vueTest2";
    }

    @RequestMapping("/vue_bind")
    public String vueBind(Model model) {
        return "/vue/vue_bind";
    }

    @RequestMapping("/vue_computed_1")
    public String vue_computed_1(Model model) {
        return "/vue/vue_computed_1";
    }

    @RequestMapping("/es6")
    public String es6(Model model) {
        return "/vue02/vue_es6";
    }

    @RequestMapping("/es6_str")
    public String es6_str(Model model) {
        return "/vue02/vue_es6_str";
    }

    @RequestMapping("/vue_vOn")
    public String vue_vOn() {
        return "/vue02/vue_v-on";
    }

    @RequestMapping("/vue_vIf")
    public String vue_vIf() {
        return "/vue02/v-if";
    }

    @RequestMapping("/vue_vIf_test")
    public String vue_vIf_test() {
        return "/vue02/v-if_test";
    }

    @RequestMapping("/v-show")
    public String vue_vShow() {
        return "/vue03/vue_v-show";
    }

    @RequestMapping("/v-for")
    public String vue_v_for() {
        return "/vue03/vue_v-for";
    }

    @RequestMapping("/v-for-methods")
    public String vue_v_for_methods() {
        return "/vue03/v-for-methods";
    }

    @RequestMapping("/vue_v-for_test")
    public String vue_v_for_test() {
        return "/vue03/vue_v-for_test";
    }


    @RequestMapping("cart")
    public String cart() {
        return "/vue03/cart/cart";
    }

    @RequestMapping("es6_high")
    public String es6_high() {
        return "/vue04/vue_es6_high";
    }

    @RequestMapping("model")
    public String vue_model() {
        return "/vue04/vue_model";
    }

    @RequestMapping("component_1")
    public String vue_component_1() {
        return "/vue04/vue_component_1";
    }

    @RequestMapping("component_2")
    public String vue_component_2() {
        return "/vue04/vue_component_2";
    }

    @RequestMapping("cpn_test1")
    public String vue_cpn_test1() {
        return "/vue05/vue_cpn_test1";
    }

    @RequestMapping("cpn3")
    public String vue_vue_cpn3() {
        return "/vue05/vue_cpn3";
    }

    @RequestMapping("slot")
    public String vue_vue_slot3() {
        return "/vue05/vue_slot";
    }

    @RequestMapping("es6_module")
    public String vue_es6_module() {
        return "/vue05/vue_es6_module";
    }

    @RequestMapping("vue_test30")
    public String vue_test30() {
        return "/vue05/vue_test";
    }






}

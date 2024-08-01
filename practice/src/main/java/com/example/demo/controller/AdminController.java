package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin/signin")
    public String signin() {
        return "admin/signin"; 
    }

    @GetMapping("/admin/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin/signup"; 
    }

    @PostMapping("/admin/signup")
    public String registerAdmin(@ModelAttribute Admin admin, Model model) {
        try {
            // 管理者の情報を保存
            adminService.registerNewAdmin(admin);

            // 成功メッセージを追加
            model.addAttribute("message", "管理者が正常に登録されました。");

            // 登録後のリダイレクト先を指定
            return "redirect:/admin/signin";
        } catch (Exception e) {
            // エラーメッセージを追加
            model.addAttribute("error", "登録に失敗しました。");
            return "admin/signup"; // フォームに戻る
        }
    }
}

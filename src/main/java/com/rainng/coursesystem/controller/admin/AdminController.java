package com.rainng.coursesystem.controller.admin;

import com.rainng.coursesystem.config.themis.annotation.Admin;
import com.rainng.coursesystem.controller.BaseController;
import com.rainng.coursesystem.model.entity.AdminEntity;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.admin.AdminService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Admin(Admin.ADMIN_MANAGE)
@RequestMapping("/admin/admin")
@RestController
public class AdminController extends BaseController {
    private final AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    //管理员管理获取信息
    @GetMapping("/{id}")
    public ResultVO get(@PathVariable Integer id) {
        System.out.println("get");
        return service.get(id);
    }

    @PostMapping
    public ResultVO create(@RequestBody @Validated AdminEntity entity) {
        System.out.println("create");
        return service.create(entity);
    }

    @DeleteMapping("/{id}")
    public ResultVO delete(@PathVariable Integer id) {
        System.out.println("delete");
        return service.delete(id);
    }

    @PutMapping
    public ResultVO update(@RequestBody @Validated AdminEntity entity) {
        System.out.println("update");
        return service.update(entity);
    }

    //管理员管理员管理
    @GetMapping()
    public ResultVO list() {
        System.out.println("list");
        return service.list();
    }
}

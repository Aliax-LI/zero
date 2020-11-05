package com.example.zero.api;

import com.example.zero.model.FbSysUser;
import com.example.zero.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private SysUserService userService;

    /**
     * 查询全部
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/listAll")
    public Object listAll(@RequestParam(value = "page",defaultValue = "1")int page,
                          @RequestParam(value = "size",defaultValue = "10")int size){
        return userService.listAll(page, size);
    }

    /**
     * 添加数据
     * @param user
     * @return
     */
    @PostMapping("/insert")
    public int insert (FbSysUser user){
        return userService.insert(user);
    }

    /**
     * 删除
     * @param userId
     * @return
     */
    @DeleteMapping("/remove/{userId}")
    public int remove(@PathVariable Integer userId){
        return userService.remove(userId);
    }

    /**
     * 修改
     * @param user
     * @return
     */
    @PutMapping("/update")
    public int update(FbSysUser user){
        return userService.update(user);
    }
}

package com.rick.project.user.web;

import com.rick.db.dto.Grid;
import com.rick.project.user.api.UserService;
import com.rick.project.user.dao.dataobject.UserDO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@RestController
@RequestMapping("pages")
@RequiredArgsConstructor
public class PageController {

    private final UserService userService;

    /**
     * http://localhost:8080/pages
     */
    @RequestMapping()
    public String pages() {
        Grid<UserDO> g1 = userService.page1();
        Grid<UserDO> g2 = userService.page2();
        Grid<Map<String, Object>> g3 = userService.page3();
        System.out.println(g1);
        System.out.println(g2);
        System.out.println(g3);

        return "success";
    }

}



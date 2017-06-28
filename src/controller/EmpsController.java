package controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import domain.Emps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import service.EmpsService;
import util.MyTool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */
@Controller
public class EmpsController {
    @Autowired
    private EmpsService empsService;

    @RequestMapping("/goMain")
    public String goMain(ModelMap modelMap){
        List<Emps> list=empsService.getAllEmps();
        modelMap.addAttribute("list",list);
        return "main";
    }

    @RequestMapping("/findLikeName")
    public String findLikeName(String name,ModelMap modelMap){
        modelMap.addAttribute("list",empsService.getLikeName(name));
        return "main";
    }

    @RequestMapping("/goChangeUI")
    public String goChangeUI(ModelMap modelMap, HttpServletRequest request){
        String empid=request.getParameter("empid");
        modelMap.addAttribute("emp",empsService.getByEmpid(empid));
        return "change";
    }

    @RequestMapping("/changeEmp")
    public String changeEmp(Emps emps,ModelMap modelMap,@RequestParam("photo1")MultipartFile uploadfile,HttpSession session){
        System.out.println(emps.getEname()+emps.getEmpid());
        String path=session.getServletContext().getRealPath("\\images")+"\\"+uploadfile.getOriginalFilename();
        emps.setPhoto(path);
        File file=new File(path);
        try {
            uploadfile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        empsService.changeEmpByEmpid(emps);
        modelMap.addAttribute("list",empsService.getAllEmps());
        return "main";
    }

    @RequestMapping("/goAddEmpUI")
    public String goAddEmpUI(ModelMap modelMap){
        modelMap.addAttribute("empid", MyTool.getRandomEmpid());
        return "addEmp";
    }

    @RequestMapping("/addEmp")
    public String addEmp(Emps emps, @RequestParam("photo1")MultipartFile uploadfile, ModelMap modelMap, HttpSession session){
        System.out.println(emps.getEmpid()+emps.getHiredate()+","+uploadfile.getOriginalFilename());
//        emps.setPhoto(uploadfile.getOriginalFilename());
        String path=session.getServletContext().getRealPath("\\images")+"\\"+uploadfile.getOriginalFilename();
        emps.setPhoto(path);
        File file=new File(path);
        try {
            uploadfile.transferTo(file);
            empsService.addEmp(emps);
        } catch (IOException e) {
            e.printStackTrace();
        }
        modelMap.addAttribute("list",empsService.getAllEmps());
        return "main";
    }
    @RequestMapping("/delEmp")
    public String delEmp(HttpServletRequest request,ModelMap modelMap){
        String empid=request.getParameter("empid");
        empsService.delEmp(empid);
        modelMap.addAttribute("list",empsService.getAllEmps());
        return "main";
    }
}

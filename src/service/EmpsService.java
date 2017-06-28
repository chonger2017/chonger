package service;

import domain.Emps;
import mapper.EmpsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */
@Service
public class EmpsService {
    @Autowired
    private EmpsMapper empsMapper;

    public List<Emps> getAllEmps(){
        List<Emps> list=empsMapper.getAllEmps();
        for (int i=0;i<list.size();i++){
            int index=list.get(i).getPhoto().lastIndexOf("\\");
            list.get(i).setPhoto(list.get(i).getPhoto().substring(index+1));
        }
        return list;
    }

    public List<Emps> getLikeName(String name){
        List<Emps> list=empsMapper.getLikeName(name);
        for (int i=0;i<list.size();i++){
            int index=list.get(i).getPhoto().lastIndexOf("\\");
            list.get(i).setPhoto(list.get(i).getPhoto().substring(index+1));
        }
        return list;
    }

    public Emps getByEmpid(String empid){
        return empsMapper.getByEmpid(empid);
    }

    @Transactional
    public int changeEmpByEmpid(Emps emp){
        return empsMapper.changeEmpByEmpid(emp.getEname(),emp.getHiredate(),emp.getPhoto(),emp.getEmpid());
    }

    @Transactional
    public int addEmp(Emps emps){
        return empsMapper.addEmp(emps);
    }

    @Transactional
    public int delEmp(String empid){
        return empsMapper.delEemp(empid);
    }
}

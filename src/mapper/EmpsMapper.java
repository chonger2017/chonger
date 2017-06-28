package mapper;

import domain.Emps;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */
public interface EmpsMapper {
    @Select("SELECT * from emps")
    List<Emps> getAllEmps();

    @Select("SELECT * from emps where empid=#{param1}")
    Emps getByEmpid(String empid);

    @SelectProvider(type = EmpSqlProvider.class,method = "getSelectSql")
    List<Emps> getLikeName(String name);

    @Update("update emps set ename=#{param1},hiredate=#{param2},photo=#{param3} where empid=#{param4}")
    int changeEmpByEmpid(String ename, Date hirdate,String photo,String empid);

    @Insert("Insert into emps(empid,ename,hiredate,photo) values(#{empid},#{ename},#{hiredate},#{photo})")
    int addEmp(Emps emps);

    @Delete("Delete from emps where empid=#{empid}")
    int delEemp(String empid);
}

package mapper;

/**
 * Created by Administrator on 2017/6/27.
 */
public class EmpSqlProvider {
    public String getSelectSql(String name){
        return new StringBuilder().append("SELECT * FROM EMPS ")
                                  .append("where empid like '%").append(name).append("%'")
                                  .append("or ename like '%").append(name).append("%'")
                                  .append("or date_format(hiredate,'%Y-%M-%D') like '%")
                                  .append(name).append("%'").toString();
    }
}

import java.io.Serializable;

public class JavaEmployee implements Serializable {

    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private String hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;

    public void setempno(){
        this.empno=empno;
    }

    public Integer getempno(){
        return empno;
    }

    public void setename(){
        this.ename=ename;
    }

    public String getename(){
        return ename;
    }

    public void setjob(){
        this.job=job;
    }

    public String getjob(){
        return job;
    }

    public void setmgr(){
        this.mgr=mgr;
    }

    public Integer getmgr(){
        return mgr;
    }

    public void sethiredate(){
        this.hiredate=hiredate;
    }

    public String gethiredate(){
        return hiredate;
    }

    public void setsal(){
        this.sal=sal;
    }

    public Double getsal(){
        return sal;
    }

    public void setcomm(){
        this.comm=comm;
    }

    public Double getcomm(){
        return comm;
    }

    public void setdeptno(){
        this.deptno=deptno;
    }

    public Integer getdeptno(){
        return deptno;
    }

}

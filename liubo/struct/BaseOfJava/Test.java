package liubo.struct.BaseOfJava;

 class Base {
    public  Base(){
        g();
    }
    public void f(){
        System.out.println("Base f()");
    }
    public void g(){
        System.out.println("Base  g()");
    }
    public void  h(){
        System.out.println("Base h()");
    }

}
class Deriver extends  Base{
    public void f(){
        System.out.println("Derived f()");
    }
    public void g(){
        System.out.println("Derived  g()");
    }
}
public class Test{
    public static void main(String[] args) {
        Base b = new Deriver();
        b.f();
        b.g();
        b.h();
    }
}
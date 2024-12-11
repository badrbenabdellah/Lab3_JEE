package ma.fstt.ejbcontainer;

import jakarta.ejb.Stateless;

@Stateless
public class HelloImpl implements HelloLocal , HelloRemote{
    @Override
    public String sayHello(String name) {
        System.out.println("Hello " + name);
        return "Hello LSI 2024 : " + name;
    }

    @Override
    public Integer add(int a, int b) {
        return a + b ;
    }

    @Override
    public Integer sub(int a, int b) {
        return a - b ;
    }

    public Integer muli(int a, int b) {
        return a * b ;
    }

    @Override
    public Integer divi(int a, int b) {
        return a / b ;
    }
}

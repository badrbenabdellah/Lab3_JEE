package ma.fstt.ejbcontainer;

import jakarta.ejb.Local;

@Local
public interface HelloLocal {


    public String sayHello(String name);

    public Integer add(int a, int b);

    public Integer sub(int a, int b);

    public Integer muli(int a, int b) ;

    public Integer divi(int a, int b);
}

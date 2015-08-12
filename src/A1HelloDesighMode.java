/**
 * Created by wind on 2015/8/11.
 */
public class A1HelloDesighMode {
    public static void main(String[] args){
        Duck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.performFly();
        mallardDuck.performQuack();
    }
}

interface FlyBehavior{
    void fly();
}
class FlyWithWings implements FlyBehavior{
    public void fly(){
        System.out.println("fly with wings");
    }
}
class FlyNoWay implements FlyBehavior{
    public void fly(){
        System.out.println("I can't fly");
    }
}

interface QuackBehavior{
    void quack();
}
class Quack implements QuackBehavior{
    public void quack(){
        System.out.println("quack");
    }
}
class MuteQuack implements QuackBehavior{
    public void quack(){
        System.out.println("<silence>");
    }
}
class Squeak implements QuackBehavior{  //短而尖的叫声
    public void quack(){
        System.out.println("squeak");
    }
}

abstract class Duck {
    //在不同子类中会改变的状态用不同的接口表示
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void performFly(){
        flyBehavior.fly();
    }
    public void performQuack(){
        quackBehavior.quack();
    }
    //使行为可以动态的改变
    public void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }
    public void setQuackBehavior(QuackBehavior quackBehavior){
        this.quackBehavior = quackBehavior;
    }

    //子类中都需要实现的不同成员
    public abstract void display();

    //子类中都实现同样行为的成员
    public void swim(){
        System.out.println("all darks can swim");
    }

    Duck() {
    }
}

class MallardDuck extends Duck {
    public void display(){
        System.out.println("I am a MallardDuck");
    }

    public MallardDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }
}
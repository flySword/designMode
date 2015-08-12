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
class Squeak implements QuackBehavior{  //�̶���Ľ���
    public void quack(){
        System.out.println("squeak");
    }
}

abstract class Duck {
    //�ڲ�ͬ�����л�ı��״̬�ò�ͬ�Ľӿڱ�ʾ
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void performFly(){
        flyBehavior.fly();
    }
    public void performQuack(){
        quackBehavior.quack();
    }
    //ʹ��Ϊ���Զ�̬�ĸı�
    public void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }
    public void setQuackBehavior(QuackBehavior quackBehavior){
        this.quackBehavior = quackBehavior;
    }

    //�����ж���Ҫʵ�ֵĲ�ͬ��Ա
    public abstract void display();

    //�����ж�ʵ��ͬ����Ϊ�ĳ�Ա
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
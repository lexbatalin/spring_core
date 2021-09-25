package kz.spring.core.impls.robots;

import kz.spring.core.interfaces.Hand;
import kz.spring.core.interfaces.Head;
import kz.spring.core.interfaces.Leg;
import kz.spring.core.interfaces.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseModel implements Robot {

    @Autowired
//    @Qualifier("sonyHand")
    private Hand hand;

    @Autowired
//    @Qualifier("sonyLeg")
    private Leg leg;

    @Autowired
//    @Qualifier("sonyHead")
    private Head head;

    public BaseModel() {
        System.out.println(this + " base model constructor()");
    }

    public BaseModel(Hand hand, Leg leg, Head head) {
        this.hand = hand;
        this.leg = leg;
        this.head = head;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Leg getLeg() {
        return leg;
    }

    public void setLeg(Leg leg) {
        this.leg = leg;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    @Override
    public void action() {}

    @Override
    public void dance() {}
}

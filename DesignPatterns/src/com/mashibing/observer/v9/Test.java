package src.com.mashibing.observer.v9;

import java.util.ArrayList;
import java.util.List;

/**
 * @description :
 * @author：jty
 * @date: 2020-11-11
 * @sine: 0.0.1
 */
public class Test {
    public static void main(String[] args) {
        Buttons b = new Buttons();
        b.addActionListener(new MyActionListener());
        b.addActionListener(new MyActionListener2());
        b.buttonPressed();
    }
}

class Buttons {

    private List<ActionListener> actionListeners = new ArrayList<>();

    public void buttonPressed() {
        ActionEvent e = new ActionEvent(System.currentTimeMillis(),this);
        for(int i=0; i<actionListeners.size(); i++) {
            ActionListener l = actionListeners.get(i);
            l.actionPerformed(e);
        }
    }

    public void addActionListener(ActionListener l) {
        actionListeners.add(l);
    }
}

interface ActionListener {
    void actionPerformed(ActionEvent e);
}

class MyActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button pressed!");
    }

}

class MyActionListener2 implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button pressed 2!");
    }

}

class ActionEvent {

    long when;
    Object source;

    public ActionEvent(long when, Object source) {
        super();
        this.when = when;
        this.source = source;
    }


    public long getWhen() {
        return when;
    }

    public Object getSource() {
        return source;
    }

}

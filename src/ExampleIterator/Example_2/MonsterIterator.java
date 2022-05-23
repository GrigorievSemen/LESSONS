package ExampleIterator.Example_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

class MonsterIterator implements Iterator<Monster.Part> {
    private int index = -1;
    private Monster m;

    public MonsterIterator(Monster m) {
        this.m = m;
    }

    public boolean hasNext() {
        if (index == -1) return m.hasHead() || m.hasHand() || m.hasLeg();
        if (index == 0) return m.hasHand() || m.hasLeg();
        if (index == 1) return m.hasLeg();
        return false;
    }

    public Monster.Part next() {
        if (index == -1) {
            if (m.hasHead()) { index = 0; return m.getHead(); }
            if (m.hasHand()) { index = 1; return m.getTheOnlyHand(); }
            if (m.hasLeg()) { index = 2; return m.getTheOnlyLeg(); }
        }
        if (index == 0) {
            if (m.hasHand()) { index = 1; return m.getTheOnlyHand(); }
            if (m.hasLeg()) { index = 2; return m.getTheOnlyLeg(); }
        }
        if (index == 1) {
            if (m.hasLeg()) { index = 2; return m.getTheOnlyLeg(); }
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        if (index == -1) throw new IllegalStateException();
        if (index == 0)
            if (m.hasHead()) m.setHead(null);
            else throw new IllegalStateException();
        if (index == 1)
            if (m.hasHand()) m.setTheOnlyHand(null);
            else throw new IllegalStateException();
        if (index == 2)
            if (m.hasLeg()) m.setTheOnlyLeg(null);
            else throw new IllegalStateException();
    }
}

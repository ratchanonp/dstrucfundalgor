package datastr;

public class Polynomial {
    private LinkedNode header = new LinkedNode(0, 0, null);

    public void addTerm(double c, int e) {
        LinkedNode node = header;
        while (node.next != null && node.next.exp <= e) {
            node = node.next;
        }

        if (node.exp == e) {
            node.coef += c;
        } else {
            node.next = new LinkedNode(c, e, node.next);
        }
    }

    public Polynomial add(Polynomial that) {

        Polynomial result = new Polynomial();

        LinkedNode t1 = this.header;
        LinkedNode t2 = that.header;

        while (t1 != null && t2 != null) {
            if (t1.exp == t2.exp) {
                result.addTerm(t1.coef + t2.coef, t1.exp);
                t1 = t1.next;
                t2 = t2.next;
            } else if (t1.exp > t2.exp) {
                result.addTerm(t1.coef, t1.exp);
                t1 = t1.next;
            } else {
                result.addTerm(t2.coef, t2.exp);
                t2 = t2.next;
            }
        }

        while (t1 != null) {
            result.addTerm(t1.coef, t1.exp);
            t1 = t1.next;
        }

        while (t2 != null) {
            result.addTerm(t2.coef, t2.exp);
            t2 = t2.next;
        }

        return result;
    }

    public Polynomial multiply(Polynomial that) {
        Polynomial result = new Polynomial();

        LinkedNode t1 = this.header;

        while (t1 != null) {
            LinkedNode t2 = that.header;

            while (t2 != null) {
                double coeff = t1.coef * t2.coef;
                int exp = t1.exp + t2.exp;
                result.addTerm(coeff, exp);
                t2 = t2.next;
            }
            t1 = t1.next;
        }

        return result;
    }

    @Override
    public String toString() {
        LinkedNode term = header;
        String result = "";

        while (term != null) {
            result += String.format("%.0f", term.coef) + (term.exp > 0 ? "x^" + term.exp : "");
            if (term.next != null) {
                result += " + ";
            }
            term = term.next;
        }

        return result;
    }

    private static class LinkedNode {
        private double coef;
        private int exp;
        private LinkedNode next;

        LinkedNode(double c, int e, LinkedNode n) {
            this.coef = c;
            this.exp = e;
            this.next = n;
        }
    }
}

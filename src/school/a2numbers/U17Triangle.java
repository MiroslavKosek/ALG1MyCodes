package school.a2numbers;

/**
 *
 * @author Miroslav Košek
 */

//Test: in: (-6, -8) (-8, 8) (-9, -6) out: 33,77 22,00
//Test: in: (-7, -4) (-6, 6) (-4, 1) out: 21,27 12,50
public class U17Triangle {
    
    public static void main(String[] args) {
        //input
        double ax = -7;
        double ay = -4;
        double bx = -6;
        double by = 6;
        double cx = -4;
        double cy = 1;

        //processing
        double a = Math.sqrt(Math.pow(bx - cx, 2) + Math.pow(by - cy, 2));
        double b = Math.sqrt(Math.pow(cx - ax, 2) + Math.pow(cy - ay, 2));
        double c = Math.sqrt(Math.pow(ax - bx, 2) + Math.pow(ay - by, 2));

        double s = (a + b + c) / 2;
        double S = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        double O = a + b + c;

        //output
        System.out.format("Strana a: %.2f\nStrana b: %.2f\nStrana c: %.2f\n", a, b, c);
        System.out.format("Obvod: %.2f, Obsah: %.2f\n", O, S);
    }
  
}

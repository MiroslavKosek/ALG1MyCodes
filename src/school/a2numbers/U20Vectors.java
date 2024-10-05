package school.a2numbers;

/**
 *
 * @author Miroslav Košek
 */
public class U20Vectors {
    
    public static void main(String[] args) {
        //input
        double ux = 10;
        double uy = 20;
        double uz = 30;
        double vx = -5;
        double vy = -20;
        double vz = -5;
        
        //processing
        double uLength = Math.sqrt(Math.pow(ux, 2) + Math.pow(uy, 2) + Math.pow(uz, 2));
        double vLength = Math.sqrt(Math.pow(vx, 2) + Math.pow(vy, 2) + Math.pow(vz, 2));
        
        double uv = ux * vx + uy * vy + uz * vz;
        
        double wx = uy * vz - uz * vy;
        double wy = uz * vy - ux * vz;
        double wz = ux * vy - uy * vx;
        
        double Phi = Math.acos(uv / (uLength * vLength));
        
        //output
        System.out.format("Delka vektoru u: %.2f\n", uLength);
        System.out.format("Delka vektoru v: %.2f\n", vLength);
        System.out.format("Skalarni soucin u.v: %.2f\n", uv);
        System.out.format("Vektorovy soucin w: (%.2f, %.2f, %.2f)\n", wx, wy, wz);
        System.out.format("Uhel vektoru Fi v radianech: %.2f\n", Phi);
        System.out.format("Uhel vektoru Fi ve stupnich: %.2f\n", Math.toDegrees(Phi));
    }
    
}

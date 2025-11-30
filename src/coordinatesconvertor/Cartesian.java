package coordinatesconvertor;

public class Cartesian {
    private double x;
    private double y;
    private double z;

    public Cartesian(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }
    public void setZ(double z) {
        this.z = z;
    }

    public Spherical toSpherical(Cartesian c1) {
        double x = c1.getX();
        double y = c1.getY();
        double z = c1.getZ();
        double r = Math.sqrt(x * x + y * y + z * z);
        double theta = Math.toDegrees(Math.acos(z / r));
        double phi = Math.toDegrees(Math.atan2(y, x));
        return new Spherical(r, theta, phi);
    }

    public Cylendrical toCylindrical(Cartesian c1) {
        double x = c1.getX();
        double y = c1.getY();
        double z = c1.getZ();
        double rho = Math.sqrt(x * x + y * y);
        double phi = Math.toDegrees(Math.atan2(y, x));
        return new Cylendrical(rho, phi, z);
    }


}

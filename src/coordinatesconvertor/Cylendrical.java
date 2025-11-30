package coordinatesconvertor;

public class Cylendrical {
    private double rho;
    private double phi;
    private double z;

    public Cylendrical(double rho, double phi, double z) {
        this.rho = rho;
        this.phi = phi;
        this.z = z;
    }

    public double getRho() {
        return rho;
    }
    public void setRho(double rho) {
        this.rho = rho;
    }

    public double getPhi() {
        return phi;
    }
    public void setPhi(double phi) {
        this.phi = phi;
    }

    public double getZ() {
        return z;
    }
    public void setZ(double z) {
        this.z = z;
    }

    public Cartesian toCartesian(Cylendrical cyl1) {
        double rho = cyl1.getRho();
        double phi = cyl1.getPhi();
        double z = cyl1.getZ();
        double x = rho * Math.cos(Math.toRadians(phi));
        double y = rho * Math.sin(Math.toRadians(phi));
        return new Cartesian(x, y, z);
    }

    public Spherical toSpherical(Cylendrical cyl1) {
        double rho = cyl1.getRho();
        double phi = cyl1.getPhi();
        double z = cyl1.getZ();
        double r = Math.sqrt(rho * rho + z * z);
        double theta = Math.toDegrees(Math.acos(z / r));
        return new Spherical(r, theta, phi);
    }


}

package coordinatesconvertor;

public class Spherical {
    private double r;
    private double theta;
    private double phi;

    public Spherical(double r, double theta, double phi) {
        this.r = r;
        this.theta = theta;
        this.phi = phi;
    }

    public double getR() {
        return r;
    }
    public void setR(double r) {
        this.r = r;
    }

    public double getTheta() {
        return theta;
    }
    public void setTheta(double theta) {
        this.theta = theta;
    }

    public double getPhi() {
        return phi;
    }
    public void setPhi(double phi) {
        this.phi = phi;
    }

    public Cartesian toCartesian(Spherical s1) {
        double r = s1.getR();
        double theta = s1.getTheta();
        double phi = s1.getPhi();
        double x = r * Math.sin(Math.toRadians(theta)) * Math.cos(Math.toRadians(phi));
        double y = r * Math.sin(Math.toRadians(theta)) * Math.sin(Math.toRadians(phi));
        double z = r * Math.cos(Math.toRadians(theta));
        return new Cartesian(x, y, z);
    }

    public Cylendrical toCylindrical(Spherical s1) {
        double r = s1.getR();
        double theta = s1.getTheta();
        double phi = s1.getPhi();
        double rho = r * Math.sin(Math.toRadians(theta));
        double z = r * Math.cos(Math.toRadians(theta));
        return new Cylendrical(rho, phi, z);
    }

}

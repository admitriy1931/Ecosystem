

public class PopulationModel {
    private double rP; // коэффициент роста для растений
    private double rA; // коэффициент роста для животных
    private double Kp; // вместимость для растений
    private double Ka; // вместимость для животных

    public PopulationModel(double rP, double rA, double Kp, double Ka) {
        this.rP = rP;
        this.rA = rA;
        this.Kp = Kp;
        this.Ka = Ka;
    }

    private double plantGrowthFactor(double temperature, double humidity, double water) {
        if (temperature > 10 && temperature < 30 && humidity > 50 && water > 20) {
            return 1.0;
        } else if (temperature > 0 && temperature <= 10 || temperature >= 30) {
            return 0.5;
        }
        return 0.0;
    }

}

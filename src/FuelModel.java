import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

import java.io.File;

public class FuelModel {
    private FIS fis;

    public FuelModel(String filePath) {
        File f = new File(filePath);
        if (!f.exists() || !f.isFile()) {
            System.err.println("FCL dosyası bulunamadı: " + filePath);
            System.exit(1);
        }

        fis = FIS.load(filePath, true);
        if (fis == null) {
            System.err.println("FCL dosyası yüklenemedi veya format hatası: " + filePath);
            System.exit(1);
        }
    }

    public double Predict(double gear, double throttle) {
        fis.setVariable("gear", gear);
        fis.setVariable("throttle", throttle);
        fis.evaluate();
        return fis.getVariable("fuel").getValue();
    }

    public void Plot() {
        JFuzzyChart.get().chart(fis);
        JFuzzyChart.get().chart(fis.getVariable("fuel").getDefuzzifier(), "Fuel", true);
    }
}

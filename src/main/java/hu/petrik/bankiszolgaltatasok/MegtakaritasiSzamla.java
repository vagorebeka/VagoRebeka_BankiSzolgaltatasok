package hu.petrik.bankiszolgaltatasok;

public class MegtakaritasiSzamla extends Szamla {
    private double kamat;
    public static double alapKamat = 1.1;

    public double getKamat() {
        return kamat;
    }

    public void setKamat(double kamat) {
        this.kamat = kamat;
    }

    public MegtakaritasiSzamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        this.kamat = alapKamat;
    }

    @Override
    public boolean kivesz(int osszeg) {
        if (getAktualisEgyenleg() >= osszeg) {
            super.aktualisEgyenleg -= osszeg;
            return true;
        }
        else {
            return false;
        }
    }

    public void kamatJovairas() {
        super.aktualisEgyenleg = (int)(getAktualisEgyenleg()*kamat);
    }
}

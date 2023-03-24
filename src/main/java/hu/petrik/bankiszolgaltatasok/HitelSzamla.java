package hu.petrik.bankiszolgaltatasok;

public abstract class HitelSzamla extends Szamla {
    protected int hitelKeret;

    public HitelSzamla(Tulajdonos tulajdonos, int hitelKeret) {
        super(tulajdonos);
        this.hitelKeret = hitelKeret;
    }

    public boolean kivesz(int osszeg) {
        if (hitelKeret + getAktualisEgyenleg() >= osszeg) {
            super.aktualisEgyenleg -= osszeg;
            return true;
        }
        else {
            return false;
        }
    }
}

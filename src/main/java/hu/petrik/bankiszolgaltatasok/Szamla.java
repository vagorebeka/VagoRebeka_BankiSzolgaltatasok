package hu.petrik.bankiszolgaltatasok;

public abstract class Szamla implements BankiSzolgaltatas {

    private Tulajdonos tulajdonos;
    protected int aktualisEgyenleg;

    public Szamla(Tulajdonos tulajdonos) {
        this.tulajdonos = tulajdonos;
    }

    public void befizet(int osszeg) {
        this.aktualisEgyenleg += osszeg;
    }

    public int getAktualisEgyenleg() {
        return aktualisEgyenleg;
    }

    public abstract boolean kivesz(int osszeg);
}

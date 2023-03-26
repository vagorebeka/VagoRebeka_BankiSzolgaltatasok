package hu.petrik.bankiszolgaltatasok;

public class Main {
    public static void main(String[] args) {
        Bank bank1 = new Bank();
        Tulajdonos tulajdonos1 = new Tulajdonos("Kovács Tibor");
        Tulajdonos tulajdonos2 = new Tulajdonos("Szabó Lili");
        Tulajdonos tulajdonos3 = new Tulajdonos("Varga Sándor");


        MegtakaritasiSzamla szamla1 = (MegtakaritasiSzamla) bank1.szamlaNyitas(tulajdonos1, 0);

        szamla1.befizet(10000);

        System.out.println(tulajdonos1.getNev() + " egyenlege: " + szamla1.getAktualisEgyenleg());
    }
}

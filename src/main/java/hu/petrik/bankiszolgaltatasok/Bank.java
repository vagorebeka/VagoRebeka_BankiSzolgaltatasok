package hu.petrik.bankiszolgaltatasok;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    public Szamla szamla;
    private List<Szamla> szamlaLista = new ArrayList<>();

    public Szamla szamlaNyitas(Tulajdonos tulajdonos, int hitelKeret) {
        if (hitelKeret > 0){
            HitelSzamla hitelSzamla = new HitelSzamla(tulajdonos, hitelKeret);
            szamlaLista.add(hitelSzamla);
            return hitelSzamla;
        }
        else if (hitelKeret == 0){
            MegtakaritasiSzamla megtakaritasiSzamla = new MegtakaritasiSzamla(tulajdonos);
            szamlaLista.add(megtakaritasiSzamla);
            return megtakaritasiSzamla;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public int getOsszEgyenleg(Tulajdonos tulajdonos) {
        int osszEgyenleg = 0;
        for (int i = 0; i < szamlaLista.size(); i++){
            if (szamlaLista.get(i).getTulajdonos() == tulajdonos){
                osszEgyenleg += szamlaLista.get(i).getAktualisEgyenleg();
            }
        }
        return osszEgyenleg;
    }

    public Szamla getLegnagyobbEgyenleguSzamla(Tulajdonos tulajdonos) {
        int legnagyobbEgyenleg = 0;
        Szamla legnagyobbEgyenleguSzamla = szamlaLista.get(0);
        for (int i = 0; i < szamlaLista.size(); i++){
            Szamla aktualisSzamla = szamlaLista.get(i);
            if (aktualisSzamla.getTulajdonos() == tulajdonos && aktualisSzamla.getAktualisEgyenleg() > legnagyobbEgyenleg){
                legnagyobbEgyenleguSzamla = aktualisSzamla;
            }
        }
        return legnagyobbEgyenleguSzamla;
    }

    public int getOsszHitelkeret() {
        int osszHitelKeret = 0;
        for (int i = 0; i < szamlaLista.size(); i++) {
            Szamla aktualisSzamla = szamlaLista.get(i);
            if (aktualisSzamla instanceof HitelSzamla) {
                osszHitelKeret += ((HitelSzamla) aktualisSzamla).getHitelKeret();
            }
        }
        return osszHitelKeret;
    }
}

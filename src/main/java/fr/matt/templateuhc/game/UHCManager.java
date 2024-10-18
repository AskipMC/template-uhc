package fr.matt.templateuhc.game;

public class UHCManager {

    private UHC uhc;

    public UHCManager() {

    }

    public UHC getUHC() {
        return this.uhc;
    }

    public boolean hasUHC() {
        return this.uhc != null;
    }

    public void createUHC() {
        this.uhc = new UHC();
    }

    public void deleteUHC() {
        this.uhc = null;
    }

}

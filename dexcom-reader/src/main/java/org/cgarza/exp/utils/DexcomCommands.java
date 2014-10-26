package org.cgarza.exp.utils;

import org.cgarza.exp.dexcom.DexcomConnection;
import org.joda.time.DateTime;

public class DexcomCommands {

    private DexcomConnection con;

    public DexcomCommands(DexcomConnection con) {
        this.con = con;
    }

    public DexcomConnection getCon() {
        return con;
    }

    public void setCon(DexcomConnection con) {
        this.con = con;
    }

    public DateTime getRTC(){
        
        return null;
    }
}

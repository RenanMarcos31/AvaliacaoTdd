package br.com.rsinet.hub_tdd.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generator {

    public static String dateHourPath() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
    }
}

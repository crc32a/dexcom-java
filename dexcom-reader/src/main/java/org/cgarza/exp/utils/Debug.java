package org.cgarza.exp.utils;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Random;

public class Debug {

    private static final String[] binBaseNames = new String[]{"B", "KiB", "MiB", "GiB", "TiB", "PiB", "EiB", "ZiB", "YiB"};
    private static final Random rnd = new Random();

    public static String humanReadableBytes(double val) {
        if (Double.isNaN(val)) {
            return "nan";
        }
        if (Double.isInfinite(val)) {
            return "inf";
        }
        return humanReadableBytes(BigDecimal.valueOf(val).toBigInteger());
    }

    public static String humanReadableBytes(long val) {
        return humanReadableBytes(BigInteger.valueOf(val));
    }

    public static URL getUrlFromJarName(String jarPathIn) throws MalformedURLException {
        String jarFileName = StaticFileUtils.expandUser(jarPathIn);
        File jarFile = new File(jarFileName);
        URL jarURL = new URL("jar", "", "file:" + jarFile.getAbsolutePath() + "!/");
        return jarURL;
    }

    public static String humanReadableBytes(String val) {
        return humanReadableBytes(new BigInteger(val));
    }

    public static String humanReadableBytes(BigInteger val) {
        int bits = val.bitLength();
        int base1024 = bits / 10;
        int lShift = 0;

        String baseName;
        if (base1024 >= 8) {
            lShift = 80;
            baseName = binBaseNames[8];
        } else {
            lShift = base1024 * 10;
            baseName = binBaseNames[base1024];
        }
        double dVal = val.doubleValue() / BigInteger.ONE.shiftLeft(lShift).doubleValue();
        return String.format("%.4f %s", dVal, baseName);
    }

    public static String getExtendedStackTrace(Throwable th) {
        Throwable t;
        StringBuilder sb = new StringBuilder();
        Throwable currThrowable;
        String msg;

        t = th;
        while (t != null) {
            if (t instanceof Throwable) {
                currThrowable = (Throwable) t;
                sb.append(String.format("\"%s\":\"%s\"\n", currThrowable.getClass().getName(), currThrowable.getMessage()));
                for (StackTraceElement se : currThrowable.getStackTrace()) {
                    sb.append(String.format("%s\n", se.toString()));
                }
                sb.append("\nCausing Exception: ");
                t = t.getCause();
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public static String buildRandomString(int nChars, String alphaNum) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < nChars; j++) {
            sb.append(alphaNum.charAt(rnd.nextInt(alphaNum.length())));
        }
        return sb.toString();
    }

    public static String classLoaderInfo(Class<?> cls) {
        ClassLoader cl = cls.getClassLoader();
        int hc = cl.hashCode();
        String cp = findClassPath(cls);
        String loaderName = cl.getClass().getName();
        String info = cl.toString();
        String fmt = "{hash=\"%d\", classLoader=\"%s\", classPath=\"%s\", info=\"%s\"}";
        String out = String.format(fmt, hc, loaderName, cp, info);
        return out;
    }

    public static long nowMillis() {
        return System.currentTimeMillis();
    }

    public static double getEpochSeconds() {
        long millisLong = System.currentTimeMillis();
        double millisDouble = (double) millisLong;
        double seconds = millisDouble * 0.001;
        return seconds;
    }

    public static String findClassPath(Class<?> cls) {
        try {
            String className = cls.getName();
            String mangledName = "/" + className.replace(".", "/") + ".class";
            URL loc = cls.getResource(mangledName);
            String classPath = loc.getPath();
            return classPath;
        } catch (Exception ex) {
            String st = getExtendedStackTrace(ex);
            return st;
        }
    }

    public static String getThreadStacksString() {
        StringBuilder sb = new StringBuilder();
        Map<Thread, StackTraceElement[]> stMap = Thread.getAllStackTraces();
        for (Thread th : stMap.keySet()) {
            StackTraceElement[] seArray = stMap.get(th);
            sb.append("Thread: ").append(th.getName()).append("\n");
            if (seArray == null) {
                sb.append("    No StackTrace\n");
                continue;
            }
            for (int i = 0; i < seArray.length; i++) {
                String se = seArray[i].toString();
                sb.append("    ").append(se).append("\n");
            }
        }
        return sb.toString();
    }

    public static Class getThrowableCausedByOrAssignableFrom(Throwable exc, Class... causeClasses) {
        Throwable t;
        Class causeClass;
        int i;
        int last = causeClasses.length;
        for (i = 0; i < last; i++) {
            causeClass = causeClasses[i];
            t = exc;
            while (t != null) {
                if (causeClass.isAssignableFrom(t.getClass())) {
                    return causeClass;
                }
                t = t.getCause();
            }
        }
        return null;
    }

    public static boolean isThrowableCausedByOrAssignableFrom(Throwable exc, Class... causeClasses) {
        Class throwable = getThrowableCausedByOrAssignableFrom(exc, causeClasses);
        if (throwable == null) {
            return false;
        }
        return true;
    }

    public static int nCpus() {
        return Runtime.getRuntime().availableProcessors();
    }

    public static long freeMem() {
        return Runtime.getRuntime().freeMemory();
    }

    public static long totalMem() {
        return Runtime.getRuntime().totalMemory();
    }

    public static long usedMem() {
        return totalMem() - freeMem();
    }

    public static long maxMem() {
        return Runtime.getRuntime().maxMemory();
    }

    public static void gc() {
        Runtime.getRuntime().gc();
    }

    public static String showMem() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("  MaxMemory: %s\n", StaticStringUtils.lpadLong(maxMem(), " ", 20)));
        sb.append(String.format("TotalMemory: %s\n", StaticStringUtils.lpadLong(totalMem(), " ", 20)));
        sb.append(String.format(" UsedMemory: %s\n", StaticStringUtils.lpadLong(usedMem(), " ", 20)));
        sb.append(String.format(" FreeMemory: %s\n", StaticStringUtils.lpadLong(freeMem(), " ", 20)));
        sb.append(String.format("      nCpus: %s\n", StaticStringUtils.lpadLong(nCpus(), " ", 20)));
        return sb.toString();
    }

    public static int nop(int x) {
        return x + 1;
    }
}

package p007b.p225i.p226a.p288f.p313h.p325l;

import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.i.a.f.h.l.u1 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3848u1 {

    /* JADX INFO: renamed from: f */
    public static HashMap<String, String> f10338f;

    /* JADX INFO: renamed from: k */
    public static Object f10343k;

    /* JADX INFO: renamed from: l */
    public static boolean f10344l;

    /* JADX INFO: renamed from: a */
    public static final Uri f10333a = Uri.parse("content://com.google.android.gsf.gservices");

    /* JADX INFO: renamed from: b */
    public static final Uri f10334b = Uri.parse("content://com.google.android.gsf.gservices/prefix");

    /* JADX INFO: renamed from: c */
    public static final Pattern f10335c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    /* JADX INFO: renamed from: d */
    public static final Pattern f10336d = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* JADX INFO: renamed from: e */
    public static final AtomicBoolean f10337e = new AtomicBoolean();

    /* JADX INFO: renamed from: g */
    public static final HashMap<String, Boolean> f10339g = new HashMap<>();

    /* JADX INFO: renamed from: h */
    public static final HashMap<String, Integer> f10340h = new HashMap<>();

    /* JADX INFO: renamed from: i */
    public static final HashMap<String, Long> f10341i = new HashMap<>();

    /* JADX INFO: renamed from: j */
    public static final HashMap<String, Float> f10342j = new HashMap<>();

    /* JADX INFO: renamed from: m */
    public static String[] f10345m = new String[0];

    /* JADX INFO: renamed from: a */
    public static void m5308a(Object obj, String str, String str2) {
        synchronized (C3848u1.class) {
            if (obj == f10343k) {
                f10338f.put(str, str2);
            }
        }
    }
}

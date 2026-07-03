package p007b.p225i.p226a.p288f.p313h.p326m;

import android.content.ContentResolver;
import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.i.a.f.h.m.p */
/* JADX INFO: loaded from: classes3.dex */
public class C3939p {

    /* JADX INFO: renamed from: f */
    public static HashMap<String, String> f10471f;

    /* JADX INFO: renamed from: k */
    public static Object f10476k;

    /* JADX INFO: renamed from: l */
    public static boolean f10477l;

    /* JADX INFO: renamed from: a */
    public static final Uri f10466a = Uri.parse("content://com.google.android.gsf.gservices");

    /* JADX INFO: renamed from: b */
    public static final Uri f10467b = Uri.parse("content://com.google.android.gsf.gservices/prefix");

    /* JADX INFO: renamed from: c */
    public static final Pattern f10468c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    /* JADX INFO: renamed from: d */
    public static final Pattern f10469d = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* JADX INFO: renamed from: e */
    public static final AtomicBoolean f10470e = new AtomicBoolean();

    /* JADX INFO: renamed from: g */
    public static final HashMap<String, Boolean> f10472g = new HashMap<>();

    /* JADX INFO: renamed from: h */
    public static final HashMap<String, Integer> f10473h = new HashMap<>();

    /* JADX INFO: renamed from: i */
    public static final HashMap<String, Long> f10474i = new HashMap<>();

    /* JADX INFO: renamed from: j */
    public static final HashMap<String, Float> f10475j = new HashMap<>();

    /* JADX INFO: renamed from: m */
    public static String[] f10478m = new String[0];

    /* JADX INFO: renamed from: a */
    public static void m5409a(ContentResolver contentResolver) {
        if (f10471f == null) {
            f10470e.set(false);
            f10471f = new HashMap<>();
            f10476k = new Object();
            f10477l = false;
            contentResolver.registerContentObserver(f10466a, true, new C3940q());
            return;
        }
        if (f10470e.getAndSet(false)) {
            f10471f.clear();
            f10472g.clear();
            f10473h.clear();
            f10474i.clear();
            f10475j.clear();
            f10476k = new Object();
            f10477l = false;
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m5410b(Object obj, String str, String str2) {
        synchronized (C3939p.class) {
            if (obj == f10476k) {
                f10471f.put(str, str2);
            }
        }
    }
}

package b.i.a.f.h.j;

import android.content.Context;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class s0 {
    public static Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b.i.a.f.m.a f1426b;
    public static Boolean c;

    public static boolean a(Context context) {
        Objects.requireNonNull(context, "null reference");
        Boolean bool = c;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zA = z0.a(context, "com.google.android.gms.analytics.AnalyticsReceiver", false);
        c = Boolean.valueOf(zA);
        return zA;
    }
}

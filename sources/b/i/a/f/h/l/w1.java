package b.i.a.f.h.l;

import android.os.Build$VERSION;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class w1 {
    public static volatile boolean a = !a();

    public static boolean a() {
        return Build$VERSION.SDK_INT >= 24;
    }
}

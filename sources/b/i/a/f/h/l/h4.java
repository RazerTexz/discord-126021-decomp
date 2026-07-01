package b.i.a.f.h.l;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class h4 {
    public static volatile h4 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile h4 f1446b;
    public static final h4 c = new h4(true);
    public final Map<h4$a, u4$f<?, ?>> d;

    public h4() {
        this.d = new HashMap();
    }

    public static h4 a() {
        h4 h4Var = a;
        if (h4Var == null) {
            synchronized (h4.class) {
                h4Var = a;
                if (h4Var == null) {
                    h4Var = c;
                    a = h4Var;
                }
            }
        }
        return h4Var;
    }

    public h4(boolean z2) {
        this.d = Collections.emptyMap();
    }
}

package b.i.a.f.h.l;

import b.i.a.f.h.l.u4;
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
    public final Map<a, u4.f<?, ?>> d;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static final class a {
        public final Object a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1447b;

        public a(Object obj, int i) {
            this.a = obj;
            this.f1447b = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.f1447b == aVar.f1447b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.a) * 65535) + this.f1447b;
        }
    }

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

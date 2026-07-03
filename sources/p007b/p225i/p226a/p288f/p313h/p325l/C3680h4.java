package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;

/* JADX INFO: renamed from: b.i.a.f.h.l.h4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3680h4 {

    /* JADX INFO: renamed from: a */
    public static volatile C3680h4 f9984a;

    /* JADX INFO: renamed from: b */
    public static volatile C3680h4 f9985b;

    /* JADX INFO: renamed from: c */
    public static final C3680h4 f9986c = new C3680h4(true);

    /* JADX INFO: renamed from: d */
    public final Map<a, AbstractC3851u4.f<?, ?>> f9987d;

    /* JADX INFO: renamed from: b.i.a.f.h.l.h4$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final Object f9988a;

        /* JADX INFO: renamed from: b */
        public final int f9989b;

        public a(Object obj, int i) {
            this.f9988a = obj;
            this.f9989b = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f9988a == aVar.f9988a && this.f9989b == aVar.f9989b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f9988a) * 65535) + this.f9989b;
        }
    }

    public C3680h4() {
        this.f9987d = new HashMap();
    }

    /* JADX INFO: renamed from: a */
    public static C3680h4 m4933a() {
        C3680h4 c3680h4 = f9984a;
        if (c3680h4 == null) {
            synchronized (C3680h4.class) {
                c3680h4 = f9984a;
                if (c3680h4 == null) {
                    c3680h4 = f9986c;
                    f9984a = c3680h4;
                }
            }
        }
        return c3680h4;
    }

    public C3680h4(boolean z2) {
        this.f9987d = Collections.emptyMap();
    }
}

package b.i.a.f.e.h.j;

import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class g$c {
    public final b<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Feature f1363b;

    public g$c(b bVar, Feature feature, t tVar) {
        this.a = bVar;
        this.f1363b = feature;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj != null && (obj instanceof g$c)) {
            g$c g_c = (g$c) obj;
            if (b.c.a.a0.d.h0(this.a, g_c.a) && b.c.a.a0.d.h0(this.f1363b, g_c.f1363b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.f1363b});
    }

    public final String toString() {
        b.i.a.f.e.k.j jVar = new b.i.a.f.e.k.j(this);
        jVar.a("key", this.a);
        jVar.a("feature", this.f1363b);
        return jVar.toString();
    }
}

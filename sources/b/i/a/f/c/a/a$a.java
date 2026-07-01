package b.i.a.f.c.a;

import androidx.annotation.Nullable;
import b.c.a.a0.d;
import b.i.a.f.e.h.a$d;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class a$a implements a$d {
    public static final a$a j = new a$a(new a$a$a());
    public final String k;
    public final boolean l;

    @Nullable
    public final String m;

    public a$a(a$a$a a_a_a) {
        this.k = a_a_a.a;
        this.l = a_a_a.f1333b.booleanValue();
        this.m = a_a_a.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a$a)) {
            return false;
        }
        a$a a_a = (a$a) obj;
        return d.h0(this.k, a_a.k) && this.l == a_a.l && d.h0(this.m, a_a.m);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.k, Boolean.valueOf(this.l), this.m});
    }
}

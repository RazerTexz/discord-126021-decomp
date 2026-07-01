package b.i.a.c;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: MediaItem.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o1$c {

    @Nullable
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public Uri f1034b;

    @Nullable
    public String c;

    @Nullable
    public String g;

    @Nullable
    public Object i;

    @Nullable
    public p1 j;
    public o1$d$a d = new o1$d$a();
    public o1$f$a e = new o1$f$a(null);
    public List<?> f = Collections.emptyList();
    public b.i.b.b.p<o1$k> h = b.i.b.b.h0.l;
    public o1$g$a k = new o1$g$a();

    public o1 a() {
        o1$i o1_i;
        o1$f$a o1_f_a = this.e;
        b.c.a.a0.d.D(o1_f_a.f1037b == null || o1_f_a.a != null);
        Uri uri = this.f1034b;
        if (uri != null) {
            String str = this.c;
            o1$f$a o1_f_a2 = this.e;
            o1_i = new o1$i(uri, str, o1_f_a2.a != null ? new o1$f(o1_f_a2, null) : null, null, this.f, this.g, this.h, this.i, null);
        } else {
            o1_i = null;
        }
        String str2 = this.a;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str2;
        o1$e o1_eA = this.d.a();
        o1$g$a o1_g_a = this.k;
        Objects.requireNonNull(o1_g_a);
        o1$g o1_g = new o1$g(o1_g_a, null);
        p1 p1Var = this.j;
        if (p1Var == null) {
            p1Var = p1.j;
        }
        return new o1(str3, o1_eA, o1_i, o1_g, p1Var, null);
    }
}

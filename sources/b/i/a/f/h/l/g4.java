package b.i.a.f.h.l;

import com.google.android.gms.internal.measurement.zzhi;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class g4 implements v7 {
    public final zzhi a;

    public g4(zzhi zzhiVar) {
        Charset charset = w4.a;
        this.a = zzhiVar;
        zzhiVar.c = this;
    }

    public final void a(int i, double d) throws IOException {
        zzhi zzhiVar = this.a;
        Objects.requireNonNull(zzhiVar);
        zzhiVar.z(i, Double.doubleToRawLongBits(d));
    }

    public final void b(int i, float f) throws IOException {
        zzhi zzhiVar = this.a;
        Objects.requireNonNull(zzhiVar);
        zzhiVar.G(i, Float.floatToRawIntBits(f));
    }

    public final void c(int i, Object obj) throws IOException {
        if (obj instanceof t3) {
            this.a.t(i, (t3) obj);
        } else {
            this.a.i(i, (c6) obj);
        }
    }

    public final void d(int i, Object obj, q6 q6Var) throws IOException {
        this.a.j(i, (c6) obj, q6Var);
    }

    public final void e(int i, Object obj, q6 q6Var) throws IOException {
        zzhi zzhiVar = this.a;
        zzhiVar.f(i, 3);
        q6Var.g((c6) obj, zzhiVar.c);
        zzhiVar.f(i, 4);
    }

    public final void f(int i, long j) throws IOException {
        this.a.g(i, zzhi.R(j));
    }

    public final void g(int i, int i2) throws IOException {
        this.a.y(i, zzhi.V(i2));
    }
}

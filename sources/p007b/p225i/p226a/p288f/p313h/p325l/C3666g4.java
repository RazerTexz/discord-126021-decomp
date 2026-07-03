package p007b.p225i.p226a.p288f.p313h.p325l;

import com.google.android.gms.internal.measurement.zzhi;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.h.l.g4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3666g4 implements InterfaceC3867v7 {

    /* JADX INFO: renamed from: a */
    public final zzhi f9967a;

    public C3666g4(zzhi zzhiVar) {
        Charset charset = C3877w4.f10379a;
        this.f9967a = zzhiVar;
        zzhiVar.f20630c = this;
    }

    /* JADX INFO: renamed from: a */
    public final void m4909a(int i, double d) throws IOException {
        zzhi zzhiVar = this.f9967a;
        Objects.requireNonNull(zzhiVar);
        zzhiVar.mo9098z(i, Double.doubleToRawLongBits(d));
    }

    /* JADX INFO: renamed from: b */
    public final void m4910b(int i, float f) throws IOException {
        zzhi zzhiVar = this.f9967a;
        Objects.requireNonNull(zzhiVar);
        zzhiVar.mo9082G(i, Float.floatToRawIntBits(f));
    }

    /* JADX INFO: renamed from: c */
    public final void m4911c(int i, Object obj) throws IOException {
        if (obj instanceof AbstractC3837t3) {
            this.f9967a.mo9096t(i, (AbstractC3837t3) obj);
        } else {
            this.f9967a.mo9089i(i, (InterfaceC3612c6) obj);
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m4912d(int i, Object obj, InterfaceC3801q6 interfaceC3801q6) throws IOException {
        this.f9967a.mo9090j(i, (InterfaceC3612c6) obj, interfaceC3801q6);
    }

    /* JADX INFO: renamed from: e */
    public final void m4913e(int i, Object obj, InterfaceC3801q6 interfaceC3801q6) throws IOException {
        zzhi zzhiVar = this.f9967a;
        zzhiVar.mo9086f(i, 3);
        interfaceC3801q6.mo4849g((InterfaceC3612c6) obj, zzhiVar.f20630c);
        zzhiVar.mo9086f(i, 4);
    }

    /* JADX INFO: renamed from: f */
    public final void m4914f(int i, long j) throws IOException {
        this.f9967a.mo9087g(i, zzhi.m9065R(j));
    }

    /* JADX INFO: renamed from: g */
    public final void m4915g(int i, int i2) throws IOException {
        this.f9967a.mo9097y(i, zzhi.m9069V(i2));
    }
}

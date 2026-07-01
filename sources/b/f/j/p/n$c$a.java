package b.f.j.p;

import androidx.core.os.EnvironmentCompat;
import com.facebook.imagepipeline.decoder.DecodeException;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Objects;

/* JADX INFO: compiled from: DecodeProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class n$c$a implements c0$c {
    public final /* synthetic */ x0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f627b;
    public final /* synthetic */ n$c c;

    public n$c$a(n$c n_c, n nVar, x0 x0Var, int i) {
        this.c = n_c;
        this.a = x0Var;
        this.f627b = i;
    }

    @Override // b.f.j.p.c0$c
    public void a(b.f.j.j.e eVar, int i) {
        boolean z2;
        String str;
        long j;
        b.f.j.j.c cVarT;
        int i2 = i;
        if (eVar != null) {
            x0 x0Var = this.c.c;
            eVar.x();
            x0Var.d("image_format", eVar.l.f541b);
            if (this.c.h.f || !b.m(i2, 16)) {
                ImageRequest imageRequestE = this.a.e();
                if (this.c.h.g || !b.f.d.l.b.e(imageRequestE.c)) {
                    eVar.q = b.c.a.a0.d.a0(imageRequestE.k, imageRequestE.j, eVar, this.f627b);
                }
            }
            Objects.requireNonNull(this.a.g().getExperiments());
            n$c n_c = this.c;
            Objects.requireNonNull(n_c);
            eVar.x();
            if (eVar.l == b.f.i.b.a || !b.f(i)) {
                synchronized (n_c) {
                    z2 = n_c.f;
                }
                if (z2 || !b.f.j.j.e.u(eVar)) {
                    return;
                }
                eVar.x();
                b.f.i.c cVar = eVar.l;
                String str2 = cVar != null ? cVar.f541b : EnvironmentCompat.MEDIA_UNKNOWN;
                StringBuilder sb = new StringBuilder();
                eVar.x();
                sb.append(eVar.o);
                sb.append("x");
                eVar.x();
                sb.append(eVar.p);
                String string = sb.toString();
                String strValueOf = String.valueOf(eVar.q);
                boolean zE = b.e(i);
                boolean z3 = zE && !b.m(i2, 8);
                boolean zM = b.m(i2, 4);
                b.f.j.d.e eVar2 = n_c.c.e().j;
                if (eVar2 != null) {
                    str = eVar2.a + "x" + eVar2.f566b;
                } else {
                    str = EnvironmentCompat.MEDIA_UNKNOWN;
                }
                String str3 = str;
                try {
                    c0 c0Var = n_c.g;
                    synchronized (c0Var) {
                        j = c0Var.j - c0Var.i;
                    }
                    String strValueOf2 = String.valueOf(n_c.c.e().c);
                    int iN = (z3 || zM) ? eVar.n() : n_c.o(eVar);
                    b.f.j.j.i iVarP = (z3 || zM) ? b.f.j.j.h.a : n_c.p();
                    n_c.d.e(n_c.c, "DecodeProducer");
                    try {
                        try {
                            cVarT = n_c.t(eVar, iN, iVarP);
                            try {
                                if (eVar.q != 1) {
                                    i2 |= 16;
                                }
                                n_c.d.j(n_c.c, "DecodeProducer", n_c.n(cVarT, j, iVarP, zE, str2, string, str3, strValueOf));
                                n_c.v(eVar, cVarT);
                                n_c.s(cVarT, i2);
                            } catch (Exception e) {
                                e = e;
                                n_c.d.k(n_c.c, "DecodeProducer", e, n_c.n(cVarT, j, iVarP, zE, str2, string, str3, strValueOf));
                                n_c.u(true);
                                n_c.f632b.c(e);
                            }
                        } catch (DecodeException e2) {
                            b.f.j.j.e eVarA = e2.a();
                            b.f.d.e.a.o("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e2.getMessage(), strValueOf2, eVarA.d(10), Integer.valueOf(eVarA.n()));
                            throw e2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        cVarT = null;
                    }
                    eVar.close();
                } catch (Throwable th) {
                    eVar.close();
                    throw th;
                }
            }
        }
    }
}

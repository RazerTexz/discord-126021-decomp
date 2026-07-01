package b.i.a.c.a3;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.upstream.Loader$e;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e0$a implements Loader$e, s$a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f813b;
    public final b.i.a.c.e3.y c;
    public final d0 d;
    public final b.i.a.c.x2.j e;
    public final b.i.a.c.f3.j f;
    public volatile boolean h;
    public long j;

    @Nullable
    public b.i.a.c.x2.w m;
    public boolean n;
    public final /* synthetic */ e0 o;
    public final b.i.a.c.x2.s g = new b.i.a.c.x2.s();
    public boolean i = true;
    public long l = -1;
    public final long a = t.a.getAndIncrement();
    public b.i.a.c.e3.n k = a(0);

    public e0$a(e0 e0Var, Uri uri, b.i.a.c.e3.l lVar, d0 d0Var, b.i.a.c.x2.j jVar, b.i.a.c.f3.j jVar2) {
        this.o = e0Var;
        this.f813b = uri;
        this.c = new b.i.a.c.e3.y(lVar);
        this.d = d0Var;
        this.e = jVar;
        this.f = jVar2;
    }

    public final b.i.a.c.e3.n a(long j) {
        Collections.emptyMap();
        Uri uri = this.f813b;
        String str = this.o.t;
        Map<String, String> map = e0.j;
        if (uri != null) {
            return new b.i.a.c.e3.n(uri, 0L, 1, null, map, j, -1L, str, 6, null);
        }
        throw new IllegalStateException("The uri must be set.");
    }

    public void b() throws IOException {
        b.i.a.c.e3.h sVar;
        int i;
        int iE = 0;
        while (iE == 0 && !this.h) {
            try {
                long j = this.g.a;
                b.i.a.c.e3.n nVarA = a(j);
                this.k = nVarA;
                long jA = this.c.a(nVarA);
                this.l = jA;
                if (jA != -1) {
                    this.l = jA + j;
                }
                this.o.C = IcyHeaders.a(this.c.j());
                b.i.a.c.e3.y yVar = this.c;
                IcyHeaders icyHeaders = this.o.C;
                if (icyHeaders == null || (i = icyHeaders.o) == -1) {
                    sVar = yVar;
                } else {
                    sVar = new s(yVar, i, this);
                    b.i.a.c.x2.w wVarB = this.o.B(new e0$d(0, true));
                    this.m = wVarB;
                    ((h0) wVarB).e(e0.k);
                }
                long jA2 = j;
                ((m) this.d).b(sVar, this.f813b, this.c.j(), j, this.l, this.e);
                if (this.o.C != null) {
                    b.i.a.c.x2.h hVar = ((m) this.d).f828b;
                    if (hVar instanceof b.i.a.c.x2.h0.f) {
                        ((b.i.a.c.x2.h0.f) hVar).f1206s = true;
                    }
                }
                if (this.i) {
                    d0 d0Var = this.d;
                    long j2 = this.j;
                    b.i.a.c.x2.h hVar2 = ((m) d0Var).f828b;
                    Objects.requireNonNull(hVar2);
                    hVar2.g(jA2, j2);
                    this.i = false;
                }
                while (true) {
                    long j3 = jA2;
                    while (true) {
                        if (iE != 0 || this.h) {
                            break;
                        }
                        try {
                            b.i.a.c.f3.j jVar = this.f;
                            synchronized (jVar) {
                                while (!jVar.f971b) {
                                    try {
                                        jVar.wait();
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            }
                            d0 d0Var2 = this.d;
                            b.i.a.c.x2.s sVar2 = this.g;
                            m mVar = (m) d0Var2;
                            b.i.a.c.x2.h hVar3 = mVar.f828b;
                            Objects.requireNonNull(hVar3);
                            b.i.a.c.x2.i iVar = mVar.c;
                            Objects.requireNonNull(iVar);
                            iE = hVar3.e(iVar, sVar2);
                            jA2 = ((m) this.d).a();
                            if (jA2 > this.o.u + j3) {
                                this.f.a();
                                e0 e0Var = this.o;
                                e0Var.A.post(e0Var.f812z);
                            }
                        } catch (InterruptedException unused) {
                            throw new InterruptedIOException();
                        }
                    }
                }
                if (iE == 1) {
                    iE = 0;
                } else if (((m) this.d).a() != -1) {
                    this.g.a = ((m) this.d).a();
                }
                b.i.a.c.e3.y yVar2 = this.c;
                if (yVar2 != null) {
                    try {
                        yVar2.a.close();
                    } catch (IOException unused2) {
                    }
                }
            } catch (Throwable th2) {
                if (iE != 1 && ((m) this.d).a() != -1) {
                    this.g.a = ((m) this.d).a();
                }
                b.i.a.c.e3.y yVar3 = this.c;
                if (yVar3 != null) {
                    try {
                        yVar3.a.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th2;
            }
        }
    }
}

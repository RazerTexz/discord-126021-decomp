package b.f.j.e;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Build$VERSION;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b.f.j.c.w;
import b.f.j.p.b1;
import b.f.j.p.d0;
import b.f.j.p.e0;
import b.f.j.p.f0;
import b.f.j.p.f1;
import b.f.j.p.g1;
import b.f.j.p.h0;
import b.f.j.p.i0;
import b.f.j.p.i1;
import b.f.j.p.j0;
import b.f.j.p.j1;
import b.f.j.p.k0;
import b.f.j.p.k1;
import b.f.j.p.n0;
import b.f.j.p.o0;
import b.f.j.p.r0;
import b.f.j.p.s;
import b.f.j.p.s0;
import b.f.j.p.t;
import b.f.j.p.t0;
import b.f.j.p.u;
import b.f.j.p.v;
import b.f.j.p.w0;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.producers.LocalExifThumbnailProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: ProducerSequenceFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class q {
    public final ContentResolver a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f583b;
    public final o0 c;
    public final boolean d;
    public final boolean e;
    public final g1 f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final b.f.j.s.c j;
    public final boolean k;
    public final boolean l;
    public final boolean m;

    @Nullable
    @VisibleForTesting
    public w0<CloseableReference<b.f.j.j.c>> n;

    @Nullable
    public w0<b.f.j.j.e> o;

    @Nullable
    @VisibleForTesting
    public w0<CloseableReference<b.f.j.j.c>> p;

    @Nullable
    @VisibleForTesting
    public w0<CloseableReference<b.f.j.j.c>> q;

    @Nullable
    @VisibleForTesting
    public w0<CloseableReference<b.f.j.j.c>> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    @VisibleForTesting
    public w0<CloseableReference<b.f.j.j.c>> f584s;

    @Nullable
    @VisibleForTesting
    public w0<CloseableReference<b.f.j.j.c>> t;

    @Nullable
    @VisibleForTesting
    public w0<CloseableReference<b.f.j.j.c>> u;

    @Nullable
    @VisibleForTesting
    public w0<CloseableReference<b.f.j.j.c>> v;

    @Nullable
    @VisibleForTesting
    public w0<CloseableReference<b.f.j.j.c>> w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @VisibleForTesting
    public Map<w0<CloseableReference<b.f.j.j.c>>, w0<CloseableReference<b.f.j.j.c>>> f585x = new HashMap();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @VisibleForTesting
    public Map<w0<CloseableReference<b.f.j.j.c>>, w0<CloseableReference<b.f.j.j.c>>> f586y;

    public q(ContentResolver contentResolver, p pVar, o0 o0Var, boolean z2, boolean z3, g1 g1Var, boolean z4, boolean z5, boolean z6, boolean z7, b.f.j.s.c cVar, boolean z8, boolean z9, boolean z10) {
        this.a = contentResolver;
        this.f583b = pVar;
        this.c = o0Var;
        this.d = z2;
        new HashMap();
        this.f586y = new HashMap();
        this.f = g1Var;
        this.g = z4;
        this.h = z5;
        this.e = z6;
        this.i = z7;
        this.j = cVar;
        this.k = z8;
        this.l = z9;
        this.m = z10;
    }

    public final synchronized w0<b.f.j.j.e> a() {
        b.f.j.r.b.b();
        if (this.o == null) {
            b.f.j.r.b.b();
            p pVar = this.f583b;
            b.f.j.p.a aVar = new b.f.j.p.a(m(new n0(pVar.k, pVar.d, this.c)));
            this.o = aVar;
            this.o = this.f583b.a(aVar, this.d && !this.g, this.j);
            b.f.j.r.b.b();
        }
        b.f.j.r.b.b();
        return this.o;
    }

    public final synchronized w0<CloseableReference<b.f.j.j.c>> b() {
        if (this.u == null) {
            b.f.j.p.m mVar = new b.f.j.p.m(this.f583b.k);
            b.f.d.m.b bVar = b.f.d.m.c.a;
            this.u = j(this.f583b.a(new b.f.j.p.a(mVar), true, this.j));
        }
        return this.u;
    }

    public w0<CloseableReference<b.f.j.j.c>> c(ImageRequest imageRequest) {
        w0<CloseableReference<b.f.j.j.c>> w0VarG;
        b.f.j.p.o oVar;
        b.f.j.r.b.b();
        try {
            b.f.j.r.b.b();
            Objects.requireNonNull(imageRequest);
            Uri uri = imageRequest.c;
            b.c.a.a0.d.y(uri, "Uri is null.");
            int i = imageRequest.d;
            if (i != 0) {
                boolean z2 = false;
                switch (i) {
                    case 2:
                        w0VarG = g();
                        break;
                    case 3:
                        synchronized (this) {
                            if (this.p == null) {
                                p pVar = this.f583b;
                                this.p = k(new h0(pVar.j.e(), pVar.k));
                            }
                            w0VarG = this.p;
                        }
                        break;
                    case 4:
                        if (imageRequest.h && Build$VERSION.SDK_INT >= 29) {
                            synchronized (this) {
                                if (this.v == null) {
                                    p pVar2 = this.f583b;
                                    this.v = i(new j0(pVar2.j.c(), pVar2.a));
                                }
                                w0VarG = this.v;
                            }
                        } else {
                            String type = this.a.getType(uri);
                            Map<String, String> map = b.f.d.f.a.a;
                            if (type != null && type.startsWith("video/")) {
                                z2 = true;
                            }
                            w0VarG = !z2 ? e() : g();
                        }
                        break;
                    case 5:
                        w0VarG = d();
                        break;
                    case 6:
                        w0VarG = f();
                        break;
                    case 7:
                        w0VarG = b();
                        break;
                    case 8:
                        w0VarG = h();
                        break;
                    default:
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unsupported uri scheme! Uri is: ");
                        String strValueOf = String.valueOf(uri);
                        if (strValueOf.length() > 30) {
                            strValueOf = strValueOf.substring(0, 30) + "...";
                        }
                        sb.append(strValueOf);
                        throw new IllegalArgumentException(sb.toString());
                }
            } else {
                synchronized (this) {
                    b.f.j.r.b.b();
                    if (this.n == null) {
                        b.f.j.r.b.b();
                        this.n = j(a());
                        b.f.j.r.b.b();
                    }
                    b.f.j.r.b.b();
                    w0VarG = this.n;
                }
            }
            b.f.j.r.b.b();
            if (imageRequest.f2903s != null) {
                synchronized (this) {
                    w0<CloseableReference<b.f.j.j.c>> w0Var = this.f585x.get(w0VarG);
                    if (w0Var == null) {
                        p pVar3 = this.f583b;
                        t0 t0Var = new t0(w0VarG, pVar3.f580s, pVar3.j.c());
                        p pVar4 = this.f583b;
                        s0 s0Var = new s0(pVar4.o, pVar4.p, t0Var);
                        this.f585x.put(w0VarG, s0Var);
                        w0VarG = s0Var;
                    } else {
                        w0VarG = w0Var;
                    }
                }
            }
            if (this.h) {
                synchronized (this) {
                    w0<CloseableReference<b.f.j.j.c>> w0Var2 = this.f586y.get(w0VarG);
                    if (w0Var2 == null) {
                        p pVar5 = this.f583b;
                        b.f.j.p.i iVar = new b.f.j.p.i(w0VarG, pVar5.t, pVar5.u, pVar5.v);
                        this.f586y.put(w0VarG, iVar);
                        w0VarG = iVar;
                    } else {
                        w0VarG = w0Var2;
                    }
                }
            }
            if (this.m && imageRequest.u > 0) {
                synchronized (this) {
                    oVar = new b.f.j.p.o(w0VarG, this.f583b.j.g());
                }
                w0VarG = oVar;
            }
            b.f.j.r.b.b();
            return w0VarG;
        } catch (Throwable th) {
            b.f.j.r.b.b();
            throw th;
        }
    }

    public final synchronized w0<CloseableReference<b.f.j.j.c>> d() {
        if (this.t == null) {
            p pVar = this.f583b;
            this.t = k(new d0(pVar.j.e(), pVar.k, pVar.c));
        }
        return this.t;
    }

    public final synchronized w0<CloseableReference<b.f.j.j.c>> e() {
        if (this.r == null) {
            p pVar = this.f583b;
            e0 e0Var = new e0(pVar.j.e(), pVar.k, pVar.a);
            p pVar2 = this.f583b;
            Objects.requireNonNull(pVar2);
            p pVar3 = this.f583b;
            this.r = l(e0Var, new k1[]{new f0(pVar2.j.e(), pVar2.k, pVar2.a), new LocalExifThumbnailProducer(pVar3.j.f(), pVar3.k, pVar3.a)});
        }
        return this.r;
    }

    public final synchronized w0<CloseableReference<b.f.j.j.c>> f() {
        if (this.f584s == null) {
            p pVar = this.f583b;
            this.f584s = k(new i0(pVar.j.e(), pVar.k, pVar.f579b));
        }
        return this.f584s;
    }

    public final synchronized w0<CloseableReference<b.f.j.j.c>> g() {
        if (this.q == null) {
            p pVar = this.f583b;
            this.q = i(new k0(pVar.j.e(), pVar.a));
        }
        return this.q;
    }

    public final synchronized w0<CloseableReference<b.f.j.j.c>> h() {
        if (this.w == null) {
            p pVar = this.f583b;
            this.w = k(new b1(pVar.j.e(), pVar.k, pVar.a));
        }
        return this.w;
    }

    public final w0<CloseableReference<b.f.j.j.c>> i(w0<CloseableReference<b.f.j.j.c>> w0Var) {
        p pVar = this.f583b;
        w<CacheKey, b.f.j.j.c> wVar = pVar.o;
        b.f.j.c.i iVar = pVar.p;
        b.f.j.p.g gVar = new b.f.j.p.g(iVar, new b.f.j.p.h(wVar, iVar, w0Var));
        p pVar2 = this.f583b;
        g1 g1Var = this.f;
        Objects.requireNonNull(pVar2);
        f1 f1Var = new f1(gVar, g1Var);
        if (!this.k && !this.l) {
            p pVar3 = this.f583b;
            return new b.f.j.p.f(pVar3.o, pVar3.p, f1Var);
        }
        p pVar4 = this.f583b;
        w<CacheKey, b.f.j.j.c> wVar2 = pVar4.o;
        b.f.j.c.i iVar2 = pVar4.p;
        return new b.f.j.p.j(pVar4.n, pVar4.l, pVar4.m, iVar2, pVar4.q, pVar4.r, new b.f.j.p.f(wVar2, iVar2, f1Var));
    }

    public final w0<CloseableReference<b.f.j.j.c>> j(w0<b.f.j.j.e> w0Var) {
        b.f.j.r.b.b();
        p pVar = this.f583b;
        w0<CloseableReference<b.f.j.j.c>> w0VarI = i(new b.f.j.p.n(pVar.d, pVar.j.a(), pVar.e, pVar.f, pVar.g, pVar.h, pVar.i, w0Var, pVar.f581x, pVar.w, null, b.f.d.d.l.a));
        b.f.j.r.b.b();
        return w0VarI;
    }

    public final w0<CloseableReference<b.f.j.j.c>> k(w0<b.f.j.j.e> w0Var) {
        p pVar = this.f583b;
        return l(w0Var, new k1[]{new LocalExifThumbnailProducer(pVar.j.f(), pVar.k, pVar.a)});
    }

    public final w0<CloseableReference<b.f.j.j.c>> l(w0<b.f.j.j.e> w0Var, k1<b.f.j.j.e>[] k1VarArr) {
        i1 i1Var = new i1(5, this.f583b.j.b(), this.f583b.a(new b.f.j.p.a(m(w0Var)), true, this.j));
        Objects.requireNonNull(this.f583b);
        return j(new b.f.j.p.k(this.f583b.a(new j1(k1VarArr), true, this.j), i1Var));
    }

    public final w0<b.f.j.j.e> m(w0<b.f.j.j.e> w0Var) {
        t tVar;
        b.f.d.m.b bVar = b.f.d.m.c.a;
        if (this.i) {
            b.f.j.r.b.b();
            if (this.e) {
                p pVar = this.f583b;
                b.f.j.c.f fVar = pVar.l;
                b.f.j.c.i iVar = pVar.p;
                tVar = new t(fVar, pVar.m, iVar, new r0(fVar, iVar, pVar.k, pVar.d, w0Var));
            } else {
                p pVar2 = this.f583b;
                tVar = new t(pVar2.l, pVar2.m, pVar2.p, w0Var);
            }
            p pVar3 = this.f583b;
            s sVar = new s(pVar3.l, pVar3.m, pVar3.p, tVar);
            b.f.j.r.b.b();
            w0Var = sVar;
        }
        p pVar4 = this.f583b;
        w<CacheKey, PooledByteBuffer> wVar = pVar4.n;
        b.f.j.c.i iVar2 = pVar4.p;
        v vVar = new v(wVar, iVar2, w0Var);
        if (!this.l) {
            return new u(iVar2, pVar4.f582y, vVar);
        }
        return new u(iVar2, pVar4.f582y, new b.f.j.p.w(pVar4.l, pVar4.m, iVar2, pVar4.q, pVar4.r, vVar));
    }
}

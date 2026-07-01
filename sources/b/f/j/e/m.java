package b.f.j.e;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build$VERSION;
import androidx.core.util.Pools$SynchronizedPool;
import b.f.j.c.m$b;
import b.f.j.c.r;
import b.f.j.c.s;
import b.f.j.c.t;
import b.f.j.c.v;
import b.f.j.c.w;
import b.f.j.c.w$a;
import b.f.j.c.y;
import b.f.j.c.z;
import b.f.j.l.x;
import b.f.j.p.g1;
import b.f.j.p.h1;
import b.f.j.p.o0;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: ImagePipelineFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class m {
    public static m a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g1 f577b;
    public final k c;
    public final a d;
    public b.f.j.c.m<CacheKey, b.f.j.j.c> e;
    public s<CacheKey, b.f.j.j.c> f;
    public b.f.j.c.m<CacheKey, PooledByteBuffer> g;
    public s<CacheKey, PooledByteBuffer> h;
    public b.f.j.c.f i;
    public b.f.b.b.h j;
    public b.f.j.h.b k;
    public h l;
    public b.f.j.s.c m;
    public p n;
    public q o;
    public b.f.j.c.f p;
    public b.f.b.b.h q;
    public PlatformBitmapFactory r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public b.f.j.n.d f578s;
    public b.f.j.a.b.a t;

    public m(k kVar) {
        b.f.j.r.b.b();
        Objects.requireNonNull(kVar);
        this.c = kVar;
        Objects.requireNonNull(kVar.getExperiments());
        this.f577b = new h1(kVar.D().b());
        Objects.requireNonNull(kVar.getExperiments());
        CloseableReference.k = 0;
        this.d = new a(kVar.f());
        b.f.j.r.b.b();
    }

    public static synchronized void j(k kVar) {
        if (a != null) {
            b.f.d.e.a.k(m.class, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
        }
        a = new m(kVar);
    }

    public final h a() {
        b.f.j.h.b bVarC;
        b.f.j.h.b bVarB;
        if (Build$VERSION.SDK_INT >= 24) {
            Objects.requireNonNull(this.c.getExperiments());
        }
        if (this.o == null) {
            ContentResolver contentResolver = this.c.getContext().getApplicationContext().getContentResolver();
            if (this.n == null) {
                l$d l_d = this.c.getExperiments().f575b;
                Context context = this.c.getContext();
                b.f.d.g.a aVarE = this.c.a().e();
                if (this.k == null) {
                    if (this.c.B() != null) {
                        this.k = this.c.B();
                    } else {
                        b.f.j.a.b.a aVarB = b();
                        if (aVarB != null) {
                            bVarB = aVarB.b();
                            bVarC = aVarB.c();
                        } else {
                            bVarC = null;
                            bVarB = null;
                        }
                        if (this.c.x() != null) {
                            h();
                            Objects.requireNonNull(this.c.x());
                            throw null;
                        }
                        this.k = new b.f.j.h.a(bVarB, bVarC, h());
                    }
                }
                b.f.j.h.b bVar = this.k;
                b.f.j.h.d dVarO = this.c.o();
                boolean zS = this.c.s();
                boolean zM = this.c.m();
                Objects.requireNonNull(this.c.getExperiments());
                e eVarD = this.c.D();
                b.f.d.g.g gVarC = this.c.a().c(this.c.c());
                this.c.a().d();
                s<CacheKey, b.f.j.j.c> sVarD = d();
                s<CacheKey, PooledByteBuffer> sVarE = e();
                b.f.j.c.f fVarF = f();
                b.f.j.c.f fVarI = i();
                b.f.j.c.i iVarL = this.c.l();
                PlatformBitmapFactory platformBitmapFactoryG = g();
                Objects.requireNonNull(this.c.getExperiments());
                Objects.requireNonNull(this.c.getExperiments());
                Objects.requireNonNull(this.c.getExperiments());
                int i = this.c.getExperiments().a;
                a aVar = this.d;
                Objects.requireNonNull(this.c.getExperiments());
                int i2 = this.c.getExperiments().g;
                Objects.requireNonNull((l$c) l_d);
                this.n = new p(context, aVarE, bVar, dVarO, zS, zM, false, eVarD, gVarC, sVarD, sVarE, fVarF, fVarI, iVarL, platformBitmapFactoryG, 0, 0, false, i, aVar, false, i2);
            }
            p pVar = this.n;
            o0 o0VarH = this.c.h();
            boolean zM2 = this.c.m();
            Objects.requireNonNull(this.c.getExperiments());
            g1 g1Var = this.f577b;
            boolean zS2 = this.c.s();
            Objects.requireNonNull(this.c.getExperiments());
            boolean zY = this.c.y();
            if (this.m == null) {
                if (this.c.v() == null && this.c.u() == null) {
                    Objects.requireNonNull(this.c.getExperiments());
                }
                int i3 = this.c.getExperiments().a;
                Objects.requireNonNull(this.c.getExperiments());
                this.m = new b.f.j.s.e(i3, false, this.c.v(), this.c.u(), this.c.getExperiments().f);
            }
            b.f.j.s.c cVar = this.m;
            Objects.requireNonNull(this.c.getExperiments());
            Objects.requireNonNull(this.c.getExperiments());
            Objects.requireNonNull(this.c.getExperiments());
            this.o = new q(contentResolver, pVar, o0VarH, zM2, false, g1Var, zS2, false, false, zY, cVar, false, false, false);
        }
        q qVar = this.o;
        Set<b.f.j.k.e> setK = this.c.k();
        Set<b.f.j.k.d> setB = this.c.b();
        Supplier<Boolean> supplierD = this.c.d();
        s<CacheKey, b.f.j.j.c> sVarD2 = d();
        s<CacheKey, PooledByteBuffer> sVarE2 = e();
        b.f.j.c.f fVarF2 = f();
        b.f.j.c.f fVarI2 = i();
        b.f.j.c.i iVarL2 = this.c.l();
        g1 g1Var2 = this.f577b;
        Supplier<Boolean> supplier = this.c.getExperiments().d;
        Objects.requireNonNull(this.c.getExperiments());
        return new h(qVar, setK, setB, supplierD, sVarD2, sVarE2, fVarF2, fVarI2, iVarL2, g1Var2, supplier, null, this.c.z(), this.c);
    }

    public final b.f.j.a.b.a b() {
        if (this.t == null) {
            PlatformBitmapFactory platformBitmapFactoryG = g();
            e eVarD = this.c.D();
            b.f.j.c.m<CacheKey, b.f.j.j.c> mVarC = c();
            boolean z2 = this.c.getExperiments().c;
            b.f.d.b.f fVarT = this.c.t();
            if (!b.f.j.a.b.b.a) {
                try {
                    b.f.j.a.b.b.f546b = (b.f.j.a.b.a) Class.forName("com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl").getConstructor(PlatformBitmapFactory.class, e.class, b.f.j.c.m.class, Boolean.TYPE, b.f.d.b.f.class).newInstance(platformBitmapFactoryG, eVarD, mVarC, Boolean.valueOf(z2), fVarT);
                } catch (Throwable unused) {
                }
                if (b.f.j.a.b.b.f546b != null) {
                    b.f.j.a.b.b.a = true;
                }
            }
            this.t = b.f.j.a.b.b.f546b;
        }
        return this.t;
    }

    public b.f.j.c.m<CacheKey, b.f.j.j.c> c() {
        if (this.e == null) {
            b.f.j.c.a aVarG = this.c.g();
            Supplier<MemoryCacheParams> supplierA = this.c.A();
            b.f.d.g.c cVarW = this.c.w();
            w$a w_aN = this.c.n();
            Objects.requireNonNull(this.c.getExperiments());
            Objects.requireNonNull(this.c.getExperiments());
            m$b<CacheKey> m_bR = this.c.r();
            b.f.j.c.k kVar = (b.f.j.c.k) aVarG;
            Objects.requireNonNull(kVar);
            v vVar = new v(new b.f.j.c.j(kVar), w_aN, supplierA, m_bR, false, false);
            cVarW.a(vVar);
            this.e = vVar;
        }
        return this.e;
    }

    public s<CacheKey, b.f.j.j.c> d() {
        if (this.f == null) {
            b.f.j.c.m<CacheKey, b.f.j.j.c> mVarC = c();
            r rVarQ = this.c.q();
            Objects.requireNonNull((z) rVarQ);
            this.f = new s<>(mVarC, new t(rVarQ));
        }
        return this.f;
    }

    public s<CacheKey, PooledByteBuffer> e() {
        w<CacheKey, PooledByteBuffer> wVarI;
        if (this.h == null) {
            if (this.c.i() != null) {
                wVarI = this.c.i();
            } else {
                if (this.g == null) {
                    Supplier<MemoryCacheParams> supplierC = this.c.C();
                    b.f.d.g.c cVarW = this.c.w();
                    v vVar = new v(new b.f.j.c.p(), new y(), supplierC, null, false, false);
                    cVarW.a(vVar);
                    this.g = vVar;
                }
                wVarI = this.g;
            }
            r rVarQ = this.c.q();
            Objects.requireNonNull((z) rVarQ);
            this.h = new s<>(wVarI, new b.f.j.c.q(rVarQ));
        }
        return this.h;
    }

    public b.f.j.c.f f() {
        if (this.i == null) {
            if (this.j == null) {
                this.j = ((c) this.c.e()).a(this.c.j());
            }
            this.i = new b.f.j.c.f(this.j, this.c.a().c(this.c.c()), this.c.a().d(), this.c.D().e(), this.c.D().d(), this.c.q());
        }
        return this.i;
    }

    public PlatformBitmapFactory g() {
        if (this.r == null) {
            x xVarA = this.c.a();
            h();
            this.r = new b.f.j.b.a(xVarA.a(), this.d);
        }
        return this.r;
    }

    public b.f.j.n.d h() {
        b.f.j.n.d aVar;
        if (this.f578s == null) {
            x xVarA = this.c.a();
            Objects.requireNonNull(this.c.getExperiments());
            if (Build$VERSION.SDK_INT >= 26) {
                int iB = xVarA.b();
                aVar = new b.f.j.n.c(xVarA.a(), iB, new Pools$SynchronizedPool(iB));
            } else {
                int iB2 = xVarA.b();
                aVar = new b.f.j.n.a(xVarA.a(), iB2, new Pools$SynchronizedPool(iB2));
            }
            this.f578s = aVar;
        }
        return this.f578s;
    }

    public final b.f.j.c.f i() {
        if (this.p == null) {
            if (this.q == null) {
                this.q = ((c) this.c.e()).a(this.c.p());
            }
            this.p = new b.f.j.c.f(this.q, this.c.a().c(this.c.c()), this.c.a().d(), this.c.D().e(), this.c.D().d(), this.c.q());
        }
        return this.p;
    }
}

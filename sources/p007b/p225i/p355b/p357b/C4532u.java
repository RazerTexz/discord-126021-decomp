package p007b.p225i.p355b.p357b;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p356a.AbstractC4484d;
import p007b.p225i.p355b.p356a.C4487g;

/* JADX INFO: renamed from: b.i.b.b.u */
/* JADX INFO: compiled from: MapMaker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4532u {

    /* JADX INFO: renamed from: a */
    public boolean f12064a;

    /* JADX INFO: renamed from: b */
    public int f12065b = -1;

    /* JADX INFO: renamed from: c */
    public int f12066c = -1;

    /* JADX INFO: renamed from: d */
    @MonotonicNonNullDecl
    public ConcurrentMapC4533v.p f12067d;

    /* JADX INFO: renamed from: e */
    @MonotonicNonNullDecl
    public ConcurrentMapC4533v.p f12068e;

    /* JADX INFO: renamed from: f */
    @MonotonicNonNullDecl
    public AbstractC4484d<Object> f12069f;

    /* JADX INFO: renamed from: a */
    public ConcurrentMapC4533v.p m6284a() {
        return (ConcurrentMapC4533v.p) C3404f.m4255W(this.f12067d, ConcurrentMapC4533v.p.f12099j);
    }

    /* JADX INFO: renamed from: b */
    public ConcurrentMapC4533v.p m6285b() {
        return (ConcurrentMapC4533v.p) C3404f.m4255W(this.f12068e, ConcurrentMapC4533v.p.f12099j);
    }

    /* JADX INFO: renamed from: c */
    public <K, V> ConcurrentMap<K, V> m6286c() {
        if (!this.f12064a) {
            int i = this.f12065b;
            if (i == -1) {
                i = 16;
            }
            int i2 = this.f12066c;
            if (i2 == -1) {
                i2 = 4;
            }
            return new ConcurrentHashMap(i, 0.75f, i2);
        }
        ConcurrentMapC4533v.b0<Object, Object, ConcurrentMapC4533v.e> b0Var = ConcurrentMapC4533v.f12070j;
        ConcurrentMapC4533v.p pVar = ConcurrentMapC4533v.p.f12100k;
        ConcurrentMapC4533v.p pVarM6284a = m6284a();
        ConcurrentMapC4533v.p pVar2 = ConcurrentMapC4533v.p.f12099j;
        if (pVarM6284a == pVar2 && m6285b() == pVar2) {
            return new ConcurrentMapC4533v(this, ConcurrentMapC4533v.q.a.f12103a);
        }
        if (m6284a() == pVar2 && m6285b() == pVar) {
            return new ConcurrentMapC4533v(this, ConcurrentMapC4533v.s.a.f12105a);
        }
        if (m6284a() == pVar && m6285b() == pVar2) {
            return new ConcurrentMapC4533v(this, ConcurrentMapC4533v.w.a.f12108a);
        }
        if (m6284a() == pVar && m6285b() == pVar) {
            return new ConcurrentMapC4533v(this, ConcurrentMapC4533v.y.a.f12110a);
        }
        throw new AssertionError();
    }

    /* JADX INFO: renamed from: d */
    public C4532u m6287d(ConcurrentMapC4533v.p pVar) {
        ConcurrentMapC4533v.p pVar2 = this.f12067d;
        C3404f.m4207G(pVar2 == null, "Key strength was already set to %s", pVar2);
        Objects.requireNonNull(pVar);
        this.f12067d = pVar;
        if (pVar != ConcurrentMapC4533v.p.f12099j) {
            this.f12064a = true;
        }
        return this;
    }

    public String toString() {
        C4487g c4487g = new C4487g(C4532u.class.getSimpleName(), null);
        int i = this.f12065b;
        if (i != -1) {
            c4487g.m6214a("initialCapacity", i);
        }
        int i2 = this.f12066c;
        if (i2 != -1) {
            c4487g.m6214a("concurrencyLevel", i2);
        }
        ConcurrentMapC4533v.p pVar = this.f12067d;
        if (pVar != null) {
            String strM4349u1 = C3404f.m4349u1(pVar.toString());
            C4487g.a aVar = new C4487g.a(null);
            c4487g.f11952c.f11955c = aVar;
            c4487g.f11952c = aVar;
            aVar.f11954b = strM4349u1;
            aVar.f11953a = "keyStrength";
        }
        ConcurrentMapC4533v.p pVar2 = this.f12068e;
        if (pVar2 != null) {
            String strM4349u2 = C3404f.m4349u1(pVar2.toString());
            C4487g.a aVar2 = new C4487g.a(null);
            c4487g.f11952c.f11955c = aVar2;
            c4487g.f11952c = aVar2;
            aVar2.f11954b = strM4349u2;
            aVar2.f11953a = "valueStrength";
        }
        if (this.f12069f != null) {
            C4487g.a aVar3 = new C4487g.a(null);
            c4487g.f11952c.f11955c = aVar3;
            c4487g.f11952c = aVar3;
            aVar3.f11954b = "keyEquivalence";
        }
        return c4487g.toString();
    }
}

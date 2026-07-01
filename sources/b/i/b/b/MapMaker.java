package b.i.b.b;

import b.i.b.a.Equivalence;
import b.i.b.a.MoreObjects2;
import b.i.b.b.MapMakerInternalMap;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* JADX INFO: renamed from: b.i.b.b.u, reason: use source file name */
/* JADX INFO: compiled from: MapMaker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MapMaker {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1649b = -1;
    public int c = -1;

    @MonotonicNonNullDecl
    public MapMakerInternalMap.p d;

    @MonotonicNonNullDecl
    public MapMakerInternalMap.p e;

    @MonotonicNonNullDecl
    public Equivalence<Object> f;

    public MapMakerInternalMap.p a() {
        return (MapMakerInternalMap.p) b.i.a.f.e.o.f.W(this.d, MapMakerInternalMap.p.j);
    }

    public MapMakerInternalMap.p b() {
        return (MapMakerInternalMap.p) b.i.a.f.e.o.f.W(this.e, MapMakerInternalMap.p.j);
    }

    public <K, V> ConcurrentMap<K, V> c() {
        if (!this.a) {
            int i = this.f1649b;
            if (i == -1) {
                i = 16;
            }
            int i2 = this.c;
            if (i2 == -1) {
                i2 = 4;
            }
            return new ConcurrentHashMap(i, 0.75f, i2);
        }
        MapMakerInternalMap.b0<Object, Object, MapMakerInternalMap.e> b0Var = MapMakerInternalMap.j;
        MapMakerInternalMap.p pVar = MapMakerInternalMap.p.k;
        MapMakerInternalMap.p pVarA = a();
        MapMakerInternalMap.p pVar2 = MapMakerInternalMap.p.j;
        if (pVarA == pVar2 && b() == pVar2) {
            return new MapMakerInternalMap(this, MapMakerInternalMap.q.a.a);
        }
        if (a() == pVar2 && b() == pVar) {
            return new MapMakerInternalMap(this, MapMakerInternalMap.s.a.a);
        }
        if (a() == pVar && b() == pVar2) {
            return new MapMakerInternalMap(this, MapMakerInternalMap.w.a.a);
        }
        if (a() == pVar && b() == pVar) {
            return new MapMakerInternalMap(this, MapMakerInternalMap.y.a.a);
        }
        throw new AssertionError();
    }

    public MapMaker d(MapMakerInternalMap.p pVar) {
        MapMakerInternalMap.p pVar2 = this.d;
        b.i.a.f.e.o.f.G(pVar2 == null, "Key strength was already set to %s", pVar2);
        Objects.requireNonNull(pVar);
        this.d = pVar;
        if (pVar != MapMakerInternalMap.p.j) {
            this.a = true;
        }
        return this;
    }

    public String toString() {
        MoreObjects2 moreObjects2 = new MoreObjects2(MapMaker.class.getSimpleName(), null);
        int i = this.f1649b;
        if (i != -1) {
            moreObjects2.a("initialCapacity", i);
        }
        int i2 = this.c;
        if (i2 != -1) {
            moreObjects2.a("concurrencyLevel", i2);
        }
        MapMakerInternalMap.p pVar = this.d;
        if (pVar != null) {
            String strU1 = b.i.a.f.e.o.f.u1(pVar.toString());
            MoreObjects2.a aVar = new MoreObjects2.a(null);
            moreObjects2.c.c = aVar;
            moreObjects2.c = aVar;
            aVar.f1644b = strU1;
            aVar.a = "keyStrength";
        }
        MapMakerInternalMap.p pVar2 = this.e;
        if (pVar2 != null) {
            String strU2 = b.i.a.f.e.o.f.u1(pVar2.toString());
            MoreObjects2.a aVar2 = new MoreObjects2.a(null);
            moreObjects2.c.c = aVar2;
            moreObjects2.c = aVar2;
            aVar2.f1644b = strU2;
            aVar2.a = "valueStrength";
        }
        if (this.f != null) {
            MoreObjects2.a aVar3 = new MoreObjects2.a(null);
            moreObjects2.c.c = aVar3;
            moreObjects2.c = aVar3;
            aVar3.f1644b = "keyEquivalence";
        }
        return moreObjects2.toString();
    }
}

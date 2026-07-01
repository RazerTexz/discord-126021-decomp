package d0.e0.p.d.m0.l.b.e0;

import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.x0$a;
import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.f.s;
import d0.e0.p.d.m0.f.s$c;
import d0.e0.p.d.m0.l.b.w;
import d0.e0.p.d.m0.l.b.z;
import d0.e0.p.d.m0.m.o;
import d0.e0.p.d.m0.n.c0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DeserializedTypeParameterDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends d0.e0.p.d.m0.c.i1.b {
    public final d0.e0.p.d.m0.l.b.l t;
    public final s u;
    public final a v;

    /* JADX WARN: Illegal instructions before constructor call */
    public m(d0.e0.p.d.m0.l.b.l lVar, s sVar, int i) {
        d0.z.d.m.checkNotNullParameter(lVar, "c");
        d0.z.d.m.checkNotNullParameter(sVar, "proto");
        o storageManager = lVar.getStorageManager();
        d0.e0.p.d.m0.c.m containingDeclaration = lVar.getContainingDeclaration();
        d0.e0.p.d.m0.g.e name = w.getName(lVar.getNameResolver(), sVar.getName());
        z zVar = z.a;
        s$c variance = sVar.getVariance();
        d0.z.d.m.checkNotNullExpressionValue(variance, "proto.variance");
        super(storageManager, containingDeclaration, name, zVar.variance(variance), sVar.getReified(), i, u0.a, x0$a.a);
        this.t = lVar;
        this.u = sVar;
        this.v = new a(lVar.getStorageManager(), new m$a(this));
    }

    public static final /* synthetic */ d0.e0.p.d.m0.l.b.l access$getC$p(m mVar) {
        return mVar.t;
    }

    @Override // d0.e0.p.d.m0.c.i1.f
    public void c(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "type");
        throw new IllegalStateException(d0.z.d.m.stringPlus("There should be no cycles for deserialized type parameters, but found for: ", this));
    }

    @Override // d0.e0.p.d.m0.c.i1.f
    public List<c0> d() {
        List<q> listUpperBounds = d0.e0.p.d.m0.f.z.f.upperBounds(this.u, this.t.getTypeTable());
        if (listUpperBounds.isEmpty()) {
            return d0.t.m.listOf(d0.e0.p.d.m0.k.x.a.getBuiltIns(this).getDefaultBound());
        }
        d0.e0.p.d.m0.l.b.c0 typeDeserializer = this.t.getTypeDeserializer();
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listUpperBounds, 10));
        Iterator<T> it = listUpperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(typeDeserializer.type((q) it.next()));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.c.g1.b, d0.e0.p.d.m0.c.g1.a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.g1.g getAnnotations() {
        return getAnnotations();
    }

    public final s getProto() {
        return this.u;
    }

    @Override // d0.e0.p.d.m0.c.g1.b, d0.e0.p.d.m0.c.g1.a
    public a getAnnotations() {
        return this.v;
    }
}

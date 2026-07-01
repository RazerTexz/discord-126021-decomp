package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.d0;
import d0.e0.p.d.m0.f.b$b$c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AnnotationAndConstantLoaderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements c<d0.e0.p.d.m0.c.g1.c, d0.e0.p.d.m0.k.v.g<?>> {
    public final d0.e0.p.d.m0.l.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f3484b;

    public d(d0.e0.p.d.m0.c.c0 c0Var, d0 d0Var, d0.e0.p.d.m0.l.a aVar) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        d0.z.d.m.checkNotNullParameter(d0Var, "notFoundClasses");
        d0.z.d.m.checkNotNullParameter(aVar, "protocol");
        this.a = aVar;
        this.f3484b = new e(c0Var, d0Var);
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<d0.e0.p.d.m0.c.g1.c> loadCallableAnnotations(y yVar, d0.e0.p.d.m0.i.n nVar, b bVar) {
        List listEmptyList;
        d0.z.d.m.checkNotNullParameter(yVar, "container");
        d0.z.d.m.checkNotNullParameter(nVar, "proto");
        d0.z.d.m.checkNotNullParameter(bVar, "kind");
        if (nVar instanceof d0.e0.p.d.m0.f.d) {
            listEmptyList = (List) ((d0.e0.p.d.m0.f.d) nVar).getExtension(this.a.getConstructorAnnotation());
        } else if (nVar instanceof d0.e0.p.d.m0.f.i) {
            listEmptyList = (List) ((d0.e0.p.d.m0.f.i) nVar).getExtension(this.a.getFunctionAnnotation());
        } else {
            if (!(nVar instanceof d0.e0.p.d.m0.f.n)) {
                throw new IllegalStateException(d0.z.d.m.stringPlus("Unknown message: ", nVar).toString());
            }
            int iOrdinal = bVar.ordinal();
            if (iOrdinal == 1) {
                listEmptyList = (List) ((d0.e0.p.d.m0.f.n) nVar).getExtension(this.a.getPropertyAnnotation());
            } else if (iOrdinal == 2) {
                listEmptyList = (List) ((d0.e0.p.d.m0.f.n) nVar).getExtension(this.a.getPropertyGetterAnnotation());
            } else {
                if (iOrdinal != 3) {
                    throw new IllegalStateException("Unsupported callable kind with property proto".toString());
                }
                listEmptyList = (List) ((d0.e0.p.d.m0.f.n) nVar).getExtension(this.a.getPropertySetterAnnotation());
            }
        }
        if (listEmptyList == null) {
            listEmptyList = d0.t.n.emptyList();
        }
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f3484b.deserializeAnnotation((d0.e0.p.d.m0.f.b) it.next(), yVar.getNameResolver()));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<d0.e0.p.d.m0.c.g1.c> loadClassAnnotations(y$a y_a) {
        d0.z.d.m.checkNotNullParameter(y_a, "container");
        List listEmptyList = (List) y_a.getClassProto().getExtension(this.a.getClassAnnotation());
        if (listEmptyList == null) {
            listEmptyList = d0.t.n.emptyList();
        }
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f3484b.deserializeAnnotation((d0.e0.p.d.m0.f.b) it.next(), y_a.getNameResolver()));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<d0.e0.p.d.m0.c.g1.c> loadEnumEntryAnnotations(y yVar, d0.e0.p.d.m0.f.g gVar) {
        d0.z.d.m.checkNotNullParameter(yVar, "container");
        d0.z.d.m.checkNotNullParameter(gVar, "proto");
        List listEmptyList = (List) gVar.getExtension(this.a.getEnumEntryAnnotation());
        if (listEmptyList == null) {
            listEmptyList = d0.t.n.emptyList();
        }
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f3484b.deserializeAnnotation((d0.e0.p.d.m0.f.b) it.next(), yVar.getNameResolver()));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<d0.e0.p.d.m0.c.g1.c> loadExtensionReceiverParameterAnnotations(y yVar, d0.e0.p.d.m0.i.n nVar, b bVar) {
        d0.z.d.m.checkNotNullParameter(yVar, "container");
        d0.z.d.m.checkNotNullParameter(nVar, "proto");
        d0.z.d.m.checkNotNullParameter(bVar, "kind");
        return d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<d0.e0.p.d.m0.c.g1.c> loadPropertyBackingFieldAnnotations(y yVar, d0.e0.p.d.m0.f.n nVar) {
        d0.z.d.m.checkNotNullParameter(yVar, "container");
        d0.z.d.m.checkNotNullParameter(nVar, "proto");
        return d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.k.v.g<?> loadPropertyConstant(y yVar, d0.e0.p.d.m0.f.n nVar, d0.e0.p.d.m0.n.c0 c0Var) {
        return loadPropertyConstant(yVar, nVar, c0Var);
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<d0.e0.p.d.m0.c.g1.c> loadPropertyDelegateFieldAnnotations(y yVar, d0.e0.p.d.m0.f.n nVar) {
        d0.z.d.m.checkNotNullParameter(yVar, "container");
        d0.z.d.m.checkNotNullParameter(nVar, "proto");
        return d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<d0.e0.p.d.m0.c.g1.c> loadTypeAnnotations(d0.e0.p.d.m0.f.q qVar, d0.e0.p.d.m0.f.z.c cVar) {
        d0.z.d.m.checkNotNullParameter(qVar, "proto");
        d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
        List listEmptyList = (List) qVar.getExtension(this.a.getTypeAnnotation());
        if (listEmptyList == null) {
            listEmptyList = d0.t.n.emptyList();
        }
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f3484b.deserializeAnnotation((d0.e0.p.d.m0.f.b) it.next(), cVar));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<d0.e0.p.d.m0.c.g1.c> loadTypeParameterAnnotations(d0.e0.p.d.m0.f.s sVar, d0.e0.p.d.m0.f.z.c cVar) {
        d0.z.d.m.checkNotNullParameter(sVar, "proto");
        d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
        List listEmptyList = (List) sVar.getExtension(this.a.getTypeParameterAnnotation());
        if (listEmptyList == null) {
            listEmptyList = d0.t.n.emptyList();
        }
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f3484b.deserializeAnnotation((d0.e0.p.d.m0.f.b) it.next(), cVar));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<d0.e0.p.d.m0.c.g1.c> loadValueParameterAnnotations(y yVar, d0.e0.p.d.m0.i.n nVar, b bVar, int i, d0.e0.p.d.m0.f.u uVar) {
        d0.z.d.m.checkNotNullParameter(yVar, "container");
        d0.z.d.m.checkNotNullParameter(nVar, "callableProto");
        d0.z.d.m.checkNotNullParameter(bVar, "kind");
        d0.z.d.m.checkNotNullParameter(uVar, "proto");
        List listEmptyList = (List) uVar.getExtension(this.a.getParameterAnnotation());
        if (listEmptyList == null) {
            listEmptyList = d0.t.n.emptyList();
        }
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f3484b.deserializeAnnotation((d0.e0.p.d.m0.f.b) it.next(), yVar.getNameResolver()));
        }
        return arrayList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d0.e0.p.d.m0.l.b.c
    public d0.e0.p.d.m0.k.v.g<?> loadPropertyConstant(y yVar, d0.e0.p.d.m0.f.n nVar, d0.e0.p.d.m0.n.c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(yVar, "container");
        d0.z.d.m.checkNotNullParameter(nVar, "proto");
        d0.z.d.m.checkNotNullParameter(c0Var, "expectedType");
        b$b$c b_b_c = (b$b$c) d0.e0.p.d.m0.f.z.e.getExtensionOrNull(nVar, this.a.getCompileTimeValue());
        if (b_b_c == null) {
            return null;
        }
        return this.f3484b.resolveValue(c0Var, b_b_c, yVar.getNameResolver());
    }
}

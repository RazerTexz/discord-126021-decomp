package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11328d0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11677b;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11679d;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11682g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11694s;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11696u;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11706e;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.C11843a;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AbstractC11889y;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.d */
/* JADX INFO: compiled from: AnnotationAndConstantLoaderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11850d implements InterfaceC11848c<InterfaceC11340c, AbstractC11815g<?>> {

    /* JADX INFO: renamed from: a */
    public final C11843a f24513a;

    /* JADX INFO: renamed from: b */
    public final C11855e f24514b;

    public C11850d(InterfaceC11325c0 interfaceC11325c0, C11328d0 c11328d0, C11843a c11843a) {
        C12238m.checkNotNullParameter(interfaceC11325c0, "module");
        C12238m.checkNotNullParameter(c11328d0, "notFoundClasses");
        C12238m.checkNotNullParameter(c11843a, "protocol");
        this.f24513a = c11843a;
        this.f24514b = new C11855e(interfaceC11325c0, c11328d0);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11848c
    public List<InterfaceC11340c> loadCallableAnnotations(AbstractC11889y abstractC11889y, InterfaceC11734n interfaceC11734n, EnumC11846b enumC11846b) {
        List listEmptyList;
        C12238m.checkNotNullParameter(abstractC11889y, "container");
        C12238m.checkNotNullParameter(interfaceC11734n, "proto");
        C12238m.checkNotNullParameter(enumC11846b, "kind");
        if (interfaceC11734n instanceof C11679d) {
            listEmptyList = (List) ((C11679d) interfaceC11734n).getExtension(this.f24513a.getConstructorAnnotation());
        } else if (interfaceC11734n instanceof C11684i) {
            listEmptyList = (List) ((C11684i) interfaceC11734n).getExtension(this.f24513a.getFunctionAnnotation());
        } else {
            if (!(interfaceC11734n instanceof C11689n)) {
                throw new IllegalStateException(C12238m.stringPlus("Unknown message: ", interfaceC11734n).toString());
            }
            int iOrdinal = enumC11846b.ordinal();
            if (iOrdinal == 1) {
                listEmptyList = (List) ((C11689n) interfaceC11734n).getExtension(this.f24513a.getPropertyAnnotation());
            } else if (iOrdinal == 2) {
                listEmptyList = (List) ((C11689n) interfaceC11734n).getExtension(this.f24513a.getPropertyGetterAnnotation());
            } else {
                if (iOrdinal != 3) {
                    throw new IllegalStateException("Unsupported callable kind with property proto".toString());
                }
                listEmptyList = (List) ((C11689n) interfaceC11734n).getExtension(this.f24513a.getPropertySetterAnnotation());
            }
        }
        if (listEmptyList == null) {
            listEmptyList = C12147n.emptyList();
        }
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f24514b.deserializeAnnotation((C11677b) it.next(), abstractC11889y.getNameResolver()));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11848c
    public List<InterfaceC11340c> loadClassAnnotations(AbstractC11889y.a aVar) {
        C12238m.checkNotNullParameter(aVar, "container");
        List listEmptyList = (List) aVar.getClassProto().getExtension(this.f24513a.getClassAnnotation());
        if (listEmptyList == null) {
            listEmptyList = C12147n.emptyList();
        }
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f24514b.deserializeAnnotation((C11677b) it.next(), aVar.getNameResolver()));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11848c
    public List<InterfaceC11340c> loadEnumEntryAnnotations(AbstractC11889y abstractC11889y, C11682g c11682g) {
        C12238m.checkNotNullParameter(abstractC11889y, "container");
        C12238m.checkNotNullParameter(c11682g, "proto");
        List listEmptyList = (List) c11682g.getExtension(this.f24513a.getEnumEntryAnnotation());
        if (listEmptyList == null) {
            listEmptyList = C12147n.emptyList();
        }
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f24514b.deserializeAnnotation((C11677b) it.next(), abstractC11889y.getNameResolver()));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11848c
    public List<InterfaceC11340c> loadExtensionReceiverParameterAnnotations(AbstractC11889y abstractC11889y, InterfaceC11734n interfaceC11734n, EnumC11846b enumC11846b) {
        C12238m.checkNotNullParameter(abstractC11889y, "container");
        C12238m.checkNotNullParameter(interfaceC11734n, "proto");
        C12238m.checkNotNullParameter(enumC11846b, "kind");
        return C12147n.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11848c
    public List<InterfaceC11340c> loadPropertyBackingFieldAnnotations(AbstractC11889y abstractC11889y, C11689n c11689n) {
        C12238m.checkNotNullParameter(abstractC11889y, "container");
        C12238m.checkNotNullParameter(c11689n, "proto");
        return C12147n.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11848c
    public List<InterfaceC11340c> loadPropertyDelegateFieldAnnotations(AbstractC11889y abstractC11889y, C11689n c11689n) {
        C12238m.checkNotNullParameter(abstractC11889y, "container");
        C12238m.checkNotNullParameter(c11689n, "proto");
        return C12147n.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11848c
    public List<InterfaceC11340c> loadTypeAnnotations(C11692q c11692q, InterfaceC11704c interfaceC11704c) {
        C12238m.checkNotNullParameter(c11692q, "proto");
        C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
        List listEmptyList = (List) c11692q.getExtension(this.f24513a.getTypeAnnotation());
        if (listEmptyList == null) {
            listEmptyList = C12147n.emptyList();
        }
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f24514b.deserializeAnnotation((C11677b) it.next(), interfaceC11704c));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11848c
    public List<InterfaceC11340c> loadTypeParameterAnnotations(C11694s c11694s, InterfaceC11704c interfaceC11704c) {
        C12238m.checkNotNullParameter(c11694s, "proto");
        C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
        List listEmptyList = (List) c11694s.getExtension(this.f24513a.getTypeParameterAnnotation());
        if (listEmptyList == null) {
            listEmptyList = C12147n.emptyList();
        }
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f24514b.deserializeAnnotation((C11677b) it.next(), interfaceC11704c));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11848c
    public List<InterfaceC11340c> loadValueParameterAnnotations(AbstractC11889y abstractC11889y, InterfaceC11734n interfaceC11734n, EnumC11846b enumC11846b, int i, C11696u c11696u) {
        C12238m.checkNotNullParameter(abstractC11889y, "container");
        C12238m.checkNotNullParameter(interfaceC11734n, "callableProto");
        C12238m.checkNotNullParameter(enumC11846b, "kind");
        C12238m.checkNotNullParameter(c11696u, "proto");
        List listEmptyList = (List) c11696u.getExtension(this.f24513a.getParameterAnnotation());
        if (listEmptyList == null) {
            listEmptyList = C12147n.emptyList();
        }
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f24514b.deserializeAnnotation((C11677b) it.next(), abstractC11889y.getNameResolver()));
        }
        return arrayList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11848c
    public AbstractC11815g<?> loadPropertyConstant(AbstractC11889y abstractC11889y, C11689n c11689n, AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11889y, "container");
        C12238m.checkNotNullParameter(c11689n, "proto");
        C12238m.checkNotNullParameter(abstractC11913c0, "expectedType");
        C11677b.b.c cVar = (C11677b.b.c) C11706e.getExtensionOrNull(c11689n, this.f24513a.getCompileTimeValue());
        if (cVar == null) {
            return null;
        }
        return this.f24514b.resolveValue(abstractC11913c0, cVar, abstractC11889y.getNameResolver());
    }
}

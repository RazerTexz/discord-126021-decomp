package d0.e0.p.d.m0.l.b.e0;

import d0.e0.p.d.m0.c.d0$b;
import d0.e0.p.d.m0.c.x0;
import d0.e0.p.d.m0.c.x0$a;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.l.b.p;
import d0.e0.p.d.m0.n.c0;
import d0.t.o;
import d0.t.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$b extends d0.e0.p.d.m0.n.b {
    public final d0.e0.p.d.m0.m.j<List<z0>> c;
    public final /* synthetic */ d d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$b(d dVar) {
        super(dVar.getC().getStorageManager());
        d0.z.d.m.checkNotNullParameter(dVar, "this$0");
        this.d = dVar;
        this.c = dVar.getC().getStorageManager().createLazyValue(new d$b$a(dVar));
    }

    @Override // d0.e0.p.d.m0.n.g
    public Collection<c0> a() {
        d0.e0.p.d.m0.g.b bVarAsSingleFqName;
        List<q> listSupertypes = d0.e0.p.d.m0.f.z.f.supertypes(this.d.getClassProto(), this.d.getC().getTypeTable());
        d dVar = this.d;
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listSupertypes, 10));
        Iterator<T> it = listSupertypes.iterator();
        while (it.hasNext()) {
            arrayList.add(dVar.getC().getTypeDeserializer().type((q) it.next()));
        }
        List listPlus = u.plus((Collection) arrayList, (Iterable) this.d.getC().getComponents().getAdditionalClassPartsProvider().getSupertypes(this.d));
        ArrayList<d0$b> arrayList2 = new ArrayList();
        Iterator it2 = listPlus.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            d0.e0.p.d.m0.c.h declarationDescriptor = ((c0) it2.next()).getConstructor().getDeclarationDescriptor();
            d0$b d0_b = declarationDescriptor instanceof d0$b ? (d0$b) declarationDescriptor : null;
            if (d0_b != null) {
                arrayList2.add(d0_b);
            }
        }
        if (!arrayList2.isEmpty()) {
            p errorReporter = this.d.getC().getComponents().getErrorReporter();
            d dVar2 = this.d;
            ArrayList arrayList3 = new ArrayList(o.collectionSizeOrDefault(arrayList2, 10));
            for (d0$b d0_b2 : arrayList2) {
                d0.e0.p.d.m0.g.a classId = d0.e0.p.d.m0.k.x.a.getClassId(d0_b2);
                String strAsString = (classId == null || (bVarAsSingleFqName = classId.asSingleFqName()) == null) ? null : bVarAsSingleFqName.asString();
                if (strAsString == null) {
                    strAsString = d0_b2.getName().asString();
                }
                arrayList3.add(strAsString);
            }
            errorReporter.reportIncompleteHierarchy(dVar2, arrayList3);
        }
        return u.toList(listPlus);
    }

    @Override // d0.e0.p.d.m0.n.g
    public x0 d() {
        return x0$a.a;
    }

    @Override // d0.e0.p.d.m0.n.b, d0.e0.p.d.m0.n.g, d0.e0.p.d.m0.n.u0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.e getDeclarationDescriptor() {
        return getDeclarationDescriptor();
    }

    @Override // d0.e0.p.d.m0.n.u0
    public List<z0> getParameters() {
        return this.c.invoke();
    }

    @Override // d0.e0.p.d.m0.n.u0
    public boolean isDenotable() {
        return true;
    }

    public String toString() {
        String string = this.d.getName().toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "name.toString()");
        return string;
    }

    @Override // d0.e0.p.d.m0.n.g, d0.e0.p.d.m0.n.u0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.h getDeclarationDescriptor() {
        return getDeclarationDescriptor();
    }

    @Override // d0.e0.p.d.m0.n.b, d0.e0.p.d.m0.n.g, d0.e0.p.d.m0.n.u0
    public d getDeclarationDescriptor() {
        return this.d;
    }
}

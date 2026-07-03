package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11363b;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.EnumC11508k;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.C11526d;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.C11529g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m.C11557e;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11577j;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11592y;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11916d0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.s */
/* JADX INFO: compiled from: LazyJavaTypeParameterDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11552s extends AbstractC11363b {

    /* JADX INFO: renamed from: t */
    public final C11529g f23418t;

    /* JADX INFO: renamed from: u */
    public final InterfaceC11592y f23419u;

    /* JADX INFO: renamed from: v */
    public final C11526d f23420v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11552s(C11529g c11529g, InterfaceC11592y interfaceC11592y, int i, InterfaceC11450m interfaceC11450m) {
        super(c11529g.getStorageManager(), interfaceC11450m, interfaceC11592y.getName(), EnumC11935j1.INVARIANT, false, i, InterfaceC11467u0.f23099a, c11529g.getComponents().getSupertypeLoopChecker());
        C12238m.checkNotNullParameter(c11529g, "c");
        C12238m.checkNotNullParameter(interfaceC11592y, "javaTypeParameter");
        C12238m.checkNotNullParameter(interfaceC11450m, "containingDeclaration");
        this.f23418t = c11529g;
        this.f23419u = interfaceC11592y;
        this.f23420v = new C11526d(c11529g, interfaceC11592y, false, 4, null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11371f
    /* JADX INFO: renamed from: b */
    public List<AbstractC11913c0> mo9399b(List<? extends AbstractC11913c0> list) {
        C12238m.checkNotNullParameter(list, "bounds");
        return this.f23418t.getComponents().getSignatureEnhancement().enhanceTypeParameterBounds(this, list, this.f23418t);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11371f
    /* JADX INFO: renamed from: c */
    public void mo9400c(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "type");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11371f
    /* JADX INFO: renamed from: d */
    public List<AbstractC11913c0> mo9401d() {
        Collection<InterfaceC11577j> upperBounds = this.f23419u.getUpperBounds();
        if (upperBounds.isEmpty()) {
            C11916d0 c11916d0 = C11916d0.f24748a;
            AbstractC11934j0 anyType = this.f23418t.getModule().getBuiltIns().getAnyType();
            C12238m.checkNotNullExpressionValue(anyType, "c.module.builtIns.anyType");
            AbstractC11934j0 nullableAnyType = this.f23418t.getModule().getBuiltIns().getNullableAnyType();
            C12238m.checkNotNullExpressionValue(nullableAnyType, "c.module.builtIns.nullableAnyType");
            return C12145m.listOf(C11916d0.flexibleType(anyType, nullableAnyType));
        }
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(upperBounds, 10));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f23418t.getTypeResolver().transformJavaType((InterfaceC11577j) it.next(), C11557e.toAttributes$default(EnumC11508k.COMMON, false, this, 1, null)));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.C11339b, p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11338a
    public C11526d getAnnotations() {
        return this.f23420v;
    }
}

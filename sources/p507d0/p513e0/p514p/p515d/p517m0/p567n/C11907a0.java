package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.C11776o;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11978g;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.a0 */
/* JADX INFO: compiled from: IntersectionTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11907a0 implements InterfaceC12008u0, InterfaceC11978g {

    /* JADX INFO: renamed from: a */
    public AbstractC11913c0 f24739a;

    /* JADX INFO: renamed from: b */
    public final LinkedHashSet<AbstractC11913c0> f24740b;

    /* JADX INFO: renamed from: c */
    public final int f24741c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.a0$a */
    /* JADX INFO: compiled from: IntersectionTypeConstructor.kt */
    public static final class a extends AbstractC12240o implements Function1<AbstractC11947g, AbstractC11934j0> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final AbstractC11934j0 invoke(AbstractC11947g abstractC11947g) {
            C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
            return C11907a0.this.refine(abstractC11947g).createType();
        }
    }

    public C11907a0(Collection<? extends AbstractC11913c0> collection) {
        C12238m.checkNotNullParameter(collection, "typesToIntersect");
        collection.isEmpty();
        LinkedHashSet<AbstractC11913c0> linkedHashSet = new LinkedHashSet<>(collection);
        this.f24740b = linkedHashSet;
        this.f24741c = linkedHashSet.hashCode();
    }

    public final InterfaceC11770i createScopeForKotlinType() {
        return C11776o.f24381b.create("member scope for intersection type", this.f24740b);
    }

    public final AbstractC11934j0 createType() {
        C11916d0 c11916d0 = C11916d0.f24748a;
        return C11916d0.simpleTypeWithNonTrivialMemberScope(InterfaceC11344g.f22735f.getEMPTY(), this, C12147n.emptyList(), false, createScopeForKotlinType(), new a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C11907a0) {
            return C12238m.areEqual(this.f24740b, ((C11907a0) obj).f24740b);
        }
        return false;
    }

    public final AbstractC11913c0 getAlternativeType() {
        return this.f24739a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public AbstractC11288h getBuiltIns() {
        AbstractC11288h builtIns = this.f24740b.iterator().next().getConstructor().getBuiltIns();
        C12238m.checkNotNullExpressionValue(builtIns, "intersectedTypes.iterator().next().constructor.builtIns");
        return builtIns;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public InterfaceC11352h getDeclarationDescriptor() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public List<InterfaceC11477z0> getParameters() {
        return C12147n.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public Collection<AbstractC11913c0> getSupertypes() {
        return this.f24740b;
    }

    public int hashCode() {
        return this.f24741c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public boolean isDenotable() {
        return false;
    }

    public final C11907a0 setAlternative(AbstractC11913c0 abstractC11913c0) {
        C11907a0 c11907a0 = new C11907a0(this.f24740b);
        c11907a0.f24739a = abstractC11913c0;
        return c11907a0;
    }

    public String toString() {
        return C12163u.joinToString$default(C12163u.sortedWith(this.f24740b, new C11910b0()), " & ", "{", "}", 0, null, null, 56, null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public C11907a0 refine(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        Collection<AbstractC11913c0> supertypes = getSupertypes();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(supertypes, 10));
        Iterator<T> it = supertypes.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            arrayList.add(((AbstractC11913c0) it.next()).refine(abstractC11947g));
            z2 = true;
        }
        C11907a0 alternative = null;
        if (z2) {
            AbstractC11913c0 alternativeType = getAlternativeType();
            alternative = new C11907a0(arrayList).setAlternative(alternativeType != null ? alternativeType.refine(abstractC11947g) : null);
        }
        return alternative == null ? this : alternative;
    }
}

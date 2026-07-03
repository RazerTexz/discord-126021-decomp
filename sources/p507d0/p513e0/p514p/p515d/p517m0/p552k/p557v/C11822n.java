package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11908a1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11916d0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12016y0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.n */
/* JADX INFO: compiled from: IntegerLiteralTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11822n implements InterfaceC12008u0 {

    /* JADX INFO: renamed from: a */
    public static final a f24444a = new a(null);

    /* JADX INFO: renamed from: b */
    public final long f24445b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC11325c0 f24446c;

    /* JADX INFO: renamed from: d */
    public final Set<AbstractC11913c0> f24447d;

    /* JADX INFO: renamed from: e */
    public final AbstractC11934j0 f24448e;

    /* JADX INFO: renamed from: f */
    public final Lazy f24449f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.n$a */
    /* JADX INFO: compiled from: IntegerLiteralTypeConstructor.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v14, types: [d0.e0.p.d.m0.n.j0] */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6, types: [d0.e0.p.d.m0.n.c0, d0.e0.p.d.m0.n.j0, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r1v1 */
        public final AbstractC11934j0 findIntersectionType(Collection<? extends AbstractC11934j0> collection) {
            C12238m.checkNotNullParameter(collection, "types");
            if (collection.isEmpty()) {
                return null;
            }
            Iterator it = collection.iterator();
            if (!it.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            ?? next = it.next();
            while (it.hasNext()) {
                AbstractC11934j0 abstractC11934j0 = (AbstractC11934j0) it.next();
                next = (AbstractC11934j0) next;
                if (next != 0 && abstractC11934j0 != null) {
                    InterfaceC12008u0 constructor = next.getConstructor();
                    InterfaceC12008u0 constructor2 = abstractC11934j0.getConstructor();
                    boolean z2 = constructor instanceof C11822n;
                    if (z2 && (constructor2 instanceof C11822n)) {
                        C11822n c11822n = (C11822n) constructor;
                        C11822n c11822n2 = new C11822n(c11822n.f24445b, c11822n.f24446c, C12163u.union(c11822n.getPossibleTypes(), ((C11822n) constructor2).getPossibleTypes()), null);
                        C11916d0 c11916d0 = C11916d0.f24748a;
                        next = C11916d0.integerLiteralType(InterfaceC11344g.f22735f.getEMPTY(), c11822n2, false);
                    } else if (z2) {
                        if (((C11822n) constructor).getPossibleTypes().contains(abstractC11934j0)) {
                            next = abstractC11934j0;
                        }
                    } else if (!(constructor2 instanceof C11822n) || !((C11822n) constructor2).getPossibleTypes().contains(next)) {
                    }
                }
                next = 0;
            }
            return (AbstractC11934j0) next;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.n$b */
    /* JADX INFO: compiled from: IntegerLiteralTypeConstructor.kt */
    public static final class b extends AbstractC12240o implements Function0<List<AbstractC11934j0>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<AbstractC11934j0> invoke() {
            AbstractC11934j0 defaultType = C11822n.this.getBuiltIns().getComparable().getDefaultType();
            C12238m.checkNotNullExpressionValue(defaultType, "builtIns.comparable.defaultType");
            List<AbstractC11934j0> listMutableListOf = C12147n.mutableListOf(C11908a1.replace$default(defaultType, C12145m.listOf(new C12016y0(EnumC11935j1.IN_VARIANCE, C11822n.this.f24448e)), null, 2, null));
            if (!C11822n.access$isContainsOnlyUnsignedTypes(C11822n.this)) {
                listMutableListOf.add(C11822n.this.getBuiltIns().getNumberType());
            }
            return listMutableListOf;
        }
    }

    public C11822n(long j, InterfaceC11325c0 interfaceC11325c0, Set set, DefaultConstructorMarker defaultConstructorMarker) {
        C11916d0 c11916d0 = C11916d0.f24748a;
        this.f24448e = C11916d0.integerLiteralType(InterfaceC11344g.f22735f.getEMPTY(), this, false);
        this.f24449f = C12083g.lazy(new b());
        this.f24445b = j;
        this.f24446c = interfaceC11325c0;
        this.f24447d = set;
    }

    public static final boolean access$isContainsOnlyUnsignedTypes(C11822n c11822n) {
        Collection<AbstractC11913c0> allSignedLiteralTypes = C11829u.getAllSignedLiteralTypes(c11822n.f24446c);
        if ((allSignedLiteralTypes instanceof Collection) && allSignedLiteralTypes.isEmpty()) {
            return true;
        }
        Iterator<T> it = allSignedLiteralTypes.iterator();
        while (it.hasNext()) {
            if (!(!c11822n.getPossibleTypes().contains((AbstractC11913c0) it.next()))) {
                return false;
            }
        }
        return true;
    }

    public final boolean checkConstructor(InterfaceC12008u0 interfaceC12008u0) {
        C12238m.checkNotNullParameter(interfaceC12008u0, "constructor");
        Set<AbstractC11913c0> set = this.f24447d;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (C12238m.areEqual(((AbstractC11913c0) it.next()).getConstructor(), interfaceC12008u0)) {
                return true;
            }
        }
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public AbstractC11288h getBuiltIns() {
        return this.f24446c.getBuiltIns();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public InterfaceC11352h getDeclarationDescriptor() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public List<InterfaceC11477z0> getParameters() {
        return C12147n.emptyList();
    }

    public final Set<AbstractC11913c0> getPossibleTypes() {
        return this.f24447d;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public Collection<AbstractC11913c0> getSupertypes() {
        return (List) this.f24449f.getValue();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public boolean isDenotable() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public InterfaceC12008u0 refine(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        return this;
    }

    public String toString() {
        StringBuilder sbM829Q = C1643a.m829Q('[');
        sbM829Q.append(C12163u.joinToString$default(this.f24447d, ",", null, null, 0, null, C11823o.f24450j, 30, null));
        sbM829Q.append(']');
        return C12238m.stringPlus("IntegerLiteralType", sbM829Q.toString());
    }
}

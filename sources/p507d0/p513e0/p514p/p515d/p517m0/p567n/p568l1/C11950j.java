package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.EnumC12110i;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a.InterfaceC11804b;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.j */
/* JADX INFO: compiled from: NewCapturedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11950j implements InterfaceC11804b {

    /* JADX INFO: renamed from: a */
    public final InterfaceC12012w0 f24815a;

    /* JADX INFO: renamed from: b */
    public Function0<? extends List<? extends AbstractC11932i1>> f24816b;

    /* JADX INFO: renamed from: c */
    public final C11950j f24817c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC11477z0 f24818d;

    /* JADX INFO: renamed from: e */
    public final Lazy f24819e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.j$a */
    /* JADX INFO: compiled from: NewCapturedType.kt */
    public static final class a extends AbstractC12240o implements Function0<List<? extends AbstractC11932i1>> {
        public final /* synthetic */ List<AbstractC11932i1> $supertypes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends AbstractC11932i1> list) {
            super(0);
            this.$supertypes = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends AbstractC11932i1> invoke() {
            return this.$supertypes;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.j$b */
    /* JADX INFO: compiled from: NewCapturedType.kt */
    public static final class b extends AbstractC12240o implements Function0<List<? extends AbstractC11932i1>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends AbstractC11932i1> invoke() {
            Function0 function0 = C11950j.this.f24816b;
            if (function0 == null) {
                return null;
            }
            return (List) function0.invoke();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.j$c */
    /* JADX INFO: compiled from: NewCapturedType.kt */
    public static final class c extends AbstractC12240o implements Function0<List<? extends AbstractC11932i1>> {
        public final /* synthetic */ List<AbstractC11932i1> $supertypes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(List<? extends AbstractC11932i1> list) {
            super(0);
            this.$supertypes = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends AbstractC11932i1> invoke() {
            return this.$supertypes;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.j$d */
    /* JADX INFO: compiled from: NewCapturedType.kt */
    public static final class d extends AbstractC12240o implements Function0<List<? extends AbstractC11932i1>> {
        public final /* synthetic */ AbstractC11947g $kotlinTypeRefiner;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AbstractC11947g abstractC11947g) {
            super(0);
            this.$kotlinTypeRefiner = abstractC11947g;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends AbstractC11932i1> invoke() {
            List<AbstractC11932i1> supertypes = C11950j.this.getSupertypes();
            AbstractC11947g abstractC11947g = this.$kotlinTypeRefiner;
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(supertypes, 10));
            Iterator<T> it = supertypes.iterator();
            while (it.hasNext()) {
                arrayList.add(((AbstractC11932i1) it.next()).refine(abstractC11947g));
            }
            return arrayList;
        }
    }

    public C11950j(InterfaceC12012w0 interfaceC12012w0, Function0<? extends List<? extends AbstractC11932i1>> function0, C11950j c11950j, InterfaceC11477z0 interfaceC11477z0) {
        C12238m.checkNotNullParameter(interfaceC12012w0, "projection");
        this.f24815a = interfaceC12012w0;
        this.f24816b = function0;
        this.f24817c = c11950j;
        this.f24818d = interfaceC11477z0;
        this.f24819e = C12083g.lazy(EnumC12110i.PUBLICATION, new b());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!C12238m.areEqual(C11950j.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        C11950j c11950j = (C11950j) obj;
        C11950j c11950j2 = this.f24817c;
        if (c11950j2 == null) {
            c11950j2 = this;
        }
        C11950j c11950j3 = c11950j.f24817c;
        if (c11950j3 != null) {
            c11950j = c11950j3;
        }
        return c11950j2 == c11950j;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public AbstractC11288h getBuiltIns() {
        AbstractC11913c0 type = getProjection().getType();
        C12238m.checkNotNullExpressionValue(type, "projection.type");
        return C11992a.getBuiltIns(type);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public InterfaceC11352h getDeclarationDescriptor() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public List<InterfaceC11477z0> getParameters() {
        return C12147n.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a.InterfaceC11804b
    public InterfaceC12012w0 getProjection() {
        return this.f24815a;
    }

    public int hashCode() {
        C11950j c11950j = this.f24817c;
        return c11950j == null ? super.hashCode() : c11950j.hashCode();
    }

    public final void initializeSupertypes(List<? extends AbstractC11932i1> list) {
        C12238m.checkNotNullParameter(list, "supertypes");
        Function0<? extends List<? extends AbstractC11932i1>> function0 = this.f24816b;
        this.f24816b = new c(list);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public boolean isDenotable() {
        return false;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("CapturedType(");
        sbM833U.append(getProjection());
        sbM833U.append(')');
        return sbM833U.toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public List<AbstractC11932i1> getSupertypes() {
        List<AbstractC11932i1> list = (List) this.f24819e.getValue();
        return list == null ? C12147n.emptyList() : list;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public C11950j refine(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        InterfaceC12012w0 interfaceC12012w0Refine = getProjection().refine(abstractC11947g);
        C12238m.checkNotNullExpressionValue(interfaceC12012w0Refine, "projection.refine(kotlinTypeRefiner)");
        d dVar = this.f24816b == null ? null : new d(abstractC11947g);
        C11950j c11950j = this.f24817c;
        if (c11950j == null) {
            c11950j = this;
        }
        return new C11950j(interfaceC12012w0Refine, dVar, c11950j, this.f24818d);
    }

    public /* synthetic */ C11950j(InterfaceC12012w0 interfaceC12012w0, Function0 function0, C11950j c11950j, InterfaceC11477z0 interfaceC11477z0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC12012w0, (i & 2) != 0 ? null : function0, (i & 4) != 0 ? null : c11950j, (i & 8) != 0 ? null : interfaceC11477z0);
    }

    public /* synthetic */ C11950j(InterfaceC12012w0 interfaceC12012w0, List list, C11950j c11950j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC12012w0, list, (i & 4) != 0 ? null : c11950j);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C11950j(InterfaceC12012w0 interfaceC12012w0, List<? extends AbstractC11932i1> list, C11950j c11950j) {
        this(interfaceC12012w0, new a(list), c11950j, null, 8, null);
        C12238m.checkNotNullParameter(interfaceC12012w0, "projection");
        C12238m.checkNotNullParameter(list, "supertypes");
    }
}

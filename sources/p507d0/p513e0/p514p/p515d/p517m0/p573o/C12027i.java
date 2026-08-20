package p507d0.p513e0.p514p.p515d.p517m0.p573o;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.o.i */
/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12027i extends AbstractC12019a {

    /* JADX INFO: renamed from: a */
    public static final C12027i f24917a = new C12027i();

    /* JADX INFO: renamed from: b */
    public static final List<C12022d> f24918b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.i$a */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class a extends AbstractC12240o implements Function1<InterfaceC11472x, String> {

        /* JADX INFO: renamed from: j */
        public static final a f24919j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(InterfaceC11472x interfaceC11472x) {
            Boolean boolValueOf;
            C12238m.checkNotNullParameter(interfaceC11472x, "<this>");
            List<InterfaceC11326c1> valueParameters = interfaceC11472x.getValueParameters();
            C12238m.checkNotNullExpressionValue(valueParameters, "valueParameters");
            InterfaceC11326c1 interfaceC11326c1 = (InterfaceC11326c1) C12163u.lastOrNull((List) valueParameters);
            if (interfaceC11326c1 == null) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(!C11836a.declaresOrInheritsDefaultValue(interfaceC11326c1) && interfaceC11326c1.getVarargElementType() == null);
            }
            boolean zAreEqual = C12238m.areEqual(boolValueOf, Boolean.TRUE);
            C12027i c12027i = C12027i.f24917a;
            if (zAreEqual) {
                return null;
            }
            return "last parameter should not have a default value or be a vararg";
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.i$b */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class b extends AbstractC12240o implements Function1<InterfaceC11472x, String> {

        /* JADX INFO: renamed from: j */
        public static final b f24920j = new b();

        public b() {
            super(1);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0062  */
        @Override // kotlin.jvm.functions.Function1
        public final String invoke(InterfaceC11472x interfaceC11472x) {
            boolean z2;
            boolean z3;
            C12238m.checkNotNullParameter(interfaceC11472x, "<this>");
            C12027i c12027i = C12027i.f24917a;
            InterfaceC11450m containingDeclaration = interfaceC11472x.getContainingDeclaration();
            C12238m.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
            if (!((containingDeclaration instanceof InterfaceC11330e) && AbstractC11288h.isAny((InterfaceC11330e) containingDeclaration))) {
                Collection<? extends InterfaceC11472x> overriddenDescriptors = interfaceC11472x.getOverriddenDescriptors();
                C12238m.checkNotNullExpressionValue(overriddenDescriptors, "overriddenDescriptors");
                if (!overriddenDescriptors.isEmpty()) {
                    Iterator<T> it = overriddenDescriptors.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z3 = false;
                            break;
                        }
                        InterfaceC11450m containingDeclaration2 = ((InterfaceC11472x) it.next()).getContainingDeclaration();
                        C12238m.checkNotNullExpressionValue(containingDeclaration2, "it.containingDeclaration");
                        if ((containingDeclaration2 instanceof InterfaceC11330e) && AbstractC11288h.isAny((InterfaceC11330e) containingDeclaration2)) {
                            z3 = true;
                            break;
                        }
                    }
                } else {
                    z3 = false;
                    break;
                }
                z2 = z3;
            }
            if (z2) {
                return null;
            }
            return "must override ''equals()'' in Any";
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.i$c */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class c extends AbstractC12240o implements Function1<InterfaceC11472x, String> {

        /* JADX INFO: renamed from: j */
        public static final c f24921j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(InterfaceC11472x interfaceC11472x) {
            boolean zIsSubtypeOf;
            C12238m.checkNotNullParameter(interfaceC11472x, "<this>");
            InterfaceC11459q0 dispatchReceiverParameter = interfaceC11472x.getDispatchReceiverParameter();
            if (dispatchReceiverParameter == null) {
                dispatchReceiverParameter = interfaceC11472x.getExtensionReceiverParameter();
            }
            C12027i c12027i = C12027i.f24917a;
            boolean z2 = false;
            if (dispatchReceiverParameter != null) {
                AbstractC11913c0 returnType = interfaceC11472x.getReturnType();
                if (returnType == null) {
                    zIsSubtypeOf = false;
                } else {
                    AbstractC11913c0 type = dispatchReceiverParameter.getType();
                    C12238m.checkNotNullExpressionValue(type, "receiver.type");
                    zIsSubtypeOf = C11992a.isSubtypeOf(returnType, type);
                }
                if (zIsSubtypeOf) {
                    z2 = true;
                }
            }
            if (z2) {
                return null;
            }
            return "receiver must be a supertype of the return type";
        }
    }

    static {
        C11716e c11716e = C12028j.f24938i;
        AbstractC12024f.b bVar = AbstractC12024f.b.f24914b;
        InterfaceC12020b[] interfaceC12020bArr = {bVar, new AbstractC12030l.a(1)};
        C11716e c11716e2 = C12028j.f24939j;
        InterfaceC12020b[] interfaceC12020bArr2 = {bVar, new AbstractC12030l.a(2)};
        C11716e c11716e3 = C12028j.f24930a;
        C12026h c12026h = C12026h.f24916a;
        C12023e c12023e = C12023e.f24911a;
        C11716e c11716e4 = C12028j.f24935f;
        AbstractC12030l.d dVar = AbstractC12030l.d.f24969b;
        AbstractC12029k.a aVar = AbstractC12029k.a.f24959d;
        C11716e c11716e5 = C12028j.f24937h;
        AbstractC12030l.c cVar = AbstractC12030l.c.f24968b;
        f24918b = C12147n.listOf((Object[]) new C12022d[]{new C12022d(c11716e, interfaceC12020bArr, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(c11716e2, interfaceC12020bArr2, a.f24919j), new C12022d(c11716e3, new InterfaceC12020b[]{bVar, c12026h, new AbstractC12030l.a(2), c12023e}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(C12028j.f24931b, new InterfaceC12020b[]{bVar, c12026h, new AbstractC12030l.a(3), c12023e}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(C12028j.f24932c, new InterfaceC12020b[]{bVar, c12026h, new AbstractC12030l.b(2), c12023e}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(C12028j.f24936g, new InterfaceC12020b[]{bVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(c11716e4, new InterfaceC12020b[]{bVar, dVar, c12026h, aVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(c11716e5, new InterfaceC12020b[]{bVar, cVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(C12028j.f24940k, new InterfaceC12020b[]{bVar, cVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(C12028j.f24941l, new InterfaceC12020b[]{bVar, cVar, aVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(C12028j.f24954y, new InterfaceC12020b[]{bVar, dVar, c12026h}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(C12028j.f24933d, new InterfaceC12020b[]{AbstractC12024f.a.f24913b}, b.f24920j), new C12022d(C12028j.f24934e, new InterfaceC12020b[]{bVar, AbstractC12029k.b.f24961d, dVar, c12026h}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(C12028j.f24928G, new InterfaceC12020b[]{bVar, dVar, c12026h}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(C12028j.f24927F, new InterfaceC12020b[]{bVar, cVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(C12147n.listOf((Object[]) new C11716e[]{C12028j.f24943n, C12028j.f24944o}), new InterfaceC12020b[]{bVar}, c.f24921j), new C12022d(C12028j.f24929H, new InterfaceC12020b[]{bVar, AbstractC12029k.c.f24963d, dVar, c12026h}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(C12028j.f24942m, new InterfaceC12020b[]{bVar, cVar}, (Function1) null, 4, (DefaultConstructorMarker) null)});
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.AbstractC12019a
    public List<C12022d> getChecks$descriptors() {
        return f24918b;
    }
}

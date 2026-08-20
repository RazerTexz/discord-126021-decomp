package p507d0.p513e0.p514p.p515d.p517m0.p573o;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.o.k */
/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12029k implements InterfaceC12020b {

    /* JADX INFO: renamed from: a */
    public final String f24956a;

    /* JADX INFO: renamed from: b */
    public final Function1<AbstractC11288h, AbstractC11913c0> f24957b;

    /* JADX INFO: renamed from: c */
    public final String f24958c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.k$a */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class a extends AbstractC12029k {

        /* JADX INFO: renamed from: d */
        public static final a f24959d = new a();

        /* JADX INFO: renamed from: d0.e0.p.d.m0.o.k$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: modifierChecks.kt */
        public static final class C13340a extends AbstractC12240o implements Function1<AbstractC11288h, AbstractC11913c0> {

            /* JADX INFO: renamed from: j */
            public static final C13340a f24960j = new C13340a();

            public C13340a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AbstractC11913c0 invoke(AbstractC11288h abstractC11288h) {
                C12238m.checkNotNullParameter(abstractC11288h, "<this>");
                AbstractC11934j0 booleanType = abstractC11288h.getBooleanType();
                C12238m.checkNotNullExpressionValue(booleanType, "booleanType");
                return booleanType;
            }
        }

        public a() {
            super("Boolean", C13340a.f24960j, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.k$b */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class b extends AbstractC12029k {

        /* JADX INFO: renamed from: d */
        public static final b f24961d = new b();

        /* JADX INFO: renamed from: d0.e0.p.d.m0.o.k$b$a */
        /* JADX INFO: compiled from: modifierChecks.kt */
        public static final class a extends AbstractC12240o implements Function1<AbstractC11288h, AbstractC11913c0> {

            /* JADX INFO: renamed from: j */
            public static final a f24962j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AbstractC11913c0 invoke(AbstractC11288h abstractC11288h) {
                C12238m.checkNotNullParameter(abstractC11288h, "<this>");
                AbstractC11934j0 intType = abstractC11288h.getIntType();
                C12238m.checkNotNullExpressionValue(intType, "intType");
                return intType;
            }
        }

        public b() {
            super("Int", a.f24962j, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.k$c */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class c extends AbstractC12029k {

        /* JADX INFO: renamed from: d */
        public static final c f24963d = new c();

        /* JADX INFO: renamed from: d0.e0.p.d.m0.o.k$c$a */
        /* JADX INFO: compiled from: modifierChecks.kt */
        public static final class a extends AbstractC12240o implements Function1<AbstractC11288h, AbstractC11913c0> {

            /* JADX INFO: renamed from: j */
            public static final a f24964j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AbstractC11913c0 invoke(AbstractC11288h abstractC11288h) {
                C12238m.checkNotNullParameter(abstractC11288h, "<this>");
                AbstractC11934j0 unitType = abstractC11288h.getUnitType();
                C12238m.checkNotNullExpressionValue(unitType, "unitType");
                return unitType;
            }
        }

        public c() {
            super("Unit", a.f24964j, null);
        }
    }

    public AbstractC12029k(String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this.f24956a = str;
        this.f24957b = function1;
        this.f24958c = C12238m.stringPlus("must return ", str);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public boolean check(InterfaceC11472x interfaceC11472x) {
        C12238m.checkNotNullParameter(interfaceC11472x, "functionDescriptor");
        return C12238m.areEqual(interfaceC11472x.getReturnType(), this.f24957b.invoke(C11836a.getBuiltIns(interfaceC11472x)));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public String getDescription() {
        return this.f24958c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public String invoke(InterfaceC11472x interfaceC11472x) {
        return InterfaceC12020b.a.invoke(this, interfaceC11472x);
    }
}

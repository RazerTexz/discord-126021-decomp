package p507d0.p513e0.p514p.p515d.p517m0.p573o;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.o.l */
/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12030l implements InterfaceC12020b {

    /* JADX INFO: renamed from: a */
    public final String f24965a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.l$a */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class a extends AbstractC12030l {

        /* JADX INFO: renamed from: b */
        public final int f24966b;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(int i) {
            StringBuilder sbM834V = C1643a.m834V("must have at least ", i, " value parameter");
            sbM834V.append(i > 1 ? "s" : "");
            super(sbM834V.toString(), null);
            this.f24966b = i;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
        public boolean check(InterfaceC11472x interfaceC11472x) {
            C12238m.checkNotNullParameter(interfaceC11472x, "functionDescriptor");
            return interfaceC11472x.getValueParameters().size() >= this.f24966b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.l$b */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class b extends AbstractC12030l {

        /* JADX INFO: renamed from: b */
        public final int f24967b;

        public b(int i) {
            super(C1643a.m873r("must have exactly ", i, " value parameters"), null);
            this.f24967b = i;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
        public boolean check(InterfaceC11472x interfaceC11472x) {
            C12238m.checkNotNullParameter(interfaceC11472x, "functionDescriptor");
            return interfaceC11472x.getValueParameters().size() == this.f24967b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.l$c */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class c extends AbstractC12030l {

        /* JADX INFO: renamed from: b */
        public static final c f24968b = new c();

        public c() {
            super("must have no value parameters", null);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
        public boolean check(InterfaceC11472x interfaceC11472x) {
            C12238m.checkNotNullParameter(interfaceC11472x, "functionDescriptor");
            return interfaceC11472x.getValueParameters().isEmpty();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.l$d */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class d extends AbstractC12030l {

        /* JADX INFO: renamed from: b */
        public static final d f24969b = new d();

        public d() {
            super("must have a single value parameter", null);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
        public boolean check(InterfaceC11472x interfaceC11472x) {
            C12238m.checkNotNullParameter(interfaceC11472x, "functionDescriptor");
            return interfaceC11472x.getValueParameters().size() == 1;
        }
    }

    public AbstractC12030l(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.f24965a = str;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public String getDescription() {
        return this.f24965a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public String invoke(InterfaceC11472x interfaceC11472x) {
        return InterfaceC12020b.a.invoke(this, interfaceC11472x);
    }
}

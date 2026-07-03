package p507d0.p513e0.p514p.p515d;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import p507d0.p513e0.InterfaceC11233f;
import p507d0.p513e0.p514p.p515d.C11251c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11407k0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12250y;

/* JADX INFO: renamed from: d0.e0.p.d.o */
/* JADX INFO: compiled from: KParameterImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12049o implements InterfaceC11233f {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f25034j = {C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C12049o.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C12049o.class), "annotations", "getAnnotations()Ljava/util/List;"))};

    /* JADX INFO: renamed from: k */
    public final C11251c0.a f25035k;

    /* JADX INFO: renamed from: l */
    public final AbstractC11256f<?> f25036l;

    /* JADX INFO: renamed from: m */
    public final int f25037m;

    /* JADX INFO: renamed from: n */
    public final InterfaceC11233f.a f25038n;

    /* JADX INFO: renamed from: d0.e0.p.d.o$a */
    /* JADX INFO: compiled from: KParameterImpl.kt */
    public static final class a extends AbstractC12240o implements Function0<List<? extends Annotation>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends Annotation> invoke() {
            return C11265j0.computeAnnotations(C12049o.this.m10055a());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.o$b */
    /* JADX INFO: compiled from: KParameterImpl.kt */
    public static final class b extends AbstractC12240o implements Function0<Type> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Type invoke() {
            InterfaceC11407k0 interfaceC11407k0M10055a = C12049o.this.m10055a();
            if (!(interfaceC11407k0M10055a instanceof InterfaceC11459q0) || !C12238m.areEqual(C11265j0.getInstanceReceiverParameter(C12049o.this.getCallable().getDescriptor()), interfaceC11407k0M10055a) || C12049o.this.getCallable().getDescriptor().getKind() != InterfaceC11321b.a.FAKE_OVERRIDE) {
                return C12049o.this.getCallable().getCaller().getParameterTypes().get(C12049o.this.getIndex());
            }
            InterfaceC11450m containingDeclaration = C12049o.this.getCallable().getDescriptor().getContainingDeclaration();
            Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class<?> javaClass = C11265j0.toJavaClass((InterfaceC11330e) containingDeclaration);
            if (javaClass != null) {
                return javaClass;
            }
            throw new C11247a0("Cannot determine receiver Java type of inherited declaration: " + interfaceC11407k0M10055a);
        }
    }

    public C12049o(AbstractC11256f<?> abstractC11256f, int i, InterfaceC11233f.a aVar, Function0<? extends InterfaceC11407k0> function0) {
        C12238m.checkNotNullParameter(abstractC11256f, "callable");
        C12238m.checkNotNullParameter(aVar, "kind");
        C12238m.checkNotNullParameter(function0, "computeDescriptor");
        this.f25036l = abstractC11256f;
        this.f25037m = i;
        this.f25038n = aVar;
        this.f25035k = C11251c0.lazySoft(function0);
        C11251c0.lazySoft(new a());
    }

    /* JADX INFO: renamed from: a */
    public final InterfaceC11407k0 m10055a() {
        return (InterfaceC11407k0) this.f25035k.getValue(this, f25034j[0]);
    }

    public boolean equals(Object obj) {
        if (obj instanceof C12049o) {
            C12049o c12049o = (C12049o) obj;
            if (C12238m.areEqual(this.f25036l, c12049o.f25036l) && getIndex() == c12049o.getIndex()) {
                return true;
            }
        }
        return false;
    }

    public final AbstractC11256f<?> getCallable() {
        return this.f25036l;
    }

    public int getIndex() {
        return this.f25037m;
    }

    @Override // p507d0.p513e0.InterfaceC11233f
    public InterfaceC11233f.a getKind() {
        return this.f25038n;
    }

    @Override // p507d0.p513e0.InterfaceC11233f
    public String getName() {
        InterfaceC11407k0 interfaceC11407k0M10055a = m10055a();
        if (!(interfaceC11407k0M10055a instanceof InterfaceC11326c1)) {
            interfaceC11407k0M10055a = null;
        }
        InterfaceC11326c1 interfaceC11326c1 = (InterfaceC11326c1) interfaceC11407k0M10055a;
        if (interfaceC11326c1 == null || interfaceC11326c1.getContainingDeclaration().hasSynthesizedParameterNames()) {
            return null;
        }
        C11716e name = interfaceC11326c1.getName();
        C12238m.checkNotNullExpressionValue(name, "valueParameter.name");
        if (name.isSpecial()) {
            return null;
        }
        return name.asString();
    }

    @Override // p507d0.p513e0.InterfaceC11233f
    public KType getType() {
        AbstractC11913c0 type = m10055a().getType();
        C12238m.checkNotNullExpressionValue(type, "descriptor.type");
        return new C12058x(type, new b());
    }

    public int hashCode() {
        return Integer.valueOf(getIndex()).hashCode() + (this.f25036l.hashCode() * 31);
    }

    @Override // p507d0.p513e0.InterfaceC11233f
    public boolean isOptional() {
        InterfaceC11407k0 interfaceC11407k0M10055a = m10055a();
        if (!(interfaceC11407k0M10055a instanceof InterfaceC11326c1)) {
            interfaceC11407k0M10055a = null;
        }
        InterfaceC11326c1 interfaceC11326c1 = (InterfaceC11326c1) interfaceC11407k0M10055a;
        if (interfaceC11326c1 != null) {
            return C11836a.declaresOrInheritsDefaultValue(interfaceC11326c1);
        }
        return false;
    }

    @Override // p507d0.p513e0.InterfaceC11233f
    public boolean isVararg() {
        InterfaceC11407k0 interfaceC11407k0M10055a = m10055a();
        return (interfaceC11407k0M10055a instanceof InterfaceC11326c1) && ((InterfaceC11326c1) interfaceC11407k0M10055a).getVarargElementType() != null;
    }

    public String toString() {
        return C11255e0.f22349b.renderParameter(this);
    }
}

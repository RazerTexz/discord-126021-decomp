package p507d0.p513e0.p514p.p515d;

import com.discord.models.domain.ModelAuditLogEntry;
import java.lang.reflect.Field;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty$Setter;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p516l0.C11276h;
import p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11451m0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11455o0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11457p0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.C11620n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.AbstractC11672e;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.C11675h;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11786d;
import p507d0.p592z.p594d.AbstractC12221d;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12250y;

/* JADX INFO: renamed from: d0.e0.p.d.s */
/* JADX INFO: compiled from: KPropertyImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12053s<V> extends AbstractC11256f<V> implements KProperty<V> {

    /* JADX INFO: renamed from: n */
    public static final Object f25048n;

    /* JADX INFO: renamed from: o */
    public final C11251c0.b<Field> f25049o;

    /* JADX INFO: renamed from: p */
    public final C11251c0.a<InterfaceC11453n0> f25050p;

    /* JADX INFO: renamed from: q */
    public final AbstractC11262i f25051q;

    /* JADX INFO: renamed from: r */
    public final String f25052r;

    /* JADX INFO: renamed from: s */
    public final String f25053s;

    /* JADX INFO: renamed from: t */
    public final Object f25054t;

    /* JADX INFO: renamed from: d0.e0.p.d.s$a */
    /* JADX INFO: compiled from: KPropertyImpl.kt */
    public static abstract class a<PropertyType, ReturnType> extends AbstractC11256f<ReturnType> implements KFunction<ReturnType> {
        @Override // p507d0.p513e0.p514p.p515d.AbstractC11256f
        public AbstractC11262i getContainer() {
            return getProperty().getContainer();
        }

        @Override // p507d0.p513e0.p514p.p515d.AbstractC11256f
        public InterfaceC11272d<?> getDefaultCaller() {
            return null;
        }

        @Override // p507d0.p513e0.p514p.p515d.AbstractC11256f
        public abstract InterfaceC11451m0 getDescriptor();

        public abstract AbstractC12053s<PropertyType> getProperty();

        @Override // p507d0.p513e0.p514p.p515d.AbstractC11256f
        public boolean isBound() {
            return getProperty().isBound();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isExternal() {
            return getDescriptor().isExternal();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isInfix() {
            return getDescriptor().isInfix();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isInline() {
            return getDescriptor().isInline();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isOperator() {
            return getDescriptor().isOperator();
        }

        @Override // kotlin.reflect.KCallable, kotlin.reflect.KFunction
        public boolean isSuspend() {
            return getDescriptor().isSuspend();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.s$b */
    /* JADX INFO: compiled from: KPropertyImpl.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.s$c */
    /* JADX INFO: compiled from: KPropertyImpl.kt */
    public static abstract class c<V> extends a<V, V> implements KProperty.Getter<V> {

        /* JADX INFO: renamed from: n */
        public static final /* synthetic */ KProperty[] f25055n = {C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(c.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(c.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};

        /* JADX INFO: renamed from: o */
        public final C11251c0.a f25056o = C11251c0.lazySoft(new b());

        /* JADX INFO: renamed from: p */
        public final C11251c0.b f25057p = C11251c0.lazy(new a());

        /* JADX INFO: renamed from: d0.e0.p.d.s$c$a */
        /* JADX INFO: compiled from: KPropertyImpl.kt */
        public static final class a extends AbstractC12240o implements Function0<InterfaceC11272d<?>> {
            public a() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final InterfaceC11272d<?> invoke() {
                return C12057w.access$computeCallerForAccessor(c.this, true);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.s$c$b */
        /* JADX INFO: compiled from: KPropertyImpl.kt */
        public static final class b extends AbstractC12240o implements Function0<InterfaceC11455o0> {
            public b() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final InterfaceC11455o0 invoke() {
                InterfaceC11455o0 getter = c.this.getProperty().getDescriptor().getGetter();
                return getter != null ? getter : C11786d.createDefaultGetter(c.this.getProperty().getDescriptor(), InterfaceC11344g.f22735f.getEMPTY());
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.AbstractC11256f
        public InterfaceC11272d<?> getCaller() {
            return (InterfaceC11272d) this.f25057p.getValue(this, f25055n[1]);
        }

        @Override // p507d0.p513e0.p514p.p515d.AbstractC12053s.a, p507d0.p513e0.p514p.p515d.AbstractC11256f
        public InterfaceC11455o0 getDescriptor() {
            return (InterfaceC11455o0) this.f25056o.getValue(this, f25055n[0]);
        }

        @Override // kotlin.reflect.KCallable
        public String getName() {
            StringBuilder sbM833U = C1643a.m833U("<get-");
            sbM833U.append(getProperty().getName());
            sbM833U.append('>');
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.s$d */
    /* JADX INFO: compiled from: KPropertyImpl.kt */
    public static abstract class d<V> extends a<V, Unit> implements KMutableProperty$Setter<V> {

        /* JADX INFO: renamed from: n */
        public static final /* synthetic */ KProperty[] f25058n = {C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(d.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(d.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};

        /* JADX INFO: renamed from: o */
        public final C11251c0.a f25059o = C11251c0.lazySoft(new b());

        /* JADX INFO: renamed from: p */
        public final C11251c0.b f25060p = C11251c0.lazy(new a());

        /* JADX INFO: renamed from: d0.e0.p.d.s$d$a */
        /* JADX INFO: compiled from: KPropertyImpl.kt */
        public static final class a extends AbstractC12240o implements Function0<InterfaceC11272d<?>> {
            public a() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final InterfaceC11272d<?> invoke() {
                return C12057w.access$computeCallerForAccessor(d.this, false);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.s$d$b */
        /* JADX INFO: compiled from: KPropertyImpl.kt */
        public static final class b extends AbstractC12240o implements Function0<InterfaceC11457p0> {
            public b() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final InterfaceC11457p0 invoke() {
                InterfaceC11457p0 setter = d.this.getProperty().getDescriptor().getSetter();
                if (setter != null) {
                    return setter;
                }
                InterfaceC11453n0 descriptor = d.this.getProperty().getDescriptor();
                InterfaceC11344g.a aVar = InterfaceC11344g.f22735f;
                return C11786d.createDefaultSetter(descriptor, aVar.getEMPTY(), aVar.getEMPTY());
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.AbstractC11256f
        public InterfaceC11272d<?> getCaller() {
            return (InterfaceC11272d) this.f25060p.getValue(this, f25058n[1]);
        }

        @Override // p507d0.p513e0.p514p.p515d.AbstractC12053s.a, p507d0.p513e0.p514p.p515d.AbstractC11256f
        public InterfaceC11457p0 getDescriptor() {
            return (InterfaceC11457p0) this.f25059o.getValue(this, f25058n[0]);
        }

        @Override // kotlin.reflect.KCallable
        public String getName() {
            StringBuilder sbM833U = C1643a.m833U("<set-");
            sbM833U.append(getProperty().getName());
            sbM833U.append('>');
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.s$e */
    /* JADX INFO: compiled from: KPropertyImpl.kt */
    public static final class e extends AbstractC12240o implements Function0<InterfaceC11453n0> {
        public e() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final InterfaceC11453n0 invoke() {
            return AbstractC12053s.this.getContainer().findPropertyDescriptor(AbstractC12053s.this.getName(), AbstractC12053s.this.getSignature());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.s$f */
    /* JADX INFO: compiled from: KPropertyImpl.kt */
    public static final class f extends AbstractC12240o implements Function0<Field> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Field invoke() {
            Class<?> enclosingClass;
            AbstractC11254e abstractC11254eMapPropertySignature = C11257f0.f22358b.mapPropertySignature(AbstractC12053s.this.getDescriptor());
            if (!(abstractC11254eMapPropertySignature instanceof AbstractC11254e.c)) {
                if (abstractC11254eMapPropertySignature instanceof AbstractC11254e.a) {
                    return ((AbstractC11254e.a) abstractC11254eMapPropertySignature).getField();
                }
                if ((abstractC11254eMapPropertySignature instanceof AbstractC11254e.b) || (abstractC11254eMapPropertySignature instanceof AbstractC11254e.d)) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            AbstractC11254e.c cVar = (AbstractC11254e.c) abstractC11254eMapPropertySignature;
            InterfaceC11453n0 descriptor = cVar.getDescriptor();
            AbstractC11672e.a jvmFieldSignature$default = C11675h.getJvmFieldSignature$default(C11675h.f23720a, cVar.getProto(), cVar.getNameResolver(), cVar.getTypeTable(), false, 8, null);
            if (jvmFieldSignature$default == null) {
                return null;
            }
            if (C11620n.isPropertyWithBackingFieldInOuterClass(descriptor) || C11675h.isMovedFromInterfaceCompanion(cVar.getProto())) {
                enclosingClass = AbstractC12053s.this.getContainer().getJClass().getEnclosingClass();
            } else {
                InterfaceC11450m containingDeclaration = descriptor.getContainingDeclaration();
                enclosingClass = containingDeclaration instanceof InterfaceC11330e ? C11265j0.toJavaClass((InterfaceC11330e) containingDeclaration) : AbstractC12053s.this.getContainer().getJClass();
            }
            if (enclosingClass == null) {
                return null;
            }
            try {
                return enclosingClass.getDeclaredField(jvmFieldSignature$default.getName());
            } catch (NoSuchFieldException unused) {
                return null;
            }
        }
    }

    static {
        new b(null);
        f25048n = new Object();
    }

    public AbstractC12053s(AbstractC11262i abstractC11262i, String str, String str2, InterfaceC11453n0 interfaceC11453n0, Object obj) {
        this.f25051q = abstractC11262i;
        this.f25052r = str;
        this.f25053s = str2;
        this.f25054t = obj;
        C11251c0.b<Field> bVarLazy = C11251c0.lazy(new f());
        C12238m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy {…y -> null\n        }\n    }");
        this.f25049o = bVarLazy;
        C11251c0.a<InterfaceC11453n0> aVarLazySoft = C11251c0.lazySoft(interfaceC11453n0, new e());
        C12238m.checkNotNullExpressionValue(aVarLazySoft, "ReflectProperties.lazySo…or(name, signature)\n    }");
        this.f25050p = aVarLazySoft;
    }

    /* JADX INFO: renamed from: c */
    public final Field m10056c() {
        if (getDescriptor().isDelegated()) {
            return getJavaField();
        }
        return null;
    }

    public boolean equals(Object obj) {
        AbstractC12053s<?> abstractC12053sAsKPropertyImpl = C11265j0.asKPropertyImpl(obj);
        return abstractC12053sAsKPropertyImpl != null && C12238m.areEqual(getContainer(), abstractC12053sAsKPropertyImpl.getContainer()) && C12238m.areEqual(getName(), abstractC12053sAsKPropertyImpl.getName()) && C12238m.areEqual(this.f25053s, abstractC12053sAsKPropertyImpl.f25053s) && C12238m.areEqual(this.f25054t, abstractC12053sAsKPropertyImpl.f25054t);
    }

    public final Object getBoundReceiver() {
        return C11276h.coerceToExpectedReceiverType(this.f25054t, getDescriptor());
    }

    @Override // p507d0.p513e0.p514p.p515d.AbstractC11256f
    public InterfaceC11272d<?> getCaller() {
        return getGetter().getCaller();
    }

    @Override // p507d0.p513e0.p514p.p515d.AbstractC11256f
    public AbstractC11262i getContainer() {
        return this.f25051q;
    }

    @Override // p507d0.p513e0.p514p.p515d.AbstractC11256f
    public InterfaceC11272d<?> getDefaultCaller() {
        return getGetter().getDefaultCaller();
    }

    public abstract c<V> getGetter();

    public final Field getJavaField() {
        return this.f25049o.invoke();
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        return this.f25052r;
    }

    public final String getSignature() {
        return this.f25053s;
    }

    public int hashCode() {
        return this.f25053s.hashCode() + ((getName().hashCode() + (getContainer().hashCode() * 31)) * 31);
    }

    @Override // p507d0.p513e0.p514p.p515d.AbstractC11256f
    public boolean isBound() {
        return !C12238m.areEqual(this.f25054t, AbstractC12221d.NO_RECEIVER);
    }

    @Override // kotlin.reflect.KProperty
    public boolean isConst() {
        return getDescriptor().isConst();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isLateinit() {
        return getDescriptor().isLateInit();
    }

    @Override // kotlin.reflect.KCallable, kotlin.reflect.KFunction
    public boolean isSuspend() {
        return false;
    }

    public String toString() {
        return C11255e0.f22349b.renderProperty(getDescriptor());
    }

    @Override // p507d0.p513e0.p514p.p515d.AbstractC11256f
    public InterfaceC11453n0 getDescriptor() {
        InterfaceC11453n0 interfaceC11453n0Invoke = this.f25050p.invoke();
        C12238m.checkNotNullExpressionValue(interfaceC11453n0Invoke, "_descriptor()");
        return interfaceC11453n0Invoke;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AbstractC12053s(AbstractC11262i abstractC11262i, String str, String str2, Object obj) {
        this(abstractC11262i, str, str2, null, obj);
        C12238m.checkNotNullParameter(abstractC11262i, "container");
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(str2, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AbstractC12053s(AbstractC11262i abstractC11262i, InterfaceC11453n0 interfaceC11453n0) {
        C12238m.checkNotNullParameter(abstractC11262i, "container");
        C12238m.checkNotNullParameter(interfaceC11453n0, "descriptor");
        String strAsString = interfaceC11453n0.getName().asString();
        C12238m.checkNotNullExpressionValue(strAsString, "descriptor.name.asString()");
        this(abstractC11262i, strAsString, C11257f0.f22358b.mapPropertySignature(interfaceC11453n0).asString(), interfaceC11453n0, AbstractC12221d.NO_RECEIVER);
    }
}

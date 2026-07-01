package d0.e0.p.d;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.ReflectProperties;
import d0.e0.p.d.RuntimeTypeMapper2;
import d0.e0.p.d.l0.Caller2;
import d0.e0.p.d.l0.InlineClassAwareCaller2;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.PropertyAccessorDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.PropertyGetterDescriptor;
import d0.e0.p.d.m0.c.PropertySetterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.e.a.DescriptorsJvmAbiUtil;
import d0.e0.p.d.m0.f.a0.b.JvmMemberSignature;
import d0.e0.p.d.m0.f.a0.b.JvmProtoBufUtil;
import d0.e0.p.d.m0.k.DescriptorFactory;
import d0.z.d.CallableReference;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import java.lang.reflect.Field;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty4;

/* JADX INFO: renamed from: d0.e0.p.d.s, reason: use source file name */
/* JADX INFO: compiled from: KPropertyImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class KPropertyImpl<V> extends KCallableImpl<V> implements KProperty<V> {
    public static final Object n;
    public final ReflectProperties.b<Field> o;
    public final ReflectProperties.a<PropertyDescriptor> p;
    public final KDeclarationContainerImpl q;
    public final String r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f3568s;
    public final Object t;

    /* JADX INFO: renamed from: d0.e0.p.d.s$a */
    /* JADX INFO: compiled from: KPropertyImpl.kt */
    public static abstract class a<PropertyType, ReturnType> extends KCallableImpl<ReturnType> implements KFunction<ReturnType> {
        @Override // d0.e0.p.d.KCallableImpl
        public KDeclarationContainerImpl getContainer() {
            return getProperty().getContainer();
        }

        @Override // d0.e0.p.d.KCallableImpl
        public Caller2<?> getDefaultCaller() {
            return null;
        }

        @Override // d0.e0.p.d.KCallableImpl
        public abstract PropertyAccessorDescriptor getDescriptor();

        public abstract KPropertyImpl<PropertyType> getProperty();

        @Override // d0.e0.p.d.KCallableImpl
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
        public static final /* synthetic */ KProperty[] n = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(c.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(c.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        public final ReflectProperties.a o = ReflectProperties.lazySoft(new b());
        public final ReflectProperties.b p = ReflectProperties.lazy(new a());

        /* JADX INFO: renamed from: d0.e0.p.d.s$c$a */
        /* JADX INFO: compiled from: KPropertyImpl.kt */
        public static final class a extends Lambda implements Function0<Caller2<?>> {
            public a() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Caller2<?> invoke() {
                return KPropertyImpl5.access$computeCallerForAccessor(c.this, true);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.s$c$b */
        /* JADX INFO: compiled from: KPropertyImpl.kt */
        public static final class b extends Lambda implements Function0<PropertyGetterDescriptor> {
            public b() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PropertyGetterDescriptor invoke() {
                PropertyGetterDescriptor getter = c.this.getProperty().getDescriptor().getGetter();
                return getter != null ? getter : DescriptorFactory.createDefaultGetter(c.this.getProperty().getDescriptor(), Annotations4.f.getEMPTY());
            }
        }

        @Override // d0.e0.p.d.KCallableImpl
        public Caller2<?> getCaller() {
            return (Caller2) this.p.getValue(this, n[1]);
        }

        @Override // d0.e0.p.d.KPropertyImpl.a, d0.e0.p.d.KCallableImpl
        public PropertyGetterDescriptor getDescriptor() {
            return (PropertyGetterDescriptor) this.o.getValue(this, n[0]);
        }

        @Override // kotlin.reflect.KCallable
        public String getName() {
            StringBuilder sbU = outline.U("<get-");
            sbU.append(getProperty().getName());
            sbU.append('>');
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.s$d */
    /* JADX INFO: compiled from: KPropertyImpl.kt */
    public static abstract class d<V> extends a<V, Unit> implements KProperty4<V> {
        public static final /* synthetic */ KProperty[] n = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(d.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(d.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        public final ReflectProperties.a o = ReflectProperties.lazySoft(new b());
        public final ReflectProperties.b p = ReflectProperties.lazy(new a());

        /* JADX INFO: renamed from: d0.e0.p.d.s$d$a */
        /* JADX INFO: compiled from: KPropertyImpl.kt */
        public static final class a extends Lambda implements Function0<Caller2<?>> {
            public a() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Caller2<?> invoke() {
                return KPropertyImpl5.access$computeCallerForAccessor(d.this, false);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.s$d$b */
        /* JADX INFO: compiled from: KPropertyImpl.kt */
        public static final class b extends Lambda implements Function0<PropertySetterDescriptor> {
            public b() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PropertySetterDescriptor invoke() {
                PropertySetterDescriptor setter = d.this.getProperty().getDescriptor().getSetter();
                if (setter != null) {
                    return setter;
                }
                PropertyDescriptor descriptor = d.this.getProperty().getDescriptor();
                Annotations4.a aVar = Annotations4.f;
                return DescriptorFactory.createDefaultSetter(descriptor, aVar.getEMPTY(), aVar.getEMPTY());
            }
        }

        @Override // d0.e0.p.d.KCallableImpl
        public Caller2<?> getCaller() {
            return (Caller2) this.p.getValue(this, n[1]);
        }

        @Override // d0.e0.p.d.KPropertyImpl.a, d0.e0.p.d.KCallableImpl
        public PropertySetterDescriptor getDescriptor() {
            return (PropertySetterDescriptor) this.o.getValue(this, n[0]);
        }

        @Override // kotlin.reflect.KCallable
        public String getName() {
            StringBuilder sbU = outline.U("<set-");
            sbU.append(getProperty().getName());
            sbU.append('>');
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.s$e */
    /* JADX INFO: compiled from: KPropertyImpl.kt */
    public static final class e extends Lambda implements Function0<PropertyDescriptor> {
        public e() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PropertyDescriptor invoke() {
            return KPropertyImpl.this.getContainer().findPropertyDescriptor(KPropertyImpl.this.getName(), KPropertyImpl.this.getSignature());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.s$f */
    /* JADX INFO: compiled from: KPropertyImpl.kt */
    public static final class f extends Lambda implements Function0<Field> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Field invoke() {
            Class<?> enclosingClass;
            RuntimeTypeMapper2 runtimeTypeMapper2MapPropertySignature = RuntimeTypeMapper3.f3198b.mapPropertySignature(KPropertyImpl.this.getDescriptor());
            if (!(runtimeTypeMapper2MapPropertySignature instanceof RuntimeTypeMapper2.c)) {
                if (runtimeTypeMapper2MapPropertySignature instanceof RuntimeTypeMapper2.a) {
                    return ((RuntimeTypeMapper2.a) runtimeTypeMapper2MapPropertySignature).getField();
                }
                if ((runtimeTypeMapper2MapPropertySignature instanceof RuntimeTypeMapper2.b) || (runtimeTypeMapper2MapPropertySignature instanceof RuntimeTypeMapper2.d)) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            RuntimeTypeMapper2.c cVar = (RuntimeTypeMapper2.c) runtimeTypeMapper2MapPropertySignature;
            PropertyDescriptor descriptor = cVar.getDescriptor();
            JvmMemberSignature.a jvmFieldSignature$default = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.a, cVar.getProto(), cVar.getNameResolver(), cVar.getTypeTable(), false, 8, null);
            if (jvmFieldSignature$default == null) {
                return null;
            }
            if (DescriptorsJvmAbiUtil.isPropertyWithBackingFieldInOuterClass(descriptor) || JvmProtoBufUtil.isMovedFromInterfaceCompanion(cVar.getProto())) {
                enclosingClass = KPropertyImpl.this.getContainer().getJClass().getEnclosingClass();
            } else {
                DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
                enclosingClass = containingDeclaration instanceof ClassDescriptor ? util2.toJavaClass((ClassDescriptor) containingDeclaration) : KPropertyImpl.this.getContainer().getJClass();
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
        n = new Object();
    }

    public KPropertyImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, PropertyDescriptor propertyDescriptor, Object obj) {
        this.q = kDeclarationContainerImpl;
        this.r = str;
        this.f3568s = str2;
        this.t = obj;
        ReflectProperties.b<Field> bVarLazy = ReflectProperties.lazy(new f());
        Intrinsics3.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy {…y -> null\n        }\n    }");
        this.o = bVarLazy;
        ReflectProperties.a<PropertyDescriptor> aVarLazySoft = ReflectProperties.lazySoft(propertyDescriptor, new e());
        Intrinsics3.checkNotNullExpressionValue(aVarLazySoft, "ReflectProperties.lazySo…or(name, signature)\n    }");
        this.p = aVarLazySoft;
    }

    public final Field c() {
        if (getDescriptor().isDelegated()) {
            return getJavaField();
        }
        return null;
    }

    public boolean equals(Object obj) {
        KPropertyImpl<?> kPropertyImplAsKPropertyImpl = util2.asKPropertyImpl(obj);
        return kPropertyImplAsKPropertyImpl != null && Intrinsics3.areEqual(getContainer(), kPropertyImplAsKPropertyImpl.getContainer()) && Intrinsics3.areEqual(getName(), kPropertyImplAsKPropertyImpl.getName()) && Intrinsics3.areEqual(this.f3568s, kPropertyImplAsKPropertyImpl.f3568s) && Intrinsics3.areEqual(this.t, kPropertyImplAsKPropertyImpl.t);
    }

    public final Object getBoundReceiver() {
        return InlineClassAwareCaller2.coerceToExpectedReceiverType(this.t, getDescriptor());
    }

    @Override // d0.e0.p.d.KCallableImpl
    public Caller2<?> getCaller() {
        return getGetter().getCaller();
    }

    @Override // d0.e0.p.d.KCallableImpl
    public KDeclarationContainerImpl getContainer() {
        return this.q;
    }

    @Override // d0.e0.p.d.KCallableImpl
    public Caller2<?> getDefaultCaller() {
        return getGetter().getDefaultCaller();
    }

    public abstract c<V> getGetter();

    public final Field getJavaField() {
        return this.o.invoke();
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        return this.r;
    }

    public final String getSignature() {
        return this.f3568s;
    }

    public int hashCode() {
        return this.f3568s.hashCode() + ((getName().hashCode() + (getContainer().hashCode() * 31)) * 31);
    }

    @Override // d0.e0.p.d.KCallableImpl
    public boolean isBound() {
        return !Intrinsics3.areEqual(this.t, CallableReference.NO_RECEIVER);
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
        return ReflectionObjectRenderer.f3197b.renderProperty(getDescriptor());
    }

    @Override // d0.e0.p.d.KCallableImpl
    public PropertyDescriptor getDescriptor() {
        PropertyDescriptor propertyDescriptorInvoke = this.p.invoke();
        Intrinsics3.checkNotNullExpressionValue(propertyDescriptorInvoke, "_descriptor()");
        return propertyDescriptorInvoke;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KPropertyImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        this(kDeclarationContainerImpl, str, str2, null, obj);
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public KPropertyImpl(KDeclarationContainerImpl kDeclarationContainerImpl, PropertyDescriptor propertyDescriptor) {
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "descriptor");
        String strAsString = propertyDescriptor.getName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "descriptor.name.asString()");
        this(kDeclarationContainerImpl, strAsString, RuntimeTypeMapper3.f3198b.mapPropertySignature(propertyDescriptor).asString(), propertyDescriptor, CallableReference.NO_RECEIVER);
    }
}

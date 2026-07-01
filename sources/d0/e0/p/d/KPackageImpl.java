package d0.e0.p.d;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import d0.e0.p.d.KDeclarationContainerImpl;
import d0.e0.p.d.ReflectProperties;
import d0.e0.p.d.m0.c.ConstructorDescriptor;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.k1.a.ReflectKotlinClass2;
import d0.e0.p.d.m0.c.k1.b.reflectClassUtil;
import d0.e0.p.d.m0.d.b.LookupLocation3;
import d0.e0.p.d.m0.e.b.b0.KotlinClassHeader;
import d0.e0.p.d.m0.f.a0.JvmProtoBuf;
import d0.e0.p.d.m0.f.a0.b.JvmMetadataVersion;
import d0.e0.p.d.m0.f.a0.b.JvmNameResolver;
import d0.e0.p.d.m0.f.a0.b.JvmProtoBufUtil;
import d0.e0.p.d.m0.f.z.ProtoBufUtil;
import d0.e0.p.d.m0.f.z.TypeTable;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.i.GeneratedMessageLite;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.l.b.MemberDeserializer;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.z.d.FunctionReference;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import java.util.Collection;
import java.util.List;
import kotlin.Tuples2;
import kotlin.Tuples3;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: d0.e0.p.d.n, reason: use source file name */
/* JADX INFO: compiled from: KPackageImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KPackageImpl extends KDeclarationContainerImpl {
    public final ReflectProperties.b<a> m;
    public final Class<?> n;

    /* JADX INFO: renamed from: d0.e0.p.d.n$a */
    /* JADX INFO: compiled from: KPackageImpl.kt */
    public final class a extends KDeclarationContainerImpl.b {
        public static final /* synthetic */ KProperty[] d = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "metadata", "getMetadata()Lkotlin/Triple;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "members", "getMembers()Ljava/util/Collection;"))};
        public final ReflectProperties.a e;
        public final ReflectProperties.a f;
        public final ReflectProperties.b g;
        public final ReflectProperties.b h;

        /* JADX INFO: renamed from: d0.e0.p.d.n$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: KPackageImpl.kt */
        public static final class C0418a extends Lambda implements Function0<ReflectKotlinClass2> {
            public C0418a() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ReflectKotlinClass2 invoke() {
                return ReflectKotlinClass2.a.create(KPackageImpl.this.getJClass());
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.n$a$b */
        /* JADX INFO: compiled from: KPackageImpl.kt */
        public static final class b extends Lambda implements Function0<Collection<? extends KCallableImpl<?>>> {
            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Collection<? extends KCallableImpl<?>> invoke() {
                a aVar = a.this;
                return KPackageImpl.this.b(aVar.getScope(), KDeclarationContainerImpl.c.DECLARED);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.n$a$c */
        /* JADX INFO: compiled from: KPackageImpl.kt */
        public static final class c extends Lambda implements Function0<Tuples3<? extends JvmNameResolver, ? extends d0.e0.p.d.m0.f.l, ? extends JvmMetadataVersion>> {
            public c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Tuples3<? extends JvmNameResolver, ? extends d0.e0.p.d.m0.f.l, ? extends JvmMetadataVersion> invoke() {
                KotlinClassHeader classHeader;
                ReflectKotlinClass2 reflectKotlinClass2Access$getKotlinClass$p = a.access$getKotlinClass$p(a.this);
                if (reflectKotlinClass2Access$getKotlinClass$p == null || (classHeader = reflectKotlinClass2Access$getKotlinClass$p.getClassHeader()) == null) {
                    return null;
                }
                String[] data = classHeader.getData();
                String[] strings = classHeader.getStrings();
                if (data == null || strings == null) {
                    return null;
                }
                Tuples2<JvmNameResolver, d0.e0.p.d.m0.f.l> packageDataFrom = JvmProtoBufUtil.readPackageDataFrom(data, strings);
                return new Tuples3<>(packageDataFrom.component1(), packageDataFrom.component2(), classHeader.getMetadataVersion());
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.n$a$d */
        /* JADX INFO: compiled from: KPackageImpl.kt */
        public static final class d extends Lambda implements Function0<Class<?>> {
            public d() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Class<?> invoke() {
                KotlinClassHeader classHeader;
                ReflectKotlinClass2 reflectKotlinClass2Access$getKotlinClass$p = a.access$getKotlinClass$p(a.this);
                String multifileClassName = (reflectKotlinClass2Access$getKotlinClass$p == null || (classHeader = reflectKotlinClass2Access$getKotlinClass$p.getClassHeader()) == null) ? null : classHeader.getMultifileClassName();
                if (multifileClassName == null) {
                    return null;
                }
                if (multifileClassName.length() > 0) {
                    return KPackageImpl.this.getJClass().getClassLoader().loadClass(StringsJVM.replace$default(multifileClassName, MentionUtils.SLASH_CHAR, '.', false, 4, (Object) null));
                }
                return null;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.n$a$e */
        /* JADX INFO: compiled from: KPackageImpl.kt */
        public static final class e extends Lambda implements Function0<MemberScope3> {
            public e() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MemberScope3 invoke() {
                ReflectKotlinClass2 reflectKotlinClass2Access$getKotlinClass$p = a.access$getKotlinClass$p(a.this);
                return reflectKotlinClass2Access$getKotlinClass$p != null ? a.this.getModuleData().getPackagePartScopeCache().getPackagePartScope(reflectKotlinClass2Access$getKotlinClass$p) : MemberScope3.b.f3461b;
            }
        }

        public a() {
            super();
            this.e = ReflectProperties.lazySoft(new C0418a());
            this.f = ReflectProperties.lazySoft(new e());
            this.g = ReflectProperties.lazy(new d());
            this.h = ReflectProperties.lazy(new c());
            ReflectProperties.lazySoft(new b());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static final ReflectKotlinClass2 access$getKotlinClass$p(a aVar) {
            return (ReflectKotlinClass2) aVar.e.getValue(aVar, d[0]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Tuples3<JvmNameResolver, d0.e0.p.d.m0.f.l, JvmMetadataVersion> getMetadata() {
            return (Tuples3) this.h.getValue(this, d[3]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Class<?> getMultifileFacade() {
            return (Class) this.g.getValue(this, d[2]);
        }

        public final MemberScope3 getScope() {
            return (MemberScope3) this.f.getValue(this, d[1]);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.n$b */
    /* JADX INFO: compiled from: KPackageImpl.kt */
    public static final class b extends Lambda implements Function0<a> {
        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return KPackageImpl.this.new a();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.n$c */
    /* JADX INFO: compiled from: KPackageImpl.kt */
    public static final /* synthetic */ class c extends FunctionReference implements Function2<MemberDeserializer, d0.e0.p.d.m0.f.n, PropertyDescriptor> {
        public static final c j = new c();

        public c() {
            super(2);
        }

        @Override // d0.z.d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "loadProperty";
        }

        @Override // d0.z.d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(MemberDeserializer.class);
        }

        @Override // d0.z.d.CallableReference
        public final String getSignature() {
            return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
        }

        @Override // kotlin.jvm.functions.Function2
        public final PropertyDescriptor invoke(MemberDeserializer memberDeserializer, d0.e0.p.d.m0.f.n nVar) {
            Intrinsics3.checkNotNullParameter(memberDeserializer, "p1");
            Intrinsics3.checkNotNullParameter(nVar, "p2");
            return memberDeserializer.loadProperty(nVar);
        }
    }

    public KPackageImpl(Class<?> cls, String str) {
        Intrinsics3.checkNotNullParameter(cls, "jClass");
        this.n = cls;
        ReflectProperties.b<a> bVarLazy = ReflectProperties.lazy(new b());
        Intrinsics3.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Data() }");
        this.m = bVarLazy;
    }

    @Override // d0.e0.p.d.KDeclarationContainerImpl
    public Class<?> c() {
        Class<?> multifileFacade = this.m.invoke().getMultifileFacade();
        return multifileFacade != null ? multifileFacade : getJClass();
    }

    public boolean equals(Object obj) {
        return (obj instanceof KPackageImpl) && Intrinsics3.areEqual(getJClass(), ((KPackageImpl) obj).getJClass());
    }

    @Override // d0.e0.p.d.KDeclarationContainerImpl
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        return Collections2.emptyList();
    }

    @Override // d0.e0.p.d.KDeclarationContainerImpl
    public Collection<FunctionDescriptor> getFunctions(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.m.invoke().getScope().getContributedFunctions(name, LookupLocation3.FROM_REFLECTION);
    }

    @Override // d0.z.d.ClassBasedDeclarationContainer
    public Class<?> getJClass() {
        return this.n;
    }

    @Override // d0.e0.p.d.KDeclarationContainerImpl
    public PropertyDescriptor getLocalProperty(int i) {
        Tuples3<JvmNameResolver, d0.e0.p.d.m0.f.l, JvmMetadataVersion> metadata = this.m.invoke().getMetadata();
        if (metadata == null) {
            return null;
        }
        JvmNameResolver jvmNameResolverComponent1 = metadata.component1();
        d0.e0.p.d.m0.f.l lVarComponent2 = metadata.component2();
        JvmMetadataVersion jvmMetadataVersionComponent3 = metadata.component3();
        GeneratedMessageLite.f<d0.e0.p.d.m0.f.l, List<d0.e0.p.d.m0.f.n>> fVar = JvmProtoBuf.n;
        Intrinsics3.checkNotNullExpressionValue(fVar, "JvmProtoBuf.packageLocalVariable");
        d0.e0.p.d.m0.f.n nVar = (d0.e0.p.d.m0.f.n) ProtoBufUtil.getExtensionOrNull(lVarComponent2, fVar, i);
        if (nVar == null) {
            return null;
        }
        Class<?> jClass = getJClass();
        d0.e0.p.d.m0.f.t typeTable = lVarComponent2.getTypeTable();
        Intrinsics3.checkNotNullExpressionValue(typeTable, "packageProto.typeTable");
        return (PropertyDescriptor) util2.deserializeToDescriptor(jClass, nVar, jvmNameResolverComponent1, new TypeTable(typeTable), jvmMetadataVersionComponent3, c.j);
    }

    @Override // d0.e0.p.d.KDeclarationContainerImpl
    public Collection<PropertyDescriptor> getProperties(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.m.invoke().getScope().getContributedVariables(name, LookupLocation3.FROM_REFLECTION);
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    public String toString() {
        StringBuilder sbU = outline.U("file class ");
        sbU.append(reflectClassUtil.getClassId(getJClass()).asSingleFqName());
        return sbU.toString();
    }
}

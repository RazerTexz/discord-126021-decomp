package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.e.b.b0.KotlinClassHeader;
import d0.e0.p.d.m0.f.a0.b.JvmMetadataVersion;
import d0.e0.p.d.m0.f.a0.b.JvmNameResolver;
import d0.e0.p.d.m0.f.a0.b.JvmProtoBufUtil;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.l.b.ClassData;
import d0.e0.p.d.m0.l.b.IncompatibleVersionErrorData;
import d0.e0.p.d.m0.l.b.context5;
import d0.e0.p.d.m0.l.b.e0.DeserializedContainerSource;
import d0.e0.p.d.m0.l.b.e0.DeserializedPackageMemberScope;
import d0.t.Collections2;
import d0.t.Sets5;
import d0.t.SetsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Set;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.f, reason: use source file name */
/* JADX INFO: compiled from: DeserializedDescriptorResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DeserializedDescriptorResolver {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<KotlinClassHeader.a> f3376b = SetsJVM.setOf(KotlinClassHeader.a.CLASS);
    public static final Set<KotlinClassHeader.a> c = Sets5.setOf((Object[]) new KotlinClassHeader.a[]{KotlinClassHeader.a.FILE_FACADE, KotlinClassHeader.a.MULTIFILE_CLASS_PART});
    public static final JvmMetadataVersion d = new JvmMetadataVersion(1, 1, 2);
    public static final JvmMetadataVersion e = new JvmMetadataVersion(1, 1, 11);
    public static final JvmMetadataVersion f = new JvmMetadataVersion(1, 1, 13);
    public context5 g;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.f$a */
    /* JADX INFO: compiled from: DeserializedDescriptorResolver.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final JvmMetadataVersion getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm() {
            return DeserializedDescriptorResolver.f;
        }

        public final Set<KotlinClassHeader.a> getKOTLIN_CLASS$descriptors_jvm() {
            return DeserializedDescriptorResolver.f3376b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.f$b */
    /* JADX INFO: compiled from: DeserializedDescriptorResolver.kt */
    public static final class b extends Lambda implements Function0<Collection<? extends Name>> {
        public static final b j = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Collection<? extends Name> invoke() {
            return Collections2.emptyList();
        }
    }

    public static final boolean access$getSkipMetadataVersionCheck(DeserializedDescriptorResolver deserializedDescriptorResolver) {
        return deserializedDescriptorResolver.getComponents().getConfiguration().getSkipMetadataVersionCheck();
    }

    public final DeserializedContainerSource a(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        DeserializedContainerSource deserializedContainerSource = DeserializedContainerSource.STABLE;
        if (getComponents().getConfiguration().getAllowUnstableDependencies()) {
            return deserializedContainerSource;
        }
        if (kotlinJvmBinaryClass.getClassHeader().isUnstableFirBinary()) {
            return DeserializedContainerSource.FIR_UNSTABLE;
        }
        return kotlinJvmBinaryClass.getClassHeader().isUnstableJvmIrBinary() ? DeserializedContainerSource.IR_UNSTABLE : deserializedContainerSource;
    }

    public final IncompatibleVersionErrorData<JvmMetadataVersion> b(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (getComponents().getConfiguration().getSkipMetadataVersionCheck() || kotlinJvmBinaryClass.getClassHeader().getMetadataVersion().isCompatible()) {
            return null;
        }
        return new IncompatibleVersionErrorData<>(kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), JvmMetadataVersion.f, kotlinJvmBinaryClass.getLocation(), kotlinJvmBinaryClass.getClassId());
    }

    public final boolean c(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (!getComponents().getConfiguration().getReportErrorsOnPreReleaseDependencies() || (!kotlinJvmBinaryClass.getClassHeader().isPreRelease() && !Intrinsics3.areEqual(kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), d))) {
            if (!(!getComponents().getConfiguration().getSkipPrereleaseCheck() && kotlinJvmBinaryClass.getClassHeader().isPreRelease() && Intrinsics3.areEqual(kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), e))) {
                return false;
            }
        }
        return true;
    }

    public final MemberScope3 createKotlinPackagePartScope(PackageFragmentDescriptor packageFragmentDescriptor, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        String[] strings;
        Tuples2<JvmNameResolver, d0.e0.p.d.m0.f.l> packageDataFrom;
        Intrinsics3.checkNotNullParameter(packageFragmentDescriptor, "descriptor");
        Intrinsics3.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
        String[] strArrD = d(kotlinJvmBinaryClass, c);
        if (strArrD == null || (strings = kotlinJvmBinaryClass.getClassHeader().getStrings()) == null) {
            return null;
        }
        try {
            try {
                JvmProtoBufUtil jvmProtoBufUtil = JvmProtoBufUtil.a;
                packageDataFrom = JvmProtoBufUtil.readPackageDataFrom(strArrD, strings);
            } catch (InvalidProtocolBufferException e2) {
                throw new IllegalStateException(Intrinsics3.stringPlus("Could not read data from ", kotlinJvmBinaryClass.getLocation()), e2);
            }
        } catch (Throwable th) {
            if (access$getSkipMetadataVersionCheck(this) || kotlinJvmBinaryClass.getClassHeader().getMetadataVersion().isCompatible()) {
                throw th;
            }
            packageDataFrom = null;
        }
        if (packageDataFrom == null) {
            return null;
        }
        JvmNameResolver jvmNameResolverComponent1 = packageDataFrom.component1();
        d0.e0.p.d.m0.f.l lVarComponent2 = packageDataFrom.component2();
        return new DeserializedPackageMemberScope(packageFragmentDescriptor, lVarComponent2, jvmNameResolverComponent1, kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), new JvmPackagePartSource(kotlinJvmBinaryClass, lVarComponent2, jvmNameResolverComponent1, b(kotlinJvmBinaryClass), c(kotlinJvmBinaryClass), a(kotlinJvmBinaryClass)), getComponents(), b.j);
    }

    public final String[] d(KotlinJvmBinaryClass kotlinJvmBinaryClass, Set<? extends KotlinClassHeader.a> set) {
        KotlinClassHeader classHeader = kotlinJvmBinaryClass.getClassHeader();
        String[] data = classHeader.getData();
        if (data == null) {
            data = classHeader.getIncompatibleData();
        }
        if (data != null && set.contains(classHeader.getKind())) {
            return data;
        }
        return null;
    }

    public final context5 getComponents() {
        context5 context5Var = this.g;
        if (context5Var != null) {
            return context5Var;
        }
        Intrinsics3.throwUninitializedPropertyAccessException("components");
        throw null;
    }

    public final ClassData readClassData$descriptors_jvm(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        String[] strings;
        Tuples2<JvmNameResolver, d0.e0.p.d.m0.f.c> classDataFrom;
        Intrinsics3.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
        String[] strArrD = d(kotlinJvmBinaryClass, a.getKOTLIN_CLASS$descriptors_jvm());
        if (strArrD == null || (strings = kotlinJvmBinaryClass.getClassHeader().getStrings()) == null) {
            return null;
        }
        try {
            try {
                JvmProtoBufUtil jvmProtoBufUtil = JvmProtoBufUtil.a;
                classDataFrom = JvmProtoBufUtil.readClassDataFrom(strArrD, strings);
            } catch (InvalidProtocolBufferException e2) {
                throw new IllegalStateException(Intrinsics3.stringPlus("Could not read data from ", kotlinJvmBinaryClass.getLocation()), e2);
            }
        } catch (Throwable th) {
            if (access$getSkipMetadataVersionCheck(this) || kotlinJvmBinaryClass.getClassHeader().getMetadataVersion().isCompatible()) {
                throw th;
            }
            classDataFrom = null;
        }
        if (classDataFrom == null) {
            return null;
        }
        return new ClassData(classDataFrom.component1(), classDataFrom.component2(), kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), new KotlinJvmBinarySourceElement(kotlinJvmBinaryClass, b(kotlinJvmBinaryClass), c(kotlinJvmBinaryClass), a(kotlinJvmBinaryClass)));
    }

    public final ClassDescriptor resolveClass(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Intrinsics3.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
        ClassData classData$descriptors_jvm = readClassData$descriptors_jvm(kotlinJvmBinaryClass);
        if (classData$descriptors_jvm == null) {
            return null;
        }
        return getComponents().getClassDeserializer().deserializeClass(kotlinJvmBinaryClass.getClassId(), classData$descriptors_jvm);
    }

    public final void setComponents(context5 context5Var) {
        Intrinsics3.checkNotNullParameter(context5Var, "<set-?>");
        this.g = context5Var;
    }

    public final void setComponents(DeserializationComponentsForJava deserializationComponentsForJava) {
        Intrinsics3.checkNotNullParameter(deserializationComponentsForJava, "components");
        setComponents(deserializationComponentsForJava.getComponents());
    }
}

package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.b.q.JvmBuiltIns;
import d0.e0.p.d.m0.b.q.JvmBuiltInsCustomizer2;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.NotFoundClasses;
import d0.e0.p.d.m0.c.h1.AdditionalClassPartsProvider;
import d0.e0.p.d.m0.c.h1.PlatformDependentDeclarationFilter;
import d0.e0.p.d.m0.d.b.LookupTracker;
import d0.e0.p.d.m0.e.a.i0.LazyJavaPackageFragmentProvider;
import d0.e0.p.d.m0.f.a0.b.JvmProtoBufUtil;
import d0.e0.p.d.m0.k.z.SamConversionResolverImpl;
import d0.e0.p.d.m0.l.b.ContractDeserializer;
import d0.e0.p.d.m0.l.b.DeserializationConfiguration;
import d0.e0.p.d.m0.l.b.ErrorReporter;
import d0.e0.p.d.m0.l.b.LocalClassifierTypeSettings;
import d0.e0.p.d.m0.l.b.context5;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.n.l1.NewKotlinTypeChecker;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.e, reason: use source file name */
/* JADX INFO: compiled from: DeserializationComponentsForJava.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DeserializationComponentsForJava {
    public final context5 a;

    public DeserializationComponentsForJava(StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2, DeserializationConfiguration deserializationConfiguration, JavaClassDataFinder javaClassDataFinder, BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl, LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, NotFoundClasses notFoundClasses, ErrorReporter errorReporter, LookupTracker lookupTracker, ContractDeserializer contractDeserializer, NewKotlinTypeChecker newKotlinTypeChecker) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        Intrinsics3.checkNotNullParameter(deserializationConfiguration, "configuration");
        Intrinsics3.checkNotNullParameter(javaClassDataFinder, "classDataFinder");
        Intrinsics3.checkNotNullParameter(binaryClassAnnotationAndConstantLoaderImpl, "annotationAndConstantLoader");
        Intrinsics3.checkNotNullParameter(lazyJavaPackageFragmentProvider, "packageFragmentProvider");
        Intrinsics3.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics3.checkNotNullParameter(errorReporter, "errorReporter");
        Intrinsics3.checkNotNullParameter(lookupTracker, "lookupTracker");
        Intrinsics3.checkNotNullParameter(contractDeserializer, "contractDeserializer");
        Intrinsics3.checkNotNullParameter(newKotlinTypeChecker, "kotlinTypeChecker");
        KotlinBuiltIns builtIns = moduleDescriptor2.getBuiltIns();
        JvmBuiltIns jvmBuiltIns = builtIns instanceof JvmBuiltIns ? (JvmBuiltIns) builtIns : null;
        LocalClassifierTypeSettings.a aVar = LocalClassifierTypeSettings.a.a;
        JavaFlexibleTypeDeserializer javaFlexibleTypeDeserializer = JavaFlexibleTypeDeserializer.a;
        List listEmptyList = Collections2.emptyList();
        AdditionalClassPartsProvider customizer = jvmBuiltIns == null ? null : jvmBuiltIns.getCustomizer();
        AdditionalClassPartsProvider additionalClassPartsProvider = customizer == null ? AdditionalClassPartsProvider.a.a : customizer;
        JvmBuiltInsCustomizer2 customizer2 = jvmBuiltIns != null ? jvmBuiltIns.getCustomizer() : null;
        this.a = new context5(storageManager, moduleDescriptor2, deserializationConfiguration, javaClassDataFinder, binaryClassAnnotationAndConstantLoaderImpl, lazyJavaPackageFragmentProvider, aVar, errorReporter, lookupTracker, javaFlexibleTypeDeserializer, listEmptyList, notFoundClasses, contractDeserializer, additionalClassPartsProvider, customizer2 == null ? PlatformDependentDeclarationFilter.b.a : customizer2, JvmProtoBufUtil.a.getEXTENSION_REGISTRY(), newKotlinTypeChecker, new SamConversionResolverImpl(storageManager, Collections2.emptyList()), null, 262144, null);
    }

    public final context5 getComponents() {
        return this.a;
    }
}

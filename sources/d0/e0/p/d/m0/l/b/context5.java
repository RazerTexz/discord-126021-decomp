package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.NotFoundClasses;
import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.c.PackageFragmentProvider;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.c.h1.AdditionalClassPartsProvider;
import d0.e0.p.d.m0.c.h1.ClassDescriptorFactory;
import d0.e0.p.d.m0.c.h1.PlatformDependentDeclarationFilter;
import d0.e0.p.d.m0.c.h1.PlatformDependentTypeTransformer;
import d0.e0.p.d.m0.d.b.LookupTracker;
import d0.e0.p.d.m0.f.z.BinaryVersion;
import d0.e0.p.d.m0.f.z.NameResolver;
import d0.e0.p.d.m0.f.z.TypeTable;
import d0.e0.p.d.m0.f.z.VersionRequirement2;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.i.ExtensionRegistryLite;
import d0.e0.p.d.m0.k.z.SamConversionResolver;
import d0.e0.p.d.m0.l.b.e0.DeserializedContainerSource2;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.n.l1.NewKotlinTypeChecker;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.j, reason: use source file name */
/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class context5 {
    public final StorageManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ModuleDescriptor2 f3503b;
    public final DeserializationConfiguration c;
    public final ClassDataFinder d;
    public final AnnotationAndConstantLoader<AnnotationDescriptor, d0.e0.p.d.m0.k.v.g<?>> e;
    public final PackageFragmentProvider f;
    public final LocalClassifierTypeSettings g;
    public final ErrorReporter h;
    public final LookupTracker i;
    public final FlexibleTypeDeserializer j;
    public final Iterable<ClassDescriptorFactory> k;
    public final NotFoundClasses l;
    public final ContractDeserializer m;
    public final AdditionalClassPartsProvider n;
    public final PlatformDependentDeclarationFilter o;
    public final ExtensionRegistryLite p;
    public final NewKotlinTypeChecker q;
    public final SamConversionResolver r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final PlatformDependentTypeTransformer f3504s;
    public final ClassDeserializer t;

    /* JADX WARN: Multi-variable type inference failed */
    public context5(StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2, DeserializationConfiguration deserializationConfiguration, ClassDataFinder classDataFinder, AnnotationAndConstantLoader<? extends AnnotationDescriptor, ? extends d0.e0.p.d.m0.k.v.g<?>> annotationAndConstantLoader, PackageFragmentProvider packageFragmentProvider, LocalClassifierTypeSettings localClassifierTypeSettings, ErrorReporter errorReporter, LookupTracker lookupTracker, FlexibleTypeDeserializer flexibleTypeDeserializer, Iterable<? extends ClassDescriptorFactory> iterable, NotFoundClasses notFoundClasses, ContractDeserializer contractDeserializer, AdditionalClassPartsProvider additionalClassPartsProvider, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, ExtensionRegistryLite extensionRegistryLite, NewKotlinTypeChecker newKotlinTypeChecker, SamConversionResolver samConversionResolver, PlatformDependentTypeTransformer platformDependentTypeTransformer) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        Intrinsics3.checkNotNullParameter(deserializationConfiguration, "configuration");
        Intrinsics3.checkNotNullParameter(classDataFinder, "classDataFinder");
        Intrinsics3.checkNotNullParameter(annotationAndConstantLoader, "annotationAndConstantLoader");
        Intrinsics3.checkNotNullParameter(packageFragmentProvider, "packageFragmentProvider");
        Intrinsics3.checkNotNullParameter(localClassifierTypeSettings, "localClassifierTypeSettings");
        Intrinsics3.checkNotNullParameter(errorReporter, "errorReporter");
        Intrinsics3.checkNotNullParameter(lookupTracker, "lookupTracker");
        Intrinsics3.checkNotNullParameter(flexibleTypeDeserializer, "flexibleTypeDeserializer");
        Intrinsics3.checkNotNullParameter(iterable, "fictitiousClassDescriptorFactories");
        Intrinsics3.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics3.checkNotNullParameter(contractDeserializer, "contractDeserializer");
        Intrinsics3.checkNotNullParameter(additionalClassPartsProvider, "additionalClassPartsProvider");
        Intrinsics3.checkNotNullParameter(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        Intrinsics3.checkNotNullParameter(extensionRegistryLite, "extensionRegistryLite");
        Intrinsics3.checkNotNullParameter(newKotlinTypeChecker, "kotlinTypeChecker");
        Intrinsics3.checkNotNullParameter(samConversionResolver, "samConversionResolver");
        Intrinsics3.checkNotNullParameter(platformDependentTypeTransformer, "platformDependentTypeTransformer");
        this.a = storageManager;
        this.f3503b = moduleDescriptor2;
        this.c = deserializationConfiguration;
        this.d = classDataFinder;
        this.e = annotationAndConstantLoader;
        this.f = packageFragmentProvider;
        this.g = localClassifierTypeSettings;
        this.h = errorReporter;
        this.i = lookupTracker;
        this.j = flexibleTypeDeserializer;
        this.k = iterable;
        this.l = notFoundClasses;
        this.m = contractDeserializer;
        this.n = additionalClassPartsProvider;
        this.o = platformDependentDeclarationFilter;
        this.p = extensionRegistryLite;
        this.q = newKotlinTypeChecker;
        this.r = samConversionResolver;
        this.f3504s = platformDependentTypeTransformer;
        this.t = new ClassDeserializer(this);
    }

    public final context6 createContext(PackageFragmentDescriptor packageFragmentDescriptor, NameResolver nameResolver, TypeTable typeTable, VersionRequirement2 versionRequirement2, BinaryVersion binaryVersion, DeserializedContainerSource2 deserializedContainerSource2) {
        Intrinsics3.checkNotNullParameter(packageFragmentDescriptor, "descriptor");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics3.checkNotNullParameter(versionRequirement2, "versionRequirementTable");
        Intrinsics3.checkNotNullParameter(binaryVersion, "metadataVersion");
        return new context6(this, nameResolver, packageFragmentDescriptor, typeTable, versionRequirement2, binaryVersion, deserializedContainerSource2, null, Collections2.emptyList());
    }

    public final ClassDescriptor deserializeClass(ClassId classId) {
        Intrinsics3.checkNotNullParameter(classId, "classId");
        return ClassDeserializer.deserializeClass$default(this.t, classId, null, 2, null);
    }

    public final AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        return this.n;
    }

    public final AnnotationAndConstantLoader<AnnotationDescriptor, d0.e0.p.d.m0.k.v.g<?>> getAnnotationAndConstantLoader() {
        return this.e;
    }

    public final ClassDataFinder getClassDataFinder() {
        return this.d;
    }

    public final ClassDeserializer getClassDeserializer() {
        return this.t;
    }

    public final DeserializationConfiguration getConfiguration() {
        return this.c;
    }

    public final ContractDeserializer getContractDeserializer() {
        return this.m;
    }

    public final ErrorReporter getErrorReporter() {
        return this.h;
    }

    public final ExtensionRegistryLite getExtensionRegistryLite() {
        return this.p;
    }

    public final Iterable<ClassDescriptorFactory> getFictitiousClassDescriptorFactories() {
        return this.k;
    }

    public final FlexibleTypeDeserializer getFlexibleTypeDeserializer() {
        return this.j;
    }

    public final NewKotlinTypeChecker getKotlinTypeChecker() {
        return this.q;
    }

    public final LocalClassifierTypeSettings getLocalClassifierTypeSettings() {
        return this.g;
    }

    public final LookupTracker getLookupTracker() {
        return this.i;
    }

    public final ModuleDescriptor2 getModuleDescriptor() {
        return this.f3503b;
    }

    public final NotFoundClasses getNotFoundClasses() {
        return this.l;
    }

    public final PackageFragmentProvider getPackageFragmentProvider() {
        return this.f;
    }

    public final PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return this.o;
    }

    public final PlatformDependentTypeTransformer getPlatformDependentTypeTransformer() {
        return this.f3504s;
    }

    public final StorageManager getStorageManager() {
        return this.a;
    }

    public /* synthetic */ context5(StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2, DeserializationConfiguration deserializationConfiguration, ClassDataFinder classDataFinder, AnnotationAndConstantLoader annotationAndConstantLoader, PackageFragmentProvider packageFragmentProvider, LocalClassifierTypeSettings localClassifierTypeSettings, ErrorReporter errorReporter, LookupTracker lookupTracker, FlexibleTypeDeserializer flexibleTypeDeserializer, Iterable iterable, NotFoundClasses notFoundClasses, ContractDeserializer contractDeserializer, AdditionalClassPartsProvider additionalClassPartsProvider, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, ExtensionRegistryLite extensionRegistryLite, NewKotlinTypeChecker newKotlinTypeChecker, SamConversionResolver samConversionResolver, PlatformDependentTypeTransformer platformDependentTypeTransformer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager, moduleDescriptor2, deserializationConfiguration, classDataFinder, annotationAndConstantLoader, packageFragmentProvider, localClassifierTypeSettings, errorReporter, lookupTracker, flexibleTypeDeserializer, iterable, notFoundClasses, contractDeserializer, (i & 8192) != 0 ? AdditionalClassPartsProvider.a.a : additionalClassPartsProvider, (i & 16384) != 0 ? PlatformDependentDeclarationFilter.a.a : platformDependentDeclarationFilter, extensionRegistryLite, (65536 & i) != 0 ? NewKotlinTypeChecker.f3529b.getDefault() : newKotlinTypeChecker, samConversionResolver, (i & 262144) != 0 ? PlatformDependentTypeTransformer.a.a : platformDependentTypeTransformer);
    }
}

package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.b.p.BuiltInFictitiousFunctionClassFactory;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.NotFoundClasses;
import d0.e0.p.d.m0.c.h1.AdditionalClassPartsProvider;
import d0.e0.p.d.m0.c.h1.ClassDescriptorFactory;
import d0.e0.p.d.m0.c.h1.PlatformDependentDeclarationFilter;
import d0.e0.p.d.m0.d.b.LookupTracker;
import d0.e0.p.d.m0.e.b.KotlinClassFinder;
import d0.e0.p.d.m0.k.z.SamConversionResolver;
import d0.e0.p.d.m0.l.b.AbstractDeserializedPackageFragmentProvider;
import d0.e0.p.d.m0.l.b.AnnotationAndConstantLoaderImpl;
import d0.e0.p.d.m0.l.b.ContractDeserializer;
import d0.e0.p.d.m0.l.b.DeserializationConfiguration;
import d0.e0.p.d.m0.l.b.DeserializedClassDataFinder;
import d0.e0.p.d.m0.l.b.ErrorReporter;
import d0.e0.p.d.m0.l.b.FlexibleTypeDeserializer;
import d0.e0.p.d.m0.l.b.LocalClassifierTypeSettings;
import d0.e0.p.d.m0.l.b.context5;
import d0.e0.p.d.m0.l.b.d0.BuiltInSerializerProtocol;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.n.l1.NewKotlinTypeChecker;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.o, reason: use source file name */
/* JADX INFO: compiled from: JvmBuiltInsPackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmBuiltInsPackageFragmentProvider extends AbstractDeserializedPackageFragmentProvider {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltInsPackageFragmentProvider(StorageManager storageManager, KotlinClassFinder kotlinClassFinder, ModuleDescriptor2 moduleDescriptor2, NotFoundClasses notFoundClasses, AdditionalClassPartsProvider additionalClassPartsProvider, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, DeserializationConfiguration deserializationConfiguration, NewKotlinTypeChecker newKotlinTypeChecker, SamConversionResolver samConversionResolver) {
        super(storageManager, kotlinClassFinder, moduleDescriptor2);
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(kotlinClassFinder, "finder");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        Intrinsics3.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics3.checkNotNullParameter(additionalClassPartsProvider, "additionalClassPartsProvider");
        Intrinsics3.checkNotNullParameter(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        Intrinsics3.checkNotNullParameter(deserializationConfiguration, "deserializationConfiguration");
        Intrinsics3.checkNotNullParameter(newKotlinTypeChecker, "kotlinTypeChecker");
        Intrinsics3.checkNotNullParameter(samConversionResolver, "samConversionResolver");
        DeserializedClassDataFinder deserializedClassDataFinder = new DeserializedClassDataFinder(this);
        BuiltInSerializerProtocol builtInSerializerProtocol = BuiltInSerializerProtocol.m;
        AnnotationAndConstantLoaderImpl annotationAndConstantLoaderImpl = new AnnotationAndConstantLoaderImpl(moduleDescriptor2, notFoundClasses, builtInSerializerProtocol);
        LocalClassifierTypeSettings.a aVar = LocalClassifierTypeSettings.a.a;
        ErrorReporter errorReporter = ErrorReporter.a;
        Intrinsics3.checkNotNullExpressionValue(errorReporter, "DO_NOTHING");
        context5 context5Var = new context5(storageManager, moduleDescriptor2, deserializationConfiguration, deserializedClassDataFinder, annotationAndConstantLoaderImpl, this, aVar, errorReporter, LookupTracker.a.a, FlexibleTypeDeserializer.a.a, Collections2.listOf((Object[]) new ClassDescriptorFactory[]{new BuiltInFictitiousFunctionClassFactory(storageManager, moduleDescriptor2), new JvmBuiltInClassDescriptorFactory(storageManager, moduleDescriptor2, null, 4, null)}), notFoundClasses, ContractDeserializer.a.getDEFAULT(), additionalClassPartsProvider, platformDependentDeclarationFilter, builtInSerializerProtocol.getExtensionRegistry(), newKotlinTypeChecker, samConversionResolver, null, 262144, null);
        Intrinsics3.checkNotNullParameter(context5Var, "<set-?>");
        this.d = context5Var;
    }
}

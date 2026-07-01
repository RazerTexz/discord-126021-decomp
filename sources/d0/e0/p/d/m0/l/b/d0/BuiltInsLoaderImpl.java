package d0.e0.p.d.m0.l.b.d0;

import d0.e0.p.d.m0.b.BuiltInsLoader;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.NotFoundClasses;
import d0.e0.p.d.m0.c.PackageFragmentProvider;
import d0.e0.p.d.m0.c.PackageFragmentProviderImpl;
import d0.e0.p.d.m0.c.h1.AdditionalClassPartsProvider;
import d0.e0.p.d.m0.c.h1.ClassDescriptorFactory;
import d0.e0.p.d.m0.c.h1.PlatformDependentDeclarationFilter;
import d0.e0.p.d.m0.d.b.LookupTracker;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.k.z.SamConversionResolverImpl;
import d0.e0.p.d.m0.l.b.AnnotationAndConstantLoaderImpl;
import d0.e0.p.d.m0.l.b.ContractDeserializer;
import d0.e0.p.d.m0.l.b.DeserializationConfiguration;
import d0.e0.p.d.m0.l.b.DeserializedClassDataFinder;
import d0.e0.p.d.m0.l.b.ErrorReporter;
import d0.e0.p.d.m0.l.b.FlexibleTypeDeserializer;
import d0.e0.p.d.m0.l.b.LocalClassifierTypeSettings;
import d0.e0.p.d.m0.l.b.context5;
import d0.e0.p.d.m0.m.StorageManager;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.FunctionReference;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.d0.b, reason: use source file name */
/* JADX INFO: compiled from: BuiltInsLoaderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BuiltInsLoaderImpl implements BuiltInsLoader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BuiltInsResourceLoader f3485b = new BuiltInsResourceLoader();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.d0.b$a */
    /* JADX INFO: compiled from: BuiltInsLoaderImpl.kt */
    public /* synthetic */ class a extends FunctionReference implements Function1<String, InputStream> {
        public a(BuiltInsResourceLoader builtInsResourceLoader) {
            super(1, builtInsResourceLoader);
        }

        @Override // d0.z.d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "loadResource";
        }

        @Override // d0.z.d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(BuiltInsResourceLoader.class);
        }

        @Override // d0.z.d.CallableReference
        public final String getSignature() {
            return "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
        }

        @Override // kotlin.jvm.functions.Function1
        public final InputStream invoke(String str) {
            Intrinsics3.checkNotNullParameter(str, "p0");
            return ((BuiltInsResourceLoader) this.receiver).loadResource(str);
        }
    }

    public final PackageFragmentProvider createBuiltInPackageFragmentProvider(StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2, Set<FqName> set, Iterable<? extends ClassDescriptorFactory> iterable, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, AdditionalClassPartsProvider additionalClassPartsProvider, boolean z2, Function1<? super String, ? extends InputStream> function1) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        Intrinsics3.checkNotNullParameter(set, "packageFqNames");
        Intrinsics3.checkNotNullParameter(iterable, "classDescriptorFactories");
        Intrinsics3.checkNotNullParameter(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        Intrinsics3.checkNotNullParameter(additionalClassPartsProvider, "additionalClassPartsProvider");
        Intrinsics3.checkNotNullParameter(function1, "loadResource");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(set, 10));
        for (FqName fqName : set) {
            String builtInsFilePath = BuiltInSerializerProtocol.m.getBuiltInsFilePath(fqName);
            InputStream inputStreamInvoke = function1.invoke(builtInsFilePath);
            if (inputStreamInvoke == null) {
                throw new IllegalStateException(Intrinsics3.stringPlus("Resource not found in classpath: ", builtInsFilePath));
            }
            arrayList.add(BuiltInsPackageFragmentImpl.v.create(fqName, storageManager, moduleDescriptor2, inputStreamInvoke, z2));
        }
        PackageFragmentProviderImpl packageFragmentProviderImpl = new PackageFragmentProviderImpl(arrayList);
        NotFoundClasses notFoundClasses = new NotFoundClasses(storageManager, moduleDescriptor2);
        DeserializationConfiguration.a aVar = DeserializationConfiguration.a.a;
        DeserializedClassDataFinder deserializedClassDataFinder = new DeserializedClassDataFinder(packageFragmentProviderImpl);
        BuiltInSerializerProtocol builtInSerializerProtocol = BuiltInSerializerProtocol.m;
        AnnotationAndConstantLoaderImpl annotationAndConstantLoaderImpl = new AnnotationAndConstantLoaderImpl(moduleDescriptor2, notFoundClasses, builtInSerializerProtocol);
        LocalClassifierTypeSettings.a aVar2 = LocalClassifierTypeSettings.a.a;
        ErrorReporter errorReporter = ErrorReporter.a;
        Intrinsics3.checkNotNullExpressionValue(errorReporter, "DO_NOTHING");
        context5 context5Var = new context5(storageManager, moduleDescriptor2, aVar, deserializedClassDataFinder, annotationAndConstantLoaderImpl, packageFragmentProviderImpl, aVar2, errorReporter, LookupTracker.a.a, FlexibleTypeDeserializer.a.a, iterable, notFoundClasses, ContractDeserializer.a.getDEFAULT(), additionalClassPartsProvider, platformDependentDeclarationFilter, builtInSerializerProtocol.getExtensionRegistry(), null, new SamConversionResolverImpl(storageManager, Collections2.emptyList()), null, Opcodes.ASM5, null);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((BuiltInsPackageFragmentImpl) it.next()).initialize(context5Var);
        }
        return packageFragmentProviderImpl;
    }

    @Override // d0.e0.p.d.m0.b.BuiltInsLoader
    public PackageFragmentProvider createPackageFragmentProvider(StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2, Iterable<? extends ClassDescriptorFactory> iterable, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, AdditionalClassPartsProvider additionalClassPartsProvider, boolean z2) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "builtInsModule");
        Intrinsics3.checkNotNullParameter(iterable, "classDescriptorFactories");
        Intrinsics3.checkNotNullParameter(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        Intrinsics3.checkNotNullParameter(additionalClassPartsProvider, "additionalClassPartsProvider");
        return createBuiltInPackageFragmentProvider(storageManager, moduleDescriptor2, StandardNames.p, iterable, platformDependentDeclarationFilter, additionalClassPartsProvider, z2, new a(this.f3485b));
    }
}

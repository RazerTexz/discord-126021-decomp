package d0.e0.p.d.m0.b;

import d0.Lazy5;
import d0.LazyJVM;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.PackageFragmentProvider;
import d0.e0.p.d.m0.c.h1.AdditionalClassPartsProvider;
import d0.e0.p.d.m0.c.h1.ClassDescriptorFactory;
import d0.e0.p.d.m0.c.h1.PlatformDependentDeclarationFilter;
import d0.e0.p.d.m0.m.StorageManager;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ServiceLoader;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.a, reason: use source file name */
/* JADX INFO: compiled from: BuiltInsLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface BuiltInsLoader {
    public static final a a = a.a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.a$a */
    /* JADX INFO: compiled from: BuiltInsLoader.kt */
    public static final class a {
        public static final /* synthetic */ a a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<BuiltInsLoader> f3209b = LazyJVM.lazy(Lazy5.PUBLICATION, C0377a.j);

        /* JADX INFO: renamed from: d0.e0.p.d.m0.b.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BuiltInsLoader.kt */
        public static final class C0377a extends Lambda implements Function0<BuiltInsLoader> {
            public static final C0377a j = new C0377a();

            public C0377a() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BuiltInsLoader invoke() {
                ServiceLoader serviceLoaderLoad = ServiceLoader.load(BuiltInsLoader.class, BuiltInsLoader.class.getClassLoader());
                Intrinsics3.checkNotNullExpressionValue(serviceLoaderLoad, "implementations");
                BuiltInsLoader builtInsLoader = (BuiltInsLoader) _Collections.firstOrNull(serviceLoaderLoad);
                if (builtInsLoader != null) {
                    return builtInsLoader;
                }
                throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
            }
        }

        public final BuiltInsLoader getInstance() {
            return f3209b.getValue();
        }
    }

    PackageFragmentProvider createPackageFragmentProvider(StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2, Iterable<? extends ClassDescriptorFactory> iterable, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, AdditionalClassPartsProvider additionalClassPartsProvider, boolean z2);
}

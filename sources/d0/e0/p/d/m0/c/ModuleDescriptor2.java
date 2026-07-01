package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.c0, reason: use source file name */
/* JADX INFO: compiled from: ModuleDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ModuleDescriptor2 extends DeclarationDescriptor {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.c0$a */
    /* JADX INFO: compiled from: ModuleDescriptor.kt */
    public static final class a {
        public static <R, D> R accept(ModuleDescriptor2 moduleDescriptor2, DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "this");
            Intrinsics3.checkNotNullParameter(declarationDescriptorVisitor, "visitor");
            return declarationDescriptorVisitor.visitModuleDeclaration(moduleDescriptor2, d);
        }

        public static DeclarationDescriptor getContainingDeclaration(ModuleDescriptor2 moduleDescriptor2) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "this");
            return null;
        }
    }

    KotlinBuiltIns getBuiltIns();

    <T> T getCapability(ModuleCapability<T> moduleCapability);

    List<ModuleDescriptor2> getExpectedByModules();

    PackageViewDescriptor getPackage(FqName fqName);

    Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1);

    boolean shouldSeeInternalsOf(ModuleDescriptor2 moduleDescriptor2);
}

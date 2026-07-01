package d0.e0.p.d.m0.c.i1;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.DeclarationDescriptorVisitor;
import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.c.PackageFragmentProvider2;
import d0.e0.p.d.m0.c.PackageViewDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.k.a0.ChainedMemberScope;
import d0.e0.p.d.m0.k.a0.LazyScopeAdapter;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.m.storage7;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.s, reason: use source file name */
/* JADX INFO: compiled from: LazyPackageViewDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LazyPackageViewDescriptorImpl extends DeclarationDescriptorImpl implements PackageViewDescriptor {
    public static final /* synthetic */ KProperty<Object>[] l = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(LazyPackageViewDescriptorImpl.class), "fragments", "getFragments()Ljava/util/List;"))};
    public final ModuleDescriptorImpl3 m;
    public final FqName n;
    public final storage5 o;
    public final MemberScope3 p;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.s$a */
    /* JADX INFO: compiled from: LazyPackageViewDescriptorImpl.kt */
    public static final class a extends Lambda implements Function0<List<? extends PackageFragmentDescriptor>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends PackageFragmentDescriptor> invoke() {
            return PackageFragmentProvider2.packageFragments(LazyPackageViewDescriptorImpl.this.getModule().getPackageFragmentProvider(), LazyPackageViewDescriptorImpl.this.getFqName());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.s$b */
    /* JADX INFO: compiled from: LazyPackageViewDescriptorImpl.kt */
    public static final class b extends Lambda implements Function0<MemberScope3> {
        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MemberScope3 invoke() {
            if (LazyPackageViewDescriptorImpl.this.getFragments().isEmpty()) {
                return MemberScope3.b.f3461b;
            }
            List<PackageFragmentDescriptor> fragments = LazyPackageViewDescriptorImpl.this.getFragments();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(fragments, 10));
            Iterator<T> it = fragments.iterator();
            while (it.hasNext()) {
                arrayList.add(((PackageFragmentDescriptor) it.next()).getMemberScope());
            }
            List listPlus = _Collections.plus((Collection<? extends SubpackagesScope>) arrayList, new SubpackagesScope(LazyPackageViewDescriptorImpl.this.getModule(), LazyPackageViewDescriptorImpl.this.getFqName()));
            ChainedMemberScope.a aVar = ChainedMemberScope.f3451b;
            StringBuilder sbU = outline.U("package view scope for ");
            sbU.append(LazyPackageViewDescriptorImpl.this.getFqName());
            sbU.append(" in ");
            sbU.append(LazyPackageViewDescriptorImpl.this.getModule().getName());
            return aVar.create(sbU.toString(), listPlus);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyPackageViewDescriptorImpl(ModuleDescriptorImpl3 moduleDescriptorImpl3, FqName fqName, StorageManager storageManager) {
        super(Annotations4.f.getEMPTY(), fqName.shortNameOrSpecial());
        Intrinsics3.checkNotNullParameter(moduleDescriptorImpl3, "module");
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        this.m = moduleDescriptorImpl3;
        this.n = fqName;
        this.o = storageManager.createLazyValue(new a());
        this.p = new LazyScopeAdapter(storageManager, new b());
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        Intrinsics3.checkNotNullParameter(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitPackageViewDescriptor(this, d);
    }

    public boolean equals(Object obj) {
        PackageViewDescriptor packageViewDescriptor = obj instanceof PackageViewDescriptor ? (PackageViewDescriptor) obj : null;
        return packageViewDescriptor != null && Intrinsics3.areEqual(getFqName(), packageViewDescriptor.getFqName()) && Intrinsics3.areEqual(getModule(), packageViewDescriptor.getModule());
    }

    @Override // d0.e0.p.d.m0.c.PackageViewDescriptor
    public FqName getFqName() {
        return this.n;
    }

    @Override // d0.e0.p.d.m0.c.PackageViewDescriptor
    public List<PackageFragmentDescriptor> getFragments() {
        return (List) storage7.getValue(this.o, this, (KProperty<?>) l[0]);
    }

    @Override // d0.e0.p.d.m0.c.PackageViewDescriptor
    public MemberScope3 getMemberScope() {
        return this.p;
    }

    public int hashCode() {
        return getFqName().hashCode() + (getModule().hashCode() * 31);
    }

    @Override // d0.e0.p.d.m0.c.PackageViewDescriptor
    public boolean isEmpty() {
        return PackageViewDescriptor.a.isEmpty(this);
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    public PackageViewDescriptor getContainingDeclaration() {
        if (getFqName().isRoot()) {
            return null;
        }
        ModuleDescriptorImpl3 module = getModule();
        FqName fqNameParent = getFqName().parent();
        Intrinsics3.checkNotNullExpressionValue(fqNameParent, "fqName.parent()");
        return module.getPackage(fqNameParent);
    }

    @Override // d0.e0.p.d.m0.c.PackageViewDescriptor
    public ModuleDescriptorImpl3 getModule() {
        return this.m;
    }
}

package d0.e0.p.d.m0.b.q;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.b.BuiltInsPackageFragment;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassKind;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.h1.ClassDescriptorFactory;
import d0.e0.p.d.m0.c.i1.ClassDescriptorImpl;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.FqNameUnsafe;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.m.storage7;
import d0.t.CollectionsJVM;
import d0.t.Sets5;
import d0.t.SetsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.e, reason: use source file name */
/* JADX INFO: compiled from: JvmBuiltInClassDescriptorFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmBuiltInClassDescriptorFactory implements ClassDescriptorFactory {
    public static final b a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f3238b = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(JvmBuiltInClassDescriptorFactory.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
    public static final FqName c = StandardNames.l;
    public static final Name d;
    public static final ClassId e;
    public final ModuleDescriptor2 f;
    public final Function1<ModuleDescriptor2, DeclarationDescriptor> g;
    public final storage5 h;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.e$a */
    /* JADX INFO: compiled from: JvmBuiltInClassDescriptorFactory.kt */
    public static final class a extends Lambda implements Function1<ModuleDescriptor2, BuiltInsPackageFragment> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final BuiltInsPackageFragment invoke(ModuleDescriptor2 moduleDescriptor2) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
            List<PackageFragmentDescriptor> fragments = moduleDescriptor2.getPackage(JvmBuiltInClassDescriptorFactory.c).getFragments();
            ArrayList arrayList = new ArrayList();
            for (Object obj : fragments) {
                if (obj instanceof BuiltInsPackageFragment) {
                    arrayList.add(obj);
                }
            }
            return (BuiltInsPackageFragment) _Collections.first((List) arrayList);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.e$b */
    /* JADX INFO: compiled from: JvmBuiltInClassDescriptorFactory.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final ClassId getCLONEABLE_CLASS_ID() {
            return JvmBuiltInClassDescriptorFactory.e;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.e$c */
    /* JADX INFO: compiled from: JvmBuiltInClassDescriptorFactory.kt */
    public static final class c extends Lambda implements Function0<ClassDescriptorImpl> {
        public final /* synthetic */ StorageManager $storageManager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(StorageManager storageManager) {
            super(0);
            this.$storageManager = storageManager;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ClassDescriptorImpl invoke() {
            ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl((DeclarationDescriptor) JvmBuiltInClassDescriptorFactory.this.g.invoke(JvmBuiltInClassDescriptorFactory.this.f), JvmBuiltInClassDescriptorFactory.d, Modality.ABSTRACT, ClassKind.INTERFACE, CollectionsJVM.listOf(JvmBuiltInClassDescriptorFactory.this.f.getBuiltIns().getAnyType()), SourceElement.a, false, this.$storageManager);
            classDescriptorImpl.initialize(new CloneableClassScope(this.$storageManager, classDescriptorImpl), Sets5.emptySet(), null);
            return classDescriptorImpl;
        }
    }

    static {
        FqNameUnsafe fqNameUnsafe = StandardNames.a.d;
        Name nameShortName = fqNameUnsafe.shortName();
        Intrinsics3.checkNotNullExpressionValue(nameShortName, "cloneable.shortName()");
        d = nameShortName;
        ClassId classId = ClassId.topLevel(fqNameUnsafe.toSafe());
        Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(StandardNames.FqNames.cloneable.toSafe())");
        e = classId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JvmBuiltInClassDescriptorFactory(StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2, Function1<? super ModuleDescriptor2, ? extends DeclarationDescriptor> function1) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        Intrinsics3.checkNotNullParameter(function1, "computeContainingDeclaration");
        this.f = moduleDescriptor2;
        this.g = function1;
        this.h = storageManager.createLazyValue(new c(storageManager));
    }

    @Override // d0.e0.p.d.m0.c.h1.ClassDescriptorFactory
    public ClassDescriptor createClass(ClassId classId) {
        Intrinsics3.checkNotNullParameter(classId, "classId");
        if (Intrinsics3.areEqual(classId, a.getCLONEABLE_CLASS_ID())) {
            return (ClassDescriptorImpl) storage7.getValue(this.h, this, (KProperty<?>) f3238b[0]);
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.c.h1.ClassDescriptorFactory
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "packageFqName");
        return Intrinsics3.areEqual(fqName, c) ? SetsJVM.setOf((ClassDescriptorImpl) storage7.getValue(this.h, this, (KProperty<?>) f3238b[0])) : Sets5.emptySet();
    }

    @Override // d0.e0.p.d.m0.c.h1.ClassDescriptorFactory
    public boolean shouldCreateClass(FqName fqName, Name name) {
        Intrinsics3.checkNotNullParameter(fqName, "packageFqName");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return Intrinsics3.areEqual(name, d) && Intrinsics3.areEqual(fqName, c);
    }

    public /* synthetic */ JvmBuiltInClassDescriptorFactory(StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager, moduleDescriptor2, (i & 4) != 0 ? a.j : function1);
    }
}

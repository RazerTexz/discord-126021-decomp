package d0.e0.p.d.m0.c;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.d0._Ranges;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.ClassDescriptorBase;
import d0.e0.p.d.m0.c.i1.EmptyPackageFragmentDesciptor;
import d0.e0.p.d.m0.c.i1.TypeParameterDescriptorImpl;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.m.LockBasedStorageManager;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.m.storage3;
import d0.e0.p.d.m0.n.ClassTypeConstructorImpl;
import d0.e0.p.d.m0.n.Variance;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Iterators4;
import d0.t.Sets5;
import d0.t.SetsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.Ranges2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.d0, reason: use source file name */
/* JADX INFO: compiled from: NotFoundClasses.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NotFoundClasses {
    public final StorageManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ModuleDescriptor2 f3243b;
    public final storage3<FqName, PackageFragmentDescriptor> c;
    public final storage3<a, ClassDescriptor> d;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.d0$a */
    /* JADX INFO: compiled from: NotFoundClasses.kt */
    public static final class a {
        public final ClassId a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Integer> f3244b;

        public a(ClassId classId, List<Integer> list) {
            Intrinsics3.checkNotNullParameter(classId, "classId");
            Intrinsics3.checkNotNullParameter(list, "typeParametersCount");
            this.a = classId;
            this.f3244b = list;
        }

        public final ClassId component1() {
            return this.a;
        }

        public final List<Integer> component2() {
            return this.f3244b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics3.areEqual(this.a, aVar.a) && Intrinsics3.areEqual(this.f3244b, aVar.f3244b);
        }

        public int hashCode() {
            return this.f3244b.hashCode() + (this.a.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ClassRequest(classId=");
            sbU.append(this.a);
            sbU.append(", typeParametersCount=");
            sbU.append(this.f3244b);
            sbU.append(')');
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.d0$b */
    /* JADX INFO: compiled from: NotFoundClasses.kt */
    public static final class b extends ClassDescriptorBase {
        public final boolean r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final List<TypeParameterDescriptor> f3245s;
        public final ClassTypeConstructorImpl t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(StorageManager storageManager, DeclarationDescriptor declarationDescriptor, Name name, boolean z2, int i) {
            super(storageManager, declarationDescriptor, name, SourceElement.a, false);
            Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics3.checkNotNullParameter(declarationDescriptor, "container");
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.r = z2;
            Ranges2 ranges2Until = _Ranges.until(0, i);
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2Until, 10));
            Iterator<Integer> it = ranges2Until.iterator();
            while (it.hasNext()) {
                int iNextInt = ((Iterators4) it).nextInt();
                arrayList.add(TypeParameterDescriptorImpl.createWithDefaultBound(this, Annotations4.f.getEMPTY(), false, Variance.INVARIANT, Name.identifier(Intrinsics3.stringPlus(ExifInterface.GPS_DIRECTION_TRUE, Integer.valueOf(iNextInt))), iNextInt, storageManager));
            }
            this.f3245s = arrayList;
            this.t = new ClassTypeConstructorImpl(this, typeParameterUtils.computeConstructorTypeParameters(this), SetsJVM.setOf(DescriptorUtils2.getModule(this).getBuiltIns().getAnyType()), storageManager);
        }

        @Override // d0.e0.p.d.m0.c.g1.Annotations3
        public Annotations4 getAnnotations() {
            return Annotations4.f.getEMPTY();
        }

        @Override // d0.e0.p.d.m0.c.ClassDescriptor
        public ClassDescriptor getCompanionObjectDescriptor() {
            return null;
        }

        @Override // d0.e0.p.d.m0.c.ClassDescriptor
        public Collection<ClassConstructorDescriptor> getConstructors() {
            return Sets5.emptySet();
        }

        @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.ClassifierDescriptorWithTypeParameters
        public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
            return this.f3245s;
        }

        @Override // d0.e0.p.d.m0.c.ClassDescriptor
        public ClassKind getKind() {
            return ClassKind.CLASS;
        }

        @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.MemberDescriptor
        public Modality getModality() {
            return Modality.FINAL;
        }

        @Override // d0.e0.p.d.m0.c.ClassDescriptor
        public Collection<ClassDescriptor> getSealedSubclasses() {
            return Collections2.emptyList();
        }

        @Override // d0.e0.p.d.m0.c.i1.ModuleAwareClassDescriptor
        public MemberScope3 getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            return MemberScope3.b.f3461b;
        }

        @Override // d0.e0.p.d.m0.c.ClassDescriptor
        public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
            return null;
        }

        @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.DeclarationDescriptorWithVisibility, d0.e0.p.d.m0.c.MemberDescriptor
        public DescriptorVisibility2 getVisibility() {
            DescriptorVisibility2 descriptorVisibility2 = DescriptorVisibilities.e;
            Intrinsics3.checkNotNullExpressionValue(descriptorVisibility2, "PUBLIC");
            return descriptorVisibility2;
        }

        @Override // d0.e0.p.d.m0.c.MemberDescriptor
        public boolean isActual() {
            return false;
        }

        @Override // d0.e0.p.d.m0.c.ClassDescriptor
        public boolean isCompanionObject() {
            return false;
        }

        @Override // d0.e0.p.d.m0.c.ClassDescriptor
        public boolean isData() {
            return false;
        }

        @Override // d0.e0.p.d.m0.c.MemberDescriptor
        public boolean isExpect() {
            return false;
        }

        @Override // d0.e0.p.d.m0.c.i1.ClassDescriptorBase, d0.e0.p.d.m0.c.MemberDescriptor
        public boolean isExternal() {
            return false;
        }

        @Override // d0.e0.p.d.m0.c.ClassDescriptor
        public boolean isFun() {
            return false;
        }

        @Override // d0.e0.p.d.m0.c.ClassDescriptor
        public boolean isInline() {
            return false;
        }

        @Override // d0.e0.p.d.m0.c.ClassifierDescriptorWithTypeParameters
        public boolean isInner() {
            return this.r;
        }

        @Override // d0.e0.p.d.m0.c.ClassDescriptor
        public boolean isValue() {
            return false;
        }

        public String toString() {
            StringBuilder sbU = outline.U("class ");
            sbU.append(getName());
            sbU.append(" (not found)");
            return sbU.toString();
        }

        @Override // d0.e0.p.d.m0.c.ClassDescriptor
        public MemberScope3.b getStaticScope() {
            return MemberScope3.b.f3461b;
        }

        @Override // d0.e0.p.d.m0.c.ClassifierDescriptor
        public ClassTypeConstructorImpl getTypeConstructor() {
            return this.t;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.d0$c */
    /* JADX INFO: compiled from: NotFoundClasses.kt */
    public static final class c extends Lambda implements Function1<a, ClassDescriptor> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ClassDescriptor invoke(a aVar) {
            Intrinsics3.checkNotNullParameter(aVar, "$dstr$classId$typeParametersCount");
            ClassId classIdComponent1 = aVar.component1();
            List<Integer> listComponent2 = aVar.component2();
            if (classIdComponent1.isLocal()) {
                throw new UnsupportedOperationException(Intrinsics3.stringPlus("Unresolved local class: ", classIdComponent1));
            }
            ClassId outerClassId = classIdComponent1.getOuterClassId();
            ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor = outerClassId == null ? null : NotFoundClasses.this.getClass(outerClassId, _Collections.drop(listComponent2, 1));
            if (classOrPackageFragmentDescriptor == null) {
                storage3 storage3Var = NotFoundClasses.this.c;
                FqName packageFqName = classIdComponent1.getPackageFqName();
                Intrinsics3.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
                classOrPackageFragmentDescriptor = (ClassOrPackageFragmentDescriptor) ((LockBasedStorageManager.m) storage3Var).invoke(packageFqName);
            }
            ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor2 = classOrPackageFragmentDescriptor;
            boolean zIsNestedClass = classIdComponent1.isNestedClass();
            StorageManager storageManager = NotFoundClasses.this.a;
            Name shortClassName = classIdComponent1.getShortClassName();
            Intrinsics3.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
            Integer num = (Integer) _Collections.firstOrNull((List) listComponent2);
            return new b(storageManager, classOrPackageFragmentDescriptor2, shortClassName, zIsNestedClass, num == null ? 0 : num.intValue());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.d0$d */
    /* JADX INFO: compiled from: NotFoundClasses.kt */
    public static final class d extends Lambda implements Function1<FqName, PackageFragmentDescriptor> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final PackageFragmentDescriptor invoke(FqName fqName) {
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            return new EmptyPackageFragmentDesciptor(NotFoundClasses.this.f3243b, fqName);
        }
    }

    public NotFoundClasses(StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        this.a = storageManager;
        this.f3243b = moduleDescriptor2;
        this.c = storageManager.createMemoizedFunction(new d());
        this.d = storageManager.createMemoizedFunction(new c());
    }

    public final ClassDescriptor getClass(ClassId classId, List<Integer> list) {
        Intrinsics3.checkNotNullParameter(classId, "classId");
        Intrinsics3.checkNotNullParameter(list, "typeParametersCount");
        return (ClassDescriptor) ((LockBasedStorageManager.m) this.d).invoke(new a(classId, list));
    }
}

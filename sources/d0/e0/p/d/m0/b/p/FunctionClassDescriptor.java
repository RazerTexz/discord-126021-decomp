package d0.e0.p.d.m0.b.p;

import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.c.ClassConstructorDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassKind;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.SupertypeLoopChecker;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.findClassInModule;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.AbstractClassDescriptor;
import d0.e0.p.d.m0.c.i1.TypeParameterDescriptorImpl;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.n.AbstractClassTypeConstructor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinTypeFactory;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.TypeProjectionImpl;
import d0.e0.p.d.m0.n.Variance;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Iterators4;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.b, reason: use source file name */
/* JADX INFO: compiled from: FunctionClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FunctionClassDescriptor extends AbstractClassDescriptor {
    public static final ClassId o;
    public static final ClassId p;
    public final StorageManager q;
    public final PackageFragmentDescriptor r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final FunctionClassKind f3234s;
    public final int t;
    public final b u;
    public final FunctionClassScope v;
    public final List<TypeParameterDescriptor> w;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.b$a */
    /* JADX INFO: compiled from: FunctionClassDescriptor.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
        o = new ClassId(StandardNames.l, Name.identifier("Function"));
        p = new ClassId(StandardNames.i, Name.identifier("KFunction"));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunctionClassDescriptor(StorageManager storageManager, PackageFragmentDescriptor packageFragmentDescriptor, FunctionClassKind functionClassKind, int i) {
        super(storageManager, functionClassKind.numberedClassName(i));
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(packageFragmentDescriptor, "containingDeclaration");
        Intrinsics3.checkNotNullParameter(functionClassKind, "functionKind");
        this.q = storageManager;
        this.r = packageFragmentDescriptor;
        this.f3234s = functionClassKind;
        this.t = i;
        this.u = new b(this);
        this.v = new FunctionClassScope(storageManager, this);
        ArrayList arrayList = new ArrayList();
        Ranges2 ranges2 = new Ranges2(1, i);
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2, 10));
        Iterator<Integer> it = ranges2.iterator();
        while (it.hasNext()) {
            b(arrayList, this, Variance.IN_VARIANCE, Intrinsics3.stringPlus("P", Integer.valueOf(((Iterators4) it).nextInt())));
            arrayList2.add(Unit.a);
        }
        b(arrayList, this, Variance.OUT_VARIANCE, "R");
        this.w = _Collections.toList(arrayList);
    }

    public static final void b(ArrayList<TypeParameterDescriptor> arrayList, FunctionClassDescriptor functionClassDescriptor, Variance variance, String str) {
        arrayList.add(TypeParameterDescriptorImpl.createWithDefaultBound(functionClassDescriptor, Annotations4.f.getEMPTY(), false, variance, Name.identifier(str), arrayList.size(), functionClassDescriptor.q));
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations3
    public Annotations4 getAnnotations() {
        return Annotations4.f.getEMPTY();
    }

    public final int getArity() {
        return this.t;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public /* bridge */ /* synthetic */ ClassDescriptor getCompanionObjectDescriptor() {
        return (ClassDescriptor) m82getCompanionObjectDescriptor();
    }

    /* JADX INFO: renamed from: getCompanionObjectDescriptor, reason: collision with other method in class */
    public Void m82getCompanionObjectDescriptor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.w;
    }

    public final FunctionClassKind getFunctionKind() {
        return this.f3234s;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public ClassKind getKind() {
        return ClassKind.INTERFACE;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.MemberDescriptor
    public Modality getModality() {
        return Modality.ABSTRACT;
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.a;
        Intrinsics3.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        return sourceElement;
    }

    @Override // d0.e0.p.d.m0.c.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.u;
    }

    @Override // d0.e0.p.d.m0.c.i1.ModuleAwareClassDescriptor
    public MemberScope3 getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.v;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public /* bridge */ /* synthetic */ ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return (ClassConstructorDescriptor) m83getUnsubstitutedPrimaryConstructor();
    }

    /* JADX INFO: renamed from: getUnsubstitutedPrimaryConstructor, reason: collision with other method in class */
    public Void m83getUnsubstitutedPrimaryConstructor() {
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

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
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
        return false;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public boolean isValue() {
        return false;
    }

    public String toString() {
        String strAsString = getName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "name.asString()");
        return strAsString;
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.b$b */
    /* JADX INFO: compiled from: FunctionClassDescriptor.kt */
    public final class b extends AbstractClassTypeConstructor {
        public final /* synthetic */ FunctionClassDescriptor c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FunctionClassDescriptor functionClassDescriptor) {
            super(functionClassDescriptor.q);
            Intrinsics3.checkNotNullParameter(functionClassDescriptor, "this$0");
            this.c = functionClassDescriptor;
        }

        @Override // d0.e0.p.d.m0.n.AbstractTypeConstructor
        public Collection<KotlinType> a() {
            List<ClassId> listListOf;
            int iOrdinal = this.c.getFunctionKind().ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                listListOf = CollectionsJVM.listOf(FunctionClassDescriptor.o);
            } else if (iOrdinal == 2) {
                listListOf = Collections2.listOf((Object[]) new ClassId[]{FunctionClassDescriptor.p, new ClassId(StandardNames.l, FunctionClassKind.k.numberedClassName(this.c.getArity()))});
            } else {
                if (iOrdinal != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                listListOf = Collections2.listOf((Object[]) new ClassId[]{FunctionClassDescriptor.p, new ClassId(StandardNames.d, FunctionClassKind.l.numberedClassName(this.c.getArity()))});
            }
            ModuleDescriptor2 containingDeclaration = this.c.r.getContainingDeclaration();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listListOf, 10));
            for (ClassId classId : listListOf) {
                ClassDescriptor classDescriptorFindClassAcrossModuleDependencies = findClassInModule.findClassAcrossModuleDependencies(containingDeclaration, classId);
                if (classDescriptorFindClassAcrossModuleDependencies == null) {
                    throw new IllegalStateException(("Built-in class " + classId + " not found").toString());
                }
                List listTakeLast = _Collections.takeLast(getParameters(), classDescriptorFindClassAcrossModuleDependencies.getTypeConstructor().getParameters().size());
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(listTakeLast, 10));
                Iterator it = listTakeLast.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new TypeProjectionImpl(((TypeParameterDescriptor) it.next()).getDefaultType()));
                }
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
                arrayList.add(KotlinTypeFactory.simpleNotNullType(Annotations4.f.getEMPTY(), classDescriptorFindClassAcrossModuleDependencies, arrayList2));
            }
            return _Collections.toList(arrayList);
        }

        @Override // d0.e0.p.d.m0.n.AbstractTypeConstructor
        public SupertypeLoopChecker d() {
            return SupertypeLoopChecker.a.a;
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            return this.c.w;
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        public String toString() {
            return getDeclarationDescriptor().toString();
        }

        @Override // d0.e0.p.d.m0.n.AbstractTypeConstructor, d0.e0.p.d.m0.n.TypeConstructor
        public FunctionClassDescriptor getDeclarationDescriptor() {
            return this.c;
        }
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public List<ClassConstructorDescriptor> getConstructors() {
        return Collections2.emptyList();
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.DeclarationDescriptorNonRoot, d0.e0.p.d.m0.c.DeclarationDescriptor
    public PackageFragmentDescriptor getContainingDeclaration() {
        return this.r;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public List<ClassDescriptor> getSealedSubclasses() {
        return Collections2.emptyList();
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public MemberScope3.b getStaticScope() {
        return MemberScope3.b.f3461b;
    }
}

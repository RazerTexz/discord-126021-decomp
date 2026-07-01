package d0.e0.p.d.m0.e.a.i0.l;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.d.b.LookupLocation2;
import d0.e0.p.d.m0.e.a.JavaClassFinder;
import d0.e0.p.d.m0.e.a.i0.context4;
import d0.e0.p.d.m0.e.a.i0.l.DeclaredMemberIndex2;
import d0.e0.p.d.m0.e.a.k0.c0;
import d0.e0.p.d.m0.e.a.k0.u;
import d0.e0.p.d.m0.e.b.KotlinClassFinder;
import d0.e0.p.d.m0.e.b.KotlinClassFinder2;
import d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass;
import d0.e0.p.d.m0.e.b.b0.KotlinClassHeader;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.g.SpecialNames;
import d0.e0.p.d.m0.k.a0.MemberScope2;
import d0.e0.p.d.m0.m.storage4;
import d0.e0.p.d.m0.m.storage6;
import d0.e0.p.d.m0.p.functions;
import d0.t.Collections2;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.j, reason: use source file name */
/* JADX INFO: compiled from: LazyJavaPackageScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaPackageScope extends LazyJavaStaticScope {
    public final u n;
    public final LazyJavaPackageFragment o;
    public final storage6<Set<String>> p;
    public final storage4<a, ClassDescriptor> q;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.j$a */
    /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
    public static final class a {
        public final Name a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d0.e0.p.d.m0.e.a.k0.g f3334b;

        public a(Name name, d0.e0.p.d.m0.e.a.k0.g gVar) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.a = name;
            this.f3334b = gVar;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && Intrinsics3.areEqual(this.a, ((a) obj).a);
        }

        public final d0.e0.p.d.m0.e.a.k0.g getJavaClass() {
            return this.f3334b;
        }

        public final Name getName() {
            return this.a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.j$b */
    /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
    public static abstract class b {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.j$b$a */
        /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
        public static final class a extends b {
            public final ClassDescriptor a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ClassDescriptor classDescriptor) {
                super(null);
                Intrinsics3.checkNotNullParameter(classDescriptor, "descriptor");
                this.a = classDescriptor;
            }

            public final ClassDescriptor getDescriptor() {
                return this.a;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.j$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
        public static final class C0384b extends b {
            public static final C0384b a = new C0384b();

            public C0384b() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.j$b$c */
        /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
        public static final class c extends b {
            public static final c a = new c();

            public c() {
                super(null);
            }
        }

        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.j$c */
    /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
    public static final class c extends Lambda implements Function1<a, ClassDescriptor> {
        public final /* synthetic */ context4 $c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(context4 context4Var) {
            super(1);
            this.$c = context4Var;
        }

        /* JADX WARN: Code duplicated, block: B:31:0x0091  */
        @Override // kotlin.jvm.functions.Function1
        public final ClassDescriptor invoke(a aVar) {
            byte[] content;
            Intrinsics3.checkNotNullParameter(aVar, "request");
            ClassId classId = new ClassId(LazyJavaPackageScope.this.o.getFqName(), aVar.getName());
            KotlinClassFinder.a aVarFindKotlinClassOrContent = aVar.getJavaClass() != null ? this.$c.getComponents().getKotlinClassFinder().findKotlinClassOrContent(aVar.getJavaClass()) : this.$c.getComponents().getKotlinClassFinder().findKotlinClassOrContent(classId);
            KotlinJvmBinaryClass kotlinJvmBinaryClass = aVarFindKotlinClassOrContent == null ? null : aVarFindKotlinClassOrContent.toKotlinJvmBinaryClass();
            ClassId classId2 = kotlinJvmBinaryClass == null ? null : kotlinJvmBinaryClass.getClassId();
            if (classId2 != null && (classId2.isNestedClass() || classId2.isLocal())) {
                return null;
            }
            b bVarAccess$resolveKotlinBinaryClass = LazyJavaPackageScope.access$resolveKotlinBinaryClass(LazyJavaPackageScope.this, kotlinJvmBinaryClass);
            if (bVarAccess$resolveKotlinBinaryClass instanceof b.a) {
                return ((b.a) bVarAccess$resolveKotlinBinaryClass).getDescriptor();
            }
            if (bVarAccess$resolveKotlinBinaryClass instanceof b.c) {
                return null;
            }
            if (!(bVarAccess$resolveKotlinBinaryClass instanceof b.C0384b)) {
                throw new NoWhenBranchMatchedException();
            }
            d0.e0.p.d.m0.e.a.k0.g javaClass = aVar.getJavaClass();
            if (javaClass == null) {
                JavaClassFinder finder = this.$c.getComponents().getFinder();
                if (aVarFindKotlinClassOrContent != null) {
                    if (!(aVarFindKotlinClassOrContent instanceof KotlinClassFinder.a.C0390a)) {
                        aVarFindKotlinClassOrContent = null;
                    }
                    KotlinClassFinder.a.C0390a c0390a = (KotlinClassFinder.a.C0390a) aVarFindKotlinClassOrContent;
                    if (c0390a == null) {
                        content = null;
                    } else {
                        content = c0390a.getContent();
                    }
                } else {
                    content = null;
                }
                javaClass = finder.findClass(new JavaClassFinder.a(classId, content, null, 4, null));
            }
            d0.e0.p.d.m0.e.a.k0.g gVar = javaClass;
            if ((gVar == null ? null : gVar.getLightClassOriginKind()) != c0.BINARY) {
                FqName fqName = gVar == null ? null : gVar.getFqName();
                if (fqName == null || fqName.isRoot() || !Intrinsics3.areEqual(fqName.parent(), LazyJavaPackageScope.this.o.getFqName())) {
                    return null;
                }
                LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(this.$c, LazyJavaPackageScope.this.o, gVar, null, 8, null);
                this.$c.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor);
                return lazyJavaClassDescriptor;
            }
            throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + gVar + "\nClassId: " + classId + "\nfindKotlinClass(JavaClass) = " + KotlinClassFinder2.findKotlinClass(this.$c.getComponents().getKotlinClassFinder(), gVar) + "\nfindKotlinClass(ClassId) = " + KotlinClassFinder2.findKotlinClass(this.$c.getComponents().getKotlinClassFinder(), classId) + '\n');
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.j$d */
    /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
    public static final class d extends Lambda implements Function0<Set<? extends String>> {
        public final /* synthetic */ context4 $c;
        public final /* synthetic */ LazyJavaPackageScope this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(context4 context4Var, LazyJavaPackageScope lazyJavaPackageScope) {
            super(0);
            this.$c = context4Var;
            this.this$0 = lazyJavaPackageScope;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends String> invoke() {
            return this.$c.getComponents().getFinder().knownClassNamesInPackage(this.this$0.o.getFqName());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageScope(context4 context4Var, u uVar, LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(context4Var);
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        Intrinsics3.checkNotNullParameter(uVar, "jPackage");
        Intrinsics3.checkNotNullParameter(lazyJavaPackageFragment, "ownerDescriptor");
        this.n = uVar;
        this.o = lazyJavaPackageFragment;
        this.p = context4Var.getStorageManager().createNullableLazyValue(new d(context4Var, this));
        this.q = context4Var.getStorageManager().createMemoizedFunctionWithNullableValues(new c(context4Var));
    }

    public static final b access$resolveKotlinBinaryClass(LazyJavaPackageScope lazyJavaPackageScope, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Objects.requireNonNull(lazyJavaPackageScope);
        if (kotlinJvmBinaryClass == null) {
            return b.C0384b.a;
        }
        if (kotlinJvmBinaryClass.getClassHeader().getKind() != KotlinClassHeader.a.CLASS) {
            return b.c.a;
        }
        ClassDescriptor classDescriptorResolveClass = lazyJavaPackageScope.c.getComponents().getDeserializedDescriptorResolver().resolveClass(kotlinJvmBinaryClass);
        return classDescriptorResolveClass != null ? new b.a(classDescriptorResolveClass) : b.C0384b.a;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public Set<Name> a(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        if (!memberScope2.acceptsKinds(MemberScope2.a.getNON_SINGLETON_CLASSIFIERS_MASK())) {
            return Sets5.emptySet();
        }
        Set<String> setInvoke = this.p.invoke();
        if (setInvoke != null) {
            HashSet hashSet = new HashSet();
            Iterator<T> it = setInvoke.iterator();
            while (it.hasNext()) {
                hashSet.add(Name.identifier((String) it.next()));
            }
            return hashSet;
        }
        u uVar = this.n;
        if (function1 == null) {
            function1 = functions.alwaysTrue();
        }
        Collection<d0.e0.p.d.m0.e.a.k0.g> classes = uVar.getClasses(function1);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (d0.e0.p.d.m0.e.a.k0.g gVar : classes) {
            Name name = gVar.getLightClassOriginKind() == c0.SOURCE ? null : gVar.getName();
            if (name != null) {
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public Set<Name> b(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        return Sets5.emptySet();
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public DeclaredMemberIndex2 d() {
        return DeclaredMemberIndex2.a.a;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public void f(Collection<SimpleFunctionDescriptor> collection, Name name) {
        Intrinsics3.checkNotNullParameter(collection, "result");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
    }

    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(d0.e0.p.d.m0.e.a.k0.g gVar) {
        Intrinsics3.checkNotNullParameter(gVar, "javaClass");
        return o(gVar.getName(), gVar);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x005b  */
    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope, d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        MemberScope2.a aVar = MemberScope2.a;
        if (!memberScope2.acceptsKinds(aVar.getNON_SINGLETON_CLASSIFIERS_MASK() | aVar.getCLASSIFIERS_MASK())) {
            return Collections2.emptyList();
        }
        Collection<DeclarationDescriptor> collectionInvoke = this.e.invoke();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionInvoke) {
            DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) obj;
            if (declarationDescriptor instanceof ClassDescriptor) {
                Name name = ((ClassDescriptor) declarationDescriptor).getName();
                Intrinsics3.checkNotNullExpressionValue(name, "it.name");
                if (function1.invoke(name).booleanValue()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            if (z2) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope, d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return Collections2.emptyList();
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public Set<Name> h(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        return Sets5.emptySet();
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public DeclarationDescriptor j() {
        return this.o;
    }

    public final ClassDescriptor o(Name name, d0.e0.p.d.m0.e.a.k0.g gVar) {
        if (!SpecialNames.isSafeIdentifier(name)) {
            return null;
        }
        Set<String> setInvoke = this.p.invoke();
        if (gVar != null || setInvoke == null || setInvoke.contains(name.asString())) {
            return this.q.invoke(new a(name, gVar));
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.ResolutionScope
    public ClassDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return o(name, null);
    }
}

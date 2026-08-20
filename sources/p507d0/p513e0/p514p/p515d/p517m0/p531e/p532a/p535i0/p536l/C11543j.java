package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import com.discord.models.domain.ModelAuditLogEntry;
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
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11480b;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.InterfaceC11625s;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.C11529g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.EnumC11569c0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11588u;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11654o;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11653n;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0.C11636a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11718g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.C11765d;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11899i;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11901k;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12036d;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.j */
/* JADX INFO: compiled from: LazyJavaPackageScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11543j extends AbstractC11551r {

    /* JADX INFO: renamed from: n */
    public final InterfaceC11588u f23377n;

    /* JADX INFO: renamed from: o */
    public final C11542i f23378o;

    /* JADX INFO: renamed from: p */
    public final InterfaceC11901k<Set<String>> f23379p;

    /* JADX INFO: renamed from: q */
    public final InterfaceC11899i<a, InterfaceC11330e> f23380q;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.j$a */
    /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final C11716e f23381a;

        /* JADX INFO: renamed from: b */
        public final InterfaceC11574g f23382b;

        public a(C11716e c11716e, InterfaceC11574g interfaceC11574g) {
            C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.f23381a = c11716e;
            this.f23382b = interfaceC11574g;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && C12238m.areEqual(this.f23381a, ((a) obj).f23381a);
        }

        public final InterfaceC11574g getJavaClass() {
            return this.f23382b;
        }

        public final C11716e getName() {
            return this.f23381a;
        }

        public int hashCode() {
            return this.f23381a.hashCode();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.j$b */
    /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
    public static abstract class b {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.j$b$a */
        /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
        public static final class a extends b {

            /* JADX INFO: renamed from: a */
            public final InterfaceC11330e f23383a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(InterfaceC11330e interfaceC11330e) {
                super(null);
                C12238m.checkNotNullParameter(interfaceC11330e, "descriptor");
                this.f23383a = interfaceC11330e;
            }

            public final InterfaceC11330e getDescriptor() {
                return this.f23383a;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.j$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
        public static final class C13311b extends b {

            /* JADX INFO: renamed from: a */
            public static final C13311b f23384a = new C13311b();

            public C13311b() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.j$b$c */
        /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
        public static final class c extends b {

            /* JADX INFO: renamed from: a */
            public static final c f23385a = new c();

            public c() {
                super(null);
            }
        }

        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.j$c */
    /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
    public static final class c extends AbstractC12240o implements Function1<a, InterfaceC11330e> {

        /* JADX INFO: renamed from: $c */
        public final /* synthetic */ C11529g f23386$c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(C11529g c11529g) {
            super(1);
            this.f23386$c = c11529g;
        }

        /* JADX WARN: Code duplicated, block: B:31:0x0091  */
        @Override // kotlin.jvm.functions.Function1
        public final InterfaceC11330e invoke(a aVar) {
            byte[] content;
            C12238m.checkNotNullParameter(aVar, "request");
            C11712a c11712a = new C11712a(C11543j.this.f23378o.getFqName(), aVar.getName());
            InterfaceC11653n.a aVarFindKotlinClassOrContent = aVar.getJavaClass() != null ? this.f23386$c.getComponents().getKotlinClassFinder().findKotlinClassOrContent(aVar.getJavaClass()) : this.f23386$c.getComponents().getKotlinClassFinder().findKotlinClassOrContent(c11712a);
            InterfaceC11655p kotlinJvmBinaryClass = aVarFindKotlinClassOrContent == null ? null : aVarFindKotlinClassOrContent.toKotlinJvmBinaryClass();
            C11712a classId = kotlinJvmBinaryClass == null ? null : kotlinJvmBinaryClass.getClassId();
            if (classId != null && (classId.isNestedClass() || classId.isLocal())) {
                return null;
            }
            b bVarAccess$resolveKotlinBinaryClass = C11543j.access$resolveKotlinBinaryClass(C11543j.this, kotlinJvmBinaryClass);
            if (bVarAccess$resolveKotlinBinaryClass instanceof b.a) {
                return ((b.a) bVarAccess$resolveKotlinBinaryClass).getDescriptor();
            }
            if (bVarAccess$resolveKotlinBinaryClass instanceof b.c) {
                return null;
            }
            if (!(bVarAccess$resolveKotlinBinaryClass instanceof b.C13311b)) {
                throw new NoWhenBranchMatchedException();
            }
            InterfaceC11574g javaClass = aVar.getJavaClass();
            if (javaClass == null) {
                InterfaceC11625s finder = this.f23386$c.getComponents().getFinder();
                if (aVarFindKotlinClassOrContent != null) {
                    if (!(aVarFindKotlinClassOrContent instanceof InterfaceC11653n.a.C13316a)) {
                        aVarFindKotlinClassOrContent = null;
                    }
                    InterfaceC11653n.a.C13316a c13316a = (InterfaceC11653n.a.C13316a) aVarFindKotlinClassOrContent;
                    if (c13316a == null) {
                        content = null;
                    } else {
                        content = c13316a.getContent();
                    }
                } else {
                    content = null;
                }
                javaClass = finder.findClass(new InterfaceC11625s.a(c11712a, content, null, 4, null));
            }
            InterfaceC11574g interfaceC11574g = javaClass;
            if ((interfaceC11574g == null ? null : interfaceC11574g.getLightClassOriginKind()) != EnumC11569c0.BINARY) {
                C11713b fqName = interfaceC11574g == null ? null : interfaceC11574g.getFqName();
                if (fqName == null || fqName.isRoot() || !C12238m.areEqual(fqName.parent(), C11543j.this.f23378o.getFqName())) {
                    return null;
                }
                C11539f c11539f = new C11539f(this.f23386$c, C11543j.this.f23378o, interfaceC11574g, null, 8, null);
                this.f23386$c.getComponents().getJavaClassesTracker().reportClass(c11539f);
                return c11539f;
            }
            throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + interfaceC11574g + "\nClassId: " + c11712a + "\nfindKotlinClass(JavaClass) = " + C11654o.findKotlinClass(this.f23386$c.getComponents().getKotlinClassFinder(), interfaceC11574g) + "\nfindKotlinClass(ClassId) = " + C11654o.findKotlinClass(this.f23386$c.getComponents().getKotlinClassFinder(), c11712a) + '\n');
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.j$d */
    /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
    public static final class d extends AbstractC12240o implements Function0<Set<? extends String>> {

        /* JADX INFO: renamed from: $c */
        public final /* synthetic */ C11529g f23387$c;
        public final /* synthetic */ C11543j this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(C11529g c11529g, C11543j c11543j) {
            super(0);
            this.f23387$c = c11529g;
            this.this$0 = c11543j;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends String> invoke() {
            return this.f23387$c.getComponents().getFinder().knownClassNamesInPackage(this.this$0.f23378o.getFqName());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11543j(C11529g c11529g, InterfaceC11588u interfaceC11588u, C11542i c11542i) {
        super(c11529g);
        C12238m.checkNotNullParameter(c11529g, "c");
        C12238m.checkNotNullParameter(interfaceC11588u, "jPackage");
        C12238m.checkNotNullParameter(c11542i, "ownerDescriptor");
        this.f23377n = interfaceC11588u;
        this.f23378o = c11542i;
        this.f23379p = c11529g.getStorageManager().createNullableLazyValue(new d(c11529g, this));
        this.f23380q = c11529g.getStorageManager().createMemoizedFunctionWithNullableValues(new c(c11529g));
    }

    public static final b access$resolveKotlinBinaryClass(C11543j c11543j, InterfaceC11655p interfaceC11655p) {
        Objects.requireNonNull(c11543j);
        if (interfaceC11655p == null) {
            return b.C13311b.f23384a;
        }
        if (interfaceC11655p.getClassHeader().getKind() != C11636a.a.CLASS) {
            return b.c.f23385a;
        }
        InterfaceC11330e interfaceC11330eResolveClass = c11543j.f23389c.getComponents().getDeserializedDescriptorResolver().resolveClass(interfaceC11655p);
        return interfaceC11330eResolveClass != null ? new b.a(interfaceC11330eResolveClass) : b.C13311b.f23384a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.AbstractC11544k
    /* JADX INFO: renamed from: a */
    public Set<C11716e> mo9470a(C11765d c11765d, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(c11765d, "kindFilter");
        if (!c11765d.acceptsKinds(C11765d.f24339a.getNON_SINGLETON_CLASSIFIERS_MASK())) {
            return C12148n0.emptySet();
        }
        Set<String> setInvoke = this.f23379p.invoke();
        if (setInvoke != null) {
            HashSet hashSet = new HashSet();
            Iterator<T> it = setInvoke.iterator();
            while (it.hasNext()) {
                hashSet.add(C11716e.identifier((String) it.next()));
            }
            return hashSet;
        }
        InterfaceC11588u interfaceC11588u = this.f23377n;
        if (function1 == null) {
            function1 = C12036d.alwaysTrue();
        }
        Collection<InterfaceC11574g> classes = interfaceC11588u.getClasses(function1);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (InterfaceC11574g interfaceC11574g : classes) {
            C11716e name = interfaceC11574g.getLightClassOriginKind() == EnumC11569c0.SOURCE ? null : interfaceC11574g.getName();
            if (name != null) {
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.AbstractC11544k
    /* JADX INFO: renamed from: b */
    public Set<C11716e> mo9471b(C11765d c11765d, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(c11765d, "kindFilter");
        return C12148n0.emptySet();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.AbstractC11544k
    /* JADX INFO: renamed from: d */
    public InterfaceC11535b mo9473d() {
        return InterfaceC11535b.a.f23328a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.AbstractC11544k
    /* JADX INFO: renamed from: f */
    public void mo9474f(Collection<InterfaceC11465t0> collection, C11716e c11716e) {
        C12238m.checkNotNullParameter(collection, "result");
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
    }

    public final InterfaceC11330e findClassifierByJavaClass$descriptors_jvm(InterfaceC11574g interfaceC11574g) {
        C12238m.checkNotNullParameter(interfaceC11574g, "javaClass");
        return m9493o(interfaceC11574g.getName(), interfaceC11574g);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x005b  */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.AbstractC11544k, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public Collection<InterfaceC11450m> getContributedDescriptors(C11765d c11765d, Function1<? super C11716e, Boolean> function1) {
        boolean z2;
        C12238m.checkNotNullParameter(c11765d, "kindFilter");
        C12238m.checkNotNullParameter(function1, "nameFilter");
        C11765d.a aVar = C11765d.f24339a;
        if (!c11765d.acceptsKinds(aVar.getNON_SINGLETON_CLASSIFIERS_MASK() | aVar.getCLASSIFIERS_MASK())) {
            return C12147n.emptyList();
        }
        Collection<InterfaceC11450m> collectionInvoke = this.f23391e.invoke();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionInvoke) {
            InterfaceC11450m interfaceC11450m = (InterfaceC11450m) obj;
            if (interfaceC11450m instanceof InterfaceC11330e) {
                C11716e name = ((InterfaceC11330e) interfaceC11450m).getName();
                C12238m.checkNotNullExpressionValue(name, "it.name");
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

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.AbstractC11544k, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Collection<InterfaceC11453n0> getContributedVariables(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return C12147n.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.AbstractC11544k
    /* JADX INFO: renamed from: h */
    public Set<C11716e> mo9476h(C11765d c11765d, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(c11765d, "kindFilter");
        return C12148n0.emptySet();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.AbstractC11544k
    /* JADX INFO: renamed from: j */
    public InterfaceC11450m mo9478j() {
        return this.f23378o;
    }

    /* JADX INFO: renamed from: o */
    public final InterfaceC11330e m9493o(C11716e c11716e, InterfaceC11574g interfaceC11574g) {
        if (!C11718g.isSafeIdentifier(c11716e)) {
            return null;
        }
        Set<String> setInvoke = this.f23379p.invoke();
        if (interfaceC11574g != null || setInvoke == null || setInvoke.contains(c11716e.asString())) {
            return this.f23380q.invoke(new a(c11716e, interfaceC11574g));
        }
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public InterfaceC11330e getContributedClassifier(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return m9493o(c11716e, null);
    }
}

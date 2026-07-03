package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import p507d0.C12116o;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11362a0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.C11523a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.C11527e;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.C11529g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11588u;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11654o;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11656q;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11661v;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0.C11636a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.C11839c;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11904n;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11900j;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12250y;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.i */
/* JADX INFO: compiled from: LazyJavaPackageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11542i extends AbstractC11362a0 {

    /* JADX INFO: renamed from: o */
    public static final /* synthetic */ KProperty<Object>[] f23370o = {C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11542i.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11542i.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};

    /* JADX INFO: renamed from: p */
    public final InterfaceC11588u f23371p;

    /* JADX INFO: renamed from: q */
    public final C11529g f23372q;

    /* JADX INFO: renamed from: r */
    public final InterfaceC11900j f23373r;

    /* JADX INFO: renamed from: s */
    public final C11537d f23374s;

    /* JADX INFO: renamed from: t */
    public final InterfaceC11900j<List<C11713b>> f23375t;

    /* JADX INFO: renamed from: u */
    public final InterfaceC11344g f23376u;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.i$a */
    /* JADX INFO: compiled from: LazyJavaPackageFragment.kt */
    public static final class a extends AbstractC12240o implements Function0<Map<String, ? extends InterfaceC11655p>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<String, ? extends InterfaceC11655p> invoke() {
            InterfaceC11661v packagePartProvider = C11542i.this.f23372q.getComponents().getPackagePartProvider();
            String strAsString = C11542i.this.getFqName().asString();
            C12238m.checkNotNullExpressionValue(strAsString, "fqName.asString()");
            List<String> listFindPackageParts = packagePartProvider.findPackageParts(strAsString);
            C11542i c11542i = C11542i.this;
            ArrayList arrayList = new ArrayList();
            for (String str : listFindPackageParts) {
                C11712a c11712a = C11712a.topLevel(C11839c.byInternalName(str).getFqNameForTopLevelClassMaybeWithDollars());
                C12238m.checkNotNullExpressionValue(c11712a, "topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)");
                InterfaceC11655p interfaceC11655pFindKotlinClass = C11654o.findKotlinClass(c11542i.f23372q.getComponents().getKotlinClassFinder(), c11712a);
                Pair pairM10073to = interfaceC11655pFindKotlinClass == null ? null : C12116o.m10073to(str, interfaceC11655pFindKotlinClass);
                if (pairM10073to != null) {
                    arrayList.add(pairM10073to);
                }
            }
            return C12136h0.toMap(arrayList);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.i$b */
    /* JADX INFO: compiled from: LazyJavaPackageFragment.kt */
    public static final class b extends AbstractC12240o implements Function0<HashMap<C11839c, C11839c>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final HashMap<C11839c, C11839c> invoke() {
            String multifileClassName;
            HashMap<C11839c, C11839c> map = new HashMap<>();
            for (Map.Entry<String, InterfaceC11655p> entry : C11542i.this.getBinaryClasses$descriptors_jvm().entrySet()) {
                String key = entry.getKey();
                InterfaceC11655p value = entry.getValue();
                C11839c c11839cByInternalName = C11839c.byInternalName(key);
                C12238m.checkNotNullExpressionValue(c11839cByInternalName, "byInternalName(partInternalName)");
                C11636a classHeader = value.getClassHeader();
                int iOrdinal = classHeader.getKind().ordinal();
                if (iOrdinal == 2) {
                    map.put(c11839cByInternalName, c11839cByInternalName);
                } else if (iOrdinal == 5 && (multifileClassName = classHeader.getMultifileClassName()) != null) {
                    C11839c c11839cByInternalName2 = C11839c.byInternalName(multifileClassName);
                    C12238m.checkNotNullExpressionValue(c11839cByInternalName2, "byInternalName(header.multifileClassName ?: continue@kotlinClasses)");
                    map.put(c11839cByInternalName, c11839cByInternalName2);
                }
            }
            return map;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.i$c */
    /* JADX INFO: compiled from: LazyJavaPackageFragment.kt */
    public static final class c extends AbstractC12240o implements Function0<List<? extends C11713b>> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends C11713b> invoke() {
            Collection<InterfaceC11588u> subPackages = C11542i.this.f23371p.getSubPackages();
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(subPackages, 10));
            Iterator<T> it = subPackages.iterator();
            while (it.hasNext()) {
                arrayList.add(((InterfaceC11588u) it.next()).getFqName());
            }
            return arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11542i(C11529g c11529g, InterfaceC11588u interfaceC11588u) {
        super(c11529g.getModule(), interfaceC11588u.getFqName());
        C12238m.checkNotNullParameter(c11529g, "outerContext");
        C12238m.checkNotNullParameter(interfaceC11588u, "jPackage");
        this.f23371p = interfaceC11588u;
        C11529g c11529gChildForClassOrPackage$default = C11523a.childForClassOrPackage$default(c11529g, this, null, 0, 6, null);
        this.f23372q = c11529gChildForClassOrPackage$default;
        this.f23373r = c11529gChildForClassOrPackage$default.getStorageManager().createLazyValue(new a());
        this.f23374s = new C11537d(c11529gChildForClassOrPackage$default, interfaceC11588u, this);
        this.f23375t = c11529gChildForClassOrPackage$default.getStorageManager().createRecursionTolerantLazyValue(new c(), C12147n.emptyList());
        this.f23376u = c11529gChildForClassOrPackage$default.getComponents().getJavaTypeEnhancementState().getDisabledDefaultAnnotations() ? InterfaceC11344g.f22735f.getEMPTY() : C11527e.resolveAnnotations(c11529gChildForClassOrPackage$default, interfaceC11588u);
        c11529gChildForClassOrPackage$default.getStorageManager().createLazyValue(new b());
    }

    public final InterfaceC11330e findClassifierByJavaClass$descriptors_jvm(InterfaceC11574g interfaceC11574g) {
        C12238m.checkNotNullParameter(interfaceC11574g, "jClass");
        return this.f23374s.getJavaScope$descriptors_jvm().findClassifierByJavaClass$descriptors_jvm(interfaceC11574g);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.C11339b, p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11338a
    public InterfaceC11344g getAnnotations() {
        return this.f23376u;
    }

    public final Map<String, InterfaceC11655p> getBinaryClasses$descriptors_jvm() {
        return (Map) C11904n.getValue(this.f23373r, this, (KProperty<?>) f23370o[0]);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11362a0, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11383l, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11456p
    public InterfaceC11467u0 getSource() {
        return new C11656q(this);
    }

    public final List<C11713b> getSubPackageFqNames$descriptors_jvm() {
        return this.f23375t.invoke();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11362a0, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11381k
    public String toString() {
        return C12238m.stringPlus("Lazy Java package fragment: ", getFqName());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0
    public C11537d getMemberScope() {
        return this.f23374s;
    }
}

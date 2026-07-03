package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.C11306f;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.C11315o;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11328d0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11360i0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11379j;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11399y;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.InterfaceC11504g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.C11528f;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.C11532j;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11644e;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11645f;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11661v;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.C11838b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p561z.C11842b;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11874j;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11875k;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11896f;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11952l;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.k */
/* JADX INFO: compiled from: RuntimeModuleData.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11418k {

    /* JADX INFO: renamed from: a */
    public static final a f23022a = new a(null);

    /* JADX INFO: renamed from: b */
    public final C11874j f23023b;

    /* JADX INFO: renamed from: c */
    public final C11408a f23024c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.k$a */
    /* JADX INFO: compiled from: RuntimeModuleData.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final C11418k create(ClassLoader classLoader) {
            C12238m.checkNotNullParameter(classLoader, "classLoader");
            C11896f c11896f = new C11896f("RuntimeModuleData");
            C11306f c11306f = new C11306f(c11896f, C11306f.a.FROM_DEPENDENCIES);
            C11716e c11716eSpecial = C11716e.special("<runtime module for " + classLoader + '>');
            C12238m.checkNotNullExpressionValue(c11716eSpecial, "special(\"<runtime module for $classLoader>\")");
            C11399y c11399y = new C11399y(c11716eSpecial, c11896f, c11306f, null, null, null, 56, null);
            c11306f.setBuiltInsModule(c11399y);
            c11306f.initialize(c11399y, true);
            C11414g c11414g = new C11414g(classLoader);
            C11645f c11645f = new C11645f();
            C11532j c11532j = new C11532j();
            C11328d0 c11328d0 = new C11328d0(c11896f, c11399y);
            C11528f c11528fMakeLazyJavaPackageFragmentFromClassLoaderProvider = C11419l.makeLazyJavaPackageFragmentFromClassLoaderProvider(classLoader, c11399y, c11896f, c11328d0, c11414g, c11645f, c11532j, (128 & 128) != 0 ? InterfaceC11661v.a.f23635a : null);
            C11644e c11644eMakeDeserializationComponentsForJava = C11419l.makeDeserializationComponentsForJava(c11399y, c11896f, c11328d0, c11528fMakeLazyJavaPackageFragmentFromClassLoaderProvider, c11414g, c11645f);
            c11645f.setComponents(c11644eMakeDeserializationComponentsForJava);
            InterfaceC11504g interfaceC11504g = InterfaceC11504g.f23244a;
            C12238m.checkNotNullExpressionValue(interfaceC11504g, "EMPTY");
            C11838b c11838b = new C11838b(c11528fMakeLazyJavaPackageFragmentFromClassLoaderProvider, interfaceC11504g);
            c11532j.setResolver(c11838b);
            ClassLoader classLoader2 = Unit.class.getClassLoader();
            C12238m.checkNotNullExpressionValue(classLoader2, "stdlibClassLoader");
            C11315o c11315o = new C11315o(c11896f, new C11414g(classLoader2), c11399y, c11328d0, c11306f.getCustomizer(), c11306f.getCustomizer(), InterfaceC11875k.a.f24658a, InterfaceC11952l.f24820b.getDefault(), new C11842b(c11896f, C12147n.emptyList()));
            c11399y.setDependencies(c11399y);
            c11399y.initialize(new C11379j(C12147n.listOf((Object[]) new InterfaceC11360i0[]{c11838b.getPackageFragmentProvider(), c11315o})));
            return new C11418k(c11644eMakeDeserializationComponentsForJava.getComponents(), new C11408a(c11645f, c11414g), null);
        }
    }

    public C11418k(C11874j c11874j, C11408a c11408a, DefaultConstructorMarker defaultConstructorMarker) {
        this.f23023b = c11874j;
        this.f23024c = c11408a;
    }

    public final C11874j getDeserialization() {
        return this.f23023b;
    }

    public final InterfaceC11325c0 getModule() {
        return this.f23023b.getModuleDescriptor();
    }

    public final C11408a getPackagePartScopeCache() {
        return this.f23024c;
    }
}

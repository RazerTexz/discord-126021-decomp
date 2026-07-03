package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11290j;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11328d0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11473x0;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11481c;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.C11489c;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.InterfaceC11626t;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.InterfaceC11503f;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.InterfaceC11504g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.InterfaceC11507j;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.C11524b;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.C11528f;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.InterfaceC11525c;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.InterfaceC11531i;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.C11598d;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.C11606l;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11642c;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11644e;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11645f;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11646g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11653n;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11661v;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p561z.C11842b;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11873i;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11875k;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11952l;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12037e;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.l */
/* JADX INFO: compiled from: RuntimeModuleData.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11419l {
    public static final C11644e makeDeserializationComponentsForJava(InterfaceC11325c0 interfaceC11325c0, InterfaceC11905o interfaceC11905o, C11328d0 c11328d0, C11528f c11528f, InterfaceC11653n interfaceC11653n, C11645f c11645f) {
        C12238m.checkNotNullParameter(interfaceC11325c0, "module");
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(c11328d0, "notFoundClasses");
        C12238m.checkNotNullParameter(c11528f, "lazyJavaPackageFragmentProvider");
        C12238m.checkNotNullParameter(interfaceC11653n, "reflectKotlinClassFinder");
        C12238m.checkNotNullParameter(c11645f, "deserializedDescriptorResolver");
        return new C11644e(interfaceC11905o, interfaceC11325c0, InterfaceC11875k.a.f24658a, new C11646g(interfaceC11653n, c11645f), new C11642c(interfaceC11325c0, c11328d0, interfaceC11905o, interfaceC11653n), c11528f, c11328d0, C11417j.f23021b, InterfaceC11481c.a.f23110a, InterfaceC11873i.f24635a.getDEFAULT(), InterfaceC11952l.f24820b.getDefault());
    }

    public static final C11528f makeLazyJavaPackageFragmentFromClassLoaderProvider(ClassLoader classLoader, InterfaceC11325c0 interfaceC11325c0, InterfaceC11905o interfaceC11905o, C11328d0 c11328d0, InterfaceC11653n interfaceC11653n, C11645f c11645f, InterfaceC11531i interfaceC11531i, InterfaceC11661v interfaceC11661v) {
        C12238m.checkNotNullParameter(classLoader, "classLoader");
        C12238m.checkNotNullParameter(interfaceC11325c0, "module");
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(c11328d0, "notFoundClasses");
        C12238m.checkNotNullParameter(interfaceC11653n, "reflectKotlinClassFinder");
        C12238m.checkNotNullParameter(c11645f, "deserializedDescriptorResolver");
        C12238m.checkNotNullParameter(interfaceC11531i, "singleModuleClassResolver");
        C12238m.checkNotNullParameter(interfaceC11661v, "packagePartProvider");
        C12037e c12037e = C12037e.f24982b;
        C11489c c11489c = new C11489c(interfaceC11905o, c12037e);
        C11411d c11411d = new C11411d(classLoader);
        InterfaceC11507j interfaceC11507j = InterfaceC11507j.f23249a;
        C12238m.checkNotNullExpressionValue(interfaceC11507j, "DO_NOTHING");
        C11417j c11417j = C11417j.f23021b;
        InterfaceC11504g interfaceC11504g = InterfaceC11504g.f23244a;
        C12238m.checkNotNullExpressionValue(interfaceC11504g, "EMPTY");
        InterfaceC11503f.a aVar = InterfaceC11503f.a.f23243a;
        C11842b c11842b = new C11842b(interfaceC11905o, C12147n.emptyList());
        C11420m c11420m = C11420m.f23025a;
        InterfaceC11473x0.a aVar2 = InterfaceC11473x0.a.f23103a;
        InterfaceC11481c.a aVar3 = InterfaceC11481c.a.f23110a;
        C11290j c11290j = new C11290j(interfaceC11325c0, c11328d0);
        InterfaceC11525c.a aVar4 = InterfaceC11525c.a.f23303a;
        return new C11528f(new C11524b(interfaceC11905o, c11411d, interfaceC11653n, c11645f, interfaceC11507j, c11417j, interfaceC11504g, aVar, c11842b, c11420m, interfaceC11531i, interfaceC11661v, aVar2, aVar3, interfaceC11325c0, c11290j, c11489c, new C11606l(c11489c, c12037e, new C11598d(aVar4)), InterfaceC11626t.a.f23521a, aVar4, InterfaceC11952l.f24820b.getDefault(), c12037e));
    }
}

package d0.e0.p.d.m0.l.b.d0;

import d0.e0.p.d.m0.b.k;
import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.c.d0;
import d0.e0.p.d.m0.c.f0;
import d0.e0.p.d.m0.c.g0;
import d0.e0.p.d.m0.l.b.i;
import d0.e0.p.d.m0.l.b.j;
import d0.e0.p.d.m0.l.b.k$a;
import d0.e0.p.d.m0.l.b.p;
import d0.e0.p.d.m0.l.b.q$a;
import d0.e0.p.d.m0.l.b.t$a;
import d0.e0.p.d.m0.m.o;
import d0.t.n;
import d0.z.d.m;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: BuiltInsLoaderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements d0.e0.p.d.m0.b.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f3485b = new d();

    public final f0 createBuiltInPackageFragmentProvider(o oVar, c0 c0Var, Set<d0.e0.p.d.m0.g.b> set, Iterable<? extends d0.e0.p.d.m0.c.h1.b> iterable, d0.e0.p.d.m0.c.h1.c cVar, d0.e0.p.d.m0.c.h1.a aVar, boolean z2, Function1<? super String, ? extends InputStream> function1) {
        m.checkNotNullParameter(oVar, "storageManager");
        m.checkNotNullParameter(c0Var, "module");
        m.checkNotNullParameter(set, "packageFqNames");
        m.checkNotNullParameter(iterable, "classDescriptorFactories");
        m.checkNotNullParameter(cVar, "platformDependentDeclarationFilter");
        m.checkNotNullParameter(aVar, "additionalClassPartsProvider");
        m.checkNotNullParameter(function1, "loadResource");
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(set, 10));
        for (d0.e0.p.d.m0.g.b bVar : set) {
            String builtInsFilePath = a.m.getBuiltInsFilePath(bVar);
            InputStream inputStreamInvoke = function1.invoke(builtInsFilePath);
            if (inputStreamInvoke == null) {
                throw new IllegalStateException(m.stringPlus("Resource not found in classpath: ", builtInsFilePath));
            }
            arrayList.add(c.v.create(bVar, oVar, c0Var, inputStreamInvoke, z2));
        }
        g0 g0Var = new g0(arrayList);
        d0 d0Var = new d0(oVar, c0Var);
        k$a k_a = k$a.a;
        d0.e0.p.d.m0.l.b.m mVar = new d0.e0.p.d.m0.l.b.m(g0Var);
        a aVar2 = a.m;
        d0.e0.p.d.m0.l.b.d dVar = new d0.e0.p.d.m0.l.b.d(c0Var, d0Var, aVar2);
        t$a t_a = t$a.a;
        p pVar = p.a;
        m.checkNotNullExpressionValue(pVar, "DO_NOTHING");
        j jVar = new j(oVar, c0Var, k_a, mVar, dVar, g0Var, t_a, pVar, d0.e0.p.d.m0.d.b.c$a.a, q$a.a, iterable, d0Var, i.a.getDEFAULT(), aVar, cVar, aVar2.getExtensionRegistry(), null, new d0.e0.p.d.m0.k.z.b(oVar, n.emptyList()), null, Opcodes.ASM5, null);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).initialize(jVar);
        }
        return g0Var;
    }

    @Override // d0.e0.p.d.m0.b.a
    public f0 createPackageFragmentProvider(o oVar, c0 c0Var, Iterable<? extends d0.e0.p.d.m0.c.h1.b> iterable, d0.e0.p.d.m0.c.h1.c cVar, d0.e0.p.d.m0.c.h1.a aVar, boolean z2) {
        m.checkNotNullParameter(oVar, "storageManager");
        m.checkNotNullParameter(c0Var, "builtInsModule");
        m.checkNotNullParameter(iterable, "classDescriptorFactories");
        m.checkNotNullParameter(cVar, "platformDependentDeclarationFilter");
        m.checkNotNullParameter(aVar, "additionalClassPartsProvider");
        return createBuiltInPackageFragmentProvider(oVar, c0Var, k.p, iterable, cVar, aVar, z2, new b$a(this.f3485b));
    }
}

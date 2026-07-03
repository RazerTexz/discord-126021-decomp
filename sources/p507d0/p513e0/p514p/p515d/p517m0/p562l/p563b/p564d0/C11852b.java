package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p564d0;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;
import org.objectweb.asm.Opcodes;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.InterfaceC11281a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11328d0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11337g0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11334f0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11354a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11355b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11356c;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11481c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p561z.C11842b;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11850d;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11874j;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11877m;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11873i;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11875k;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11880p;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11881q;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11884t;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12235j;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.d0.b */
/* JADX INFO: compiled from: BuiltInsLoaderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11852b implements InterfaceC11281a {

    /* JADX INFO: renamed from: b */
    public final C11854d f24516b = new C11854d();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.d0.b$a */
    /* JADX INFO: compiled from: BuiltInsLoaderImpl.kt */
    public /* synthetic */ class a extends C12235j implements Function1<String, InputStream> {
        public a(C11854d c11854d) {
            super(1, c11854d);
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d, kotlin.reflect.KCallable
        public final String getName() {
            return "loadResource";
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d
        public final KDeclarationContainer getOwner() {
            return C12216a0.getOrCreateKotlinClass(C11854d.class);
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d
        public final String getSignature() {
            return "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
        }

        @Override // kotlin.jvm.functions.Function1
        public final InputStream invoke(String str) {
            C12238m.checkNotNullParameter(str, "p0");
            return ((C11854d) this.receiver).loadResource(str);
        }
    }

    public final InterfaceC11334f0 createBuiltInPackageFragmentProvider(InterfaceC11905o interfaceC11905o, InterfaceC11325c0 interfaceC11325c0, Set<C11713b> set, Iterable<? extends InterfaceC11355b> iterable, InterfaceC11356c interfaceC11356c, InterfaceC11354a interfaceC11354a, boolean z2, Function1<? super String, ? extends InputStream> function1) {
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(interfaceC11325c0, "module");
        C12238m.checkNotNullParameter(set, "packageFqNames");
        C12238m.checkNotNullParameter(iterable, "classDescriptorFactories");
        C12238m.checkNotNullParameter(interfaceC11356c, "platformDependentDeclarationFilter");
        C12238m.checkNotNullParameter(interfaceC11354a, "additionalClassPartsProvider");
        C12238m.checkNotNullParameter(function1, "loadResource");
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(set, 10));
        for (C11713b c11713b : set) {
            String builtInsFilePath = C11851a.f24515m.getBuiltInsFilePath(c11713b);
            InputStream inputStreamInvoke = function1.invoke(builtInsFilePath);
            if (inputStreamInvoke == null) {
                throw new IllegalStateException(C12238m.stringPlus("Resource not found in classpath: ", builtInsFilePath));
            }
            arrayList.add(C11853c.f24517v.create(c11713b, interfaceC11905o, interfaceC11325c0, inputStreamInvoke, z2));
        }
        C11337g0 c11337g0 = new C11337g0(arrayList);
        C11328d0 c11328d0 = new C11328d0(interfaceC11905o, interfaceC11325c0);
        InterfaceC11875k.a aVar = InterfaceC11875k.a.f24658a;
        C11877m c11877m = new C11877m(c11337g0);
        C11851a c11851a = C11851a.f24515m;
        C11850d c11850d = new C11850d(interfaceC11325c0, c11328d0, c11851a);
        InterfaceC11884t.a aVar2 = InterfaceC11884t.a.f24682a;
        InterfaceC11880p interfaceC11880p = InterfaceC11880p.f24676a;
        C12238m.checkNotNullExpressionValue(interfaceC11880p, "DO_NOTHING");
        C11874j c11874j = new C11874j(interfaceC11905o, interfaceC11325c0, aVar, c11877m, c11850d, c11337g0, aVar2, interfaceC11880p, InterfaceC11481c.a.f23110a, InterfaceC11881q.a.f24677a, iterable, c11328d0, InterfaceC11873i.f24635a.getDEFAULT(), interfaceC11354a, interfaceC11356c, c11851a.getExtensionRegistry(), null, new C11842b(interfaceC11905o, C12147n.emptyList()), null, Opcodes.ASM5, null);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((C11853c) it.next()).initialize(c11874j);
        }
        return c11337g0;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p518b.InterfaceC11281a
    public InterfaceC11334f0 createPackageFragmentProvider(InterfaceC11905o interfaceC11905o, InterfaceC11325c0 interfaceC11325c0, Iterable<? extends InterfaceC11355b> iterable, InterfaceC11356c interfaceC11356c, InterfaceC11354a interfaceC11354a, boolean z2) {
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(interfaceC11325c0, "builtInsModule");
        C12238m.checkNotNullParameter(iterable, "classDescriptorFactories");
        C12238m.checkNotNullParameter(interfaceC11356c, "platformDependentDeclarationFilter");
        C12238m.checkNotNullParameter(interfaceC11354a, "additionalClassPartsProvider");
        return createBuiltInPackageFragmentProvider(interfaceC11905o, interfaceC11325c0, C11291k.f22503p, iterable, interfaceC11356c, interfaceC11354a, z2, new a(this.f24516b));
    }
}

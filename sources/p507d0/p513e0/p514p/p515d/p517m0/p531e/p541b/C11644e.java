package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.C11306f;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.C11307g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11328d0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11354a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11356c;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11481c;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.C11528f;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.C11675h;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p561z.C11842b;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11874j;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11873i;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11875k;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11880p;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11884t;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11952l;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.e */
/* JADX INFO: compiled from: DeserializationComponentsForJava.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11644e {

    /* JADX INFO: renamed from: a */
    public final C11874j f23602a;

    public C11644e(InterfaceC11905o interfaceC11905o, InterfaceC11325c0 interfaceC11325c0, InterfaceC11875k interfaceC11875k, C11646g c11646g, C11642c c11642c, C11528f c11528f, C11328d0 c11328d0, InterfaceC11880p interfaceC11880p, InterfaceC11481c interfaceC11481c, InterfaceC11873i interfaceC11873i, InterfaceC11952l interfaceC11952l) {
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(interfaceC11325c0, "moduleDescriptor");
        C12238m.checkNotNullParameter(interfaceC11875k, "configuration");
        C12238m.checkNotNullParameter(c11646g, "classDataFinder");
        C12238m.checkNotNullParameter(c11642c, "annotationAndConstantLoader");
        C12238m.checkNotNullParameter(c11528f, "packageFragmentProvider");
        C12238m.checkNotNullParameter(c11328d0, "notFoundClasses");
        C12238m.checkNotNullParameter(interfaceC11880p, "errorReporter");
        C12238m.checkNotNullParameter(interfaceC11481c, "lookupTracker");
        C12238m.checkNotNullParameter(interfaceC11873i, "contractDeserializer");
        C12238m.checkNotNullParameter(interfaceC11952l, "kotlinTypeChecker");
        AbstractC11288h builtIns = interfaceC11325c0.getBuiltIns();
        C11306f c11306f = builtIns instanceof C11306f ? (C11306f) builtIns : null;
        InterfaceC11884t.a aVar = InterfaceC11884t.a.f24682a;
        C11647h c11647h = C11647h.f23613a;
        List listEmptyList = C12147n.emptyList();
        InterfaceC11354a customizer = c11306f == null ? null : c11306f.getCustomizer();
        InterfaceC11354a interfaceC11354a = customizer == null ? InterfaceC11354a.a.f22796a : customizer;
        C11307g customizer2 = c11306f != null ? c11306f.getCustomizer() : null;
        this.f23602a = new C11874j(interfaceC11905o, interfaceC11325c0, interfaceC11875k, c11646g, c11642c, c11528f, aVar, interfaceC11880p, interfaceC11481c, c11647h, listEmptyList, c11328d0, interfaceC11873i, interfaceC11354a, customizer2 == null ? InterfaceC11356c.b.f22798a : customizer2, C11675h.f23720a.getEXTENSION_REGISTRY(), interfaceC11952l, new C11842b(interfaceC11905o, C12147n.emptyList()), null, 262144, null);
    }

    public final C11874j getComponents() {
        return this.f23602a;
    }
}

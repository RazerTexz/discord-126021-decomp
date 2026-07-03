package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import p507d0.p513e0.p514p.p515d.p517m0.p518b.p519p.C11296a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11328d0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11354a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11355b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11356c;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11481c;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11653n;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p561z.InterfaceC11841a;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AbstractC11844a;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11850d;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11874j;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11877m;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11873i;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11875k;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11880p;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11881q;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11884t;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p564d0.C11851a;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11952l;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.o */
/* JADX INFO: compiled from: JvmBuiltInsPackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11315o extends AbstractC11844a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11315o(InterfaceC11905o interfaceC11905o, InterfaceC11653n interfaceC11653n, InterfaceC11325c0 interfaceC11325c0, C11328d0 c11328d0, InterfaceC11354a interfaceC11354a, InterfaceC11356c interfaceC11356c, InterfaceC11875k interfaceC11875k, InterfaceC11952l interfaceC11952l, InterfaceC11841a interfaceC11841a) {
        super(interfaceC11905o, interfaceC11653n, interfaceC11325c0);
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(interfaceC11653n, "finder");
        C12238m.checkNotNullParameter(interfaceC11325c0, "moduleDescriptor");
        C12238m.checkNotNullParameter(c11328d0, "notFoundClasses");
        C12238m.checkNotNullParameter(interfaceC11354a, "additionalClassPartsProvider");
        C12238m.checkNotNullParameter(interfaceC11356c, "platformDependentDeclarationFilter");
        C12238m.checkNotNullParameter(interfaceC11875k, "deserializationConfiguration");
        C12238m.checkNotNullParameter(interfaceC11952l, "kotlinTypeChecker");
        C12238m.checkNotNullParameter(interfaceC11841a, "samConversionResolver");
        C11877m c11877m = new C11877m(this);
        C11851a c11851a = C11851a.f24515m;
        C11850d c11850d = new C11850d(interfaceC11325c0, c11328d0, c11851a);
        InterfaceC11884t.a aVar = InterfaceC11884t.a.f24682a;
        InterfaceC11880p interfaceC11880p = InterfaceC11880p.f24676a;
        C12238m.checkNotNullExpressionValue(interfaceC11880p, "DO_NOTHING");
        C11874j c11874j = new C11874j(interfaceC11905o, interfaceC11325c0, interfaceC11875k, c11877m, c11850d, this, aVar, interfaceC11880p, InterfaceC11481c.a.f23110a, InterfaceC11881q.a.f24677a, C12147n.listOf((Object[]) new InterfaceC11355b[]{new C11296a(interfaceC11905o, interfaceC11325c0), new C11305e(interfaceC11905o, interfaceC11325c0, null, 4, null)}), c11328d0, InterfaceC11873i.f24635a.getDEFAULT(), interfaceC11354a, interfaceC11356c, c11851a.getExtensionRegistry(), interfaceC11952l, interfaceC11841a, null, 262144, null);
        C12238m.checkNotNullParameter(c11874j, "<set-?>");
        this.f24493d = c11874j;
    }
}

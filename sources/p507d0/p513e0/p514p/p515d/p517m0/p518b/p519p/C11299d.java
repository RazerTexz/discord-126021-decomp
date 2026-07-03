package p507d0.p513e0.p514p.p515d.p517m0.p518b.p519p;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11766e;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.d */
/* JADX INFO: compiled from: FunctionClassScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11299d extends AbstractC11766e {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11299d(InterfaceC11905o interfaceC11905o, C11297b c11297b) {
        super(interfaceC11905o, c11297b);
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(c11297b, "containingClass");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11766e
    /* JADX INFO: renamed from: a */
    public List<InterfaceC11472x> mo9372a() {
        int iOrdinal = ((C11297b) this.f24363c).getFunctionKind().ordinal();
        if (iOrdinal != 0) {
            return iOrdinal != 1 ? C12147n.emptyList() : C12145m.listOf(C11300e.f22609M.create((C11297b) this.f24363c, true));
        }
        return C12145m.listOf(C11300e.f22609M.create((C11297b) this.f24363c, false));
    }
}

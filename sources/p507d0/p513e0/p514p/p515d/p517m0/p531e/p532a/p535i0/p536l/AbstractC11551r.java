package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.C11529g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.AbstractC11544k;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11585r;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.r */
/* JADX INFO: compiled from: LazyJavaStaticScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11551r extends AbstractC11544k {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AbstractC11551r(C11529g c11529g) {
        super(c11529g, null, 2, 0 == true ? 1 : 0);
        C12238m.checkNotNullParameter(c11529g, "c");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.AbstractC11544k
    /* JADX INFO: renamed from: g */
    public void mo9475g(C11716e c11716e, Collection<InterfaceC11453n0> collection) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(collection, "result");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.AbstractC11544k
    /* JADX INFO: renamed from: i */
    public InterfaceC11459q0 mo9477i() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.AbstractC11544k
    /* JADX INFO: renamed from: l */
    public AbstractC11544k.a mo9480l(InterfaceC11585r interfaceC11585r, List<? extends InterfaceC11477z0> list, AbstractC11913c0 abstractC11913c0, List<? extends InterfaceC11326c1> list2) {
        C12238m.checkNotNullParameter(interfaceC11585r, "method");
        C12238m.checkNotNullParameter(list, "methodTypeParameters");
        C12238m.checkNotNullParameter(abstractC11913c0, "returnType");
        C12238m.checkNotNullParameter(list2, "valueParameters");
        return new AbstractC11544k.a(abstractC11913c0, null, list2, list, false, C12147n.emptyList());
    }
}

package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l */
/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C11939l extends AbstractC12018z0 {

    /* JADX INFO: renamed from: b */
    public final AbstractC12018z0 f24796b;

    public C11939l(AbstractC12018z0 abstractC12018z0) {
        C12238m.checkNotNullParameter(abstractC12018z0, "substitution");
        this.f24796b = abstractC12018z0;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
    public boolean approximateCapturedTypes() {
        return this.f24796b.approximateCapturedTypes();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
    public InterfaceC11344g filterAnnotations(InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        return this.f24796b.filterAnnotations(interfaceC11344g);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
    public InterfaceC12012w0 get(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "key");
        return this.f24796b.get(abstractC11913c0);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
    public boolean isEmpty() {
        return this.f24796b.isEmpty();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
    public AbstractC11913c0 prepareTopLevelType(AbstractC11913c0 abstractC11913c0, EnumC11935j1 enumC11935j1) {
        C12238m.checkNotNullParameter(abstractC11913c0, "topLevelType");
        C12238m.checkNotNullParameter(enumC11935j1, ModelAuditLogEntry.CHANGE_KEY_POSITION);
        return this.f24796b.prepareTopLevelType(abstractC11913c0, enumC11935j1);
    }
}

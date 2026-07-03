package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11480b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.a */
/* JADX INFO: compiled from: AbstractScopeAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11762a implements InterfaceC11770i {
    /* JADX INFO: renamed from: a */
    public abstract InterfaceC11770i mo9910a();

    public final InterfaceC11770i getActualScope() {
        return mo9910a() instanceof AbstractC11762a ? ((AbstractC11762a) mo9910a()).getActualScope() : mo9910a();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Set<C11716e> getClassifierNames() {
        return mo9910a().getClassifierNames();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public InterfaceC11352h getContributedClassifier(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return mo9910a().getContributedClassifier(c11716e, interfaceC11480b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public Collection<InterfaceC11450m> getContributedDescriptors(C11765d c11765d, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(c11765d, "kindFilter");
        C12238m.checkNotNullParameter(function1, "nameFilter");
        return mo9910a().getContributedDescriptors(c11765d, function1);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Collection<InterfaceC11465t0> getContributedFunctions(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return mo9910a().getContributedFunctions(c11716e, interfaceC11480b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Collection<InterfaceC11453n0> getContributedVariables(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return mo9910a().getContributedVariables(c11716e, interfaceC11480b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Set<C11716e> getFunctionNames() {
        return mo9910a().getFunctionNames();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Set<C11716e> getVariableNames() {
        return mo9910a().getVariableNames();
    }
}

package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11480b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12036d;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.j */
/* JADX INFO: compiled from: MemberScopeImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11771j implements InterfaceC11770i {
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Set<C11716e> getClassifierNames() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public InterfaceC11352h getContributedClassifier(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public Collection<InterfaceC11450m> getContributedDescriptors(C11765d c11765d, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(c11765d, "kindFilter");
        C12238m.checkNotNullParameter(function1, "nameFilter");
        return C12147n.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Collection<? extends InterfaceC11465t0> getContributedFunctions(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return C12147n.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Collection<? extends InterfaceC11453n0> getContributedVariables(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return C12147n.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Set<C11716e> getFunctionNames() {
        Collection<InterfaceC11450m> contributedDescriptors = getContributedDescriptors(C11765d.f24354p, C12036d.alwaysTrue());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : contributedDescriptors) {
            if (obj instanceof InterfaceC11465t0) {
                C11716e name = ((InterfaceC11465t0) obj).getName();
                C12238m.checkNotNullExpressionValue(name, "it.name");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Set<C11716e> getVariableNames() {
        Collection<InterfaceC11450m> contributedDescriptors = getContributedDescriptors(C11765d.f24355q, C12036d.alwaysTrue());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : contributedDescriptors) {
            if (obj instanceof InterfaceC11465t0) {
                C11716e name = ((InterfaceC11465t0) obj).getName();
                C12238m.checkNotNullExpressionValue(name, "it.name");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }
}

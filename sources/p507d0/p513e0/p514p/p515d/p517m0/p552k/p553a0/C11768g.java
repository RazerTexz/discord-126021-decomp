package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11359i;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11475y0;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11480b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.g */
/* JADX INFO: compiled from: InnerClassesScopeWrapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11768g extends AbstractC11771j {

    /* JADX INFO: renamed from: b */
    public final InterfaceC11770i f24367b;

    public C11768g(InterfaceC11770i interfaceC11770i) {
        C12238m.checkNotNullParameter(interfaceC11770i, "workerScope");
        this.f24367b = interfaceC11770i;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Set<C11716e> getClassifierNames() {
        return this.f24367b.getClassifierNames();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public InterfaceC11352h getContributedClassifier(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        InterfaceC11352h contributedClassifier = this.f24367b.getContributedClassifier(c11716e, interfaceC11480b);
        if (contributedClassifier == null) {
            return null;
        }
        InterfaceC11330e interfaceC11330e = contributedClassifier instanceof InterfaceC11330e ? (InterfaceC11330e) contributedClassifier : null;
        if (interfaceC11330e != null) {
            return interfaceC11330e;
        }
        if (contributedClassifier instanceof InterfaceC11475y0) {
            return (InterfaceC11475y0) contributedClassifier;
        }
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(C11765d c11765d, Function1 function1) {
        return getContributedDescriptors(c11765d, (Function1<? super C11716e, Boolean>) function1);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Set<C11716e> getFunctionNames() {
        return this.f24367b.getFunctionNames();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Set<C11716e> getVariableNames() {
        return this.f24367b.getVariableNames();
    }

    public String toString() {
        return C12238m.stringPlus("Classes from ", this.f24367b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public List<InterfaceC11352h> getContributedDescriptors(C11765d c11765d, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(c11765d, "kindFilter");
        C12238m.checkNotNullParameter(function1, "nameFilter");
        C11765d c11765dRestrictedToKindsOrNull = c11765d.restrictedToKindsOrNull(C11765d.f24339a.getCLASSIFIERS_MASK());
        if (c11765dRestrictedToKindsOrNull == null) {
            return C12147n.emptyList();
        }
        Collection<InterfaceC11450m> contributedDescriptors = this.f24367b.getContributedDescriptors(c11765dRestrictedToKindsOrNull, function1);
        ArrayList arrayList = new ArrayList();
        for (Object obj : contributedDescriptors) {
            if (obj instanceof InterfaceC11359i) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}

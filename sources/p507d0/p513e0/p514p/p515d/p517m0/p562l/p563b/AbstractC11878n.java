package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11362a0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.AbstractC11863h;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.n */
/* JADX INFO: compiled from: DeserializedPackageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11878n extends AbstractC11362a0 {

    /* JADX INFO: renamed from: o */
    public final InterfaceC11905o f24669o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC11878n(C11713b c11713b, InterfaceC11905o interfaceC11905o, InterfaceC11325c0 interfaceC11325c0) {
        super(interfaceC11325c0, c11713b);
        C12238m.checkNotNullParameter(c11713b, "fqName");
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(interfaceC11325c0, "module");
        this.f24669o = interfaceC11905o;
    }

    public abstract InterfaceC11871g getClassDataFinder();

    public boolean hasTopLevelClass(C11716e c11716e) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        InterfaceC11770i memberScope = getMemberScope();
        return (memberScope instanceof AbstractC11863h) && ((AbstractC11863h) memberScope).getClassNames$deserialization().contains(c11716e);
    }
}

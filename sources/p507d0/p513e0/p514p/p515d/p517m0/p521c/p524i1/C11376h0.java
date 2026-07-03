package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11402j0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11764c;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.C11765d;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12033a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.h0 */
/* JADX INFO: compiled from: SubpackagesScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C11376h0 extends AbstractC11771j {

    /* JADX INFO: renamed from: b */
    public final InterfaceC11325c0 f22878b;

    /* JADX INFO: renamed from: c */
    public final C11713b f22879c;

    public C11376h0(InterfaceC11325c0 interfaceC11325c0, C11713b c11713b) {
        C12238m.checkNotNullParameter(interfaceC11325c0, "moduleDescriptor");
        C12238m.checkNotNullParameter(c11713b, "fqName");
        this.f22878b = interfaceC11325c0;
        this.f22879c = c11713b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Set<C11716e> getClassifierNames() {
        return C12148n0.emptySet();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public Collection<InterfaceC11450m> getContributedDescriptors(C11765d c11765d, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(c11765d, "kindFilter");
        C12238m.checkNotNullParameter(function1, "nameFilter");
        if (!c11765d.acceptsKinds(C11765d.f24339a.getPACKAGES_MASK())) {
            return C12147n.emptyList();
        }
        if (this.f22879c.isRoot() && c11765d.getExcludes().contains(AbstractC11764c.b.f24338a)) {
            return C12147n.emptyList();
        }
        Collection<C11713b> subPackagesOf = this.f22878b.getSubPackagesOf(this.f22879c, function1);
        ArrayList arrayList = new ArrayList(subPackagesOf.size());
        Iterator<C11713b> it = subPackagesOf.iterator();
        while (it.hasNext()) {
            C11716e c11716eShortName = it.next().shortName();
            C12238m.checkNotNullExpressionValue(c11716eShortName, "subFqName.shortName()");
            if (function1.invoke(c11716eShortName).booleanValue()) {
                C12238m.checkNotNullParameter(c11716eShortName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                InterfaceC11402j0 interfaceC11402j0 = null;
                if (!c11716eShortName.isSpecial()) {
                    InterfaceC11325c0 interfaceC11325c0 = this.f22878b;
                    C11713b c11713bChild = this.f22879c.child(c11716eShortName);
                    C12238m.checkNotNullExpressionValue(c11713bChild, "fqName.child(name)");
                    InterfaceC11402j0 interfaceC11402j1 = interfaceC11325c0.getPackage(c11713bChild);
                    if (!interfaceC11402j1.isEmpty()) {
                        interfaceC11402j0 = interfaceC11402j1;
                    }
                }
                C12033a.addIfNotNull(arrayList, interfaceC11402j0);
            }
        }
        return arrayList;
    }
}

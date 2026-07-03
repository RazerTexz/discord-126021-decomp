package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.j0 */
/* JADX INFO: compiled from: PackageViewDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11402j0 extends InterfaceC11450m {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.j0$a */
    /* JADX INFO: compiled from: PackageViewDescriptor.kt */
    public static final class a {
        public static boolean isEmpty(InterfaceC11402j0 interfaceC11402j0) {
            C12238m.checkNotNullParameter(interfaceC11402j0, "this");
            return interfaceC11402j0.getFragments().isEmpty();
        }
    }

    C11713b getFqName();

    List<InterfaceC11331e0> getFragments();

    InterfaceC11770i getMemberScope();

    InterfaceC11325c0 getModule();

    boolean isEmpty();
}

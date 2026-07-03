package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.c0 */
/* JADX INFO: compiled from: ModuleDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11325c0 extends InterfaceC11450m {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.c0$a */
    /* JADX INFO: compiled from: ModuleDescriptor.kt */
    public static final class a {
        public static <R, D> R accept(InterfaceC11325c0 interfaceC11325c0, InterfaceC11454o<R, D> interfaceC11454o, D d) {
            C12238m.checkNotNullParameter(interfaceC11325c0, "this");
            C12238m.checkNotNullParameter(interfaceC11454o, "visitor");
            return interfaceC11454o.visitModuleDeclaration(interfaceC11325c0, d);
        }

        public static InterfaceC11450m getContainingDeclaration(InterfaceC11325c0 interfaceC11325c0) {
            C12238m.checkNotNullParameter(interfaceC11325c0, "this");
            return null;
        }
    }

    AbstractC11288h getBuiltIns();

    <T> T getCapability(C11322b0<T> c11322b0);

    List<InterfaceC11325c0> getExpectedByModules();

    InterfaceC11402j0 getPackage(C11713b c11713b);

    Collection<C11713b> getSubPackagesOf(C11713b c11713b, Function1<? super C11716e, Boolean> function1);

    boolean shouldSeeInternalsOf(InterfaceC11325c0 interfaceC11325c0);
}

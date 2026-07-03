package p507d0.p513e0.p514p.p515d.p517m0.p573o;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.o.b */
/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC12020b {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.b$a */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class a {
        public static String invoke(InterfaceC12020b interfaceC12020b, InterfaceC11472x interfaceC11472x) {
            C12238m.checkNotNullParameter(interfaceC12020b, "this");
            C12238m.checkNotNullParameter(interfaceC11472x, "functionDescriptor");
            if (interfaceC12020b.check(interfaceC11472x)) {
                return null;
            }
            return interfaceC12020b.getDescription();
        }
    }

    boolean check(InterfaceC11472x interfaceC11472x);

    String getDescription();

    String invoke(InterfaceC11472x interfaceC11472x);
}

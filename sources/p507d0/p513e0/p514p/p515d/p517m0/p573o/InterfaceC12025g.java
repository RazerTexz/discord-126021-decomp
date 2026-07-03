package p507d0.p513e0.p514p.p515d.p517m0.p573o;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.o.g */
/* JADX INFO: compiled from: ModuleVisibilityHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC12025g {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.g$a */
    /* JADX INFO: compiled from: ModuleVisibilityHelper.kt */
    public static final class a implements InterfaceC12025g {

        /* JADX INFO: renamed from: a */
        public static final a f24915a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12025g
        public boolean isInFriendModule(InterfaceC11450m interfaceC11450m, InterfaceC11450m interfaceC11450m2) {
            C12238m.checkNotNullParameter(interfaceC11450m, "what");
            C12238m.checkNotNullParameter(interfaceC11450m2, "from");
            return true;
        }
    }

    boolean isInFriendModule(InterfaceC11450m interfaceC11450m, InterfaceC11450m interfaceC11450m2);
}

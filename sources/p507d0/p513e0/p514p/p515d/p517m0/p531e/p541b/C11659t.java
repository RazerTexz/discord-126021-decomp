package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.t */
/* JADX INFO: compiled from: methodSignatureBuildingUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11659t {
    public static final String signature(C11662w c11662w, InterfaceC11330e interfaceC11330e, String str) {
        C12238m.checkNotNullParameter(c11662w, "<this>");
        C12238m.checkNotNullParameter(interfaceC11330e, "classDescriptor");
        C12238m.checkNotNullParameter(str, "jvmDescriptor");
        return c11662w.signature(C11660u.getInternalName(interfaceC11330e), str);
    }
}

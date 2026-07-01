package d0.e0.p.d.m0.c.g1;

import java.util.List;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g$a {
    public static final /* synthetic */ g$a a = new g$a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f3251b = new g$a$a();

    public final g create(List<? extends c> list) {
        d0.z.d.m.checkNotNullParameter(list, "annotations");
        return list.isEmpty() ? f3251b : new h(list);
    }

    public final g getEMPTY() {
        return f3251b;
    }
}

package p000;

import java.util.Map;
import java.util.Set;
import p637j0.p641k.InterfaceC12589b;

/* JADX INFO: renamed from: j */
/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class C12574j<T, R> implements InterfaceC12589b<Map<Long, ? extends Integer>, Set<? extends Long>> {

    /* JADX INFO: renamed from: j */
    public static final C12574j f26680j = new C12574j(0);

    /* JADX INFO: renamed from: k */
    public static final C12574j f26681k = new C12574j(1);

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ int f26682l;

    public C12574j(int i) {
        this.f26682l = i;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public final Set<? extends Long> call(Map<Long, ? extends Integer> map) {
        int i = this.f26682l;
        if (i == 0) {
            return map.keySet();
        }
        if (i == 1) {
            return map.keySet();
        }
        throw null;
    }
}

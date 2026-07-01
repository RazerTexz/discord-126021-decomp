package d0.e0.p.d.m0.e.a.l0;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public final w a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<w> f3347b;

    public k() {
        this(null, null, 3, null);
    }

    public k(w wVar, List<w> list) {
        d0.z.d.m.checkNotNullParameter(list, "parametersInfo");
        this.a = wVar;
        this.f3347b = list;
    }

    public final List<w> getParametersInfo() {
        return this.f3347b;
    }

    public final w getReturnTypeInfo() {
        return this.a;
    }

    public /* synthetic */ k(w wVar, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : wVar, (i & 2) != 0 ? d0.t.n.emptyList() : list);
    }
}

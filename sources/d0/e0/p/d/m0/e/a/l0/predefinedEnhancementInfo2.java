package d0.e0.p.d.m0.e.a.l0;

import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.k, reason: use source file name */
/* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class predefinedEnhancementInfo2 {
    public final predefinedEnhancementInfo4 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<predefinedEnhancementInfo4> f3347b;

    /* JADX WARN: Multi-variable type inference failed */
    public predefinedEnhancementInfo2() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public predefinedEnhancementInfo2(predefinedEnhancementInfo4 predefinedenhancementinfo4, List<predefinedEnhancementInfo4> list) {
        Intrinsics3.checkNotNullParameter(list, "parametersInfo");
        this.a = predefinedenhancementinfo4;
        this.f3347b = list;
    }

    public final List<predefinedEnhancementInfo4> getParametersInfo() {
        return this.f3347b;
    }

    public final predefinedEnhancementInfo4 getReturnTypeInfo() {
        return this.a;
    }

    public /* synthetic */ predefinedEnhancementInfo2(predefinedEnhancementInfo4 predefinedenhancementinfo4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : predefinedenhancementinfo4, (i & 2) != 0 ? Collections2.emptyList() : list);
    }
}

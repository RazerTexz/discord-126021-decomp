package b.a.y;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.y.a0, reason: use source file name */
/* JADX INFO: compiled from: PileView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PileView2 extends Lambda implements Function1<Integer, String> {
    public final /* synthetic */ String $avatarUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PileView2(String str) {
        super(1);
        this.$avatarUrl = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public String invoke(Integer num) {
        num.intValue();
        return this.$avatarUrl;
    }
}

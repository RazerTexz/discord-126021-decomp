package b.a.y;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PileView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a0 extends d0.z.d.o implements Function1<Integer, String> {
    public final /* synthetic */ String $avatarUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(String str) {
        super(1);
        this.$avatarUrl = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public String invoke(Integer num) {
        num.intValue();
        return this.$avatarUrl;
    }
}

package b.p.a;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: b.p.a.d, reason: use source file name */
/* JADX INFO: compiled from: Alert.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Alert4 extends Lambda implements Function0<Integer> {
    public final /* synthetic */ Alert2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Alert4(Alert2 alert2) {
        super(0);
        this.this$0 = alert2;
    }

    @Override // kotlin.jvm.functions.Function0
    public Integer invoke() {
        return Integer.valueOf(this.this$0.getResources().getDimensionPixelSize(this.this$0.getResources().getIdentifier("navigation_bar_height", "dimen", "android")));
    }
}

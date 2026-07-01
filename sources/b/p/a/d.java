package b.p.a;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Alert.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends o implements Function0<Integer> {
    public final /* synthetic */ b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar) {
        super(0);
        this.this$0 = bVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public Integer invoke() {
        return Integer.valueOf(this.this$0.getResources().getDimensionPixelSize(this.this$0.getResources().getIdentifier("navigation_bar_height", "dimen", "android")));
    }
}

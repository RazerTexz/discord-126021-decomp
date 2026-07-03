package p007b.p483p.p484a;

import android.view.View;
import com.tapadoo.alerter.C11198R;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.p.a.c */
/* JADX INFO: compiled from: Alert.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5273c extends AbstractC12240o implements Function0<View> {
    public final /* synthetic */ ViewOnClickListenerC5272b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5273c(ViewOnClickListenerC5272b viewOnClickListenerC5272b) {
        super(0);
        this.this$0 = viewOnClickListenerC5272b;
    }

    @Override // kotlin.jvm.functions.Function0
    public View invoke() {
        return this.this$0.findViewById(C11198R.d.vAlertContentContainer);
    }
}

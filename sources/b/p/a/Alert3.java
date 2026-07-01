package b.p.a;

import android.view.View;
import com.tapadoo.alerter.R;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: b.p.a.c, reason: use source file name */
/* JADX INFO: compiled from: Alert.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Alert3 extends Lambda implements Function0<View> {
    public final /* synthetic */ Alert2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Alert3(Alert2 alert2) {
        super(0);
        this.this$0 = alert2;
    }

    @Override // kotlin.jvm.functions.Function0
    public View invoke() {
        return this.this$0.findViewById(R.d.vAlertContentContainer);
    }
}

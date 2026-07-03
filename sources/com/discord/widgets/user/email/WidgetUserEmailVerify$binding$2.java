package com.discord.widgets.user.email;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetUserEmailVerifyBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserEmailVerify$binding$2 extends C12236k implements Function1<View, WidgetUserEmailVerifyBinding> {
    public static final WidgetUserEmailVerify$binding$2 INSTANCE = new WidgetUserEmailVerify$binding$2();

    public WidgetUserEmailVerify$binding$2() {
        super(1, WidgetUserEmailVerifyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserEmailVerifyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUserEmailVerifyBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.alert_verify_email_anchor;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.alert_verify_email_anchor);
        if (linearLayout != null) {
            i = C5419R.id.alert_verify_email_change;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.alert_verify_email_change);
            if (materialButton != null) {
                i = C5419R.id.alert_verify_email_resend;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.alert_verify_email_resend);
                if (materialButton2 != null) {
                    return new WidgetUserEmailVerifyBinding((RelativeLayout) view, linearLayout, materialButton, materialButton2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

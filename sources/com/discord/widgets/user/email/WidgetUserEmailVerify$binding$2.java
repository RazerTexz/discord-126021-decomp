package com.discord.widgets.user.email;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetUserEmailVerifyBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserEmailVerify$binding$2 extends k implements Function1<View, WidgetUserEmailVerifyBinding> {
    public static final WidgetUserEmailVerify$binding$2 INSTANCE = new WidgetUserEmailVerify$binding$2();

    public WidgetUserEmailVerify$binding$2() {
        super(1, WidgetUserEmailVerifyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserEmailVerifyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserEmailVerifyBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserEmailVerifyBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.alert_verify_email_anchor;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.alert_verify_email_anchor);
        if (linearLayout != null) {
            i = R$id.alert_verify_email_change;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.alert_verify_email_change);
            if (materialButton != null) {
                i = R$id.alert_verify_email_resend;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.alert_verify_email_resend);
                if (materialButton2 != null) {
                    return new WidgetUserEmailVerifyBinding((RelativeLayout) view, linearLayout, materialButton, materialButton2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

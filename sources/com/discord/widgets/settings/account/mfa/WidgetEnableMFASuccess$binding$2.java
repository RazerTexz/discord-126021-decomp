package com.discord.widgets.settings.account.mfa;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsEnableMfaSuccessBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetEnableMFASuccess.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEnableMFASuccess$binding$2 extends C12236k implements Function1<View, WidgetSettingsEnableMfaSuccessBinding> {
    public static final WidgetEnableMFASuccess$binding$2 INSTANCE = new WidgetEnableMFASuccess$binding$2();

    public WidgetEnableMFASuccess$binding$2() {
        super(1, WidgetSettingsEnableMfaSuccessBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsEnableMfaSuccessBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsEnableMfaSuccessBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.mfa_success_enable_sms);
        if (materialButton != null) {
            return new WidgetSettingsEnableMfaSuccessBinding((LinearLayout) view, materialButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.mfa_success_enable_sms)));
    }
}

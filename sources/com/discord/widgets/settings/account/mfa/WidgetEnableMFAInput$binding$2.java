package com.discord.widgets.settings.account.mfa;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsEnableMfaInputBinding;
import com.discord.views.CodeVerificationView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetEnableMFAInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEnableMFAInput$binding$2 extends C12236k implements Function1<View, WidgetSettingsEnableMfaInputBinding> {
    public static final WidgetEnableMFAInput$binding$2 INSTANCE = new WidgetEnableMFAInput$binding$2();

    public WidgetEnableMFAInput$binding$2() {
        super(1, WidgetSettingsEnableMfaInputBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsEnableMfaInputBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsEnableMfaInputBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        CodeVerificationView codeVerificationView = (CodeVerificationView) view.findViewById(C5419R.id.user_settings_mfa_enable_input_code);
        if (codeVerificationView != null) {
            return new WidgetSettingsEnableMfaInputBinding((LinearLayout) view, codeVerificationView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.user_settings_mfa_enable_input_code)));
    }
}

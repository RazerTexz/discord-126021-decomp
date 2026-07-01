package com.discord.widgets.settings.account.mfa;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.WidgetSettingsEnableMfaKeyBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEnableMFAKey.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEnableMFAKey$binding$2 extends k implements Function1<View, WidgetSettingsEnableMfaKeyBinding> {
    public static final WidgetEnableMFAKey$binding$2 INSTANCE = new WidgetEnableMFAKey$binding$2();

    public WidgetEnableMFAKey$binding$2() {
        super(1, WidgetSettingsEnableMfaKeyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsEnableMfaKeyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsEnableMfaKeyBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsEnableMfaKeyBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.enable_mfa_key_code;
        TextView textView = (TextView) view.findViewById(R$id.enable_mfa_key_code);
        if (textView != null) {
            i = R$id.enable_mfa_key_launch_authy;
            TextView textView2 = (TextView) view.findViewById(R$id.enable_mfa_key_launch_authy);
            if (textView2 != null) {
                i = R$id.enable_mfa_key_launch_google_auth;
                TextView textView3 = (TextView) view.findViewById(R$id.enable_mfa_key_launch_google_auth);
                if (textView3 != null) {
                    return new WidgetSettingsEnableMfaKeyBinding((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

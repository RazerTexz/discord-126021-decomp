package com.discord.widgets.servers;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsSecurityBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsSecurity$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsSecurityBinding> {
    public static final WidgetServerSettingsSecurity$binding$2 INSTANCE = new WidgetServerSettingsSecurity$binding$2();

    public WidgetServerSettingsSecurity$binding$2() {
        super(1, WidgetServerSettingsSecurityBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsSecurityBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsSecurityBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.mfa_description_text;
        TextView textView = (TextView) view.findViewById(R.id.mfa_description_text);
        if (textView != null) {
            i = R.id.server_settings_security_label;
            TextView textView2 = (TextView) view.findViewById(R.id.server_settings_security_label);
            if (textView2 != null) {
                i = R.id.server_settings_security_toggle_mfa_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.server_settings_security_toggle_mfa_button);
                if (materialButton != null) {
                    return new WidgetServerSettingsSecurityBinding((CoordinatorLayout) view, textView, textView2, materialButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

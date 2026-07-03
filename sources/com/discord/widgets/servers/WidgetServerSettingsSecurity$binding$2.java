package com.discord.widgets.servers;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetServerSettingsSecurityBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsSecurity$binding$2 extends C12236k implements Function1<View, WidgetServerSettingsSecurityBinding> {
    public static final WidgetServerSettingsSecurity$binding$2 INSTANCE = new WidgetServerSettingsSecurity$binding$2();

    public WidgetServerSettingsSecurity$binding$2() {
        super(1, WidgetServerSettingsSecurityBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsSecurityBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsSecurityBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.mfa_description_text;
        TextView textView = (TextView) view.findViewById(C5419R.id.mfa_description_text);
        if (textView != null) {
            i = C5419R.id.server_settings_security_label;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.server_settings_security_label);
            if (textView2 != null) {
                i = C5419R.id.server_settings_security_toggle_mfa_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.server_settings_security_toggle_mfa_button);
                if (materialButton != null) {
                    return new WidgetServerSettingsSecurityBinding((CoordinatorLayout) view, textView, textView2, materialButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

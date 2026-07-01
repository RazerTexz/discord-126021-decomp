package com.discord.widgets.servers;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsSecurityDialogBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsSecurity$ToggleMfaDialog$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsSecurityDialogBinding> {
    public static final WidgetServerSettingsSecurity$ToggleMfaDialog$binding$2 INSTANCE = new WidgetServerSettingsSecurity$ToggleMfaDialog$binding$2();

    public WidgetServerSettingsSecurity$ToggleMfaDialog$binding$2() {
        super(1, WidgetServerSettingsSecurityDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsSecurityDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsSecurityDialogBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.notice_header;
        TextView textView = (TextView) view.findViewById(R.id.notice_header);
        if (textView != null) {
            i = R.id.server_settings_security_dialog_cancel;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.server_settings_security_dialog_cancel);
            if (materialButton != null) {
                i = R.id.server_settings_security_dialog_confirm;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.server_settings_security_dialog_confirm);
                if (materialButton2 != null) {
                    i = R.id.server_settings_security_server_mfa_code;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.server_settings_security_server_mfa_code);
                    if (textInputLayout != null) {
                        return new WidgetServerSettingsSecurityDialogBinding((LinearLayout) view, textView, materialButton, materialButton2, textInputLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

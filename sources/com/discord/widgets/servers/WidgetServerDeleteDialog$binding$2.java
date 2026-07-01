package com.discord.widgets.servers;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.WidgetServerDeleteDialogBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerDeleteDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerDeleteDialog$binding$2 extends k implements Function1<View, WidgetServerDeleteDialogBinding> {
    public static final WidgetServerDeleteDialog$binding$2 INSTANCE = new WidgetServerDeleteDialog$binding$2();

    public WidgetServerDeleteDialog$binding$2() {
        super(1, WidgetServerDeleteDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerDeleteDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerDeleteDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerDeleteDialogBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.server_settings_delete_server_cancel;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.server_settings_delete_server_cancel);
        if (materialButton != null) {
            i = R$id.server_settings_delete_server_confirm;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.server_settings_delete_server_confirm);
            if (materialButton2 != null) {
                i = R$id.server_settings_delete_server_header;
                TextView textView = (TextView) view.findViewById(R$id.server_settings_delete_server_header);
                if (textView != null) {
                    i = R$id.server_settings_delete_server_mfa_code;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.server_settings_delete_server_mfa_code);
                    if (textInputLayout != null) {
                        i = R$id.server_settings_delete_server_mfa_wrap;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.server_settings_delete_server_mfa_wrap);
                        if (linearLayout != null) {
                            i = R$id.server_settings_delete_server_text;
                            TextView textView2 = (TextView) view.findViewById(R$id.server_settings_delete_server_text);
                            if (textView2 != null) {
                                return new WidgetServerDeleteDialogBinding((LinearLayout) view, materialButton, materialButton2, textView, textInputLayout, linearLayout, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

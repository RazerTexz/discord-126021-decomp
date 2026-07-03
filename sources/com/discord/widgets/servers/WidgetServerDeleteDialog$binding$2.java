package com.discord.widgets.servers;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetServerDeleteDialogBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerDeleteDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerDeleteDialog$binding$2 extends C12236k implements Function1<View, WidgetServerDeleteDialogBinding> {
    public static final WidgetServerDeleteDialog$binding$2 INSTANCE = new WidgetServerDeleteDialog$binding$2();

    public WidgetServerDeleteDialog$binding$2() {
        super(1, WidgetServerDeleteDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerDeleteDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerDeleteDialogBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.server_settings_delete_server_cancel;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.server_settings_delete_server_cancel);
        if (materialButton != null) {
            i = C5419R.id.server_settings_delete_server_confirm;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.server_settings_delete_server_confirm);
            if (materialButton2 != null) {
                i = C5419R.id.server_settings_delete_server_header;
                TextView textView = (TextView) view.findViewById(C5419R.id.server_settings_delete_server_header);
                if (textView != null) {
                    i = C5419R.id.server_settings_delete_server_mfa_code;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.server_settings_delete_server_mfa_code);
                    if (textInputLayout != null) {
                        i = C5419R.id.server_settings_delete_server_mfa_wrap;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.server_settings_delete_server_mfa_wrap);
                        if (linearLayout != null) {
                            i = C5419R.id.server_settings_delete_server_text;
                            TextView textView2 = (TextView) view.findViewById(C5419R.id.server_settings_delete_server_text);
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

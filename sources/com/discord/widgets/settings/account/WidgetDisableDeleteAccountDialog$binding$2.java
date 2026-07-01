package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.WidgetDisableDeleteAccountDialogBinding;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetDisableDeleteAccountDialog$binding$2 extends k implements Function1<View, WidgetDisableDeleteAccountDialogBinding> {
    public static final WidgetDisableDeleteAccountDialog$binding$2 INSTANCE = new WidgetDisableDeleteAccountDialog$binding$2();

    public WidgetDisableDeleteAccountDialog$binding$2() {
        super(1, WidgetDisableDeleteAccountDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetDisableDeleteAccountDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetDisableDeleteAccountDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetDisableDeleteAccountDialogBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.disable_delete_body;
        TextView textView = (TextView) view.findViewById(R$id.disable_delete_body);
        if (textView != null) {
            i = R$id.disable_delete_cancel;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.disable_delete_cancel);
            if (materialButton != null) {
                i = R$id.disable_delete_code_wrap;
                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.disable_delete_code_wrap);
                if (textInputLayout != null) {
                    i = R$id.disable_delete_confirm;
                    LoadingButton loadingButton = (LoadingButton) view.findViewById(R$id.disable_delete_confirm);
                    if (loadingButton != null) {
                        i = R$id.disable_delete_header;
                        TextView textView2 = (TextView) view.findViewById(R$id.disable_delete_header);
                        if (textView2 != null) {
                            i = R$id.disable_delete_password_wrap;
                            TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R$id.disable_delete_password_wrap);
                            if (textInputLayout2 != null) {
                                i = R$id.notice_header_container;
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.notice_header_container);
                                if (linearLayout != null) {
                                    return new WidgetDisableDeleteAccountDialogBinding((LinearLayout) view, textView, materialButton, textInputLayout, loadingButton, textView2, textInputLayout2, linearLayout);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

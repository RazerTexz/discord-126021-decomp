package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetSettingsAccountEmailEditConfirmBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccountEmailEditConfirm$binding$2 extends k implements Function1<View, WidgetSettingsAccountEmailEditConfirmBinding> {
    public static final WidgetSettingsAccountEmailEditConfirm$binding$2 INSTANCE = new WidgetSettingsAccountEmailEditConfirm$binding$2();

    public WidgetSettingsAccountEmailEditConfirm$binding$2() {
        super(1, WidgetSettingsAccountEmailEditConfirmBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountEmailEditConfirmBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsAccountEmailEditConfirmBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAccountEmailEditConfirmBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = 2131363051;
        DimmerView dimmerView = (DimmerView) view.findViewById(2131363051);
        if (dimmerView != null) {
            i = R$id.edit_account_code_wrap;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.edit_account_code_wrap);
            if (textInputLayout != null) {
                i = R$id.edit_account_email_confirm_description;
                TextView textView = (TextView) view.findViewById(R$id.edit_account_email_confirm_description);
                if (textView != null) {
                    i = R$id.settings_account_confirm_resend;
                    LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.settings_account_confirm_resend);
                    if (linkifiedTextView != null) {
                        i = R$id.settings_account_next;
                        Button button = (Button) view.findViewById(R$id.settings_account_next);
                        if (button != null) {
                            return new WidgetSettingsAccountEmailEditConfirmBinding((CoordinatorLayout) view, dimmerView, textInputLayout, textView, linkifiedTextView, button);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

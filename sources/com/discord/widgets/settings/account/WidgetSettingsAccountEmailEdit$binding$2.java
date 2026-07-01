package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.Button;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetSettingsAccountEmailEditBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAccountEmailEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccountEmailEdit$binding$2 extends k implements Function1<View, WidgetSettingsAccountEmailEditBinding> {
    public static final WidgetSettingsAccountEmailEdit$binding$2 INSTANCE = new WidgetSettingsAccountEmailEdit$binding$2();

    public WidgetSettingsAccountEmailEdit$binding$2() {
        super(1, WidgetSettingsAccountEmailEditBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountEmailEditBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsAccountEmailEditBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAccountEmailEditBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = 2131363051;
        DimmerView dimmerView = (DimmerView) view.findViewById(2131363051);
        if (dimmerView != null) {
            i = R$id.edit_account_email_description;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.edit_account_email_description);
            if (linkifiedTextView != null) {
                i = R$id.edit_account_email_wrap;
                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.edit_account_email_wrap);
                if (textInputLayout != null) {
                    i = R$id.settings_account_next;
                    Button button = (Button) view.findViewById(R$id.settings_account_next);
                    if (button != null) {
                        i = R$id.settings_account_save;
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R$id.settings_account_save);
                        if (floatingActionButton != null) {
                            return new WidgetSettingsAccountEmailEditBinding((CoordinatorLayout) view, dimmerView, linkifiedTextView, textInputLayout, button, floatingActionButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

package com.discord.widgets.settings.account;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetSettingsAccountContactsNameEditBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAccountContactsNameEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccountContactsNameEdit$binding$2 extends k implements Function1<View, WidgetSettingsAccountContactsNameEditBinding> {
    public static final WidgetSettingsAccountContactsNameEdit$binding$2 INSTANCE = new WidgetSettingsAccountContactsNameEdit$binding$2();

    public WidgetSettingsAccountContactsNameEdit$binding$2() {
        super(1, WidgetSettingsAccountContactsNameEditBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountContactsNameEditBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsAccountContactsNameEditBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAccountContactsNameEditBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.edit_account_name_wrap;
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.edit_account_name_wrap);
        if (textInputLayout != null) {
            i = R$id.settings_account_name_clear;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.settings_account_name_clear);
            if (materialButton != null) {
                i = R$id.settings_account_save;
                FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R$id.settings_account_save);
                if (floatingActionButton != null) {
                    return new WidgetSettingsAccountContactsNameEditBinding((CoordinatorLayout) view, textInputLayout, materialButton, floatingActionButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

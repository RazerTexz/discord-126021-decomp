package com.discord.widgets.settings.account;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetSettingsAccountContactsNameEditBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsAccountContactsNameEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccountContactsNameEdit2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsAccountContactsNameEditBinding> {
    public static final WidgetSettingsAccountContactsNameEdit2 INSTANCE = new WidgetSettingsAccountContactsNameEdit2();

    public WidgetSettingsAccountContactsNameEdit2() {
        super(1, WidgetSettingsAccountContactsNameEditBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountContactsNameEditBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsAccountContactsNameEditBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.edit_account_name_wrap;
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.edit_account_name_wrap);
        if (textInputLayout != null) {
            i = R.id.settings_account_name_clear;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.settings_account_name_clear);
            if (materialButton != null) {
                i = R.id.settings_account_save;
                FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.settings_account_save);
                if (floatingActionButton != null) {
                    return new WidgetSettingsAccountContactsNameEditBinding((CoordinatorLayout) view, textInputLayout, materialButton, floatingActionButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

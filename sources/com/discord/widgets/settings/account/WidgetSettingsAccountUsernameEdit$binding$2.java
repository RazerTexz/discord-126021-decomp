package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetSettingsAccountEditBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAccountUsernameEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccountUsernameEdit$binding$2 extends k implements Function1<View, WidgetSettingsAccountEditBinding> {
    public static final WidgetSettingsAccountUsernameEdit$binding$2 INSTANCE = new WidgetSettingsAccountUsernameEdit$binding$2();

    public WidgetSettingsAccountUsernameEdit$binding$2() {
        super(1, WidgetSettingsAccountEditBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountEditBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsAccountEditBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAccountEditBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.dtddd;
        TextView textView = (TextView) view.findViewById(R$id.dtddd);
        if (textView != null) {
            i = R$id.edit_account_discriminator_wrap;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.edit_account_discriminator_wrap);
            if (textInputLayout != null) {
                i = R$id.edit_account_tag_layout_container;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R$id.edit_account_tag_layout_container);
                if (relativeLayout != null) {
                    i = R$id.edit_account_username_wrap;
                    TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R$id.edit_account_username_wrap);
                    if (textInputLayout2 != null) {
                        i = R$id.settings_account_save;
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R$id.settings_account_save);
                        if (floatingActionButton != null) {
                            return new WidgetSettingsAccountEditBinding((CoordinatorLayout) view, textView, textInputLayout, relativeLayout, textInputLayout2, floatingActionButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

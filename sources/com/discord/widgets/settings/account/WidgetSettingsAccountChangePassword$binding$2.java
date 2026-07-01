package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetSettingsAccountChangePasswordBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAccountChangePassword.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccountChangePassword$binding$2 extends k implements Function1<View, WidgetSettingsAccountChangePasswordBinding> {
    public static final WidgetSettingsAccountChangePassword$binding$2 INSTANCE = new WidgetSettingsAccountChangePassword$binding$2();

    public WidgetSettingsAccountChangePassword$binding$2() {
        super(1, WidgetSettingsAccountChangePasswordBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountChangePasswordBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsAccountChangePasswordBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAccountChangePasswordBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.auth_change_password_icon;
        ImageView imageView = (ImageView) view.findViewById(R$id.auth_change_password_icon);
        if (imageView != null) {
            i = R$id.change_password_current_password_input;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.change_password_current_password_input);
            if (textInputLayout != null) {
                i = R$id.change_password_new_password_input;
                TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R$id.change_password_new_password_input);
                if (textInputLayout2 != null) {
                    i = R$id.change_password_save;
                    LoadingButton loadingButton = (LoadingButton) view.findViewById(R$id.change_password_save);
                    if (loadingButton != null) {
                        i = R$id.change_password_title;
                        ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R$id.change_password_title);
                        if (screenTitleView != null) {
                            i = R$id.change_password_two_factor;
                            TextInputLayout textInputLayout3 = (TextInputLayout) view.findViewById(R$id.change_password_two_factor);
                            if (textInputLayout3 != null) {
                                i = R$id.change_password_two_factor_title;
                                TextView textView = (TextView) view.findViewById(R$id.change_password_two_factor_title);
                                if (textView != null) {
                                    i = 2131363051;
                                    DimmerView dimmerView = (DimmerView) view.findViewById(2131363051);
                                    if (dimmerView != null) {
                                        return new WidgetSettingsAccountChangePasswordBinding((CoordinatorLayout) view, imageView, textInputLayout, textInputLayout2, loadingButton, screenTitleView, textInputLayout3, textView, dimmerView);
                                    }
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

package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsAccountChangePasswordBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsAccountChangePassword.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccountChangePassword$binding$2 extends C12236k implements Function1<View, WidgetSettingsAccountChangePasswordBinding> {
    public static final WidgetSettingsAccountChangePassword$binding$2 INSTANCE = new WidgetSettingsAccountChangePassword$binding$2();

    public WidgetSettingsAccountChangePassword$binding$2() {
        super(1, WidgetSettingsAccountChangePasswordBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountChangePasswordBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsAccountChangePasswordBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.auth_change_password_icon;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.auth_change_password_icon);
        if (imageView != null) {
            i = C5419R.id.change_password_current_password_input;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.change_password_current_password_input);
            if (textInputLayout != null) {
                i = C5419R.id.change_password_new_password_input;
                TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(C5419R.id.change_password_new_password_input);
                if (textInputLayout2 != null) {
                    i = C5419R.id.change_password_save;
                    LoadingButton loadingButton = (LoadingButton) view.findViewById(C5419R.id.change_password_save);
                    if (loadingButton != null) {
                        i = C5419R.id.change_password_title;
                        ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(C5419R.id.change_password_title);
                        if (screenTitleView != null) {
                            i = C5419R.id.change_password_two_factor;
                            TextInputLayout textInputLayout3 = (TextInputLayout) view.findViewById(C5419R.id.change_password_two_factor);
                            if (textInputLayout3 != null) {
                                i = C5419R.id.change_password_two_factor_title;
                                TextView textView = (TextView) view.findViewById(C5419R.id.change_password_two_factor_title);
                                if (textView != null) {
                                    i = C5419R.id.dimmer_view;
                                    DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
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

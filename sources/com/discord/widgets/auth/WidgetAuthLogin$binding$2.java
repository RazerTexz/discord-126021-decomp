package com.discord.widgets.auth;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetAuthLoginBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.phone.PhoneOrEmailInputView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthLogin$binding$2 extends k implements Function1<View, WidgetAuthLoginBinding> {
    public static final WidgetAuthLogin$binding$2 INSTANCE = new WidgetAuthLogin$binding$2();

    public WidgetAuthLogin$binding$2() {
        super(1, WidgetAuthLoginBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthLoginBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuthLoginBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuthLoginBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.auth_login;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.auth_login);
        if (materialButton != null) {
            i = R$id.auth_login_container;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.auth_login_container);
            if (linearLayout != null) {
                i = R$id.auth_login_forgot_password;
                TextView textView = (TextView) view.findViewById(R$id.auth_login_forgot_password);
                if (textView != null) {
                    i = R$id.auth_login_login_input;
                    PhoneOrEmailInputView phoneOrEmailInputView = (PhoneOrEmailInputView) view.findViewById(R$id.auth_login_login_input);
                    if (phoneOrEmailInputView != null) {
                        i = R$id.auth_login_password_manager_link;
                        TextView textView2 = (TextView) view.findViewById(R$id.auth_login_password_manager_link);
                        if (textView2 != null) {
                            i = R$id.auth_login_password_wrap;
                            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.auth_login_password_wrap);
                            if (textInputLayout != null) {
                                i = 2131363051;
                                DimmerView dimmerView = (DimmerView) view.findViewById(2131363051);
                                if (dimmerView != null) {
                                    return new WidgetAuthLoginBinding((CoordinatorLayout) view, materialButton, linearLayout, textView, phoneOrEmailInputView, textView2, textInputLayout, dimmerView);
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

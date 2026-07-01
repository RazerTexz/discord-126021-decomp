package com.discord.widgets.auth;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetAuthLoginBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.phone.PhoneOrEmailInputView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLogin$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthLogin2 extends FunctionReferenceImpl implements Function1<View, WidgetAuthLoginBinding> {
    public static final WidgetAuthLogin2 INSTANCE = new WidgetAuthLogin2();

    public WidgetAuthLogin2() {
        super(1, WidgetAuthLoginBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthLoginBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetAuthLoginBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.auth_login;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.auth_login);
        if (materialButton != null) {
            i = R.id.auth_login_container;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.auth_login_container);
            if (linearLayout != null) {
                i = R.id.auth_login_forgot_password;
                TextView textView = (TextView) view.findViewById(R.id.auth_login_forgot_password);
                if (textView != null) {
                    i = R.id.auth_login_login_input;
                    PhoneOrEmailInputView phoneOrEmailInputView = (PhoneOrEmailInputView) view.findViewById(R.id.auth_login_login_input);
                    if (phoneOrEmailInputView != null) {
                        i = R.id.auth_login_password_manager_link;
                        TextView textView2 = (TextView) view.findViewById(R.id.auth_login_password_manager_link);
                        if (textView2 != null) {
                            i = R.id.auth_login_password_wrap;
                            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.auth_login_password_wrap);
                            if (textInputLayout != null) {
                                i = R.id.dimmer_view;
                                DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
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

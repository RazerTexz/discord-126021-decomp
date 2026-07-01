package com.discord.widgets.auth;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetAuthResetPasswordBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthResetPassword$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetAuthResetPassword.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthResetPassword2 extends FunctionReferenceImpl implements Function1<View, WidgetAuthResetPasswordBinding> {
    public static final WidgetAuthResetPassword2 INSTANCE = new WidgetAuthResetPassword2();

    public WidgetAuthResetPassword2() {
        super(1, WidgetAuthResetPasswordBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthResetPasswordBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetAuthResetPasswordBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.auth_reset_password_back;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.auth_reset_password_back);
        if (materialButton != null) {
            i = R.id.auth_reset_password_submit;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.auth_reset_password_submit);
            if (materialButton2 != null) {
                return new WidgetAuthResetPasswordBinding((CoordinatorLayout) view, materialButton, materialButton2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

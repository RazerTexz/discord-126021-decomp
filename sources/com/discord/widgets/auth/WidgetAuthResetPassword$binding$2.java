package com.discord.widgets.auth;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetAuthResetPasswordBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthResetPassword.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthResetPassword$binding$2 extends k implements Function1<View, WidgetAuthResetPasswordBinding> {
    public static final WidgetAuthResetPassword$binding$2 INSTANCE = new WidgetAuthResetPassword$binding$2();

    public WidgetAuthResetPassword$binding$2() {
        super(1, WidgetAuthResetPasswordBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthResetPasswordBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuthResetPasswordBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuthResetPasswordBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.auth_reset_password_back;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.auth_reset_password_back);
        if (materialButton != null) {
            i = R$id.auth_reset_password_submit;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.auth_reset_password_submit);
            if (materialButton2 != null) {
                return new WidgetAuthResetPasswordBinding((CoordinatorLayout) view, materialButton, materialButton2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

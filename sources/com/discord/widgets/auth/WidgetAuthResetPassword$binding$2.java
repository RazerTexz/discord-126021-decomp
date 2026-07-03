package com.discord.widgets.auth;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetAuthResetPasswordBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetAuthResetPassword.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthResetPassword$binding$2 extends C12236k implements Function1<View, WidgetAuthResetPasswordBinding> {
    public static final WidgetAuthResetPassword$binding$2 INSTANCE = new WidgetAuthResetPassword$binding$2();

    public WidgetAuthResetPassword$binding$2() {
        super(1, WidgetAuthResetPasswordBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthResetPasswordBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetAuthResetPasswordBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.auth_reset_password_back;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.auth_reset_password_back);
        if (materialButton != null) {
            i = C5419R.id.auth_reset_password_submit;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.auth_reset_password_submit);
            if (materialButton2 != null) {
                return new WidgetAuthResetPasswordBinding((CoordinatorLayout) view, materialButton, materialButton2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

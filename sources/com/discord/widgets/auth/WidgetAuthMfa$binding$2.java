package com.discord.widgets.auth;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetAuthMfaBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CodeVerificationView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthMfa.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthMfa$binding$2 extends k implements Function1<View, WidgetAuthMfaBinding> {
    public static final WidgetAuthMfa$binding$2 INSTANCE = new WidgetAuthMfa$binding$2();

    public WidgetAuthMfa$binding$2() {
        super(1, WidgetAuthMfaBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthMfaBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuthMfaBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuthMfaBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.auth_login_forgot_password;
        TextView textView = (TextView) view.findViewById(R$id.auth_login_forgot_password);
        if (textView != null) {
            i = R$id.auth_mfa_verification;
            CodeVerificationView codeVerificationView = (CodeVerificationView) view.findViewById(R$id.auth_mfa_verification);
            if (codeVerificationView != null) {
                i = 2131363051;
                DimmerView dimmerView = (DimmerView) view.findViewById(2131363051);
                if (dimmerView != null) {
                    return new WidgetAuthMfaBinding((CoordinatorLayout) view, textView, codeVerificationView, dimmerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

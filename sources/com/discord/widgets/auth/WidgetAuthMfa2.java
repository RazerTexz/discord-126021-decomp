package com.discord.widgets.auth;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetAuthMfaBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CodeVerificationView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthMfa$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetAuthMfa.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthMfa2 extends FunctionReferenceImpl implements Function1<View, WidgetAuthMfaBinding> {
    public static final WidgetAuthMfa2 INSTANCE = new WidgetAuthMfa2();

    public WidgetAuthMfa2() {
        super(1, WidgetAuthMfaBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthMfaBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetAuthMfaBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.auth_login_forgot_password;
        TextView textView = (TextView) view.findViewById(R.id.auth_login_forgot_password);
        if (textView != null) {
            i = R.id.auth_mfa_verification;
            CodeVerificationView codeVerificationView = (CodeVerificationView) view.findViewById(R.id.auth_mfa_verification);
            if (codeVerificationView != null) {
                i = R.id.dimmer_view;
                DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
                if (dimmerView != null) {
                    return new WidgetAuthMfaBinding((CoordinatorLayout) view, textView, codeVerificationView, dimmerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

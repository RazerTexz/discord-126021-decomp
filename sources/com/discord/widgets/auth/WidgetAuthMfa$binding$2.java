package com.discord.widgets.auth;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetAuthMfaBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CodeVerificationView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetAuthMfa.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthMfa$binding$2 extends C12236k implements Function1<View, WidgetAuthMfaBinding> {
    public static final WidgetAuthMfa$binding$2 INSTANCE = new WidgetAuthMfa$binding$2();

    public WidgetAuthMfa$binding$2() {
        super(1, WidgetAuthMfaBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthMfaBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetAuthMfaBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.auth_login_forgot_password;
        TextView textView = (TextView) view.findViewById(C5419R.id.auth_login_forgot_password);
        if (textView != null) {
            i = C5419R.id.auth_mfa_verification;
            CodeVerificationView codeVerificationView = (CodeVerificationView) view.findViewById(C5419R.id.auth_mfa_verification);
            if (codeVerificationView != null) {
                i = C5419R.id.dimmer_view;
                DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
                if (dimmerView != null) {
                    return new WidgetAuthMfaBinding((CoordinatorLayout) view, textView, codeVerificationView, dimmerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

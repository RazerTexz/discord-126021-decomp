package com.discord.widgets.auth;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetAuthPhoneVerifyBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CodeVerificationView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthPhoneVerify3 extends FunctionReferenceImpl implements Function1<View, WidgetAuthPhoneVerifyBinding> {
    public static final WidgetAuthPhoneVerify3 INSTANCE = new WidgetAuthPhoneVerify3();

    public WidgetAuthPhoneVerify3() {
        super(1, WidgetAuthPhoneVerifyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthPhoneVerifyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetAuthPhoneVerifyBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.auth_phone_bailout;
        TextView textView = (TextView) view.findViewById(R.id.auth_phone_bailout);
        if (textView != null) {
            i = R.id.auth_phone_verify_code;
            CodeVerificationView codeVerificationView = (CodeVerificationView) view.findViewById(R.id.auth_phone_verify_code);
            if (codeVerificationView != null) {
                i = R.id.auth_phone_verify_resend;
                TextView textView2 = (TextView) view.findViewById(R.id.auth_phone_verify_resend);
                if (textView2 != null) {
                    i = R.id.auth_phone_verify_subtitle;
                    TextView textView3 = (TextView) view.findViewById(R.id.auth_phone_verify_subtitle);
                    if (textView3 != null) {
                        i = R.id.auth_phone_verify_title;
                        TextView textView4 = (TextView) view.findViewById(R.id.auth_phone_verify_title);
                        if (textView4 != null) {
                            i = R.id.dimmer_view;
                            DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
                            if (dimmerView != null) {
                                return new WidgetAuthPhoneVerifyBinding((CoordinatorLayout) view, textView, codeVerificationView, textView2, textView3, textView4, dimmerView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

package com.discord.widgets.auth;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetAuthPhoneVerifyBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CodeVerificationView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthPhoneVerify$binding$2 extends C12236k implements Function1<View, WidgetAuthPhoneVerifyBinding> {
    public static final WidgetAuthPhoneVerify$binding$2 INSTANCE = new WidgetAuthPhoneVerify$binding$2();

    public WidgetAuthPhoneVerify$binding$2() {
        super(1, WidgetAuthPhoneVerifyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthPhoneVerifyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetAuthPhoneVerifyBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.auth_phone_bailout;
        TextView textView = (TextView) view.findViewById(C5419R.id.auth_phone_bailout);
        if (textView != null) {
            i = C5419R.id.auth_phone_verify_code;
            CodeVerificationView codeVerificationView = (CodeVerificationView) view.findViewById(C5419R.id.auth_phone_verify_code);
            if (codeVerificationView != null) {
                i = C5419R.id.auth_phone_verify_resend;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.auth_phone_verify_resend);
                if (textView2 != null) {
                    i = C5419R.id.auth_phone_verify_subtitle;
                    TextView textView3 = (TextView) view.findViewById(C5419R.id.auth_phone_verify_subtitle);
                    if (textView3 != null) {
                        i = C5419R.id.auth_phone_verify_title;
                        TextView textView4 = (TextView) view.findViewById(C5419R.id.auth_phone_verify_title);
                        if (textView4 != null) {
                            i = C5419R.id.dimmer_view;
                            DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
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

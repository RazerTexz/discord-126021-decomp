package com.discord.widgets.user.phone;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.discord.R;
import com.discord.databinding.WidgetUserPhoneVerifyBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CodeVerificationView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneVerify$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserPhoneVerify5 extends FunctionReferenceImpl implements Function1<View, WidgetUserPhoneVerifyBinding> {
    public static final WidgetUserPhoneVerify5 INSTANCE = new WidgetUserPhoneVerify5();

    public WidgetUserPhoneVerify5() {
        super(1, WidgetUserPhoneVerifyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserPhoneVerifyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUserPhoneVerifyBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.close_button;
        ImageView imageView = (ImageView) view.findViewById(R.id.close_button);
        if (imageView != null) {
            i = R.id.dimmer_view;
            DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
            if (dimmerView != null) {
                i = R.id.phone_digit_verification_view;
                CodeVerificationView codeVerificationView = (CodeVerificationView) view.findViewById(R.id.phone_digit_verification_view);
                if (codeVerificationView != null) {
                    return new WidgetUserPhoneVerifyBinding((RelativeLayout) view, imageView, dimmerView, codeVerificationView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

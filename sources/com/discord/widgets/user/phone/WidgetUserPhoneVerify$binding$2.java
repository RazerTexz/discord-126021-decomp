package com.discord.widgets.user.phone;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetUserPhoneVerifyBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CodeVerificationView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserPhoneVerify$binding$2 extends k implements Function1<View, WidgetUserPhoneVerifyBinding> {
    public static final WidgetUserPhoneVerify$binding$2 INSTANCE = new WidgetUserPhoneVerify$binding$2();

    public WidgetUserPhoneVerify$binding$2() {
        super(1, WidgetUserPhoneVerifyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserPhoneVerifyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserPhoneVerifyBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserPhoneVerifyBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.close_button;
        ImageView imageView = (ImageView) view.findViewById(R$id.close_button);
        if (imageView != null) {
            i = 2131363051;
            DimmerView dimmerView = (DimmerView) view.findViewById(2131363051);
            if (dimmerView != null) {
                i = R$id.phone_digit_verification_view;
                CodeVerificationView codeVerificationView = (CodeVerificationView) view.findViewById(R$id.phone_digit_verification_view);
                if (codeVerificationView != null) {
                    return new WidgetUserPhoneVerifyBinding((RelativeLayout) view, imageView, dimmerView, codeVerificationView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

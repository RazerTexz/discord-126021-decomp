package com.discord.widgets.user.phone;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetUserPhoneVerifyBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CodeVerificationView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserPhoneVerify$binding$2 extends C12236k implements Function1<View, WidgetUserPhoneVerifyBinding> {
    public static final WidgetUserPhoneVerify$binding$2 INSTANCE = new WidgetUserPhoneVerify$binding$2();

    public WidgetUserPhoneVerify$binding$2() {
        super(1, WidgetUserPhoneVerifyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserPhoneVerifyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUserPhoneVerifyBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.close_button;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.close_button);
        if (imageView != null) {
            i = C5419R.id.dimmer_view;
            DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
            if (dimmerView != null) {
                i = C5419R.id.phone_digit_verification_view;
                CodeVerificationView codeVerificationView = (CodeVerificationView) view.findViewById(C5419R.id.phone_digit_verification_view);
                if (codeVerificationView != null) {
                    return new WidgetUserPhoneVerifyBinding((RelativeLayout) view, imageView, dimmerView, codeVerificationView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

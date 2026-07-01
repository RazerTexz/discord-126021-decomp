package com.discord.widgets.settings.premium;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.discord.R$id;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetClaimOutboundPromoBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetClaimOutboundPromo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetClaimOutboundPromo$binding$2 extends k implements Function1<View, WidgetClaimOutboundPromoBinding> {
    public static final WidgetClaimOutboundPromo$binding$2 INSTANCE = new WidgetClaimOutboundPromo$binding$2();

    public WidgetClaimOutboundPromo$binding$2() {
        super(1, WidgetClaimOutboundPromoBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetClaimOutboundPromoBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetClaimOutboundPromoBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetClaimOutboundPromoBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.claimPromoBody;
        TextView textView = (TextView) view.findViewById(R$id.claimPromoBody);
        if (textView != null) {
            i = R$id.claimPromoCode;
            TextView textView2 = (TextView) view.findViewById(R$id.claimPromoCode);
            if (textView2 != null) {
                i = R$id.claimPromoCodeBox;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.claimPromoCodeBox);
                if (linearLayout != null) {
                    i = R$id.claimPromoCopyButton;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.claimPromoCopyButton);
                    if (materialButton != null) {
                        i = R$id.claimPromoFailure;
                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R$id.claimPromoFailure);
                        if (linearLayoutCompat != null) {
                            i = R$id.claimPromoFailureCloseButton;
                            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.claimPromoFailureCloseButton);
                            if (materialButton2 != null) {
                                i = R$id.claimPromoFlipper;
                                AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R$id.claimPromoFlipper);
                                if (appViewFlipper != null) {
                                    i = R$id.claimPromoLoading;
                                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.claimPromoLoading);
                                    if (frameLayout != null) {
                                        i = R$id.claimPromoMaybeLaterButton;
                                        MaterialButton materialButton3 = (MaterialButton) view.findViewById(R$id.claimPromoMaybeLaterButton);
                                        if (materialButton3 != null) {
                                            i = R$id.claimPromoRedeemButton;
                                            MaterialButton materialButton4 = (MaterialButton) view.findViewById(R$id.claimPromoRedeemButton);
                                            if (materialButton4 != null) {
                                                i = R$id.claimPromoSuccess;
                                                LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) view.findViewById(R$id.claimPromoSuccess);
                                                if (linearLayoutCompat2 != null) {
                                                    return new WidgetClaimOutboundPromoBinding((LinearLayoutCompat) view, textView, textView2, linearLayout, materialButton, linearLayoutCompat, materialButton2, appViewFlipper, frameLayout, materialButton3, materialButton4, linearLayoutCompat2);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

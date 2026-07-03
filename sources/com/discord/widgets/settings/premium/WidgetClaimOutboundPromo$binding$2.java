package com.discord.widgets.settings.premium;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetClaimOutboundPromoBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetClaimOutboundPromo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetClaimOutboundPromo$binding$2 extends C12236k implements Function1<View, WidgetClaimOutboundPromoBinding> {
    public static final WidgetClaimOutboundPromo$binding$2 INSTANCE = new WidgetClaimOutboundPromo$binding$2();

    public WidgetClaimOutboundPromo$binding$2() {
        super(1, WidgetClaimOutboundPromoBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetClaimOutboundPromoBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetClaimOutboundPromoBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.claimPromoBody;
        TextView textView = (TextView) view.findViewById(C5419R.id.claimPromoBody);
        if (textView != null) {
            i = C5419R.id.claimPromoCode;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.claimPromoCode);
            if (textView2 != null) {
                i = C5419R.id.claimPromoCodeBox;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.claimPromoCodeBox);
                if (linearLayout != null) {
                    i = C5419R.id.claimPromoCopyButton;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.claimPromoCopyButton);
                    if (materialButton != null) {
                        i = C5419R.id.claimPromoFailure;
                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(C5419R.id.claimPromoFailure);
                        if (linearLayoutCompat != null) {
                            i = C5419R.id.claimPromoFailureCloseButton;
                            MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.claimPromoFailureCloseButton);
                            if (materialButton2 != null) {
                                i = C5419R.id.claimPromoFlipper;
                                AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.claimPromoFlipper);
                                if (appViewFlipper != null) {
                                    i = C5419R.id.claimPromoLoading;
                                    FrameLayout frameLayout = (FrameLayout) view.findViewById(C5419R.id.claimPromoLoading);
                                    if (frameLayout != null) {
                                        i = C5419R.id.claimPromoMaybeLaterButton;
                                        MaterialButton materialButton3 = (MaterialButton) view.findViewById(C5419R.id.claimPromoMaybeLaterButton);
                                        if (materialButton3 != null) {
                                            i = C5419R.id.claimPromoRedeemButton;
                                            MaterialButton materialButton4 = (MaterialButton) view.findViewById(C5419R.id.claimPromoRedeemButton);
                                            if (materialButton4 != null) {
                                                i = C5419R.id.claimPromoSuccess;
                                                LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) view.findViewById(C5419R.id.claimPromoSuccess);
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

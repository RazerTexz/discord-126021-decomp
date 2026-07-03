package com.discord.widgets.servers.guild_role_subscription.upsell;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$binding$2 extends C12236k implements Function1<View, WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding> {
    public static final WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$binding$2 INSTANCE = new WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$binding$2();

    public WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$binding$2() {
        super(1, WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.cancel_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.cancel_button);
        if (materialButton != null) {
            i = C5419R.id.confirm_button;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.confirm_button);
            if (materialButton2 != null) {
                i = C5419R.id.upsell_body;
                TextView textView = (TextView) view.findViewById(C5419R.id.upsell_body);
                if (textView != null) {
                    i = C5419R.id.upsell_header;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.upsell_header);
                    if (textView2 != null) {
                        i = C5419R.id.upsell_image;
                        ImageView imageView = (ImageView) view.findViewById(C5419R.id.upsell_image);
                        if (imageView != null) {
                            return new WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding((NestedScrollView) view, materialButton, materialButton2, textView, textView2, imageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

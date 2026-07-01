package com.discord.widgets.servers.guild_role_subscription.upsell;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R$id;
import com.discord.databinding.WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$binding$2 extends k implements Function1<View, WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding> {
    public static final WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$binding$2 INSTANCE = new WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$binding$2();

    public WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$binding$2() {
        super(1, WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = 2131362294;
        MaterialButton materialButton = (MaterialButton) view.findViewById(2131362294);
        if (materialButton != null) {
            i = 2131362803;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(2131362803);
            if (materialButton2 != null) {
                i = R$id.upsell_body;
                TextView textView = (TextView) view.findViewById(R$id.upsell_body);
                if (textView != null) {
                    i = R$id.upsell_header;
                    TextView textView2 = (TextView) view.findViewById(R$id.upsell_header);
                    if (textView2 != null) {
                        i = R$id.upsell_image;
                        ImageView imageView = (ImageView) view.findViewById(R$id.upsell_image);
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

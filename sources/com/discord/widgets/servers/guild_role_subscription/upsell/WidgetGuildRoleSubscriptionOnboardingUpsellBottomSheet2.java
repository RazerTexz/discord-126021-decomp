package com.discord.widgets.servers.guild_role_subscription.upsell;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.upsell.WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding> {
    public static final WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet2 INSTANCE = new WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet2();

    public WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet2() {
        super(1, WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.cancel_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.cancel_button);
        if (materialButton != null) {
            i = R.id.confirm_button;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.confirm_button);
            if (materialButton2 != null) {
                i = R.id.upsell_body;
                TextView textView = (TextView) view.findViewById(R.id.upsell_body);
                if (textView != null) {
                    i = R.id.upsell_header;
                    TextView textView2 = (TextView) view.findViewById(R.id.upsell_header);
                    if (textView2 != null) {
                        i = R.id.upsell_image;
                        ImageView imageView = (ImageView) view.findViewById(R.id.upsell_image);
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

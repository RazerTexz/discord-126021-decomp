package com.discord.views.guildboost;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.ViewPremiumUpsellInfoBinding;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.premium.PremiumTier;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.utilities.billing.PremiumUtils2;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.text.NumberFormat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildBoostSubscriptionUpsellView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostSubscriptionUpsellView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final ViewPremiumUpsellInfoBinding binding;

    /* JADX INFO: compiled from: GuildBoostSubscriptionUpsellView.kt */
    public static final class a extends Lambda implements Function1<RenderContext, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            RenderContext renderContext2 = renderContext;
            Intrinsics3.checkNotNullParameter(renderContext2, "$receiver");
            renderContext2.strikethroughColor = Integer.valueOf(ColorCompat.getThemedColor(GuildBoostSubscriptionUpsellView.this.getContext(), R.attr.colorTextMuted));
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostSubscriptionUpsellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_premium_upsell_info, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.view_premium_upsell_info_subheading;
        TextView textView = (TextView) viewInflate.findViewById(R.id.view_premium_upsell_info_subheading);
        if (textView != null) {
            i = R.id.view_premium_upsell_info_subheading_blurb;
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.view_premium_upsell_info_subheading_blurb);
            if (textView2 != null) {
                i = R.id.view_premium_upsell_info_subheading_price;
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.view_premium_upsell_info_subheading_price);
                if (textView3 != null) {
                    ViewPremiumUpsellInfoBinding viewPremiumUpsellInfoBinding = new ViewPremiumUpsellInfoBinding((LinearLayout) viewInflate, textView, textView2, textView3);
                    Intrinsics3.checkNotNullExpressionValue(viewPremiumUpsellInfoBinding, "ViewPremiumUpsellInfoBin…rom(context), this, true)");
                    this.binding = viewPremiumUpsellInfoBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void a(PremiumTier userPremiumTier, boolean showBlurb) {
        Intrinsics3.checkNotNullParameter(userPremiumTier, "userPremiumTier");
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.viewPremiumUpsellInfoSubheadingBlurb");
        textView.setVisibility(showBlurb ? 0 : 8);
        SubscriptionPlanType subscriptionPlanType = SubscriptionPlanType.PREMIUM_GUILD_MONTH;
        int price = subscriptionPlanType.getPrice();
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        CharSequence charSequenceD = FormatUtils.d(this, R.string.billing_price_per_month, new Object[]{PremiumUtils2.getFormattedPriceUsd(price, context)}, (4 & 4) != 0 ? FormatUtils.c.j : null);
        int price2 = (int) (subscriptionPlanType.getPrice() * 0.7f);
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        CharSequence charSequenceD2 = FormatUtils.d(this, R.string.billing_price_per_month, new Object[]{PremiumUtils2.getFormattedPriceUsd(price2, context2)}, (4 & 4) != 0 ? FormatUtils.c.j : null);
        String str = NumberFormat.getPercentInstance().format(Float.valueOf(0.3f));
        Context context3 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context3, "context");
        CharSequence charSequenceB = FormatUtils.b(context3, R.string.guild_settings_premium_upsell_subheading_extra_android, new Object[]{charSequenceD2, charSequenceD}, new a());
        int iOrdinal = userPremiumTier.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2) {
            TextView textView2 = this.binding.f92b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.viewPremiumUpsellInfoSubheading");
            FormatUtils.m(textView2, R.string.guild_settings_premium_upsell_subheading, new Object[]{charSequenceD}, (4 & 4) != 0 ? FormatUtils.g.j : null);
            TextView textView3 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.viewPremiumUpsellInfoSubheadingPrice");
            ViewExtensions.setTextAndVisibilityBy(textView3, null);
            return;
        }
        if (iOrdinal == 3) {
            TextView textView4 = this.binding.f92b;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.viewPremiumUpsellInfoSubheading");
            FormatUtils.m(textView4, R.string.guild_settings_premium_upsell_subheading_tier_1_mobile, new Object[]{str}, (4 & 4) != 0 ? FormatUtils.g.j : null);
            TextView textView5 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.viewPremiumUpsellInfoSubheadingPrice");
            ViewExtensions.setTextAndVisibilityBy(textView5, charSequenceB);
            return;
        }
        if (iOrdinal != 4) {
            return;
        }
        TextView textView6 = this.binding.f92b;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.viewPremiumUpsellInfoSubheading");
        FormatUtils.m(textView6, R.string.guild_settings_premium_upsell_subheading_tier_2_mobile, new Object[]{String.valueOf(2), str}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        TextView textView7 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.viewPremiumUpsellInfoSubheadingPrice");
        ViewExtensions.setTextAndVisibilityBy(textView7, charSequenceB);
    }
}

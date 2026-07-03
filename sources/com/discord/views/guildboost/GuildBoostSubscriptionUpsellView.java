package com.discord.views.guildboost;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.api.premium.PremiumTier;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.utilities.billing.PremiumUtilsKt;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import java.text.NumberFormat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.C0931c3;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildBoostSubscriptionUpsellView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostSubscriptionUpsellView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final C0931c3 binding;

    /* JADX INFO: renamed from: com.discord.views.guildboost.GuildBoostSubscriptionUpsellView$a */
    /* JADX INFO: compiled from: GuildBoostSubscriptionUpsellView.kt */
    public static final class C7115a extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public C7115a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            RenderContext renderContext2 = renderContext;
            C12238m.checkNotNullParameter(renderContext2, "$receiver");
            renderContext2.strikethroughColor = Integer.valueOf(ColorCompat.getThemedColor(GuildBoostSubscriptionUpsellView.this.getContext(), C5419R.attr.colorTextMuted));
            return Unit.f27425a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostSubscriptionUpsellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0);
        C12238m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.view_premium_upsell_info, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.view_premium_upsell_info_subheading;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.view_premium_upsell_info_subheading);
        if (textView != null) {
            i = C5419R.id.view_premium_upsell_info_subheading_blurb;
            TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.view_premium_upsell_info_subheading_blurb);
            if (textView2 != null) {
                i = C5419R.id.view_premium_upsell_info_subheading_price;
                TextView textView3 = (TextView) viewInflate.findViewById(C5419R.id.view_premium_upsell_info_subheading_price);
                if (textView3 != null) {
                    C0931c3 c0931c3 = new C0931c3((LinearLayout) viewInflate, textView, textView2, textView3);
                    C12238m.checkNotNullExpressionValue(c0931c3, "ViewPremiumUpsellInfoBin…rom(context), this, true)");
                    this.binding = c0931c3;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    /* JADX INFO: renamed from: a */
    public final void m8597a(PremiumTier userPremiumTier, boolean showBlurb) {
        C12238m.checkNotNullParameter(userPremiumTier, "userPremiumTier");
        TextView textView = this.binding.f744c;
        C12238m.checkNotNullExpressionValue(textView, "binding.viewPremiumUpsellInfoSubheadingBlurb");
        textView.setVisibility(showBlurb ? 0 : 8);
        SubscriptionPlanType subscriptionPlanType = SubscriptionPlanType.PREMIUM_GUILD_MONTH;
        int price = subscriptionPlanType.getPrice();
        Context context = getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        CharSequence charSequenceM212d = C1107b.m212d(this, C5419R.string.billing_price_per_month, new Object[]{PremiumUtilsKt.getFormattedPriceUsd(price, context)}, (4 & 4) != 0 ? C1107b.c.f1492j : null);
        int price2 = (int) (subscriptionPlanType.getPrice() * 0.7f);
        Context context2 = getContext();
        C12238m.checkNotNullExpressionValue(context2, "context");
        CharSequence charSequenceM212d2 = C1107b.m212d(this, C5419R.string.billing_price_per_month, new Object[]{PremiumUtilsKt.getFormattedPriceUsd(price2, context2)}, (4 & 4) != 0 ? C1107b.c.f1492j : null);
        String str = NumberFormat.getPercentInstance().format(Float.valueOf(0.3f));
        Context context3 = getContext();
        C12238m.checkNotNullExpressionValue(context3, "context");
        CharSequence charSequenceM210b = C1107b.m210b(context3, C5419R.string.guild_settings_premium_upsell_subheading_extra_android, new Object[]{charSequenceM212d2, charSequenceM212d}, new C7115a());
        int iOrdinal = userPremiumTier.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2) {
            TextView textView2 = this.binding.f743b;
            C12238m.checkNotNullExpressionValue(textView2, "binding.viewPremiumUpsellInfoSubheading");
            C1107b.m221m(textView2, C5419R.string.guild_settings_premium_upsell_subheading, new Object[]{charSequenceM212d}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
            TextView textView3 = this.binding.f745d;
            C12238m.checkNotNullExpressionValue(textView3, "binding.viewPremiumUpsellInfoSubheadingPrice");
            ViewExtensions.setTextAndVisibilityBy(textView3, null);
            return;
        }
        if (iOrdinal == 3) {
            TextView textView4 = this.binding.f743b;
            C12238m.checkNotNullExpressionValue(textView4, "binding.viewPremiumUpsellInfoSubheading");
            C1107b.m221m(textView4, C5419R.string.guild_settings_premium_upsell_subheading_tier_1_mobile, new Object[]{str}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
            TextView textView5 = this.binding.f745d;
            C12238m.checkNotNullExpressionValue(textView5, "binding.viewPremiumUpsellInfoSubheadingPrice");
            ViewExtensions.setTextAndVisibilityBy(textView5, charSequenceM210b);
            return;
        }
        if (iOrdinal != 4) {
            return;
        }
        TextView textView6 = this.binding.f743b;
        C12238m.checkNotNullExpressionValue(textView6, "binding.viewPremiumUpsellInfoSubheading");
        C1107b.m221m(textView6, C5419R.string.guild_settings_premium_upsell_subheading_tier_2_mobile, new Object[]{String.valueOf(2), str}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView7 = this.binding.f745d;
        C12238m.checkNotNullExpressionValue(textView7, "binding.viewPremiumUpsellInfoSubheadingPrice");
        ViewExtensions.setTextAndVisibilityBy(textView7, charSequenceM210b);
    }
}

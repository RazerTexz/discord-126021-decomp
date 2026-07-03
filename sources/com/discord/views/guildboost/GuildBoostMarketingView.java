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
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.button.MaterialButton;
import java.text.NumberFormat;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p008a.p025i.C1089y2;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildBoostMarketingView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostMarketingView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final C1089y2 binding;

    /* JADX INFO: renamed from: com.discord.views.guildboost.GuildBoostMarketingView$a */
    /* JADX INFO: compiled from: GuildBoostMarketingView.kt */
    public static final class ViewOnClickListenerC7114a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Function0 f19271j;

        public ViewOnClickListenerC7114a(Function0 function0) {
            this.f19271j = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f19271j.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostMarketingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0);
        C12238m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.view_premium_marketing, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.view_premium_marketing_container_tier1;
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(C5419R.id.view_premium_marketing_container_tier1);
        if (linearLayout != null) {
            i = C5419R.id.view_premium_marketing_learn_more;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(C5419R.id.view_premium_marketing_learn_more);
            if (materialButton != null) {
                LinearLayout linearLayout2 = (LinearLayout) viewInflate;
                i = C5419R.id.view_premium_marketing_marketing_subtitle;
                TextView textView = (TextView) viewInflate.findViewById(C5419R.id.view_premium_marketing_marketing_subtitle);
                if (textView != null) {
                    i = C5419R.id.view_premium_marketing_marketing_title;
                    TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.view_premium_marketing_marketing_title);
                    if (textView2 != null) {
                        i = C5419R.id.view_premium_marketing_nitro_boost_count;
                        TextView textView3 = (TextView) viewInflate.findViewById(C5419R.id.view_premium_marketing_nitro_boost_count);
                        if (textView3 != null) {
                            i = C5419R.id.view_premium_marketing_nitro_boost_discount;
                            TextView textView4 = (TextView) viewInflate.findViewById(C5419R.id.view_premium_marketing_nitro_boost_discount);
                            if (textView4 != null) {
                                i = C5419R.id.view_premium_marketing_nitro_classic_boost_count;
                                TextView textView5 = (TextView) viewInflate.findViewById(C5419R.id.view_premium_marketing_nitro_classic_boost_count);
                                if (textView5 != null) {
                                    i = C5419R.id.view_premium_marketing_nitro_classic_boost_discount;
                                    TextView textView6 = (TextView) viewInflate.findViewById(C5419R.id.view_premium_marketing_nitro_classic_boost_discount);
                                    if (textView6 != null) {
                                        C1089y2 c1089y2 = new C1089y2(linearLayout2, linearLayout, materialButton, linearLayout2, textView, textView2, textView3, textView4, textView5, textView6);
                                        C12238m.checkNotNullExpressionValue(c1089y2, "ViewPremiumMarketingBind…rom(context), this, true)");
                                        this.binding = c1089y2;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0138  */
    /* JADX INFO: renamed from: a */
    public final void m8595a(PremiumTier userPremiumTier, Function0<Unit> onlearnMoreClickCallback) {
        Unit unit;
        C12238m.checkNotNullParameter(userPremiumTier, "userPremiumTier");
        C12238m.checkNotNullParameter(onlearnMoreClickCallback, "onlearnMoreClickCallback");
        Context context = getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        CharSequence i18nPluralString = StringResourceUtilsKt.getI18nPluralString(context, C5419R.plurals.guild_settings_premium_upsell_body_perk_no_free_guild_subscriptions_numFreeGuildSubscriptions, 2, 2);
        TextView textView = this.binding.f1414h;
        C12238m.checkNotNullExpressionValue(textView, "binding.viewPremiumMarketingNitroBoostDiscount");
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        Float fValueOf = Float.valueOf(0.3f);
        C1107b.m221m(textView, C5419R.string.f14757xf6a2f9e9, new Object[]{percentInstance.format(fValueOf)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView2 = this.binding.f1413g;
        C12238m.checkNotNullExpressionValue(textView2, "binding.viewPremiumMarketingNitroBoostCount");
        C1107b.m221m(textView2, C5419R.string.guild_settings_premium_upsell_body_perk_num_guild_subscriptions, new Object[]{i18nPluralString}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView3 = this.binding.f1416j;
        C12238m.checkNotNullExpressionValue(textView3, "binding.viewPremiumMarke…NitroClassicBoostDiscount");
        C1107b.m221m(textView3, C5419R.string.f14757xf6a2f9e9, new Object[]{NumberFormat.getPercentInstance().format(fValueOf)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView4 = this.binding.f1415i;
        C12238m.checkNotNullExpressionValue(textView4, "binding.viewPremiumMarketingNitroClassicBoostCount");
        C1107b.m221m(textView4, C5419R.string.f14758xe408127, new Object[]{i18nPluralString}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        this.binding.f1409c.setOnClickListener(new ViewOnClickListenerC7114a(onlearnMoreClickCallback));
        int iOrdinal = userPremiumTier.ordinal();
        if (iOrdinal == 0) {
            TextView textView5 = this.binding.f1411e;
            C12238m.checkNotNullExpressionValue(textView5, "binding.viewPremiumMarketingMarketingSubtitle");
            textView5.setVisibility(8);
            unit = Unit.f27425a;
        } else if (iOrdinal == 1) {
            LinearLayout linearLayout = this.binding.f1410d;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.viewPremiumMarketingMarketingContainer");
            linearLayout.setVisibility(0);
            LinearLayout linearLayout2 = this.binding.f1408b;
            C12238m.checkNotNullExpressionValue(linearLayout2, "binding.viewPremiumMarketingContainerTier1");
            linearLayout2.setVisibility(0);
            TextView textView6 = this.binding.f1412f;
            C12238m.checkNotNullExpressionValue(textView6, "binding.viewPremiumMarketingMarketingTitle");
            ViewExtensions.setTextAndVisibilityBy(textView6, C1107b.m212d(this, C5419R.string.guild_settings_premium_upsell_heading_secondary, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null));
            TextView textView7 = this.binding.f1411e;
            C12238m.checkNotNullExpressionValue(textView7, "binding.viewPremiumMarketingMarketingSubtitle");
            textView7.setVisibility(8);
            unit = Unit.f27425a;
        } else if (iOrdinal == 2) {
            TextView textView8 = this.binding.f1411e;
            C12238m.checkNotNullExpressionValue(textView8, "binding.viewPremiumMarketingMarketingSubtitle");
            textView8.setVisibility(8);
            unit = Unit.f27425a;
        } else if (iOrdinal == 3) {
            LinearLayout linearLayout3 = this.binding.f1410d;
            C12238m.checkNotNullExpressionValue(linearLayout3, "binding.viewPremiumMarketingMarketingContainer");
            linearLayout3.setVisibility(0);
            LinearLayout linearLayout4 = this.binding.f1408b;
            C12238m.checkNotNullExpressionValue(linearLayout4, "binding.viewPremiumMarketingContainerTier1");
            linearLayout4.setVisibility(8);
            TextView textView9 = this.binding.f1412f;
            C12238m.checkNotNullExpressionValue(textView9, "binding.viewPremiumMarketingMarketingTitle");
            ViewExtensions.setTextAndVisibilityBy(textView9, C1107b.m212d(this, C5419R.string.guild_settings_premium_upsell_heading_secondary_premium_user, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null));
            TextView textView10 = this.binding.f1411e;
            C12238m.checkNotNullExpressionValue(textView10, "binding.viewPremiumMarketingMarketingSubtitle");
            ViewExtensions.setTextAndVisibilityBy(textView10, C1107b.m212d(this, C5419R.string.guild_settings_premium_upsell_heading_tertiary_premium_user, new Object[]{String.valueOf(2)}, (4 & 4) != 0 ? C1107b.c.f1492j : null));
            unit = Unit.f27425a;
        } else {
            if (iOrdinal != 4) {
                throw new NoWhenBranchMatchedException();
            }
            LinearLayout linearLayout5 = this.binding.f1410d;
            C12238m.checkNotNullExpressionValue(linearLayout5, "binding.viewPremiumMarketingMarketingContainer");
            linearLayout5.setVisibility(8);
            unit = Unit.f27425a;
        }
        KotlinExtensionsKt.getExhaustive(unit);
    }
}

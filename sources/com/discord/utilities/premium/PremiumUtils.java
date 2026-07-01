package com.discord.utilities.premium;

import android.content.Context;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import b.a.a.b.GuildBoostUpsellDialog;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.discord.R;
import com.discord.api.guild.GuildFeature;
import com.discord.api.premium.PremiumTier;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelSku;
import com.discord.models.domain.ModelStoreListing;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.stores.StoreGooglePlaySkuDetails;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.gifting.GiftStyle;
import com.discord.utilities.gifting.GiftStyle3;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.user.UserUtils;
import d0.t.Sets5;
import d0.t._Sets;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PremiumUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PremiumUtils {
    public static final float GUILD_BOOST_FOR_PREMIUM_USER_DISCOUNT_PERCENT = 0.3f;
    public static final PremiumUtils INSTANCE = new PremiumUtils();
    public static final int MAX_NON_PREMIUM_GUILD_COUNT = 100;
    public static final int MAX_PREMIUM_GUILD_COUNT = 200;
    private static final String MONTHLY_ISO8601 = "P1M";
    public static final int NUM_FREE_GUILD_BOOSTS_WITH_PREMIUM = 2;
    public static final long PREMIUM_APPLICATION_ID = 521842831262875670L;
    public static final float PREMIUM_YEARLY_DISCOUNT_PERCENT = 0.16f;
    private static final String YEARLY_ISO8601 = "P1Y";
    private static final Set<GuildFeature> tier1BoostFeatures;
    private static final Set<GuildFeature> tier2BoostFeatures;
    private static final Set<GuildFeature> tier3BoostFeatures;

    /* JADX INFO: compiled from: PremiumUtils.kt */
    public static final /* data */ class BoostFeatureBadgeData {
        private final int iconColor;
        private final Function1<View, Unit> onClickListener;
        private final CharSequence text;
        private final int textColor;

        /* JADX WARN: Multi-variable type inference failed */
        public BoostFeatureBadgeData(Function1<? super View, Unit> function1, int i, CharSequence charSequence, int i2) {
            Intrinsics3.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            this.onClickListener = function1;
            this.iconColor = i;
            this.text = charSequence;
            this.textColor = i2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BoostFeatureBadgeData copy$default(BoostFeatureBadgeData boostFeatureBadgeData, Function1 function1, int i, CharSequence charSequence, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                function1 = boostFeatureBadgeData.onClickListener;
            }
            if ((i3 & 2) != 0) {
                i = boostFeatureBadgeData.iconColor;
            }
            if ((i3 & 4) != 0) {
                charSequence = boostFeatureBadgeData.text;
            }
            if ((i3 & 8) != 0) {
                i2 = boostFeatureBadgeData.textColor;
            }
            return boostFeatureBadgeData.copy(function1, i, charSequence, i2);
        }

        public final Function1<View, Unit> component1() {
            return this.onClickListener;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getIconColor() {
            return this.iconColor;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CharSequence getText() {
            return this.text;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getTextColor() {
            return this.textColor;
        }

        public final BoostFeatureBadgeData copy(Function1<? super View, Unit> onClickListener, int iconColor, CharSequence text, int textColor) {
            Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            return new BoostFeatureBadgeData(onClickListener, iconColor, text, textColor);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BoostFeatureBadgeData)) {
                return false;
            }
            BoostFeatureBadgeData boostFeatureBadgeData = (BoostFeatureBadgeData) other;
            return Intrinsics3.areEqual(this.onClickListener, boostFeatureBadgeData.onClickListener) && this.iconColor == boostFeatureBadgeData.iconColor && Intrinsics3.areEqual(this.text, boostFeatureBadgeData.text) && this.textColor == boostFeatureBadgeData.textColor;
        }

        public final int getIconColor() {
            return this.iconColor;
        }

        public final Function1<View, Unit> getOnClickListener() {
            return this.onClickListener;
        }

        public final CharSequence getText() {
            return this.text;
        }

        public final int getTextColor() {
            return this.textColor;
        }

        public int hashCode() {
            Function1<View, Unit> function1 = this.onClickListener;
            int iHashCode = (((function1 != null ? function1.hashCode() : 0) * 31) + this.iconColor) * 31;
            CharSequence charSequence = this.text;
            return ((iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31) + this.textColor;
        }

        public String toString() {
            StringBuilder sbU = outline.U("BoostFeatureBadgeData(onClickListener=");
            sbU.append(this.onClickListener);
            sbU.append(", iconColor=");
            sbU.append(this.iconColor);
            sbU.append(", text=");
            sbU.append(this.text);
            sbU.append(", textColor=");
            return outline.B(sbU, this.textColor, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ModelSku.SkuCategory.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[ModelSku.SkuCategory.NITRO_CLASSIC.ordinal()] = 1;
            iArr[ModelSku.SkuCategory.NITRO.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.premium.PremiumUtils$getBoostFeatureBadgeDataForGuildFeature$1, reason: invalid class name */
    /* JADX INFO: compiled from: PremiumUtils.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Long $channelId;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ Guild $guild;
        public final /* synthetic */ Traits.Location $locationTrait;
        public final /* synthetic */ Integer $minimumBoostTier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Guild guild, FragmentManager fragmentManager, Integer num, Traits.Location location, Long l) {
            super(1);
            this.$guild = guild;
            this.$fragmentManager = fragmentManager;
            this.$minimumBoostTier = num;
            this.$locationTrait = location;
            this.$channelId = l;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            Guild guild = this.$guild;
            if (guild != null) {
                GuildBoostUpsellDialog.INSTANCE.a(this.$fragmentManager, guild.getId(), this.$channelId, this.$minimumBoostTier, this.$locationTrait);
            }
        }
    }

    static {
        Set<GuildFeature> of = Sets5.setOf((Object[]) new GuildFeature[]{GuildFeature.INVITE_SPLASH, GuildFeature.ANIMATED_ICON});
        tier1BoostFeatures = of;
        Set<GuildFeature> setPlus = _Sets.plus((Set) of, (Iterable) Sets5.setOf((Object[]) new GuildFeature[]{GuildFeature.BANNER, GuildFeature.PRIVATE_THREADS, GuildFeature.ROLE_ICONS}));
        tier2BoostFeatures = setPlus;
        tier3BoostFeatures = _Sets.plus((Set) setPlus, (Iterable) Sets5.setOf((Object[]) new GuildFeature[]{GuildFeature.VANITY_URL, GuildFeature.ANIMATED_BANNER}));
    }

    private PremiumUtils() {
    }

    public final boolean doesGuildHaveEnoughBoostsForFeature(Guild guild, GuildFeature feature) {
        Intrinsics3.checkNotNullParameter(feature, "feature");
        int premiumTier = guild != null ? guild.getPremiumTier() : -1;
        Integer minimumBoostTierForGuildFeature = getMinimumBoostTierForGuildFeature(feature);
        return premiumTier >= (minimumBoostTierForGuildFeature != null ? minimumBoostTierForGuildFeature.intValue() : 0);
    }

    public final Purchase findPurchaseForSkuName(List<? extends Purchase> purchases, String skuName) {
        Intrinsics3.checkNotNullParameter(skuName, "skuName");
        Object obj = null;
        if (purchases == null) {
            return null;
        }
        for (Object obj2 : purchases) {
            if (((Purchase) obj2).b().contains(skuName)) {
                obj = obj2;
                break;
            }
        }
        return (Purchase) obj;
    }

    public final ModelSubscription findSubscriptionForSku(List<ModelSubscription> subscriptions, String skuName) {
        Object next;
        Intrinsics3.checkNotNullParameter(subscriptions, "subscriptions");
        Intrinsics3.checkNotNullParameter(skuName, "skuName");
        Iterator<T> it = subscriptions.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics3.areEqual(((ModelSubscription) next).getPaymentGatewayPlanId(), skuName)) {
                return (ModelSubscription) next;
            }
        }
        next = null;
        return (ModelSubscription) next;
    }

    public final BoostFeatureBadgeData getBoostFeatureBadgeDataForGuildFeature(Guild guild, Long channelId, GuildFeature guildFeature, Context context, FragmentManager fragmentManager, Function1<? super View, Unit> onEnabledClickListener, Traits.Location locationTrait) {
        Intrinsics3.checkNotNullParameter(guildFeature, "guildFeature");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        if (guild != null && guild.hasFeature(guildFeature)) {
            String string = context.getString(R.string.guild_settings_premium_guild_unlocked);
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.stri…s_premium_guild_unlocked)");
            return new BoostFeatureBadgeData(onEnabledClickListener, ColorCompat.getColor(context, R.color.guild_boosting_pink), string, ColorCompat.getThemedColor(context, R.attr.colorTextNormal));
        }
        Integer minimumBoostTierForGuildFeature = getMinimumBoostTierForGuildFeature(guildFeature);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(guild, fragmentManager, minimumBoostTierForGuildFeature, locationTrait, channelId);
        CharSequence boostTierShortText = getBoostTierShortText(context, minimumBoostTierForGuildFeature);
        if (boostTierShortText == null) {
            boostTierShortText = "";
        }
        return new BoostFeatureBadgeData(anonymousClass1, ColorCompat.getThemedColor(context, R.attr.colorInteractiveNormal), boostTierShortText, ColorCompat.getThemedColor(context, R.attr.colorTextMuted));
    }

    public final CharSequence getBoostTierShortText(Context context, Integer premiumTier) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (premiumTier != null && premiumTier.intValue() == 1) {
            return FormatUtils.b(context, R.string.premium_guild_tier_1_short, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        if (premiumTier != null && premiumTier.intValue() == 2) {
            return FormatUtils.b(context, R.string.premium_guild_tier_2_short, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        if (premiumTier != null && premiumTier.intValue() == 3) {
            return FormatUtils.b(context, R.string.premium_guild_tier_3_short, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        return null;
    }

    public final int getGuildBoostCountFromSubscription(ModelSubscription modelSubscription) {
        Intrinsics3.checkNotNullParameter(modelSubscription, "$this$getGuildBoostCountFromSubscription");
        return (modelSubscription.getPremiumBasePlanId() == SubscriptionPlanType.PREMIUM_MONTH_TIER_2.getPlanId() || modelSubscription.getPremiumBasePlanId() == SubscriptionPlanType.PREMIUM_YEAR_TIER_2.getPlanId() || modelSubscription.getPremiumBasePlanId() == SubscriptionPlanType.PREMIUM_3_MONTH_TIER_2.getPlanId() || modelSubscription.getPremiumBasePlanId() == SubscriptionPlanType.PREMIUM_6_MONTH_TIER_2.getPlanId()) ? 2 : 0;
    }

    public final int getGuildEmojiMaxCount(int guildPremiumTier, boolean hasMoreEmoji) {
        if (hasMoreEmoji && guildPremiumTier <= 2) {
            return 200;
        }
        if (guildPremiumTier == 1) {
            return 100;
        }
        if (guildPremiumTier != 2) {
            return guildPremiumTier != 3 ? 50 : 250;
        }
        return 150;
    }

    public final int getGuildEmojiMaxCount(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        return getGuildEmojiMaxCount(guild.getPremiumTier(), guild.getFeatures().contains(GuildFeature.MORE_EMOJI));
    }

    public final int getGuildMaxFileSizeMB(int guildPremiumTier) {
        if (guildPremiumTier == 0 || guildPremiumTier == 1) {
            return 8;
        }
        return guildPremiumTier != 2 ? 100 : 50;
    }

    public final int getGuildStickerMaxCount(int guildPremiumTier, boolean hasMoreSticker) {
        if (hasMoreSticker && guildPremiumTier <= 2) {
            return 60;
        }
        if (guildPremiumTier == 1) {
            return 15;
        }
        if (guildPremiumTier != 2) {
            return guildPremiumTier != 3 ? 0 : 60;
        }
        return 30;
    }

    public final int getMaxFileSizeMB(User user) {
        if (user != null && UserUtils.INSTANCE.isStaff(user)) {
            return 200;
        }
        if ((user != null ? user.getPremiumTier() : null) == PremiumTier.TIER_1) {
            return 50;
        }
        if ((user != null ? user.getPremiumTier() : null) == PremiumTier.TIER_2) {
            return 100;
        }
        return (user != null ? user.getPremiumTier() : null) == PremiumTier.TIER_0 ? 20 : 8;
    }

    public final Integer getMinimumBoostTierForGuildFeature(GuildFeature guildFeature) {
        Intrinsics3.checkNotNullParameter(guildFeature, "guildFeature");
        if (tier1BoostFeatures.contains(guildFeature)) {
            return 1;
        }
        if (tier2BoostFeatures.contains(guildFeature)) {
            return 2;
        }
        return tier3BoostFeatures.contains(guildFeature) ? 3 : null;
    }

    @DrawableRes
    public final int getNitroGiftBackground(ModelGift gift, Context context) {
        Intrinsics3.checkNotNullParameter(gift, "gift");
        Intrinsics3.checkNotNullParameter(context, "context");
        return GiftStyle3.hasCustomStyle(gift) ? ColorCompat.getThemedColor(context, R.attr.colorBackgroundSecondaryAlt) : DrawableCompat.getThemedDrawableRes(context, R.attr.gift_nitro_splash, R.drawable.img_nitro_splash_dark);
    }

    @DrawableRes
    public final int getNitroGiftIcon(ModelGift gift) {
        Intrinsics3.checkNotNullParameter(gift, "gift");
        GiftStyle customStyle = GiftStyle3.getCustomStyle(gift);
        if (customStyle != null) {
            return customStyle.getStaticRes();
        }
        ModelStoreListing storeListing = gift.getStoreListing();
        return getNitroGiftIcon(storeListing != null ? storeListing.getSku() : null);
    }

    public final CharSequence getPlanPriceText(Context context, SkuDetails skuDetails) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(skuDetails, "skuDetails");
        String strOptString = skuDetails.f2006b.optString("subscriptionPeriod");
        int iHashCode = strOptString.hashCode();
        if (iHashCode != 78476) {
            if (iHashCode == 78488 && strOptString.equals(YEARLY_ISO8601)) {
                return FormatUtils.b(context, R.string.billing_price_per_year, new Object[]{skuDetails.b()}, (4 & 4) != 0 ? FormatUtils.b.j : null);
            }
        } else if (strOptString.equals(MONTHLY_ISO8601)) {
            return FormatUtils.b(context, R.string.billing_price_per_month, new Object[]{skuDetails.b()}, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        return "";
    }

    public final String getSkuPrice(String paymentGatewaySkuId) {
        Intrinsics3.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        StoreGooglePlaySkuDetails.State state = StoreStream.INSTANCE.getGooglePlaySkuDetails().getSkuStateSnapshot();
        if (!(state instanceof StoreGooglePlaySkuDetails.State.Loaded)) {
            Logger.w$default(AppLog.g, outline.w("SkuDetails not loaded. Unable to get price for sku id ", paymentGatewaySkuId), null, 2, null);
            return null;
        }
        SkuDetails skuDetails = ((StoreGooglePlaySkuDetails.State.Loaded) state).getSkuDetails().get(paymentGatewaySkuId);
        if (skuDetails != null) {
            return skuDetails.b();
        }
        return null;
    }

    public final boolean isNitroSku(ModelSku sku) {
        Intrinsics3.checkNotNullParameter(sku, "sku");
        return sku.getSkuCategory() == ModelSku.SkuCategory.NITRO_CLASSIC || sku.getSkuCategory() == ModelSku.SkuCategory.NITRO;
    }

    public final boolean isPremiumTierAtLeast(PremiumTier premiumTier, PremiumTier minimumLevel) {
        Intrinsics3.checkNotNullParameter(premiumTier, "premiumTier");
        Intrinsics3.checkNotNullParameter(minimumLevel, "minimumLevel");
        return premiumTier.ordinal() >= minimumLevel.ordinal();
    }

    public final int microAmountToMinor(long amount) {
        return (int) (amount / ((long) 10000));
    }

    public final void openAppleBilling(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        UriHandler.handle$default(UriHandler.INSTANCE, context, FormatUtils.b(context, R.string.apple_billing_url, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null).toString(), false, false, null, 28, null);
    }

    public final void openGooglePlayBilling(Context context, String skuName) {
        String strP;
        Intrinsics3.checkNotNullParameter(context, "context");
        if (skuName == null || (strP = outline.P(new Object[]{skuName, context.getPackageName()}, 2, GooglePlayBillingManager.PLAY_STORE_SUBSCRIPTION_DEEPLINK_URL, "java.lang.String.format(this, *args)")) == null) {
            strP = GooglePlayBillingManager.PLAY_STORE_SUBSCRIPTION_URL;
        }
        UriHandler.handle$default(UriHandler.INSTANCE, context, strP, false, false, null, 28, null);
    }

    @DrawableRes
    public final int getNitroGiftIcon(ModelSku sku) {
        ModelSku.SkuCategory skuCategory = sku != null ? sku.getSkuCategory() : null;
        if (skuCategory != null) {
            int iOrdinal = skuCategory.ordinal();
            if (iOrdinal == 1) {
                return R.drawable.drawable_ic_nitro;
            }
            if (iOrdinal == 2) {
                return R.drawable.drawable_ic_nitro_classic;
            }
        }
        return 0;
    }
}

package com.discord.utilities.premium;

import android.content.Context;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import b.d.b.a.a;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.discord.api.guild.GuildFeature;
import com.discord.api.premium.PremiumTier;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelSku;
import com.discord.models.domain.ModelSku$SkuCategory;
import com.discord.models.domain.ModelStoreListing;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.stores.StoreGooglePlaySkuDetails$State;
import com.discord.stores.StoreGooglePlaySkuDetails$State$Loaded;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.gifting.GiftStyle;
import com.discord.utilities.gifting.GiftStyleKt;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.user.UserUtils;
import d0.t.n0;
import d0.t.o0;
import d0.z.d.m;
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

    static {
        Set<GuildFeature> of = n0.setOf((Object[]) new GuildFeature[]{GuildFeature.INVITE_SPLASH, GuildFeature.ANIMATED_ICON});
        tier1BoostFeatures = of;
        Set<GuildFeature> setPlus = o0.plus((Set) of, (Iterable) n0.setOf((Object[]) new GuildFeature[]{GuildFeature.BANNER, GuildFeature.PRIVATE_THREADS, GuildFeature.ROLE_ICONS}));
        tier2BoostFeatures = setPlus;
        tier3BoostFeatures = o0.plus((Set) setPlus, (Iterable) n0.setOf((Object[]) new GuildFeature[]{GuildFeature.VANITY_URL, GuildFeature.ANIMATED_BANNER}));
    }

    private PremiumUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PremiumUtils$BoostFeatureBadgeData getBoostFeatureBadgeDataForGuildFeature$default(PremiumUtils premiumUtils, Guild guild, Long l, GuildFeature guildFeature, Context context, FragmentManager fragmentManager, Function1 function1, Traits$Location traits$Location, int i, Object obj) {
        return premiumUtils.getBoostFeatureBadgeDataForGuildFeature(guild, l, guildFeature, context, fragmentManager, (i & 32) != 0 ? null : function1, (i & 64) != 0 ? null : traits$Location);
    }

    public final boolean doesGuildHaveEnoughBoostsForFeature(Guild guild, GuildFeature feature) {
        m.checkNotNullParameter(feature, "feature");
        int premiumTier = guild != null ? guild.getPremiumTier() : -1;
        Integer minimumBoostTierForGuildFeature = getMinimumBoostTierForGuildFeature(feature);
        return premiumTier >= (minimumBoostTierForGuildFeature != null ? minimumBoostTierForGuildFeature.intValue() : 0);
    }

    public final Purchase findPurchaseForSkuName(List<? extends Purchase> purchases, String skuName) {
        m.checkNotNullParameter(skuName, "skuName");
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
        m.checkNotNullParameter(subscriptions, "subscriptions");
        m.checkNotNullParameter(skuName, "skuName");
        Iterator<T> it = subscriptions.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (m.areEqual(((ModelSubscription) next).getPaymentGatewayPlanId(), skuName)) {
                return (ModelSubscription) next;
            }
        }
        next = null;
        return (ModelSubscription) next;
    }

    public final PremiumUtils$BoostFeatureBadgeData getBoostFeatureBadgeDataForGuildFeature(Guild guild, Long channelId, GuildFeature guildFeature, Context context, FragmentManager fragmentManager, Function1<? super View, Unit> onEnabledClickListener, Traits$Location locationTrait) {
        m.checkNotNullParameter(guildFeature, "guildFeature");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        if (guild != null && guild.hasFeature(guildFeature)) {
            String string = context.getString(2131891356);
            m.checkNotNullExpressionValue(string, "context.getString(R.stri…s_premium_guild_unlocked)");
            return new PremiumUtils$BoostFeatureBadgeData(onEnabledClickListener, ColorCompat.getColor(context, 2131099927), string, ColorCompat.getThemedColor(context, 2130969057));
        }
        Integer minimumBoostTierForGuildFeature = getMinimumBoostTierForGuildFeature(guildFeature);
        PremiumUtils$getBoostFeatureBadgeDataForGuildFeature$1 premiumUtils$getBoostFeatureBadgeDataForGuildFeature$1 = new PremiumUtils$getBoostFeatureBadgeDataForGuildFeature$1(guild, fragmentManager, minimumBoostTierForGuildFeature, locationTrait, channelId);
        CharSequence boostTierShortText = getBoostTierShortText(context, minimumBoostTierForGuildFeature);
        if (boostTierShortText == null) {
            boostTierShortText = "";
        }
        return new PremiumUtils$BoostFeatureBadgeData(premiumUtils$getBoostFeatureBadgeDataForGuildFeature$1, ColorCompat.getThemedColor(context, 2130969008), boostTierShortText, ColorCompat.getThemedColor(context, 2130969056));
    }

    public final CharSequence getBoostTierShortText(Context context, Integer premiumTier) {
        m.checkNotNullParameter(context, "context");
        if (premiumTier != null && premiumTier.intValue() == 1) {
            return b.h(context, 2131894201, new Object[0], null, 4);
        }
        if (premiumTier != null && premiumTier.intValue() == 2) {
            return b.h(context, 2131894203, new Object[0], null, 4);
        }
        if (premiumTier != null && premiumTier.intValue() == 3) {
            return b.h(context, 2131894205, new Object[0], null, 4);
        }
        return null;
    }

    public final int getGuildBoostCountFromSubscription(ModelSubscription modelSubscription) {
        m.checkNotNullParameter(modelSubscription, "$this$getGuildBoostCountFromSubscription");
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
        m.checkNotNullParameter(guild, "guild");
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
        m.checkNotNullParameter(guildFeature, "guildFeature");
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
        m.checkNotNullParameter(gift, "gift");
        m.checkNotNullParameter(context, "context");
        return GiftStyleKt.hasCustomStyle(gift) ? ColorCompat.getThemedColor(context, 2130968913) : DrawableCompat.getThemedDrawableRes(context, 2130969407, 2131232398);
    }

    @DrawableRes
    public final int getNitroGiftIcon(ModelGift gift) {
        m.checkNotNullParameter(gift, "gift");
        GiftStyle customStyle = GiftStyleKt.getCustomStyle(gift);
        if (customStyle != null) {
            return customStyle.getStaticRes();
        }
        ModelStoreListing storeListing = gift.getStoreListing();
        return getNitroGiftIcon(storeListing != null ? storeListing.getSku() : null);
    }

    public final CharSequence getPlanPriceText(Context context, SkuDetails skuDetails) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(skuDetails, "skuDetails");
        String strOptString = skuDetails.f2006b.optString("subscriptionPeriod");
        int iHashCode = strOptString.hashCode();
        if (iHashCode != 78476) {
            if (iHashCode == 78488 && strOptString.equals(YEARLY_ISO8601)) {
                return b.h(context, 2131887150, new Object[]{skuDetails.b()}, null, 4);
            }
        } else if (strOptString.equals(MONTHLY_ISO8601)) {
            return b.h(context, 2131887143, new Object[]{skuDetails.b()}, null, 4);
        }
        return "";
    }

    public final String getSkuPrice(String paymentGatewaySkuId) {
        m.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        StoreGooglePlaySkuDetails$State skuStateSnapshot = StoreStream.Companion.getGooglePlaySkuDetails().getSkuStateSnapshot();
        if (!(skuStateSnapshot instanceof StoreGooglePlaySkuDetails$State$Loaded)) {
            Logger.w$default(AppLog.g, a.w("SkuDetails not loaded. Unable to get price for sku id ", paymentGatewaySkuId), null, 2, null);
            return null;
        }
        SkuDetails skuDetails = ((StoreGooglePlaySkuDetails$State$Loaded) skuStateSnapshot).getSkuDetails().get(paymentGatewaySkuId);
        if (skuDetails != null) {
            return skuDetails.b();
        }
        return null;
    }

    public final boolean isNitroSku(ModelSku sku) {
        m.checkNotNullParameter(sku, "sku");
        return sku.getSkuCategory() == ModelSku$SkuCategory.NITRO_CLASSIC || sku.getSkuCategory() == ModelSku$SkuCategory.NITRO;
    }

    public final boolean isPremiumTierAtLeast(PremiumTier premiumTier, PremiumTier minimumLevel) {
        m.checkNotNullParameter(premiumTier, "premiumTier");
        m.checkNotNullParameter(minimumLevel, "minimumLevel");
        return premiumTier.ordinal() >= minimumLevel.ordinal();
    }

    public final int microAmountToMinor(long amount) {
        return (int) (amount / ((long) 10000));
    }

    public final void openAppleBilling(Context context) {
        m.checkNotNullParameter(context, "context");
        UriHandler.handle$default(UriHandler.INSTANCE, context, b.h(context, 2131886499, new Object[0], null, 4).toString(), false, false, null, 28, null);
    }

    public final void openGooglePlayBilling(Context context, String skuName) {
        String strP;
        m.checkNotNullParameter(context, "context");
        if (skuName == null || (strP = a.P(new Object[]{skuName, context.getPackageName()}, 2, GooglePlayBillingManager.PLAY_STORE_SUBSCRIPTION_DEEPLINK_URL, "java.lang.String.format(this, *args)")) == null) {
            strP = GooglePlayBillingManager.PLAY_STORE_SUBSCRIPTION_URL;
        }
        UriHandler.handle$default(UriHandler.INSTANCE, context, strP, false, false, null, 28, null);
    }

    @DrawableRes
    public final int getNitroGiftIcon(ModelSku sku) {
        ModelSku$SkuCategory skuCategory = sku != null ? sku.getSkuCategory() : null;
        if (skuCategory != null) {
            int iOrdinal = skuCategory.ordinal();
            if (iOrdinal == 1) {
                return 2131231249;
            }
            if (iOrdinal == 2) {
                return 2131231250;
            }
        }
        return 0;
    }
}

package com.discord.utilities.gifting;

import android.content.Context;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingFlowParams$a;
import com.android.billingclient.api.SkuDetails;
import com.discord.api.premium.PremiumTier;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelSkuKt;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Payment;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.analytics.Traits$StoreSku;
import com.discord.utilities.billing.GooglePlayInAppSku;
import com.discord.utilities.billing.GooglePlayInAppSkuKt;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.DurationUnit;
import com.discord.utilities.resources.DurationUtilsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeDialog$Companion;
import d0.o;
import d0.t.h0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GiftingUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GiftingUtils {
    public static final GiftingUtils INSTANCE = new GiftingUtils();
    public static final long PREMIUM_SUBSCRIPTION_APPLICATION_ID = 521842831262875670L;

    private GiftingUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void buyGift$default(GiftingUtils giftingUtils, FragmentActivity fragmentActivity, GooglePlayInAppSku googlePlayInAppSku, Traits$Location traits$Location, Function0 function0, int i, Object obj) throws Exception {
        if ((i & 8) != 0) {
            function0 = null;
        }
        giftingUtils.buyGift(fragmentActivity, googlePlayInAppSku, traits$Location, function0);
    }

    public final void buyGift(FragmentActivity activity, GooglePlayInAppSku inAppSku, Traits$Location location, Function0<Unit> dismissWarningCallback) throws Exception {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(inAppSku, "inAppSku");
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        SkuDetails skuDetails = inAppSku.getSkuDetails();
        if (skuDetails == null) {
            throw new Exception("No skuDetails for " + inAppSku);
        }
        UserUtils userUtils = UserUtils.INSTANCE;
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        String obfuscatedUserId = userUtils.getObfuscatedUserId(Long.valueOf(storeStream$Companion.getUsers().getMeSnapshot().getId()));
        if (obfuscatedUserId == null) {
            throw new Exception("No current user ID");
        }
        BillingFlowParams$a billingFlowParams$a = new BillingFlowParams$a();
        ArrayList<SkuDetails> arrayList = new ArrayList<>();
        arrayList.add(skuDetails);
        billingFlowParams$a.d = arrayList;
        billingFlowParams$a.a = obfuscatedUserId;
        BillingFlowParams billingFlowParamsA = billingFlowParams$a.a();
        m.checkNotNullExpressionValue(billingFlowParamsA, "BillingFlowParams\n      …dUserId)\n        .build()");
        Long skuId = inAppSku.getSkuId();
        if (skuId == null) {
            throw new Exception("No skuId for " + inAppSku);
        }
        long jLongValue = skuId.longValue();
        StoreGooglePlayPurchases googlePlayPurchases = storeStream$Companion.getGooglePlayPurchases();
        String paymentGatewaySkuId = inAppSku.getPaymentGatewaySkuId();
        int id2 = GiftingUtils$SkuTypes.SUBSCRIPTION.getId();
        String strA = skuDetails.a();
        m.checkNotNullExpressionValue(strA, "skuDetails.description");
        Traits$StoreSku traits$StoreSku = new Traits$StoreSku(jLongValue, id2, 521842831262875670L, strA);
        PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
        int iMicroAmountToMinor = premiumUtils.microAmountToMinor(skuDetails.c());
        int iMicroAmountToMinor2 = premiumUtils.microAmountToMinor(skuDetails.f2006b.has("original_price_micros") ? skuDetails.f2006b.optLong("original_price_micros") : skuDetails.c());
        String strOptString = skuDetails.f2006b.optString("price_currency_code");
        m.checkNotNullExpressionValue(strOptString, "skuDetails.priceCurrencyCode");
        Locale locale = Locale.ROOT;
        m.checkNotNullExpressionValue(locale, "Locale.ROOT");
        Objects.requireNonNull(strOptString, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strOptString.toLowerCase(locale);
        m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        googlePlayPurchases.trackPaymentFlowStarted(paymentGatewaySkuId, jLongValue, location, traits$StoreSku, new Traits$Payment(Traits$Payment$Type.SUBSCRIPTION, iMicroAmountToMinor, iMicroAmountToMinor2, lowerCase, true));
        GiftingUtils$buyGift$1 giftingUtils$buyGift$1 = new GiftingUtils$buyGift$1(activity, billingFlowParamsA);
        if (storeStream$Companion.getGooglePlayPurchases().hasSeenGiftingWarning()) {
            giftingUtils$buyGift$1.invoke2();
            return;
        }
        WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        m.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        String string = activity.getString(2131888438);
        String string2 = activity.getString(2131889760);
        m.checkNotNullExpressionValue(string2, "activity.getString(R.str…gle_play_notice_extended)");
        WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion, supportFragmentManager, string, string2, activity.getString(2131886572), activity.getString(2131893181), h0.mapOf(o.to(2131364555, new GiftingUtils$buyGift$2(inAppSku, giftingUtils$buyGift$1)), o.to(2131364550, new GiftingUtils$buyGift$3(dismissWarningCallback))), null, null, null, null, null, null, 0, new GiftingUtils$buyGift$4(dismissWarningCallback), 8128, null);
        storeStream$Companion.getGooglePlayPurchases().markViewedGiftingWarning();
    }

    public final String generateGiftUrl(String giftCode) {
        m.checkNotNullParameter(giftCode, "giftCode");
        return "https://discord.gift/" + giftCode;
    }

    public final Integer getIconForSku(GooglePlayInAppSku inAppSku) {
        m.checkNotNullParameter(inAppSku, "inAppSku");
        if (m.areEqual(inAppSku, GooglePlayInAppSkuKt.getPremiumTier1Month())) {
            return 2131232028;
        }
        if (m.areEqual(inAppSku, GooglePlayInAppSkuKt.getPremiumTier1Year())) {
            return 2131232030;
        }
        if (m.areEqual(inAppSku, GooglePlayInAppSkuKt.getPremiumTier2Month())) {
            return 2131232031;
        }
        return m.areEqual(inAppSku, GooglePlayInAppSkuKt.getPremiumTier2Year()) ? 2131232032 : null;
    }

    public final PremiumTier getTierForSku(Long skuId) {
        if (skuId != null && skuId.longValue() == ModelSkuKt.PREMIUM_TIER_1_SKU_ID) {
            return PremiumTier.TIER_1;
        }
        if (skuId != null && skuId.longValue() == ModelSkuKt.PREMIUM_TIER_2_SKU_ID) {
            return PremiumTier.TIER_2;
        }
        return null;
    }

    public final CharSequence getTimeString(long millis, Context context) {
        m.checkNotNullParameter(context, "context");
        TimeUtils timeUtils = TimeUtils.INSTANCE;
        int hoursFromMillis = timeUtils.getHoursFromMillis(millis);
        if (hoursFromMillis > 0) {
            return DurationUtilsKt.formatDuration(context, DurationUnit.HOURS, hoursFromMillis);
        }
        return DurationUtilsKt.formatDuration(context, DurationUnit.MINS, timeUtils.getMinutesFromMillis(millis));
    }
}

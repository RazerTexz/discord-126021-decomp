package com.discord.utilities.billing;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.discord.app.AppActivity;
import com.discord.app.AppLog;
import com.discord.stores.StoreGooglePlaySkuDetails;
import com.discord.stores.StoreStream;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ActivityLifecycleCallbacks;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p101a.p102a.C1614a;
import p007b.p100d.p101a.p102a.C1619d;
import p007b.p100d.p101a.p102a.C1623h;
import p007b.p100d.p101a.p102a.InterfaceC1616b;
import p007b.p100d.p101a.p102a.InterfaceC1620e;
import p007b.p100d.p101a.p102a.InterfaceC1621f;
import p007b.p100d.p101a.p102a.InterfaceC1622g;
import p007b.p100d.p101a.p102a.InterfaceC1624i;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: GooglePlayBillingManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GooglePlayBillingManager implements InterfaceC1622g, InterfaceC1616b, InterfaceC1624i, InterfaceC1620e {
    private static final long DEFAULT_BACKOFF_TIME_MS = 1000;
    public static final String PLAY_STORE_SUBSCRIPTION_DEEPLINK_URL = "https://play.google.com/store/account/subscriptions?sku=%s&package=%s";
    public static final String PLAY_STORE_SUBSCRIPTION_URL = "https://play.google.com/store/account/subscriptions";
    private static BillingClient billingClient;
    private static boolean isAuthenticated;
    public static final GooglePlayBillingManager INSTANCE = new GooglePlayBillingManager();
    private static AtomicLong backoffTimeMs = new AtomicLong(1000);
    private static Map<String, InAppSkuToConsume> inAppSkusToConsume = new HashMap();

    /* JADX INFO: compiled from: GooglePlayBillingManager.kt */
    public static final class GooglePlayBillingManagerLifecycleListener extends ActivityLifecycleCallbacks {
        @Override // com.discord.utilities.p501rx.ActivityLifecycleCallbacks
        public void onActivityCreated(AppActivity activity, Bundle savedInstanceState) {
            C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            super.onActivityCreated(activity, savedInstanceState);
            C0870j c0870j = C0870j.f524g;
            if (activity.m8347g(C0870j.f523f)) {
                GooglePlayBillingManager googlePlayBillingManager = GooglePlayBillingManager.INSTANCE;
                if (GooglePlayBillingManager.access$isAuthenticated$p(googlePlayBillingManager)) {
                    googlePlayBillingManager.onActivityCreated();
                }
            }
        }

        @Override // com.discord.utilities.p501rx.ActivityLifecycleCallbacks
        public void onActivityDestroyed(AppActivity activity) {
            C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            super.onActivityDestroyed(activity);
            C0870j c0870j = C0870j.f524g;
            if (activity.m8347g(C0870j.f523f)) {
                GooglePlayBillingManager.INSTANCE.onActivityDestroyed();
            }
        }

        @Override // com.discord.utilities.p501rx.ActivityLifecycleCallbacks
        public void onActivityResumed(AppActivity activity) {
            C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            super.onActivityResumed(activity);
            C0870j c0870j = C0870j.f524g;
            if (activity.m8347g(C0870j.f523f)) {
                GooglePlayBillingManager googlePlayBillingManager = GooglePlayBillingManager.INSTANCE;
                if (GooglePlayBillingManager.access$isAuthenticated$p(googlePlayBillingManager)) {
                    googlePlayBillingManager.queryPurchases();
                }
            }
        }
    }

    /* JADX INFO: compiled from: GooglePlayBillingManager.kt */
    public static final /* data */ class InAppSkuToConsume {
        private final String paymentGatewaySkuId;
        private final Long skuId;
        private final InAppSkuType type;

        public InAppSkuToConsume(InAppSkuType inAppSkuType, Long l, String str) {
            C12238m.checkNotNullParameter(inAppSkuType, "type");
            C12238m.checkNotNullParameter(str, "paymentGatewaySkuId");
            this.type = inAppSkuType;
            this.skuId = l;
            this.paymentGatewaySkuId = str;
        }

        public static /* synthetic */ InAppSkuToConsume copy$default(InAppSkuToConsume inAppSkuToConsume, InAppSkuType inAppSkuType, Long l, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                inAppSkuType = inAppSkuToConsume.type;
            }
            if ((i & 2) != 0) {
                l = inAppSkuToConsume.skuId;
            }
            if ((i & 4) != 0) {
                str = inAppSkuToConsume.paymentGatewaySkuId;
            }
            return inAppSkuToConsume.copy(inAppSkuType, l, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final InAppSkuType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getSkuId() {
            return this.skuId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPaymentGatewaySkuId() {
            return this.paymentGatewaySkuId;
        }

        public final InAppSkuToConsume copy(InAppSkuType type, Long skuId, String paymentGatewaySkuId) {
            C12238m.checkNotNullParameter(type, "type");
            C12238m.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
            return new InAppSkuToConsume(type, skuId, paymentGatewaySkuId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InAppSkuToConsume)) {
                return false;
            }
            InAppSkuToConsume inAppSkuToConsume = (InAppSkuToConsume) other;
            return C12238m.areEqual(this.type, inAppSkuToConsume.type) && C12238m.areEqual(this.skuId, inAppSkuToConsume.skuId) && C12238m.areEqual(this.paymentGatewaySkuId, inAppSkuToConsume.paymentGatewaySkuId);
        }

        public final String getPaymentGatewaySkuId() {
            return this.paymentGatewaySkuId;
        }

        public final Long getSkuId() {
            return this.skuId;
        }

        public final InAppSkuType getType() {
            return this.type;
        }

        public int hashCode() {
            InAppSkuType inAppSkuType = this.type;
            int iHashCode = (inAppSkuType != null ? inAppSkuType.hashCode() : 0) * 31;
            Long l = this.skuId;
            int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
            String str = this.paymentGatewaySkuId;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("InAppSkuToConsume(type=");
            sbM833U.append(this.type);
            sbM833U.append(", skuId=");
            sbM833U.append(this.skuId);
            sbM833U.append(", paymentGatewaySkuId=");
            return C1643a.m822J(sbM833U, this.paymentGatewaySkuId, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            InAppSkuType.values();
            int[] iArr = new int[1];
            $EnumSwitchMapping$0 = iArr;
            InAppSkuType inAppSkuType = InAppSkuType.PREMIUM_GIFT;
            iArr[inAppSkuType.ordinal()] = 1;
            InAppSkuType.values();
            int[] iArr2 = new int[1];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[inAppSkuType.ordinal()] = 1;
            InAppSkuType.values();
            $EnumSwitchMapping$2 = new int[1];
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.billing.GooglePlayBillingManager$init$1 */
    /* JADX INFO: compiled from: GooglePlayBillingManager.kt */
    public static final class C67061 extends AbstractC12240o implements Function1<Boolean, Unit> {
        public static final C67061 INSTANCE = new C67061();

        public C67061() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            GooglePlayBillingManager googlePlayBillingManager = GooglePlayBillingManager.INSTANCE;
            GooglePlayBillingManager.isAuthenticated = z2;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.billing.GooglePlayBillingManager$onBillingServiceDisconnected$1 */
    /* JADX INFO: compiled from: GooglePlayBillingManager.kt */
    public static final class C67071 extends AbstractC12240o implements Function1<Long, Unit> {
        public final /* synthetic */ long $currentBackoffTimeMs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67071(long j) {
            super(1);
            this.$currentBackoffTimeMs = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            GooglePlayBillingManager googlePlayBillingManager = GooglePlayBillingManager.INSTANCE;
            if (GooglePlayBillingManager.access$getBillingClient$p(googlePlayBillingManager).mo802d()) {
                return;
            }
            GooglePlayBillingManager.access$getBillingClient$p(googlePlayBillingManager).mo806h(googlePlayBillingManager);
            GooglePlayBillingManager.access$getBackoffTimeMs$p(googlePlayBillingManager).set(this.$currentBackoffTimeMs * ((long) 2));
        }
    }

    private GooglePlayBillingManager() {
    }

    public static final /* synthetic */ AtomicLong access$getBackoffTimeMs$p(GooglePlayBillingManager googlePlayBillingManager) {
        return backoffTimeMs;
    }

    public static final /* synthetic */ BillingClient access$getBillingClient$p(GooglePlayBillingManager googlePlayBillingManager) {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            C12238m.throwUninitializedPropertyAccessException("billingClient");
        }
        return billingClient2;
    }

    public static final /* synthetic */ boolean access$isAuthenticated$p(GooglePlayBillingManager googlePlayBillingManager) {
        return isAuthenticated;
    }

    private final void handleConsumeEnd(String purchaseToken) {
        InAppSkuToConsume inAppSkuToConsume = inAppSkusToConsume.get(purchaseToken);
        if (inAppSkuToConsume != null) {
            inAppSkuToConsume.getType();
        }
    }

    private final void handleConsumeFailure(String purchaseToken) {
        InAppSkuToConsume inAppSkuToConsume = inAppSkusToConsume.get(purchaseToken);
        if (inAppSkuToConsume != null) {
            StoreStream.INSTANCE.getGooglePlayPurchases().trackPaymentFlowFailed(inAppSkuToConsume.getPaymentGatewaySkuId());
        }
    }

    private final void handleConsumeStart(Purchase purchase, InAppSkuToConsume inAppSkuToConsume) {
        Map<String, InAppSkuToConsume> map = inAppSkusToConsume;
        String strM7497a = purchase.m7497a();
        C12238m.checkNotNullExpressionValue(strM7497a, "purchase.purchaseToken");
        map.put(strM7497a, inAppSkuToConsume);
        if (inAppSkuToConsume.getType().ordinal() != 0) {
            throw new NoWhenBranchMatchedException();
        }
        KotlinExtensionsKt.getExhaustive(Unit.f27425a);
    }

    private final void handleConsumeSuccess(String purchaseToken) {
        InAppSkuToConsume inAppSkuToConsume = inAppSkusToConsume.get(purchaseToken);
        if (inAppSkuToConsume != null) {
            StoreStream.INSTANCE.getGooglePlayPurchases().trackPaymentFlowCompleted(inAppSkuToConsume.getPaymentGatewaySkuId());
            if (inAppSkuToConsume.getType().ordinal() != 0) {
                throw new NoWhenBranchMatchedException();
            }
            KotlinExtensionsKt.getExhaustive(Unit.f27425a);
        }
    }

    private final void queryInAppSkuDetails() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            C12238m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.mo802d()) {
            List<GooglePlayInAppSku> skus = GooglePlayInAppSkus.INSTANCE.getSkus();
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(skus, 10));
            Iterator<T> it = skus.iterator();
            while (it.hasNext()) {
                arrayList.add(((GooglePlayInAppSku) it.next()).getPaymentGatewaySkuId());
            }
            ArrayList arrayList2 = new ArrayList(arrayList);
            C1623h c1623h = new C1623h();
            c1623h.f2959a = "inapp";
            c1623h.f2960b = arrayList2;
            C12238m.checkNotNullExpressionValue(c1623h, "SkuDetailsParams.newBuil…kuNames)\n        .build()");
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                C12238m.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.mo805g(c1623h, this);
        }
    }

    public final void consumePurchase(Purchase purchase, InAppSkuType inAppSkuType, Long skuId) {
        C12238m.checkNotNullParameter(purchase, "purchase");
        C12238m.checkNotNullParameter(inAppSkuType, "inAppSkuType");
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            C12238m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.mo802d()) {
            String strM7497a = purchase.m7497a();
            if (strM7497a == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            }
            C1619d c1619d = new C1619d();
            c1619d.f2958a = strM7497a;
            C12238m.checkNotNullExpressionValue(c1619d, "ConsumeParams.newBuilder…se.purchaseToken).build()");
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                C12238m.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.mo799a(c1619d, this);
            ArrayList<String> arrayListM7498b = purchase.m7498b();
            C12238m.checkNotNullExpressionValue(arrayListM7498b, "purchase.skus");
            for (String str : arrayListM7498b) {
                GooglePlayBillingManager googlePlayBillingManager = INSTANCE;
                C12238m.checkNotNullExpressionValue(str, "sku");
                googlePlayBillingManager.handleConsumeStart(purchase, new InAppSkuToConsume(inAppSkuType, skuId, str));
            }
        }
    }

    public final void init(Application application) {
        C12238m.checkNotNullParameter(application, "application");
        Context applicationContext = application.getApplicationContext();
        if (applicationContext == null) {
            throw new IllegalArgumentException("Please provide a valid Context.");
        }
        C1614a c1614a = new C1614a(null, true, applicationContext, this);
        C12238m.checkNotNullExpressionValue(c1614a, "BillingClient.newBuilder…chases()\n        .build()");
        billingClient = c1614a;
        application.registerActivityLifecycleCallbacks(new GooglePlayBillingManagerLifecycleListener());
        ObservableExtensionsKt.appSubscribe(StoreStream.INSTANCE.getAuthentication().observeIsAuthed$app_productionGoogleRelease(), (Class<?>) GooglePlayBillingManager.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C67061.INSTANCE);
    }

    public final int launchBillingFlow(Activity activity, BillingFlowParams params) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        C12238m.checkNotNullParameter(params, "params");
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            C12238m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (!billingClient2.mo802d()) {
            return -1;
        }
        BillingClient billingClient3 = billingClient;
        if (billingClient3 == null) {
            C12238m.throwUninitializedPropertyAccessException("billingClient");
        }
        BillingResult billingResultMo803e = billingClient3.mo803e(activity, params);
        C12238m.checkNotNullExpressionValue(billingResultMo803e, "billingClient.launchBillingFlow(activity, params)");
        return billingResultMo803e.f14557a;
    }

    public final void onActivityCreated() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            C12238m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.mo802d()) {
            return;
        }
        BillingClient billingClient3 = billingClient;
        if (billingClient3 == null) {
            C12238m.throwUninitializedPropertyAccessException("billingClient");
        }
        billingClient3.mo806h(this);
    }

    public final void onActivityDestroyed() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            C12238m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.mo802d()) {
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                C12238m.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.mo800b();
        }
    }

    @Override // p007b.p100d.p101a.p102a.InterfaceC1616b
    public void onBillingServiceDisconnected() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            C12238m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.mo801c() != 0) {
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                C12238m.throwUninitializedPropertyAccessException("billingClient");
            }
            if (billingClient3.mo801c() != 3) {
                return;
            }
        }
        long j = backoffTimeMs.get();
        Observable<Long> observableM11068d0 = Observable.m11068d0(j, TimeUnit.MILLISECONDS);
        C12238m.checkNotNullExpressionValue(observableM11068d0, "Observable\n          .ti…s, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(observableM11068d0, (Class<?>) GooglePlayBillingManager.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C67071(j));
    }

    @Override // p007b.p100d.p101a.p102a.InterfaceC1616b
    public void onBillingSetupFinished(BillingResult billingResult) {
        C12238m.checkNotNullParameter(billingResult, "billingResult");
        if (billingResult.f14557a == 0) {
            querySkuDetails();
            queryInAppSkuDetails();
            queryPurchases();
            backoffTimeMs.set(1000L);
        }
    }

    @Override // p007b.p100d.p101a.p102a.InterfaceC1620e
    public void onConsumeResponse(BillingResult billingResult, String purchaseToken) {
        C12238m.checkNotNullParameter(billingResult, "billingResult");
        C12238m.checkNotNullParameter(purchaseToken, "purchaseToken");
        if (billingResult.f14557a == 0) {
            handleConsumeSuccess(purchaseToken);
        } else {
            handleConsumeFailure(purchaseToken);
            AppLog appLog = AppLog.f14950g;
            StringBuilder sbM836X = C1643a.m836X("Failed to consume purchase. ", "Billing Response Code: ");
            sbM836X.append(billingResult.f14557a);
            sbM836X.append(", ");
            sbM836X.append("Purchase Token: ");
            sbM836X.append(purchaseToken);
            Logger.e$default(appLog, sbM836X.toString(), null, null, 6, null);
        }
        handleConsumeEnd(purchaseToken);
    }

    @Override // p007b.p100d.p101a.p102a.InterfaceC1622g
    public void onPurchasesUpdated(BillingResult billingResult, List<? extends Purchase> purchases) {
        boolean z2;
        C12238m.checkNotNullParameter(billingResult, "billingResult");
        if (billingResult.f14557a != 0) {
            StoreStream.INSTANCE.getGooglePlayPurchases().updatePendingDowngrade(null);
        }
        int i = billingResult.f14557a;
        if (i != 0) {
            if (i == 1) {
                AppLog.m8358i("onPurchasesUpdated: User canceled the purchase");
                return;
            } else if (i == 5) {
                Logger.e$default(AppLog.f14950g, "onPurchasesUpdated: Google Play doesn't recognize this app config. Verify the SKU product ID and the signed APK you are using.", null, null, 6, null);
                return;
            } else {
                if (i != 7) {
                    return;
                }
                AppLog.m8358i("onPurchasesUpdated: The user already owns this item");
                return;
            }
        }
        if (purchases == null || purchases.isEmpty()) {
            StoreStream.INSTANCE.getGooglePlayPurchases().downgradePurchase();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (purchases != null) {
            for (Purchase purchase : purchases) {
                ArrayList<String> arrayListM7498b = purchase.m7498b();
                C12238m.checkNotNullExpressionValue(arrayListM7498b, "purchase.skus");
                if (arrayListM7498b.isEmpty()) {
                    z2 = false;
                    break;
                }
                Iterator<T> it = arrayListM7498b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    String str = (String) it.next();
                    GooglePlayInAppSkus googlePlayInAppSkus = GooglePlayInAppSkus.INSTANCE;
                    C12238m.checkNotNullExpressionValue(str, "sku");
                    if (googlePlayInAppSkus.isInAppSku(str)) {
                        z2 = true;
                        break;
                    }
                }
                if (z2) {
                    arrayList2.add(purchase);
                } else {
                    arrayList.add(purchase);
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            StoreStream.INSTANCE.getGooglePlayPurchases().processPurchases(arrayList2, "inapp");
        }
        if (!arrayList.isEmpty()) {
            StoreStream.INSTANCE.getGooglePlayPurchases().processPurchases(arrayList, "subs");
        }
    }

    @Override // p007b.p100d.p101a.p102a.InterfaceC1624i
    public void onSkuDetailsResponse(BillingResult billingResult, List<? extends SkuDetails> skuDetails) {
        C12238m.checkNotNullParameter(billingResult, "billingResult");
        int i = billingResult.f14557a;
        String str = billingResult.f14558b;
        C12238m.checkNotNullExpressionValue(str, "billingResult.debugMessage");
        switch (i) {
            case -2:
            case 1:
            case 7:
            case 8:
                StoreStream.INSTANCE.getGooglePlaySkuDetails().handleError();
                Logger.e$default(AppLog.f14950g, "onSkuDetailsResponse: " + i + ' ' + str, null, null, 6, null);
                break;
            case -1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                StoreStream.INSTANCE.getGooglePlaySkuDetails().handleError();
                break;
            case 0:
                StoreGooglePlaySkuDetails googlePlaySkuDetails = StoreStream.INSTANCE.getGooglePlaySkuDetails();
                if (skuDetails == null) {
                    skuDetails = C12147n.emptyList();
                }
                googlePlaySkuDetails.updateSkuDetails(skuDetails);
                break;
        }
    }

    public final void queryPurchases() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            C12238m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.mo802d()) {
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                C12238m.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.mo804f("subs", new InterfaceC1621f() { // from class: com.discord.utilities.billing.GooglePlayBillingManager.queryPurchases.1
                @Override // p007b.p100d.p101a.p102a.InterfaceC1621f
                public final void onQueryPurchasesResponse(BillingResult billingResult, List<Purchase> list) {
                    C12238m.checkNotNullParameter(billingResult, "<anonymous parameter 0>");
                    C12238m.checkNotNullParameter(list, "purchasesList");
                    StoreStream.INSTANCE.getGooglePlayPurchases().processPurchases(list, "subs");
                }
            });
            BillingClient billingClient4 = billingClient;
            if (billingClient4 == null) {
                C12238m.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient4.mo804f("inapp", new InterfaceC1621f() { // from class: com.discord.utilities.billing.GooglePlayBillingManager.queryPurchases.2
                @Override // p007b.p100d.p101a.p102a.InterfaceC1621f
                public final void onQueryPurchasesResponse(BillingResult billingResult, List<Purchase> list) {
                    C12238m.checkNotNullParameter(billingResult, "<anonymous parameter 0>");
                    C12238m.checkNotNullParameter(list, "purchasesList");
                    StoreStream.INSTANCE.getGooglePlayPurchases().processPurchases(list, "inapp");
                }
            });
        }
    }

    public final void querySkuDetails() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            C12238m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.mo802d()) {
            ArrayList arrayList = new ArrayList(GooglePlaySku.INSTANCE.getALL_SKU_NAMES());
            C1623h c1623h = new C1623h();
            c1623h.f2959a = "subs";
            c1623h.f2960b = arrayList;
            C12238m.checkNotNullExpressionValue(c1623h, "SkuDetailsParams.newBuil…U_NAMES)\n        .build()");
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                C12238m.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.mo805g(c1623h, this);
        }
    }
}

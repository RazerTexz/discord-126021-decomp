package com.discord.utilities.billing;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import b.a.d.AppScreen2;
import b.d.a.a.a;
import b.d.a.a.b;
import b.d.a.a.d;
import b.d.a.a.e;
import b.d.a.a.f;
import b.d.a.a.g;
import b.d.a.a.h;
import b.d.a.a.i;
import b.d.b.a.outline;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.discord.app.AppActivity;
import com.discord.app.AppLog;
import com.discord.stores.StoreGooglePlaySkuDetails;
import com.discord.stores.StoreStream;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ActivityLifecycleCallbacks;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
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
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: GooglePlayBillingManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GooglePlayBillingManager implements g, b, i, e {
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
        @Override // com.discord.utilities.rx.ActivityLifecycleCallbacks
        public void onActivityCreated(AppActivity activity, Bundle savedInstanceState) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            super.onActivityCreated(activity, savedInstanceState);
            AppScreen2 appScreen2 = AppScreen2.g;
            if (activity.g(AppScreen2.f)) {
                GooglePlayBillingManager googlePlayBillingManager = GooglePlayBillingManager.INSTANCE;
                if (GooglePlayBillingManager.access$isAuthenticated$p(googlePlayBillingManager)) {
                    googlePlayBillingManager.onActivityCreated();
                }
            }
        }

        @Override // com.discord.utilities.rx.ActivityLifecycleCallbacks
        public void onActivityDestroyed(AppActivity activity) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            super.onActivityDestroyed(activity);
            AppScreen2 appScreen2 = AppScreen2.g;
            if (activity.g(AppScreen2.f)) {
                GooglePlayBillingManager.INSTANCE.onActivityDestroyed();
            }
        }

        @Override // com.discord.utilities.rx.ActivityLifecycleCallbacks
        public void onActivityResumed(AppActivity activity) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            super.onActivityResumed(activity);
            AppScreen2 appScreen2 = AppScreen2.g;
            if (activity.g(AppScreen2.f)) {
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
        private final GooglePlayInAppSku4 type;

        public InAppSkuToConsume(GooglePlayInAppSku4 googlePlayInAppSku4, Long l, String str) {
            Intrinsics3.checkNotNullParameter(googlePlayInAppSku4, "type");
            Intrinsics3.checkNotNullParameter(str, "paymentGatewaySkuId");
            this.type = googlePlayInAppSku4;
            this.skuId = l;
            this.paymentGatewaySkuId = str;
        }

        public static /* synthetic */ InAppSkuToConsume copy$default(InAppSkuToConsume inAppSkuToConsume, GooglePlayInAppSku4 googlePlayInAppSku4, Long l, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                googlePlayInAppSku4 = inAppSkuToConsume.type;
            }
            if ((i & 2) != 0) {
                l = inAppSkuToConsume.skuId;
            }
            if ((i & 4) != 0) {
                str = inAppSkuToConsume.paymentGatewaySkuId;
            }
            return inAppSkuToConsume.copy(googlePlayInAppSku4, l, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final GooglePlayInAppSku4 getType() {
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

        public final InAppSkuToConsume copy(GooglePlayInAppSku4 type, Long skuId, String paymentGatewaySkuId) {
            Intrinsics3.checkNotNullParameter(type, "type");
            Intrinsics3.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
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
            return Intrinsics3.areEqual(this.type, inAppSkuToConsume.type) && Intrinsics3.areEqual(this.skuId, inAppSkuToConsume.skuId) && Intrinsics3.areEqual(this.paymentGatewaySkuId, inAppSkuToConsume.paymentGatewaySkuId);
        }

        public final String getPaymentGatewaySkuId() {
            return this.paymentGatewaySkuId;
        }

        public final Long getSkuId() {
            return this.skuId;
        }

        public final GooglePlayInAppSku4 getType() {
            return this.type;
        }

        public int hashCode() {
            GooglePlayInAppSku4 googlePlayInAppSku4 = this.type;
            int iHashCode = (googlePlayInAppSku4 != null ? googlePlayInAppSku4.hashCode() : 0) * 31;
            Long l = this.skuId;
            int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
            String str = this.paymentGatewaySkuId;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("InAppSkuToConsume(type=");
            sbU.append(this.type);
            sbU.append(", skuId=");
            sbU.append(this.skuId);
            sbU.append(", paymentGatewaySkuId=");
            return outline.J(sbU, this.paymentGatewaySkuId, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            GooglePlayInAppSku4.values();
            int[] iArr = new int[1];
            $EnumSwitchMapping$0 = iArr;
            GooglePlayInAppSku4 googlePlayInAppSku4 = GooglePlayInAppSku4.PREMIUM_GIFT;
            iArr[googlePlayInAppSku4.ordinal()] = 1;
            GooglePlayInAppSku4.values();
            int[] iArr2 = new int[1];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[googlePlayInAppSku4.ordinal()] = 1;
            GooglePlayInAppSku4.values();
            $EnumSwitchMapping$2 = new int[1];
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.billing.GooglePlayBillingManager$init$1, reason: invalid class name */
    /* JADX INFO: compiled from: GooglePlayBillingManager.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            GooglePlayBillingManager googlePlayBillingManager = GooglePlayBillingManager.INSTANCE;
            GooglePlayBillingManager.isAuthenticated = z2;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.billing.GooglePlayBillingManager$onBillingServiceDisconnected$1, reason: invalid class name */
    /* JADX INFO: compiled from: GooglePlayBillingManager.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ long $currentBackoffTimeMs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$currentBackoffTimeMs = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            GooglePlayBillingManager googlePlayBillingManager = GooglePlayBillingManager.INSTANCE;
            if (GooglePlayBillingManager.access$getBillingClient$p(googlePlayBillingManager).d()) {
                return;
            }
            GooglePlayBillingManager.access$getBillingClient$p(googlePlayBillingManager).h(googlePlayBillingManager);
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
            Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
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
        String strA = purchase.a();
        Intrinsics3.checkNotNullExpressionValue(strA, "purchase.purchaseToken");
        map.put(strA, inAppSkuToConsume);
        if (inAppSkuToConsume.getType().ordinal() != 0) {
            throw new NoWhenBranchMatchedException();
        }
        KotlinExtensions.getExhaustive(Unit.a);
    }

    private final void handleConsumeSuccess(String purchaseToken) {
        InAppSkuToConsume inAppSkuToConsume = inAppSkusToConsume.get(purchaseToken);
        if (inAppSkuToConsume != null) {
            StoreStream.INSTANCE.getGooglePlayPurchases().trackPaymentFlowCompleted(inAppSkuToConsume.getPaymentGatewaySkuId());
            if (inAppSkuToConsume.getType().ordinal() != 0) {
                throw new NoWhenBranchMatchedException();
            }
            KotlinExtensions.getExhaustive(Unit.a);
        }
    }

    private final void queryInAppSkuDetails() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            List<GooglePlayInAppSku> skus = GooglePlayInAppSku3.INSTANCE.getSkus();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(skus, 10));
            Iterator<T> it = skus.iterator();
            while (it.hasNext()) {
                arrayList.add(((GooglePlayInAppSku) it.next()).getPaymentGatewaySkuId());
            }
            ArrayList arrayList2 = new ArrayList(arrayList);
            h hVar = new h();
            hVar.a = "inapp";
            hVar.f450b = arrayList2;
            Intrinsics3.checkNotNullExpressionValue(hVar, "SkuDetailsParams.newBuil…kuNames)\n        .build()");
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.g(hVar, this);
        }
    }

    public final void consumePurchase(Purchase purchase, GooglePlayInAppSku4 inAppSkuType, Long skuId) {
        Intrinsics3.checkNotNullParameter(purchase, "purchase");
        Intrinsics3.checkNotNullParameter(inAppSkuType, "inAppSkuType");
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            String strA = purchase.a();
            if (strA == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            }
            d dVar = new d();
            dVar.a = strA;
            Intrinsics3.checkNotNullExpressionValue(dVar, "ConsumeParams.newBuilder…se.purchaseToken).build()");
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.a(dVar, this);
            ArrayList<String> arrayListB = purchase.b();
            Intrinsics3.checkNotNullExpressionValue(arrayListB, "purchase.skus");
            for (String str : arrayListB) {
                GooglePlayBillingManager googlePlayBillingManager = INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(str, "sku");
                googlePlayBillingManager.handleConsumeStart(purchase, new InAppSkuToConsume(inAppSkuType, skuId, str));
            }
        }
    }

    public final void init(Application application) {
        Intrinsics3.checkNotNullParameter(application, "application");
        Context applicationContext = application.getApplicationContext();
        if (applicationContext == null) {
            throw new IllegalArgumentException("Please provide a valid Context.");
        }
        a aVar = new a(null, true, applicationContext, this);
        Intrinsics3.checkNotNullExpressionValue(aVar, "BillingClient.newBuilder…chases()\n        .build()");
        billingClient = aVar;
        application.registerActivityLifecycleCallbacks(new GooglePlayBillingManagerLifecycleListener());
        ObservableExtensionsKt.appSubscribe(StoreStream.INSTANCE.getAuthentication().observeIsAuthed$app_productionGoogleRelease(), (Class<?>) GooglePlayBillingManager.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass1.INSTANCE);
    }

    public final int launchBillingFlow(Activity activity, BillingFlowParams params) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(params, "params");
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
        }
        if (!billingClient2.d()) {
            return -1;
        }
        BillingClient billingClient3 = billingClient;
        if (billingClient3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
        }
        BillingResult billingResultE = billingClient3.e(activity, params);
        Intrinsics3.checkNotNullExpressionValue(billingResultE, "billingClient.launchBillingFlow(activity, params)");
        return billingResultE.a;
    }

    public final void onActivityCreated() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            return;
        }
        BillingClient billingClient3 = billingClient;
        if (billingClient3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
        }
        billingClient3.h(this);
    }

    public final void onActivityDestroyed() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.b();
        }
    }

    @Override // b.d.a.a.b
    public void onBillingServiceDisconnected() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.c() != 0) {
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
            }
            if (billingClient3.c() != 3) {
                return;
            }
        }
        long j = backoffTimeMs.get();
        Observable<Long> observableD0 = Observable.d0(j, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n          .ti…s, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(observableD0, (Class<?>) GooglePlayBillingManager.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(j));
    }

    @Override // b.d.a.a.b
    public void onBillingSetupFinished(BillingResult billingResult) {
        Intrinsics3.checkNotNullParameter(billingResult, "billingResult");
        if (billingResult.a == 0) {
            querySkuDetails();
            queryInAppSkuDetails();
            queryPurchases();
            backoffTimeMs.set(1000L);
        }
    }

    @Override // b.d.a.a.e
    public void onConsumeResponse(BillingResult billingResult, String purchaseToken) {
        Intrinsics3.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics3.checkNotNullParameter(purchaseToken, "purchaseToken");
        if (billingResult.a == 0) {
            handleConsumeSuccess(purchaseToken);
        } else {
            handleConsumeFailure(purchaseToken);
            AppLog appLog = AppLog.g;
            StringBuilder sbX = outline.X("Failed to consume purchase. ", "Billing Response Code: ");
            sbX.append(billingResult.a);
            sbX.append(", ");
            sbX.append("Purchase Token: ");
            sbX.append(purchaseToken);
            Logger.e$default(appLog, sbX.toString(), null, null, 6, null);
        }
        handleConsumeEnd(purchaseToken);
    }

    @Override // b.d.a.a.g
    public void onPurchasesUpdated(BillingResult billingResult, List<? extends Purchase> purchases) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(billingResult, "billingResult");
        if (billingResult.a != 0) {
            StoreStream.INSTANCE.getGooglePlayPurchases().updatePendingDowngrade(null);
        }
        int i = billingResult.a;
        if (i != 0) {
            if (i == 1) {
                AppLog.i("onPurchasesUpdated: User canceled the purchase");
                return;
            } else if (i == 5) {
                Logger.e$default(AppLog.g, "onPurchasesUpdated: Google Play doesn't recognize this app config. Verify the SKU product ID and the signed APK you are using.", null, null, 6, null);
                return;
            } else {
                if (i != 7) {
                    return;
                }
                AppLog.i("onPurchasesUpdated: The user already owns this item");
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
                ArrayList<String> arrayListB = purchase.b();
                Intrinsics3.checkNotNullExpressionValue(arrayListB, "purchase.skus");
                if (arrayListB.isEmpty()) {
                    z2 = false;
                    break;
                }
                Iterator<T> it = arrayListB.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    String str = (String) it.next();
                    GooglePlayInAppSku3 googlePlayInAppSku3 = GooglePlayInAppSku3.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(str, "sku");
                    if (googlePlayInAppSku3.isInAppSku(str)) {
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

    @Override // b.d.a.a.i
    public void onSkuDetailsResponse(BillingResult billingResult, List<? extends SkuDetails> skuDetails) {
        Intrinsics3.checkNotNullParameter(billingResult, "billingResult");
        int i = billingResult.a;
        String str = billingResult.f2003b;
        Intrinsics3.checkNotNullExpressionValue(str, "billingResult.debugMessage");
        switch (i) {
            case -2:
            case 1:
            case 7:
            case 8:
                StoreStream.INSTANCE.getGooglePlaySkuDetails().handleError();
                Logger.e$default(AppLog.g, "onSkuDetailsResponse: " + i + ' ' + str, null, null, 6, null);
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
                    skuDetails = Collections2.emptyList();
                }
                googlePlaySkuDetails.updateSkuDetails(skuDetails);
                break;
        }
    }

    public final void queryPurchases() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.f("subs", new f() { // from class: com.discord.utilities.billing.GooglePlayBillingManager.queryPurchases.1
                @Override // b.d.a.a.f
                public final void onQueryPurchasesResponse(BillingResult billingResult, List<Purchase> list) {
                    Intrinsics3.checkNotNullParameter(billingResult, "<anonymous parameter 0>");
                    Intrinsics3.checkNotNullParameter(list, "purchasesList");
                    StoreStream.INSTANCE.getGooglePlayPurchases().processPurchases(list, "subs");
                }
            });
            BillingClient billingClient4 = billingClient;
            if (billingClient4 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient4.f("inapp", new f() { // from class: com.discord.utilities.billing.GooglePlayBillingManager.queryPurchases.2
                @Override // b.d.a.a.f
                public final void onQueryPurchasesResponse(BillingResult billingResult, List<Purchase> list) {
                    Intrinsics3.checkNotNullParameter(billingResult, "<anonymous parameter 0>");
                    Intrinsics3.checkNotNullParameter(list, "purchasesList");
                    StoreStream.INSTANCE.getGooglePlayPurchases().processPurchases(list, "inapp");
                }
            });
        }
    }

    public final void querySkuDetails() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            ArrayList arrayList = new ArrayList(GooglePlaySku.INSTANCE.getALL_SKU_NAMES());
            h hVar = new h();
            hVar.a = "subs";
            hVar.f450b = arrayList;
            Intrinsics3.checkNotNullExpressionValue(hVar, "SkuDetailsParams.newBuil…U_NAMES)\n        .build()");
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.g(hVar, this);
        }
    }
}

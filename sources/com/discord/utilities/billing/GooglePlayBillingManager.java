package com.discord.utilities.billing;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.appcompat.widget.ActivityChooserModel;
import b.d.a.a.a;
import b.d.a.a.b;
import b.d.a.a.d;
import b.d.a.a.e;
import b.d.a.a.g;
import b.d.a.a.h;
import b.d.a.a.i;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.discord.app.AppLog;
import com.discord.stores.StoreGooglePlaySkuDetails;
import com.discord.stores.StoreStream;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.n;
import d0.t.o;
import d0.z.d.m;
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
    private static Map<String, GooglePlayBillingManager$InAppSkuToConsume> inAppSkusToConsume = new HashMap();

    private GooglePlayBillingManager() {
    }

    public static final /* synthetic */ AtomicLong access$getBackoffTimeMs$p(GooglePlayBillingManager googlePlayBillingManager) {
        return backoffTimeMs;
    }

    public static final /* synthetic */ BillingClient access$getBillingClient$p(GooglePlayBillingManager googlePlayBillingManager) {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            m.throwUninitializedPropertyAccessException("billingClient");
        }
        return billingClient2;
    }

    public static final /* synthetic */ boolean access$isAuthenticated$p(GooglePlayBillingManager googlePlayBillingManager) {
        return isAuthenticated;
    }

    public static final /* synthetic */ void access$setAuthenticated$p(GooglePlayBillingManager googlePlayBillingManager, boolean z2) {
        isAuthenticated = z2;
    }

    public static final /* synthetic */ void access$setBackoffTimeMs$p(GooglePlayBillingManager googlePlayBillingManager, AtomicLong atomicLong) {
        backoffTimeMs = atomicLong;
    }

    public static final /* synthetic */ void access$setBillingClient$p(GooglePlayBillingManager googlePlayBillingManager, BillingClient billingClient2) {
        billingClient = billingClient2;
    }

    private final void handleConsumeEnd(String purchaseToken) {
        GooglePlayBillingManager$InAppSkuToConsume googlePlayBillingManager$InAppSkuToConsume = inAppSkusToConsume.get(purchaseToken);
        if (googlePlayBillingManager$InAppSkuToConsume != null) {
            googlePlayBillingManager$InAppSkuToConsume.getType();
        }
    }

    private final void handleConsumeFailure(String purchaseToken) {
        GooglePlayBillingManager$InAppSkuToConsume googlePlayBillingManager$InAppSkuToConsume = inAppSkusToConsume.get(purchaseToken);
        if (googlePlayBillingManager$InAppSkuToConsume != null) {
            StoreStream.Companion.getGooglePlayPurchases().trackPaymentFlowFailed(googlePlayBillingManager$InAppSkuToConsume.getPaymentGatewaySkuId());
        }
    }

    private final void handleConsumeStart(Purchase purchase, GooglePlayBillingManager$InAppSkuToConsume inAppSkuToConsume) {
        Map<String, GooglePlayBillingManager$InAppSkuToConsume> map = inAppSkusToConsume;
        String strA = purchase.a();
        m.checkNotNullExpressionValue(strA, "purchase.purchaseToken");
        map.put(strA, inAppSkuToConsume);
        if (inAppSkuToConsume.getType().ordinal() != 0) {
            throw new NoWhenBranchMatchedException();
        }
        KotlinExtensionsKt.getExhaustive(Unit.a);
    }

    private final void handleConsumeSuccess(String purchaseToken) {
        GooglePlayBillingManager$InAppSkuToConsume googlePlayBillingManager$InAppSkuToConsume = inAppSkusToConsume.get(purchaseToken);
        if (googlePlayBillingManager$InAppSkuToConsume != null) {
            StoreStream.Companion.getGooglePlayPurchases().trackPaymentFlowCompleted(googlePlayBillingManager$InAppSkuToConsume.getPaymentGatewaySkuId());
            if (googlePlayBillingManager$InAppSkuToConsume.getType().ordinal() != 0) {
                throw new NoWhenBranchMatchedException();
            }
            KotlinExtensionsKt.getExhaustive(Unit.a);
        }
    }

    private final void queryInAppSkuDetails() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            List<GooglePlayInAppSku> skus = GooglePlayInAppSkus.INSTANCE.getSkus();
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(skus, 10));
            Iterator<T> it = skus.iterator();
            while (it.hasNext()) {
                arrayList.add(((GooglePlayInAppSku) it.next()).getPaymentGatewaySkuId());
            }
            ArrayList arrayList2 = new ArrayList(arrayList);
            h hVar = new h();
            hVar.a = "inapp";
            hVar.f450b = arrayList2;
            m.checkNotNullExpressionValue(hVar, "SkuDetailsParams.newBuil…kuNames)\n        .build()");
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                m.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.g(hVar, this);
        }
    }

    public final void consumePurchase(Purchase purchase, InAppSkuType inAppSkuType, Long skuId) {
        m.checkNotNullParameter(purchase, "purchase");
        m.checkNotNullParameter(inAppSkuType, "inAppSkuType");
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            String strA = purchase.a();
            if (strA == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            }
            d dVar = new d();
            dVar.a = strA;
            m.checkNotNullExpressionValue(dVar, "ConsumeParams.newBuilder…se.purchaseToken).build()");
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                m.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.a(dVar, this);
            ArrayList<String> arrayListB = purchase.b();
            m.checkNotNullExpressionValue(arrayListB, "purchase.skus");
            for (String str : arrayListB) {
                GooglePlayBillingManager googlePlayBillingManager = INSTANCE;
                m.checkNotNullExpressionValue(str, "sku");
                googlePlayBillingManager.handleConsumeStart(purchase, new GooglePlayBillingManager$InAppSkuToConsume(inAppSkuType, skuId, str));
            }
        }
    }

    public final void init(Application application) {
        m.checkNotNullParameter(application, "application");
        Context applicationContext = application.getApplicationContext();
        if (applicationContext == null) {
            throw new IllegalArgumentException("Please provide a valid Context.");
        }
        a aVar = new a(null, true, applicationContext, this);
        m.checkNotNullExpressionValue(aVar, "BillingClient.newBuilder…chases()\n        .build()");
        billingClient = aVar;
        application.registerActivityLifecycleCallbacks(new GooglePlayBillingManager$GooglePlayBillingManagerLifecycleListener());
        ObservableExtensionsKt.appSubscribe$default(StoreStream.Companion.getAuthentication().observeIsAuthed$app_productionGoogleRelease(), GooglePlayBillingManager.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, GooglePlayBillingManager$init$1.INSTANCE, 62, (Object) null);
    }

    public final int launchBillingFlow(Activity activity, BillingFlowParams params) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(params, "params");
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (!billingClient2.d()) {
            return -1;
        }
        BillingClient billingClient3 = billingClient;
        if (billingClient3 == null) {
            m.throwUninitializedPropertyAccessException("billingClient");
        }
        BillingResult billingResultE = billingClient3.e(activity, params);
        m.checkNotNullExpressionValue(billingResultE, "billingClient.launchBillingFlow(activity, params)");
        return billingResultE.a;
    }

    public final void onActivityCreated() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            return;
        }
        BillingClient billingClient3 = billingClient;
        if (billingClient3 == null) {
            m.throwUninitializedPropertyAccessException("billingClient");
        }
        billingClient3.h(this);
    }

    public final void onActivityDestroyed() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                m.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.b();
        }
    }

    @Override // b.d.a.a.b
    public void onBillingServiceDisconnected() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.c() != 0) {
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                m.throwUninitializedPropertyAccessException("billingClient");
            }
            if (billingClient3.c() != 3) {
                return;
            }
        }
        long j = backoffTimeMs.get();
        Observable<Long> observableD0 = Observable.d0(j, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableD0, "Observable\n          .ti…s, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableD0, GooglePlayBillingManager.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GooglePlayBillingManager$onBillingServiceDisconnected$1(j), 62, (Object) null);
    }

    @Override // b.d.a.a.b
    public void onBillingSetupFinished(BillingResult billingResult) {
        m.checkNotNullParameter(billingResult, "billingResult");
        if (billingResult.a == 0) {
            querySkuDetails();
            queryInAppSkuDetails();
            queryPurchases();
            backoffTimeMs.set(1000L);
        }
    }

    @Override // b.d.a.a.e
    public void onConsumeResponse(BillingResult billingResult, String purchaseToken) {
        m.checkNotNullParameter(billingResult, "billingResult");
        m.checkNotNullParameter(purchaseToken, "purchaseToken");
        if (billingResult.a == 0) {
            handleConsumeSuccess(purchaseToken);
        } else {
            handleConsumeFailure(purchaseToken);
            AppLog appLog = AppLog.g;
            StringBuilder sbX = b.d.b.a.a.X("Failed to consume purchase. ", "Billing Response Code: ");
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
        m.checkNotNullParameter(billingResult, "billingResult");
        if (billingResult.a != 0) {
            StoreStream.Companion.getGooglePlayPurchases().updatePendingDowngrade(null);
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
            StoreStream.Companion.getGooglePlayPurchases().downgradePurchase();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (purchases != null) {
            for (Purchase purchase : purchases) {
                ArrayList<String> arrayListB = purchase.b();
                m.checkNotNullExpressionValue(arrayListB, "purchase.skus");
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
                    GooglePlayInAppSkus googlePlayInAppSkus = GooglePlayInAppSkus.INSTANCE;
                    m.checkNotNullExpressionValue(str, "sku");
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
            StoreStream.Companion.getGooglePlayPurchases().processPurchases(arrayList2, "inapp");
        }
        if (!arrayList.isEmpty()) {
            StoreStream.Companion.getGooglePlayPurchases().processPurchases(arrayList, "subs");
        }
    }

    @Override // b.d.a.a.i
    public void onSkuDetailsResponse(BillingResult billingResult, List<? extends SkuDetails> skuDetails) {
        m.checkNotNullParameter(billingResult, "billingResult");
        int i = billingResult.a;
        String str = billingResult.f2003b;
        m.checkNotNullExpressionValue(str, "billingResult.debugMessage");
        switch (i) {
            case -2:
            case 1:
            case 7:
            case 8:
                StoreStream.Companion.getGooglePlaySkuDetails().handleError();
                Logger.e$default(AppLog.g, "onSkuDetailsResponse: " + i + ' ' + str, null, null, 6, null);
                break;
            case -1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                StoreStream.Companion.getGooglePlaySkuDetails().handleError();
                break;
            case 0:
                StoreGooglePlaySkuDetails googlePlaySkuDetails = StoreStream.Companion.getGooglePlaySkuDetails();
                if (skuDetails == null) {
                    skuDetails = n.emptyList();
                }
                googlePlaySkuDetails.updateSkuDetails(skuDetails);
                break;
        }
    }

    public final void queryPurchases() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                m.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.f("subs", GooglePlayBillingManager$queryPurchases$1.INSTANCE);
            BillingClient billingClient4 = billingClient;
            if (billingClient4 == null) {
                m.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient4.f("inapp", GooglePlayBillingManager$queryPurchases$2.INSTANCE);
        }
    }

    public final void querySkuDetails() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            ArrayList arrayList = new ArrayList(GooglePlaySku.Companion.getALL_SKU_NAMES());
            h hVar = new h();
            hVar.a = "subs";
            hVar.f450b = arrayList;
            m.checkNotNullExpressionValue(hVar, "SkuDetailsParams.newBuil…U_NAMES)\n        .build()");
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                m.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.g(hVar, this);
        }
    }
}

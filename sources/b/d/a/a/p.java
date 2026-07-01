package b.d.a.a;

import com.android.billingclient.api.BillingResult;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class p {
    public static final BillingResult a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BillingResult f451b;
    public static final BillingResult c;
    public static final BillingResult d;
    public static final BillingResult e;
    public static final BillingResult f;
    public static final BillingResult g;
    public static final BillingResult h;
    public static final BillingResult i;
    public static final BillingResult j;
    public static final BillingResult k;
    public static final BillingResult l;
    public static final BillingResult m;

    static {
        BillingResult billingResult = new BillingResult();
        billingResult.a = 3;
        billingResult.f2003b = "Google Play In-app Billing API version is less than 3";
        a = billingResult;
        BillingResult billingResult2 = new BillingResult();
        billingResult2.a = 3;
        billingResult2.f2003b = "Google Play In-app Billing API version is less than 9";
        BillingResult billingResult3 = new BillingResult();
        billingResult3.a = 3;
        billingResult3.f2003b = "Billing service unavailable on device.";
        f451b = billingResult3;
        BillingResult billingResult4 = new BillingResult();
        billingResult4.a = 5;
        billingResult4.f2003b = "Client is already in the process of connecting to billing service.";
        c = billingResult4;
        BillingResult billingResult5 = new BillingResult();
        billingResult5.a = 3;
        billingResult5.f2003b = "Play Store version installed does not support cross selling products.";
        BillingResult billingResult6 = new BillingResult();
        billingResult6.a = 5;
        billingResult6.f2003b = "The list of SKUs can't be empty.";
        d = billingResult6;
        BillingResult billingResult7 = new BillingResult();
        billingResult7.a = 5;
        billingResult7.f2003b = "SKU type can't be empty.";
        e = billingResult7;
        BillingResult billingResult8 = new BillingResult();
        billingResult8.a = -2;
        billingResult8.f2003b = "Client does not support extra params.";
        f = billingResult8;
        BillingResult billingResult9 = new BillingResult();
        billingResult9.a = -2;
        billingResult9.f2003b = "Client does not support the feature.";
        g = billingResult9;
        BillingResult billingResult10 = new BillingResult();
        billingResult10.a = -2;
        billingResult10.f2003b = "Client does not support get purchase history.";
        BillingResult billingResult11 = new BillingResult();
        billingResult11.a = 5;
        billingResult11.f2003b = "Invalid purchase token.";
        BillingResult billingResult12 = new BillingResult();
        billingResult12.a = 6;
        billingResult12.f2003b = "An internal error occurred.";
        h = billingResult12;
        BillingResult billingResult13 = new BillingResult();
        billingResult13.a = 4;
        billingResult13.f2003b = "Item is unavailable for purchase.";
        BillingResult billingResult14 = new BillingResult();
        billingResult14.a = 5;
        billingResult14.f2003b = "SKU can't be null.";
        BillingResult billingResult15 = new BillingResult();
        billingResult15.a = 5;
        billingResult15.f2003b = "SKU type can't be null.";
        BillingResult billingResult16 = new BillingResult();
        billingResult16.a = 0;
        billingResult16.f2003b = "";
        i = billingResult16;
        BillingResult billingResult17 = new BillingResult();
        billingResult17.a = -1;
        billingResult17.f2003b = "Service connection is disconnected.";
        j = billingResult17;
        BillingResult billingResult18 = new BillingResult();
        billingResult18.a = -3;
        billingResult18.f2003b = "Timeout communicating with service.";
        k = billingResult18;
        BillingResult billingResult19 = new BillingResult();
        billingResult19.a = -2;
        billingResult19.f2003b = "Client doesn't support subscriptions.";
        l = billingResult19;
        BillingResult billingResult20 = new BillingResult();
        billingResult20.a = -2;
        billingResult20.f2003b = "Client doesn't support subscriptions update.";
        BillingResult billingResult21 = new BillingResult();
        billingResult21.a = -2;
        billingResult21.f2003b = "Client doesn't support multi-item purchases.";
        m = billingResult21;
        BillingResult billingResult22 = new BillingResult();
        billingResult22.a = 5;
        billingResult22.f2003b = "Unknown feature";
    }
}

package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p313h.p327n.C3941a;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public class ProxyBillingActivity extends Activity {

    /* JADX INFO: renamed from: j */
    @Nullable
    public ResultReceiver f14559j;

    /* JADX INFO: renamed from: k */
    public boolean f14560k;

    /* JADX INFO: renamed from: a */
    public final Intent m7496a() {
        Intent intent = new Intent("com.android.vending.billing.PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            int i3 = C3941a.m5413c(intent, "ProxyBillingActivity").f14557a;
            if (i2 != -1) {
                C3941a.m5416f("ProxyBillingActivity", C1643a.m853h(85, "Activity finished with resultCode ", i2, " and billing's responseCode: ", i3));
            } else if (i3 != 0) {
                i2 = -1;
                C3941a.m5416f("ProxyBillingActivity", C1643a.m853h(85, "Activity finished with resultCode ", i2, " and billing's responseCode: ", i3));
            } else {
                i3 = 0;
            }
            ResultReceiver resultReceiver = this.f14559j;
            if (resultReceiver != null) {
                resultReceiver.send(i3, intent == null ? null : intent.getExtras());
            } else {
                Intent intentM7496a = m7496a();
                if (intent != null) {
                    if (intent.getExtras() != null) {
                        intentM7496a.putExtras(intent.getExtras());
                    } else {
                        C3941a.m5416f("ProxyBillingActivity", "Got null bundle!");
                        intentM7496a.putExtra("RESPONSE_CODE", 6);
                        intentM7496a.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                    }
                }
                sendBroadcast(intentM7496a);
            }
        } else {
            StringBuilder sb = new StringBuilder(69);
            sb.append("Got onActivityResult with wrong requestCode: ");
            sb.append(i);
            sb.append("; skipping...");
            C3941a.m5416f("ProxyBillingActivity", sb.toString());
        }
        this.f14560k = false;
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        PendingIntent pendingIntent;
        super.onCreate(bundle);
        if (bundle != null) {
            C3941a.m5415e("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
            this.f14560k = bundle.getBoolean("send_cancelled_broadcast_if_finished", false);
            if (bundle.containsKey("result_receiver")) {
                this.f14559j = (ResultReceiver) bundle.getParcelable("result_receiver");
                return;
            }
            return;
        }
        C3941a.m5415e("ProxyBillingActivity", "Launching Play Store billing flow");
        if (getIntent().hasExtra("BUY_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
        } else if (getIntent().hasExtra("SUBS_MANAGEMENT_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
            this.f14559j = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
        } else {
            pendingIntent = null;
        }
        try {
            this.f14560k = true;
            startIntentSenderForResult(pendingIntent.getIntentSender(), 100, new Intent(), 0, 0, 0);
        } catch (IntentSender.SendIntentException e) {
            String strValueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 53);
            sb.append("Got exception while trying to start a purchase flow: ");
            sb.append(strValueOf);
            C3941a.m5416f("ProxyBillingActivity", sb.toString());
            ResultReceiver resultReceiver = this.f14559j;
            if (resultReceiver != null) {
                resultReceiver.send(6, null);
            } else {
                Intent intentM7496a = m7496a();
                intentM7496a.putExtra("RESPONSE_CODE", 6);
                intentM7496a.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                sendBroadcast(intentM7496a);
            }
            this.f14560k = false;
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.f14560k) {
            Intent intentM7496a = m7496a();
            intentM7496a.putExtra("RESPONSE_CODE", 1);
            intentM7496a.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            sendBroadcast(intentM7496a);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        ResultReceiver resultReceiver = this.f14559j;
        if (resultReceiver != null) {
            bundle.putParcelable("result_receiver", resultReceiver);
        }
        bundle.putBoolean("send_cancelled_broadcast_if_finished", this.f14560k);
    }
}

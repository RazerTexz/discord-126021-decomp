package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.a.f.h.n.a;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public class ProxyBillingActivity extends Activity {

    @Nullable
    public ResultReceiver j;
    public boolean k;

    public final Intent a() {
        Intent intent = new Intent("com.android.vending.billing.PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            int i3 = a.c(intent, "ProxyBillingActivity").a;
            if (i2 != -1) {
                a.f("ProxyBillingActivity", outline.h(85, "Activity finished with resultCode ", i2, " and billing's responseCode: ", i3));
            } else if (i3 != 0) {
                i2 = -1;
                a.f("ProxyBillingActivity", outline.h(85, "Activity finished with resultCode ", i2, " and billing's responseCode: ", i3));
            } else {
                i3 = 0;
            }
            ResultReceiver resultReceiver = this.j;
            if (resultReceiver != null) {
                resultReceiver.send(i3, intent == null ? null : intent.getExtras());
            } else {
                Intent intentA = a();
                if (intent != null) {
                    if (intent.getExtras() != null) {
                        intentA.putExtras(intent.getExtras());
                    } else {
                        a.f("ProxyBillingActivity", "Got null bundle!");
                        intentA.putExtra("RESPONSE_CODE", 6);
                        intentA.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                    }
                }
                sendBroadcast(intentA);
            }
        } else {
            StringBuilder sb = new StringBuilder(69);
            sb.append("Got onActivityResult with wrong requestCode: ");
            sb.append(i);
            sb.append("; skipping...");
            a.f("ProxyBillingActivity", sb.toString());
        }
        this.k = false;
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        PendingIntent pendingIntent;
        super.onCreate(bundle);
        if (bundle != null) {
            a.e("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
            this.k = bundle.getBoolean("send_cancelled_broadcast_if_finished", false);
            if (bundle.containsKey("result_receiver")) {
                this.j = (ResultReceiver) bundle.getParcelable("result_receiver");
                return;
            }
            return;
        }
        a.e("ProxyBillingActivity", "Launching Play Store billing flow");
        if (getIntent().hasExtra("BUY_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
        } else if (getIntent().hasExtra("SUBS_MANAGEMENT_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
            this.j = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
        } else {
            pendingIntent = null;
        }
        try {
            this.k = true;
            startIntentSenderForResult(pendingIntent.getIntentSender(), 100, new Intent(), 0, 0, 0);
        } catch (IntentSender.SendIntentException e) {
            String strValueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 53);
            sb.append("Got exception while trying to start a purchase flow: ");
            sb.append(strValueOf);
            a.f("ProxyBillingActivity", sb.toString());
            ResultReceiver resultReceiver = this.j;
            if (resultReceiver != null) {
                resultReceiver.send(6, null);
            } else {
                Intent intentA = a();
                intentA.putExtra("RESPONSE_CODE", 6);
                intentA.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                sendBroadcast(intentA);
            }
            this.k = false;
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.k) {
            Intent intentA = a();
            intentA.putExtra("RESPONSE_CODE", 1);
            intentA.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            sendBroadcast(intentA);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        ResultReceiver resultReceiver = this.j;
        if (resultReceiver != null) {
            bundle.putParcelable("result_receiver", resultReceiver);
        }
        bundle.putBoolean("send_cancelled_broadcast_if_finished", this.k);
    }
}

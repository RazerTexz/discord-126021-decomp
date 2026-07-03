package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepName;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3293g;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@KeepName
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f20485j = 0;

    /* JADX INFO: renamed from: k */
    public int f20486k = 0;

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f20486k = 0;
            setResult(i2, intent);
            if (booleanExtra) {
                C3293g c3293gM4078a = C3293g.m4078a(this);
                if (i2 == -1) {
                    Handler handler = c3293gM4078a.f9390x;
                    handler.sendMessage(handler.obtainMessage(3));
                } else if (i2 == 0) {
                    ConnectionResult connectionResult = new ConnectionResult(13, null);
                    int intExtra = getIntent().getIntExtra("failing_client_id", -1);
                    if (!c3293gM4078a.m4080c(connectionResult, intExtra)) {
                        Handler handler2 = c3293gM4078a.f9390x;
                        handler2.sendMessage(handler2.obtainMessage(5, intExtra, 0, connectionResult));
                    }
                }
            }
        } else if (i == 2) {
            this.f20486k = 0;
            setResult(i2, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f20486k = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f20486k = bundle.getInt("resolution");
        }
        if (this.f20486k != 1) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                Log.e("GoogleApiActivity", "Activity started without extras");
                finish();
                return;
            }
            PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
            Integer num = (Integer) extras.get("error_code");
            if (pendingIntent == null && num == null) {
                Log.e("GoogleApiActivity", "Activity started without resolution");
                finish();
                return;
            }
            if (pendingIntent == null) {
                Object obj = GoogleApiAvailability.f20480c;
                GoogleApiAvailability.f20481d.m9027f(this, num == null ? 8 : num.intValue(), 2, this);
                this.f20486k = 1;
            } else {
                try {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                    this.f20486k = 1;
                } catch (IntentSender.SendIntentException e) {
                    Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e);
                    finish();
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f20486k);
        super.onSaveInstanceState(bundle);
    }
}

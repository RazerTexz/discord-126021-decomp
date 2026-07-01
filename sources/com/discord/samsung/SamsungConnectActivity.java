package com.discord.samsung;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import b.a.r.d;
import b.n.a.a.a;
import d0.g0.t;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: SamsungConnectActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SamsungConnectActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public a samsungAccountServiceCallback;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public boolean serviceBound;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final SamsungConnectActivity$a serviceConnection = new SamsungConnectActivity$a(this);

    /* JADX WARN: Code duplicated, block: B:18:0x0034  */
    public static final void a(SamsungConnectActivity samsungConnectActivity, String str, String str2) {
        Objects.requireNonNull(samsungConnectActivity);
        boolean z2 = true;
        if (str == null || t.isBlank(str)) {
            samsungConnectActivity.setResult(0);
        } else {
            if (str2 != null && !t.isBlank(str2)) {
                z2 = false;
            }
            if (z2) {
                samsungConnectActivity.setResult(0);
            } else {
                Intent intent = new Intent();
                intent.putExtra("com.discord.samsung.intent.extra.AUTH_CODE", str);
                intent.putExtra("com.discord.samsung.intent.extra.SERVER_URL", str2);
                samsungConnectActivity.setResult(-1, intent);
            }
        }
        samsungConnectActivity.finish();
    }

    public static final void b(Context context, ActivityResultLauncher<Intent> activityResultLauncher, int i) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(activityResultLauncher, "launcher");
        Intent intentAddFlags = new Intent(context, (Class<?>) SamsungConnectActivity.class).putExtra("com.discord.samsung.intent.extra.ATTEMPT_COUNT", i).addFlags(65536);
        m.checkNotNullExpressionValue(intentAddFlags, "Intent(context, SamsungC…AG_ACTIVITY_NO_ANIMATION)");
        activityResultLauncher.launch(intentAddFlags);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.samsungAccountServiceCallback = new d(this);
        Intent intent = new Intent("com.msc.action.samsungaccount.REQUEST_SERVICE").setPackage("com.osp.app.signin");
        m.checkNotNullExpressionValue(intent, "Intent(SA_ACCOUNT_ACTION…ckage(SA_ACCOUNT_SERVICE)");
        Log.i("Discord", "Samsung starting SA Service");
        if (startService(intent) == null) {
            Log.e("Discord", "Samsung Account service could not be started");
        } else {
            if (bindService(intent, this.serviceConnection, 1)) {
                return;
            }
            Log.e("Discord", "Samsung Account service could not be bound");
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        if (this.serviceBound) {
            unbindService(this.serviceConnection);
            this.serviceBound = false;
        }
        super.onStop();
    }
}

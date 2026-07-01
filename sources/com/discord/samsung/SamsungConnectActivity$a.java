package com.discord.samsung;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import b.n.a.a.a;
import b.n.a.a.b;
import b.n.a.a.b$a;
import b.n.a.a.b$a$a;
import com.discord.BuildConfig;
import d0.z.d.m;

/* JADX INFO: compiled from: SamsungConnectActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SamsungConnectActivity$a implements ServiceConnection {
    public final /* synthetic */ SamsungConnectActivity j;

    public SamsungConnectActivity$a(SamsungConnectActivity samsungConnectActivity) {
        this.j = samsungConnectActivity;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        b b_a_a;
        this.j.serviceBound = true;
        int i = b$a.a;
        if (iBinder == null) {
            b_a_a = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.msc.sa.aidl.ISAService");
            b_a_a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new b$a$a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }
        Log.i("Discord", "Samsung Account service connection established");
        try {
            a aVar = this.j.samsungAccountServiceCallback;
            if (aVar == null) {
                m.throwUninitializedPropertyAccessException("samsungAccountServiceCallback");
            }
            String strQ = b_a_a.Q("97t47j218f", "dummy", BuildConfig.APPLICATION_ID, aVar);
            Log.i("Discord", "Samsung Account service connection established: " + strQ);
            if (strQ == null) {
                SamsungConnectActivity samsungConnectActivity = this.j;
                samsungConnectActivity.setResult(500, new Intent().putExtra("com.discord.samsung.intent.extra.ATTEMPT_COUNT", samsungConnectActivity.getIntent().getIntExtra("com.discord.samsung.intent.extra.ATTEMPT_COUNT", 0) + 1));
                samsungConnectActivity.finish();
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putStringArray("additional", new String[]{"api_server_url", "auth_server_url"});
            boolean zH0 = b_a_a.h0(1221, strQ, bundle);
            Log.i("Discord", "Samsung Account service connection established: isReqSucc? " + zH0);
            if (!zH0) {
                throw new Exception("Call Samsung.requestAuthCode failed");
            }
        } catch (Throwable th) {
            Log.e("Discord", "Unable to connect to Samsung", th);
            SamsungConnectActivity.a(this.j, null, null);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.i("Discord", "Samsung Account service connection unbound");
        SamsungConnectActivity samsungConnectActivity = this.j;
        samsungConnectActivity.serviceBound = false;
        samsungConnectActivity.finish();
    }
}

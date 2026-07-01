package com.adjust.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class GooglePlayServicesClient {
    public static GooglePlayServicesClient$GooglePlayServicesInfo getGooglePlayServicesInfo(Context context, long j) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Google Play Services info can't be accessed from the main thread");
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            GooglePlayServicesClient$GooglePlayServicesConnection googlePlayServicesClient$GooglePlayServicesConnection = new GooglePlayServicesClient$GooglePlayServicesConnection(j);
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (!context.bindService(intent, googlePlayServicesClient$GooglePlayServicesConnection, 1)) {
                    throw new IOException("Google Play connection failed");
                }
                try {
                    GooglePlayServicesClient$GooglePlayServicesInterface googlePlayServicesClient$GooglePlayServicesInterface = new GooglePlayServicesClient$GooglePlayServicesInterface(googlePlayServicesClient$GooglePlayServicesConnection.getBinder());
                    GooglePlayServicesClient$GooglePlayServicesInfo googlePlayServicesClient$GooglePlayServicesInfo = new GooglePlayServicesClient$GooglePlayServicesInfo(googlePlayServicesClient$GooglePlayServicesInterface.getGpsAdid(), googlePlayServicesClient$GooglePlayServicesInterface.getTrackingEnabled(true));
                    context.unbindService(googlePlayServicesClient$GooglePlayServicesConnection);
                    return googlePlayServicesClient$GooglePlayServicesInfo;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Throwable th) {
                context.unbindService(googlePlayServicesClient$GooglePlayServicesConnection);
                throw th;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}

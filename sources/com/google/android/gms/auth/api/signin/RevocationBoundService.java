package com.google.android.gms.auth.api.signin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;
import p007b.p225i.p226a.p288f.p292c.p293a.p296f.p297b.BinderC3214q;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RevocationBoundService extends Service {
    @Override // android.app.Service
    @Nullable
    public final IBinder onBind(Intent intent) {
        if (!"com.google.android.gms.auth.api.signin.RevocationBoundService.disconnect".equals(intent.getAction()) && !"com.google.android.gms.auth.api.signin.RevocationBoundService.clearClientState".equals(intent.getAction())) {
            String strValueOf = String.valueOf(intent.getAction());
            Log.w("RevocationService", strValueOf.length() != 0 ? "Unknown action sent to RevocationBoundService: ".concat(strValueOf) : new String("Unknown action sent to RevocationBoundService: "));
            return null;
        }
        if (Log.isLoggable("RevocationService", 2)) {
            String strValueOf2 = String.valueOf(intent.getAction());
            Log.v("RevocationService", strValueOf2.length() != 0 ? "RevocationBoundService handling ".concat(strValueOf2) : new String("RevocationBoundService handling "));
        }
        return new BinderC3214q(this);
    }
}

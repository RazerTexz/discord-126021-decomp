package com.google.android.gms.cloudmessaging;

import android.os.Build$VERSION;
import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zza$a extends ClassLoader {
    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str, boolean z2) throws ClassNotFoundException {
        if (!"com.google.android.gms.iid.MessengerCompat".equals(str)) {
            return super.loadClass(str, z2);
        }
        if (!(Log.isLoggable("CloudMessengerCompat", 3) || (Build$VERSION.SDK_INT == 23 && Log.isLoggable("CloudMessengerCompat", 3)))) {
            return zza.class;
        }
        Log.d("CloudMessengerCompat", "Using renamed FirebaseIidMessengerCompat class");
        return zza.class;
    }
}

package com.discord.stores.utilities;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import j0.k.b;
import retrofit2.Response;

/* JADX INFO: compiled from: RestCallState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestCallStateKt$logNetworkAction$4<T, R> implements b<Response<T>, T> {
    public static final RestCallStateKt$logNetworkAction$4 INSTANCE = new RestCallStateKt$logNetworkAction$4();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Response) obj);
    }

    public final T call(Response<T> response) {
        return response.f3824b;
    }
}

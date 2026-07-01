package com.discord.stores;

import androidx.core.app.NotificationCompat;
import co.discord.media_engine.VideoInputDeviceDescription;
import j0.k.b;

/* JADX INFO: compiled from: StoreRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRtcConnection$init$3<T, R> implements b<VideoInputDeviceDescription, Boolean> {
    public static final StoreRtcConnection$init$3 INSTANCE = new StoreRtcConnection$init$3();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(VideoInputDeviceDescription videoInputDeviceDescription) {
        return call2(videoInputDeviceDescription);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(VideoInputDeviceDescription videoInputDeviceDescription) {
        return Boolean.valueOf(videoInputDeviceDescription != null);
    }
}

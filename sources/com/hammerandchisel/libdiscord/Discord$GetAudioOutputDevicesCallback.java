package com.hammerandchisel.libdiscord;

import androidx.annotation.NonNull;
import co.discord.media_engine.AudioOutputDeviceDescription;

/* JADX INFO: loaded from: classes3.dex */
public interface Discord$GetAudioOutputDevicesCallback {
    void onDevices(@NonNull AudioOutputDeviceDescription[] audioOutputDeviceDescriptionArr);
}

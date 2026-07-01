package com.hammerandchisel.libdiscord;

import androidx.annotation.NonNull;
import co.discord.media_engine.AudioInputDeviceDescription;

/* JADX INFO: loaded from: classes3.dex */
public interface Discord$GetAudioInputDevicesCallback {
    void onDevices(@NonNull AudioInputDeviceDescription[] audioInputDeviceDescriptionArr);
}

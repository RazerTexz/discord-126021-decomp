package com.hammerandchisel.libdiscord;

import androidx.annotation.NonNull;
import co.discord.media_engine.VideoInputDeviceDescription;

/* JADX INFO: loaded from: classes3.dex */
public interface Discord$GetVideoInputDevicesCallback {
    void onDevices(@NonNull VideoInputDeviceDescription[] videoInputDeviceDescriptionArr);
}

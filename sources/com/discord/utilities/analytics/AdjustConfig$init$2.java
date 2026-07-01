package com.discord.utilities.analytics;

import com.adjust.sdk.OnDeviceIdsRead;

/* JADX INFO: compiled from: AdjustConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AdjustConfig$init$2 implements OnDeviceIdsRead {
    public static final AdjustConfig$init$2 INSTANCE = new AdjustConfig$init$2();

    @Override // com.adjust.sdk.OnDeviceIdsRead
    public final void onGoogleAdIdRead(String str) {
        if (str != null) {
            AnalyticSuperProperties.INSTANCE.setAdvertiserId(str);
        }
    }
}

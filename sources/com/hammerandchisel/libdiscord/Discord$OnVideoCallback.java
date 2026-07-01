package com.hammerandchisel.libdiscord;

import androidx.annotation.NonNull;
import co.discord.media_engine.StreamParameters;

/* JADX INFO: loaded from: classes3.dex */
public interface Discord$OnVideoCallback {
    void onVideo(long j, int i, @NonNull String str, @NonNull StreamParameters[] streamParametersArr);
}

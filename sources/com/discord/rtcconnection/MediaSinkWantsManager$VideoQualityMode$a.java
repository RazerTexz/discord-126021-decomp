package com.discord.rtcconnection;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MediaSinkWantsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSinkWantsManager$VideoQualityMode$a {
    public MediaSinkWantsManager$VideoQualityMode$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final MediaSinkWantsManager$VideoQualityMode a(Integer num) {
        if (num != null && num.intValue() == 1) {
            return MediaSinkWantsManager$VideoQualityMode.AUTO;
        }
        return (num != null && num.intValue() == 2) ? MediaSinkWantsManager$VideoQualityMode.FULL : MediaSinkWantsManager$VideoQualityMode.AUTO;
    }
}

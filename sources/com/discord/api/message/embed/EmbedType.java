package com.discord.api.message.embed;

import androidx.core.os.EnvironmentCompat;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: compiled from: EmbedType.kt */
/* JADX INFO: loaded from: classes.dex */
public enum EmbedType {
    ARTICLE("article"),
    IMAGE("image"),
    VIDEO(MediaStreamTrack.VIDEO_TRACK_KIND),
    TWEET("tweet"),
    LINK("link"),
    HTML("html"),
    FILE("file"),
    GIFV("gifv"),
    RICH("rich"),
    APPLICATION_NEWS("application_news"),
    UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN);

    private final String apiValue;

    EmbedType(String str) {
        this.apiValue = str;
    }

    public final String getApiValue() {
        return this.apiValue;
    }
}

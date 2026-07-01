package com.discord.utilities.intent;

import androidx.core.os.EnvironmentCompat;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RouteHandlers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RouteHandlers$AnalyticsMetadata {
    public static final RouteHandlers$AnalyticsMetadata$Companion Companion = new RouteHandlers$AnalyticsMetadata$Companion(null);
    private static final RouteHandlers$AnalyticsMetadata UNKNOWN = new RouteHandlers$AnalyticsMetadata(EnvironmentCompat.MEDIA_UNKNOWN, null, null, 6, null);
    private final Long channelId;
    private final Long guildId;
    private final String type;

    public RouteHandlers$AnalyticsMetadata(String str, Long l, Long l2) {
        m.checkNotNullParameter(str, "type");
        this.type = str;
        this.guildId = l;
        this.channelId = l2;
    }

    public static final /* synthetic */ RouteHandlers$AnalyticsMetadata access$getUNKNOWN$cp() {
        return UNKNOWN;
    }

    public final Long getChannelId() {
        return this.channelId;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final String getType() {
        return this.type;
    }

    public /* synthetic */ RouteHandlers$AnalyticsMetadata(String str, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2);
    }
}

package com.discord.utilities.voice;

import androidx.core.app.NotificationCompat;
import com.discord.rtcconnection.RtcConnection$Metadata;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: ScreenShareManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ScreenShareManager$startStream$1<T, R> implements b<RtcConnection$Metadata, Boolean> {
    public final /* synthetic */ ScreenShareManager this$0;

    public ScreenShareManager$startStream$1(ScreenShareManager screenShareManager) {
        this.this$0 = screenShareManager;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(RtcConnection$Metadata rtcConnection$Metadata) {
        return call2(rtcConnection$Metadata);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(RtcConnection$Metadata rtcConnection$Metadata) {
        Long l = rtcConnection$Metadata != null ? rtcConnection$Metadata.channelId : null;
        return Boolean.valueOf(l != null && l.longValue() == this.this$0.getChannelId() && m.areEqual(rtcConnection$Metadata.guildId, this.this$0.getGuildId()));
    }
}

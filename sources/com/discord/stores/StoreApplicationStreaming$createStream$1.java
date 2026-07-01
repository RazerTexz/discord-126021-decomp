package com.discord.stores;

import b.d.b.a.a;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelApplicationStream$CallStream;
import com.discord.models.domain.ModelApplicationStream$GuildStream;
import com.discord.rtcconnection.RtcConnection;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationStreaming.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationStreaming$createStream$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ String $preferredRegion;
    public final /* synthetic */ StoreApplicationStreaming this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationStreaming$createStream$1(StoreApplicationStreaming storeApplicationStreaming, long j, Long l, String str) {
        super(0);
        this.this$0 = storeApplicationStreaming;
        this.$channelId = j;
        this.$guildId = l;
        this.$preferredRegion = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreApplicationStreaming$ActiveApplicationStream$State state;
        StoreApplicationStreaming$ActiveApplicationStream$State state2;
        ModelApplicationStream stream;
        RtcConnection rtcConnection = StoreApplicationStreaming.access$getRtcConnectionStore$p(this.this$0).getRtcConnection();
        Object encodedStreamKey = null;
        boolean z2 = false;
        if (rtcConnection == null || rtcConnection.channelId != this.$channelId || (!m.areEqual(rtcConnection.guildId, this.$guildId))) {
            AppLog appLog = AppLog.g;
            StringBuilder sbU = a.U("\n                Failed to start stream.\n                rtcConnection == null: ");
            sbU.append(rtcConnection == null);
            sbU.append("\n                rtcConnection.channelId != channelId: ");
            sbU.append(rtcConnection == null || rtcConnection.channelId != this.$channelId);
            sbU.append("\n                rtcConnection.guildId != guildId: ");
            sbU.append(!m.areEqual(rtcConnection != null ? rtcConnection.guildId : null, this.$guildId));
            sbU.append("\n              ");
            Logger.e$default(appLog, "Failed to start stream.", new IllegalStateException(d0.g0.m.trimIndent(sbU.toString())), null, 4, null);
            return;
        }
        long id2 = StoreApplicationStreaming.access$getUserStore$p(this.this$0).getMeSnapshot().getId();
        ModelApplicationStream modelApplicationStream$GuildStream = this.$guildId != null ? new ModelApplicationStream$GuildStream(this.$guildId.longValue(), this.$channelId, id2) : new ModelApplicationStream$CallStream(this.$channelId, id2);
        StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStreamAccess$getActiveApplicationStream$p = StoreApplicationStreaming.access$getActiveApplicationStream$p(this.this$0);
        if (storeApplicationStreaming$ActiveApplicationStreamAccess$getActiveApplicationStream$p != null && (stream = storeApplicationStreaming$ActiveApplicationStreamAccess$getActiveApplicationStream$p.getStream()) != null) {
            encodedStreamKey = stream.getEncodedStreamKey();
        }
        if ((encodedStreamKey == modelApplicationStream$GuildStream.getEncodedStreamKey()) && storeApplicationStreaming$ActiveApplicationStreamAccess$getActiveApplicationStream$p != null && (state2 = storeApplicationStreaming$ActiveApplicationStreamAccess$getActiveApplicationStream$p.getState()) != null && state2.isStreamActive()) {
            z2 = true;
        }
        if (z2) {
            return;
        }
        if (storeApplicationStreaming$ActiveApplicationStreamAccess$getActiveApplicationStream$p != null && (state = storeApplicationStreaming$ActiveApplicationStreamAccess$getActiveApplicationStream$p.getState()) != null && state.isStreamActive()) {
            StoreApplicationStreaming.access$stopStreamInternal(this.this$0, storeApplicationStreaming$ActiveApplicationStreamAccess$getActiveApplicationStream$p.getStream().getEncodedStreamKey());
        }
        StoreApplicationStreaming.access$getStoreStream$p(this.this$0).streamCreate(modelApplicationStream$GuildStream.getEncodedStreamKey(), this.$preferredRegion);
    }
}

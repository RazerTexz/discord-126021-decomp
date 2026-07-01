package com.discord.stores;

import com.discord.rtcconnection.RtcConnection$AnalyticsEvent;
import com.discord.rtcconnection.RtcConnection$Quality;
import com.discord.rtcconnection.RtcConnection$State$f;
import com.discord.rtcconnection.RtcConnection$StateChange;
import com.discord.rtcconnection.RtcConnection$b;
import com.discord.rtcconnection.VideoMetadata;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStreamRtcConnection$RtcConnectionListener extends RtcConnection$b {
    public final /* synthetic */ StoreStreamRtcConnection this$0;

    public StoreStreamRtcConnection$RtcConnectionListener(StoreStreamRtcConnection storeStreamRtcConnection) {
        this.this$0 = storeStreamRtcConnection;
    }

    @Override // com.discord.rtcconnection.RtcConnection$b, com.discord.rtcconnection.RtcConnection$c
    public void onAnalyticsEvent(RtcConnection$AnalyticsEvent event, Map<String, Object> properties) {
        m.checkNotNullParameter(event, "event");
        m.checkNotNullParameter(properties, "properties");
        int iOrdinal = event.ordinal();
        if (iOrdinal == 3) {
            StoreStreamRtcConnection.access$getDispatcher$p(this.this$0).schedule(new StoreStreamRtcConnection$RtcConnectionListener$onAnalyticsEvent$1(this, properties));
        } else {
            if (iOrdinal != 4) {
                return;
            }
            StoreStreamRtcConnection.access$getAnalyticsStore$p(this.this$0).trackMediaSessionJoined(properties);
        }
    }

    @Override // com.discord.rtcconnection.RtcConnection$b
    public void onFirstFrameReceived(long ssrc) {
        StoreStreamRtcConnection.access$getListenerSubject$p(this.this$0).notify(new StoreStreamRtcConnection$RtcConnectionListener$onFirstFrameReceived$1(ssrc));
    }

    @Override // com.discord.rtcconnection.RtcConnection$b
    public void onFirstFrameSent() {
        StoreStreamRtcConnection.access$getListenerSubject$p(this.this$0).notify(StoreStreamRtcConnection$RtcConnectionListener$onFirstFrameSent$1.INSTANCE);
    }

    @Override // com.discord.rtcconnection.RtcConnection$b, com.discord.rtcconnection.RtcConnection$c
    public void onMediaSessionIdReceived() {
        StoreStreamRtcConnection.access$getDispatcher$p(this.this$0).schedule(new StoreStreamRtcConnection$RtcConnectionListener$onMediaSessionIdReceived$1(this));
    }

    @Override // com.discord.rtcconnection.RtcConnection$b, com.discord.rtcconnection.RtcConnection$c
    public void onQualityUpdate(RtcConnection$Quality quality) {
        m.checkNotNullParameter(quality, "quality");
        StoreStreamRtcConnection.access$getDispatcher$p(this.this$0).schedule(new StoreStreamRtcConnection$RtcConnectionListener$onQualityUpdate$1(this, quality));
    }

    @Override // com.discord.rtcconnection.RtcConnection$b, com.discord.rtcconnection.RtcConnection$c
    public void onStateChange(RtcConnection$StateChange stateChange) {
        m.checkNotNullParameter(stateChange, "stateChange");
        StoreStreamRtcConnection.access$recordBreadcrumb(this.this$0, "store state change: " + stateChange);
        if (m.areEqual(stateChange.state, RtcConnection$State$f.a)) {
            StoreStreamRtcConnection.access$getListenerSubject$p(this.this$0).notify(StoreStreamRtcConnection$RtcConnectionListener$onStateChange$1.INSTANCE);
        }
        StoreStreamRtcConnection.access$getDispatcher$p(this.this$0).schedule(new StoreStreamRtcConnection$RtcConnectionListener$onStateChange$2(this, stateChange));
    }

    @Override // com.discord.rtcconnection.RtcConnection$b, com.discord.rtcconnection.RtcConnection$c
    public void onVideoMetadata(VideoMetadata metadata) {
        m.checkNotNullParameter(metadata, "metadata");
        StoreStreamRtcConnection.access$getDispatcher$p(this.this$0).schedule(new StoreStreamRtcConnection$RtcConnectionListener$onVideoMetadata$1(this, metadata));
    }

    @Override // com.discord.rtcconnection.RtcConnection$b, com.discord.rtcconnection.RtcConnection$c
    public void onVideoStream(long userId, Integer streamId, int audioSsrc, int videoSsrc, int rtxSsrc) {
        StoreStreamRtcConnection.access$getDispatcher$p(this.this$0).schedule(new StoreStreamRtcConnection$RtcConnectionListener$onVideoStream$1(this, userId, streamId));
    }
}

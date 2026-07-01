package com.discord.utilities.voice;

import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.RtcConnection$State;
import com.discord.rtcconnection.RtcConnection$State$d;
import com.discord.rtcconnection.RtcConnection$State$f;
import com.discord.rtcconnection.RtcConnection$StateChange;
import com.discord.rtcconnection.RtcConnection$b;
import d0.z.d.m;

/* JADX INFO: compiled from: ScreenShareManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ScreenShareManager$RtcConnectionListener extends RtcConnection$b {
    public final /* synthetic */ ScreenShareManager this$0;

    public ScreenShareManager$RtcConnectionListener(ScreenShareManager screenShareManager) {
        this.this$0 = screenShareManager;
    }

    @Override // com.discord.rtcconnection.RtcConnection$b, com.discord.rtcconnection.RtcConnection$c
    public void onStateChange(RtcConnection$StateChange stateChange) {
        m.checkNotNullParameter(stateChange, "stateChange");
        RtcConnection$State rtcConnection$State = stateChange.state;
        if (!m.areEqual(rtcConnection$State, RtcConnection$State$f.a)) {
            if (rtcConnection$State instanceof RtcConnection$State$d) {
                this.this$0.stopStream();
            }
        } else {
            ScreenShareManager$State screenShareManager$StateAccess$getPreviousState$p = ScreenShareManager.access$getPreviousState$p(this.this$0);
            RtcConnection rtcConnection = screenShareManager$StateAccess$getPreviousState$p != null ? screenShareManager$StateAccess$getPreviousState$p.getRtcConnection() : null;
            if (rtcConnection != null) {
                rtcConnection.t(ScreenShareManager.access$getScreenshareIntent$p(this.this$0), ScreenShareManager.access$createThumbnailEmitter(this.this$0));
                ScreenShareManager.access$uploadScreenSharePreviews(this.this$0);
            }
        }
    }
}

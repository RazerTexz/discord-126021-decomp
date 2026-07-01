package com.discord.views.calls;

import b.d.b.a.a;

/* JADX INFO: compiled from: VideoCallParticipantView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class VideoCallParticipantView$StreamFps {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final int fps;

    public VideoCallParticipantView$StreamFps(int i) {
        this.fps = i;
    }

    public final boolean a() {
        return this.fps == 60;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof VideoCallParticipantView$StreamFps) && this.fps == ((VideoCallParticipantView$StreamFps) other).fps;
        }
        return true;
    }

    /* JADX INFO: renamed from: hashCode, reason: from getter */
    public int getFps() {
        return this.fps;
    }

    public String toString() {
        return a.B(a.U("StreamFps(fps="), this.fps, ")");
    }
}

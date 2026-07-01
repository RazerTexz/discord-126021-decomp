package com.discord.rtcconnection.mediaengine;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: MediaEngine.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class MediaEngine$AudioInfo {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final String audioSubsystem;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String audioLayer;

    public MediaEngine$AudioInfo(String str, String str2) {
        m.checkNotNullParameter(str, "audioSubsystem");
        m.checkNotNullParameter(str2, "audioLayer");
        this.audioSubsystem = str;
        this.audioLayer = str2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaEngine$AudioInfo)) {
            return false;
        }
        MediaEngine$AudioInfo mediaEngine$AudioInfo = (MediaEngine$AudioInfo) other;
        return m.areEqual(this.audioSubsystem, mediaEngine$AudioInfo.audioSubsystem) && m.areEqual(this.audioLayer, mediaEngine$AudioInfo.audioLayer);
    }

    public int hashCode() {
        String str = this.audioSubsystem;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.audioLayer;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("AudioInfo(audioSubsystem=");
        sbU.append(this.audioSubsystem);
        sbU.append(", audioLayer=");
        return a.J(sbU, this.audioLayer, ")");
    }
}

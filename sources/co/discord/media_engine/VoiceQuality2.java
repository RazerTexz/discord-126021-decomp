package co.discord.media_engine;

import b.d.b.a.outline;

/* JADX INFO: renamed from: co.discord.media_engine.Duration, reason: use source file name */
/* JADX INFO: compiled from: VoiceQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class VoiceQuality2 {
    private int connected;
    private int listening;
    private int participation;
    private int speaking;

    public VoiceQuality2(int i, int i2, int i3, int i4) {
        this.listening = i;
        this.speaking = i2;
        this.participation = i3;
        this.connected = i4;
    }

    public static /* synthetic */ VoiceQuality2 copy$default(VoiceQuality2 voiceQuality2, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = voiceQuality2.listening;
        }
        if ((i5 & 2) != 0) {
            i2 = voiceQuality2.speaking;
        }
        if ((i5 & 4) != 0) {
            i3 = voiceQuality2.participation;
        }
        if ((i5 & 8) != 0) {
            i4 = voiceQuality2.connected;
        }
        return voiceQuality2.copy(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getListening() {
        return this.listening;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSpeaking() {
        return this.speaking;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getParticipation() {
        return this.participation;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getConnected() {
        return this.connected;
    }

    public final VoiceQuality2 copy(int listening, int speaking, int participation, int connected) {
        return new VoiceQuality2(listening, speaking, participation, connected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceQuality2)) {
            return false;
        }
        VoiceQuality2 voiceQuality2 = (VoiceQuality2) other;
        return this.listening == voiceQuality2.listening && this.speaking == voiceQuality2.speaking && this.participation == voiceQuality2.participation && this.connected == voiceQuality2.connected;
    }

    public final int getConnected() {
        return this.connected;
    }

    public final int getListening() {
        return this.listening;
    }

    public final int getParticipation() {
        return this.participation;
    }

    public final int getSpeaking() {
        return this.speaking;
    }

    public int hashCode() {
        return (((((this.listening * 31) + this.speaking) * 31) + this.participation) * 31) + this.connected;
    }

    public final void setConnected(int i) {
        this.connected = i;
    }

    public final void setListening(int i) {
        this.listening = i;
    }

    public final void setParticipation(int i) {
        this.participation = i;
    }

    public final void setSpeaking(int i) {
        this.speaking = i;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Duration(listening=");
        sbU.append(this.listening);
        sbU.append(", speaking=");
        sbU.append(this.speaking);
        sbU.append(", participation=");
        sbU.append(this.participation);
        sbU.append(", connected=");
        return outline.B(sbU, this.connected, ")");
    }
}

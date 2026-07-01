package co.discord.media_engine;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: Codecs.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class AudioEncoder {
    private final int channels;
    private final int freq;
    private final String name;
    private final int pacsize;
    private final int rate;
    private final int type;

    public AudioEncoder(int i, String str, int i2, int i3, int i4, int i5) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.type = i;
        this.name = str;
        this.freq = i2;
        this.pacsize = i3;
        this.channels = i4;
        this.rate = i5;
    }

    public static /* synthetic */ AudioEncoder copy$default(AudioEncoder audioEncoder, int i, String str, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = audioEncoder.type;
        }
        if ((i6 & 2) != 0) {
            str = audioEncoder.name;
        }
        String str2 = str;
        if ((i6 & 4) != 0) {
            i2 = audioEncoder.freq;
        }
        int i7 = i2;
        if ((i6 & 8) != 0) {
            i3 = audioEncoder.pacsize;
        }
        int i8 = i3;
        if ((i6 & 16) != 0) {
            i4 = audioEncoder.channels;
        }
        int i9 = i4;
        if ((i6 & 32) != 0) {
            i5 = audioEncoder.rate;
        }
        return audioEncoder.copy(i, str2, i7, i8, i9, i5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getFreq() {
        return this.freq;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getPacsize() {
        return this.pacsize;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getChannels() {
        return this.channels;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getRate() {
        return this.rate;
    }

    public final AudioEncoder copy(int type, String name, int freq, int pacsize, int channels, int rate) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new AudioEncoder(type, name, freq, pacsize, channels, rate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AudioEncoder)) {
            return false;
        }
        AudioEncoder audioEncoder = (AudioEncoder) other;
        return this.type == audioEncoder.type && m.areEqual(this.name, audioEncoder.name) && this.freq == audioEncoder.freq && this.pacsize == audioEncoder.pacsize && this.channels == audioEncoder.channels && this.rate == audioEncoder.rate;
    }

    public final int getChannels() {
        return this.channels;
    }

    public final int getFreq() {
        return this.freq;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPacsize() {
        return this.pacsize;
    }

    public final int getRate() {
        return this.rate;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int i = this.type * 31;
        String str = this.name;
        return ((((((((i + (str != null ? str.hashCode() : 0)) * 31) + this.freq) * 31) + this.pacsize) * 31) + this.channels) * 31) + this.rate;
    }

    public String toString() {
        StringBuilder sbU = a.U("AudioEncoder(type=");
        sbU.append(this.type);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", freq=");
        sbU.append(this.freq);
        sbU.append(", pacsize=");
        sbU.append(this.pacsize);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", rate=");
        return a.B(sbU, this.rate, ")");
    }
}

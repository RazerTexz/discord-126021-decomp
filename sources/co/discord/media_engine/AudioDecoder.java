package co.discord.media_engine;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: Codecs.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class AudioDecoder {
    private final int channels;
    private final int freq;
    private final String name;
    private final Map<String, String> params;
    private final String[] paramsKeys;
    private final String[] paramsValues;
    private final int type;

    public AudioDecoder(int i, String str, int i2, int i3, Map<String, String> map) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(map, "params");
        this.type = i;
        this.name = str;
        this.freq = i2;
        this.channels = i3;
        this.params = map;
        Object[] array = map.keySet().toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        this.paramsKeys = (String[]) array;
        Object[] array2 = map.values().toArray(new String[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
        this.paramsValues = (String[]) array2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AudioDecoder copy$default(AudioDecoder audioDecoder, int i, String str, int i2, int i3, Map map, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = audioDecoder.type;
        }
        if ((i4 & 2) != 0) {
            str = audioDecoder.name;
        }
        String str2 = str;
        if ((i4 & 4) != 0) {
            i2 = audioDecoder.freq;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            i3 = audioDecoder.channels;
        }
        int i6 = i3;
        if ((i4 & 16) != 0) {
            map = audioDecoder.params;
        }
        return audioDecoder.copy(i, str2, i5, i6, map);
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
    public final int getChannels() {
        return this.channels;
    }

    public final Map<String, String> component5() {
        return this.params;
    }

    public final AudioDecoder copy(int type, String name, int freq, int channels, Map<String, String> params) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(params, "params");
        return new AudioDecoder(type, name, freq, channels, params);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AudioDecoder)) {
            return false;
        }
        AudioDecoder audioDecoder = (AudioDecoder) other;
        return this.type == audioDecoder.type && m.areEqual(this.name, audioDecoder.name) && this.freq == audioDecoder.freq && this.channels == audioDecoder.channels && m.areEqual(this.params, audioDecoder.params);
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

    public final Map<String, String> getParams() {
        return this.params;
    }

    public final String[] getParamsKeys() {
        return this.paramsKeys;
    }

    public final String[] getParamsValues() {
        return this.paramsValues;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int i = this.type * 31;
        String str = this.name;
        int iHashCode = (((((i + (str != null ? str.hashCode() : 0)) * 31) + this.freq) * 31) + this.channels) * 31;
        Map<String, String> map = this.params;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("AudioDecoder(type=");
        sbU.append(this.type);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", freq=");
        sbU.append(this.freq);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", params=");
        return a.M(sbU, this.params, ")");
    }
}

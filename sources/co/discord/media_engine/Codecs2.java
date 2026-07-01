package co.discord.media_engine;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: co.discord.media_engine.AudioDecoder, reason: use source file name */
/* JADX INFO: compiled from: Codecs.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Codecs2 {
    private final int channels;
    private final int freq;
    private final String name;
    private final Map<String, String> params;
    private final String[] paramsKeys;
    private final String[] paramsValues;
    private final int type;

    public Codecs2(int i, String str, int i2, int i3, Map<String, String> map) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(map, "params");
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
    public static /* synthetic */ Codecs2 copy$default(Codecs2 codecs2, int i, String str, int i2, int i3, Map map, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = codecs2.type;
        }
        if ((i4 & 2) != 0) {
            str = codecs2.name;
        }
        String str2 = str;
        if ((i4 & 4) != 0) {
            i2 = codecs2.freq;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            i3 = codecs2.channels;
        }
        int i6 = i3;
        if ((i4 & 16) != 0) {
            map = codecs2.params;
        }
        return codecs2.copy(i, str2, i5, i6, map);
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

    public final Codecs2 copy(int type, String name, int freq, int channels, Map<String, String> params) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(params, "params");
        return new Codecs2(type, name, freq, channels, params);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Codecs2)) {
            return false;
        }
        Codecs2 codecs2 = (Codecs2) other;
        return this.type == codecs2.type && Intrinsics3.areEqual(this.name, codecs2.name) && this.freq == codecs2.freq && this.channels == codecs2.channels && Intrinsics3.areEqual(this.params, codecs2.params);
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
        StringBuilder sbU = outline.U("AudioDecoder(type=");
        sbU.append(this.type);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", freq=");
        sbU.append(this.freq);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", params=");
        return outline.M(sbU, this.params, ")");
    }
}

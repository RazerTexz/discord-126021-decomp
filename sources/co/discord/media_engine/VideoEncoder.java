package co.discord.media_engine;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Map;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Codecs.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class VideoEncoder {
    private final String name;
    private final Map<String, String> params;
    private final String[] paramsKeys;
    private final String[] paramsValues;
    private final int rtxType;
    private final int type;

    public VideoEncoder(String str, int i, int i2, Map<String, String> map) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(map, "params");
        this.name = str;
        this.type = i;
        this.rtxType = i2;
        this.params = map;
        Object[] array = map.keySet().toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        this.paramsKeys = (String[]) array;
        Object[] array2 = map.values().toArray(new String[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
        this.paramsValues = (String[]) array2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VideoEncoder copy$default(VideoEncoder videoEncoder, String str, int i, int i2, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = videoEncoder.name;
        }
        if ((i3 & 2) != 0) {
            i = videoEncoder.type;
        }
        if ((i3 & 4) != 0) {
            i2 = videoEncoder.rtxType;
        }
        if ((i3 & 8) != 0) {
            map = videoEncoder.params;
        }
        return videoEncoder.copy(str, i, i2, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRtxType() {
        return this.rtxType;
    }

    public final Map<String, String> component4() {
        return this.params;
    }

    public final VideoEncoder copy(String name, int type, int rtxType, Map<String, String> params) {
        C12238m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(params, "params");
        return new VideoEncoder(name, type, rtxType, params);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoEncoder)) {
            return false;
        }
        VideoEncoder videoEncoder = (VideoEncoder) other;
        return C12238m.areEqual(this.name, videoEncoder.name) && this.type == videoEncoder.type && this.rtxType == videoEncoder.rtxType && C12238m.areEqual(this.params, videoEncoder.params);
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

    public final int getRtxType() {
        return this.rtxType;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.type) * 31) + this.rtxType) * 31;
        Map<String, String> map = this.params;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("VideoEncoder(name=");
        sbM833U.append(this.name);
        sbM833U.append(", type=");
        sbM833U.append(this.type);
        sbM833U.append(", rtxType=");
        sbM833U.append(this.rtxType);
        sbM833U.append(", params=");
        return C1643a.m825M(sbM833U, this.params, ")");
    }
}

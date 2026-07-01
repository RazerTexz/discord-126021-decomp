package co.discord.media_engine;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: co.discord.media_engine.VideoDecoder, reason: use source file name */
/* JADX INFO: compiled from: Codecs.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Codecs4 {
    private final String name;
    private final Map<String, String> params;
    private final String[] paramsKeys;
    private final String[] paramsValues;
    private final int rtxType;
    private final int type;

    public Codecs4(String str, int i, int i2, Map<String, String> map) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(map, "params");
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
    public static /* synthetic */ Codecs4 copy$default(Codecs4 codecs4, String str, int i, int i2, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = codecs4.name;
        }
        if ((i3 & 2) != 0) {
            i = codecs4.type;
        }
        if ((i3 & 4) != 0) {
            i2 = codecs4.rtxType;
        }
        if ((i3 & 8) != 0) {
            map = codecs4.params;
        }
        return codecs4.copy(str, i, i2, map);
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

    public final Codecs4 copy(String name, int type, int rtxType, Map<String, String> params) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(params, "params");
        return new Codecs4(name, type, rtxType, params);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Codecs4)) {
            return false;
        }
        Codecs4 codecs4 = (Codecs4) other;
        return Intrinsics3.areEqual(this.name, codecs4.name) && this.type == codecs4.type && this.rtxType == codecs4.rtxType && Intrinsics3.areEqual(this.params, codecs4.params);
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
        StringBuilder sbU = outline.U("VideoDecoder(name=");
        sbU.append(this.name);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", rtxType=");
        sbU.append(this.rtxType);
        sbU.append(", params=");
        return outline.M(sbU, this.params, ")");
    }
}

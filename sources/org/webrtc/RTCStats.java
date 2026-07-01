package org.webrtc;

import b.d.b.a.a;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: loaded from: classes3.dex */
public class RTCStats {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f3820id;
    private final Map<String, Object> members;
    private final long timestampUs;
    private final String type;

    public RTCStats(long j, String str, String str2, Map<String, Object> map) {
        this.timestampUs = j;
        this.type = str;
        this.f3820id = str2;
        this.members = map;
    }

    private static void appendValue(StringBuilder sb, Object obj) {
        if (!(obj instanceof Object[])) {
            if (!(obj instanceof String)) {
                sb.append(obj);
                return;
            }
            sb.append('\"');
            sb.append(obj);
            sb.append('\"');
            return;
        }
        Object[] objArr = (Object[]) obj;
        sb.append('[');
        for (int i = 0; i < objArr.length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            appendValue(sb, objArr[i]);
        }
        sb.append(']');
    }

    @CalledByNative
    public static RTCStats create(long j, String str, String str2, Map map) {
        return new RTCStats(j, str, str2, map);
    }

    public String getId() {
        return this.f3820id;
    }

    public Map<String, Object> getMembers() {
        return this.members;
    }

    public double getTimestampUs() {
        return this.timestampUs;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder sbU = a.U("{ timestampUs: ");
        sbU.append(this.timestampUs);
        sbU.append(", type: ");
        sbU.append(this.type);
        sbU.append(", id: ");
        sbU.append(this.f3820id);
        for (Map$Entry<String, Object> map$Entry : this.members.entrySet()) {
            sbU.append(", ");
            sbU.append(map$Entry.getKey());
            sbU.append(": ");
            appendValue(sbU, map$Entry.getValue());
        }
        sbU.append(" }");
        return sbU.toString();
    }
}

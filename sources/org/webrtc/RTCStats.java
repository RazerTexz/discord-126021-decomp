package org.webrtc;

import java.util.Map;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes3.dex */
public class RTCStats {

    /* JADX INFO: renamed from: id */
    private final String f27614id;
    private final Map<String, Object> members;
    private final long timestampUs;
    private final String type;

    public RTCStats(long j, String str, String str2, Map<String, Object> map) {
        this.timestampUs = j;
        this.type = str;
        this.f27614id = str2;
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
        return this.f27614id;
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
        StringBuilder sbM833U = C1643a.m833U("{ timestampUs: ");
        sbM833U.append(this.timestampUs);
        sbM833U.append(", type: ");
        sbM833U.append(this.type);
        sbM833U.append(", id: ");
        sbM833U.append(this.f27614id);
        for (Map.Entry<String, Object> entry : this.members.entrySet()) {
            sbM833U.append(", ");
            sbM833U.append(entry.getKey());
            sbM833U.append(": ");
            appendValue(sbM833U, entry.getValue());
        }
        sbM833U.append(" }");
        return sbM833U.toString();
    }
}

package org.webrtc;

import b.d.b.a.outline;

/* JADX INFO: loaded from: classes3.dex */
public class StatsReport {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f3822id;
    public final double timestamp;
    public final String type;
    public final Value[] values;

    public static class Value {
        public final String name;
        public final String value;

        @CalledByNative("Value")
        public Value(String str, String str2) {
            this.name = str;
            this.value = str2;
        }

        public String toString() {
            StringBuilder sbU = outline.U("[");
            sbU.append(this.name);
            sbU.append(": ");
            return outline.J(sbU, this.value, "]");
        }
    }

    @CalledByNative
    public StatsReport(String str, String str2, double d, Value[] valueArr) {
        this.f3822id = str;
        this.type = str2;
        this.timestamp = d;
        this.values = valueArr;
    }

    public String toString() {
        StringBuilder sbU = outline.U("id: ");
        sbU.append(this.f3822id);
        sbU.append(", type: ");
        sbU.append(this.type);
        sbU.append(", timestamp: ");
        sbU.append(this.timestamp);
        sbU.append(", values: ");
        int i = 0;
        while (true) {
            Value[] valueArr = this.values;
            if (i >= valueArr.length) {
                return sbU.toString();
            }
            sbU.append(valueArr[i].toString());
            sbU.append(", ");
            i++;
        }
    }
}

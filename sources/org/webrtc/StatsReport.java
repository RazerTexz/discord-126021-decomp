package org.webrtc;

import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes3.dex */
public class StatsReport {

    /* JADX INFO: renamed from: id */
    public final String f27616id;
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
            StringBuilder sbM833U = C1643a.m833U("[");
            sbM833U.append(this.name);
            sbM833U.append(": ");
            return C1643a.m822J(sbM833U, this.value, "]");
        }
    }

    @CalledByNative
    public StatsReport(String str, String str2, double d, Value[] valueArr) {
        this.f27616id = str;
        this.type = str2;
        this.timestamp = d;
        this.values = valueArr;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("id: ");
        sbM833U.append(this.f27616id);
        sbM833U.append(", type: ");
        sbM833U.append(this.type);
        sbM833U.append(", timestamp: ");
        sbM833U.append(this.timestamp);
        sbM833U.append(", values: ");
        int i = 0;
        while (true) {
            Value[] valueArr = this.values;
            if (i >= valueArr.length) {
                return sbM833U.toString();
            }
            sbM833U.append(valueArr[i].toString());
            sbM833U.append(", ");
            i++;
        }
    }
}

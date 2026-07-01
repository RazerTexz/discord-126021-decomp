package org.webrtc;

import b.d.b.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class StatsReport {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f3822id;
    public final double timestamp;
    public final String type;
    public final StatsReport$Value[] values;

    @CalledByNative
    public StatsReport(String str, String str2, double d, StatsReport$Value[] statsReport$ValueArr) {
        this.f3822id = str;
        this.type = str2;
        this.timestamp = d;
        this.values = statsReport$ValueArr;
    }

    public String toString() {
        StringBuilder sbU = a.U("id: ");
        sbU.append(this.f3822id);
        sbU.append(", type: ");
        sbU.append(this.type);
        sbU.append(", timestamp: ");
        sbU.append(this.timestamp);
        sbU.append(", values: ");
        int i = 0;
        while (true) {
            StatsReport$Value[] statsReport$ValueArr = this.values;
            if (i >= statsReport$ValueArr.length) {
                return sbU.toString();
            }
            sbU.append(statsReport$ValueArr[i].toString());
            sbU.append(", ");
            i++;
        }
    }
}

package org.webrtc;

import b.d.b.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class StatsReport$Value {
    public final String name;
    public final String value;

    @CalledByNative("Value")
    public StatsReport$Value(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    public String toString() {
        StringBuilder sbU = a.U("[");
        sbU.append(this.name);
        sbU.append(": ");
        return a.J(sbU, this.value, "]");
    }
}

package com.discord.rtcconnection;

import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class RtcConnection$State {
    public RtcConnection$State() {
    }

    public String toString() {
        if (this instanceof RtcConnection$State$d) {
            return super.toString();
        }
        String simpleName = getClass().getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public RtcConnection$State(DefaultConstructorMarker defaultConstructorMarker) {
    }
}

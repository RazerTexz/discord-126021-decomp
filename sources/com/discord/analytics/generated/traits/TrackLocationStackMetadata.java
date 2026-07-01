package com.discord.analytics.generated.traits;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: TrackLocationStackMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLocationStackMetadata {
    private final List<CharSequence> locationStack = null;

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackLocationStackMetadata) && m.areEqual(this.locationStack, ((TrackLocationStackMetadata) other).locationStack);
        }
        return true;
    }

    public int hashCode() {
        List<CharSequence> list = this.locationStack;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("TrackLocationStackMetadata(locationStack="), this.locationStack, ")");
    }
}

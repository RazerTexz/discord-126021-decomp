package com.discord.analytics.generated.traits;

import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackLocationStackMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLocationStackMetadata {
    private final List<CharSequence> locationStack = null;

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackLocationStackMetadata) && C12238m.areEqual(this.locationStack, ((TrackLocationStackMetadata) other).locationStack);
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
        return C1643a.m824L(C1643a.m833U("TrackLocationStackMetadata(locationStack="), this.locationStack, ")");
    }
}

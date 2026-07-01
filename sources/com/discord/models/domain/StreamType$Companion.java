package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StreamType$Companion {
    private StreamType$Companion() {
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x0022  */
    public final StreamType fromString(String string) {
        m.checkNotNullParameter(string, "string");
        for (StreamType streamType : StreamType.access$getVALUES$cp()) {
            if (m.areEqual(streamType.getSerializedRepresentation(), string)) {
                if (streamType != null) {
                    return streamType;
                }
                throw new IllegalArgumentException(a.w("unable to parse stream type: ", string));
            }
        }
        streamType = null;
        if (streamType != null) {
            return streamType;
        }
        throw new IllegalArgumentException(a.w("unable to parse stream type: ", string));
    }

    public /* synthetic */ StreamType$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

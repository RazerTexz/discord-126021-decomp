package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public enum StreamType {
    GUILD("guild"),
    CALL(NotificationCompat.CATEGORY_CALL);

    private final String serializedRepresentation;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final StreamType[] VALUES = values();

    /* JADX INFO: compiled from: ModelApplicationStream.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0021 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:11:0x0022  */
        public final StreamType fromString(String string) {
            C12238m.checkNotNullParameter(string, "string");
            for (StreamType streamType : StreamType.VALUES) {
                if (C12238m.areEqual(streamType.getSerializedRepresentation(), string)) {
                    if (streamType != null) {
                        return streamType;
                    }
                    throw new IllegalArgumentException(C1643a.m883w("unable to parse stream type: ", string));
                }
            }
            streamType = null;
            if (streamType != null) {
                return streamType;
            }
            throw new IllegalArgumentException(C1643a.m883w("unable to parse stream type: ", string));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    StreamType(String str) {
        this.serializedRepresentation = str;
    }

    public final String getSerializedRepresentation() {
        return this.serializedRepresentation;
    }
}

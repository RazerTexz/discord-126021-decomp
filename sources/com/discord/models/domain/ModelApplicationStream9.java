package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.models.domain.StreamType, reason: use source file name */
/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public enum ModelApplicationStream9 {
    GUILD("guild"),
    CALL(NotificationCompat.CATEGORY_CALL);

    private final String serializedRepresentation;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ModelApplicationStream9[] VALUES = values();

    /* JADX INFO: renamed from: com.discord.models.domain.StreamType$Companion, reason: from kotlin metadata */
    /* JADX INFO: compiled from: ModelApplicationStream.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0021 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:11:0x0022  */
        public final ModelApplicationStream9 fromString(String string) {
            Intrinsics3.checkNotNullParameter(string, "string");
            for (ModelApplicationStream9 modelApplicationStream9 : ModelApplicationStream9.VALUES) {
                if (Intrinsics3.areEqual(modelApplicationStream9.getSerializedRepresentation(), string)) {
                    if (modelApplicationStream9 != null) {
                        return modelApplicationStream9;
                    }
                    throw new IllegalArgumentException(outline.w("unable to parse stream type: ", string));
                }
            }
            modelApplicationStream9 = null;
            if (modelApplicationStream9 != null) {
                return modelApplicationStream9;
            }
            throw new IllegalArgumentException(outline.w("unable to parse stream type: ", string));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    ModelApplicationStream9(String str) {
        this.serializedRepresentation = str;
    }

    public final String getSerializedRepresentation() {
        return this.serializedRepresentation;
    }
}

package com.discord.models.domain;

import b.d.b.a.a;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModelSubscription.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelSubscription$Status$Companion {
    private ModelSubscription$Status$Companion() {
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    public final ModelSubscription$Status from(int statusInt) {
        ModelSubscription$Status modelSubscription$Status;
        ModelSubscription$Status[] modelSubscription$StatusArrValues = ModelSubscription$Status.values();
        for (int i = 0; i < 6; i++) {
            modelSubscription$Status = modelSubscription$StatusArrValues[i];
            if (modelSubscription$Status.getIntRepresentation() == statusInt) {
                if (modelSubscription$Status != null) {
                    return modelSubscription$Status;
                }
                throw new IllegalArgumentException(a.q("unsupported subscription status: ", statusInt));
            }
        }
        modelSubscription$Status = null;
        if (modelSubscription$Status != null) {
            return modelSubscription$Status;
        }
        throw new IllegalArgumentException(a.q("unsupported subscription status: ", statusInt));
    }

    public /* synthetic */ ModelSubscription$Status$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

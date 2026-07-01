package com.discord.models.domain;

import b.d.b.a.a;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModelSubscription.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelSubscription$Type$Companion {
    private ModelSubscription$Type$Companion() {
    }

    public final ModelSubscription$Type from(int typeInt) {
        if (typeInt == 1) {
            return ModelSubscription$Type.PREMIUM;
        }
        if (typeInt == 2) {
            return ModelSubscription$Type.GUILD;
        }
        throw new IllegalArgumentException(a.q("unsupported subscription type: ", typeInt));
    }

    public /* synthetic */ ModelSubscription$Type$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

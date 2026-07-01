package com.discord.utilities.handoff;

import d0.z.d.m;
import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MobileWebHandoff.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MobileWebHandoff$Companion {
    private MobileWebHandoff$Companion() {
    }

    public final String generateNonce() {
        String string = UUID.randomUUID().toString();
        m.checkNotNullExpressionValue(string, "UUID.randomUUID().toString()");
        return string;
    }

    public /* synthetic */ MobileWebHandoff$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

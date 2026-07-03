package com.lyft.kronos.internal.ntp;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: NTPSyncException.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NTPSyncException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTPSyncException(String str) {
        super(str);
        C12238m.checkParameterIsNotNull(str, "message");
    }
}

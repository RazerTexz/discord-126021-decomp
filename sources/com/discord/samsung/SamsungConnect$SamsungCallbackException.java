package com.discord.samsung;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SamsungConnect.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SamsungConnect$SamsungCallbackException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SamsungConnect$SamsungCallbackException(String str, String str2) {
        super('[' + str + "] " + str2);
        C12238m.checkNotNullParameter(str, "errorCode");
    }
}

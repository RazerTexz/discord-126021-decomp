package com.discord.samsung;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.samsung.SamsungConnect$SamsungCallbackException, reason: use source file name */
/* JADX INFO: compiled from: SamsungConnect.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SamsungConnect3 extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SamsungConnect3(String str, String str2) {
        super('[' + str + "] " + str2);
        Intrinsics3.checkNotNullParameter(str, "errorCode");
    }
}

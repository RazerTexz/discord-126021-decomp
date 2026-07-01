package com.discord.api.auth.mfa;

import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: GetBackupCodesVerificationRequestBody.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GetBackupCodesVerificationRequestBody {
    private final String key;
    private final String nonce;
    private final boolean regenerate;

    public GetBackupCodesVerificationRequestBody(String str, String str2, boolean z2) {
        Intrinsics3.checkNotNullParameter(str, "key");
        Intrinsics3.checkNotNullParameter(str2, "nonce");
        this.key = str;
        this.nonce = str2;
        this.regenerate = z2;
    }
}

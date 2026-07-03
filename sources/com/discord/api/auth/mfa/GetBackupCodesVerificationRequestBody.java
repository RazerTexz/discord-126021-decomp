package com.discord.api.auth.mfa;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GetBackupCodesVerificationRequestBody.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GetBackupCodesVerificationRequestBody {
    private final String key;
    private final String nonce;
    private final boolean regenerate;

    public GetBackupCodesVerificationRequestBody(String str, String str2, boolean z2) {
        C12238m.checkNotNullParameter(str, "key");
        C12238m.checkNotNullParameter(str2, "nonce");
        this.key = str;
        this.nonce = str2;
        this.regenerate = z2;
    }
}

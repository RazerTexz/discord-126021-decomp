package com.discord.utilities.auth;

import b.d.b.a.a;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GoogleSmartLockRepo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SmartLockSignInAttempt {
    private final boolean signedInWithoutError;
    private final boolean usedAutomaticCredentials;

    public SmartLockSignInAttempt() {
        this(false, false, 3, null);
    }

    public SmartLockSignInAttempt(boolean z2, boolean z3) {
        this.usedAutomaticCredentials = z2;
        this.signedInWithoutError = z3;
    }

    public static /* synthetic */ SmartLockSignInAttempt copy$default(SmartLockSignInAttempt smartLockSignInAttempt, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = smartLockSignInAttempt.usedAutomaticCredentials;
        }
        if ((i & 2) != 0) {
            z3 = smartLockSignInAttempt.signedInWithoutError;
        }
        return smartLockSignInAttempt.copy(z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getUsedAutomaticCredentials() {
        return this.usedAutomaticCredentials;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSignedInWithoutError() {
        return this.signedInWithoutError;
    }

    public final SmartLockSignInAttempt copy(boolean usedAutomaticCredentials, boolean signedInWithoutError) {
        return new SmartLockSignInAttempt(usedAutomaticCredentials, signedInWithoutError);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SmartLockSignInAttempt)) {
            return false;
        }
        SmartLockSignInAttempt smartLockSignInAttempt = (SmartLockSignInAttempt) other;
        return this.usedAutomaticCredentials == smartLockSignInAttempt.usedAutomaticCredentials && this.signedInWithoutError == smartLockSignInAttempt.signedInWithoutError;
    }

    public final boolean getSignedInWithoutError() {
        return this.signedInWithoutError;
    }

    public final boolean getUsedAutomaticCredentials() {
        return this.usedAutomaticCredentials;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean z2 = this.usedAutomaticCredentials;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.signedInWithoutError;
        return i + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbU = a.U("SmartLockSignInAttempt(usedAutomaticCredentials=");
        sbU.append(this.usedAutomaticCredentials);
        sbU.append(", signedInWithoutError=");
        return a.O(sbU, this.signedInWithoutError, ")");
    }

    public /* synthetic */ SmartLockSignInAttempt(boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? true : z3);
    }
}

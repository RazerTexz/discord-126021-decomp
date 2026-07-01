package com.discord.utilities.auth;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.auth.GoogleSmartLockRepo$Companion$INSTANCE$2, reason: use source file name */
/* JADX INFO: compiled from: GoogleSmartLockRepo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GoogleSmartLockRepo2 extends Lambda implements Function0<GoogleSmartLockRepo> {
    public static final GoogleSmartLockRepo2 INSTANCE = new GoogleSmartLockRepo2();

    public GoogleSmartLockRepo2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GoogleSmartLockRepo invoke() {
        return new GoogleSmartLockRepo(null, 1, null);
    }
}

package com.discord.utilities.auth;

import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GoogleSmartLockRepo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GoogleSmartLockRepo$Companion {
    private GoogleSmartLockRepo$Companion() {
    }

    public final GoogleSmartLockRepo getINSTANCE() {
        Lazy lazyAccess$getINSTANCE$cp = GoogleSmartLockRepo.access$getINSTANCE$cp();
        GoogleSmartLockRepo$Companion googleSmartLockRepo$Companion = GoogleSmartLockRepo.Companion;
        return (GoogleSmartLockRepo) lazyAccess$getINSTANCE$cp.getValue();
    }

    public /* synthetic */ GoogleSmartLockRepo$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

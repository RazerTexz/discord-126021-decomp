package com.discord.utilities.auth;

import android.content.Intent;
import com.google.android.gms.auth.api.credentials.Credential;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GoogleSmartLockManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GoogleSmartLockManager$Companion {
    private GoogleSmartLockManager$Companion() {
    }

    public final void handleResult(int resultCode, Intent data) {
        if (resultCode != -1 || data == null) {
            return;
        }
        Credential credential = (Credential) data.getParcelableExtra("com.google.android.gms.credentials.Credential");
        String str = credential != null ? credential.j : null;
        String str2 = credential != null ? credential.n : null;
        if (str == null || str2 == null) {
            return;
        }
        GoogleSmartLockRepo.Companion.getINSTANCE().setSmartLockLogin(str, str2);
    }

    public /* synthetic */ GoogleSmartLockManager$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

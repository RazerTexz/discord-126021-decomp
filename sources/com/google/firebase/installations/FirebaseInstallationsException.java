package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseException;

/* JADX INFO: loaded from: classes3.dex */
public class FirebaseInstallationsException extends FirebaseException {

    @NonNull
    private final EnumC11081a status;

    /* JADX INFO: renamed from: com.google.firebase.installations.FirebaseInstallationsException$a */
    public enum EnumC11081a {
        BAD_CONFIG,
        UNAVAILABLE,
        TOO_MANY_REQUESTS
    }

    public FirebaseInstallationsException(@NonNull EnumC11081a enumC11081a) {
        this.status = enumC11081a;
    }

    public FirebaseInstallationsException(@NonNull String str, @NonNull EnumC11081a enumC11081a) {
        super(str);
        this.status = enumC11081a;
    }
}

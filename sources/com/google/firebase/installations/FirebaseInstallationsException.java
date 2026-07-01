package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseException;

/* JADX INFO: loaded from: classes3.dex */
public class FirebaseInstallationsException extends FirebaseException {

    @NonNull
    private final a status;

    public enum a {
        BAD_CONFIG,
        UNAVAILABLE,
        TOO_MANY_REQUESTS
    }

    public FirebaseInstallationsException(@NonNull a aVar) {
        this.status = aVar;
    }

    public FirebaseInstallationsException(@NonNull String str, @NonNull a aVar) {
        super(str);
        this.status = aVar;
    }
}

package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseException;

/* JADX INFO: loaded from: classes3.dex */
public class FirebaseInstallationsException extends FirebaseException {

    @NonNull
    private final FirebaseInstallationsException$a status;

    public FirebaseInstallationsException(@NonNull FirebaseInstallationsException$a firebaseInstallationsException$a) {
        this.status = firebaseInstallationsException$a;
    }

    public FirebaseInstallationsException(@NonNull String str, @NonNull FirebaseInstallationsException$a firebaseInstallationsException$a) {
        super(str);
        this.status = firebaseInstallationsException$a;
    }
}

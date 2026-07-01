package com.discord.app;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppPermissions.kt */
/* JADX INFO: loaded from: classes.dex */
public interface AppPermissionsRequests {
    public static final /* synthetic */ int a = 0;

    boolean hasMedia();

    void requestCameraQRScanner(Function0<Unit> onSuccess);

    void requestCameraQRScanner(Function0<Unit> onSuccess, Function0<Unit> onFailure);

    void requestContacts(Function0<Unit> onSuccess, Function0<Unit> onFailure);

    void requestMedia(Function0<Unit> onSuccess);

    void requestMediaDownload(Function0<Unit> onSuccess);

    void requestMicrophone(Function0<Unit> onFailure, Function0<Unit> onSuccess);

    void requestVideoCallPermissions(Function0<Unit> onSuccess);
}

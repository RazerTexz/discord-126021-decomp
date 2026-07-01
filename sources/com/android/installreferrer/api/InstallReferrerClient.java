package com.android.installreferrer.api;

import android.content.Context;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class InstallReferrerClient {
    public static InstallReferrerClient$Builder newBuilder(Context context) {
        return new InstallReferrerClient$Builder(context, null);
    }

    public abstract void endConnection();

    public abstract ReferrerDetails getInstallReferrer() throws RemoteException;

    public abstract boolean isReady();

    public abstract void startConnection(InstallReferrerStateListener installReferrerStateListener);
}

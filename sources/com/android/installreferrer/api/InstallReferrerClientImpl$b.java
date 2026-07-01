package com.android.installreferrer.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import b.i.a.d.a.a;
import b.i.a.d.a.a$a;
import b.i.a.d.a.a$a$a;
import com.android.installreferrer.commons.InstallReferrerCommons;

/* JADX INFO: loaded from: classes.dex */
public final class InstallReferrerClientImpl$b implements ServiceConnection {
    public final InstallReferrerStateListener j;
    public final /* synthetic */ InstallReferrerClientImpl k;

    public InstallReferrerClientImpl$b(InstallReferrerClientImpl installReferrerClientImpl, InstallReferrerStateListener installReferrerStateListener, InstallReferrerClientImpl$a installReferrerClientImpl$a) {
        this.k = installReferrerClientImpl;
        if (installReferrerStateListener == null) {
            throw new RuntimeException("Please specify a listener to know when setup is done.");
        }
        this.j = installReferrerStateListener;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a a_a_a;
        InstallReferrerCommons.logVerbose("InstallReferrerClient", "Install Referrer service connected.");
        InstallReferrerClientImpl installReferrerClientImpl = this.k;
        int i = a$a.a;
        if (iBinder == null) {
            a_a_a = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            a_a_a = iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new a$a$a(iBinder);
        }
        installReferrerClientImpl.c = a_a_a;
        this.k.a = 2;
        this.j.onInstallReferrerSetupFinished(0);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        InstallReferrerCommons.logWarn("InstallReferrerClient", "Install Referrer service disconnected.");
        InstallReferrerClientImpl installReferrerClientImpl = this.k;
        installReferrerClientImpl.c = null;
        installReferrerClientImpl.a = 0;
        this.j.onInstallReferrerServiceDisconnected();
    }
}

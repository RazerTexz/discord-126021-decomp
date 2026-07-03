package com.android.installreferrer.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.android.installreferrer.commons.InstallReferrerCommons;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import p007b.p225i.p226a.p285d.p286a.InterfaceC3169a;

/* JADX INFO: loaded from: classes.dex */
public class InstallReferrerClientImpl extends InstallReferrerClient {

    /* JADX INFO: renamed from: a */
    public int f14569a = 0;

    /* JADX INFO: renamed from: b */
    public final Context f14570b;

    /* JADX INFO: renamed from: c */
    public InterfaceC3169a f14571c;

    /* JADX INFO: renamed from: d */
    public ServiceConnection f14572d;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ClientState {
        public static final int CLOSED = 3;
        public static final int CONNECTED = 2;
        public static final int CONNECTING = 1;
        public static final int DISCONNECTED = 0;
    }

    /* JADX INFO: renamed from: com.android.installreferrer.api.InstallReferrerClientImpl$b */
    public final class ServiceConnectionC5418b implements ServiceConnection {

        /* JADX INFO: renamed from: j */
        public final InstallReferrerStateListener f14573j;

        public ServiceConnectionC5418b(InstallReferrerStateListener installReferrerStateListener, C5417a c5417a) {
            if (installReferrerStateListener == null) {
                throw new RuntimeException("Please specify a listener to know when setup is done.");
            }
            this.f14573j = installReferrerStateListener;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            InterfaceC3169a c13227a;
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Install Referrer service connected.");
            InstallReferrerClientImpl installReferrerClientImpl = InstallReferrerClientImpl.this;
            int i = InterfaceC3169a.a.f9162a;
            if (iBinder == null) {
                c13227a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
                c13227a = iInterfaceQueryLocalInterface instanceof InterfaceC3169a ? (InterfaceC3169a) iInterfaceQueryLocalInterface : new InterfaceC3169a.a.C13227a(iBinder);
            }
            installReferrerClientImpl.f14571c = c13227a;
            InstallReferrerClientImpl.this.f14569a = 2;
            this.f14573j.onInstallReferrerSetupFinished(0);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "Install Referrer service disconnected.");
            InstallReferrerClientImpl installReferrerClientImpl = InstallReferrerClientImpl.this;
            installReferrerClientImpl.f14571c = null;
            installReferrerClientImpl.f14569a = 0;
            this.f14573j.onInstallReferrerServiceDisconnected();
        }
    }

    public InstallReferrerClientImpl(Context context) {
        this.f14570b = context.getApplicationContext();
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public void endConnection() {
        this.f14569a = 3;
        if (this.f14572d != null) {
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Unbinding from service.");
            this.f14570b.unbindService(this.f14572d);
            this.f14572d = null;
        }
        this.f14571c = null;
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public ReferrerDetails getInstallReferrer() throws RemoteException {
        if (!isReady()) {
            throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", this.f14570b.getPackageName());
        try {
            return new ReferrerDetails(this.f14571c.mo3923B(bundle));
        } catch (RemoteException e) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "RemoteException getting install referrer information");
            this.f14569a = 0;
            throw e;
        }
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public boolean isReady() {
        return (this.f14569a != 2 || this.f14571c == null || this.f14572d == null) ? false : true;
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public void startConnection(InstallReferrerStateListener installReferrerStateListener) {
        ServiceInfo serviceInfo;
        boolean z2;
        if (isReady()) {
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Service connection is valid. No need to re-initialize.");
            installReferrerStateListener.onInstallReferrerSetupFinished(0);
            return;
        }
        int i = this.f14569a;
        if (i == 1) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "Client is already in the process of connecting to the service.");
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
            return;
        }
        if (i == 3) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "Client was already closed and can't be reused. Please create another instance.");
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
            return;
        }
        InstallReferrerCommons.logVerbose("InstallReferrerClient", "Starting install referrer service setup.");
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        List<ResolveInfo> listQueryIntentServices = this.f14570b.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty() || (serviceInfo = listQueryIntentServices.get(0).serviceInfo) == null) {
            this.f14569a = 0;
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Install Referrer service unavailable on device.");
            installReferrerStateListener.onInstallReferrerSetupFinished(2);
            return;
        }
        String str = serviceInfo.packageName;
        String str2 = serviceInfo.name;
        if ("com.android.vending".equals(str) && str2 != null) {
            try {
                z2 = this.f14570b.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (z2) {
                Intent intent2 = new Intent(intent);
                ServiceConnectionC5418b serviceConnectionC5418b = new ServiceConnectionC5418b(installReferrerStateListener, null);
                this.f14572d = serviceConnectionC5418b;
                try {
                    if (this.f14570b.bindService(intent2, serviceConnectionC5418b, 1)) {
                        InstallReferrerCommons.logVerbose("InstallReferrerClient", "Service was bonded successfully.");
                        return;
                    }
                    InstallReferrerCommons.logWarn("InstallReferrerClient", "Connection to service is blocked.");
                    this.f14569a = 0;
                    installReferrerStateListener.onInstallReferrerSetupFinished(1);
                    return;
                } catch (SecurityException unused2) {
                    InstallReferrerCommons.logWarn("InstallReferrerClient", "No permission to connect to service.");
                    this.f14569a = 0;
                    installReferrerStateListener.onInstallReferrerSetupFinished(4);
                    return;
                }
            }
        }
        InstallReferrerCommons.logWarn("InstallReferrerClient", "Play Store missing or incompatible. Version 8.3.73 or later required.");
        this.f14569a = 0;
        installReferrerStateListener.onInstallReferrerSetupFinished(2);
    }
}

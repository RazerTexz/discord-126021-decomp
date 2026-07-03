package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p668x.p669a.p670a.InterfaceC13176a;
import p668x.p669a.p670a.InterfaceC13178c;

/* JADX INFO: loaded from: classes.dex */
public class PostMessageService extends Service {
    private InterfaceC13178c.a mBinder = new InterfaceC13178c.a() { // from class: androidx.browser.customtabs.PostMessageService.1
        @Override // p668x.p669a.p670a.InterfaceC13178c
        public void onMessageChannelReady(@NonNull InterfaceC13176a interfaceC13176a, @Nullable Bundle bundle) throws RemoteException {
            interfaceC13176a.onMessageChannelReady(bundle);
        }

        @Override // p668x.p669a.p670a.InterfaceC13178c
        public void onPostMessage(@NonNull InterfaceC13176a interfaceC13176a, @NonNull String str, @Nullable Bundle bundle) throws RemoteException {
            interfaceC13176a.onPostMessage(str, bundle);
        }
    };

    @Override // android.app.Service
    @NonNull
    public IBinder onBind(@Nullable Intent intent) {
        return this.mBinder;
    }
}

package androidx.browser.trusted;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p668x.p669a.p670a.p671d.InterfaceC13179a;

/* JADX INFO: loaded from: classes.dex */
public class TrustedWebActivityCallbackRemote {
    private final InterfaceC13179a mCallbackBinder;

    private TrustedWebActivityCallbackRemote(@NonNull InterfaceC13179a interfaceC13179a) {
        this.mCallbackBinder = interfaceC13179a;
    }

    @Nullable
    public static TrustedWebActivityCallbackRemote fromBinder(@Nullable IBinder iBinder) {
        InterfaceC13179a interfaceC13179aAsInterface = iBinder == null ? null : InterfaceC13179a.a.asInterface(iBinder);
        if (interfaceC13179aAsInterface == null) {
            return null;
        }
        return new TrustedWebActivityCallbackRemote(interfaceC13179aAsInterface);
    }

    public void runExtraCallback(@NonNull String str, @NonNull Bundle bundle) throws RemoteException {
        this.mCallbackBinder.onExtraCallback(str, bundle);
    }
}

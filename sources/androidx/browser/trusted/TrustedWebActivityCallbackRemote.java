package androidx.browser.trusted;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import x.a.a.d.a;
import x.a.a.d.a$a;

/* JADX INFO: loaded from: classes.dex */
public class TrustedWebActivityCallbackRemote {
    private final a mCallbackBinder;

    private TrustedWebActivityCallbackRemote(@NonNull a aVar) {
        this.mCallbackBinder = aVar;
    }

    @Nullable
    public static TrustedWebActivityCallbackRemote fromBinder(@Nullable IBinder iBinder) {
        a aVarAsInterface = iBinder == null ? null : a$a.asInterface(iBinder);
        if (aVarAsInterface == null) {
            return null;
        }
        return new TrustedWebActivityCallbackRemote(aVarAsInterface);
    }

    public void runExtraCallback(@NonNull String str, @NonNull Bundle bundle) throws RemoteException {
        this.mCallbackBinder.onExtraCallback(str, bundle);
    }
}

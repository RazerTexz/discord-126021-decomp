package androidx.browser.trusted;

import android.os.Bundle;
import android.os.RemoteException;
import x.a.a.d.a$a;

/* JADX INFO: loaded from: classes.dex */
public class TrustedWebActivityServiceConnection$1 extends a$a {
    public final /* synthetic */ TrustedWebActivityCallback val$callback;

    public TrustedWebActivityServiceConnection$1(TrustedWebActivityCallback trustedWebActivityCallback) {
        this.val$callback = trustedWebActivityCallback;
    }

    @Override // x.a.a.d.a
    public void onExtraCallback(String str, Bundle bundle) throws RemoteException {
        this.val$callback.onExtraCallback(str, bundle);
    }
}

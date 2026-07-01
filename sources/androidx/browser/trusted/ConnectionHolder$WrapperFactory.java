package androidx.browser.trusted;

import android.content.ComponentName;
import android.os.IBinder;
import androidx.annotation.NonNull;
import x.a.a.d.b$a;

/* JADX INFO: loaded from: classes.dex */
public class ConnectionHolder$WrapperFactory {
    @NonNull
    public TrustedWebActivityServiceConnection create(ComponentName componentName, IBinder iBinder) {
        return new TrustedWebActivityServiceConnection(b$a.asInterface(iBinder), componentName);
    }
}

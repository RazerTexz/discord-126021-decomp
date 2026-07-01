package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import x.a.a.c$a;

/* JADX INFO: loaded from: classes.dex */
public class PostMessageService extends Service {
    private c$a mBinder = new PostMessageService$1(this);

    @Override // android.app.Service
    @NonNull
    public IBinder onBind(@Nullable Intent intent) {
        return this.mBinder;
    }
}

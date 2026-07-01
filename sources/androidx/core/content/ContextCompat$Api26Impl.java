package androidx.core.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public class ContextCompat$Api26Impl {
    private ContextCompat$Api26Impl() {
    }

    @DoNotInline
    public static ComponentName startForegroundService(Context context, Intent intent) {
        return context.startForegroundService(intent);
    }
}

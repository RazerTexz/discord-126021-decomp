package androidx.core.content;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
public class ContextCompat$Api24Impl {
    private ContextCompat$Api24Impl() {
    }

    @DoNotInline
    public static Context createDeviceProtectedStorageContext(Context context) {
        return context.createDeviceProtectedStorageContext();
    }

    @DoNotInline
    public static File getDataDir(Context context) {
        return context.getDataDir();
    }

    @DoNotInline
    public static boolean isDeviceProtectedStorage(Context context) {
        return context.isDeviceProtectedStorage();
    }
}

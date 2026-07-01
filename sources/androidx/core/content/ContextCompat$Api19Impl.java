package androidx.core.content;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
public class ContextCompat$Api19Impl {
    private ContextCompat$Api19Impl() {
    }

    @DoNotInline
    public static File[] getExternalCacheDirs(Context context) {
        return context.getExternalCacheDirs();
    }

    @DoNotInline
    public static File[] getExternalFilesDirs(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    @DoNotInline
    public static File[] getObbDirs(Context context) {
        return context.getObbDirs();
    }
}

package androidx.core.content;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class ContextCompat$Api21Impl {
    private ContextCompat$Api21Impl() {
    }

    @DoNotInline
    public static File getCodeCacheDir(Context context) {
        return context.getCodeCacheDir();
    }

    @DoNotInline
    public static Drawable getDrawable(Context context, int i) {
        return context.getDrawable(i);
    }

    @DoNotInline
    public static File getNoBackupFilesDir(Context context) {
        return context.getNoBackupFilesDir();
    }
}

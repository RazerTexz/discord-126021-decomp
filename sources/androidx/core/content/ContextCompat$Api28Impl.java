package androidx.core.content;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
public class ContextCompat$Api28Impl {
    private ContextCompat$Api28Impl() {
    }

    @DoNotInline
    public static Executor getMainExecutor(Context context) {
        return context.getMainExecutor();
    }
}

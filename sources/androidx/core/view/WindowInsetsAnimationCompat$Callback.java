package androidx.core.view;

import android.view.WindowInsets;
import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class WindowInsetsAnimationCompat$Callback {
    public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
    public static final int DISPATCH_MODE_STOP = 0;
    public WindowInsets mDispachedInsets;
    private final int mDispatchMode;

    public WindowInsetsAnimationCompat$Callback(int i) {
        this.mDispatchMode = i;
    }

    public final int getDispatchMode() {
        return this.mDispatchMode;
    }

    public void onEnd(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
    }

    public void onPrepare(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
    }

    @NonNull
    public abstract WindowInsetsCompat onProgress(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull List<WindowInsetsAnimationCompat> list);

    @NonNull
    public WindowInsetsAnimationCompat$BoundsCompat onStart(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat, @NonNull WindowInsetsAnimationCompat$BoundsCompat windowInsetsAnimationCompat$BoundsCompat) {
        return windowInsetsAnimationCompat$BoundsCompat;
    }
}

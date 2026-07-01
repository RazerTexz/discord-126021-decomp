package androidx.core.view;

import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Bounds;
import android.view.WindowInsetsAnimation$Callback;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(30)
public class WindowInsetsAnimationCompat$Impl30$ProxyCallback extends WindowInsetsAnimation$Callback {
    private final HashMap<WindowInsetsAnimation, WindowInsetsAnimationCompat> mAnimations;
    private final WindowInsetsAnimationCompat$Callback mCompat;
    private List<WindowInsetsAnimationCompat> mRORunningAnimations;
    private ArrayList<WindowInsetsAnimationCompat> mTmpRunningAnimations;

    public WindowInsetsAnimationCompat$Impl30$ProxyCallback(@NonNull WindowInsetsAnimationCompat$Callback windowInsetsAnimationCompat$Callback) {
        super(windowInsetsAnimationCompat$Callback.getDispatchMode());
        this.mAnimations = new HashMap<>();
        this.mCompat = windowInsetsAnimationCompat$Callback;
    }

    @NonNull
    private WindowInsetsAnimationCompat getWindowInsetsAnimationCompat(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
        WindowInsetsAnimationCompat windowInsetsAnimationCompat = this.mAnimations.get(windowInsetsAnimation);
        if (windowInsetsAnimationCompat != null) {
            return windowInsetsAnimationCompat;
        }
        WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = WindowInsetsAnimationCompat.toWindowInsetsAnimationCompat(windowInsetsAnimation);
        this.mAnimations.put(windowInsetsAnimation, windowInsetsAnimationCompat2);
        return windowInsetsAnimationCompat2;
    }

    @Override // android.view.WindowInsetsAnimation$Callback
    public void onEnd(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
        this.mCompat.onEnd(getWindowInsetsAnimationCompat(windowInsetsAnimation));
        this.mAnimations.remove(windowInsetsAnimation);
    }

    @Override // android.view.WindowInsetsAnimation$Callback
    public void onPrepare(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
        this.mCompat.onPrepare(getWindowInsetsAnimationCompat(windowInsetsAnimation));
    }

    @Override // android.view.WindowInsetsAnimation$Callback
    @NonNull
    public WindowInsets onProgress(@NonNull WindowInsets windowInsets, @NonNull List<WindowInsetsAnimation> list) {
        ArrayList<WindowInsetsAnimationCompat> arrayList = this.mTmpRunningAnimations;
        if (arrayList == null) {
            ArrayList<WindowInsetsAnimationCompat> arrayList2 = new ArrayList<>(list.size());
            this.mTmpRunningAnimations = arrayList2;
            this.mRORunningAnimations = Collections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            WindowInsetsAnimation windowInsetsAnimation = list.get(size);
            WindowInsetsAnimationCompat windowInsetsAnimationCompat = getWindowInsetsAnimationCompat(windowInsetsAnimation);
            windowInsetsAnimationCompat.setFraction(windowInsetsAnimation.getFraction());
            this.mTmpRunningAnimations.add(windowInsetsAnimationCompat);
        }
        return this.mCompat.onProgress(WindowInsetsCompat.toWindowInsetsCompat(windowInsets), this.mRORunningAnimations).toWindowInsets();
    }

    @Override // android.view.WindowInsetsAnimation$Callback
    @NonNull
    public WindowInsetsAnimation$Bounds onStart(@NonNull WindowInsetsAnimation windowInsetsAnimation, @NonNull WindowInsetsAnimation$Bounds windowInsetsAnimation$Bounds) {
        return this.mCompat.onStart(getWindowInsetsAnimationCompat(windowInsetsAnimation), WindowInsetsAnimationCompat$BoundsCompat.toBoundsCompat(windowInsetsAnimation$Bounds)).toBounds();
    }
}

package androidx.dynamicanimation.animation;

import android.os.SystemClock;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AnimationHandler {
    private static final long FRAME_DELAY_MS = 10;
    public static final ThreadLocal<AnimationHandler> sAnimatorHandler = new ThreadLocal<>();
    private AnimationHandler$AnimationFrameCallbackProvider mProvider;
    private final SimpleArrayMap<AnimationHandler$AnimationFrameCallback, Long> mDelayedCallbackStartTime = new SimpleArrayMap<>();
    public final ArrayList<AnimationHandler$AnimationFrameCallback> mAnimationCallbacks = new ArrayList<>();
    private final AnimationHandler$AnimationCallbackDispatcher mCallbackDispatcher = new AnimationHandler$AnimationCallbackDispatcher(this);
    public long mCurrentFrameTime = 0;
    private boolean mListDirty = false;

    private void cleanUpList() {
        if (this.mListDirty) {
            for (int size = this.mAnimationCallbacks.size() - 1; size >= 0; size--) {
                if (this.mAnimationCallbacks.get(size) == null) {
                    this.mAnimationCallbacks.remove(size);
                }
            }
            this.mListDirty = false;
        }
    }

    public static long getFrameTime() {
        ThreadLocal<AnimationHandler> threadLocal = sAnimatorHandler;
        if (threadLocal.get() == null) {
            return 0L;
        }
        return threadLocal.get().mCurrentFrameTime;
    }

    public static AnimationHandler getInstance() {
        ThreadLocal<AnimationHandler> threadLocal = sAnimatorHandler;
        if (threadLocal.get() == null) {
            threadLocal.set(new AnimationHandler());
        }
        return threadLocal.get();
    }

    private boolean isCallbackDue(AnimationHandler$AnimationFrameCallback animationHandler$AnimationFrameCallback, long j) {
        Long l = this.mDelayedCallbackStartTime.get(animationHandler$AnimationFrameCallback);
        if (l == null) {
            return true;
        }
        if (l.longValue() >= j) {
            return false;
        }
        this.mDelayedCallbackStartTime.remove(animationHandler$AnimationFrameCallback);
        return true;
    }

    public void addAnimationFrameCallback(AnimationHandler$AnimationFrameCallback animationHandler$AnimationFrameCallback, long j) {
        if (this.mAnimationCallbacks.size() == 0) {
            getProvider().postFrameCallback();
        }
        if (!this.mAnimationCallbacks.contains(animationHandler$AnimationFrameCallback)) {
            this.mAnimationCallbacks.add(animationHandler$AnimationFrameCallback);
        }
        if (j > 0) {
            this.mDelayedCallbackStartTime.put(animationHandler$AnimationFrameCallback, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public void doAnimationFrame(long j) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        for (int i = 0; i < this.mAnimationCallbacks.size(); i++) {
            AnimationHandler$AnimationFrameCallback animationHandler$AnimationFrameCallback = this.mAnimationCallbacks.get(i);
            if (animationHandler$AnimationFrameCallback != null && isCallbackDue(animationHandler$AnimationFrameCallback, jUptimeMillis)) {
                animationHandler$AnimationFrameCallback.doAnimationFrame(j);
            }
        }
        cleanUpList();
    }

    public AnimationHandler$AnimationFrameCallbackProvider getProvider() {
        if (this.mProvider == null) {
            this.mProvider = new AnimationHandler$FrameCallbackProvider16(this.mCallbackDispatcher);
        }
        return this.mProvider;
    }

    public void removeCallback(AnimationHandler$AnimationFrameCallback animationHandler$AnimationFrameCallback) {
        this.mDelayedCallbackStartTime.remove(animationHandler$AnimationFrameCallback);
        int iIndexOf = this.mAnimationCallbacks.indexOf(animationHandler$AnimationFrameCallback);
        if (iIndexOf >= 0) {
            this.mAnimationCallbacks.set(iIndexOf, null);
            this.mListDirty = true;
        }
    }

    public void setProvider(AnimationHandler$AnimationFrameCallbackProvider animationHandler$AnimationFrameCallbackProvider) {
        this.mProvider = animationHandler$AnimationFrameCallbackProvider;
    }
}

package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface Animatable2Compat extends Animatable {
    void clearAnimationCallbacks();

    void registerAnimationCallback(@NonNull Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback);

    boolean unregisterAnimationCallback(@NonNull Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback);
}

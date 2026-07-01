package androidx.appcompat.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedStateListDrawableCompat$AnimatedStateListState extends StateListDrawable$StateListState {
    private static final long REVERSED_BIT = 4294967296L;
    private static final long REVERSIBLE_FLAG_BIT = 8589934592L;
    public SparseArrayCompat<Integer> mStateIds;
    public LongSparseArray<Long> mTransitions;

    public AnimatedStateListDrawableCompat$AnimatedStateListState(@Nullable AnimatedStateListDrawableCompat$AnimatedStateListState animatedStateListDrawableCompat$AnimatedStateListState, @NonNull AnimatedStateListDrawableCompat animatedStateListDrawableCompat, @Nullable Resources resources) {
        super(animatedStateListDrawableCompat$AnimatedStateListState, animatedStateListDrawableCompat, resources);
        if (animatedStateListDrawableCompat$AnimatedStateListState != null) {
            this.mTransitions = animatedStateListDrawableCompat$AnimatedStateListState.mTransitions;
            this.mStateIds = animatedStateListDrawableCompat$AnimatedStateListState.mStateIds;
        } else {
            this.mTransitions = new LongSparseArray<>();
            this.mStateIds = new SparseArrayCompat<>();
        }
    }

    private static long generateTransitionKey(int i, int i2) {
        return ((long) i2) | (((long) i) << 32);
    }

    public int addStateSet(@NonNull int[] iArr, @NonNull Drawable drawable, int i) {
        int iAddStateSet = super.addStateSet(iArr, drawable);
        this.mStateIds.put(iAddStateSet, Integer.valueOf(i));
        return iAddStateSet;
    }

    public int addTransition(int i, int i2, @NonNull Drawable drawable, boolean z2) {
        int iAddChild = super.addChild(drawable);
        long jGenerateTransitionKey = generateTransitionKey(i, i2);
        long j = z2 ? 8589934592L : 0L;
        long j2 = iAddChild;
        this.mTransitions.append(jGenerateTransitionKey, Long.valueOf(j2 | j));
        if (z2) {
            this.mTransitions.append(generateTransitionKey(i2, i), Long.valueOf(4294967296L | j2 | j));
        }
        return iAddChild;
    }

    public int getKeyframeIdAt(int i) {
        if (i < 0) {
            return 0;
        }
        return this.mStateIds.get(i, 0).intValue();
    }

    public int indexOfKeyframe(@NonNull int[] iArr) {
        int iIndexOfStateSet = super.indexOfStateSet(iArr);
        return iIndexOfStateSet >= 0 ? iIndexOfStateSet : super.indexOfStateSet(StateSet.WILD_CARD);
    }

    public int indexOfTransition(int i, int i2) {
        return (int) this.mTransitions.get(generateTransitionKey(i, i2), -1L).longValue();
    }

    public boolean isTransitionReversed(int i, int i2) {
        return (this.mTransitions.get(generateTransitionKey(i, i2), -1L).longValue() & 4294967296L) != 0;
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable$StateListState, androidx.appcompat.graphics.drawable.DrawableContainer$DrawableContainerState
    public void mutate() {
        this.mTransitions = this.mTransitions.clone();
        this.mStateIds = this.mStateIds.clone();
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable$StateListState, android.graphics.drawable.Drawable$ConstantState
    @NonNull
    public Drawable newDrawable() {
        return new AnimatedStateListDrawableCompat(this, null);
    }

    public boolean transitionHasReversibleFlag(int i, int i2) {
        return (this.mTransitions.get(generateTransitionKey(i, i2), -1L).longValue() & 8589934592L) != 0;
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable$StateListState, android.graphics.drawable.Drawable$ConstantState
    @NonNull
    public Drawable newDrawable(Resources resources) {
        return new AnimatedStateListDrawableCompat(this, resources);
    }
}

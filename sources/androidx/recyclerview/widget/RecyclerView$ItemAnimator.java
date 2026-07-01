package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class RecyclerView$ItemAnimator {
    public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
    public static final int FLAG_CHANGED = 2;
    public static final int FLAG_INVALIDATED = 4;
    public static final int FLAG_MOVED = 2048;
    public static final int FLAG_REMOVED = 8;
    private RecyclerView$ItemAnimator$ItemAnimatorListener mListener = null;
    private ArrayList<RecyclerView$ItemAnimator$ItemAnimatorFinishedListener> mFinishedListeners = new ArrayList<>();
    private long mAddDuration = 120;
    private long mRemoveDuration = 120;
    private long mMoveDuration = 250;
    private long mChangeDuration = 250;

    public static int buildAdapterChangeFlagsForAnimations(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        int i = recyclerView$ViewHolder.mFlags & 14;
        if (recyclerView$ViewHolder.isInvalid()) {
            return 4;
        }
        if ((i & 4) != 0) {
            return i;
        }
        int oldPosition = recyclerView$ViewHolder.getOldPosition();
        int absoluteAdapterPosition = recyclerView$ViewHolder.getAbsoluteAdapterPosition();
        return (oldPosition == -1 || absoluteAdapterPosition == -1 || oldPosition == absoluteAdapterPosition) ? i : i | 2048;
    }

    public abstract boolean animateAppearance(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder, @Nullable RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo2);

    public abstract boolean animateChange(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder, @NonNull RecyclerView$ViewHolder recyclerView$ViewHolder2, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo2);

    public abstract boolean animateDisappearance(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo, @Nullable RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo2);

    public abstract boolean animatePersistence(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo2);

    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return true;
    }

    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder, @NonNull List<Object> list) {
        return canReuseUpdatedViewHolder(recyclerView$ViewHolder);
    }

    public final void dispatchAnimationFinished(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder) {
        onAnimationFinished(recyclerView$ViewHolder);
        RecyclerView$ItemAnimator$ItemAnimatorListener recyclerView$ItemAnimator$ItemAnimatorListener = this.mListener;
        if (recyclerView$ItemAnimator$ItemAnimatorListener != null) {
            recyclerView$ItemAnimator$ItemAnimatorListener.onAnimationFinished(recyclerView$ViewHolder);
        }
    }

    public final void dispatchAnimationStarted(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder) {
        onAnimationStarted(recyclerView$ViewHolder);
    }

    public final void dispatchAnimationsFinished() {
        int size = this.mFinishedListeners.size();
        for (int i = 0; i < size; i++) {
            this.mFinishedListeners.get(i).onAnimationsFinished();
        }
        this.mFinishedListeners.clear();
    }

    public abstract void endAnimation(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder);

    public abstract void endAnimations();

    public long getAddDuration() {
        return this.mAddDuration;
    }

    public long getChangeDuration() {
        return this.mChangeDuration;
    }

    public long getMoveDuration() {
        return this.mMoveDuration;
    }

    public long getRemoveDuration() {
        return this.mRemoveDuration;
    }

    public abstract boolean isRunning();

    public final boolean isRunning(@Nullable RecyclerView$ItemAnimator$ItemAnimatorFinishedListener recyclerView$ItemAnimator$ItemAnimatorFinishedListener) {
        boolean zIsRunning = isRunning();
        if (recyclerView$ItemAnimator$ItemAnimatorFinishedListener != null) {
            if (zIsRunning) {
                this.mFinishedListeners.add(recyclerView$ItemAnimator$ItemAnimatorFinishedListener);
            } else {
                recyclerView$ItemAnimator$ItemAnimatorFinishedListener.onAnimationsFinished();
            }
        }
        return zIsRunning;
    }

    @NonNull
    public RecyclerView$ItemAnimator$ItemHolderInfo obtainHolderInfo() {
        return new RecyclerView$ItemAnimator$ItemHolderInfo();
    }

    public void onAnimationFinished(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder) {
    }

    public void onAnimationStarted(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder) {
    }

    @NonNull
    public RecyclerView$ItemAnimator$ItemHolderInfo recordPostLayoutInformation(@NonNull RecyclerView$State recyclerView$State, @NonNull RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return obtainHolderInfo().setFrom(recyclerView$ViewHolder);
    }

    @NonNull
    public RecyclerView$ItemAnimator$ItemHolderInfo recordPreLayoutInformation(@NonNull RecyclerView$State recyclerView$State, @NonNull RecyclerView$ViewHolder recyclerView$ViewHolder, int i, @NonNull List<Object> list) {
        return obtainHolderInfo().setFrom(recyclerView$ViewHolder);
    }

    public abstract void runPendingAnimations();

    public void setAddDuration(long j) {
        this.mAddDuration = j;
    }

    public void setChangeDuration(long j) {
        this.mChangeDuration = j;
    }

    public void setListener(RecyclerView$ItemAnimator$ItemAnimatorListener recyclerView$ItemAnimator$ItemAnimatorListener) {
        this.mListener = recyclerView$ItemAnimator$ItemAnimatorListener;
    }

    public void setMoveDuration(long j) {
        this.mMoveDuration = j;
    }

    public void setRemoveDuration(long j) {
        this.mRemoveDuration = j;
    }
}

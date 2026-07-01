package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DefaultItemAnimator extends SimpleItemAnimator {
    private static final boolean DEBUG = false;
    private static TimeInterpolator sDefaultInterpolator;
    private ArrayList<RecyclerView$ViewHolder> mPendingRemovals = new ArrayList<>();
    private ArrayList<RecyclerView$ViewHolder> mPendingAdditions = new ArrayList<>();
    private ArrayList<DefaultItemAnimator$MoveInfo> mPendingMoves = new ArrayList<>();
    private ArrayList<DefaultItemAnimator$ChangeInfo> mPendingChanges = new ArrayList<>();
    public ArrayList<ArrayList<RecyclerView$ViewHolder>> mAdditionsList = new ArrayList<>();
    public ArrayList<ArrayList<DefaultItemAnimator$MoveInfo>> mMovesList = new ArrayList<>();
    public ArrayList<ArrayList<DefaultItemAnimator$ChangeInfo>> mChangesList = new ArrayList<>();
    public ArrayList<RecyclerView$ViewHolder> mAddAnimations = new ArrayList<>();
    public ArrayList<RecyclerView$ViewHolder> mMoveAnimations = new ArrayList<>();
    public ArrayList<RecyclerView$ViewHolder> mRemoveAnimations = new ArrayList<>();
    public ArrayList<RecyclerView$ViewHolder> mChangeAnimations = new ArrayList<>();

    private void animateRemoveImpl(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        View view = recyclerView$ViewHolder.itemView;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.mRemoveAnimations.add(recyclerView$ViewHolder);
        viewPropertyAnimatorAnimate.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new DefaultItemAnimator$4(this, recyclerView$ViewHolder, viewPropertyAnimatorAnimate, view)).start();
    }

    private void endChangeAnimation(List<DefaultItemAnimator$ChangeInfo> list, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            DefaultItemAnimator$ChangeInfo defaultItemAnimator$ChangeInfo = list.get(size);
            if (endChangeAnimationIfNecessary(defaultItemAnimator$ChangeInfo, recyclerView$ViewHolder) && defaultItemAnimator$ChangeInfo.oldHolder == null && defaultItemAnimator$ChangeInfo.newHolder == null) {
                list.remove(defaultItemAnimator$ChangeInfo);
            }
        }
    }

    private void endChangeAnimationIfNecessary(DefaultItemAnimator$ChangeInfo defaultItemAnimator$ChangeInfo) {
        RecyclerView$ViewHolder recyclerView$ViewHolder = defaultItemAnimator$ChangeInfo.oldHolder;
        if (recyclerView$ViewHolder != null) {
            endChangeAnimationIfNecessary(defaultItemAnimator$ChangeInfo, recyclerView$ViewHolder);
        }
        RecyclerView$ViewHolder recyclerView$ViewHolder2 = defaultItemAnimator$ChangeInfo.newHolder;
        if (recyclerView$ViewHolder2 != null) {
            endChangeAnimationIfNecessary(defaultItemAnimator$ChangeInfo, recyclerView$ViewHolder2);
        }
    }

    private void resetAnimation(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        if (sDefaultInterpolator == null) {
            sDefaultInterpolator = new ValueAnimator().getInterpolator();
        }
        recyclerView$ViewHolder.itemView.animate().setInterpolator(sDefaultInterpolator);
        endAnimation(recyclerView$ViewHolder);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        resetAnimation(recyclerView$ViewHolder);
        recyclerView$ViewHolder.itemView.setAlpha(0.0f);
        this.mPendingAdditions.add(recyclerView$ViewHolder);
        return true;
    }

    public void animateAddImpl(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        View view = recyclerView$ViewHolder.itemView;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.mAddAnimations.add(recyclerView$ViewHolder);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(getAddDuration()).setListener(new DefaultItemAnimator$5(this, recyclerView$ViewHolder, view, viewPropertyAnimatorAnimate)).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ViewHolder recyclerView$ViewHolder2, int i, int i2, int i3, int i4) {
        if (recyclerView$ViewHolder == recyclerView$ViewHolder2) {
            return animateMove(recyclerView$ViewHolder, i, i2, i3, i4);
        }
        float translationX = recyclerView$ViewHolder.itemView.getTranslationX();
        float translationY = recyclerView$ViewHolder.itemView.getTranslationY();
        float alpha = recyclerView$ViewHolder.itemView.getAlpha();
        resetAnimation(recyclerView$ViewHolder);
        int i5 = (int) ((i3 - i) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        recyclerView$ViewHolder.itemView.setTranslationX(translationX);
        recyclerView$ViewHolder.itemView.setTranslationY(translationY);
        recyclerView$ViewHolder.itemView.setAlpha(alpha);
        if (recyclerView$ViewHolder2 != null) {
            resetAnimation(recyclerView$ViewHolder2);
            recyclerView$ViewHolder2.itemView.setTranslationX(-i5);
            recyclerView$ViewHolder2.itemView.setTranslationY(-i6);
            recyclerView$ViewHolder2.itemView.setAlpha(0.0f);
        }
        this.mPendingChanges.add(new DefaultItemAnimator$ChangeInfo(recyclerView$ViewHolder, recyclerView$ViewHolder2, i, i2, i3, i4));
        return true;
    }

    public void animateChangeImpl(DefaultItemAnimator$ChangeInfo defaultItemAnimator$ChangeInfo) {
        RecyclerView$ViewHolder recyclerView$ViewHolder = defaultItemAnimator$ChangeInfo.oldHolder;
        View view = recyclerView$ViewHolder == null ? null : recyclerView$ViewHolder.itemView;
        RecyclerView$ViewHolder recyclerView$ViewHolder2 = defaultItemAnimator$ChangeInfo.newHolder;
        View view2 = recyclerView$ViewHolder2 != null ? recyclerView$ViewHolder2.itemView : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            this.mChangeAnimations.add(defaultItemAnimator$ChangeInfo.oldHolder);
            duration.translationX(defaultItemAnimator$ChangeInfo.toX - defaultItemAnimator$ChangeInfo.fromX);
            duration.translationY(defaultItemAnimator$ChangeInfo.toY - defaultItemAnimator$ChangeInfo.fromY);
            duration.alpha(0.0f).setListener(new DefaultItemAnimator$7(this, defaultItemAnimator$ChangeInfo, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.mChangeAnimations.add(defaultItemAnimator$ChangeInfo.newHolder);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new DefaultItemAnimator$8(this, defaultItemAnimator$ChangeInfo, viewPropertyAnimatorAnimate, view2)).start();
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateMove(RecyclerView$ViewHolder recyclerView$ViewHolder, int i, int i2, int i3, int i4) {
        View view = recyclerView$ViewHolder.itemView;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) recyclerView$ViewHolder.itemView.getTranslationY());
        resetAnimation(recyclerView$ViewHolder);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            dispatchMoveFinished(recyclerView$ViewHolder);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.mPendingMoves.add(new DefaultItemAnimator$MoveInfo(recyclerView$ViewHolder, translationX, translationY, i3, i4));
        return true;
    }

    public void animateMoveImpl(RecyclerView$ViewHolder recyclerView$ViewHolder, int i, int i2, int i3, int i4) {
        View view = recyclerView$ViewHolder.itemView;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.mMoveAnimations.add(recyclerView$ViewHolder);
        viewPropertyAnimatorAnimate.setDuration(getMoveDuration()).setListener(new DefaultItemAnimator$6(this, recyclerView$ViewHolder, i5, view, i6, viewPropertyAnimatorAnimate)).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        resetAnimation(recyclerView$ViewHolder);
        this.mPendingRemovals.add(recyclerView$ViewHolder);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ItemAnimator
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder, @NonNull List<Object> list) {
        return !list.isEmpty() || super.canReuseUpdatedViewHolder(recyclerView$ViewHolder, list);
    }

    public void cancelAll(List<RecyclerView$ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    public void dispatchFinishedWhenDone() {
        if (isRunning()) {
            return;
        }
        dispatchAnimationsFinished();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ItemAnimator
    public void endAnimation(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        View view = recyclerView$ViewHolder.itemView;
        view.animate().cancel();
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.mPendingMoves.get(size).holder == recyclerView$ViewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(recyclerView$ViewHolder);
                this.mPendingMoves.remove(size);
            }
        }
        endChangeAnimation(this.mPendingChanges, recyclerView$ViewHolder);
        if (this.mPendingRemovals.remove(recyclerView$ViewHolder)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(recyclerView$ViewHolder);
        }
        if (this.mPendingAdditions.remove(recyclerView$ViewHolder)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(recyclerView$ViewHolder);
        }
        for (int size2 = this.mChangesList.size() - 1; size2 >= 0; size2--) {
            ArrayList<DefaultItemAnimator$ChangeInfo> arrayList = this.mChangesList.get(size2);
            endChangeAnimation(arrayList, recyclerView$ViewHolder);
            if (arrayList.isEmpty()) {
                this.mChangesList.remove(size2);
            }
        }
        for (int size3 = this.mMovesList.size() - 1; size3 >= 0; size3--) {
            ArrayList<DefaultItemAnimator$MoveInfo> arrayList2 = this.mMovesList.get(size3);
            for (int size4 = arrayList2.size() - 1; size4 >= 0; size4--) {
                if (arrayList2.get(size4).holder == recyclerView$ViewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(recyclerView$ViewHolder);
                    arrayList2.remove(size4);
                    if (!arrayList2.isEmpty()) {
                        break;
                    }
                    this.mMovesList.remove(size3);
                    break;
                }
            }
        }
        for (int size5 = this.mAdditionsList.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView$ViewHolder> arrayList3 = this.mAdditionsList.get(size5);
            if (arrayList3.remove(recyclerView$ViewHolder)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(recyclerView$ViewHolder);
                if (arrayList3.isEmpty()) {
                    this.mAdditionsList.remove(size5);
                }
            }
        }
        this.mRemoveAnimations.remove(recyclerView$ViewHolder);
        this.mAddAnimations.remove(recyclerView$ViewHolder);
        this.mChangeAnimations.remove(recyclerView$ViewHolder);
        this.mMoveAnimations.remove(recyclerView$ViewHolder);
        dispatchFinishedWhenDone();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ItemAnimator
    public void endAnimations() {
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            DefaultItemAnimator$MoveInfo defaultItemAnimator$MoveInfo = this.mPendingMoves.get(size);
            View view = defaultItemAnimator$MoveInfo.holder.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(defaultItemAnimator$MoveInfo.holder);
            this.mPendingMoves.remove(size);
        }
        for (int size2 = this.mPendingRemovals.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.mPendingRemovals.get(size2));
            this.mPendingRemovals.remove(size2);
        }
        int size3 = this.mPendingAdditions.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView$ViewHolder recyclerView$ViewHolder = this.mPendingAdditions.get(size3);
            recyclerView$ViewHolder.itemView.setAlpha(1.0f);
            dispatchAddFinished(recyclerView$ViewHolder);
            this.mPendingAdditions.remove(size3);
        }
        for (int size4 = this.mPendingChanges.size() - 1; size4 >= 0; size4--) {
            endChangeAnimationIfNecessary(this.mPendingChanges.get(size4));
        }
        this.mPendingChanges.clear();
        if (isRunning()) {
            for (int size5 = this.mMovesList.size() - 1; size5 >= 0; size5--) {
                ArrayList<DefaultItemAnimator$MoveInfo> arrayList = this.mMovesList.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    DefaultItemAnimator$MoveInfo defaultItemAnimator$MoveInfo2 = arrayList.get(size6);
                    View view2 = defaultItemAnimator$MoveInfo2.holder.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    dispatchMoveFinished(defaultItemAnimator$MoveInfo2.holder);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.mMovesList.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.mAdditionsList.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView$ViewHolder> arrayList2 = this.mAdditionsList.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView$ViewHolder recyclerView$ViewHolder2 = arrayList2.get(size8);
                    recyclerView$ViewHolder2.itemView.setAlpha(1.0f);
                    dispatchAddFinished(recyclerView$ViewHolder2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.mAdditionsList.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.mChangesList.size() - 1; size9 >= 0; size9--) {
                ArrayList<DefaultItemAnimator$ChangeInfo> arrayList3 = this.mChangesList.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    endChangeAnimationIfNecessary(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.mChangesList.remove(arrayList3);
                    }
                }
            }
            cancelAll(this.mRemoveAnimations);
            cancelAll(this.mMoveAnimations);
            cancelAll(this.mAddAnimations);
            cancelAll(this.mChangeAnimations);
            dispatchAnimationsFinished();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ItemAnimator
    public boolean isRunning() {
        return (this.mPendingAdditions.isEmpty() && this.mPendingChanges.isEmpty() && this.mPendingMoves.isEmpty() && this.mPendingRemovals.isEmpty() && this.mMoveAnimations.isEmpty() && this.mRemoveAnimations.isEmpty() && this.mAddAnimations.isEmpty() && this.mChangeAnimations.isEmpty() && this.mMovesList.isEmpty() && this.mAdditionsList.isEmpty() && this.mChangesList.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ItemAnimator
    public void runPendingAnimations() {
        boolean z2 = !this.mPendingRemovals.isEmpty();
        boolean z3 = !this.mPendingMoves.isEmpty();
        boolean z4 = !this.mPendingChanges.isEmpty();
        boolean z5 = !this.mPendingAdditions.isEmpty();
        if (z2 || z3 || z5 || z4) {
            Iterator<RecyclerView$ViewHolder> it = this.mPendingRemovals.iterator();
            while (it.hasNext()) {
                animateRemoveImpl(it.next());
            }
            this.mPendingRemovals.clear();
            if (z3) {
                ArrayList<DefaultItemAnimator$MoveInfo> arrayList = new ArrayList<>();
                arrayList.addAll(this.mPendingMoves);
                this.mMovesList.add(arrayList);
                this.mPendingMoves.clear();
                DefaultItemAnimator$1 defaultItemAnimator$1 = new DefaultItemAnimator$1(this, arrayList);
                if (z2) {
                    ViewCompat.postOnAnimationDelayed(arrayList.get(0).holder.itemView, defaultItemAnimator$1, getRemoveDuration());
                } else {
                    defaultItemAnimator$1.run();
                }
            }
            if (z4) {
                ArrayList<DefaultItemAnimator$ChangeInfo> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.mPendingChanges);
                this.mChangesList.add(arrayList2);
                this.mPendingChanges.clear();
                DefaultItemAnimator$2 defaultItemAnimator$2 = new DefaultItemAnimator$2(this, arrayList2);
                if (z2) {
                    ViewCompat.postOnAnimationDelayed(arrayList2.get(0).oldHolder.itemView, defaultItemAnimator$2, getRemoveDuration());
                } else {
                    defaultItemAnimator$2.run();
                }
            }
            if (z5) {
                ArrayList<RecyclerView$ViewHolder> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.mPendingAdditions);
                this.mAdditionsList.add(arrayList3);
                this.mPendingAdditions.clear();
                DefaultItemAnimator$3 defaultItemAnimator$3 = new DefaultItemAnimator$3(this, arrayList3);
                if (z2 || z3 || z4) {
                    ViewCompat.postOnAnimationDelayed(arrayList3.get(0).itemView, defaultItemAnimator$3, Math.max(z3 ? getMoveDuration() : 0L, z4 ? getChangeDuration() : 0L) + (z2 ? getRemoveDuration() : 0L));
                } else {
                    defaultItemAnimator$3.run();
                }
            }
        }
    }

    private boolean endChangeAnimationIfNecessary(DefaultItemAnimator$ChangeInfo defaultItemAnimator$ChangeInfo, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        boolean z2 = false;
        if (defaultItemAnimator$ChangeInfo.newHolder == recyclerView$ViewHolder) {
            defaultItemAnimator$ChangeInfo.newHolder = null;
        } else {
            if (defaultItemAnimator$ChangeInfo.oldHolder != recyclerView$ViewHolder) {
                return false;
            }
            defaultItemAnimator$ChangeInfo.oldHolder = null;
            z2 = true;
        }
        recyclerView$ViewHolder.itemView.setAlpha(1.0f);
        recyclerView$ViewHolder.itemView.setTranslationX(0.0f);
        recyclerView$ViewHolder.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(recyclerView$ViewHolder, z2);
        return true;
    }
}

package androidx.appcompat.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public class SearchView$UpdatableTouchDelegate extends TouchDelegate {
    private final Rect mActualBounds;
    private boolean mDelegateTargeted;
    private final View mDelegateView;
    private final int mSlop;
    private final Rect mSlopBounds;
    private final Rect mTargetBounds;

    public SearchView$UpdatableTouchDelegate(Rect rect, Rect rect2, View view) {
        super(rect, view);
        this.mSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.mTargetBounds = new Rect();
        this.mSlopBounds = new Rect();
        this.mActualBounds = new Rect();
        setBounds(rect, rect2);
        this.mDelegateView = view;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        boolean z3;
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z4 = true;
        if (action != 0) {
            if (action == 1 || action == 2) {
                z3 = this.mDelegateTargeted;
                if (z3 && !this.mSlopBounds.contains(x2, y2)) {
                    z4 = z3;
                    z2 = false;
                }
            } else if (action != 3) {
                z2 = true;
                z4 = false;
            } else {
                z3 = this.mDelegateTargeted;
                this.mDelegateTargeted = false;
            }
            z4 = z3;
            z2 = true;
        } else if (this.mTargetBounds.contains(x2, y2)) {
            this.mDelegateTargeted = true;
            z2 = true;
        } else {
            z2 = true;
            z4 = false;
        }
        if (!z4) {
            return false;
        }
        if (!z2 || this.mActualBounds.contains(x2, y2)) {
            Rect rect = this.mActualBounds;
            motionEvent.setLocation(x2 - rect.left, y2 - rect.top);
        } else {
            motionEvent.setLocation(this.mDelegateView.getWidth() / 2, this.mDelegateView.getHeight() / 2);
        }
        return this.mDelegateView.dispatchTouchEvent(motionEvent);
    }

    public void setBounds(Rect rect, Rect rect2) {
        this.mTargetBounds.set(rect);
        this.mSlopBounds.set(rect);
        Rect rect3 = this.mSlopBounds;
        int i = this.mSlop;
        rect3.inset(-i, -i);
        this.mActualBounds.set(rect2);
    }
}

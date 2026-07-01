package androidx.core.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View$OnLongClickListener;
import android.view.View$OnTouchListener;

/* JADX INFO: loaded from: classes.dex */
public class DragStartHelper {
    private boolean mDragging;
    private int mLastTouchX;
    private int mLastTouchY;
    private final DragStartHelper$OnDragStartListener mListener;
    private final View$OnLongClickListener mLongClickListener = new DragStartHelper$1(this);
    private final View$OnTouchListener mTouchListener = new DragStartHelper$2(this);
    private final View mView;

    public DragStartHelper(View view, DragStartHelper$OnDragStartListener dragStartHelper$OnDragStartListener) {
        this.mView = view;
        this.mListener = dragStartHelper$OnDragStartListener;
    }

    public void attach() {
        this.mView.setOnLongClickListener(this.mLongClickListener);
        this.mView.setOnTouchListener(this.mTouchListener);
    }

    public void detach() {
        this.mView.setOnLongClickListener(null);
        this.mView.setOnTouchListener(null);
    }

    public void getTouchPosition(Point point) {
        point.set(this.mLastTouchX, this.mLastTouchY);
    }

    public boolean onLongClick(View view) {
        return this.mListener.onDragStart(view, this);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0046  */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastTouchX = x2;
            this.mLastTouchY = y2;
        } else if (action == 1) {
            this.mDragging = false;
        } else if (action != 2) {
            if (action == 3) {
                this.mDragging = false;
            }
        } else if (MotionEventCompat.isFromSource(motionEvent, 8194) && (motionEvent.getButtonState() & 1) != 0 && !this.mDragging && (this.mLastTouchX != x2 || this.mLastTouchY != y2)) {
            this.mLastTouchX = x2;
            this.mLastTouchY = y2;
            boolean zOnDragStart = this.mListener.onDragStart(view, this);
            this.mDragging = zOnDragStart;
            return zOnDragStart;
        }
        return false;
    }
}

package androidx.core.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View$OnTouchListener;

/* JADX INFO: loaded from: classes.dex */
public class DragStartHelper$2 implements View$OnTouchListener {
    public final /* synthetic */ DragStartHelper this$0;

    public DragStartHelper$2(DragStartHelper dragStartHelper) {
        this.this$0 = dragStartHelper;
    }

    @Override // android.view.View$OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.this$0.onTouch(view, motionEvent);
    }
}

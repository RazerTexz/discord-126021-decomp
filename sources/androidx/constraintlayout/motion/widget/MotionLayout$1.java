package androidx.constraintlayout.motion.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class MotionLayout$1 implements Runnable {
    public final /* synthetic */ MotionLayout this$0;
    public final /* synthetic */ View val$target;

    public MotionLayout$1(MotionLayout motionLayout, View view) {
        this.this$0 = motionLayout;
        this.val$target = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$target.setNestedScrollingEnabled(true);
    }
}

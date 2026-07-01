package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class ChangeClipBounds$1 extends AnimatorListenerAdapter {
    public final /* synthetic */ ChangeClipBounds this$0;
    public final /* synthetic */ View val$endView;

    public ChangeClipBounds$1(ChangeClipBounds changeClipBounds, View view) {
        this.this$0 = changeClipBounds;
        this.val$endView = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ViewCompat.setClipBounds(this.val$endView, null);
    }
}

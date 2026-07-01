package androidx.fragment.app;

import android.view.View;
import android.view.View$OnAttachStateChangeListener;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class FragmentStateManager$1 implements View$OnAttachStateChangeListener {
    public final /* synthetic */ FragmentStateManager this$0;
    public final /* synthetic */ View val$fragmentView;

    public FragmentStateManager$1(FragmentStateManager fragmentStateManager, View view) {
        this.this$0 = fragmentStateManager;
        this.val$fragmentView = view;
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.val$fragmentView.removeOnAttachStateChangeListener(this);
        ViewCompat.requestApplyInsets(this.val$fragmentView);
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }
}

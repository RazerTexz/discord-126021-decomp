package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.ShowableListMenu;

/* JADX INFO: loaded from: classes.dex */
public class ActivityChooserView$4 extends ForwardingListener {
    public final /* synthetic */ ActivityChooserView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityChooserView$4(ActivityChooserView activityChooserView, View view) {
        super(view);
        this.this$0 = activityChooserView;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public ShowableListMenu getPopup() {
        return this.this$0.getListPopupWindow();
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public boolean onForwardingStarted() {
        this.this$0.showPopup();
        return true;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public boolean onForwardingStopped() {
        this.this$0.dismissPopup();
        return true;
    }
}

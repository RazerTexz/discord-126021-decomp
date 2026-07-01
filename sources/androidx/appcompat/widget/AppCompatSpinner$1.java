package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.appcompat.view.menu.ShowableListMenu;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatSpinner$1 extends ForwardingListener {
    public final /* synthetic */ AppCompatSpinner this$0;
    public final /* synthetic */ AppCompatSpinner$DropdownPopup val$popup;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatSpinner$1(AppCompatSpinner appCompatSpinner, View view, AppCompatSpinner$DropdownPopup appCompatSpinner$DropdownPopup) {
        super(view);
        this.this$0 = appCompatSpinner;
        this.val$popup = appCompatSpinner$DropdownPopup;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public ShowableListMenu getPopup() {
        return this.val$popup;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    @SuppressLint({"SyntheticAccessor"})
    public boolean onForwardingStarted() {
        if (this.this$0.getInternalPopup().isShowing()) {
            return true;
        }
        this.this$0.showPopup();
        return true;
    }
}

package androidx.appcompat.widget;

import android.view.MenuItem;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar$1 implements ActionMenuView$OnMenuItemClickListener {
    public final /* synthetic */ Toolbar this$0;

    public Toolbar$1(Toolbar toolbar) {
        this.this$0 = toolbar;
    }

    @Override // androidx.appcompat.widget.ActionMenuView$OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        Toolbar$OnMenuItemClickListener toolbar$OnMenuItemClickListener = this.this$0.mOnMenuItemClickListener;
        if (toolbar$OnMenuItemClickListener != null) {
            return toolbar$OnMenuItemClickListener.onMenuItemClick(menuItem);
        }
        return false;
    }
}

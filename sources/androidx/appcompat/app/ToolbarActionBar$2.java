package androidx.appcompat.app;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar$OnMenuItemClickListener;

/* JADX INFO: loaded from: classes.dex */
public class ToolbarActionBar$2 implements Toolbar$OnMenuItemClickListener {
    public final /* synthetic */ ToolbarActionBar this$0;

    public ToolbarActionBar$2(ToolbarActionBar toolbarActionBar) {
        this.this$0 = toolbarActionBar;
    }

    @Override // androidx.appcompat.widget.Toolbar$OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        return this.this$0.mWindowCallback.onMenuItemSelected(0, menuItem);
    }
}

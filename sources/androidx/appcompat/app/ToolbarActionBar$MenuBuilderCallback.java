package androidx.appcompat.app;

import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder$Callback;

/* JADX INFO: loaded from: classes.dex */
public final class ToolbarActionBar$MenuBuilderCallback implements MenuBuilder$Callback {
    public final /* synthetic */ ToolbarActionBar this$0;

    public ToolbarActionBar$MenuBuilderCallback(ToolbarActionBar toolbarActionBar) {
        this.this$0 = toolbarActionBar;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder$Callback
    public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder$Callback
    public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
        ToolbarActionBar toolbarActionBar = this.this$0;
        if (toolbarActionBar.mWindowCallback != null) {
            if (toolbarActionBar.mDecorToolbar.isOverflowMenuShowing()) {
                this.this$0.mWindowCallback.onPanelClosed(108, menuBuilder);
            } else if (this.this$0.mWindowCallback.onPreparePanel(0, null, menuBuilder)) {
                this.this$0.mWindowCallback.onMenuOpened(108, menuBuilder);
            }
        }
    }
}

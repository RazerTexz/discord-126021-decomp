package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder$Callback;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView$MenuBuilderCallback implements MenuBuilder$Callback {
    public final /* synthetic */ ActionMenuView this$0;

    public ActionMenuView$MenuBuilderCallback(ActionMenuView actionMenuView) {
        this.this$0 = actionMenuView;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder$Callback
    public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        ActionMenuView$OnMenuItemClickListener actionMenuView$OnMenuItemClickListener = this.this$0.mOnMenuItemClickListener;
        return actionMenuView$OnMenuItemClickListener != null && actionMenuView$OnMenuItemClickListener.onMenuItemClick(menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder$Callback
    public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
        MenuBuilder$Callback menuBuilder$Callback = this.this$0.mMenuBuilderCallback;
        if (menuBuilder$Callback != null) {
            menuBuilder$Callback.onMenuModeChange(menuBuilder);
        }
    }
}

package androidx.appcompat.widget;

import android.R$id;
import android.view.View;
import android.view.View$OnClickListener;
import android.view.Window$Callback;
import androidx.appcompat.view.menu.ActionMenuItem;

/* JADX INFO: loaded from: classes.dex */
public class ToolbarWidgetWrapper$1 implements View$OnClickListener {
    public final ActionMenuItem mNavItem;
    public final /* synthetic */ ToolbarWidgetWrapper this$0;

    public ToolbarWidgetWrapper$1(ToolbarWidgetWrapper toolbarWidgetWrapper) {
        this.this$0 = toolbarWidgetWrapper;
        this.mNavItem = new ActionMenuItem(toolbarWidgetWrapper.mToolbar.getContext(), 0, R$id.home, 0, 0, toolbarWidgetWrapper.mTitle);
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.this$0;
        Window$Callback window$Callback = toolbarWidgetWrapper.mWindowCallback;
        if (window$Callback == null || !toolbarWidgetWrapper.mMenuPrepared) {
            return;
        }
        window$Callback.onMenuItemSelected(0, this.mNavItem);
    }
}

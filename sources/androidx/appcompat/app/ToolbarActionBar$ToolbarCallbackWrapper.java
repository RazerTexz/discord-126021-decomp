package androidx.appcompat.app;

import android.view.Menu;
import android.view.View;
import android.view.Window$Callback;
import androidx.appcompat.view.WindowCallbackWrapper;

/* JADX INFO: loaded from: classes.dex */
public class ToolbarActionBar$ToolbarCallbackWrapper extends WindowCallbackWrapper {
    public final /* synthetic */ ToolbarActionBar this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolbarActionBar$ToolbarCallbackWrapper(ToolbarActionBar toolbarActionBar, Window$Callback window$Callback) {
        super(window$Callback);
        this.this$0 = toolbarActionBar;
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window$Callback
    public View onCreatePanelView(int i) {
        return i == 0 ? new View(this.this$0.mDecorToolbar.getContext()) : super.onCreatePanelView(i);
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window$Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        boolean zOnPreparePanel = super.onPreparePanel(i, view, menu);
        if (zOnPreparePanel) {
            ToolbarActionBar toolbarActionBar = this.this$0;
            if (!toolbarActionBar.mToolbarMenuPrepared) {
                toolbarActionBar.mDecorToolbar.setMenuPrepared();
                this.this$0.mToolbarMenuPrepared = true;
            }
        }
        return zOnPreparePanel;
    }
}

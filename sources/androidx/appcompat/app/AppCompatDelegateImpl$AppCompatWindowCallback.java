package androidx.appcompat.app;

import android.os.Build$VERSION;
import android.view.ActionMode;
import android.view.ActionMode$Callback;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.view.Window$Callback;
import androidx.annotation.RequiresApi;
import androidx.appcompat.view.SupportActionModeWrapper$CallbackWrapper;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.MenuBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDelegateImpl$AppCompatWindowCallback extends WindowCallbackWrapper {
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatDelegateImpl$AppCompatWindowCallback(AppCompatDelegateImpl appCompatDelegateImpl, Window$Callback window$Callback) {
        super(window$Callback);
        this.this$0 = appCompatDelegateImpl;
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window$Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.this$0.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window$Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent) || this.this$0.onKeyShortcut(keyEvent.getKeyCode(), keyEvent);
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window$Callback
    public void onContentChanged() {
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window$Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0 || (menu instanceof MenuBuilder)) {
            return super.onCreatePanelMenu(i, menu);
        }
        return false;
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window$Callback
    public boolean onMenuOpened(int i, Menu menu) {
        super.onMenuOpened(i, menu);
        this.this$0.onMenuOpened(i);
        return true;
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window$Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
        this.this$0.onPanelClosed(i);
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window$Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
        if (i == 0 && menuBuilder == null) {
            return false;
        }
        if (menuBuilder != null) {
            menuBuilder.setOverrideVisibleItems(true);
        }
        boolean zOnPreparePanel = super.onPreparePanel(i, view, menu);
        if (menuBuilder != null) {
            menuBuilder.setOverrideVisibleItems(false);
        }
        return zOnPreparePanel;
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window$Callback
    @RequiresApi(24)
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
        MenuBuilder menuBuilder;
        AppCompatDelegateImpl$PanelFeatureState panelState = this.this$0.getPanelState(0, true);
        if (panelState == null || (menuBuilder = panelState.menu) == null) {
            super.onProvideKeyboardShortcuts(list, menu, i);
        } else {
            super.onProvideKeyboardShortcuts(list, menuBuilder, i);
        }
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window$Callback
    public ActionMode onWindowStartingActionMode(ActionMode$Callback actionMode$Callback) {
        if (Build$VERSION.SDK_INT >= 23) {
            return null;
        }
        return this.this$0.isHandleNativeActionModesEnabled() ? startAsSupportActionMode(actionMode$Callback) : super.onWindowStartingActionMode(actionMode$Callback);
    }

    public final ActionMode startAsSupportActionMode(ActionMode$Callback actionMode$Callback) {
        SupportActionModeWrapper$CallbackWrapper supportActionModeWrapper$CallbackWrapper = new SupportActionModeWrapper$CallbackWrapper(this.this$0.mContext, actionMode$Callback);
        androidx.appcompat.view.ActionMode actionModeStartSupportActionMode = this.this$0.startSupportActionMode(supportActionModeWrapper$CallbackWrapper);
        if (actionModeStartSupportActionMode != null) {
            return supportActionModeWrapper$CallbackWrapper.getActionModeWrapper(actionModeStartSupportActionMode);
        }
        return null;
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window$Callback
    @RequiresApi(23)
    public ActionMode onWindowStartingActionMode(ActionMode$Callback actionMode$Callback, int i) {
        if (this.this$0.isHandleNativeActionModesEnabled() && i == 0) {
            return startAsSupportActionMode(actionMode$Callback);
        }
        return super.onWindowStartingActionMode(actionMode$Callback, i);
    }
}

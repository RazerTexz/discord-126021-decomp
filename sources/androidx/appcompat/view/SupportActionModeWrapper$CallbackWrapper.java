package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
public class SupportActionModeWrapper$CallbackWrapper implements ActionMode$Callback {
    public final Context mContext;
    public final android.view.ActionMode$Callback mWrappedCallback;
    public final ArrayList<SupportActionModeWrapper> mActionModes = new ArrayList<>();
    public final SimpleArrayMap<Menu, Menu> mMenus = new SimpleArrayMap<>();

    public SupportActionModeWrapper$CallbackWrapper(Context context, android.view.ActionMode$Callback actionMode$Callback) {
        this.mContext = context;
        this.mWrappedCallback = actionMode$Callback;
    }

    private Menu getMenuWrapper(Menu menu) {
        Menu menu2 = this.mMenus.get(menu);
        if (menu2 != null) {
            return menu2;
        }
        MenuWrapperICS menuWrapperICS = new MenuWrapperICS(this.mContext, (SupportMenu) menu);
        this.mMenus.put(menu, menuWrapperICS);
        return menuWrapperICS;
    }

    public android.view.ActionMode getActionModeWrapper(ActionMode actionMode) {
        int size = this.mActionModes.size();
        for (int i = 0; i < size; i++) {
            SupportActionModeWrapper supportActionModeWrapper = this.mActionModes.get(i);
            if (supportActionModeWrapper != null && supportActionModeWrapper.mWrappedObject == actionMode) {
                return supportActionModeWrapper;
            }
        }
        SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.mContext, actionMode);
        this.mActionModes.add(supportActionModeWrapper2);
        return supportActionModeWrapper2;
    }

    @Override // androidx.appcompat.view.ActionMode$Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.mWrappedCallback.onActionItemClicked(getActionModeWrapper(actionMode), new MenuItemWrapperICS(this.mContext, (SupportMenuItem) menuItem));
    }

    @Override // androidx.appcompat.view.ActionMode$Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.mWrappedCallback.onCreateActionMode(getActionModeWrapper(actionMode), getMenuWrapper(menu));
    }

    @Override // androidx.appcompat.view.ActionMode$Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.mWrappedCallback.onDestroyActionMode(getActionModeWrapper(actionMode));
    }

    @Override // androidx.appcompat.view.ActionMode$Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.mWrappedCallback.onPrepareActionMode(getActionModeWrapper(actionMode), getMenuWrapper(menu));
    }
}

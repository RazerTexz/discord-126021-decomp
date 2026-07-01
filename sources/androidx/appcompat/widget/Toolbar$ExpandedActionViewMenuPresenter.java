package androidx.appcompat.widget;

import android.content.Context;
import android.os.Parcelable;
import android.view.KeyEvent$Callback;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar$ExpandedActionViewMenuPresenter implements MenuPresenter {
    public MenuItemImpl mCurrentExpandedItem;
    public MenuBuilder mMenu;
    public final /* synthetic */ Toolbar this$0;

    public Toolbar$ExpandedActionViewMenuPresenter(Toolbar toolbar) {
        this.this$0 = toolbar;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        KeyEvent$Callback keyEvent$Callback = this.this$0.mExpandedActionView;
        if (keyEvent$Callback instanceof CollapsibleActionView) {
            ((CollapsibleActionView) keyEvent$Callback).onActionViewCollapsed();
        }
        Toolbar toolbar = this.this$0;
        toolbar.removeView(toolbar.mExpandedActionView);
        Toolbar toolbar2 = this.this$0;
        toolbar2.removeView(toolbar2.mCollapseButtonView);
        Toolbar toolbar3 = this.this$0;
        toolbar3.mExpandedActionView = null;
        toolbar3.addChildrenForExpandedActionView();
        this.mCurrentExpandedItem = null;
        this.this$0.requestLayout();
        menuItemImpl.setActionViewExpanded(false);
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        this.this$0.ensureCollapseButtonView();
        ViewParent parent = this.this$0.mCollapseButtonView.getParent();
        Toolbar toolbar = this.this$0;
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.mCollapseButtonView);
            }
            Toolbar toolbar2 = this.this$0;
            toolbar2.addView(toolbar2.mCollapseButtonView);
        }
        this.this$0.mExpandedActionView = menuItemImpl.getActionView();
        this.mCurrentExpandedItem = menuItemImpl;
        ViewParent parent2 = this.this$0.mExpandedActionView.getParent();
        Toolbar toolbar3 = this.this$0;
        if (parent2 != toolbar3) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar3.mExpandedActionView);
            }
            Toolbar$LayoutParams toolbar$LayoutParamsGenerateDefaultLayoutParams = this.this$0.generateDefaultLayoutParams();
            Toolbar toolbar4 = this.this$0;
            toolbar$LayoutParamsGenerateDefaultLayoutParams.gravity = 8388611 | (toolbar4.mButtonGravity & 112);
            toolbar$LayoutParamsGenerateDefaultLayoutParams.mViewType = 2;
            toolbar4.mExpandedActionView.setLayoutParams(toolbar$LayoutParamsGenerateDefaultLayoutParams);
            Toolbar toolbar5 = this.this$0;
            toolbar5.addView(toolbar5.mExpandedActionView);
        }
        this.this$0.removeChildrenForExpandedActionView();
        this.this$0.requestLayout();
        menuItemImpl.setActionViewExpanded(true);
        KeyEvent$Callback keyEvent$Callback = this.this$0.mExpandedActionView;
        if (keyEvent$Callback instanceof CollapsibleActionView) {
            ((CollapsibleActionView) keyEvent$Callback).onActionViewExpanded();
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        return null;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        MenuItemImpl menuItemImpl;
        MenuBuilder menuBuilder2 = this.mMenu;
        if (menuBuilder2 != null && (menuItemImpl = this.mCurrentExpandedItem) != null) {
            menuBuilder2.collapseItemActionView(menuItemImpl);
        }
        this.mMenu = menuBuilder;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z2) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter$Callback menuPresenter$Callback) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z2) {
        if (this.mCurrentExpandedItem != null) {
            MenuBuilder menuBuilder = this.mMenu;
            boolean z3 = false;
            if (menuBuilder != null) {
                int size = menuBuilder.size();
                for (int i = 0; i < size; i++) {
                    if (this.mMenu.getItem(i) == this.mCurrentExpandedItem) {
                        z3 = true;
                        break;
                    }
                }
            }
            if (z3) {
                return;
            }
            collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
        }
    }
}

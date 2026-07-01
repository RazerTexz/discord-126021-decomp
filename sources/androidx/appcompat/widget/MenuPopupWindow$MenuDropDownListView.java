package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
public class MenuPopupWindow$MenuDropDownListView extends DropDownListView {
    public final int mAdvanceKey;
    private MenuItemHoverListener mHoverListener;
    private MenuItem mHoveredMenuItem;
    public final int mRetreatKey;

    public MenuPopupWindow$MenuDropDownListView(Context context, boolean z2) {
        super(context, z2);
        if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
            this.mAdvanceKey = 21;
            this.mRetreatKey = 22;
        } else {
            this.mAdvanceKey = 22;
            this.mRetreatKey = 21;
        }
    }

    public void clearSelection() {
        setSelection(-1);
    }

    @Override // androidx.appcompat.widget.DropDownListView, android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ boolean hasFocus() {
        return super.hasFocus();
    }

    @Override // androidx.appcompat.widget.DropDownListView, android.view.View
    public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
        return super.hasWindowFocus();
    }

    @Override // androidx.appcompat.widget.DropDownListView, android.view.View
    public /* bridge */ /* synthetic */ boolean isFocused() {
        return super.isFocused();
    }

    @Override // androidx.appcompat.widget.DropDownListView, android.view.View
    public /* bridge */ /* synthetic */ boolean isInTouchMode() {
        return super.isInTouchMode();
    }

    @Override // androidx.appcompat.widget.DropDownListView
    public /* bridge */ /* synthetic */ int lookForSelectablePosition(int i, boolean z2) {
        return super.lookForSelectablePosition(i, z2);
    }

    @Override // androidx.appcompat.widget.DropDownListView
    public /* bridge */ /* synthetic */ int measureHeightOfChildrenCompat(int i, int i2, int i3, int i4, int i5) {
        return super.measureHeightOfChildrenCompat(i, i2, i3, i4, i5);
    }

    @Override // androidx.appcompat.widget.DropDownListView
    public /* bridge */ /* synthetic */ boolean onForwardedEvent(MotionEvent motionEvent, int i) {
        return super.onForwardedEvent(motionEvent, i);
    }

    @Override // androidx.appcompat.widget.DropDownListView, android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int headersCount;
        MenuAdapter menuAdapter;
        int iPointToPosition;
        int i;
        if (this.mHoverListener != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                headersCount = headerViewListAdapter.getHeadersCount();
                menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
            } else {
                headersCount = 0;
                menuAdapter = (MenuAdapter) adapter;
            }
            MenuItemImpl item = null;
            if (motionEvent.getAction() != 10 && (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i = iPointToPosition - headersCount) >= 0 && i < menuAdapter.getCount()) {
                item = menuAdapter.getItem(i);
            }
            MenuItem menuItem = this.mHoveredMenuItem;
            if (menuItem != item) {
                MenuBuilder adapterMenu = menuAdapter.getAdapterMenu();
                if (menuItem != null) {
                    this.mHoverListener.onItemHoverExit(adapterMenu, menuItem);
                }
                this.mHoveredMenuItem = item;
                if (item != null) {
                    this.mHoverListener.onItemHoverEnter(adapterMenu, item);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent$Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i == this.mAdvanceKey) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView == null || i != this.mRetreatKey) {
            return super.onKeyDown(i, keyEvent);
        }
        setSelection(-1);
        ((MenuAdapter) getAdapter()).getAdapterMenu().close(false);
        return true;
    }

    @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
        this.mHoverListener = menuItemHoverListener;
    }

    @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}

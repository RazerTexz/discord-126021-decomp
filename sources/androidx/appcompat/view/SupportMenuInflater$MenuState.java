package androidx.appcompat.view;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff$Mode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes.dex */
public class SupportMenuInflater$MenuState {
    private static final int defaultGroupId = 0;
    private static final int defaultItemCategory = 0;
    private static final int defaultItemCheckable = 0;
    private static final boolean defaultItemChecked = false;
    private static final boolean defaultItemEnabled = true;
    private static final int defaultItemId = 0;
    private static final int defaultItemOrder = 0;
    private static final boolean defaultItemVisible = true;
    private int groupCategory;
    private int groupCheckable;
    private boolean groupEnabled;
    private int groupId;
    private int groupOrder;
    private boolean groupVisible;
    public ActionProvider itemActionProvider;
    private String itemActionProviderClassName;
    private String itemActionViewClassName;
    private int itemActionViewLayout;
    private boolean itemAdded;
    private int itemAlphabeticModifiers;
    private char itemAlphabeticShortcut;
    private int itemCategoryOrder;
    private int itemCheckable;
    private boolean itemChecked;
    private CharSequence itemContentDescription;
    private boolean itemEnabled;
    private int itemIconResId;
    private ColorStateList itemIconTintList = null;
    private PorterDuff$Mode itemIconTintMode = null;
    private int itemId;
    private String itemListenerMethodName;
    private int itemNumericModifiers;
    private char itemNumericShortcut;
    private int itemShowAsAction;
    private CharSequence itemTitle;
    private CharSequence itemTitleCondensed;
    private CharSequence itemTooltipText;
    private boolean itemVisible;
    private Menu menu;
    public final /* synthetic */ SupportMenuInflater this$0;

    public SupportMenuInflater$MenuState(SupportMenuInflater supportMenuInflater, Menu menu) {
        this.this$0 = supportMenuInflater;
        this.menu = menu;
        resetGroup();
    }

    private char getShortcut(String str) {
        if (str == null) {
            return (char) 0;
        }
        return str.charAt(0);
    }

    private <T> T newInstance(String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.this$0.mContext.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return (T) constructor.newInstance(objArr);
        } catch (Exception e) {
            Log.w(SupportMenuInflater.LOG_TAG, "Cannot instantiate class: " + str, e);
            return null;
        }
    }

    private void setItem(MenuItem menuItem) {
        boolean z2 = false;
        menuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled).setCheckable(this.itemCheckable >= 1).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
        int i = this.itemShowAsAction;
        if (i >= 0) {
            menuItem.setShowAsAction(i);
        }
        if (this.itemListenerMethodName != null) {
            if (this.this$0.mContext.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            menuItem.setOnMenuItemClickListener(new SupportMenuInflater$InflatedOnMenuItemClickListener(this.this$0.getRealOwner(), this.itemListenerMethodName));
        }
        if (this.itemCheckable >= 2) {
            if (menuItem instanceof MenuItemImpl) {
                ((MenuItemImpl) menuItem).setExclusiveCheckable(true);
            } else if (menuItem instanceof MenuItemWrapperICS) {
                ((MenuItemWrapperICS) menuItem).setExclusiveCheckable(true);
            }
        }
        String str = this.itemActionViewClassName;
        if (str != null) {
            menuItem.setActionView((View) newInstance(str, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, this.this$0.mActionViewConstructorArguments));
            z2 = true;
        }
        int i2 = this.itemActionViewLayout;
        if (i2 > 0) {
            if (z2) {
                Log.w(SupportMenuInflater.LOG_TAG, "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i2);
            }
        }
        ActionProvider actionProvider = this.itemActionProvider;
        if (actionProvider != null) {
            MenuItemCompat.setActionProvider(menuItem, actionProvider);
        }
        MenuItemCompat.setContentDescription(menuItem, this.itemContentDescription);
        MenuItemCompat.setTooltipText(menuItem, this.itemTooltipText);
        MenuItemCompat.setAlphabeticShortcut(menuItem, this.itemAlphabeticShortcut, this.itemAlphabeticModifiers);
        MenuItemCompat.setNumericShortcut(menuItem, this.itemNumericShortcut, this.itemNumericModifiers);
        PorterDuff$Mode porterDuff$Mode = this.itemIconTintMode;
        if (porterDuff$Mode != null) {
            MenuItemCompat.setIconTintMode(menuItem, porterDuff$Mode);
        }
        ColorStateList colorStateList = this.itemIconTintList;
        if (colorStateList != null) {
            MenuItemCompat.setIconTintList(menuItem, colorStateList);
        }
    }

    public void addItem() {
        this.itemAdded = true;
        setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
    }

    public SubMenu addSubMenuItem() {
        this.itemAdded = true;
        SubMenu subMenuAddSubMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
        setItem(subMenuAddSubMenu.getItem());
        return subMenuAddSubMenu;
    }

    public boolean hasAddedItem() {
        return this.itemAdded;
    }

    public void readGroup(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = this.this$0.mContext.obtainStyledAttributes(attributeSet, R$styleable.MenuGroup);
        this.groupId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MenuGroup_android_id, 0);
        this.groupCategory = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
        this.groupOrder = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
        this.groupCheckable = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
        this.groupVisible = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_visible, true);
        this.groupEnabled = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_enabled, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void readItem(AttributeSet attributeSet) {
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.this$0.mContext, attributeSet, R$styleable.MenuItem);
        this.itemId = tintTypedArrayObtainStyledAttributes.getResourceId(R$styleable.MenuItem_android_id, 0);
        this.itemCategoryOrder = (tintTypedArrayObtainStyledAttributes.getInt(R$styleable.MenuItem_android_menuCategory, this.groupCategory) & (-65536)) | (tintTypedArrayObtainStyledAttributes.getInt(R$styleable.MenuItem_android_orderInCategory, this.groupOrder) & 65535);
        this.itemTitle = tintTypedArrayObtainStyledAttributes.getText(R$styleable.MenuItem_android_title);
        this.itemTitleCondensed = tintTypedArrayObtainStyledAttributes.getText(R$styleable.MenuItem_android_titleCondensed);
        this.itemIconResId = tintTypedArrayObtainStyledAttributes.getResourceId(R$styleable.MenuItem_android_icon, 0);
        this.itemAlphabeticShortcut = getShortcut(tintTypedArrayObtainStyledAttributes.getString(R$styleable.MenuItem_android_alphabeticShortcut));
        this.itemAlphabeticModifiers = tintTypedArrayObtainStyledAttributes.getInt(R$styleable.MenuItem_alphabeticModifiers, 4096);
        this.itemNumericShortcut = getShortcut(tintTypedArrayObtainStyledAttributes.getString(R$styleable.MenuItem_android_numericShortcut));
        this.itemNumericModifiers = tintTypedArrayObtainStyledAttributes.getInt(R$styleable.MenuItem_numericModifiers, 4096);
        int i = R$styleable.MenuItem_android_checkable;
        if (tintTypedArrayObtainStyledAttributes.hasValue(i)) {
            this.itemCheckable = tintTypedArrayObtainStyledAttributes.getBoolean(i, false) ? 1 : 0;
        } else {
            this.itemCheckable = this.groupCheckable;
        }
        this.itemChecked = tintTypedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuItem_android_checked, false);
        this.itemVisible = tintTypedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuItem_android_visible, this.groupVisible);
        this.itemEnabled = tintTypedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuItem_android_enabled, this.groupEnabled);
        this.itemShowAsAction = tintTypedArrayObtainStyledAttributes.getInt(R$styleable.MenuItem_showAsAction, -1);
        this.itemListenerMethodName = tintTypedArrayObtainStyledAttributes.getString(R$styleable.MenuItem_android_onClick);
        this.itemActionViewLayout = tintTypedArrayObtainStyledAttributes.getResourceId(R$styleable.MenuItem_actionLayout, 0);
        this.itemActionViewClassName = tintTypedArrayObtainStyledAttributes.getString(R$styleable.MenuItem_actionViewClass);
        String string = tintTypedArrayObtainStyledAttributes.getString(R$styleable.MenuItem_actionProviderClass);
        this.itemActionProviderClassName = string;
        boolean z2 = string != null;
        if (z2 && this.itemActionViewLayout == 0 && this.itemActionViewClassName == null) {
            this.itemActionProvider = (ActionProvider) newInstance(string, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, this.this$0.mActionProviderConstructorArguments);
        } else {
            if (z2) {
                Log.w(SupportMenuInflater.LOG_TAG, "Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            this.itemActionProvider = null;
        }
        this.itemContentDescription = tintTypedArrayObtainStyledAttributes.getText(R$styleable.MenuItem_contentDescription);
        this.itemTooltipText = tintTypedArrayObtainStyledAttributes.getText(R$styleable.MenuItem_tooltipText);
        int i2 = R$styleable.MenuItem_iconTintMode;
        if (tintTypedArrayObtainStyledAttributes.hasValue(i2)) {
            this.itemIconTintMode = DrawableUtils.parseTintMode(tintTypedArrayObtainStyledAttributes.getInt(i2, -1), this.itemIconTintMode);
        } else {
            this.itemIconTintMode = null;
        }
        int i3 = R$styleable.MenuItem_iconTint;
        if (tintTypedArrayObtainStyledAttributes.hasValue(i3)) {
            this.itemIconTintList = tintTypedArrayObtainStyledAttributes.getColorStateList(i3);
        } else {
            this.itemIconTintList = null;
        }
        tintTypedArrayObtainStyledAttributes.recycle();
        this.itemAdded = false;
    }

    public void resetGroup() {
        this.groupId = 0;
        this.groupCategory = 0;
        this.groupOrder = 0;
        this.groupCheckable = 0;
        this.groupVisible = true;
        this.groupEnabled = true;
    }
}

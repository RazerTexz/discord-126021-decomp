package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Dimension;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.C10817R;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuPresenter implements MenuPresenter {
    private static final String STATE_ADAPTER = "android:menu:adapter";
    private static final String STATE_HEADER = "android:menu:header";
    private static final String STATE_HIERARCHY = "android:menu:list";
    public C10930c adapter;
    private MenuPresenter.Callback callback;
    public boolean hasCustomItemIconSize;
    public LinearLayout headerLayout;
    public ColorStateList iconTintList;

    /* JADX INFO: renamed from: id */
    private int f21030id;
    public Drawable itemBackground;
    public int itemHorizontalPadding;
    public int itemIconPadding;
    public int itemIconSize;
    private int itemMaxLines;
    public LayoutInflater layoutInflater;
    public MenuBuilder menu;
    private NavigationMenuView menuView;
    public int paddingSeparator;
    private int paddingTopDefault;
    public int textAppearance;
    public boolean textAppearanceSet;
    public ColorStateList textColor;
    public boolean isBehindStatusBar = true;
    private int overScrollMode = -1;
    public final View.OnClickListener onClickListener = new ViewOnClickListenerC10928a();

    /* JADX INFO: renamed from: com.google.android.material.internal.NavigationMenuPresenter$a */
    public class ViewOnClickListenerC10928a implements View.OnClickListener {
        public ViewOnClickListenerC10928a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z2 = true;
            NavigationMenuPresenter.this.setUpdateSuspended(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            boolean zPerformItemAction = navigationMenuPresenter.menu.performItemAction(itemData, navigationMenuPresenter, 0);
            if (itemData != null && itemData.isCheckable() && zPerformItemAction) {
                NavigationMenuPresenter.this.adapter.m9145b(itemData);
            } else {
                z2 = false;
            }
            NavigationMenuPresenter.this.setUpdateSuspended(false);
            if (z2) {
                NavigationMenuPresenter.this.updateMenuView(false);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.NavigationMenuPresenter$b */
    public static class C10929b extends AbstractC10939l {
        public C10929b(View view) {
            super(view);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.NavigationMenuPresenter$c */
    public class C10930c extends RecyclerView.Adapter<AbstractC10939l> {

        /* JADX INFO: renamed from: a */
        public final ArrayList<InterfaceC10932e> f21032a = new ArrayList<>();

        /* JADX INFO: renamed from: b */
        public MenuItemImpl f21033b;

        /* JADX INFO: renamed from: c */
        public boolean f21034c;

        public C10930c() {
            m9144a();
        }

        /* JADX INFO: renamed from: a */
        public final void m9144a() {
            if (this.f21034c) {
                return;
            }
            this.f21034c = true;
            this.f21032a.clear();
            this.f21032a.add(new C10931d());
            int i = -1;
            int size = NavigationMenuPresenter.this.menu.getVisibleItems().size();
            boolean z2 = false;
            int i2 = 0;
            boolean z3 = false;
            int size2 = 0;
            while (i2 < size) {
                MenuItemImpl menuItemImpl = NavigationMenuPresenter.this.menu.getVisibleItems().get(i2);
                if (menuItemImpl.isChecked()) {
                    m9145b(menuItemImpl);
                }
                if (menuItemImpl.isCheckable()) {
                    menuItemImpl.setExclusiveCheckable(z2);
                }
                if (menuItemImpl.hasSubMenu()) {
                    SubMenu subMenu = menuItemImpl.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i2 != 0) {
                            this.f21032a.add(new C10933f(NavigationMenuPresenter.this.paddingSeparator, z2 ? 1 : 0));
                        }
                        this.f21032a.add(new C10934g(menuItemImpl));
                        int size3 = subMenu.size();
                        int i3 = 0;
                        boolean z4 = false;
                        while (i3 < size3) {
                            MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i3);
                            if (menuItemImpl2.isVisible()) {
                                if (!z4 && menuItemImpl2.getIcon() != null) {
                                    z4 = true;
                                }
                                if (menuItemImpl2.isCheckable()) {
                                    menuItemImpl2.setExclusiveCheckable(z2);
                                }
                                if (menuItemImpl.isChecked()) {
                                    m9145b(menuItemImpl);
                                }
                                this.f21032a.add(new C10934g(menuItemImpl2));
                            }
                            i3++;
                            z2 = false;
                        }
                        if (z4) {
                            int size4 = this.f21032a.size();
                            for (int size5 = this.f21032a.size(); size5 < size4; size5++) {
                                ((C10934g) this.f21032a.get(size5)).f21039b = true;
                            }
                        }
                    }
                } else {
                    int groupId = menuItemImpl.getGroupId();
                    if (groupId != i) {
                        size2 = this.f21032a.size();
                        z3 = menuItemImpl.getIcon() != null;
                        if (i2 != 0) {
                            size2++;
                            ArrayList<InterfaceC10932e> arrayList = this.f21032a;
                            int i4 = NavigationMenuPresenter.this.paddingSeparator;
                            arrayList.add(new C10933f(i4, i4));
                        }
                    } else if (!z3 && menuItemImpl.getIcon() != null) {
                        int size6 = this.f21032a.size();
                        for (int i5 = size2; i5 < size6; i5++) {
                            ((C10934g) this.f21032a.get(i5)).f21039b = true;
                        }
                        z3 = true;
                    }
                    C10934g c10934g = new C10934g(menuItemImpl);
                    c10934g.f21039b = z3;
                    this.f21032a.add(c10934g);
                    i = groupId;
                }
                i2++;
                z2 = false;
            }
            this.f21034c = false;
        }

        /* JADX INFO: renamed from: b */
        public void m9145b(@NonNull MenuItemImpl menuItemImpl) {
            if (this.f21033b == menuItemImpl || !menuItemImpl.isCheckable()) {
                return;
            }
            MenuItemImpl menuItemImpl2 = this.f21033b;
            if (menuItemImpl2 != null) {
                menuItemImpl2.setChecked(false);
            }
            this.f21033b = menuItemImpl;
            menuItemImpl.setChecked(true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: getItemCount */
        public int getPageSize() {
            return this.f21032a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            InterfaceC10932e interfaceC10932e = this.f21032a.get(i);
            if (interfaceC10932e instanceof C10933f) {
                return 2;
            }
            if (interfaceC10932e instanceof C10931d) {
                return 3;
            }
            if (interfaceC10932e instanceof C10934g) {
                return ((C10934g) interfaceC10932e).f21038a.hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            AbstractC10939l abstractC10939l = (AbstractC10939l) viewHolder;
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    ((TextView) abstractC10939l.itemView).setText(((C10934g) this.f21032a.get(i)).f21038a.getTitle());
                    return;
                } else {
                    if (itemViewType != 2) {
                        return;
                    }
                    C10933f c10933f = (C10933f) this.f21032a.get(i);
                    abstractC10939l.itemView.setPadding(0, c10933f.f21036a, 0, c10933f.f21037b);
                    return;
                }
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) abstractC10939l.itemView;
            navigationMenuItemView.setIconTintList(NavigationMenuPresenter.this.iconTintList);
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            if (navigationMenuPresenter.textAppearanceSet) {
                navigationMenuItemView.setTextAppearance(navigationMenuPresenter.textAppearance);
            }
            ColorStateList colorStateList = NavigationMenuPresenter.this.textColor;
            if (colorStateList != null) {
                navigationMenuItemView.setTextColor(colorStateList);
            }
            Drawable drawable = NavigationMenuPresenter.this.itemBackground;
            ViewCompat.setBackground(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            C10934g c10934g = (C10934g) this.f21032a.get(i);
            navigationMenuItemView.setNeedsEmptyIcon(c10934g.f21039b);
            navigationMenuItemView.setHorizontalPadding(NavigationMenuPresenter.this.itemHorizontalPadding);
            navigationMenuItemView.setIconPadding(NavigationMenuPresenter.this.itemIconPadding);
            NavigationMenuPresenter navigationMenuPresenter2 = NavigationMenuPresenter.this;
            if (navigationMenuPresenter2.hasCustomItemIconSize) {
                navigationMenuItemView.setIconSize(navigationMenuPresenter2.itemIconSize);
            }
            navigationMenuItemView.setMaxLines(NavigationMenuPresenter.this.itemMaxLines);
            navigationMenuItemView.initialize(c10934g.f21038a, 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @Nullable
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            RecyclerView.ViewHolder c10936i;
            if (i == 0) {
                NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
                c10936i = new C10936i(navigationMenuPresenter.layoutInflater, viewGroup, navigationMenuPresenter.onClickListener);
            } else if (i == 1) {
                c10936i = new C10938k(NavigationMenuPresenter.this.layoutInflater, viewGroup);
            } else {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return new C10929b(NavigationMenuPresenter.this.headerLayout);
                }
                c10936i = new C10937j(NavigationMenuPresenter.this.layoutInflater, viewGroup);
            }
            return c10936i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            AbstractC10939l abstractC10939l = (AbstractC10939l) viewHolder;
            if (abstractC10939l instanceof C10936i) {
                ((NavigationMenuItemView) abstractC10939l.itemView).recycle();
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.NavigationMenuPresenter$d */
    public static class C10931d implements InterfaceC10932e {
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.NavigationMenuPresenter$e */
    public interface InterfaceC10932e {
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.NavigationMenuPresenter$f */
    public static class C10933f implements InterfaceC10932e {

        /* JADX INFO: renamed from: a */
        public final int f21036a;

        /* JADX INFO: renamed from: b */
        public final int f21037b;

        public C10933f(int i, int i2) {
            this.f21036a = i;
            this.f21037b = i2;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.NavigationMenuPresenter$g */
    public static class C10934g implements InterfaceC10932e {

        /* JADX INFO: renamed from: a */
        public final MenuItemImpl f21038a;

        /* JADX INFO: renamed from: b */
        public boolean f21039b;

        public C10934g(MenuItemImpl menuItemImpl) {
            this.f21038a = menuItemImpl;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.NavigationMenuPresenter$h */
    public class C10935h extends RecyclerViewAccessibilityDelegate {
        public C10935h(RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            C10930c c10930c = NavigationMenuPresenter.this.adapter;
            int i = NavigationMenuPresenter.this.headerLayout.getChildCount() == 0 ? 0 : 1;
            for (int i2 = 0; i2 < NavigationMenuPresenter.this.adapter.getPageSize(); i2++) {
                if (NavigationMenuPresenter.this.adapter.getItemViewType(i2) == 0) {
                    i++;
                }
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(i, 0, false));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.NavigationMenuPresenter$i */
    public static class C10936i extends AbstractC10939l {
        public C10936i(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(C10817R.layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.NavigationMenuPresenter$j */
    public static class C10937j extends AbstractC10939l {
        public C10937j(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(C10817R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.NavigationMenuPresenter$k */
    public static class C10938k extends AbstractC10939l {
        public C10938k(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(C10817R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.NavigationMenuPresenter$l */
    public static abstract class AbstractC10939l extends RecyclerView.ViewHolder {
        public AbstractC10939l(View view) {
            super(view);
        }
    }

    private void updateTopPadding() {
        int i = (this.headerLayout.getChildCount() == 0 && this.isBehindStatusBar) ? this.paddingTopDefault : 0;
        NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, i, 0, navigationMenuView.getPaddingBottom());
    }

    public void addHeaderView(@NonNull View view) {
        this.headerLayout.addView(view);
        NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void dispatchApplyWindowInsets(@NonNull WindowInsetsCompat windowInsetsCompat) {
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        if (this.paddingTopDefault != systemWindowInsetTop) {
            this.paddingTopDefault = systemWindowInsetTop;
            updateTopPadding();
        }
        NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom());
        ViewCompat.dispatchApplyWindowInsets(this.headerLayout, windowInsetsCompat);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Nullable
    public MenuItemImpl getCheckedItem() {
        return this.adapter.f21033b;
    }

    public int getHeaderCount() {
        return this.headerLayout.getChildCount();
    }

    public View getHeaderView(int i) {
        return this.headerLayout.getChildAt(i);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f21030id;
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.itemBackground;
    }

    public int getItemHorizontalPadding() {
        return this.itemHorizontalPadding;
    }

    public int getItemIconPadding() {
        return this.itemIconPadding;
    }

    public int getItemMaxLines() {
        return this.itemMaxLines;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.textColor;
    }

    @Nullable
    public ColorStateList getItemTintList() {
        return this.iconTintList;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.menuView == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.layoutInflater.inflate(C10817R.layout.design_navigation_menu, viewGroup, false);
            this.menuView = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new C10935h(this.menuView));
            if (this.adapter == null) {
                this.adapter = new C10930c();
            }
            int i = this.overScrollMode;
            if (i != -1) {
                this.menuView.setOverScrollMode(i);
            }
            this.headerLayout = (LinearLayout) this.layoutInflater.inflate(C10817R.layout.design_navigation_item_header, (ViewGroup) this.menuView, false);
            this.menuView.setAdapter(this.adapter);
        }
        return this.menuView;
    }

    public View inflateHeaderView(@LayoutRes int i) {
        View viewInflate = this.layoutInflater.inflate(i, (ViewGroup) this.headerLayout, false);
        addHeaderView(viewInflate);
        return viewInflate;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this.layoutInflater = LayoutInflater.from(context);
        this.menu = menuBuilder;
        this.paddingSeparator = context.getResources().getDimensionPixelOffset(C10817R.dimen.design_navigation_separator_vertical_padding);
    }

    public boolean isBehindStatusBar() {
        return this.isBehindStatusBar;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z2) {
        MenuPresenter.Callback callback = this.callback;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z2);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItemImpl menuItemImpl;
        View actionView;
        ParcelableSparseArray parcelableSparseArray;
        MenuItemImpl menuItemImpl2;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.menuView.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle(STATE_ADAPTER);
            if (bundle2 != null) {
                C10930c c10930c = this.adapter;
                Objects.requireNonNull(c10930c);
                int i = bundle2.getInt("android:menu:checked", 0);
                if (i != 0) {
                    c10930c.f21034c = true;
                    int size = c10930c.f21032a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        InterfaceC10932e interfaceC10932e = c10930c.f21032a.get(i2);
                        if ((interfaceC10932e instanceof C10934g) && (menuItemImpl2 = ((C10934g) interfaceC10932e).f21038a) != null && menuItemImpl2.getItemId() == i) {
                            c10930c.m9145b(menuItemImpl2);
                            break;
                        }
                    }
                    c10930c.f21034c = false;
                    c10930c.m9144a();
                }
                SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
                if (sparseParcelableArray2 != null) {
                    int size2 = c10930c.f21032a.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        InterfaceC10932e interfaceC10932e2 = c10930c.f21032a.get(i3);
                        if ((interfaceC10932e2 instanceof C10934g) && (menuItemImpl = ((C10934g) interfaceC10932e2).f21038a) != null && (actionView = menuItemImpl.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray2.get(menuItemImpl.getItemId())) != null) {
                            actionView.restoreHierarchyState(parcelableSparseArray);
                        }
                    }
                }
            }
            SparseArray sparseParcelableArray3 = bundle.getSparseParcelableArray(STATE_HEADER);
            if (sparseParcelableArray3 != null) {
                this.headerLayout.restoreHierarchyState(sparseParcelableArray3);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.menuView != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.menuView.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        C10930c c10930c = this.adapter;
        if (c10930c != null) {
            Objects.requireNonNull(c10930c);
            Bundle bundle2 = new Bundle();
            MenuItemImpl menuItemImpl = c10930c.f21033b;
            if (menuItemImpl != null) {
                bundle2.putInt("android:menu:checked", menuItemImpl.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            int size = c10930c.f21032a.size();
            for (int i = 0; i < size; i++) {
                InterfaceC10932e interfaceC10932e = c10930c.f21032a.get(i);
                if (interfaceC10932e instanceof C10934g) {
                    MenuItemImpl menuItemImpl2 = ((C10934g) interfaceC10932e).f21038a;
                    View actionView = menuItemImpl2 != null ? menuItemImpl2.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray2.put(menuItemImpl2.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle2.putSparseParcelableArray("android:menu:action_views", sparseArray2);
            bundle.putBundle(STATE_ADAPTER, bundle2);
        }
        if (this.headerLayout != null) {
            SparseArray<? extends Parcelable> sparseArray3 = new SparseArray<>();
            this.headerLayout.saveHierarchyState(sparseArray3);
            bundle.putSparseParcelableArray(STATE_HEADER, sparseArray3);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void removeHeaderView(@NonNull View view) {
        this.headerLayout.removeView(view);
        if (this.headerLayout.getChildCount() == 0) {
            NavigationMenuView navigationMenuView = this.menuView;
            navigationMenuView.setPadding(0, this.paddingTopDefault, 0, navigationMenuView.getPaddingBottom());
        }
    }

    public void setBehindStatusBar(boolean z2) {
        if (this.isBehindStatusBar != z2) {
            this.isBehindStatusBar = z2;
            updateTopPadding();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.callback = callback;
    }

    public void setCheckedItem(@NonNull MenuItemImpl menuItemImpl) {
        this.adapter.m9145b(menuItemImpl);
    }

    public void setId(int i) {
        this.f21030id = i;
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.itemBackground = drawable;
        updateMenuView(false);
    }

    public void setItemHorizontalPadding(int i) {
        this.itemHorizontalPadding = i;
        updateMenuView(false);
    }

    public void setItemIconPadding(int i) {
        this.itemIconPadding = i;
        updateMenuView(false);
    }

    public void setItemIconSize(@Dimension int i) {
        if (this.itemIconSize != i) {
            this.itemIconSize = i;
            this.hasCustomItemIconSize = true;
            updateMenuView(false);
        }
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.iconTintList = colorStateList;
        updateMenuView(false);
    }

    public void setItemMaxLines(int i) {
        this.itemMaxLines = i;
        updateMenuView(false);
    }

    public void setItemTextAppearance(@StyleRes int i) {
        this.textAppearance = i;
        this.textAppearanceSet = true;
        updateMenuView(false);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.textColor = colorStateList;
        updateMenuView(false);
    }

    public void setOverScrollMode(int i) {
        this.overScrollMode = i;
        NavigationMenuView navigationMenuView = this.menuView;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i);
        }
    }

    public void setUpdateSuspended(boolean z2) {
        C10930c c10930c = this.adapter;
        if (c10930c != null) {
            c10930c.f21034c = z2;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z2) {
        C10930c c10930c = this.adapter;
        if (c10930c != null) {
            c10930c.m9144a();
            c10930c.notifyDataSetChanged();
        }
    }
}

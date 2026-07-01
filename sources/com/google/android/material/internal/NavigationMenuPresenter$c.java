package com.google.android.material.internal;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.SubMenu;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationMenuPresenter$c extends RecyclerView$Adapter<NavigationMenuPresenter$l> {
    public final ArrayList<NavigationMenuPresenter$e> a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MenuItemImpl f3044b;
    public boolean c;
    public final /* synthetic */ NavigationMenuPresenter d;

    public NavigationMenuPresenter$c(NavigationMenuPresenter navigationMenuPresenter) {
        this.d = navigationMenuPresenter;
        a();
    }

    public final void a() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.a.clear();
        this.a.add(new NavigationMenuPresenter$d());
        int i = -1;
        int size = this.d.menu.getVisibleItems().size();
        boolean z2 = false;
        int i2 = 0;
        boolean z3 = false;
        int size2 = 0;
        while (i2 < size) {
            MenuItemImpl menuItemImpl = this.d.menu.getVisibleItems().get(i2);
            if (menuItemImpl.isChecked()) {
                b(menuItemImpl);
            }
            if (menuItemImpl.isCheckable()) {
                menuItemImpl.setExclusiveCheckable(z2);
            }
            if (menuItemImpl.hasSubMenu()) {
                SubMenu subMenu = menuItemImpl.getSubMenu();
                if (subMenu.hasVisibleItems()) {
                    if (i2 != 0) {
                        this.a.add(new NavigationMenuPresenter$f(this.d.paddingSeparator, z2 ? 1 : 0));
                    }
                    this.a.add(new NavigationMenuPresenter$g(menuItemImpl));
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
                                b(menuItemImpl);
                            }
                            this.a.add(new NavigationMenuPresenter$g(menuItemImpl2));
                        }
                        i3++;
                        z2 = false;
                    }
                    if (z4) {
                        int size4 = this.a.size();
                        for (int size5 = this.a.size(); size5 < size4; size5++) {
                            ((NavigationMenuPresenter$g) this.a.get(size5)).f3046b = true;
                        }
                    }
                }
            } else {
                int groupId = menuItemImpl.getGroupId();
                if (groupId != i) {
                    size2 = this.a.size();
                    z3 = menuItemImpl.getIcon() != null;
                    if (i2 != 0) {
                        size2++;
                        ArrayList<NavigationMenuPresenter$e> arrayList = this.a;
                        int i4 = this.d.paddingSeparator;
                        arrayList.add(new NavigationMenuPresenter$f(i4, i4));
                    }
                } else if (!z3 && menuItemImpl.getIcon() != null) {
                    int size6 = this.a.size();
                    for (int i5 = size2; i5 < size6; i5++) {
                        ((NavigationMenuPresenter$g) this.a.get(i5)).f3046b = true;
                    }
                    z3 = true;
                }
                NavigationMenuPresenter$g navigationMenuPresenter$g = new NavigationMenuPresenter$g(menuItemImpl);
                navigationMenuPresenter$g.f3046b = z3;
                this.a.add(navigationMenuPresenter$g);
                i = groupId;
            }
            i2++;
            z2 = false;
        }
        this.c = false;
    }

    public void b(@NonNull MenuItemImpl menuItemImpl) {
        if (this.f3044b == menuItemImpl || !menuItemImpl.isCheckable()) {
            return;
        }
        MenuItemImpl menuItemImpl2 = this.f3044b;
        if (menuItemImpl2 != null) {
            menuItemImpl2.setChecked(false);
        }
        this.f3044b = menuItemImpl;
        menuItemImpl.setChecked(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemViewType(int i) {
        NavigationMenuPresenter$e navigationMenuPresenter$e = this.a.get(i);
        if (navigationMenuPresenter$e instanceof NavigationMenuPresenter$f) {
            return 2;
        }
        if (navigationMenuPresenter$e instanceof NavigationMenuPresenter$d) {
            return 3;
        }
        if (navigationMenuPresenter$e instanceof NavigationMenuPresenter$g) {
            return ((NavigationMenuPresenter$g) navigationMenuPresenter$e).a.hasSubMenu() ? 1 : 0;
        }
        throw new RuntimeException("Unknown item type.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onBindViewHolder(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        NavigationMenuPresenter$l navigationMenuPresenter$l = (NavigationMenuPresenter$l) recyclerView$ViewHolder;
        int itemViewType = getItemViewType(i);
        if (itemViewType != 0) {
            if (itemViewType == 1) {
                ((TextView) navigationMenuPresenter$l.itemView).setText(((NavigationMenuPresenter$g) this.a.get(i)).a.getTitle());
                return;
            } else {
                if (itemViewType != 2) {
                    return;
                }
                NavigationMenuPresenter$f navigationMenuPresenter$f = (NavigationMenuPresenter$f) this.a.get(i);
                navigationMenuPresenter$l.itemView.setPadding(0, navigationMenuPresenter$f.a, 0, navigationMenuPresenter$f.f3045b);
                return;
            }
        }
        NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) navigationMenuPresenter$l.itemView;
        navigationMenuItemView.setIconTintList(this.d.iconTintList);
        NavigationMenuPresenter navigationMenuPresenter = this.d;
        if (navigationMenuPresenter.textAppearanceSet) {
            navigationMenuItemView.setTextAppearance(navigationMenuPresenter.textAppearance);
        }
        ColorStateList colorStateList = this.d.textColor;
        if (colorStateList != null) {
            navigationMenuItemView.setTextColor(colorStateList);
        }
        Drawable drawable = this.d.itemBackground;
        ViewCompat.setBackground(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
        NavigationMenuPresenter$g navigationMenuPresenter$g = (NavigationMenuPresenter$g) this.a.get(i);
        navigationMenuItemView.setNeedsEmptyIcon(navigationMenuPresenter$g.f3046b);
        navigationMenuItemView.setHorizontalPadding(this.d.itemHorizontalPadding);
        navigationMenuItemView.setIconPadding(this.d.itemIconPadding);
        NavigationMenuPresenter navigationMenuPresenter2 = this.d;
        if (navigationMenuPresenter2.hasCustomItemIconSize) {
            navigationMenuItemView.setIconSize(navigationMenuPresenter2.itemIconSize);
        }
        navigationMenuItemView.setMaxLines(NavigationMenuPresenter.access$000(this.d));
        navigationMenuItemView.initialize(navigationMenuPresenter$g.a, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    @Nullable
    public RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        RecyclerView$ViewHolder navigationMenuPresenter$i;
        if (i == 0) {
            NavigationMenuPresenter navigationMenuPresenter = this.d;
            navigationMenuPresenter$i = new NavigationMenuPresenter$i(navigationMenuPresenter.layoutInflater, viewGroup, navigationMenuPresenter.onClickListener);
        } else if (i == 1) {
            navigationMenuPresenter$i = new NavigationMenuPresenter$k(this.d.layoutInflater, viewGroup);
        } else {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return new NavigationMenuPresenter$b(this.d.headerLayout);
            }
            navigationMenuPresenter$i = new NavigationMenuPresenter$j(this.d.layoutInflater, viewGroup);
        }
        return navigationMenuPresenter$i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onViewRecycled(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        NavigationMenuPresenter$l navigationMenuPresenter$l = (NavigationMenuPresenter$l) recyclerView$ViewHolder;
        if (navigationMenuPresenter$l instanceof NavigationMenuPresenter$i) {
            ((NavigationMenuItemView) navigationMenuPresenter$l.itemView).recycle();
        }
    }
}

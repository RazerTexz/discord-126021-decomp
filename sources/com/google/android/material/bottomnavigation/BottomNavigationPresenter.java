package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ParcelableSparseArray;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationPresenter implements MenuPresenter {

    /* JADX INFO: renamed from: id */
    private int f20919id;
    private MenuBuilder menu;
    private BottomNavigationMenuView menuView;
    private boolean updateSuspended = false;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C10848a();

        /* JADX INFO: renamed from: j */
        public int f20920j;

        /* JADX INFO: renamed from: k */
        @Nullable
        public ParcelableSparseArray f20921k;

        /* JADX INFO: renamed from: com.google.android.material.bottomnavigation.BottomNavigationPresenter$SavedState$a */
        public static class C10848a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            parcel.writeInt(this.f20920j);
            parcel.writeParcelable(this.f20921k, 0);
        }

        public SavedState(@NonNull Parcel parcel) {
            this.f20920j = parcel.readInt();
            this.f20921k = (ParcelableSparseArray) parcel.readParcelable(SavedState.class.getClassLoader());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f20919id;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        return this.menuView;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.menu = menuBuilder;
        this.menuView.initialize(menuBuilder);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z2) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.menuView.tryRestoreSelectedItemId(savedState.f20920j);
            this.menuView.setBadgeDrawables(BadgeUtils.createBadgeDrawablesFromSavedStates(this.menuView.getContext(), savedState.f20921k));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.f20920j = this.menuView.getSelectedItemId();
        savedState.f20921k = BadgeUtils.createParcelableBadgeStates(this.menuView.getBadgeDrawables());
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void setBottomNavigationMenuView(BottomNavigationMenuView bottomNavigationMenuView) {
        this.menuView = bottomNavigationMenuView;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
    }

    public void setId(int i) {
        this.f20919id = i;
    }

    public void setUpdateSuspended(boolean z2) {
        this.updateSuspended = z2;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z2) {
        if (this.updateSuspended) {
            return;
        }
        if (z2) {
            this.menuView.buildMenuView();
        } else {
            this.menuView.updateMenuView();
        }
    }
}

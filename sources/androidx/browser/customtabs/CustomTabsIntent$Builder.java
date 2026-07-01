package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.annotation.AnimRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.BundleCompat;
import b.d.b.a.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class CustomTabsIntent$Builder {

    @Nullable
    private ArrayList<Bundle> mActionButtons;

    @Nullable
    private SparseArray<Bundle> mColorSchemeParamBundles;

    @Nullable
    private Bundle mDefaultColorSchemeBundle;

    @Nullable
    private ArrayList<Bundle> mMenuItems;

    @Nullable
    private Bundle mStartAnimationBundle;
    private final Intent mIntent = new Intent("android.intent.action.VIEW");
    private final CustomTabColorSchemeParams$Builder mDefaultColorSchemeBuilder = new CustomTabColorSchemeParams$Builder();
    private int mShareState = 0;
    private boolean mInstantAppsEnabled = true;

    public CustomTabsIntent$Builder() {
    }

    private void setSessionParameters(@Nullable IBinder iBinder, @Nullable PendingIntent pendingIntent) {
        Bundle bundle = new Bundle();
        BundleCompat.putBinder(bundle, CustomTabsIntent.EXTRA_SESSION, iBinder);
        if (pendingIntent != null) {
            bundle.putParcelable(CustomTabsIntent.EXTRA_SESSION_ID, pendingIntent);
        }
        this.mIntent.putExtras(bundle);
    }

    @NonNull
    @Deprecated
    public CustomTabsIntent$Builder addDefaultShareMenuItem() {
        setShareState(1);
        return this;
    }

    @NonNull
    public CustomTabsIntent$Builder addMenuItem(@NonNull String str, @NonNull PendingIntent pendingIntent) {
        if (this.mMenuItems == null) {
            this.mMenuItems = new ArrayList<>();
        }
        Bundle bundle = new Bundle();
        bundle.putString(CustomTabsIntent.KEY_MENU_ITEM_TITLE, str);
        bundle.putParcelable(CustomTabsIntent.KEY_PENDING_INTENT, pendingIntent);
        this.mMenuItems.add(bundle);
        return this;
    }

    @NonNull
    @Deprecated
    public CustomTabsIntent$Builder addToolbarItem(int i, @NonNull Bitmap bitmap, @NonNull String str, @NonNull PendingIntent pendingIntent) throws IllegalStateException {
        if (this.mActionButtons == null) {
            this.mActionButtons = new ArrayList<>();
        }
        if (this.mActionButtons.size() >= 5) {
            throw new IllegalStateException("Exceeded maximum toolbar item count of 5");
        }
        Bundle bundle = new Bundle();
        bundle.putInt(CustomTabsIntent.KEY_ID, i);
        bundle.putParcelable(CustomTabsIntent.KEY_ICON, bitmap);
        bundle.putString(CustomTabsIntent.KEY_DESCRIPTION, str);
        bundle.putParcelable(CustomTabsIntent.KEY_PENDING_INTENT, pendingIntent);
        this.mActionButtons.add(bundle);
        return this;
    }

    @NonNull
    public CustomTabsIntent build() {
        if (!this.mIntent.hasExtra(CustomTabsIntent.EXTRA_SESSION)) {
            setSessionParameters(null, null);
        }
        ArrayList<Bundle> arrayList = this.mMenuItems;
        if (arrayList != null) {
            this.mIntent.putParcelableArrayListExtra(CustomTabsIntent.EXTRA_MENU_ITEMS, arrayList);
        }
        ArrayList<Bundle> arrayList2 = this.mActionButtons;
        if (arrayList2 != null) {
            this.mIntent.putParcelableArrayListExtra(CustomTabsIntent.EXTRA_TOOLBAR_ITEMS, arrayList2);
        }
        this.mIntent.putExtra(CustomTabsIntent.EXTRA_ENABLE_INSTANT_APPS, this.mInstantAppsEnabled);
        this.mIntent.putExtras(this.mDefaultColorSchemeBuilder.build().toBundle());
        Bundle bundle = this.mDefaultColorSchemeBundle;
        if (bundle != null) {
            this.mIntent.putExtras(bundle);
        }
        if (this.mColorSchemeParamBundles != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putSparseParcelableArray(CustomTabsIntent.EXTRA_COLOR_SCHEME_PARAMS, this.mColorSchemeParamBundles);
            this.mIntent.putExtras(bundle2);
        }
        this.mIntent.putExtra(CustomTabsIntent.EXTRA_SHARE_STATE, this.mShareState);
        return new CustomTabsIntent(this.mIntent, this.mStartAnimationBundle);
    }

    @NonNull
    @Deprecated
    public CustomTabsIntent$Builder enableUrlBarHiding() {
        this.mIntent.putExtra(CustomTabsIntent.EXTRA_ENABLE_URLBAR_HIDING, true);
        return this;
    }

    @NonNull
    public CustomTabsIntent$Builder setActionButton(@NonNull Bitmap bitmap, @NonNull String str, @NonNull PendingIntent pendingIntent, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putInt(CustomTabsIntent.KEY_ID, 0);
        bundle.putParcelable(CustomTabsIntent.KEY_ICON, bitmap);
        bundle.putString(CustomTabsIntent.KEY_DESCRIPTION, str);
        bundle.putParcelable(CustomTabsIntent.KEY_PENDING_INTENT, pendingIntent);
        this.mIntent.putExtra(CustomTabsIntent.EXTRA_ACTION_BUTTON_BUNDLE, bundle);
        this.mIntent.putExtra(CustomTabsIntent.EXTRA_TINT_ACTION_BUTTON, z2);
        return this;
    }

    @NonNull
    public CustomTabsIntent$Builder setCloseButtonIcon(@NonNull Bitmap bitmap) {
        this.mIntent.putExtra(CustomTabsIntent.EXTRA_CLOSE_BUTTON_ICON, bitmap);
        return this;
    }

    @NonNull
    public CustomTabsIntent$Builder setColorScheme(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("Invalid value for the colorScheme argument");
        }
        this.mIntent.putExtra(CustomTabsIntent.EXTRA_COLOR_SCHEME, i);
        return this;
    }

    @NonNull
    public CustomTabsIntent$Builder setColorSchemeParams(int i, @NonNull CustomTabColorSchemeParams customTabColorSchemeParams) {
        if (i < 0 || i > 2 || i == 0) {
            throw new IllegalArgumentException(a.q("Invalid colorScheme: ", i));
        }
        if (this.mColorSchemeParamBundles == null) {
            this.mColorSchemeParamBundles = new SparseArray<>();
        }
        this.mColorSchemeParamBundles.put(i, customTabColorSchemeParams.toBundle());
        return this;
    }

    @NonNull
    public CustomTabsIntent$Builder setDefaultColorSchemeParams(@NonNull CustomTabColorSchemeParams customTabColorSchemeParams) {
        this.mDefaultColorSchemeBundle = customTabColorSchemeParams.toBundle();
        return this;
    }

    @NonNull
    @Deprecated
    public CustomTabsIntent$Builder setDefaultShareMenuItemEnabled(boolean z2) {
        if (z2) {
            setShareState(1);
        } else {
            setShareState(2);
        }
        return this;
    }

    @NonNull
    public CustomTabsIntent$Builder setExitAnimations(@NonNull Context context, @AnimRes int i, @AnimRes int i2) {
        this.mIntent.putExtra(CustomTabsIntent.EXTRA_EXIT_ANIMATION_BUNDLE, ActivityOptionsCompat.makeCustomAnimation(context, i, i2).toBundle());
        return this;
    }

    @NonNull
    public CustomTabsIntent$Builder setInstantAppsEnabled(boolean z2) {
        this.mInstantAppsEnabled = z2;
        return this;
    }

    @NonNull
    @Deprecated
    public CustomTabsIntent$Builder setNavigationBarColor(@ColorInt int i) {
        this.mDefaultColorSchemeBuilder.setNavigationBarColor(i);
        return this;
    }

    @NonNull
    @Deprecated
    public CustomTabsIntent$Builder setNavigationBarDividerColor(@ColorInt int i) {
        this.mDefaultColorSchemeBuilder.setNavigationBarDividerColor(i);
        return this;
    }

    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public CustomTabsIntent$Builder setPendingSession(@NonNull CustomTabsSession$PendingSession customTabsSession$PendingSession) {
        setSessionParameters(null, customTabsSession$PendingSession.getId());
        return this;
    }

    @NonNull
    @Deprecated
    public CustomTabsIntent$Builder setSecondaryToolbarColor(@ColorInt int i) {
        this.mDefaultColorSchemeBuilder.setSecondaryToolbarColor(i);
        return this;
    }

    @NonNull
    public CustomTabsIntent$Builder setSecondaryToolbarViews(@NonNull RemoteViews remoteViews, @Nullable int[] iArr, @Nullable PendingIntent pendingIntent) {
        this.mIntent.putExtra(CustomTabsIntent.EXTRA_REMOTEVIEWS, remoteViews);
        this.mIntent.putExtra(CustomTabsIntent.EXTRA_REMOTEVIEWS_VIEW_IDS, iArr);
        this.mIntent.putExtra(CustomTabsIntent.EXTRA_REMOTEVIEWS_PENDINGINTENT, pendingIntent);
        return this;
    }

    @NonNull
    public CustomTabsIntent$Builder setSession(@NonNull CustomTabsSession customTabsSession) {
        this.mIntent.setPackage(customTabsSession.getComponentName().getPackageName());
        setSessionParameters(customTabsSession.getBinder(), customTabsSession.getId());
        return this;
    }

    @NonNull
    public CustomTabsIntent$Builder setShareState(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("Invalid value for the shareState argument");
        }
        this.mShareState = i;
        if (i == 1) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_DEFAULT_SHARE_MENU_ITEM, true);
        } else if (i == 2) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_DEFAULT_SHARE_MENU_ITEM, false);
        } else {
            this.mIntent.removeExtra(CustomTabsIntent.EXTRA_DEFAULT_SHARE_MENU_ITEM);
        }
        return this;
    }

    @NonNull
    public CustomTabsIntent$Builder setShowTitle(boolean z2) {
        this.mIntent.putExtra(CustomTabsIntent.EXTRA_TITLE_VISIBILITY_STATE, z2 ? 1 : 0);
        return this;
    }

    @NonNull
    public CustomTabsIntent$Builder setStartAnimations(@NonNull Context context, @AnimRes int i, @AnimRes int i2) {
        this.mStartAnimationBundle = ActivityOptionsCompat.makeCustomAnimation(context, i, i2).toBundle();
        return this;
    }

    @NonNull
    @Deprecated
    public CustomTabsIntent$Builder setToolbarColor(@ColorInt int i) {
        this.mDefaultColorSchemeBuilder.setToolbarColor(i);
        return this;
    }

    @NonNull
    public CustomTabsIntent$Builder setUrlBarHidingEnabled(boolean z2) {
        this.mIntent.putExtra(CustomTabsIntent.EXTRA_ENABLE_URLBAR_HIDING, z2);
        return this;
    }

    public CustomTabsIntent$Builder(@Nullable CustomTabsSession customTabsSession) {
        if (customTabsSession != null) {
            setSession(customTabsSession);
        }
    }

    @NonNull
    public CustomTabsIntent$Builder setActionButton(@NonNull Bitmap bitmap, @NonNull String str, @NonNull PendingIntent pendingIntent) {
        return setActionButton(bitmap, str, pendingIntent, false);
    }
}

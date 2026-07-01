package androidx.fragment.app;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

/* JADX INFO: loaded from: classes.dex */
public interface FragmentManager$BackStackEntry {
    @Nullable
    @Deprecated
    CharSequence getBreadCrumbShortTitle();

    @StringRes
    @Deprecated
    int getBreadCrumbShortTitleRes();

    @Nullable
    @Deprecated
    CharSequence getBreadCrumbTitle();

    @StringRes
    @Deprecated
    int getBreadCrumbTitleRes();

    int getId();

    @Nullable
    String getName();
}

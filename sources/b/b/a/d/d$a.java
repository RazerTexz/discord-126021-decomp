package b.b.a.d;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

/* JADX INFO: compiled from: AddContentPagerAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d$a {
    private final int contentDesc;
    private final int icon;

    public d$a(@DrawableRes int i, @StringRes int i2) {
        this.icon = i;
        this.contentDesc = i2;
    }

    public abstract Fragment createFragment();

    public final int getContentDesc() {
        return this.contentDesc;
    }

    public final int getIcon() {
        return this.icon;
    }
}

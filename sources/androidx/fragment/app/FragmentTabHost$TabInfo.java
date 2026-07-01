package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentTabHost$TabInfo {

    @Nullable
    public final Bundle args;

    @NonNull
    public final Class<?> clss;
    public Fragment fragment;

    @NonNull
    public final String tag;

    public FragmentTabHost$TabInfo(@NonNull String str, @NonNull Class<?> cls, @Nullable Bundle bundle) {
        this.tag = str;
        this.clss = cls;
        this.args = bundle;
    }
}

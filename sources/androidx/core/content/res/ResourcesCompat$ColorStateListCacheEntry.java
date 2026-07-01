package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class ResourcesCompat$ColorStateListCacheEntry {
    public final Configuration mConfiguration;
    public final ColorStateList mValue;

    public ResourcesCompat$ColorStateListCacheEntry(@NonNull ColorStateList colorStateList, @NonNull Configuration configuration) {
        this.mValue = colorStateList;
        this.mConfiguration = configuration;
    }
}

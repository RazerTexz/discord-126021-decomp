package androidx.appcompat.content.res;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatResources$ColorStateListCacheEntry {
    public final Configuration configuration;
    public final ColorStateList value;

    public AppCompatResources$ColorStateListCacheEntry(@NonNull ColorStateList colorStateList, @NonNull Configuration configuration) {
        this.value = colorStateList;
        this.configuration = configuration;
    }
}

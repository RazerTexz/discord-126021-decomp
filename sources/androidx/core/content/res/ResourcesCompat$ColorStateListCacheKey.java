package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.Resources$Theme;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;

/* JADX INFO: loaded from: classes.dex */
public final class ResourcesCompat$ColorStateListCacheKey {
    public final Resources mResources;

    @Nullable
    public final Resources$Theme mTheme;

    public ResourcesCompat$ColorStateListCacheKey(@NonNull Resources resources, @Nullable Resources$Theme resources$Theme) {
        this.mResources = resources;
        this.mTheme = resources$Theme;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ResourcesCompat$ColorStateListCacheKey.class != obj.getClass()) {
            return false;
        }
        ResourcesCompat$ColorStateListCacheKey resourcesCompat$ColorStateListCacheKey = (ResourcesCompat$ColorStateListCacheKey) obj;
        return this.mResources.equals(resourcesCompat$ColorStateListCacheKey.mResources) && ObjectsCompat.equals(this.mTheme, resourcesCompat$ColorStateListCacheKey.mTheme);
    }

    public int hashCode() {
        return ObjectsCompat.hash(this.mResources, this.mTheme);
    }
}

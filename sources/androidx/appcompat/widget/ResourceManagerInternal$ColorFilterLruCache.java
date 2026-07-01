package androidx.appcompat.widget;

import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffColorFilter;
import androidx.collection.LruCache;

/* JADX INFO: loaded from: classes.dex */
public class ResourceManagerInternal$ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
    public ResourceManagerInternal$ColorFilterLruCache(int i) {
        super(i);
    }

    private static int generateCacheKey(int i, PorterDuff$Mode porterDuff$Mode) {
        return porterDuff$Mode.hashCode() + ((i + 31) * 31);
    }

    public PorterDuffColorFilter get(int i, PorterDuff$Mode porterDuff$Mode) {
        return get(Integer.valueOf(generateCacheKey(i, porterDuff$Mode)));
    }

    public PorterDuffColorFilter put(int i, PorterDuff$Mode porterDuff$Mode, PorterDuffColorFilter porterDuffColorFilter) {
        return put(Integer.valueOf(generateCacheKey(i, porterDuff$Mode)), porterDuffColorFilter);
    }
}

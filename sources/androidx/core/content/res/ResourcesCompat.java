package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources$NotFoundException;
import android.content.res.Resources$Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Handler;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Preconditions;
import b.d.b.a.a;
import java.io.IOException;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class ResourcesCompat {

    @AnyRes
    public static final int ID_NULL = 0;
    private static final String TAG = "ResourcesCompat";
    private static final ThreadLocal<TypedValue> sTempTypedValue = new ThreadLocal<>();
    private static final WeakHashMap<ResourcesCompat$ColorStateListCacheKey, SparseArray<ResourcesCompat$ColorStateListCacheEntry>> sColorStateCaches = new WeakHashMap<>(0);
    private static final Object sColorStateCacheLock = new Object();

    private ResourcesCompat() {
    }

    private static void addColorStateListToCache(@NonNull ResourcesCompat$ColorStateListCacheKey resourcesCompat$ColorStateListCacheKey, @ColorRes int i, @NonNull ColorStateList colorStateList) {
        synchronized (sColorStateCacheLock) {
            WeakHashMap<ResourcesCompat$ColorStateListCacheKey, SparseArray<ResourcesCompat$ColorStateListCacheEntry>> weakHashMap = sColorStateCaches;
            SparseArray<ResourcesCompat$ColorStateListCacheEntry> sparseArray = weakHashMap.get(resourcesCompat$ColorStateListCacheKey);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(resourcesCompat$ColorStateListCacheKey, sparseArray);
            }
            sparseArray.append(i, new ResourcesCompat$ColorStateListCacheEntry(colorStateList, resourcesCompat$ColorStateListCacheKey.mResources.getConfiguration()));
        }
    }

    @Nullable
    private static ColorStateList getCachedColorStateList(@NonNull ResourcesCompat$ColorStateListCacheKey resourcesCompat$ColorStateListCacheKey, @ColorRes int i) {
        ResourcesCompat$ColorStateListCacheEntry resourcesCompat$ColorStateListCacheEntry;
        synchronized (sColorStateCacheLock) {
            SparseArray<ResourcesCompat$ColorStateListCacheEntry> sparseArray = sColorStateCaches.get(resourcesCompat$ColorStateListCacheKey);
            if (sparseArray != null && sparseArray.size() > 0 && (resourcesCompat$ColorStateListCacheEntry = sparseArray.get(i)) != null) {
                if (resourcesCompat$ColorStateListCacheEntry.mConfiguration.equals(resourcesCompat$ColorStateListCacheKey.mResources.getConfiguration())) {
                    return resourcesCompat$ColorStateListCacheEntry.mValue;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    @Nullable
    public static Typeface getCachedFont(@NonNull Context context, @FontRes int i) throws Resources$NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, new TypedValue(), 0, null, null, false, true);
    }

    @ColorInt
    public static int getColor(@NonNull Resources resources, @ColorRes int i, @Nullable Resources$Theme resources$Theme) throws Resources$NotFoundException {
        return Build$VERSION.SDK_INT >= 23 ? resources.getColor(i, resources$Theme) : resources.getColor(i);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Resources resources, @ColorRes int i, @Nullable Resources$Theme resources$Theme) throws Resources$NotFoundException {
        if (Build$VERSION.SDK_INT >= 23) {
            return resources.getColorStateList(i, resources$Theme);
        }
        ResourcesCompat$ColorStateListCacheKey resourcesCompat$ColorStateListCacheKey = new ResourcesCompat$ColorStateListCacheKey(resources, resources$Theme);
        ColorStateList cachedColorStateList = getCachedColorStateList(resourcesCompat$ColorStateListCacheKey, i);
        if (cachedColorStateList != null) {
            return cachedColorStateList;
        }
        ColorStateList colorStateListInflateColorStateList = inflateColorStateList(resources, i, resources$Theme);
        if (colorStateListInflateColorStateList == null) {
            return resources.getColorStateList(i);
        }
        addColorStateListToCache(resourcesCompat$ColorStateListCacheKey, i, colorStateListInflateColorStateList);
        return colorStateListInflateColorStateList;
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Resources resources, @DrawableRes int i, @Nullable Resources$Theme resources$Theme) throws Resources$NotFoundException {
        return resources.getDrawable(i, resources$Theme);
    }

    @Nullable
    public static Drawable getDrawableForDensity(@NonNull Resources resources, @DrawableRes int i, int i2, @Nullable Resources$Theme resources$Theme) throws Resources$NotFoundException {
        return resources.getDrawableForDensity(i, i2, resources$Theme);
    }

    public static float getFloat(@NonNull Resources resources, @DimenRes int i) {
        if (Build$VERSION.SDK_INT >= 29) {
            return ResourcesCompat$ImplApi29.getFloat(resources, i);
        }
        TypedValue typedValue = getTypedValue();
        resources.getValue(i, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        StringBuilder sbU = a.U("Resource ID #0x");
        sbU.append(Integer.toHexString(i));
        sbU.append(" type #0x");
        sbU.append(Integer.toHexString(typedValue.type));
        sbU.append(" is not valid");
        throw new Resources$NotFoundException(sbU.toString());
    }

    @Nullable
    public static Typeface getFont(@NonNull Context context, @FontRes int i) throws Resources$NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, new TypedValue(), 0, null, null, false, false);
    }

    @NonNull
    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> threadLocal = sTempTypedValue;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    @Nullable
    private static ColorStateList inflateColorStateList(Resources resources, int i, @Nullable Resources$Theme resources$Theme) {
        if (isColorInt(resources, i)) {
            return null;
        }
        try {
            return ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i), resources$Theme);
        } catch (Exception e) {
            Log.e(TAG, "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    private static boolean isColorInt(@NonNull Resources resources, @ColorRes int i) {
        TypedValue typedValue = getTypedValue();
        resources.getValue(i, typedValue, true);
        int i2 = typedValue.type;
        return i2 >= 28 && i2 <= 31;
    }

    private static Typeface loadFont(@NonNull Context context, int i, TypedValue typedValue, int i2, @Nullable ResourcesCompat$FontCallback resourcesCompat$FontCallback, @Nullable Handler handler, boolean z2, boolean z3) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface typefaceLoadFont = loadFont(context, resources, typedValue, i, i2, resourcesCompat$FontCallback, handler, z2, z3);
        if (typefaceLoadFont != null || resourcesCompat$FontCallback != null || z3) {
            return typefaceLoadFont;
        }
        StringBuilder sbU = a.U("Font resource ID #0x");
        sbU.append(Integer.toHexString(i));
        sbU.append(" could not be retrieved.");
        throw new Resources$NotFoundException(sbU.toString());
    }

    public static void getFont(@NonNull Context context, @FontRes int i, @NonNull ResourcesCompat$FontCallback resourcesCompat$FontCallback, @Nullable Handler handler) throws Resources$NotFoundException {
        Preconditions.checkNotNull(resourcesCompat$FontCallback);
        if (context.isRestricted()) {
            resourcesCompat$FontCallback.callbackFailAsync(-4, handler);
        } else {
            loadFont(context, i, new TypedValue(), 0, resourcesCompat$FontCallback, handler, false, false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00a7  */
    private static Typeface loadFont(@NonNull Context context, Resources resources, TypedValue typedValue, int i, int i2, @Nullable ResourcesCompat$FontCallback resourcesCompat$FontCallback, @Nullable Handler handler, boolean z2, boolean z3) {
        CharSequence charSequence = typedValue.string;
        if (charSequence != null) {
            String string = charSequence.toString();
            if (!string.startsWith("res/")) {
                if (resourcesCompat$FontCallback != null) {
                    resourcesCompat$FontCallback.callbackFailAsync(-3, handler);
                }
                return null;
            }
            Typeface typefaceFindFromCache = TypefaceCompat.findFromCache(resources, i, i2);
            if (typefaceFindFromCache != null) {
                if (resourcesCompat$FontCallback != null) {
                    resourcesCompat$FontCallback.callbackSuccessAsync(typefaceFindFromCache, handler);
                }
                return typefaceFindFromCache;
            }
            if (z3) {
                return null;
            }
            try {
                if (string.toLowerCase().endsWith(".xml")) {
                    FontResourcesParserCompat$FamilyResourceEntry fontResourcesParserCompat$FamilyResourceEntry = FontResourcesParserCompat.parse(resources.getXml(i), resources);
                    if (fontResourcesParserCompat$FamilyResourceEntry == null) {
                        Log.e(TAG, "Failed to find font-family tag");
                        if (resourcesCompat$FontCallback != null) {
                            resourcesCompat$FontCallback.callbackFailAsync(-3, handler);
                        }
                        return null;
                    }
                    return TypefaceCompat.createFromResourcesFamilyXml(context, fontResourcesParserCompat$FamilyResourceEntry, resources, i, i2, resourcesCompat$FontCallback, handler, z2);
                }
                Typeface typefaceCreateFromResourcesFontFile = TypefaceCompat.createFromResourcesFontFile(context, resources, i, string, i2);
                if (resourcesCompat$FontCallback != null) {
                    if (typefaceCreateFromResourcesFontFile != null) {
                        resourcesCompat$FontCallback.callbackSuccessAsync(typefaceCreateFromResourcesFontFile, handler);
                    } else {
                        resourcesCompat$FontCallback.callbackFailAsync(-3, handler);
                    }
                }
                return typefaceCreateFromResourcesFontFile;
            } catch (IOException e) {
                Log.e(TAG, "Failed to read xml resource " + string, e);
                if (resourcesCompat$FontCallback != null) {
                    resourcesCompat$FontCallback.callbackFailAsync(-3, handler);
                }
                return null;
            } catch (XmlPullParserException e2) {
                Log.e(TAG, "Failed to parse xml resource " + string, e2);
                if (resourcesCompat$FontCallback != null) {
                    resourcesCompat$FontCallback.callbackFailAsync(-3, handler);
                }
                return null;
            }
        }
        StringBuilder sbU = a.U("Resource \"");
        sbU.append(resources.getResourceName(i));
        sbU.append("\" (");
        sbU.append(Integer.toHexString(i));
        sbU.append(") is not a Font: ");
        sbU.append(typedValue);
        throw new Resources$NotFoundException(sbU.toString());
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface getFont(@NonNull Context context, @FontRes int i, TypedValue typedValue, int i2, @Nullable ResourcesCompat$FontCallback resourcesCompat$FontCallback) throws Resources$NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, typedValue, i2, resourcesCompat$FontCallback, null, true, false);
    }
}

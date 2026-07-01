package androidx.core.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager$NameNotFoundException;
import android.graphics.Typeface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Consumer;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class FontRequestWorker {
    public static final LruCache<String, Typeface> sTypefaceCache = new LruCache<>(16);
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = RequestExecutor.createDefaultExecutor("fonts-androidx", 10, 10000);
    public static final Object LOCK = new Object();

    @GuardedBy("LOCK")
    public static final SimpleArrayMap<String, ArrayList<Consumer<FontRequestWorker$TypefaceResult>>> PENDING_REPLIES = new SimpleArrayMap<>();

    private FontRequestWorker() {
    }

    private static String createCacheId(@NonNull FontRequest fontRequest, int i) {
        return fontRequest.getId() + "-" + i;
    }

    @SuppressLint({"WrongConstant"})
    private static int getFontFamilyResultStatus(@NonNull FontsContractCompat$FontFamilyResult fontsContractCompat$FontFamilyResult) {
        int i = 1;
        if (fontsContractCompat$FontFamilyResult.getStatusCode() != 0) {
            return fontsContractCompat$FontFamilyResult.getStatusCode() != 1 ? -3 : -2;
        }
        FontsContractCompat$FontInfo[] fonts = fontsContractCompat$FontFamilyResult.getFonts();
        if (fonts != null && fonts.length != 0) {
            i = 0;
            for (FontsContractCompat$FontInfo fontsContractCompat$FontInfo : fonts) {
                int resultCode = fontsContractCompat$FontInfo.getResultCode();
                if (resultCode != 0) {
                    if (resultCode < 0) {
                        return -3;
                    }
                    return resultCode;
                }
            }
        }
        return i;
    }

    @NonNull
    public static FontRequestWorker$TypefaceResult getFontSync(@NonNull String str, @NonNull Context context, @NonNull FontRequest fontRequest, int i) {
        LruCache<String, Typeface> lruCache = sTypefaceCache;
        Typeface typeface = lruCache.get(str);
        if (typeface != null) {
            return new FontRequestWorker$TypefaceResult(typeface);
        }
        try {
            FontsContractCompat$FontFamilyResult fontFamilyResult = FontProvider.getFontFamilyResult(context, fontRequest, null);
            int fontFamilyResultStatus = getFontFamilyResultStatus(fontFamilyResult);
            if (fontFamilyResultStatus != 0) {
                return new FontRequestWorker$TypefaceResult(fontFamilyResultStatus);
            }
            Typeface typefaceCreateFromFontInfo = TypefaceCompat.createFromFontInfo(context, null, fontFamilyResult.getFonts(), i);
            if (typefaceCreateFromFontInfo == null) {
                return new FontRequestWorker$TypefaceResult(-3);
            }
            lruCache.put(str, typefaceCreateFromFontInfo);
            return new FontRequestWorker$TypefaceResult(typefaceCreateFromFontInfo);
        } catch (PackageManager$NameNotFoundException unused) {
            return new FontRequestWorker$TypefaceResult(-1);
        }
    }

    public static Typeface requestFontAsync(@NonNull Context context, @NonNull FontRequest fontRequest, int i, @Nullable Executor executor, @NonNull CallbackWithHandler callbackWithHandler) {
        String strCreateCacheId = createCacheId(fontRequest, i);
        Typeface typeface = sTypefaceCache.get(strCreateCacheId);
        if (typeface != null) {
            callbackWithHandler.onTypefaceResult(new FontRequestWorker$TypefaceResult(typeface));
            return typeface;
        }
        FontRequestWorker$2 fontRequestWorker$2 = new FontRequestWorker$2(callbackWithHandler);
        synchronized (LOCK) {
            SimpleArrayMap<String, ArrayList<Consumer<FontRequestWorker$TypefaceResult>>> simpleArrayMap = PENDING_REPLIES;
            ArrayList<Consumer<FontRequestWorker$TypefaceResult>> arrayList = simpleArrayMap.get(strCreateCacheId);
            if (arrayList != null) {
                arrayList.add(fontRequestWorker$2);
                return null;
            }
            ArrayList<Consumer<FontRequestWorker$TypefaceResult>> arrayList2 = new ArrayList<>();
            arrayList2.add(fontRequestWorker$2);
            simpleArrayMap.put(strCreateCacheId, arrayList2);
            FontRequestWorker$3 fontRequestWorker$3 = new FontRequestWorker$3(strCreateCacheId, context, fontRequest, i);
            if (executor == null) {
                executor = DEFAULT_EXECUTOR_SERVICE;
            }
            RequestExecutor.execute(executor, fontRequestWorker$3, new FontRequestWorker$4(strCreateCacheId));
            return null;
        }
    }

    public static Typeface requestFontSync(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull CallbackWithHandler callbackWithHandler, int i, int i2) {
        String strCreateCacheId = createCacheId(fontRequest, i);
        Typeface typeface = sTypefaceCache.get(strCreateCacheId);
        if (typeface != null) {
            callbackWithHandler.onTypefaceResult(new FontRequestWorker$TypefaceResult(typeface));
            return typeface;
        }
        if (i2 == -1) {
            FontRequestWorker$TypefaceResult fontSync = getFontSync(strCreateCacheId, context, fontRequest, i);
            callbackWithHandler.onTypefaceResult(fontSync);
            return fontSync.mTypeface;
        }
        try {
            FontRequestWorker$TypefaceResult fontRequestWorker$TypefaceResult = (FontRequestWorker$TypefaceResult) RequestExecutor.submit(DEFAULT_EXECUTOR_SERVICE, new FontRequestWorker$1(strCreateCacheId, context, fontRequest, i), i2);
            callbackWithHandler.onTypefaceResult(fontRequestWorker$TypefaceResult);
            return fontRequestWorker$TypefaceResult.mTypeface;
        } catch (InterruptedException unused) {
            callbackWithHandler.onTypefaceResult(new FontRequestWorker$TypefaceResult(-3));
            return null;
        }
    }

    public static void resetTypefaceCache() {
        sTypefaceCache.evictAll();
    }
}

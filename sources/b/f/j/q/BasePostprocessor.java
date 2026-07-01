package b.f.j.q;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import b.f.j.e.NativeCodeSetup;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: b.f.j.q.a, reason: use source file name */
/* JADX INFO: compiled from: BasePostprocessor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BasePostprocessor implements Postprocessor {
    public static final Bitmap.Config FALLBACK_BITMAP_CONFIGURATION = Bitmap.Config.ARGB_8888;
    private static Method sCopyBitmap;

    private static void internalCopyBitmap(Bitmap bitmap, Bitmap bitmap2) {
        if (!NativeCodeSetup.a || bitmap.getConfig() != bitmap2.getConfig()) {
            new Canvas(bitmap).drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
            return;
        }
        try {
            if (sCopyBitmap == null) {
                sCopyBitmap = Class.forName("com.facebook.imagepipeline.nativecode.Bitmaps").getDeclaredMethod("copyBitmap", Bitmap.class, Bitmap.class);
            }
            sCopyBitmap.invoke(null, bitmap, bitmap2);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Wrong Native code setup, reflection failed.", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Wrong Native code setup, reflection failed.", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("Wrong Native code setup, reflection failed.", e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException("Wrong Native code setup, reflection failed.", e4);
        }
    }

    @Override // b.f.j.q.Postprocessor
    public String getName() {
        return "Unknown postprocessor";
    }

    @Override // b.f.j.q.Postprocessor
    public CacheKey getPostprocessorCacheKey() {
        return null;
    }

    @Override // b.f.j.q.Postprocessor
    public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
        Bitmap.Config config = bitmap.getConfig();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (config == null) {
            config = FALLBACK_BITMAP_CONFIGURATION;
        }
        CloseableReference<Bitmap> closeableReferenceB = platformBitmapFactory.b(width, height, config);
        try {
            process(closeableReferenceB.u(), bitmap);
            CloseableReference<Bitmap> closeableReferenceClone = closeableReferenceB.clone();
            closeableReferenceB.close();
            return closeableReferenceClone;
        } catch (Throwable th) {
            Class<CloseableReference> cls = CloseableReference.j;
            if (closeableReferenceB != null) {
                closeableReferenceB.close();
            }
            throw th;
        }
    }

    public void process(Bitmap bitmap) {
    }

    public void process(Bitmap bitmap, Bitmap bitmap2) {
        internalCopyBitmap(bitmap, bitmap2);
        process(bitmap);
    }
}

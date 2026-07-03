package p007b.p109f.p161j.p182q;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p007b.p109f.p161j.p170e.C1899n;

/* JADX INFO: renamed from: b.f.j.q.a */
/* JADX INFO: compiled from: BasePostprocessor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2025a implements InterfaceC2026b {
    public static final Bitmap.Config FALLBACK_BITMAP_CONFIGURATION = Bitmap.Config.ARGB_8888;
    private static Method sCopyBitmap;

    private static void internalCopyBitmap(Bitmap bitmap, Bitmap bitmap2) {
        if (!C1899n.f3808a || bitmap.getConfig() != bitmap2.getConfig()) {
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

    @Override // p007b.p109f.p161j.p182q.InterfaceC2026b
    public String getName() {
        return "Unknown postprocessor";
    }

    @Override // p007b.p109f.p161j.p182q.InterfaceC2026b
    public CacheKey getPostprocessorCacheKey() {
        return null;
    }

    @Override // p007b.p109f.p161j.p182q.InterfaceC2026b
    public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
        Bitmap.Config config = bitmap.getConfig();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (config == null) {
            config = FALLBACK_BITMAP_CONFIGURATION;
        }
        CloseableReference<Bitmap> closeableReferenceMo1206b = platformBitmapFactory.mo1206b(width, height, config);
        try {
            process(closeableReferenceMo1206b.m8642u(), bitmap);
            CloseableReference<Bitmap> closeableReferenceClone = closeableReferenceMo1206b.clone();
            closeableReferenceMo1206b.close();
            return closeableReferenceClone;
        } catch (Throwable th) {
            Class<CloseableReference> cls = CloseableReference.f19438j;
            if (closeableReferenceMo1206b != null) {
                closeableReferenceMo1206b.close();
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

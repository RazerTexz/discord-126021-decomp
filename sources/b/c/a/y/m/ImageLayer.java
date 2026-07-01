package b.c.a.y.m;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.c.a.ImageAssetDelegate;
import b.c.a.LottieDrawable;
import b.c.a.LottieImageAsset;
import b.c.a.LottieProperty;
import b.c.a.b0.Logger2;
import b.c.a.b0.Utils;
import b.c.a.c0.LottieValueCallback;
import b.c.a.w.LPaint;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.ValueCallbackKeyframeAnimation;
import b.c.a.x.ImageAssetManager;
import java.io.IOException;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.c.a.y.m.d, reason: use source file name */
/* JADX INFO: compiled from: ImageLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class ImageLayer extends BaseLayer2 {

    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Paint f435x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Rect f436y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Rect f437z;

    public ImageLayer(LottieDrawable lottieDrawable, Layer2 layer2) {
        super(lottieDrawable, layer2);
        this.f435x = new LPaint(3);
        this.f436y = new Rect();
        this.f437z = new Rect();
    }

    @Override // b.c.a.y.m.BaseLayer2, b.c.a.w.b.DrawingContent
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        super.d(rectF, matrix, z2);
        Bitmap bitmapQ = q();
        if (bitmapQ != null) {
            rectF.set(0.0f, 0.0f, Utils.c() * bitmapQ.getWidth(), Utils.c() * bitmapQ.getHeight());
            this.m.mapRect(rectF);
        }
    }

    @Override // b.c.a.y.m.BaseLayer2, b.c.a.y.KeyPathElement
    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        this.v.c(t, lottieValueCallback);
        if (t == LottieProperty.C) {
            if (lottieValueCallback == null) {
                this.A = null;
            } else {
                this.A = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            }
        }
    }

    @Override // b.c.a.y.m.BaseLayer2
    public void j(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap bitmapQ = q();
        if (bitmapQ == null || bitmapQ.isRecycled()) {
            return;
        }
        float fC = Utils.c();
        this.f435x.setAlpha(i);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.A;
        if (baseKeyframeAnimation != null) {
            this.f435x.setColorFilter(baseKeyframeAnimation.e());
        }
        canvas.save();
        canvas.concat(matrix);
        this.f436y.set(0, 0, bitmapQ.getWidth(), bitmapQ.getHeight());
        this.f437z.set(0, 0, (int) (bitmapQ.getWidth() * fC), (int) (bitmapQ.getHeight() * fC));
        canvas.drawBitmap(bitmapQ, this.f436y, this.f437z, this.f435x);
        canvas.restore();
    }

    @Nullable
    public final Bitmap q() {
        ImageAssetManager imageAssetManager;
        LottieImageAsset lottieImageAsset;
        String str = this.o.g;
        LottieDrawable lottieDrawable = this.n;
        if (lottieDrawable.getCallback() == null) {
            imageAssetManager = null;
        } else {
            ImageAssetManager imageAssetManager2 = lottieDrawable.f352s;
            if (imageAssetManager2 != null) {
                Drawable.Callback callback = lottieDrawable.getCallback();
                Context context = (callback != null && (callback instanceof View)) ? ((View) callback).getContext() : null;
                if (!((context == null && imageAssetManager2.f398b == null) || imageAssetManager2.f398b.equals(context))) {
                    lottieDrawable.f352s = null;
                }
            }
            if (lottieDrawable.f352s == null) {
                lottieDrawable.f352s = new ImageAssetManager(lottieDrawable.getCallback(), lottieDrawable.t, lottieDrawable.u, lottieDrawable.k.d);
            }
            imageAssetManager = lottieDrawable.f352s;
        }
        if (imageAssetManager == null || (lottieImageAsset = imageAssetManager.e.get(str)) == null) {
            return null;
        }
        Bitmap bitmap = lottieImageAsset.e;
        if (bitmap != null) {
            return bitmap;
        }
        ImageAssetDelegate imageAssetDelegate = imageAssetManager.d;
        if (imageAssetDelegate != null) {
            Bitmap bitmapA = imageAssetDelegate.a(lottieImageAsset);
            if (bitmapA == null) {
                return bitmapA;
            }
            imageAssetManager.a(str, bitmapA);
            return bitmapA;
        }
        String str2 = lottieImageAsset.d;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = Opcodes.IF_ICMPNE;
        if (str2.startsWith("data:") && str2.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(str2.substring(str2.indexOf(44) + 1), 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options);
                imageAssetManager.a(str, bitmapDecodeByteArray);
                return bitmapDecodeByteArray;
            } catch (IllegalArgumentException e) {
                Logger2.c("data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(imageAssetManager.c)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            Bitmap bitmapE = Utils.e(BitmapFactory.decodeStream(imageAssetManager.f398b.getAssets().open(imageAssetManager.c + str2), null, options), lottieImageAsset.a, lottieImageAsset.f367b);
            imageAssetManager.a(str, bitmapE);
            return bitmapE;
        } catch (IOException e2) {
            Logger2.c("Unable to open asset.", e2);
            return null;
        }
    }
}

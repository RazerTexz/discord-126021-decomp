package b.c.a.y.m;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory$Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable$Callback;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.c.a.j;
import b.c.a.k;
import b.c.a.o;
import b.c.a.w.c.p;
import java.io.IOException;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: ImageLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends b {

    @Nullable
    public b.c.a.w.c.a<ColorFilter, ColorFilter> A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Paint f435x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Rect f436y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Rect f437z;

    public d(j jVar, e eVar) {
        super(jVar, eVar);
        this.f435x = new b.c.a.w.a(3);
        this.f436y = new Rect();
        this.f437z = new Rect();
    }

    @Override // b.c.a.y.m.b, b.c.a.w.b.e
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        super.d(rectF, matrix, z2);
        Bitmap bitmapQ = q();
        if (bitmapQ != null) {
            rectF.set(0.0f, 0.0f, b.c.a.b0.g.c() * bitmapQ.getWidth(), b.c.a.b0.g.c() * bitmapQ.getHeight());
            this.m.mapRect(rectF);
        }
    }

    @Override // b.c.a.y.m.b, b.c.a.y.g
    public <T> void g(T t, @Nullable b.c.a.c0.c<T> cVar) {
        this.v.c(t, cVar);
        if (t == o.C) {
            if (cVar == null) {
                this.A = null;
            } else {
                this.A = new p(cVar, null);
            }
        }
    }

    @Override // b.c.a.y.m.b
    public void j(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap bitmapQ = q();
        if (bitmapQ == null || bitmapQ.isRecycled()) {
            return;
        }
        float fC = b.c.a.b0.g.c();
        this.f435x.setAlpha(i);
        b.c.a.w.c.a<ColorFilter, ColorFilter> aVar = this.A;
        if (aVar != null) {
            this.f435x.setColorFilter(aVar.e());
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
        b.c.a.x.b bVar;
        k kVar;
        String str = this.o.g;
        j jVar = this.n;
        if (jVar.getCallback() == null) {
            bVar = null;
        } else {
            b.c.a.x.b bVar2 = jVar.f352s;
            if (bVar2 != null) {
                Drawable$Callback callback = jVar.getCallback();
                Context context = (callback != null && (callback instanceof View)) ? ((View) callback).getContext() : null;
                if (!((context == null && bVar2.f398b == null) || bVar2.f398b.equals(context))) {
                    jVar.f352s = null;
                }
            }
            if (jVar.f352s == null) {
                jVar.f352s = new b.c.a.x.b(jVar.getCallback(), jVar.t, jVar.u, jVar.k.d);
            }
            bVar = jVar.f352s;
        }
        if (bVar == null || (kVar = bVar.e.get(str)) == null) {
            return null;
        }
        Bitmap bitmap = kVar.e;
        if (bitmap != null) {
            return bitmap;
        }
        b.c.a.b bVar3 = bVar.d;
        if (bVar3 != null) {
            Bitmap bitmapA = bVar3.a(kVar);
            if (bitmapA == null) {
                return bitmapA;
            }
            bVar.a(str, bitmapA);
            return bitmapA;
        }
        String str2 = kVar.d;
        BitmapFactory$Options bitmapFactory$Options = new BitmapFactory$Options();
        bitmapFactory$Options.inScaled = true;
        bitmapFactory$Options.inDensity = Opcodes.IF_ICMPNE;
        if (str2.startsWith("data:") && str2.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(str2.substring(str2.indexOf(44) + 1), 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, bitmapFactory$Options);
                bVar.a(str, bitmapDecodeByteArray);
                return bitmapDecodeByteArray;
            } catch (IllegalArgumentException e) {
                b.c.a.b0.c.c("data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(bVar.c)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            Bitmap bitmapE = b.c.a.b0.g.e(BitmapFactory.decodeStream(bVar.f398b.getAssets().open(bVar.c + str2), null, bitmapFactory$Options), kVar.a, kVar.f367b);
            bVar.a(str, bitmapE);
            return bitmapE;
        } catch (IOException e2) {
            b.c.a.b0.c.c("Unable to open asset.", e2);
            return null;
        }
    }
}

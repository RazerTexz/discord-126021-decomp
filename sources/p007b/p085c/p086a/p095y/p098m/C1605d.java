package p007b.p085c.p086a.p095y.p098m;

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
import java.io.IOException;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.C1512k;
import p007b.p085c.p086a.InterfaceC1492b;
import p007b.p085c.p086a.InterfaceC1516o;
import p007b.p085c.p086a.p089b0.C1495c;
import p007b.p085c.p086a.p089b0.C1499g;
import p007b.p085c.p086a.p090c0.C1503c;
import p007b.p085c.p086a.p091w.C1524a;
import p007b.p085c.p086a.p091w.p093c.AbstractC1544a;
import p007b.p085c.p086a.p091w.p093c.C1559p;
import p007b.p085c.p086a.p094x.C1561b;

/* JADX INFO: renamed from: b.c.a.y.m.d */
/* JADX INFO: compiled from: ImageLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class C1605d extends AbstractC1603b {

    /* JADX INFO: renamed from: A */
    @Nullable
    public AbstractC1544a<ColorFilter, ColorFilter> f2864A;

    /* JADX INFO: renamed from: x */
    public final Paint f2865x;

    /* JADX INFO: renamed from: y */
    public final Rect f2866y;

    /* JADX INFO: renamed from: z */
    public final Rect f2867z;

    public C1605d(C1511j c1511j, C1606e c1606e) {
        super(c1511j, c1606e);
        this.f2865x = new C1524a(3);
        this.f2866y = new Rect();
        this.f2867z = new Rect();
    }

    @Override // p007b.p085c.p086a.p095y.p098m.AbstractC1603b, p007b.p085c.p086a.p091w.p092b.InterfaceC1529e
    /* JADX INFO: renamed from: d */
    public void mo712d(RectF rectF, Matrix matrix, boolean z2) {
        super.mo712d(rectF, matrix, z2);
        Bitmap bitmapM787q = m787q();
        if (bitmapM787q != null) {
            rectF.set(0.0f, 0.0f, C1499g.m659c() * bitmapM787q.getWidth(), C1499g.m659c() * bitmapM787q.getHeight());
            this.f2848m.mapRect(rectF);
        }
    }

    @Override // p007b.p085c.p086a.p095y.p098m.AbstractC1603b, p007b.p085c.p086a.p095y.InterfaceC1568g
    /* JADX INFO: renamed from: g */
    public <T> void mo714g(T t, @Nullable C1503c<T> c1503c) {
        this.f2857v.m745c(t, c1503c);
        if (t == InterfaceC1516o.f2421C) {
            if (c1503c == null) {
                this.f2864A = null;
            } else {
                this.f2864A = new C1559p(c1503c, null);
            }
        }
    }

    @Override // p007b.p085c.p086a.p095y.p098m.AbstractC1603b
    /* JADX INFO: renamed from: j */
    public void mo780j(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap bitmapM787q = m787q();
        if (bitmapM787q == null || bitmapM787q.isRecycled()) {
            return;
        }
        float fM659c = C1499g.m659c();
        this.f2865x.setAlpha(i);
        AbstractC1544a<ColorFilter, ColorFilter> abstractC1544a = this.f2864A;
        if (abstractC1544a != null) {
            this.f2865x.setColorFilter(abstractC1544a.mo727e());
        }
        canvas.save();
        canvas.concat(matrix);
        this.f2866y.set(0, 0, bitmapM787q.getWidth(), bitmapM787q.getHeight());
        this.f2867z.set(0, 0, (int) (bitmapM787q.getWidth() * fM659c), (int) (bitmapM787q.getHeight() * fM659c));
        canvas.drawBitmap(bitmapM787q, this.f2866y, this.f2867z, this.f2865x);
        canvas.restore();
    }

    @Nullable
    /* JADX INFO: renamed from: q */
    public final Bitmap m787q() {
        C1561b c1561b;
        C1512k c1512k;
        String str = this.f2850o.f2874g;
        C1511j c1511j = this.f2849n;
        if (c1511j.getCallback() == null) {
            c1561b = null;
        } else {
            C1561b c1561b2 = c1511j.f2378s;
            if (c1561b2 != null) {
                Drawable.Callback callback = c1511j.getCallback();
                Context context = (callback != null && (callback instanceof View)) ? ((View) callback).getContext() : null;
                if (!((context == null && c1561b2.f2648b == null) || c1561b2.f2648b.equals(context))) {
                    c1511j.f2378s = null;
                }
            }
            if (c1511j.f2378s == null) {
                c1511j.f2378s = new C1561b(c1511j.getCallback(), c1511j.f2379t, c1511j.f2380u, c1511j.f2370k.f2339d);
            }
            c1561b = c1511j.f2378s;
        }
        if (c1561b == null || (c1512k = c1561b.f2651e.get(str)) == null) {
            return null;
        }
        Bitmap bitmap = c1512k.f2418e;
        if (bitmap != null) {
            return bitmap;
        }
        InterfaceC1492b interfaceC1492b = c1561b.f2650d;
        if (interfaceC1492b != null) {
            Bitmap bitmapM636a = interfaceC1492b.m636a(c1512k);
            if (bitmapM636a == null) {
                return bitmapM636a;
            }
            c1561b.m749a(str, bitmapM636a);
            return bitmapM636a;
        }
        String str2 = c1512k.f2417d;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = Opcodes.IF_ICMPNE;
        if (str2.startsWith("data:") && str2.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(str2.substring(str2.indexOf(44) + 1), 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options);
                c1561b.m749a(str, bitmapDecodeByteArray);
                return bitmapDecodeByteArray;
            } catch (IllegalArgumentException e) {
                C1495c.m641c("data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(c1561b.f2649c)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            Bitmap bitmapM661e = C1499g.m661e(BitmapFactory.decodeStream(c1561b.f2648b.getAssets().open(c1561b.f2649c + str2), null, options), c1512k.f2414a, c1512k.f2415b);
            c1561b.m749a(str, bitmapM661e);
            return bitmapM661e;
        } catch (IOException e2) {
            C1495c.m641c("Unable to open asset.", e2);
            return null;
        }
    }
}

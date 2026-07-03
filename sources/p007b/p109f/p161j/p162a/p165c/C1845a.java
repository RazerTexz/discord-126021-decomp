package p007b.p109f.p161j.p162a.p165c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.util.Objects;
import p007b.p109f.p161j.p162a.p163a.C1835b;
import p007b.p109f.p161j.p162a.p163a.C1838e;
import p007b.p109f.p161j.p162a.p163a.InterfaceC1834a;
import p007b.p109f.p161j.p162a.p163a.InterfaceC1836c;
import p007b.p109f.p161j.p162a.p163a.InterfaceC1837d;
import p007b.p109f.p161j.p162a.p166d.C1849a;

/* JADX INFO: renamed from: b.f.j.a.c.a */
/* JADX INFO: compiled from: AnimatedDrawableBackendImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class C1845a implements InterfaceC1834a {

    /* JADX INFO: renamed from: a */
    public final C1849a f3624a;

    /* JADX INFO: renamed from: b */
    public final C1838e f3625b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC1836c f3626c;

    /* JADX INFO: renamed from: d */
    public final Rect f3627d;

    /* JADX INFO: renamed from: e */
    public final int[] f3628e;

    /* JADX INFO: renamed from: f */
    public final C1835b[] f3629f;

    /* JADX INFO: renamed from: g */
    public final Rect f3630g = new Rect();

    /* JADX INFO: renamed from: h */
    public final Rect f3631h = new Rect();

    /* JADX INFO: renamed from: i */
    public final boolean f3632i;

    /* JADX INFO: renamed from: j */
    public Bitmap f3633j;

    public C1845a(C1849a c1849a, C1838e c1838e, Rect rect, boolean z2) {
        this.f3624a = c1849a;
        this.f3625b = c1838e;
        InterfaceC1836c interfaceC1836c = c1838e.f3609a;
        this.f3626c = interfaceC1836c;
        int[] iArrMo1183i = interfaceC1836c.mo1183i();
        this.f3628e = iArrMo1183i;
        Objects.requireNonNull(c1849a);
        for (int i = 0; i < iArrMo1183i.length; i++) {
            if (iArrMo1183i[i] < 11) {
                iArrMo1183i[i] = 100;
            }
        }
        C1849a c1849a2 = this.f3624a;
        int[] iArr = this.f3628e;
        Objects.requireNonNull(c1849a2);
        for (int i2 : iArr) {
        }
        C1849a c1849a3 = this.f3624a;
        int[] iArr2 = this.f3628e;
        Objects.requireNonNull(c1849a3);
        int[] iArr3 = new int[iArr2.length];
        int i3 = 0;
        for (int i4 = 0; i4 < iArr2.length; i4++) {
            iArr3[i4] = i3;
            i3 += iArr2[i4];
        }
        this.f3627d = m1195a(this.f3626c, rect);
        this.f3632i = z2;
        this.f3629f = new C1835b[this.f3626c.mo1177a()];
        for (int i5 = 0; i5 < this.f3626c.mo1177a(); i5++) {
            this.f3629f[i5] = this.f3626c.mo1182g(i5);
        }
    }

    /* JADX INFO: renamed from: a */
    public static Rect m1195a(InterfaceC1836c interfaceC1836c, Rect rect) {
        return rect == null ? new Rect(0, 0, interfaceC1836c.getWidth(), interfaceC1836c.getHeight()) : new Rect(0, 0, Math.min(rect.width(), interfaceC1836c.getWidth()), Math.min(rect.height(), interfaceC1836c.getHeight()));
    }

    /* JADX INFO: renamed from: b */
    public int m1196b() {
        return this.f3626c.mo1177a();
    }

    /* JADX INFO: renamed from: c */
    public final synchronized Bitmap m1197c(int i, int i2) {
        Bitmap bitmap = this.f3633j;
        if (bitmap != null && (bitmap.getWidth() < i || this.f3633j.getHeight() < i2)) {
            synchronized (this) {
                Bitmap bitmap2 = this.f3633j;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                    this.f3633j = null;
                }
            }
        }
        if (this.f3633j == null) {
            this.f3633j = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.f3633j.eraseColor(0);
        return this.f3633j;
    }

    /* JADX INFO: renamed from: d */
    public void m1198d(int i, Canvas canvas) {
        InterfaceC1837d interfaceC1837dMo1180e = this.f3626c.mo1180e(i);
        try {
            if (interfaceC1837dMo1180e.getWidth() > 0 && interfaceC1837dMo1180e.getHeight() > 0) {
                if (this.f3626c.mo1181f()) {
                    m1200f(canvas, interfaceC1837dMo1180e);
                } else {
                    m1199e(canvas, interfaceC1837dMo1180e);
                }
            }
        } finally {
            interfaceC1837dMo1180e.dispose();
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m1199e(Canvas canvas, InterfaceC1837d interfaceC1837d) {
        int width;
        int height;
        int iMo1186b;
        int iMo1187c;
        if (this.f3632i) {
            float fMax = Math.max(interfaceC1837d.getWidth() / Math.min(interfaceC1837d.getWidth(), canvas.getWidth()), interfaceC1837d.getHeight() / Math.min(interfaceC1837d.getHeight(), canvas.getHeight()));
            width = (int) (interfaceC1837d.getWidth() / fMax);
            height = (int) (interfaceC1837d.getHeight() / fMax);
            iMo1186b = (int) (interfaceC1837d.mo1186b() / fMax);
            iMo1187c = (int) (interfaceC1837d.mo1187c() / fMax);
        } else {
            width = interfaceC1837d.getWidth();
            height = interfaceC1837d.getHeight();
            iMo1186b = interfaceC1837d.mo1186b();
            iMo1187c = interfaceC1837d.mo1187c();
        }
        synchronized (this) {
            Bitmap bitmapM1197c = m1197c(width, height);
            this.f3633j = bitmapM1197c;
            interfaceC1837d.mo1185a(width, height, bitmapM1197c);
            canvas.save();
            canvas.translate(iMo1186b, iMo1187c);
            canvas.drawBitmap(this.f3633j, 0.0f, 0.0f, (Paint) null);
            canvas.restore();
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m1200f(Canvas canvas, InterfaceC1837d interfaceC1837d) {
        double dWidth = ((double) this.f3627d.width()) / ((double) this.f3626c.getWidth());
        double dHeight = ((double) this.f3627d.height()) / ((double) this.f3626c.getHeight());
        int iRound = (int) Math.round(((double) interfaceC1837d.getWidth()) * dWidth);
        int iRound2 = (int) Math.round(((double) interfaceC1837d.getHeight()) * dHeight);
        int iMo1186b = (int) (((double) interfaceC1837d.mo1186b()) * dWidth);
        int iMo1187c = (int) (((double) interfaceC1837d.mo1187c()) * dHeight);
        synchronized (this) {
            int iWidth = this.f3627d.width();
            int iHeight = this.f3627d.height();
            m1197c(iWidth, iHeight);
            Bitmap bitmap = this.f3633j;
            if (bitmap != null) {
                interfaceC1837d.mo1185a(iRound, iRound2, bitmap);
            }
            this.f3630g.set(0, 0, iWidth, iHeight);
            this.f3631h.set(iMo1186b, iMo1187c, iWidth + iMo1186b, iHeight + iMo1187c);
            Bitmap bitmap2 = this.f3633j;
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, this.f3630g, this.f3631h, (Paint) null);
            }
        }
    }
}

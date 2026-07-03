package p007b.p109f.p161j.p162a.p165c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.common.references.CloseableReference;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p109f.p161j.p162a.p163a.C1835b;
import p007b.p109f.p161j.p162a.p163a.C1838e;
import p007b.p109f.p161j.p162a.p163a.InterfaceC1834a;
import p007b.p109f.p161j.p185t.InterfaceC2037a;

/* JADX INFO: renamed from: b.f.j.a.c.d */
/* JADX INFO: compiled from: AnimatedImageCompositor.java */
/* JADX INFO: loaded from: classes2.dex */
public class C1848d {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1834a f3641a;

    /* JADX INFO: renamed from: b */
    public final a f3642b;

    /* JADX INFO: renamed from: c */
    public final Paint f3643c;

    /* JADX INFO: renamed from: b.f.j.a.c.d$a */
    /* JADX INFO: compiled from: AnimatedImageCompositor.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo1162a(int i, Bitmap bitmap);

        /* JADX INFO: renamed from: b */
        CloseableReference<Bitmap> mo1163b(int i);
    }

    public C1848d(InterfaceC1834a interfaceC1834a, a aVar) {
        this.f3641a = interfaceC1834a;
        this.f3642b = aVar;
        Paint paint = new Paint();
        this.f3643c = paint;
        paint.setColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    /* JADX INFO: renamed from: a */
    public final void m1202a(Canvas canvas, C1835b c1835b) {
        int i = c1835b.f3603a;
        int i2 = c1835b.f3604b;
        canvas.drawRect(i, i2, i + c1835b.f3605c, i2 + c1835b.f3606d, this.f3643c);
    }

    /* JADX INFO: renamed from: b */
    public final boolean m1203b(C1835b c1835b) {
        return c1835b.f3603a == 0 && c1835b.f3604b == 0 && c1835b.f3605c == ((C1845a) this.f3641a).f3627d.width() && c1835b.f3606d == ((C1845a) this.f3641a).f3627d.height();
    }

    /* JADX INFO: renamed from: c */
    public final boolean m1204c(int i) {
        if (i == 0) {
            return true;
        }
        C1835b[] c1835bArr = ((C1845a) this.f3641a).f3629f;
        C1835b c1835b = c1835bArr[i];
        C1835b c1835b2 = c1835bArr[i - 1];
        if (c1835b.f3607e == 2 && m1203b(c1835b)) {
            return true;
        }
        return c1835b2.f3608f == 2 && m1203b(c1835b2);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002f  */
    /* JADX INFO: renamed from: d */
    public void m1205d(int i, Bitmap bitmap) {
        InterfaceC2037a interfaceC2037a;
        int i2;
        Canvas canvas = new Canvas(bitmap);
        int i3 = 0;
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        if (m1204c(i)) {
            i3 = i;
        } else {
            for (int i4 = i - 1; i4 >= 0; i4--) {
                C1835b c1835b = ((C1845a) this.f3641a).f3629f[i4];
                int i5 = c1835b.f3608f;
                if (i5 == 1) {
                    i2 = 1;
                } else if (i5 != 2) {
                    i2 = i5 == 3 ? 3 : 4;
                } else if (m1203b(c1835b)) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                int iM758h = C1563b.m758h(i2);
                if (iM758h == 0) {
                    C1835b c1835b2 = ((C1845a) this.f3641a).f3629f[i4];
                    CloseableReference<Bitmap> closeableReferenceMo1163b = this.f3642b.mo1163b(i4);
                    if (closeableReferenceMo1163b != null) {
                        try {
                            canvas.drawBitmap(closeableReferenceMo1163b.m8642u(), 0.0f, 0.0f, (Paint) null);
                            if (c1835b2.f3608f == 2) {
                                m1202a(canvas, c1835b2);
                            }
                            i3 = i4 + 1;
                            closeableReferenceMo1163b.close();
                            break;
                        } catch (Throwable th) {
                            closeableReferenceMo1163b.close();
                            throw th;
                        }
                    }
                    if (m1204c(i4)) {
                        i3 = i4;
                        break;
                    }
                } else if (iM758h == 1) {
                    i3 = i4 + 1;
                    break;
                } else {
                    if (iM758h == 3) {
                        i3 = i4;
                        break;
                    }
                }
            }
        }
        while (i3 < i) {
            C1835b c1835b3 = ((C1845a) this.f3641a).f3629f[i3];
            int i6 = c1835b3.f3608f;
            if (i6 != 3) {
                if (c1835b3.f3607e == 2) {
                    m1202a(canvas, c1835b3);
                }
                ((C1845a) this.f3641a).m1198d(i3, canvas);
                this.f3642b.mo1162a(i3, bitmap);
                if (i6 == 2) {
                    m1202a(canvas, c1835b3);
                }
            }
            i3++;
        }
        C1835b c1835b4 = ((C1845a) this.f3641a).f3629f[i];
        if (c1835b4.f3607e == 2) {
            m1202a(canvas, c1835b4);
        }
        ((C1845a) this.f3641a).m1198d(i, canvas);
        C1838e c1838e = ((C1845a) this.f3641a).f3625b;
        if (c1838e == null || (interfaceC2037a = c1838e.f3612d) == null) {
            return;
        }
        interfaceC2037a.m1537a(bitmap);
    }
}

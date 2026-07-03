package p007b.p109f.p148h.p149a.p151b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Objects;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p148h.p149a.p150a.C1803c;
import p007b.p109f.p148h.p149a.p150a.InterfaceC1801a;
import p007b.p109f.p148h.p149a.p150a.InterfaceC1804d;
import p007b.p109f.p148h.p149a.p151b.p153e.C1814c;
import p007b.p109f.p148h.p149a.p151b.p153e.C1814c.a;
import p007b.p109f.p148h.p149a.p151b.p153e.C1815d;
import p007b.p109f.p148h.p149a.p151b.p153e.InterfaceC1812a;
import p007b.p109f.p148h.p149a.p151b.p153e.InterfaceC1813b;
import p007b.p109f.p148h.p149a.p151b.p154f.C1817b;
import p007b.p109f.p161j.p162a.p165c.C1845a;
import p007b.p109f.p161j.p162a.p165c.C1848d;

/* JADX INFO: renamed from: b.f.h.a.b.a */
/* JADX INFO: compiled from: BitmapAnimationBackend.java */
/* JADX INFO: loaded from: classes.dex */
public class C1805a implements InterfaceC1801a, C1803c.b {

    /* JADX INFO: renamed from: a */
    public final PlatformBitmapFactory f3496a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1806b f3497b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC1804d f3498c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC1807c f3499d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC1812a f3500e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC1813b f3501f;

    /* JADX INFO: renamed from: h */
    public Rect f3503h;

    /* JADX INFO: renamed from: i */
    public int f3504i;

    /* JADX INFO: renamed from: j */
    public int f3505j;

    /* JADX INFO: renamed from: k */
    public Bitmap.Config f3506k = Bitmap.Config.ARGB_8888;

    /* JADX INFO: renamed from: g */
    public final Paint f3502g = new Paint(6);

    public C1805a(PlatformBitmapFactory platformBitmapFactory, InterfaceC1806b interfaceC1806b, InterfaceC1804d interfaceC1804d, InterfaceC1807c interfaceC1807c, InterfaceC1812a interfaceC1812a, InterfaceC1813b interfaceC1813b) {
        this.f3496a = platformBitmapFactory;
        this.f3497b = interfaceC1806b;
        this.f3498c = interfaceC1804d;
        this.f3499d = interfaceC1807c;
        this.f3500e = interfaceC1812a;
        this.f3501f = interfaceC1813b;
        m1150n();
    }

    @Override // p007b.p109f.p148h.p149a.p150a.InterfaceC1804d
    /* JADX INFO: renamed from: a */
    public int mo1142a() {
        return this.f3498c.mo1142a();
    }

    @Override // p007b.p109f.p148h.p149a.p150a.InterfaceC1804d
    /* JADX INFO: renamed from: b */
    public int mo1143b() {
        return this.f3498c.mo1143b();
    }

    @Override // p007b.p109f.p148h.p149a.p150a.C1803c.b
    /* JADX INFO: renamed from: c */
    public void mo1146c() {
        this.f3497b.clear();
    }

    @Override // p007b.p109f.p148h.p149a.p150a.InterfaceC1801a
    public void clear() {
        this.f3497b.clear();
    }

    @Override // p007b.p109f.p148h.p149a.p150a.InterfaceC1801a
    /* JADX INFO: renamed from: d */
    public void mo1136d(ColorFilter colorFilter) {
        this.f3502g.setColorFilter(colorFilter);
    }

    @Override // p007b.p109f.p148h.p149a.p150a.InterfaceC1804d
    /* JADX INFO: renamed from: e */
    public int mo1144e(int i) {
        return this.f3498c.mo1144e(i);
    }

    @Override // p007b.p109f.p148h.p149a.p150a.InterfaceC1801a
    /* JADX INFO: renamed from: f */
    public void mo1137f(@IntRange(from = 0, m76to = 255) int i) {
        this.f3502g.setAlpha(i);
    }

    @Override // p007b.p109f.p148h.p149a.p150a.InterfaceC1801a
    /* JADX INFO: renamed from: g */
    public int mo1138g() {
        return this.f3505j;
    }

    @Override // p007b.p109f.p148h.p149a.p150a.InterfaceC1801a
    /* JADX INFO: renamed from: h */
    public void mo1139h(Rect rect) {
        this.f3503h = rect;
        C1817b c1817b = (C1817b) this.f3499d;
        C1845a c1845a = (C1845a) c1817b.f3528b;
        if (!C1845a.m1195a(c1845a.f3626c, rect).equals(c1845a.f3627d)) {
            c1845a = new C1845a(c1845a.f3624a, c1845a.f3625b, rect, c1845a.f3632i);
        }
        if (c1845a != c1817b.f3528b) {
            c1817b.f3528b = c1845a;
            c1817b.f3529c = new C1848d(c1845a, c1817b.f3530d);
        }
        m1150n();
    }

    @Override // p007b.p109f.p148h.p149a.p150a.InterfaceC1801a
    /* JADX INFO: renamed from: i */
    public int mo1140i() {
        return this.f3504i;
    }

    @Override // p007b.p109f.p148h.p149a.p150a.InterfaceC1801a
    /* JADX INFO: renamed from: j */
    public boolean mo1141j(Drawable drawable, Canvas canvas, int i) {
        InterfaceC1813b interfaceC1813b;
        int i2 = i;
        boolean zM1148l = m1148l(canvas, i2, 0);
        InterfaceC1812a interfaceC1812a = this.f3500e;
        if (interfaceC1812a != null && (interfaceC1813b = this.f3501f) != null) {
            InterfaceC1806b interfaceC1806b = this.f3497b;
            C1815d c1815d = (C1815d) interfaceC1812a;
            int i3 = 1;
            while (i3 <= c1815d.f3525a) {
                int iMo1142a = (i2 + i3) % mo1142a();
                C1691a.m980h(2);
                C1814c c1814c = (C1814c) interfaceC1813b;
                Objects.requireNonNull(c1814c);
                int iHashCode = (hashCode() * 31) + iMo1142a;
                synchronized (c1814c.f3519e) {
                    if (c1814c.f3519e.get(iHashCode) != null) {
                        int i4 = C1691a.f3102a;
                    } else if (interfaceC1806b.mo1153c(iMo1142a)) {
                        int i5 = C1691a.f3102a;
                    } else {
                        C1814c.a aVar = c1814c.new a(this, interfaceC1806b, iMo1142a, iHashCode);
                        c1814c.f3519e.put(iHashCode, aVar);
                        c1814c.f3518d.execute(aVar);
                    }
                }
                i3++;
                i2 = i;
            }
        }
        return zM1148l;
    }

    /* JADX INFO: renamed from: k */
    public final boolean m1147k(int i, CloseableReference<Bitmap> closeableReference, Canvas canvas, int i2) {
        if (!CloseableReference.m8640y(closeableReference)) {
            return false;
        }
        if (this.f3503h == null) {
            canvas.drawBitmap(closeableReference.m8642u(), 0.0f, 0.0f, this.f3502g);
        } else {
            canvas.drawBitmap(closeableReference.m8642u(), (Rect) null, this.f3503h, this.f3502g);
        }
        if (i2 == 3) {
            return true;
        }
        this.f3497b.mo1155e(i, closeableReference, i2);
        return true;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: l */
    public final boolean m1148l(Canvas canvas, int i, int i2) {
        CloseableReference closeableReferenceMo1154d;
        boolean zM1147k;
        int i3 = 2;
        boolean z2 = true;
        CloseableReference closeableReference = null;
        try {
            if (i2 == 0) {
                closeableReferenceMo1154d = this.f3497b.mo1154d(i);
                zM1147k = m1147k(i, closeableReferenceMo1154d, canvas, 0);
                i3 = 1;
            } else if (i2 == 1) {
                closeableReferenceMo1154d = this.f3497b.mo1151a(i, this.f3504i, this.f3505j);
                if (!m1149m(i, closeableReferenceMo1154d) || !m1147k(i, closeableReferenceMo1154d, canvas, 1)) {
                    z2 = false;
                }
                zM1147k = z2;
            } else if (i2 == 2) {
                try {
                    closeableReferenceMo1154d = this.f3496a.m8695a(this.f3504i, this.f3505j, this.f3506k);
                    if (!m1149m(i, closeableReferenceMo1154d) || !m1147k(i, closeableReferenceMo1154d, canvas, 2)) {
                        z2 = false;
                    }
                    zM1147k = z2;
                    i3 = 3;
                } catch (RuntimeException e) {
                    C1691a.m984l(C1805a.class, "Failed to create frame bitmap", e);
                    Class<CloseableReference> cls = CloseableReference.f19438j;
                    return false;
                }
            } else {
                if (i2 != 3) {
                    Class<CloseableReference> cls2 = CloseableReference.f19438j;
                    return false;
                }
                closeableReferenceMo1154d = this.f3497b.mo1156f(i);
                zM1147k = m1147k(i, closeableReferenceMo1154d, canvas, 3);
                i3 = -1;
            }
            Class<CloseableReference> cls3 = CloseableReference.f19438j;
            if (closeableReferenceMo1154d != null) {
                closeableReferenceMo1154d.close();
            }
            return (zM1147k || i3 == -1) ? zM1147k : m1148l(canvas, i, i3);
        } catch (Throwable th) {
            Class<CloseableReference> cls4 = CloseableReference.f19438j;
            if (0 != 0) {
                closeableReference.close();
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: m */
    public final boolean m1149m(int i, CloseableReference<Bitmap> closeableReference) {
        if (!CloseableReference.m8640y(closeableReference)) {
            return false;
        }
        boolean zM1161a = ((C1817b) this.f3499d).m1161a(i, closeableReference.m8642u());
        if (!zM1161a) {
            closeableReference.close();
        }
        return zM1161a;
    }

    /* JADX INFO: renamed from: n */
    public final void m1150n() {
        int width = ((C1845a) ((C1817b) this.f3499d).f3528b).f3626c.getWidth();
        this.f3504i = width;
        if (width == -1) {
            Rect rect = this.f3503h;
            this.f3504i = rect == null ? -1 : rect.width();
        }
        int height = ((C1845a) ((C1817b) this.f3499d).f3528b).f3626c.getHeight();
        this.f3505j = height;
        if (height == -1) {
            Rect rect2 = this.f3503h;
            this.f3505j = rect2 != null ? rect2.height() : -1;
        }
    }
}

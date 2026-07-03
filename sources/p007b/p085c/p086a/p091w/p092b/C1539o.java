package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import java.util.List;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.InterfaceC1516o;
import p007b.p085c.p086a.p089b0.C1498f;
import p007b.p085c.p086a.p090c0.C1503c;
import p007b.p085c.p086a.p091w.p093c.AbstractC1544a;
import p007b.p085c.p086a.p091w.p093c.C1546c;
import p007b.p085c.p086a.p095y.C1567f;
import p007b.p085c.p086a.p095y.p097l.C1594i;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;

/* JADX INFO: renamed from: b.c.a.w.b.o */
/* JADX INFO: compiled from: RectangleContent.java */
/* JADX INFO: loaded from: classes.dex */
public class C1539o implements AbstractC1544a.b, InterfaceC1535k, InterfaceC1537m {

    /* JADX INFO: renamed from: c */
    public final String f2561c;

    /* JADX INFO: renamed from: d */
    public final boolean f2562d;

    /* JADX INFO: renamed from: e */
    public final C1511j f2563e;

    /* JADX INFO: renamed from: f */
    public final AbstractC1544a<?, PointF> f2564f;

    /* JADX INFO: renamed from: g */
    public final AbstractC1544a<?, PointF> f2565g;

    /* JADX INFO: renamed from: h */
    public final AbstractC1544a<?, Float> f2566h;

    /* JADX INFO: renamed from: j */
    public boolean f2568j;

    /* JADX INFO: renamed from: a */
    public final Path f2559a = new Path();

    /* JADX INFO: renamed from: b */
    public final RectF f2560b = new RectF();

    /* JADX INFO: renamed from: i */
    public C1526b f2567i = new C1526b();

    public C1539o(C1511j c1511j, AbstractC1603b abstractC1603b, C1594i c1594i) {
        this.f2561c = c1594i.f2793a;
        this.f2562d = c1594i.f2797e;
        this.f2563e = c1511j;
        AbstractC1544a<PointF, PointF> abstractC1544aMo773a = c1594i.f2794b.mo773a();
        this.f2564f = abstractC1544aMo773a;
        AbstractC1544a<PointF, PointF> abstractC1544aMo773a2 = c1594i.f2795c.mo773a();
        this.f2565g = abstractC1544aMo773a2;
        AbstractC1544a<Float, Float> abstractC1544aMo773a3 = c1594i.f2796d.mo773a();
        this.f2566h = abstractC1544aMo773a3;
        abstractC1603b.m777e(abstractC1544aMo773a);
        abstractC1603b.m777e(abstractC1544aMo773a2);
        abstractC1603b.m777e(abstractC1544aMo773a3);
        abstractC1544aMo773a.f2596a.add(this);
        abstractC1544aMo773a2.f2596a.add(this);
        abstractC1544aMo773a3.f2596a.add(this);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.b
    /* JADX INFO: renamed from: a */
    public void mo709a() {
        this.f2568j = false;
        this.f2563e.invalidateSelf();
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1527c
    /* JADX INFO: renamed from: b */
    public void mo710b(List<InterfaceC1527c> list, List<InterfaceC1527c> list2) {
        for (int i = 0; i < list.size(); i++) {
            InterfaceC1527c interfaceC1527c = list.get(i);
            if (interfaceC1527c instanceof C1543s) {
                C1543s c1543s = (C1543s) interfaceC1527c;
                if (c1543s.f2592c == 1) {
                    this.f2567i.f2481a.add(c1543s);
                    c1543s.f2591b.add(this);
                }
            }
        }
    }

    @Override // p007b.p085c.p086a.p095y.InterfaceC1568g
    /* JADX INFO: renamed from: c */
    public void mo711c(C1567f c1567f, int i, List<C1567f> list, C1567f c1567f2) {
        C1498f.m656f(c1567f, i, list, c1567f2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p085c.p086a.p095y.InterfaceC1568g
    /* JADX INFO: renamed from: g */
    public <T> void mo714g(T t, @Nullable C1503c<T> c1503c) {
        if (t == InterfaceC1516o.f2430h) {
            AbstractC1544a<?, PointF> abstractC1544a = this.f2565g;
            C1503c<PointF> c1503c2 = abstractC1544a.f2600e;
            abstractC1544a.f2600e = c1503c;
        } else if (t == InterfaceC1516o.f2432j) {
            AbstractC1544a<?, PointF> abstractC1544a2 = this.f2564f;
            C1503c<PointF> c1503c3 = abstractC1544a2.f2600e;
            abstractC1544a2.f2600e = c1503c;
        } else if (t == InterfaceC1516o.f2431i) {
            AbstractC1544a<?, Float> abstractC1544a3 = this.f2566h;
            C1503c<Float> c1503c4 = abstractC1544a3.f2600e;
            abstractC1544a3.f2600e = c1503c;
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1527c
    public String getName() {
        return this.f2561c;
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1537m
    public Path getPath() {
        if (this.f2568j) {
            return this.f2559a;
        }
        this.f2559a.reset();
        if (this.f2562d) {
            this.f2568j = true;
            return this.f2559a;
        }
        PointF pointFMo727e = this.f2565g.mo727e();
        float f = pointFMo727e.x / 2.0f;
        float f2 = pointFMo727e.y / 2.0f;
        AbstractC1544a<?, Float> abstractC1544a = this.f2566h;
        float fM739j = abstractC1544a == null ? 0.0f : ((C1546c) abstractC1544a).m739j();
        float fMin = Math.min(f, f2);
        if (fM739j > fMin) {
            fM739j = fMin;
        }
        PointF pointFMo727e2 = this.f2564f.mo727e();
        this.f2559a.moveTo(pointFMo727e2.x + f, (pointFMo727e2.y - f2) + fM739j);
        this.f2559a.lineTo(pointFMo727e2.x + f, (pointFMo727e2.y + f2) - fM739j);
        if (fM739j > 0.0f) {
            RectF rectF = this.f2560b;
            float f3 = pointFMo727e2.x;
            float f4 = fM739j * 2.0f;
            float f5 = pointFMo727e2.y;
            rectF.set((f3 + f) - f4, (f5 + f2) - f4, f3 + f, f5 + f2);
            this.f2559a.arcTo(this.f2560b, 0.0f, 90.0f, false);
        }
        this.f2559a.lineTo((pointFMo727e2.x - f) + fM739j, pointFMo727e2.y + f2);
        if (fM739j > 0.0f) {
            RectF rectF2 = this.f2560b;
            float f6 = pointFMo727e2.x;
            float f7 = pointFMo727e2.y;
            float f8 = fM739j * 2.0f;
            rectF2.set(f6 - f, (f7 + f2) - f8, (f6 - f) + f8, f7 + f2);
            this.f2559a.arcTo(this.f2560b, 90.0f, 90.0f, false);
        }
        this.f2559a.lineTo(pointFMo727e2.x - f, (pointFMo727e2.y - f2) + fM739j);
        if (fM739j > 0.0f) {
            RectF rectF3 = this.f2560b;
            float f9 = pointFMo727e2.x;
            float f10 = pointFMo727e2.y;
            float f11 = fM739j * 2.0f;
            rectF3.set(f9 - f, f10 - f2, (f9 - f) + f11, (f10 - f2) + f11);
            this.f2559a.arcTo(this.f2560b, 180.0f, 90.0f, false);
        }
        this.f2559a.lineTo((pointFMo727e2.x + f) - fM739j, pointFMo727e2.y - f2);
        if (fM739j > 0.0f) {
            RectF rectF4 = this.f2560b;
            float f12 = pointFMo727e2.x;
            float f13 = fM739j * 2.0f;
            float f14 = pointFMo727e2.y;
            rectF4.set((f12 + f) - f13, f14 - f2, f12 + f, (f14 - f2) + f13);
            this.f2559a.arcTo(this.f2560b, 270.0f, 90.0f, false);
        }
        this.f2559a.close();
        this.f2567i.m715a(this.f2559a);
        this.f2568j = true;
        return this.f2559a;
    }
}

package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.util.List;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.InterfaceC1516o;
import p007b.p085c.p086a.p089b0.C1498f;
import p007b.p085c.p086a.p090c0.C1503c;
import p007b.p085c.p086a.p091w.p093c.AbstractC1544a;
import p007b.p085c.p086a.p095y.C1567f;
import p007b.p085c.p086a.p095y.p097l.C1586a;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;

/* JADX INFO: renamed from: b.c.a.w.b.f */
/* JADX INFO: compiled from: EllipseContent.java */
/* JADX INFO: loaded from: classes.dex */
public class C1530f implements InterfaceC1537m, AbstractC1544a.b, InterfaceC1535k {

    /* JADX INFO: renamed from: b */
    public final String f2494b;

    /* JADX INFO: renamed from: c */
    public final C1511j f2495c;

    /* JADX INFO: renamed from: d */
    public final AbstractC1544a<?, PointF> f2496d;

    /* JADX INFO: renamed from: e */
    public final AbstractC1544a<?, PointF> f2497e;

    /* JADX INFO: renamed from: f */
    public final C1586a f2498f;

    /* JADX INFO: renamed from: h */
    public boolean f2500h;

    /* JADX INFO: renamed from: a */
    public final Path f2493a = new Path();

    /* JADX INFO: renamed from: g */
    public C1526b f2499g = new C1526b();

    public C1530f(C1511j c1511j, AbstractC1603b abstractC1603b, C1586a c1586a) {
        this.f2494b = c1586a.f2739a;
        this.f2495c = c1511j;
        AbstractC1544a<PointF, PointF> abstractC1544aMo773a = c1586a.f2741c.mo773a();
        this.f2496d = abstractC1544aMo773a;
        AbstractC1544a<PointF, PointF> abstractC1544aMo773a2 = c1586a.f2740b.mo773a();
        this.f2497e = abstractC1544aMo773a2;
        this.f2498f = c1586a;
        abstractC1603b.m777e(abstractC1544aMo773a);
        abstractC1603b.m777e(abstractC1544aMo773a2);
        abstractC1544aMo773a.f2596a.add(this);
        abstractC1544aMo773a2.f2596a.add(this);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.b
    /* JADX INFO: renamed from: a */
    public void mo709a() {
        this.f2500h = false;
        this.f2495c.invalidateSelf();
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1527c
    /* JADX INFO: renamed from: b */
    public void mo710b(List<InterfaceC1527c> list, List<InterfaceC1527c> list2) {
        for (int i = 0; i < list.size(); i++) {
            InterfaceC1527c interfaceC1527c = list.get(i);
            if (interfaceC1527c instanceof C1543s) {
                C1543s c1543s = (C1543s) interfaceC1527c;
                if (c1543s.f2592c == 1) {
                    this.f2499g.f2481a.add(c1543s);
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
        if (t == InterfaceC1516o.f2429g) {
            AbstractC1544a<?, PointF> abstractC1544a = this.f2496d;
            C1503c<PointF> c1503c2 = abstractC1544a.f2600e;
            abstractC1544a.f2600e = c1503c;
        } else if (t == InterfaceC1516o.f2432j) {
            AbstractC1544a<?, PointF> abstractC1544a2 = this.f2497e;
            C1503c<PointF> c1503c3 = abstractC1544a2.f2600e;
            abstractC1544a2.f2600e = c1503c;
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1527c
    public String getName() {
        return this.f2494b;
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1537m
    public Path getPath() {
        if (this.f2500h) {
            return this.f2493a;
        }
        this.f2493a.reset();
        if (this.f2498f.f2743e) {
            this.f2500h = true;
            return this.f2493a;
        }
        PointF pointFMo727e = this.f2496d.mo727e();
        float f = pointFMo727e.x / 2.0f;
        float f2 = pointFMo727e.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.f2493a.reset();
        if (this.f2498f.f2742d) {
            float f5 = -f2;
            this.f2493a.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.f2493a.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.f2493a.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.f2493a.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.f2493a.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.f2493a.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.f2493a.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.f2493a.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.f2493a.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.f2493a.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointFMo727e2 = this.f2497e.mo727e();
        this.f2493a.offset(pointFMo727e2.x, pointFMo727e2.y);
        this.f2493a.close();
        this.f2499g.m715a(this.f2493a);
        this.f2500h = true;
        return this.f2493a;
    }
}

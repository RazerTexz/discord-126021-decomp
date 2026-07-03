package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.InterfaceC1516o;
import p007b.p085c.p086a.p089b0.C1498f;
import p007b.p085c.p086a.p090c0.C1503c;
import p007b.p085c.p086a.p091w.p093c.AbstractC1544a;
import p007b.p085c.p086a.p091w.p093c.C1558o;
import p007b.p085c.p086a.p095y.C1567f;
import p007b.p085c.p086a.p095y.p096k.C1583l;
import p007b.p085c.p086a.p095y.p097l.C1595j;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;

/* JADX INFO: renamed from: b.c.a.w.b.p */
/* JADX INFO: compiled from: RepeaterContent.java */
/* JADX INFO: loaded from: classes.dex */
public class C1540p implements InterfaceC1529e, InterfaceC1537m, InterfaceC1534j, AbstractC1544a.b, InterfaceC1535k {

    /* JADX INFO: renamed from: a */
    public final Matrix f2569a = new Matrix();

    /* JADX INFO: renamed from: b */
    public final Path f2570b = new Path();

    /* JADX INFO: renamed from: c */
    public final C1511j f2571c;

    /* JADX INFO: renamed from: d */
    public final AbstractC1603b f2572d;

    /* JADX INFO: renamed from: e */
    public final String f2573e;

    /* JADX INFO: renamed from: f */
    public final boolean f2574f;

    /* JADX INFO: renamed from: g */
    public final AbstractC1544a<Float, Float> f2575g;

    /* JADX INFO: renamed from: h */
    public final AbstractC1544a<Float, Float> f2576h;

    /* JADX INFO: renamed from: i */
    public final C1558o f2577i;

    /* JADX INFO: renamed from: j */
    public C1528d f2578j;

    public C1540p(C1511j c1511j, AbstractC1603b abstractC1603b, C1595j c1595j) {
        this.f2571c = c1511j;
        this.f2572d = abstractC1603b;
        this.f2573e = c1595j.f2798a;
        this.f2574f = c1595j.f2802e;
        AbstractC1544a<Float, Float> abstractC1544aMo773a = c1595j.f2799b.mo773a();
        this.f2575g = abstractC1544aMo773a;
        abstractC1603b.m777e(abstractC1544aMo773a);
        abstractC1544aMo773a.f2596a.add(this);
        AbstractC1544a<Float, Float> abstractC1544aMo773a2 = c1595j.f2800c.mo773a();
        this.f2576h = abstractC1544aMo773a2;
        abstractC1603b.m777e(abstractC1544aMo773a2);
        abstractC1544aMo773a2.f2596a.add(this);
        C1583l c1583l = c1595j.f2801d;
        Objects.requireNonNull(c1583l);
        C1558o c1558o = new C1558o(c1583l);
        this.f2577i = c1558o;
        c1558o.m743a(abstractC1603b);
        c1558o.m744b(this);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.b
    /* JADX INFO: renamed from: a */
    public void mo709a() {
        this.f2571c.invalidateSelf();
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1527c
    /* JADX INFO: renamed from: b */
    public void mo710b(List<InterfaceC1527c> list, List<InterfaceC1527c> list2) {
        this.f2578j.mo710b(list, list2);
    }

    @Override // p007b.p085c.p086a.p095y.InterfaceC1568g
    /* JADX INFO: renamed from: c */
    public void mo711c(C1567f c1567f, int i, List<C1567f> list, C1567f c1567f2) {
        C1498f.m656f(c1567f, i, list, c1567f2, this);
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1529e
    /* JADX INFO: renamed from: d */
    public void mo712d(RectF rectF, Matrix matrix, boolean z2) {
        this.f2578j.mo712d(rectF, matrix, z2);
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1534j
    /* JADX INFO: renamed from: e */
    public void mo721e(ListIterator<InterfaceC1527c> listIterator) {
        if (this.f2578j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f2578j = new C1528d(this.f2571c, this.f2572d, "Repeater", this.f2574f, arrayList, null);
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1529e
    /* JADX INFO: renamed from: f */
    public void mo713f(Canvas canvas, Matrix matrix, int i) {
        float fFloatValue = this.f2575g.mo727e().floatValue();
        float fFloatValue2 = this.f2576h.mo727e().floatValue();
        float fFloatValue3 = this.f2577i.f2639m.mo727e().floatValue() / 100.0f;
        float fFloatValue4 = this.f2577i.f2640n.mo727e().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.f2569a.set(matrix);
            float f = i2;
            this.f2569a.preConcat(this.f2577i.m748f(f + fFloatValue2));
            this.f2578j.mo713f(canvas, this.f2569a, (int) (C1498f.m655e(fFloatValue3, fFloatValue4, f / fFloatValue) * i));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p085c.p086a.p095y.InterfaceC1568g
    /* JADX INFO: renamed from: g */
    public <T> void mo714g(T t, @Nullable C1503c<T> c1503c) {
        if (this.f2577i.m745c(t, c1503c)) {
            return;
        }
        if (t == InterfaceC1516o.f2439q) {
            AbstractC1544a<Float, Float> abstractC1544a = this.f2575g;
            C1503c<Float> c1503c2 = abstractC1544a.f2600e;
            abstractC1544a.f2600e = c1503c;
        } else if (t == InterfaceC1516o.f2440r) {
            AbstractC1544a<Float, Float> abstractC1544a2 = this.f2576h;
            C1503c<Float> c1503c3 = abstractC1544a2.f2600e;
            abstractC1544a2.f2600e = c1503c;
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1527c
    public String getName() {
        return this.f2573e;
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1537m
    public Path getPath() {
        Path path = this.f2578j.getPath();
        this.f2570b.reset();
        float fFloatValue = this.f2575g.mo727e().floatValue();
        float fFloatValue2 = this.f2576h.mo727e().floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.f2569a.set(this.f2577i.m748f(i + fFloatValue2));
            this.f2570b.addPath(path, this.f2569a);
        }
        return this.f2570b;
    }
}

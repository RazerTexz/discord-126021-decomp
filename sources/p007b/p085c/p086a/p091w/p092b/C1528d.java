package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.p089b0.C1499g;
import p007b.p085c.p086a.p090c0.C1503c;
import p007b.p085c.p086a.p091w.C1524a;
import p007b.p085c.p086a.p091w.p093c.AbstractC1544a;
import p007b.p085c.p086a.p091w.p093c.C1558o;
import p007b.p085c.p086a.p095y.C1567f;
import p007b.p085c.p086a.p095y.InterfaceC1568g;
import p007b.p085c.p086a.p095y.p096k.C1583l;
import p007b.p085c.p086a.p095y.p097l.C1598m;
import p007b.p085c.p086a.p095y.p097l.InterfaceC1587b;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;

/* JADX INFO: renamed from: b.c.a.w.b.d */
/* JADX INFO: compiled from: ContentGroup.java */
/* JADX INFO: loaded from: classes.dex */
public class C1528d implements InterfaceC1529e, InterfaceC1537m, AbstractC1544a.b, InterfaceC1568g {

    /* JADX INFO: renamed from: a */
    public Paint f2482a;

    /* JADX INFO: renamed from: b */
    public RectF f2483b;

    /* JADX INFO: renamed from: c */
    public final Matrix f2484c;

    /* JADX INFO: renamed from: d */
    public final Path f2485d;

    /* JADX INFO: renamed from: e */
    public final RectF f2486e;

    /* JADX INFO: renamed from: f */
    public final String f2487f;

    /* JADX INFO: renamed from: g */
    public final boolean f2488g;

    /* JADX INFO: renamed from: h */
    public final List<InterfaceC1527c> f2489h;

    /* JADX INFO: renamed from: i */
    public final C1511j f2490i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public List<InterfaceC1537m> f2491j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public C1558o f2492k;

    public C1528d(C1511j c1511j, AbstractC1603b abstractC1603b, C1598m c1598m) {
        C1583l c1583l;
        String str = c1598m.f2812a;
        boolean z2 = c1598m.f2814c;
        List<InterfaceC1587b> list = c1598m.f2813b;
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            InterfaceC1527c interfaceC1527cMo775a = list.get(i).mo775a(c1511j, abstractC1603b);
            if (interfaceC1527cMo775a != null) {
                arrayList.add(interfaceC1527cMo775a);
            }
        }
        List<InterfaceC1587b> list2 = c1598m.f2813b;
        for (int i2 = 0; i2 < list2.size(); i2++) {
            InterfaceC1587b interfaceC1587b = list2.get(i2);
            if (interfaceC1587b instanceof C1583l) {
                c1583l = (C1583l) interfaceC1587b;
                this(c1511j, abstractC1603b, str, z2, arrayList, c1583l);
            }
        }
        c1583l = null;
        this(c1511j, abstractC1603b, str, z2, arrayList, c1583l);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.b
    /* JADX INFO: renamed from: a */
    public void mo709a() {
        this.f2490i.invalidateSelf();
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1527c
    /* JADX INFO: renamed from: b */
    public void mo710b(List<InterfaceC1527c> list, List<InterfaceC1527c> list2) {
        ArrayList arrayList = new ArrayList(this.f2489h.size() + list.size());
        arrayList.addAll(list);
        for (int size = this.f2489h.size() - 1; size >= 0; size--) {
            InterfaceC1527c interfaceC1527c = this.f2489h.get(size);
            interfaceC1527c.mo710b(arrayList, this.f2489h.subList(0, size));
            arrayList.add(interfaceC1527c);
        }
    }

    @Override // p007b.p085c.p086a.p095y.InterfaceC1568g
    /* JADX INFO: renamed from: c */
    public void mo711c(C1567f c1567f, int i, List<C1567f> list, C1567f c1567f2) {
        if (c1567f.m770e(this.f2487f, i)) {
            if (!"__container".equals(this.f2487f)) {
                c1567f2 = c1567f2.m766a(this.f2487f);
                if (c1567f.m768c(this.f2487f, i)) {
                    list.add(c1567f2.m772g(this));
                }
            }
            if (c1567f.m771f(this.f2487f, i)) {
                int iM769d = c1567f.m769d(this.f2487f, i) + i;
                for (int i2 = 0; i2 < this.f2489h.size(); i2++) {
                    InterfaceC1527c interfaceC1527c = this.f2489h.get(i2);
                    if (interfaceC1527c instanceof InterfaceC1568g) {
                        ((InterfaceC1568g) interfaceC1527c).mo711c(c1567f, iM769d, list, c1567f2);
                    }
                }
            }
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1529e
    /* JADX INFO: renamed from: d */
    public void mo712d(RectF rectF, Matrix matrix, boolean z2) {
        this.f2484c.set(matrix);
        C1558o c1558o = this.f2492k;
        if (c1558o != null) {
            this.f2484c.preConcat(c1558o.m747e());
        }
        this.f2486e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f2489h.size() - 1; size >= 0; size--) {
            InterfaceC1527c interfaceC1527c = this.f2489h.get(size);
            if (interfaceC1527c instanceof InterfaceC1529e) {
                ((InterfaceC1529e) interfaceC1527c).mo712d(this.f2486e, this.f2484c, z2);
                rectF.union(this.f2486e);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public List<InterfaceC1537m> m716e() {
        if (this.f2491j == null) {
            this.f2491j = new ArrayList();
            for (int i = 0; i < this.f2489h.size(); i++) {
                InterfaceC1527c interfaceC1527c = this.f2489h.get(i);
                if (interfaceC1527c instanceof InterfaceC1537m) {
                    this.f2491j.add((InterfaceC1537m) interfaceC1527c);
                }
            }
        }
        return this.f2491j;
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1529e
    /* JADX INFO: renamed from: f */
    public void mo713f(Canvas canvas, Matrix matrix, int i) {
        boolean z2;
        if (this.f2488g) {
            return;
        }
        this.f2484c.set(matrix);
        C1558o c1558o = this.f2492k;
        if (c1558o != null) {
            this.f2484c.preConcat(c1558o.m747e());
            AbstractC1544a<Integer, Integer> abstractC1544a = this.f2492k.f2636j;
            i = (int) (((((abstractC1544a == null ? 100 : abstractC1544a.mo727e().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z3 = false;
        if (this.f2490i.f2366A) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= this.f2489h.size()) {
                    z2 = false;
                    break;
                } else {
                    if ((this.f2489h.get(i2) instanceof InterfaceC1529e) && (i3 = i3 + 1) >= 2) {
                        z2 = true;
                        break;
                    }
                    i2++;
                }
            }
            if (z2 && i != 255) {
                z3 = true;
            }
        }
        if (z3) {
            this.f2483b.set(0.0f, 0.0f, 0.0f, 0.0f);
            mo712d(this.f2483b, this.f2484c, true);
            this.f2482a.setAlpha(i);
            C1499g.m662f(canvas, this.f2483b, this.f2482a, 31);
        }
        if (z3) {
            i = 255;
        }
        for (int size = this.f2489h.size() - 1; size >= 0; size--) {
            InterfaceC1527c interfaceC1527c = this.f2489h.get(size);
            if (interfaceC1527c instanceof InterfaceC1529e) {
                ((InterfaceC1529e) interfaceC1527c).mo713f(canvas, this.f2484c, i);
            }
        }
        if (z3) {
            canvas.restore();
        }
    }

    @Override // p007b.p085c.p086a.p095y.InterfaceC1568g
    /* JADX INFO: renamed from: g */
    public <T> void mo714g(T t, @Nullable C1503c<T> c1503c) {
        C1558o c1558o = this.f2492k;
        if (c1558o != null) {
            c1558o.m745c(t, c1503c);
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1527c
    public String getName() {
        return this.f2487f;
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1537m
    public Path getPath() {
        this.f2484c.reset();
        C1558o c1558o = this.f2492k;
        if (c1558o != null) {
            this.f2484c.set(c1558o.m747e());
        }
        this.f2485d.reset();
        if (this.f2488g) {
            return this.f2485d;
        }
        for (int size = this.f2489h.size() - 1; size >= 0; size--) {
            InterfaceC1527c interfaceC1527c = this.f2489h.get(size);
            if (interfaceC1527c instanceof InterfaceC1537m) {
                this.f2485d.addPath(((InterfaceC1537m) interfaceC1527c).getPath(), this.f2484c);
            }
        }
        return this.f2485d;
    }

    public C1528d(C1511j c1511j, AbstractC1603b abstractC1603b, String str, boolean z2, List<InterfaceC1527c> list, @Nullable C1583l c1583l) {
        this.f2482a = new C1524a();
        this.f2483b = new RectF();
        this.f2484c = new Matrix();
        this.f2485d = new Path();
        this.f2486e = new RectF();
        this.f2487f = str;
        this.f2490i = c1511j;
        this.f2488g = z2;
        this.f2489h = list;
        if (c1583l != null) {
            C1558o c1558o = new C1558o(c1583l);
            this.f2492k = c1558o;
            c1558o.m743a(abstractC1603b);
            this.f2492k.m744b(this);
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            InterfaceC1527c interfaceC1527c = list.get(size);
            if (interfaceC1527c instanceof InterfaceC1534j) {
                arrayList.add((InterfaceC1534j) interfaceC1527c);
            }
        }
        int size2 = arrayList.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                return;
            } else {
                ((InterfaceC1534j) arrayList.get(size2)).mo721e(list.listIterator(list.size()));
            }
        }
    }
}

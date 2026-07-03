package p007b.p109f.p132g.p133a.p134a;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import p007b.p109f.p132g.p142e.C1775i;
import p007b.p109f.p161j.p174i.InterfaceC1914a;
import p007b.p109f.p161j.p175j.AbstractC1917c;
import p007b.p109f.p161j.p175j.C1918d;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: renamed from: b.f.g.a.a.a */
/* JADX INFO: compiled from: DefaultDrawableFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class C1730a implements InterfaceC1914a {

    /* JADX INFO: renamed from: a */
    public final Resources f3166a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1914a f3167b;

    public C1730a(Resources resources, InterfaceC1914a interfaceC1914a) {
        this.f3166a = resources;
        this.f3167b = interfaceC1914a;
    }

    @Override // p007b.p109f.p161j.p174i.InterfaceC1914a
    /* JADX INFO: renamed from: a */
    public boolean mo1035a(AbstractC1917c abstractC1917c) {
        return true;
    }

    @Override // p007b.p109f.p161j.p174i.InterfaceC1914a
    /* JADX INFO: renamed from: b */
    public Drawable mo1036b(AbstractC1917c abstractC1917c) {
        try {
            C2030b.m1527b();
            if (!(abstractC1917c instanceof C1918d)) {
                InterfaceC1914a interfaceC1914a = this.f3167b;
                if (interfaceC1914a == null || !interfaceC1914a.mo1035a(abstractC1917c)) {
                    return null;
                }
                return this.f3167b.mo1036b(abstractC1917c);
            }
            C1918d c1918d = (C1918d) abstractC1917c;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f3166a, c1918d.f3887m);
            int i = c1918d.f3889o;
            if (!((i == 0 || i == -1) ? false : true)) {
                int i2 = c1918d.f3890p;
                if (!((i2 == 1 || i2 == 0) ? false : true)) {
                    return bitmapDrawable;
                }
            }
            return new C1775i(bitmapDrawable, c1918d.f3889o, c1918d.f3890p);
        } finally {
            C2030b.m1527b();
        }
    }
}

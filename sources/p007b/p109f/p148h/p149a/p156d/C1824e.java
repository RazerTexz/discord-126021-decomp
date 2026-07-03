package p007b.p109f.p148h.p149a.p156d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import p007b.p109f.p115d.p126k.InterfaceC1714b;
import p007b.p109f.p148h.p149a.p150a.C1803c;
import p007b.p109f.p148h.p149a.p151b.C1805a;
import p007b.p109f.p148h.p149a.p151b.InterfaceC1806b;
import p007b.p109f.p148h.p149a.p151b.p152d.C1808a;
import p007b.p109f.p148h.p149a.p151b.p152d.C1809b;
import p007b.p109f.p148h.p149a.p151b.p152d.C1810c;
import p007b.p109f.p148h.p149a.p151b.p152d.C1811d;
import p007b.p109f.p148h.p149a.p151b.p153e.C1814c;
import p007b.p109f.p148h.p149a.p151b.p153e.C1815d;
import p007b.p109f.p148h.p149a.p151b.p154f.C1816a;
import p007b.p109f.p148h.p149a.p151b.p154f.C1817b;
import p007b.p109f.p148h.p149a.p155c.C1818a;
import p007b.p109f.p161j.p162a.p163a.C1838e;
import p007b.p109f.p161j.p162a.p163a.InterfaceC1834a;
import p007b.p109f.p161j.p162a.p163a.InterfaceC1836c;
import p007b.p109f.p161j.p162a.p165c.C1847c;
import p007b.p109f.p161j.p162a.p165c.InterfaceC1846b;
import p007b.p109f.p161j.p168c.InterfaceC1866m;
import p007b.p109f.p161j.p174i.InterfaceC1914a;
import p007b.p109f.p161j.p175j.AbstractC1917c;
import p007b.p109f.p161j.p175j.C1915a;

/* JADX INFO: renamed from: b.f.h.a.d.e */
/* JADX INFO: compiled from: ExperimentalBitmapAnimationDrawableFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class C1824e implements InterfaceC1914a {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1846b f3552a;

    /* JADX INFO: renamed from: b */
    public final ScheduledExecutorService f3553b;

    /* JADX INFO: renamed from: c */
    public final ExecutorService f3554c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC1714b f3555d;

    /* JADX INFO: renamed from: e */
    public final PlatformBitmapFactory f3556e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC1866m<CacheKey, AbstractC1917c> f3557f;

    /* JADX INFO: renamed from: g */
    public final Supplier<Integer> f3558g;

    /* JADX INFO: renamed from: h */
    public final Supplier<Integer> f3559h;

    /* JADX INFO: renamed from: i */
    public final Supplier<Boolean> f3560i;

    public C1824e(InterfaceC1846b interfaceC1846b, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, InterfaceC1714b interfaceC1714b, PlatformBitmapFactory platformBitmapFactory, InterfaceC1866m<CacheKey, AbstractC1917c> interfaceC1866m, Supplier<Integer> supplier, Supplier<Integer> supplier2, Supplier<Boolean> supplier3) {
        this.f3552a = interfaceC1846b;
        this.f3553b = scheduledExecutorService;
        this.f3554c = executorService;
        this.f3555d = interfaceC1714b;
        this.f3556e = platformBitmapFactory;
        this.f3557f = interfaceC1866m;
        this.f3558g = supplier;
        this.f3559h = supplier2;
        this.f3560i = supplier3;
    }

    @Override // p007b.p109f.p161j.p174i.InterfaceC1914a
    /* JADX INFO: renamed from: a */
    public boolean mo1035a(AbstractC1917c abstractC1917c) {
        return abstractC1917c instanceof C1915a;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x007d  */
    /* JADX WARN: Code duplicated, block: B:33:0x0089  */
    /* JADX WARN: Code duplicated, block: B:35:0x0093  */
    @Override // p007b.p109f.p161j.p174i.InterfaceC1914a
    /* JADX INFO: renamed from: b */
    public Drawable mo1036b(AbstractC1917c abstractC1917c) {
        InterfaceC1836c interfaceC1836c;
        C1838e c1838e;
        C1809b c1809b;
        InterfaceC1806b c1811d;
        C1817b c1817b;
        int iIntValue;
        C1815d c1815d;
        C1814c c1814c;
        C1915a c1915a = (C1915a) abstractC1917c;
        synchronized (c1915a) {
            C1838e c1838e2 = c1915a.f3882l;
            interfaceC1836c = c1838e2 == null ? null : c1838e2.f3609a;
        }
        synchronized (c1915a) {
            c1838e = c1915a.f3882l;
        }
        Objects.requireNonNull(c1838e);
        Bitmap.Config configMo1179d = interfaceC1836c != null ? interfaceC1836c.mo1179d() : null;
        InterfaceC1836c interfaceC1836c2 = c1838e.f3609a;
        InterfaceC1834a interfaceC1834aMo1164a = this.f3552a.mo1164a(c1838e, new Rect(0, 0, interfaceC1836c2.getWidth(), interfaceC1836c2.getHeight()));
        int iIntValue2 = this.f3558g.get().intValue();
        if (iIntValue2 != 1) {
            if (iIntValue2 != 2) {
                c1811d = iIntValue2 != 3 ? new C1811d() : new C1810c();
            } else {
                c1809b = new C1809b(m1165c(c1838e), false);
            }
            InterfaceC1806b interfaceC1806b = c1811d;
            c1817b = new C1817b(interfaceC1806b, interfaceC1834aMo1164a);
            iIntValue = this.f3559h.get().intValue();
            if (iIntValue > 0) {
                C1815d c1815d2 = new C1815d(iIntValue);
                PlatformBitmapFactory platformBitmapFactory = this.f3556e;
                if (configMo1179d == null) {
                    configMo1179d = Bitmap.Config.ARGB_8888;
                }
                c1815d = c1815d2;
                c1814c = new C1814c(platformBitmapFactory, c1817b, configMo1179d, this.f3554c);
            } else {
                c1815d = null;
                c1814c = null;
            }
            C1805a c1805a = new C1805a(this.f3556e, interfaceC1806b, new C1816a(interfaceC1834aMo1164a), c1817b, c1815d, c1814c);
            return new C1818a(new C1803c(c1805a, c1805a, this.f3555d, this.f3553b));
        }
        c1809b = new C1809b(m1165c(c1838e), true);
        c1811d = c1809b;
        InterfaceC1806b interfaceC1806b2 = c1811d;
        c1817b = new C1817b(interfaceC1806b2, interfaceC1834aMo1164a);
        iIntValue = this.f3559h.get().intValue();
        if (iIntValue > 0) {
            C1815d c1815d3 = new C1815d(iIntValue);
            PlatformBitmapFactory platformBitmapFactory2 = this.f3556e;
            if (configMo1179d == null) {
                configMo1179d = Bitmap.Config.ARGB_8888;
            }
            c1815d = c1815d3;
            c1814c = new C1814c(platformBitmapFactory2, c1817b, configMo1179d, this.f3554c);
        } else {
            c1815d = null;
            c1814c = null;
        }
        C1805a c1805a2 = new C1805a(this.f3556e, interfaceC1806b2, new C1816a(interfaceC1834aMo1164a), c1817b, c1815d, c1814c);
        return new C1818a(new C1803c(c1805a2, c1805a2, this.f3555d, this.f3553b));
    }

    /* JADX INFO: renamed from: c */
    public final C1847c m1165c(C1838e c1838e) {
        return new C1847c(new C1808a(c1838e.hashCode(), Boolean.FALSE.booleanValue()), this.f3557f);
    }
}

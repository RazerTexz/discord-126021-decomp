package p007b.p109f.p161j.p162a.p164b;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Objects;
import p007b.p109f.p161j.p162a.p163a.C1839f;
import p007b.p109f.p161j.p162a.p163a.InterfaceC1836c;
import p007b.p109f.p161j.p162a.p165c.InterfaceC1846b;
import p007b.p109f.p161j.p169d.C1881b;
import p007b.p109f.p161j.p175j.AbstractC1917c;
import p007b.p109f.p161j.p175j.C1915a;

/* JADX INFO: renamed from: b.f.j.a.b.e */
/* JADX INFO: compiled from: AnimatedImageFactoryImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class C1844e implements InterfaceC1843d {

    /* JADX INFO: renamed from: a */
    public static InterfaceC1842c f3620a;

    /* JADX INFO: renamed from: b */
    public static InterfaceC1842c f3621b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC1846b f3622c;

    /* JADX INFO: renamed from: d */
    public final PlatformBitmapFactory f3623d;

    static {
        InterfaceC1842c interfaceC1842c;
        InterfaceC1842c interfaceC1842c2 = null;
        try {
            interfaceC1842c = (InterfaceC1842c) Class.forName("com.facebook.animated.gif.GifImage").newInstance();
        } catch (Throwable unused) {
            interfaceC1842c = null;
        }
        f3620a = interfaceC1842c;
        try {
            interfaceC1842c2 = (InterfaceC1842c) Class.forName("com.facebook.animated.webp.WebPImage").newInstance();
        } catch (Throwable unused2) {
        }
        f3621b = interfaceC1842c2;
    }

    public C1844e(InterfaceC1846b interfaceC1846b, PlatformBitmapFactory platformBitmapFactory) {
        this.f3622c = interfaceC1846b;
        this.f3623d = platformBitmapFactory;
    }

    /* JADX INFO: renamed from: a */
    public final AbstractC1917c m1194a(C1881b c1881b, InterfaceC1836c interfaceC1836c, Bitmap.Config config) {
        try {
            Objects.requireNonNull(c1881b);
            C1839f c1839f = new C1839f(interfaceC1836c);
            c1839f.f3614b = CloseableReference.m8636n(null);
            c1839f.f3616d = 0;
            c1839f.f3615c = CloseableReference.m8637q(null);
            c1839f.f3617e = null;
            return new C1915a(c1839f.m1188a());
        } finally {
            Class<CloseableReference> cls = CloseableReference.f19438j;
            CloseableReference.m8639t(null);
        }
    }
}

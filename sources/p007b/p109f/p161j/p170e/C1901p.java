package p007b.p109f.p161j.p170e;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import p007b.p109f.p115d.p122g.InterfaceC1694a;
import p007b.p109f.p115d.p122g.InterfaceC1700g;
import p007b.p109f.p161j.p168c.C1857d;
import p007b.p109f.p161j.p168c.C1859f;
import p007b.p109f.p161j.p168c.InterfaceC1862i;
import p007b.p109f.p161j.p168c.InterfaceC1876w;
import p007b.p109f.p161j.p173h.InterfaceC1909b;
import p007b.p109f.p161j.p173h.InterfaceC1911d;
import p007b.p109f.p161j.p175j.AbstractC1917c;
import p007b.p109f.p161j.p175j.C1919e;
import p007b.p109f.p161j.p181p.C1970c1;
import p007b.p109f.p161j.p181p.InterfaceC2018w0;
import p007b.p109f.p161j.p184s.InterfaceC2033c;

/* JADX INFO: renamed from: b.f.j.e.p */
/* JADX INFO: compiled from: ProducerFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class C1901p {

    /* JADX INFO: renamed from: a */
    public ContentResolver f3815a;

    /* JADX INFO: renamed from: b */
    public Resources f3816b;

    /* JADX INFO: renamed from: c */
    public AssetManager f3817c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC1694a f3818d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC1909b f3819e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC1911d f3820f;

    /* JADX INFO: renamed from: g */
    public final boolean f3821g;

    /* JADX INFO: renamed from: h */
    public final boolean f3822h;

    /* JADX INFO: renamed from: i */
    public final boolean f3823i;

    /* JADX INFO: renamed from: j */
    public final InterfaceC1890e f3824j;

    /* JADX INFO: renamed from: k */
    public final InterfaceC1700g f3825k;

    /* JADX INFO: renamed from: l */
    public final C1859f f3826l;

    /* JADX INFO: renamed from: m */
    public final C1859f f3827m;

    /* JADX INFO: renamed from: n */
    public final InterfaceC1876w<CacheKey, PooledByteBuffer> f3828n;

    /* JADX INFO: renamed from: o */
    public final InterfaceC1876w<CacheKey, AbstractC1917c> f3829o;

    /* JADX INFO: renamed from: p */
    public final InterfaceC1862i f3830p;

    /* JADX INFO: renamed from: q */
    public final C1857d<CacheKey> f3831q;

    /* JADX INFO: renamed from: r */
    public final C1857d<CacheKey> f3832r;

    /* JADX INFO: renamed from: s */
    public final PlatformBitmapFactory f3833s;

    /* JADX INFO: renamed from: t */
    public final int f3834t;

    /* JADX INFO: renamed from: u */
    public final int f3835u;

    /* JADX INFO: renamed from: v */
    public boolean f3836v;

    /* JADX INFO: renamed from: w */
    public final C1886a f3837w;

    /* JADX INFO: renamed from: x */
    public final int f3838x;

    /* JADX INFO: renamed from: y */
    public final boolean f3839y;

    public C1901p(Context context, InterfaceC1694a interfaceC1694a, InterfaceC1909b interfaceC1909b, InterfaceC1911d interfaceC1911d, boolean z2, boolean z3, boolean z4, InterfaceC1890e interfaceC1890e, InterfaceC1700g interfaceC1700g, InterfaceC1876w<CacheKey, AbstractC1917c> interfaceC1876w, InterfaceC1876w<CacheKey, PooledByteBuffer> interfaceC1876w2, C1859f c1859f, C1859f c1859f2, InterfaceC1862i interfaceC1862i, PlatformBitmapFactory platformBitmapFactory, int i, int i2, boolean z5, int i3, C1886a c1886a, boolean z6, int i4) {
        this.f3815a = context.getApplicationContext().getContentResolver();
        this.f3816b = context.getApplicationContext().getResources();
        this.f3817c = context.getApplicationContext().getAssets();
        this.f3818d = interfaceC1694a;
        this.f3819e = interfaceC1909b;
        this.f3820f = interfaceC1911d;
        this.f3821g = z2;
        this.f3822h = z3;
        this.f3823i = z4;
        this.f3824j = interfaceC1890e;
        this.f3825k = interfaceC1700g;
        this.f3829o = interfaceC1876w;
        this.f3828n = interfaceC1876w2;
        this.f3826l = c1859f;
        this.f3827m = c1859f2;
        this.f3830p = interfaceC1862i;
        this.f3833s = platformBitmapFactory;
        this.f3831q = new C1857d<>(i4);
        this.f3832r = new C1857d<>(i4);
        this.f3834t = i;
        this.f3835u = i2;
        this.f3836v = z5;
        this.f3838x = i3;
        this.f3837w = c1886a;
        this.f3839y = z6;
    }

    /* JADX INFO: renamed from: a */
    public C1970c1 m1304a(InterfaceC2018w0<C1919e> interfaceC2018w0, boolean z2, InterfaceC2033c interfaceC2033c) {
        return new C1970c1(this.f3824j.mo1256c(), this.f3825k, interfaceC2018w0, z2, interfaceC2033c);
    }
}

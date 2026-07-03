package com.facebook.fresco.animation.factory;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import p007b.p109f.p115d.p117b.C1672c;
import p007b.p109f.p115d.p117b.C1676g;
import p007b.p109f.p115d.p117b.InterfaceExecutorServiceC1675f;
import p007b.p109f.p115d.p119d.C1689l;
import p007b.p109f.p115d.p119d.InterfaceC1680c;
import p007b.p109f.p148h.p149a.p156d.C1820a;
import p007b.p109f.p148h.p149a.p156d.C1821b;
import p007b.p109f.p148h.p149a.p156d.C1822c;
import p007b.p109f.p148h.p149a.p156d.C1823d;
import p007b.p109f.p148h.p149a.p156d.C1824e;
import p007b.p109f.p161j.p162a.p164b.C1844e;
import p007b.p109f.p161j.p162a.p164b.InterfaceC1840a;
import p007b.p109f.p161j.p162a.p164b.InterfaceC1843d;
import p007b.p109f.p161j.p162a.p165c.InterfaceC1846b;
import p007b.p109f.p161j.p162a.p166d.C1849a;
import p007b.p109f.p161j.p168c.InterfaceC1866m;
import p007b.p109f.p161j.p169d.C1881b;
import p007b.p109f.p161j.p170e.InterfaceC1890e;
import p007b.p109f.p161j.p173h.InterfaceC1909b;
import p007b.p109f.p161j.p174i.InterfaceC1914a;
import p007b.p109f.p161j.p175j.AbstractC1917c;
import p007b.p109f.p161j.p175j.C1919e;
import p007b.p109f.p161j.p175j.InterfaceC1923i;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC1680c
public class AnimatedFactoryV2Impl implements InterfaceC1840a {

    /* JADX INFO: renamed from: a */
    public final PlatformBitmapFactory f19531a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1890e f19532b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC1866m<CacheKey, AbstractC1917c> f19533c;

    /* JADX INFO: renamed from: d */
    public final boolean f19534d;

    /* JADX INFO: renamed from: e */
    public InterfaceC1843d f19535e;

    /* JADX INFO: renamed from: f */
    public InterfaceC1846b f19536f;

    /* JADX INFO: renamed from: g */
    public C1849a f19537g;

    /* JADX INFO: renamed from: h */
    public InterfaceC1914a f19538h;

    /* JADX INFO: renamed from: i */
    public InterfaceExecutorServiceC1675f f19539i;

    /* JADX INFO: renamed from: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl$a */
    public class C10650a implements InterfaceC1909b {
        public C10650a() {
        }

        @Override // p007b.p109f.p161j.p173h.InterfaceC1909b
        /* JADX INFO: renamed from: a */
        public AbstractC1917c mo1322a(C1919e c1919e, int i, InterfaceC1923i interfaceC1923i, C1881b c1881b) {
            AnimatedFactoryV2Impl animatedFactoryV2Impl = AnimatedFactoryV2Impl.this;
            if (animatedFactoryV2Impl.f19535e == null) {
                animatedFactoryV2Impl.f19535e = new C1844e(new C1823d(animatedFactoryV2Impl), animatedFactoryV2Impl.f19531a);
            }
            InterfaceC1843d interfaceC1843d = animatedFactoryV2Impl.f19535e;
            Bitmap.Config config = c1881b.f3710e;
            C1844e c1844e = (C1844e) interfaceC1843d;
            Objects.requireNonNull(c1844e);
            if (C1844e.f3620a == null) {
                throw new UnsupportedOperationException("To encode animated gif please add the dependency to the animated-gif module");
            }
            CloseableReference<PooledByteBuffer> closeableReferenceM1340c = c1919e.m1340c();
            Objects.requireNonNull(closeableReferenceM1340c);
            try {
                PooledByteBuffer pooledByteBufferM8642u = closeableReferenceM1340c.m8642u();
                return c1844e.m1194a(c1881b, pooledByteBufferM8642u.getByteBuffer() != null ? C1844e.f3620a.mo1192c(pooledByteBufferM8642u.getByteBuffer(), c1881b) : C1844e.f3620a.mo1193h(pooledByteBufferM8642u.mo1397k(), pooledByteBufferM8642u.size(), c1881b), config);
            } finally {
                closeableReferenceM1340c.close();
            }
        }
    }

    /* JADX INFO: renamed from: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl$b */
    public class C10651b implements InterfaceC1909b {
        public C10651b() {
        }

        @Override // p007b.p109f.p161j.p173h.InterfaceC1909b
        /* JADX INFO: renamed from: a */
        public AbstractC1917c mo1322a(C1919e c1919e, int i, InterfaceC1923i interfaceC1923i, C1881b c1881b) {
            AnimatedFactoryV2Impl animatedFactoryV2Impl = AnimatedFactoryV2Impl.this;
            if (animatedFactoryV2Impl.f19535e == null) {
                animatedFactoryV2Impl.f19535e = new C1844e(new C1823d(animatedFactoryV2Impl), animatedFactoryV2Impl.f19531a);
            }
            InterfaceC1843d interfaceC1843d = animatedFactoryV2Impl.f19535e;
            Bitmap.Config config = c1881b.f3710e;
            C1844e c1844e = (C1844e) interfaceC1843d;
            Objects.requireNonNull(c1844e);
            if (C1844e.f3621b == null) {
                throw new UnsupportedOperationException("To encode animated webp please add the dependency to the animated-webp module");
            }
            CloseableReference<PooledByteBuffer> closeableReferenceM1340c = c1919e.m1340c();
            Objects.requireNonNull(closeableReferenceM1340c);
            try {
                PooledByteBuffer pooledByteBufferM8642u = closeableReferenceM1340c.m8642u();
                return c1844e.m1194a(c1881b, pooledByteBufferM8642u.getByteBuffer() != null ? C1844e.f3621b.mo1192c(pooledByteBufferM8642u.getByteBuffer(), c1881b) : C1844e.f3621b.mo1193h(pooledByteBufferM8642u.mo1397k(), pooledByteBufferM8642u.size(), c1881b), config);
            } finally {
                closeableReferenceM1340c.close();
            }
        }
    }

    @InterfaceC1680c
    public AnimatedFactoryV2Impl(PlatformBitmapFactory platformBitmapFactory, InterfaceC1890e interfaceC1890e, InterfaceC1866m<CacheKey, AbstractC1917c> interfaceC1866m, boolean z2, InterfaceExecutorServiceC1675f interfaceExecutorServiceC1675f) {
        this.f19531a = platformBitmapFactory;
        this.f19532b = interfaceC1890e;
        this.f19533c = interfaceC1866m;
        this.f19534d = z2;
        this.f19539i = interfaceExecutorServiceC1675f;
    }

    @Override // p007b.p109f.p161j.p162a.p164b.InterfaceC1840a
    /* JADX INFO: renamed from: a */
    public InterfaceC1914a mo1189a(Context context) {
        if (this.f19538h == null) {
            C1820a c1820a = new C1820a(this);
            ExecutorService c1672c = this.f19539i;
            if (c1672c == null) {
                c1672c = new C1672c(this.f19532b.mo1254a());
            }
            ExecutorService executorService = c1672c;
            C1821b c1821b = new C1821b(this);
            Supplier<Boolean> supplier = C1689l.f3101a;
            if (this.f19536f == null) {
                this.f19536f = new C1822c(this);
            }
            InterfaceC1846b interfaceC1846b = this.f19536f;
            if (C1676g.f3090k == null) {
                C1676g.f3090k = new C1676g();
            }
            this.f19538h = new C1824e(interfaceC1846b, C1676g.f3090k, executorService, RealtimeSinceBootClock.get(), this.f19531a, this.f19533c, c1820a, c1821b, supplier);
        }
        return this.f19538h;
    }

    @Override // p007b.p109f.p161j.p162a.p164b.InterfaceC1840a
    /* JADX INFO: renamed from: b */
    public InterfaceC1909b mo1190b() {
        return new C10650a();
    }

    @Override // p007b.p109f.p161j.p162a.p164b.InterfaceC1840a
    /* JADX INFO: renamed from: c */
    public InterfaceC1909b mo1191c() {
        return new C10651b();
    }
}

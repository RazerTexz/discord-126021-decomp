package p007b.p109f.p161j.p181p;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.Closeable;
import p007b.p109f.p161j.p168c.C1867n;
import p007b.p109f.p161j.p168c.InterfaceC1862i;
import p007b.p109f.p161j.p175j.AbstractC1917c;

/* JADX INFO: renamed from: b.f.j.p.g */
/* JADX INFO: compiled from: BitmapMemoryCacheKeyMultiplexProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1980g extends AbstractC1996l0<Pair<CacheKey, ImageRequest.EnumC10667c>, CloseableReference<AbstractC1917c>> {

    /* JADX INFO: renamed from: f */
    public final InterfaceC1862i f4059f;

    public C1980g(InterfaceC1862i interfaceC1862i, InterfaceC2018w0 interfaceC2018w0) {
        super(interfaceC2018w0, "BitmapMemoryCacheKeyMultiplexProducer", "multiplex_bmp_cnt");
        this.f4059f = interfaceC1862i;
    }

    @Override // p007b.p109f.p161j.p181p.AbstractC1996l0
    /* JADX INFO: renamed from: c */
    public Closeable mo1476c(Closeable closeable) {
        return CloseableReference.m8636n((CloseableReference) closeable);
    }

    @Override // p007b.p109f.p161j.p181p.AbstractC1996l0
    /* JADX INFO: renamed from: d */
    public Pair<CacheKey, ImageRequest.EnumC10667c> mo1477d(InterfaceC2020x0 interfaceC2020x0) {
        return Pair.create(((C1867n) this.f4059f).m1229a(interfaceC2020x0.mo1447e(), interfaceC2020x0.mo1444b()), interfaceC2020x0.mo1459q());
    }
}

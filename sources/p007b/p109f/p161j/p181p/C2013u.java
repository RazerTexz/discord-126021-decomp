package p007b.p109f.p161j.p181p;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.Closeable;
import p007b.p109f.p161j.p168c.C1867n;
import p007b.p109f.p161j.p168c.InterfaceC1862i;
import p007b.p109f.p161j.p175j.C1919e;

/* JADX INFO: renamed from: b.f.j.p.u */
/* JADX INFO: compiled from: EncodedCacheKeyMultiplexProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2013u extends AbstractC1996l0<Pair<CacheKey, ImageRequest.EnumC10667c>, C1919e> {

    /* JADX INFO: renamed from: f */
    public final InterfaceC1862i f4236f;

    public C2013u(InterfaceC1862i interfaceC1862i, boolean z2, InterfaceC2018w0 interfaceC2018w0) {
        super(interfaceC2018w0, "EncodedCacheKeyMultiplexProducer", "multiplex_enc_cnt", z2);
        this.f4236f = interfaceC1862i;
    }

    @Override // p007b.p109f.p161j.p181p.AbstractC1996l0
    /* JADX INFO: renamed from: c */
    public Closeable mo1476c(Closeable closeable) {
        return C1919e.m1336a((C1919e) closeable);
    }

    @Override // p007b.p109f.p161j.p181p.AbstractC1996l0
    /* JADX INFO: renamed from: d */
    public Pair<CacheKey, ImageRequest.EnumC10667c> mo1477d(InterfaceC2020x0 interfaceC2020x0) {
        return Pair.create(((C1867n) this.f4236f).m1230b(interfaceC2020x0.mo1447e(), interfaceC2020x0.mo1444b()), interfaceC2020x0.mo1459q());
    }
}

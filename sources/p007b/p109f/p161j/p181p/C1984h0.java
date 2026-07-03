package p007b.p109f.p161j.p181p;

import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import p007b.p109f.p115d.p122g.InterfaceC1700g;
import p007b.p109f.p161j.p175j.C1919e;

/* JADX INFO: renamed from: b.f.j.p.h0 */
/* JADX INFO: compiled from: LocalFileFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1984h0 extends AbstractC1981g0 {
    public C1984h0(Executor executor, InterfaceC1700g interfaceC1700g) {
        super(executor, interfaceC1700g);
    }

    @Override // p007b.p109f.p161j.p181p.AbstractC1981g0
    /* JADX INFO: renamed from: d */
    public C1919e mo1428d(ImageRequest imageRequest) throws IOException {
        return m1478c(new FileInputStream(imageRequest.m8719a().toString()), (int) imageRequest.m8719a().length());
    }

    @Override // p007b.p109f.p161j.p181p.AbstractC1981g0
    /* JADX INFO: renamed from: e */
    public String mo1429e() {
        return "LocalFileFetchProducer";
    }
}

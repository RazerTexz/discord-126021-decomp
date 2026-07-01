package b.f.j.p;

import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: LocalFileFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class h0 extends g0 {
    public h0(Executor executor, b.f.d.g.g gVar) {
        super(executor, gVar);
    }

    @Override // b.f.j.p.g0
    public b.f.j.j.e d(ImageRequest imageRequest) throws IOException {
        return c(new FileInputStream(imageRequest.a().toString()), (int) imageRequest.a().length());
    }

    @Override // b.f.j.p.g0
    public String e() {
        return "LocalFileFetchProducer";
    }
}

package b.f.j.p;

import android.content.ContentResolver;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: QualifiedResourceFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class b1 extends g0 {
    public final ContentResolver c;

    public b1(Executor executor, b.f.d.g.g gVar, ContentResolver contentResolver) {
        super(executor, gVar);
        this.c = contentResolver;
    }

    @Override // b.f.j.p.g0
    public b.f.j.j.e d(ImageRequest imageRequest) throws IOException {
        InputStream inputStreamOpenInputStream = this.c.openInputStream(imageRequest.c);
        b.c.a.a0.d.y(inputStreamOpenInputStream, "ContentResolver returned null InputStream");
        return c(inputStreamOpenInputStream, -1);
    }

    @Override // b.f.j.p.g0
    public String e() {
        return "QualifiedResourceFetchProducer";
    }
}

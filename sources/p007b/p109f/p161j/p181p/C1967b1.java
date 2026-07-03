package p007b.p109f.p161j.p181p;

import android.content.ContentResolver;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p122g.InterfaceC1700g;
import p007b.p109f.p161j.p175j.C1919e;

/* JADX INFO: renamed from: b.f.j.p.b1 */
/* JADX INFO: compiled from: QualifiedResourceFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1967b1 extends AbstractC1981g0 {

    /* JADX INFO: renamed from: c */
    public final ContentResolver f3998c;

    public C1967b1(Executor executor, InterfaceC1700g interfaceC1700g, ContentResolver contentResolver) {
        super(executor, interfaceC1700g);
        this.f3998c = contentResolver;
    }

    @Override // p007b.p109f.p161j.p181p.AbstractC1981g0
    /* JADX INFO: renamed from: d */
    public C1919e mo1428d(ImageRequest imageRequest) throws IOException {
        InputStream inputStreamOpenInputStream = this.f3998c.openInputStream(imageRequest.f19585c);
        C1460d.m591y(inputStreamOpenInputStream, "ContentResolver returned null InputStream");
        return m1478c(inputStreamOpenInputStream, -1);
    }

    @Override // p007b.p109f.p161j.p181p.AbstractC1981g0
    /* JADX INFO: renamed from: e */
    public String mo1429e() {
        return "QualifiedResourceFetchProducer";
    }
}

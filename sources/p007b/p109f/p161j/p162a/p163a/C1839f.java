package p007b.p109f.p161j.p162a.p163a;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.List;
import p007b.p109f.p161j.p185t.InterfaceC2037a;

/* JADX INFO: renamed from: b.f.j.a.a.f */
/* JADX INFO: compiled from: AnimatedImageResultBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
public class C1839f {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1836c f3613a;

    /* JADX INFO: renamed from: b */
    public CloseableReference<Bitmap> f3614b;

    /* JADX INFO: renamed from: c */
    public List<CloseableReference<Bitmap>> f3615c;

    /* JADX INFO: renamed from: d */
    public int f3616d;

    /* JADX INFO: renamed from: e */
    public InterfaceC2037a f3617e;

    public C1839f(InterfaceC1836c interfaceC1836c) {
        this.f3613a = interfaceC1836c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public C1838e m1188a() {
        try {
            C1838e c1838e = new C1838e(this);
            CloseableReference<Bitmap> closeableReference = this.f3614b;
            return c1838e;
        } finally {
            CloseableReference<Bitmap> closeableReference2 = this.f3614b;
            Class<CloseableReference> cls = CloseableReference.f19438j;
            if (closeableReference2 != null) {
                closeableReference2.close();
            }
            this.f3614b = null;
            CloseableReference.m8639t(this.f3615c);
            this.f3615c = null;
        }
    }
}

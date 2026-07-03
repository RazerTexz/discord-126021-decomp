package p007b.p109f.p161j.p162a.p163a;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.List;
import java.util.Objects;
import p007b.p109f.p161j.p185t.InterfaceC2037a;

/* JADX INFO: renamed from: b.f.j.a.a.e */
/* JADX INFO: compiled from: AnimatedImageResult.java */
/* JADX INFO: loaded from: classes2.dex */
public class C1838e {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1836c f3609a;

    /* JADX INFO: renamed from: b */
    public CloseableReference<Bitmap> f3610b;

    /* JADX INFO: renamed from: c */
    public List<CloseableReference<Bitmap>> f3611c;

    /* JADX INFO: renamed from: d */
    public InterfaceC2037a f3612d;

    public C1838e(C1839f c1839f) {
        InterfaceC1836c interfaceC1836c = c1839f.f3613a;
        Objects.requireNonNull(interfaceC1836c);
        this.f3609a = interfaceC1836c;
        this.f3610b = CloseableReference.m8636n(c1839f.f3614b);
        this.f3611c = CloseableReference.m8637q(c1839f.f3615c);
        this.f3612d = c1839f.f3617e;
    }
}

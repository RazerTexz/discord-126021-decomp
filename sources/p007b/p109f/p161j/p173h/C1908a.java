package p007b.p109f.p161j.p173h;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.decoder.DecodeException;
import java.io.InputStream;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p160i.C1831b;
import p007b.p109f.p160i.C1832c;
import p007b.p109f.p160i.C1833d;
import p007b.p109f.p161j.p169d.C1881b;
import p007b.p109f.p161j.p175j.AbstractC1917c;
import p007b.p109f.p161j.p175j.C1918d;
import p007b.p109f.p161j.p175j.C1919e;
import p007b.p109f.p161j.p175j.C1922h;
import p007b.p109f.p161j.p175j.InterfaceC1923i;
import p007b.p109f.p161j.p179n.InterfaceC1960d;

/* JADX INFO: renamed from: b.f.j.h.a */
/* JADX INFO: compiled from: DefaultImageDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class C1908a implements InterfaceC1909b {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1909b f3868a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1909b f3869b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC1960d f3870c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC1909b f3871d = new a();

    /* JADX INFO: renamed from: b.f.j.h.a$a */
    /* JADX INFO: compiled from: DefaultImageDecoder.java */
    public class a implements InterfaceC1909b {
        public a() {
        }

        @Override // p007b.p109f.p161j.p173h.InterfaceC1909b
        /* JADX INFO: renamed from: a */
        public AbstractC1917c mo1322a(C1919e c1919e, int i, InterfaceC1923i interfaceC1923i, C1881b c1881b) {
            c1919e.m1347x();
            C1832c c1832c = c1919e.f3893l;
            if (c1832c == C1831b.f3585a) {
                CloseableReference<Bitmap> closeableReferenceMo1415b = C1908a.this.f3870c.mo1415b(c1919e, c1881b.f3709d, null, i, null);
                try {
                    C1460d.m521g1(null, closeableReferenceMo1415b);
                    c1919e.m1347x();
                    int i2 = c1919e.f3894m;
                    c1919e.m1347x();
                    C1918d c1918d = new C1918d(closeableReferenceMo1415b, interfaceC1923i, i2, c1919e.f3895n);
                    Boolean bool = Boolean.FALSE;
                    if (AbstractC1917c.f3884j.contains("is_rounded")) {
                        c1918d.f3885k.put("is_rounded", bool);
                    }
                    return c1918d;
                } finally {
                    closeableReferenceMo1415b.close();
                }
            }
            if (c1832c != C1831b.f3587c) {
                if (c1832c != C1831b.f3594j) {
                    if (c1832c != C1832c.f3597a) {
                        return C1908a.this.m1323b(c1919e, c1881b);
                    }
                    throw new DecodeException("unknown image format", c1919e);
                }
                InterfaceC1909b interfaceC1909b = C1908a.this.f3869b;
                if (interfaceC1909b != null) {
                    return interfaceC1909b.mo1322a(c1919e, i, interfaceC1923i, c1881b);
                }
                throw new DecodeException("Animated WebP support not set up!", c1919e);
            }
            C1908a c1908a = C1908a.this;
            Objects.requireNonNull(c1908a);
            c1919e.m1347x();
            if (c1919e.f3896o != -1) {
                c1919e.m1347x();
                if (c1919e.f3897p != -1) {
                    Objects.requireNonNull(c1881b);
                    InterfaceC1909b interfaceC1909b2 = c1908a.f3868a;
                    return interfaceC1909b2 != null ? interfaceC1909b2.mo1322a(c1919e, i, interfaceC1923i, c1881b) : c1908a.m1323b(c1919e, c1881b);
                }
            }
            throw new DecodeException("image width or height is incorrect", c1919e);
        }
    }

    public C1908a(InterfaceC1909b interfaceC1909b, InterfaceC1909b interfaceC1909b2, InterfaceC1960d interfaceC1960d) {
        this.f3868a = interfaceC1909b;
        this.f3869b = interfaceC1909b2;
        this.f3870c = interfaceC1960d;
    }

    @Override // p007b.p109f.p161j.p173h.InterfaceC1909b
    /* JADX INFO: renamed from: a */
    public AbstractC1917c mo1322a(C1919e c1919e, int i, InterfaceC1923i interfaceC1923i, C1881b c1881b) {
        InputStream inputStreamM1342e;
        Objects.requireNonNull(c1881b);
        c1919e.m1347x();
        C1832c c1832c = c1919e.f3893l;
        if ((c1832c == null || c1832c == C1832c.f3597a) && (inputStreamM1342e = c1919e.m1342e()) != null) {
            c1919e.f3893l = C1833d.m1174b(inputStreamM1342e);
        }
        return this.f3871d.mo1322a(c1919e, i, interfaceC1923i, c1881b);
    }

    /* JADX INFO: renamed from: b */
    public C1918d m1323b(C1919e c1919e, C1881b c1881b) {
        CloseableReference<Bitmap> closeableReferenceMo1414a = this.f3870c.mo1414a(c1919e, c1881b.f3709d, null, null);
        try {
            C1460d.m521g1(null, closeableReferenceMo1414a);
            InterfaceC1923i interfaceC1923i = C1922h.f3908a;
            c1919e.m1347x();
            int i = c1919e.f3894m;
            c1919e.m1347x();
            C1918d c1918d = new C1918d(closeableReferenceMo1414a, interfaceC1923i, i, c1919e.f3895n);
            Boolean bool = Boolean.FALSE;
            if (AbstractC1917c.f3884j.contains("is_rounded")) {
                c1918d.f3885k.put("is_rounded", bool);
            }
            return c1918d;
        } finally {
            closeableReferenceMo1414a.close();
        }
    }
}

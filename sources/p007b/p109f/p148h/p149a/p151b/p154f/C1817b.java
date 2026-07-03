package p007b.p109f.p148h.p149a.p151b.p154f;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p148h.p149a.p151b.InterfaceC1806b;
import p007b.p109f.p148h.p149a.p151b.InterfaceC1807c;
import p007b.p109f.p161j.p162a.p163a.InterfaceC1834a;
import p007b.p109f.p161j.p162a.p165c.C1848d;

/* JADX INFO: renamed from: b.f.h.a.b.f.b */
/* JADX INFO: compiled from: AnimatedDrawableBackendFrameRenderer.java */
/* JADX INFO: loaded from: classes.dex */
public class C1817b implements InterfaceC1807c {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1806b f3527a;

    /* JADX INFO: renamed from: b */
    public InterfaceC1834a f3528b;

    /* JADX INFO: renamed from: c */
    public C1848d f3529c;

    /* JADX INFO: renamed from: d */
    public final C1848d.a f3530d;

    /* JADX INFO: renamed from: b.f.h.a.b.f.b$a */
    /* JADX INFO: compiled from: AnimatedDrawableBackendFrameRenderer.java */
    public class a implements C1848d.a {
        public a() {
        }

        @Override // p007b.p109f.p161j.p162a.p165c.C1848d.a
        /* JADX INFO: renamed from: a */
        public void mo1162a(int i, Bitmap bitmap) {
        }

        @Override // p007b.p109f.p161j.p162a.p165c.C1848d.a
        /* JADX INFO: renamed from: b */
        public CloseableReference<Bitmap> mo1163b(int i) {
            return C1817b.this.f3527a.mo1154d(i);
        }
    }

    public C1817b(InterfaceC1806b interfaceC1806b, InterfaceC1834a interfaceC1834a) {
        a aVar = new a();
        this.f3530d = aVar;
        this.f3527a = interfaceC1806b;
        this.f3528b = interfaceC1834a;
        this.f3529c = new C1848d(interfaceC1834a, aVar);
    }

    /* JADX INFO: renamed from: a */
    public boolean m1161a(int i, Bitmap bitmap) {
        try {
            this.f3529c.m1205d(i, bitmap);
            return true;
        } catch (IllegalStateException e) {
            C1691a.m976d(C1817b.class, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }
}

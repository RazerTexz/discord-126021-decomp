package p007b.p452o.p453a.p470u;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.p467r.C5202c;
import p007b.p452o.p453a.p467r.C5204e;
import p007b.p452o.p453a.p473x.C5236b;
import p007b.p452o.p475b.p481f.C5269b;

/* JADX INFO: renamed from: b.o.a.u.b */
/* JADX INFO: compiled from: OverlayDrawer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5214b {

    /* JADX INFO: renamed from: a */
    public static final C5103b f14147a = new C5103b(C5214b.class.getSimpleName());

    /* JADX INFO: renamed from: b */
    public InterfaceC5213a f14148b;

    /* JADX INFO: renamed from: c */
    public SurfaceTexture f14149c;

    /* JADX INFO: renamed from: d */
    public Surface f14150d;

    /* JADX INFO: renamed from: f */
    public C5204e f14152f;

    /* JADX INFO: renamed from: g */
    public final Object f14153g = new Object();

    /* JADX INFO: renamed from: e */
    @VisibleForTesting
    public C5202c f14151e = new C5202c(new C5269b(33984, 36197, null, 4));

    public C5214b(@NonNull InterfaceC5213a interfaceC5213a, @NonNull C5236b c5236b) {
        this.f14148b = interfaceC5213a;
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f14151e.f14105a.f14337g);
        this.f14149c = surfaceTexture;
        surfaceTexture.setDefaultBufferSize(c5236b.f14251j, c5236b.f14252k);
        this.f14150d = new Surface(this.f14149c);
        this.f14152f = new C5204e(this.f14151e.f14105a.f14337g);
    }
}

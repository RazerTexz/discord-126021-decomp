package p007b.p452o.p453a.p455n;

import com.otaliastudios.cameraview.CameraView;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4361e;
import p007b.p452o.p453a.RunnableC5108g;

/* JADX INFO: renamed from: b.o.a.n.m */
/* JADX INFO: compiled from: CameraEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5139m implements InterfaceC4361e<Void> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AbstractC5135i f13934a;

    public C5139m(AbstractC5135i abstractC5135i) {
        this.f13934a = abstractC5135i;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4361e
    public void onSuccess(Void r6) {
        CameraView.C11195b c11195b = (CameraView.C11195b) this.f13934a.f13921m;
        c11195b.f22141b.m7159a(1, "dispatchOnCameraClosed");
        CameraView.this.f22133u.post(new RunnableC5108g(c11195b));
    }
}

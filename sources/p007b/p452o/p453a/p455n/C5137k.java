package p007b.p452o.p453a.p455n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.otaliastudios.cameraview.CameraView;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4362f;
import p007b.p452o.p453a.AbstractC5104c;
import p007b.p452o.p453a.RunnableC5107f;

/* JADX INFO: renamed from: b.o.a.n.k */
/* JADX INFO: compiled from: CameraEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5137k implements InterfaceC4362f<AbstractC5104c, Void> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AbstractC5135i f13932a;

    public C5137k(AbstractC5135i abstractC5135i) {
        this.f13932a = abstractC5135i;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4362f
    @NonNull
    /* JADX INFO: renamed from: a */
    public Task<Void> mo4013a(@Nullable AbstractC5104c abstractC5104c) throws Exception {
        AbstractC5104c abstractC5104c2 = abstractC5104c;
        if (abstractC5104c2 == null) {
            throw new RuntimeException("Null options!");
        }
        CameraView.C11195b c11195b = (CameraView.C11195b) this.f13932a.f13921m;
        c11195b.f22141b.m7159a(1, "dispatchOnCameraOpened", abstractC5104c2);
        CameraView.this.f22133u.post(new RunnableC5107f(c11195b, abstractC5104c2));
        return C3404f.m4264Z(null);
    }
}

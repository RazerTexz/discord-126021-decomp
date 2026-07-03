package p007b.p452o.p453a.p471v;

import android.media.MediaActionSound;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.CameraView;
import p007b.p452o.p453a.C5113l;
import p007b.p452o.p453a.RunnableC5109h;
import p007b.p452o.p453a.p455n.AbstractC5133g;

/* JADX INFO: renamed from: b.o.a.v.d */
/* JADX INFO: compiled from: PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC5219d {

    /* JADX INFO: renamed from: j */
    @VisibleForTesting(otherwise = 4)
    public C5113l.a f14172j;

    /* JADX INFO: renamed from: k */
    @VisibleForTesting
    public a f14173k;

    /* JADX INFO: renamed from: l */
    public Exception f14174l;

    /* JADX INFO: renamed from: b.o.a.v.d$a */
    /* JADX INFO: compiled from: PictureRecorder.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo7227a(@Nullable C5113l.a aVar, @Nullable Exception exc);
    }

    public AbstractC5219d(@NonNull C5113l.a aVar, @Nullable a aVar2) {
        this.f14172j = aVar;
        this.f14173k = aVar2;
    }

    /* JADX INFO: renamed from: a */
    public void m7420a(boolean z2) {
        CameraView cameraView;
        boolean z3;
        a aVar = this.f14173k;
        if (aVar != null) {
            boolean z4 = !z2;
            CameraView.C11195b c11195b = (CameraView.C11195b) ((AbstractC5133g) aVar).f13921m;
            if (z4 && (z3 = (cameraView = CameraView.this).f22124l) && z3) {
                if (cameraView.f22111B == null) {
                    cameraView.f22111B = new MediaActionSound();
                }
                cameraView.f22111B.play(0);
            }
            CameraView.this.f22133u.post(new RunnableC5109h(c11195b));
        }
    }

    /* JADX INFO: renamed from: b */
    public void mo7416b() {
        a aVar = this.f14173k;
        if (aVar != null) {
            aVar.mo7227a(this.f14172j, this.f14174l);
            this.f14173k = null;
            this.f14172j = null;
        }
    }

    /* JADX INFO: renamed from: c */
    public abstract void mo7417c();
}

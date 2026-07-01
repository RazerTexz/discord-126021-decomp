package b.o.a.n.o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: renamed from: b.o.a.n.o.d, reason: use source file name */
/* JADX INFO: compiled from: ActionWrapper.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public abstract class ActionWrapper extends BaseAction {

    /* JADX INFO: renamed from: b.o.a.n.o.d$a */
    /* JADX INFO: compiled from: ActionWrapper.java */
    public class a implements ActionCallback {
        public a() {
        }

        @Override // b.o.a.n.o.ActionCallback
        public void a(@NonNull Action2 action2, int i) {
            ActionWrapper.this.l(i);
            if (i == Integer.MAX_VALUE) {
                ((BaseAction) action2).a.remove(this);
            }
        }
    }

    @Override // b.o.a.n.o.BaseAction, b.o.a.n.o.Action2
    public void b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        m().b(actionHolder, captureRequest, totalCaptureResult);
    }

    @Override // b.o.a.n.o.BaseAction, b.o.a.n.o.Action2
    public void c(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest) {
        if (this.d) {
            j(actionHolder);
            this.d = false;
        }
        m().c(actionHolder, captureRequest);
    }

    @Override // b.o.a.n.o.BaseAction, b.o.a.n.o.Action2
    public void d(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        m().d(actionHolder, captureRequest, captureResult);
    }

    @Override // b.o.a.n.o.BaseAction
    public void h(@NonNull ActionHolder actionHolder) {
        m().h(actionHolder);
    }

    @Override // b.o.a.n.o.BaseAction
    public void j(@NonNull ActionHolder actionHolder) {
        this.c = actionHolder;
        m().f(new a());
        m().j(actionHolder);
    }

    @NonNull
    public abstract BaseAction m();
}

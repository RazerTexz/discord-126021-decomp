package b.o.a.n.o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: renamed from: b.o.a.n.o.h, reason: use source file name */
/* JADX INFO: compiled from: SequenceAction.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class SequenceAction extends BaseAction {
    public final List<BaseAction> e;
    public int f = -1;

    /* JADX INFO: renamed from: b.o.a.n.o.h$a */
    /* JADX INFO: compiled from: SequenceAction.java */
    public class a implements ActionCallback {
        public a() {
        }

        @Override // b.o.a.n.o.ActionCallback
        public void a(@NonNull Action2 action2, int i) {
            if (i == Integer.MAX_VALUE) {
                ((BaseAction) action2).a.remove(this);
                SequenceAction.this.m();
            }
        }
    }

    public SequenceAction(@NonNull List<BaseAction> list) {
        this.e = list;
        m();
    }

    @Override // b.o.a.n.o.BaseAction, b.o.a.n.o.Action2
    public void b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        int i = this.f;
        if (i >= 0) {
            this.e.get(i).b(actionHolder, captureRequest, totalCaptureResult);
        }
    }

    @Override // b.o.a.n.o.BaseAction, b.o.a.n.o.Action2
    public void c(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest) {
        if (this.d) {
            j(actionHolder);
            this.d = false;
        }
        int i = this.f;
        if (i >= 0) {
            this.e.get(i).c(actionHolder, captureRequest);
        }
    }

    @Override // b.o.a.n.o.BaseAction, b.o.a.n.o.Action2
    public void d(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        int i = this.f;
        if (i >= 0) {
            this.e.get(i).d(actionHolder, captureRequest, captureResult);
        }
    }

    @Override // b.o.a.n.o.BaseAction
    public void h(@NonNull ActionHolder actionHolder) {
        int i = this.f;
        if (i >= 0) {
            this.e.get(i).h(actionHolder);
        }
    }

    @Override // b.o.a.n.o.BaseAction
    public void j(@NonNull ActionHolder actionHolder) {
        this.c = actionHolder;
        int i = this.f;
        if (i >= 0) {
            this.e.get(i).j(actionHolder);
        }
    }

    public final void m() {
        int i = this.f;
        boolean z2 = i == -1;
        if (i == this.e.size() - 1) {
            l(Integer.MAX_VALUE);
            return;
        }
        int i2 = this.f + 1;
        this.f = i2;
        this.e.get(i2).f(new a());
        if (z2) {
            return;
        }
        this.e.get(this.f).j(this.c);
    }
}

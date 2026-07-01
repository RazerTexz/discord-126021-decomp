package b.o.a.n.o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: b.o.a.n.o.j, reason: use source file name */
/* JADX INFO: compiled from: TogetherAction.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class TogetherAction extends BaseAction {
    public final List<BaseAction> e;
    public final List<BaseAction> f;

    /* JADX INFO: renamed from: b.o.a.n.o.j$a */
    /* JADX INFO: compiled from: TogetherAction.java */
    public class a implements ActionCallback {
        public a() {
        }

        @Override // b.o.a.n.o.ActionCallback
        public void a(@NonNull Action2 action2, int i) {
            if (i == Integer.MAX_VALUE) {
                TogetherAction.this.f.remove(action2);
            }
            if (TogetherAction.this.f.isEmpty()) {
                TogetherAction.this.l(Integer.MAX_VALUE);
            }
        }
    }

    public TogetherAction(@NonNull List<BaseAction> list) {
        this.e = new ArrayList(list);
        this.f = new ArrayList(list);
        Iterator<BaseAction> it = list.iterator();
        while (it.hasNext()) {
            it.next().f(new a());
        }
    }

    @Override // b.o.a.n.o.BaseAction, b.o.a.n.o.Action2
    public void b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        for (BaseAction baseAction : this.e) {
            if (!baseAction.g()) {
                baseAction.b(actionHolder, captureRequest, totalCaptureResult);
            }
        }
    }

    @Override // b.o.a.n.o.BaseAction, b.o.a.n.o.Action2
    public void c(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest) {
        if (this.d) {
            j(actionHolder);
            this.d = false;
        }
        for (BaseAction baseAction : this.e) {
            if (!baseAction.g()) {
                baseAction.c(actionHolder, captureRequest);
            }
        }
    }

    @Override // b.o.a.n.o.BaseAction, b.o.a.n.o.Action2
    public void d(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        for (BaseAction baseAction : this.e) {
            if (!baseAction.g()) {
                baseAction.d(actionHolder, captureRequest, captureResult);
            }
        }
    }

    @Override // b.o.a.n.o.BaseAction
    public void h(@NonNull ActionHolder actionHolder) {
        for (BaseAction baseAction : this.e) {
            if (!baseAction.g()) {
                baseAction.h(actionHolder);
            }
        }
    }

    @Override // b.o.a.n.o.BaseAction
    public void j(@NonNull ActionHolder actionHolder) {
        this.c = actionHolder;
        for (BaseAction baseAction : this.e) {
            if (!baseAction.g()) {
                baseAction.j(actionHolder);
            }
        }
    }
}

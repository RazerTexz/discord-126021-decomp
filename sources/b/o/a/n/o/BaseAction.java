package b.o.a.n.o;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import b.o.a.n.Camera2Engine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: b.o.a.n.o.e, reason: use source file name */
/* JADX INFO: compiled from: BaseAction.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public abstract class BaseAction implements Action2 {
    public final List<ActionCallback> a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1935b;
    public ActionHolder c;
    public boolean d;

    @Override // b.o.a.n.o.Action2
    public final void a(@NonNull ActionHolder actionHolder) {
        ((Camera2Engine) actionHolder).p0.remove(this);
        if (!g()) {
            h(actionHolder);
            l(Integer.MAX_VALUE);
        }
        this.d = false;
    }

    @Override // b.o.a.n.o.Action2
    public void b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
    }

    @Override // b.o.a.n.o.Action2
    @CallSuper
    public void c(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest) {
        if (this.d) {
            j(actionHolder);
            this.d = false;
        }
    }

    @Override // b.o.a.n.o.Action2
    public void d(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
    }

    @Override // b.o.a.n.o.Action2
    public final void e(@NonNull ActionHolder actionHolder) {
        this.c = actionHolder;
        Camera2Engine camera2Engine = (Camera2Engine) actionHolder;
        if (!camera2Engine.p0.contains(this)) {
            camera2Engine.p0.add(this);
        }
        if (((Camera2Engine) actionHolder).f1922j0 != null) {
            j(actionHolder);
        } else {
            this.d = true;
        }
    }

    public void f(@NonNull ActionCallback actionCallback) {
        if (this.a.contains(actionCallback)) {
            return;
        }
        this.a.add(actionCallback);
        actionCallback.a(this, this.f1935b);
    }

    public boolean g() {
        return this.f1935b == Integer.MAX_VALUE;
    }

    public void h(@NonNull ActionHolder actionHolder) {
    }

    public void i(@NonNull ActionHolder actionHolder) {
    }

    @CallSuper
    public void j(@NonNull ActionHolder actionHolder) {
        this.c = actionHolder;
    }

    @NonNull
    public <T> T k(@NonNull CameraCharacteristics.Key<T> key, @NonNull T t) {
        T t2 = (T) ((Camera2Engine) this.c).f1919g0.get(key);
        return t2 == null ? t : t2;
    }

    public final void l(int i) {
        if (i != this.f1935b) {
            this.f1935b = i;
            Iterator<ActionCallback> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.f1935b);
            }
            if (this.f1935b == Integer.MAX_VALUE) {
                ((Camera2Engine) this.c).p0.remove(this);
                i(this.c);
            }
        }
    }
}

package b.o.a.w;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.o.a.CameraLogger;
import b.o.a.n.CameraBaseEngine;
import b.o.a.n.CameraBaseEngine2;
import b.o.a.n.CameraEngine;
import b.o.a.n.t.Reference2;
import b.o.a.n.v.CameraState2;
import b.o.a.n.v.CameraStateOrchestrator;
import b.o.a.n.v.CameraStateOrchestrator3;
import b.o.a.x.Size3;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: renamed from: b.o.a.w.a, reason: use source file name */
/* JADX INFO: compiled from: CameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CameraPreview<T extends View, Output> {
    public static final CameraLogger a = new CameraLogger(CameraPreview.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f1957b;
    public T c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    /* JADX INFO: renamed from: b.o.a.w.a$a */
    /* JADX INFO: compiled from: CameraPreview.java */
    public class a implements Runnable {
        public final /* synthetic */ TaskCompletionSource j;

        public a(TaskCompletionSource taskCompletionSource) {
            this.j = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewK = CameraPreview.this.k();
            ViewParent parent = viewK.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(viewK);
            }
            this.j.a.s(null);
        }
    }

    /* JADX INFO: renamed from: b.o.a.w.a$b */
    /* JADX INFO: compiled from: CameraPreview.java */
    public interface b {
        void a();
    }

    /* JADX INFO: renamed from: b.o.a.w.a$c */
    /* JADX INFO: compiled from: CameraPreview.java */
    public interface c {
    }

    public CameraPreview(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        this.c = (T) n(context, viewGroup);
    }

    public void e(@Nullable b bVar) {
    }

    public final void f(int i, int i2) {
        a.a(1, "dispatchOnSurfaceAvailable:", "w=", Integer.valueOf(i), "h=", Integer.valueOf(i2));
        this.e = i;
        this.f = i2;
        if (i > 0 && i2 > 0) {
            e(null);
        }
        c cVar = this.f1957b;
        if (cVar != null) {
            ((CameraEngine) cVar).V();
        }
    }

    public final void g() {
        this.e = 0;
        this.f = 0;
        c cVar = this.f1957b;
        if (cVar != null) {
            CameraEngine cameraEngine = (CameraEngine) cVar;
            CameraEngine.j.a(1, "onSurfaceDestroyed");
            cameraEngine.N0(false);
            cameraEngine.M0(false);
        }
    }

    public final void h(int i, int i2) {
        a.a(1, "dispatchOnSurfaceSizeChanged:", "w=", Integer.valueOf(i), "h=", Integer.valueOf(i2));
        if (i == this.e && i2 == this.f) {
            return;
        }
        this.e = i;
        this.f = i2;
        if (i > 0 && i2 > 0) {
            e(null);
        }
        c cVar = this.f1957b;
        if (cVar != null) {
            CameraBaseEngine cameraBaseEngine = (CameraBaseEngine) cVar;
            Objects.requireNonNull(cameraBaseEngine);
            CameraEngine.j.a(1, "onSurfaceChanged:", "Size is", cameraBaseEngine.U0(Reference2.VIEW));
            CameraStateOrchestrator cameraStateOrchestrator = cameraBaseEngine.n;
            cameraStateOrchestrator.b("surface changed", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.BIND, new CameraBaseEngine2(cameraBaseEngine)));
        }
    }

    @NonNull
    public abstract Output i();

    @NonNull
    public abstract Class<Output> j();

    @NonNull
    public abstract View k();

    @NonNull
    public final Size3 l() {
        return new Size3(this.e, this.f);
    }

    public final boolean m() {
        return this.e > 0 && this.f > 0;
    }

    @NonNull
    public abstract T n(@NonNull Context context, @NonNull ViewGroup viewGroup);

    @CallSuper
    public void o() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            View viewK = k();
            ViewParent parent = viewK.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(viewK);
                return;
            }
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        handler.post(new a(taskCompletionSource));
        try {
            b.i.a.f.e.o.f.j(taskCompletionSource.a);
        } catch (Exception unused) {
        }
    }

    public void p() {
    }

    public void q() {
    }

    public void r(int i) {
        this.i = i;
    }

    public void s(int i, int i2) {
        a.a(1, "setStreamSize:", "desiredW=", Integer.valueOf(i), "desiredH=", Integer.valueOf(i2));
        this.g = i;
        this.h = i2;
        if (i <= 0 || i2 <= 0) {
            return;
        }
        e(null);
    }

    public void t(@Nullable c cVar) {
        c cVar2;
        c cVar3;
        if (m() && (cVar3 = this.f1957b) != null) {
            CameraEngine cameraEngine = (CameraEngine) cVar3;
            CameraEngine.j.a(1, "onSurfaceDestroyed");
            cameraEngine.N0(false);
            cameraEngine.M0(false);
        }
        this.f1957b = cVar;
        if (!m() || (cVar2 = this.f1957b) == null) {
            return;
        }
        ((CameraEngine) cVar2).V();
    }

    public boolean u() {
        return this instanceof GlCameraPreview2;
    }
}

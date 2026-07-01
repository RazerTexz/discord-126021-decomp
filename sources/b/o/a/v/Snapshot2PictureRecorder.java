package b.o.a.v;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import b.o.a.PictureResult;
import b.o.a.n.Camera2Engine;
import b.o.a.n.o.Action2;
import b.o.a.n.o.ActionHolder;
import b.o.a.n.o.BaseAction;
import b.o.a.n.o.CompletionCallback;
import b.o.a.n.o.SequenceAction;
import b.o.a.n.o.TimeoutAction;
import b.o.a.n.p.LockAction;
import b.o.a.w.RendererCameraPreview;
import b.o.a.x.AspectRatio2;
import java.util.Arrays;

/* JADX INFO: renamed from: b.o.a.v.f, reason: use source file name */
/* JADX INFO: compiled from: Snapshot2PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class Snapshot2PictureRecorder extends SnapshotGlPictureRecorder {
    public final Action2 t;
    public final ActionHolder u;
    public final boolean v;
    public Integer w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Integer f1955x;

    /* JADX INFO: renamed from: b.o.a.v.f$a */
    /* JADX INFO: compiled from: Snapshot2PictureRecorder.java */
    public class a extends CompletionCallback {
        public a() {
        }

        @Override // b.o.a.n.o.CompletionCallback
        public void b(@NonNull Action2 action2) {
            SnapshotPictureRecorder.m.a(1, "Taking picture with super.take().");
            Snapshot2PictureRecorder.super.c();
        }
    }

    /* JADX INFO: renamed from: b.o.a.v.f$b */
    /* JADX INFO: compiled from: Snapshot2PictureRecorder.java */
    public class b extends BaseAction {
        public b(Snapshot2PictureRecorder snapshot2PictureRecorder, a aVar) {
        }

        @Override // b.o.a.n.o.BaseAction, b.o.a.n.o.Action2
        public void b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.FLASH_STATE);
            if (num == null) {
                SnapshotPictureRecorder.m.a(2, "FlashAction:", "Waiting flash, but flashState is null!", "Taking snapshot.");
                l(Integer.MAX_VALUE);
            } else if (num.intValue() != 3) {
                SnapshotPictureRecorder.m.a(1, "FlashAction:", "Waiting flash but flashState is", num, ". Waiting...");
            } else {
                SnapshotPictureRecorder.m.a(1, "FlashAction:", "Waiting flash and we have FIRED state!", "Taking snapshot.");
                l(Integer.MAX_VALUE);
            }
        }

        @Override // b.o.a.n.o.BaseAction
        public void j(@NonNull ActionHolder actionHolder) {
            this.c = actionHolder;
            SnapshotPictureRecorder.m.a(1, "FlashAction:", "Parameters locked, opening torch.");
            ((Camera2Engine) actionHolder).f1921i0.set(CaptureRequest.FLASH_MODE, 2);
            Camera2Engine camera2Engine = (Camera2Engine) actionHolder;
            camera2Engine.f1921i0.set(CaptureRequest.CONTROL_AE_MODE, 1);
            camera2Engine.k1();
        }
    }

    /* JADX INFO: renamed from: b.o.a.v.f$c */
    /* JADX INFO: compiled from: Snapshot2PictureRecorder.java */
    public class c extends BaseAction {
        public c(a aVar) {
        }

        @Override // b.o.a.n.o.BaseAction
        public void j(@NonNull ActionHolder actionHolder) {
            this.c = actionHolder;
            try {
                SnapshotPictureRecorder.m.a(1, "ResetFlashAction:", "Reverting the flash changes.");
                CaptureRequest.Builder builder = ((Camera2Engine) actionHolder).f1921i0;
                builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                builder.set(CaptureRequest.FLASH_MODE, 0);
                ((Camera2Engine) actionHolder).e1(this, builder);
                builder.set(CaptureRequest.CONTROL_AE_MODE, Snapshot2PictureRecorder.this.w);
                builder.set(CaptureRequest.FLASH_MODE, Snapshot2PictureRecorder.this.f1955x);
                ((Camera2Engine) actionHolder).k1();
            } catch (CameraAccessException unused) {
            }
        }
    }

    public Snapshot2PictureRecorder(@NonNull PictureResult.a aVar, @NonNull Camera2Engine camera2Engine, @NonNull RendererCameraPreview rendererCameraPreview, @NonNull AspectRatio2 aspectRatio2) {
        super(aVar, camera2Engine, rendererCameraPreview, aspectRatio2, camera2Engine.f1930c0);
        this.u = camera2Engine;
        boolean z2 = false;
        SequenceAction sequenceAction = new SequenceAction(Arrays.asList(new TimeoutAction(2500L, new LockAction()), new b(this, null)));
        this.t = sequenceAction;
        sequenceAction.f(new a());
        TotalCaptureResult totalCaptureResult = camera2Engine.f1922j0;
        if (totalCaptureResult == null) {
            SnapshotPictureRecorder.m.a(2, "Picture snapshot requested very early, before the first preview frame.", "Metering might not work as intended.");
        }
        Integer num = totalCaptureResult != null ? (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE) : null;
        if (camera2Engine.H && num != null && num.intValue() == 4) {
            z2 = true;
        }
        this.v = z2;
        this.w = (Integer) camera2Engine.f1921i0.get(CaptureRequest.CONTROL_AE_MODE);
        this.f1955x = (Integer) camera2Engine.f1921i0.get(CaptureRequest.FLASH_MODE);
    }

    @Override // b.o.a.v.SnapshotGlPictureRecorder, b.o.a.v.PictureRecorder
    public void b() {
        new c(null).e(this.u);
        super.b();
    }

    @Override // b.o.a.v.SnapshotGlPictureRecorder, b.o.a.v.PictureRecorder
    public void c() {
        if (this.v) {
            SnapshotPictureRecorder.m.a(1, "take:", "Engine needs flash. Starting action");
            this.t.e(this.u);
        } else {
            SnapshotPictureRecorder.m.a(1, "take:", "Engine does no metering or needs no flash.", "Taking fast snapshot.");
            super.c();
        }
    }
}

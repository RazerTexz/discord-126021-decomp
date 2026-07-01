package b.o.a.n;

import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import b.o.a.n.o.ActionHolder;
import b.o.a.n.o.BaseAction;

/* JADX INFO: renamed from: b.o.a.n.f, reason: use source file name */
/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class Camera2Engine3 extends BaseAction {
    public final /* synthetic */ Camera2Engine e;

    public Camera2Engine3(Camera2Engine camera2Engine) {
        this.e = camera2Engine;
    }

    @Override // b.o.a.n.o.BaseAction
    public void j(@NonNull ActionHolder actionHolder) {
        this.c = actionHolder;
        this.e.f1(((Camera2Engine) actionHolder).f1921i0);
        Camera2Engine camera2Engine = (Camera2Engine) actionHolder;
        CaptureRequest.Builder builder = camera2Engine.f1921i0;
        CaptureRequest.Key key = CaptureRequest.CONTROL_AE_LOCK;
        Boolean bool = Boolean.FALSE;
        builder.set(key, bool);
        camera2Engine.f1921i0.set(CaptureRequest.CONTROL_AWB_LOCK, bool);
        camera2Engine.k1();
        l(Integer.MAX_VALUE);
    }
}

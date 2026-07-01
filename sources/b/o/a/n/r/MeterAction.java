package b.o.a.n.r;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.o.a.CameraLogger;
import b.o.a.n.Camera2Engine;
import b.o.a.n.CameraEngine;
import b.o.a.n.o.ActionHolder;
import b.o.a.n.o.ActionWrapper;
import b.o.a.n.o.BaseAction;
import b.o.a.n.s.Camera2MeteringTransform;
import b.o.a.n.t.Reference2;
import b.o.a.t.MeteringRegions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: b.o.a.n.r.g, reason: use source file name */
/* JADX INFO: compiled from: MeterAction.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class MeterAction extends ActionWrapper {
    public static final CameraLogger e = new CameraLogger(MeterAction.class.getSimpleName());
    public List<BaseMeter> f;
    public BaseAction g;
    public final MeteringRegions h;
    public final CameraEngine i;
    public final boolean j;

    public MeterAction(@NonNull CameraEngine cameraEngine, @Nullable MeteringRegions meteringRegions, boolean z2) {
        this.h = meteringRegions;
        this.i = cameraEngine;
        this.j = z2;
    }

    @Override // b.o.a.n.o.ActionWrapper, b.o.a.n.o.BaseAction
    public void j(@NonNull ActionHolder actionHolder) {
        CameraLogger cameraLogger = e;
        cameraLogger.a(2, "onStart:", "initializing.");
        n(actionHolder);
        cameraLogger.a(2, "onStart:", "initialized.");
        super.j(actionHolder);
    }

    @Override // b.o.a.n.o.ActionWrapper
    @NonNull
    public BaseAction m() {
        return this.g;
    }

    public final void n(@NonNull ActionHolder actionHolder) {
        List arrayList = new ArrayList();
        if (this.h != null) {
            Camera2Engine camera2Engine = (Camera2Engine) actionHolder;
            Camera2MeteringTransform camera2MeteringTransform = new Camera2MeteringTransform(this.i.e(), this.i.z().l(), this.i.C(Reference2.VIEW), this.i.z().d, camera2Engine.f1919g0, camera2Engine.f1921i0);
            arrayList = this.h.c(camera2MeteringTransform).b(Integer.MAX_VALUE, camera2MeteringTransform);
        }
        ExposureMeter exposureMeter = new ExposureMeter(arrayList, this.j);
        FocusMeter focusMeter = new FocusMeter(arrayList, this.j);
        WhiteBalanceMeter whiteBalanceMeter = new WhiteBalanceMeter(arrayList, this.j);
        this.f = Arrays.asList(exposureMeter, focusMeter, whiteBalanceMeter);
        this.g = b.i.a.f.e.o.f.x1(exposureMeter, focusMeter, whiteBalanceMeter);
    }
}

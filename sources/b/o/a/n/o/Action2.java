package b.o.a.n.o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: renamed from: b.o.a.n.o.a, reason: use source file name */
/* JADX INFO: compiled from: Action.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public interface Action2 {
    void a(@NonNull ActionHolder actionHolder);

    void b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult);

    void c(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest);

    void d(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult);

    void e(@NonNull ActionHolder actionHolder);
}

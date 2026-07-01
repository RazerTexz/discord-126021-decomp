package b.o.a.n;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$p extends b.o.a.n.o.e {
    public final /* synthetic */ TaskCompletionSource e;

    public d$p(d dVar, TaskCompletionSource taskCompletionSource) {
        this.e = taskCompletionSource;
    }

    @Override // b.o.a.n.o.e, b.o.a.n.o.a
    public void b(@NonNull b.o.a.n.o.c cVar, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        l(Integer.MAX_VALUE);
        this.e.b(null);
    }
}

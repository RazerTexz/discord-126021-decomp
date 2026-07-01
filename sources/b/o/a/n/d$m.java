package b.o.a.n;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice$StateCallback;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.otaliastudios.cameraview.CameraException;
import java.util.Objects;

/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$m extends CameraDevice$StateCallback {
    public final /* synthetic */ TaskCompletionSource a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f1924b;

    public d$m(d dVar, TaskCompletionSource taskCompletionSource) {
        this.f1924b = dVar;
        this.a = taskCompletionSource;
    }

    @Override // android.hardware.camera2.CameraDevice$StateCallback
    public void onDisconnected(@NonNull CameraDevice cameraDevice) {
        CameraException cameraException = new CameraException(3);
        if (this.a.a.o()) {
            i.j.a(1, "CameraDevice.StateCallback reported disconnection.");
            throw cameraException;
        }
        this.a.a(cameraException);
    }

    @Override // android.hardware.camera2.CameraDevice$StateCallback
    public void onError(@NonNull CameraDevice cameraDevice, int i) {
        int i2 = 1;
        if (this.a.a.o()) {
            i.j.a(3, "CameraDevice.StateCallback reported an error:", Integer.valueOf(i));
            throw new CameraException(3);
        }
        TaskCompletionSource taskCompletionSource = this.a;
        Objects.requireNonNull(this.f1924b);
        if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
            i2 = 0;
        }
        taskCompletionSource.a(new CameraException(i2));
    }

    @Override // android.hardware.camera2.CameraDevice$StateCallback
    public void onOpened(@NonNull CameraDevice cameraDevice) {
        int i;
        this.f1924b.f1918f0 = cameraDevice;
        try {
            i.j.a(1, "onStartEngine:", "Opened camera device.");
            d dVar = this.f1924b;
            dVar.f1919g0 = dVar.f1916d0.getCameraCharacteristics(dVar.f1917e0);
            boolean zB = this.f1924b.L.b(b.o.a.n.t.b.SENSOR, b.o.a.n.t.b.VIEW);
            int iOrdinal = this.f1924b.B.ordinal();
            if (iOrdinal == 0) {
                i = 256;
            } else {
                if (iOrdinal != 1) {
                    throw new IllegalArgumentException("Unknown format:" + this.f1924b.B);
                }
                i = 32;
            }
            d dVar2 = this.f1924b;
            dVar2.p = new b.o.a.n.u.b(dVar2.f1916d0, dVar2.f1917e0, zB, i);
            d dVar3 = this.f1924b;
            Objects.requireNonNull(dVar3);
            dVar3.q1(1);
            this.a.b(this.f1924b.p);
        } catch (CameraAccessException e) {
            this.a.a(this.f1924b.o1(e));
        }
    }
}

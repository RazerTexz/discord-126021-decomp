package b.i.a.c.g3.z;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import androidx.annotation.BinderThread;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.a.c.g3.z.g, reason: use source file name */
/* JADX INFO: compiled from: OrientationListener.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OrientationListener implements SensorEventListener {
    public final float[] a = new float[16];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f999b = new float[16];
    public final float[] c = new float[16];
    public final float[] d = new float[3];
    public final Display e;
    public final a[] f;
    public boolean g;

    /* JADX INFO: renamed from: b.i.a.c.g3.z.g$a */
    /* JADX INFO: compiled from: OrientationListener.java */
    public interface a {
        void a(float[] fArr, float f);
    }

    public OrientationListener(Display display, a... aVarArr) {
        this.e = display;
        this.f = aVarArr;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    @BinderThread
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.a, sensorEvent.values);
        float[] fArr = this.a;
        int rotation = this.e.getRotation();
        if (rotation != 0) {
            int i = Opcodes.LOR;
            int i2 = 130;
            if (rotation == 1) {
                i = 2;
                i2 = Opcodes.LOR;
            } else if (rotation != 2) {
                if (rotation != 3) {
                    throw new IllegalStateException();
                }
                i = 130;
                i2 = 1;
            }
            float[] fArr2 = this.f999b;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.f999b, i, i2, fArr);
        }
        SensorManager.remapCoordinateSystem(this.a, 1, Opcodes.LXOR, this.f999b);
        SensorManager.getOrientation(this.f999b, this.d);
        float f = this.d[2];
        Matrix.rotateM(this.a, 0, 90.0f, 1.0f, 0.0f, 0.0f);
        float[] fArr3 = this.a;
        if (!this.g) {
            FrameRotationQueue.a(this.c, fArr3);
            this.g = true;
        }
        float[] fArr4 = this.f999b;
        System.arraycopy(fArr3, 0, fArr4, 0, fArr4.length);
        Matrix.multiplyMM(fArr3, 0, this.f999b, 0, this.c, 0);
        float[] fArr5 = this.a;
        for (a aVar : this.f) {
            aVar.a(fArr5, f);
        }
    }
}

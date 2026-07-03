package p007b.p225i.p226a.p242c.p260g3.p261z;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import androidx.annotation.BinderThread;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.a.c.g3.z.g */
/* JADX INFO: compiled from: OrientationListener.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2795g implements SensorEventListener {

    /* JADX INFO: renamed from: a */
    public final float[] f6972a = new float[16];

    /* JADX INFO: renamed from: b */
    public final float[] f6973b = new float[16];

    /* JADX INFO: renamed from: c */
    public final float[] f6974c = new float[16];

    /* JADX INFO: renamed from: d */
    public final float[] f6975d = new float[3];

    /* JADX INFO: renamed from: e */
    public final Display f6976e;

    /* JADX INFO: renamed from: f */
    public final a[] f6977f;

    /* JADX INFO: renamed from: g */
    public boolean f6978g;

    /* JADX INFO: renamed from: b.i.a.c.g3.z.g$a */
    /* JADX INFO: compiled from: OrientationListener.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo3199a(float[] fArr, float f);
    }

    public C2795g(Display display, a... aVarArr) {
        this.f6976e = display;
        this.f6977f = aVarArr;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    @BinderThread
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.f6972a, sensorEvent.values);
        float[] fArr = this.f6972a;
        int rotation = this.f6976e.getRotation();
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
            float[] fArr2 = this.f6973b;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.f6973b, i, i2, fArr);
        }
        SensorManager.remapCoordinateSystem(this.f6972a, 1, Opcodes.LXOR, this.f6973b);
        SensorManager.getOrientation(this.f6973b, this.f6975d);
        float f = this.f6975d[2];
        Matrix.rotateM(this.f6972a, 0, 90.0f, 1.0f, 0.0f, 0.0f);
        float[] fArr3 = this.f6972a;
        if (!this.f6978g) {
            C2794f.m3198a(this.f6974c, fArr3);
            this.f6978g = true;
        }
        float[] fArr4 = this.f6973b;
        System.arraycopy(fArr3, 0, fArr4, 0, fArr4.length);
        Matrix.multiplyMM(fArr3, 0, this.f6973b, 0, this.f6974c, 0);
        float[] fArr5 = this.f6972a;
        for (a aVar : this.f6977f) {
            aVar.mo3199a(fArr5, f);
        }
    }
}

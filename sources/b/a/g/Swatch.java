package b.a.g;

import android.graphics.Color;
import b.d.b.a.outline;
import java.util.Arrays;

/* JADX INFO: renamed from: b.a.g.d, reason: use source file name */
/* JADX INFO: compiled from: Swatch.java */
/* JADX INFO: loaded from: classes.dex */
public final class Swatch {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f71b;
    public final int c;
    public final int d;
    public final int e;
    public float[] f;

    public Swatch(int i, int i2) {
        this.a = Color.red(i);
        this.f71b = Color.green(i);
        this.c = Color.blue(i);
        this.d = i;
        this.e = i2;
    }

    public float[] a() {
        if (this.f == null) {
            float[] fArr = new float[3];
            this.f = fArr;
            ColorUtils2.a(this.a, this.f71b, this.c, fArr);
        }
        return this.f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(Swatch.class.getSimpleName());
        sb.append(" ");
        sb.append("[");
        sb.append(Integer.toHexString(this.d));
        sb.append(']');
        sb.append("[HSL: ");
        sb.append(Arrays.toString(a()));
        sb.append(']');
        sb.append("[Population: ");
        return outline.A(sb, this.e, ']');
    }

    public Swatch(int i, int i2, int i3, int i4) {
        this.a = i;
        this.f71b = i2;
        this.c = i3;
        this.d = Color.rgb(i, i2, i3);
        this.e = i4;
    }
}

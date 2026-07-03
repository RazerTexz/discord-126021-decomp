package p007b.p008a.p023g;

import android.graphics.Color;
import java.util.Arrays;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.a.g.d */
/* JADX INFO: compiled from: Swatch.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0906d {

    /* JADX INFO: renamed from: a */
    public final int f645a;

    /* JADX INFO: renamed from: b */
    public final int f646b;

    /* JADX INFO: renamed from: c */
    public final int f647c;

    /* JADX INFO: renamed from: d */
    public final int f648d;

    /* JADX INFO: renamed from: e */
    public final int f649e;

    /* JADX INFO: renamed from: f */
    public float[] f650f;

    public C0906d(int i, int i2) {
        this.f645a = Color.red(i);
        this.f646b = Color.green(i);
        this.f647c = Color.blue(i);
        this.f648d = i;
        this.f649e = i2;
    }

    /* JADX INFO: renamed from: a */
    public float[] m193a() {
        if (this.f650f == null) {
            float[] fArr = new float[3];
            this.f650f = fArr;
            C0905c.m192a(this.f645a, this.f646b, this.f647c, fArr);
        }
        return this.f650f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(C0906d.class.getSimpleName());
        sb.append(" ");
        sb.append("[");
        sb.append(Integer.toHexString(this.f648d));
        sb.append(']');
        sb.append("[HSL: ");
        sb.append(Arrays.toString(m193a()));
        sb.append(']');
        sb.append("[Population: ");
        return C1643a.m813A(sb, this.f649e, ']');
    }

    public C0906d(int i, int i2, int i3, int i4) {
        this.f645a = i;
        this.f646b = i2;
        this.f647c = i3;
        this.f648d = Color.rgb(i, i2, i3);
        this.f649e = i4;
    }
}

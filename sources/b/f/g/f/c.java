package b.f.g.f;

import androidx.annotation.ColorInt;
import java.util.Arrays;

/* JADX INFO: compiled from: RoundingParams.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public int a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f523b = false;
    public float[] c = null;
    public int d = 0;
    public float e = 0.0f;
    public int f = 0;
    public float g = 0.0f;
    public boolean h = false;

    public static c a(float f) {
        c cVar = new c();
        if (cVar.c == null) {
            cVar.c = new float[8];
        }
        Arrays.fill(cVar.c, f);
        return cVar;
    }

    public c b(@ColorInt int i) {
        this.d = i;
        this.a = 1;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f523b == cVar.f523b && this.d == cVar.d && Float.compare(cVar.e, this.e) == 0 && this.f == cVar.f && Float.compare(cVar.g, this.g) == 0 && this.a == cVar.a && this.h == cVar.h) {
            return Arrays.equals(this.c, cVar.c);
        }
        return false;
    }

    public int hashCode() {
        int i = this.a;
        int iH = (((i != 0 ? b.c.a.y.b.h(i) : 0) * 31) + (this.f523b ? 1 : 0)) * 31;
        float[] fArr = this.c;
        int iHashCode = (((iH + (fArr != null ? Arrays.hashCode(fArr) : 0)) * 31) + this.d) * 31;
        float f = this.e;
        int iFloatToIntBits = (((iHashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31) + this.f) * 31;
        float f2 = this.g;
        return ((((iFloatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31) + 0) * 31) + (this.h ? 1 : 0);
    }
}

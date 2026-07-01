package b.i.e;

/* JADX INFO: compiled from: ResultPoint.java */
/* JADX INFO: loaded from: classes3.dex */
public class k {
    public final float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f1826b;

    public k(float f, float f2) {
        this.a = f;
        this.f1826b = f2;
    }

    public static float a(k kVar, k kVar2) {
        return b.i.a.f.e.o.f.Q(kVar.a, kVar.f1826b, kVar2.a, kVar2.f1826b);
    }

    public static void b(k[] kVarArr) {
        k kVar;
        k kVar2;
        k kVar3;
        float fA = a(kVarArr[0], kVarArr[1]);
        float fA2 = a(kVarArr[1], kVarArr[2]);
        float fA3 = a(kVarArr[0], kVarArr[2]);
        if (fA2 >= fA && fA2 >= fA3) {
            kVar = kVarArr[0];
            kVar2 = kVarArr[1];
            kVar3 = kVarArr[2];
        } else if (fA3 < fA2 || fA3 < fA) {
            kVar = kVarArr[2];
            kVar2 = kVarArr[0];
            kVar3 = kVarArr[1];
        } else {
            kVar = kVarArr[1];
            kVar2 = kVarArr[0];
            kVar3 = kVarArr[2];
        }
        float f = kVar.a;
        float f2 = kVar.f1826b;
        if (((kVar2.f1826b - f2) * (kVar3.a - f)) - ((kVar2.a - f) * (kVar3.f1826b - f2)) < 0.0f) {
            k kVar4 = kVar3;
            kVar3 = kVar2;
            kVar2 = kVar4;
        }
        kVarArr[0] = kVar2;
        kVarArr[1] = kVar;
        kVarArr[2] = kVar3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (this.a == kVar.a && this.f1826b == kVar.f1826b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f1826b) + (Float.floatToIntBits(this.a) * 31);
    }

    public final String toString() {
        return "(" + this.a + ',' + this.f1826b + ')';
    }
}

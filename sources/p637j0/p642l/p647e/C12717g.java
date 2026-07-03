package p637j0.p642l.p647e;

/* JADX INFO: renamed from: j0.l.e.g */
/* JADX INFO: compiled from: OpenHashSet.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12717g<T> {

    /* JADX INFO: renamed from: a */
    public int f27277a;

    /* JADX INFO: renamed from: b */
    public int f27278b;

    /* JADX INFO: renamed from: c */
    public int f27279c;

    /* JADX INFO: renamed from: d */
    public T[] f27280d;

    public C12717g() {
        int iM10823b = C12723m.m10823b(16);
        this.f27277a = iM10823b - 1;
        this.f27279c = (int) (iM10823b * 0.75f);
        this.f27280d = (T[]) new Object[iM10823b];
    }

    /* JADX INFO: renamed from: b */
    public static int m10814b(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >>> 16);
    }

    /* JADX INFO: renamed from: a */
    public boolean m10815a(T t) {
        T t2;
        T[] tArr = this.f27280d;
        int i = this.f27277a;
        int iM10814b = m10814b(t.hashCode()) & i;
        T t3 = tArr[iM10814b];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                iM10814b = (iM10814b + 1) & i;
                t2 = tArr[iM10814b];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[iM10814b] = t;
        int i2 = this.f27278b + 1;
        this.f27278b = i2;
        if (i2 >= this.f27279c) {
            T[] tArr2 = this.f27280d;
            int length = tArr2.length;
            int i3 = length << 1;
            int i4 = i3 - 1;
            T[] tArr3 = (T[]) new Object[i3];
            while (true) {
                int i5 = i2 - 1;
                if (i2 == 0) {
                    break;
                }
                do {
                    length--;
                } while (tArr2[length] == null);
                int iM10814b2 = m10814b(tArr2[length].hashCode()) & i4;
                if (tArr3[iM10814b2] != null) {
                    do {
                        iM10814b2 = (iM10814b2 + 1) & i4;
                    } while (tArr3[iM10814b2] != null);
                }
                tArr3[iM10814b2] = tArr2[length];
                i2 = i5;
            }
            this.f27277a = i4;
            this.f27279c = (int) (i3 * 0.75f);
            this.f27280d = tArr3;
        }
        return true;
    }

    /* JADX INFO: renamed from: c */
    public boolean m10816c(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.f27278b--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t != null) {
                    int iM10814b = m10814b(t.hashCode()) & i2;
                    if (i > i3) {
                        if (i >= iM10814b && iM10814b > i3) {
                            break;
                        }
                        i4 = i3 + 1;
                    } else {
                        if (i >= iM10814b || iM10814b > i3) {
                            break;
                        }
                        i4 = i3 + 1;
                    }
                } else {
                    tArr[i] = null;
                    return true;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }
}

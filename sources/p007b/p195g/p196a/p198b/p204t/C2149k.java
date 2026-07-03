package p007b.p195g.p196a.p198b.p204t;

import java.util.ArrayList;

/* JADX INFO: renamed from: b.g.a.b.t.k */
/* JADX INFO: compiled from: TextBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2149k {

    /* JADX INFO: renamed from: a */
    public static final char[] f4604a = new char[0];

    /* JADX INFO: renamed from: b */
    public final C2139a f4605b;

    /* JADX INFO: renamed from: c */
    public int f4606c;

    /* JADX INFO: renamed from: d */
    public ArrayList<char[]> f4607d;

    /* JADX INFO: renamed from: e */
    public boolean f4608e;

    /* JADX INFO: renamed from: f */
    public int f4609f;

    /* JADX INFO: renamed from: g */
    public char[] f4610g;

    /* JADX INFO: renamed from: h */
    public int f4611h;

    /* JADX INFO: renamed from: i */
    public String f4612i;

    /* JADX INFO: renamed from: j */
    public char[] f4613j;

    public C2149k(C2139a c2139a) {
        this.f4605b = c2139a;
    }

    /* JADX INFO: renamed from: a */
    public void m1739a(String str, int i, int i2) {
        if (this.f4606c >= 0) {
            m1744f(i2);
        }
        this.f4612i = null;
        this.f4613j = null;
        char[] cArr = this.f4610g;
        int length = cArr.length;
        int i3 = this.f4611h;
        int i4 = length - i3;
        if (i4 >= i2) {
            str.getChars(i, i + i2, cArr, i3);
            this.f4611h += i2;
            return;
        }
        if (i4 > 0) {
            int i5 = i + i4;
            str.getChars(i, i5, cArr, i3);
            i2 -= i4;
            i = i5;
        }
        while (true) {
            m1742d();
            int iMin = Math.min(this.f4610g.length, i2);
            int i6 = i + iMin;
            str.getChars(i, i6, this.f4610g, 0);
            this.f4611h += iMin;
            i2 -= iMin;
            if (i2 <= 0) {
                return;
            } else {
                i = i6;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m1740b(char[] cArr, int i, int i2) {
        if (this.f4606c >= 0) {
            m1744f(i2);
        }
        this.f4612i = null;
        this.f4613j = null;
        char[] cArr2 = this.f4610g;
        int length = cArr2.length;
        int i3 = this.f4611h;
        int i4 = length - i3;
        if (i4 >= i2) {
            System.arraycopy(cArr, i, cArr2, i3, i2);
            this.f4611h += i2;
            return;
        }
        if (i4 > 0) {
            System.arraycopy(cArr, i, cArr2, i3, i4);
            i += i4;
            i2 -= i4;
        }
        do {
            m1742d();
            int iMin = Math.min(this.f4610g.length, i2);
            System.arraycopy(cArr, i, this.f4610g, 0, iMin);
            this.f4611h += iMin;
            i += iMin;
            i2 -= iMin;
        } while (i2 > 0);
    }

    /* JADX INFO: renamed from: c */
    public String m1741c() {
        if (this.f4612i == null) {
            if (this.f4613j != null) {
                this.f4612i = new String(this.f4613j);
            } else {
                if (this.f4606c >= 0) {
                    this.f4612i = "";
                    return "";
                }
                int i = this.f4609f;
                int i2 = this.f4611h;
                if (i == 0) {
                    this.f4612i = i2 != 0 ? new String(this.f4610g, 0, i2) : "";
                } else {
                    StringBuilder sb = new StringBuilder(i + i2);
                    ArrayList<char[]> arrayList = this.f4607d;
                    if (arrayList != null) {
                        int size = arrayList.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            char[] cArr = this.f4607d.get(i3);
                            sb.append(cArr, 0, cArr.length);
                        }
                    }
                    sb.append(this.f4610g, 0, this.f4611h);
                    this.f4612i = sb.toString();
                }
            }
        }
        return this.f4612i;
    }

    /* JADX INFO: renamed from: d */
    public final void m1742d() {
        if (this.f4607d == null) {
            this.f4607d = new ArrayList<>();
        }
        char[] cArr = this.f4610g;
        this.f4608e = true;
        this.f4607d.add(cArr);
        this.f4609f += cArr.length;
        this.f4611h = 0;
        int length = cArr.length;
        int i = length + (length >> 1);
        if (i < 500) {
            i = 500;
        } else if (i > 65536) {
            i = 65536;
        }
        this.f4610g = new char[i];
    }

    /* JADX INFO: renamed from: e */
    public char[] m1743e() {
        if (this.f4607d == null) {
            this.f4607d = new ArrayList<>();
        }
        this.f4608e = true;
        this.f4607d.add(this.f4610g);
        int length = this.f4610g.length;
        this.f4609f += length;
        this.f4611h = 0;
        int i = length + (length >> 1);
        if (i < 500) {
            i = 500;
        } else if (i > 65536) {
            i = 65536;
        }
        char[] cArr = new char[i];
        this.f4610g = cArr;
        return cArr;
    }

    /* JADX INFO: renamed from: f */
    public final void m1744f(int i) {
        this.f4606c = -1;
        int i2 = i + 0;
        char[] cArr = this.f4610g;
        if (cArr == null || i2 > cArr.length) {
            C2139a c2139a = this.f4605b;
            this.f4610g = c2139a != null ? c2139a.m1730a(2, i2) : new char[Math.max(i2, 500)];
        }
        this.f4609f = 0;
        this.f4611h = 0;
    }

    public String toString() {
        return m1741c();
    }

    public C2149k(C2139a c2139a, char[] cArr) {
        this.f4605b = null;
        this.f4610g = cArr;
        this.f4611h = cArr.length;
        this.f4606c = -1;
    }
}

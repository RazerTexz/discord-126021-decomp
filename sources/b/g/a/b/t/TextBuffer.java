package b.g.a.b.t;

import java.util.ArrayList;

/* JADX INFO: renamed from: b.g.a.b.t.k, reason: use source file name */
/* JADX INFO: compiled from: TextBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TextBuffer {
    public static final char[] a = new char[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BufferRecycler f678b;
    public int c;
    public ArrayList<char[]> d;
    public boolean e;
    public int f;
    public char[] g;
    public int h;
    public String i;
    public char[] j;

    public TextBuffer(BufferRecycler bufferRecycler) {
        this.f678b = bufferRecycler;
    }

    public void a(String str, int i, int i2) {
        if (this.c >= 0) {
            f(i2);
        }
        this.i = null;
        this.j = null;
        char[] cArr = this.g;
        int length = cArr.length;
        int i3 = this.h;
        int i4 = length - i3;
        if (i4 >= i2) {
            str.getChars(i, i + i2, cArr, i3);
            this.h += i2;
            return;
        }
        if (i4 > 0) {
            int i5 = i + i4;
            str.getChars(i, i5, cArr, i3);
            i2 -= i4;
            i = i5;
        }
        while (true) {
            d();
            int iMin = Math.min(this.g.length, i2);
            int i6 = i + iMin;
            str.getChars(i, i6, this.g, 0);
            this.h += iMin;
            i2 -= iMin;
            if (i2 <= 0) {
                return;
            } else {
                i = i6;
            }
        }
    }

    public void b(char[] cArr, int i, int i2) {
        if (this.c >= 0) {
            f(i2);
        }
        this.i = null;
        this.j = null;
        char[] cArr2 = this.g;
        int length = cArr2.length;
        int i3 = this.h;
        int i4 = length - i3;
        if (i4 >= i2) {
            System.arraycopy(cArr, i, cArr2, i3, i2);
            this.h += i2;
            return;
        }
        if (i4 > 0) {
            System.arraycopy(cArr, i, cArr2, i3, i4);
            i += i4;
            i2 -= i4;
        }
        do {
            d();
            int iMin = Math.min(this.g.length, i2);
            System.arraycopy(cArr, i, this.g, 0, iMin);
            this.h += iMin;
            i += iMin;
            i2 -= iMin;
        } while (i2 > 0);
    }

    public String c() {
        if (this.i == null) {
            if (this.j != null) {
                this.i = new String(this.j);
            } else {
                if (this.c >= 0) {
                    this.i = "";
                    return "";
                }
                int i = this.f;
                int i2 = this.h;
                if (i == 0) {
                    this.i = i2 != 0 ? new String(this.g, 0, i2) : "";
                } else {
                    StringBuilder sb = new StringBuilder(i + i2);
                    ArrayList<char[]> arrayList = this.d;
                    if (arrayList != null) {
                        int size = arrayList.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            char[] cArr = this.d.get(i3);
                            sb.append(cArr, 0, cArr.length);
                        }
                    }
                    sb.append(this.g, 0, this.h);
                    this.i = sb.toString();
                }
            }
        }
        return this.i;
    }

    public final void d() {
        if (this.d == null) {
            this.d = new ArrayList<>();
        }
        char[] cArr = this.g;
        this.e = true;
        this.d.add(cArr);
        this.f += cArr.length;
        this.h = 0;
        int length = cArr.length;
        int i = length + (length >> 1);
        if (i < 500) {
            i = 500;
        } else if (i > 65536) {
            i = 65536;
        }
        this.g = new char[i];
    }

    public char[] e() {
        if (this.d == null) {
            this.d = new ArrayList<>();
        }
        this.e = true;
        this.d.add(this.g);
        int length = this.g.length;
        this.f += length;
        this.h = 0;
        int i = length + (length >> 1);
        if (i < 500) {
            i = 500;
        } else if (i > 65536) {
            i = 65536;
        }
        char[] cArr = new char[i];
        this.g = cArr;
        return cArr;
    }

    public final void f(int i) {
        this.c = -1;
        int i2 = i + 0;
        char[] cArr = this.g;
        if (cArr == null || i2 > cArr.length) {
            BufferRecycler bufferRecycler = this.f678b;
            this.g = bufferRecycler != null ? bufferRecycler.a(2, i2) : new char[Math.max(i2, 500)];
        }
        this.f = 0;
        this.h = 0;
    }

    public String toString() {
        return c();
    }

    public TextBuffer(BufferRecycler bufferRecycler, char[] cArr) {
        this.f678b = null;
        this.g = cArr;
        this.h = cArr.length;
        this.c = -1;
    }
}

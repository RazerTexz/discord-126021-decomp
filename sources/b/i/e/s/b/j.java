package b.i.e.s.b;

import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: Version.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static final int[] a = {31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j[] f1890b = a();
    public final int c;
    public final int[] d;
    public final j$b[] e;
    public final int f;

    public j(int i, int[] iArr, j$b... j_bArr) {
        this.c = i;
        this.d = iArr;
        this.e = j_bArr;
        int i2 = j_bArr[0].a;
        int i3 = 0;
        for (j$a j_a : j_bArr[0].f1892b) {
            i3 += (j_a.f1891b + i2) * j_a.a;
        }
        this.f = i3;
    }

    public static j[] a() {
        return new j[]{new j(1, new int[0], new j$b(7, new j$a(1, 19)), new j$b(10, new j$a(1, 16)), new j$b(13, new j$a(1, 13)), new j$b(17, new j$a(1, 9))), new j(2, new int[]{6, 18}, new j$b(10, new j$a(1, 34)), new j$b(16, new j$a(1, 28)), new j$b(22, new j$a(1, 22)), new j$b(28, new j$a(1, 16))), new j(3, new int[]{6, 22}, new j$b(15, new j$a(1, 55)), new j$b(26, new j$a(1, 44)), new j$b(18, new j$a(2, 17)), new j$b(22, new j$a(2, 13))), new j(4, new int[]{6, 26}, new j$b(20, new j$a(1, 80)), new j$b(18, new j$a(2, 32)), new j$b(26, new j$a(2, 24)), new j$b(16, new j$a(4, 9))), new j(5, new int[]{6, 30}, new j$b(26, new j$a(1, 108)), new j$b(24, new j$a(2, 43)), new j$b(18, new j$a(2, 15), new j$a(2, 16)), new j$b(22, new j$a(2, 11), new j$a(2, 12))), new j(6, new int[]{6, 34}, new j$b(18, new j$a(2, 68)), new j$b(16, new j$a(4, 27)), new j$b(24, new j$a(4, 19)), new j$b(28, new j$a(4, 15))), new j(7, new int[]{6, 22, 38}, new j$b(20, new j$a(2, 78)), new j$b(18, new j$a(4, 31)), new j$b(18, new j$a(2, 14), new j$a(4, 15)), new j$b(26, new j$a(4, 13), new j$a(1, 14))), new j(8, new int[]{6, 24, 42}, new j$b(24, new j$a(2, 97)), new j$b(22, new j$a(2, 38), new j$a(2, 39)), new j$b(22, new j$a(4, 18), new j$a(2, 19)), new j$b(26, new j$a(4, 14), new j$a(2, 15))), new j(9, new int[]{6, 26, 46}, new j$b(30, new j$a(2, 116)), new j$b(22, new j$a(3, 36), new j$a(2, 37)), new j$b(20, new j$a(4, 16), new j$a(4, 17)), new j$b(24, new j$a(4, 12), new j$a(4, 13))), new j(10, new int[]{6, 28, 50}, new j$b(18, new j$a(2, 68), new j$a(2, 69)), new j$b(26, new j$a(4, 43), new j$a(1, 44)), new j$b(24, new j$a(6, 19), new j$a(2, 20)), new j$b(28, new j$a(6, 15), new j$a(2, 16))), new j(11, new int[]{6, 30, 54}, new j$b(20, new j$a(4, 81)), new j$b(30, new j$a(1, 50), new j$a(4, 51)), new j$b(28, new j$a(4, 22), new j$a(4, 23)), new j$b(24, new j$a(3, 12), new j$a(8, 13))), new j(12, new int[]{6, 32, 58}, new j$b(24, new j$a(2, 92), new j$a(2, 93)), new j$b(22, new j$a(6, 36), new j$a(2, 37)), new j$b(26, new j$a(4, 20), new j$a(6, 21)), new j$b(28, new j$a(7, 14), new j$a(4, 15))), new j(13, new int[]{6, 34, 62}, new j$b(26, new j$a(4, 107)), new j$b(22, new j$a(8, 37), new j$a(1, 38)), new j$b(24, new j$a(8, 20), new j$a(4, 21)), new j$b(22, new j$a(12, 11), new j$a(4, 12))), new j(14, new int[]{6, 26, 46, 66}, new j$b(30, new j$a(3, 115), new j$a(1, 116)), new j$b(24, new j$a(4, 40), new j$a(5, 41)), new j$b(20, new j$a(11, 16), new j$a(5, 17)), new j$b(24, new j$a(11, 12), new j$a(5, 13))), new j(15, new int[]{6, 26, 48, 70}, new j$b(22, new j$a(5, 87), new j$a(1, 88)), new j$b(24, new j$a(5, 41), new j$a(5, 42)), new j$b(30, new j$a(5, 24), new j$a(7, 25)), new j$b(24, new j$a(11, 12), new j$a(7, 13))), new j(16, new int[]{6, 26, 50, 74}, new j$b(24, new j$a(5, 98), new j$a(1, 99)), new j$b(28, new j$a(7, 45), new j$a(3, 46)), new j$b(24, new j$a(15, 19), new j$a(2, 20)), new j$b(30, new j$a(3, 15), new j$a(13, 16))), new j(17, new int[]{6, 30, 54, 78}, new j$b(28, new j$a(1, 107), new j$a(5, 108)), new j$b(28, new j$a(10, 46), new j$a(1, 47)), new j$b(28, new j$a(1, 22), new j$a(15, 23)), new j$b(28, new j$a(2, 14), new j$a(17, 15))), new j(18, new int[]{6, 30, 56, 82}, new j$b(30, new j$a(5, 120), new j$a(1, 121)), new j$b(26, new j$a(9, 43), new j$a(4, 44)), new j$b(28, new j$a(17, 22), new j$a(1, 23)), new j$b(28, new j$a(2, 14), new j$a(19, 15))), new j(19, new int[]{6, 30, 58, 86}, new j$b(28, new j$a(3, 113), new j$a(4, 114)), new j$b(26, new j$a(3, 44), new j$a(11, 45)), new j$b(26, new j$a(17, 21), new j$a(4, 22)), new j$b(26, new j$a(9, 13), new j$a(16, 14))), new j(20, new int[]{6, 34, 62, 90}, new j$b(28, new j$a(3, 107), new j$a(5, 108)), new j$b(26, new j$a(3, 41), new j$a(13, 42)), new j$b(30, new j$a(15, 24), new j$a(5, 25)), new j$b(28, new j$a(15, 15), new j$a(10, 16))), new j(21, new int[]{6, 28, 50, 72, 94}, new j$b(28, new j$a(4, 116), new j$a(4, 117)), new j$b(26, new j$a(17, 42)), new j$b(28, new j$a(17, 22), new j$a(6, 23)), new j$b(30, new j$a(19, 16), new j$a(6, 17))), new j(22, new int[]{6, 26, 50, 74, 98}, new j$b(28, new j$a(2, 111), new j$a(7, 112)), new j$b(28, new j$a(17, 46)), new j$b(30, new j$a(7, 24), new j$a(16, 25)), new j$b(24, new j$a(34, 13))), new j(23, new int[]{6, 30, 54, 78, 102}, new j$b(30, new j$a(4, 121), new j$a(5, 122)), new j$b(28, new j$a(4, 47), new j$a(14, 48)), new j$b(30, new j$a(11, 24), new j$a(14, 25)), new j$b(30, new j$a(16, 15), new j$a(14, 16))), new j(24, new int[]{6, 28, 54, 80, 106}, new j$b(30, new j$a(6, 117), new j$a(4, 118)), new j$b(28, new j$a(6, 45), new j$a(14, 46)), new j$b(30, new j$a(11, 24), new j$a(16, 25)), new j$b(30, new j$a(30, 16), new j$a(2, 17))), new j(25, new int[]{6, 32, 58, 84, 110}, new j$b(26, new j$a(8, 106), new j$a(4, 107)), new j$b(28, new j$a(8, 47), new j$a(13, 48)), new j$b(30, new j$a(7, 24), new j$a(22, 25)), new j$b(30, new j$a(22, 15), new j$a(13, 16))), new j(26, new int[]{6, 30, 58, 86, 114}, new j$b(28, new j$a(10, 114), new j$a(2, 115)), new j$b(28, new j$a(19, 46), new j$a(4, 47)), new j$b(28, new j$a(28, 22), new j$a(6, 23)), new j$b(30, new j$a(33, 16), new j$a(4, 17))), new j(27, new int[]{6, 34, 62, 90, 118}, new j$b(30, new j$a(8, 122), new j$a(4, 123)), new j$b(28, new j$a(22, 45), new j$a(3, 46)), new j$b(30, new j$a(8, 23), new j$a(26, 24)), new j$b(30, new j$a(12, 15), new j$a(28, 16))), new j(28, new int[]{6, 26, 50, 74, 98, 122}, new j$b(30, new j$a(3, 117), new j$a(10, 118)), new j$b(28, new j$a(3, 45), new j$a(23, 46)), new j$b(30, new j$a(4, 24), new j$a(31, 25)), new j$b(30, new j$a(11, 15), new j$a(31, 16))), new j(29, new int[]{6, 30, 54, 78, 102, 126}, new j$b(30, new j$a(7, 116), new j$a(7, 117)), new j$b(28, new j$a(21, 45), new j$a(7, 46)), new j$b(30, new j$a(1, 23), new j$a(37, 24)), new j$b(30, new j$a(19, 15), new j$a(26, 16))), new j(30, new int[]{6, 26, 52, 78, 104, 130}, new j$b(30, new j$a(5, 115), new j$a(10, 116)), new j$b(28, new j$a(19, 47), new j$a(10, 48)), new j$b(30, new j$a(15, 24), new j$a(25, 25)), new j$b(30, new j$a(23, 15), new j$a(25, 16))), new j(31, new int[]{6, 30, 56, 82, 108, Opcodes.I2F}, new j$b(30, new j$a(13, 115), new j$a(3, 116)), new j$b(28, new j$a(2, 46), new j$a(29, 47)), new j$b(30, new j$a(42, 24), new j$a(1, 25)), new j$b(30, new j$a(23, 15), new j$a(28, 16))), new j(32, new int[]{6, 34, 60, 86, 112, Opcodes.L2D}, new j$b(30, new j$a(17, 115)), new j$b(28, new j$a(10, 46), new j$a(23, 47)), new j$b(30, new j$a(10, 24), new j$a(35, 25)), new j$b(30, new j$a(19, 15), new j$a(35, 16))), new j(33, new int[]{6, 30, 58, 86, 114, Opcodes.D2I}, new j$b(30, new j$a(17, 115), new j$a(1, 116)), new j$b(28, new j$a(14, 46), new j$a(21, 47)), new j$b(30, new j$a(29, 24), new j$a(19, 25)), new j$b(30, new j$a(11, 15), new j$a(46, 16))), new j(34, new int[]{6, 34, 62, 90, 118, Opcodes.I2C}, new j$b(30, new j$a(13, 115), new j$a(6, 116)), new j$b(28, new j$a(14, 46), new j$a(23, 47)), new j$b(30, new j$a(44, 24), new j$a(7, 25)), new j$b(30, new j$a(59, 16), new j$a(1, 17))), new j(35, new int[]{6, 30, 54, 78, 102, 126, 150}, new j$b(30, new j$a(12, 121), new j$a(7, 122)), new j$b(28, new j$a(12, 47), new j$a(26, 48)), new j$b(30, new j$a(39, 24), new j$a(14, 25)), new j$b(30, new j$a(22, 15), new j$a(41, 16))), new j(36, new int[]{6, 24, 50, 76, 102, 128, 154}, new j$b(30, new j$a(6, 121), new j$a(14, 122)), new j$b(28, new j$a(6, 47), new j$a(34, 48)), new j$b(30, new j$a(46, 24), new j$a(10, 25)), new j$b(30, new j$a(2, 15), new j$a(64, 16))), new j(37, new int[]{6, 28, 54, 80, 106, Opcodes.IINC, 158}, new j$b(30, new j$a(17, 122), new j$a(4, 123)), new j$b(28, new j$a(29, 46), new j$a(14, 47)), new j$b(30, new j$a(49, 24), new j$a(10, 25)), new j$b(30, new j$a(24, 15), new j$a(46, 16))), new j(38, new int[]{6, 32, 58, 84, 110, Opcodes.L2I, Opcodes.IF_ICMPGE}, new j$b(30, new j$a(4, 122), new j$a(18, 123)), new j$b(28, new j$a(13, 46), new j$a(32, 47)), new j$b(30, new j$a(48, 24), new j$a(14, 25)), new j$b(30, new j$a(42, 15), new j$a(32, 16))), new j(39, new int[]{6, 26, 54, 82, 110, Opcodes.L2D, Opcodes.IF_ACMPNE}, new j$b(30, new j$a(20, 117), new j$a(4, 118)), new j$b(28, new j$a(40, 47), new j$a(7, 48)), new j$b(30, new j$a(43, 24), new j$a(22, 25)), new j$b(30, new j$a(10, 15), new j$a(67, 16))), new j(40, new int[]{6, 30, 58, 86, 114, Opcodes.D2I, Opcodes.TABLESWITCH}, new j$b(30, new j$a(19, 118), new j$a(6, 119)), new j$b(28, new j$a(18, 47), new j$a(31, 48)), new j$b(30, new j$a(34, 24), new j$a(34, 25)), new j$b(30, new j$a(20, 15), new j$a(61, 16)))};
    }

    public static j b(int i) {
        int i2 = 0;
        int i3 = 0;
        int i4 = Integer.MAX_VALUE;
        while (true) {
            int[] iArr = a;
            if (i2 >= iArr.length) {
                if (i4 <= 3) {
                    return d(i3);
                }
                return null;
            }
            int i5 = iArr[i2];
            if (i5 == i) {
                return d(i2 + 7);
            }
            int iB = g.b(i, i5);
            if (iB < i4) {
                i3 = i2 + 7;
                i4 = iB;
            }
            i2++;
        }
    }

    public static j d(int i) {
        if (i <= 0 || i > 40) {
            throw new IllegalArgumentException();
        }
        return f1890b[i - 1];
    }

    public int c() {
        return (this.c * 4) + 17;
    }

    public String toString() {
        return String.valueOf(this.c);
    }
}

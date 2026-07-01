package b.i.a.c.x2.i0;

import b.i.a.c.f3.x;
import com.discord.api.permission.Permission;
import java.io.IOException;

/* JADX INFO: compiled from: Sniffer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public static final int[] a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean a(b.i.a.c.x2.i iVar, boolean z2, boolean z3) throws IOException {
        boolean z4;
        boolean z5;
        long jB = iVar.b();
        long j = Permission.SEND_TTS_MESSAGES;
        long j2 = -1;
        if (jB != -1 && jB <= Permission.SEND_TTS_MESSAGES) {
            j = jB;
        }
        int i = (int) j;
        x xVar = new x(64);
        boolean z6 = false;
        int i2 = 0;
        boolean z7 = false;
        while (true) {
            if (i2 < i) {
                xVar.A(8);
                if (iVar.e(xVar.a, z6 ? 1 : 0, 8, true)) {
                    long jU = xVar.u();
                    int iF = xVar.f();
                    int i3 = 16;
                    if (jU == 1) {
                        iVar.o(xVar.a, 8, 8);
                        xVar.D(16);
                        jU = xVar.m();
                    } else {
                        if (jU == 0) {
                            long jB2 = iVar.b();
                            if (jB2 != j2) {
                                jU = (jB2 - iVar.f()) + ((long) 8);
                            }
                        }
                        i3 = 8;
                    }
                    long j3 = i3;
                    if (jU < j3) {
                        return z6;
                    }
                    i2 += i3;
                    if (iF == 1836019574) {
                        i += (int) jU;
                        if (jB != -1 && i > jB) {
                            i = (int) jB;
                        }
                        j2 = -1;
                    } else {
                        if (iF == 1836019558 || iF == 1836475768) {
                            z4 = true;
                            return !z7 && z2 == z4;
                        }
                        long j4 = jB;
                        if ((((long) i2) + jU) - j3 < i) {
                            int i4 = (int) (jU - j3);
                            i2 += i4;
                            if (iF == 1718909296) {
                                if (i4 < 8) {
                                    return false;
                                }
                                xVar.A(i4);
                                iVar.o(xVar.a, 0, i4);
                                int i5 = i4 / 4;
                                for (int i6 = 0; i6 < i5; i6++) {
                                    if (i6 != 1) {
                                        int iF2 = xVar.f();
                                        if ((iF2 >>> 8) == 3368816 || (iF2 == 1751476579 && z3)) {
                                            z5 = true;
                                            break;
                                        }
                                        int[] iArr = a;
                                        int length = iArr.length;
                                        int i7 = 0;
                                        while (true) {
                                            if (i7 >= length) {
                                                z5 = false;
                                                break;
                                            }
                                            if (iArr[i7] == iF2) {
                                                z5 = true;
                                                break;
                                            }
                                            i7++;
                                        }
                                        if (z5) {
                                            z7 = true;
                                            break;
                                        }
                                    } else {
                                        xVar.F(4);
                                    }
                                }
                                if (!z7) {
                                    return false;
                                }
                            } else if (i4 != 0) {
                                iVar.g(i4);
                            }
                            jB = j4;
                            j2 = -1;
                            z6 = false;
                        }
                    }
                }
            }
            z4 = false;
            if (z7) {
            }
        }
    }
}

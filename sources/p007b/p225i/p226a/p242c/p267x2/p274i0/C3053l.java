package p007b.p225i.p226a.p242c.p267x2.p274i0;

import com.discord.api.permission.Permission;
import java.io.IOException;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;

/* JADX INFO: renamed from: b.i.a.c.x2.i0.l */
/* JADX INFO: compiled from: Sniffer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3053l {

    /* JADX INFO: renamed from: a */
    public static final int[] f8459a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    /* JADX INFO: renamed from: a */
    public static boolean m3730a(InterfaceC3041i interfaceC3041i, boolean z2, boolean z3) throws IOException {
        boolean z4;
        boolean z5;
        long jMo3642b = interfaceC3041i.mo3642b();
        long j = Permission.SEND_TTS_MESSAGES;
        long j2 = -1;
        if (jMo3642b != -1 && jMo3642b <= Permission.SEND_TTS_MESSAGES) {
            j = jMo3642b;
        }
        int i = (int) j;
        C2757x c2757x = new C2757x(64);
        boolean z6 = false;
        int i2 = 0;
        boolean z7 = false;
        while (true) {
            if (i2 < i) {
                c2757x.m3075A(8);
                if (interfaceC3041i.mo3644e(c2757x.f6793a, z6 ? 1 : 0, 8, true)) {
                    long jM3101u = c2757x.m3101u();
                    int iM3086f = c2757x.m3086f();
                    int i3 = 16;
                    if (jM3101u == 1) {
                        interfaceC3041i.mo3652o(c2757x.f6793a, 8, 8);
                        c2757x.m3078D(16);
                        jM3101u = c2757x.m3093m();
                    } else {
                        if (jM3101u == 0) {
                            long jMo3642b2 = interfaceC3041i.mo3642b();
                            if (jMo3642b2 != j2) {
                                jM3101u = (jMo3642b2 - interfaceC3041i.mo3645f()) + ((long) 8);
                            }
                        }
                        i3 = 8;
                    }
                    long j3 = i3;
                    if (jM3101u < j3) {
                        return z6;
                    }
                    i2 += i3;
                    if (iM3086f == 1836019574) {
                        i += (int) jM3101u;
                        if (jMo3642b != -1 && i > jMo3642b) {
                            i = (int) jMo3642b;
                        }
                        j2 = -1;
                    } else {
                        if (iM3086f == 1836019558 || iM3086f == 1836475768) {
                            z4 = true;
                            return !z7 && z2 == z4;
                        }
                        long j4 = jMo3642b;
                        if ((((long) i2) + jM3101u) - j3 < i) {
                            int i4 = (int) (jM3101u - j3);
                            i2 += i4;
                            if (iM3086f == 1718909296) {
                                if (i4 < 8) {
                                    return false;
                                }
                                c2757x.m3075A(i4);
                                interfaceC3041i.mo3652o(c2757x.f6793a, 0, i4);
                                int i5 = i4 / 4;
                                for (int i6 = 0; i6 < i5; i6++) {
                                    if (i6 != 1) {
                                        int iM3086f2 = c2757x.m3086f();
                                        if ((iM3086f2 >>> 8) == 3368816 || (iM3086f2 == 1751476579 && z3)) {
                                            z5 = true;
                                            break;
                                        }
                                        int[] iArr = f8459a;
                                        int length = iArr.length;
                                        int i7 = 0;
                                        while (true) {
                                            if (i7 >= length) {
                                                z5 = false;
                                                break;
                                            }
                                            if (iArr[i7] == iM3086f2) {
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
                                        c2757x.m3080F(4);
                                    }
                                }
                                if (!z7) {
                                    return false;
                                }
                            } else if (i4 != 0) {
                                interfaceC3041i.mo3646g(i4);
                            }
                            jMo3642b = j4;
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

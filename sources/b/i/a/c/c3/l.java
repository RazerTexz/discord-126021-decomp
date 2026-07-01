package b.i.a.c.c3;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import b.i.a.c.a3.a0$a;
import b.i.a.c.a3.n0;
import b.i.a.c.a3.o0;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.t;
import b.i.a.c.g2;
import b.i.a.c.h2;
import b.i.a.c.j1;
import b.i.a.c.o2;
import b.i.a.c.p2;
import b.i.a.c.p2$a;
import b.i.a.c.v0;
import b.i.b.b.c0;
import b.i.b.b.d0;
import b.i.b.b.f0;
import b.i.b.b.g$a;
import b.i.b.b.h0;
import b.i.b.b.n$b;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/* JADX INFO: compiled from: MappingTrackSelector.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l extends q {
    @Override // b.i.a.c.c3.q
    public final void a(@Nullable Object obj) {
    }

    /* JADX WARN: Code duplicated, block: B:110:0x028d A[LOOP:8: B:67:0x0159->B:110:0x028d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:229:0x04bc  */
    /* JADX WARN: Code duplicated, block: B:330:0x06d7  */
    /* JADX WARN: Code duplicated, block: B:458:0x095e  */
    /* JADX WARN: Code duplicated, block: B:489:0x09b6  */
    /* JADX WARN: Code duplicated, block: B:541:0x0287 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // b.i.a.c.c3.q
    public final r b(g2[] g2VarArr, o0 o0Var, a0$a a0_a, o2 o2Var) throws ExoPlaybackException {
        int i;
        boolean z2;
        boolean z3;
        j fVar;
        int[] iArr;
        String str;
        h$d h_d;
        Pair pairCreate;
        int[][] iArr2;
        n0 n0Var;
        String str2;
        int[][] iArr3;
        l$a l_a;
        int i2;
        int i3;
        h$d h_d2;
        String str3;
        j$a j_a;
        Pair pairCreate2;
        int i4;
        int[] iArr4;
        int i5;
        int i6;
        String str4;
        int i7;
        n0 n0Var2;
        h hVar;
        int i8;
        j$a[] j_aArr;
        int i9;
        int[][][] iArr5;
        int[] iArr6;
        h$d h_d3;
        boolean z4;
        l$a l_a2;
        h$d h_d4;
        o0 o0Var2;
        int[][] iArr7;
        j$a j_a2;
        List<Integer> list;
        ArrayList arrayList;
        String str5;
        int[] iArrQ1;
        ArrayList arrayList2;
        HashSet hashSet;
        int i10;
        int[] iArr8;
        o0 o0Var3 = o0Var;
        int[] iArr9 = new int[g2VarArr.length + 1];
        int length = g2VarArr.length + 1;
        n0[][] n0VarArr = new n0[length][];
        int[][][] iArr10 = new int[g2VarArr.length + 1][][];
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            int i13 = o0Var3.k;
            n0VarArr[i12] = new n0[i13];
            iArr10[i12] = new int[i13][];
        }
        int length2 = g2VarArr.length;
        int[] iArr11 = new int[length2];
        for (int i14 = 0; i14 < length2; i14++) {
            iArr11[i14] = g2VarArr[i14].p();
        }
        int i15 = 0;
        while (i15 < o0Var3.k) {
            n0 n0Var3 = o0Var3.l[i15];
            boolean z5 = t.g(n0Var3.l[i11].w) == 5;
            int length3 = g2VarArr.length;
            int i16 = 0;
            int i17 = 0;
            boolean z6 = true;
            while (i16 < g2VarArr.length) {
                g2 g2Var = g2VarArr[i16];
                int iMax = 0;
                while (i11 < n0Var3.k) {
                    iMax = Math.max(iMax, g2Var.a(n0Var3.l[i11]) & 7);
                    i11++;
                }
                boolean z7 = iArr9[i16] == 0;
                if (iMax > i17 || (iMax == i17 && z5 && !z6 && z7)) {
                    z6 = z7;
                    i17 = iMax;
                    length3 = i16;
                }
                i16++;
                i11 = 0;
            }
            if (length3 == g2VarArr.length) {
                iArr8 = new int[n0Var3.k];
            } else {
                g2 g2Var2 = g2VarArr[length3];
                int[] iArr12 = new int[n0Var3.k];
                for (int i18 = 0; i18 < n0Var3.k; i18++) {
                    iArr12[i18] = g2Var2.a(n0Var3.l[i18]);
                }
                iArr8 = iArr12;
            }
            int i19 = iArr9[length3];
            n0VarArr[length3][i19] = n0Var3;
            iArr10[length3][i19] = iArr8;
            iArr9[length3] = iArr9[length3] + 1;
            i15++;
            o0Var3 = o0Var;
            i11 = 0;
        }
        o0[] o0VarArr = new o0[g2VarArr.length];
        String[] strArr = new String[g2VarArr.length];
        int[] iArr13 = new int[g2VarArr.length];
        for (int i20 = 0; i20 < g2VarArr.length; i20++) {
            int i21 = iArr9[i20];
            o0VarArr[i20] = new o0((n0[]) e0.D(n0VarArr[i20], i21));
            iArr10[i20] = (int[][]) e0.D(iArr10[i20], i21);
            strArr[i20] = g2VarArr[i20].getName();
            iArr13[i20] = ((v0) g2VarArr[i20]).j;
        }
        l$a l_a3 = new l$a(strArr, iArr13, o0VarArr, iArr11, iArr10, new o0((n0[]) e0.D(n0VarArr[g2VarArr.length], iArr9[g2VarArr.length])));
        h hVar2 = (h) this;
        h$d h_d5 = hVar2.f.get();
        int i22 = l_a3.a;
        j$a[] j_aArr2 = new j$a[i22];
        l$a l_a4 = l_a3;
        h$d h_d6 = h_d5;
        int i23 = 0;
        boolean z8 = false;
        boolean z9 = false;
        while (i23 < i22) {
            if (2 == l_a4.f903b[i23]) {
                if (z9) {
                    hVar = hVar2;
                    i8 = i22;
                    j_aArr = j_aArr2;
                    i9 = i23;
                    iArr5 = iArr10;
                    z4 = z8;
                    iArr6 = iArr11;
                    h_d3 = h_d5;
                } else {
                    o0 o0Var4 = l_a4.c[i23];
                    int[][] iArr14 = iArr10[i23];
                    int i24 = iArr11[i23];
                    if (h_d6.F || h_d6.E) {
                        l_a2 = l_a3;
                        hVar = hVar2;
                        h_d4 = h_d5;
                        i8 = i22;
                        j_aArr = j_aArr2;
                        i9 = i23;
                        iArr5 = iArr10;
                        z4 = z8;
                        o0Var2 = o0Var4;
                        iArr7 = iArr14;
                        iArr6 = iArr11;
                        j_a2 = null;
                        break;
                    }
                    int i25 = h_d6.M ? 24 : 16;
                    boolean z10 = h_d6.L && (i24 & i25) != 0;
                    h$d h_d7 = h_d6;
                    int i26 = 0;
                    while (true) {
                        if (i26 >= o0Var4.k) {
                            l_a2 = l_a3;
                            hVar = hVar2;
                            h_d4 = h_d5;
                            i8 = i22;
                            j_aArr = j_aArr2;
                            i9 = i23;
                            iArr5 = iArr10;
                            z4 = z8;
                            o0Var2 = o0Var4;
                            iArr7 = iArr14;
                            iArr6 = iArr11;
                            j_a2 = null;
                            break;
                        }
                        n0 n0Var4 = o0Var4.l[i26];
                        int[] iArr15 = iArr14[i26];
                        hVar = hVar2;
                        int i27 = h_d7.k;
                        iArr6 = iArr11;
                        int i28 = h_d7.l;
                        iArr5 = iArr10;
                        int i29 = h_d7.m;
                        i8 = i22;
                        int i30 = h_d7.n;
                        z4 = z8;
                        int i31 = h_d7.o;
                        l_a2 = l_a3;
                        int i32 = h_d7.p;
                        j_aArr = j_aArr2;
                        int i33 = h_d7.q;
                        i9 = i23;
                        int i34 = h_d7.r;
                        iArr7 = iArr14;
                        int i35 = h_d7.f905s;
                        h_d4 = h_d5;
                        int i36 = h_d7.t;
                        boolean z11 = h_d7.u;
                        o0Var2 = o0Var4;
                        int i37 = i26;
                        if (n0Var4.k < 2) {
                            iArrQ1 = h.f898b;
                        } else {
                            List<Integer> listD = h.d(n0Var4, i35, i36, z11);
                            ArrayList arrayList3 = (ArrayList) listD;
                            if (arrayList3.size() < 2) {
                                iArrQ1 = h.f898b;
                            } else {
                                if (z10) {
                                    list = listD;
                                    arrayList = arrayList3;
                                    str5 = null;
                                } else {
                                    HashSet hashSet2 = new HashSet();
                                    int i38 = 0;
                                    int i39 = 0;
                                    str5 = null;
                                    while (i39 < arrayList3.size()) {
                                        List<Integer> list2 = listD;
                                        String str6 = n0Var4.l[((Integer) arrayList3.get(i39)).intValue()].w;
                                        if (hashSet2.add(str6)) {
                                            hashSet = hashSet2;
                                            i10 = i39;
                                            int i40 = 0;
                                            int i41 = 0;
                                            while (i41 < arrayList3.size()) {
                                                int iIntValue = ((Integer) arrayList3.get(i41)).intValue();
                                                ArrayList arrayList4 = arrayList3;
                                                if (h.f(n0Var4.l[iIntValue], str6, iArr15[iIntValue], i25, i27, i28, i29, i30, i31, i32, i33, i34)) {
                                                    i40++;
                                                }
                                                i41++;
                                                arrayList3 = arrayList4;
                                            }
                                            arrayList2 = arrayList3;
                                            if (i40 > i38) {
                                                str5 = str6;
                                                i38 = i40;
                                            }
                                        } else {
                                            arrayList2 = arrayList3;
                                            hashSet = hashSet2;
                                            i10 = i39;
                                        }
                                        i39 = i10 + 1;
                                        listD = list2;
                                        hashSet2 = hashSet;
                                        arrayList3 = arrayList2;
                                    }
                                    list = listD;
                                    arrayList = arrayList3;
                                }
                                int size = arrayList.size();
                                while (true) {
                                    size--;
                                    if (size < 0) {
                                        break;
                                    }
                                    ArrayList arrayList5 = arrayList;
                                    int iIntValue2 = ((Integer) arrayList5.get(size)).intValue();
                                    if (!h.f(n0Var4.l[iIntValue2], str5, iArr15[iIntValue2], i25, i27, i28, i29, i30, i31, i32, i33, i34)) {
                                        arrayList5.remove(size);
                                    }
                                    arrayList = arrayList5;
                                }
                                iArrQ1 = arrayList.size() < 2 ? h.f898b : b.i.a.f.e.o.f.q1(list);
                            }
                            if (iArrQ1.length > 0) {
                                j_a2 = new j$a(n0Var4, iArrQ1);
                                break;
                            }
                            i26 = i37 + 1;
                            hVar2 = hVar;
                            iArr11 = iArr6;
                            iArr10 = iArr5;
                            i22 = i8;
                            z8 = z4;
                            l_a3 = l_a2;
                            j_aArr2 = j_aArr;
                            i23 = i9;
                            iArr14 = iArr7;
                            h_d5 = h_d4;
                            h_d7 = h_d5;
                            o0Var4 = o0Var2;
                            z10 = z10;
                        }
                        z10 = z10;
                        if (iArrQ1.length > 0) {
                            j_a2 = new j$a(n0Var4, iArrQ1);
                            break;
                        }
                        i26 = i37 + 1;
                        hVar2 = hVar;
                        iArr11 = iArr6;
                        iArr10 = iArr5;
                        i22 = i8;
                        z8 = z4;
                        l_a3 = l_a2;
                        j_aArr2 = j_aArr;
                        i23 = i9;
                        iArr14 = iArr7;
                        h_d5 = h_d4;
                        h_d7 = h_d5;
                        o0Var4 = o0Var2;
                        z10 = z10;
                    }
                    if (j_a2 == null) {
                        o0 o0Var5 = o0Var2;
                        n0 n0Var5 = null;
                        h$h h_h = null;
                        int i42 = 0;
                        int i43 = -1;
                        while (i42 < o0Var5.k) {
                            n0 n0Var6 = o0Var5.l[i42];
                            h$d h_d8 = h_d4;
                            List<Integer> listD2 = h.d(n0Var6, h_d8.f905s, h_d8.t, h_d8.u);
                            int[] iArr16 = iArr7[i42];
                            h$h h_h2 = h_h;
                            n0 n0Var7 = n0Var5;
                            for (int i44 = 0; i44 < n0Var6.k; i44++) {
                                j1 j1Var = n0Var6.l[i44];
                                if ((j1Var.p & 16384) == 0 && h.e(iArr16[i44], h_d8.R)) {
                                    h$h h_h3 = new h$h(j1Var, h_d8, iArr16[i44], ((ArrayList) listD2).contains(Integer.valueOf(i44)));
                                    if ((h_h3.j || h_d8.K) && (h_h2 == null || h_h3.f(h_h2) > 0)) {
                                        i43 = i44;
                                        n0Var7 = n0Var6;
                                        h_h2 = h_h3;
                                    }
                                }
                            }
                            i42++;
                            n0Var5 = n0Var7;
                            h_d4 = h_d8;
                            h_h = h_h2;
                        }
                        h_d3 = h_d4;
                        j_a2 = n0Var5 == null ? null : new j$a(n0Var5, i43);
                    } else {
                        h_d3 = h_d4;
                    }
                    j_aArr[i9] = j_a2;
                    z9 = j_aArr[i9] != null;
                    h_d6 = h_d3;
                    l_a3 = l_a2;
                }
                l_a4 = l_a3;
                z8 = z4 | (l_a3.c[i9].k > 0);
            } else {
                hVar = hVar2;
                i8 = i22;
                j_aArr = j_aArr2;
                i9 = i23;
                iArr5 = iArr10;
                iArr6 = iArr11;
                h_d3 = h_d5;
            }
            h_d5 = h_d3;
            iArr11 = iArr6;
            iArr10 = iArr5;
            i22 = i8;
            j_aArr2 = j_aArr;
            i23 = i9 + 1;
            hVar2 = hVar;
        }
        h hVar3 = hVar2;
        h$d h_d9 = h_d5;
        j$a[] j_aArr3 = j_aArr2;
        int[][][] iArr17 = iArr10;
        boolean z12 = z8;
        int[] iArr18 = iArr11;
        int i45 = i22;
        h$b h_b = null;
        int i46 = -1;
        int i47 = 0;
        String str7 = null;
        while (i47 < i45) {
            if (1 == l_a4.f903b[i47]) {
                boolean z13 = h_d6.T || !z12;
                o0 o0Var6 = l_a4.c[i47];
                int[][] iArr19 = iArr17[i47];
                int i48 = iArr18[i47];
                h$b h_b2 = null;
                int i49 = -1;
                int i50 = -1;
                int i51 = 0;
                while (i51 < o0Var6.k) {
                    n0 n0Var8 = o0Var6.l[i51];
                    int[] iArr20 = iArr19[i51];
                    int i52 = i49;
                    int i53 = i50;
                    h$b h_b3 = h_b2;
                    int i54 = 0;
                    while (i54 < n0Var8.k) {
                        String str8 = str7;
                        if (h.e(iArr20[i54], h_d6.R)) {
                            n0Var2 = n0Var8;
                            h$b h_b4 = new h$b(n0Var8.l[i54], h_d6, iArr20[i54]);
                            if ((h_b4.j || h_d6.N) && (h_b3 == null || h_b4.f(h_b3) > 0)) {
                                i53 = i54;
                                h_b3 = h_b4;
                                i52 = i51;
                            }
                        } else {
                            n0Var2 = n0Var8;
                        }
                        i54++;
                        str7 = str8;
                        n0Var8 = n0Var2;
                    }
                    i51++;
                    h_b2 = h_b3;
                    i50 = i53;
                    i49 = i52;
                }
                str3 = str7;
                if (i49 == -1) {
                    l_a = l_a3;
                    i2 = i47;
                    i3 = i45;
                    h_d2 = h_d9;
                    pairCreate2 = null;
                } else {
                    n0 n0Var9 = o0Var6.l[i49];
                    if (h_d6.F || h_d6.E || !z13) {
                        l_a = l_a3;
                        i2 = i47;
                        i3 = i45;
                        h_d2 = h_d9;
                    } else {
                        int[] iArr21 = iArr19[i49];
                        int i55 = h_d6.f908z;
                        boolean z14 = h_d6.O;
                        boolean z15 = h_d6.P;
                        boolean z16 = h_d6.Q;
                        j1 j1Var2 = n0Var9.l[i50];
                        int[] iArr22 = new int[n0Var9.k];
                        l_a = l_a3;
                        i3 = i45;
                        h_d2 = h_d9;
                        int i56 = 0;
                        int i57 = 0;
                        while (i57 < n0Var9.k) {
                            if (i57 != i50) {
                                j1 j1Var3 = n0Var9.l[i57];
                                i4 = i47;
                                iArr4 = iArr21;
                                if (h.e(iArr21[i57], false) && (i5 = j1Var3.f1017s) != -1 && i5 <= i55 && (z16 || ((i7 = j1Var3.J) != -1 && i7 == j1Var2.J)) && ((z14 || ((str4 = j1Var3.w) != null && TextUtils.equals(str4, j1Var2.w))) && (z15 || ((i6 = j1Var3.K) != -1 && i6 == j1Var2.K)))) {
                                }
                                i57++;
                                i47 = i4;
                                iArr21 = iArr4;
                            } else {
                                i4 = i47;
                                iArr4 = iArr21;
                            }
                            iArr22[i56] = i57;
                            i56++;
                            i57++;
                            i47 = i4;
                            iArr21 = iArr4;
                        }
                        i2 = i47;
                        int[] iArrCopyOf = Arrays.copyOf(iArr22, i56);
                        j_a = iArrCopyOf.length > 1 ? new j$a(n0Var9, iArrCopyOf) : null;
                        if (j_a == null) {
                            j_a = new j$a(n0Var9, i50);
                        }
                        Objects.requireNonNull(h_b2);
                        pairCreate2 = Pair.create(j_a, h_b2);
                    }
                    if (j_a == null) {
                        j_a = new j$a(n0Var9, i50);
                    }
                    Objects.requireNonNull(h_b2);
                    pairCreate2 = Pair.create(j_a, h_b2);
                }
                if (pairCreate2 != null && (h_b == null || ((h$b) pairCreate2.second).f(h_b) > 0)) {
                    if (i46 != -1) {
                        j_aArr3[i46] = null;
                    }
                    j$a j_a3 = (j$a) pairCreate2.first;
                    j_aArr3[i2] = j_a3;
                    str7 = j_a3.a.l[j_a3.f902b[0]].n;
                    i46 = i2;
                    h_b = (h$b) pairCreate2.second;
                }
                i47 = i2 + 1;
                i45 = i3;
                l_a3 = l_a;
                l_a4 = l_a3;
                h_d9 = h_d2;
                h_d6 = h_d9;
            } else {
                l_a = l_a3;
                i2 = i47;
                i3 = i45;
                h_d2 = h_d9;
                str3 = str7;
            }
            str7 = str3;
            i47 = i2 + 1;
            i45 = i3;
            l_a3 = l_a;
            l_a4 = l_a3;
            h_d9 = h_d2;
            h_d6 = h_d9;
        }
        l$a l_a5 = l_a3;
        h$d h_d10 = h_d9;
        String str9 = str7;
        int i58 = i45;
        int i59 = -1;
        int i60 = 0;
        h$g h_g = null;
        while (i60 < i58) {
            l$a l_a6 = l_a5;
            int i61 = l_a6.f903b[i60];
            if (i61 == 1 || i61 == 2) {
                str = str9;
                h_d = h_d10;
            } else if (i61 != 3) {
                o0 o0Var7 = l_a6.c[i60];
                int[][] iArr23 = iArr17[i60];
                n0 n0Var10 = null;
                h$c h_c = null;
                int i62 = 0;
                int i63 = 0;
                while (i62 < o0Var7.k) {
                    n0 n0Var11 = o0Var7.l[i62];
                    int[] iArr24 = iArr23[i62];
                    int i64 = i63;
                    h$c h_c2 = h_c;
                    n0 n0Var12 = n0Var10;
                    int i65 = 0;
                    while (i65 < n0Var11.k) {
                        o0 o0Var8 = o0Var7;
                        h$d h_d11 = h_d10;
                        if (h.e(iArr24[i65], h_d11.R)) {
                            iArr3 = iArr23;
                            h$c h_c3 = new h$c(n0Var11.l[i65], iArr24[i65]);
                            if (h_c2 == null || h_c3.f(h_c2) > 0) {
                                i64 = i65;
                                n0Var12 = n0Var11;
                                h_c2 = h_c3;
                            }
                        } else {
                            iArr3 = iArr23;
                        }
                        i65++;
                        h_d10 = h_d11;
                        o0Var7 = o0Var8;
                        iArr23 = iArr3;
                    }
                    i62++;
                    n0Var10 = n0Var12;
                    h_c = h_c2;
                    i63 = i64;
                }
                h_d = h_d10;
                j_aArr3[i60] = n0Var10 == null ? null : new j$a(n0Var10, i63);
                str = str9;
            } else {
                h_d = h_d10;
                o0 o0Var9 = l_a6.c[i60];
                int[][] iArr25 = iArr17[i60];
                n0 n0Var13 = null;
                h$g h_g2 = null;
                int i66 = -1;
                int i67 = 0;
                while (i67 < o0Var9.k) {
                    n0 n0Var14 = o0Var9.l[i67];
                    int[] iArr26 = iArr25[i67];
                    int i68 = i66;
                    h$g h_g3 = h_g2;
                    n0 n0Var15 = n0Var13;
                    int i69 = 0;
                    while (i69 < n0Var14.k) {
                        o0 o0Var10 = o0Var9;
                        if (h.e(iArr26[i69], h_d.R)) {
                            iArr2 = iArr25;
                            n0Var = n0Var14;
                            str2 = str9;
                            h$g h_g4 = new h$g(n0Var14.l[i69], h_d, iArr26[i69], str2);
                            if (h_g4.j && (h_g3 == null || h_g4.f(h_g3) > 0)) {
                                i68 = i69;
                                h_g3 = h_g4;
                                n0Var15 = n0Var;
                            }
                        } else {
                            iArr2 = iArr25;
                            n0Var = n0Var14;
                            str2 = str9;
                        }
                        i69++;
                        str9 = str2;
                        o0Var9 = o0Var10;
                        iArr25 = iArr2;
                        n0Var14 = n0Var;
                    }
                    i67++;
                    n0Var13 = n0Var15;
                    h_g2 = h_g3;
                    i66 = i68;
                }
                str = str9;
                if (n0Var13 == null) {
                    pairCreate = null;
                } else {
                    j$a j_a4 = new j$a(n0Var13, i66);
                    Objects.requireNonNull(h_g2);
                    pairCreate = Pair.create(j_a4, h_g2);
                }
                if (pairCreate != null && (h_g == null || ((h$g) pairCreate.second).f(h_g) > 0)) {
                    if (i59 != -1) {
                        j_aArr3[i59] = null;
                    }
                    j_aArr3[i60] = (j$a) pairCreate.first;
                    h_g = (h$g) pairCreate.second;
                    i59 = i60;
                }
            }
            i60++;
            l_a5 = l_a6;
            str9 = str;
            h_d10 = h_d;
        }
        l$a l_a7 = l_a5;
        h$d h_d12 = h_d10;
        for (int i70 = 0; i70 < i58; i70++) {
            j$a j_a5 = j_aArr3[i70];
            int i71 = l_a7.f903b[i70];
            if (h_d12.V.get(i70) || h_d12.H.contains(Integer.valueOf(i71))) {
                j_a5 = null;
            } else {
                o0 o0Var11 = l_a7.c[i70];
                Map<o0, h$f> map = h_d12.U.get(i70);
                if (map != null && map.containsKey(o0Var11)) {
                    Map<o0, h$f> map2 = h_d12.U.get(i70);
                    h$f h_f = map2 != null ? map2.get(o0Var11) : null;
                    if (h_f == null) {
                        j_a5 = null;
                    } else {
                        j_a5 = new j$a(o0Var11.l[h_f.j], h_f.k, h_f.l);
                    }
                } else {
                    for (int i72 = 0; i72 < o0Var11.k; i72++) {
                        n0 n0Var16 = o0Var11.l[i72];
                        o$a o_a = h_d12.G.l.get(n0Var16);
                        if (o_a != null) {
                            j_a5 = new j$a(n0Var16, b.i.a.f.e.o.f.q1(o_a.l));
                            break;
                        }
                    }
                }
            }
            j_aArr3[i70] = j_a5;
        }
        j$b j_b = hVar3.e;
        b.i.a.c.e3.f fVar2 = hVar3.a;
        Objects.requireNonNull(fVar2);
        Objects.requireNonNull((f$b) j_b);
        ArrayList arrayList6 = new ArrayList();
        for (int i73 = 0; i73 < i58; i73++) {
            if (j_aArr3[i73] == null || j_aArr3[i73].f902b.length <= 1) {
                arrayList6.add(null);
            } else {
                b.i.b.b.a<Object> aVar = b.i.b.b.p.k;
                b.i.b.b.p$a p_a = new b.i.b.b.p$a();
                p_a.b(new f$a(0L, 0L));
                arrayList6.add(p_a);
            }
        }
        long[][] jArr = new long[i58][];
        for (int i74 = 0; i74 < i58; i74++) {
            j$a j_a6 = j_aArr3[i74];
            if (j_a6 == null) {
                jArr[i74] = new long[0];
            } else {
                jArr[i74] = new long[j_a6.f902b.length];
                int i75 = 0;
                while (true) {
                    int[] iArr27 = j_a6.f902b;
                    if (i75 >= iArr27.length) {
                        break;
                    }
                    jArr[i74][i75] = j_a6.a.l[iArr27[i75]].f1017s;
                    i75++;
                }
                Arrays.sort(jArr[i74]);
            }
        }
        int[] iArr28 = new int[i58];
        long[] jArr2 = new long[i58];
        for (int i76 = 0; i76 < i58; i76++) {
            jArr2[i76] = jArr[i76].length == 0 ? 0L : jArr[i76][0];
        }
        f.m(arrayList6, jArr2);
        f0 f0Var = f0.j;
        b.i.a.f.e.o.f.A(2, "expectedValuesPerKey");
        d0 d0Var = new d0(new TreeMap(f0Var), new c0(2));
        int i77 = 0;
        while (i77 < i58) {
            if (jArr[i77].length <= 1) {
                iArr = iArr28;
            } else {
                int length4 = jArr[i77].length;
                double[] dArr = new double[length4];
                int i78 = 0;
                while (true) {
                    double dLog = 0.0d;
                    if (i78 >= jArr[i77].length) {
                        break;
                    }
                    if (jArr[i77][i78] != -1) {
                        dLog = Math.log(jArr[i77][i78]);
                    }
                    dArr[i78] = dLog;
                    i78++;
                    iArr28 = iArr28;
                }
                iArr = iArr28;
                int i79 = length4 - 1;
                double d = dArr[i79] - dArr[0];
                int i80 = 0;
                while (i80 < i79) {
                    double d2 = dArr[i80];
                    i80++;
                    Object objValueOf = Double.valueOf(d == 0.0d ? 1.0d : (((d2 + dArr[i80]) * 0.5d) - dArr[0]) / d);
                    int i81 = i79;
                    Integer numValueOf = Integer.valueOf(i77);
                    double d3 = d;
                    Collection collection = (Collection) d0Var.m.get(objValueOf);
                    if (collection == null) {
                        Collection collectionE = d0Var.e();
                        if (!collectionE.add(numValueOf)) {
                            throw new AssertionError("New Collection violated the Collection spec");
                        }
                        d0Var.n++;
                        d0Var.m.put((K) objValueOf, (Collection<V>) collectionE);
                    } else if (collection.add(numValueOf)) {
                        d0Var.n++;
                    }
                    i79 = i81;
                    d = d3;
                }
            }
            i77++;
            iArr28 = iArr;
        }
        int[] iArr29 = iArr28;
        Collection g_a = d0Var.k;
        if (g_a == null) {
            g_a = new g$a(d0Var);
            d0Var.k = g_a;
        }
        b.i.b.b.p pVarN = b.i.b.b.p.n(g_a);
        for (int i82 = 0; i82 < pVarN.size(); i82++) {
            int iIntValue3 = ((Integer) pVarN.get(i82)).intValue();
            int i83 = iArr29[iIntValue3] + 1;
            iArr29[iIntValue3] = i83;
            jArr2[iIntValue3] = jArr[iIntValue3][i83];
            f.m(arrayList6, jArr2);
        }
        for (int i84 = 0; i84 < i58; i84++) {
            if (arrayList6.get(i84) != null) {
                jArr2[i84] = jArr2[i84] * 2;
            }
        }
        f.m(arrayList6, jArr2);
        b.i.a.f.e.o.f.A(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        int i85 = 0;
        int i86 = 0;
        while (i85 < arrayList6.size()) {
            b.i.b.b.p$a p_a2 = (b.i.b.b.p$a) arrayList6.get(i85);
            b.i.b.b.p<Object> pVarC = p_a2 == null ? h0.l : p_a2.c();
            Objects.requireNonNull(pVarC);
            int i87 = i86 + 1;
            if (objArrCopyOf.length < i87) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, n$b.a(objArrCopyOf.length, i87));
            }
            objArrCopyOf[i86] = pVarC;
            i85++;
            i86 = i87;
        }
        b.i.b.b.p pVarL = b.i.b.b.p.l(objArrCopyOf, i86);
        j[] jVarArr = new j[i58];
        for (int i88 = 0; i88 < i58; i88++) {
            j$a j_a7 = j_aArr3[i88];
            if (j_a7 != null) {
                int[] iArr30 = j_a7.f902b;
                if (iArr30.length != 0) {
                    if (iArr30.length == 1) {
                        fVar = new k(j_a7.a, iArr30[0], j_a7.c);
                    } else {
                        long j = 25000;
                        fVar = new f(j_a7.a, iArr30, j_a7.c, fVar2, 10000, j, j, 1279, 719, 0.7f, 0.75f, (b.i.b.b.p) pVarL.get(i88), b.i.a.c.f3.g.a);
                    }
                    jVarArr[i88] = fVar;
                }
            }
        }
        h2[] h2VarArr = new h2[i58];
        for (int i89 = 0; i89 < i58; i89++) {
            h2VarArr[i89] = !(h_d12.V.get(i89) || h_d12.H.contains(Integer.valueOf(l_a7.f903b[i89]))) && (l_a7.f903b[i89] == -2 || jVarArr[i89] != null) ? h2.a : null;
        }
        if (h_d12.S) {
            int i90 = 0;
            int i91 = -1;
            int i92 = -1;
            while (true) {
                if (i90 >= l_a7.a) {
                    i = -1;
                    z2 = true;
                    break;
                }
                int i93 = l_a7.f903b[i90];
                j jVar = jVarArr[i90];
                if (i93 == 1 || i93 == 2) {
                    if (jVar != null) {
                        int[][] iArr31 = iArr17[i90];
                        int iA = l_a7.c[i90].a(jVar.a());
                        int i94 = 0;
                        while (true) {
                            if (i94 >= jVar.length()) {
                                z3 = true;
                                break;
                            }
                            if ((iArr31[iA][jVar.f(i94)] & 32) != 32) {
                                z3 = false;
                                break;
                            }
                            i94++;
                        }
                        if (z3) {
                            if (i93 == 1) {
                                i = -1;
                                if (i91 != -1) {
                                    z2 = false;
                                    break;
                                }
                                i91 = i90;
                            } else {
                                i = -1;
                                if (i92 != -1) {
                                    z2 = false;
                                    break;
                                }
                                i92 = i90;
                            }
                        }
                    }
                }
                i90++;
            }
            if (z2 & ((i91 == i || i92 == i) ? false : true)) {
                h2 h2Var = new h2(true);
                h2VarArr[i91] = h2Var;
                h2VarArr[i92] = h2Var;
            }
        }
        Pair pairCreate3 = Pair.create(h2VarArr, jVarArr);
        m[] mVarArr = (m[]) pairCreate3.second;
        b.i.a.f.e.o.f.A(4, "initialCapacity");
        Object[] objArrCopyOf2 = new Object[4];
        int i95 = 0;
        int i96 = 0;
        while (i95 < l_a7.a) {
            o0 o0Var12 = l_a7.c[i95];
            m mVar = mVarArr[i95];
            Object[] objArrCopyOf3 = objArrCopyOf2;
            int i97 = i96;
            int i98 = 0;
            while (i98 < o0Var12.k) {
                n0 n0Var17 = o0Var12.l[i98];
                int i99 = n0Var17.k;
                int[] iArr32 = new int[i99];
                boolean[] zArr = new boolean[i99];
                for (int i100 = 0; i100 < n0Var17.k; i100++) {
                    iArr32[i100] = l_a7.a(i95, i98, i100);
                    if (mVar != null && mVar.a() == n0Var17) {
                        boolean z17 = mVar.l(i100) != -1;
                        zArr[i100] = z17;
                    }
                    zArr[i100] = z17;
                }
                p2$a p2_a = new p2$a(n0Var17, iArr32, l_a7.f903b[i95], zArr);
                int i101 = i97 + 1;
                if (objArrCopyOf3.length < i101) {
                    objArrCopyOf3 = Arrays.copyOf(objArrCopyOf3, n$b.a(objArrCopyOf3.length, i101));
                }
                objArrCopyOf3[i97] = p2_a;
                i98++;
                i97 = i101;
            }
            i95++;
            i96 = i97;
            objArrCopyOf2 = objArrCopyOf3;
        }
        o0 o0Var13 = l_a7.f;
        int i102 = 0;
        while (i102 < o0Var13.k) {
            n0 n0Var18 = o0Var13.l[i102];
            int[] iArr33 = new int[n0Var18.k];
            Arrays.fill(iArr33, 0);
            p2$a p2_a2 = new p2$a(n0Var18, iArr33, t.g(n0Var18.l[0].w), new boolean[n0Var18.k]);
            int i103 = i96 + 1;
            if (objArrCopyOf2.length < i103) {
                objArrCopyOf2 = Arrays.copyOf(objArrCopyOf2, n$b.a(objArrCopyOf2.length, i103));
            }
            objArrCopyOf2[i96] = p2_a2;
            i102++;
            i96 = i103;
        }
        return new r((h2[]) pairCreate3.first, (j[]) pairCreate3.second, new p2(b.i.b.b.p.l(objArrCopyOf2, i96)), l_a7);
    }
}

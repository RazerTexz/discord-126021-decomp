package p007b.p225i.p226a.p242c.p255c3;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import p007b.p225i.p226a.p242c.AbstractC2832o2;
import p007b.p225i.p226a.p242c.AbstractC2951v0;
import p007b.p225i.p226a.p242c.C2804h2;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.C2836p2;
import p007b.p225i.p226a.p242c.InterfaceC2763g2;
import p007b.p225i.p226a.p242c.p243a3.C2556n0;
import p007b.p225i.p226a.p242c.p243a3.C2558o0;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2704f;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2753t;
import p007b.p225i.p226a.p242c.p259f3.InterfaceC2740g;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.AbstractC4493a;
import p007b.p225i.p355b.p357b.AbstractC4505g;
import p007b.p225i.p355b.p357b.AbstractC4519n;
import p007b.p225i.p355b.p357b.AbstractC4523p;
import p007b.p225i.p355b.p357b.C4498c0;
import p007b.p225i.p355b.p357b.C4500d0;
import p007b.p225i.p355b.p357b.C4504f0;
import p007b.p225i.p355b.p357b.C4508h0;

/* JADX INFO: renamed from: b.i.a.c.c3.l */
/* JADX INFO: compiled from: MappingTrackSelector.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2646l extends AbstractC2651q {

    /* JADX INFO: renamed from: b.i.a.c.c3.l$a */
    /* JADX INFO: compiled from: MappingTrackSelector.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final int f6262a;

        /* JADX INFO: renamed from: b */
        public final int[] f6263b;

        /* JADX INFO: renamed from: c */
        public final C2558o0[] f6264c;

        /* JADX INFO: renamed from: d */
        public final int[] f6265d;

        /* JADX INFO: renamed from: e */
        public final int[][][] f6266e;

        /* JADX INFO: renamed from: f */
        public final C2558o0 f6267f;

        @VisibleForTesting
        public a(String[] strArr, int[] iArr, C2558o0[] c2558o0Arr, int[] iArr2, int[][][] iArr3, C2558o0 c2558o0) {
            this.f6263b = iArr;
            this.f6264c = c2558o0Arr;
            this.f6266e = iArr3;
            this.f6265d = iArr2;
            this.f6267f = c2558o0;
            this.f6262a = iArr.length;
        }

        /* JADX INFO: renamed from: a */
        public int m2754a(int i, int i2, int i3) {
            return this.f6266e[i][i2][i3] & 7;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.AbstractC2651q
    /* JADX INFO: renamed from: a */
    public final void mo2752a(@Nullable Object obj) {
    }

    /* JADX WARN: Code duplicated, block: B:110:0x028d A[LOOP:8: B:67:0x0159->B:110:0x028d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:229:0x04bc  */
    /* JADX WARN: Code duplicated, block: B:330:0x06d7  */
    /* JADX WARN: Code duplicated, block: B:458:0x095e  */
    /* JADX WARN: Code duplicated, block: B:489:0x09b6  */
    /* JADX WARN: Code duplicated, block: B:541:0x0287 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // p007b.p225i.p226a.p242c.p255c3.AbstractC2651q
    /* JADX INFO: renamed from: b */
    public final C2652r mo2753b(InterfaceC2763g2[] interfaceC2763g2Arr, C2558o0 c2558o0, InterfaceC2530a0.a aVar, AbstractC2832o2 abstractC2832o2) throws ExoPlaybackException {
        int i;
        boolean z2;
        boolean z3;
        InterfaceC2644j c2640f;
        int[] iArr;
        String str;
        C2642h.d dVar;
        Pair pairCreate;
        int[][] iArr2;
        C2556n0 c2556n0;
        String str2;
        int[][] iArr3;
        a aVar2;
        int i2;
        int i3;
        C2642h.d dVar2;
        String str3;
        InterfaceC2644j.a aVar3;
        Pair pairCreate2;
        int i4;
        int[] iArr4;
        int i5;
        int i6;
        String str4;
        int i7;
        C2556n0 c2556n1;
        C2642h c2642h;
        int i8;
        InterfaceC2644j.a[] aVarArr;
        int i9;
        int[][][] iArr5;
        int[] iArr6;
        C2642h.d dVar3;
        boolean z4;
        a aVar4;
        C2642h.d dVar4;
        C2558o0 c2558o1;
        int[][] iArr7;
        InterfaceC2644j.a aVar5;
        List<Integer> list;
        ArrayList arrayList;
        String str5;
        int[] iArrM4333q1;
        ArrayList arrayList2;
        HashSet hashSet;
        int i10;
        int[] iArr8;
        C2558o0 c2558o2 = c2558o0;
        int[] iArr9 = new int[interfaceC2763g2Arr.length + 1];
        int length = interfaceC2763g2Arr.length + 1;
        C2556n0[][] c2556n0Arr = new C2556n0[length][];
        int[][][] iArr10 = new int[interfaceC2763g2Arr.length + 1][][];
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            int i13 = c2558o2.f5675k;
            c2556n0Arr[i12] = new C2556n0[i13];
            iArr10[i12] = new int[i13][];
        }
        int length2 = interfaceC2763g2Arr.length;
        int[] iArr11 = new int[length2];
        for (int i14 = 0; i14 < length2; i14++) {
            iArr11[i14] = interfaceC2763g2Arr[i14].mo3119p();
        }
        int i15 = 0;
        while (i15 < c2558o2.f5675k) {
            C2556n0 c2556n2 = c2558o2.f5676l[i15];
            boolean z5 = C2753t.m3049g(c2556n2.f5662l[i11].f7155w) == 5;
            int length3 = interfaceC2763g2Arr.length;
            int i16 = 0;
            int i17 = 0;
            boolean z6 = true;
            while (i16 < interfaceC2763g2Arr.length) {
                InterfaceC2763g2 interfaceC2763g2 = interfaceC2763g2Arr[i16];
                int iMax = 0;
                while (i11 < c2556n2.f5661k) {
                    iMax = Math.max(iMax, interfaceC2763g2.mo2630a(c2556n2.f5662l[i11]) & 7);
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
            if (length3 == interfaceC2763g2Arr.length) {
                iArr8 = new int[c2556n2.f5661k];
            } else {
                InterfaceC2763g2 interfaceC2763g3 = interfaceC2763g2Arr[length3];
                int[] iArr12 = new int[c2556n2.f5661k];
                for (int i18 = 0; i18 < c2556n2.f5661k; i18++) {
                    iArr12[i18] = interfaceC2763g3.mo2630a(c2556n2.f5662l[i18]);
                }
                iArr8 = iArr12;
            }
            int i19 = iArr9[length3];
            c2556n0Arr[length3][i19] = c2556n2;
            iArr10[length3][i19] = iArr8;
            iArr9[length3] = iArr9[length3] + 1;
            i15++;
            c2558o2 = c2558o0;
            i11 = 0;
        }
        C2558o0[] c2558o0Arr = new C2558o0[interfaceC2763g2Arr.length];
        String[] strArr = new String[interfaceC2763g2Arr.length];
        int[] iArr13 = new int[interfaceC2763g2Arr.length];
        for (int i20 = 0; i20 < interfaceC2763g2Arr.length; i20++) {
            int i21 = iArr9[i20];
            c2558o0Arr[i20] = new C2558o0((C2556n0[]) C2738e0.m2983D(c2556n0Arr[i20], i21));
            iArr10[i20] = (int[][]) C2738e0.m2983D(iArr10[i20], i21);
            strArr[i20] = interfaceC2763g2Arr[i20].getName();
            iArr13[i20] = ((AbstractC2951v0) interfaceC2763g2Arr[i20]).f7889j;
        }
        a aVar6 = new a(strArr, iArr13, c2558o0Arr, iArr11, iArr10, new C2558o0((C2556n0[]) C2738e0.m2983D(c2556n0Arr[interfaceC2763g2Arr.length], iArr9[interfaceC2763g2Arr.length])));
        C2642h c2642h2 = (C2642h) this;
        C2642h.d dVar5 = c2642h2.f6196f.get();
        int i22 = aVar6.f6262a;
        InterfaceC2644j.a[] aVarArr2 = new InterfaceC2644j.a[i22];
        a aVar7 = aVar6;
        C2642h.d dVar6 = dVar5;
        int i23 = 0;
        boolean z8 = false;
        boolean z9 = false;
        while (i23 < i22) {
            if (2 == aVar7.f6263b[i23]) {
                if (z9) {
                    c2642h = c2642h2;
                    i8 = i22;
                    aVarArr = aVarArr2;
                    i9 = i23;
                    iArr5 = iArr10;
                    z4 = z8;
                    iArr6 = iArr11;
                    dVar3 = dVar5;
                } else {
                    C2558o0 c2558o3 = aVar7.f6264c[i23];
                    int[][] iArr14 = iArr10[i23];
                    int i24 = iArr11[i23];
                    if (dVar6.f6282F || dVar6.f6281E) {
                        aVar4 = aVar6;
                        c2642h = c2642h2;
                        dVar4 = dVar5;
                        i8 = i22;
                        aVarArr = aVarArr2;
                        i9 = i23;
                        iArr5 = iArr10;
                        z4 = z8;
                        c2558o1 = c2558o3;
                        iArr7 = iArr14;
                        iArr6 = iArr11;
                        aVar5 = null;
                        break;
                    }
                    int i25 = dVar6.f6217M ? 24 : 16;
                    boolean z10 = dVar6.f6216L && (i24 & i25) != 0;
                    C2642h.d dVar7 = dVar6;
                    int i26 = 0;
                    while (true) {
                        if (i26 >= c2558o3.f5675k) {
                            aVar4 = aVar6;
                            c2642h = c2642h2;
                            dVar4 = dVar5;
                            i8 = i22;
                            aVarArr = aVarArr2;
                            i9 = i23;
                            iArr5 = iArr10;
                            z4 = z8;
                            c2558o1 = c2558o3;
                            iArr7 = iArr14;
                            iArr6 = iArr11;
                            aVar5 = null;
                            break;
                        }
                        C2556n0 c2556n3 = c2558o3.f5676l[i26];
                        int[] iArr15 = iArr14[i26];
                        c2642h = c2642h2;
                        int i27 = dVar7.f6285k;
                        iArr6 = iArr11;
                        int i28 = dVar7.f6286l;
                        iArr5 = iArr10;
                        int i29 = dVar7.f6287m;
                        i8 = i22;
                        int i30 = dVar7.f6288n;
                        z4 = z8;
                        int i31 = dVar7.f6289o;
                        aVar4 = aVar6;
                        int i32 = dVar7.f6290p;
                        aVarArr = aVarArr2;
                        int i33 = dVar7.f6291q;
                        i9 = i23;
                        int i34 = dVar7.f6292r;
                        iArr7 = iArr14;
                        int i35 = dVar7.f6293s;
                        dVar4 = dVar5;
                        int i36 = dVar7.f6294t;
                        boolean z11 = dVar7.f6295u;
                        c2558o1 = c2558o3;
                        int i37 = i26;
                        if (c2556n3.f5661k < 2) {
                            iArrM4333q1 = C2642h.f6192b;
                        } else {
                            List<Integer> listM2736d = C2642h.m2736d(c2556n3, i35, i36, z11);
                            ArrayList arrayList3 = (ArrayList) listM2736d;
                            if (arrayList3.size() < 2) {
                                iArrM4333q1 = C2642h.f6192b;
                            } else {
                                if (z10) {
                                    list = listM2736d;
                                    arrayList = arrayList3;
                                    str5 = null;
                                } else {
                                    HashSet hashSet2 = new HashSet();
                                    int i38 = 0;
                                    int i39 = 0;
                                    str5 = null;
                                    while (i39 < arrayList3.size()) {
                                        List<Integer> list2 = listM2736d;
                                        String str6 = c2556n3.f5662l[((Integer) arrayList3.get(i39)).intValue()].f7155w;
                                        if (hashSet2.add(str6)) {
                                            hashSet = hashSet2;
                                            i10 = i39;
                                            int i40 = 0;
                                            int i41 = 0;
                                            while (i41 < arrayList3.size()) {
                                                int iIntValue = ((Integer) arrayList3.get(i41)).intValue();
                                                ArrayList arrayList4 = arrayList3;
                                                if (C2642h.m2738f(c2556n3.f5662l[iIntValue], str6, iArr15[iIntValue], i25, i27, i28, i29, i30, i31, i32, i33, i34)) {
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
                                        listM2736d = list2;
                                        hashSet2 = hashSet;
                                        arrayList3 = arrayList2;
                                    }
                                    list = listM2736d;
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
                                    if (!C2642h.m2738f(c2556n3.f5662l[iIntValue2], str5, iArr15[iIntValue2], i25, i27, i28, i29, i30, i31, i32, i33, i34)) {
                                        arrayList5.remove(size);
                                    }
                                    arrayList = arrayList5;
                                }
                                iArrM4333q1 = arrayList.size() < 2 ? C2642h.f6192b : C3404f.m4333q1(list);
                            }
                            if (iArrM4333q1.length > 0) {
                                aVar5 = new InterfaceC2644j.a(c2556n3, iArrM4333q1);
                                break;
                            }
                            i26 = i37 + 1;
                            c2642h2 = c2642h;
                            iArr11 = iArr6;
                            iArr10 = iArr5;
                            i22 = i8;
                            z8 = z4;
                            aVar6 = aVar4;
                            aVarArr2 = aVarArr;
                            i23 = i9;
                            iArr14 = iArr7;
                            dVar5 = dVar4;
                            dVar7 = dVar5;
                            c2558o3 = c2558o1;
                            z10 = z10;
                        }
                        z10 = z10;
                        if (iArrM4333q1.length > 0) {
                            aVar5 = new InterfaceC2644j.a(c2556n3, iArrM4333q1);
                            break;
                        }
                        i26 = i37 + 1;
                        c2642h2 = c2642h;
                        iArr11 = iArr6;
                        iArr10 = iArr5;
                        i22 = i8;
                        z8 = z4;
                        aVar6 = aVar4;
                        aVarArr2 = aVarArr;
                        i23 = i9;
                        iArr14 = iArr7;
                        dVar5 = dVar4;
                        dVar7 = dVar5;
                        c2558o3 = c2558o1;
                        z10 = z10;
                    }
                    if (aVar5 == null) {
                        C2558o0 c2558o4 = c2558o1;
                        C2556n0 c2556n4 = null;
                        C2642h.h hVar = null;
                        int i42 = 0;
                        int i43 = -1;
                        while (i42 < c2558o4.f5675k) {
                            C2556n0 c2556n5 = c2558o4.f5676l[i42];
                            C2642h.d dVar8 = dVar4;
                            List<Integer> listM2736d2 = C2642h.m2736d(c2556n5, dVar8.f6293s, dVar8.f6294t, dVar8.f6295u);
                            int[] iArr16 = iArr7[i42];
                            C2642h.h hVar2 = hVar;
                            C2556n0 c2556n6 = c2556n4;
                            for (int i44 = 0; i44 < c2556n5.f5661k; i44++) {
                                C2811j1 c2811j1 = c2556n5.f5662l[i44];
                                if ((c2811j1.f7148p & 16384) == 0 && C2642h.m2737e(iArr16[i44], dVar8.f6222R)) {
                                    C2642h.h hVar3 = new C2642h.h(c2811j1, dVar8, iArr16[i44], ((ArrayList) listM2736d2).contains(Integer.valueOf(i44)));
                                    if ((hVar3.f6252j || dVar8.f6215K) && (hVar2 == null || hVar3.compareTo(hVar2) > 0)) {
                                        i43 = i44;
                                        c2556n6 = c2556n5;
                                        hVar2 = hVar3;
                                    }
                                }
                            }
                            i42++;
                            c2556n4 = c2556n6;
                            dVar4 = dVar8;
                            hVar = hVar2;
                        }
                        dVar3 = dVar4;
                        aVar5 = c2556n4 == null ? null : new InterfaceC2644j.a(c2556n4, i43);
                    } else {
                        dVar3 = dVar4;
                    }
                    aVarArr[i9] = aVar5;
                    z9 = aVarArr[i9] != null;
                    dVar6 = dVar3;
                    aVar6 = aVar4;
                }
                aVar7 = aVar6;
                z8 = z4 | (aVar6.f6264c[i9].f5675k > 0);
            } else {
                c2642h = c2642h2;
                i8 = i22;
                aVarArr = aVarArr2;
                i9 = i23;
                iArr5 = iArr10;
                iArr6 = iArr11;
                dVar3 = dVar5;
            }
            dVar5 = dVar3;
            iArr11 = iArr6;
            iArr10 = iArr5;
            i22 = i8;
            aVarArr2 = aVarArr;
            i23 = i9 + 1;
            c2642h2 = c2642h;
        }
        C2642h c2642h3 = c2642h2;
        C2642h.d dVar9 = dVar5;
        InterfaceC2644j.a[] aVarArr3 = aVarArr2;
        int[][][] iArr17 = iArr10;
        boolean z12 = z8;
        int[] iArr18 = iArr11;
        int i45 = i22;
        C2642h.b bVar = null;
        int i46 = -1;
        int i47 = 0;
        String str7 = null;
        while (i47 < i45) {
            if (1 == aVar7.f6263b[i47]) {
                boolean z13 = dVar6.f6224T || !z12;
                C2558o0 c2558o5 = aVar7.f6264c[i47];
                int[][] iArr19 = iArr17[i47];
                int i48 = iArr18[i47];
                C2642h.b bVar2 = null;
                int i49 = -1;
                int i50 = -1;
                int i51 = 0;
                while (i51 < c2558o5.f5675k) {
                    C2556n0 c2556n7 = c2558o5.f5676l[i51];
                    int[] iArr20 = iArr19[i51];
                    int i52 = i49;
                    int i53 = i50;
                    C2642h.b bVar3 = bVar2;
                    int i54 = 0;
                    while (i54 < c2556n7.f5661k) {
                        String str8 = str7;
                        if (C2642h.m2737e(iArr20[i54], dVar6.f6222R)) {
                            c2556n1 = c2556n7;
                            C2642h.b bVar4 = new C2642h.b(c2556n7.f5662l[i54], dVar6, iArr20[i54]);
                            if ((bVar4.f6197j || dVar6.f6218N) && (bVar3 == null || bVar4.compareTo(bVar3) > 0)) {
                                i53 = i54;
                                bVar3 = bVar4;
                                i52 = i51;
                            }
                        } else {
                            c2556n1 = c2556n7;
                        }
                        i54++;
                        str7 = str8;
                        c2556n7 = c2556n1;
                    }
                    i51++;
                    bVar2 = bVar3;
                    i50 = i53;
                    i49 = i52;
                }
                str3 = str7;
                if (i49 == -1) {
                    aVar2 = aVar6;
                    i2 = i47;
                    i3 = i45;
                    dVar2 = dVar9;
                    pairCreate2 = null;
                } else {
                    C2556n0 c2556n8 = c2558o5.f5676l[i49];
                    if (dVar6.f6282F || dVar6.f6281E || !z13) {
                        aVar2 = aVar6;
                        i2 = i47;
                        i3 = i45;
                        dVar2 = dVar9;
                    } else {
                        int[] iArr21 = iArr19[i49];
                        int i55 = dVar6.f6300z;
                        boolean z14 = dVar6.f6219O;
                        boolean z15 = dVar6.f6220P;
                        boolean z16 = dVar6.f6221Q;
                        C2811j1 c2811j2 = c2556n8.f5662l[i50];
                        int[] iArr22 = new int[c2556n8.f5661k];
                        aVar2 = aVar6;
                        i3 = i45;
                        dVar2 = dVar9;
                        int i56 = 0;
                        int i57 = 0;
                        while (i57 < c2556n8.f5661k) {
                            if (i57 != i50) {
                                C2811j1 c2811j3 = c2556n8.f5662l[i57];
                                i4 = i47;
                                iArr4 = iArr21;
                                if (C2642h.m2737e(iArr21[i57], false) && (i5 = c2811j3.f7151s) != -1 && i5 <= i55 && (z16 || ((i7 = c2811j3.f7136J) != -1 && i7 == c2811j2.f7136J)) && ((z14 || ((str4 = c2811j3.f7155w) != null && TextUtils.equals(str4, c2811j2.f7155w))) && (z15 || ((i6 = c2811j3.f7137K) != -1 && i6 == c2811j2.f7137K)))) {
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
                        aVar3 = iArrCopyOf.length > 1 ? new InterfaceC2644j.a(c2556n8, iArrCopyOf) : null;
                        if (aVar3 == null) {
                            aVar3 = new InterfaceC2644j.a(c2556n8, i50);
                        }
                        Objects.requireNonNull(bVar2);
                        pairCreate2 = Pair.create(aVar3, bVar2);
                    }
                    if (aVar3 == null) {
                        aVar3 = new InterfaceC2644j.a(c2556n8, i50);
                    }
                    Objects.requireNonNull(bVar2);
                    pairCreate2 = Pair.create(aVar3, bVar2);
                }
                if (pairCreate2 != null && (bVar == null || ((C2642h.b) pairCreate2.second).compareTo(bVar) > 0)) {
                    if (i46 != -1) {
                        aVarArr3[i46] = null;
                    }
                    InterfaceC2644j.a aVar8 = (InterfaceC2644j.a) pairCreate2.first;
                    aVarArr3[i2] = aVar8;
                    str7 = aVar8.f6259a.f5662l[aVar8.f6260b[0]].f7146n;
                    i46 = i2;
                    bVar = (C2642h.b) pairCreate2.second;
                }
                i47 = i2 + 1;
                i45 = i3;
                aVar6 = aVar2;
                aVar7 = aVar6;
                dVar9 = dVar2;
                dVar6 = dVar9;
            } else {
                aVar2 = aVar6;
                i2 = i47;
                i3 = i45;
                dVar2 = dVar9;
                str3 = str7;
            }
            str7 = str3;
            i47 = i2 + 1;
            i45 = i3;
            aVar6 = aVar2;
            aVar7 = aVar6;
            dVar9 = dVar2;
            dVar6 = dVar9;
        }
        a aVar9 = aVar6;
        C2642h.d dVar10 = dVar9;
        String str9 = str7;
        int i58 = i45;
        int i59 = -1;
        int i60 = 0;
        C2642h.g gVar = null;
        while (i60 < i58) {
            a aVar10 = aVar9;
            int i61 = aVar10.f6263b[i60];
            if (i61 == 1 || i61 == 2) {
                str = str9;
                dVar = dVar10;
            } else if (i61 != 3) {
                C2558o0 c2558o6 = aVar10.f6264c[i60];
                int[][] iArr23 = iArr17[i60];
                C2556n0 c2556n9 = null;
                C2642h.c cVar = null;
                int i62 = 0;
                int i63 = 0;
                while (i62 < c2558o6.f5675k) {
                    C2556n0 c2556n10 = c2558o6.f5676l[i62];
                    int[] iArr24 = iArr23[i62];
                    int i64 = i63;
                    C2642h.c cVar2 = cVar;
                    C2556n0 c2556n11 = c2556n9;
                    int i65 = 0;
                    while (i65 < c2556n10.f5661k) {
                        C2558o0 c2558o7 = c2558o6;
                        C2642h.d dVar11 = dVar10;
                        if (C2642h.m2737e(iArr24[i65], dVar11.f6222R)) {
                            iArr3 = iArr23;
                            C2642h.c cVar3 = new C2642h.c(c2556n10.f5662l[i65], iArr24[i65]);
                            if (cVar2 == null || cVar3.compareTo(cVar2) > 0) {
                                i64 = i65;
                                c2556n11 = c2556n10;
                                cVar2 = cVar3;
                            }
                        } else {
                            iArr3 = iArr23;
                        }
                        i65++;
                        dVar10 = dVar11;
                        c2558o6 = c2558o7;
                        iArr23 = iArr3;
                    }
                    i62++;
                    c2556n9 = c2556n11;
                    cVar = cVar2;
                    i63 = i64;
                }
                dVar = dVar10;
                aVarArr3[i60] = c2556n9 == null ? null : new InterfaceC2644j.a(c2556n9, i63);
                str = str9;
            } else {
                dVar = dVar10;
                C2558o0 c2558o8 = aVar10.f6264c[i60];
                int[][] iArr25 = iArr17[i60];
                C2556n0 c2556n12 = null;
                C2642h.g gVar2 = null;
                int i66 = -1;
                int i67 = 0;
                while (i67 < c2558o8.f5675k) {
                    C2556n0 c2556n13 = c2558o8.f5676l[i67];
                    int[] iArr26 = iArr25[i67];
                    int i68 = i66;
                    C2642h.g gVar3 = gVar2;
                    C2556n0 c2556n14 = c2556n12;
                    int i69 = 0;
                    while (i69 < c2556n13.f5661k) {
                        C2558o0 c2558o9 = c2558o8;
                        if (C2642h.m2737e(iArr26[i69], dVar.f6222R)) {
                            iArr2 = iArr25;
                            c2556n0 = c2556n13;
                            str2 = str9;
                            C2642h.g gVar4 = new C2642h.g(c2556n13.f5662l[i69], dVar, iArr26[i69], str2);
                            if (gVar4.f6243j && (gVar3 == null || gVar4.compareTo(gVar3) > 0)) {
                                i68 = i69;
                                gVar3 = gVar4;
                                c2556n14 = c2556n0;
                            }
                        } else {
                            iArr2 = iArr25;
                            c2556n0 = c2556n13;
                            str2 = str9;
                        }
                        i69++;
                        str9 = str2;
                        c2558o8 = c2558o9;
                        iArr25 = iArr2;
                        c2556n13 = c2556n0;
                    }
                    i67++;
                    c2556n12 = c2556n14;
                    gVar2 = gVar3;
                    i66 = i68;
                }
                str = str9;
                if (c2556n12 == null) {
                    pairCreate = null;
                } else {
                    InterfaceC2644j.a aVar11 = new InterfaceC2644j.a(c2556n12, i66);
                    Objects.requireNonNull(gVar2);
                    pairCreate = Pair.create(aVar11, gVar2);
                }
                if (pairCreate != null && (gVar == null || ((C2642h.g) pairCreate.second).compareTo(gVar) > 0)) {
                    if (i59 != -1) {
                        aVarArr3[i59] = null;
                    }
                    aVarArr3[i60] = (InterfaceC2644j.a) pairCreate.first;
                    gVar = (C2642h.g) pairCreate.second;
                    i59 = i60;
                }
            }
            i60++;
            aVar9 = aVar10;
            str9 = str;
            dVar10 = dVar;
        }
        a aVar12 = aVar9;
        C2642h.d dVar12 = dVar10;
        for (int i70 = 0; i70 < i58; i70++) {
            InterfaceC2644j.a aVar13 = aVarArr3[i70];
            int i71 = aVar12.f6263b[i70];
            if (dVar12.f6226V.get(i70) || dVar12.f6284H.contains(Integer.valueOf(i71))) {
                aVar13 = null;
            } else {
                C2558o0 c2558o10 = aVar12.f6264c[i70];
                Map<C2558o0, C2642h.f> map = dVar12.f6225U.get(i70);
                if (map != null && map.containsKey(c2558o10)) {
                    Map<C2558o0, C2642h.f> map2 = dVar12.f6225U.get(i70);
                    C2642h.f fVar = map2 != null ? map2.get(c2558o10) : null;
                    if (fVar == null) {
                        aVar13 = null;
                    } else {
                        aVar13 = new InterfaceC2644j.a(c2558o10.f5676l[fVar.f6240j], fVar.f6241k, fVar.f6242l);
                    }
                } else {
                    for (int i72 = 0; i72 < c2558o10.f5675k; i72++) {
                        C2556n0 c2556n15 = c2558o10.f5676l[i72];
                        C2649o.a aVar14 = dVar12.f6283G.f6272l.get(c2556n15);
                        if (aVar14 != null) {
                            aVar13 = new InterfaceC2644j.a(c2556n15, C3404f.m4333q1(aVar14.f6275l));
                            break;
                        }
                    }
                }
            }
            aVarArr3[i70] = aVar13;
        }
        InterfaceC2644j.b bVar5 = c2642h3.f6195e;
        InterfaceC2704f interfaceC2704f = c2642h3.f6325a;
        Objects.requireNonNull(interfaceC2704f);
        Objects.requireNonNull((C2640f.b) bVar5);
        ArrayList arrayList6 = new ArrayList();
        for (int i73 = 0; i73 < i58; i73++) {
            if (aVarArr3[i73] == null || aVarArr3[i73].f6260b.length <= 1) {
                arrayList6.add(null);
            } else {
                AbstractC4493a<Object> abstractC4493a = AbstractC4523p.f12045k;
                AbstractC4523p.a aVar15 = new AbstractC4523p.a();
                aVar15.m6271b(new C2640f.a(0L, 0L));
                arrayList6.add(aVar15);
            }
        }
        long[][] jArr = new long[i58][];
        for (int i74 = 0; i74 < i58; i74++) {
            InterfaceC2644j.a aVar16 = aVarArr3[i74];
            if (aVar16 == null) {
                jArr[i74] = new long[0];
            } else {
                jArr[i74] = new long[aVar16.f6260b.length];
                int i75 = 0;
                while (true) {
                    int[] iArr27 = aVar16.f6260b;
                    if (i75 >= iArr27.length) {
                        break;
                    }
                    jArr[i74][i75] = aVar16.f6259a.f5662l[iArr27[i75]].f7151s;
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
        C2640f.m2722m(arrayList6, jArr2);
        C4504f0 c4504f0 = C4504f0.f12005j;
        C3404f.m4189A(2, "expectedValuesPerKey");
        C4500d0 c4500d0 = new C4500d0(new TreeMap(c4504f0), new C4498c0(2));
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
                    Collection collection = (Collection) c4500d0.f11973m.get(objValueOf);
                    if (collection == null) {
                        Collection collectionMo6217e = c4500d0.mo6217e();
                        if (!collectionMo6217e.add(numValueOf)) {
                            throw new AssertionError("New Collection violated the Collection spec");
                        }
                        c4500d0.f11974n++;
                        c4500d0.f11973m.put((K) objValueOf, (Collection<V>) collectionMo6217e);
                    } else if (collection.add(numValueOf)) {
                        c4500d0.f11974n++;
                    }
                    i79 = i81;
                    d = d3;
                }
            }
            i77++;
            iArr28 = iArr;
        }
        int[] iArr29 = iArr28;
        Collection aVar17 = c4500d0.f12007k;
        if (aVar17 == null) {
            aVar17 = new AbstractC4505g.a();
            c4500d0.f12007k = aVar17;
        }
        AbstractC4523p abstractC4523pM6264n = AbstractC4523p.m6264n(aVar17);
        for (int i82 = 0; i82 < abstractC4523pM6264n.size(); i82++) {
            int iIntValue3 = ((Integer) abstractC4523pM6264n.get(i82)).intValue();
            int i83 = iArr29[iIntValue3] + 1;
            iArr29[iIntValue3] = i83;
            jArr2[iIntValue3] = jArr[iIntValue3][i83];
            C2640f.m2722m(arrayList6, jArr2);
        }
        for (int i84 = 0; i84 < i58; i84++) {
            if (arrayList6.get(i84) != null) {
                jArr2[i84] = jArr2[i84] * 2;
            }
        }
        C2640f.m2722m(arrayList6, jArr2);
        C3404f.m4189A(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        int i85 = 0;
        int i86 = 0;
        while (i85 < arrayList6.size()) {
            AbstractC4523p.a aVar18 = (AbstractC4523p.a) arrayList6.get(i85);
            AbstractC4523p<Object> abstractC4523pM6272c = aVar18 == null ? C4508h0.f12012l : aVar18.m6272c();
            Objects.requireNonNull(abstractC4523pM6272c);
            int i87 = i86 + 1;
            if (objArrCopyOf.length < i87) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, AbstractC4519n.b.m6260a(objArrCopyOf.length, i87));
            }
            objArrCopyOf[i86] = abstractC4523pM6272c;
            i85++;
            i86 = i87;
        }
        AbstractC4523p abstractC4523pM6262l = AbstractC4523p.m6262l(objArrCopyOf, i86);
        InterfaceC2644j[] interfaceC2644jArr = new InterfaceC2644j[i58];
        for (int i88 = 0; i88 < i58; i88++) {
            InterfaceC2644j.a aVar19 = aVarArr3[i88];
            if (aVar19 != null) {
                int[] iArr30 = aVar19.f6260b;
                if (iArr30.length != 0) {
                    if (iArr30.length == 1) {
                        c2640f = new C2645k(aVar19.f6259a, iArr30[0], aVar19.f6261c);
                    } else {
                        long j = 25000;
                        c2640f = new C2640f(aVar19.f6259a, iArr30, aVar19.f6261c, interfaceC2704f, 10000, j, j, 1279, 719, 0.7f, 0.75f, (AbstractC4523p) abstractC4523pM6262l.get(i88), InterfaceC2740g.f6720a);
                    }
                    interfaceC2644jArr[i88] = c2640f;
                }
            }
        }
        C2804h2[] c2804h2Arr = new C2804h2[i58];
        for (int i89 = 0; i89 < i58; i89++) {
            c2804h2Arr[i89] = !(dVar12.f6226V.get(i89) || dVar12.f6284H.contains(Integer.valueOf(aVar12.f6263b[i89]))) && (aVar12.f6263b[i89] == -2 || interfaceC2644jArr[i89] != null) ? C2804h2.f7117a : null;
        }
        if (dVar12.f6223S) {
            int i90 = 0;
            int i91 = -1;
            int i92 = -1;
            while (true) {
                if (i90 >= aVar12.f6262a) {
                    i = -1;
                    z2 = true;
                    break;
                }
                int i93 = aVar12.f6263b[i90];
                InterfaceC2644j interfaceC2644j = interfaceC2644jArr[i90];
                if (i93 == 1 || i93 == 2) {
                    if (interfaceC2644j != null) {
                        int[][] iArr31 = iArr17[i90];
                        int iM2575a = aVar12.f6264c[i90].m2575a(interfaceC2644j.mo2727a());
                        int i94 = 0;
                        while (true) {
                            if (i94 >= interfaceC2644j.length()) {
                                z3 = true;
                                break;
                            }
                            if ((iArr31[iM2575a][interfaceC2644j.mo2730f(i94)] & 32) != 32) {
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
                C2804h2 c2804h2 = new C2804h2(true);
                c2804h2Arr[i91] = c2804h2;
                c2804h2Arr[i92] = c2804h2;
            }
        }
        Pair pairCreate3 = Pair.create(c2804h2Arr, interfaceC2644jArr);
        InterfaceC2647m[] interfaceC2647mArr = (InterfaceC2647m[]) pairCreate3.second;
        C3404f.m4189A(4, "initialCapacity");
        Object[] objArrCopyOf2 = new Object[4];
        int i95 = 0;
        int i96 = 0;
        while (i95 < aVar12.f6262a) {
            C2558o0 c2558o11 = aVar12.f6264c[i95];
            InterfaceC2647m interfaceC2647m = interfaceC2647mArr[i95];
            Object[] objArrCopyOf3 = objArrCopyOf2;
            int i97 = i96;
            int i98 = 0;
            while (i98 < c2558o11.f5675k) {
                C2556n0 c2556n16 = c2558o11.f5676l[i98];
                int i99 = c2556n16.f5661k;
                int[] iArr32 = new int[i99];
                boolean[] zArr = new boolean[i99];
                for (int i100 = 0; i100 < c2556n16.f5661k; i100++) {
                    iArr32[i100] = aVar12.m2754a(i95, i98, i100);
                    if (interfaceC2647m != null && interfaceC2647m.mo2727a() == c2556n16) {
                        boolean z17 = interfaceC2647m.mo2734l(i100) != -1;
                        zArr[i100] = z17;
                    }
                    zArr[i100] = z17;
                }
                C2836p2.a aVar20 = new C2836p2.a(c2556n16, iArr32, aVar12.f6263b[i95], zArr);
                int i101 = i97 + 1;
                if (objArrCopyOf3.length < i101) {
                    objArrCopyOf3 = Arrays.copyOf(objArrCopyOf3, AbstractC4519n.b.m6260a(objArrCopyOf3.length, i101));
                }
                objArrCopyOf3[i97] = aVar20;
                i98++;
                i97 = i101;
            }
            i95++;
            i96 = i97;
            objArrCopyOf2 = objArrCopyOf3;
        }
        C2558o0 c2558o12 = aVar12.f6267f;
        int i102 = 0;
        while (i102 < c2558o12.f5675k) {
            C2556n0 c2556n17 = c2558o12.f5676l[i102];
            int[] iArr33 = new int[c2556n17.f5661k];
            Arrays.fill(iArr33, 0);
            C2836p2.a aVar21 = new C2836p2.a(c2556n17, iArr33, C2753t.m3049g(c2556n17.f5662l[0].f7155w), new boolean[c2556n17.f5661k]);
            int i103 = i96 + 1;
            if (objArrCopyOf2.length < i103) {
                objArrCopyOf2 = Arrays.copyOf(objArrCopyOf2, AbstractC4519n.b.m6260a(objArrCopyOf2.length, i103));
            }
            objArrCopyOf2[i96] = aVar21;
            i102++;
            i96 = i103;
        }
        return new C2652r((C2804h2[]) pairCreate3.first, (InterfaceC2644j[]) pairCreate3.second, new C2836p2(AbstractC4523p.m6262l(objArrCopyOf2, i96)), aVar12);
    }
}

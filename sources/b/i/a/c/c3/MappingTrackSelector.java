package b.i.a.c.c3;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b.i.a.c.BaseRenderer;
import b.i.a.c.Format2;
import b.i.a.c.RendererCapabilities;
import b.i.a.c.RendererConfiguration;
import b.i.a.c.Timeline;
import b.i.a.c.TracksInfo;
import b.i.a.c.a3.MediaSource2;
import b.i.a.c.a3.TrackGroup;
import b.i.a.c.a3.TrackGroupArray;
import b.i.a.c.c3.AdaptiveTrackSelection;
import b.i.a.c.c3.DefaultTrackSelector;
import b.i.a.c.c3.ExoTrackSelection2;
import b.i.a.c.c3.TrackSelectionOverrides;
import b.i.a.c.e3.BandwidthMeter;
import b.i.a.c.f3.Clock4;
import b.i.a.c.f3.MimeTypes;
import b.i.a.c.f3.Util2;
import b.i.b.b.AbstractIndexedListIterator;
import b.i.b.b.AbstractMultimap;
import b.i.b.b.ImmutableCollection;
import b.i.b.b.ImmutableList2;
import b.i.b.b.MultimapBuilder;
import b.i.b.b.Multimaps;
import b.i.b.b.NaturalOrdering;
import b.i.b.b.RegularImmutableList;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/* JADX INFO: renamed from: b.i.a.c.c3.l, reason: use source file name */
/* JADX INFO: compiled from: MappingTrackSelector.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MappingTrackSelector extends TrackSelector {

    /* JADX INFO: renamed from: b.i.a.c.c3.l$a */
    /* JADX INFO: compiled from: MappingTrackSelector.java */
    public static final class a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f903b;
        public final TrackGroupArray[] c;
        public final int[] d;
        public final int[][][] e;
        public final TrackGroupArray f;

        @VisibleForTesting
        public a(String[] strArr, int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.f903b = iArr;
            this.c = trackGroupArrayArr;
            this.e = iArr3;
            this.d = iArr2;
            this.f = trackGroupArray;
            this.a = iArr.length;
        }

        public int a(int i, int i2, int i3) {
            return this.e[i][i2][i3] & 7;
        }
    }

    @Override // b.i.a.c.c3.TrackSelector
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
    @Override // b.i.a.c.c3.TrackSelector
    public final TrackSelectorResult b(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray, MediaSource2.a aVar, Timeline timeline) throws ExoPlaybackException {
        int i;
        boolean z2;
        boolean z3;
        ExoTrackSelection2 adaptiveTrackSelection;
        int[] iArr;
        String str;
        DefaultTrackSelector.d dVar;
        Pair pairCreate;
        int[][] iArr2;
        TrackGroup trackGroup;
        String str2;
        int[][] iArr3;
        a aVar2;
        int i2;
        int i3;
        DefaultTrackSelector.d dVar2;
        String str3;
        ExoTrackSelection2.a aVar3;
        Pair pairCreate2;
        int i4;
        int[] iArr4;
        int i5;
        int i6;
        String str4;
        int i7;
        TrackGroup trackGroup2;
        DefaultTrackSelector defaultTrackSelector;
        int i8;
        ExoTrackSelection2.a[] aVarArr;
        int i9;
        int[][][] iArr5;
        int[] iArr6;
        DefaultTrackSelector.d dVar3;
        boolean z4;
        a aVar4;
        DefaultTrackSelector.d dVar4;
        TrackGroupArray trackGroupArray2;
        int[][] iArr7;
        ExoTrackSelection2.a aVar5;
        List<Integer> list;
        ArrayList arrayList;
        String str5;
        int[] iArrQ1;
        ArrayList arrayList2;
        HashSet hashSet;
        int i10;
        int[] iArr8;
        TrackGroupArray trackGroupArray3 = trackGroupArray;
        int[] iArr9 = new int[rendererCapabilitiesArr.length + 1];
        int length = rendererCapabilitiesArr.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length][];
        int[][][] iArr10 = new int[rendererCapabilitiesArr.length + 1][][];
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            int i13 = trackGroupArray3.k;
            trackGroupArr[i12] = new TrackGroup[i13];
            iArr10[i12] = new int[i13][];
        }
        int length2 = rendererCapabilitiesArr.length;
        int[] iArr11 = new int[length2];
        for (int i14 = 0; i14 < length2; i14++) {
            iArr11[i14] = rendererCapabilitiesArr[i14].p();
        }
        int i15 = 0;
        while (i15 < trackGroupArray3.k) {
            TrackGroup trackGroup3 = trackGroupArray3.l[i15];
            boolean z5 = MimeTypes.g(trackGroup3.l[i11].w) == 5;
            int length3 = rendererCapabilitiesArr.length;
            int i16 = 0;
            int i17 = 0;
            boolean z6 = true;
            while (i16 < rendererCapabilitiesArr.length) {
                RendererCapabilities rendererCapabilities = rendererCapabilitiesArr[i16];
                int iMax = 0;
                while (i11 < trackGroup3.k) {
                    iMax = Math.max(iMax, rendererCapabilities.a(trackGroup3.l[i11]) & 7);
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
            if (length3 == rendererCapabilitiesArr.length) {
                iArr8 = new int[trackGroup3.k];
            } else {
                RendererCapabilities rendererCapabilities2 = rendererCapabilitiesArr[length3];
                int[] iArr12 = new int[trackGroup3.k];
                for (int i18 = 0; i18 < trackGroup3.k; i18++) {
                    iArr12[i18] = rendererCapabilities2.a(trackGroup3.l[i18]);
                }
                iArr8 = iArr12;
            }
            int i19 = iArr9[length3];
            trackGroupArr[length3][i19] = trackGroup3;
            iArr10[length3][i19] = iArr8;
            iArr9[length3] = iArr9[length3] + 1;
            i15++;
            trackGroupArray3 = trackGroupArray;
            i11 = 0;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[rendererCapabilitiesArr.length];
        String[] strArr = new String[rendererCapabilitiesArr.length];
        int[] iArr13 = new int[rendererCapabilitiesArr.length];
        for (int i20 = 0; i20 < rendererCapabilitiesArr.length; i20++) {
            int i21 = iArr9[i20];
            trackGroupArrayArr[i20] = new TrackGroupArray((TrackGroup[]) Util2.D(trackGroupArr[i20], i21));
            iArr10[i20] = (int[][]) Util2.D(iArr10[i20], i21);
            strArr[i20] = rendererCapabilitiesArr[i20].getName();
            iArr13[i20] = ((BaseRenderer) rendererCapabilitiesArr[i20]).j;
        }
        a aVar6 = new a(strArr, iArr13, trackGroupArrayArr, iArr11, iArr10, new TrackGroupArray((TrackGroup[]) Util2.D(trackGroupArr[rendererCapabilitiesArr.length], iArr9[rendererCapabilitiesArr.length])));
        DefaultTrackSelector defaultTrackSelector2 = (DefaultTrackSelector) this;
        DefaultTrackSelector.d dVar5 = defaultTrackSelector2.f.get();
        int i22 = aVar6.a;
        ExoTrackSelection2.a[] aVarArr2 = new ExoTrackSelection2.a[i22];
        a aVar7 = aVar6;
        DefaultTrackSelector.d dVar6 = dVar5;
        int i23 = 0;
        boolean z8 = false;
        boolean z9 = false;
        while (i23 < i22) {
            if (2 == aVar7.f903b[i23]) {
                if (z9) {
                    defaultTrackSelector = defaultTrackSelector2;
                    i8 = i22;
                    aVarArr = aVarArr2;
                    i9 = i23;
                    iArr5 = iArr10;
                    z4 = z8;
                    iArr6 = iArr11;
                    dVar3 = dVar5;
                } else {
                    TrackGroupArray trackGroupArray4 = aVar7.c[i23];
                    int[][] iArr14 = iArr10[i23];
                    int i24 = iArr11[i23];
                    if (dVar6.F || dVar6.E) {
                        aVar4 = aVar6;
                        defaultTrackSelector = defaultTrackSelector2;
                        dVar4 = dVar5;
                        i8 = i22;
                        aVarArr = aVarArr2;
                        i9 = i23;
                        iArr5 = iArr10;
                        z4 = z8;
                        trackGroupArray2 = trackGroupArray4;
                        iArr7 = iArr14;
                        iArr6 = iArr11;
                        aVar5 = null;
                        break;
                    }
                    int i25 = dVar6.M ? 24 : 16;
                    boolean z10 = dVar6.L && (i24 & i25) != 0;
                    DefaultTrackSelector.d dVar7 = dVar6;
                    int i26 = 0;
                    while (true) {
                        if (i26 >= trackGroupArray4.k) {
                            aVar4 = aVar6;
                            defaultTrackSelector = defaultTrackSelector2;
                            dVar4 = dVar5;
                            i8 = i22;
                            aVarArr = aVarArr2;
                            i9 = i23;
                            iArr5 = iArr10;
                            z4 = z8;
                            trackGroupArray2 = trackGroupArray4;
                            iArr7 = iArr14;
                            iArr6 = iArr11;
                            aVar5 = null;
                            break;
                        }
                        TrackGroup trackGroup4 = trackGroupArray4.l[i26];
                        int[] iArr15 = iArr14[i26];
                        defaultTrackSelector = defaultTrackSelector2;
                        int i27 = dVar7.k;
                        iArr6 = iArr11;
                        int i28 = dVar7.l;
                        iArr5 = iArr10;
                        int i29 = dVar7.m;
                        i8 = i22;
                        int i30 = dVar7.n;
                        z4 = z8;
                        int i31 = dVar7.o;
                        aVar4 = aVar6;
                        int i32 = dVar7.p;
                        aVarArr = aVarArr2;
                        int i33 = dVar7.q;
                        i9 = i23;
                        int i34 = dVar7.r;
                        iArr7 = iArr14;
                        int i35 = dVar7.f905s;
                        dVar4 = dVar5;
                        int i36 = dVar7.t;
                        boolean z11 = dVar7.u;
                        trackGroupArray2 = trackGroupArray4;
                        int i37 = i26;
                        if (trackGroup4.k < 2) {
                            iArrQ1 = DefaultTrackSelector.f898b;
                        } else {
                            List<Integer> listD = DefaultTrackSelector.d(trackGroup4, i35, i36, z11);
                            ArrayList arrayList3 = (ArrayList) listD;
                            if (arrayList3.size() < 2) {
                                iArrQ1 = DefaultTrackSelector.f898b;
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
                                        String str6 = trackGroup4.l[((Integer) arrayList3.get(i39)).intValue()].w;
                                        if (hashSet2.add(str6)) {
                                            hashSet = hashSet2;
                                            i10 = i39;
                                            int i40 = 0;
                                            int i41 = 0;
                                            while (i41 < arrayList3.size()) {
                                                int iIntValue = ((Integer) arrayList3.get(i41)).intValue();
                                                ArrayList arrayList4 = arrayList3;
                                                if (DefaultTrackSelector.f(trackGroup4.l[iIntValue], str6, iArr15[iIntValue], i25, i27, i28, i29, i30, i31, i32, i33, i34)) {
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
                                    if (!DefaultTrackSelector.f(trackGroup4.l[iIntValue2], str5, iArr15[iIntValue2], i25, i27, i28, i29, i30, i31, i32, i33, i34)) {
                                        arrayList5.remove(size);
                                    }
                                    arrayList = arrayList5;
                                }
                                iArrQ1 = arrayList.size() < 2 ? DefaultTrackSelector.f898b : b.i.a.f.e.o.f.q1(list);
                            }
                            if (iArrQ1.length > 0) {
                                aVar5 = new ExoTrackSelection2.a(trackGroup4, iArrQ1);
                                break;
                            }
                            i26 = i37 + 1;
                            defaultTrackSelector2 = defaultTrackSelector;
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
                            trackGroupArray4 = trackGroupArray2;
                            z10 = z10;
                        }
                        z10 = z10;
                        if (iArrQ1.length > 0) {
                            aVar5 = new ExoTrackSelection2.a(trackGroup4, iArrQ1);
                            break;
                        }
                        i26 = i37 + 1;
                        defaultTrackSelector2 = defaultTrackSelector;
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
                        trackGroupArray4 = trackGroupArray2;
                        z10 = z10;
                    }
                    if (aVar5 == null) {
                        TrackGroupArray trackGroupArray5 = trackGroupArray2;
                        TrackGroup trackGroup5 = null;
                        DefaultTrackSelector.h hVar = null;
                        int i42 = 0;
                        int i43 = -1;
                        while (i42 < trackGroupArray5.k) {
                            TrackGroup trackGroup6 = trackGroupArray5.l[i42];
                            DefaultTrackSelector.d dVar8 = dVar4;
                            List<Integer> listD2 = DefaultTrackSelector.d(trackGroup6, dVar8.f905s, dVar8.t, dVar8.u);
                            int[] iArr16 = iArr7[i42];
                            DefaultTrackSelector.h hVar2 = hVar;
                            TrackGroup trackGroup7 = trackGroup5;
                            for (int i44 = 0; i44 < trackGroup6.k; i44++) {
                                Format2 format2 = trackGroup6.l[i44];
                                if ((format2.p & 16384) == 0 && DefaultTrackSelector.e(iArr16[i44], dVar8.R)) {
                                    DefaultTrackSelector.h hVar3 = new DefaultTrackSelector.h(format2, dVar8, iArr16[i44], ((ArrayList) listD2).contains(Integer.valueOf(i44)));
                                    if ((hVar3.j || dVar8.K) && (hVar2 == null || hVar3.compareTo(hVar2) > 0)) {
                                        i43 = i44;
                                        trackGroup7 = trackGroup6;
                                        hVar2 = hVar3;
                                    }
                                }
                            }
                            i42++;
                            trackGroup5 = trackGroup7;
                            dVar4 = dVar8;
                            hVar = hVar2;
                        }
                        dVar3 = dVar4;
                        aVar5 = trackGroup5 == null ? null : new ExoTrackSelection2.a(trackGroup5, i43);
                    } else {
                        dVar3 = dVar4;
                    }
                    aVarArr[i9] = aVar5;
                    z9 = aVarArr[i9] != null;
                    dVar6 = dVar3;
                    aVar6 = aVar4;
                }
                aVar7 = aVar6;
                z8 = z4 | (aVar6.c[i9].k > 0);
            } else {
                defaultTrackSelector = defaultTrackSelector2;
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
            defaultTrackSelector2 = defaultTrackSelector;
        }
        DefaultTrackSelector defaultTrackSelector3 = defaultTrackSelector2;
        DefaultTrackSelector.d dVar9 = dVar5;
        ExoTrackSelection2.a[] aVarArr3 = aVarArr2;
        int[][][] iArr17 = iArr10;
        boolean z12 = z8;
        int[] iArr18 = iArr11;
        int i45 = i22;
        DefaultTrackSelector.b bVar = null;
        int i46 = -1;
        int i47 = 0;
        String str7 = null;
        while (i47 < i45) {
            if (1 == aVar7.f903b[i47]) {
                boolean z13 = dVar6.T || !z12;
                TrackGroupArray trackGroupArray6 = aVar7.c[i47];
                int[][] iArr19 = iArr17[i47];
                int i48 = iArr18[i47];
                DefaultTrackSelector.b bVar2 = null;
                int i49 = -1;
                int i50 = -1;
                int i51 = 0;
                while (i51 < trackGroupArray6.k) {
                    TrackGroup trackGroup8 = trackGroupArray6.l[i51];
                    int[] iArr20 = iArr19[i51];
                    int i52 = i49;
                    int i53 = i50;
                    DefaultTrackSelector.b bVar3 = bVar2;
                    int i54 = 0;
                    while (i54 < trackGroup8.k) {
                        String str8 = str7;
                        if (DefaultTrackSelector.e(iArr20[i54], dVar6.R)) {
                            trackGroup2 = trackGroup8;
                            DefaultTrackSelector.b bVar4 = new DefaultTrackSelector.b(trackGroup8.l[i54], dVar6, iArr20[i54]);
                            if ((bVar4.j || dVar6.N) && (bVar3 == null || bVar4.compareTo(bVar3) > 0)) {
                                i53 = i54;
                                bVar3 = bVar4;
                                i52 = i51;
                            }
                        } else {
                            trackGroup2 = trackGroup8;
                        }
                        i54++;
                        str7 = str8;
                        trackGroup8 = trackGroup2;
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
                    TrackGroup trackGroup9 = trackGroupArray6.l[i49];
                    if (dVar6.F || dVar6.E || !z13) {
                        aVar2 = aVar6;
                        i2 = i47;
                        i3 = i45;
                        dVar2 = dVar9;
                    } else {
                        int[] iArr21 = iArr19[i49];
                        int i55 = dVar6.f908z;
                        boolean z14 = dVar6.O;
                        boolean z15 = dVar6.P;
                        boolean z16 = dVar6.Q;
                        Format2 format3 = trackGroup9.l[i50];
                        int[] iArr22 = new int[trackGroup9.k];
                        aVar2 = aVar6;
                        i3 = i45;
                        dVar2 = dVar9;
                        int i56 = 0;
                        int i57 = 0;
                        while (i57 < trackGroup9.k) {
                            if (i57 != i50) {
                                Format2 format4 = trackGroup9.l[i57];
                                i4 = i47;
                                iArr4 = iArr21;
                                if (DefaultTrackSelector.e(iArr21[i57], false) && (i5 = format4.f1017s) != -1 && i5 <= i55 && (z16 || ((i7 = format4.J) != -1 && i7 == format3.J)) && ((z14 || ((str4 = format4.w) != null && TextUtils.equals(str4, format3.w))) && (z15 || ((i6 = format4.K) != -1 && i6 == format3.K)))) {
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
                        aVar3 = iArrCopyOf.length > 1 ? new ExoTrackSelection2.a(trackGroup9, iArrCopyOf) : null;
                        if (aVar3 == null) {
                            aVar3 = new ExoTrackSelection2.a(trackGroup9, i50);
                        }
                        Objects.requireNonNull(bVar2);
                        pairCreate2 = Pair.create(aVar3, bVar2);
                    }
                    if (aVar3 == null) {
                        aVar3 = new ExoTrackSelection2.a(trackGroup9, i50);
                    }
                    Objects.requireNonNull(bVar2);
                    pairCreate2 = Pair.create(aVar3, bVar2);
                }
                if (pairCreate2 != null && (bVar == null || ((DefaultTrackSelector.b) pairCreate2.second).compareTo(bVar) > 0)) {
                    if (i46 != -1) {
                        aVarArr3[i46] = null;
                    }
                    ExoTrackSelection2.a aVar8 = (ExoTrackSelection2.a) pairCreate2.first;
                    aVarArr3[i2] = aVar8;
                    str7 = aVar8.a.l[aVar8.f902b[0]].n;
                    i46 = i2;
                    bVar = (DefaultTrackSelector.b) pairCreate2.second;
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
        DefaultTrackSelector.d dVar10 = dVar9;
        String str9 = str7;
        int i58 = i45;
        int i59 = -1;
        int i60 = 0;
        DefaultTrackSelector.g gVar = null;
        while (i60 < i58) {
            a aVar10 = aVar9;
            int i61 = aVar10.f903b[i60];
            if (i61 == 1 || i61 == 2) {
                str = str9;
                dVar = dVar10;
            } else if (i61 != 3) {
                TrackGroupArray trackGroupArray7 = aVar10.c[i60];
                int[][] iArr23 = iArr17[i60];
                TrackGroup trackGroup10 = null;
                DefaultTrackSelector.c cVar = null;
                int i62 = 0;
                int i63 = 0;
                while (i62 < trackGroupArray7.k) {
                    TrackGroup trackGroup11 = trackGroupArray7.l[i62];
                    int[] iArr24 = iArr23[i62];
                    int i64 = i63;
                    DefaultTrackSelector.c cVar2 = cVar;
                    TrackGroup trackGroup12 = trackGroup10;
                    int i65 = 0;
                    while (i65 < trackGroup11.k) {
                        TrackGroupArray trackGroupArray8 = trackGroupArray7;
                        DefaultTrackSelector.d dVar11 = dVar10;
                        if (DefaultTrackSelector.e(iArr24[i65], dVar11.R)) {
                            iArr3 = iArr23;
                            DefaultTrackSelector.c cVar3 = new DefaultTrackSelector.c(trackGroup11.l[i65], iArr24[i65]);
                            if (cVar2 == null || cVar3.compareTo(cVar2) > 0) {
                                i64 = i65;
                                trackGroup12 = trackGroup11;
                                cVar2 = cVar3;
                            }
                        } else {
                            iArr3 = iArr23;
                        }
                        i65++;
                        dVar10 = dVar11;
                        trackGroupArray7 = trackGroupArray8;
                        iArr23 = iArr3;
                    }
                    i62++;
                    trackGroup10 = trackGroup12;
                    cVar = cVar2;
                    i63 = i64;
                }
                dVar = dVar10;
                aVarArr3[i60] = trackGroup10 == null ? null : new ExoTrackSelection2.a(trackGroup10, i63);
                str = str9;
            } else {
                dVar = dVar10;
                TrackGroupArray trackGroupArray9 = aVar10.c[i60];
                int[][] iArr25 = iArr17[i60];
                TrackGroup trackGroup13 = null;
                DefaultTrackSelector.g gVar2 = null;
                int i66 = -1;
                int i67 = 0;
                while (i67 < trackGroupArray9.k) {
                    TrackGroup trackGroup14 = trackGroupArray9.l[i67];
                    int[] iArr26 = iArr25[i67];
                    int i68 = i66;
                    DefaultTrackSelector.g gVar3 = gVar2;
                    TrackGroup trackGroup15 = trackGroup13;
                    int i69 = 0;
                    while (i69 < trackGroup14.k) {
                        TrackGroupArray trackGroupArray10 = trackGroupArray9;
                        if (DefaultTrackSelector.e(iArr26[i69], dVar.R)) {
                            iArr2 = iArr25;
                            trackGroup = trackGroup14;
                            str2 = str9;
                            DefaultTrackSelector.g gVar4 = new DefaultTrackSelector.g(trackGroup14.l[i69], dVar, iArr26[i69], str2);
                            if (gVar4.j && (gVar3 == null || gVar4.compareTo(gVar3) > 0)) {
                                i68 = i69;
                                gVar3 = gVar4;
                                trackGroup15 = trackGroup;
                            }
                        } else {
                            iArr2 = iArr25;
                            trackGroup = trackGroup14;
                            str2 = str9;
                        }
                        i69++;
                        str9 = str2;
                        trackGroupArray9 = trackGroupArray10;
                        iArr25 = iArr2;
                        trackGroup14 = trackGroup;
                    }
                    i67++;
                    trackGroup13 = trackGroup15;
                    gVar2 = gVar3;
                    i66 = i68;
                }
                str = str9;
                if (trackGroup13 == null) {
                    pairCreate = null;
                } else {
                    ExoTrackSelection2.a aVar11 = new ExoTrackSelection2.a(trackGroup13, i66);
                    Objects.requireNonNull(gVar2);
                    pairCreate = Pair.create(aVar11, gVar2);
                }
                if (pairCreate != null && (gVar == null || ((DefaultTrackSelector.g) pairCreate.second).compareTo(gVar) > 0)) {
                    if (i59 != -1) {
                        aVarArr3[i59] = null;
                    }
                    aVarArr3[i60] = (ExoTrackSelection2.a) pairCreate.first;
                    gVar = (DefaultTrackSelector.g) pairCreate.second;
                    i59 = i60;
                }
            }
            i60++;
            aVar9 = aVar10;
            str9 = str;
            dVar10 = dVar;
        }
        a aVar12 = aVar9;
        DefaultTrackSelector.d dVar12 = dVar10;
        for (int i70 = 0; i70 < i58; i70++) {
            ExoTrackSelection2.a aVar13 = aVarArr3[i70];
            int i71 = aVar12.f903b[i70];
            if (dVar12.V.get(i70) || dVar12.H.contains(Integer.valueOf(i71))) {
                aVar13 = null;
            } else {
                TrackGroupArray trackGroupArray11 = aVar12.c[i70];
                Map<TrackGroupArray, DefaultTrackSelector.f> map = dVar12.U.get(i70);
                if (map != null && map.containsKey(trackGroupArray11)) {
                    Map<TrackGroupArray, DefaultTrackSelector.f> map2 = dVar12.U.get(i70);
                    DefaultTrackSelector.f fVar = map2 != null ? map2.get(trackGroupArray11) : null;
                    if (fVar == null) {
                        aVar13 = null;
                    } else {
                        aVar13 = new ExoTrackSelection2.a(trackGroupArray11.l[fVar.j], fVar.k, fVar.l);
                    }
                } else {
                    for (int i72 = 0; i72 < trackGroupArray11.k; i72++) {
                        TrackGroup trackGroup16 = trackGroupArray11.l[i72];
                        TrackSelectionOverrides.a aVar14 = dVar12.G.l.get(trackGroup16);
                        if (aVar14 != null) {
                            aVar13 = new ExoTrackSelection2.a(trackGroup16, b.i.a.f.e.o.f.q1(aVar14.l));
                            break;
                        }
                    }
                }
            }
            aVarArr3[i70] = aVar13;
        }
        ExoTrackSelection2.b bVar5 = defaultTrackSelector3.e;
        BandwidthMeter bandwidthMeter = defaultTrackSelector3.a;
        Objects.requireNonNull(bandwidthMeter);
        Objects.requireNonNull((AdaptiveTrackSelection.b) bVar5);
        ArrayList arrayList6 = new ArrayList();
        for (int i73 = 0; i73 < i58; i73++) {
            if (aVarArr3[i73] == null || aVarArr3[i73].f902b.length <= 1) {
                arrayList6.add(null);
            } else {
                AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
                ImmutableList2.a aVar15 = new ImmutableList2.a();
                aVar15.b(new AdaptiveTrackSelection.a(0L, 0L));
                arrayList6.add(aVar15);
            }
        }
        long[][] jArr = new long[i58][];
        for (int i74 = 0; i74 < i58; i74++) {
            ExoTrackSelection2.a aVar16 = aVarArr3[i74];
            if (aVar16 == null) {
                jArr[i74] = new long[0];
            } else {
                jArr[i74] = new long[aVar16.f902b.length];
                int i75 = 0;
                while (true) {
                    int[] iArr27 = aVar16.f902b;
                    if (i75 >= iArr27.length) {
                        break;
                    }
                    jArr[i74][i75] = aVar16.a.l[iArr27[i75]].f1017s;
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
        AdaptiveTrackSelection.m(arrayList6, jArr2);
        NaturalOrdering naturalOrdering = NaturalOrdering.j;
        b.i.a.f.e.o.f.A(2, "expectedValuesPerKey");
        Multimaps multimaps = new Multimaps(new TreeMap(naturalOrdering), new MultimapBuilder(2));
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
                    Collection collection = (Collection) multimaps.m.get(objValueOf);
                    if (collection == null) {
                        Collection collectionE = multimaps.e();
                        if (!collectionE.add(numValueOf)) {
                            throw new AssertionError("New Collection violated the Collection spec");
                        }
                        multimaps.n++;
                        multimaps.m.put((K) objValueOf, (Collection<V>) collectionE);
                    } else if (collection.add(numValueOf)) {
                        multimaps.n++;
                    }
                    i79 = i81;
                    d = d3;
                }
            }
            i77++;
            iArr28 = iArr;
        }
        int[] iArr29 = iArr28;
        Collection aVar17 = multimaps.k;
        if (aVar17 == null) {
            aVar17 = new AbstractMultimap.a();
            multimaps.k = aVar17;
        }
        ImmutableList2 immutableList2N = ImmutableList2.n(aVar17);
        for (int i82 = 0; i82 < immutableList2N.size(); i82++) {
            int iIntValue3 = ((Integer) immutableList2N.get(i82)).intValue();
            int i83 = iArr29[iIntValue3] + 1;
            iArr29[iIntValue3] = i83;
            jArr2[iIntValue3] = jArr[iIntValue3][i83];
            AdaptiveTrackSelection.m(arrayList6, jArr2);
        }
        for (int i84 = 0; i84 < i58; i84++) {
            if (arrayList6.get(i84) != null) {
                jArr2[i84] = jArr2[i84] * 2;
            }
        }
        AdaptiveTrackSelection.m(arrayList6, jArr2);
        b.i.a.f.e.o.f.A(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        int i85 = 0;
        int i86 = 0;
        while (i85 < arrayList6.size()) {
            ImmutableList2.a aVar18 = (ImmutableList2.a) arrayList6.get(i85);
            ImmutableList2<Object> immutableList2C = aVar18 == null ? RegularImmutableList.l : aVar18.c();
            Objects.requireNonNull(immutableList2C);
            int i87 = i86 + 1;
            if (objArrCopyOf.length < i87) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, ImmutableCollection.b.a(objArrCopyOf.length, i87));
            }
            objArrCopyOf[i86] = immutableList2C;
            i85++;
            i86 = i87;
        }
        ImmutableList2 immutableList2L = ImmutableList2.l(objArrCopyOf, i86);
        ExoTrackSelection2[] exoTrackSelection2Arr = new ExoTrackSelection2[i58];
        for (int i88 = 0; i88 < i58; i88++) {
            ExoTrackSelection2.a aVar19 = aVarArr3[i88];
            if (aVar19 != null) {
                int[] iArr30 = aVar19.f902b;
                if (iArr30.length != 0) {
                    if (iArr30.length == 1) {
                        adaptiveTrackSelection = new FixedTrackSelection(aVar19.a, iArr30[0], aVar19.c);
                    } else {
                        long j = 25000;
                        adaptiveTrackSelection = new AdaptiveTrackSelection(aVar19.a, iArr30, aVar19.c, bandwidthMeter, 10000, j, j, 1279, 719, 0.7f, 0.75f, (ImmutableList2) immutableList2L.get(i88), Clock4.a);
                    }
                    exoTrackSelection2Arr[i88] = adaptiveTrackSelection;
                }
            }
        }
        RendererConfiguration[] rendererConfigurationArr = new RendererConfiguration[i58];
        for (int i89 = 0; i89 < i58; i89++) {
            rendererConfigurationArr[i89] = !(dVar12.V.get(i89) || dVar12.H.contains(Integer.valueOf(aVar12.f903b[i89]))) && (aVar12.f903b[i89] == -2 || exoTrackSelection2Arr[i89] != null) ? RendererConfiguration.a : null;
        }
        if (dVar12.S) {
            int i90 = 0;
            int i91 = -1;
            int i92 = -1;
            while (true) {
                if (i90 >= aVar12.a) {
                    i = -1;
                    z2 = true;
                    break;
                }
                int i93 = aVar12.f903b[i90];
                ExoTrackSelection2 exoTrackSelection2 = exoTrackSelection2Arr[i90];
                if (i93 == 1 || i93 == 2) {
                    if (exoTrackSelection2 != null) {
                        int[][] iArr31 = iArr17[i90];
                        int iA = aVar12.c[i90].a(exoTrackSelection2.a());
                        int i94 = 0;
                        while (true) {
                            if (i94 >= exoTrackSelection2.length()) {
                                z3 = true;
                                break;
                            }
                            if ((iArr31[iA][exoTrackSelection2.f(i94)] & 32) != 32) {
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
                RendererConfiguration rendererConfiguration = new RendererConfiguration(true);
                rendererConfigurationArr[i91] = rendererConfiguration;
                rendererConfigurationArr[i92] = rendererConfiguration;
            }
        }
        Pair pairCreate3 = Pair.create(rendererConfigurationArr, exoTrackSelection2Arr);
        TrackSelection[] trackSelectionArr = (TrackSelection[]) pairCreate3.second;
        b.i.a.f.e.o.f.A(4, "initialCapacity");
        Object[] objArrCopyOf2 = new Object[4];
        int i95 = 0;
        int i96 = 0;
        while (i95 < aVar12.a) {
            TrackGroupArray trackGroupArray12 = aVar12.c[i95];
            TrackSelection trackSelection = trackSelectionArr[i95];
            Object[] objArrCopyOf3 = objArrCopyOf2;
            int i97 = i96;
            int i98 = 0;
            while (i98 < trackGroupArray12.k) {
                TrackGroup trackGroup17 = trackGroupArray12.l[i98];
                int i99 = trackGroup17.k;
                int[] iArr32 = new int[i99];
                boolean[] zArr = new boolean[i99];
                for (int i100 = 0; i100 < trackGroup17.k; i100++) {
                    iArr32[i100] = aVar12.a(i95, i98, i100);
                    if (trackSelection != null && trackSelection.a() == trackGroup17) {
                        boolean z17 = trackSelection.l(i100) != -1;
                        zArr[i100] = z17;
                    }
                    zArr[i100] = z17;
                }
                TracksInfo.a aVar20 = new TracksInfo.a(trackGroup17, iArr32, aVar12.f903b[i95], zArr);
                int i101 = i97 + 1;
                if (objArrCopyOf3.length < i101) {
                    objArrCopyOf3 = Arrays.copyOf(objArrCopyOf3, ImmutableCollection.b.a(objArrCopyOf3.length, i101));
                }
                objArrCopyOf3[i97] = aVar20;
                i98++;
                i97 = i101;
            }
            i95++;
            i96 = i97;
            objArrCopyOf2 = objArrCopyOf3;
        }
        TrackGroupArray trackGroupArray13 = aVar12.f;
        int i102 = 0;
        while (i102 < trackGroupArray13.k) {
            TrackGroup trackGroup18 = trackGroupArray13.l[i102];
            int[] iArr33 = new int[trackGroup18.k];
            Arrays.fill(iArr33, 0);
            TracksInfo.a aVar21 = new TracksInfo.a(trackGroup18, iArr33, MimeTypes.g(trackGroup18.l[0].w), new boolean[trackGroup18.k]);
            int i103 = i96 + 1;
            if (objArrCopyOf2.length < i103) {
                objArrCopyOf2 = Arrays.copyOf(objArrCopyOf2, ImmutableCollection.b.a(objArrCopyOf2.length, i103));
            }
            objArrCopyOf2[i96] = aVar21;
            i102++;
            i96 = i103;
        }
        return new TrackSelectorResult((RendererConfiguration[]) pairCreate3.first, (ExoTrackSelection2[]) pairCreate3.second, new TracksInfo(ImmutableList2.l(objArrCopyOf2, i96)), aVar12);
    }
}

package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.h.m.e;
import b.i.a.f.j.b.e.k0;
import com.esotericsoftware.kryo.Kryo;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.nearby.zzgs;
import com.google.android.gms.nearby.messages.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class Update extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Update> CREATOR = new k0();
    public final int j;
    public final int k;
    public final Message l;

    @Nullable
    public final zze m;

    @Nullable
    public final zza n;

    @Nullable
    public final zzgs o;

    @Nullable
    public final byte[] p;

    public Update(int i, int i2, Message message, @Nullable zze zzeVar, @Nullable zza zzaVar, @Nullable zzgs zzgsVar, @Nullable byte[] bArr) {
        this.j = i;
        if ((i2 & 2) != 0) {
            i2 = 2;
            zzeVar = null;
            zzaVar = null;
            zzgsVar = null;
            bArr = null;
        }
        this.k = i2;
        this.l = message;
        this.m = zzeVar;
        this.n = zzaVar;
        this.o = zzgsVar;
        this.p = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Update)) {
            return false;
        }
        Update update = (Update) obj;
        return this.k == update.k && AnimatableValueParser.h0(this.l, update.l) && AnimatableValueParser.h0(this.m, update.m) && AnimatableValueParser.h0(this.n, update.n) && AnimatableValueParser.h0(this.o, update.o) && Arrays.equals(this.p, update.p);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.k), this.l, this.m, this.n, this.o, this.p});
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:45:0x0121  */
    /* JADX WARN: Code duplicated, block: B:46:0x0124  */
    /* JADX WARN: Code duplicated, block: B:60:0x0147  */
    /* JADX WARN: Code duplicated, block: B:61:0x014c  */
    public String toString() {
        String str;
        String strValueOf;
        String str2;
        ArrayList arrayList;
        ArraySet arraySet = new ArraySet();
        if (w0(1)) {
            arraySet.add("FOUND");
        }
        if (w0(2)) {
            arraySet.add("LOST");
        }
        if (w0(4)) {
            arraySet.add("DISTANCE");
        }
        if (w0(8)) {
            arraySet.add("BLE_SIGNAL");
        }
        if (w0(16)) {
            arraySet.add("DEVICE");
        }
        if (w0(32)) {
            arraySet.add("BLE_RECORD");
        }
        String strValueOf2 = String.valueOf(arraySet);
        String strValueOf3 = String.valueOf(this.l);
        String strValueOf4 = String.valueOf(this.m);
        String strValueOf5 = String.valueOf(this.n);
        String strValueOf6 = String.valueOf(this.o);
        byte[] bArr = this.p;
        ParcelUuid parcelUuid = e.a;
        e eVar = null;
        if (bArr == null) {
            str = strValueOf6;
        } else {
            int i = 0;
            ArrayList arrayList2 = new ArrayList();
            SparseArray sparseArray = new SparseArray();
            HashMap map = new HashMap();
            String str3 = null;
            int i2 = -1;
            byte b2 = Kryo.NULL;
            try {
                while (i < bArr.length) {
                    try {
                        int i3 = i + 1;
                        int i4 = bArr[i] & 255;
                        if (i4 != 0) {
                            int i5 = i4 - 1;
                            int i6 = i3 + 1;
                            int i7 = bArr[i3] & 255;
                            str = strValueOf6;
                            if (i7 == 22) {
                                map.put(e.c(e.b(bArr, i6, 2)), e.b(bArr, i6 + 2, i5 - 2));
                            } else if (i7 != 255) {
                                switch (i7) {
                                    case 1:
                                        i2 = bArr[i6] & 255;
                                        break;
                                    case 2:
                                    case 3:
                                        e.a(bArr, i6, i5, 2, arrayList2);
                                        break;
                                    case 4:
                                    case 5:
                                        e.a(bArr, i6, i5, 4, arrayList2);
                                        break;
                                    case 6:
                                    case 7:
                                        e.a(bArr, i6, i5, 16, arrayList2);
                                        break;
                                    case 8:
                                    case 9:
                                        str3 = new String(e.b(bArr, i6, i5));
                                        break;
                                    case 10:
                                        b2 = bArr[i6];
                                        break;
                                    default:
                                        break;
                                }
                            } else {
                                sparseArray.put(((bArr[i6 + 1] & 255) << 8) + (bArr[i6] & 255), e.b(bArr, i6 + 2, i5 - 2));
                            }
                            try {
                                i = i5 + i6;
                                strValueOf6 = str;
                            } catch (Exception e) {
                                e = e;
                            }
                        } else {
                            str = strValueOf6;
                            if (arrayList2.isEmpty()) {
                                arrayList = null;
                            } else {
                                arrayList = arrayList2;
                            }
                            eVar = new e(arrayList, sparseArray, map, i2, b2, str3, bArr);
                        }
                        e = e;
                    } catch (Exception e2) {
                        e = e2;
                        str = strValueOf6;
                    }
                    strValueOf = String.valueOf(Arrays.toString(bArr));
                    if (strValueOf.length() != 0) {
                        str2 = "Unable to parse scan record: ".concat(strValueOf);
                    } else {
                        str2 = new String("Unable to parse scan record: ");
                    }
                    Log.w("BleRecord", str2, e);
                }
                eVar = new e(arrayList, sparseArray, map, i2, b2, str3, bArr);
            } catch (Exception e3) {
                e = e3;
                strValueOf = String.valueOf(Arrays.toString(bArr));
                if (strValueOf.length() != 0) {
                    str2 = "Unable to parse scan record: ".concat(strValueOf);
                } else {
                    str2 = new String("Unable to parse scan record: ");
                }
                Log.w("BleRecord", str2, e);
            }
            str = strValueOf6;
            if (arrayList2.isEmpty()) {
                arrayList = null;
            } else {
                arrayList = arrayList2;
            }
        }
        String strValueOf7 = String.valueOf(eVar);
        StringBuilder sbS = outline.S(strValueOf7.length() + str.length() + strValueOf5.length() + strValueOf4.length() + strValueOf3.length() + strValueOf2.length() + 68, "Update{types=", strValueOf2, ", message=", strValueOf3);
        outline.s0(sbS, ", distance=", strValueOf4, ", bleSignal=", strValueOf5);
        outline.s0(sbS, ", device=", str, ", bleRecord=", strValueOf7);
        sbS.append("}");
        return sbS.toString();
    }

    public final boolean w0(int i) {
        return (i & this.k) != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.k;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        AnimatableValueParser.s2(parcel, 3, this.l, i, false);
        AnimatableValueParser.s2(parcel, 4, this.m, i, false);
        AnimatableValueParser.s2(parcel, 5, this.n, i, false);
        AnimatableValueParser.s2(parcel, 6, this.o, i, false);
        AnimatableValueParser.q2(parcel, 7, this.p, false);
        AnimatableValueParser.A2(parcel, iY2);
    }
}

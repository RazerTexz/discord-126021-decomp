package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import com.esotericsoftware.kryo.Kryo;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.nearby.zzgs;
import com.google.android.gms.nearby.messages.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p313h.p326m.C3928e;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4291k0;

/* JADX INFO: loaded from: classes3.dex */
public class Update extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Update> CREATOR = new C4291k0();

    /* JADX INFO: renamed from: j */
    public final int f20764j;

    /* JADX INFO: renamed from: k */
    public final int f20765k;

    /* JADX INFO: renamed from: l */
    public final Message f20766l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public final zze f20767m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public final zza f20768n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public final zzgs f20769o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public final byte[] f20770p;

    public Update(int i, int i2, Message message, @Nullable zze zzeVar, @Nullable zza zzaVar, @Nullable zzgs zzgsVar, @Nullable byte[] bArr) {
        this.f20764j = i;
        if ((i2 & 2) != 0) {
            i2 = 2;
            zzeVar = null;
            zzaVar = null;
            zzgsVar = null;
            bArr = null;
        }
        this.f20765k = i2;
        this.f20766l = message;
        this.f20767m = zzeVar;
        this.f20768n = zzaVar;
        this.f20769o = zzgsVar;
        this.f20770p = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Update)) {
            return false;
        }
        Update update = (Update) obj;
        return this.f20765k == update.f20765k && C1460d.m524h0(this.f20766l, update.f20766l) && C1460d.m524h0(this.f20767m, update.f20767m) && C1460d.m524h0(this.f20768n, update.f20768n) && C1460d.m524h0(this.f20769o, update.f20769o) && Arrays.equals(this.f20770p, update.f20770p);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f20765k), this.f20766l, this.f20767m, this.f20768n, this.f20769o, this.f20770p});
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
        if (m9123w0(1)) {
            arraySet.add("FOUND");
        }
        if (m9123w0(2)) {
            arraySet.add("LOST");
        }
        if (m9123w0(4)) {
            arraySet.add("DISTANCE");
        }
        if (m9123w0(8)) {
            arraySet.add("BLE_SIGNAL");
        }
        if (m9123w0(16)) {
            arraySet.add("DEVICE");
        }
        if (m9123w0(32)) {
            arraySet.add("BLE_RECORD");
        }
        String strValueOf2 = String.valueOf(arraySet);
        String strValueOf3 = String.valueOf(this.f20766l);
        String strValueOf4 = String.valueOf(this.f20767m);
        String strValueOf5 = String.valueOf(this.f20768n);
        String strValueOf6 = String.valueOf(this.f20769o);
        byte[] bArr = this.f20770p;
        ParcelUuid parcelUuid = C3928e.f10450a;
        C3928e c3928e = null;
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
                                map.put(C3928e.m5405c(C3928e.m5404b(bArr, i6, 2)), C3928e.m5404b(bArr, i6 + 2, i5 - 2));
                            } else if (i7 != 255) {
                                switch (i7) {
                                    case 1:
                                        i2 = bArr[i6] & 255;
                                        break;
                                    case 2:
                                    case 3:
                                        C3928e.m5403a(bArr, i6, i5, 2, arrayList2);
                                        break;
                                    case 4:
                                    case 5:
                                        C3928e.m5403a(bArr, i6, i5, 4, arrayList2);
                                        break;
                                    case 6:
                                    case 7:
                                        C3928e.m5403a(bArr, i6, i5, 16, arrayList2);
                                        break;
                                    case 8:
                                    case 9:
                                        str3 = new String(C3928e.m5404b(bArr, i6, i5));
                                        break;
                                    case 10:
                                        b2 = bArr[i6];
                                        break;
                                    default:
                                        break;
                                }
                            } else {
                                sparseArray.put(((bArr[i6 + 1] & 255) << 8) + (bArr[i6] & 255), C3928e.m5404b(bArr, i6 + 2, i5 - 2));
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
                            c3928e = new C3928e(arrayList, sparseArray, map, i2, b2, str3, bArr);
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
                c3928e = new C3928e(arrayList, sparseArray, map, i2, b2, str3, bArr);
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
        String strValueOf7 = String.valueOf(c3928e);
        StringBuilder sbM831S = C1643a.m831S(strValueOf7.length() + str.length() + strValueOf5.length() + strValueOf4.length() + strValueOf3.length() + strValueOf2.length() + 68, "Update{types=", strValueOf2, ", message=", strValueOf3);
        C1643a.m876s0(sbM831S, ", distance=", strValueOf4, ", bleSignal=", strValueOf5);
        C1643a.m876s0(sbM831S, ", device=", str, ", bleRecord=", strValueOf7);
        sbM831S.append("}");
        return sbM831S.toString();
    }

    /* JADX INFO: renamed from: w0 */
    public final boolean m9123w0(int i) {
        return (i & this.f20765k) != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20764j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.f20765k;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        C1460d.m570s2(parcel, 3, this.f20766l, i, false);
        C1460d.m570s2(parcel, 4, this.f20767m, i, false);
        C1460d.m570s2(parcel, 5, this.f20768n, i, false);
        C1460d.m570s2(parcel, 6, this.f20769o, i, false);
        C1460d.m562q2(parcel, 7, this.f20770p, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}

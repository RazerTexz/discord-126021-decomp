package p007b.p225i.p226a.p288f.p313h.p326m;

import android.os.ParcelUuid;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3402d;

/* JADX INFO: renamed from: b.i.a.f.h.m.e */
/* JADX INFO: loaded from: classes3.dex */
public final class C3928e {

    /* JADX INFO: renamed from: a */
    public static final ParcelUuid f10450a = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");

    /* JADX INFO: renamed from: b */
    public final int f10451b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final List<ParcelUuid> f10452c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public final SparseArray<byte[]> f10453d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public final Map<ParcelUuid, byte[]> f10454e;

    /* JADX INFO: renamed from: f */
    public final int f10455f;

    /* JADX INFO: renamed from: g */
    @Nullable
    public final String f10456g;

    /* JADX INFO: renamed from: h */
    public final byte[] f10457h;

    public C3928e(@Nullable List<ParcelUuid> list, @Nullable SparseArray<byte[]> sparseArray, @Nullable Map<ParcelUuid, byte[]> map, int i, int i2, @Nullable String str, byte[] bArr) {
        this.f10452c = list;
        this.f10453d = sparseArray;
        this.f10454e = map;
        this.f10456g = str;
        this.f10451b = i;
        this.f10455f = i2;
        this.f10457h = bArr;
    }

    /* JADX INFO: renamed from: a */
    public static int m5403a(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(m5405c(m5404b(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    /* JADX INFO: renamed from: b */
    public static byte[] m5404b(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    /* JADX INFO: renamed from: c */
    public static ParcelUuid m5405c(byte[] bArr) {
        long j;
        int length = bArr.length;
        if (length != 2 && length != 4 && length != 16) {
            throw new IllegalArgumentException(C1643a.m851g(38, "uuidBytes length invalid - ", length));
        }
        if (length == 16) {
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            return new ParcelUuid(new UUID(byteBufferOrder.getLong(8), byteBufferOrder.getLong(0)));
        }
        if (length == 2) {
            j = ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8));
        } else {
            j = ((long) ((bArr[3] & 255) << 24)) + ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8)) + ((long) ((bArr[2] & 255) << 16));
        }
        ParcelUuid parcelUuid = f10450a;
        return new ParcelUuid(new UUID(parcelUuid.getUuid().getMostSignificantBits() + (j << 32), parcelUuid.getUuid().getLeastSignificantBits()));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C3928e) {
            return Arrays.equals(this.f10457h, ((C3928e) obj).f10457h);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f10457h);
    }

    public final String toString() {
        String string;
        int i = this.f10451b;
        String strValueOf = String.valueOf(this.f10452c);
        SparseArray<byte[]> sparseArray = this.f10453d;
        StringBuilder sb = new StringBuilder();
        String string2 = "{}";
        if (sparseArray.size() <= 0) {
            string = "{}";
        } else {
            sb.append('{');
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (i2 > 0) {
                    sb.append(", ");
                }
                int iKeyAt = sparseArray.keyAt(i2);
                byte[] bArrValueAt = sparseArray.valueAt(i2);
                sb.append(iKeyAt);
                sb.append('=');
                sb.append(bArrValueAt == null ? null : C3402d.m4187a(bArrValueAt, false));
            }
            sb.append('}');
            string = sb.toString();
        }
        Map<ParcelUuid, byte[]> map = this.f10454e;
        StringBuilder sb2 = new StringBuilder();
        if (map.keySet().size() > 0) {
            sb2.append('{');
            int i3 = 0;
            for (Map.Entry<ParcelUuid, byte[]> entry : map.entrySet()) {
                if (i3 > 0) {
                    sb2.append(", ");
                }
                sb2.append(entry.getKey());
                sb2.append('=');
                byte[] value = entry.getValue();
                sb2.append(value == null ? null : C3402d.m4187a(value, false));
                i3++;
            }
            sb2.append('}');
            string2 = sb2.toString();
        }
        int i4 = this.f10455f;
        String str = this.f10456g;
        StringBuilder sb3 = new StringBuilder(C1643a.m841b(str, C1643a.m841b(string2, C1643a.m841b(string, strValueOf.length() + Opcodes.F2I))));
        sb3.append("BleRecord [mAdvertiseFlags=");
        sb3.append(i);
        sb3.append(", mServiceUuids=");
        sb3.append(strValueOf);
        C1643a.m876s0(sb3, ", mManufacturerSpecificData=", string, ", mServiceData=", string2);
        sb3.append(", mTxPowerLevel=");
        sb3.append(i4);
        sb3.append(", mDeviceName=");
        sb3.append(str);
        sb3.append("]");
        return sb3.toString();
    }
}

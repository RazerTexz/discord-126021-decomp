package b.i.a.f.h.m;

import android.os.ParcelUuid;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final ParcelUuid a = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1508b;

    @Nullable
    public final List<ParcelUuid> c;

    @Nullable
    public final SparseArray<byte[]> d;

    @Nullable
    public final Map<ParcelUuid, byte[]> e;
    public final int f;

    @Nullable
    public final String g;
    public final byte[] h;

    public e(@Nullable List<ParcelUuid> list, @Nullable SparseArray<byte[]> sparseArray, @Nullable Map<ParcelUuid, byte[]> map, int i, int i2, @Nullable String str, byte[] bArr) {
        this.c = list;
        this.d = sparseArray;
        this.e = map;
        this.g = str;
        this.f1508b = i;
        this.f = i2;
        this.h = bArr;
    }

    public static int a(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(c(b(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    public static byte[] b(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static ParcelUuid c(byte[] bArr) {
        long j;
        int length = bArr.length;
        if (length != 2 && length != 4 && length != 16) {
            throw new IllegalArgumentException(outline.g(38, "uuidBytes length invalid - ", length));
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
        ParcelUuid parcelUuid = a;
        return new ParcelUuid(new UUID(parcelUuid.getUuid().getMostSignificantBits() + (j << 32), parcelUuid.getUuid().getLeastSignificantBits()));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            return Arrays.equals(this.h, ((e) obj).h);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.h);
    }

    public final String toString() {
        String string;
        int i = this.f1508b;
        String strValueOf = String.valueOf(this.c);
        SparseArray<byte[]> sparseArray = this.d;
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
                sb.append(bArrValueAt == null ? null : b.i.a.f.e.o.d.a(bArrValueAt, false));
            }
            sb.append('}');
            string = sb.toString();
        }
        Map<ParcelUuid, byte[]> map = this.e;
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
                sb2.append(value == null ? null : b.i.a.f.e.o.d.a(value, false));
                i3++;
            }
            sb2.append('}');
            string2 = sb2.toString();
        }
        int i4 = this.f;
        String str = this.g;
        StringBuilder sb3 = new StringBuilder(outline.b(str, outline.b(string2, outline.b(string, strValueOf.length() + Opcodes.F2I))));
        sb3.append("BleRecord [mAdvertiseFlags=");
        sb3.append(i);
        sb3.append(", mServiceUuids=");
        sb3.append(strValueOf);
        outline.s0(sb3, ", mManufacturerSpecificData=", string, ", mServiceData=", string2);
        sb3.append(", mTxPowerLevel=");
        sb3.append(i4);
        sb3.append(", mDeviceName=");
        sb3.append(str);
        sb3.append("]");
        return sb3.toString();
    }
}

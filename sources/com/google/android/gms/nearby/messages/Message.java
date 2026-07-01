package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import b.c.a.a0.d;
import b.d.b.a.a;
import b.i.a.f.j.b.f;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.nearby.zzgs;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class Message extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable$Creator<Message> CREATOR = new f();
    public static final zzgs[] j = {zzgs.j};
    public final int k;
    public final byte[] l;
    public final String m;
    public final String n;

    @Deprecated
    public final zzgs[] o;
    public final long p;

    public Message(int i, @Nullable byte[] bArr, @Nullable String str, String str2, @Nullable zzgs[] zzgsVarArr, long j2) {
        this.k = i;
        Objects.requireNonNull(str2, "null reference");
        this.m = str2;
        this.n = str == null ? "" : str;
        this.p = j2;
        Objects.requireNonNull(bArr, "null reference");
        d.n(bArr.length <= 102400, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", Integer.valueOf(bArr.length), 102400);
        this.l = bArr;
        this.o = (zzgsVarArr == null || zzgsVarArr.length == 0) ? j : zzgsVarArr;
        d.n(str2.length() <= 32, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", Integer.valueOf(str2.length()), 32);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        return TextUtils.equals(this.n, message.n) && TextUtils.equals(this.m, message.m) && Arrays.equals(this.l, message.l) && this.p == message.p;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.n, this.m, Integer.valueOf(Arrays.hashCode(this.l)), Long.valueOf(this.p)});
    }

    public String toString() {
        String str = this.n;
        String str2 = this.m;
        byte[] bArr = this.l;
        int length = bArr == null ? 0 : bArr.length;
        StringBuilder sbS = a.S(a.b(str2, a.b(str, 59)), "Message{namespace='", str, "', type='", str2);
        sbS.append("', content=[");
        sbS.append(length);
        sbS.append(" bytes]}");
        return sbS.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        d.q2(parcel, 1, this.l, false);
        d.t2(parcel, 2, this.m, false);
        d.t2(parcel, 3, this.n, false);
        d.v2(parcel, 4, this.o, i, false);
        long j2 = this.p;
        parcel.writeInt(524293);
        parcel.writeLong(j2);
        int i2 = this.k;
        parcel.writeInt(263144);
        parcel.writeInt(i2);
        d.A2(parcel, iY2);
    }
}

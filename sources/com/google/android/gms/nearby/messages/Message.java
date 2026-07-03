package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.nearby.zzgs;
import java.util.Arrays;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p333j.p334b.C4322f;

/* JADX INFO: loaded from: classes3.dex */
public class Message extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Message> CREATOR = new C4322f();

    /* JADX INFO: renamed from: j */
    public static final zzgs[] f20711j = {zzgs.f20644j};

    /* JADX INFO: renamed from: k */
    public final int f20712k;

    /* JADX INFO: renamed from: l */
    public final byte[] f20713l;

    /* JADX INFO: renamed from: m */
    public final String f20714m;

    /* JADX INFO: renamed from: n */
    public final String f20715n;

    /* JADX INFO: renamed from: o */
    @Deprecated
    public final zzgs[] f20716o;

    /* JADX INFO: renamed from: p */
    public final long f20717p;

    public Message(int i, @Nullable byte[] bArr, @Nullable String str, String str2, @Nullable zzgs[] zzgsVarArr, long j) {
        this.f20712k = i;
        Objects.requireNonNull(str2, "null reference");
        this.f20714m = str2;
        this.f20715n = str == null ? "" : str;
        this.f20717p = j;
        Objects.requireNonNull(bArr, "null reference");
        C1460d.m547n(bArr.length <= 102400, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", Integer.valueOf(bArr.length), 102400);
        this.f20713l = bArr;
        this.f20716o = (zzgsVarArr == null || zzgsVarArr.length == 0) ? f20711j : zzgsVarArr;
        C1460d.m547n(str2.length() <= 32, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", Integer.valueOf(str2.length()), 32);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        return TextUtils.equals(this.f20715n, message.f20715n) && TextUtils.equals(this.f20714m, message.f20714m) && Arrays.equals(this.f20713l, message.f20713l) && this.f20717p == message.f20717p;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f20715n, this.f20714m, Integer.valueOf(Arrays.hashCode(this.f20713l)), Long.valueOf(this.f20717p)});
    }

    public String toString() {
        String str = this.f20715n;
        String str2 = this.f20714m;
        byte[] bArr = this.f20713l;
        int length = bArr == null ? 0 : bArr.length;
        StringBuilder sbM831S = C1643a.m831S(C1643a.m841b(str2, C1643a.m841b(str, 59)), "Message{namespace='", str, "', type='", str2);
        sbM831S.append("', content=[");
        sbM831S.append(length);
        sbM831S.append(" bytes]}");
        return sbM831S.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m562q2(parcel, 1, this.f20713l, false);
        C1460d.m574t2(parcel, 2, this.f20714m, false);
        C1460d.m574t2(parcel, 3, this.f20715n, false);
        C1460d.m582v2(parcel, 4, this.f20716o, i, false);
        long j = this.f20717p;
        parcel.writeInt(524293);
        parcel.writeLong(j);
        int i2 = this.f20712k;
        parcel.writeInt(263144);
        parcel.writeInt(i2);
        C1460d.m418A2(parcel, iM594y2);
    }
}

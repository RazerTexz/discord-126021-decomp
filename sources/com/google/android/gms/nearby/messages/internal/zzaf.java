package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.c.a.a0.d;
import b.d.b.a.a;
import b.i.a.f.j.b.e.e;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.nearby.messages.Message;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaf extends AbstractSafeParcelable {
    public static final Parcelable$Creator<zzaf> CREATOR = new e();
    public final int j;
    public final Message k;

    public zzaf(int i, Message message) {
        this.j = i;
        Objects.requireNonNull(message, "null reference");
        this.k = message;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzaf) {
            return d.h0(this.k, ((zzaf) obj).k);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.k});
    }

    public final String toString() {
        String string = this.k.toString();
        return a.k(a.b(string, 24), "MessageWrapper{message=", string, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        d.s2(parcel, 1, this.k, i, false);
        int i2 = this.j;
        parcel.writeInt(263144);
        parcel.writeInt(i2);
        d.A2(parcel, iY2);
    }
}

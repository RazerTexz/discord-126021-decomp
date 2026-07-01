package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.j.b.g;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.nearby.zzgp;
import com.google.android.gms.internal.nearby.zzgu;
import com.google.android.gms.nearby.messages.internal.zzad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class MessageFilter extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MessageFilter> CREATOR = new g();
    public static final MessageFilter j;
    public final int k;
    public final List<zzad> l;
    public final List<zzgu> m;
    public final boolean n;
    public final List<zzgp> o;
    public final int p;

    static {
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        HashSet hashSet2 = new HashSet();
        AnimatableValueParser.G(true, "At least one of the include methods must be called.");
        j = new MessageFilter(2, new ArrayList(hashSet), arrayList, true, new ArrayList(hashSet2), 0);
    }

    public MessageFilter(int i, List<zzad> list, List<zzgu> list2, boolean z2, List<zzgp> list3, int i2) {
        this.k = i;
        Objects.requireNonNull(list, "null reference");
        this.l = Collections.unmodifiableList(list);
        this.n = z2;
        this.m = Collections.unmodifiableList(list2 == null ? Collections.emptyList() : list2);
        this.o = Collections.unmodifiableList(list3 == null ? Collections.emptyList() : list3);
        this.p = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageFilter)) {
            return false;
        }
        MessageFilter messageFilter = (MessageFilter) obj;
        return this.n == messageFilter.n && AnimatableValueParser.h0(this.l, messageFilter.l) && AnimatableValueParser.h0(this.m, messageFilter.m) && AnimatableValueParser.h0(this.o, messageFilter.o);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.l, this.m, Boolean.valueOf(this.n), this.o});
    }

    public String toString() {
        boolean z2 = this.n;
        String strValueOf = String.valueOf(this.l);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 53);
        sb.append("MessageFilter{includeAllMyTypes=");
        sb.append(z2);
        sb.append(", messageTypes=");
        sb.append(strValueOf);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.w2(parcel, 1, this.l, false);
        AnimatableValueParser.w2(parcel, 2, this.m, false);
        boolean z2 = this.n;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        AnimatableValueParser.w2(parcel, 4, this.o, false);
        int i2 = this.p;
        parcel.writeInt(262149);
        parcel.writeInt(i2);
        int i3 = this.k;
        parcel.writeInt(263144);
        parcel.writeInt(i3);
        AnimatableValueParser.A2(parcel, iY2);
    }
}

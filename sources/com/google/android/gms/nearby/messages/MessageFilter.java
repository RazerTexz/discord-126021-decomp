package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
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
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p333j.p334b.C4323g;

/* JADX INFO: loaded from: classes3.dex */
public class MessageFilter extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MessageFilter> CREATOR = new C4323g();

    /* JADX INFO: renamed from: j */
    public static final MessageFilter f20718j;

    /* JADX INFO: renamed from: k */
    public final int f20719k;

    /* JADX INFO: renamed from: l */
    public final List<zzad> f20720l;

    /* JADX INFO: renamed from: m */
    public final List<zzgu> f20721m;

    /* JADX INFO: renamed from: n */
    public final boolean f20722n;

    /* JADX INFO: renamed from: o */
    public final List<zzgp> f20723o;

    /* JADX INFO: renamed from: p */
    public final int f20724p;

    static {
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        HashSet hashSet2 = new HashSet();
        C1460d.m435G(true, "At least one of the include methods must be called.");
        f20718j = new MessageFilter(2, new ArrayList(hashSet), arrayList, true, new ArrayList(hashSet2), 0);
    }

    public MessageFilter(int i, List<zzad> list, List<zzgu> list2, boolean z2, List<zzgp> list3, int i2) {
        this.f20719k = i;
        Objects.requireNonNull(list, "null reference");
        this.f20720l = Collections.unmodifiableList(list);
        this.f20722n = z2;
        this.f20721m = Collections.unmodifiableList(list2 == null ? Collections.emptyList() : list2);
        this.f20723o = Collections.unmodifiableList(list3 == null ? Collections.emptyList() : list3);
        this.f20724p = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageFilter)) {
            return false;
        }
        MessageFilter messageFilter = (MessageFilter) obj;
        return this.f20722n == messageFilter.f20722n && C1460d.m524h0(this.f20720l, messageFilter.f20720l) && C1460d.m524h0(this.f20721m, messageFilter.f20721m) && C1460d.m524h0(this.f20723o, messageFilter.f20723o);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f20720l, this.f20721m, Boolean.valueOf(this.f20722n), this.f20723o});
    }

    public String toString() {
        boolean z2 = this.f20722n;
        String strValueOf = String.valueOf(this.f20720l);
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
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m586w2(parcel, 1, this.f20720l, false);
        C1460d.m586w2(parcel, 2, this.f20721m, false);
        boolean z2 = this.f20722n;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        C1460d.m586w2(parcel, 4, this.f20723o, false);
        int i2 = this.f20724p;
        parcel.writeInt(262149);
        parcel.writeInt(i2);
        int i3 = this.f20719k;
        parcel.writeInt(263144);
        parcel.writeInt(i3);
        C1460d.m418A2(parcel, iM594y2);
    }
}

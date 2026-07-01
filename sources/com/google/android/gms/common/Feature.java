package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import b.c.a.a0.d;
import b.i.a.f.e.k.j;
import b.i.a.f.e.r;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class Feature extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable$Creator<Feature> CREATOR = new r();
    public final String j;

    @Deprecated
    public final int k;
    public final long l;

    public Feature(@RecentlyNonNull String str, int i, long j) {
        this.j = str;
        this.k = i;
        this.l = j;
    }

    public Feature(@RecentlyNonNull String str, long j) {
        this.j = str;
        this.l = j;
        this.k = -1;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            String str = this.j;
            if (((str != null && str.equals(feature.j)) || (this.j == null && feature.j == null)) && w0() == feature.w0()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.j, Long.valueOf(w0())});
    }

    @RecentlyNonNull
    public final String toString() {
        j jVar = new j(this);
        jVar.a(ModelAuditLogEntry.CHANGE_KEY_NAME, this.j);
        jVar.a("version", Long.valueOf(w0()));
        return jVar.toString();
    }

    public long w0() {
        long j = this.l;
        return j == -1 ? this.k : j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        d.t2(parcel, 1, this.j, false);
        int i2 = this.k;
        parcel.writeInt(262146);
        parcel.writeInt(i2);
        long jW0 = w0();
        parcel.writeInt(524291);
        parcel.writeLong(jW0);
        d.A2(parcel, iY2);
    }
}

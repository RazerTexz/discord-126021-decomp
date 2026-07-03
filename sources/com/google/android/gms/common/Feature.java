package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.C3413r;
import p007b.p225i.p226a.p288f.p299e.p304k.C3361j;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class Feature extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<Feature> CREATOR = new C3413r();

    /* JADX INFO: renamed from: j */
    public final String f20477j;

    /* JADX INFO: renamed from: k */
    @Deprecated
    public final int f20478k;

    /* JADX INFO: renamed from: l */
    public final long f20479l;

    public Feature(@RecentlyNonNull String str, int i, long j) {
        this.f20477j = str;
        this.f20478k = i;
        this.f20479l = j;
    }

    public Feature(@RecentlyNonNull String str, long j) {
        this.f20477j = str;
        this.f20479l = j;
        this.f20478k = -1;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            String str = this.f20477j;
            if (((str != null && str.equals(feature.f20477j)) || (this.f20477j == null && feature.f20477j == null)) && m9021w0() == feature.m9021w0()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f20477j, Long.valueOf(m9021w0())});
    }

    @RecentlyNonNull
    public final String toString() {
        C3361j c3361j = new C3361j(this);
        c3361j.m4162a(ModelAuditLogEntry.CHANGE_KEY_NAME, this.f20477j);
        c3361j.m4162a("version", Long.valueOf(m9021w0()));
        return c3361j.toString();
    }

    /* JADX INFO: renamed from: w0 */
    public long m9021w0() {
        long j = this.f20479l;
        return j == -1 ? this.f20478k : j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m574t2(parcel, 1, this.f20477j, false);
        int i2 = this.f20478k;
        parcel.writeInt(262146);
        parcel.writeInt(i2);
        long jM9021w0 = m9021w0();
        parcel.writeInt(524291);
        parcel.writeLong(jM9021w0);
        C1460d.m418A2(parcel, iM594y2);
    }
}

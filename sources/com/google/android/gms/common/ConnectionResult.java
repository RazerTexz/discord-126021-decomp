package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.C3412q;
import p007b.p225i.p226a.p288f.p299e.p304k.C3361j;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class ConnectionResult extends AbstractSafeParcelable {
    public static final int SUCCESS = 0;

    /* JADX INFO: renamed from: k */
    public final int f20473k;

    /* JADX INFO: renamed from: l */
    public final int f20474l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public final PendingIntent f20475m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public final String f20476n;

    /* JADX INFO: renamed from: j */
    @RecentlyNonNull
    public static final ConnectionResult f20472j = new ConnectionResult(0);

    @RecentlyNonNull
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new C3412q();

    public ConnectionResult(int i) {
        this.f20473k = 1;
        this.f20474l = i;
        this.f20475m = null;
        this.f20476n = null;
    }

    public ConnectionResult(int i, int i2, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        this.f20473k = i;
        this.f20474l = i2;
        this.f20475m = pendingIntent;
        this.f20476n = str;
    }

    @NonNull
    /* JADX INFO: renamed from: y0 */
    public static String m9018y0(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f20474l == connectionResult.f20474l && C1460d.m524h0(this.f20475m, connectionResult.f20475m) && C1460d.m524h0(this.f20476n, connectionResult.f20476n);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f20474l), this.f20475m, this.f20476n});
    }

    @RecentlyNonNull
    public String toString() {
        C3361j c3361j = new C3361j(this);
        c3361j.m4162a("statusCode", m9018y0(this.f20474l));
        c3361j.m4162a("resolution", this.f20475m);
        c3361j.m4162a("message", this.f20476n);
        return c3361j.toString();
    }

    /* JADX INFO: renamed from: w0 */
    public boolean m9019w0() {
        return (this.f20474l == 0 || this.f20475m == null) ? false : true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20473k;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.f20474l;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        C1460d.m570s2(parcel, 3, this.f20475m, i, false);
        C1460d.m574t2(parcel, 4, this.f20476n, false);
        C1460d.m418A2(parcel, iM594y2);
    }

    /* JADX INFO: renamed from: x0 */
    public boolean m9020x0() {
        return this.f20474l == 0;
    }

    public ConnectionResult(int i, @Nullable PendingIntent pendingIntent) {
        this.f20473k = 1;
        this.f20474l = i;
        this.f20475m = pendingIntent;
        this.f20476n = null;
    }

    public ConnectionResult(int i, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        this.f20473k = 1;
        this.f20474l = i;
        this.f20475m = null;
        this.f20476n = str;
    }
}

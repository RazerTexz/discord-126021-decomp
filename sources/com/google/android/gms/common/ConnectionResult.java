package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.k.j;
import b.i.a.f.e.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class ConnectionResult extends AbstractSafeParcelable {
    public static final int SUCCESS = 0;
    public final int k;
    public final int l;

    @Nullable
    public final PendingIntent m;

    @Nullable
    public final String n;

    @RecentlyNonNull
    public static final ConnectionResult j = new ConnectionResult(0);

    @RecentlyNonNull
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new q();

    public ConnectionResult(int i) {
        this.k = 1;
        this.l = i;
        this.m = null;
        this.n = null;
    }

    public ConnectionResult(int i, int i2, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        this.k = i;
        this.l = i2;
        this.m = pendingIntent;
        this.n = str;
    }

    @NonNull
    public static String y0(int i) {
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
        return this.l == connectionResult.l && AnimatableValueParser.h0(this.m, connectionResult.m) && AnimatableValueParser.h0(this.n, connectionResult.n);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.l), this.m, this.n});
    }

    @RecentlyNonNull
    public String toString() {
        j jVar = new j(this);
        jVar.a("statusCode", y0(this.l));
        jVar.a("resolution", this.m);
        jVar.a("message", this.n);
        return jVar.toString();
    }

    public boolean w0() {
        return (this.l == 0 || this.m == null) ? false : true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        int i2 = this.k;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.l;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        AnimatableValueParser.s2(parcel, 3, this.m, i, false);
        AnimatableValueParser.t2(parcel, 4, this.n, false);
        AnimatableValueParser.A2(parcel, iY2);
    }

    public boolean x0() {
        return this.l == 0;
    }

    public ConnectionResult(int i, @Nullable PendingIntent pendingIntent) {
        this.k = 1;
        this.l = i;
        this.m = pendingIntent;
        this.n = null;
    }

    public ConnectionResult(int i, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        this.k = 1;
        this.l = i;
        this.m = null;
        this.n = str;
    }
}

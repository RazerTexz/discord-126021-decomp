package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4293l0;

/* JADX INFO: loaded from: classes3.dex */
public final class ClientAppContext extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<ClientAppContext> CREATOR = new C4293l0();

    /* JADX INFO: renamed from: j */
    public final int f20741j;

    /* JADX INFO: renamed from: k */
    public final String f20742k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public final String f20743l;

    /* JADX INFO: renamed from: m */
    public final boolean f20744m;

    /* JADX INFO: renamed from: n */
    @Deprecated
    public final int f20745n;

    /* JADX INFO: renamed from: o */
    public final String f20746o;

    public ClientAppContext(int i, String str, @Nullable String str2, boolean z2, int i2, @Nullable String str3) {
        this.f20741j = i;
        Objects.requireNonNull(str, "null reference");
        this.f20742k = str;
        if (str2 != null && !str2.isEmpty() && !str2.startsWith("0p:")) {
            Log.w("NearbyMessages", String.format(Locale.US, "ClientAppContext: 0P identifier(%s) without 0P prefix(%s)", str2, "0p:"));
            str2 = str2.length() != 0 ? "0p:".concat(str2) : new String("0p:");
        }
        this.f20743l = str2;
        this.f20744m = z2;
        this.f20745n = i2;
        this.f20746o = str3;
    }

    public ClientAppContext(String str, @Nullable String str2, boolean z2, @Nullable String str3, int i) {
        this(1, str, str2, z2, i, null);
    }

    @Nullable
    /* JADX INFO: renamed from: w0 */
    public static final ClientAppContext m9121w0(@Nullable ClientAppContext clientAppContext, @Nullable String str, @Nullable String str2, boolean z2) {
        if (clientAppContext != null) {
            return clientAppContext;
        }
        if (str == null && str2 == null) {
            return null;
        }
        return new ClientAppContext(str, str2, z2, null, 0);
    }

    /* JADX INFO: renamed from: x0 */
    public static boolean m9122x0(String str, String str2) {
        return TextUtils.isEmpty(str) ? TextUtils.isEmpty(str2) : str.equals(str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientAppContext)) {
            return false;
        }
        ClientAppContext clientAppContext = (ClientAppContext) obj;
        return m9122x0(this.f20742k, clientAppContext.f20742k) && m9122x0(this.f20743l, clientAppContext.f20743l) && this.f20744m == clientAppContext.f20744m && m9122x0(this.f20746o, clientAppContext.f20746o) && this.f20745n == clientAppContext.f20745n;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f20742k, this.f20743l, Boolean.valueOf(this.f20744m), this.f20746o, Integer.valueOf(this.f20745n)});
    }

    public final String toString() {
        return String.format(Locale.US, "{realClientPackageName: %s, zeroPartyIdentifier: %s, useRealClientApiKey: %b, apiKey: %s, callingContext: %d}", this.f20742k, this.f20743l, Boolean.valueOf(this.f20744m), this.f20746o, Integer.valueOf(this.f20745n));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20741j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        C1460d.m574t2(parcel, 2, this.f20742k, false);
        C1460d.m574t2(parcel, 3, this.f20743l, false);
        boolean z2 = this.f20744m;
        parcel.writeInt(262148);
        parcel.writeInt(z2 ? 1 : 0);
        int i3 = this.f20745n;
        parcel.writeInt(262149);
        parcel.writeInt(i3);
        C1460d.m574t2(parcel, 6, this.f20746o, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}

package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.j.b.e.l0;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class ClientAppContext extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<ClientAppContext> CREATOR = new l0();
    public final int j;
    public final String k;

    @Nullable
    public final String l;
    public final boolean m;

    @Deprecated
    public final int n;
    public final String o;

    public ClientAppContext(int i, String str, @Nullable String str2, boolean z2, int i2, @Nullable String str3) {
        this.j = i;
        Objects.requireNonNull(str, "null reference");
        this.k = str;
        if (str2 != null && !str2.isEmpty() && !str2.startsWith("0p:")) {
            Log.w("NearbyMessages", String.format(Locale.US, "ClientAppContext: 0P identifier(%s) without 0P prefix(%s)", str2, "0p:"));
            str2 = str2.length() != 0 ? "0p:".concat(str2) : new String("0p:");
        }
        this.l = str2;
        this.m = z2;
        this.n = i2;
        this.o = str3;
    }

    public ClientAppContext(String str, @Nullable String str2, boolean z2, @Nullable String str3, int i) {
        this(1, str, str2, z2, i, null);
    }

    @Nullable
    public static final ClientAppContext w0(@Nullable ClientAppContext clientAppContext, @Nullable String str, @Nullable String str2, boolean z2) {
        if (clientAppContext != null) {
            return clientAppContext;
        }
        if (str == null && str2 == null) {
            return null;
        }
        return new ClientAppContext(str, str2, z2, null, 0);
    }

    public static boolean x0(String str, String str2) {
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
        return x0(this.k, clientAppContext.k) && x0(this.l, clientAppContext.l) && this.m == clientAppContext.m && x0(this.o, clientAppContext.o) && this.n == clientAppContext.n;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.k, this.l, Boolean.valueOf(this.m), this.o, Integer.valueOf(this.n)});
    }

    public final String toString() {
        return String.format(Locale.US, "{realClientPackageName: %s, zeroPartyIdentifier: %s, useRealClientApiKey: %b, apiKey: %s, callingContext: %d}", this.k, this.l, Boolean.valueOf(this.m), this.o, Integer.valueOf(this.n));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        AnimatableValueParser.t2(parcel, 2, this.k, false);
        AnimatableValueParser.t2(parcel, 3, this.l, false);
        boolean z2 = this.m;
        parcel.writeInt(262148);
        parcel.writeInt(z2 ? 1 : 0);
        int i3 = this.n;
        parcel.writeInt(262149);
        parcel.writeInt(i3);
        AnimatableValueParser.t2(parcel, 6, this.o, false);
        AnimatableValueParser.A2(parcel, iY2);
    }
}

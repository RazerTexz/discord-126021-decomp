package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import b.c.a.a0.d;
import b.i.a.f.j.b.e.a;
import b.i.a.f.j.b.e.c;
import b.i.a.f.j.b.e.h0;
import b.i.a.f.j.b.e.o0;
import b.i.a.f.j.b.e.q0;
import b.i.a.f.j.b.e.r0;
import b.i.a.f.j.b.e.t0;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscribeRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable$Creator<SubscribeRequest> CREATOR = new h0();
    public final int j;

    @Nullable
    public final o0 k;
    public final Strategy l;
    public final r0 m;
    public final MessageFilter n;

    @Nullable
    public final PendingIntent o;

    @Deprecated
    public final int p;

    @Nullable
    @Deprecated
    public final String q;

    @Nullable
    @Deprecated
    public final String r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public final byte[] f3020s;

    @Deprecated
    public final boolean t;

    @Nullable
    public final a u;

    @Deprecated
    public final boolean v;

    @Deprecated
    public final ClientAppContext w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f3021x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f3022y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f3023z;

    public SubscribeRequest(int i, @Nullable IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, @Nullable PendingIntent pendingIntent, int i2, @Nullable String str, @Nullable String str2, @Nullable byte[] bArr, boolean z2, @Nullable IBinder iBinder3, boolean z3, @Nullable ClientAppContext clientAppContext, boolean z4, int i3, int i4) {
        o0 q0Var;
        r0 t0Var;
        this.j = i;
        a cVar = null;
        if (iBinder == null) {
            q0Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            q0Var = iInterfaceQueryLocalInterface instanceof o0 ? (o0) iInterfaceQueryLocalInterface : new q0(iBinder);
        }
        this.k = q0Var;
        this.l = strategy;
        if (iBinder2 == null) {
            t0Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            t0Var = iInterfaceQueryLocalInterface2 instanceof r0 ? (r0) iInterfaceQueryLocalInterface2 : new t0(iBinder2);
        }
        this.m = t0Var;
        this.n = messageFilter;
        this.o = pendingIntent;
        this.p = i2;
        this.q = str;
        this.r = str2;
        this.f3020s = bArr;
        this.t = z2;
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
            cVar = iInterfaceQueryLocalInterface3 instanceof a ? (a) iInterfaceQueryLocalInterface3 : new c(iBinder3);
        }
        this.u = cVar;
        this.v = z3;
        this.w = ClientAppContext.w0(clientAppContext, str2, str, z3);
        this.f3021x = z4;
        this.f3022y = i3;
        this.f3023z = i4;
    }

    public final String toString() {
        String string;
        String strValueOf = String.valueOf(this.k);
        String strValueOf2 = String.valueOf(this.l);
        String strValueOf3 = String.valueOf(this.m);
        String strValueOf4 = String.valueOf(this.n);
        String strValueOf5 = String.valueOf(this.o);
        byte[] bArr = this.f3020s;
        if (bArr == null) {
            string = null;
        } else {
            int length = bArr.length;
            StringBuilder sb = new StringBuilder(19);
            sb.append("<");
            sb.append(length);
            sb.append(" bytes>");
            string = sb.toString();
        }
        String strValueOf6 = String.valueOf(this.u);
        boolean z2 = this.v;
        String strValueOf7 = String.valueOf(this.w);
        boolean z3 = this.f3021x;
        String str = this.q;
        String str2 = this.r;
        boolean z4 = this.t;
        int i = this.f3023z;
        StringBuilder sbS = b.d.b.a.a.S(b.d.b.a.a.b(str2, b.d.b.a.a.b(str, strValueOf7.length() + strValueOf6.length() + b.d.b.a.a.b(string, strValueOf5.length() + strValueOf4.length() + strValueOf3.length() + strValueOf2.length() + strValueOf.length() + 291))), "SubscribeRequest{messageListener=", strValueOf, ", strategy=", strValueOf2);
        b.d.b.a.a.s0(sbS, ", callback=", strValueOf3, ", filter=", strValueOf4);
        b.d.b.a.a.s0(sbS, ", pendingIntent=", strValueOf5, ", hint=", string);
        sbS.append(", subscribeCallback=");
        sbS.append(strValueOf6);
        sbS.append(", useRealClientApiKey=");
        sbS.append(z2);
        sbS.append(", clientAppContext=");
        sbS.append(strValueOf7);
        sbS.append(", isDiscardPendingIntent=");
        sbS.append(z3);
        b.d.b.a.a.s0(sbS, ", zeroPartyPackageName=", str, ", realClientPackageName=", str2);
        sbS.append(", isIgnoreNearbyPermission=");
        sbS.append(z4);
        sbS.append(", callingContext=");
        sbS.append(i);
        sbS.append("}");
        return sbS.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        o0 o0Var = this.k;
        d.r2(parcel, 2, o0Var == null ? null : o0Var.asBinder(), false);
        d.s2(parcel, 3, this.l, i, false);
        r0 r0Var = this.m;
        d.r2(parcel, 4, r0Var == null ? null : r0Var.asBinder(), false);
        d.s2(parcel, 5, this.n, i, false);
        d.s2(parcel, 6, this.o, i, false);
        int i3 = this.p;
        parcel.writeInt(262151);
        parcel.writeInt(i3);
        d.t2(parcel, 8, this.q, false);
        d.t2(parcel, 9, this.r, false);
        d.q2(parcel, 10, this.f3020s, false);
        boolean z2 = this.t;
        parcel.writeInt(262155);
        parcel.writeInt(z2 ? 1 : 0);
        a aVar = this.u;
        d.r2(parcel, 12, aVar != null ? aVar.asBinder() : null, false);
        boolean z3 = this.v;
        parcel.writeInt(262157);
        parcel.writeInt(z3 ? 1 : 0);
        d.s2(parcel, 14, this.w, i, false);
        boolean z4 = this.f3021x;
        parcel.writeInt(262159);
        parcel.writeInt(z4 ? 1 : 0);
        int i4 = this.f3022y;
        parcel.writeInt(262160);
        parcel.writeInt(i4);
        int i5 = this.f3023z;
        parcel.writeInt(262161);
        parcel.writeInt(i5);
        d.A2(parcel, iY2);
    }
}

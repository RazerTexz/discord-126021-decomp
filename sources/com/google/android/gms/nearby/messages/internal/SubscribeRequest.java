package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4274c;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4285h0;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4303q0;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4309t0;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4268a;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4299o0;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4305r0;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscribeRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SubscribeRequest> CREATOR = new C4285h0();

    /* JADX INFO: renamed from: j */
    public final int f20747j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public final InterfaceC4299o0 f20748k;

    /* JADX INFO: renamed from: l */
    public final Strategy f20749l;

    /* JADX INFO: renamed from: m */
    public final InterfaceC4305r0 f20750m;

    /* JADX INFO: renamed from: n */
    public final MessageFilter f20751n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public final PendingIntent f20752o;

    /* JADX INFO: renamed from: p */
    @Deprecated
    public final int f20753p;

    /* JADX INFO: renamed from: q */
    @Nullable
    @Deprecated
    public final String f20754q;

    /* JADX INFO: renamed from: r */
    @Nullable
    @Deprecated
    public final String f20755r;

    /* JADX INFO: renamed from: s */
    @Nullable
    public final byte[] f20756s;

    /* JADX INFO: renamed from: t */
    @Deprecated
    public final boolean f20757t;

    /* JADX INFO: renamed from: u */
    @Nullable
    public final InterfaceC4268a f20758u;

    /* JADX INFO: renamed from: v */
    @Deprecated
    public final boolean f20759v;

    /* JADX INFO: renamed from: w */
    @Deprecated
    public final ClientAppContext f20760w;

    /* JADX INFO: renamed from: x */
    public final boolean f20761x;

    /* JADX INFO: renamed from: y */
    public final int f20762y;

    /* JADX INFO: renamed from: z */
    public final int f20763z;

    public SubscribeRequest(int i, @Nullable IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, @Nullable PendingIntent pendingIntent, int i2, @Nullable String str, @Nullable String str2, @Nullable byte[] bArr, boolean z2, @Nullable IBinder iBinder3, boolean z3, @Nullable ClientAppContext clientAppContext, boolean z4, int i3, int i4) {
        InterfaceC4299o0 c4303q0;
        InterfaceC4305r0 c4309t0;
        this.f20747j = i;
        InterfaceC4268a c4274c = null;
        if (iBinder == null) {
            c4303q0 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            c4303q0 = iInterfaceQueryLocalInterface instanceof InterfaceC4299o0 ? (InterfaceC4299o0) iInterfaceQueryLocalInterface : new C4303q0(iBinder);
        }
        this.f20748k = c4303q0;
        this.f20749l = strategy;
        if (iBinder2 == null) {
            c4309t0 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            c4309t0 = iInterfaceQueryLocalInterface2 instanceof InterfaceC4305r0 ? (InterfaceC4305r0) iInterfaceQueryLocalInterface2 : new C4309t0(iBinder2);
        }
        this.f20750m = c4309t0;
        this.f20751n = messageFilter;
        this.f20752o = pendingIntent;
        this.f20753p = i2;
        this.f20754q = str;
        this.f20755r = str2;
        this.f20756s = bArr;
        this.f20757t = z2;
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
            c4274c = iInterfaceQueryLocalInterface3 instanceof InterfaceC4268a ? (InterfaceC4268a) iInterfaceQueryLocalInterface3 : new C4274c(iBinder3);
        }
        this.f20758u = c4274c;
        this.f20759v = z3;
        this.f20760w = ClientAppContext.m9121w0(clientAppContext, str2, str, z3);
        this.f20761x = z4;
        this.f20762y = i3;
        this.f20763z = i4;
    }

    public final String toString() {
        String string;
        String strValueOf = String.valueOf(this.f20748k);
        String strValueOf2 = String.valueOf(this.f20749l);
        String strValueOf3 = String.valueOf(this.f20750m);
        String strValueOf4 = String.valueOf(this.f20751n);
        String strValueOf5 = String.valueOf(this.f20752o);
        byte[] bArr = this.f20756s;
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
        String strValueOf6 = String.valueOf(this.f20758u);
        boolean z2 = this.f20759v;
        String strValueOf7 = String.valueOf(this.f20760w);
        boolean z3 = this.f20761x;
        String str = this.f20754q;
        String str2 = this.f20755r;
        boolean z4 = this.f20757t;
        int i = this.f20763z;
        StringBuilder sbM831S = C1643a.m831S(C1643a.m841b(str2, C1643a.m841b(str, strValueOf7.length() + strValueOf6.length() + C1643a.m841b(string, strValueOf5.length() + strValueOf4.length() + strValueOf3.length() + strValueOf2.length() + strValueOf.length() + 291))), "SubscribeRequest{messageListener=", strValueOf, ", strategy=", strValueOf2);
        C1643a.m876s0(sbM831S, ", callback=", strValueOf3, ", filter=", strValueOf4);
        C1643a.m876s0(sbM831S, ", pendingIntent=", strValueOf5, ", hint=", string);
        sbM831S.append(", subscribeCallback=");
        sbM831S.append(strValueOf6);
        sbM831S.append(", useRealClientApiKey=");
        sbM831S.append(z2);
        sbM831S.append(", clientAppContext=");
        sbM831S.append(strValueOf7);
        sbM831S.append(", isDiscardPendingIntent=");
        sbM831S.append(z3);
        C1643a.m876s0(sbM831S, ", zeroPartyPackageName=", str, ", realClientPackageName=", str2);
        sbM831S.append(", isIgnoreNearbyPermission=");
        sbM831S.append(z4);
        sbM831S.append(", callingContext=");
        sbM831S.append(i);
        sbM831S.append("}");
        return sbM831S.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20747j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        InterfaceC4299o0 interfaceC4299o0 = this.f20748k;
        C1460d.m566r2(parcel, 2, interfaceC4299o0 == null ? null : interfaceC4299o0.asBinder(), false);
        C1460d.m570s2(parcel, 3, this.f20749l, i, false);
        InterfaceC4305r0 interfaceC4305r0 = this.f20750m;
        C1460d.m566r2(parcel, 4, interfaceC4305r0 == null ? null : interfaceC4305r0.asBinder(), false);
        C1460d.m570s2(parcel, 5, this.f20751n, i, false);
        C1460d.m570s2(parcel, 6, this.f20752o, i, false);
        int i3 = this.f20753p;
        parcel.writeInt(262151);
        parcel.writeInt(i3);
        C1460d.m574t2(parcel, 8, this.f20754q, false);
        C1460d.m574t2(parcel, 9, this.f20755r, false);
        C1460d.m562q2(parcel, 10, this.f20756s, false);
        boolean z2 = this.f20757t;
        parcel.writeInt(262155);
        parcel.writeInt(z2 ? 1 : 0);
        InterfaceC4268a interfaceC4268a = this.f20758u;
        C1460d.m566r2(parcel, 12, interfaceC4268a != null ? interfaceC4268a.asBinder() : null, false);
        boolean z3 = this.f20759v;
        parcel.writeInt(262157);
        parcel.writeInt(z3 ? 1 : 0);
        C1460d.m570s2(parcel, 14, this.f20760w, i, false);
        boolean z4 = this.f20761x;
        parcel.writeInt(262159);
        parcel.writeInt(z4 ? 1 : 0);
        int i4 = this.f20762y;
        parcel.writeInt(262160);
        parcel.writeInt(i4);
        int i5 = this.f20763z;
        parcel.writeInt(262161);
        parcel.writeInt(i5);
        C1460d.m418A2(parcel, iM594y2);
    }
}

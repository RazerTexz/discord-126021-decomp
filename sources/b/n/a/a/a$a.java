package b.n.a.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import b.a.r.d;
import com.discord.samsung.SamsungConnectActivity;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.g0.t;
import d0.g0.y;
import d0.z.d.m;

/* JADX INFO: compiled from: ISACallback.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a$a extends Binder implements a {
    public a$a() {
        attachInterface(this, "com.msc.sa.aidl.ISACallback");
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00e9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:54:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:55:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:58:0x0117  */
    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        String string;
        String string2;
        if (i == 1598968902) {
            parcel2.writeString("com.msc.sa.aidl.ISACallback");
            return true;
        }
        switch (i) {
            case 1:
                parcel.enforceInterface("com.msc.sa.aidl.ISACallback");
                parcel.readInt();
                parcel.readInt();
                if (parcel.readInt() != 0) {
                }
                throw new IllegalStateException("Unexpected call to onReceiveAccessToken");
            case 2:
                parcel.enforceInterface("com.msc.sa.aidl.ISACallback");
                parcel.readInt();
                parcel.readInt();
                if (parcel.readInt() != 0) {
                }
                throw new IllegalStateException("Unexpected call to onReceiveAccessToken");
            case 3:
                parcel.enforceInterface("com.msc.sa.aidl.ISACallback");
                parcel.readInt();
                parcel.readInt();
                if (parcel.readInt() != 0) {
                }
                throw new IllegalStateException("Unexpected call to onReceiveDisclaimerAgreement");
            case 4:
                parcel.enforceInterface("com.msc.sa.aidl.ISACallback");
                parcel.readInt();
                boolean z2 = parcel.readInt() != 0;
                Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                d dVar = (d) this;
                String string3 = bundle != null ? bundle.getString("authcode") : null;
                String string4 = bundle != null ? bundle.getString("auth_server_url") : null;
                Log.i("Discord", "Samsung onReceiveAuthCode=" + z2);
                if (z2) {
                    if (string3 == null || t.isBlank(string3)) {
                        if (bundle != null) {
                            string = bundle.getString("error_code");
                        } else {
                            string = null;
                        }
                        if (bundle != null) {
                            string2 = bundle.getString("error_message");
                        } else {
                            string2 = null;
                        }
                        StringBuilder sbU = b.d.b.a.a.U("Samsung Account link failure ");
                        StringBuilder sb = new StringBuilder();
                        sb.append('[');
                        sb.append(string);
                        sb.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
                        sb.append(string3 != null ? y.takeLast(string3, 4) : null);
                        sb.append("]: ");
                        sb.append(string2);
                        sbU.append(sb.toString());
                        String string5 = sbU.toString();
                        m.checkNotNullExpressionValue(string5, "StringBuilder()\n        …              .toString()");
                        Log.w("Discord", string5);
                    }
                } else {
                    if (bundle != null) {
                        string = bundle.getString("error_code");
                    } else {
                        string = null;
                    }
                    if (bundle != null) {
                        string2 = bundle.getString("error_message");
                    } else {
                        string2 = null;
                    }
                    StringBuilder sbU2 = b.d.b.a.a.U("Samsung Account link failure ");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(string);
                    sb2.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
                    sb2.append(string3 != null ? y.takeLast(string3, 4) : null);
                    sb2.append("]: ");
                    sb2.append(string2);
                    sbU2.append(sb2.toString());
                    String string6 = sbU2.toString();
                    m.checkNotNullExpressionValue(string6, "StringBuilder()\n        …              .toString()");
                    Log.w("Discord", string6);
                }
                SamsungConnectActivity.a(dVar.a, string3, string4);
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.msc.sa.aidl.ISACallback");
                parcel.readInt();
                parcel.readInt();
                if (parcel.readInt() != 0) {
                }
                throw new IllegalStateException("Unexpected call to onReceiveSCloudAccessToken");
            case 6:
                parcel.enforceInterface("com.msc.sa.aidl.ISACallback");
                parcel.readInt();
                parcel.readInt();
                if (parcel.readInt() != 0) {
                }
                throw new IllegalStateException("Unexpected call to onReceivePasswordConfirmation");
            case 7:
                parcel.enforceInterface("com.msc.sa.aidl.ISACallback");
                parcel.readInt();
                parcel.readInt();
                if (parcel.readInt() != 0) {
                }
                throw new IllegalStateException("Unexpected call to onReceiveRLControlFMM");
            case 8:
                parcel.enforceInterface("com.msc.sa.aidl.ISACallback");
                parcel.readInt();
                parcel.readInt();
                if (parcel.readInt() != 0) {
                }
                throw new IllegalStateException("Unexpected call to onReceiveRubinRequest");
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}

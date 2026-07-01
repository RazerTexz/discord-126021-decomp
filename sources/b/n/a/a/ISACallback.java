package b.n.a.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import b.a.r.SamsungConnectActivity3;
import b.d.b.a.outline;
import com.discord.samsung.SamsungConnectActivity;
import com.discord.widgets.chat.input.MentionUtils;
import d0.g0.StringsJVM;
import d0.g0._Strings;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.n.a.a.a, reason: use source file name */
/* JADX INFO: compiled from: ISACallback.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ISACallback extends IInterface {

    /* JADX INFO: renamed from: b.n.a.a.a$a */
    /* JADX INFO: compiled from: ISACallback.java */
    public static abstract class a extends Binder implements ISACallback {
        public a() {
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
                    SamsungConnectActivity3 samsungConnectActivity3 = (SamsungConnectActivity3) this;
                    String string3 = bundle != null ? bundle.getString("authcode") : null;
                    String string4 = bundle != null ? bundle.getString("auth_server_url") : null;
                    Log.i("Discord", "Samsung onReceiveAuthCode=" + z2);
                    if (z2) {
                        if (string3 == null || StringsJVM.isBlank(string3)) {
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
                            StringBuilder sbU = outline.U("Samsung Account link failure ");
                            StringBuilder sb = new StringBuilder();
                            sb.append('[');
                            sb.append(string);
                            sb.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
                            sb.append(string3 != null ? _Strings.takeLast(string3, 4) : null);
                            sb.append("]: ");
                            sb.append(string2);
                            sbU.append(sb.toString());
                            String string5 = sbU.toString();
                            Intrinsics3.checkNotNullExpressionValue(string5, "StringBuilder()\n        …              .toString()");
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
                        StringBuilder sbU2 = outline.U("Samsung Account link failure ");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append('[');
                        sb2.append(string);
                        sb2.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
                        sb2.append(string3 != null ? _Strings.takeLast(string3, 4) : null);
                        sb2.append("]: ");
                        sb2.append(string2);
                        sbU2.append(sb2.toString());
                        String string6 = sbU2.toString();
                        Intrinsics3.checkNotNullExpressionValue(string6, "StringBuilder()\n        …              .toString()");
                        Log.w("Discord", string6);
                    }
                    SamsungConnectActivity.a(samsungConnectActivity3.a, string3, string4);
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
}

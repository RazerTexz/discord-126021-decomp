package b.i.a.f.i.b;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface i3 extends IInterface {
    String A(zzn zznVar) throws RemoteException;

    void G(long j, String str, String str2, String str3) throws RemoteException;

    void I(zzn zznVar) throws RemoteException;

    List<zzz> J(String str, String str2, String str3) throws RemoteException;

    List<zzz> K(String str, String str2, zzn zznVar) throws RemoteException;

    List<zzku> R(String str, String str2, boolean z2, zzn zznVar) throws RemoteException;

    void T(zzn zznVar) throws RemoteException;

    void d0(zzn zznVar) throws RemoteException;

    byte[] j(zzaq zzaqVar, String str) throws RemoteException;

    void l0(zzaq zzaqVar, zzn zznVar) throws RemoteException;

    void m(zzn zznVar) throws RemoteException;

    void m0(Bundle bundle, zzn zznVar) throws RemoteException;

    void p0(zzku zzkuVar, zzn zznVar) throws RemoteException;

    void q0(zzz zzzVar, zzn zznVar) throws RemoteException;

    List<zzku> u(String str, String str2, String str3, boolean z2) throws RemoteException;
}

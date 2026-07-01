package b.i.a.f.i.b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l3 extends b.i.a.f.h.l.s0 implements i3 {
    public l3() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // b.i.a.f.h.l.s0
    public final boolean c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        ArrayList arrayList;
        switch (i) {
            case 1:
                ((z4) this).l0((zzaq) b.i.a.f.h.l.v.a(parcel, zzaq.CREATOR), (zzn) b.i.a.f.h.l.v.a(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                zzku zzkuVar = (zzku) b.i.a.f.h.l.v.a(parcel, zzku.CREATOR);
                zzn zznVar = (zzn) b.i.a.f.h.l.v.a(parcel, zzn.CREATOR);
                z4 z4Var = (z4) this;
                Objects.requireNonNull(zzkuVar, "null reference");
                z4Var.u0(zznVar);
                z4Var.i(new o5(z4Var, zzkuVar, zznVar));
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                zzn zznVar2 = (zzn) b.i.a.f.h.l.v.a(parcel, zzn.CREATOR);
                z4 z4Var2 = (z4) this;
                z4Var2.u0(zznVar2);
                z4Var2.i(new q5(z4Var2, zznVar2));
                parcel2.writeNoException();
                return true;
            case 5:
                zzaq zzaqVar = (zzaq) b.i.a.f.h.l.v.a(parcel, zzaq.CREATOR);
                String string = parcel.readString();
                parcel.readString();
                z4 z4Var3 = (z4) this;
                Objects.requireNonNull(zzaqVar, "null reference");
                b.c.a.a0.d.w(string);
                z4Var3.t0(string, true);
                z4Var3.i(new m5(z4Var3, zzaqVar, string));
                parcel2.writeNoException();
                return true;
            case 6:
                zzn zznVar3 = (zzn) b.i.a.f.h.l.v.a(parcel, zzn.CREATOR);
                z4 z4Var4 = (z4) this;
                z4Var4.u0(zznVar3);
                z4Var4.i(new c5(z4Var4, zznVar3));
                parcel2.writeNoException();
                return true;
            case 7:
                zzn zznVar4 = (zzn) b.i.a.f.h.l.v.a(parcel, zzn.CREATOR);
                boolean z2 = parcel.readInt() != 0;
                z4 z4Var5 = (z4) this;
                z4Var5.u0(zznVar4);
                try {
                    List<u9> list = (List) ((FutureTask) z4Var5.a.f().t(new n5(z4Var5, zznVar4))).get();
                    arrayList = new ArrayList(list.size());
                    for (u9 u9Var : list) {
                        if (z2 || !t9.r0(u9Var.c)) {
                            arrayList.add(new zzku(u9Var));
                        }
                        break;
                    }
                } catch (InterruptedException | ExecutionException e) {
                    z4Var5.a.g().f.c("Failed to get user properties. appId", q3.s(zznVar4.j), e);
                    arrayList = null;
                }
                parcel2.writeNoException();
                parcel2.writeTypedList(arrayList);
                return true;
            case 9:
                byte[] bArrJ = ((z4) this).j((zzaq) b.i.a.f.h.l.v.a(parcel, zzaq.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrJ);
                return true;
            case 10:
                ((z4) this).G(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                String strA = ((z4) this).A((zzn) b.i.a.f.h.l.v.a(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            case 12:
                ((z4) this).q0((zzz) b.i.a.f.h.l.v.a(parcel, zzz.CREATOR), (zzn) b.i.a.f.h.l.v.a(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                ((z4) this).g((zzz) b.i.a.f.h.l.v.a(parcel, zzz.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                String string2 = parcel.readString();
                String string3 = parcel.readString();
                ClassLoader classLoader = b.i.a.f.h.l.v.a;
                List<zzku> listR = ((z4) this).R(string2, string3, parcel.readInt() != 0, (zzn) b.i.a.f.h.l.v.a(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(listR);
                return true;
            case 15:
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                ClassLoader classLoader2 = b.i.a.f.h.l.v.a;
                List<zzku> listU = ((z4) this).u(string4, string5, string6, parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeTypedList(listU);
                return true;
            case 16:
                List<zzz> listK = ((z4) this).K(parcel.readString(), parcel.readString(), (zzn) b.i.a.f.h.l.v.a(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(listK);
                return true;
            case 17:
                List<zzz> listJ = ((z4) this).J(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(listJ);
                return true;
            case 18:
                zzn zznVar5 = (zzn) b.i.a.f.h.l.v.a(parcel, zzn.CREATOR);
                z4 z4Var6 = (z4) this;
                z4Var6.t0(zznVar5.j, false);
                z4Var6.i(new h5(z4Var6, zznVar5));
                parcel2.writeNoException();
                return true;
            case 19:
                ((z4) this).m0((Bundle) b.i.a.f.h.l.v.a(parcel, Bundle.CREATOR), (zzn) b.i.a.f.h.l.v.a(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 20:
                ((z4) this).m((zzn) b.i.a.f.h.l.v.a(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}

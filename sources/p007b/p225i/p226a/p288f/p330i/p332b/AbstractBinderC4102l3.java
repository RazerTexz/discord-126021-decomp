package p007b.p225i.p226a.p288f.p330i.p332b;

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
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p313h.p325l.BinderC3821s0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3859v;

/* JADX INFO: renamed from: b.i.a.f.i.b.l3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractBinderC4102l3 extends BinderC3821s0 implements InterfaceC4068i3 {
    public AbstractBinderC4102l3() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.BinderC3821s0
    /* JADX INFO: renamed from: c */
    public final boolean mo4565c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        ArrayList arrayList;
        switch (i) {
            case 1:
                ((BinderC4257z4) this).mo5675l0((zzaq) C3859v.m5326a(parcel, zzaq.CREATOR), (zzn) C3859v.m5326a(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                zzku zzkuVar = (zzku) C3859v.m5326a(parcel, zzku.CREATOR);
                zzn zznVar = (zzn) C3859v.m5326a(parcel, zzn.CREATOR);
                BinderC4257z4 binderC4257z4 = (BinderC4257z4) this;
                Objects.requireNonNull(zzkuVar, "null reference");
                binderC4257z4.m5978u0(zznVar);
                binderC4257z4.m5976i(new RunnableC4137o5(binderC4257z4, zzkuVar, zznVar));
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                zzn zznVar2 = (zzn) C3859v.m5326a(parcel, zzn.CREATOR);
                BinderC4257z4 binderC4257z5 = (BinderC4257z4) this;
                binderC4257z5.m5978u0(zznVar2);
                binderC4257z5.m5976i(new RunnableC4159q5(binderC4257z5, zznVar2));
                parcel2.writeNoException();
                return true;
            case 5:
                zzaq zzaqVar = (zzaq) C3859v.m5326a(parcel, zzaq.CREATOR);
                String string = parcel.readString();
                parcel.readString();
                BinderC4257z4 binderC4257z6 = (BinderC4257z4) this;
                Objects.requireNonNull(zzaqVar, "null reference");
                C1460d.m583w(string);
                binderC4257z6.m5977t0(string, true);
                binderC4257z6.m5976i(new RunnableC4115m5(binderC4257z6, zzaqVar, string));
                parcel2.writeNoException();
                return true;
            case 6:
                zzn zznVar3 = (zzn) C3859v.m5326a(parcel, zzn.CREATOR);
                BinderC4257z4 binderC4257z7 = (BinderC4257z4) this;
                binderC4257z7.m5978u0(zznVar3);
                binderC4257z7.m5976i(new RunnableC3998c5(binderC4257z7, zznVar3));
                parcel2.writeNoException();
                return true;
            case 7:
                zzn zznVar4 = (zzn) C3859v.m5326a(parcel, zzn.CREATOR);
                boolean z2 = parcel.readInt() != 0;
                BinderC4257z4 binderC4257z8 = (BinderC4257z4) this;
                binderC4257z8.m5978u0(zznVar4);
                try {
                    List<C4207u9> list = (List) ((FutureTask) binderC4257z8.f11390a.mo5725f().m5850t(new CallableC4126n5(binderC4257z8, zznVar4))).get();
                    arrayList = new ArrayList(list.size());
                    for (C4207u9 c4207u9 : list) {
                        if (z2 || !C4196t9.m5885r0(c4207u9.f11292c)) {
                            arrayList.add(new zzku(c4207u9));
                        }
                        break;
                    }
                } catch (InterruptedException | ExecutionException e) {
                    binderC4257z8.f11390a.mo5726g().f11141f.m5862c("Failed to get user properties. appId", C4157q3.m5788s(zznVar4.f20683j), e);
                    arrayList = null;
                }
                parcel2.writeNoException();
                parcel2.writeTypedList(arrayList);
                return true;
            case 9:
                byte[] bArrMo5674j = ((BinderC4257z4) this).mo5674j((zzaq) C3859v.m5326a(parcel, zzaq.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrMo5674j);
                return true;
            case 10:
                ((BinderC4257z4) this).mo5667G(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                String strMo5666A = ((BinderC4257z4) this).mo5666A((zzn) C3859v.m5326a(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(strMo5666A);
                return true;
            case 12:
                ((BinderC4257z4) this).mo5679q0((zzz) C3859v.m5326a(parcel, zzz.CREATOR), (zzn) C3859v.m5326a(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                ((BinderC4257z4) this).m5975g((zzz) C3859v.m5326a(parcel, zzz.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                String string2 = parcel.readString();
                String string3 = parcel.readString();
                ClassLoader classLoader = C3859v.f10357a;
                List<zzku> listMo5671R = ((BinderC4257z4) this).mo5671R(string2, string3, parcel.readInt() != 0, (zzn) C3859v.m5326a(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(listMo5671R);
                return true;
            case 15:
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                ClassLoader classLoader2 = C3859v.f10357a;
                List<zzku> listMo5680u = ((BinderC4257z4) this).mo5680u(string4, string5, string6, parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeTypedList(listMo5680u);
                return true;
            case 16:
                List<zzz> listMo5670K = ((BinderC4257z4) this).mo5670K(parcel.readString(), parcel.readString(), (zzn) C3859v.m5326a(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(listMo5670K);
                return true;
            case 17:
                List<zzz> listMo5669J = ((BinderC4257z4) this).mo5669J(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(listMo5669J);
                return true;
            case 18:
                zzn zznVar5 = (zzn) C3859v.m5326a(parcel, zzn.CREATOR);
                BinderC4257z4 binderC4257z9 = (BinderC4257z4) this;
                binderC4257z9.m5977t0(zznVar5.f20683j, false);
                binderC4257z9.m5976i(new RunnableC4058h5(binderC4257z9, zznVar5));
                parcel2.writeNoException();
                return true;
            case 19:
                ((BinderC4257z4) this).mo5677m0((Bundle) C3859v.m5326a(parcel, Bundle.CREATOR), (zzn) C3859v.m5326a(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 20:
                ((BinderC4257z4) this).mo5676m((zzn) C3859v.m5326a(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}

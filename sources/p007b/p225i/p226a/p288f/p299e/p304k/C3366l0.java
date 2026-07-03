package p007b.p225i.p226a.p288f.p299e.p304k;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b;

/* JADX INFO: renamed from: b.i.a.f.e.k.l0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3366l0 extends AbstractC3393z {

    /* JADX INFO: renamed from: g */
    @Nullable
    public final IBinder f9536g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ AbstractC3345b f9537h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    public C3366l0(AbstractC3345b abstractC3345b, @Nullable int i, @Nullable IBinder iBinder, Bundle bundle) {
        super(abstractC3345b, i, bundle);
        this.f9537h = abstractC3345b;
        this.f9536g = iBinder;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3393z
    /* JADX INFO: renamed from: d */
    public final boolean mo4171d() {
        try {
            IBinder iBinder = this.f9536g;
            Objects.requireNonNull(iBinder, "null reference");
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.f9537h.mo3984x().equals(interfaceDescriptor)) {
                String strMo3984x = this.f9537h.mo3984x();
                StringBuilder sb = new StringBuilder(String.valueOf(strMo3984x).length() + 34 + String.valueOf(interfaceDescriptor).length());
                sb.append("service descriptor mismatch: ");
                sb.append(strMo3984x);
                sb.append(" vs. ");
                sb.append(interfaceDescriptor);
                Log.e("GmsClient", sb.toString());
                return false;
            }
            IInterface iInterfaceMo3983r = this.f9537h.mo3983r(this.f9536g);
            if (iInterfaceMo3983r == null || !(AbstractC3345b.m4124E(this.f9537h, 2, 4, iInterfaceMo3983r) || AbstractC3345b.m4124E(this.f9537h, 3, 4, iInterfaceMo3983r))) {
                return false;
            }
            AbstractC3345b abstractC3345b = this.f9537h;
            abstractC3345b.f9495t = null;
            AbstractC3345b.a aVar = abstractC3345b.f9491p;
            if (aVar == null) {
                return true;
            }
            aVar.mo4145i(null);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3393z
    /* JADX INFO: renamed from: e */
    public final void mo4172e(ConnectionResult connectionResult) {
        AbstractC3345b.b bVar = this.f9537h.f9492q;
        if (bVar != null) {
            bVar.mo4146g(connectionResult);
        }
        Objects.requireNonNull(this.f9537h);
        System.currentTimeMillis();
    }
}

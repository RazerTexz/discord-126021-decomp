package b.i.a.f.e.k;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class l0 extends z {

    @Nullable
    public final IBinder g;
    public final /* synthetic */ b h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    public l0(b bVar, @Nullable int i, @Nullable IBinder iBinder, Bundle bundle) {
        super(bVar, i, bundle);
        this.h = bVar;
        this.g = iBinder;
    }

    @Override // b.i.a.f.e.k.z
    public final boolean d() {
        try {
            IBinder iBinder = this.g;
            Objects.requireNonNull(iBinder, "null reference");
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.h.x().equals(interfaceDescriptor)) {
                String strX = this.h.x();
                StringBuilder sb = new StringBuilder(String.valueOf(strX).length() + 34 + String.valueOf(interfaceDescriptor).length());
                sb.append("service descriptor mismatch: ");
                sb.append(strX);
                sb.append(" vs. ");
                sb.append(interfaceDescriptor);
                Log.e("GmsClient", sb.toString());
                return false;
            }
            IInterface iInterfaceR = this.h.r(this.g);
            if (iInterfaceR == null || !(b.E(this.h, 2, 4, iInterfaceR) || b.E(this.h, 3, 4, iInterfaceR))) {
                return false;
            }
            b bVar = this.h;
            bVar.t = null;
            b$a b_a = bVar.p;
            if (b_a == null) {
                return true;
            }
            b_a.i(null);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }

    @Override // b.i.a.f.e.k.z
    public final void e(ConnectionResult connectionResult) {
        b$b b_b = this.h.q;
        if (b_b != null) {
            b_b.g(connectionResult);
        }
        Objects.requireNonNull(this.h);
        System.currentTimeMillis();
    }
}

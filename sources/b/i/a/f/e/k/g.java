package b.i.a.f.e.k;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface g extends IInterface {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public static abstract class a extends b.i.a.f.h.g.b implements g {
        @RecentlyNonNull
        public static g g(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return iInterfaceQueryLocalInterface instanceof g ? (g) iInterfaceQueryLocalInterface : new w0(iBinder);
        }
    }

    @RecentlyNonNull
    Account b() throws RemoteException;
}

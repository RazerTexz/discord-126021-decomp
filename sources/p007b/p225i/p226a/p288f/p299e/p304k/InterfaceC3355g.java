package p007b.p225i.p226a.p288f.p299e.p304k;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import p007b.p225i.p226a.p288f.p313h.p320g.BinderC3482b;

/* JADX INFO: renamed from: b.i.a.f.e.k.g */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC3355g extends IInterface {

    /* JADX INFO: renamed from: b.i.a.f.e.k.g$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public static abstract class a extends BinderC3482b implements InterfaceC3355g {
        @RecentlyNonNull
        /* JADX INFO: renamed from: g */
        public static InterfaceC3355g m4157g(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return iInterfaceQueryLocalInterface instanceof InterfaceC3355g ? (InterfaceC3355g) iInterfaceQueryLocalInterface : new C3388w0(iBinder);
        }
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: b */
    Account mo4156b() throws RemoteException;
}

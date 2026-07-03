package p007b.p225i.p226a.p288f.p311f;

import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.RecentlyNonNull;
import p007b.p225i.p226a.p288f.p313h.p320g.BinderC3482b;

/* JADX INFO: renamed from: b.i.a.f.f.a */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC3422a extends IInterface {

    /* JADX INFO: renamed from: b.i.a.f.f.a$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public static abstract class a extends BinderC3482b implements InterfaceC3422a {
        public a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        @RecentlyNonNull
        /* JADX INFO: renamed from: g */
        public static InterfaceC3422a m4380g(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return iInterfaceQueryLocalInterface instanceof InterfaceC3422a ? (InterfaceC3422a) iInterfaceQueryLocalInterface : new C3424c(iBinder);
        }
    }
}

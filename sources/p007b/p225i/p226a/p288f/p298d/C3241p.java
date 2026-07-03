package p007b.p225i.p226a.p288f.p298d;

import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.cloudmessaging.zza;

/* JADX INFO: renamed from: b.i.a.f.d.p */
/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3241p {

    /* JADX INFO: renamed from: a */
    @Nullable
    public final Messenger f9277a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public final zza f9278b;

    public C3241p(IBinder iBinder) throws RemoteException {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.f9277a = new Messenger(iBinder);
            this.f9278b = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.f9278b = new zza(iBinder);
            this.f9277a = null;
        } else {
            String strValueOf = String.valueOf(interfaceDescriptor);
            Log.w("MessengerIpcClient", strValueOf.length() != 0 ? "Invalid interface descriptor: ".concat(strValueOf) : new String("Invalid interface descriptor: "));
            throw new RemoteException();
        }
    }
}

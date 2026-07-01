package b.i.a.f.d;

import android.os.Bundle;
import android.os.Handler$Callback;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.cloudmessaging.zzp;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class j implements Handler$Callback {
    public final g j;

    public j(g gVar) {
        this.j = gVar;
    }

    @Override // android.os.Handler$Callback
    public final boolean handleMessage(Message message) {
        g gVar = this.j;
        Objects.requireNonNull(gVar);
        int i = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Received response to request: ");
            sb.append(i);
            Log.d("MessengerIpcClient", sb.toString());
        }
        synchronized (gVar) {
            q<?> qVar = gVar.n.get(i);
            if (qVar == null) {
                StringBuilder sb2 = new StringBuilder(50);
                sb2.append("Received response for unknown request: ");
                sb2.append(i);
                Log.w("MessengerIpcClient", sb2.toString());
                return true;
            }
            gVar.n.remove(i);
            gVar.c();
            Bundle data = message.getData();
            if (data.getBoolean("unsupported", false)) {
                qVar.b(new zzp(4, "Not supported by GmsCore"));
                return true;
            }
            qVar.a(data);
            return true;
        }
    }
}

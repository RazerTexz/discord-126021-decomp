package b.i.a.f.d;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class t implements b.i.a.f.n.a {
    public static final b.i.a.f.n.a a = new t();

    @Override // b.i.a.f.n.a
    public final Object a(Task task) throws IOException {
        int i = b.a;
        if (task.p()) {
            return (Bundle) task.l();
        }
        if (Log.isLoggable("Rpc", 3)) {
            String strValueOf = String.valueOf(task.k());
            StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
            sb.append("Error making request: ");
            sb.append(strValueOf);
            Log.d("Rpc", sb.toString());
        }
        throw new IOException("SERVICE_NOT_AVAILABLE", task.k());
    }
}

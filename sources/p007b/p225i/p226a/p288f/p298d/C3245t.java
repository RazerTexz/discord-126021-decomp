package p007b.p225i.p226a.p288f.p298d;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4353a;

/* JADX INFO: renamed from: b.i.a.f.d.t */
/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C3245t implements InterfaceC4353a {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC4353a f9286a = new C3245t();

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4353a
    /* JADX INFO: renamed from: a */
    public final Object mo4012a(Task task) throws IOException {
        int i = C3227b.f9243a;
        if (task.mo6021p()) {
            return (Bundle) task.mo6017l();
        }
        if (Log.isLoggable("Rpc", 3)) {
            String strValueOf = String.valueOf(task.mo6016k());
            StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
            sb.append("Error making request: ");
            sb.append(strValueOf);
            Log.d("Rpc", sb.toString());
        }
        throw new IOException("SERVICE_NOT_AVAILABLE", task.mo6016k());
    }
}

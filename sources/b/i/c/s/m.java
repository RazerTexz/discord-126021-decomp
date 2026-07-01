package b.i.c.s;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class m implements b.i.a.f.n.a {
    public final n a;

    public m(n nVar) {
        this.a = nVar;
    }

    @Override // b.i.a.f.n.a
    public final Object a(Task task) throws IOException {
        Objects.requireNonNull(this.a);
        Bundle bundle = (Bundle) task.m(IOException.class);
        if (bundle == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundle.getString("registration_id");
        if (string != null || (string = bundle.getString("unregistered")) != null) {
            return string;
        }
        String string2 = bundle.getString("error");
        if ("RST".equals(string2)) {
            throw new IOException("INSTANCE_ID_RESET");
        }
        if (string2 != null) {
            throw new IOException(string2);
        }
        String strValueOf = String.valueOf(bundle);
        Log.w("FirebaseInstanceId", b.d.b.a.a.j(strValueOf.length() + 21, "Unexpected response: ", strValueOf), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }
}

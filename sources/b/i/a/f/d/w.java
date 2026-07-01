package b.i.a.f.d;

import android.os.Bundle;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class w implements b.i.a.f.n.f {
    public static final b.i.a.f.n.f a = new w();

    @Override // b.i.a.f.n.f
    public final Task a(Object obj) {
        Bundle bundle = (Bundle) obj;
        int i = b.a;
        return bundle != null && bundle.containsKey("google.messenger") ? b.i.a.f.e.o.f.Z(null) : b.i.a.f.e.o.f.Z(bundle);
    }
}

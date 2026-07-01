package b.f.g.a.a.h.i;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import b.f.g.a.a.h.f;
import b.f.g.a.a.h.g;
import b.f.g.a.a.h.h;
import java.util.Objects;

/* JADX INFO: compiled from: ImagePerfControllerListener2.java */
/* JADX INFO: loaded from: classes.dex */
public class a$a extends Handler {
    public final g a;

    public a$a(@NonNull Looper looper, @NonNull g gVar) {
        super(looper);
        this.a = gVar;
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        Object obj = message.obj;
        Objects.requireNonNull(obj);
        h hVar = (h) obj;
        int i = message.what;
        if (i == 1) {
            ((f) this.a).b(hVar, message.arg1);
        } else {
            if (i != 2) {
                return;
            }
            ((f) this.a).a(hVar, message.arg1);
        }
    }
}

package b.i.a.g.h;

import android.os.Handler$Callback;
import android.os.Message;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SnackbarManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$a implements Handler$Callback {
    public final /* synthetic */ a j;

    public a$a(a aVar) {
        this.j = aVar;
    }

    @Override // android.os.Handler$Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what != 0) {
            return false;
        }
        a aVar = this.j;
        a$c a_c = (a$c) message.obj;
        synchronized (aVar.f1624b) {
            if (aVar.d == a_c || aVar.e == a_c) {
                aVar.a(a_c, 2);
            }
        }
        return true;
    }
}

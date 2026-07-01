package b.i.a.c.f3;

import android.os.Message;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: SystemHandlerWrapper.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b0$b implements o$a {

    @Nullable
    public Message a;

    public b0$b() {
    }

    public final void a() {
        this.a = null;
        List<b0$b> list = b0.a;
        synchronized (list) {
            if (list.size() < 50) {
                list.add(this);
            }
        }
    }

    public void b() {
        Message message = this.a;
        Objects.requireNonNull(message);
        message.sendToTarget();
        a();
    }

    public b0$b(b0$a b0_a) {
    }
}

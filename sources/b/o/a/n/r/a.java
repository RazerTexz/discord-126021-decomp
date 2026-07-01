package b.o.a.n.r;

import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: compiled from: BaseMeter.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public abstract class a extends b.o.a.n.o.e {
    public static final b.o.a.b e = new b.o.a.b(a.class.getSimpleName());
    public final List<MeteringRectangle> f;
    public boolean g;
    public boolean h;

    public a(@NonNull List<MeteringRectangle> list, boolean z2) {
        this.f = list;
        this.h = z2;
    }

    @Override // b.o.a.n.o.e
    public final void j(@NonNull b.o.a.n.o.c cVar) {
        this.c = cVar;
        boolean z2 = this.h && n(cVar);
        if (m(cVar) && !z2) {
            e.a(1, "onStart:", "supported and not skipped. Dispatching onStarted.");
            o(cVar, this.f);
        } else {
            e.a(1, "onStart:", "not supported or skipped. Dispatching COMPLETED state.");
            this.g = true;
            l(Integer.MAX_VALUE);
        }
    }

    public abstract boolean m(@NonNull b.o.a.n.o.c cVar);

    public abstract boolean n(@NonNull b.o.a.n.o.c cVar);

    public abstract void o(@NonNull b.o.a.n.o.c cVar, @NonNull List<MeteringRectangle> list);
}

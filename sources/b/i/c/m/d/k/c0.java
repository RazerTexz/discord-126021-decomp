package b.i.c.m.d.k;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class c0 implements b.i.a.f.n.f<b.i.c.m.d.s.h.b, Void> {
    public final /* synthetic */ Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d0 f1679b;

    public c0(d0 d0Var, Executor executor) {
        this.f1679b = d0Var;
        this.a = executor;
    }

    @Override // b.i.a.f.n.f
    @NonNull
    public Task<Void> a(@Nullable b.i.c.m.d.s.h.b bVar) throws Exception {
        b.i.c.m.d.s.h.b bVar2 = bVar;
        if (bVar2 == null) {
            b.i.c.m.d.b.a.g("Received null app settings, cannot send reports at crash time.");
            return b.i.a.f.e.o.f.Z(null);
        }
        x xVar = this.f1679b.n;
        Context context = xVar.i;
        b.i.c.m.d.q.b bVarA = ((h0) xVar.r).a(bVar2);
        for (File file : xVar.q()) {
            x.c(bVar2.e, file);
            b.i.c.m.d.q.c.d dVar = new b.i.c.m.d.q.c.d(file, x.f);
            i iVar = xVar.m;
            iVar.b(new j(iVar, new x$m(context, dVar, bVarA, true)));
        }
        return b.i.a.f.e.o.f.B1(Arrays.asList(x.b(this.f1679b.n), this.f1679b.n.A.b(this.a, b.c.a.y.b.m(bVar2))));
    }
}

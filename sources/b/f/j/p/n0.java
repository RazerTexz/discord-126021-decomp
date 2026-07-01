package b.f.j.p;

import android.os.SystemClock;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: compiled from: NetworkFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class n0 implements w0<b.f.j.j.e> {
    public final b.f.d.g.g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.f.d.g.a f629b;
    public final o0 c;

    public n0(b.f.d.g.g gVar, b.f.d.g.a aVar, o0 o0Var) {
        this.a = gVar;
        this.f629b = aVar;
        this.c = o0Var;
    }

    public static void e(b.f.d.g.i iVar, int i, b.f.j.d.a aVar, l<b.f.j.j.e> lVar, x0 x0Var) throws Throwable {
        CloseableReference closeableReferenceA = CloseableReference.A(((MemoryPooledByteBufferOutputStream) iVar).b());
        b.f.j.j.e eVar = null;
        try {
            b.f.j.j.e eVar2 = new b.f.j.j.e(closeableReferenceA);
            try {
                eVar2.f590s = null;
                eVar2.q();
                x0Var.h(b.f.j.j.f.NETWORK);
                lVar.b(eVar2, i);
                eVar2.close();
                if (closeableReferenceA != null) {
                    closeableReferenceA.close();
                }
            } catch (Throwable th) {
                th = th;
                eVar = eVar2;
                if (eVar != null) {
                    eVar.close();
                }
                if (closeableReferenceA != null) {
                    closeableReferenceA.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // b.f.j.p.w0
    public void b(l<b.f.j.j.e> lVar, x0 x0Var) {
        x0Var.o().e(x0Var, "NetworkFetchProducer");
        Objects.requireNonNull((a0) this.c);
        a0$a a0_a = new a0$a(lVar, x0Var);
        o0 o0Var = this.c;
        n0$a n0_a = new n0$a(this, a0_a);
        a0 a0Var = (a0) o0Var;
        Objects.requireNonNull(a0Var);
        a0_a.d = a0Var.c.now();
        x0Var.f(new z(a0Var, a0Var.f604b.submit(new y(a0Var, a0_a, n0_a)), n0_a));
    }

    public void c(b.f.d.g.i iVar, x xVar) throws Throwable {
        HashMap map;
        int i = ((MemoryPooledByteBufferOutputStream) iVar).l;
        if (xVar.a().g(xVar.f642b, "NetworkFetchProducer")) {
            Objects.requireNonNull((a0) this.c);
            a0$a a0_a = (a0$a) xVar;
            map = new HashMap(4);
            map.put("queue_time", Long.toString(a0_a.e - a0_a.d));
            map.put("fetch_time", Long.toString(a0_a.f - a0_a.e));
            map.put("total_time", Long.toString(a0_a.f - a0_a.d));
            map.put("image_size", Integer.toString(i));
        } else {
            map = null;
        }
        z0 z0VarA = xVar.a();
        z0VarA.j(xVar.f642b, "NetworkFetchProducer", map);
        z0VarA.c(xVar.f642b, "NetworkFetchProducer", true);
        xVar.f642b.n("network");
        e(iVar, 1, null, xVar.a, xVar.f642b);
    }

    public void d(b.f.d.g.i iVar, x xVar) throws Throwable {
        boolean z2;
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (xVar.f642b.p()) {
            Objects.requireNonNull(this.c);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || jUptimeMillis - xVar.c < 100) {
            return;
        }
        xVar.c = jUptimeMillis;
        xVar.a().a(xVar.f642b, "NetworkFetchProducer", "intermediate_result");
        e(iVar, 0, null, xVar.a, xVar.f642b);
    }
}

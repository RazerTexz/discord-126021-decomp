package b.o.a.n.v;

import androidx.annotation.NonNull;
import b.i.a.f.n.c0;
import b.o.a.n.CameraEngine;
import b.o.a.n.v.CameraOrchestrator;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.o.a.n.v.f, reason: use source file name */
/* JADX INFO: compiled from: CameraStateOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraStateOrchestrator extends CameraOrchestrator {
    public CameraState2 f;
    public CameraState2 g;
    public int h;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: b.o.a.n.v.f$a */
    /* JADX INFO: compiled from: CameraStateOrchestrator.java */
    public class a<T> implements b.i.a.f.n.c<T> {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // b.i.a.f.n.c
        public void onComplete(@NonNull Task<T> task) {
            int i = this.a;
            CameraStateOrchestrator cameraStateOrchestrator = CameraStateOrchestrator.this;
            if (i == cameraStateOrchestrator.h) {
                cameraStateOrchestrator.g = cameraStateOrchestrator.f;
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: b.o.a.n.v.f$b */
    /* JADX INFO: compiled from: CameraStateOrchestrator.java */
    public class b<T> implements Callable<Task<T>> {
        public final /* synthetic */ CameraState2 j;
        public final /* synthetic */ String k;
        public final /* synthetic */ CameraState2 l;
        public final /* synthetic */ Callable m;
        public final /* synthetic */ boolean n;

        public b(CameraState2 cameraState2, String str, CameraState2 cameraState3, Callable callable, boolean z2) {
            this.j = cameraState2;
            this.k = str;
            this.l = cameraState3;
            this.m = callable;
            this.n = z2;
        }

        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            CameraStateOrchestrator cameraStateOrchestrator = CameraStateOrchestrator.this;
            if (cameraStateOrchestrator.f == this.j) {
                return ((Task) this.m.call()).j(CameraEngine.this.k.g, new CameraStateOrchestrator2(this));
            }
            CameraOrchestrator.a.a(2, this.k.toUpperCase(), "- State mismatch, aborting. current:", CameraStateOrchestrator.this.f, "from:", this.j, "to:", this.l);
            c0 c0Var = new c0();
            c0Var.u();
            return c0Var;
        }
    }

    public CameraStateOrchestrator(@NonNull CameraOrchestrator.b bVar) {
        super(bVar);
        CameraState2 cameraState2 = CameraState2.OFF;
        this.f = cameraState2;
        this.g = cameraState2;
        this.h = 0;
    }

    @NonNull
    public <T> Task<T> f(@NonNull CameraState2 cameraState2, @NonNull CameraState2 cameraState3, boolean z2, @NonNull Callable<Task<T>> callable) {
        String str;
        int i = this.h + 1;
        this.h = i;
        this.g = cameraState3;
        boolean z3 = !cameraState3.f(cameraState2);
        if (z3) {
            str = cameraState2.name() + " << " + cameraState3.name();
        } else {
            str = cameraState2.name() + " >> " + cameraState3.name();
        }
        Task<T> taskD = d(str, z2, 0L, new b(cameraState2, str, cameraState3, callable, z3));
        taskD.b(new a(i));
        return taskD;
    }
}

package b.o.a.n.v;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: CameraStateOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class f$a<T> implements b.i.a.f.n.c<T> {
    public final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f1943b;

    public f$a(f fVar, int i) {
        this.f1943b = fVar;
        this.a = i;
    }

    @Override // b.i.a.f.n.c
    public void onComplete(@NonNull Task<T> task) {
        int i = this.a;
        f fVar = this.f1943b;
        if (i == fVar.h) {
            fVar.g = fVar.f;
        }
    }
}

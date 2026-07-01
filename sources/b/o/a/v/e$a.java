package b.o.a.v;

import android.hardware.Camera;
import android.hardware.Camera$PreviewCallback;
import androidx.annotation.NonNull;
import b.o.a.l$a;

/* JADX INFO: compiled from: Snapshot1PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public class e$a implements Camera$PreviewCallback {
    public final /* synthetic */ e j;

    public e$a(e eVar) {
        this.j = eVar;
    }

    @Override // android.hardware.Camera$PreviewCallback
    public void onPreviewFrame(@NonNull byte[] bArr, Camera camera) {
        this.j.a(false);
        e eVar = this.j;
        l$a l_a = eVar.j;
        int i = l_a.c;
        b.o.a.x.b bVar = l_a.d;
        b.o.a.x.b bVarC = eVar.n.C(b.o.a.n.t.b.SENSOR);
        if (bVarC == null) {
            throw new IllegalStateException("Preview stream size should never be null here.");
        }
        b.o.a.r.g.a(new e$a$a(this, bArr, bVarC, i, bVar));
        camera.setPreviewCallbackWithBuffer(null);
        camera.setPreviewCallbackWithBuffer(this.j.n);
        b.o.a.p.a aVarL1 = this.j.n.l1();
        e eVar2 = this.j;
        aVarL1.e(eVar2.q, bVarC, eVar2.n.L);
    }
}

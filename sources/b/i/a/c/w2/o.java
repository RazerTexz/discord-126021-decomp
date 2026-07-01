package b.i.a.c.w2;

import android.media.MediaDrm;
import android.media.MediaDrm$OnEventListener;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager$b;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager$c;
import java.util.Objects;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class o implements MediaDrm$OnEventListener {
    public final /* synthetic */ c0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a0$b f1154b;

    public /* synthetic */ o(c0 c0Var, a0$b a0_b) {
        this.a = c0Var;
        this.f1154b = a0_b;
    }

    @Override // android.media.MediaDrm$OnEventListener
    public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        c0 c0Var = this.a;
        a0$b a0_b = this.f1154b;
        Objects.requireNonNull(c0Var);
        DefaultDrmSessionManager$c defaultDrmSessionManager$c = ((DefaultDrmSessionManager$b) a0_b).a.f2931x;
        Objects.requireNonNull(defaultDrmSessionManager$c);
        defaultDrmSessionManager$c.obtainMessage(i, bArr).sendToTarget();
    }
}

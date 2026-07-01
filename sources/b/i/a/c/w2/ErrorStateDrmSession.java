package b.i.a.c.w2;

import androidx.annotation.Nullable;
import b.i.a.c.C;
import b.i.a.c.v2.CryptoConfig;
import b.i.a.c.w2.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSession;
import java.util.UUID;

/* JADX INFO: renamed from: b.i.a.c.w2.z, reason: use source file name */
/* JADX INFO: compiled from: ErrorStateDrmSession.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ErrorStateDrmSession implements DrmSession {
    public final DrmSession.DrmSessionException a;

    public ErrorStateDrmSession(DrmSession.DrmSessionException drmSessionException) {
        this.a = drmSessionException;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void a(@Nullable DrmSessionEventListener.a aVar) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void b(@Nullable DrmSessionEventListener.a aVar) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final UUID c() {
        return C.a;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean d() {
        return false;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean e(String str) {
        return false;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public DrmSession.DrmSessionException f() {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public CryptoConfig g() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public int getState() {
        return 1;
    }
}

package p007b.p225i.p226a.p242c.p266w2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSession;
import java.util.UUID;
import p007b.p225i.p226a.p242c.C2997x0;
import p007b.p225i.p226a.p242c.p265v2.InterfaceC2954b;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s;

/* JADX INFO: renamed from: b.i.a.c.w2.z */
/* JADX INFO: compiled from: ErrorStateDrmSession.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2995z implements DrmSession {

    /* JADX INFO: renamed from: a */
    public final DrmSession.DrmSessionException f8019a;

    public C2995z(DrmSession.DrmSessionException drmSessionException) {
        this.f8019a = drmSessionException;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    /* JADX INFO: renamed from: a */
    public void mo3606a(@Nullable InterfaceC2988s.a aVar) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    /* JADX INFO: renamed from: b */
    public void mo3607b(@Nullable InterfaceC2988s.a aVar) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    /* JADX INFO: renamed from: c */
    public final UUID mo3608c() {
        return C2997x0.f8021a;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    /* JADX INFO: renamed from: d */
    public boolean mo3609d() {
        return false;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    /* JADX INFO: renamed from: e */
    public boolean mo3610e(String str) {
        return false;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    /* JADX INFO: renamed from: f */
    public DrmSession.DrmSessionException mo3611f() {
        return this.f8019a;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    /* JADX INFO: renamed from: g */
    public InterfaceC2954b mo3612g() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public int getState() {
        return 1;
    }
}

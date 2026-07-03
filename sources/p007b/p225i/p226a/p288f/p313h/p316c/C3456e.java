package p007b.p225i.p226a.p288f.p313h.p316c;

import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;
import p007b.p225i.p226a.p288f.p292c.p293a.p294d.InterfaceC3187b;

/* JADX INFO: renamed from: b.i.a.f.h.c.e */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3456e implements InterfaceC3187b {

    /* JADX INFO: renamed from: j */
    public final Status f9637j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public final Credential f9638k;

    public C3456e(Status status, @Nullable Credential credential) {
        this.f9637j = status;
        this.f9638k = credential;
    }

    @Override // p007b.p225i.p226a.p288f.p292c.p293a.p294d.InterfaceC3187b
    @Nullable
    /* JADX INFO: renamed from: R */
    public final Credential mo3969R() {
        return this.f9638k;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3273h
    /* JADX INFO: renamed from: b0 */
    public final Status mo4053b0() {
        return this.f9637j;
    }
}

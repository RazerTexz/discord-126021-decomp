package p007b.p225i.p226a.p288f.p299e.p304k;

import androidx.annotation.BinderThread;
import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.e.k.m0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3368m0 extends AbstractC3393z {

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ AbstractC3345b f9541g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    public C3368m0(AbstractC3345b abstractC3345b, int i) {
        super(abstractC3345b, i, null);
        this.f9541g = abstractC3345b;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3393z
    /* JADX INFO: renamed from: d */
    public final boolean mo4171d() {
        this.f9541g.f9486k.mo4103a(ConnectionResult.f20472j);
        return true;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3393z
    /* JADX INFO: renamed from: e */
    public final void mo4172e(ConnectionResult connectionResult) {
        Objects.requireNonNull(this.f9541g);
        this.f9541g.f9486k.mo4103a(connectionResult);
        Objects.requireNonNull(this.f9541g);
        System.currentTimeMillis();
    }
}

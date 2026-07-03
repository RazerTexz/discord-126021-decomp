package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: renamed from: b.i.a.f.i.b.n9 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4130n9 implements InterfaceC4218v9 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C4097k9 f10997a;

    public C4130n9(C4097k9 c4097k9) {
        this.f10997a = c4097k9;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4218v9
    /* JADX INFO: renamed from: a */
    public final void mo5762a(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.f10997a.f10906k.mo5726g().f11141f.m5860a("AppId not known when logging error event");
        } else {
            this.f10997a.mo5725f().m5852v(new RunnableC4152p9(this, str, bundle));
        }
    }
}

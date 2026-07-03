package p007b.p225i.p226a.p288f.p313h.p316c;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Base64;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p292c.p293a.C3183a;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3349d;
import p007b.p225i.p226a.p288f.p299e.p304k.C3347c;

/* JADX INFO: renamed from: b.i.a.f.h.c.o */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3466o extends AbstractC3349d<InterfaceC3471t> {

    /* JADX INFO: renamed from: A */
    public final C3183a.a f9644A;

    public C3466o(Context context, Looper looper, C3347c c3347c, C3183a.a aVar, AbstractC3268c.a aVar2, AbstractC3268c.b bVar) {
        super(context, looper, 68, c3347c, aVar2, bVar);
        C3183a.a.C13228a c13228a = new C3183a.a.C13228a(aVar == null ? C3183a.a.f9210j : aVar);
        byte[] bArr = new byte[16];
        C3452a.f9634a.nextBytes(bArr);
        c13228a.f9216c = Base64.encodeToString(bArr, 11);
        this.f9644A = new C3183a.a(c13228a);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b, p007b.p225i.p226a.p288f.p299e.p300h.C3266a.f
    /* JADX INFO: renamed from: l */
    public final int mo3982l() {
        return 12800000;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: r */
    public final /* synthetic */ IInterface mo3983r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC3471t ? (InterfaceC3471t) iInterfaceQueryLocalInterface : new C3470s(iBinder);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: u */
    public final Bundle mo4140u() {
        C3183a.a aVar = this.f9644A;
        Objects.requireNonNull(aVar);
        Bundle bundle = new Bundle();
        bundle.putString("consumer_package", aVar.f9211k);
        bundle.putBoolean("force_save_dialog", aVar.f9212l);
        bundle.putString("log_session_id", aVar.f9213m);
        return bundle;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: x */
    public final String mo3984x() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: y */
    public final String mo3985y() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }
}

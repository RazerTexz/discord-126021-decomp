package p007b.p225i.p226a.p288f.p337l.p338b;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.zas;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.signin.internal.zam;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p292c.p293a.p296f.p297b.C3198a;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.BinderC3294g0;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.RunnableC3298i0;
import p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b;
import p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3349d;
import p007b.p225i.p226a.p288f.p299e.p304k.C3347c;
import p007b.p225i.p226a.p288f.p337l.InterfaceC4349f;

/* JADX INFO: renamed from: b.i.a.f.l.b.a */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C4336a extends AbstractC3349d<InterfaceC4340e> implements InterfaceC4349f {

    /* JADX INFO: renamed from: A */
    public final boolean f11448A;

    /* JADX INFO: renamed from: B */
    public final C3347c f11449B;

    /* JADX INFO: renamed from: C */
    public final Bundle f11450C;

    /* JADX INFO: renamed from: D */
    @Nullable
    public final Integer f11451D;

    public C4336a(Context context, Looper looper, boolean z2, C3347c c3347c, Bundle bundle, AbstractC3268c.a aVar, AbstractC3268c.b bVar) {
        super(context, looper, 44, c3347c, aVar, bVar);
        this.f11448A = z2;
        this.f11449B = c3347c;
        this.f11450C = bundle;
        this.f11451D = c3347c.f9508h;
    }

    @Override // p007b.p225i.p226a.p288f.p337l.InterfaceC4349f
    /* JADX INFO: renamed from: d */
    public final void mo5998d(InterfaceC4338c interfaceC4338c) {
        C1460d.m595z(interfaceC4338c, "Expecting a valid ISignInCallbacks");
        try {
            Account account = this.f11449B.f9501a;
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            GoogleSignInAccount googleSignInAccountM3975b = "<<default account>>".equals(account.name) ? C3198a.m3973a(this.f9479d).m3975b() : null;
            Integer num = this.f11451D;
            Objects.requireNonNull(num, "null reference");
            ((InterfaceC4340e) m4142w()).mo6000f0(new zak(new zas(account, num.intValue(), googleSignInAccountM3975b)), interfaceC4338c);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                BinderC3294g0 binderC3294g0 = (BinderC3294g0) interfaceC4338c;
                binderC3294g0.f9415c.post(new RunnableC3298i0(binderC3294g0, new zam()));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b, p007b.p225i.p226a.p288f.p299e.p300h.C3266a.f
    /* JADX INFO: renamed from: l */
    public int mo3982l() {
        return 12451000;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b, p007b.p225i.p226a.p288f.p299e.p300h.C3266a.f
    /* JADX INFO: renamed from: o */
    public boolean mo4042o() {
        return this.f11448A;
    }

    @Override // p007b.p225i.p226a.p288f.p337l.InterfaceC4349f
    /* JADX INFO: renamed from: p */
    public final void mo5999p() {
        m4132g(new AbstractC3345b.d());
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: r */
    public /* synthetic */ IInterface mo3983r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC4340e ? (InterfaceC4340e) iInterfaceQueryLocalInterface : new C4342g(iBinder);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: u */
    public Bundle mo4140u() {
        if (!this.f9479d.getPackageName().equals(this.f11449B.f9505e)) {
            this.f11450C.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f11449B.f9505e);
        }
        return this.f11450C;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: x */
    public String mo3984x() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: y */
    public String mo3985y() {
        return "com.google.android.gms.signin.service.START";
    }
}

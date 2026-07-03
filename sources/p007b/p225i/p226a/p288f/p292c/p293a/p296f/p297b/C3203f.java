package p007b.p225i.p226a.p288f.p292c.p293a.p296f.p297b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import java.util.Arrays;
import java.util.Iterator;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3349d;
import p007b.p225i.p226a.p288f.p299e.p304k.C3347c;
import p007b.p225i.p226a.p288f.p313h.p316c.C3452a;

/* JADX INFO: renamed from: b.i.a.f.c.a.f.b.f */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3203f extends AbstractC3349d<InterfaceC3212o> {

    /* JADX INFO: renamed from: A */
    public final GoogleSignInOptions f9234A;

    public C3203f(Context context, Looper looper, C3347c c3347c, @Nullable GoogleSignInOptions googleSignInOptions, AbstractC3268c.a aVar, AbstractC3268c.b bVar) {
        super(context, looper, 91, c3347c, aVar, bVar);
        GoogleSignInOptions.C10794a c10794a = googleSignInOptions != null ? new GoogleSignInOptions.C10794a(googleSignInOptions) : new GoogleSignInOptions.C10794a();
        byte[] bArr = new byte[16];
        C3452a.f9634a.nextBytes(bArr);
        c10794a.f20454i = Base64.encodeToString(bArr, 11);
        if (!c3347c.f9503c.isEmpty()) {
            Iterator<Scope> it = c3347c.f9503c.iterator();
            while (it.hasNext()) {
                c10794a.f20446a.add(it.next());
                c10794a.f20446a.addAll(Arrays.asList(new Scope[0]));
            }
        }
        this.f9234A = c10794a.m9015a();
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b, p007b.p225i.p226a.p288f.p299e.p300h.C3266a.f
    /* JADX INFO: renamed from: l */
    public final int mo3982l() {
        return 12451000;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: r */
    public final /* synthetic */ IInterface mo3983r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC3212o ? (InterfaceC3212o) iInterfaceQueryLocalInterface : new C3215r(iBinder);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: x */
    public final String mo3984x() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: y */
    public final String mo3985y() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }
}

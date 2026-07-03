package p007b.p225i.p226a.p288f.p313h.p317d;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import p007b.p225i.p226a.p288f.p292c.p293a.C3184b;
import p007b.p225i.p226a.p288f.p292c.p293a.C3185c;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3349d;
import p007b.p225i.p226a.p288f.p299e.p304k.C3347c;

/* JADX INFO: renamed from: b.i.a.f.h.d.a */
/* JADX INFO: loaded from: classes3.dex */
public final class C3473a extends AbstractC3349d<InterfaceC3474b> {

    /* JADX INFO: renamed from: A */
    public final Bundle f9645A;

    public C3473a(Context context, Looper looper, C3347c c3347c, C3185c c3185c, AbstractC3268c.a aVar, AbstractC3268c.b bVar) {
        super(context, looper, 16, c3347c, aVar, bVar);
        if (c3185c != null) {
            throw new NoSuchMethodError();
        }
        this.f9645A = new Bundle();
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b, p007b.p225i.p226a.p288f.p299e.p300h.C3266a.f
    /* JADX INFO: renamed from: l */
    public final int mo3982l() {
        return 12451000;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b, p007b.p225i.p226a.p288f.p299e.p300h.C3266a.f
    /* JADX INFO: renamed from: o */
    public final boolean mo4042o() {
        C3347c c3347c = this.f9513x;
        Account account = c3347c.f9501a;
        if (TextUtils.isEmpty(account != null ? account.name : null)) {
            return false;
        }
        if (c3347c.f9504d.get(C3184b.f9219c) == null) {
            return !c3347c.f9502b.isEmpty();
        }
        throw null;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: r */
    public final /* synthetic */ IInterface mo3983r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC3474b ? (InterfaceC3474b) iInterfaceQueryLocalInterface : new C3475c(iBinder);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: u */
    public final Bundle mo4140u() {
        return this.f9645A;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: x */
    public final String mo3984x() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: y */
    public final String mo3985y() {
        return "com.google.android.gms.auth.service.START";
    }
}

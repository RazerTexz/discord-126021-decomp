package p007b.p225i.p226a.p288f.p313h.p324k;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3290f;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3303l;
import p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3349d;
import p007b.p225i.p226a.p288f.p299e.p304k.C3347c;

/* JADX INFO: renamed from: b.i.a.f.h.k.g */
/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3562g extends AbstractC3349d<InterfaceC3557b> {
    public C3562g(Context context, Looper looper, C3347c c3347c, InterfaceC3290f interfaceC3290f, InterfaceC3303l interfaceC3303l) {
        super(context, looper, 19, c3347c, interfaceC3290f, interfaceC3303l);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b, p007b.p225i.p226a.p288f.p299e.p300h.C3266a.f
    /* JADX INFO: renamed from: l */
    public final int mo3982l() {
        return 12600000;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: r */
    public final /* synthetic */ IInterface mo3983r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        return iInterfaceQueryLocalInterface instanceof InterfaceC3557b ? (InterfaceC3557b) iInterfaceQueryLocalInterface : new C3559d(iBinder);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: x */
    public final String mo3984x() {
        return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: y */
    public final String mo3985y() {
        return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
    }
}

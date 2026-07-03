package p007b.p225i.p226a.p288f.p312g;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: renamed from: b.i.a.f.g.e */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3429e implements DynamiteModule.InterfaceC10803a {
    @Override // com.google.android.gms.dynamite.DynamiteModule.InterfaceC10803a
    /* JADX INFO: renamed from: a */
    public final C3434j mo4384a(Context context, String str, InterfaceC3433i interfaceC3433i) throws DynamiteModule.LoadingException {
        int iMo4382a;
        C3434j c3434j = new C3434j();
        int iMo4383b = interfaceC3433i.mo4383b(context, str);
        c3434j.f9618a = iMo4383b;
        int i = 0;
        if (iMo4383b != 0) {
            iMo4382a = interfaceC3433i.mo4382a(context, str, false);
            c3434j.f9619b = iMo4382a;
        } else {
            iMo4382a = interfaceC3433i.mo4382a(context, str, true);
            c3434j.f9619b = iMo4382a;
        }
        int i2 = c3434j.f9618a;
        if (i2 == 0) {
            if (iMo4382a == 0) {
                c3434j.f9620c = 0;
            }
            return c3434j;
        }
        i = i2;
        if (i >= iMo4382a) {
            c3434j.f9620c = -1;
        } else {
            c3434j.f9620c = 1;
        }
        return c3434j;
    }
}

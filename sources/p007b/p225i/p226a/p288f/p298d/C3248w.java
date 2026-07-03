package p007b.p225i.p226a.p288f.p298d;

import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4362f;

/* JADX INFO: renamed from: b.i.a.f.d.w */
/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C3248w implements InterfaceC4362f {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC4362f f9290a = new C3248w();

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4362f
    /* JADX INFO: renamed from: a */
    public final Task mo4013a(Object obj) {
        Bundle bundle = (Bundle) obj;
        int i = C3227b.f9243a;
        return bundle != null && bundle.containsKey("google.messenger") ? C3404f.m4264Z(null) : C3404f.m4264Z(bundle);
    }
}

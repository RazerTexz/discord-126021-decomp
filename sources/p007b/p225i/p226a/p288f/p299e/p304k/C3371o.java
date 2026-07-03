package p007b.p225i.p226a.p288f.p299e.p304k;

import android.content.Intent;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3299j;

/* JADX INFO: renamed from: b.i.a.f.e.k.o */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3371o extends AbstractDialogInterfaceOnClickListenerC3369n {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Intent f9542j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ InterfaceC3299j f9543k;

    public C3371o(Intent intent, InterfaceC3299j interfaceC3299j, int i) {
        this.f9542j = intent;
        this.f9543k = interfaceC3299j;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractDialogInterfaceOnClickListenerC3369n
    /* JADX INFO: renamed from: a */
    public final void mo4173a() {
        Intent intent = this.f9542j;
        if (intent != null) {
            this.f9543k.startActivityForResult(intent, 2);
        }
    }
}

package p007b.p225i.p226a.p288f.p299e.p304k;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: renamed from: b.i.a.f.e.k.m */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3367m extends AbstractDialogInterfaceOnClickListenerC3369n {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Intent f9538j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Activity f9539k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ int f9540l;

    public C3367m(Intent intent, Activity activity, int i) {
        this.f9538j = intent;
        this.f9539k = activity;
        this.f9540l = i;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractDialogInterfaceOnClickListenerC3369n
    /* JADX INFO: renamed from: a */
    public final void mo4173a() {
        Intent intent = this.f9538j;
        if (intent != null) {
            this.f9539k.startActivityForResult(intent, this.f9540l);
        }
    }
}

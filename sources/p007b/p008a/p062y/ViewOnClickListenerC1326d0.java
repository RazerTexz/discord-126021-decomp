package p007b.p008a.p062y;

import android.view.View;

/* JADX INFO: renamed from: b.a.y.d0 */
/* JADX INFO: compiled from: SelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewOnClickListenerC1326d0 implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C1328e0 f2016j;

    public ViewOnClickListenerC1326d0(C1328e0 c1328e0) {
        this.f2016j = c1328e0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C1328e0 c1328e0 = this.f2016j;
        c1328e0.f2018a.mo376c(c1328e0.getAdapterPosition());
        this.f2016j.f2019b.dismiss();
    }
}

package b.a.y;

import android.view.View;

/* JADX INFO: renamed from: b.a.y.d0, reason: use source file name */
/* JADX INFO: compiled from: SelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectorBottomSheet3 implements View.OnClickListener {
    public final /* synthetic */ SelectorBottomSheet4 j;

    public SelectorBottomSheet3(SelectorBottomSheet4 selectorBottomSheet4) {
        this.j = selectorBottomSheet4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SelectorBottomSheet4 selectorBottomSheet4 = this.j;
        selectorBottomSheet4.a.c(selectorBottomSheet4.getAdapterPosition());
        this.j.f310b.dismiss();
    }
}

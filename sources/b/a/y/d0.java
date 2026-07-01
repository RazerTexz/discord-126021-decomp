package b.a.y;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: SelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d0 implements View$OnClickListener {
    public final /* synthetic */ e0 j;

    public d0(e0 e0Var) {
        this.j = e0Var;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        e0 e0Var = this.j;
        e0Var.a.c(e0Var.getAdapterPosition());
        this.j.f310b.dismiss();
    }
}

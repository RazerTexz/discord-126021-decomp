package b.a.y.l0;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ExperimentOverrideView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements View$OnClickListener {
    public final /* synthetic */ Function0 j;

    public b(Function0 function0) {
        this.j = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.j.invoke();
    }
}

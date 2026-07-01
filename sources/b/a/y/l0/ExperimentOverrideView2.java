package b.a.y.l0;

import android.view.View;
import android.widget.AdapterView;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.y.l0.a, reason: use source file name */
/* JADX INFO: compiled from: ExperimentOverrideView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExperimentOverrideView2 implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ Function1 j;

    public ExperimentOverrideView2(Function1 function1) {
        this.j = function1;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (j != -1) {
            this.j.invoke(Integer.valueOf((int) j));
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}

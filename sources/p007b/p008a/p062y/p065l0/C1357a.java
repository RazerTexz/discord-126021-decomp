package p007b.p008a.p062y.p065l0;

import android.view.View;
import android.widget.AdapterView;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.y.l0.a */
/* JADX INFO: compiled from: ExperimentOverrideView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1357a implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Function1 f2046j;

    public C1357a(Function1 function1) {
        this.f2046j = function1;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (j != -1) {
            this.f2046j.invoke(Integer.valueOf((int) j));
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}

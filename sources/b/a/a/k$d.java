package b.a.a;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DatePickerDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k$d implements View$OnClickListener {
    public final /* synthetic */ k j;

    public k$d(k kVar) {
        this.j = kVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function1<? super Long, Unit> function1;
        k kVar = this.j;
        if (kVar.datePicked && (function1 = kVar.onDatePicked) != null) {
            function1.invoke(Long.valueOf(kVar.selectedDate));
        }
        this.j.dismiss();
    }
}

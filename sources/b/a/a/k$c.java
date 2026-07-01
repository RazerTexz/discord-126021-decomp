package b.a.a;

import android.widget.DatePicker;
import android.widget.DatePicker$OnDateChangedListener;
import java.util.Calendar;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DatePickerDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k$c implements DatePicker$OnDateChangedListener {
    public final /* synthetic */ k j;

    public k$c(k kVar) {
        this.j = kVar;
    }

    @Override // android.widget.DatePicker$OnDateChangedListener
    public final void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(i, i2, i3);
        k kVar = this.j;
        d0.z.d.m.checkNotNullExpressionValue(calendar, "cal");
        kVar.selectedDate = calendar.getTimeInMillis();
        k kVar2 = this.j;
        kVar2.datePicked = true;
        Function1<? super Long, Unit> function1 = kVar2.onDatePicked;
        if (function1 != null) {
            function1.invoke(Long.valueOf(kVar2.selectedDate));
        }
    }
}

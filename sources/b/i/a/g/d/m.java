package b.i.a.g.d;

import android.view.View;
import android.view.View$OnClickListener;
import com.google.android.material.datepicker.MaterialCalendar$k;
import com.google.android.material.datepicker.Month;
import com.google.android.material.datepicker.YearGridAdapter;

/* JADX INFO: compiled from: YearGridAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public class m implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ YearGridAdapter k;

    public m(YearGridAdapter yearGridAdapter, int i) {
        this.k = yearGridAdapter;
        this.j = i;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        this.k.a.setCurrentMonth(this.k.a.getCalendarConstraints().clamp(Month.g(this.j, this.k.a.getCurrentMonth().k)));
        this.k.a.setSelector(MaterialCalendar$k.DAY);
    }
}

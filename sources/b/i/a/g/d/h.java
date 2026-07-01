package b.i.a.g.d;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.MaterialCalendar$d;
import com.google.android.material.datepicker.MaterialCalendar$l;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import com.google.android.material.datepicker.MonthsPagerAdapter;
import com.google.android.material.datepicker.OnSelectionChangedListener;
import java.util.Iterator;

/* JADX INFO: compiled from: MonthsPagerAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public class h implements AdapterView$OnItemClickListener {
    public final /* synthetic */ MaterialCalendarGridView j;
    public final /* synthetic */ MonthsPagerAdapter k;

    public h(MonthsPagerAdapter monthsPagerAdapter, MaterialCalendarGridView materialCalendarGridView) {
        this.k = monthsPagerAdapter;
        this.j = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView$OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVarA = this.j.a();
        if (i >= gVarA.b() && i <= gVarA.d()) {
            MaterialCalendar$l materialCalendar$l = this.k.d;
            long jLongValue = this.j.a().c(i).longValue();
            MaterialCalendar$d materialCalendar$d = (MaterialCalendar$d) materialCalendar$l;
            if (MaterialCalendar.access$100(materialCalendar$d.a).getDateValidator().isValid(jLongValue)) {
                MaterialCalendar.access$200(materialCalendar$d.a).select(jLongValue);
                Iterator it = materialCalendar$d.a.onSelectionChangedListeners.iterator();
                while (it.hasNext()) {
                    ((OnSelectionChangedListener) it.next()).onSelectionChanged(MaterialCalendar.access$200(materialCalendar$d.a).getSelection());
                }
                MaterialCalendar.access$000(materialCalendar$d.a).getAdapter().notifyDataSetChanged();
                if (MaterialCalendar.access$300(materialCalendar$d.a) != null) {
                    MaterialCalendar.access$300(materialCalendar$d.a).getAdapter().notifyDataSetChanged();
                }
            }
        }
    }
}

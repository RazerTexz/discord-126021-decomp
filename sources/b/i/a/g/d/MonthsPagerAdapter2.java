package b.i.a.g.d;

import android.view.View;
import android.widget.AdapterView;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import com.google.android.material.datepicker.MonthsPagerAdapter;
import com.google.android.material.datepicker.OnSelectionChangedListener;
import java.util.Iterator;

/* JADX INFO: renamed from: b.i.a.g.d.h, reason: use source file name */
/* JADX INFO: compiled from: MonthsPagerAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public class MonthsPagerAdapter2 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ MaterialCalendarGridView j;
    public final /* synthetic */ MonthsPagerAdapter k;

    public MonthsPagerAdapter2(MonthsPagerAdapter monthsPagerAdapter, MaterialCalendarGridView materialCalendarGridView) {
        this.k = monthsPagerAdapter;
        this.j = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        MonthAdapter adapter = this.j.getAdapter();
        if (i >= adapter.b() && i <= adapter.d()) {
            MaterialCalendar.l lVar = this.k.d;
            long jLongValue = this.j.getAdapter().getItem(i).longValue();
            MaterialCalendar.d dVar = (MaterialCalendar.d) lVar;
            if (MaterialCalendar.this.calendarConstraints.getDateValidator().isValid(jLongValue)) {
                MaterialCalendar.this.dateSelector.select(jLongValue);
                Iterator it = MaterialCalendar.this.onSelectionChangedListeners.iterator();
                while (it.hasNext()) {
                    ((OnSelectionChangedListener) it.next()).onSelectionChanged(MaterialCalendar.this.dateSelector.getSelection());
                }
                MaterialCalendar.this.recyclerView.getAdapter().notifyDataSetChanged();
                if (MaterialCalendar.this.yearSelector != null) {
                    MaterialCalendar.this.yearSelector.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }
}

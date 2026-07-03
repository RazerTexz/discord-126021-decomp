package p007b.p225i.p226a.p341g.p345d;

import android.view.View;
import android.widget.AdapterView;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import com.google.android.material.datepicker.MonthsPagerAdapter;
import com.google.android.material.datepicker.OnSelectionChangedListener;
import java.util.Iterator;

/* JADX INFO: renamed from: b.i.a.g.d.h */
/* JADX INFO: compiled from: MonthsPagerAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4397h implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ MaterialCalendarGridView f11612j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ MonthsPagerAdapter f11613k;

    public C4397h(MonthsPagerAdapter monthsPagerAdapter, MaterialCalendarGridView materialCalendarGridView) {
        this.f11613k = monthsPagerAdapter;
        this.f11612j = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C4396g adapter = this.f11612j.getAdapter();
        if (i >= adapter.m6063b() && i <= adapter.m6065d()) {
            MaterialCalendar.InterfaceC10896l interfaceC10896l = this.f11613k.f20994d;
            long jLongValue = this.f11612j.getAdapter().getItem(i).longValue();
            MaterialCalendar.C10888d c10888d = (MaterialCalendar.C10888d) interfaceC10896l;
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

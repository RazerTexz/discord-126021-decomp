package p007b.p225i.p226a.p341g.p345d;

import android.view.View;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.Month;
import com.google.android.material.datepicker.YearGridAdapter;

/* JADX INFO: renamed from: b.i.a.g.d.m */
/* JADX INFO: compiled from: YearGridAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public class ViewOnClickListenerC4402m implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f11618j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ YearGridAdapter f11619k;

    public ViewOnClickListenerC4402m(YearGridAdapter yearGridAdapter, int i) {
        this.f11619k = yearGridAdapter;
        this.f11618j = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f11619k.f21006a.setCurrentMonth(this.f11619k.f21006a.getCalendarConstraints().clamp(Month.m9131g(this.f11618j, this.f11619k.f21006a.getCurrentMonth().f20985k)));
        this.f11619k.f21006a.setSelector(MaterialCalendar.EnumC10895k.DAY);
    }
}

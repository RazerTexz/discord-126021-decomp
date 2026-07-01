package com.google.android.material.datepicker;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialCalendar$a implements Runnable {
    public final /* synthetic */ int j;
    public final /* synthetic */ MaterialCalendar k;

    public MaterialCalendar$a(MaterialCalendar materialCalendar, int i) {
        this.k = materialCalendar;
        this.j = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        MaterialCalendar.access$000(this.k).smoothScrollToPosition(this.j);
    }
}

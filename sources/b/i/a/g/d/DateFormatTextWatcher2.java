package b.i.a.g.d;

/* JADX INFO: renamed from: b.i.a.g.d.d, reason: use source file name */
/* JADX INFO: compiled from: DateFormatTextWatcher.java */
/* JADX INFO: loaded from: classes3.dex */
public class DateFormatTextWatcher2 implements Runnable {
    public final /* synthetic */ long j;
    public final /* synthetic */ DateFormatTextWatcher k;

    public DateFormatTextWatcher2(DateFormatTextWatcher dateFormatTextWatcher, long j) {
        this.k = dateFormatTextWatcher;
        this.j = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        DateFormatTextWatcher dateFormatTextWatcher = this.k;
        dateFormatTextWatcher.j.setError(String.format(dateFormatTextWatcher.m, b.i.a.f.e.o.f.g0(this.j)));
        this.k.a();
    }
}

package b.i.a.c.d3;

import com.google.android.exoplayer2.ui.DefaultTimeBar;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ DefaultTimeBar j;

    public /* synthetic */ b(DefaultTimeBar defaultTimeBar) {
        this.j = defaultTimeBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.g(false);
    }
}

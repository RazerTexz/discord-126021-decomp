package y.b.b;

import androidx.core.widget.ContentLoadingProgressBar;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ ContentLoadingProgressBar j;

    public /* synthetic */ d(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.j = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ContentLoadingProgressBar.b(this.j);
    }
}

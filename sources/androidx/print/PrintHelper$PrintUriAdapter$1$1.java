package androidx.print;

import android.os.CancellationSignal$OnCancelListener;

/* JADX INFO: loaded from: classes.dex */
public class PrintHelper$PrintUriAdapter$1$1 implements CancellationSignal$OnCancelListener {
    public final /* synthetic */ PrintHelper$PrintUriAdapter$1 this$2;

    public PrintHelper$PrintUriAdapter$1$1(PrintHelper$PrintUriAdapter$1 printHelper$PrintUriAdapter$1) {
        this.this$2 = printHelper$PrintUriAdapter$1;
    }

    @Override // android.os.CancellationSignal$OnCancelListener
    public void onCancel() {
        this.this$2.this$1.cancelLoad();
        this.this$2.cancel(false);
    }
}

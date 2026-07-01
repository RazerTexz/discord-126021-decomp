package b.o.a.w;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: CameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$a implements Runnable {
    public final /* synthetic */ TaskCompletionSource j;
    public final /* synthetic */ a k;

    public a$a(a aVar, TaskCompletionSource taskCompletionSource) {
        this.k = aVar;
        this.j = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public void run() {
        View viewK = this.k.k();
        ViewParent parent = viewK.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(viewK);
        }
        this.j.a.s(null);
    }
}

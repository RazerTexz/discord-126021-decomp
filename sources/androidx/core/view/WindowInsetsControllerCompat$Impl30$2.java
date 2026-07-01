package androidx.core.view;

import android.view.WindowInsetsController;
import android.view.WindowInsetsController$OnControllableInsetsChangedListener;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class WindowInsetsControllerCompat$Impl30$2 implements WindowInsetsController$OnControllableInsetsChangedListener {
    public final /* synthetic */ WindowInsetsControllerCompat$Impl30 this$0;
    public final /* synthetic */ WindowInsetsControllerCompat$OnControllableInsetsChangedListener val$listener;

    public WindowInsetsControllerCompat$Impl30$2(WindowInsetsControllerCompat$Impl30 windowInsetsControllerCompat$Impl30, WindowInsetsControllerCompat$OnControllableInsetsChangedListener windowInsetsControllerCompat$OnControllableInsetsChangedListener) {
        this.this$0 = windowInsetsControllerCompat$Impl30;
        this.val$listener = windowInsetsControllerCompat$OnControllableInsetsChangedListener;
    }

    @Override // android.view.WindowInsetsController$OnControllableInsetsChangedListener
    public void onControllableInsetsChanged(@NonNull WindowInsetsController windowInsetsController, int i) {
        WindowInsetsControllerCompat$Impl30 windowInsetsControllerCompat$Impl30 = this.this$0;
        if (windowInsetsControllerCompat$Impl30.mInsetsController == windowInsetsController) {
            this.val$listener.onControllableInsetsChanged(windowInsetsControllerCompat$Impl30.mCompatController, i);
        }
    }
}

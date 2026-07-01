package androidx.core.view;

import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class WindowInsetsControllerCompat$Impl30$1 implements WindowInsetsAnimationControlListener {
    private WindowInsetsAnimationControllerCompat mCompatAnimController = null;
    public final /* synthetic */ WindowInsetsControllerCompat$Impl30 this$0;
    public final /* synthetic */ WindowInsetsAnimationControlListenerCompat val$listener;

    public WindowInsetsControllerCompat$Impl30$1(WindowInsetsControllerCompat$Impl30 windowInsetsControllerCompat$Impl30, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        this.this$0 = windowInsetsControllerCompat$Impl30;
        this.val$listener = windowInsetsAnimationControlListenerCompat;
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onCancelled(@Nullable WindowInsetsAnimationController windowInsetsAnimationController) {
        this.val$listener.onCancelled(windowInsetsAnimationController == null ? null : this.mCompatAnimController);
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onFinished(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
        this.val$listener.onFinished(this.mCompatAnimController);
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onReady(@NonNull WindowInsetsAnimationController windowInsetsAnimationController, int i) {
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = new WindowInsetsAnimationControllerCompat(windowInsetsAnimationController);
        this.mCompatAnimController = windowInsetsAnimationControllerCompat;
        this.val$listener.onReady(windowInsetsAnimationControllerCompat, i);
    }
}

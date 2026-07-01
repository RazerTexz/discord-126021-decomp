package androidx.appcompat.app;

import android.view.KeyEvent;
import androidx.core.view.KeyEventDispatcher$Component;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDialog$1 implements KeyEventDispatcher$Component {
    public final /* synthetic */ AppCompatDialog this$0;

    public AppCompatDialog$1(AppCompatDialog appCompatDialog) {
        this.this$0 = appCompatDialog;
    }

    @Override // androidx.core.view.KeyEventDispatcher$Component
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return this.this$0.superDispatchKeyEvent(keyEvent);
    }
}

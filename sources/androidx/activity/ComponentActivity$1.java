package androidx.activity;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity$1 implements Runnable {
    public final /* synthetic */ ComponentActivity this$0;

    public ComponentActivity$1(ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ComponentActivity.access$001(this.this$0);
        } catch (IllegalStateException e) {
            if (!TextUtils.equals(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                throw e;
            }
        }
    }
}

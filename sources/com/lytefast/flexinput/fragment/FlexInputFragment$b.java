package com.lytefast.flexinput.fragment;

import android.util.Log;
import androidx.fragment.app.DialogFragment;

/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FlexInputFragment$b implements Runnable {
    public final /* synthetic */ DialogFragment j;

    public FlexInputFragment$b(DialogFragment dialogFragment) {
        this.j = dialogFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DialogFragment dialogFragment = this.j;
        if (dialogFragment == null || !dialogFragment.isAdded() || this.j.isRemoving() || this.j.isDetached()) {
            return;
        }
        try {
            this.j.dismiss();
        } catch (IllegalStateException e) {
            Log.w(FlexInputFragment.k, "could not dismiss add content dialog", e);
        }
    }
}

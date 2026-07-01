package com.google.android.material.snackbar;

import android.os.Handler$Callback;
import android.os.Message;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class BaseTransientBottomBar$j implements Handler$Callback {
    @Override // android.os.Handler$Callback
    public boolean handleMessage(@NonNull Message message) {
        int i = message.what;
        if (i == 0) {
            ((BaseTransientBottomBar) message.obj).showView();
            return true;
        }
        if (i != 1) {
            return false;
        }
        ((BaseTransientBottomBar) message.obj).hideView(message.arg1);
        return true;
    }
}

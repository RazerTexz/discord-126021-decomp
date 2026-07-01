package com.google.android.material.snackbar;

import android.os.Handler;
import b.i.a.g.h.a$b;

/* JADX INFO: loaded from: classes3.dex */
public class BaseTransientBottomBar$o implements a$b {
    public final /* synthetic */ BaseTransientBottomBar a;

    public BaseTransientBottomBar$o(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    @Override // b.i.a.g.h.a$b
    public void a(int i) {
        Handler handler = BaseTransientBottomBar.handler;
        handler.sendMessage(handler.obtainMessage(1, i, 0, this.a));
    }

    @Override // b.i.a.g.h.a$b
    public void show() {
        Handler handler = BaseTransientBottomBar.handler;
        handler.sendMessage(handler.obtainMessage(0, this.a));
    }
}

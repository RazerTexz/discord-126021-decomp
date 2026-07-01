package com.google.android.material.snackbar;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseTransientBottomBar$BaseCallback<B> {
    public static final int DISMISS_EVENT_ACTION = 1;
    public static final int DISMISS_EVENT_CONSECUTIVE = 4;
    public static final int DISMISS_EVENT_MANUAL = 3;
    public static final int DISMISS_EVENT_SWIPE = 0;
    public static final int DISMISS_EVENT_TIMEOUT = 2;

    public void onDismissed(B b2, int i) {
    }

    public void onShown(B b2) {
    }
}

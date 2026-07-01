package com.google.android.material.snackbar;

/* JADX INFO: loaded from: classes3.dex */
public class Snackbar$Callback extends BaseTransientBottomBar$BaseCallback<Snackbar> {
    public static final int DISMISS_EVENT_ACTION = 1;
    public static final int DISMISS_EVENT_CONSECUTIVE = 4;
    public static final int DISMISS_EVENT_MANUAL = 3;
    public static final int DISMISS_EVENT_SWIPE = 0;
    public static final int DISMISS_EVENT_TIMEOUT = 2;

    /* JADX INFO: renamed from: onDismissed, reason: avoid collision after fix types in other method */
    public void onDismissed2(Snackbar snackbar, int i) {
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar$BaseCallback
    public /* bridge */ /* synthetic */ void onDismissed(Snackbar snackbar, int i) {
        onDismissed2(snackbar, i);
    }

    /* JADX INFO: renamed from: onShown, reason: avoid collision after fix types in other method */
    public void onShown2(Snackbar snackbar) {
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar$BaseCallback
    public /* bridge */ /* synthetic */ void onShown(Snackbar snackbar) {
        onShown2(snackbar);
    }
}

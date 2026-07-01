package androidx.appcompat.widget;

/* JADX INFO: loaded from: classes.dex */
public interface ActionBarOverlayLayout$ActionBarVisibilityCallback {
    void enableContentAnimations(boolean z2);

    void hideForSystem();

    void onContentScrollStarted();

    void onContentScrollStopped();

    void onWindowVisibilityChanged(int i);

    void showForSystem();
}

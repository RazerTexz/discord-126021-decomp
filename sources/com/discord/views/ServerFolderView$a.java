package com.discord.views;

import android.view.animation.Animation;
import android.view.animation.Animation$AnimationListener;

/* JADX INFO: compiled from: ServerFolderView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerFolderView$a implements Animation$AnimationListener {
    public final /* synthetic */ ServerFolderView j;

    public ServerFolderView$a(ServerFolderView serverFolderView) {
        this.j = serverFolderView;
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationEnd(Animation animation) {
        ServerFolderView serverFolderView = this.j;
        int i = ServerFolderView.j;
        serverFolderView.a();
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}

package b.a.d;

import com.discord.app.AppActivity;

/* JADX INFO: renamed from: b.a.d.i, reason: use source file name */
/* JADX INFO: compiled from: AppScreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppScreen implements Runnable {
    public final /* synthetic */ AppActivity j;

    public AppScreen(AppActivity appActivity) {
        this.j = appActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.recreate();
    }
}

package p007b.p008a.p018d;

import com.discord.app.AppActivity;

/* JADX INFO: renamed from: b.a.d.i */
/* JADX INFO: compiled from: AppScreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0868i implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AppActivity f517j;

    public RunnableC0868i(AppActivity appActivity) {
        this.f517j = appActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f517j.recreate();
    }
}

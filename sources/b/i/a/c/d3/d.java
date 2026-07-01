package b.i.a.c.d3;

import com.google.android.exoplayer2.ui.PlayerControlView;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ PlayerControlView j;

    public /* synthetic */ d(PlayerControlView playerControlView) {
        this.j = playerControlView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PlayerControlView playerControlView = this.j;
        int i = PlayerControlView.j;
        playerControlView.n();
    }
}

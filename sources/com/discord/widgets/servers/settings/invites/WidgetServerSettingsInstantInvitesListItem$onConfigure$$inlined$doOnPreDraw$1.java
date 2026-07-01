package com.discord.widgets.servers.settings.invites;

import android.view.View;
import com.discord.utilities.dimen.DimenUtils;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvitesListItem$onConfigure$$inlined$doOnPreDraw$1 implements Runnable {
    public final /* synthetic */ View $this_doOnPreDraw;

    public WidgetServerSettingsInstantInvitesListItem$onConfigure$$inlined$doOnPreDraw$1(View view) {
        this.$this_doOnPreDraw = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View view = this.$this_doOnPreDraw;
        view.setMinimumWidth(DimenUtils.dpToPixels(4) + view.getWidth());
    }
}

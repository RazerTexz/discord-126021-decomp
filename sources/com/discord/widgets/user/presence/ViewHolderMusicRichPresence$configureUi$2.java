package com.discord.widgets.user.presence;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.api.activity.Activity;
import com.discord.utilities.integrations.SpotifyHelper;

/* JADX INFO: compiled from: ViewHolderMusicRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewHolderMusicRichPresence$configureUi$2 implements View$OnClickListener {
    public final /* synthetic */ Activity $activity;

    public ViewHolderMusicRichPresence$configureUi$2(Activity activity) {
        this.$activity = activity;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        SpotifyHelper.INSTANCE.launchTrack(a.x(view, "it", "it.context"), this.$activity);
    }
}

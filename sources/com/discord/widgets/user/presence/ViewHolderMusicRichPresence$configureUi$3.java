package com.discord.widgets.user.presence;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.api.activity.Activity;
import com.discord.models.user.User;
import com.discord.utilities.integrations.SpotifyHelper;

/* JADX INFO: compiled from: ViewHolderMusicRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewHolderMusicRichPresence$configureUi$3 implements View$OnClickListener {
    public final /* synthetic */ Activity $activity;
    public final /* synthetic */ boolean $isMe;
    public final /* synthetic */ User $user;

    public ViewHolderMusicRichPresence$configureUi$3(Activity activity, User user, boolean z2) {
        this.$activity = activity;
        this.$user = user;
        this.$isMe = z2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        SpotifyHelper spotifyHelper = SpotifyHelper.INSTANCE;
        Context contextX = a.x(view, "it", "it.context");
        Activity activity = this.$activity;
        User user = this.$user;
        spotifyHelper.launchAlbum(contextX, activity, user != null ? user.getId() : 0L, this.$isMe);
    }
}

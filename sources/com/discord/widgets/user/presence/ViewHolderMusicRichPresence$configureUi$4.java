package com.discord.widgets.user.presence;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.integrations.SpotifyHelper;
import d0.z.d.m;

/* JADX INFO: compiled from: ViewHolderMusicRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewHolderMusicRichPresence$configureUi$4 implements View$OnClickListener {
    public static final ViewHolderMusicRichPresence$configureUi$4 INSTANCE = new ViewHolderMusicRichPresence$configureUi$4();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        SpotifyHelper spotifyHelper = SpotifyHelper.INSTANCE;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        spotifyHelper.openPlayStoreForSpotify(context);
    }
}

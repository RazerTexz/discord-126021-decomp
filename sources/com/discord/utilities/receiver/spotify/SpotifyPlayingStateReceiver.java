package com.discord.utilities.receiver.spotify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: SpotifyPlayingStateReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpotifyPlayingStateReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        StoreStream.INSTANCE.getSpotify().setPlayingStatus(intent.getBooleanExtra("playing", false), intent.getIntExtra("playbackPosition", 0));
    }
}

package com.discord.utilities.integrations;

import android.content.Context;
import android.util.Log;
import d0.y.b;
import java.io.IOException;
import java.net.URL;

/* JADX INFO: compiled from: SpotifyHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpotifyHelper$openPlayStoreForSpotify$1 implements Runnable {
    public final /* synthetic */ Context $context;

    public SpotifyHelper$openPlayStoreForSpotify$1(Context context) {
        this.$context = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            b.closeFinally(new URL("https://app.adjust.com/ndjczk?campaign=" + this.$context.getPackageName()).openStream(), null);
        } catch (IOException e) {
            Log.w("SPOTIFY", "Couldn't open tracking url", e);
        }
    }
}

package com.discord.utilities.integrations;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager$NameNotFoundException;
import android.net.Uri;
import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.api.activity.Activity;
import com.discord.utilities.receiver.spotify.SpotifyMetadataReceiver;
import com.discord.utilities.receiver.spotify.SpotifyPlayingStateReceiver;
import com.discord.utilities.uri.UriHandler;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: SpotifyHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpotifyHelper {
    public static final SpotifyHelper INSTANCE = new SpotifyHelper();
    private static final String SPOTIFY_PACKAGE_NAME = "com.spotify.music";
    private static final String SPOTIFY_UTM_PARAMS = "utm_source=discord&utm_medium=mobile";

    private SpotifyHelper() {
    }

    public static final /* synthetic */ void access$launchSpotifyIntent(SpotifyHelper spotifyHelper, Context context, Intent intent) {
        spotifyHelper.launchSpotifyIntent(context, intent);
    }

    private final void launchSpotifyIntent(Context context, Intent intent) {
        try {
            intent.putExtra("android.intent.extra.REFERRER", Uri.parse("android-app://" + context.getPackageName()));
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            if (isSpotifyInstalled(context)) {
                return;
            }
            openPlayStoreForSpotify(context);
        }
    }

    public static final void registerSpotifyBroadcastReceivers(Context context) {
        m.checkNotNullParameter(context, "context");
        context.registerReceiver(new SpotifyMetadataReceiver(), new IntentFilter("com.spotify.music.metadatachanged"));
        context.registerReceiver(new SpotifyPlayingStateReceiver(), new IntentFilter("com.spotify.music.playbackstatechanged"));
    }

    private final void runIfSpotifyInstalled(Function0<Unit> action, Context context) {
        try {
            action.invoke();
        } catch (ActivityNotFoundException unused) {
            if (isSpotifyInstalled(context)) {
                return;
            }
            openPlayStoreForSpotify(context);
        }
    }

    public final boolean isSpotifyInstalled(Context context) {
        m.checkNotNullParameter(context, "context");
        try {
            context.getPackageManager().getPackageInfo(SPOTIFY_PACKAGE_NAME, 0);
            return true;
        } catch (PackageManager$NameNotFoundException unused) {
            return false;
        }
    }

    public final void launchAlbum(Context context, Activity activity, long userId, boolean isMe) {
        String sessionId;
        Long applicationId;
        m.checkNotNullParameter(context, "context");
        if (isMe) {
            openSpotifyApp(context);
        } else {
            if (activity == null || (sessionId = activity.getSessionId()) == null || (applicationId = activity.getApplicationId()) == null) {
                return;
            }
            runIfSpotifyInstalled(new SpotifyHelper$launchAlbum$1(userId, sessionId, applicationId.longValue(), context), context);
        }
    }

    public final void launchTrack(Context context, Activity activity) {
        String syncId;
        m.checkNotNullParameter(context, "context");
        if (activity == null || (syncId = activity.getSyncId()) == null) {
            return;
        }
        INSTANCE.runIfSpotifyInstalled(new SpotifyHelper$launchTrack$$inlined$let$lambda$1(syncId, context), context);
    }

    public final void openPlayStoreForSpotify(Context context) {
        m.checkNotNullParameter(context, "context");
        new Thread(new SpotifyHelper$openPlayStoreForSpotify$1(context)).start();
        UriHandler.handle$default(UriHandler.INSTANCE, context, "https://play.google.com/store/apps/details?id=com.spotify.music&utm_source=discord&utm_medium=mobile", false, false, null, 28, null);
    }

    public final void openSpotifyApp(Context context) {
        m.checkNotNullParameter(context, "context");
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(SPOTIFY_PACKAGE_NAME);
        if (launchIntentForPackage != null) {
            context.startActivity(launchIntentForPackage);
        }
    }
}

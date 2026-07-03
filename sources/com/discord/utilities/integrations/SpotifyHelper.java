package com.discord.utilities.integrations;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityMetadata;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.receiver.spotify.SpotifyMetadataReceiver;
import com.discord.utilities.receiver.spotify.SpotifyPlayingStateReceiver;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.uri.UriHandler;
import java.io.IOException;
import java.net.URL;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p591y.C12201b;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: SpotifyHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpotifyHelper {
    public static final SpotifyHelper INSTANCE = new SpotifyHelper();
    private static final String SPOTIFY_PACKAGE_NAME = "com.spotify.music";
    private static final String SPOTIFY_UTM_PARAMS = "utm_source=discord&utm_medium=mobile";

    /* JADX INFO: renamed from: com.discord.utilities.integrations.SpotifyHelper$launchAlbum$1 */
    /* JADX INFO: compiled from: SpotifyHelper.kt */
    public static final class C67811 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $applicationId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ String $sessionId;
        public final /* synthetic */ long $userId;

        /* JADX INFO: renamed from: com.discord.utilities.integrations.SpotifyHelper$launchAlbum$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: SpotifyHelper.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<ActivityMetadata, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ActivityMetadata activityMetadata) {
                invoke2(activityMetadata);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ActivityMetadata activityMetadata) {
                String albumId;
                if (activityMetadata == null || (albumId = activityMetadata.getAlbumId()) == null) {
                    return;
                }
                SpotifyHelper.INSTANCE.launchSpotifyIntent(C67811.this.$context, new Intent("android.intent.action.VIEW", Uri.parse("spotify:album:" + Uri.encode(albumId) + "?utm_source=discord&utm_medium=mobile")));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67811(long j, String str, long j2, Context context) {
            super(0);
            this.$userId = j;
            this.$sessionId = str;
            this.$applicationId = j2;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getActivityMetadata(this.$userId, this.$sessionId, this.$applicationId), false, 1, null)), (117 & 1) != 0 ? null : this.$context, "REST: Spotify GetActivityMetadata", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new AnonymousClass1(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
        }
    }

    private SpotifyHelper() {
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
        C12238m.checkNotNullParameter(context, "context");
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
        C12238m.checkNotNullParameter(context, "context");
        try {
            context.getPackageManager().getPackageInfo(SPOTIFY_PACKAGE_NAME, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final void launchAlbum(Context context, Activity activity, long userId, boolean isMe) {
        String sessionId;
        Long applicationId;
        C12238m.checkNotNullParameter(context, "context");
        if (isMe) {
            openSpotifyApp(context);
        } else {
            if (activity == null || (sessionId = activity.getSessionId()) == null || (applicationId = activity.getApplicationId()) == null) {
                return;
            }
            runIfSpotifyInstalled(new C67811(userId, sessionId, applicationId.longValue(), context), context);
        }
    }

    public final void launchTrack(Context context, Activity activity) {
        String syncId;
        C12238m.checkNotNullParameter(context, "context");
        if (activity == null || (syncId = activity.getSyncId()) == null) {
            return;
        }
        INSTANCE.runIfSpotifyInstalled(new SpotifyHelper$launchTrack$$inlined$let$lambda$1(syncId, context), context);
    }

    public final void openPlayStoreForSpotify(final Context context) {
        C12238m.checkNotNullParameter(context, "context");
        new Thread(new Runnable() { // from class: com.discord.utilities.integrations.SpotifyHelper.openPlayStoreForSpotify.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    C12201b.closeFinally(new URL("https://app.adjust.com/ndjczk?campaign=" + context.getPackageName()).openStream(), null);
                } catch (IOException e) {
                    Log.w("SPOTIFY", "Couldn't open tracking url", e);
                }
            }
        }).start();
        UriHandler.handle$default(UriHandler.INSTANCE, context, "https://play.google.com/store/apps/details?id=com.spotify.music&utm_source=discord&utm_medium=mobile", false, false, null, 28, null);
    }

    public final void openSpotifyApp(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(SPOTIFY_PACKAGE_NAME);
        if (launchIntentForPackage != null) {
            context.startActivity(launchIntentForPackage);
        }
    }
}

package com.discord.utilities.integrations;

import android.content.Intent;
import android.net.Uri;
import com.discord.api.activity.ActivityMetadata;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SpotifyHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpotifyHelper$launchAlbum$1$1 extends o implements Function1<ActivityMetadata, Unit> {
    public final /* synthetic */ SpotifyHelper$launchAlbum$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpotifyHelper$launchAlbum$1$1(SpotifyHelper$launchAlbum$1 spotifyHelper$launchAlbum$1) {
        super(1);
        this.this$0 = spotifyHelper$launchAlbum$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ActivityMetadata activityMetadata) {
        invoke2(activityMetadata);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ActivityMetadata activityMetadata) {
        String albumId;
        if (activityMetadata == null || (albumId = activityMetadata.getAlbumId()) == null) {
            return;
        }
        SpotifyHelper.access$launchSpotifyIntent(SpotifyHelper.INSTANCE, this.this$0.$context, new Intent("android.intent.action.VIEW", Uri.parse("spotify:album:" + Uri.encode(albumId) + "?utm_source=discord&utm_medium=mobile")));
    }
}

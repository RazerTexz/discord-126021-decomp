package com.discord.utilities.integrations;

import android.content.Context;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SpotifyHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpotifyHelper$launchAlbum$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $applicationId;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $sessionId;
    public final /* synthetic */ long $userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpotifyHelper$launchAlbum$1(long j, String str, long j2, Context context) {
        super(0);
        this.$userId = j;
        this.$sessionId = str;
        this.$applicationId = j2;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getActivityMetadata(this.$userId, this.$sessionId, this.$applicationId), false, 1, null)), this.$context, "REST: Spotify GetActivityMetadata", (Function1) null, new SpotifyHelper$launchAlbum$1$1(this), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
    }
}

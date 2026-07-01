package com.discord.utilities.streams;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelApplicationStream$CallStream;
import com.discord.models.domain.ModelApplicationStream$GuildStream;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableCombineLatestOverloadsKt;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import kotlin.NoWhenBranchMatchedException;
import rx.Observable;

/* JADX INFO: compiled from: StreamContextService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StreamContextService$getForUser$1<T, R> implements b<ModelApplicationStream, Observable<? extends StreamContext>> {
    public final /* synthetic */ boolean $includePreview;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ StreamContextService this$0;

    public StreamContextService$getForUser$1(StreamContextService streamContextService, boolean z2, long j) {
        this.this$0 = streamContextService;
        this.$includePreview = z2;
        this.$userId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends StreamContext> call(ModelApplicationStream modelApplicationStream) {
        return call2(modelApplicationStream);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends StreamContext> call2(ModelApplicationStream modelApplicationStream) {
        long guildId;
        if (modelApplicationStream == null) {
            return new k(null);
        }
        if (modelApplicationStream instanceof ModelApplicationStream$GuildStream) {
            guildId = ((ModelApplicationStream$GuildStream) modelApplicationStream).getGuildId();
        } else {
            if (!(modelApplicationStream instanceof ModelApplicationStream$CallStream)) {
                throw new NoWhenBranchMatchedException();
            }
            guildId = 0;
        }
        Observable<Guild> observableObserveGuild = StreamContextService.access$getGuildStore$p(this.this$0).observeGuild(guildId);
        StreamContextService streamContextService = this.this$0;
        Observable observableAccess$getPreviewObservable = StreamContextService.access$getPreviewObservable(streamContextService, modelApplicationStream, this.$includePreview, StreamContextService.access$getApplicationStreamPreviewStore$p(streamContextService));
        Observable<Long> observableObservePermissionsForChannel = StreamContextService.access$getPermissionsStore$p(this.this$0).observePermissionsForChannel(modelApplicationStream.getChannelId());
        Observable<User> observableObserveUser = StreamContextService.access$getUserStore$p(this.this$0).observeUser(this.$userId);
        Observable observableObserveMe$default = StoreUser.observeMe$default(StreamContextService.access$getUserStore$p(this.this$0), false, 1, null);
        Observable<R> observableR = StreamContextService.access$getGuildStore$p(this.this$0).observeComputed(guildId).G(new StreamContextService$getForUser$1$1(this)).G(StreamContextService$getForUser$1$2.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "guildStore\n             …  .distinctUntilChanged()");
        return ObservableCombineLatestOverloadsKt.combineLatest(observableObserveGuild, observableAccess$getPreviewObservable, observableObservePermissionsForChannel, observableObserveUser, observableObserveMe$default, observableR, StreamContextService.access$getVoiceStateStore$p(this.this$0).observe(guildId, modelApplicationStream.getChannelId()), StreamContextService.access$getChannelStore$p(this.this$0).observeChannel(modelApplicationStream.getChannelId()), StreamContextService.access$getVoiceChannelSelectedStore$p(this.this$0).observeSelectedVoiceChannelId(), StreamContextService.access$getApplicationStreamingStore$p(this.this$0).observeActiveStream(), new StreamContextService$getForUser$1$3(modelApplicationStream));
    }
}

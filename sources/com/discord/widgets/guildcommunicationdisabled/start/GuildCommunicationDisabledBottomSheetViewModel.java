package com.discord.widgets.guildcommunicationdisabled.start;

import android.content.Context;
import b.a.d.d0;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.m;
import j0.p.a;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GuildCommunicationDisabledBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildCommunicationDisabledBottomSheetViewModel extends d0<GuildCommunicationDisabledBottomSheetViewModel$ViewState> {
    public static final GuildCommunicationDisabledBottomSheetViewModel$Companion Companion = new GuildCommunicationDisabledBottomSheetViewModel$Companion(null);

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildCommunicationDisabledBottomSheetViewModel(long j, long j2, ObservationDeck observationDeck, StoreGuilds storeGuilds, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        ObservationDeck observationDeck2 = (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck;
        StoreGuilds guilds = (i & 8) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        this(j, j2, observationDeck2, guilds, (i & 16) != 0 ? GuildCommunicationDisabledBottomSheetViewModel$Companion.access$observeStores(Companion, j, j2, observationDeck2, guilds) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(GuildCommunicationDisabledBottomSheetViewModel guildCommunicationDisabledBottomSheetViewModel, GuildCommunicationDisabledBottomSheetViewModel$StoreState guildCommunicationDisabledBottomSheetViewModel$StoreState) {
        guildCommunicationDisabledBottomSheetViewModel.handleStoreState(guildCommunicationDisabledBottomSheetViewModel$StoreState);
    }

    private final void handleStoreState(GuildCommunicationDisabledBottomSheetViewModel$StoreState storeState) {
        Guild guild = storeState.getGuild();
        GuildMember guildMember = storeState.getGuildMember();
        if (guild == null || guildMember == null) {
            updateViewState(GuildCommunicationDisabledBottomSheetViewModel$ViewState$Invalid.INSTANCE);
        } else {
            UtcDateTime communicationDisabledUntil = guildMember.getCommunicationDisabledUntil();
            updateViewState(new GuildCommunicationDisabledBottomSheetViewModel$ViewState$Valid(communicationDisabledUntil != null ? communicationDisabledUntil.getDateTimeMillis() - ClockFactory.get().currentTimeMillis() : 0L, guild.getName()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildCommunicationDisabledBottomSheetViewModel(long j, long j2, ObservationDeck observationDeck, StoreGuilds storeGuilds, Observable<GuildCommunicationDisabledBottomSheetViewModel$StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(storeGuilds, "guildStore");
        m.checkNotNullParameter(observable, "storeStateObservable");
        Observable observableJ = Observable.j(Observable.F(0L, 1L, TimeUnit.SECONDS, a.a()), observable, GuildCommunicationDisabledBottomSheetViewModel$1.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…->\n      storeState\n    }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableJ), this, null, 2, null), GuildCommunicationDisabledBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildCommunicationDisabledBottomSheetViewModel$2(this), 62, (Object) null);
    }
}

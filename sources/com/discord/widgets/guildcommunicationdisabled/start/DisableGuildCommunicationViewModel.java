package com.discord.widgets.guildcommunicationdisabled.start;

import android.content.Context;
import b.a.d.d0;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams$DisableGuildCommunication;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: DisableGuildCommunicationViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DisableGuildCommunicationViewModel extends d0<DisableGuildCommunicationViewModel$ViewState> {
    public static final DisableGuildCommunicationViewModel$Companion Companion = new DisableGuildCommunicationViewModel$Companion(null);
    private final long guildId;
    private final long userId;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DisableGuildCommunicationViewModel(long j, long j2, ObservationDeck observationDeck, StoreUser storeUser, StoreGuilds storeGuilds, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        ObservationDeck observationDeck2 = (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck;
        StoreUser users = (i & 8) != 0 ? StoreStream.Companion.getUsers() : storeUser;
        StoreGuilds guilds = (i & 16) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        this(j, j2, observationDeck2, users, guilds, (i & 32) != 0 ? DisableGuildCommunicationViewModel$Companion.access$observeStores(Companion, j, j2, observationDeck2, users, guilds) : observable);
    }

    public static final /* synthetic */ long access$getGuildId$p(DisableGuildCommunicationViewModel disableGuildCommunicationViewModel) {
        return disableGuildCommunicationViewModel.guildId;
    }

    public static final /* synthetic */ long access$getUserId$p(DisableGuildCommunicationViewModel disableGuildCommunicationViewModel) {
        return disableGuildCommunicationViewModel.userId;
    }

    public static final /* synthetic */ void access$handleStoreState(DisableGuildCommunicationViewModel disableGuildCommunicationViewModel, DisableGuildCommunicationViewModel$StoreState disableGuildCommunicationViewModel$StoreState) {
        disableGuildCommunicationViewModel.handleStoreState(disableGuildCommunicationViewModel$StoreState);
    }

    private final void handleStoreState(DisableGuildCommunicationViewModel$StoreState storeState) {
        TimeDurationDisabledCommunication selectedDurationOption;
        DisableGuildCommunicationViewModel$ViewState disableGuildCommunicationViewModel$ViewState$Valid;
        DisableGuildCommunicationViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof DisableGuildCommunicationViewModel$ViewState$Valid)) {
            viewState = null;
        }
        DisableGuildCommunicationViewModel$ViewState$Valid disableGuildCommunicationViewModel$ViewState$Valid2 = (DisableGuildCommunicationViewModel$ViewState$Valid) viewState;
        if (storeState.getGuild() == null) {
            disableGuildCommunicationViewModel$ViewState$Valid = DisableGuildCommunicationViewModel$ViewState$Invalid.INSTANCE;
        } else {
            User user = storeState.getUser();
            long id2 = storeState.getGuild().getId();
            if (disableGuildCommunicationViewModel$ViewState$Valid2 == null || (selectedDurationOption = disableGuildCommunicationViewModel$ViewState$Valid2.getSelectedDurationOption()) == null) {
                selectedDurationOption = TimeDurationDisabledCommunication.SECONDS_60;
            }
            disableGuildCommunicationViewModel$ViewState$Valid = new DisableGuildCommunicationViewModel$ViewState$Valid(user, id2, selectedDurationOption);
        }
        updateViewState(disableGuildCommunicationViewModel$ViewState$Valid);
    }

    public final void onDisableCommunicationConfirm(WeakReference<Context> context, String reason, Function0<Unit> onFinished) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(onFinished, "onFinished");
        DisableGuildCommunicationViewModel$ViewState viewState = getViewState();
        if (viewState instanceof DisableGuildCommunicationViewModel$ViewState$Valid) {
            DisableGuildCommunicationViewModel$ViewState$Valid disableGuildCommunicationViewModel$ViewState$Valid = (DisableGuildCommunicationViewModel$ViewState$Valid) viewState;
            Pair<String, Long> futureTimestamp = GuildCommunicationDisabledDateUtils.INSTANCE.getFutureTimestamp(disableGuildCommunicationViewModel$ViewState$Valid.getSelectedDurationOption().getDurationMs());
            String strComponent1 = futureTimestamp.component1();
            long jLongValue = futureTimestamp.component2().longValue();
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(RestCallStateKt.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().disableGuildCommunication(this.guildId, this.userId, new RestAPIParams$DisableGuildCommunication(strComponent1), reason), false, 1, null), new DisableGuildCommunicationViewModel$onDisableCommunicationConfirm$1(this, ((long) disableGuildCommunicationViewModel$ViewState$Valid.getSelectedDurationOption().getDurationMs()) / 1000, jLongValue, reason)), this, null, 2, null), DisableGuildCommunicationViewModel.class, context.get(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new DisableGuildCommunicationViewModel$onDisableCommunicationConfirm$2(onFinished), 60, (Object) null);
        }
    }

    public final void onDurationLengthSelected(TimeDurationDisabledCommunication duration) {
        m.checkNotNullParameter(duration, "duration");
        DisableGuildCommunicationViewModel$ViewState viewState = getViewState();
        if (viewState instanceof DisableGuildCommunicationViewModel$ViewState$Valid) {
            updateViewState(DisableGuildCommunicationViewModel$ViewState$Valid.copy$default((DisableGuildCommunicationViewModel$ViewState$Valid) viewState, null, 0L, duration, 3, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisableGuildCommunicationViewModel(long j, long j2, ObservationDeck observationDeck, StoreUser storeUser, StoreGuilds storeGuilds, Observable<DisableGuildCommunicationViewModel$StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(storeUser, "userStore");
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.userId = j;
        this.guildId = j2;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), DisableGuildCommunicationViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new DisableGuildCommunicationViewModel$1(this), 62, (Object) null);
    }
}

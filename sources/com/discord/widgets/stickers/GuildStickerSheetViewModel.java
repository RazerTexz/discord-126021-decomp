package com.discord.widgets.stickers;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import b.a.d.d0;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.guilds.join.GuildJoinHelperKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildStickerSheetViewModel extends d0<GuildStickerSheetViewModel$ViewState> {
    public static final GuildStickerSheetViewModel$Companion Companion = new GuildStickerSheetViewModel$Companion(null);
    private final RestAPI restAPI;
    private final Sticker sticker;
    private final StoreUser storeUser;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildStickerSheetViewModel(Sticker sticker, RestAPI restAPI, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreGuilds storeGuilds, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 2) != 0 ? RestAPI.Companion.getApi() : restAPI;
        StoreUser users = (i & 4) != 0 ? StoreStream.Companion.getUsers() : storeUser;
        StoreChannelsSelected channelsSelected = (i & 8) != 0 ? StoreStream.Companion.getChannelsSelected() : storeChannelsSelected;
        StoreGuilds guilds = (i & 16) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        this(sticker, api, users, channelsSelected, guilds, (i & 32) != 0 ? GuildStickerSheetViewModel$Companion.access$observeStoreState(Companion, api, sticker, users, channelsSelected, guilds) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(GuildStickerSheetViewModel guildStickerSheetViewModel, GuildStickerSheetViewModel$StoreState guildStickerSheetViewModel$StoreState) {
        guildStickerSheetViewModel.handleStoreState(guildStickerSheetViewModel$StoreState);
    }

    public static final /* synthetic */ void access$updateViewState(GuildStickerSheetViewModel guildStickerSheetViewModel, GuildStickerSheetViewModel$ViewState guildStickerSheetViewModel$ViewState) {
        guildStickerSheetViewModel.updateViewState(guildStickerSheetViewModel$ViewState);
    }

    @MainThread
    private final void handleStoreState(GuildStickerSheetViewModel$StoreState storeState) {
        updateViewState(new GuildStickerSheetViewModel$ViewState$Loaded(this.sticker, UserUtils.INSTANCE.getCanUsePremiumStickers(storeState.getMeUser()), m.areEqual(storeState.getCurrentGuildId(), this.sticker.getGuildId()), storeState.getGuildStickerGuildInfo()));
    }

    public final void joinGuild(Guild guild, Fragment fragment) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(fragment, "fragment");
        Context contextRequireContext = fragment.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "fragment.requireContext()");
        GuildJoinHelperKt.joinGuild$default(contextRequireContext, guild.getId(), false, null, null, null, GuildStickerSheetViewModel.class, null, null, null, new GuildStickerSheetViewModel$joinGuild$1(this), 952, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildStickerSheetViewModel(Sticker sticker, RestAPI restAPI, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreGuilds storeGuilds, Observable<GuildStickerSheetViewModel$StoreState> observable) {
        super(GuildStickerSheetViewModel$ViewState$Loading.INSTANCE);
        m.checkNotNullParameter(sticker, "sticker");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.sticker = sticker;
        this.restAPI = restAPI;
        this.storeUser = storeUser;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), GuildStickerSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildStickerSheetViewModel$1(this), 62, (Object) null);
    }
}

package com.discord.widgets.emoji;

import android.content.Context;
import androidx.fragment.app.Fragment;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreEmojiCustom;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMediaFavorites;
import com.discord.stores.StoreMediaFavorites$Favorite;
import com.discord.stores.StoreMediaFavorites$Favorite$FavCustomEmoji;
import com.discord.stores.StoreMediaFavorites$Favorite$FavUnicodeEmoji;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType$Custom;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType$Unicode;
import com.discord.widgets.guilds.join.GuildJoinHelperKt;
import d0.z.d.m;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: EmojiSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiSheetViewModel extends d0<EmojiSheetViewModel$ViewState> {
    public static final EmojiSheetViewModel$Companion Companion = new EmojiSheetViewModel$Companion(null);
    private final EmojiNode$EmojiIdAndType emojiIdAndType;
    private final RestAPI restAPI;
    private final StoreAnalytics storeAnalytics;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreEmoji storeEmoji;
    private final StoreEmojiCustom storeEmojiCustom;
    private final StoreGuilds storeGuilds;
    private final StoreMediaFavorites storeMediaFavorites;
    private final StoreUser storeUsers;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ EmojiSheetViewModel(EmojiNode$EmojiIdAndType emojiNode$EmojiIdAndType, RestAPI restAPI, StoreEmoji storeEmoji, StoreEmojiCustom storeEmojiCustom, StoreAnalytics storeAnalytics, StoreUser storeUser, StoreGuilds storeGuilds, StoreChannelsSelected storeChannelsSelected, StoreMediaFavorites storeMediaFavorites, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 2) != 0 ? RestAPI.Companion.getApi() : restAPI;
        StoreEmoji emojis = (i & 4) != 0 ? StoreStream.Companion.getEmojis() : storeEmoji;
        StoreEmojiCustom customEmojis = (i & 8) != 0 ? StoreStream.Companion.getCustomEmojis() : storeEmojiCustom;
        StoreAnalytics analytics = (i & 16) != 0 ? StoreStream.Companion.getAnalytics() : storeAnalytics;
        StoreUser users = (i & 32) != 0 ? StoreStream.Companion.getUsers() : storeUser;
        StoreGuilds guilds = (i & 64) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        StoreChannelsSelected channelsSelected = (i & 128) != 0 ? StoreStream.Companion.getChannelsSelected() : storeChannelsSelected;
        StoreMediaFavorites mediaFavorites = (i & 256) != 0 ? StoreStream.Companion.getMediaFavorites() : storeMediaFavorites;
        this(emojiNode$EmojiIdAndType, api, emojis, customEmojis, analytics, users, guilds, channelsSelected, mediaFavorites, (i & 512) != 0 ? EmojiSheetViewModel$Companion.access$observeStoreState(Companion, api, emojiNode$EmojiIdAndType, users, guilds, customEmojis, channelsSelected, mediaFavorites) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(EmojiSheetViewModel emojiSheetViewModel, EmojiSheetViewModel$StoreState emojiSheetViewModel$StoreState) {
        emojiSheetViewModel.handleStoreState(emojiSheetViewModel$StoreState);
    }

    public static final /* synthetic */ void access$updateViewState(EmojiSheetViewModel emojiSheetViewModel, EmojiSheetViewModel$ViewState emojiSheetViewModel$ViewState) {
        emojiSheetViewModel.updateViewState(emojiSheetViewModel$ViewState);
    }

    private final void customPopoutAnalytics(EmojiSheetViewModel$StoreState storeState) {
        EmojiNode$EmojiIdAndType emoji = storeState.getEmoji();
        Objects.requireNonNull(emoji, "null cannot be cast to non-null type com.discord.utilities.textprocessing.node.EmojiNode.EmojiIdAndType.Custom");
        EmojiNode$EmojiIdAndType$Custom emojiNode$EmojiIdAndType$Custom = (EmojiNode$EmojiIdAndType$Custom) emoji;
        EmojiSheetViewModel$Companion$CustomEmojGuildInfo customEmojiGuildInfo = storeState.getCustomEmojiGuildInfo();
        m.checkNotNull(customEmojiGuildInfo);
        boolean z2 = !customEmojiGuildInfo.getIsPublic();
        boolean isUserInGuild = customEmojiGuildInfo.getIsUserInGuild();
        boolean meUserIsPremium = storeState.getMeUserIsPremium();
        Channel currentChannel = storeState.getCurrentChannel();
        if (currentChannel != null) {
            this.storeAnalytics.openCustomEmojiPopout(currentChannel, emojiNode$EmojiIdAndType$Custom.getId(), meUserIsPremium, isUserInGuild, z2);
        }
    }

    private final void handleStoreState(EmojiSheetViewModel$StoreState storeState) {
        EmojiNode$EmojiIdAndType emoji = storeState.getEmoji();
        if (emoji instanceof EmojiNode$EmojiIdAndType$Unicode) {
            standardPopoutAnalytics(storeState);
            handleStoreStateUnicode(storeState);
        } else if (emoji instanceof EmojiNode$EmojiIdAndType$Custom) {
            customPopoutAnalytics(storeState);
            handleStoreStateCustom(storeState);
        }
    }

    private final void handleStoreStateCustom(EmojiSheetViewModel$StoreState storeState) {
        boolean z2;
        Guild guild;
        EmojiNode$EmojiIdAndType emoji = storeState.getEmoji();
        Objects.requireNonNull(emoji, "null cannot be cast to non-null type com.discord.utilities.textprocessing.node.EmojiNode.EmojiIdAndType.Custom");
        EmojiNode$EmojiIdAndType$Custom emojiNode$EmojiIdAndType$Custom = (EmojiNode$EmojiIdAndType$Custom) emoji;
        EmojiSheetViewModel$Companion$CustomEmojGuildInfo customEmojiGuildInfo = storeState.getCustomEmojiGuildInfo();
        m.checkNotNull(customEmojiGuildInfo);
        boolean zContains = storeState.getFavorites().contains(new StoreMediaFavorites$Favorite$FavCustomEmoji(emojiNode$EmojiIdAndType$Custom));
        boolean isUserInGuild = customEmojiGuildInfo.getIsUserInGuild();
        Channel currentChannel = storeState.getCurrentChannel();
        boolean z3 = false;
        if (currentChannel != null) {
            long guildId = currentChannel.getGuildId();
            EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Known emojiSheetViewModel$Companion$CustomEmojGuildInfo$Known = (EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Known) (!(customEmojiGuildInfo instanceof EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Known) ? null : customEmojiGuildInfo);
            if (emojiSheetViewModel$Companion$CustomEmojGuildInfo$Known != null && (guild = emojiSheetViewModel$Companion$CustomEmojGuildInfo$Known.getGuild()) != null && guild.getId() == guildId) {
                z3 = true;
            }
            z2 = z3;
        } else {
            z2 = false;
        }
        updateViewState(new EmojiSheetViewModel$ViewState$EmojiCustom(emojiNode$EmojiIdAndType$Custom, customEmojiGuildInfo, storeState.getMeUserIsPremium(), z2, isUserInGuild, zContains));
    }

    private final void handleStoreStateUnicode(EmojiSheetViewModel$StoreState storeState) {
        EmojiSheetViewModel$ViewState emojiSheetViewModel$ViewState$EmojiUnicode;
        EmojiNode$EmojiIdAndType emoji = storeState.getEmoji();
        Objects.requireNonNull(emoji, "null cannot be cast to non-null type com.discord.utilities.textprocessing.node.EmojiNode.EmojiIdAndType.Unicode");
        ModelEmojiUnicode modelEmojiUnicode = this.storeEmoji.getUnicodeEmojisNamesMap().get(((EmojiNode$EmojiIdAndType$Unicode) emoji).getName());
        if (modelEmojiUnicode != null) {
            emojiSheetViewModel$ViewState$EmojiUnicode = new EmojiSheetViewModel$ViewState$EmojiUnicode(modelEmojiUnicode, true, storeState.getFavorites().contains(new StoreMediaFavorites$Favorite$FavUnicodeEmoji(modelEmojiUnicode)));
        } else {
            emojiSheetViewModel$ViewState$EmojiUnicode = EmojiSheetViewModel$ViewState$Invalid.INSTANCE;
        }
        updateViewState(emojiSheetViewModel$ViewState$EmojiUnicode);
    }

    private final void standardPopoutAnalytics(EmojiSheetViewModel$StoreState storeState) {
        Channel currentChannel = storeState.getCurrentChannel();
        if (currentChannel != null) {
            this.storeAnalytics.openUnicodeEmojiPopout(currentChannel);
        }
    }

    public final void joinGuild(Guild guild, Fragment fragment) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(fragment, "fragment");
        Context contextRequireContext = fragment.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "fragment.requireContext()");
        GuildJoinHelperKt.joinGuild$default(contextRequireContext, guild.getId(), false, null, null, null, EmojiSheetViewModel.class, null, null, null, new EmojiSheetViewModel$joinGuild$1(this), 952, null);
    }

    public final void setFavorite(boolean favorite) {
        Object storeMediaFavorites$Favorite$FavUnicodeEmoji;
        EmojiSheetViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            if (viewState instanceof EmojiSheetViewModel$ViewState$EmojiCustom) {
                storeMediaFavorites$Favorite$FavUnicodeEmoji = new StoreMediaFavorites$Favorite$FavCustomEmoji(((EmojiSheetViewModel$ViewState$EmojiCustom) viewState).getEmojiCustom());
            } else if (!(viewState instanceof EmojiSheetViewModel$ViewState$EmojiUnicode)) {
                return;
            } else {
                storeMediaFavorites$Favorite$FavUnicodeEmoji = new StoreMediaFavorites$Favorite$FavUnicodeEmoji(((EmojiSheetViewModel$ViewState$EmojiUnicode) viewState).getEmojiUnicode());
            }
            Object exhaustive = KotlinExtensionsKt.getExhaustive(storeMediaFavorites$Favorite$FavUnicodeEmoji);
            if (favorite) {
                this.storeMediaFavorites.addFavorite((StoreMediaFavorites$Favorite) exhaustive);
            } else {
                this.storeMediaFavorites.removeFavorite((StoreMediaFavorites$Favorite) exhaustive);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiSheetViewModel(EmojiNode$EmojiIdAndType emojiNode$EmojiIdAndType, RestAPI restAPI, StoreEmoji storeEmoji, StoreEmojiCustom storeEmojiCustom, StoreAnalytics storeAnalytics, StoreUser storeUser, StoreGuilds storeGuilds, StoreChannelsSelected storeChannelsSelected, StoreMediaFavorites storeMediaFavorites, Observable<EmojiSheetViewModel$StoreState> observable) {
        super(EmojiSheetViewModel$ViewState$Loading.INSTANCE);
        m.checkNotNullParameter(emojiNode$EmojiIdAndType, "emojiIdAndType");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(storeEmoji, "storeEmoji");
        m.checkNotNullParameter(storeEmojiCustom, "storeEmojiCustom");
        m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        m.checkNotNullParameter(storeUser, "storeUsers");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        m.checkNotNullParameter(storeMediaFavorites, "storeMediaFavorites");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.emojiIdAndType = emojiNode$EmojiIdAndType;
        this.restAPI = restAPI;
        this.storeEmoji = storeEmoji;
        this.storeEmojiCustom = storeEmojiCustom;
        this.storeAnalytics = storeAnalytics;
        this.storeUsers = storeUser;
        this.storeGuilds = storeGuilds;
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeMediaFavorites = storeMediaFavorites;
        Observable observableR = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null).r();
        m.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, EmojiSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new EmojiSheetViewModel$1(this), 62, (Object) null);
    }
}

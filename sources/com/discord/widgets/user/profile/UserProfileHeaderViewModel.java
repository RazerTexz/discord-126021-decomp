package com.discord.widgets.user.profile;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.nullserializable.NullSerializable;
import com.discord.nullserializable.NullSerializable$b;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserProfile;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.user.presence.ModelRichPresence;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: UserProfileHeaderViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderViewModel extends d0<UserProfileHeaderViewModel$ViewState> {
    public static final UserProfileHeaderViewModel$Companion Companion = new UserProfileHeaderViewModel$Companion(null);
    public static final long ME = -1;
    private final long userId;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ UserProfileHeaderViewModel(long j, Long l, Long l2, Observable observable, boolean z2, StoreUser storeUser, StoreUserProfile storeUserProfile, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Long l3 = (i & 2) != 0 ? null : l;
        Long l4 = (i & 4) == 0 ? l2 : null;
        this(j, l3, l4, (i & 8) != 0 ? UserProfileHeaderViewModel$Companion.observeStoreState$default(Companion, j, l3, l4, null, null, null, null, null, null, null, null, null, 4088, null) : observable, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? StoreStream.Companion.getUsers() : storeUser, (i & 64) != 0 ? StoreStream.Companion.getUserProfile() : storeUserProfile);
    }

    public static final /* synthetic */ void access$handleStoreState(UserProfileHeaderViewModel userProfileHeaderViewModel, UserProfileHeaderViewModel$StoreState userProfileHeaderViewModel$StoreState) {
        userProfileHeaderViewModel.handleStoreState(userProfileHeaderViewModel$StoreState);
    }

    private final void handleStoreState(UserProfileHeaderViewModel$StoreState storeState) {
        List listEmptyList;
        long id2 = storeState.getUser().getId();
        GuildMember guildMember = storeState.getUserIdToGuildMemberMap().get(Long.valueOf(id2));
        NullSerializable<String> nullSerializableB = storeState.getUserProfile().getUser().b();
        if (!(nullSerializableB instanceof NullSerializable$b)) {
            nullSerializableB = null;
        }
        NullSerializable$b nullSerializable$b = (NullSerializable$b) nullSerializableB;
        String str = nullSerializable$b != null ? (String) nullSerializable$b.a() : null;
        Channel channel = storeState.getChannel();
        boolean z2 = channel != null && ChannelUtils.B(channel);
        UserProfileHeaderViewModel$ViewState viewState = getViewState();
        User user = storeState.getUser();
        NullSerializable<String> nullSerializableC = storeState.getUserProfile().getUser().c();
        String strA = nullSerializableC != null ? nullSerializableC.a() : null;
        if (z2) {
            Collection<Map<Long, GuildMember>> guildMembers = storeState.getGuildMembers();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = guildMembers.iterator();
            while (it.hasNext()) {
                GuildMember guildMember2 = (GuildMember) ((Map) it.next()).get(Long.valueOf(id2));
                if (guildMember2 != null) {
                    arrayList.add(guildMember2);
                }
            }
            listEmptyList = u.toList(arrayList);
        } else {
            listEmptyList = n.emptyList();
        }
        ModelRichPresence richPresence = storeState.getRichPresence();
        updateViewState(new UserProfileHeaderViewModel$ViewState$Loaded(user, str, strA, guildMember, listEmptyList, richPresence != null ? richPresence.getPresence() : null, storeState.getStreamContext(), storeState.getUserProfile(), UserUtils.INSTANCE.isPremium(storeState.getMe()), storeState.getMe().isVerified(), storeState.getAllowAnimatedEmojis(), true, false, storeState.getReducedMotionEnabled(), viewState instanceof UserProfileHeaderViewModel$ViewState$Loaded ? ((UserProfileHeaderViewModel$ViewState$Loaded) viewState).getAllowAnimationInReducedMotion() : false, id2 == storeState.getMe().getId(), 4096, null));
    }

    @MainThread
    public final void toggleAllowAnimationInReducedMotion() {
        UserProfileHeaderViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof UserProfileHeaderViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        UserProfileHeaderViewModel$ViewState$Loaded userProfileHeaderViewModel$ViewState$Loaded = (UserProfileHeaderViewModel$ViewState$Loaded) viewState;
        if (userProfileHeaderViewModel$ViewState$Loaded == null || !userProfileHeaderViewModel$ViewState$Loaded.getReducedMotionEnabled()) {
            return;
        }
        updateViewState(UserProfileHeaderViewModel$ViewState$Loaded.copy$default(userProfileHeaderViewModel$ViewState$Loaded, null, null, null, null, null, null, null, null, false, false, false, false, false, false, !userProfileHeaderViewModel$ViewState$Loaded.getAllowAnimationInReducedMotion(), false, 49151, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileHeaderViewModel(long j, Long l, Long l2, Observable<UserProfileHeaderViewModel$StoreState> observable, boolean z2, StoreUser storeUser, StoreUserProfile storeUserProfile) {
        super(UserProfileHeaderViewModel$ViewState$Uninitialized.INSTANCE);
        long j2 = j;
        m.checkNotNullParameter(observable, "storeObservable");
        m.checkNotNullParameter(storeUser, "storeUsers");
        m.checkNotNullParameter(storeUserProfile, "storeUserProfile");
        this.userId = j2;
        if (z2) {
            StoreUserProfile.fetchProfile$default(storeUserProfile, j2 == -1 ? storeUser.getMeSnapshot().getId() : j2, l2, false, null, 12, null);
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), UserProfileHeaderViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new UserProfileHeaderViewModel$1(this), 62, (Object) null);
    }
}

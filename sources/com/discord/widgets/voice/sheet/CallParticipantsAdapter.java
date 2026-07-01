package com.discord.widgets.voice.sheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.streams.StreamContext;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallParticipantsAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> {
    public static final CallParticipantsAdapter$Companion Companion = new CallParticipantsAdapter$Companion(null);
    private static final int VIEW_TYPE_DIVIDER = 3;
    private static final int VIEW_TYPE_EMBEDDED_ACTIVITY = 6;
    private static final int VIEW_TYPE_EVENT = 5;
    private static final int VIEW_TYPE_HEADER = 1;
    private static final int VIEW_TYPE_INVITE = 4;
    private static final int VIEW_TYPE_SPECTATORS_HEADER = 2;
    private static final int VIEW_TYPE_VOICE_USER = 0;
    private final boolean isCallPreview;
    private Function0<Unit> onEmbeddedActivityClicked;
    private Function1<? super GuildScheduledEvent, Unit> onEventClicked;
    private Function1<? super View, Unit> onInviteFriendsClicked;
    private Function1<? super GuildScheduledEvent, Unit> onStartEventClicked;
    private Function1<? super StreamContext, Unit> onStreamPreviewClicked;
    private Function1<? super StoreVoiceParticipants$VoiceUser, Unit> onToggleRingingClicked;
    private Function1<? super StoreVoiceParticipants$VoiceUser, Unit> onVoiceUserClicked;
    private final boolean quantizeUserAvatars;

    public /* synthetic */ CallParticipantsAdapter(RecyclerView recyclerView, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3);
    }

    public final Function0<Unit> getOnEmbeddedActivityClicked() {
        return this.onEmbeddedActivityClicked;
    }

    public final Function1<GuildScheduledEvent, Unit> getOnEventClicked() {
        return this.onEventClicked;
    }

    public final Function1<View, Unit> getOnInviteFriendsClicked() {
        return this.onInviteFriendsClicked;
    }

    public final Function1<GuildScheduledEvent, Unit> getOnStartEventClicked() {
        return this.onStartEventClicked;
    }

    public final Function1<StreamContext, Unit> getOnStreamPreviewClicked() {
        return this.onStreamPreviewClicked;
    }

    public final Function1<StoreVoiceParticipants$VoiceUser, Unit> getOnToggleRingingClicked() {
        return this.onToggleRingingClicked;
    }

    public final Function1<StoreVoiceParticipants$VoiceUser, Unit> getOnVoiceUserClicked() {
        return this.onVoiceUserClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnEmbeddedActivityClicked(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onEmbeddedActivityClicked = function0;
    }

    public final void setOnEventClicked(Function1<? super GuildScheduledEvent, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onEventClicked = function1;
    }

    public final void setOnInviteFriendsClicked(Function1<? super View, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onInviteFriendsClicked = function1;
    }

    public final void setOnStartEventClicked(Function1<? super GuildScheduledEvent, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onStartEventClicked = function1;
    }

    public final void setOnStreamPreviewClicked(Function1<? super StreamContext, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onStreamPreviewClicked = function1;
    }

    public final void setOnToggleRingingClicked(Function1<? super StoreVoiceParticipants$VoiceUser, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onToggleRingingClicked = function1;
    }

    public final void setOnVoiceUserClicked(Function1<? super StoreVoiceParticipants$VoiceUser, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onVoiceUserClicked = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallParticipantsAdapter(RecyclerView recyclerView, boolean z2, boolean z3) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.isCallPreview = z2;
        this.quantizeUserAvatars = z3;
        this.onVoiceUserClicked = CallParticipantsAdapter$onVoiceUserClicked$1.INSTANCE;
        this.onStreamPreviewClicked = CallParticipantsAdapter$onStreamPreviewClicked$1.INSTANCE;
        this.onToggleRingingClicked = CallParticipantsAdapter$onToggleRingingClicked$1.INSTANCE;
        this.onInviteFriendsClicked = CallParticipantsAdapter$onInviteFriendsClicked$1.INSTANCE;
        this.onEventClicked = CallParticipantsAdapter$onEventClicked$1.INSTANCE;
        this.onStartEventClicked = CallParticipantsAdapter$onStartEventClicked$1.INSTANCE;
        this.onEmbeddedActivityClicked = CallParticipantsAdapter$onEmbeddedActivityClicked$1.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
                return new CallParticipantsAdapter$ViewHolderUser(this, this.isCallPreview, this.quantizeUserAvatars);
            case 1:
                return new CallParticipantsAdapter$ViewHolderHeader(this);
            case 2:
                return new CallParticipantsAdapter$ViewHolderHeader(this);
            case 3:
                return new CallParticipantsAdapter$ViewHolderDivider(this);
            case 4:
                return new CallParticipantsAdapter$ViewHolderInvite(this, this.isCallPreview);
            case 5:
                return new CallParticipantsAdapter$ViewHolderEvent(this, this.isCallPreview);
            case 6:
                return new CallParticipantsAdapter$ViewHolderEmbeddedActivity(this, this.isCallPreview);
            default:
                throw invalidViewTypeException(viewType);
        }
    }
}

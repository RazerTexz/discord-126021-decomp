package com.discord.widgets.voice.sheet;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.a.y.PileView2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.voice.state.VoiceState;
import com.discord.databinding.VoiceUserListItemEmbeddedActivityBinding;
import com.discord.databinding.VoiceUserListItemEventBinding;
import com.discord.databinding.VoiceUserListItemHeaderBinding;
import com.discord.databinding.VoiceUserListItemInviteBinding;
import com.discord.databinding.VoiceUserListItemUserBinding;
import com.discord.models.commands.Application;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.colors.RepresentativeColors2;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.streams.StreamContext;
import com.discord.views.PileView;
import com.discord.views.StreamPreviewView;
import com.discord.views.VoiceUserView;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallParticipantsAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> {
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
    private Function1<? super StoreVoiceParticipants.VoiceUser, Unit> onToggleRingingClicked;
    private Function1<? super StoreVoiceParticipants.VoiceUser, Unit> onVoiceUserClicked;
    private final boolean quantizeUserAvatars;

    /* JADX INFO: compiled from: CallParticipantsAdapter.kt */
    public static abstract class ListItem implements MGRecyclerDataPayload {

        /* JADX INFO: compiled from: CallParticipantsAdapter.kt */
        public static final class Divider extends ListItem {
            public static final Divider INSTANCE = new Divider();
            private static final int type = 3;
            private static final String key = String.valueOf(3);

            private Divider() {
                super(null);
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return key;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return type;
            }
        }

        /* JADX INFO: compiled from: CallParticipantsAdapter.kt */
        public static final /* data */ class EmbeddedActivityItem extends ListItem {
            private final Application application;
            private final EmbeddedActivity embeddedActivity;
            private final String key;
            private final List<UserGuildMember> participants;
            private final int type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmbeddedActivityItem(EmbeddedActivity embeddedActivity, List<UserGuildMember> list, Application application) {
                super(null);
                Intrinsics3.checkNotNullParameter(embeddedActivity, "embeddedActivity");
                Intrinsics3.checkNotNullParameter(list, "participants");
                Intrinsics3.checkNotNullParameter(application, "application");
                this.embeddedActivity = embeddedActivity;
                this.participants = list;
                this.application = application;
                this.type = 6;
                this.key = String.valueOf(embeddedActivity.getApplicationId());
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ EmbeddedActivityItem copy$default(EmbeddedActivityItem embeddedActivityItem, EmbeddedActivity embeddedActivity, List list, Application application, int i, Object obj) {
                if ((i & 1) != 0) {
                    embeddedActivity = embeddedActivityItem.embeddedActivity;
                }
                if ((i & 2) != 0) {
                    list = embeddedActivityItem.participants;
                }
                if ((i & 4) != 0) {
                    application = embeddedActivityItem.application;
                }
                return embeddedActivityItem.copy(embeddedActivity, list, application);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final EmbeddedActivity getEmbeddedActivity() {
                return this.embeddedActivity;
            }

            public final List<UserGuildMember> component2() {
                return this.participants;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Application getApplication() {
                return this.application;
            }

            public final EmbeddedActivityItem copy(EmbeddedActivity embeddedActivity, List<UserGuildMember> participants, Application application) {
                Intrinsics3.checkNotNullParameter(embeddedActivity, "embeddedActivity");
                Intrinsics3.checkNotNullParameter(participants, "participants");
                Intrinsics3.checkNotNullParameter(application, "application");
                return new EmbeddedActivityItem(embeddedActivity, participants, application);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EmbeddedActivityItem)) {
                    return false;
                }
                EmbeddedActivityItem embeddedActivityItem = (EmbeddedActivityItem) other;
                return Intrinsics3.areEqual(this.embeddedActivity, embeddedActivityItem.embeddedActivity) && Intrinsics3.areEqual(this.participants, embeddedActivityItem.participants) && Intrinsics3.areEqual(this.application, embeddedActivityItem.application);
            }

            public final Application getApplication() {
                return this.application;
            }

            public final EmbeddedActivity getEmbeddedActivity() {
                return this.embeddedActivity;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final List<UserGuildMember> getParticipants() {
                return this.participants;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                EmbeddedActivity embeddedActivity = this.embeddedActivity;
                int iHashCode = (embeddedActivity != null ? embeddedActivity.hashCode() : 0) * 31;
                List<UserGuildMember> list = this.participants;
                int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
                Application application = this.application;
                return iHashCode2 + (application != null ? application.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("EmbeddedActivityItem(embeddedActivity=");
                sbU.append(this.embeddedActivity);
                sbU.append(", participants=");
                sbU.append(this.participants);
                sbU.append(", application=");
                sbU.append(this.application);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: CallParticipantsAdapter.kt */
        public static final /* data */ class Event extends ListItem {
            private final boolean canStartEvent;
            private final GuildScheduledEvent event;
            private final boolean isCurrentUserInCall;
            private final String key;
            private final int type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Event(GuildScheduledEvent guildScheduledEvent, boolean z2, boolean z3) {
                super(null);
                Intrinsics3.checkNotNullParameter(guildScheduledEvent, "event");
                this.event = guildScheduledEvent;
                this.canStartEvent = z2;
                this.isCurrentUserInCall = z3;
                this.type = 5;
                this.key = String.valueOf(5);
            }

            public static /* synthetic */ Event copy$default(Event event, GuildScheduledEvent guildScheduledEvent, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    guildScheduledEvent = event.event;
                }
                if ((i & 2) != 0) {
                    z2 = event.canStartEvent;
                }
                if ((i & 4) != 0) {
                    z3 = event.isCurrentUserInCall;
                }
                return event.copy(guildScheduledEvent, z2, z3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final GuildScheduledEvent getEvent() {
                return this.event;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getCanStartEvent() {
                return this.canStartEvent;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getIsCurrentUserInCall() {
                return this.isCurrentUserInCall;
            }

            public final Event copy(GuildScheduledEvent event, boolean canStartEvent, boolean isCurrentUserInCall) {
                Intrinsics3.checkNotNullParameter(event, "event");
                return new Event(event, canStartEvent, isCurrentUserInCall);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Event)) {
                    return false;
                }
                Event event = (Event) other;
                return Intrinsics3.areEqual(this.event, event.event) && this.canStartEvent == event.canStartEvent && this.isCurrentUserInCall == event.isCurrentUserInCall;
            }

            public final boolean getCanStartEvent() {
                return this.canStartEvent;
            }

            public final GuildScheduledEvent getEvent() {
                return this.event;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3 */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                GuildScheduledEvent guildScheduledEvent = this.event;
                int iHashCode = (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0) * 31;
                boolean z2 = this.canStartEvent;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode + r1) * 31;
                boolean z3 = this.isCurrentUserInCall;
                return i + (z3 ? 1 : z3);
            }

            public final boolean isCurrentUserInCall() {
                return this.isCurrentUserInCall;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Event(event=");
                sbU.append(this.event);
                sbU.append(", canStartEvent=");
                sbU.append(this.canStartEvent);
                sbU.append(", isCurrentUserInCall=");
                return outline.O(sbU, this.isCurrentUserInCall, ")");
            }
        }

        /* JADX INFO: compiled from: CallParticipantsAdapter.kt */
        public static final /* data */ class Header extends ListItem {
            private final String key;
            private final int stringResId;
            private final int type;

            public Header(@StringRes int i) {
                super(null);
                this.stringResId = i;
                this.type = 1;
                this.key = String.valueOf(i);
            }

            public static /* synthetic */ Header copy$default(Header header, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = header.stringResId;
                }
                return header.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getStringResId() {
                return this.stringResId;
            }

            public final Header copy(@StringRes int stringResId) {
                return new Header(stringResId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Header) && this.stringResId == ((Header) other).stringResId;
                }
                return true;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final int getStringResId() {
                return this.stringResId;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                return this.stringResId;
            }

            public String toString() {
                return outline.B(outline.U("Header(stringResId="), this.stringResId, ")");
            }
        }

        /* JADX INFO: compiled from: CallParticipantsAdapter.kt */
        public static final class Invite extends ListItem {
            public static final Invite INSTANCE = new Invite();
            private static final int type = 4;
            private static final String key = String.valueOf(4);

            private Invite() {
                super(null);
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return key;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return type;
            }
        }

        /* JADX INFO: compiled from: CallParticipantsAdapter.kt */
        public static final /* data */ class SpectatorsHeader extends ListItem {
            private final String key;
            private final String streamerName;
            private final int type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SpectatorsHeader(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "streamerName");
                this.streamerName = str;
                this.type = 2;
                this.key = "SpectatorsHeader";
            }

            public static /* synthetic */ SpectatorsHeader copy$default(SpectatorsHeader spectatorsHeader, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = spectatorsHeader.streamerName;
                }
                return spectatorsHeader.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getStreamerName() {
                return this.streamerName;
            }

            public final SpectatorsHeader copy(String streamerName) {
                Intrinsics3.checkNotNullParameter(streamerName, "streamerName");
                return new SpectatorsHeader(streamerName);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SpectatorsHeader) && Intrinsics3.areEqual(this.streamerName, ((SpectatorsHeader) other).streamerName);
                }
                return true;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final String getStreamerName() {
                return this.streamerName;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                String str = this.streamerName;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.J(outline.U("SpectatorsHeader(streamerName="), this.streamerName, ")");
            }
        }

        /* JADX INFO: compiled from: CallParticipantsAdapter.kt */
        public static final /* data */ class VoiceUser extends ListItem {
            private final boolean canRing;
            private final boolean isSpectatingSameStream;
            private final String key;
            private final StoreVoiceParticipants.VoiceUser participant;
            private final int type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public VoiceUser(StoreVoiceParticipants.VoiceUser voiceUser, boolean z2, boolean z3) {
                super(null);
                Intrinsics3.checkNotNullParameter(voiceUser, "participant");
                this.participant = voiceUser;
                this.canRing = z2;
                this.isSpectatingSameStream = z3;
                this.key = String.valueOf(voiceUser.getUser().getId());
            }

            public static /* synthetic */ VoiceUser copy$default(VoiceUser voiceUser, StoreVoiceParticipants.VoiceUser voiceUser2, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    voiceUser2 = voiceUser.participant;
                }
                if ((i & 2) != 0) {
                    z2 = voiceUser.canRing;
                }
                if ((i & 4) != 0) {
                    z3 = voiceUser.isSpectatingSameStream;
                }
                return voiceUser.copy(voiceUser2, z2, z3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final StoreVoiceParticipants.VoiceUser getParticipant() {
                return this.participant;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getCanRing() {
                return this.canRing;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getIsSpectatingSameStream() {
                return this.isSpectatingSameStream;
            }

            public final VoiceUser copy(StoreVoiceParticipants.VoiceUser participant, boolean canRing, boolean isSpectatingSameStream) {
                Intrinsics3.checkNotNullParameter(participant, "participant");
                return new VoiceUser(participant, canRing, isSpectatingSameStream);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof VoiceUser)) {
                    return false;
                }
                VoiceUser voiceUser = (VoiceUser) other;
                return Intrinsics3.areEqual(this.participant, voiceUser.participant) && this.canRing == voiceUser.canRing && this.isSpectatingSameStream == voiceUser.isSpectatingSameStream;
            }

            public final boolean getCanRing() {
                return this.canRing;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final StoreVoiceParticipants.VoiceUser getParticipant() {
                return this.participant;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3 */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                StoreVoiceParticipants.VoiceUser voiceUser = this.participant;
                int iHashCode = (voiceUser != null ? voiceUser.hashCode() : 0) * 31;
                boolean z2 = this.canRing;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode + r1) * 31;
                boolean z3 = this.isSpectatingSameStream;
                return i + (z3 ? 1 : z3);
            }

            public final boolean isSpectatingSameStream() {
                return this.isSpectatingSameStream;
            }

            public String toString() {
                StringBuilder sbU = outline.U("VoiceUser(participant=");
                sbU.append(this.participant);
                sbU.append(", canRing=");
                sbU.append(this.canRing);
                sbU.append(", isSpectatingSameStream=");
                return outline.O(sbU, this.isSpectatingSameStream, ")");
            }
        }

        private ListItem() {
        }

        public /* synthetic */ ListItem(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: CallParticipantsAdapter.kt */
    public static final class ViewHolderDivider extends MGRecyclerViewHolder<CallParticipantsAdapter, MGRecyclerDataPayload> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderDivider(CallParticipantsAdapter callParticipantsAdapter) {
            super(R.layout.voice_user_list_item_divider, callParticipantsAdapter);
            Intrinsics3.checkNotNullParameter(callParticipantsAdapter, "adapter");
        }
    }

    /* JADX INFO: compiled from: CallParticipantsAdapter.kt */
    public static final class ViewHolderEmbeddedActivity extends MGRecyclerViewHolder<CallParticipantsAdapter, MGRecyclerDataPayload> {
        private final VoiceUserListItemEmbeddedActivityBinding binding;
        private final MGImages.DistinctChangeDetector distinctChangeDetector;
        private final boolean isCallPreview;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderEmbeddedActivity(CallParticipantsAdapter callParticipantsAdapter, boolean z2) {
            super(R.layout.voice_user_list_item_embedded_activity, callParticipantsAdapter);
            Intrinsics3.checkNotNullParameter(callParticipantsAdapter, "adapter");
            this.isCallPreview = z2;
            View view = this.itemView;
            int i = R.id.app_icon;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.app_icon);
            if (simpleDraweeView != null) {
                i = R.id.app_name;
                TextView textView = (TextView) view.findViewById(R.id.app_name);
                if (textView != null) {
                    i = R.id.clickable_container;
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.clickable_container);
                    if (constraintLayout != null) {
                        i = R.id.participant_avatars;
                        PileView pileView = (PileView) view.findViewById(R.id.participant_avatars);
                        if (pileView != null) {
                            VoiceUserListItemEmbeddedActivityBinding voiceUserListItemEmbeddedActivityBinding = new VoiceUserListItemEmbeddedActivityBinding((FrameLayout) view, simpleDraweeView, textView, constraintLayout, pileView);
                            Intrinsics3.checkNotNullExpressionValue(voiceUserListItemEmbeddedActivityBinding, "VoiceUserListItemEmbedde…ityBinding.bind(itemView)");
                            this.binding = voiceUserListItemEmbeddedActivityBinding;
                            this.distinctChangeDetector = new MGImages.DistinctChangeDetector();
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ CallParticipantsAdapter access$getAdapter$p(ViewHolderEmbeddedActivity viewHolderEmbeddedActivity) {
            return (CallParticipantsAdapter) viewHolderEmbeddedActivity.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, MGRecyclerDataPayload data) {
            Drawable drawable;
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            ListItem.EmbeddedActivityItem embeddedActivityItem = (ListItem.EmbeddedActivityItem) data;
            Application application = embeddedActivityItem.getApplication();
            if (!this.isCallPreview) {
                FrameLayout frameLayout = this.binding.a;
                Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
                this.binding.a.setBackgroundColor(ColorCompat.getThemedColor(frameLayout.getContext(), R.attr.colorBackgroundPrimary));
            }
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.appName");
            textView.setText(application.getName());
            boolean z2 = application.getIcon() != null;
            SimpleDraweeView simpleDraweeView = this.binding.f2219b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.appIcon");
            if (z2) {
                drawable = null;
            } else {
                SimpleDraweeView simpleDraweeView2 = this.binding.f2219b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.appIcon");
                drawable = ContextCompat.getDrawable(simpleDraweeView2.getContext(), R.drawable.ic_activity_24dp);
            }
            simpleDraweeView.setBackground(drawable);
            String applicationIcon = IconUtils.INSTANCE.getApplicationIcon(application, DimenUtils.dpToPixels(32));
            SimpleDraweeView simpleDraweeView3 = this.binding.f2219b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.appIcon");
            MGImages.setImage$default(simpleDraweeView3, z2 ? applicationIcon : null, DimenUtils.dpToPixels(32), DimenUtils.dpToPixels(32), false, null, this.distinctChangeDetector, 48, null);
            List<UserGuildMember> participants = embeddedActivityItem.getParticipants();
            int iDpToPixels = DimenUtils.dpToPixels(16);
            Intrinsics3.checkNotNullParameter(participants, "userGuildMembers");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(participants, 10));
            for (UserGuildMember userGuildMember : participants) {
                arrayList.add(IconUtils.INSTANCE.getForGuildMemberOrUser(userGuildMember.getUser(), userGuildMember.getGuildMember(), Integer.valueOf(iDpToPixels), false));
            }
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new PileView.c(new PileView2((String) it.next()), null));
            }
            this.binding.e.setItems(arrayList2);
            this.binding.d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.CallParticipantsAdapter$ViewHolderEmbeddedActivity$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CallParticipantsAdapter.ViewHolderEmbeddedActivity.access$getAdapter$p(this.this$0).getOnEmbeddedActivityClicked().invoke();
                }
            });
        }
    }

    /* JADX INFO: compiled from: CallParticipantsAdapter.kt */
    public static final class ViewHolderEvent extends MGRecyclerViewHolder<CallParticipantsAdapter, MGRecyclerDataPayload> {
        private final VoiceUserListItemEventBinding binding;
        private final boolean isCallPreview;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderEvent(CallParticipantsAdapter callParticipantsAdapter, boolean z2) {
            super(R.layout.voice_user_list_item_event, callParticipantsAdapter);
            Intrinsics3.checkNotNullParameter(callParticipantsAdapter, "adapter");
            this.isCallPreview = z2;
            View view = this.itemView;
            GuildScheduledEventItemView guildScheduledEventItemView = (GuildScheduledEventItemView) view.findViewById(R.id.event_card);
            if (guildScheduledEventItemView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.event_card)));
            }
            VoiceUserListItemEventBinding voiceUserListItemEventBinding = new VoiceUserListItemEventBinding((FrameLayout) view, guildScheduledEventItemView);
            Intrinsics3.checkNotNullExpressionValue(voiceUserListItemEventBinding, "VoiceUserListItemEventBinding.bind(itemView)");
            this.binding = voiceUserListItemEventBinding;
        }

        public static final /* synthetic */ CallParticipantsAdapter access$getAdapter$p(ViewHolderEvent viewHolderEvent) {
            return (CallParticipantsAdapter) viewHolderEvent.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, final MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            if (data instanceof ListItem.Event) {
                ListItem.Event event = (ListItem.Event) data;
                this.binding.f2220b.configureInVoiceChannel(event.getEvent(), null, event.getCanStartEvent() && event.isCurrentUserInCall(), event.isCurrentUserInCall(), event.isCurrentUserInCall(), this.isCallPreview, new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.CallParticipantsAdapter$ViewHolderEvent$onConfigure$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CallParticipantsAdapter.ViewHolderEvent.access$getAdapter$p(this.this$0).getOnEventClicked().invoke(((CallParticipantsAdapter.ListItem.Event) data).getEvent());
                    }
                }, new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.CallParticipantsAdapter$ViewHolderEvent$onConfigure$2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CallParticipantsAdapter.ViewHolderEvent.access$getAdapter$p(this.this$0).getOnStartEventClicked().invoke(((CallParticipantsAdapter.ListItem.Event) data).getEvent());
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: CallParticipantsAdapter.kt */
    public static final class ViewHolderHeader extends MGRecyclerViewHolder<CallParticipantsAdapter, MGRecyclerDataPayload> {
        private final VoiceUserListItemHeaderBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderHeader(CallParticipantsAdapter callParticipantsAdapter) {
            super(R.layout.voice_user_list_item_header, callParticipantsAdapter);
            Intrinsics3.checkNotNullParameter(callParticipantsAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            TextView textView = (TextView) view;
            VoiceUserListItemHeaderBinding voiceUserListItemHeaderBinding = new VoiceUserListItemHeaderBinding(textView, textView);
            Intrinsics3.checkNotNullExpressionValue(voiceUserListItemHeaderBinding, "VoiceUserListItemHeaderBinding.bind(itemView)");
            this.binding = voiceUserListItemHeaderBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            if (data instanceof ListItem.Header) {
                this.binding.f2221b.setText(((ListItem.Header) data).getStringResId());
                return;
            }
            if (data instanceof ListItem.SpectatorsHeader) {
                TextView textView = this.binding.f2221b;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.voiceUserListItemHeaderLabel");
                TextView textView2 = this.binding.f2221b;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.voiceUserListItemHeaderLabel");
                textView.setText(FormatUtils.d(textView2, R.string.go_live_watching_user, new Object[]{((ListItem.SpectatorsHeader) data).getStreamerName()}, (4 & 4) != 0 ? FormatUtils.c.j : null));
            }
        }
    }

    /* JADX INFO: compiled from: CallParticipantsAdapter.kt */
    public static final class ViewHolderInvite extends MGRecyclerViewHolder<CallParticipantsAdapter, MGRecyclerDataPayload> {
        private final VoiceUserListItemInviteBinding binding;
        private final boolean isCallPreview;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderInvite(CallParticipantsAdapter callParticipantsAdapter, boolean z2) {
            super(R.layout.voice_user_list_item_invite, callParticipantsAdapter);
            Intrinsics3.checkNotNullParameter(callParticipantsAdapter, "adapter");
            this.isCallPreview = z2;
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            VoiceUserListItemInviteBinding voiceUserListItemInviteBinding = new VoiceUserListItemInviteBinding((LinearLayout) view);
            Intrinsics3.checkNotNullExpressionValue(voiceUserListItemInviteBinding, "VoiceUserListItemInviteBinding.bind(itemView)");
            this.binding = voiceUserListItemInviteBinding;
        }

        public static final /* synthetic */ CallParticipantsAdapter access$getAdapter$p(ViewHolderInvite viewHolderInvite) {
            return (CallParticipantsAdapter) viewHolderInvite.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            if (data instanceof ListItem.Invite) {
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.CallParticipantsAdapter$ViewHolderInvite$onConfigure$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Function1<View, Unit> onInviteFriendsClicked = CallParticipantsAdapter.ViewHolderInvite.access$getAdapter$p(this.this$0).getOnInviteFriendsClicked();
                        Intrinsics3.checkNotNullExpressionValue(view, "it");
                        onInviteFriendsClicked.invoke(view);
                    }
                });
                if (this.isCallPreview) {
                    return;
                }
                LinearLayout linearLayout = this.binding.a;
                Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
                this.binding.a.setBackgroundColor(ColorCompat.getThemedColor(linearLayout.getContext(), R.attr.colorBackgroundPrimary));
            }
        }
    }

    /* JADX INFO: compiled from: CallParticipantsAdapter.kt */
    public static final class ViewHolderUser extends MGRecyclerViewHolder<CallParticipantsAdapter, MGRecyclerDataPayload> {
        private final VoiceUserListItemUserBinding binding;
        private final boolean isCallPreview;
        private final boolean quantizeUserAvatar;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderUser(CallParticipantsAdapter callParticipantsAdapter, boolean z2, boolean z3) {
            super(R.layout.voice_user_list_item_user, callParticipantsAdapter);
            Intrinsics3.checkNotNullParameter(callParticipantsAdapter, "adapter");
            this.isCallPreview = z2;
            this.quantizeUserAvatar = z3;
            View view = this.itemView;
            int i = R.id.voice_user_list_item_deafen_indicator;
            ImageView imageView = (ImageView) view.findViewById(R.id.voice_user_list_item_deafen_indicator);
            if (imageView != null) {
                i = R.id.voice_user_list_item_live_indicator;
                TextView textView = (TextView) view.findViewById(R.id.voice_user_list_item_live_indicator);
                if (textView != null) {
                    i = R.id.voice_user_list_item_mute_indicator;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.voice_user_list_item_mute_indicator);
                    if (imageView2 != null) {
                        i = R.id.voice_user_list_item_spectating_indicator;
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.voice_user_list_item_spectating_indicator);
                        if (imageView3 != null) {
                            i = R.id.voice_user_list_item_toggle_ringing;
                            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.voice_user_list_item_toggle_ringing);
                            if (materialButton != null) {
                                i = R.id.voice_user_list_item_user_avatar;
                                VoiceUserView voiceUserView = (VoiceUserView) view.findViewById(R.id.voice_user_list_item_user_avatar);
                                if (voiceUserView != null) {
                                    i = R.id.voice_user_list_item_user_name;
                                    TextView textView2 = (TextView) view.findViewById(R.id.voice_user_list_item_user_name);
                                    if (textView2 != null) {
                                        i = R.id.voice_user_list_item_user_stream_preview;
                                        StreamPreviewView streamPreviewView = (StreamPreviewView) view.findViewById(R.id.voice_user_list_item_user_stream_preview);
                                        if (streamPreviewView != null) {
                                            i = R.id.voice_user_list_item_video_indicator;
                                            ImageView imageView4 = (ImageView) view.findViewById(R.id.voice_user_list_item_video_indicator);
                                            if (imageView4 != null) {
                                                VoiceUserListItemUserBinding voiceUserListItemUserBinding = new VoiceUserListItemUserBinding((LinearLayout) view, imageView, textView, imageView2, imageView3, materialButton, voiceUserView, textView2, streamPreviewView, imageView4);
                                                Intrinsics3.checkNotNullExpressionValue(voiceUserListItemUserBinding, "VoiceUserListItemUserBinding.bind(itemView)");
                                                this.binding = voiceUserListItemUserBinding;
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ CallParticipantsAdapter access$getAdapter$p(ViewHolderUser viewHolderUser) {
            return (CallParticipantsAdapter) viewHolderUser.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, MGRecyclerDataPayload data) {
            CharSequence charSequenceD;
            CharSequence charSequenceD2;
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            ListItem.VoiceUser voiceUser = (ListItem.VoiceUser) data;
            final StoreVoiceParticipants.VoiceUser participant = voiceUser.getParticipant();
            String colorId = RepresentativeColors2.getColorId(participant.getUser());
            if (this.quantizeUserAvatar) {
                this.binding.g.setOnBitmapLoadedListener(new CallParticipantsAdapter$ViewHolderUser$onConfigure$1(colorId));
            }
            if (!this.isCallPreview) {
                LinearLayout linearLayout = this.binding.a;
                Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
                this.binding.a.setBackgroundColor(ColorCompat.getThemedColor(linearLayout.getContext(), R.attr.colorBackgroundPrimary));
            }
            this.binding.g.a(participant, R.dimen.avatar_size_standard);
            TextView textView = this.binding.h;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.voiceUserListItemUserName");
            textView.setText(participant.getDisplayName());
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.CallParticipantsAdapter$ViewHolderUser$onConfigure$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CallParticipantsAdapter.ViewHolderUser.access$getAdapter$p(this.this$0).getOnVoiceUserClicked().invoke(participant);
                }
            });
            MaterialButton materialButton = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.voiceUserListItemToggleRinging");
            boolean z2 = false;
            materialButton.setVisibility(voiceUser.getCanRing() ? 0 : 8);
            MaterialButton materialButton2 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.voiceUserListItemToggleRinging");
            if (participant.isRinging()) {
                MaterialButton materialButton3 = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.voiceUserListItemToggleRinging");
                charSequenceD = FormatUtils.d(materialButton3, R.string.stop_ringing, new Object[0], (4 & 4) != 0 ? FormatUtils.c.j : null);
            } else {
                MaterialButton materialButton4 = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(materialButton4, "binding.voiceUserListItemToggleRinging");
                charSequenceD = FormatUtils.d(materialButton4, R.string.ring, new Object[0], (4 & 4) != 0 ? FormatUtils.c.j : null);
            }
            materialButton2.setText(charSequenceD);
            this.binding.f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.CallParticipantsAdapter$ViewHolderUser$onConfigure$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CallParticipantsAdapter.ViewHolderUser.access$getAdapter$p(this.this$0).getOnToggleRingingClicked().invoke(participant);
                }
            });
            MaterialButton materialButton5 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(materialButton5, "binding.voiceUserListItemToggleRinging");
            if (participant.isRinging()) {
                MaterialButton materialButton6 = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(materialButton6, "binding.voiceUserListItemToggleRinging");
                charSequenceD2 = FormatUtils.d(materialButton6, R.string.stop_ringing_username_a11y_label, new Object[]{participant.getDisplayName()}, (4 & 4) != 0 ? FormatUtils.c.j : null);
            } else {
                MaterialButton materialButton7 = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(materialButton7, "binding.voiceUserListItemToggleRinging");
                charSequenceD2 = FormatUtils.d(materialButton7, R.string.ring_username_a11y_label, new Object[]{participant.getDisplayName()}, (4 & 4) != 0 ? FormatUtils.c.j : null);
            }
            materialButton5.setContentDescription(charSequenceD2);
            if (!participant.isConnected() || participant.getVoiceState() == null) {
                ImageView imageView = this.binding.f2222b;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.voiceUserListItemDeafenIndicator");
                imageView.setVisibility(8);
                ImageView imageView2 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.voiceUserListItemMuteIndicator");
                imageView2.setVisibility(8);
                StreamPreviewView streamPreviewView = this.binding.i;
                Intrinsics3.checkNotNullExpressionValue(streamPreviewView, "binding.voiceUserListItemUserStreamPreview");
                streamPreviewView.setVisibility(8);
                ImageView imageView3 = this.binding.j;
                Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.voiceUserListItemVideoIndicator");
                imageView3.setVisibility(8);
                ImageView imageView4 = this.binding.e;
                Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.voiceUserListItemSpectatingIndicator");
                imageView4.setVisibility(8);
                TextView textView2 = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.voiceUserListItemLiveIndicator");
                textView2.setVisibility(8);
                return;
            }
            ImageView imageView5 = this.binding.f2222b;
            Intrinsics3.checkNotNullExpressionValue(imageView5, "binding.voiceUserListItemDeafenIndicator");
            imageView5.setVisibility(0);
            ImageView imageView6 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(imageView6, "binding.voiceUserListItemMuteIndicator");
            imageView6.setVisibility(0);
            VoiceState voiceState = participant.getVoiceState();
            boolean z3 = voiceState.getSelfDeaf() || voiceState.getDeaf();
            boolean z4 = voiceState.getSelfMute() || voiceState.getMute() || voiceState.getSuppress();
            boolean selfVideo = voiceState.getSelfVideo();
            ImageView imageView7 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(imageView7, "binding.voiceUserListItemSpectatingIndicator");
            imageView7.setVisibility(voiceUser.isSpectatingSameStream() ? 0 : 8);
            ImageView imageView8 = this.binding.f2222b;
            Intrinsics3.checkNotNullExpressionValue(imageView8, "binding.voiceUserListItemDeafenIndicator");
            imageView8.setVisibility(z3 ? 0 : 8);
            ImageView imageView9 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(imageView9, "binding.voiceUserListItemMuteIndicator");
            imageView9.setVisibility(z4 ? 0 : 8);
            ImageView imageView10 = this.binding.j;
            Intrinsics3.checkNotNullExpressionValue(imageView10, "binding.voiceUserListItemVideoIndicator");
            imageView10.setVisibility(selfVideo ? 0 : 8);
            StreamContext streamContext = participant.getStreamContext();
            TextView textView3 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.voiceUserListItemLiveIndicator");
            textView3.setVisibility(streamContext != null ? 0 : 8);
            StoreApplicationStreamPreviews.StreamPreview preview = streamContext != null ? streamContext.getPreview() : null;
            if (preview != null) {
                StreamContext.Joinability joinability = streamContext.getJoinability();
                StreamContext.Joinability joinability2 = StreamContext.Joinability.CAN_CONNECT;
                if (joinability == joinability2) {
                    StreamPreviewView streamPreviewView2 = this.binding.i;
                    Intrinsics3.checkNotNullExpressionValue(streamPreviewView2, "binding.voiceUserListItemUserStreamPreview");
                    streamPreviewView2.setVisibility(0);
                    this.binding.i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.CallParticipantsAdapter$ViewHolderUser$onConfigure$4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CallParticipantsAdapter.ViewHolderUser.access$getAdapter$p(this.this$0).getOnStreamPreviewClicked().invoke(participant.getStreamContext());
                        }
                    });
                    StreamContext streamContext2 = voiceUser.getParticipant().getStreamContext();
                    if (streamContext2 != null && streamContext2.isCurrentUserParticipating()) {
                        z2 = true;
                    }
                    this.binding.i.a(preview, joinability2, z2);
                    return;
                }
            }
            StreamPreviewView streamPreviewView3 = this.binding.i;
            Intrinsics3.checkNotNullExpressionValue(streamPreviewView3, "binding.voiceUserListItemUserStreamPreview");
            streamPreviewView3.setVisibility(8);
        }
    }

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

    public final Function1<StoreVoiceParticipants.VoiceUser, Unit> getOnToggleRingingClicked() {
        return this.onToggleRingingClicked;
    }

    public final Function1<StoreVoiceParticipants.VoiceUser, Unit> getOnVoiceUserClicked() {
        return this.onVoiceUserClicked;
    }

    public final void setOnEmbeddedActivityClicked(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onEmbeddedActivityClicked = function0;
    }

    public final void setOnEventClicked(Function1<? super GuildScheduledEvent, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onEventClicked = function1;
    }

    public final void setOnInviteFriendsClicked(Function1<? super View, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onInviteFriendsClicked = function1;
    }

    public final void setOnStartEventClicked(Function1<? super GuildScheduledEvent, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onStartEventClicked = function1;
    }

    public final void setOnStreamPreviewClicked(Function1<? super StreamContext, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onStreamPreviewClicked = function1;
    }

    public final void setOnToggleRingingClicked(Function1<? super StoreVoiceParticipants.VoiceUser, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onToggleRingingClicked = function1;
    }

    public final void setOnVoiceUserClicked(Function1<? super StoreVoiceParticipants.VoiceUser, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onVoiceUserClicked = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallParticipantsAdapter(RecyclerView recyclerView, boolean z2, boolean z3) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
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

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
                return new ViewHolderUser(this, this.isCallPreview, this.quantizeUserAvatars);
            case 1:
                return new ViewHolderHeader(this);
            case 2:
                return new ViewHolderHeader(this);
            case 3:
                return new ViewHolderDivider(this);
            case 4:
                return new ViewHolderInvite(this, this.isCallPreview);
            case 5:
                return new ViewHolderEvent(this, this.isCallPreview);
            case 6:
                return new ViewHolderEmbeddedActivity(this, this.isCallPreview);
            default:
                throw invalidViewTypeException(viewType);
        }
    }
}

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
import com.discord.C5419R;
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
import com.discord.utilities.colors.RepresentativeColorsKt;
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
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.C1107b;
import p007b.p008a.p062y.C1320a0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

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
                C12238m.checkNotNullParameter(embeddedActivity, "embeddedActivity");
                C12238m.checkNotNullParameter(list, "participants");
                C12238m.checkNotNullParameter(application, "application");
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
                C12238m.checkNotNullParameter(embeddedActivity, "embeddedActivity");
                C12238m.checkNotNullParameter(participants, "participants");
                C12238m.checkNotNullParameter(application, "application");
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
                return C12238m.areEqual(this.embeddedActivity, embeddedActivityItem.embeddedActivity) && C12238m.areEqual(this.participants, embeddedActivityItem.participants) && C12238m.areEqual(this.application, embeddedActivityItem.application);
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
                StringBuilder sbM833U = C1643a.m833U("EmbeddedActivityItem(embeddedActivity=");
                sbM833U.append(this.embeddedActivity);
                sbM833U.append(", participants=");
                sbM833U.append(this.participants);
                sbM833U.append(", application=");
                sbM833U.append(this.application);
                sbM833U.append(")");
                return sbM833U.toString();
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
                C12238m.checkNotNullParameter(guildScheduledEvent, "event");
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
                C12238m.checkNotNullParameter(event, "event");
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
                return C12238m.areEqual(this.event, event.event) && this.canStartEvent == event.canStartEvent && this.isCurrentUserInCall == event.isCurrentUserInCall;
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
                StringBuilder sbM833U = C1643a.m833U("Event(event=");
                sbM833U.append(this.event);
                sbM833U.append(", canStartEvent=");
                sbM833U.append(this.canStartEvent);
                sbM833U.append(", isCurrentUserInCall=");
                return C1643a.m827O(sbM833U, this.isCurrentUserInCall, ")");
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
                return C1643a.m814B(C1643a.m833U("Header(stringResId="), this.stringResId, ")");
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
                C12238m.checkNotNullParameter(str, "streamerName");
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
                C12238m.checkNotNullParameter(streamerName, "streamerName");
                return new SpectatorsHeader(streamerName);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SpectatorsHeader) && C12238m.areEqual(this.streamerName, ((SpectatorsHeader) other).streamerName);
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
                return C1643a.m822J(C1643a.m833U("SpectatorsHeader(streamerName="), this.streamerName, ")");
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
                C12238m.checkNotNullParameter(voiceUser, "participant");
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
                C12238m.checkNotNullParameter(participant, "participant");
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
                return C12238m.areEqual(this.participant, voiceUser.participant) && this.canRing == voiceUser.canRing && this.isSpectatingSameStream == voiceUser.isSpectatingSameStream;
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
                StringBuilder sbM833U = C1643a.m833U("VoiceUser(participant=");
                sbM833U.append(this.participant);
                sbM833U.append(", canRing=");
                sbM833U.append(this.canRing);
                sbM833U.append(", isSpectatingSameStream=");
                return C1643a.m827O(sbM833U, this.isSpectatingSameStream, ")");
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
            super(C5419R.layout.voice_user_list_item_divider, callParticipantsAdapter);
            C12238m.checkNotNullParameter(callParticipantsAdapter, "adapter");
        }
    }

    /* JADX INFO: compiled from: CallParticipantsAdapter.kt */
    public static final class ViewHolderEmbeddedActivity extends MGRecyclerViewHolder<CallParticipantsAdapter, MGRecyclerDataPayload> {
        private final VoiceUserListItemEmbeddedActivityBinding binding;
        private final MGImages.DistinctChangeDetector distinctChangeDetector;
        private final boolean isCallPreview;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderEmbeddedActivity(CallParticipantsAdapter callParticipantsAdapter, boolean z2) {
            super(C5419R.layout.voice_user_list_item_embedded_activity, callParticipantsAdapter);
            C12238m.checkNotNullParameter(callParticipantsAdapter, "adapter");
            this.isCallPreview = z2;
            View view = this.itemView;
            int i = C5419R.id.app_icon;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.app_icon);
            if (simpleDraweeView != null) {
                i = C5419R.id.app_name;
                TextView textView = (TextView) view.findViewById(C5419R.id.app_name);
                if (textView != null) {
                    i = C5419R.id.clickable_container;
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C5419R.id.clickable_container);
                    if (constraintLayout != null) {
                        i = C5419R.id.participant_avatars;
                        PileView pileView = (PileView) view.findViewById(C5419R.id.participant_avatars);
                        if (pileView != null) {
                            VoiceUserListItemEmbeddedActivityBinding voiceUserListItemEmbeddedActivityBinding = new VoiceUserListItemEmbeddedActivityBinding((FrameLayout) view, simpleDraweeView, textView, constraintLayout, pileView);
                            C12238m.checkNotNullExpressionValue(voiceUserListItemEmbeddedActivityBinding, "VoiceUserListItemEmbedde…ityBinding.bind(itemView)");
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
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            ListItem.EmbeddedActivityItem embeddedActivityItem = (ListItem.EmbeddedActivityItem) data;
            Application application = embeddedActivityItem.getApplication();
            if (!this.isCallPreview) {
                FrameLayout frameLayout = this.binding.f15614a;
                C12238m.checkNotNullExpressionValue(frameLayout, "binding.root");
                this.binding.f15614a.setBackgroundColor(ColorCompat.getThemedColor(frameLayout.getContext(), C5419R.attr.colorBackgroundPrimary));
            }
            TextView textView = this.binding.f15616c;
            C12238m.checkNotNullExpressionValue(textView, "binding.appName");
            textView.setText(application.getName());
            boolean z2 = application.getIcon() != null;
            SimpleDraweeView simpleDraweeView = this.binding.f15615b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.appIcon");
            if (z2) {
                drawable = null;
            } else {
                SimpleDraweeView simpleDraweeView2 = this.binding.f15615b;
                C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.appIcon");
                drawable = ContextCompat.getDrawable(simpleDraweeView2.getContext(), C5419R.drawable.ic_activity_24dp);
            }
            simpleDraweeView.setBackground(drawable);
            String applicationIcon = IconUtils.INSTANCE.getApplicationIcon(application, DimenUtils.dpToPixels(32));
            SimpleDraweeView simpleDraweeView3 = this.binding.f15615b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.appIcon");
            MGImages.setImage$default(simpleDraweeView3, z2 ? applicationIcon : null, DimenUtils.dpToPixels(32), DimenUtils.dpToPixels(32), false, null, this.distinctChangeDetector, 48, null);
            List<UserGuildMember> participants = embeddedActivityItem.getParticipants();
            int iDpToPixels = DimenUtils.dpToPixels(16);
            C12238m.checkNotNullParameter(participants, "userGuildMembers");
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(participants, 10));
            for (UserGuildMember userGuildMember : participants) {
                arrayList.add(IconUtils.INSTANCE.getForGuildMemberOrUser(userGuildMember.getUser(), userGuildMember.getGuildMember(), Integer.valueOf(iDpToPixels), false));
            }
            ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new PileView.C7089c(new C1320a0((String) it.next()), null));
            }
            this.binding.f15618e.setItems(arrayList2);
            this.binding.f15617d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.CallParticipantsAdapter$ViewHolderEmbeddedActivity$onConfigure$1
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
            super(C5419R.layout.voice_user_list_item_event, callParticipantsAdapter);
            C12238m.checkNotNullParameter(callParticipantsAdapter, "adapter");
            this.isCallPreview = z2;
            View view = this.itemView;
            GuildScheduledEventItemView guildScheduledEventItemView = (GuildScheduledEventItemView) view.findViewById(C5419R.id.event_card);
            if (guildScheduledEventItemView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.event_card)));
            }
            VoiceUserListItemEventBinding voiceUserListItemEventBinding = new VoiceUserListItemEventBinding((FrameLayout) view, guildScheduledEventItemView);
            C12238m.checkNotNullExpressionValue(voiceUserListItemEventBinding, "VoiceUserListItemEventBinding.bind(itemView)");
            this.binding = voiceUserListItemEventBinding;
        }

        public static final /* synthetic */ CallParticipantsAdapter access$getAdapter$p(ViewHolderEvent viewHolderEvent) {
            return (CallParticipantsAdapter) viewHolderEvent.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, final MGRecyclerDataPayload data) {
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            if (data instanceof ListItem.Event) {
                ListItem.Event event = (ListItem.Event) data;
                this.binding.f15620b.configureInVoiceChannel(event.getEvent(), null, event.getCanStartEvent() && event.isCurrentUserInCall(), event.isCurrentUserInCall(), event.isCurrentUserInCall(), this.isCallPreview, new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.CallParticipantsAdapter$ViewHolderEvent$onConfigure$1
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
            super(C5419R.layout.voice_user_list_item_header, callParticipantsAdapter);
            C12238m.checkNotNullParameter(callParticipantsAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            TextView textView = (TextView) view;
            VoiceUserListItemHeaderBinding voiceUserListItemHeaderBinding = new VoiceUserListItemHeaderBinding(textView, textView);
            C12238m.checkNotNullExpressionValue(voiceUserListItemHeaderBinding, "VoiceUserListItemHeaderBinding.bind(itemView)");
            this.binding = voiceUserListItemHeaderBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, MGRecyclerDataPayload data) {
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            if (data instanceof ListItem.Header) {
                this.binding.f15622b.setText(((ListItem.Header) data).getStringResId());
                return;
            }
            if (data instanceof ListItem.SpectatorsHeader) {
                TextView textView = this.binding.f15622b;
                C12238m.checkNotNullExpressionValue(textView, "binding.voiceUserListItemHeaderLabel");
                TextView textView2 = this.binding.f15622b;
                C12238m.checkNotNullExpressionValue(textView2, "binding.voiceUserListItemHeaderLabel");
                textView.setText(C1107b.m212d(textView2, C5419R.string.go_live_watching_user, new Object[]{((ListItem.SpectatorsHeader) data).getStreamerName()}, (4 & 4) != 0 ? C1107b.c.f1492j : null));
            }
        }
    }

    /* JADX INFO: compiled from: CallParticipantsAdapter.kt */
    public static final class ViewHolderInvite extends MGRecyclerViewHolder<CallParticipantsAdapter, MGRecyclerDataPayload> {
        private final VoiceUserListItemInviteBinding binding;
        private final boolean isCallPreview;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderInvite(CallParticipantsAdapter callParticipantsAdapter, boolean z2) {
            super(C5419R.layout.voice_user_list_item_invite, callParticipantsAdapter);
            C12238m.checkNotNullParameter(callParticipantsAdapter, "adapter");
            this.isCallPreview = z2;
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            VoiceUserListItemInviteBinding voiceUserListItemInviteBinding = new VoiceUserListItemInviteBinding((LinearLayout) view);
            C12238m.checkNotNullExpressionValue(voiceUserListItemInviteBinding, "VoiceUserListItemInviteBinding.bind(itemView)");
            this.binding = voiceUserListItemInviteBinding;
        }

        public static final /* synthetic */ CallParticipantsAdapter access$getAdapter$p(ViewHolderInvite viewHolderInvite) {
            return (CallParticipantsAdapter) viewHolderInvite.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, MGRecyclerDataPayload data) {
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            if (data instanceof ListItem.Invite) {
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.CallParticipantsAdapter$ViewHolderInvite$onConfigure$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Function1<View, Unit> onInviteFriendsClicked = CallParticipantsAdapter.ViewHolderInvite.access$getAdapter$p(this.this$0).getOnInviteFriendsClicked();
                        C12238m.checkNotNullExpressionValue(view, "it");
                        onInviteFriendsClicked.invoke(view);
                    }
                });
                if (this.isCallPreview) {
                    return;
                }
                LinearLayout linearLayout = this.binding.f15623a;
                C12238m.checkNotNullExpressionValue(linearLayout, "binding.root");
                this.binding.f15623a.setBackgroundColor(ColorCompat.getThemedColor(linearLayout.getContext(), C5419R.attr.colorBackgroundPrimary));
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
            super(C5419R.layout.voice_user_list_item_user, callParticipantsAdapter);
            C12238m.checkNotNullParameter(callParticipantsAdapter, "adapter");
            this.isCallPreview = z2;
            this.quantizeUserAvatar = z3;
            View view = this.itemView;
            int i = C5419R.id.voice_user_list_item_deafen_indicator;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.voice_user_list_item_deafen_indicator);
            if (imageView != null) {
                i = C5419R.id.voice_user_list_item_live_indicator;
                TextView textView = (TextView) view.findViewById(C5419R.id.voice_user_list_item_live_indicator);
                if (textView != null) {
                    i = C5419R.id.voice_user_list_item_mute_indicator;
                    ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.voice_user_list_item_mute_indicator);
                    if (imageView2 != null) {
                        i = C5419R.id.voice_user_list_item_spectating_indicator;
                        ImageView imageView3 = (ImageView) view.findViewById(C5419R.id.voice_user_list_item_spectating_indicator);
                        if (imageView3 != null) {
                            i = C5419R.id.voice_user_list_item_toggle_ringing;
                            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.voice_user_list_item_toggle_ringing);
                            if (materialButton != null) {
                                i = C5419R.id.voice_user_list_item_user_avatar;
                                VoiceUserView voiceUserView = (VoiceUserView) view.findViewById(C5419R.id.voice_user_list_item_user_avatar);
                                if (voiceUserView != null) {
                                    i = C5419R.id.voice_user_list_item_user_name;
                                    TextView textView2 = (TextView) view.findViewById(C5419R.id.voice_user_list_item_user_name);
                                    if (textView2 != null) {
                                        i = C5419R.id.voice_user_list_item_user_stream_preview;
                                        StreamPreviewView streamPreviewView = (StreamPreviewView) view.findViewById(C5419R.id.voice_user_list_item_user_stream_preview);
                                        if (streamPreviewView != null) {
                                            i = C5419R.id.voice_user_list_item_video_indicator;
                                            ImageView imageView4 = (ImageView) view.findViewById(C5419R.id.voice_user_list_item_video_indicator);
                                            if (imageView4 != null) {
                                                VoiceUserListItemUserBinding voiceUserListItemUserBinding = new VoiceUserListItemUserBinding((LinearLayout) view, imageView, textView, imageView2, imageView3, materialButton, voiceUserView, textView2, streamPreviewView, imageView4);
                                                C12238m.checkNotNullExpressionValue(voiceUserListItemUserBinding, "VoiceUserListItemUserBinding.bind(itemView)");
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
            CharSequence charSequenceM212d;
            CharSequence charSequenceM212d2;
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            ListItem.VoiceUser voiceUser = (ListItem.VoiceUser) data;
            final StoreVoiceParticipants.VoiceUser participant = voiceUser.getParticipant();
            String colorId = RepresentativeColorsKt.getColorId(participant.getUser());
            if (this.quantizeUserAvatar) {
                this.binding.f15630g.setOnBitmapLoadedListener(new CallParticipantsAdapter$ViewHolderUser$onConfigure$1(colorId));
            }
            if (!this.isCallPreview) {
                LinearLayout linearLayout = this.binding.f15624a;
                C12238m.checkNotNullExpressionValue(linearLayout, "binding.root");
                this.binding.f15624a.setBackgroundColor(ColorCompat.getThemedColor(linearLayout.getContext(), C5419R.attr.colorBackgroundPrimary));
            }
            this.binding.f15630g.m8570a(participant, C5419R.dimen.avatar_size_standard);
            TextView textView = this.binding.f15631h;
            C12238m.checkNotNullExpressionValue(textView, "binding.voiceUserListItemUserName");
            textView.setText(participant.getDisplayName());
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.CallParticipantsAdapter$ViewHolderUser$onConfigure$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CallParticipantsAdapter.ViewHolderUser.access$getAdapter$p(this.this$0).getOnVoiceUserClicked().invoke(participant);
                }
            });
            MaterialButton materialButton = this.binding.f15629f;
            C12238m.checkNotNullExpressionValue(materialButton, "binding.voiceUserListItemToggleRinging");
            boolean z2 = false;
            materialButton.setVisibility(voiceUser.getCanRing() ? 0 : 8);
            MaterialButton materialButton2 = this.binding.f15629f;
            C12238m.checkNotNullExpressionValue(materialButton2, "binding.voiceUserListItemToggleRinging");
            if (participant.isRinging()) {
                MaterialButton materialButton3 = this.binding.f15629f;
                C12238m.checkNotNullExpressionValue(materialButton3, "binding.voiceUserListItemToggleRinging");
                charSequenceM212d = C1107b.m212d(materialButton3, C5419R.string.stop_ringing, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null);
            } else {
                MaterialButton materialButton4 = this.binding.f15629f;
                C12238m.checkNotNullExpressionValue(materialButton4, "binding.voiceUserListItemToggleRinging");
                charSequenceM212d = C1107b.m212d(materialButton4, C5419R.string.ring, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null);
            }
            materialButton2.setText(charSequenceM212d);
            this.binding.f15629f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.CallParticipantsAdapter$ViewHolderUser$onConfigure$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CallParticipantsAdapter.ViewHolderUser.access$getAdapter$p(this.this$0).getOnToggleRingingClicked().invoke(participant);
                }
            });
            MaterialButton materialButton5 = this.binding.f15629f;
            C12238m.checkNotNullExpressionValue(materialButton5, "binding.voiceUserListItemToggleRinging");
            if (participant.isRinging()) {
                MaterialButton materialButton6 = this.binding.f15629f;
                C12238m.checkNotNullExpressionValue(materialButton6, "binding.voiceUserListItemToggleRinging");
                charSequenceM212d2 = C1107b.m212d(materialButton6, C5419R.string.stop_ringing_username_a11y_label, new Object[]{participant.getDisplayName()}, (4 & 4) != 0 ? C1107b.c.f1492j : null);
            } else {
                MaterialButton materialButton7 = this.binding.f15629f;
                C12238m.checkNotNullExpressionValue(materialButton7, "binding.voiceUserListItemToggleRinging");
                charSequenceM212d2 = C1107b.m212d(materialButton7, C5419R.string.ring_username_a11y_label, new Object[]{participant.getDisplayName()}, (4 & 4) != 0 ? C1107b.c.f1492j : null);
            }
            materialButton5.setContentDescription(charSequenceM212d2);
            if (!participant.isConnected() || participant.getVoiceState() == null) {
                ImageView imageView = this.binding.f15625b;
                C12238m.checkNotNullExpressionValue(imageView, "binding.voiceUserListItemDeafenIndicator");
                imageView.setVisibility(8);
                ImageView imageView2 = this.binding.f15627d;
                C12238m.checkNotNullExpressionValue(imageView2, "binding.voiceUserListItemMuteIndicator");
                imageView2.setVisibility(8);
                StreamPreviewView streamPreviewView = this.binding.f15632i;
                C12238m.checkNotNullExpressionValue(streamPreviewView, "binding.voiceUserListItemUserStreamPreview");
                streamPreviewView.setVisibility(8);
                ImageView imageView3 = this.binding.f15633j;
                C12238m.checkNotNullExpressionValue(imageView3, "binding.voiceUserListItemVideoIndicator");
                imageView3.setVisibility(8);
                ImageView imageView4 = this.binding.f15628e;
                C12238m.checkNotNullExpressionValue(imageView4, "binding.voiceUserListItemSpectatingIndicator");
                imageView4.setVisibility(8);
                TextView textView2 = this.binding.f15626c;
                C12238m.checkNotNullExpressionValue(textView2, "binding.voiceUserListItemLiveIndicator");
                textView2.setVisibility(8);
                return;
            }
            ImageView imageView5 = this.binding.f15625b;
            C12238m.checkNotNullExpressionValue(imageView5, "binding.voiceUserListItemDeafenIndicator");
            imageView5.setVisibility(0);
            ImageView imageView6 = this.binding.f15627d;
            C12238m.checkNotNullExpressionValue(imageView6, "binding.voiceUserListItemMuteIndicator");
            imageView6.setVisibility(0);
            VoiceState voiceState = participant.getVoiceState();
            boolean z3 = voiceState.getSelfDeaf() || voiceState.getDeaf();
            boolean z4 = voiceState.getSelfMute() || voiceState.getMute() || voiceState.getSuppress();
            boolean selfVideo = voiceState.getSelfVideo();
            ImageView imageView7 = this.binding.f15628e;
            C12238m.checkNotNullExpressionValue(imageView7, "binding.voiceUserListItemSpectatingIndicator");
            imageView7.setVisibility(voiceUser.isSpectatingSameStream() ? 0 : 8);
            ImageView imageView8 = this.binding.f15625b;
            C12238m.checkNotNullExpressionValue(imageView8, "binding.voiceUserListItemDeafenIndicator");
            imageView8.setVisibility(z3 ? 0 : 8);
            ImageView imageView9 = this.binding.f15627d;
            C12238m.checkNotNullExpressionValue(imageView9, "binding.voiceUserListItemMuteIndicator");
            imageView9.setVisibility(z4 ? 0 : 8);
            ImageView imageView10 = this.binding.f15633j;
            C12238m.checkNotNullExpressionValue(imageView10, "binding.voiceUserListItemVideoIndicator");
            imageView10.setVisibility(selfVideo ? 0 : 8);
            StreamContext streamContext = participant.getStreamContext();
            TextView textView3 = this.binding.f15626c;
            C12238m.checkNotNullExpressionValue(textView3, "binding.voiceUserListItemLiveIndicator");
            textView3.setVisibility(streamContext != null ? 0 : 8);
            StoreApplicationStreamPreviews.StreamPreview preview = streamContext != null ? streamContext.getPreview() : null;
            if (preview != null) {
                StreamContext.Joinability joinability = streamContext.getJoinability();
                StreamContext.Joinability joinability2 = StreamContext.Joinability.CAN_CONNECT;
                if (joinability == joinability2) {
                    StreamPreviewView streamPreviewView2 = this.binding.f15632i;
                    C12238m.checkNotNullExpressionValue(streamPreviewView2, "binding.voiceUserListItemUserStreamPreview");
                    streamPreviewView2.setVisibility(0);
                    this.binding.f15632i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.CallParticipantsAdapter$ViewHolderUser$onConfigure$4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CallParticipantsAdapter.ViewHolderUser.access$getAdapter$p(this.this$0).getOnStreamPreviewClicked().invoke(participant.getStreamContext());
                        }
                    });
                    StreamContext streamContext2 = voiceUser.getParticipant().getStreamContext();
                    if (streamContext2 != null && streamContext2.isCurrentUserParticipating()) {
                        z2 = true;
                    }
                    this.binding.f15632i.m8557a(preview, joinability2, z2);
                    return;
                }
            }
            StreamPreviewView streamPreviewView3 = this.binding.f15632i;
            C12238m.checkNotNullExpressionValue(streamPreviewView3, "binding.voiceUserListItemUserStreamPreview");
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
        C12238m.checkNotNullParameter(function0, "<set-?>");
        this.onEmbeddedActivityClicked = function0;
    }

    public final void setOnEventClicked(Function1<? super GuildScheduledEvent, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "<set-?>");
        this.onEventClicked = function1;
    }

    public final void setOnInviteFriendsClicked(Function1<? super View, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "<set-?>");
        this.onInviteFriendsClicked = function1;
    }

    public final void setOnStartEventClicked(Function1<? super GuildScheduledEvent, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "<set-?>");
        this.onStartEventClicked = function1;
    }

    public final void setOnStreamPreviewClicked(Function1<? super StreamContext, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "<set-?>");
        this.onStreamPreviewClicked = function1;
    }

    public final void setOnToggleRingingClicked(Function1<? super StoreVoiceParticipants.VoiceUser, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "<set-?>");
        this.onToggleRingingClicked = function1;
    }

    public final void setOnVoiceUserClicked(Function1<? super StoreVoiceParticipants.VoiceUser, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "<set-?>");
        this.onVoiceUserClicked = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallParticipantsAdapter(RecyclerView recyclerView, boolean z2, boolean z3) {
        super(recyclerView, false, 2, null);
        C12238m.checkNotNullParameter(recyclerView, "recycler");
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
        C12238m.checkNotNullParameter(parent, "parent");
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

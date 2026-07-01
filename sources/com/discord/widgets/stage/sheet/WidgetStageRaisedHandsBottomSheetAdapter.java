package com.discord.widgets.stage.sheet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.databinding.StageRaisedHandsItemUserBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.extensions.SimpleDraweeViewExtensions;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetAdapter extends MGRecyclerAdapterSimple<ListItem> {
    private static final int MILLIS_PER_DAY = 86400000;
    private static final int NEW_USER_DAYS_THRESOLD = 7;
    private static final int VIEW_TYPE_PARTICIPANT = 0;
    private Function1<? super StoreVoiceParticipants.VoiceUser, Unit> onDismissRequest;
    private Function1<? super StoreVoiceParticipants.VoiceUser, Unit> onInviteToSpeak;
    private Function1<? super StoreVoiceParticipants.VoiceUser, Unit> onViewProfile;

    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetAdapter.kt */
    public static abstract class ListItem implements MGRecyclerDataPayload {

        /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetAdapter.kt */
        public static final /* data */ class Participant extends ListItem {
            private final String key;
            private final GuildMember member;
            private final StoreVoiceParticipants.VoiceUser participant;
            private final UtcDateTime requestToSpeakTimestamp;
            private final GuildRole role;
            private final int type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Participant(StoreVoiceParticipants.VoiceUser voiceUser, UtcDateTime utcDateTime, GuildMember guildMember, GuildRole guildRole) {
                super(null);
                Intrinsics3.checkNotNullParameter(voiceUser, "participant");
                this.participant = voiceUser;
                this.requestToSpeakTimestamp = utcDateTime;
                this.member = guildMember;
                this.role = guildRole;
                this.key = String.valueOf(voiceUser.getUser().getId());
            }

            public static /* synthetic */ Participant copy$default(Participant participant, StoreVoiceParticipants.VoiceUser voiceUser, UtcDateTime utcDateTime, GuildMember guildMember, GuildRole guildRole, int i, Object obj) {
                if ((i & 1) != 0) {
                    voiceUser = participant.participant;
                }
                if ((i & 2) != 0) {
                    utcDateTime = participant.requestToSpeakTimestamp;
                }
                if ((i & 4) != 0) {
                    guildMember = participant.member;
                }
                if ((i & 8) != 0) {
                    guildRole = participant.role;
                }
                return participant.copy(voiceUser, utcDateTime, guildMember, guildRole);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final StoreVoiceParticipants.VoiceUser getParticipant() {
                return this.participant;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final UtcDateTime getRequestToSpeakTimestamp() {
                return this.requestToSpeakTimestamp;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final GuildMember getMember() {
                return this.member;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final GuildRole getRole() {
                return this.role;
            }

            public final Participant copy(StoreVoiceParticipants.VoiceUser participant, UtcDateTime requestToSpeakTimestamp, GuildMember member, GuildRole role) {
                Intrinsics3.checkNotNullParameter(participant, "participant");
                return new Participant(participant, requestToSpeakTimestamp, member, role);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Participant)) {
                    return false;
                }
                Participant participant = (Participant) other;
                return Intrinsics3.areEqual(this.participant, participant.participant) && Intrinsics3.areEqual(this.requestToSpeakTimestamp, participant.requestToSpeakTimestamp) && Intrinsics3.areEqual(this.member, participant.member) && Intrinsics3.areEqual(this.role, participant.role);
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final GuildMember getMember() {
                return this.member;
            }

            public final StoreVoiceParticipants.VoiceUser getParticipant() {
                return this.participant;
            }

            public final UtcDateTime getRequestToSpeakTimestamp() {
                return this.requestToSpeakTimestamp;
            }

            public final GuildRole getRole() {
                return this.role;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                StoreVoiceParticipants.VoiceUser voiceUser = this.participant;
                int iHashCode = (voiceUser != null ? voiceUser.hashCode() : 0) * 31;
                UtcDateTime utcDateTime = this.requestToSpeakTimestamp;
                int iHashCode2 = (iHashCode + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
                GuildMember guildMember = this.member;
                int iHashCode3 = (iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
                GuildRole guildRole = this.role;
                return iHashCode3 + (guildRole != null ? guildRole.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Participant(participant=");
                sbU.append(this.participant);
                sbU.append(", requestToSpeakTimestamp=");
                sbU.append(this.requestToSpeakTimestamp);
                sbU.append(", member=");
                sbU.append(this.member);
                sbU.append(", role=");
                sbU.append(this.role);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private ListItem() {
        }

        public /* synthetic */ ListItem(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetAdapter.kt */
    public static final class ViewHolderParticipant extends MGRecyclerViewHolder<WidgetStageRaisedHandsBottomSheetAdapter, ListItem> {
        private final StageRaisedHandsItemUserBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderParticipant(WidgetStageRaisedHandsBottomSheetAdapter widgetStageRaisedHandsBottomSheetAdapter) {
            super(R.layout.stage_raised_hands_item_user, widgetStageRaisedHandsBottomSheetAdapter);
            Intrinsics3.checkNotNullParameter(widgetStageRaisedHandsBottomSheetAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.stage_raised_hands_item_dismiss_button;
            ImageView imageView = (ImageView) view.findViewById(R.id.stage_raised_hands_item_dismiss_button);
            if (imageView != null) {
                i = R.id.stage_raised_hands_item_invite_button;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.stage_raised_hands_item_invite_button);
                if (imageView2 != null) {
                    i = R.id.stage_raised_hands_item_role;
                    TextView textView = (TextView) view.findViewById(R.id.stage_raised_hands_item_role);
                    if (textView != null) {
                        i = R.id.stage_raised_hands_item_user_avatar;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.stage_raised_hands_item_user_avatar);
                        if (simpleDraweeView != null) {
                            i = R.id.stage_raised_hands_item_user_name;
                            TextView textView2 = (TextView) view.findViewById(R.id.stage_raised_hands_item_user_name);
                            if (textView2 != null) {
                                StageRaisedHandsItemUserBinding stageRaisedHandsItemUserBinding = new StageRaisedHandsItemUserBinding((ConstraintLayout) view, imageView, imageView2, textView, simpleDraweeView, textView2);
                                Intrinsics3.checkNotNullExpressionValue(stageRaisedHandsItemUserBinding, "StageRaisedHandsItemUserBinding.bind(itemView)");
                                this.binding = stageRaisedHandsItemUserBinding;
                                return;
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetStageRaisedHandsBottomSheetAdapter access$getAdapter$p(ViewHolderParticipant viewHolderParticipant) {
            return (WidgetStageRaisedHandsBottomSheetAdapter) viewHolderParticipant.adapter;
        }

        private final String getParticipantMemberInfo(Context context, ListItem.Participant data) {
            String name;
            if (isNewUser(data.getParticipant().getUser())) {
                String string = context.getString(R.string.request_to_speak_member_info_new_to_discord);
                Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.stri…mber_info_new_to_discord)");
                return string;
            }
            GuildMember member = data.getMember();
            UtcDateTime joinedAt = member != null ? member.getJoinedAt() : null;
            if (joinedAt == null) {
                String string2 = context.getString(R.string.request_to_speak_member_info_non_member);
                Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…k_member_info_non_member)");
                return string2;
            }
            if (!data.getMember().getRoles().isEmpty()) {
                GuildRole role = data.getRole();
                if (role != null && (name = role.getName()) != null) {
                    return name;
                }
                String string3 = context.getString(R.string.request_to_speak_member_info_member_roles);
                Intrinsics3.checkNotNullExpressionValue(string3, "context.getString(R.stri…member_info_member_roles)");
                return string3;
            }
            if (ClockFactory.get().currentTimeMillis() - joinedAt.getDateTimeMillis() < WidgetStageRaisedHandsBottomSheetAdapter.MILLIS_PER_DAY) {
                String string4 = context.getString(R.string.request_to_speak_member_info_new_member);
                Intrinsics3.checkNotNullExpressionValue(string4, "context.getString(R.stri…k_member_info_new_member)");
                return string4;
            }
            String string5 = context.getString(R.string.request_to_speak_member_info_member);
            Intrinsics3.checkNotNullExpressionValue(string5, "context.getString(R.stri…speak_member_info_member)");
            return string5;
        }

        private final boolean isNewUser(User user) {
            return ClockFactory.get().currentTimeMillis() - ((user.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH) <= ((long) 604800000);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, ListItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            ListItem.Participant participant = (ListItem.Participant) data;
            final StoreVoiceParticipants.VoiceUser participant2 = participant.getParticipant();
            GuildMember member = participant.getMember();
            this.binding.e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetStageRaisedHandsBottomSheetAdapter.ViewHolderParticipant.access$getAdapter$p(this.this$0).getOnViewProfile().invoke(participant2);
                }
            });
            ImageView imageView = this.binding.c;
            ViewExtensions.setEnabledAndAlpha$default(imageView, !participant2.getIsInvitedToSpeak(), 0.0f, 2, null);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant$onConfigure$$inlined$apply$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetStageRaisedHandsBottomSheetAdapter.ViewHolderParticipant.access$getAdapter$p(this.this$0).getOnInviteToSpeak().invoke(participant2);
                }
            });
            this.binding.f2146b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant$onConfigure$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetStageRaisedHandsBottomSheetAdapter.ViewHolderParticipant.access$getAdapter$p(this.this$0).getOnDismissRequest().invoke(participant2);
                }
            });
            SimpleDraweeView simpleDraweeView = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.stageRaisedHandsItemUserAvatar");
            SimpleDraweeViewExtensions.setAvatar$default(simpleDraweeView, participant2.getUser(), false, R.dimen.avatar_size_standard, participant2.getGuildMember(), 2, null);
            TextView textView = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.stageRaisedHandsItemUserName");
            textView.setText(participant2.getDisplayName());
            if (member != null && member.getColor() != -16777216) {
                this.binding.f.setTextColor(member.getColor());
            }
            TextView textView2 = this.binding.d;
            Context context = textView2.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            textView2.setText(getParticipantMemberInfo(context, participant));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageRaisedHandsBottomSheetAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.onViewProfile = WidgetStageRaisedHandsBottomSheetAdapter7.INSTANCE;
        this.onInviteToSpeak = WidgetStageRaisedHandsBottomSheetAdapter6.INSTANCE;
        this.onDismissRequest = WidgetStageRaisedHandsBottomSheetAdapter5.INSTANCE;
    }

    public final Function1<StoreVoiceParticipants.VoiceUser, Unit> getOnDismissRequest() {
        return this.onDismissRequest;
    }

    public final Function1<StoreVoiceParticipants.VoiceUser, Unit> getOnInviteToSpeak() {
        return this.onInviteToSpeak;
    }

    public final Function1<StoreVoiceParticipants.VoiceUser, Unit> getOnViewProfile() {
        return this.onViewProfile;
    }

    public final void setOnDismissRequest(Function1<? super StoreVoiceParticipants.VoiceUser, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onDismissRequest = function1;
    }

    public final void setOnInviteToSpeak(Function1<? super StoreVoiceParticipants.VoiceUser, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onInviteToSpeak = function1;
    }

    public final void setOnViewProfile(Function1<? super StoreVoiceParticipants.VoiceUser, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onViewProfile = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, ListItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new ViewHolderParticipant(this);
        }
        throw invalidViewTypeException(viewType);
    }
}

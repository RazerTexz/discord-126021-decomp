package com.discord.widgets.voice.sheet;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.VoiceUserListItemEventBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;
import d0.z.d.m;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallParticipantsAdapter$ViewHolderEvent extends MGRecyclerViewHolder<CallParticipantsAdapter, MGRecyclerDataPayload> {
    private final VoiceUserListItemEventBinding binding;
    private final boolean isCallPreview;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallParticipantsAdapter$ViewHolderEvent(CallParticipantsAdapter callParticipantsAdapter, boolean z2) {
        super(R$layout.voice_user_list_item_event, callParticipantsAdapter);
        m.checkNotNullParameter(callParticipantsAdapter, "adapter");
        this.isCallPreview = z2;
        View view = this.itemView;
        GuildScheduledEventItemView guildScheduledEventItemView = (GuildScheduledEventItemView) view.findViewById(R$id.event_card);
        if (guildScheduledEventItemView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.event_card)));
        }
        VoiceUserListItemEventBinding voiceUserListItemEventBinding = new VoiceUserListItemEventBinding((FrameLayout) view, guildScheduledEventItemView);
        m.checkNotNullExpressionValue(voiceUserListItemEventBinding, "VoiceUserListItemEventBinding.bind(itemView)");
        this.binding = voiceUserListItemEventBinding;
    }

    public static final /* synthetic */ CallParticipantsAdapter access$getAdapter$p(CallParticipantsAdapter$ViewHolderEvent callParticipantsAdapter$ViewHolderEvent) {
        return (CallParticipantsAdapter) callParticipantsAdapter$ViewHolderEvent.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data instanceof CallParticipantsAdapter$ListItem$Event) {
            CallParticipantsAdapter$ListItem$Event callParticipantsAdapter$ListItem$Event = (CallParticipantsAdapter$ListItem$Event) data;
            this.binding.f2220b.configureInVoiceChannel(callParticipantsAdapter$ListItem$Event.getEvent(), null, callParticipantsAdapter$ListItem$Event.getCanStartEvent() && callParticipantsAdapter$ListItem$Event.isCurrentUserInCall(), callParticipantsAdapter$ListItem$Event.isCurrentUserInCall(), callParticipantsAdapter$ListItem$Event.isCurrentUserInCall(), this.isCallPreview, new CallParticipantsAdapter$ViewHolderEvent$onConfigure$1(this, data), new CallParticipantsAdapter$ViewHolderEvent$onConfigure$2(this, data));
        }
    }
}

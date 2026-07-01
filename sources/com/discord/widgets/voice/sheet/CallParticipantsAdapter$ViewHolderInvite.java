package com.discord.widgets.voice.sheet;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.R$layout;
import com.discord.databinding.VoiceUserListItemInviteBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallParticipantsAdapter$ViewHolderInvite extends MGRecyclerViewHolder<CallParticipantsAdapter, MGRecyclerDataPayload> {
    private final VoiceUserListItemInviteBinding binding;
    private final boolean isCallPreview;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallParticipantsAdapter$ViewHolderInvite(CallParticipantsAdapter callParticipantsAdapter, boolean z2) {
        super(R$layout.voice_user_list_item_invite, callParticipantsAdapter);
        m.checkNotNullParameter(callParticipantsAdapter, "adapter");
        this.isCallPreview = z2;
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        VoiceUserListItemInviteBinding voiceUserListItemInviteBinding = new VoiceUserListItemInviteBinding((LinearLayout) view);
        m.checkNotNullExpressionValue(voiceUserListItemInviteBinding, "VoiceUserListItemInviteBinding.bind(itemView)");
        this.binding = voiceUserListItemInviteBinding;
    }

    public static final /* synthetic */ CallParticipantsAdapter access$getAdapter$p(CallParticipantsAdapter$ViewHolderInvite callParticipantsAdapter$ViewHolderInvite) {
        return (CallParticipantsAdapter) callParticipantsAdapter$ViewHolderInvite.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data instanceof CallParticipantsAdapter$ListItem$Invite) {
            this.itemView.setOnClickListener(new CallParticipantsAdapter$ViewHolderInvite$onConfigure$1(this));
            if (this.isCallPreview) {
                return;
            }
            LinearLayout linearLayout = this.binding.a;
            m.checkNotNullExpressionValue(linearLayout, "binding.root");
            this.binding.a.setBackgroundColor(ColorCompat.getThemedColor(linearLayout.getContext(), 2130968911));
        }
    }
}

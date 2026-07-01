package com.discord.widgets.voice.sheet;

import android.view.View;
import android.widget.TextView;
import b.a.k.b;
import com.discord.R$layout;
import com.discord.databinding.VoiceUserListItemHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallParticipantsAdapter$ViewHolderHeader extends MGRecyclerViewHolder<CallParticipantsAdapter, MGRecyclerDataPayload> {
    private final VoiceUserListItemHeaderBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallParticipantsAdapter$ViewHolderHeader(CallParticipantsAdapter callParticipantsAdapter) {
        super(R$layout.voice_user_list_item_header, callParticipantsAdapter);
        m.checkNotNullParameter(callParticipantsAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        VoiceUserListItemHeaderBinding voiceUserListItemHeaderBinding = new VoiceUserListItemHeaderBinding(textView, textView);
        m.checkNotNullExpressionValue(voiceUserListItemHeaderBinding, "VoiceUserListItemHeaderBinding.bind(itemView)");
        this.binding = voiceUserListItemHeaderBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data instanceof CallParticipantsAdapter$ListItem$Header) {
            this.binding.f2221b.setText(((CallParticipantsAdapter$ListItem$Header) data).getStringResId());
            return;
        }
        if (data instanceof CallParticipantsAdapter$ListItem$SpectatorsHeader) {
            TextView textView = this.binding.f2221b;
            m.checkNotNullExpressionValue(textView, "binding.voiceUserListItemHeaderLabel");
            TextView textView2 = this.binding.f2221b;
            m.checkNotNullExpressionValue(textView2, "binding.voiceUserListItemHeaderLabel");
            textView.setText(b.j(textView2, 2131889788, new Object[]{((CallParticipantsAdapter$ListItem$SpectatorsHeader) data).getStreamerName()}, null, 4));
        }
    }
}

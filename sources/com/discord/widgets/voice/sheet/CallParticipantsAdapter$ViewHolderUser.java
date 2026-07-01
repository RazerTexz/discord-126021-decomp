package com.discord.widgets.voice.sheet;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.voice.state.VoiceState;
import com.discord.databinding.VoiceUserListItemUserBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreApplicationStreamPreviews$StreamPreview;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.colors.RepresentativeColorsKt;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContext$Joinability;
import com.discord.views.StreamPreviewView;
import com.discord.views.VoiceUserView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallParticipantsAdapter$ViewHolderUser extends MGRecyclerViewHolder<CallParticipantsAdapter, MGRecyclerDataPayload> {
    private final VoiceUserListItemUserBinding binding;
    private final boolean isCallPreview;
    private final boolean quantizeUserAvatar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallParticipantsAdapter$ViewHolderUser(CallParticipantsAdapter callParticipantsAdapter, boolean z2, boolean z3) {
        super(R$layout.voice_user_list_item_user, callParticipantsAdapter);
        m.checkNotNullParameter(callParticipantsAdapter, "adapter");
        this.isCallPreview = z2;
        this.quantizeUserAvatar = z3;
        View view = this.itemView;
        int i = R$id.voice_user_list_item_deafen_indicator;
        ImageView imageView = (ImageView) view.findViewById(R$id.voice_user_list_item_deafen_indicator);
        if (imageView != null) {
            i = R$id.voice_user_list_item_live_indicator;
            TextView textView = (TextView) view.findViewById(R$id.voice_user_list_item_live_indicator);
            if (textView != null) {
                i = R$id.voice_user_list_item_mute_indicator;
                ImageView imageView2 = (ImageView) view.findViewById(R$id.voice_user_list_item_mute_indicator);
                if (imageView2 != null) {
                    i = R$id.voice_user_list_item_spectating_indicator;
                    ImageView imageView3 = (ImageView) view.findViewById(R$id.voice_user_list_item_spectating_indicator);
                    if (imageView3 != null) {
                        i = R$id.voice_user_list_item_toggle_ringing;
                        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.voice_user_list_item_toggle_ringing);
                        if (materialButton != null) {
                            i = R$id.voice_user_list_item_user_avatar;
                            VoiceUserView voiceUserView = (VoiceUserView) view.findViewById(R$id.voice_user_list_item_user_avatar);
                            if (voiceUserView != null) {
                                i = R$id.voice_user_list_item_user_name;
                                TextView textView2 = (TextView) view.findViewById(R$id.voice_user_list_item_user_name);
                                if (textView2 != null) {
                                    i = R$id.voice_user_list_item_user_stream_preview;
                                    StreamPreviewView streamPreviewView = (StreamPreviewView) view.findViewById(R$id.voice_user_list_item_user_stream_preview);
                                    if (streamPreviewView != null) {
                                        i = R$id.voice_user_list_item_video_indicator;
                                        ImageView imageView4 = (ImageView) view.findViewById(R$id.voice_user_list_item_video_indicator);
                                        if (imageView4 != null) {
                                            VoiceUserListItemUserBinding voiceUserListItemUserBinding = new VoiceUserListItemUserBinding((LinearLayout) view, imageView, textView, imageView2, imageView3, materialButton, voiceUserView, textView2, streamPreviewView, imageView4);
                                            m.checkNotNullExpressionValue(voiceUserListItemUserBinding, "VoiceUserListItemUserBinding.bind(itemView)");
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

    public static final /* synthetic */ CallParticipantsAdapter access$getAdapter$p(CallParticipantsAdapter$ViewHolderUser callParticipantsAdapter$ViewHolderUser) {
        return (CallParticipantsAdapter) callParticipantsAdapter$ViewHolderUser.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        CharSequence charSequenceJ;
        CharSequence charSequenceJ2;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        CallParticipantsAdapter$ListItem$VoiceUser callParticipantsAdapter$ListItem$VoiceUser = (CallParticipantsAdapter$ListItem$VoiceUser) data;
        StoreVoiceParticipants$VoiceUser participant = callParticipantsAdapter$ListItem$VoiceUser.getParticipant();
        String colorId = RepresentativeColorsKt.getColorId(participant.getUser());
        if (this.quantizeUserAvatar) {
            this.binding.g.setOnBitmapLoadedListener(new CallParticipantsAdapter$ViewHolderUser$onConfigure$1(colorId));
        }
        if (!this.isCallPreview) {
            LinearLayout linearLayout = this.binding.a;
            m.checkNotNullExpressionValue(linearLayout, "binding.root");
            this.binding.a.setBackgroundColor(ColorCompat.getThemedColor(linearLayout.getContext(), 2130968911));
        }
        this.binding.g.a(participant, 2131165300);
        TextView textView = this.binding.h;
        m.checkNotNullExpressionValue(textView, "binding.voiceUserListItemUserName");
        textView.setText(participant.getDisplayName());
        this.itemView.setOnClickListener(new CallParticipantsAdapter$ViewHolderUser$onConfigure$2(this, participant));
        MaterialButton materialButton = this.binding.f;
        m.checkNotNullExpressionValue(materialButton, "binding.voiceUserListItemToggleRinging");
        boolean z2 = false;
        materialButton.setVisibility(callParticipantsAdapter$ListItem$VoiceUser.getCanRing() ? 0 : 8);
        MaterialButton materialButton2 = this.binding.f;
        m.checkNotNullExpressionValue(materialButton2, "binding.voiceUserListItemToggleRinging");
        if (participant.isRinging()) {
            MaterialButton materialButton3 = this.binding.f;
            m.checkNotNullExpressionValue(materialButton3, "binding.voiceUserListItemToggleRinging");
            charSequenceJ = b.j(materialButton3, 2131896001, new Object[0], null, 4);
        } else {
            MaterialButton materialButton4 = this.binding.f;
            m.checkNotNullExpressionValue(materialButton4, "binding.voiceUserListItemToggleRinging");
            charSequenceJ = b.j(materialButton4, 2131894850, new Object[0], null, 4);
        }
        materialButton2.setText(charSequenceJ);
        this.binding.f.setOnClickListener(new CallParticipantsAdapter$ViewHolderUser$onConfigure$3(this, participant));
        MaterialButton materialButton5 = this.binding.f;
        m.checkNotNullExpressionValue(materialButton5, "binding.voiceUserListItemToggleRinging");
        if (participant.isRinging()) {
            MaterialButton materialButton6 = this.binding.f;
            m.checkNotNullExpressionValue(materialButton6, "binding.voiceUserListItemToggleRinging");
            charSequenceJ2 = b.j(materialButton6, 2131896002, new Object[]{participant.getDisplayName()}, null, 4);
        } else {
            MaterialButton materialButton7 = this.binding.f;
            m.checkNotNullExpressionValue(materialButton7, "binding.voiceUserListItemToggleRinging");
            charSequenceJ2 = b.j(materialButton7, 2131894851, new Object[]{participant.getDisplayName()}, null, 4);
        }
        materialButton5.setContentDescription(charSequenceJ2);
        if (!participant.isConnected() || participant.getVoiceState() == null) {
            ImageView imageView = this.binding.f2222b;
            m.checkNotNullExpressionValue(imageView, "binding.voiceUserListItemDeafenIndicator");
            imageView.setVisibility(8);
            ImageView imageView2 = this.binding.d;
            m.checkNotNullExpressionValue(imageView2, "binding.voiceUserListItemMuteIndicator");
            imageView2.setVisibility(8);
            StreamPreviewView streamPreviewView = this.binding.i;
            m.checkNotNullExpressionValue(streamPreviewView, "binding.voiceUserListItemUserStreamPreview");
            streamPreviewView.setVisibility(8);
            ImageView imageView3 = this.binding.j;
            m.checkNotNullExpressionValue(imageView3, "binding.voiceUserListItemVideoIndicator");
            imageView3.setVisibility(8);
            ImageView imageView4 = this.binding.e;
            m.checkNotNullExpressionValue(imageView4, "binding.voiceUserListItemSpectatingIndicator");
            imageView4.setVisibility(8);
            TextView textView2 = this.binding.c;
            m.checkNotNullExpressionValue(textView2, "binding.voiceUserListItemLiveIndicator");
            textView2.setVisibility(8);
            return;
        }
        ImageView imageView5 = this.binding.f2222b;
        m.checkNotNullExpressionValue(imageView5, "binding.voiceUserListItemDeafenIndicator");
        imageView5.setVisibility(0);
        ImageView imageView6 = this.binding.d;
        m.checkNotNullExpressionValue(imageView6, "binding.voiceUserListItemMuteIndicator");
        imageView6.setVisibility(0);
        VoiceState voiceState = participant.getVoiceState();
        boolean z3 = voiceState.getSelfDeaf() || voiceState.getDeaf();
        boolean z4 = voiceState.getSelfMute() || voiceState.getMute() || voiceState.getSuppress();
        boolean selfVideo = voiceState.getSelfVideo();
        ImageView imageView7 = this.binding.e;
        m.checkNotNullExpressionValue(imageView7, "binding.voiceUserListItemSpectatingIndicator");
        imageView7.setVisibility(callParticipantsAdapter$ListItem$VoiceUser.isSpectatingSameStream() ? 0 : 8);
        ImageView imageView8 = this.binding.f2222b;
        m.checkNotNullExpressionValue(imageView8, "binding.voiceUserListItemDeafenIndicator");
        imageView8.setVisibility(z3 ? 0 : 8);
        ImageView imageView9 = this.binding.d;
        m.checkNotNullExpressionValue(imageView9, "binding.voiceUserListItemMuteIndicator");
        imageView9.setVisibility(z4 ? 0 : 8);
        ImageView imageView10 = this.binding.j;
        m.checkNotNullExpressionValue(imageView10, "binding.voiceUserListItemVideoIndicator");
        imageView10.setVisibility(selfVideo ? 0 : 8);
        StreamContext streamContext = participant.getStreamContext();
        TextView textView3 = this.binding.c;
        m.checkNotNullExpressionValue(textView3, "binding.voiceUserListItemLiveIndicator");
        textView3.setVisibility(streamContext != null ? 0 : 8);
        StoreApplicationStreamPreviews$StreamPreview preview = streamContext != null ? streamContext.getPreview() : null;
        if (preview != null) {
            StreamContext$Joinability joinability = streamContext.getJoinability();
            StreamContext$Joinability streamContext$Joinability = StreamContext$Joinability.CAN_CONNECT;
            if (joinability == streamContext$Joinability) {
                StreamPreviewView streamPreviewView2 = this.binding.i;
                m.checkNotNullExpressionValue(streamPreviewView2, "binding.voiceUserListItemUserStreamPreview");
                streamPreviewView2.setVisibility(0);
                this.binding.i.setOnClickListener(new CallParticipantsAdapter$ViewHolderUser$onConfigure$4(this, participant));
                StreamContext streamContext2 = callParticipantsAdapter$ListItem$VoiceUser.getParticipant().getStreamContext();
                if (streamContext2 != null && streamContext2.isCurrentUserParticipating()) {
                    z2 = true;
                }
                this.binding.i.a(preview, streamContext$Joinability, z2);
                return;
            }
        }
        StreamPreviewView streamPreviewView3 = this.binding.i;
        m.checkNotNullExpressionValue(streamPreviewView3, "binding.voiceUserListItemUserStreamPreview");
        streamPreviewView3.setVisibility(8);
    }
}

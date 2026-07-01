package com.discord.widgets.stage.sheet;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.R$integer;
import com.discord.R$layout;
import com.discord.databinding.StageAudienceBlockedBottomSheetItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.CutoutView;
import com.discord.widgets.user.UserNameFormatterKt;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: StageAudienceBlockedBottomSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageAudienceBlockedBottomSheetAdapter$ParticipantViewHolder extends MGRecyclerViewHolder<StageAudienceBlockedBottomSheetAdapter, MGRecyclerDataPayload> {
    private final StageAudienceBlockedBottomSheetItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageAudienceBlockedBottomSheetAdapter$ParticipantViewHolder(StageAudienceBlockedBottomSheetAdapter stageAudienceBlockedBottomSheetAdapter) {
        super(R$layout.stage_audience_blocked_bottom_sheet_item, stageAudienceBlockedBottomSheetAdapter);
        m.checkNotNullParameter(stageAudienceBlockedBottomSheetAdapter, "adapter");
        View view = this.itemView;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R$id.stage_channel_blocked_member_icon;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.stage_channel_blocked_member_icon);
        if (simpleDraweeView != null) {
            i = R$id.stage_channel_blocked_member_icon_container;
            CutoutView cutoutView = (CutoutView) view.findViewById(R$id.stage_channel_blocked_member_icon_container);
            if (cutoutView != null) {
                i = R$id.stage_channel_blocked_member_name;
                TextView textView = (TextView) view.findViewById(R$id.stage_channel_blocked_member_name);
                if (textView != null) {
                    i = R$id.stage_channel_blocked_member_speaker;
                    ImageView imageView = (ImageView) view.findViewById(R$id.stage_channel_blocked_member_speaker);
                    if (imageView != null) {
                        i = R$id.stage_channel_blocked_text;
                        TextView textView2 = (TextView) view.findViewById(R$id.stage_channel_blocked_text);
                        if (textView2 != null) {
                            i = R$id.stage_channel_blocked_text_divider;
                            View viewFindViewById = view.findViewById(R$id.stage_channel_blocked_text_divider);
                            if (viewFindViewById != null) {
                                i = R$id.stage_channel_blocked_text_speaker;
                                TextView textView3 = (TextView) view.findViewById(R$id.stage_channel_blocked_text_speaker);
                                if (textView3 != null) {
                                    StageAudienceBlockedBottomSheetItemBinding stageAudienceBlockedBottomSheetItemBinding = new StageAudienceBlockedBottomSheetItemBinding((ConstraintLayout) view, constraintLayout, simpleDraweeView, cutoutView, textView, imageView, textView2, viewFindViewById, textView3);
                                    m.checkNotNullExpressionValue(stageAudienceBlockedBottomSheetItemBinding, "StageAudienceBlockedBott…temBinding.bind(itemView)");
                                    this.binding = stageAudienceBlockedBottomSheetItemBinding;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data instanceof StageAudienceBlockedBottomSheetAdapter$ListItem$Participant) {
            StageAudienceBlockedBottomSheetAdapter$ListItem$Participant stageAudienceBlockedBottomSheetAdapter$ListItem$Participant = (StageAudienceBlockedBottomSheetAdapter$ListItem$Participant) data;
            this.binding.c.setCutoutEnabled(stageAudienceBlockedBottomSheetAdapter$ListItem$Participant.isSpeaker());
            ImageView imageView = this.binding.e;
            imageView.setBackgroundResource(2131231367);
            imageView.setImageResource(2131231919);
            imageView.setVisibility(stageAudienceBlockedBottomSheetAdapter$ListItem$Participant.isSpeaker() ? 0 : 4);
            imageView.setActivated(stageAudienceBlockedBottomSheetAdapter$ListItem$Participant.isSpeaker());
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            Resources resources = view.getResources();
            TextView textView = this.binding.f;
            m.checkNotNullExpressionValue(textView, "binding.stageChannelBlockedTextSpeaker");
            textView.setText(stageAudienceBlockedBottomSheetAdapter$ListItem$Participant.isSpeaker() ? resources.getString(2131895842) : resources.getString(2131895763));
            TextView textView2 = this.binding.d;
            User user = stageAudienceBlockedBottomSheetAdapter$ListItem$Participant.getParticipant().getUser();
            String nickname = stageAudienceBlockedBottomSheetAdapter$ListItem$Participant.getParticipant().getNickname();
            Context context = textView2.getContext();
            m.checkNotNullExpressionValue(context, "context");
            textView2.setText(UserNameFormatterKt.getSpannableForUserNameWithDiscrim(user, nickname, context, 2130968989, 2130969396, R$integer.uikit_textsize_large_sp, 2130969056, 2130969395, R$integer.uikit_textsize_medium_sp));
            SimpleDraweeView simpleDraweeView = this.binding.f2145b;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.stageChannelBlockedMemberIcon");
            IconUtils.setIcon$default(simpleDraweeView, stageAudienceBlockedBottomSheetAdapter$ListItem$Participant.getParticipant().getUser().getUsername(), Long.valueOf(stageAudienceBlockedBottomSheetAdapter$ListItem$Participant.getParticipant().getUser().getId()), stageAudienceBlockedBottomSheetAdapter$ListItem$Participant.getParticipant().getUser().getAvatar(), 2131165293, 0, null, null, stageAudienceBlockedBottomSheetAdapter$ListItem$Participant.getParticipant().getGuildMember(), 224, null);
            SimpleDraweeView simpleDraweeView2 = this.binding.f2145b;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.stageChannelBlockedMemberIcon");
            simpleDraweeView2.setAlpha(0.5f);
        }
    }
}

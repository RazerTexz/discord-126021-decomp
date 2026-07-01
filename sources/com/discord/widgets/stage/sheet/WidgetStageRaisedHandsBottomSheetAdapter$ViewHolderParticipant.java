package com.discord.widgets.stage.sheet;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.role.GuildRole;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.databinding.StageRaisedHandsItemUserBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.extensions.SimpleDraweeViewExtensionsKt;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant extends MGRecyclerViewHolder<WidgetStageRaisedHandsBottomSheetAdapter, WidgetStageRaisedHandsBottomSheetAdapter$ListItem> {
    private final StageRaisedHandsItemUserBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant(WidgetStageRaisedHandsBottomSheetAdapter widgetStageRaisedHandsBottomSheetAdapter) {
        super(R$layout.stage_raised_hands_item_user, widgetStageRaisedHandsBottomSheetAdapter);
        m.checkNotNullParameter(widgetStageRaisedHandsBottomSheetAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.stage_raised_hands_item_dismiss_button;
        ImageView imageView = (ImageView) view.findViewById(R$id.stage_raised_hands_item_dismiss_button);
        if (imageView != null) {
            i = R$id.stage_raised_hands_item_invite_button;
            ImageView imageView2 = (ImageView) view.findViewById(R$id.stage_raised_hands_item_invite_button);
            if (imageView2 != null) {
                i = R$id.stage_raised_hands_item_role;
                TextView textView = (TextView) view.findViewById(R$id.stage_raised_hands_item_role);
                if (textView != null) {
                    i = R$id.stage_raised_hands_item_user_avatar;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.stage_raised_hands_item_user_avatar);
                    if (simpleDraweeView != null) {
                        i = R$id.stage_raised_hands_item_user_name;
                        TextView textView2 = (TextView) view.findViewById(R$id.stage_raised_hands_item_user_name);
                        if (textView2 != null) {
                            StageRaisedHandsItemUserBinding stageRaisedHandsItemUserBinding = new StageRaisedHandsItemUserBinding((ConstraintLayout) view, imageView, imageView2, textView, simpleDraweeView, textView2);
                            m.checkNotNullExpressionValue(stageRaisedHandsItemUserBinding, "StageRaisedHandsItemUserBinding.bind(itemView)");
                            this.binding = stageRaisedHandsItemUserBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetStageRaisedHandsBottomSheetAdapter access$getAdapter$p(WidgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant widgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant) {
        return (WidgetStageRaisedHandsBottomSheetAdapter) widgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant.adapter;
    }

    private final String getParticipantMemberInfo(Context context, WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant data) {
        String name;
        if (isNewUser(data.getParticipant().getUser())) {
            String string = context.getString(2131894822);
            m.checkNotNullExpressionValue(string, "context.getString(R.stri…mber_info_new_to_discord)");
            return string;
        }
        GuildMember member = data.getMember();
        UtcDateTime joinedAt = member != null ? member.getJoinedAt() : null;
        if (joinedAt == null) {
            String string2 = context.getString(2131894823);
            m.checkNotNullExpressionValue(string2, "context.getString(R.stri…k_member_info_non_member)");
            return string2;
        }
        if (!data.getMember().getRoles().isEmpty()) {
            GuildRole role = data.getRole();
            if (role != null && (name = role.getName()) != null) {
                return name;
            }
            String string3 = context.getString(2131894820);
            m.checkNotNullExpressionValue(string3, "context.getString(R.stri…member_info_member_roles)");
            return string3;
        }
        if (ClockFactory.get().currentTimeMillis() - joinedAt.getDateTimeMillis() < 86400000) {
            String string4 = context.getString(2131894821);
            m.checkNotNullExpressionValue(string4, "context.getString(R.stri…k_member_info_new_member)");
            return string4;
        }
        String string5 = context.getString(2131894819);
        m.checkNotNullExpressionValue(string5, "context.getString(R.stri…speak_member_info_member)");
        return string5;
    }

    private final boolean isNewUser(User user) {
        return ClockFactory.get().currentTimeMillis() - ((user.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH) <= ((long) 604800000);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetStageRaisedHandsBottomSheetAdapter$ListItem widgetStageRaisedHandsBottomSheetAdapter$ListItem) {
        onConfigure2(i, widgetStageRaisedHandsBottomSheetAdapter$ListItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetStageRaisedHandsBottomSheetAdapter$ListItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant widgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant = (WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant) data;
        StoreVoiceParticipants$VoiceUser participant = widgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant.getParticipant();
        GuildMember member = widgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant.getMember();
        this.binding.e.setOnClickListener(new WidgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant$onConfigure$1(this, participant));
        ImageView imageView = this.binding.c;
        ViewExtensions.setEnabledAndAlpha$default(imageView, !participant.getIsInvitedToSpeak(), 0.0f, 2, null);
        imageView.setOnClickListener(new WidgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant$onConfigure$$inlined$apply$lambda$1(this, participant));
        this.binding.f2146b.setOnClickListener(new WidgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant$onConfigure$3(this, participant));
        SimpleDraweeView simpleDraweeView = this.binding.e;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.stageRaisedHandsItemUserAvatar");
        SimpleDraweeViewExtensionsKt.setAvatar$default(simpleDraweeView, participant.getUser(), false, 2131165300, participant.getGuildMember(), 2, null);
        TextView textView = this.binding.f;
        m.checkNotNullExpressionValue(textView, "binding.stageRaisedHandsItemUserName");
        textView.setText(participant.getDisplayName());
        if (member != null && member.getColor() != -16777216) {
            this.binding.f.setTextColor(member.getColor());
        }
        TextView textView2 = this.binding.d;
        Context context = textView2.getContext();
        m.checkNotNullExpressionValue(context, "context");
        textView2.setText(getParticipantMemberInfo(context, widgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant));
    }
}

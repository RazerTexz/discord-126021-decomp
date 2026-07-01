package com.discord.widgets.voice.fullscreen.stage;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetStageChannelAudienceBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.views.CutoutView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: StageCallViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AudienceViewHolder extends StageCallViewHolder {
    private final WidgetStageChannelAudienceBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudienceViewHolder(StageCallAdapter stageCallAdapter) {
        super(R$layout.widget_stage_channel_audience, stageCallAdapter, null);
        m.checkNotNullParameter(stageCallAdapter, "adapter");
        View view = this.itemView;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R$id.stage_channel_audience_member_icon;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.stage_channel_audience_member_icon);
        if (simpleDraweeView != null) {
            i = R$id.stage_channel_audience_member_icon_container;
            CutoutView cutoutView = (CutoutView) view.findViewById(R$id.stage_channel_audience_member_icon_container);
            if (cutoutView != null) {
                i = R$id.stage_channel_audience_member_name;
                TextView textView = (TextView) view.findViewById(R$id.stage_channel_audience_member_name);
                if (textView != null) {
                    i = R$id.stage_channel_audience_member_raised_hand;
                    ImageView imageView = (ImageView) view.findViewById(R$id.stage_channel_audience_member_raised_hand);
                    if (imageView != null) {
                        WidgetStageChannelAudienceBinding widgetStageChannelAudienceBinding = new WidgetStageChannelAudienceBinding((ConstraintLayout) view, constraintLayout, simpleDraweeView, cutoutView, textView, imageView);
                        m.checkNotNullExpressionValue(widgetStageChannelAudienceBinding, "WidgetStageChannelAudienceBinding.bind(itemView)");
                        this.binding = widgetStageChannelAudienceBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, StageCallItem stageCallItem) {
        onConfigure2(i, stageCallItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, StageCallItem data) {
        Drawable drawable;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StageCallItem$AudienceItem stageCallItem$AudienceItem = (StageCallItem$AudienceItem) data;
        this.binding.c.setCutoutEnabled(stageCallItem$AudienceItem.getVoiceUser().getIsRequestingToSpeak());
        ImageView imageView = this.binding.e;
        imageView.setVisibility(stageCallItem$AudienceItem.getVoiceUser().getIsRequestingToSpeak() ? 0 : 8);
        imageView.setActivated(stageCallItem$AudienceItem.getVoiceUser().getIsInvitedToSpeak());
        TextView textView = this.binding.d;
        textView.setText(stageCallItem$AudienceItem.getVoiceUser().getDisplayName());
        if (stageCallItem$AudienceItem.isBlocked()) {
            drawable = ContextCompat.getDrawable(textView.getContext(), 2131231578);
            if (drawable != null) {
                drawable.setTint(ContextCompat.getColor(textView.getContext(), 2131100382));
            }
        } else {
            drawable = null;
        }
        DrawableCompat.setCompoundDrawablesCompat$default(textView, drawable, (Drawable) null, stageCallItem$AudienceItem.getVoiceUser().isBooster() ? ContextCompat.getDrawable(textView.getContext(), 2131231581) : null, (Drawable) null, 10, (Object) null);
        User user = stageCallItem$AudienceItem.getVoiceUser().getUser();
        SimpleDraweeView simpleDraweeView = this.binding.f2649b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.stageChannelAudienceMemberIcon");
        IconUtils.setIcon$default(simpleDraweeView, user.getUsername(), Long.valueOf(user.getId()), user.getAvatar(), Integer.valueOf(user.getDiscriminator()), 2131165293, null, null, stageCallItem$AudienceItem.getVoiceUser().getGuildMember(), Opcodes.CHECKCAST, null);
    }
}

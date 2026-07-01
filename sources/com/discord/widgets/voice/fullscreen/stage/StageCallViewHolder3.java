package com.discord.widgets.voice.fullscreen.stage;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.discord.R;
import com.discord.databinding.WidgetStageChannelAudienceBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.views.CutoutView;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.stage.AudienceViewHolder, reason: use source file name */
/* JADX INFO: compiled from: StageCallViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StageCallViewHolder3 extends StageCallViewHolder {
    private final WidgetStageChannelAudienceBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCallViewHolder3(StageCallAdapter stageCallAdapter) {
        super(R.layout.widget_stage_channel_audience, stageCallAdapter, null);
        Intrinsics3.checkNotNullParameter(stageCallAdapter, "adapter");
        View view = this.itemView;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.stage_channel_audience_member_icon;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.stage_channel_audience_member_icon);
        if (simpleDraweeView != null) {
            i = R.id.stage_channel_audience_member_icon_container;
            CutoutView cutoutView = (CutoutView) view.findViewById(R.id.stage_channel_audience_member_icon_container);
            if (cutoutView != null) {
                i = R.id.stage_channel_audience_member_name;
                TextView textView = (TextView) view.findViewById(R.id.stage_channel_audience_member_name);
                if (textView != null) {
                    i = R.id.stage_channel_audience_member_raised_hand;
                    ImageView imageView = (ImageView) view.findViewById(R.id.stage_channel_audience_member_raised_hand);
                    if (imageView != null) {
                        WidgetStageChannelAudienceBinding widgetStageChannelAudienceBinding = new WidgetStageChannelAudienceBinding((ConstraintLayout) view, constraintLayout, simpleDraweeView, cutoutView, textView, imageView);
                        Intrinsics3.checkNotNullExpressionValue(widgetStageChannelAudienceBinding, "WidgetStageChannelAudienceBinding.bind(itemView)");
                        this.binding = widgetStageChannelAudienceBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, StageCallItem data) {
        Drawable drawable;
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StageCallItem.AudienceItem audienceItem = (StageCallItem.AudienceItem) data;
        this.binding.c.setCutoutEnabled(audienceItem.getVoiceUser().getIsRequestingToSpeak());
        ImageView imageView = this.binding.e;
        imageView.setVisibility(audienceItem.getVoiceUser().getIsRequestingToSpeak() ? 0 : 8);
        imageView.setActivated(audienceItem.getVoiceUser().getIsInvitedToSpeak());
        TextView textView = this.binding.d;
        textView.setText(audienceItem.getVoiceUser().getDisplayName());
        if (audienceItem.isBlocked()) {
            drawable = ContextCompat.getDrawable(textView.getContext(), R.drawable.ic_blocked_12dp);
            if (drawable != null) {
                drawable.setTint(ContextCompat.getColor(textView.getContext(), R.color.status_red_500));
            }
        } else {
            drawable = null;
        }
        DrawableCompat.setCompoundDrawablesCompat$default(textView, drawable, (Drawable) null, audienceItem.getVoiceUser().isBooster() ? ContextCompat.getDrawable(textView.getContext(), R.drawable.ic_boosted_badge_12dp) : null, (Drawable) null, 10, (Object) null);
        User user = audienceItem.getVoiceUser().getUser();
        SimpleDraweeView simpleDraweeView = this.binding.f2649b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.stageChannelAudienceMemberIcon");
        IconUtils.setIcon$default(simpleDraweeView, user.getUsername(), Long.valueOf(user.getId()), user.getAvatar(), Integer.valueOf(user.getDiscriminator()), R.dimen.avatar_size_large, null, null, audienceItem.getVoiceUser().getGuildMember(), Opcodes.CHECKCAST, null);
    }
}

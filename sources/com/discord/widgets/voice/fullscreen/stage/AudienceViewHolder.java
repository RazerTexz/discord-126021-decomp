package com.discord.widgets.voice.fullscreen.stage;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.discord.C5419R;
import com.discord.databinding.WidgetStageChannelAudienceBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.views.CutoutView;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import com.facebook.drawee.view.SimpleDraweeView;
import org.objectweb.asm.Opcodes;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StageCallViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AudienceViewHolder extends StageCallViewHolder {
    private final WidgetStageChannelAudienceBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudienceViewHolder(StageCallAdapter stageCallAdapter) {
        super(C5419R.layout.widget_stage_channel_audience, stageCallAdapter, null);
        C12238m.checkNotNullParameter(stageCallAdapter, "adapter");
        View view = this.itemView;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = C5419R.id.stage_channel_audience_member_icon;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.stage_channel_audience_member_icon);
        if (simpleDraweeView != null) {
            i = C5419R.id.stage_channel_audience_member_icon_container;
            CutoutView cutoutView = (CutoutView) view.findViewById(C5419R.id.stage_channel_audience_member_icon_container);
            if (cutoutView != null) {
                i = C5419R.id.stage_channel_audience_member_name;
                TextView textView = (TextView) view.findViewById(C5419R.id.stage_channel_audience_member_name);
                if (textView != null) {
                    i = C5419R.id.stage_channel_audience_member_raised_hand;
                    ImageView imageView = (ImageView) view.findViewById(C5419R.id.stage_channel_audience_member_raised_hand);
                    if (imageView != null) {
                        WidgetStageChannelAudienceBinding widgetStageChannelAudienceBinding = new WidgetStageChannelAudienceBinding((ConstraintLayout) view, constraintLayout, simpleDraweeView, cutoutView, textView, imageView);
                        C12238m.checkNotNullExpressionValue(widgetStageChannelAudienceBinding, "WidgetStageChannelAudienceBinding.bind(itemView)");
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
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StageCallItem.AudienceItem audienceItem = (StageCallItem.AudienceItem) data;
        this.binding.f18134c.setCutoutEnabled(audienceItem.getVoiceUser().getIsRequestingToSpeak());
        ImageView imageView = this.binding.f18136e;
        imageView.setVisibility(audienceItem.getVoiceUser().getIsRequestingToSpeak() ? 0 : 8);
        imageView.setActivated(audienceItem.getVoiceUser().getIsInvitedToSpeak());
        TextView textView = this.binding.f18135d;
        textView.setText(audienceItem.getVoiceUser().getDisplayName());
        if (audienceItem.isBlocked()) {
            drawable = ContextCompat.getDrawable(textView.getContext(), C5419R.drawable.ic_blocked_12dp);
            if (drawable != null) {
                drawable.setTint(ContextCompat.getColor(textView.getContext(), C5419R.color.status_red_500));
            }
        } else {
            drawable = null;
        }
        DrawableCompat.setCompoundDrawablesCompat$default(textView, drawable, (Drawable) null, audienceItem.getVoiceUser().isBooster() ? ContextCompat.getDrawable(textView.getContext(), C5419R.drawable.ic_boosted_badge_12dp) : null, (Drawable) null, 10, (Object) null);
        User user = audienceItem.getVoiceUser().getUser();
        SimpleDraweeView simpleDraweeView = this.binding.f18133b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.stageChannelAudienceMemberIcon");
        IconUtils.setIcon$default(simpleDraweeView, user.getUsername(), Long.valueOf(user.getId()), user.getAvatar(), Integer.valueOf(user.getDiscriminator()), C5419R.dimen.avatar_size_large, null, null, audienceItem.getVoiceUser().getGuildMember(), Opcodes.CHECKCAST, null);
    }
}

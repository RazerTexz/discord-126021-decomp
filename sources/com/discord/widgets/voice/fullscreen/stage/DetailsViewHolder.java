package com.discord.widgets.voice.fullscreen.stage;

import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetStageChannelDetailsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.locale.LocaleManager;
import d0.z.d.m;
import java.text.NumberFormat;
import java.util.Objects;

/* JADX INFO: compiled from: StageCallViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DetailsViewHolder extends StageCallViewHolder {
    private final WidgetStageChannelDetailsBinding binding;
    private final NumberFormat numberFormatter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailsViewHolder(StageCallAdapter stageCallAdapter) {
        super(R$layout.widget_stage_channel_details, stageCallAdapter, null);
        m.checkNotNullParameter(stageCallAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.public_dot;
        ImageView imageView = (ImageView) view.findViewById(R$id.public_dot);
        if (imageView != null) {
            i = R$id.public_icon;
            ImageView imageView2 = (ImageView) view.findViewById(R$id.public_icon);
            if (imageView2 != null) {
                i = R$id.public_text;
                TextView textView = (TextView) view.findViewById(R$id.public_text);
                if (textView != null) {
                    i = R$id.widget_stage_channel_details_blocked_count;
                    TextView textView2 = (TextView) view.findViewById(R$id.widget_stage_channel_details_blocked_count);
                    if (textView2 != null) {
                        i = R$id.widget_stage_channel_details_blocked_icon;
                        ImageView imageView3 = (ImageView) view.findViewById(R$id.widget_stage_channel_details_blocked_icon);
                        if (imageView3 != null) {
                            i = R$id.widget_stage_channel_details_dot;
                            ImageView imageView4 = (ImageView) view.findViewById(R$id.widget_stage_channel_details_dot);
                            if (imageView4 != null) {
                                i = R$id.widget_stage_channel_details_listener_count;
                                TextView textView3 = (TextView) view.findViewById(R$id.widget_stage_channel_details_listener_count);
                                if (textView3 != null) {
                                    i = R$id.widget_stage_channel_details_listener_icon;
                                    ImageView imageView5 = (ImageView) view.findViewById(R$id.widget_stage_channel_details_listener_icon);
                                    if (imageView5 != null) {
                                        i = R$id.widget_stage_channel_details_name;
                                        TextView textView4 = (TextView) view.findViewById(R$id.widget_stage_channel_details_name);
                                        if (textView4 != null) {
                                            i = R$id.widget_stage_channel_details_speaker_count;
                                            TextView textView5 = (TextView) view.findViewById(R$id.widget_stage_channel_details_speaker_count);
                                            if (textView5 != null) {
                                                i = R$id.widget_stage_channel_details_speaker_icon;
                                                ImageView imageView6 = (ImageView) view.findViewById(R$id.widget_stage_channel_details_speaker_icon);
                                                if (imageView6 != null) {
                                                    i = R$id.widget_stage_channel_details_topic;
                                                    TextView textView6 = (TextView) view.findViewById(R$id.widget_stage_channel_details_topic);
                                                    if (textView6 != null) {
                                                        WidgetStageChannelDetailsBinding widgetStageChannelDetailsBinding = new WidgetStageChannelDetailsBinding((ConstraintLayout) view, imageView, imageView2, textView, textView2, imageView3, imageView4, textView3, imageView5, textView4, textView5, imageView6, textView6);
                                                        m.checkNotNullExpressionValue(widgetStageChannelDetailsBinding, "WidgetStageChannelDetailsBinding.bind(itemView)");
                                                        this.binding = widgetStageChannelDetailsBinding;
                                                        LocaleManager localeManager = new LocaleManager();
                                                        View view2 = this.itemView;
                                                        m.checkNotNullExpressionValue(view2, "itemView");
                                                        this.numberFormatter = NumberFormat.getNumberInstance(localeManager.getPrimaryLocale(view2.getContext()));
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
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StageCallItem$DetailsItem stageCallItem$DetailsItem = (StageCallItem$DetailsItem) data;
        boolean z2 = stageCallItem$DetailsItem.getNumSpeakers() > 0;
        boolean z3 = stageCallItem$DetailsItem.getNumAudience() > 0;
        boolean z4 = stageCallItem$DetailsItem.getNumBlocked() > 0;
        ImageView imageView = this.binding.k;
        m.checkNotNullExpressionValue(imageView, "binding.widgetStageChannelDetailsSpeakerIcon");
        imageView.setVisibility(z2 ? 0 : 8);
        TextView textView = this.binding.j;
        m.checkNotNullExpressionValue(textView, "binding.widgetStageChannelDetailsSpeakerCount");
        textView.setVisibility(z2 ? 0 : 8);
        TextView textView2 = this.binding.j;
        m.checkNotNullExpressionValue(textView2, "binding.widgetStageChannelDetailsSpeakerCount");
        textView2.setText(this.numberFormatter.format(Integer.valueOf(stageCallItem$DetailsItem.getNumSpeakers())));
        ImageView imageView2 = this.binding.h;
        m.checkNotNullExpressionValue(imageView2, "binding.widgetStageChannelDetailsListenerIcon");
        imageView2.setVisibility(z3 ? 0 : 8);
        TextView textView3 = this.binding.g;
        m.checkNotNullExpressionValue(textView3, "binding.widgetStageChannelDetailsListenerCount");
        textView3.setVisibility(z3 ? 0 : 8);
        TextView textView4 = this.binding.g;
        m.checkNotNullExpressionValue(textView4, "binding.widgetStageChannelDetailsListenerCount");
        textView4.setText(this.numberFormatter.format(Integer.valueOf(stageCallItem$DetailsItem.getNumAudience())));
        ImageView imageView3 = this.binding.f;
        m.checkNotNullExpressionValue(imageView3, "binding.widgetStageChannelDetailsBlockedIcon");
        imageView3.setVisibility(z4 ? 0 : 8);
        TextView textView5 = this.binding.e;
        m.checkNotNullExpressionValue(textView5, "binding.widgetStageChannelDetailsBlockedCount");
        textView5.setVisibility(z4 ? 0 : 8);
        TextView textView6 = this.binding.e;
        m.checkNotNullExpressionValue(textView6, "binding.widgetStageChannelDetailsBlockedCount");
        textView6.setText(this.numberFormatter.format(Integer.valueOf(stageCallItem$DetailsItem.getNumBlocked())));
        TextView textView7 = this.binding.i;
        m.checkNotNullExpressionValue(textView7, "binding.widgetStageChannelDetailsName");
        textView7.setText(stageCallItem$DetailsItem.getDisplayName());
        TextView textView8 = this.binding.l;
        m.checkNotNullExpressionValue(textView8, "binding.widgetStageChannelDetailsTopic");
        textView8.setText(stageCallItem$DetailsItem.getTopic());
        ImageView imageView4 = this.binding.f2651b;
        m.checkNotNullExpressionValue(imageView4, "binding.publicDot");
        imageView4.setVisibility(stageCallItem$DetailsItem.isPublic() ? 0 : 8);
        ImageView imageView5 = this.binding.c;
        m.checkNotNullExpressionValue(imageView5, "binding.publicIcon");
        imageView5.setVisibility(stageCallItem$DetailsItem.isPublic() ? 0 : 8);
        TextView textView9 = this.binding.d;
        m.checkNotNullExpressionValue(textView9, "binding.publicText");
        textView9.setVisibility(stageCallItem$DetailsItem.isPublic() ? 0 : 8);
        ConstraintLayout constraintLayout = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        ViewGroup$LayoutParams layoutParams = constraintLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams) layoutParams;
        viewGroup$MarginLayoutParams.bottomMargin = (z2 || !z3) ? DimenUtils.dpToPixels(0) : DimenUtils.dpToPixels(24);
        constraintLayout.setLayoutParams(viewGroup$MarginLayoutParams);
    }
}

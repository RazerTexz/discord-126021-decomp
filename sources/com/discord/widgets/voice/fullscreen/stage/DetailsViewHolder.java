package com.discord.widgets.voice.fullscreen.stage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetStageChannelDetailsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.locale.LocaleManager;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import java.text.NumberFormat;
import java.util.Objects;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StageCallViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DetailsViewHolder extends StageCallViewHolder {
    private final WidgetStageChannelDetailsBinding binding;
    private final NumberFormat numberFormatter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailsViewHolder(StageCallAdapter stageCallAdapter) {
        super(C5419R.layout.widget_stage_channel_details, stageCallAdapter, null);
        C12238m.checkNotNullParameter(stageCallAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.public_dot;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.public_dot);
        if (imageView != null) {
            i = C5419R.id.public_icon;
            ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.public_icon);
            if (imageView2 != null) {
                i = C5419R.id.public_text;
                TextView textView = (TextView) view.findViewById(C5419R.id.public_text);
                if (textView != null) {
                    i = C5419R.id.widget_stage_channel_details_blocked_count;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.widget_stage_channel_details_blocked_count);
                    if (textView2 != null) {
                        i = C5419R.id.widget_stage_channel_details_blocked_icon;
                        ImageView imageView3 = (ImageView) view.findViewById(C5419R.id.widget_stage_channel_details_blocked_icon);
                        if (imageView3 != null) {
                            i = C5419R.id.widget_stage_channel_details_dot;
                            ImageView imageView4 = (ImageView) view.findViewById(C5419R.id.widget_stage_channel_details_dot);
                            if (imageView4 != null) {
                                i = C5419R.id.widget_stage_channel_details_listener_count;
                                TextView textView3 = (TextView) view.findViewById(C5419R.id.widget_stage_channel_details_listener_count);
                                if (textView3 != null) {
                                    i = C5419R.id.widget_stage_channel_details_listener_icon;
                                    ImageView imageView5 = (ImageView) view.findViewById(C5419R.id.widget_stage_channel_details_listener_icon);
                                    if (imageView5 != null) {
                                        i = C5419R.id.widget_stage_channel_details_name;
                                        TextView textView4 = (TextView) view.findViewById(C5419R.id.widget_stage_channel_details_name);
                                        if (textView4 != null) {
                                            i = C5419R.id.widget_stage_channel_details_speaker_count;
                                            TextView textView5 = (TextView) view.findViewById(C5419R.id.widget_stage_channel_details_speaker_count);
                                            if (textView5 != null) {
                                                i = C5419R.id.widget_stage_channel_details_speaker_icon;
                                                ImageView imageView6 = (ImageView) view.findViewById(C5419R.id.widget_stage_channel_details_speaker_icon);
                                                if (imageView6 != null) {
                                                    i = C5419R.id.widget_stage_channel_details_topic;
                                                    TextView textView6 = (TextView) view.findViewById(C5419R.id.widget_stage_channel_details_topic);
                                                    if (textView6 != null) {
                                                        WidgetStageChannelDetailsBinding widgetStageChannelDetailsBinding = new WidgetStageChannelDetailsBinding((ConstraintLayout) view, imageView, imageView2, textView, textView2, imageView3, imageView4, textView3, imageView5, textView4, textView5, imageView6, textView6);
                                                        C12238m.checkNotNullExpressionValue(widgetStageChannelDetailsBinding, "WidgetStageChannelDetailsBinding.bind(itemView)");
                                                        this.binding = widgetStageChannelDetailsBinding;
                                                        LocaleManager localeManager = new LocaleManager();
                                                        View view2 = this.itemView;
                                                        C12238m.checkNotNullExpressionValue(view2, "itemView");
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
    public void onConfigure(int position, StageCallItem data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StageCallItem.DetailsItem detailsItem = (StageCallItem.DetailsItem) data;
        boolean z2 = detailsItem.getNumSpeakers() > 0;
        boolean z3 = detailsItem.getNumAudience() > 0;
        boolean z4 = detailsItem.getNumBlocked() > 0;
        ImageView imageView = this.binding.f18149k;
        C12238m.checkNotNullExpressionValue(imageView, "binding.widgetStageChannelDetailsSpeakerIcon");
        imageView.setVisibility(z2 ? 0 : 8);
        TextView textView = this.binding.f18148j;
        C12238m.checkNotNullExpressionValue(textView, "binding.widgetStageChannelDetailsSpeakerCount");
        textView.setVisibility(z2 ? 0 : 8);
        TextView textView2 = this.binding.f18148j;
        C12238m.checkNotNullExpressionValue(textView2, "binding.widgetStageChannelDetailsSpeakerCount");
        textView2.setText(this.numberFormatter.format(Integer.valueOf(detailsItem.getNumSpeakers())));
        ImageView imageView2 = this.binding.f18146h;
        C12238m.checkNotNullExpressionValue(imageView2, "binding.widgetStageChannelDetailsListenerIcon");
        imageView2.setVisibility(z3 ? 0 : 8);
        TextView textView3 = this.binding.f18145g;
        C12238m.checkNotNullExpressionValue(textView3, "binding.widgetStageChannelDetailsListenerCount");
        textView3.setVisibility(z3 ? 0 : 8);
        TextView textView4 = this.binding.f18145g;
        C12238m.checkNotNullExpressionValue(textView4, "binding.widgetStageChannelDetailsListenerCount");
        textView4.setText(this.numberFormatter.format(Integer.valueOf(detailsItem.getNumAudience())));
        ImageView imageView3 = this.binding.f18144f;
        C12238m.checkNotNullExpressionValue(imageView3, "binding.widgetStageChannelDetailsBlockedIcon");
        imageView3.setVisibility(z4 ? 0 : 8);
        TextView textView5 = this.binding.f18143e;
        C12238m.checkNotNullExpressionValue(textView5, "binding.widgetStageChannelDetailsBlockedCount");
        textView5.setVisibility(z4 ? 0 : 8);
        TextView textView6 = this.binding.f18143e;
        C12238m.checkNotNullExpressionValue(textView6, "binding.widgetStageChannelDetailsBlockedCount");
        textView6.setText(this.numberFormatter.format(Integer.valueOf(detailsItem.getNumBlocked())));
        TextView textView7 = this.binding.f18147i;
        C12238m.checkNotNullExpressionValue(textView7, "binding.widgetStageChannelDetailsName");
        textView7.setText(detailsItem.getDisplayName());
        TextView textView8 = this.binding.f18150l;
        C12238m.checkNotNullExpressionValue(textView8, "binding.widgetStageChannelDetailsTopic");
        textView8.setText(detailsItem.getTopic());
        ImageView imageView4 = this.binding.f18140b;
        C12238m.checkNotNullExpressionValue(imageView4, "binding.publicDot");
        imageView4.setVisibility(detailsItem.isPublic() ? 0 : 8);
        ImageView imageView5 = this.binding.f18141c;
        C12238m.checkNotNullExpressionValue(imageView5, "binding.publicIcon");
        imageView5.setVisibility(detailsItem.isPublic() ? 0 : 8);
        TextView textView9 = this.binding.f18142d;
        C12238m.checkNotNullExpressionValue(textView9, "binding.publicText");
        textView9.setVisibility(detailsItem.isPublic() ? 0 : 8);
        ConstraintLayout constraintLayout = this.binding.f18139a;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = (z2 || !z3) ? DimenUtils.dpToPixels(0) : DimenUtils.dpToPixels(24);
        constraintLayout.setLayoutParams(marginLayoutParams);
    }
}

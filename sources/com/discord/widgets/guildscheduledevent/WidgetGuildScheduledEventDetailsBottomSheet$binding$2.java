package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildScheduledEventDetailsBottomSheetBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.segmentedcontrol.CardSegment;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventDetailsBottomSheet$binding$2 extends C12236k implements Function1<View, WidgetGuildScheduledEventDetailsBottomSheetBinding> {
    public static final WidgetGuildScheduledEventDetailsBottomSheet$binding$2 INSTANCE = new WidgetGuildScheduledEventDetailsBottomSheet$binding$2();

    public WidgetGuildScheduledEventDetailsBottomSheet$binding$2() {
        super(1, WidgetGuildScheduledEventDetailsBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildScheduledEventDetailsBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildScheduledEventDetailsBottomSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_scheduled_event_details_button_view;
        GuildScheduledEventBottomButtonView guildScheduledEventBottomButtonView = (GuildScheduledEventBottomButtonView) view.findViewById(C5419R.id.guild_scheduled_event_details_button_view);
        if (guildScheduledEventBottomButtonView != null) {
            i = C5419R.id.guild_scheduled_event_details_channel_icon;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.guild_scheduled_event_details_channel_icon);
            if (imageView != null) {
                i = C5419R.id.guild_scheduled_event_details_channel_name;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.guild_scheduled_event_details_channel_name);
                if (linkifiedTextView != null) {
                    i = C5419R.id.guild_scheduled_event_details_created_by;
                    TextView textView = (TextView) view.findViewById(C5419R.id.guild_scheduled_event_details_created_by);
                    if (textView != null) {
                        i = C5419R.id.guild_scheduled_event_details_creator_avatar;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.guild_scheduled_event_details_creator_avatar);
                        if (simpleDraweeView != null) {
                            i = C5419R.id.guild_scheduled_event_details_date_view;
                            GuildScheduledEventDateView guildScheduledEventDateView = (GuildScheduledEventDateView) view.findViewById(C5419R.id.guild_scheduled_event_details_date_view);
                            if (guildScheduledEventDateView != null) {
                                i = C5419R.id.guild_scheduled_event_details_desc_text;
                                LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) view.findViewById(C5419R.id.guild_scheduled_event_details_desc_text);
                                if (linkifiedTextView2 != null) {
                                    i = C5419R.id.guild_scheduled_event_details_guild_icon;
                                    SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(C5419R.id.guild_scheduled_event_details_guild_icon);
                                    if (simpleDraweeView2 != null) {
                                        i = C5419R.id.guild_scheduled_event_details_guild_name;
                                        TextView textView2 = (TextView) view.findViewById(C5419R.id.guild_scheduled_event_details_guild_name);
                                        if (textView2 != null) {
                                            i = C5419R.id.guild_scheduled_event_details_rsvp_count;
                                            TextView textView3 = (TextView) view.findViewById(C5419R.id.guild_scheduled_event_details_rsvp_count);
                                            if (textView3 != null) {
                                                i = C5419R.id.guild_scheduled_event_details_rsvp_icon;
                                                ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.guild_scheduled_event_details_rsvp_icon);
                                                if (imageView2 != null) {
                                                    i = C5419R.id.guild_scheduled_event_details_title_text;
                                                    TextView textView4 = (TextView) view.findViewById(C5419R.id.guild_scheduled_event_details_title_text);
                                                    if (textView4 != null) {
                                                        i = C5419R.id.guild_scheduled_event_empty_or_error_container;
                                                        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C5419R.id.guild_scheduled_event_empty_or_error_container);
                                                        if (constraintLayout != null) {
                                                            i = C5419R.id.guild_scheduled_event_empty_or_error_icon;
                                                            ImageView imageView3 = (ImageView) view.findViewById(C5419R.id.guild_scheduled_event_empty_or_error_icon);
                                                            if (imageView3 != null) {
                                                                i = C5419R.id.guild_scheduled_event_empty_or_error_title;
                                                                TextView textView5 = (TextView) view.findViewById(C5419R.id.guild_scheduled_event_empty_or_error_title);
                                                                if (textView5 != null) {
                                                                    i = C5419R.id.guild_scheduled_event_info_container;
                                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(C5419R.id.guild_scheduled_event_info_container);
                                                                    if (constraintLayout2 != null) {
                                                                        i = C5419R.id.guild_scheduled_event_rsvp_list_container;
                                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(C5419R.id.guild_scheduled_event_rsvp_list_container);
                                                                        if (constraintLayout3 != null) {
                                                                            i = C5419R.id.guild_scheduled_event_rsvp_list_recycler_view;
                                                                            RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.guild_scheduled_event_rsvp_list_recycler_view);
                                                                            if (recyclerView != null) {
                                                                                i = C5419R.id.loading_indicator;
                                                                                ProgressBar progressBar = (ProgressBar) view.findViewById(C5419R.id.loading_indicator);
                                                                                if (progressBar != null) {
                                                                                    i = C5419R.id.root_container;
                                                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(C5419R.id.root_container);
                                                                                    if (constraintLayout4 != null) {
                                                                                        i = C5419R.id.segmented_control;
                                                                                        SegmentedControlContainer segmentedControlContainer = (SegmentedControlContainer) view.findViewById(C5419R.id.segmented_control);
                                                                                        if (segmentedControlContainer != null) {
                                                                                            i = C5419R.id.segmented_control_event_info;
                                                                                            CardSegment cardSegment = (CardSegment) view.findViewById(C5419R.id.segmented_control_event_info);
                                                                                            if (cardSegment != null) {
                                                                                                i = C5419R.id.segmented_control_rsvp_list;
                                                                                                CardSegment cardSegment2 = (CardSegment) view.findViewById(C5419R.id.segmented_control_rsvp_list);
                                                                                                if (cardSegment2 != null) {
                                                                                                    return new WidgetGuildScheduledEventDetailsBottomSheetBinding((NestedScrollView) view, guildScheduledEventBottomButtonView, imageView, linkifiedTextView, textView, simpleDraweeView, guildScheduledEventDateView, linkifiedTextView2, simpleDraweeView2, textView2, textView3, imageView2, textView4, constraintLayout, imageView3, textView5, constraintLayout2, constraintLayout3, recyclerView, progressBar, constraintLayout4, segmentedControlContainer, cardSegment, cardSegment2);
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
}

package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.databinding.GuildScheduledEventBottomButtonViewBinding;
import com.discord.databinding.GuildScheduledEventItemViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.guild.UserGuildMember;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.extensions.SimpleDraweeViewExtensionsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.string.StringUtilsKt;
import com.discord.utilities.textview.TextViewFadeHelper;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventListItem;
import com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration;
import com.discord.widgets.guildscheduledevent.buttonconfiguration.DirectoryButtonConfiguration;
import com.discord.widgets.guildscheduledevent.buttonconfiguration.GuildButtonConfiguration;
import com.discord.widgets.hubs.events.HubGuildScheduledEventData;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.C1107b;
import p507d0.C12083g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildScheduledEventItemView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventItemView extends ConstraintLayout {
    private final GuildScheduledEventItemViewBinding binding;

    /* JADX INFO: renamed from: descriptionParser$delegate, reason: from kotlin metadata */
    private final Lazy descriptionParser;

    /* JADX INFO: renamed from: locationParser$delegate, reason: from kotlin metadata */
    private final Lazy locationParser;

    public GuildScheduledEventItemView(Context context) {
        this(context, null, 0, 6, null);
    }

    public GuildScheduledEventItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ GuildScheduledEventItemView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void configureDescription(String description, long guildId) {
        getDescriptionParser().configureDescription(description, guildId);
    }

    private final void configureInternal(GuildScheduledEvent guildScheduledEvent, GuildScheduledEventLocationInfo locationInfo, ButtonConfiguration buttonConfiguration, Guild guild, UserGuildMember creator, View.OnClickListener onCardClicked) {
        String str;
        GuildScheduledEventBottomButtonView guildScheduledEventBottomButtonView = this.binding.f15137b;
        C12238m.checkNotNullExpressionValue(guildScheduledEventBottomButtonView, "binding.guildScheduledEventListItemButtomView");
        guildScheduledEventBottomButtonView.setVisibility(buttonConfiguration.getIsAnyButtonVisible() ? 0 : 8);
        this.binding.f15137b.configure(buttonConfiguration);
        TextView textView = this.binding.f15146k;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildScheduledEventListItemRsvpText");
        Integer userCount = guildScheduledEvent.getUserCount();
        if (userCount != null) {
            int iIntValue = userCount.intValue();
            Context context = getContext();
            C12238m.checkNotNullExpressionValue(context, "context");
            str = StringUtilsKt.format(iIntValue, context);
        } else {
            str = null;
        }
        ViewExtensions.setTextAndVisibilityBy(textView, str);
        SimpleDraweeView simpleDraweeView = this.binding.f15139d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildScheduledEventListItemCreatorAvatar");
        SimpleDraweeViewExtensionsKt.configureCreator(simpleDraweeView, creator);
        GuildScheduledEventDateView.configure$default(this.binding.f15140e, guildScheduledEvent, false, 2, null);
        TextView textView2 = this.binding.f15147l;
        C12238m.checkNotNullExpressionValue(textView2, "binding.guildScheduledEventListItemTitleText");
        textView2.setText(guildScheduledEvent.getName());
        configureDescription(guildScheduledEvent.getDescription(), guildScheduledEvent.getGuildId());
        configureLocation(locationInfo, guild);
        this.binding.f15136a.setOnClickListener(onCardClicked);
    }

    private final void configureLocation(GuildScheduledEventLocationInfo locationInfo, Guild guild) {
        CharSequence textFromLocation;
        int i;
        int locationIconSmall;
        if (locationInfo == null && guild == null) {
            ConstraintLayout constraintLayout = this.binding.f15138c;
            C12238m.checkNotNullExpressionValue(constraintLayout, "binding.guildScheduledEv…ItemChannelGuildContainer");
            constraintLayout.setVisibility(8);
            return;
        }
        if (locationInfo != null && guild == null) {
            ConstraintLayout constraintLayout2 = this.binding.f15138c;
            C12238m.checkNotNullExpressionValue(constraintLayout2, "binding.guildScheduledEv…ItemChannelGuildContainer");
            constraintLayout2.setVisibility(0);
            SimpleDraweeView simpleDraweeView = this.binding.f15143h;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildScheduledEventListItemGuildIcon");
            simpleDraweeView.setVisibility(8);
            TextView textView = this.binding.f15144i;
            C12238m.checkNotNullExpressionValue(textView, "binding.guildScheduledEv…mGuildIconPlaceholderText");
            textView.setVisibility(8);
            TextView textView2 = this.binding.f15145j;
            C12238m.checkNotNullExpressionValue(textView2, "binding.guildScheduledEventListItemGuildName");
            textView2.setVisibility(8);
            TextView textView3 = this.binding.f15142g;
            C12238m.checkNotNullExpressionValue(textView3, "binding.guildScheduledEv…tListItemGuildChannelName");
            textView3.setVisibility(8);
            ImageView imageView = this.binding.f15148m;
            imageView.setVisibility(0);
            imageView.setImageResource(locationInfo.getLocationIcon());
            LinkifiedTextView linkifiedTextView = this.binding.f15149n;
            linkifiedTextView.setVisibility(0);
            GuildScheduledEventExternalLocationParser locationParser = getLocationParser();
            Context context = linkifiedTextView.getContext();
            C12238m.checkNotNullExpressionValue(context, "context");
            linkifiedTextView.setText(locationParser.getTextFromLocation(context, locationInfo));
            C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.standaloneChanne…xt, locationInfo)\n      }");
            return;
        }
        if (guild != null) {
            ConstraintLayout constraintLayout3 = this.binding.f15138c;
            C12238m.checkNotNullExpressionValue(constraintLayout3, "binding.guildScheduledEv…ItemChannelGuildContainer");
            constraintLayout3.setVisibility(0);
            ImageView imageView2 = this.binding.f15148m;
            C12238m.checkNotNullExpressionValue(imageView2, "binding.standaloneChannelIcon");
            imageView2.setVisibility(8);
            LinkifiedTextView linkifiedTextView2 = this.binding.f15149n;
            C12238m.checkNotNullExpressionValue(linkifiedTextView2, "binding.standaloneChannelName");
            linkifiedTextView2.setVisibility(8);
            SimpleDraweeView simpleDraweeView2 = this.binding.f15143h;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildScheduledEventListItemGuildIcon");
            simpleDraweeView2.setVisibility(0);
            TextView textView4 = this.binding.f15144i;
            C12238m.checkNotNullExpressionValue(textView4, "binding.guildScheduledEv…mGuildIconPlaceholderText");
            textView4.setVisibility(0);
            TextView textView5 = this.binding.f15144i;
            textView5.setText(guild.getShortName());
            textView5.setVisibility(guild.hasIcon() ^ true ? 0 : 8);
            SimpleDraweeView simpleDraweeView3 = this.binding.f15143h;
            C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.guildScheduledEventListItemGuildIcon");
            SimpleDraweeViewExtensionsKt.setGuildIcon(simpleDraweeView3, true, (496 & 2) != 0 ? null : guild, getResources().getDimensionPixelSize(C5419R.dimen.guild_scheduled_event_icon_corner_radius), (496 & 8) != 0 ? null : Integer.valueOf(IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(C5419R.dimen.avatar_size_standard))), (496 & 16) != 0 ? null : null, (496 & 32) != 0 ? null : null, (496 & 64) != 0 ? null : null, (496 & 128) != 0 ? false : false, (496 & 256) != 0 ? null : null);
            TextView textView6 = this.binding.f15145j;
            C12238m.checkNotNullExpressionValue(textView6, "binding.guildScheduledEventListItemGuildName");
            textView6.setText(guild.getName());
            TextView textView7 = this.binding.f15142g;
            C12238m.checkNotNullExpressionValue(textView7, "binding.guildScheduledEv…tListItemGuildChannelName");
            textView7.setVisibility(locationInfo != null ? 0 : 8);
            TextView textView8 = this.binding.f15142g;
            C12238m.checkNotNullExpressionValue(textView8, "binding.guildScheduledEv…tListItemGuildChannelName");
            if (locationInfo != null) {
                GuildScheduledEventExternalLocationParser locationParser2 = getLocationParser();
                Context context2 = getContext();
                C12238m.checkNotNullExpressionValue(context2, "context");
                textFromLocation = locationParser2.getTextFromLocation(context2, locationInfo);
            } else {
                textFromLocation = null;
            }
            ViewExtensions.setTextAndVisibilityBy(textView8, textFromLocation);
            TextView textView9 = this.binding.f15142g;
            if (locationInfo != null) {
                locationIconSmall = locationInfo.getLocationIconSmall();
                i = 0;
            } else {
                i = 0;
                locationIconSmall = 0;
            }
            textView9.setCompoundDrawablesWithIntrinsicBounds(locationIconSmall, i, i, i);
        }
    }

    public static /* synthetic */ void configureLocation$default(GuildScheduledEventItemView guildScheduledEventItemView, GuildScheduledEventLocationInfo guildScheduledEventLocationInfo, Guild guild, int i, Object obj) {
        if ((i & 2) != 0) {
            guild = null;
        }
        guildScheduledEventItemView.configureLocation(guildScheduledEventLocationInfo, guild);
    }

    private final GuildScheduledEventDescriptionParser getDescriptionParser() {
        return (GuildScheduledEventDescriptionParser) this.descriptionParser.getValue();
    }

    private final GuildScheduledEventExternalLocationParser getLocationParser() {
        return (GuildScheduledEventExternalLocationParser) this.locationParser.getValue();
    }

    public final void configureAsPreview(GuildScheduledEventModel eventModel, Channel channel, UserGuildMember creator) {
        Long lValueOf;
        C12238m.checkNotNullParameter(eventModel, "eventModel");
        GuildScheduledEventPickerDateTime guildScheduledEventPickerDateTime = GuildScheduledEventPickerDateTime.INSTANCE;
        long millis = guildScheduledEventPickerDateTime.toMillis(eventModel.getStartDate(), eventModel.getStartTime());
        GuildScheduledEventPickerDate endDate = eventModel.getEndDate();
        if (endDate != null) {
            GuildScheduledEventPickerTime endTime = eventModel.getEndTime();
            lValueOf = endTime != null ? Long.valueOf(guildScheduledEventPickerDateTime.toMillis(endDate, endTime)) : null;
        } else {
            lValueOf = null;
        }
        ConstraintLayout constraintLayout = this.binding.f15136a;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        constraintLayout.setBackground(ContextCompat.getDrawable(getContext(), C5419R.drawable.bg_guild_scheduled_event_list_item_floating));
        TextView textView = this.binding.f15146k;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildScheduledEventListItemRsvpText");
        textView.setBackgroundTintList(ColorCompat.INSTANCE.createDefaultColorStateList(ColorCompat.getThemedColor(getContext(), C5419R.attr.colorBackgroundTertiary)));
        SimpleDraweeView simpleDraweeView = this.binding.f15139d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildScheduledEventListItemCreatorAvatar");
        SimpleDraweeViewExtensionsKt.configureCreator(simpleDraweeView, creator);
        TextView textView2 = this.binding.f15146k;
        C12238m.checkNotNullExpressionValue(textView2, "binding.guildScheduledEventListItemRsvpText");
        Integer userCount = eventModel.getUserCount();
        ViewExtensions.setTextAndVisibilityBy(textView2, userCount != null ? String.valueOf(userCount.intValue()) : null);
        GuildScheduledEventBottomButtonView guildScheduledEventBottomButtonView = this.binding.f15137b;
        C12238m.checkNotNullExpressionValue(guildScheduledEventBottomButtonView, "binding.guildScheduledEventListItemButtomView");
        guildScheduledEventBottomButtonView.setVisibility(8);
        TextView textView3 = this.binding.f15147l;
        C12238m.checkNotNullExpressionValue(textView3, "binding.guildScheduledEventListItemTitleText");
        textView3.setText(eventModel.getName());
        configureDescription(eventModel.getDescription(), eventModel.getGuildId());
        this.binding.f15140e.configure(millis, lValueOf, eventModel.getEntityType(), GuildScheduledEventStatus.SCHEDULED, (16 & 16) != 0);
        configureLocation$default(this, GuildScheduledEventLocationInfo.INSTANCE.buildLocationInfo(eventModel, channel), null, 2, null);
    }

    public final void configureInChatList(GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember creator, boolean isInGuild, boolean isRsvped, boolean isConnected, boolean canConnect, View.OnClickListener cardClickListener, View.OnClickListener rsvpButtonClickListener, View.OnClickListener joinServerButtonClickListener, View.OnClickListener shareButtonClickListener) {
        C12238m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        C12238m.checkNotNullParameter(rsvpButtonClickListener, "rsvpButtonClickListener");
        C12238m.checkNotNullParameter(joinServerButtonClickListener, "joinServerButtonClickListener");
        C12238m.checkNotNullParameter(shareButtonClickListener, "shareButtonClickListener");
        configureInternal(guildScheduledEvent, GuildScheduledEventLocationInfo.INSTANCE.buildLocationInfo(guildScheduledEvent, channel), new GuildButtonConfiguration(guildScheduledEvent, true, false, isConnected, canConnect, true, isRsvped, false, rsvpButtonClickListener, joinServerButtonClickListener, null, joinServerButtonClickListener, shareButtonClickListener, null, 9344, null), guild, creator, cardClickListener);
        ConstraintLayout constraintLayout = this.binding.f15136a;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        constraintLayout.setBackground((isConnected && guildScheduledEvent.getStatus() == GuildScheduledEventStatus.ACTIVE) ? ContextCompat.getDrawable(getContext(), C5419R.drawable.bg_guild_scheduled_event_list_item_connected_secondary) : ContextCompat.getDrawable(getContext(), C5419R.drawable.bg_guild_scheduled_event_list_item_secondary));
        TextView textView = this.binding.f15146k;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildScheduledEventListItemRsvpText");
        textView.setBackgroundTintList(ColorCompat.INSTANCE.createDefaultColorStateList(ColorCompat.getThemedColor(getContext(), C5419R.attr.colorBackgroundTertiary)));
        TextView textView2 = this.binding.f15147l;
        ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = DimenUtils.dpToPixels(8);
        textView2.setLayoutParams(marginLayoutParams);
        GuildScheduledEventBottomButtonViewBinding binding = this.binding.f15137b.getBinding();
        TextView textView3 = binding.f15129d;
        C12238m.checkNotNullExpressionValue(textView3, "buttonBinding.primaryButtonText");
        Context context = getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        textView3.setText(C1107b.m216h(context, C5419R.string.guild_event_invite_embed_join_server_button_label, new Object[0], null, 4));
        TextView textView4 = binding.f15129d;
        C12238m.checkNotNullExpressionValue(textView4, "buttonBinding.primaryButtonText");
        textView4.setVisibility(isInGuild ^ true ? 0 : 8);
        ImageView imageView = binding.f15128c;
        C12238m.checkNotNullExpressionValue(imageView, "buttonBinding.primaryButton");
        imageView.setVisibility(isInGuild ^ true ? 0 : 8);
        ImageView imageView2 = binding.f15130e;
        C12238m.checkNotNullExpressionValue(imageView2, "buttonBinding.secondaryButton");
        imageView2.setVisibility(isInGuild ? 0 : 8);
        TextView textView5 = binding.f15131f;
        C12238m.checkNotNullExpressionValue(textView5, "buttonBinding.secondaryButtonText");
        textView5.setVisibility(isInGuild ? 0 : 8);
    }

    public final void configureInDirectoryEventList(HubGuildScheduledEventData eventData, View.OnClickListener cardClickListener, View.OnClickListener secondaryButtonOnClickListener, View.OnClickListener primaryButtonOnClickListener, View.OnClickListener shareButtonOnClickListener) {
        C12238m.checkNotNullParameter(eventData, "eventData");
        C12238m.checkNotNullParameter(cardClickListener, "cardClickListener");
        C12238m.checkNotNullParameter(secondaryButtonOnClickListener, "secondaryButtonOnClickListener");
        C12238m.checkNotNullParameter(primaryButtonOnClickListener, "primaryButtonOnClickListener");
        C12238m.checkNotNullParameter(shareButtonOnClickListener, "shareButtonOnClickListener");
        GuildScheduledEvent event = eventData.getEvent();
        com.discord.api.guild.Guild guild = eventData.getEvent().getGuild();
        configureInternal(event, null, new DirectoryButtonConfiguration(eventData.getEvent(), eventData.isInGuild(), eventData.isRsvped(), false, primaryButtonOnClickListener, secondaryButtonOnClickListener, shareButtonOnClickListener, new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView.configureInDirectoryEventList.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        }), guild != null ? new Guild(guild) : null, null, cardClickListener);
    }

    public final void configureInEventList(GuildScheduledEventListItem.Event item, View.OnClickListener cardClickListener, View.OnClickListener rsvpButtonClickListener, View.OnClickListener eventStartButtonClickListener, View.OnClickListener shareButtonClickListener, View.OnClickListener joinButtonClickListener) {
        C12238m.checkNotNullParameter(item, "item");
        C12238m.checkNotNullParameter(cardClickListener, "cardClickListener");
        C12238m.checkNotNullParameter(rsvpButtonClickListener, "rsvpButtonClickListener");
        C12238m.checkNotNullParameter(eventStartButtonClickListener, "eventStartButtonClickListener");
        C12238m.checkNotNullParameter(shareButtonClickListener, "shareButtonClickListener");
        C12238m.checkNotNullParameter(joinButtonClickListener, "joinButtonClickListener");
        configureInternal(item.getEvent(), GuildScheduledEventLocationInfo.INSTANCE.buildLocationInfo(item.getEvent(), item.getChannel()), new GuildButtonConfiguration(item.getEvent(), true, item.getCanStartEvent(), item.isConnected(), item.getCanConnect(), true, item.isRsvped(), false, rsvpButtonClickListener, joinButtonClickListener, null, eventStartButtonClickListener, shareButtonClickListener, null, 9344, null), null, item.getCreator(), cardClickListener);
        ConstraintLayout constraintLayout = this.binding.f15136a;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        constraintLayout.setBackground((item.isConnected() && item.getEvent().getStatus() == GuildScheduledEventStatus.ACTIVE) ? ContextCompat.getDrawable(getContext(), C5419R.drawable.bg_guild_scheduled_event_list_item_connected_primary) : ContextCompat.getDrawable(getContext(), C5419R.drawable.bg_guild_scheduled_event_list_item_primary));
    }

    public final void configureInVoiceChannel(GuildScheduledEvent guildScheduledEvent, UserGuildMember creator, boolean canStartEvent, boolean isCollapsed, boolean isConnected, boolean isCallPreview, View.OnClickListener onCardClicked, View.OnClickListener onStartEventButtonClicked) {
        Drawable drawable;
        C12238m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        C12238m.checkNotNullParameter(onCardClicked, "onCardClicked");
        C12238m.checkNotNullParameter(onStartEventButtonClicked, "onStartEventButtonClicked");
        configureInternal(guildScheduledEvent, null, new GuildButtonConfiguration(guildScheduledEvent, false, canStartEvent, isConnected, false, true, false, false, null, null, null, onStartEventButtonClicked, null, null, 14208, null), null, creator, onCardClicked);
        ConstraintLayout constraintLayout = this.binding.f15136a;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        if (isConnected && guildScheduledEvent.getStatus() == GuildScheduledEventStatus.ACTIVE) {
            drawable = isCallPreview ? ContextCompat.getDrawable(getContext(), C5419R.drawable.bg_guild_scheduled_event_list_item_connected_dark) : ContextCompat.getDrawable(getContext(), C5419R.drawable.bg_guild_scheduled_event_list_item_connected_secondary);
        } else {
            drawable = isCallPreview ? ContextCompat.getDrawable(getContext(), C5419R.drawable.bg_guild_scheduled_event_list_item_dark) : ContextCompat.getDrawable(getContext(), C5419R.drawable.bg_guild_scheduled_event_list_item_secondary);
        }
        constraintLayout.setBackground(drawable);
        TextView textView = this.binding.f15146k;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildScheduledEventListItemRsvpText");
        textView.setVisibility(8);
        if (isCollapsed) {
            LinkifiedTextView linkifiedTextView = this.binding.f15141f;
            C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.guildScheduledEventListItemDescText");
            linkifiedTextView.setVisibility(8);
        }
        GuildScheduledEventBottomButtonView guildScheduledEventBottomButtonView = this.binding.f15137b;
        C12238m.checkNotNullExpressionValue(guildScheduledEventBottomButtonView, "binding.guildScheduledEventListItemButtomView");
        guildScheduledEventBottomButtonView.setVisibility(canStartEvent && !isCollapsed ? 0 : 8);
        TextView textView2 = this.binding.f15147l;
        if (isCollapsed) {
            textView2.setMaxLines(Integer.MAX_VALUE);
            textView2.setEllipsize(null);
        } else {
            textView2.setMaxLines(1);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.guild_scheduled_event_item_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i2 = C5419R.id.guild_scheduled_event_list_item_buttom_view;
        GuildScheduledEventBottomButtonView guildScheduledEventBottomButtonView = (GuildScheduledEventBottomButtonView) viewInflate.findViewById(C5419R.id.guild_scheduled_event_list_item_buttom_view);
        if (guildScheduledEventBottomButtonView != null) {
            i2 = C5419R.id.guild_scheduled_event_list_item_channel_guild_container;
            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(C5419R.id.guild_scheduled_event_list_item_channel_guild_container);
            if (constraintLayout != null) {
                i2 = C5419R.id.guild_scheduled_event_list_item_creator_avatar;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(C5419R.id.guild_scheduled_event_list_item_creator_avatar);
                if (simpleDraweeView != null) {
                    i2 = C5419R.id.guild_scheduled_event_list_item_date_view;
                    GuildScheduledEventDateView guildScheduledEventDateView = (GuildScheduledEventDateView) viewInflate.findViewById(C5419R.id.guild_scheduled_event_list_item_date_view);
                    if (guildScheduledEventDateView != null) {
                        i2 = C5419R.id.guild_scheduled_event_list_item_desc_text;
                        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewInflate.findViewById(C5419R.id.guild_scheduled_event_list_item_desc_text);
                        if (linkifiedTextView != null) {
                            i2 = C5419R.id.guild_scheduled_event_list_item_guild_channel_name;
                            TextView textView = (TextView) viewInflate.findViewById(C5419R.id.guild_scheduled_event_list_item_guild_channel_name);
                            if (textView != null) {
                                i2 = C5419R.id.guild_scheduled_event_list_item_guild_icon;
                                SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewInflate.findViewById(C5419R.id.guild_scheduled_event_list_item_guild_icon);
                                if (simpleDraweeView2 != null) {
                                    i2 = C5419R.id.guild_scheduled_event_list_item_guild_icon_placeholder_text;
                                    TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.guild_scheduled_event_list_item_guild_icon_placeholder_text);
                                    if (textView2 != null) {
                                        i2 = C5419R.id.guild_scheduled_event_list_item_guild_name;
                                        TextView textView3 = (TextView) viewInflate.findViewById(C5419R.id.guild_scheduled_event_list_item_guild_name);
                                        if (textView3 != null) {
                                            i2 = C5419R.id.guild_scheduled_event_list_item_rsvp_text;
                                            TextView textView4 = (TextView) viewInflate.findViewById(C5419R.id.guild_scheduled_event_list_item_rsvp_text);
                                            if (textView4 != null) {
                                                i2 = C5419R.id.guild_scheduled_event_list_item_title_text;
                                                TextView textView5 = (TextView) viewInflate.findViewById(C5419R.id.guild_scheduled_event_list_item_title_text);
                                                if (textView5 != null) {
                                                    i2 = C5419R.id.header_barrier;
                                                    Barrier barrier = (Barrier) viewInflate.findViewById(C5419R.id.header_barrier);
                                                    if (barrier != null) {
                                                        i2 = C5419R.id.standalone_channel_icon;
                                                        ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.standalone_channel_icon);
                                                        if (imageView != null) {
                                                            i2 = C5419R.id.standalone_channel_name;
                                                            LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) viewInflate.findViewById(C5419R.id.standalone_channel_name);
                                                            if (linkifiedTextView2 != null) {
                                                                GuildScheduledEventItemViewBinding guildScheduledEventItemViewBinding = new GuildScheduledEventItemViewBinding((ConstraintLayout) viewInflate, guildScheduledEventBottomButtonView, constraintLayout, simpleDraweeView, guildScheduledEventDateView, linkifiedTextView, textView, simpleDraweeView2, textView2, textView3, textView4, textView5, barrier, imageView, linkifiedTextView2);
                                                                C12238m.checkNotNullExpressionValue(guildScheduledEventItemViewBinding, "GuildScheduledEventItemV…rom(context), this, true)");
                                                                this.binding = guildScheduledEventItemViewBinding;
                                                                this.descriptionParser = C12083g.lazy(new GuildScheduledEventItemView$descriptionParser$2(this));
                                                                this.locationParser = C12083g.lazy(GuildScheduledEventItemView$locationParser$2.INSTANCE);
                                                                C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.guildScheduledEventListItemDescText");
                                                                new TextViewFadeHelper(linkifiedTextView).registerFadeHelper();
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }
}

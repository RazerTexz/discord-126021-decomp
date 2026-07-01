package com.discord.widgets.channels.list;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.c.a.a0.d;
import com.discord.R$id;
import com.discord.api.channel.Channel;
import com.discord.api.voice.state.VoiceState;
import com.discord.databinding.WidgetChannelsListItemVoiceUserBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.member.GuildMember$Companion;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceUser;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemVoiceUser extends WidgetChannelsListAdapter$Item {
    private final WidgetChannelsListItemVoiceUserBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemVoiceUser(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
        super(i, widgetChannelsListAdapter);
        m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
        View view = this.itemView;
        int i2 = R$id.channels_item_voice_user_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.channels_item_voice_user_avatar);
        if (simpleDraweeView != null) {
            i2 = R$id.channels_item_voice_user_camera;
            ImageView imageView = (ImageView) view.findViewById(R$id.channels_item_voice_user_camera);
            if (imageView != null) {
                i2 = R$id.channels_item_voice_user_headphones;
                ImageView imageView2 = (ImageView) view.findViewById(R$id.channels_item_voice_user_headphones);
                if (imageView2 != null) {
                    i2 = R$id.channels_item_voice_user_live;
                    TextView textView = (TextView) view.findViewById(R$id.channels_item_voice_user_live);
                    if (textView != null) {
                        i2 = R$id.channels_item_voice_user_microphone;
                        ImageView imageView3 = (ImageView) view.findViewById(R$id.channels_item_voice_user_microphone);
                        if (imageView3 != null) {
                            i2 = R$id.channels_item_voice_user_name;
                            TextView textView2 = (TextView) view.findViewById(R$id.channels_item_voice_user_name);
                            if (textView2 != null) {
                                i2 = R$id.indicators_container;
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.indicators_container);
                                if (linearLayout != null) {
                                    WidgetChannelsListItemVoiceUserBinding widgetChannelsListItemVoiceUserBinding = new WidgetChannelsListItemVoiceUserBinding((RelativeLayout) view, simpleDraweeView, imageView, imageView2, textView, imageView3, textView2, linearLayout);
                                    m.checkNotNullExpressionValue(widgetChannelsListItemVoiceUserBinding, "WidgetChannelsListItemVo…serBinding.bind(itemView)");
                                    this.binding = widgetChannelsListItemVoiceUserBinding;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(WidgetChannelsListAdapter$ItemVoiceUser widgetChannelsListAdapter$ItemVoiceUser) {
        return (WidgetChannelsListAdapter) widgetChannelsListAdapter$ItemVoiceUser.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
        onConfigure2(i, channelListItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, ChannelListItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ChannelListItemVoiceUser channelListItemVoiceUser = (ChannelListItemVoiceUser) data;
        Channel channel = channelListItemVoiceUser.getChannel();
        VoiceState voiceState = channelListItemVoiceUser.getVoiceState();
        User user = channelListItemVoiceUser.getUser();
        GuildMember computed = channelListItemVoiceUser.getComputed();
        boolean isApplicationStreaming = channelListItemVoiceUser.getIsApplicationStreaming();
        boolean hasChannelConnectPermission = channelListItemVoiceUser.getHasChannelConnectPermission();
        SimpleDraweeView simpleDraweeView = this.binding.f2299b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.channelsItemVoiceUserAvatar");
        IconUtils.setIcon$default(simpleDraweeView, user, 2131165299, null, null, channelListItemVoiceUser.getComputed(), 24, null);
        RelativeLayout relativeLayout = this.binding.a;
        m.checkNotNullExpressionValue(relativeLayout, "binding.root");
        ViewExtensions.setOnLongClickListenerConsumeClick(relativeLayout, new WidgetChannelsListAdapter$ItemVoiceUser$onConfigure$1(this, data));
        this.binding.a.setOnClickListener(new WidgetChannelsListAdapter$ItemVoiceUser$onConfigure$2(this, data));
        TextView textView = this.binding.g;
        m.checkNotNullExpressionValue(textView, "binding.channelsItemVoiceUserName");
        textView.setText(GuildMember$Companion.getNickOrUsername$default(GuildMember.Companion, user, computed, channel, null, 8, null));
        ImageView imageView = this.binding.c;
        m.checkNotNullExpressionValue(imageView, "binding.channelsItemVoiceUserCamera");
        imageView.setVisibility(voiceState.getSelfVideo() ? 0 : 8);
        ImageView imageView2 = this.binding.f;
        m.checkNotNullExpressionValue(imageView2, "binding.channelsItemVoiceUserMicrophone");
        imageView2.setVisibility(d.V0(voiceState) ? 0 : 8);
        ImageView imageView3 = this.binding.d;
        m.checkNotNullExpressionValue(imageView3, "binding.channelsItemVoiceUserHeadphones");
        imageView3.setVisibility(voiceState.getSelfDeaf() || voiceState.getDeaf() ? 0 : 8);
        TextView textView2 = this.binding.e;
        m.checkNotNullExpressionValue(textView2, "binding.channelsItemVoiceUserLive");
        textView2.setVisibility(isApplicationStreaming && hasChannelConnectPermission ? 0 : 8);
    }
}

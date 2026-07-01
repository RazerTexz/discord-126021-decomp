package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteSettings$ChannelsSpinnerAdapter extends ArrayAdapter<Channel> {
    private Channel[] channels;

    public /* synthetic */ WidgetGuildInviteSettings$ChannelsSpinnerAdapter(Context context, int i, Channel[] channelArr, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i, (i2 & 4) != 0 ? new Channel[0] : channelArr);
    }

    private final View getItemView(int position, int layoutId, View convertView, boolean dropDownMode) {
        if (convertView == null) {
            convertView = View.inflate(getContext(), layoutId, null);
        }
        m.checkNotNullExpressionValue(convertView, "view");
        setupViews(convertView, position, dropDownMode);
        return convertView;
    }

    private final void setupViews(View convertView, int position, boolean dropDownMode) {
        TextView textView = (TextView) convertView.findViewById(new WidgetGuildInviteSettings$ChannelsSpinnerAdapter$setupViews$1(dropDownMode).invoke2());
        m.checkNotNullExpressionValue(textView, "label");
        String str = String.format("#%s", Arrays.copyOf(new Object[]{ChannelUtils.c(this.channels[position])}, 1));
        m.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        textView.setText(str);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.channels.length;
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        m.checkNotNullParameter(parent, "parent");
        return getItemView(position, R$layout.view_invite_settngs_channel_spinner_item_open, convertView, true);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int i) {
        return getItem(i);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        m.checkNotNullParameter(parent, "parent");
        return getItemView(position, R$layout.view_invite_settings_channel_spinner_item, convertView, false);
    }

    public final void setData(Channel[] newData) {
        m.checkNotNullParameter(newData, "newData");
        this.channels = newData;
        notifyDataSetChanged();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteSettings$ChannelsSpinnerAdapter(Context context, int i, Channel[] channelArr) {
        super(context, i, channelArr);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(channelArr, "channels");
        this.channels = channelArr;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public Channel getItem(int position) {
        return this.channels[position];
    }
}

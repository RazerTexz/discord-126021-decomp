package com.discord.widgets.servers.auditlog;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetServerSettingsAuditLogListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.auditlogs.AuditLogUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder extends MGRecyclerViewHolder<WidgetServerSettingsAuditLogAdapter, MGRecyclerDataPayload> {
    private final WidgetServerSettingsAuditLogListItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder(WidgetServerSettingsAuditLogAdapter widgetServerSettingsAuditLogAdapter) {
        super(R$layout.widget_server_settings_audit_log_list_item, widgetServerSettingsAuditLogAdapter);
        m.checkNotNullParameter(widgetServerSettingsAuditLogAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.audit_log_listitem_action_container;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.audit_log_listitem_action_container);
        if (frameLayout != null) {
            i = R$id.audit_log_listitem_actiontype_image;
            ImageView imageView = (ImageView) view.findViewById(R$id.audit_log_listitem_actiontype_image);
            if (imageView != null) {
                i = R$id.audit_log_listitem_arrow;
                ImageView imageView2 = (ImageView) view.findViewById(R$id.audit_log_listitem_arrow);
                if (imageView2 != null) {
                    i = R$id.audit_log_listitem_avatar;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.audit_log_listitem_avatar);
                    if (simpleDraweeView != null) {
                        i = R$id.audit_log_listitem_change_text;
                        TextView textView = (TextView) view.findViewById(R$id.audit_log_listitem_change_text);
                        if (textView != null) {
                            i = R$id.audit_log_listitem_date_text;
                            TextView textView2 = (TextView) view.findViewById(R$id.audit_log_listitem_date_text);
                            if (textView2 != null) {
                                i = R$id.audit_log_listitem_header_text;
                                TextView textView3 = (TextView) view.findViewById(R$id.audit_log_listitem_header_text);
                                if (textView3 != null) {
                                    i = R$id.audit_log_listitem_targettype_image;
                                    ImageView imageView3 = (ImageView) view.findViewById(R$id.audit_log_listitem_targettype_image);
                                    if (imageView3 != null) {
                                        i = R$id.audit_log_listitem_top_container;
                                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R$id.audit_log_listitem_top_container);
                                        if (relativeLayout != null) {
                                            WidgetServerSettingsAuditLogListItemBinding widgetServerSettingsAuditLogListItemBinding = new WidgetServerSettingsAuditLogListItemBinding((CardView) view, frameLayout, imageView, imageView2, simpleDraweeView, textView, textView2, textView3, imageView3, relativeLayout);
                                            m.checkNotNullExpressionValue(widgetServerSettingsAuditLogListItemBinding, "WidgetServerSettingsAudi…temBinding.bind(itemView)");
                                            this.binding = widgetServerSettingsAuditLogListItemBinding;
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetServerSettingsAuditLogAdapter access$getAdapter$p(WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder widgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder) {
        return (WidgetServerSettingsAuditLogAdapter) widgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        WidgetServerSettingsAuditLogAdapter$AuditLogEntryItem widgetServerSettingsAuditLogAdapter$AuditLogEntryItem = (WidgetServerSettingsAuditLogAdapter$AuditLogEntryItem) data;
        ModelAuditLogEntry auditLogEntry = widgetServerSettingsAuditLogAdapter$AuditLogEntryItem.getAuditLogEntry();
        User user = widgetServerSettingsAuditLogAdapter$AuditLogEntryItem.getUser();
        GuildMember guildMember = widgetServerSettingsAuditLogAdapter$AuditLogEntryItem.getGuildMember();
        ImageView imageView = this.binding.f2542b;
        AuditLogUtils auditLogUtils = AuditLogUtils.INSTANCE;
        imageView.setImageResource(auditLogUtils.getActionTypeImage(auditLogEntry.getActionTypeId()));
        ImageView imageView2 = this.binding.h;
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        imageView2.setImageResource(auditLogUtils.getTargetTypeImage(view, auditLogEntry.getActionTypeId()));
        SimpleDraweeView simpleDraweeView = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.auditLogListitemAvatar");
        IconUtils.setIcon$default(simpleDraweeView, user, 0, null, null, guildMember, 28, null);
        this.binding.d.setOnClickListener(new WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder$onConfigure$1(this, user, guildMember));
        TextView textView = this.binding.f;
        m.checkNotNullExpressionValue(textView, "binding.auditLogListitemDateText");
        textView.setText(widgetServerSettingsAuditLogAdapter$AuditLogEntryItem.getTimeStampText());
        TextView textView2 = this.binding.g;
        m.checkNotNullExpressionValue(textView2, "binding.auditLogListitemHeaderText");
        CharSequence headerText = widgetServerSettingsAuditLogAdapter$AuditLogEntryItem.getHeaderText();
        textView2.setText(headerText != null ? b.l(headerText, new Object[0], null, 2) : null);
        TextView textView3 = this.binding.e;
        m.checkNotNullExpressionValue(textView3, "binding.auditLogListitemChangeText");
        textView3.setVisibility(widgetServerSettingsAuditLogAdapter$AuditLogEntryItem.getIsSelected() && widgetServerSettingsAuditLogAdapter$AuditLogEntryItem.getHasChangesToRender() ? 0 : 8);
        ImageView imageView3 = this.binding.c;
        m.checkNotNullExpressionValue(imageView3, "binding.auditLogListitemArrow");
        imageView3.setVisibility(widgetServerSettingsAuditLogAdapter$AuditLogEntryItem.getHasChangesToRender() ? 0 : 4);
        if (widgetServerSettingsAuditLogAdapter$AuditLogEntryItem.getIsSelected() && widgetServerSettingsAuditLogAdapter$AuditLogEntryItem.getHasChangesToRender()) {
            TextView textView4 = this.binding.e;
            m.checkNotNullExpressionValue(textView4, "binding.auditLogListitemChangeText");
            textView4.setText(widgetServerSettingsAuditLogAdapter$AuditLogEntryItem.getChangeText());
            this.binding.c.setImageResource(2131231664);
            RelativeLayout relativeLayout = this.binding.i;
            View view2 = this.itemView;
            m.checkNotNullExpressionValue(view2, "itemView");
            relativeLayout.setBackgroundColor(ColorCompat.getThemedColor(view2, 2130969998));
            if (WidgetServerSettingsAuditLogAdapter.access$getEnsureExpandedIsVisible$p((WidgetServerSettingsAuditLogAdapter) this.adapter)) {
                WidgetServerSettingsAuditLogAdapter.access$setEnsureExpandedIsVisible$p((WidgetServerSettingsAuditLogAdapter) this.adapter, false);
                ((WidgetServerSettingsAuditLogAdapter) this.adapter).getRecycler().post(new WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder$onConfigure$2(this));
            }
        } else {
            this.binding.c.setImageResource(2131231668);
            RelativeLayout relativeLayout2 = this.binding.i;
            View view3 = this.itemView;
            m.checkNotNullExpressionValue(view3, "itemView");
            relativeLayout2.setBackgroundColor(ColorCompat.getThemedColor(view3, 2130969991));
        }
        this.itemView.setOnClickListener(new WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder$onConfigure$3(this, data));
    }
}

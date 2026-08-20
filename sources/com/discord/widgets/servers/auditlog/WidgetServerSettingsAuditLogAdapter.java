package com.discord.widgets.servers.auditlog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetServerSettingsAuditLogListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.auditlogs.AuditLogUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> {
    private static final int ENTRY_ITEM = 0;
    private static final int LOADING_ITEM = 1;
    private boolean ensureExpandedIsVisible;
    private Function2<? super Long, ? super Long, Unit> onAuditLogAvatarClicked;

    /* JADX INFO: compiled from: WidgetServerSettingsAuditLogAdapter.kt */
    public static final class AuditLogEntryItem implements MGRecyclerDataPayload {
        private final ModelAuditLogEntry auditLogEntry;
        private final CharSequence changeText;
        private final GuildMember guildMember;
        private final boolean hasChangesToRender;
        private final CharSequence headerText;
        private final boolean isSelected;
        private final String key;
        private final CharSequence timeStampText;
        private final int type;
        private final User user;

        public AuditLogEntryItem(ModelAuditLogEntry modelAuditLogEntry, boolean z2, User user, GuildMember guildMember, CharSequence charSequence, CharSequence charSequence2, boolean z3, CharSequence charSequence3) {
            C12238m.checkNotNullParameter(modelAuditLogEntry, "auditLogEntry");
            C12238m.checkNotNullParameter(charSequence3, "timeStampText");
            this.auditLogEntry = modelAuditLogEntry;
            this.isSelected = z2;
            this.user = user;
            this.guildMember = guildMember;
            this.headerText = charSequence;
            this.changeText = charSequence2;
            this.hasChangesToRender = z3;
            this.timeStampText = charSequence3;
            this.key = String.valueOf(modelAuditLogEntry.getId());
        }

        public final ModelAuditLogEntry getAuditLogEntry() {
            return this.auditLogEntry;
        }

        public final CharSequence getChangeText() {
            return this.changeText;
        }

        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        public final boolean getHasChangesToRender() {
            return this.hasChangesToRender;
        }

        public final CharSequence getHeaderText() {
            return this.headerText;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final CharSequence getTimeStampText() {
            return this.timeStampText;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final User getUser() {
            return this.user;
        }

        /* JADX INFO: renamed from: isSelected, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsAuditLogAdapter.kt */
    public static final class AuditLogEntryViewHolder extends MGRecyclerViewHolder<WidgetServerSettingsAuditLogAdapter, MGRecyclerDataPayload> {
        private final WidgetServerSettingsAuditLogListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuditLogEntryViewHolder(WidgetServerSettingsAuditLogAdapter widgetServerSettingsAuditLogAdapter) {
            super(C5419R.layout.widget_server_settings_audit_log_list_item, widgetServerSettingsAuditLogAdapter);
            C12238m.checkNotNullParameter(widgetServerSettingsAuditLogAdapter, "adapter");
            View view = this.itemView;
            int i = C5419R.id.audit_log_listitem_action_container;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(C5419R.id.audit_log_listitem_action_container);
            if (frameLayout != null) {
                i = C5419R.id.audit_log_listitem_actiontype_image;
                ImageView imageView = (ImageView) view.findViewById(C5419R.id.audit_log_listitem_actiontype_image);
                if (imageView != null) {
                    i = C5419R.id.audit_log_listitem_arrow;
                    ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.audit_log_listitem_arrow);
                    if (imageView2 != null) {
                        i = C5419R.id.audit_log_listitem_avatar;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.audit_log_listitem_avatar);
                        if (simpleDraweeView != null) {
                            i = C5419R.id.audit_log_listitem_change_text;
                            TextView textView = (TextView) view.findViewById(C5419R.id.audit_log_listitem_change_text);
                            if (textView != null) {
                                i = C5419R.id.audit_log_listitem_date_text;
                                TextView textView2 = (TextView) view.findViewById(C5419R.id.audit_log_listitem_date_text);
                                if (textView2 != null) {
                                    i = C5419R.id.audit_log_listitem_header_text;
                                    TextView textView3 = (TextView) view.findViewById(C5419R.id.audit_log_listitem_header_text);
                                    if (textView3 != null) {
                                        i = C5419R.id.audit_log_listitem_targettype_image;
                                        ImageView imageView3 = (ImageView) view.findViewById(C5419R.id.audit_log_listitem_targettype_image);
                                        if (imageView3 != null) {
                                            i = C5419R.id.audit_log_listitem_top_container;
                                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C5419R.id.audit_log_listitem_top_container);
                                            if (relativeLayout != null) {
                                                WidgetServerSettingsAuditLogListItemBinding widgetServerSettingsAuditLogListItemBinding = new WidgetServerSettingsAuditLogListItemBinding((CardView) view, frameLayout, imageView, imageView2, simpleDraweeView, textView, textView2, textView3, imageView3, relativeLayout);
                                                C12238m.checkNotNullExpressionValue(widgetServerSettingsAuditLogListItemBinding, "WidgetServerSettingsAudi…temBinding.bind(itemView)");
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

        public static final /* synthetic */ WidgetServerSettingsAuditLogAdapter access$getAdapter$p(AuditLogEntryViewHolder auditLogEntryViewHolder) {
            return (WidgetServerSettingsAuditLogAdapter) auditLogEntryViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, final MGRecyclerDataPayload data) {
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            AuditLogEntryItem auditLogEntryItem = (AuditLogEntryItem) data;
            ModelAuditLogEntry auditLogEntry = auditLogEntryItem.getAuditLogEntry();
            final User user = auditLogEntryItem.getUser();
            final GuildMember guildMember = auditLogEntryItem.getGuildMember();
            ImageView imageView = this.binding.f17522b;
            AuditLogUtils auditLogUtils = AuditLogUtils.INSTANCE;
            imageView.setImageResource(auditLogUtils.getActionTypeImage(auditLogEntry.getActionTypeId()));
            ImageView imageView2 = this.binding.f17528h;
            View view = this.itemView;
            C12238m.checkNotNullExpressionValue(view, "itemView");
            imageView2.setImageResource(auditLogUtils.getTargetTypeImage(view, auditLogEntry.getActionTypeId()));
            SimpleDraweeView simpleDraweeView = this.binding.f17524d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.auditLogListitemAvatar");
            IconUtils.setIcon$default(simpleDraweeView, user, 0, null, null, guildMember, 28, null);
            this.binding.f17524d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    if (user != null) {
                        Function2<Long, Long, Unit> onAuditLogAvatarClicked = WidgetServerSettingsAuditLogAdapter.AuditLogEntryViewHolder.access$getAdapter$p(this.this$0).getOnAuditLogAvatarClicked();
                        Long lValueOf = Long.valueOf(user.getId());
                        GuildMember guildMember2 = guildMember;
                        onAuditLogAvatarClicked.invoke(lValueOf, guildMember2 != null ? Long.valueOf(guildMember2.getGuildId()) : null);
                    }
                }
            });
            TextView textView = this.binding.f17526f;
            C12238m.checkNotNullExpressionValue(textView, "binding.auditLogListitemDateText");
            textView.setText(auditLogEntryItem.getTimeStampText());
            TextView textView2 = this.binding.f17527g;
            C12238m.checkNotNullExpressionValue(textView2, "binding.auditLogListitemHeaderText");
            CharSequence headerText = auditLogEntryItem.getHeaderText();
            textView2.setText(headerText != null ? C1107b.m215g(headerText, new Object[0], (2 & 2) != 0 ? C1107b.e.f1494j : null) : null);
            TextView textView3 = this.binding.f17525e;
            C12238m.checkNotNullExpressionValue(textView3, "binding.auditLogListitemChangeText");
            textView3.setVisibility(auditLogEntryItem.getIsSelected() && auditLogEntryItem.getHasChangesToRender() ? 0 : 8);
            ImageView imageView3 = this.binding.f17523c;
            C12238m.checkNotNullExpressionValue(imageView3, "binding.auditLogListitemArrow");
            imageView3.setVisibility(auditLogEntryItem.getHasChangesToRender() ? 0 : 4);
            if (auditLogEntryItem.getIsSelected() && auditLogEntryItem.getHasChangesToRender()) {
                TextView textView4 = this.binding.f17525e;
                C12238m.checkNotNullExpressionValue(textView4, "binding.auditLogListitemChangeText");
                textView4.setText(auditLogEntryItem.getChangeText());
                this.binding.f17523c.setImageResource(C5419R.drawable.ic_chevron_down_grey_12dp);
                RelativeLayout relativeLayout = this.binding.f17529i;
                View view2 = this.itemView;
                C12238m.checkNotNullExpressionValue(view2, "itemView");
                relativeLayout.setBackgroundColor(ColorCompat.getThemedColor(view2, C5419R.attr.primary_700_alpha_60));
                if (((WidgetServerSettingsAuditLogAdapter) this.adapter).ensureExpandedIsVisible) {
                    ((WidgetServerSettingsAuditLogAdapter) this.adapter).ensureExpandedIsVisible = false;
                    ((WidgetServerSettingsAuditLogAdapter) this.adapter).getRecycler().post(new Runnable() { // from class: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder$onConfigure$2
                        @Override // java.lang.Runnable
                        public final void run() {
                            RecyclerView.LayoutManager layoutManager = WidgetServerSettingsAuditLogAdapter.AuditLogEntryViewHolder.access$getAdapter$p(this.this$0).getRecycler().getLayoutManager();
                            if (!(layoutManager instanceof LinearLayoutManager)) {
                                layoutManager = null;
                            }
                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                            if (linearLayoutManager != null) {
                                int iFindFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                                int iMin = Math.min(linearLayoutManager.findLastCompletelyVisibleItemPosition(), WidgetServerSettingsAuditLogAdapter.AuditLogEntryViewHolder.access$getAdapter$p(this.this$0).getPageSize() - 1);
                                int adapterPosition = this.this$0.getAdapterPosition();
                                if (iFindFirstCompletelyVisibleItemPosition >= 0 && iMin >= iFindFirstCompletelyVisibleItemPosition && adapterPosition >= 0) {
                                    if (iFindFirstCompletelyVisibleItemPosition > adapterPosition || iMin < adapterPosition) {
                                        WidgetServerSettingsAuditLogAdapter.AuditLogEntryViewHolder.access$getAdapter$p(this.this$0).getRecycler().smoothScrollToPosition(this.this$0.getAdapterPosition());
                                    }
                                }
                            }
                        }
                    });
                }
            } else {
                this.binding.f17523c.setImageResource(C5419R.drawable.ic_chevron_right_grey_12dp);
                RelativeLayout relativeLayout2 = this.binding.f17529i;
                View view3 = this.itemView;
                C12238m.checkNotNullExpressionValue(view3, "itemView");
                relativeLayout2.setBackgroundColor(ColorCompat.getThemedColor(view3, C5419R.attr.primary_630));
            }
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder$onConfigure$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    WidgetServerSettingsAuditLogAdapter.AuditLogEntryViewHolder.access$getAdapter$p(this.this$0).ensureExpandedIsVisible = true;
                    StoreStream.INSTANCE.getAuditLog().toggleSelectedState(((WidgetServerSettingsAuditLogAdapter.AuditLogEntryItem) data).getAuditLogEntry().getId());
                }
            });
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsAuditLogAdapter.kt */
    public static final class AuditLogLoadingItem implements MGRecyclerDataPayload {
        private final int type = 1;
        private final String key = "loading";

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsAuditLogAdapter.kt */
    public static final class AuditLogLoadingViewHolder extends MGRecyclerViewHolder<WidgetServerSettingsAuditLogAdapter, MGRecyclerDataPayload> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuditLogLoadingViewHolder(WidgetServerSettingsAuditLogAdapter widgetServerSettingsAuditLogAdapter) {
            super(C5419R.layout.widget_server_settings_audit_log_loading_listitem, widgetServerSettingsAuditLogAdapter);
            C12238m.checkNotNullParameter(widgetServerSettingsAuditLogAdapter, "adapter");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLogAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        C12238m.checkNotNullParameter(recyclerView, "recycler");
        this.onAuditLogAvatarClicked = WidgetServerSettingsAuditLogAdapter$onAuditLogAvatarClicked$1.INSTANCE;
    }

    public final void configure(List<? extends MGRecyclerDataPayload> auditLogEntryItems) {
        C12238m.checkNotNullParameter(auditLogEntryItems, "auditLogEntryItems");
        setData(auditLogEntryItems);
    }

    public final Function2<Long, Long, Unit> getOnAuditLogAvatarClicked() {
        return this.onAuditLogAvatarClicked;
    }

    public final void setOnAuditLogAvatarClicked(Function2<? super Long, ? super Long, Unit> function2) {
        C12238m.checkNotNullParameter(function2, "<set-?>");
        this.onAuditLogAvatarClicked = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new AuditLogEntryViewHolder(this);
        }
        if (viewType == 1) {
            return new AuditLogLoadingViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}

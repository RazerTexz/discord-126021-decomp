package com.discord.widgets.servers.auditlog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsAuditLogFilterActionListitemBinding;
import com.discord.databinding.WidgetServerSettingsAuditLogFilterUserListitemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.auditlogs.AuditLogUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.CheckedSetting;
import com.discord.views.user.SettingsMemberView;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilterAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> {
    public static final int FILTER_TYPE_ACTION = 1;
    public static final int FILTER_TYPE_USER = 0;
    private Function2<? super Long, ? super Long, Unit> onAuditLogAvatarClicked;
    private Function0<Unit> onFilterSelectedCallback;

    /* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
    public static final class AuditLogActionFilterItem implements MGRecyclerDataPayload {
        private final int actionId;
        private final boolean isChecked;
        private final String key;
        private final String text;
        private final int type;

        public AuditLogActionFilterItem(int i, String str, boolean z2) {
            Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            this.actionId = i;
            this.text = str;
            this.isChecked = z2;
            this.type = 1;
            this.key = String.valueOf(i);
        }

        public final int getActionId() {
            return this.actionId;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final String getText() {
            return this.text;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: isChecked, reason: from getter */
        public final boolean getIsChecked() {
            return this.isChecked;
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
    public static final class AuditLogFilterActionViewHolder extends MGRecyclerViewHolder<WidgetServerSettingsAuditLogFilterAdapter, MGRecyclerDataPayload> {
        private final WidgetServerSettingsAuditLogFilterActionListitemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuditLogFilterActionViewHolder(WidgetServerSettingsAuditLogFilterAdapter widgetServerSettingsAuditLogFilterAdapter) {
            super(R.layout.widget_server_settings_audit_log_filter_action_listitem, widgetServerSettingsAuditLogFilterAdapter);
            Intrinsics3.checkNotNullParameter(widgetServerSettingsAuditLogFilterAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.audit_log_filter_cs;
            CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.audit_log_filter_cs);
            if (checkedSetting != null) {
                i = R.id.audit_log_filter_image_action;
                ImageView imageView = (ImageView) view.findViewById(R.id.audit_log_filter_image_action);
                if (imageView != null) {
                    i = R.id.audit_log_filter_image_container;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.audit_log_filter_image_container);
                    if (frameLayout != null) {
                        i = R.id.audit_log_filter_image_target;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.audit_log_filter_image_target);
                        if (imageView2 != null) {
                            WidgetServerSettingsAuditLogFilterActionListitemBinding widgetServerSettingsAuditLogFilterActionListitemBinding = new WidgetServerSettingsAuditLogFilterActionListitemBinding((LinearLayout) view, checkedSetting, imageView, frameLayout, imageView2);
                            Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsAuditLogFilterActionListitemBinding, "WidgetServerSettingsAudi…temBinding.bind(itemView)");
                            this.binding = widgetServerSettingsAuditLogFilterActionListitemBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter access$getAdapter$p(AuditLogFilterActionViewHolder auditLogFilterActionViewHolder) {
            return (WidgetServerSettingsAuditLogFilterAdapter) auditLogFilterActionViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            final AuditLogActionFilterItem auditLogActionFilterItem = (AuditLogActionFilterItem) data;
            ImageView imageView = this.binding.d;
            AuditLogUtils auditLogUtils = AuditLogUtils.INSTANCE;
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            imageView.setImageResource(auditLogUtils.getTargetTypeImage(view, auditLogActionFilterItem.getActionId()));
            this.binding.c.setImageResource(auditLogUtils.getActionTypeImage(auditLogActionFilterItem.getActionId()));
            this.binding.f2540b.setText(auditLogActionFilterItem.getText());
            CheckedSetting checkedSetting = this.binding.f2540b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.auditLogFilterCs");
            checkedSetting.setChecked(auditLogActionFilterItem.getIsChecked());
            this.binding.f2540b.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterActionViewHolder$onConfigure$1
                @Override // rx.functions.Action1
                public final void call(Boolean bool) {
                    StoreStream.INSTANCE.getAuditLog().setAuditLogFilterActionId(auditLogActionFilterItem.getActionId());
                    Function0 function0 = WidgetServerSettingsAuditLogFilterAdapter.AuditLogFilterActionViewHolder.access$getAdapter$p(this.this$0).onFilterSelectedCallback;
                    if (function0 != null) {
                    }
                }
            });
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
    public static final class AuditLogFilterUserViewHolder extends MGRecyclerViewHolder<WidgetServerSettingsAuditLogFilterAdapter, MGRecyclerDataPayload> {
        private final WidgetServerSettingsAuditLogFilterUserListitemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuditLogFilterUserViewHolder(WidgetServerSettingsAuditLogFilterAdapter widgetServerSettingsAuditLogFilterAdapter) {
            super(R.layout.widget_server_settings_audit_log_filter_user_listitem, widgetServerSettingsAuditLogFilterAdapter);
            Intrinsics3.checkNotNullParameter(widgetServerSettingsAuditLogFilterAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.audit_log_filter_radio_button;
            MaterialRadioButton materialRadioButton = (MaterialRadioButton) view.findViewById(R.id.audit_log_filter_radio_button);
            if (materialRadioButton != null) {
                i = R.id.item_icon;
                ImageView imageView = (ImageView) view.findViewById(R.id.item_icon);
                if (imageView != null) {
                    i = R.id.non_member_text;
                    TextView textView = (TextView) view.findViewById(R.id.non_member_text);
                    if (textView != null) {
                        i = R.id.settings_member_view;
                        SettingsMemberView settingsMemberView = (SettingsMemberView) view.findViewById(R.id.settings_member_view);
                        if (settingsMemberView != null) {
                            WidgetServerSettingsAuditLogFilterUserListitemBinding widgetServerSettingsAuditLogFilterUserListitemBinding = new WidgetServerSettingsAuditLogFilterUserListitemBinding((FrameLayout) view, materialRadioButton, imageView, textView, settingsMemberView);
                            Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsAuditLogFilterUserListitemBinding, "WidgetServerSettingsAudi…temBinding.bind(itemView)");
                            this.binding = widgetServerSettingsAuditLogFilterUserListitemBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter access$getAdapter$p(AuditLogFilterUserViewHolder auditLogFilterUserViewHolder) {
            return (WidgetServerSettingsAuditLogFilterAdapter) auditLogFilterUserViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            final AuditLogUserFilterItem auditLogUserFilterItem = (AuditLogUserFilterItem) data;
            User user = auditLogUserFilterItem.getUser();
            boolean z2 = (auditLogUserFilterItem.getId() == 0 || user == null) ? false : true;
            SettingsMemberView settingsMemberView = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(settingsMemberView, "binding.settingsMemberView");
            settingsMemberView.setVisibility(z2 ? 0 : 8);
            TextView textView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.nonMemberText");
            textView.setVisibility(z2 ^ true ? 0 : 8);
            ImageView imageView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.itemIcon");
            imageView.setVisibility(z2 ^ true ? 0 : 8);
            if (z2) {
                SettingsMemberView settingsMemberView2 = this.binding.e;
                Intrinsics3.checkNotNull(user);
                settingsMemberView2.a(user, auditLogUserFilterItem.getGuildMember());
            } else {
                TextView textView2 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.nonMemberText");
                CharSequence text = auditLogUserFilterItem.getText();
                if (text == null) {
                    text = "";
                }
                textView2.setText(text);
            }
            MaterialRadioButton materialRadioButton = this.binding.f2541b;
            Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.auditLogFilterRadioButton");
            materialRadioButton.setChecked(auditLogUserFilterItem.getIsChecked());
            this.binding.f2541b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder$onConfigure$1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                    if (z3) {
                        StoreStream.INSTANCE.getAuditLog().setAuditLogFilterUserId(auditLogUserFilterItem.getId());
                        Function0 function0 = WidgetServerSettingsAuditLogFilterAdapter.AuditLogFilterUserViewHolder.access$getAdapter$p(this.this$0).onFilterSelectedCallback;
                        if (function0 != null) {
                        }
                    }
                }
            });
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder$onConfigure$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MaterialRadioButton materialRadioButton2 = this.this$0.binding.f2541b;
                    Intrinsics3.checkNotNullExpressionValue(materialRadioButton2, "binding.auditLogFilterRadioButton");
                    materialRadioButton2.setChecked(true);
                }
            });
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
    public static final class AuditLogUserFilterItem implements MGRecyclerDataPayload {
        private final Integer discriminator;
        private final GuildMember guildMember;
        private final long id;
        private final boolean isChecked;
        private final String key;
        private final CharSequence text;
        private final int type;
        private final User user;

        public AuditLogUserFilterItem(User user, GuildMember guildMember, long j, CharSequence charSequence, Integer num, boolean z2) {
            this.user = user;
            this.guildMember = guildMember;
            this.id = j;
            this.text = charSequence;
            this.discriminator = num;
            this.isChecked = z2;
            this.key = String.valueOf(j);
        }

        public final Integer getDiscriminator() {
            return this.discriminator;
        }

        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        public final long getId() {
            return this.id;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final CharSequence getText() {
            return this.text;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final User getUser() {
            return this.user;
        }

        /* JADX INFO: renamed from: isChecked, reason: from getter */
        public final boolean getIsChecked() {
            return this.isChecked;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLogFilterAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.onAuditLogAvatarClicked = WidgetServerSettingsAuditLogFilterAdapter5.INSTANCE;
    }

    public final void configure(List<? extends MGRecyclerDataPayload> listItems, Function0<Unit> onFilterSelectedCallback) {
        Intrinsics3.checkNotNullParameter(listItems, "listItems");
        Intrinsics3.checkNotNullParameter(onFilterSelectedCallback, "onFilterSelectedCallback");
        this.onFilterSelectedCallback = onFilterSelectedCallback;
        setData(listItems);
    }

    public final Function2<Long, Long, Unit> getOnAuditLogAvatarClicked() {
        return this.onAuditLogAvatarClicked;
    }

    public final void setOnAuditLogAvatarClicked(Function2<? super Long, ? super Long, Unit> function2) {
        Intrinsics3.checkNotNullParameter(function2, "<set-?>");
        this.onAuditLogAvatarClicked = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new AuditLogFilterUserViewHolder(this);
        }
        if (viewType == 1) {
            return new AuditLogFilterActionViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}

package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.databinding.WidgetChatListAdapterItemGuildTemplateBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildTemplate;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GuildTemplateEntry;
import com.discord.widgets.guilds.create.WidgetGuildClone;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildTemplate extends WidgetChatListItem {
    private final WidgetChatListAdapterItemGuildTemplateBinding binding;
    private GuildTemplateEntry item;
    private Subscription subscription;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGuildTemplate(WidgetChatListAdapter widgetChatListAdapter) {
        super(R$layout.widget_chat_list_adapter_item_guild_template, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.item_guild_template_header;
        TextView textView = (TextView) view.findViewById(R$id.item_guild_template_header);
        if (textView != null) {
            i = R$id.item_guild_template_image;
            ImageView imageView = (ImageView) view.findViewById(R$id.item_guild_template_image);
            if (imageView != null) {
                i = R$id.item_guild_template_join_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.item_guild_template_join_button);
                if (materialButton != null) {
                    i = R$id.item_guild_template_name;
                    TextView textView2 = (TextView) view.findViewById(R$id.item_guild_template_name);
                    if (textView2 != null) {
                        i = R$id.item_guild_template_subtext;
                        TextView textView3 = (TextView) view.findViewById(R$id.item_guild_template_subtext);
                        if (textView3 != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            WidgetChatListAdapterItemGuildTemplateBinding widgetChatListAdapterItemGuildTemplateBinding = new WidgetChatListAdapterItemGuildTemplateBinding(constraintLayout, textView, imageView, materialButton, textView2, textView3, constraintLayout);
                            m.checkNotNullExpressionValue(widgetChatListAdapterItemGuildTemplateBinding, "WidgetChatListAdapterIte…ateBinding.bind(itemView)");
                            this.binding = widgetChatListAdapterItemGuildTemplateBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ void access$configureInvalidUI(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate) {
        widgetChatListAdapterItemGuildTemplate.configureInvalidUI();
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate, WidgetChatListAdapterItemGuildTemplate$Model widgetChatListAdapterItemGuildTemplate$Model) {
        widgetChatListAdapterItemGuildTemplate.configureUI(widgetChatListAdapterItemGuildTemplate$Model);
    }

    public static final /* synthetic */ Subscription access$getSubscription$p(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate) {
        return widgetChatListAdapterItemGuildTemplate.subscription;
    }

    public static final /* synthetic */ void access$openGuildTemplate(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate, Context context, ModelGuildTemplate modelGuildTemplate) {
        widgetChatListAdapterItemGuildTemplate.openGuildTemplate(context, modelGuildTemplate);
    }

    public static final /* synthetic */ void access$setSubscription$p(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate, Subscription subscription) {
        widgetChatListAdapterItemGuildTemplate.subscription = subscription;
    }

    private final void configureInvalidUI() {
        this.binding.c.setText(2131891570);
        this.binding.d.setText(2131891569);
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.itemGuildTemplateSubtext");
        textView.setVisibility(0);
        MaterialButton materialButton = this.binding.f2323b;
        m.checkNotNullExpressionValue(materialButton, "binding.itemGuildTemplateJoinButton");
        materialButton.setVisibility(8);
    }

    private final void configureLoadingUI() {
        this.binding.c.setText(2131891638);
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.itemGuildTemplateSubtext");
        textView.setVisibility(8);
        MaterialButton materialButton = this.binding.f2323b;
        m.checkNotNullExpressionValue(materialButton, "binding.itemGuildTemplateJoinButton");
        materialButton.setVisibility(8);
    }

    private final void configureResolvedUI(WidgetChatListAdapterItemGuildTemplate$Model$Resolved model) {
        ModelGuildTemplate guildTemplate = model.getGuildTemplate();
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.itemGuildTemplateName");
        textView.setText(guildTemplate.getName());
        TextView textView2 = this.binding.d;
        m.checkNotNullExpressionValue(textView2, "binding.itemGuildTemplateSubtext");
        ViewExtensions.setTextAndVisibilityBy(textView2, StringResourceUtilsKt.getI18nPluralString(a.I(this.binding.d, "binding.itemGuildTemplateSubtext", "binding.itemGuildTemplateSubtext.context"), R$plurals.guild_template_usages_usageCount, guildTemplate.getUsageCount(), Integer.valueOf(guildTemplate.getUsageCount())));
        MaterialButton materialButton = this.binding.f2323b;
        m.checkNotNullExpressionValue(materialButton, "binding.itemGuildTemplateJoinButton");
        materialButton.setVisibility(0);
        this.binding.f2323b.setOnClickListener(new WidgetChatListAdapterItemGuildTemplate$configureResolvedUI$1(this, guildTemplate));
    }

    private final void configureUI(WidgetChatListAdapterItemGuildTemplate$Model model) {
        if (model instanceof WidgetChatListAdapterItemGuildTemplate$Model$Loading) {
            configureLoadingUI();
        } else if (model instanceof WidgetChatListAdapterItemGuildTemplate$Model$Resolved) {
            configureResolvedUI((WidgetChatListAdapterItemGuildTemplate$Model$Resolved) model);
        } else {
            if (!(model instanceof WidgetChatListAdapterItemGuildTemplate$Model$Invalid)) {
                throw new NoWhenBranchMatchedException();
            }
            configureInvalidUI();
        }
    }

    private final void openGuildTemplate(Context context, ModelGuildTemplate guildTemplate) {
        WidgetGuildClone.Companion.show(context, guildTemplate.getCode(), "Guild Template Embed");
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        GuildTemplateEntry guildTemplateEntry = (GuildTemplateEntry) data;
        this.item = guildTemplateEntry;
        WidgetChatListAdapterItemGuildTemplate$ModelProvider widgetChatListAdapterItemGuildTemplate$ModelProvider = WidgetChatListAdapterItemGuildTemplate$ModelProvider.INSTANCE;
        if (guildTemplateEntry == null) {
            m.throwUninitializedPropertyAccessException("item");
        }
        Observable observableUi = ObservableExtensionsKt.ui(widgetChatListAdapterItemGuildTemplate$ModelProvider.get(guildTemplateEntry));
        WidgetChatListAdapterItemGuildTemplate$onConfigure$1 widgetChatListAdapterItemGuildTemplate$onConfigure$1 = new WidgetChatListAdapterItemGuildTemplate$onConfigure$1(this);
        ObservableExtensionsKt.appSubscribe$default(observableUi, WidgetChatListAdapterItemGuildTemplate.class, (Context) null, new WidgetChatListAdapterItemGuildTemplate$onConfigure$3(this), new WidgetChatListAdapterItemGuildTemplate$onConfigure$2(this), (Function0) null, (Function0) null, widgetChatListAdapterItemGuildTemplate$onConfigure$1, 50, (Object) null);
    }
}

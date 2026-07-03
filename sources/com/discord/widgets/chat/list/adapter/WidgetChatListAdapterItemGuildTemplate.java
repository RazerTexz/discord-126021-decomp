package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.discord.C5419R;
import com.discord.databinding.WidgetChatListAdapterItemGuildTemplateBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildTemplate;
import com.discord.stores.StoreGuildTemplates;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GuildTemplateEntry;
import com.discord.widgets.guilds.create.WidgetGuildClone;
import com.google.android.material.button.MaterialButton;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action0;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildTemplate extends WidgetChatListItem {
    private final WidgetChatListAdapterItemGuildTemplateBinding binding;
    private GuildTemplateEntry item;
    private Subscription subscription;

    /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    public static abstract class Model {

        /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
        public static final class Invalid extends Model {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
        public static final class Loading extends Model {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
        public static final /* data */ class Resolved extends Model {
            private final ModelGuildTemplate guildTemplate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Resolved(ModelGuildTemplate modelGuildTemplate) {
                super(null);
                C12238m.checkNotNullParameter(modelGuildTemplate, "guildTemplate");
                this.guildTemplate = modelGuildTemplate;
            }

            public static /* synthetic */ Resolved copy$default(Resolved resolved, ModelGuildTemplate modelGuildTemplate, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGuildTemplate = resolved.guildTemplate;
                }
                return resolved.copy(modelGuildTemplate);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelGuildTemplate getGuildTemplate() {
                return this.guildTemplate;
            }

            public final Resolved copy(ModelGuildTemplate guildTemplate) {
                C12238m.checkNotNullParameter(guildTemplate, "guildTemplate");
                return new Resolved(guildTemplate);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Resolved) && C12238m.areEqual(this.guildTemplate, ((Resolved) other).guildTemplate);
                }
                return true;
            }

            public final ModelGuildTemplate getGuildTemplate() {
                return this.guildTemplate;
            }

            public int hashCode() {
                ModelGuildTemplate modelGuildTemplate = this.guildTemplate;
                if (modelGuildTemplate != null) {
                    return modelGuildTemplate.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Resolved(guildTemplate=");
                sbM833U.append(this.guildTemplate);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private Model() {
        }

        public /* synthetic */ Model(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    public static final class ModelProvider {
        public static final ModelProvider INSTANCE = new ModelProvider();

        private ModelProvider() {
        }

        public final Observable<Model> get(final GuildTemplateEntry item) {
            C12238m.checkNotNullParameter(item, "item");
            Observable observableM11099Y = StoreStream.INSTANCE.getGuildTemplates().observeGuildTemplate(item.getGuildTemplateCode()).m11116v(new Action0() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$ModelProvider$get$1
                @Override // p658rx.functions.Action0
                public final void call() {
                    StoreStream.INSTANCE.getGuildTemplates().maybeInitTemplateState(item.getGuildTemplateCode());
                }
            }).m11099Y(new InterfaceC12589b<StoreGuildTemplates.GuildTemplateState, Observable<? extends Model>>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$ModelProvider$get$2
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends WidgetChatListAdapterItemGuildTemplate.Model> call(StoreGuildTemplates.GuildTemplateState guildTemplateState) {
                    if ((guildTemplateState instanceof StoreGuildTemplates.GuildTemplateState.Loading) || (guildTemplateState instanceof StoreGuildTemplates.GuildTemplateState.LoadFailed)) {
                        return new C12721k(WidgetChatListAdapterItemGuildTemplate.Model.Loading.INSTANCE);
                    }
                    return guildTemplateState instanceof StoreGuildTemplates.GuildTemplateState.Resolved ? new C12721k(new WidgetChatListAdapterItemGuildTemplate.Model.Resolved(((StoreGuildTemplates.GuildTemplateState.Resolved) guildTemplateState).getGuildTemplate())) : new C12721k(WidgetChatListAdapterItemGuildTemplate.Model.Invalid.INSTANCE);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n        .get…tes\n          }\n        }");
            return observableM11099Y;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$onConfigure$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    public static final /* synthetic */ class C80841 extends C12236k implements Function1<Model, Unit> {
        public C80841(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate) {
            super(1, widgetChatListAdapterItemGuildTemplate, WidgetChatListAdapterItemGuildTemplate.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            C12238m.checkNotNullParameter(model, "p1");
            ((WidgetChatListAdapterItemGuildTemplate) this.receiver).configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$onConfigure$2 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    public static final class C80852 extends AbstractC12240o implements Function1<Error, Unit> {
        public C80852() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            WidgetChatListAdapterItemGuildTemplate.this.configureInvalidUI();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$onConfigure$3 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    public static final class C80863 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C80863() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, "it");
            WidgetChatListAdapterItemGuildTemplate.this.subscription = subscription;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGuildTemplate(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_guild_template, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.item_guild_template_header;
        TextView textView = (TextView) view.findViewById(C5419R.id.item_guild_template_header);
        if (textView != null) {
            i = C5419R.id.item_guild_template_image;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.item_guild_template_image);
            if (imageView != null) {
                i = C5419R.id.item_guild_template_join_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.item_guild_template_join_button);
                if (materialButton != null) {
                    i = C5419R.id.item_guild_template_name;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.item_guild_template_name);
                    if (textView2 != null) {
                        i = C5419R.id.item_guild_template_subtext;
                        TextView textView3 = (TextView) view.findViewById(C5419R.id.item_guild_template_subtext);
                        if (textView3 != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            WidgetChatListAdapterItemGuildTemplateBinding widgetChatListAdapterItemGuildTemplateBinding = new WidgetChatListAdapterItemGuildTemplateBinding(constraintLayout, textView, imageView, materialButton, textView2, textView3, constraintLayout);
                            C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemGuildTemplateBinding, "WidgetChatListAdapterIte…ateBinding.bind(itemView)");
                            this.binding = widgetChatListAdapterItemGuildTemplateBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    private final void configureInvalidUI() {
        this.binding.f16230c.setText(C5419R.string.guild_template_invalid_title);
        this.binding.f16231d.setText(C5419R.string.guild_template_invalid_subtitle);
        TextView textView = this.binding.f16231d;
        C12238m.checkNotNullExpressionValue(textView, "binding.itemGuildTemplateSubtext");
        textView.setVisibility(0);
        MaterialButton materialButton = this.binding.f16229b;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.itemGuildTemplateJoinButton");
        materialButton.setVisibility(8);
    }

    private final void configureLoadingUI() {
        this.binding.f16230c.setText(C5419R.string.guild_template_resolving_title);
        TextView textView = this.binding.f16231d;
        C12238m.checkNotNullExpressionValue(textView, "binding.itemGuildTemplateSubtext");
        textView.setVisibility(8);
        MaterialButton materialButton = this.binding.f16229b;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.itemGuildTemplateJoinButton");
        materialButton.setVisibility(8);
    }

    private final void configureResolvedUI(Model.Resolved model) {
        final ModelGuildTemplate guildTemplate = model.getGuildTemplate();
        TextView textView = this.binding.f16230c;
        C12238m.checkNotNullExpressionValue(textView, "binding.itemGuildTemplateName");
        textView.setText(guildTemplate.getName());
        TextView textView2 = this.binding.f16231d;
        C12238m.checkNotNullExpressionValue(textView2, "binding.itemGuildTemplateSubtext");
        ViewExtensions.setTextAndVisibilityBy(textView2, StringResourceUtilsKt.getI18nPluralString(C1643a.m821I(this.binding.f16231d, "binding.itemGuildTemplateSubtext", "binding.itemGuildTemplateSubtext.context"), C5419R.plurals.guild_template_usages_usageCount, guildTemplate.getUsageCount(), Integer.valueOf(guildTemplate.getUsageCount())));
        MaterialButton materialButton = this.binding.f16229b;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.itemGuildTemplateJoinButton");
        materialButton.setVisibility(0);
        this.binding.f16229b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate.configureResolvedUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListAdapterItemGuildTemplate.this.openGuildTemplate(C1643a.m885x(view, "it", "it.context"), guildTemplate);
            }
        });
    }

    private final void configureUI(Model model) {
        if (model instanceof Model.Loading) {
            configureLoadingUI();
        } else if (model instanceof Model.Resolved) {
            configureResolvedUI((Model.Resolved) model);
        } else {
            if (!(model instanceof Model.Invalid)) {
                throw new NoWhenBranchMatchedException();
            }
            configureInvalidUI();
        }
    }

    private final void openGuildTemplate(Context context, ModelGuildTemplate guildTemplate) {
        WidgetGuildClone.INSTANCE.show(context, guildTemplate.getCode(), "Guild Template Embed");
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        GuildTemplateEntry guildTemplateEntry = (GuildTemplateEntry) data;
        this.item = guildTemplateEntry;
        ModelProvider modelProvider = ModelProvider.INSTANCE;
        if (guildTemplateEntry == null) {
            C12238m.throwUninitializedPropertyAccessException("item");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(modelProvider.get(guildTemplateEntry)), (Class<?>) WidgetChatListAdapterItemGuildTemplate.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C80863()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C80852()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C80841(this));
    }
}

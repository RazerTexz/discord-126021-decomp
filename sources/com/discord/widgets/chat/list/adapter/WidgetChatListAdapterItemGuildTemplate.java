package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.WidgetChatListAdapterItemGuildTemplateBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildTemplate;
import com.discord.stores.StoreGuildTemplates;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GuildTemplateEntry;
import com.discord.widgets.guilds.create.WidgetGuildClone;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;

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
                Intrinsics3.checkNotNullParameter(modelGuildTemplate, "guildTemplate");
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
                Intrinsics3.checkNotNullParameter(guildTemplate, "guildTemplate");
                return new Resolved(guildTemplate);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Resolved) && Intrinsics3.areEqual(this.guildTemplate, ((Resolved) other).guildTemplate);
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
                StringBuilder sbU = outline.U("Resolved(guildTemplate=");
                sbU.append(this.guildTemplate);
                sbU.append(")");
                return sbU.toString();
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
            Intrinsics3.checkNotNullParameter(item, "item");
            Observable observableY = StoreStream.INSTANCE.getGuildTemplates().observeGuildTemplate(item.getGuildTemplateCode()).v(new Action0() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$ModelProvider$get$1
                @Override // rx.functions.Action0
                public final void call() {
                    StoreStream.INSTANCE.getGuildTemplates().maybeInitTemplateState(item.getGuildTemplateCode());
                }
            }).Y(new Func1<StoreGuildTemplates.GuildTemplateState, Observable<? extends Model>>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$ModelProvider$get$2
                @Override // j0.k.Func1
                public final Observable<? extends WidgetChatListAdapterItemGuildTemplate.Model> call(StoreGuildTemplates.GuildTemplateState guildTemplateState) {
                    if ((guildTemplateState instanceof StoreGuildTemplates.GuildTemplateState.Loading) || (guildTemplateState instanceof StoreGuildTemplates.GuildTemplateState.LoadFailed)) {
                        return new ScalarSynchronousObservable(WidgetChatListAdapterItemGuildTemplate.Model.Loading.INSTANCE);
                    }
                    return guildTemplateState instanceof StoreGuildTemplates.GuildTemplateState.Resolved ? new ScalarSynchronousObservable(new WidgetChatListAdapterItemGuildTemplate.Model.Resolved(((StoreGuildTemplates.GuildTemplateState.Resolved) guildTemplateState).getGuildTemplate())) : new ScalarSynchronousObservable(WidgetChatListAdapterItemGuildTemplate.Model.Invalid.INSTANCE);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…tes\n          }\n        }");
            return observableY;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$onConfigure$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate) {
            super(1, widgetChatListAdapterItemGuildTemplate, WidgetChatListAdapterItemGuildTemplate.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            ((WidgetChatListAdapterItemGuildTemplate) this.receiver).configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$onConfigure$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetChatListAdapterItemGuildTemplate.this.configureInvalidUI();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$onConfigure$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            WidgetChatListAdapterItemGuildTemplate.this.subscription = subscription;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGuildTemplate(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_guild_template, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.item_guild_template_header;
        TextView textView = (TextView) view.findViewById(R.id.item_guild_template_header);
        if (textView != null) {
            i = R.id.item_guild_template_image;
            ImageView imageView = (ImageView) view.findViewById(R.id.item_guild_template_image);
            if (imageView != null) {
                i = R.id.item_guild_template_join_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.item_guild_template_join_button);
                if (materialButton != null) {
                    i = R.id.item_guild_template_name;
                    TextView textView2 = (TextView) view.findViewById(R.id.item_guild_template_name);
                    if (textView2 != null) {
                        i = R.id.item_guild_template_subtext;
                        TextView textView3 = (TextView) view.findViewById(R.id.item_guild_template_subtext);
                        if (textView3 != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            WidgetChatListAdapterItemGuildTemplateBinding widgetChatListAdapterItemGuildTemplateBinding = new WidgetChatListAdapterItemGuildTemplateBinding(constraintLayout, textView, imageView, materialButton, textView2, textView3, constraintLayout);
                            Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemGuildTemplateBinding, "WidgetChatListAdapterIte…ateBinding.bind(itemView)");
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
        this.binding.c.setText(R.string.guild_template_invalid_title);
        this.binding.d.setText(R.string.guild_template_invalid_subtitle);
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGuildTemplateSubtext");
        textView.setVisibility(0);
        MaterialButton materialButton = this.binding.f2323b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemGuildTemplateJoinButton");
        materialButton.setVisibility(8);
    }

    private final void configureLoadingUI() {
        this.binding.c.setText(R.string.guild_template_resolving_title);
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGuildTemplateSubtext");
        textView.setVisibility(8);
        MaterialButton materialButton = this.binding.f2323b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemGuildTemplateJoinButton");
        materialButton.setVisibility(8);
    }

    private final void configureResolvedUI(Model.Resolved model) {
        final ModelGuildTemplate guildTemplate = model.getGuildTemplate();
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGuildTemplateName");
        textView.setText(guildTemplate.getName());
        TextView textView2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemGuildTemplateSubtext");
        ViewExtensions.setTextAndVisibilityBy(textView2, StringResourceUtils.getI18nPluralString(outline.I(this.binding.d, "binding.itemGuildTemplateSubtext", "binding.itemGuildTemplateSubtext.context"), R.plurals.guild_template_usages_usageCount, guildTemplate.getUsageCount(), Integer.valueOf(guildTemplate.getUsageCount())));
        MaterialButton materialButton = this.binding.f2323b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemGuildTemplateJoinButton");
        materialButton.setVisibility(0);
        this.binding.f2323b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate.configureResolvedUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListAdapterItemGuildTemplate.this.openGuildTemplate(outline.x(view, "it", "it.context"), guildTemplate);
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
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        GuildTemplateEntry guildTemplateEntry = (GuildTemplateEntry) data;
        this.item = guildTemplateEntry;
        ModelProvider modelProvider = ModelProvider.INSTANCE;
        if (guildTemplateEntry == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("item");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(modelProvider.get(guildTemplateEntry)), (Class<?>) WidgetChatListAdapterItemGuildTemplate.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass3()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}

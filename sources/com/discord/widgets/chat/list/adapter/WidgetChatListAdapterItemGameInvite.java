package com.discord.widgets.chat.list.adapter;

import android.view.View;
import androidx.cardview.widget.CardView;
import com.discord.C5419R;
import com.discord.api.activity.Activity;
import com.discord.databinding.WidgetChatListAdapterItemGameInviteBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.ViewEmbedGameInvite;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GameInviteEntry;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGameInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGameInvite extends WidgetChatListItem {
    private final WidgetChatListAdapterItemGameInviteBinding binding;
    private Subscription subscription;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGameInvite$onConfigure$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGameInvite.kt */
    public static final class C80621 extends AbstractC12240o implements Function2<View, ViewEmbedGameInvite.Model, Unit> {
        public final /* synthetic */ GameInviteEntry $item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C80621(GameInviteEntry gameInviteEntry) {
            super(2);
            this.$item = gameInviteEntry;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, ViewEmbedGameInvite.Model model) {
            invoke2(view, model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view, ViewEmbedGameInvite.Model model) {
            C12238m.checkNotNullParameter(view, "<anonymous parameter 0>");
            C12238m.checkNotNullParameter(model, "model");
            Activity activity = model.getActivity();
            if (activity != null) {
                WidgetChatListAdapterItemGameInvite.access$getAdapter$p(WidgetChatListAdapterItemGameInvite.this).onUserActivityAction(this.$item.getAuthorId(), this.$item.getMessageId(), this.$item.getActivity().getType(), activity, this.$item.getApplication());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGameInvite$onConfigure$2 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGameInvite.kt */
    public static final class C80632 extends AbstractC12240o implements Function1<ViewEmbedGameInvite.Model, Unit> {
        public C80632() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewEmbedGameInvite.Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewEmbedGameInvite.Model model) {
            C12238m.checkNotNullParameter(model, "it");
            WidgetChatListAdapterItemGameInvite.this.binding.f16208b.bind(model, WidgetChatListAdapterItemGameInvite.access$getAdapter$p(WidgetChatListAdapterItemGameInvite.this).getClock());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGameInvite$onConfigure$3 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGameInvite.kt */
    public static final class C80643 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C80643() {
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
            WidgetChatListAdapterItemGameInvite.this.subscription = subscription;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGameInvite(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_game_invite, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        ViewEmbedGameInvite viewEmbedGameInvite = (ViewEmbedGameInvite) view.findViewById(C5419R.id.item_game_invite);
        if (viewEmbedGameInvite == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.item_game_invite)));
        }
        WidgetChatListAdapterItemGameInviteBinding widgetChatListAdapterItemGameInviteBinding = new WidgetChatListAdapterItemGameInviteBinding((CardView) view, viewEmbedGameInvite);
        C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemGameInviteBinding, "WidgetChatListAdapterIte…iteBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemGameInviteBinding;
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemGameInvite widgetChatListAdapterItemGameInvite) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemGameInvite.adapter;
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
        GameInviteEntry gameInviteEntry = (GameInviteEntry) data;
        this.binding.f16208b.setOnActionButtonClick(new C80621(gameInviteEntry));
        Observable observableM8518ui = ObservableExtensionsKt.m8518ui(ViewEmbedGameInvite.Model.INSTANCE.get(gameInviteEntry));
        C80632 c80632 = new C80632();
        String simpleName = WidgetChatListAdapterItemGameInvite.class.getSimpleName();
        C12238m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        ObservableExtensionsKt.appSubscribe(observableM8518ui, (117 & 1) != 0 ? null : null, simpleName, (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : new C80643()), c80632, (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
    }
}

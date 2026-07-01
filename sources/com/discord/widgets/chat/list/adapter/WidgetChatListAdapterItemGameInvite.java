package com.discord.widgets.chat.list.adapter;

import android.view.View;
import androidx.cardview.widget.CardView;
import com.discord.R;
import com.discord.api.activity.Activity;
import com.discord.databinding.WidgetChatListAdapterItemGameInviteBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.ViewEmbedGameInvite;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GameInviteEntry;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGameInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGameInvite extends WidgetChatListItem {
    private final WidgetChatListAdapterItemGameInviteBinding binding;
    private Subscription subscription;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGameInvite$onConfigure$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGameInvite.kt */
    public static final class AnonymousClass1 extends Lambda implements Function2<View, ViewEmbedGameInvite.Model, Unit> {
        public final /* synthetic */ GameInviteEntry $item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GameInviteEntry gameInviteEntry) {
            super(2);
            this.$item = gameInviteEntry;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, ViewEmbedGameInvite.Model model) {
            invoke2(view, model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view, ViewEmbedGameInvite.Model model) {
            Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(model, "model");
            Activity activity = model.getActivity();
            if (activity != null) {
                WidgetChatListAdapterItemGameInvite.access$getAdapter$p(WidgetChatListAdapterItemGameInvite.this).onUserActivityAction(this.$item.getAuthorId(), this.$item.getMessageId(), this.$item.getActivity().getType(), activity, this.$item.getApplication());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGameInvite$onConfigure$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGameInvite.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<ViewEmbedGameInvite.Model, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewEmbedGameInvite.Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewEmbedGameInvite.Model model) {
            Intrinsics3.checkNotNullParameter(model, "it");
            WidgetChatListAdapterItemGameInvite.this.binding.f2319b.bind(model, WidgetChatListAdapterItemGameInvite.access$getAdapter$p(WidgetChatListAdapterItemGameInvite.this).getClock());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGameInvite$onConfigure$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGameInvite.kt */
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
            WidgetChatListAdapterItemGameInvite.this.subscription = subscription;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGameInvite(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_game_invite, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        ViewEmbedGameInvite viewEmbedGameInvite = (ViewEmbedGameInvite) view.findViewById(R.id.item_game_invite);
        if (viewEmbedGameInvite == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.item_game_invite)));
        }
        WidgetChatListAdapterItemGameInviteBinding widgetChatListAdapterItemGameInviteBinding = new WidgetChatListAdapterItemGameInviteBinding((CardView) view, viewEmbedGameInvite);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemGameInviteBinding, "WidgetChatListAdapterIte…iteBinding.bind(itemView)");
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
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        GameInviteEntry gameInviteEntry = (GameInviteEntry) data;
        this.binding.f2319b.setOnActionButtonClick(new AnonymousClass1(gameInviteEntry));
        Observable observableUi = ObservableExtensionsKt.ui(ViewEmbedGameInvite.Model.INSTANCE.get(gameInviteEntry));
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        String simpleName = WidgetChatListAdapterItemGameInvite.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        ObservableExtensionsKt.appSubscribe(observableUi, (117 & 1) != 0 ? null : null, simpleName, (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : new AnonymousClass3()), anonymousClass2, (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
    }
}

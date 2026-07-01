package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.R;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.databinding.WidgetChatListAdapterItemStickerBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StickerEntry;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSticker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSticker extends WidgetChatListItem {
    private final WidgetChatListAdapterItemStickerBinding binding;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSticker$onConfigure$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemSticker.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Sticker, Unit> {
        public final /* synthetic */ ChatListEntry $data;
        public final /* synthetic */ StickerEntry $stickerEntry;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StickerEntry stickerEntry, ChatListEntry chatListEntry) {
            super(1);
            this.$stickerEntry = stickerEntry;
            this.$data = chatListEntry;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Sticker sticker) {
            invoke2(sticker);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Sticker sticker) {
            final BaseSticker sticker2 = sticker;
            if (sticker == null) {
                sticker2 = this.$stickerEntry.getSticker();
            }
            StickerView.e(WidgetChatListAdapterItemSticker.this.binding.f2334b, sticker2, null, 2);
            WidgetChatListAdapterItemSticker.this.binding.f2334b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSticker.onConfigure.1.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetChatListAdapterItemSticker.access$getAdapter$p(WidgetChatListAdapterItemSticker.this).onStickerClicked(((StickerEntry) AnonymousClass1.this.$data).getMessage(), sticker2);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSticker(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_sticker, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        StickerView stickerView = (StickerView) view.findViewById(R.id.chat_list_adapter_item_sticker);
        if (stickerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.chat_list_adapter_item_sticker)));
        }
        WidgetChatListAdapterItemStickerBinding widgetChatListAdapterItemStickerBinding = new WidgetChatListAdapterItemStickerBinding((FrameLayout) view, stickerView);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemStickerBinding, "WidgetChatListAdapterIte…kerBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemStickerBinding;
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemSticker widgetChatListAdapterItemSticker) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemSticker.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.binding.f2334b.getCom.discord.utilities.analytics.Traits.Payment.Type.SUBSCRIPTION java.lang.String();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StickerEntry stickerEntry = (StickerEntry) data;
        Observable observableZ = StickerUtils.getGuildOrStandardSticker$default(StickerUtils.INSTANCE, stickerEntry.getSticker().getId(), false, 2, null).Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "StickerUtils.getGuildOrS…kerId())\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(observableZ, (Class<?>) WidgetChatListAdapterItemSticker.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(stickerEntry, data));
    }
}

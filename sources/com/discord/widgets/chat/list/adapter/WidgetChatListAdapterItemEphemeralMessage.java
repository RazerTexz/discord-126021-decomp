package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.discord.C5419R;
import com.discord.databinding.WidgetChatListAdapterItemEphemeralMessageBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.uri.UriHandler;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.EphemeralMessageEntry;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEphemeralMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEphemeralMessage extends WidgetChatListItem {
    private final WidgetChatListAdapterItemEphemeralMessageBinding binding;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEphemeralMessage$onConfigure$2 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemEphemeralMessage.kt */
    public static final class C80612 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ Message $message;

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEphemeralMessage$onConfigure$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterItemEphemeralMessage.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Hook, Unit> {

            /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEphemeralMessage$onConfigure$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetChatListAdapterItemEphemeralMessage.kt */
            public static final class C132781 extends AbstractC12240o implements Function2<String, View, Unit> {
                public C132781() {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str, View view) {
                    invoke2(str, view);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str, View view) {
                    C12238m.checkNotNullParameter(str, "<anonymous parameter 0>");
                    C12238m.checkNotNullParameter(view, "<anonymous parameter 1>");
                    WidgetChatListAdapterItemEphemeralMessage.access$getAdapter$p(WidgetChatListAdapterItemEphemeralMessage.this).getEventHandler().onDismissClicked(C80612.this.$message);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                C12238m.checkNotNullParameter(hook, "$receiver");
                View view = WidgetChatListAdapterItemEphemeralMessage.this.itemView;
                C12238m.checkNotNullExpressionValue(view, "itemView");
                Integer numValueOf = Integer.valueOf(ColorCompat.getColor(view, C5419R.color.brand));
                C132781 c132781 = new C132781();
                Objects.requireNonNull(hook);
                C12238m.checkNotNullParameter(c132781, "onClick");
                hook.clickHandler = new Hook.C5524a(numValueOf, c132781);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C80612(Message message) {
            super(1);
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8422a("handleDelete", new AnonymousClass1());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemEphemeralMessage(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_ephemeral_message, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.chat_list_adapter_item_gutter_bg;
        View viewFindViewById = view.findViewById(C5419R.id.chat_list_adapter_item_gutter_bg);
        if (viewFindViewById != null) {
            i = C5419R.id.chat_list_adapter_item_highlighted_bg;
            View viewFindViewById2 = view.findViewById(C5419R.id.chat_list_adapter_item_highlighted_bg);
            if (viewFindViewById2 != null) {
                i = C5419R.id.chat_list_adapter_item_icon_help;
                ImageView imageView = (ImageView) view.findViewById(C5419R.id.chat_list_adapter_item_icon_help);
                if (imageView != null) {
                    i = C5419R.id.chat_list_adapter_item_text_dismiss;
                    TextView textView = (TextView) view.findViewById(C5419R.id.chat_list_adapter_item_text_dismiss);
                    if (textView != null) {
                        i = C5419R.id.chat_list_adapter_item_visibility_icon;
                        ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.chat_list_adapter_item_visibility_icon);
                        if (imageView2 != null) {
                            i = C5419R.id.uikit_chat_guideline;
                            Guideline guideline = (Guideline) view.findViewById(C5419R.id.uikit_chat_guideline);
                            if (guideline != null) {
                                WidgetChatListAdapterItemEphemeralMessageBinding widgetChatListAdapterItemEphemeralMessageBinding = new WidgetChatListAdapterItemEphemeralMessageBinding((ConstraintLayout) view, viewFindViewById, viewFindViewById2, imageView, textView, imageView2, guideline);
                                C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemEphemeralMessageBinding, "WidgetChatListAdapterIte…ageBinding.bind(itemView)");
                                this.binding = widgetChatListAdapterItemEphemeralMessageBinding;
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemEphemeralMessage widgetChatListAdapterItemEphemeralMessage) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemEphemeralMessage.adapter;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        Message message = ((EphemeralMessageEntry) data).getMessage();
        View view = this.binding.f16203b;
        C12238m.checkNotNullExpressionValue(view, "binding.chatListAdapterItemGutterBg");
        View view2 = this.binding.f16204c;
        C12238m.checkNotNullExpressionValue(view2, "binding.chatListAdapterItemHighlightedBg");
        configureCellHighlight(message, view2, view);
        this.binding.f16205d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEphemeralMessage.onConfigure.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                UriHandler uriHandler = UriHandler.INSTANCE;
                ImageView imageView = WidgetChatListAdapterItemEphemeralMessage.this.binding.f16205d;
                C12238m.checkNotNullExpressionValue(imageView, "binding.chatListAdapterItemIconHelp");
                Context context = imageView.getContext();
                C12238m.checkNotNullExpressionValue(context, "binding.chatListAdapterItemIconHelp.context");
                UriHandler.handle$default(uriHandler, context, C0862f.f507a.m149a(1500000580222L, null), false, false, null, 28, null);
            }
        });
        TextView textView = this.binding.f16206e;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemTextDismiss");
        String quantityString = textView.getResources().getQuantityString(C5419R.plurals.only_you_can_see_and_delete_these_count, 1);
        C12238m.checkNotNullExpressionValue(quantityString, "itemDismiss.resources.ge…nd_delete_these_count, 1)");
        String quantityString2 = textView.getResources().getQuantityString(C5419R.plurals.only_you_can_see_and_delete_these_countMessages, 1);
        C12238m.checkNotNullExpressionValue(quantityString2, "itemDismiss.resources.ge…e_these_countMessages, 1)");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(C1107b.m212d(textView, C5419R.string.only_you_can_see_and_delete_these, new Object[]{quantityString, quantityString2}, new C80612(message)));
    }
}

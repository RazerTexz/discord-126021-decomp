package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.Formatter;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.databinding.WidgetChatListAdapterItemAttachmentBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.embed.EmbedResourceUtils;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.list.FragmentLifecycleListener;
import com.discord.widgets.chat.list.InlineMediaView;
import com.discord.widgets.chat.list.entries.AttachmentEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.m;
import kotlin.Pair;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAttachment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAttachment extends WidgetChatListItem implements FragmentLifecycleListener {
    public static final WidgetChatListAdapterItemAttachment$Companion Companion = new WidgetChatListAdapterItemAttachment$Companion(null);
    private final WidgetChatListAdapterItemAttachmentBinding binding;
    private final int maxAttachmentImageWidth;
    private Subscription subscription;
    private final StoreUserSettings userSettings;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemAttachment(WidgetChatListAdapter widgetChatListAdapter) {
        super(R$layout.widget_chat_list_adapter_item_attachment, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "itemView.context");
        this.maxAttachmentImageWidth = embedResourceUtils.computeMaximumImageWidthPx(context);
        View view2 = this.itemView;
        int i = R$id.chat_list_adapter_item_gutter_bg;
        View viewFindViewById = view2.findViewById(R$id.chat_list_adapter_item_gutter_bg);
        if (viewFindViewById != null) {
            i = R$id.chat_list_adapter_item_highlighted_bg;
            View viewFindViewById2 = view2.findViewById(R$id.chat_list_adapter_item_highlighted_bg);
            if (viewFindViewById2 != null) {
                i = R$id.chat_list_item_attachment_barrier;
                Barrier barrier = (Barrier) view2.findViewById(R$id.chat_list_item_attachment_barrier);
                if (barrier != null) {
                    i = R$id.chat_list_item_attachment_card;
                    MaterialCardView materialCardView = (MaterialCardView) view2.findViewById(R$id.chat_list_item_attachment_card);
                    if (materialCardView != null) {
                        i = R$id.chat_list_item_attachment_description;
                        TextView textView = (TextView) view2.findViewById(R$id.chat_list_item_attachment_description);
                        if (textView != null) {
                            i = R$id.chat_list_item_attachment_download;
                            ImageView imageView = (ImageView) view2.findViewById(R$id.chat_list_item_attachment_download);
                            if (imageView != null) {
                                i = R$id.chat_list_item_attachment_icon;
                                ImageView imageView2 = (ImageView) view2.findViewById(R$id.chat_list_item_attachment_icon);
                                if (imageView2 != null) {
                                    i = R$id.chat_list_item_attachment_inline_media;
                                    InlineMediaView inlineMediaView = (InlineMediaView) view2.findViewById(R$id.chat_list_item_attachment_inline_media);
                                    if (inlineMediaView != null) {
                                        i = R$id.chat_list_item_attachment_name;
                                        TextView textView2 = (TextView) view2.findViewById(R$id.chat_list_item_attachment_name);
                                        if (textView2 != null) {
                                            i = R$id.chat_list_item_attachment_spoiler;
                                            FrameLayout frameLayout = (FrameLayout) view2.findViewById(R$id.chat_list_item_attachment_spoiler);
                                            if (frameLayout != null) {
                                                i = 2131365922;
                                                Guideline guideline = (Guideline) view2.findViewById(2131365922);
                                                if (guideline != null) {
                                                    WidgetChatListAdapterItemAttachmentBinding widgetChatListAdapterItemAttachmentBinding = new WidgetChatListAdapterItemAttachmentBinding((ConstraintLayout) view2, viewFindViewById, viewFindViewById2, barrier, materialCardView, textView, imageView, imageView2, inlineMediaView, textView2, frameLayout, guideline);
                                                    m.checkNotNullExpressionValue(widgetChatListAdapterItemAttachmentBinding, "WidgetChatListAdapterIte…entBinding.bind(itemView)");
                                                    this.binding = widgetChatListAdapterItemAttachmentBinding;
                                                    this.userSettings = StoreStream.Companion.getUserSettings();
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemAttachment widgetChatListAdapterItemAttachment) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemAttachment.adapter;
    }

    public static final /* synthetic */ WidgetChatListAdapterItemAttachmentBinding access$getBinding$p(WidgetChatListAdapterItemAttachment widgetChatListAdapterItemAttachment) {
        return widgetChatListAdapterItemAttachment.binding;
    }

    private final void configureFileData(MessageAttachment data, MessageRenderContext renderContext) {
        TextView textView = this.binding.i;
        m.checkNotNullExpressionValue(textView, "binding.chatListItemAttachmentName");
        textView.setText(data.getFilename());
        TextView textView2 = this.binding.i;
        m.checkNotNullExpressionValue(textView2, "binding.chatListItemAttachmentName");
        ViewExtensions.setOnLongClickListenerConsumeClick(textView2, WidgetChatListAdapterItemAttachment$configureFileData$1.INSTANCE);
        TextView textView3 = this.binding.e;
        m.checkNotNullExpressionValue(textView3, "binding.chatListItemAttachmentDescription");
        textView3.setText(Formatter.formatFileSize(renderContext.getContext(), data.getSize()));
        this.binding.g.setImageResource(EmbedResourceUtils.INSTANCE.getFileDrawable(data.getFilename()));
        ImageView imageView = this.binding.f;
        m.checkNotNullExpressionValue(imageView, "binding.chatListItemAttachmentDownload");
        imageView.setEnabled(true);
        ImageView imageView2 = this.binding.f;
        m.checkNotNullExpressionValue(imageView2, "binding.chatListItemAttachmentDownload");
        imageView2.setAlpha(1.0f);
        this.binding.f.setOnClickListener(new WidgetChatListAdapterItemAttachment$configureFileData$2(this, data));
    }

    /* JADX WARN: Code duplicated, block: B:17:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:23:0x00b8  */
    private final void configureUI(WidgetChatListAdapterItemAttachment$Model model) {
        boolean z2;
        boolean z3;
        AttachmentEntry attachmentEntry = model.getAttachmentEntry();
        MessageAttachment attachment = attachmentEntry.getAttachment();
        MessageRenderContext messageRenderContextCreateRenderContext = model.createRenderContext(a.x(this.itemView, "itemView", "itemView.context"), ((WidgetChatListAdapter) this.adapter).getEventHandler());
        boolean autoPlayGifs = attachmentEntry.getAutoPlayGifs();
        if (model.getIsSpoilerHidden()) {
            ViewExtensions.fadeIn$default(this.binding.j, 50L, null, WidgetChatListAdapterItemAttachment$configureUI$1.INSTANCE, null, 10, null);
        } else {
            ViewExtensions.fadeOut$default(this.binding.j, 200L, WidgetChatListAdapterItemAttachment$configureUI$2.INSTANCE, null, 4, null);
        }
        ConstraintLayout constraintLayout = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        ViewExtensions.setOnLongClickListenerConsumeClick(constraintLayout, new WidgetChatListAdapterItemAttachment$configureUI$3(this, attachmentEntry));
        this.binding.a.setOnClickListener(new WidgetChatListAdapterItemAttachment$configureUI$4(this, attachmentEntry));
        this.binding.j.setOnClickListener(new WidgetChatListAdapterItemAttachment$configureUI$5(this, model, attachmentEntry));
        boolean z4 = WidgetChatListAdapterItemAttachment$Companion.access$isInlinedAttachment$p(Companion, attachment) && this.userSettings.getIsAttachmentMediaInline();
        if (attachment.getHeight() != null) {
            Integer height = attachment.getHeight();
            m.checkNotNull(height);
            if (height.intValue() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        if (attachment.getWidth() != null) {
            Integer width = attachment.getWidth();
            m.checkNotNull(width);
            z3 = width.intValue() > 0;
        }
        if (z4 && (z3 || z2)) {
            EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
            Integer width2 = attachment.getWidth();
            m.checkNotNull(width2);
            int iIntValue = width2.intValue();
            Integer height2 = attachment.getHeight();
            m.checkNotNull(height2);
            int iIntValue2 = height2.intValue();
            int i = this.maxAttachmentImageWidth;
            int max_image_view_height_px = embedResourceUtils.getMAX_IMAGE_VIEW_HEIGHT_PX();
            InlineMediaView inlineMediaView = this.binding.h;
            m.checkNotNullExpressionValue(inlineMediaView, "binding.chatListItemAttachmentInlineMedia");
            Resources resources = inlineMediaView.getResources();
            m.checkNotNullExpressionValue(resources, "binding.chatListItemAtta…mentInlineMedia.resources");
            Pair pairCalculateScaledSize$default = EmbedResourceUtils.calculateScaledSize$default(embedResourceUtils, iIntValue, iIntValue2, i, max_image_view_height_px, resources, 0, 32, null);
            int iIntValue3 = ((Number) pairCalculateScaledSize$default.component1()).intValue();
            int iIntValue4 = ((Number) pairCalculateScaledSize$default.component2()).intValue();
            MaterialCardView materialCardView = this.binding.d;
            m.checkNotNullExpressionValue(materialCardView, "binding.chatListItemAttachmentCard");
            materialCardView.setVisibility(8);
            InlineMediaView inlineMediaView2 = this.binding.h;
            m.checkNotNullExpressionValue(inlineMediaView2, "binding.chatListItemAttachmentInlineMedia");
            inlineMediaView2.setVisibility(0);
            this.binding.h.updateUIWithAttachment(attachment, Integer.valueOf(iIntValue3), Integer.valueOf(iIntValue4), autoPlayGifs);
        } else {
            MaterialCardView materialCardView2 = this.binding.d;
            m.checkNotNullExpressionValue(materialCardView2, "binding.chatListItemAttachmentCard");
            materialCardView2.setVisibility(0);
            InlineMediaView inlineMediaView3 = this.binding.h;
            m.checkNotNullExpressionValue(inlineMediaView3, "binding.chatListItemAttachmentInlineMedia");
            inlineMediaView3.setVisibility(8);
            InlineMediaView.updateUIWithAttachment$default(this.binding.h, attachment, null, null, autoPlayGifs, 6, null);
        }
        configureFileData(attachment, messageRenderContextCreateRenderContext);
        this.binding.h.setOnClickListener(new WidgetChatListAdapterItemAttachment$configureUI$6(attachment));
        this.binding.d.setOnClickListener(new WidgetChatListAdapterItemAttachment$configureUI$7(attachment));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    @Override // com.discord.widgets.chat.list.FragmentLifecycleListener
    public void onPause() {
        this.binding.h.onPause();
    }

    @Override // com.discord.widgets.chat.list.FragmentLifecycleListener
    public void onResume() {
        this.binding.h.onResume();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        AttachmentEntry attachmentEntry = (AttachmentEntry) data;
        Message message = attachmentEntry.getMessage();
        View view = this.binding.c;
        m.checkNotNullExpressionValue(view, "binding.chatListAdapterItemHighlightedBg");
        View view2 = this.binding.f2309b;
        m.checkNotNullExpressionValue(view2, "binding.chatListAdapterItemGutterBg");
        configureCellHighlight(message, view, view2);
        configureUI(new WidgetChatListAdapterItemAttachment$Model(attachmentEntry, null, null, null, 0L, 30, null));
    }
}

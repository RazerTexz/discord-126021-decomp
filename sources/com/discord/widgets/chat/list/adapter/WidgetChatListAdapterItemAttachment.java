package com.discord.widgets.chat.list.adapter;

import a0.a.a.b;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.format.Formatter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.exifinterface.media.ExifInterface;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.api.message.attachment.MessageAttachmentType;
import com.discord.api.role.GuildRole;
import com.discord.databinding.WidgetChatListAdapterItemAttachmentBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.embed.EmbedResourceUtils;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.list.FragmentLifecycleListener;
import com.discord.widgets.chat.list.InlineMediaView;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.entries.AttachmentEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.media.WidgetMedia;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import java.util.Set;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAttachment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAttachment extends WidgetChatListItem implements FragmentLifecycleListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final WidgetChatListAdapterItemAttachmentBinding binding;
    private final int maxAttachmentImageWidth;
    private Subscription subscription;
    private final StoreUserSettings userSettings;

    /* JADX INFO: compiled from: WidgetChatListAdapterItemAttachment.kt */
    public static final class Companion {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                MessageAttachmentType.values();
                int[] iArr = new int[3];
                $EnumSwitchMapping$0 = iArr;
                iArr[MessageAttachmentType.VIDEO.ordinal()] = 1;
                iArr[MessageAttachmentType.IMAGE.ordinal()] = 2;
            }
        }

        private Companion() {
        }

        private final boolean isInlinedAttachment(MessageAttachment messageAttachment) {
            return messageAttachment.e() != MessageAttachmentType.FILE;
        }

        private final void navigateToAttachment(Context context, MessageAttachment attachment) {
            int iOrdinal = attachment.e().ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                WidgetMedia.INSTANCE.launch(context, attachment);
            } else {
                UriHandler.handleOrUntrusted$default(context, attachment.getUrl(), null, 4, null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAttachment$configureFileData$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemAttachment.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            TextView textView = (TextView) view;
            Context context = textView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            CharSequence text = textView.getText();
            Intrinsics3.checkNotNullExpressionValue(text, "it.text");
            AppToast.c(context, text, 0, 4);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAttachment$configureUI$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemAttachment.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ViewPropertyAnimator, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            Intrinsics3.checkNotNullParameter(viewPropertyAnimator, "$receiver");
            viewPropertyAnimator.scaleX(1.0f);
            viewPropertyAnimator.scaleY(1.0f);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAttachment$configureUI$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemAttachment.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<ViewPropertyAnimator, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            Intrinsics3.checkNotNullParameter(viewPropertyAnimator, "$receiver");
            viewPropertyAnimator.scaleX(0.9f);
            viewPropertyAnimator.scaleY(0.9f);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAttachment$configureUI$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemAttachment.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ AttachmentEntry $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AttachmentEntry attachmentEntry) {
            super(1);
            this.$data = attachmentEntry;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetChatListAdapter.EventHandler eventHandler = WidgetChatListAdapterItemAttachment.access$getAdapter$p(WidgetChatListAdapterItemAttachment.this).getEventHandler();
            Message message = this.$data.getMessage();
            String content = this.$data.getMessage().getContent();
            if (content == null) {
                content = "";
            }
            eventHandler.onMessageLongClicked(message, content, this.$data.isThreadStarterMessage());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemAttachment(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_attachment, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "itemView.context");
        this.maxAttachmentImageWidth = embedResourceUtils.computeMaximumImageWidthPx(context);
        View view2 = this.itemView;
        int i = R.id.chat_list_adapter_item_gutter_bg;
        View viewFindViewById = view2.findViewById(R.id.chat_list_adapter_item_gutter_bg);
        if (viewFindViewById != null) {
            i = R.id.chat_list_adapter_item_highlighted_bg;
            View viewFindViewById2 = view2.findViewById(R.id.chat_list_adapter_item_highlighted_bg);
            if (viewFindViewById2 != null) {
                i = R.id.chat_list_item_attachment_barrier;
                Barrier barrier = (Barrier) view2.findViewById(R.id.chat_list_item_attachment_barrier);
                if (barrier != null) {
                    i = R.id.chat_list_item_attachment_card;
                    MaterialCardView materialCardView = (MaterialCardView) view2.findViewById(R.id.chat_list_item_attachment_card);
                    if (materialCardView != null) {
                        i = R.id.chat_list_item_attachment_description;
                        TextView textView = (TextView) view2.findViewById(R.id.chat_list_item_attachment_description);
                        if (textView != null) {
                            i = R.id.chat_list_item_attachment_download;
                            ImageView imageView = (ImageView) view2.findViewById(R.id.chat_list_item_attachment_download);
                            if (imageView != null) {
                                i = R.id.chat_list_item_attachment_icon;
                                ImageView imageView2 = (ImageView) view2.findViewById(R.id.chat_list_item_attachment_icon);
                                if (imageView2 != null) {
                                    i = R.id.chat_list_item_attachment_inline_media;
                                    InlineMediaView inlineMediaView = (InlineMediaView) view2.findViewById(R.id.chat_list_item_attachment_inline_media);
                                    if (inlineMediaView != null) {
                                        i = R.id.chat_list_item_attachment_name;
                                        TextView textView2 = (TextView) view2.findViewById(R.id.chat_list_item_attachment_name);
                                        if (textView2 != null) {
                                            i = R.id.chat_list_item_attachment_spoiler;
                                            FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.chat_list_item_attachment_spoiler);
                                            if (frameLayout != null) {
                                                i = R.id.uikit_chat_guideline;
                                                Guideline guideline = (Guideline) view2.findViewById(R.id.uikit_chat_guideline);
                                                if (guideline != null) {
                                                    WidgetChatListAdapterItemAttachmentBinding widgetChatListAdapterItemAttachmentBinding = new WidgetChatListAdapterItemAttachmentBinding((ConstraintLayout) view2, viewFindViewById, viewFindViewById2, barrier, materialCardView, textView, imageView, imageView2, inlineMediaView, textView2, frameLayout, guideline);
                                                    Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemAttachmentBinding, "WidgetChatListAdapterIte…entBinding.bind(itemView)");
                                                    this.binding = widgetChatListAdapterItemAttachmentBinding;
                                                    this.userSettings = StoreStream.INSTANCE.getUserSettings();
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

    private final void configureFileData(final MessageAttachment data, MessageRenderContext renderContext) {
        TextView textView = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListItemAttachmentName");
        textView.setText(data.getFilename());
        TextView textView2 = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatListItemAttachmentName");
        ViewExtensions.setOnLongClickListenerConsumeClick(textView2, AnonymousClass1.INSTANCE);
        TextView textView3 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.chatListItemAttachmentDescription");
        textView3.setText(Formatter.formatFileSize(renderContext.getContext(), data.getSize()));
        this.binding.g.setImageResource(EmbedResourceUtils.INSTANCE.getFileDrawable(data.getFilename()));
        ImageView imageView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.chatListItemAttachmentDownload");
        imageView.setEnabled(true);
        ImageView imageView2 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.chatListItemAttachmentDownload");
        imageView2.setAlpha(1.0f);
        this.binding.f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAttachment.configureFileData.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListAdapter.EventHandler eventHandler = WidgetChatListAdapterItemAttachment.access$getAdapter$p(WidgetChatListAdapterItemAttachment.this).getEventHandler();
                Uri uri = Uri.parse(data.getUrl());
                Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(data.url)");
                boolean zOnQuickDownloadClicked = eventHandler.onQuickDownloadClicked(uri, data.getFilename());
                ImageView imageView3 = WidgetChatListAdapterItemAttachment.this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.chatListItemAttachmentDownload");
                imageView3.setEnabled(!zOnQuickDownloadClicked);
                ImageView imageView4 = WidgetChatListAdapterItemAttachment.this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.chatListItemAttachmentDownload");
                imageView4.setAlpha(0.3f);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:17:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:23:0x00b8  */
    private final void configureUI(final Model model) {
        boolean z2;
        boolean z3;
        final AttachmentEntry attachmentEntry = model.getAttachmentEntry();
        final MessageAttachment attachment = attachmentEntry.getAttachment();
        MessageRenderContext messageRenderContextCreateRenderContext = model.createRenderContext(outline.x(this.itemView, "itemView", "itemView.context"), ((WidgetChatListAdapter) this.adapter).getEventHandler());
        boolean autoPlayGifs = attachmentEntry.getAutoPlayGifs();
        if (model.getIsSpoilerHidden()) {
            ViewExtensions.fadeIn$default(this.binding.j, 50L, null, AnonymousClass1.INSTANCE, null, 10, null);
        } else {
            ViewExtensions.fadeOut$default(this.binding.j, 200L, AnonymousClass2.INSTANCE, null, 4, null);
        }
        ConstraintLayout constraintLayout = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
        ViewExtensions.setOnLongClickListenerConsumeClick(constraintLayout, new AnonymousClass3(attachmentEntry));
        this.binding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAttachment.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListAdapterItemAttachment.access$getAdapter$p(WidgetChatListAdapterItemAttachment.this).getEventHandler().onMessageClicked(attachmentEntry.getMessage(), attachmentEntry.isThreadStarterMessage());
            }
        });
        this.binding.j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAttachment.configureUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (WidgetChatListAdapterItemAttachment.access$getAdapter$p(WidgetChatListAdapterItemAttachment.this).getData().getIsSpoilerClickAllowed()) {
                    StoreStream.INSTANCE.getMessageState().revealSpoilerEmbed(model.getAttachmentEntry().getMessage().getId(), attachmentEntry.getEmbedIndex());
                } else {
                    WidgetChatListAdapterItemAttachment.access$getAdapter$p(WidgetChatListAdapterItemAttachment.this).getEventHandler().onMessageClicked(model.getAttachmentEntry().getMessage(), attachmentEntry.isThreadStarterMessage());
                }
            }
        });
        boolean z4 = INSTANCE.isInlinedAttachment(attachment) && this.userSettings.getIsAttachmentMediaInline();
        if (attachment.getHeight() != null) {
            Integer height = attachment.getHeight();
            Intrinsics3.checkNotNull(height);
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
            Intrinsics3.checkNotNull(width);
            z3 = width.intValue() > 0;
        }
        if (z4 && (z3 || z2)) {
            EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
            Integer width2 = attachment.getWidth();
            Intrinsics3.checkNotNull(width2);
            int iIntValue = width2.intValue();
            Integer height2 = attachment.getHeight();
            Intrinsics3.checkNotNull(height2);
            int iIntValue2 = height2.intValue();
            int i = this.maxAttachmentImageWidth;
            int max_image_view_height_px = embedResourceUtils.getMAX_IMAGE_VIEW_HEIGHT_PX();
            InlineMediaView inlineMediaView = this.binding.h;
            Intrinsics3.checkNotNullExpressionValue(inlineMediaView, "binding.chatListItemAttachmentInlineMedia");
            Resources resources = inlineMediaView.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "binding.chatListItemAtta…mentInlineMedia.resources");
            Tuples2 tuples2CalculateScaledSize = embedResourceUtils.calculateScaledSize(iIntValue, iIntValue2, i, max_image_view_height_px, resources, (32 & 32) != 0 ? 0 : 0);
            int iIntValue3 = ((Number) tuples2CalculateScaledSize.component1()).intValue();
            int iIntValue4 = ((Number) tuples2CalculateScaledSize.component2()).intValue();
            MaterialCardView materialCardView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(materialCardView, "binding.chatListItemAttachmentCard");
            materialCardView.setVisibility(8);
            InlineMediaView inlineMediaView2 = this.binding.h;
            Intrinsics3.checkNotNullExpressionValue(inlineMediaView2, "binding.chatListItemAttachmentInlineMedia");
            inlineMediaView2.setVisibility(0);
            this.binding.h.updateUIWithAttachment(attachment, Integer.valueOf(iIntValue3), Integer.valueOf(iIntValue4), autoPlayGifs);
        } else {
            MaterialCardView materialCardView2 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(materialCardView2, "binding.chatListItemAttachmentCard");
            materialCardView2.setVisibility(0);
            InlineMediaView inlineMediaView3 = this.binding.h;
            Intrinsics3.checkNotNullExpressionValue(inlineMediaView3, "binding.chatListItemAttachmentInlineMedia");
            inlineMediaView3.setVisibility(8);
            InlineMediaView.updateUIWithAttachment$default(this.binding.h, attachment, null, null, autoPlayGifs, 6, null);
        }
        configureFileData(attachment, messageRenderContextCreateRenderContext);
        this.binding.h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAttachment.configureUI.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListAdapterItemAttachment.INSTANCE.navigateToAttachment(outline.x(view, "it", "it.context"), attachment);
            }
        });
        this.binding.d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAttachment.configureUI.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListAdapterItemAttachment.INSTANCE.navigateToAttachment(outline.x(view, "it", "it.context"), attachment);
            }
        });
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.widgets.chat.list.FragmentLifecycleListener
    public void onPause() {
        this.binding.h.onPause();
    }

    @Override // com.discord.widgets.chat.list.FragmentLifecycleListener
    public void onResume() {
        this.binding.h.onResume();
    }

    /* JADX INFO: compiled from: WidgetChatListAdapterItemAttachment.kt */
    public static final /* data */ class Model {
        private final AttachmentEntry attachmentEntry;
        private final Map<Long, String> channelNames;
        private final boolean isSpoilerHidden;
        private final long myId;
        private final Map<Long, GuildRole> roles;
        private final Map<Long, String> userNames;

        public Model(AttachmentEntry attachmentEntry, Map<Long, String> map, Map<Long, String> map2, Map<Long, GuildRole> map3, long j) {
            Intrinsics3.checkNotNullParameter(attachmentEntry, "attachmentEntry");
            this.attachmentEntry = attachmentEntry;
            this.channelNames = map;
            this.userNames = map2;
            this.roles = map3;
            this.myId = j;
            this.isSpoilerHidden = attachmentEntry.getAttachment().h() && !isSpoilerEmbedRevealed(attachmentEntry);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, AttachmentEntry attachmentEntry, Map map, Map map2, Map map3, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                attachmentEntry = model.attachmentEntry;
            }
            if ((i & 2) != 0) {
                map = model.channelNames;
            }
            Map map4 = map;
            if ((i & 4) != 0) {
                map2 = model.userNames;
            }
            Map map5 = map2;
            if ((i & 8) != 0) {
                map3 = model.roles;
            }
            Map map6 = map3;
            if ((i & 16) != 0) {
                j = model.myId;
            }
            return model.copy(attachmentEntry, map4, map5, map6, j);
        }

        private final boolean isSpoilerEmbedRevealed(AttachmentEntry attachmentEntry) {
            Map<Integer, Set<String>> visibleSpoilerEmbedMap;
            StoreMessageState.State messageState = attachmentEntry.getMessageState();
            return (messageState == null || (visibleSpoilerEmbedMap = messageState.getVisibleSpoilerEmbedMap()) == null || !visibleSpoilerEmbedMap.containsKey(Integer.valueOf(attachmentEntry.getEmbedIndex()))) ? false : true;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AttachmentEntry getAttachmentEntry() {
            return this.attachmentEntry;
        }

        public final Map<Long, String> component2() {
            return this.channelNames;
        }

        public final Map<Long, String> component3() {
            return this.userNames;
        }

        public final Map<Long, GuildRole> component4() {
            return this.roles;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final long getMyId() {
            return this.myId;
        }

        public final Model copy(AttachmentEntry attachmentEntry, Map<Long, String> channelNames, Map<Long, String> userNames, Map<Long, GuildRole> roles, long myId) {
            Intrinsics3.checkNotNullParameter(attachmentEntry, "attachmentEntry");
            return new Model(attachmentEntry, channelNames, userNames, roles, myId);
        }

        public final MessageRenderContext createRenderContext(Context androidContext, WidgetChatListAdapter.EventHandler eventHandler) {
            Intrinsics3.checkNotNullParameter(androidContext, "androidContext");
            Intrinsics3.checkNotNullParameter(eventHandler, "eventHandler");
            return new MessageRenderContext(androidContext, this.myId, this.attachmentEntry.getAllowAnimatedEmojis(), this.userNames, this.channelNames, this.roles, 0, null, new WidgetChatListAdapterItemAttachment2(eventHandler), 0, 0, null, null, null, 16064, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.attachmentEntry, model.attachmentEntry) && Intrinsics3.areEqual(this.channelNames, model.channelNames) && Intrinsics3.areEqual(this.userNames, model.userNames) && Intrinsics3.areEqual(this.roles, model.roles) && this.myId == model.myId;
        }

        public final AttachmentEntry getAttachmentEntry() {
            return this.attachmentEntry;
        }

        public final Map<Long, String> getChannelNames() {
            return this.channelNames;
        }

        public final long getMyId() {
            return this.myId;
        }

        public final Map<Long, GuildRole> getRoles() {
            return this.roles;
        }

        public final Map<Long, String> getUserNames() {
            return this.userNames;
        }

        public int hashCode() {
            AttachmentEntry attachmentEntry = this.attachmentEntry;
            int iHashCode = (attachmentEntry != null ? attachmentEntry.hashCode() : 0) * 31;
            Map<Long, String> map = this.channelNames;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, String> map2 = this.userNames;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, GuildRole> map3 = this.roles;
            return b.a(this.myId) + ((iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31);
        }

        /* JADX INFO: renamed from: isSpoilerHidden, reason: from getter */
        public final boolean getIsSpoilerHidden() {
            return this.isSpoilerHidden;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(attachmentEntry=");
            sbU.append(this.attachmentEntry);
            sbU.append(", channelNames=");
            sbU.append(this.channelNames);
            sbU.append(", userNames=");
            sbU.append(this.userNames);
            sbU.append(", roles=");
            sbU.append(this.roles);
            sbU.append(", myId=");
            return outline.C(sbU, this.myId, ")");
        }

        public /* synthetic */ Model(AttachmentEntry attachmentEntry, Map map, Map map2, Map map3, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(attachmentEntry, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : map2, (i & 8) == 0 ? map3 : null, (i & 16) != 0 ? 0L : j);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        AttachmentEntry attachmentEntry = (AttachmentEntry) data;
        Message message = attachmentEntry.getMessage();
        View view = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.chatListAdapterItemHighlightedBg");
        View view2 = this.binding.f2309b;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.chatListAdapterItemGutterBg");
        configureCellHighlight(message, view, view2);
        configureUI(new Model(attachmentEntry, null, null, null, 0L, 30, null));
    }
}

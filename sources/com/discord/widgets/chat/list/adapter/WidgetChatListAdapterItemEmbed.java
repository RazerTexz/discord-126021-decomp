package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import b.a.i.y4;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.message.embed.EmbedAuthor;
import com.discord.api.message.embed.EmbedField;
import com.discord.api.message.embed.EmbedFooter;
import com.discord.api.message.embed.EmbedProvider;
import com.discord.api.message.embed.EmbedThumbnail;
import com.discord.api.message.embed.EmbedType;
import com.discord.api.message.embed.EmbedVideo;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetChatListAdapterItemEmbedBinding;
import com.discord.embed.RenderableEmbedMedia;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreMessageState$State;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.embed.EmbedResourceUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessageParseState$Companion;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.widgets.chat.list.FragmentLifecycleListener;
import com.discord.widgets.chat.list.InlineMediaView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.EmbedEntry;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.card.MaterialCardView;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed extends WidgetChatListItem implements FragmentLifecycleListener {
    public static final WidgetChatListAdapterItemEmbed$Companion Companion;
    private static final String EMBED_TYPE_DESC = "desc";
    private static final String EMBED_TYPE_FIELD_NAME = "f_name";
    private static final String EMBED_TYPE_FIELD_VALUE = "f_value";
    private static final String EMBED_TYPE_TITLE = "title";
    private static final int MAX_IMAGE_VIEW_HEIGHT_PX;
    private static final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> UI_THREAD_TITLES_PARSER;
    private static final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> UI_THREAD_VALUES_PARSER;
    private final WidgetChatListAdapterItemEmbedBinding binding;
    private final int embedThumbnailMaxSize;
    private final int embedTinyIconSize;
    private final int maxEmbedImageWidth;
    private Subscription subscription;
    private final StoreUserSettings userSettings;

    static {
        WidgetChatListAdapterItemEmbed$Companion widgetChatListAdapterItemEmbed$Companion = new WidgetChatListAdapterItemEmbed$Companion(null);
        Companion = widgetChatListAdapterItemEmbed$Companion;
        MAX_IMAGE_VIEW_HEIGHT_PX = DimenUtils.dpToPixels(360);
        UI_THREAD_TITLES_PARSER = widgetChatListAdapterItemEmbed$Companion.createTitlesParser();
        UI_THREAD_VALUES_PARSER = DiscordParser.createParser$default(true, true, false, false, false, 28, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemEmbed(WidgetChatListAdapter widgetChatListAdapter) {
        super(R$layout.widget_chat_list_adapter_item_embed, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.chat_list_adapter_item_gutter_bg;
        View viewFindViewById = view.findViewById(R$id.chat_list_adapter_item_gutter_bg);
        if (viewFindViewById != null) {
            i = R$id.chat_list_adapter_item_highlighted_bg;
            View viewFindViewById2 = view.findViewById(R$id.chat_list_adapter_item_highlighted_bg);
            if (viewFindViewById2 != null) {
                i = R$id.chat_list_item_embed_author_icon;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.chat_list_item_embed_author_icon);
                if (simpleDraweeView != null) {
                    i = R$id.chat_list_item_embed_author_text;
                    TextView textView = (TextView) view.findViewById(R$id.chat_list_item_embed_author_text);
                    if (textView != null) {
                        i = R$id.chat_list_item_embed_barrier_data;
                        Barrier barrier = (Barrier) view.findViewById(R$id.chat_list_item_embed_barrier_data);
                        if (barrier != null) {
                            i = R$id.chat_list_item_embed_barrier_header;
                            Barrier barrier2 = (Barrier) view.findViewById(R$id.chat_list_item_embed_barrier_header);
                            if (barrier2 != null) {
                                i = R$id.chat_list_item_embed_container_card;
                                MaterialCardView materialCardView = (MaterialCardView) view.findViewById(R$id.chat_list_item_embed_container_card);
                                if (materialCardView != null) {
                                    i = R$id.chat_list_item_embed_content;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R$id.chat_list_item_embed_content);
                                    if (constraintLayout != null) {
                                        i = R$id.chat_list_item_embed_description;
                                        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.chat_list_item_embed_description);
                                        if (linkifiedTextView != null) {
                                            i = R$id.chat_list_item_embed_divider;
                                            View viewFindViewById3 = view.findViewById(R$id.chat_list_item_embed_divider);
                                            if (viewFindViewById3 != null) {
                                                i = R$id.chat_list_item_embed_fields;
                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.chat_list_item_embed_fields);
                                                if (linearLayout != null) {
                                                    i = R$id.chat_list_item_embed_footer_icon;
                                                    SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(R$id.chat_list_item_embed_footer_icon);
                                                    if (simpleDraweeView2 != null) {
                                                        i = R$id.chat_list_item_embed_footer_text;
                                                        TextView textView2 = (TextView) view.findViewById(R$id.chat_list_item_embed_footer_text);
                                                        if (textView2 != null) {
                                                            i = R$id.chat_list_item_embed_image;
                                                            SimpleDraweeView simpleDraweeView3 = (SimpleDraweeView) view.findViewById(R$id.chat_list_item_embed_image);
                                                            if (simpleDraweeView3 != null) {
                                                                i = R$id.chat_list_item_embed_image_icons;
                                                                ImageView imageView = (ImageView) view.findViewById(R$id.chat_list_item_embed_image_icons);
                                                                if (imageView != null) {
                                                                    i = R$id.chat_list_item_embed_image_thumbnail;
                                                                    SimpleDraweeView simpleDraweeView4 = (SimpleDraweeView) view.findViewById(R$id.chat_list_item_embed_image_thumbnail);
                                                                    if (simpleDraweeView4 != null) {
                                                                        i = R$id.chat_list_item_embed_provider;
                                                                        TextView textView3 = (TextView) view.findViewById(R$id.chat_list_item_embed_provider);
                                                                        if (textView3 != null) {
                                                                            i = R$id.chat_list_item_embed_spoiler;
                                                                            FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.chat_list_item_embed_spoiler);
                                                                            if (frameLayout != null) {
                                                                                i = R$id.chat_list_item_embed_title;
                                                                                LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) view.findViewById(R$id.chat_list_item_embed_title);
                                                                                if (linkifiedTextView2 != null) {
                                                                                    i = R$id.embed_image_container;
                                                                                    CardView cardView = (CardView) view.findViewById(R$id.embed_image_container);
                                                                                    if (cardView != null) {
                                                                                        i = R$id.embed_inline_media;
                                                                                        InlineMediaView inlineMediaView = (InlineMediaView) view.findViewById(R$id.embed_inline_media);
                                                                                        if (inlineMediaView != null) {
                                                                                            WidgetChatListAdapterItemEmbedBinding widgetChatListAdapterItemEmbedBinding = new WidgetChatListAdapterItemEmbedBinding((ConstraintLayout) view, viewFindViewById, viewFindViewById2, simpleDraweeView, textView, barrier, barrier2, materialCardView, constraintLayout, linkifiedTextView, viewFindViewById3, linearLayout, simpleDraweeView2, textView2, simpleDraweeView3, imageView, simpleDraweeView4, textView3, frameLayout, linkifiedTextView2, cardView, inlineMediaView);
                                                                                            m.checkNotNullExpressionValue(widgetChatListAdapterItemEmbedBinding, "WidgetChatListAdapterIte…bedBinding.bind(itemView)");
                                                                                            this.binding = widgetChatListAdapterItemEmbedBinding;
                                                                                            WidgetChatListAdapterItemEmbed$1 widgetChatListAdapterItemEmbed$1 = WidgetChatListAdapterItemEmbed$1.INSTANCE;
                                                                                            m.checkNotNullExpressionValue(textView3, "binding.chatListItemEmbedProvider");
                                                                                            widgetChatListAdapterItemEmbed$1.invoke2(textView3);
                                                                                            m.checkNotNullExpressionValue(linkifiedTextView2, "binding.chatListItemEmbedTitle");
                                                                                            widgetChatListAdapterItemEmbed$1.invoke2((TextView) linkifiedTextView2);
                                                                                            m.checkNotNullExpressionValue(textView, "binding.chatListItemEmbedAuthorText");
                                                                                            widgetChatListAdapterItemEmbed$1.invoke2(textView);
                                                                                            m.checkNotNullExpressionValue(linkifiedTextView, "binding.chatListItemEmbedDescription");
                                                                                            widgetChatListAdapterItemEmbed$1.invoke2((TextView) linkifiedTextView);
                                                                                            m.checkNotNullExpressionValue(textView2, "binding.chatListItemEmbedFooterText");
                                                                                            widgetChatListAdapterItemEmbed$1.invoke2(textView2);
                                                                                            this.userSettings = StoreStream.Companion.getUserSettings();
                                                                                            View view2 = this.itemView;
                                                                                            m.checkNotNullExpressionValue(view2, "itemView");
                                                                                            this.embedTinyIconSize = (int) view2.getResources().getDimension(2131165400);
                                                                                            View view3 = this.itemView;
                                                                                            m.checkNotNullExpressionValue(view3, "itemView");
                                                                                            this.embedThumbnailMaxSize = (int) view3.getResources().getDimension(2131165399);
                                                                                            EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
                                                                                            View view4 = this.itemView;
                                                                                            m.checkNotNullExpressionValue(view4, "itemView");
                                                                                            Context context = view4.getContext();
                                                                                            m.checkNotNullExpressionValue(context, "itemView.context");
                                                                                            this.maxEmbedImageWidth = embedResourceUtils.computeMaximumImageWidthPx(context);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ void access$configureEmbedDescription(WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed, WidgetChatListAdapterItemEmbed$Model widgetChatListAdapterItemEmbed$Model, MessageRenderContext messageRenderContext) {
        widgetChatListAdapterItemEmbed.configureEmbedDescription(widgetChatListAdapterItemEmbed$Model, messageRenderContext);
    }

    public static final /* synthetic */ void access$configureEmbedFields(WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed, WidgetChatListAdapterItemEmbed$Model widgetChatListAdapterItemEmbed$Model, MessageRenderContext messageRenderContext) {
        widgetChatListAdapterItemEmbed.configureEmbedFields(widgetChatListAdapterItemEmbed$Model, messageRenderContext);
    }

    public static final /* synthetic */ void access$configureEmbedTitle(WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed, WidgetChatListAdapterItemEmbed$Model widgetChatListAdapterItemEmbed$Model, MessageRenderContext messageRenderContext) {
        widgetChatListAdapterItemEmbed.configureEmbedTitle(widgetChatListAdapterItemEmbed$Model, messageRenderContext);
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemEmbed.adapter;
    }

    public static final /* synthetic */ Subscription access$getSubscription$p(WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed) {
        return widgetChatListAdapterItemEmbed.subscription;
    }

    public static final /* synthetic */ Parser access$getUI_THREAD_TITLES_PARSER$cp() {
        return UI_THREAD_TITLES_PARSER;
    }

    public static final /* synthetic */ Parser access$getUI_THREAD_VALUES_PARSER$cp() {
        return UI_THREAD_VALUES_PARSER;
    }

    public static final /* synthetic */ void access$setSubscription$p(WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed, Subscription subscription) {
        widgetChatListAdapterItemEmbed.subscription = subscription;
    }

    private final void configureEmbedAuthor(EmbedAuthor author) {
        if (author != null) {
            TextView textView = this.binding.e;
            m.checkNotNullExpressionValue(textView, "binding.chatListItemEmbedAuthorText");
            textView.setText(author.getName());
            WidgetChatListAdapterItemEmbed$Companion widgetChatListAdapterItemEmbed$Companion = Companion;
            TextView textView2 = this.binding.e;
            m.checkNotNullExpressionValue(textView2, "binding.chatListItemEmbedAuthorText");
            WidgetChatListAdapterItemEmbed$Companion.access$bindUrlOnClick(widgetChatListAdapterItemEmbed$Companion, textView2, author.getUrl(), author.getName());
            TextView textView3 = this.binding.e;
            m.checkNotNullExpressionValue(textView3, "binding.chatListItemEmbedAuthorText");
            textView3.setVisibility(0);
        } else {
            TextView textView4 = this.binding.e;
            m.checkNotNullExpressionValue(textView4, "binding.chatListItemEmbedAuthorText");
            textView4.setVisibility(8);
        }
        if ((author != null ? author.getProxyIconUrl() : null) == null) {
            SimpleDraweeView simpleDraweeView = this.binding.d;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatListItemEmbedAuthorIcon");
            simpleDraweeView.setVisibility(8);
            return;
        }
        SimpleDraweeView simpleDraweeView2 = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatListItemEmbedAuthorIcon");
        simpleDraweeView2.setVisibility(0);
        SimpleDraweeView simpleDraweeView3 = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeView3, "binding.chatListItemEmbedAuthorIcon");
        int i = this.embedTinyIconSize;
        configureEmbedImage$default(this, simpleDraweeView3, i, i, i, author.getProxyIconUrl(), 0, 32, null);
    }

    private final void configureEmbedDescription(WidgetChatListAdapterItemEmbed$Model model, MessageRenderContext renderContext) {
        Map<Integer, Set<String>> visibleSpoilerEmbedMap;
        if (model.getParsedDescription() == null) {
            LinkifiedTextView linkifiedTextView = this.binding.h;
            m.checkNotNullExpressionValue(linkifiedTextView, "binding.chatListItemEmbedDescription");
            linkifiedTextView.setVisibility(8);
            return;
        }
        long id2 = model.getEmbedEntry().getMessage().getId();
        int embedIndex = model.getEmbedEntry().getEmbedIndex();
        long myId = model.getMyId();
        StoreMessageState$State messageState = model.getEmbedEntry().getMessageState();
        new MessagePreprocessor(myId, (messageState == null || (visibleSpoilerEmbedMap = messageState.getVisibleSpoilerEmbedMap()) == null) ? null : WidgetChatListAdapterItemEmbed$Companion.access$getEmbedFieldVisibleIndices(Companion, visibleSpoilerEmbedMap, embedIndex, EMBED_TYPE_DESC), null, false, null, 28, null).process(model.getParsedDescription());
        this.binding.h.setDraweeSpanStringBuilder(AstRenderer.render(model.getParsedDescription(), MessageRenderContext.copy$default(renderContext, null, 0L, false, null, null, null, 0, null, null, 0, 0, new WidgetChatListAdapterItemEmbed$configureEmbedDescription$1(id2, embedIndex), null, null, 14335, null)));
        LinkifiedTextView linkifiedTextView2 = this.binding.h;
        m.checkNotNullExpressionValue(linkifiedTextView2, "binding.chatListItemEmbedDescription");
        linkifiedTextView2.setVisibility(0);
    }

    private final void configureEmbedDivider(Integer color) {
        int themedColor;
        View view = this.binding.i;
        if (color != null) {
            themedColor = ColorUtils.setAlphaComponent(color.intValue(), 255);
        } else {
            m.checkNotNullExpressionValue(view, "binding.chatListItemEmbedDivider");
            themedColor = ColorCompat.getThemedColor(view.getContext(), 2130968906);
        }
        view.setBackgroundColor(themedColor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v6, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r5v7, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r6v7, types: [android.widget.LinearLayout] */
    private final void configureEmbedFields(WidgetChatListAdapterItemEmbed$Model model, MessageRenderContext renderContext) {
        ?? childAt;
        List<WidgetChatListAdapterItemEmbed$Model$ParsedField> parsedFields = model.getParsedFields();
        this.binding.j.removeAllViews();
        if (parsedFields == null) {
            LinearLayout linearLayout = this.binding.j;
            m.checkNotNullExpressionValue(linearLayout, "binding.chatListItemEmbedFields");
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout2 = this.binding.j;
        m.checkNotNullExpressionValue(linearLayout2, "binding.chatListItemEmbedFields");
        linearLayout2.setVisibility(0);
        LinearLayout linearLayout3 = this.binding.j;
        m.checkNotNullExpressionValue(linearLayout3, "binding.chatListItemEmbedFields");
        Context context = linearLayout3.getContext();
        long id2 = model.getEmbedEntry().getMessage().getId();
        int embedIndex = model.getEmbedEntry().getEmbedIndex();
        StoreMessageState$State messageState = model.getEmbedEntry().getMessageState();
        WidgetChatListAdapterItemEmbed$configureEmbedFields$1 widgetChatListAdapterItemEmbed$configureEmbedFields$1 = new WidgetChatListAdapterItemEmbed$configureEmbedFields$1(model, messageState != null ? messageState.getVisibleSpoilerEmbedMap() : null, embedIndex, renderContext, id2);
        int size = parsedFields.size();
        for (int i = 0; i < size; i++) {
            LinearLayout linearLayout4 = this.binding.j;
            m.checkNotNullExpressionValue(linearLayout4, "binding.chatListItemEmbedFields");
            int childCount = linearLayout4.getChildCount();
            int i2 = R$id.chat_list_item_embed_field_value;
            if (i >= childCount) {
                View viewInflate = LayoutInflater.from(context).inflate(R$layout.widget_chat_list_adapter_item_embed_field, (ViewGroup) this.binding.j, false);
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewInflate.findViewById(R$id.chat_list_item_embed_field_name);
                if (linkifiedTextView != null) {
                    LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) viewInflate.findViewById(R$id.chat_list_item_embed_field_value);
                    if (linkifiedTextView2 != null) {
                        childAt = (LinearLayout) viewInflate;
                        m.checkNotNullExpressionValue(new y4(childAt, linkifiedTextView, linkifiedTextView2), "WidgetChatListAdapterIte…edFields, false\n        )");
                    }
                } else {
                    i2 = R$id.chat_list_item_embed_field_name;
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
            }
            childAt = this.binding.j.getChildAt(i);
            ((SimpleDraweeSpanTextView) childAt.findViewById(R$id.chat_list_item_embed_field_name)).setDraweeSpanStringBuilder(widgetChatListAdapterItemEmbed$configureEmbedFields$1.invoke2((Collection<? extends Node<MessageRenderContext>>) parsedFields.get(i).getParsedName(), a.q("f_name:", i)));
            ((SimpleDraweeSpanTextView) childAt.findViewById(R$id.chat_list_item_embed_field_value)).setDraweeSpanStringBuilder(widgetChatListAdapterItemEmbed$configureEmbedFields$1.invoke2((Collection<? extends Node<MessageRenderContext>>) parsedFields.get(i).getParsedValue(), "f_value:" + i));
            this.binding.j.addView(childAt);
        }
    }

    private final void configureEmbedImage(MessageEmbed embed) {
        Integer num;
        EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
        RenderableEmbedMedia previewImage = embedResourceUtils.getPreviewImage(embed);
        if (previewImage == null) {
            CardView cardView = this.binding.f2316s;
            m.checkNotNullExpressionValue(cardView, "binding.embedImageContainer");
            cardView.setVisibility(8);
            return;
        }
        boolean zShouldRenderMedia = shouldRenderMedia();
        Integer num2 = previewImage.width;
        boolean z2 = num2 != null && d0.a0.a.getSign(num2.intValue()) == 1 && (num = previewImage.height) != null && d0.a0.a.getSign(num.intValue()) == 1;
        if (zShouldRenderMedia && z2) {
            SimpleDraweeView simpleDraweeView = this.binding.m;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatListItemEmbedImage");
            int i = this.maxEmbedImageWidth;
            int i2 = i / 2;
            Integer num3 = previewImage.width;
            int iIntValue = num3 != null ? num3.intValue() : 0;
            Integer num4 = previewImage.height;
            configureEmbedImage(simpleDraweeView, i, iIntValue, num4 != null ? num4.intValue() : 0, previewImage.url, i2);
            CardView cardView2 = this.binding.f2316s;
            m.checkNotNullExpressionValue(cardView2, "binding.embedImageContainer");
            cardView2.setVisibility(0);
        } else {
            CardView cardView3 = this.binding.f2316s;
            m.checkNotNullExpressionValue(cardView3, "binding.embedImageContainer");
            cardView3.setVisibility(8);
        }
        ImageView imageView = this.binding.n;
        m.checkNotNullExpressionValue(imageView, "binding.chatListItemEmbedImageIcons");
        imageView.setVisibility(embedResourceUtils.isPlayable(embed) && zShouldRenderMedia ? 0 : 8);
        this.binding.m.setOnClickListener(new WidgetChatListAdapterItemEmbed$configureEmbedImage$$inlined$apply$lambda$1(embed, this, previewImage, embed));
    }

    public static /* synthetic */ void configureEmbedImage$default(WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed, EmbedThumbnail embedThumbnail, ImageView imageView, int i, int i2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        widgetChatListAdapterItemEmbed.configureEmbedImage(embedThumbnail, imageView, i, i2);
    }

    private final void configureEmbedProvider(MessageEmbed embed, MessageRenderContext context) {
        EmbedProvider provider = embed.getProvider();
        if (provider == null) {
            TextView textView = this.binding.p;
            m.checkNotNullExpressionValue(textView, "binding.chatListItemEmbedProvider");
            textView.setVisibility(8);
            return;
        }
        String name = provider.getName();
        TextView textView2 = this.binding.p;
        m.checkNotNullExpressionValue(textView2, "binding.chatListItemEmbedProvider");
        textView2.setText(name);
        WidgetChatListAdapterItemEmbed$Companion widgetChatListAdapterItemEmbed$Companion = Companion;
        TextView textView3 = this.binding.p;
        m.checkNotNullExpressionValue(textView3, "binding.chatListItemEmbedProvider");
        WidgetChatListAdapterItemEmbed$Companion.access$bindUrlOnClick(widgetChatListAdapterItemEmbed$Companion, textView3, provider.getUrl(), provider.getName());
        TextView textView4 = this.binding.p;
        m.checkNotNullExpressionValue(textView4, "binding.chatListItemEmbedProvider");
        textView4.setVisibility(0);
    }

    private final void configureEmbedThumbnail(MessageEmbed embed) {
        boolean z2 = embed.getType() == EmbedType.LINK || embed.getType() == EmbedType.HTML || embed.getType() == EmbedType.RICH;
        EmbedThumbnail thumbnail = embed.getThumbnail();
        if (!z2 || thumbnail == null) {
            SimpleDraweeView simpleDraweeView = this.binding.o;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatListItemEmbedImageThumbnail");
            simpleDraweeView.setVisibility(8);
        } else {
            SimpleDraweeView simpleDraweeView2 = this.binding.o;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatListItemEmbedImageThumbnail");
            simpleDraweeView2.setVisibility(0);
            SimpleDraweeView simpleDraweeView3 = this.binding.o;
            m.checkNotNullExpressionValue(simpleDraweeView3, "binding.chatListItemEmbedImageThumbnail");
            configureEmbedImage$default(this, thumbnail, simpleDraweeView3, this.embedThumbnailMaxSize, 0, 8, null);
        }
    }

    private final void configureEmbedTitle(WidgetChatListAdapterItemEmbed$Model model, MessageRenderContext renderContext) {
        int themedColor;
        Map<Integer, Set<String>> visibleSpoilerEmbedMap;
        MessageEmbed embed = model.getEmbedEntry().getEmbed();
        String title = embed.getTitle();
        if (title == null) {
            LinkifiedTextView linkifiedTextView = this.binding.r;
            m.checkNotNullExpressionValue(linkifiedTextView, "binding.chatListItemEmbedTitle");
            linkifiedTextView.setVisibility(8);
            return;
        }
        int embedIndex = model.getEmbedEntry().getEmbedIndex();
        List list = Parser.parse$default(UI_THREAD_TITLES_PARSER, title, MessageParseState.Companion.getInitialState(), null, 4, null);
        long myId = model.getMyId();
        StoreMessageState$State messageState = model.getEmbedEntry().getMessageState();
        new MessagePreprocessor(myId, (messageState == null || (visibleSpoilerEmbedMap = messageState.getVisibleSpoilerEmbedMap()) == null) ? null : WidgetChatListAdapterItemEmbed$Companion.access$getEmbedFieldVisibleIndices(Companion, visibleSpoilerEmbedMap, embedIndex, EMBED_TYPE_TITLE), null, false, null, 28, null).process(list);
        this.binding.r.setDraweeSpanStringBuilder(AstRenderer.render(list, MessageRenderContext.copy$default(renderContext, null, 0L, false, null, null, null, 0, null, null, 0, 0, new WidgetChatListAdapterItemEmbed$configureEmbedTitle$1(model, embedIndex), null, null, 14335, null)));
        LinkifiedTextView linkifiedTextView2 = this.binding.r;
        if (embed.getUrl() != null) {
            LinkifiedTextView linkifiedTextView3 = this.binding.r;
            m.checkNotNullExpressionValue(linkifiedTextView3, "binding.chatListItemEmbedTitle");
            themedColor = ColorCompat.getThemedColor(linkifiedTextView3, 2130969054);
        } else {
            LinkifiedTextView linkifiedTextView4 = this.binding.r;
            m.checkNotNullExpressionValue(linkifiedTextView4, "binding.chatListItemEmbedTitle");
            themedColor = ColorCompat.getThemedColor(linkifiedTextView4, 2130969971);
        }
        linkifiedTextView2.setTextColor(themedColor);
        WidgetChatListAdapterItemEmbed$Companion widgetChatListAdapterItemEmbed$Companion = Companion;
        LinkifiedTextView linkifiedTextView5 = this.binding.r;
        m.checkNotNullExpressionValue(linkifiedTextView5, "binding.chatListItemEmbedTitle");
        WidgetChatListAdapterItemEmbed$Companion.access$bindUrlOnClick(widgetChatListAdapterItemEmbed$Companion, linkifiedTextView5, embed.getUrl(), embed.getTitle());
        LinkifiedTextView linkifiedTextView6 = this.binding.r;
        m.checkNotNullExpressionValue(linkifiedTextView6, "binding.chatListItemEmbedTitle");
        linkifiedTextView6.setVisibility(0);
    }

    private final void configureFooter(EmbedFooter footer, UtcDateTime timestamp) {
        CharSequence text = null;
        String text2 = footer != null ? footer.getText() : null;
        if (text2 == null || text2.length() == 0) {
            SimpleDraweeView simpleDraweeView = this.binding.k;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatListItemEmbedFooterIcon");
            simpleDraweeView.setVisibility(8);
        } else {
            SimpleDraweeView simpleDraweeView2 = this.binding.k;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatListItemEmbedFooterIcon");
            simpleDraweeView2.setVisibility((footer != null ? footer.getProxyIconUrl() : null) != null ? 0 : 8);
            SimpleDraweeView simpleDraweeView3 = this.binding.k;
            m.checkNotNullExpressionValue(simpleDraweeView3, "binding.chatListItemEmbedFooterIcon");
            int i = this.embedTinyIconSize;
            configureEmbedImage$default(this, simpleDraweeView3, i, i, i, footer != null ? footer.getProxyIconUrl() : null, 0, 32, null);
        }
        CharSequence readableTimeString$default = timestamp != null ? TimeUtils.toReadableTimeString$default(a.I(this.binding.l, "binding.chatListItemEmbedFooterText", "binding.chatListItemEmbedFooterText.context"), timestamp.getDateTimeMillis(), null, 4, null) : null;
        TextView textView = this.binding.l;
        if (footer != null && readableTimeString$default != null) {
            text = footer.getText() + " | " + readableTimeString$default;
        } else if (footer != null) {
            text = footer.getText();
        } else if (readableTimeString$default != null) {
            text = readableTimeString$default;
        }
        textView.setText(text);
        CharSequence text3 = textView.getText();
        m.checkNotNullExpressionValue(text3, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        textView.setVisibility(text3.length() > 0 ? 0 : 8);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0061  */
    private final void configureInlineEmbed(MessageEmbed embed, boolean autoPlayGifs) {
        RenderableEmbedMedia previewImage;
        boolean z2;
        if (!shouldRenderMedia()) {
            InlineMediaView inlineMediaView = this.binding.t;
            m.checkNotNullExpressionValue(inlineMediaView, "binding.embedInlineMedia");
            inlineMediaView.setVisibility(8);
            return;
        }
        EmbedVideo video = embed.getVideo();
        if (video != null) {
            m.checkNotNullParameter(video, "$this$asRenderableEmbedMedia");
            String proxyUrl = video.getProxyUrl();
            if (proxyUrl == null) {
                proxyUrl = video.getUrl();
            }
            previewImage = new RenderableEmbedMedia(proxyUrl, video.getWidth(), video.getHeight());
        } else {
            previewImage = EmbedResourceUtils.INSTANCE.getPreviewImage(embed);
        }
        if (previewImage != null) {
            Integer num = previewImage.width;
            if ((num != null ? num.intValue() : 0) > 0) {
                z2 = true;
            } else {
                Integer num2 = previewImage.height;
                if ((num2 != null ? num2.intValue() : 0) > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
                Integer num3 = previewImage.width;
                int iIntValue = num3 != null ? num3.intValue() : 0;
                Integer num4 = previewImage.height;
                int iIntValue2 = num4 != null ? num4.intValue() : 0;
                int i = this.maxEmbedImageWidth;
                int i2 = MAX_IMAGE_VIEW_HEIGHT_PX;
                InlineMediaView inlineMediaView2 = this.binding.t;
                m.checkNotNullExpressionValue(inlineMediaView2, "binding.embedInlineMedia");
                Resources resources = inlineMediaView2.getResources();
                m.checkNotNullExpressionValue(resources, "binding.embedInlineMedia.resources");
                Pair pairCalculateScaledSize$default = EmbedResourceUtils.calculateScaledSize$default(embedResourceUtils, iIntValue, iIntValue2, i, i2, resources, 0, 32, null);
                int iIntValue3 = ((Number) pairCalculateScaledSize$default.component1()).intValue();
                int iIntValue4 = ((Number) pairCalculateScaledSize$default.component2()).intValue();
                InlineMediaView inlineMediaView3 = this.binding.t;
                m.checkNotNullExpressionValue(inlineMediaView3, "binding.embedInlineMedia");
                inlineMediaView3.setVisibility(0);
                this.binding.t.updateUIWithEmbed(embed, Integer.valueOf(iIntValue3), Integer.valueOf(iIntValue4), autoPlayGifs);
            } else {
                InlineMediaView inlineMediaView4 = this.binding.t;
                m.checkNotNullExpressionValue(inlineMediaView4, "binding.embedInlineMedia");
                inlineMediaView4.setVisibility(8);
            }
        } else {
            InlineMediaView inlineMediaView5 = this.binding.t;
            m.checkNotNullExpressionValue(inlineMediaView5, "binding.embedInlineMedia");
            inlineMediaView5.setVisibility(8);
        }
        InlineMediaView inlineMediaView6 = this.binding.t;
        inlineMediaView6.setOnClickListener(new WidgetChatListAdapterItemEmbed$configureInlineEmbed$$inlined$apply$lambda$1(inlineMediaView6, embed));
    }

    private final void configureUI(WidgetChatListAdapterItemEmbed$Model model) {
        EmbedEntry embedEntry = model.getEmbedEntry();
        MessageEmbed embed = embedEntry.getEmbed();
        MessageRenderContext messageRenderContextCreateRenderContext = model.createRenderContext(a.x(this.itemView, "itemView", "itemView.context"), ((WidgetChatListAdapter) this.adapter).getEventHandler());
        if (model.getIsSpoilerHidden()) {
            ViewExtensions.fadeIn$default(this.binding.q, 50L, null, WidgetChatListAdapterItemEmbed$configureUI$1.INSTANCE, null, 10, null);
        } else {
            ViewExtensions.fadeOut$default(this.binding.q, 200L, WidgetChatListAdapterItemEmbed$configureUI$2.INSTANCE, null, 4, null);
        }
        this.binding.q.setOnClickListener(new WidgetChatListAdapterItemEmbed$configureUI$3(this, model, embedEntry));
        try {
            if (EmbedResourceUtils.INSTANCE.isInlineEmbed(embed)) {
                ConstraintLayout constraintLayout = this.binding.g;
                m.checkNotNullExpressionValue(constraintLayout, "binding.chatListItemEmbedContent");
                constraintLayout.setVisibility(8);
                View view = this.binding.i;
                m.checkNotNullExpressionValue(view, "binding.chatListItemEmbedDivider");
                view.setVisibility(8);
                SimpleDraweeView simpleDraweeView = this.binding.o;
                m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatListItemEmbedImageThumbnail");
                simpleDraweeView.setVisibility(8);
                InlineMediaView inlineMediaView = this.binding.t;
                m.checkNotNullExpressionValue(inlineMediaView, "binding.embedInlineMedia");
                inlineMediaView.setVisibility(0);
                configureInlineEmbed(embed, embedEntry.getAutoPlayGifs());
                MaterialCardView materialCardView = this.binding.f;
                View view2 = this.itemView;
                m.checkNotNullExpressionValue(view2, "itemView");
                materialCardView.setCardBackgroundColor(ColorCompat.getColor(view2, 2131100438));
                MaterialCardView materialCardView2 = this.binding.f;
                m.checkNotNullExpressionValue(materialCardView2, "binding.chatListItemEmbedContainerCard");
                materialCardView2.setStrokeWidth(0);
            } else {
                ConstraintLayout constraintLayout2 = this.binding.g;
                m.checkNotNullExpressionValue(constraintLayout2, "binding.chatListItemEmbedContent");
                constraintLayout2.setVisibility(0);
                View view3 = this.binding.i;
                m.checkNotNullExpressionValue(view3, "binding.chatListItemEmbedDivider");
                view3.setVisibility(0);
                InlineMediaView inlineMediaView2 = this.binding.t;
                m.checkNotNullExpressionValue(inlineMediaView2, "binding.embedInlineMedia");
                inlineMediaView2.setVisibility(8);
                configureEmbedDivider(!model.getIsSpoilerHidden() ? embed.getColor() : null);
                configureEmbedProvider(embed, messageRenderContextCreateRenderContext);
                configureEmbedAuthor(embed.getAuthor());
                configureEmbedTitle(model, messageRenderContextCreateRenderContext);
                configureEmbedDescription(model, messageRenderContextCreateRenderContext);
                configureEmbedThumbnail(embed);
                configureEmbedImage(embed);
                configureEmbedFields(model, messageRenderContextCreateRenderContext);
                configureFooter(embed.getFooter(), embed.getTimestamp());
                MaterialCardView materialCardView3 = this.binding.f;
                View view4 = this.itemView;
                m.checkNotNullExpressionValue(view4, "itemView");
                materialCardView3.setCardBackgroundColor(ColorCompat.getThemedColor(view4, 2130968912));
                MaterialCardView materialCardView4 = this.binding.f;
                m.checkNotNullExpressionValue(materialCardView4, "binding.chatListItemEmbedContainerCard");
                MaterialCardView materialCardView5 = this.binding.f;
                m.checkNotNullExpressionValue(materialCardView5, "binding.chatListItemEmbedContainerCard");
                materialCardView4.setStrokeWidth(materialCardView5.getResources().getDimensionPixelSize(2131165316));
            }
            View view5 = this.itemView;
            m.checkNotNullExpressionValue(view5, "itemView");
            view5.setVisibility(0);
        } catch (Exception e) {
            View view6 = this.itemView;
            m.checkNotNullExpressionValue(view6, "itemView");
            view6.setVisibility(8);
            Logger.e$default(AppLog.g, "Unable to render embed.", e, null, 4, null);
        }
    }

    private final List<WidgetChatListAdapterItemEmbed$Model$ParsedField> parseFields(List<EmbedField> fields, Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> nameParser, Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> valueParser) {
        if (fields == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(fields, 10));
        for (EmbedField embedField : fields) {
            String name = embedField.getName();
            MessageParseState$Companion messageParseState$Companion = MessageParseState.Companion;
            arrayList.add(new WidgetChatListAdapterItemEmbed$Model$ParsedField(Parser.parse$default(nameParser, name, messageParseState$Companion.getInitialState(), null, 4, null), Parser.parse$default(valueParser, embedField.getValue(), messageParseState$Companion.getInitialState(), null, 4, null)));
        }
        return arrayList;
    }

    private final boolean shouldRenderMedia() {
        return this.userSettings.getIsEmbedMediaInlined() && this.userSettings.getIsRenderEmbedsEnabled();
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
        this.binding.t.onPause();
    }

    @Override // com.discord.widgets.chat.list.FragmentLifecycleListener
    public void onResume() {
        this.binding.t.onResume();
    }

    public static /* synthetic */ void configureEmbedImage$default(WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed, ImageView imageView, int i, int i2, int i3, String str, int i4, int i5, Object obj) {
        widgetChatListAdapterItemEmbed.configureEmbedImage(imageView, i, i2, i3, str, (i5 & 32) != 0 ? 0 : i4);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        EmbedEntry embedEntry = (EmbedEntry) data;
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        ViewExtensions.setOnLongClickListenerConsumeClick(view, new WidgetChatListAdapterItemEmbed$onConfigure$1(this, data));
        this.itemView.setOnClickListener(new WidgetChatListAdapterItemEmbed$onConfigure$2(this, data));
        Message message = embedEntry.getMessage();
        View view2 = this.binding.c;
        m.checkNotNullExpressionValue(view2, "binding.chatListAdapterItemHighlightedBg");
        View view3 = this.binding.f2315b;
        m.checkNotNullExpressionValue(view3, "binding.chatListAdapterItemGutterBg");
        configureCellHighlight(message, view2, view3);
        String description = embedEntry.getEmbed().getDescription();
        WidgetChatListAdapterItemEmbed$Model widgetChatListAdapterItemEmbed$Model = new WidgetChatListAdapterItemEmbed$Model(embedEntry, description != null ? Parser.parse$default(UI_THREAD_VALUES_PARSER, description, MessageParseState.Companion.getInitialState(), null, 4, null) : null, parseFields(embedEntry.getEmbed().d(), UI_THREAD_TITLES_PARSER, UI_THREAD_VALUES_PARSER), null, null, null, 0L, 120, null);
        configureUI(widgetChatListAdapterItemEmbed$Model);
        Observable observableZ = WidgetChatListAdapterItemEmbed$Companion.access$getModel(Companion, widgetChatListAdapterItemEmbed$Model).Z(1);
        m.checkNotNullExpressionValue(observableZ, "getModel(initialModel)\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableZ), WidgetChatListAdapterItemEmbed.class, (Context) null, new WidgetChatListAdapterItemEmbed$onConfigure$3(this), (Function1) null, (Function0) null, (Function0) null, new WidgetChatListAdapterItemEmbed$onConfigure$4(this), 58, (Object) null);
    }

    private final void configureEmbedImage(EmbedThumbnail thumbnail, ImageView view, int maxWidth, int minWidth) {
        Integer width = thumbnail.getWidth();
        int iIntValue = width != null ? width.intValue() : 0;
        Integer height = thumbnail.getHeight();
        configureEmbedImage(view, maxWidth, iIntValue, height != null ? height.intValue() : 0, thumbnail.getProxyUrl(), minWidth);
    }

    private final void configureEmbedImage(ImageView view, int maxWidth, int width, int height, String imageProxyUrl, int minWidth) {
        if (imageProxyUrl == null) {
            return;
        }
        view.setVisibility(0);
        EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
        InlineMediaView inlineMediaView = this.binding.t;
        m.checkNotNullExpressionValue(inlineMediaView, "binding.embedInlineMedia");
        Resources resources = inlineMediaView.getResources();
        m.checkNotNullExpressionValue(resources, "binding.embedInlineMedia.resources");
        Pair<Integer, Integer> pairCalculateScaledSize = embedResourceUtils.calculateScaledSize(width, height, maxWidth, maxWidth, resources, minWidth);
        int iIntValue = pairCalculateScaledSize.component1().intValue();
        int iIntValue2 = pairCalculateScaledSize.component2().intValue();
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams.width != iIntValue || layoutParams.height != iIntValue2) {
            layoutParams.width = iIntValue;
            layoutParams.height = iIntValue2;
            view.requestLayout();
        }
        MGImages.setImage$default(view, EmbedResourceUtils.getPreviewUrls$default(embedResourceUtils, imageProxyUrl, iIntValue, iIntValue2, false, 8, null), 0, 0, false, null, null, null, 252, null);
    }
}

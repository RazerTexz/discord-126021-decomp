package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import com.discord.C5419R;
import com.discord.api.message.embed.EmbedAuthor;
import com.discord.api.message.embed.EmbedField;
import com.discord.api.message.embed.EmbedFooter;
import com.discord.api.message.embed.EmbedProvider;
import com.discord.api.message.embed.EmbedThumbnail;
import com.discord.api.message.embed.EmbedType;
import com.discord.api.message.embed.EmbedVideo;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.api.role.GuildRole;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetChatListAdapterItemEmbedBinding;
import com.discord.embed.RenderableEmbedMedia;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreMessageState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.embed.EmbedResourceUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.Tags;
import com.discord.utilities.textprocessing.TagsBuilder;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.textprocessing.node.UrlNode;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.chat.list.FragmentLifecycleListener;
import com.discord.widgets.chat.list.InlineMediaView;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.EmbedEntry;
import com.discord.widgets.media.WidgetMedia;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.card.MaterialCardView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p025i.C1091y4;
import p007b.p008a.p050t.p052b.p055c.InterfaceC1307a;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p508a0.C11210a;
import p507d0.p579g0.C12102s;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p579g0.C12108y;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p642l.p643a.EnumC12610d;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.functions.Func4;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed extends WidgetChatListItem implements FragmentLifecycleListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
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

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
    public static final class C80451 extends AbstractC12240o implements Function1<TextView, Unit> {
        public static final C80451 INSTANCE = new C80451();

        public C80451() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final TextView textView) {
            C12238m.checkNotNullParameter(textView, "$this$copyTextOnLongPress");
            textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed.1.1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    Context context = textView.getContext();
                    C12238m.checkNotNullExpressionValue(context, "context");
                    CharSequence text = textView.getText();
                    C12238m.checkNotNullExpressionValue(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                    C0876m.m165c(context, text, 0, 4);
                    return false;
                }
            });
        }
    }

    /* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
    public static final class Companion {
        private Companion() {
        }

        private final void bindUrlOnClick(View view, final String str, final String str2) {
            if (str != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$Companion$bindUrlOnClick$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        UriHandler.handleOrUntrusted(C1643a.m885x(view2, "view", "view.context"), str, str2);
                    }
                });
            } else {
                view.setOnClickListener(null);
            }
        }

        private final List<Integer> getEmbedFieldVisibleIndices(Map<Integer, ? extends Set<String>> map, int i, String str) {
            Set<String> set = map.get(Integer.valueOf(i));
            ArrayList arrayList = null;
            if (set != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : set) {
                    if (C12103t.startsWith$default((String) obj, str, false, 2, null)) {
                        arrayList2.add(obj);
                    }
                }
                arrayList = new ArrayList();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    Integer intOrNull = C12102s.toIntOrNull(C12108y.drop((String) it.next(), str.length() + 1));
                    if (intOrNull != null) {
                        arrayList.add(intOrNull);
                    }
                }
            }
            return arrayList;
        }

        private final Observable<Model> getModel(Model initialModel) {
            final EmbedEntry embedEntry = initialModel.getEmbedEntry();
            final Collection<Node<MessageRenderContext>> parsedDescription = initialModel.getParsedDescription();
            final List<Model.ParsedField> parsedFields = initialModel.getParsedFields();
            TagsBuilder tagsBuilder = new TagsBuilder();
            if (parsedDescription != null) {
                tagsBuilder.processAst(parsedDescription);
            }
            if (parsedFields != null) {
                for (Model.ParsedField parsedField : parsedFields) {
                    tagsBuilder.processAst(parsedField.getParsedName());
                    tagsBuilder.processAst(parsedField.getParsedValue());
                }
            }
            Tags tagsBuild = tagsBuilder.build();
            if (tagsBuild.getIsEmpty()) {
                Observable observable = EnumC12610d.f26760k;
                C12238m.checkNotNullExpressionValue(observable, "Observable.never()");
                return observable;
            }
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableM11073h = Observable.m11073h(companion.getUsers().observeMeId(), companion.getChannels().observeNames(tagsBuild.getChannels()), Observable.m11076j(companion.getGuilds().observeComputed(embedEntry.getGuildId(), tagsBuild.getUsers()), companion.getUsers().observeUsernames(tagsBuild.getUsers()), new Func2<Map<Long, ? extends GuildMember>, Map<Long, ? extends String>, HashMap<Long, String>>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$Companion$getModel$1
                @Override // p658rx.functions.Func2
                public /* bridge */ /* synthetic */ HashMap<Long, String> call(Map<Long, ? extends GuildMember> map, Map<Long, ? extends String> map2) {
                    return call2((Map<Long, GuildMember>) map, (Map<Long, String>) map2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final HashMap<Long, String> call2(Map<Long, GuildMember> map, Map<Long, String> map2) {
                    C12238m.checkNotNullExpressionValue(map, "members");
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<Long, GuildMember> entry : map.entrySet()) {
                        if (entry.getValue().getNick() != null) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    HashMap<Long, String> map3 = new HashMap<>(map2);
                    for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                        Object key = entry2.getKey();
                        String nick = ((GuildMember) entry2.getValue()).getNick();
                        C12238m.checkNotNull(nick);
                        map3.put(key, nick);
                    }
                    return map3;
                }
            }), companion.getGuilds().observeRoles(embedEntry.getGuildId(), tagsBuild.getRoles()), new Func4<Long, Map<Long, ? extends String>, HashMap<Long, String>, Map<Long, ? extends GuildRole>, Model>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$Companion$getModel$2
                @Override // p658rx.functions.Func4
                public /* bridge */ /* synthetic */ WidgetChatListAdapterItemEmbed.Model call(Long l, Map<Long, ? extends String> map, HashMap<Long, String> map2, Map<Long, ? extends GuildRole> map3) {
                    return call2(l, (Map<Long, String>) map, map2, (Map<Long, GuildRole>) map3);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final WidgetChatListAdapterItemEmbed.Model call2(Long l, Map<Long, String> map, HashMap<Long, String> map2, Map<Long, GuildRole> map3) {
                    EmbedEntry embedEntry2 = embedEntry;
                    Collection collection = parsedDescription;
                    List list = parsedFields;
                    C12238m.checkNotNullExpressionValue(l, "myId");
                    return new WidgetChatListAdapterItemEmbed.Model(embedEntry2, collection, list, map, map2, map3, l.longValue());
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11073h, "Observable\n          .co… roles, myId)\n          }");
            Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11073h).m11112r();
            C12238m.checkNotNullExpressionValue(observableM11112r, "Observable\n          .co…  .distinctUntilChanged()");
            return observableM11112r;
        }

        public final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> createTitlesParser() {
            return DiscordParser.createParser$default(false, false, false, false, false, 28, null);
        }

        public final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> getUI_THREAD_TITLES_PARSER() {
            return WidgetChatListAdapterItemEmbed.UI_THREAD_TITLES_PARSER;
        }

        public final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> getUI_THREAD_VALUES_PARSER() {
            return WidgetChatListAdapterItemEmbed.UI_THREAD_VALUES_PARSER;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$configureEmbedDescription$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
    public static final class C80481 extends AbstractC12240o implements Function1<SpoilerNode<?>, Unit> {
        public final /* synthetic */ int $embedIndex;
        public final /* synthetic */ long $messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C80481(long j, int i) {
            super(1);
            this.$messageId = j;
            this.$embedIndex = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
            invoke2(spoilerNode);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SpoilerNode<?> spoilerNode) {
            C12238m.checkNotNullParameter(spoilerNode, "node");
            StoreMessageState messageState = StoreStream.INSTANCE.getMessageState();
            long j = this.$messageId;
            int i = this.$embedIndex;
            StringBuilder sbM833U = C1643a.m833U("desc:");
            sbM833U.append(spoilerNode.getId());
            messageState.revealSpoilerEmbedData(j, i, sbM833U.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$configureEmbedFields$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
    public static final class C80491 extends AbstractC12240o implements Function2<Collection<? extends Node<MessageRenderContext>>, String, DraweeSpanStringBuilder> {
        public final /* synthetic */ int $embedIndex;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ Model $model;
        public final /* synthetic */ MessageRenderContext $renderContext;
        public final /* synthetic */ Map $visibleSpoilerEmbedMap;

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$configureEmbedFields$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<SpoilerNode<?>, Unit> {
            public final /* synthetic */ String $prefixKey;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(String str) {
                super(1);
                this.$prefixKey = str;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
                invoke2(spoilerNode);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SpoilerNode<?> spoilerNode) {
                C12238m.checkNotNullParameter(spoilerNode, "node");
                StoreMessageState messageState = StoreStream.INSTANCE.getMessageState();
                C80491 c80491 = C80491.this;
                messageState.revealSpoilerEmbedData(c80491.$messageId, c80491.$embedIndex, this.$prefixKey + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + spoilerNode.getId());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C80491(Model model, Map map, int i, MessageRenderContext messageRenderContext, long j) {
            super(2);
            this.$model = model;
            this.$visibleSpoilerEmbedMap = map;
            this.$embedIndex = i;
            this.$renderContext = messageRenderContext;
            this.$messageId = j;
        }

        @Override // kotlin.jvm.functions.Function2
        public final DraweeSpanStringBuilder invoke(Collection<? extends Node<MessageRenderContext>> collection, String str) {
            C12238m.checkNotNullParameter(collection, "$this$toDraweeSpanStringBuilder");
            C12238m.checkNotNullParameter(str, "prefixKey");
            long myId = this.$model.getMyId();
            Map map = this.$visibleSpoilerEmbedMap;
            new MessagePreprocessor(myId, map != null ? WidgetChatListAdapterItemEmbed.INSTANCE.getEmbedFieldVisibleIndices(map, this.$embedIndex, str) : null, null, false, null, 28, null).process(collection);
            MessageRenderContext messageRenderContext = this.$renderContext;
            return AstRenderer.render(collection, messageRenderContext.copy((14335 & 1) != 0 ? messageRenderContext.getContext() : null, (14335 & 2) != 0 ? messageRenderContext.getMyId() : 0L, (14335 & 4) != 0 ? messageRenderContext.getIsAnimationEnabled() : false, (14335 & 8) != 0 ? messageRenderContext.getUserNames() : null, (14335 & 16) != 0 ? messageRenderContext.getChannelNames() : null, (14335 & 32) != 0 ? messageRenderContext.getRoles() : null, (14335 & 64) != 0 ? messageRenderContext.getLinkColorAttrResId() : 0, (14335 & 128) != 0 ? messageRenderContext.getOnClickUrl() : null, (14335 & 256) != 0 ? messageRenderContext.getOnLongPressUrl() : null, (14335 & 512) != 0 ? messageRenderContext.getSpoilerColorRes() : 0, (14335 & 1024) != 0 ? messageRenderContext.getSpoilerRevealedColorRes() : 0, (14335 & 2048) != 0 ? messageRenderContext.getSpoilerOnClick() : new AnonymousClass1(str), (14335 & 4096) != 0 ? messageRenderContext.getUserMentionOnClick() : null, (14335 & 8192) != 0 ? messageRenderContext.getChannelMentionOnClick() : null));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$configureEmbedTitle$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
    public static final class C80511 extends AbstractC12240o implements Function1<SpoilerNode<?>, Unit> {
        public final /* synthetic */ int $embedIndex;
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C80511(Model model, int i) {
            super(1);
            this.$model = model;
            this.$embedIndex = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
            invoke2(spoilerNode);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SpoilerNode<?> spoilerNode) {
            C12238m.checkNotNullParameter(spoilerNode, "node");
            StoreMessageState messageState = StoreStream.INSTANCE.getMessageState();
            long id2 = this.$model.getEmbedEntry().getMessage().getId();
            int i = this.$embedIndex;
            StringBuilder sbM833U = C1643a.m833U("title:");
            sbM833U.append(spoilerNode.getId());
            messageState.revealSpoilerEmbedData(id2, i, sbM833U.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$configureUI$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
    public static final class C80531 extends AbstractC12240o implements Function1<ViewPropertyAnimator, Unit> {
        public static final C80531 INSTANCE = new C80531();

        public C80531() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            C12238m.checkNotNullParameter(viewPropertyAnimator, "$receiver");
            viewPropertyAnimator.scaleX(1.0f);
            viewPropertyAnimator.scaleY(1.0f);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$configureUI$2 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
    public static final class C80542 extends AbstractC12240o implements Function1<ViewPropertyAnimator, Unit> {
        public static final C80542 INSTANCE = new C80542();

        public C80542() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            C12238m.checkNotNullParameter(viewPropertyAnimator, "$receiver");
            viewPropertyAnimator.scaleX(0.9f);
            viewPropertyAnimator.scaleY(0.9f);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$onConfigure$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
    public static final class C80561 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ ChatListEntry $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C80561(ChatListEntry chatListEntry) {
            super(1);
            this.$data = chatListEntry;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            WidgetChatListAdapterItemEmbed.access$getAdapter$p(WidgetChatListAdapterItemEmbed.this).getEventHandler().onMessageLongClicked(((EmbedEntry) this.$data).getMessage(), "", ((EmbedEntry) this.$data).isThreadStarterMessage());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$onConfigure$3 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
    public static final class C80583 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C80583() {
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
            WidgetChatListAdapterItemEmbed.this.subscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$onConfigure$4 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
    public static final class C80594 extends AbstractC12240o implements Function1<Model, Unit> {
        public C80594() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            MessageRenderContext messageRenderContextCreateRenderContext = model.createRenderContext(C1643a.m885x(WidgetChatListAdapterItemEmbed.this.itemView, "itemView", "itemView.context"), WidgetChatListAdapterItemEmbed.access$getAdapter$p(WidgetChatListAdapterItemEmbed.this).getEventHandler());
            WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed = WidgetChatListAdapterItemEmbed.this;
            C12238m.checkNotNullExpressionValue(model, "model");
            widgetChatListAdapterItemEmbed.configureEmbedTitle(model, messageRenderContextCreateRenderContext);
            WidgetChatListAdapterItemEmbed.this.configureEmbedDescription(model, messageRenderContextCreateRenderContext);
            WidgetChatListAdapterItemEmbed.this.configureEmbedFields(model, messageRenderContextCreateRenderContext);
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        MAX_IMAGE_VIEW_HEIGHT_PX = DimenUtils.dpToPixels(360);
        UI_THREAD_TITLES_PARSER = companion.createTitlesParser();
        UI_THREAD_VALUES_PARSER = DiscordParser.createParser$default(true, true, false, false, false, 28, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemEmbed(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_embed, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.chat_list_adapter_item_gutter_bg;
        View viewFindViewById = view.findViewById(C5419R.id.chat_list_adapter_item_gutter_bg);
        if (viewFindViewById != null) {
            i = C5419R.id.chat_list_adapter_item_highlighted_bg;
            View viewFindViewById2 = view.findViewById(C5419R.id.chat_list_adapter_item_highlighted_bg);
            if (viewFindViewById2 != null) {
                i = C5419R.id.chat_list_item_embed_author_icon;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.chat_list_item_embed_author_icon);
                if (simpleDraweeView != null) {
                    i = C5419R.id.chat_list_item_embed_author_text;
                    TextView textView = (TextView) view.findViewById(C5419R.id.chat_list_item_embed_author_text);
                    if (textView != null) {
                        i = C5419R.id.chat_list_item_embed_barrier_data;
                        Barrier barrier = (Barrier) view.findViewById(C5419R.id.chat_list_item_embed_barrier_data);
                        if (barrier != null) {
                            i = C5419R.id.chat_list_item_embed_barrier_header;
                            Barrier barrier2 = (Barrier) view.findViewById(C5419R.id.chat_list_item_embed_barrier_header);
                            if (barrier2 != null) {
                                i = C5419R.id.chat_list_item_embed_container_card;
                                MaterialCardView materialCardView = (MaterialCardView) view.findViewById(C5419R.id.chat_list_item_embed_container_card);
                                if (materialCardView != null) {
                                    i = C5419R.id.chat_list_item_embed_content;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C5419R.id.chat_list_item_embed_content);
                                    if (constraintLayout != null) {
                                        i = C5419R.id.chat_list_item_embed_description;
                                        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.chat_list_item_embed_description);
                                        if (linkifiedTextView != null) {
                                            i = C5419R.id.chat_list_item_embed_divider;
                                            View viewFindViewById3 = view.findViewById(C5419R.id.chat_list_item_embed_divider);
                                            if (viewFindViewById3 != null) {
                                                i = C5419R.id.chat_list_item_embed_fields;
                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.chat_list_item_embed_fields);
                                                if (linearLayout != null) {
                                                    i = C5419R.id.chat_list_item_embed_footer_icon;
                                                    SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(C5419R.id.chat_list_item_embed_footer_icon);
                                                    if (simpleDraweeView2 != null) {
                                                        i = C5419R.id.chat_list_item_embed_footer_text;
                                                        TextView textView2 = (TextView) view.findViewById(C5419R.id.chat_list_item_embed_footer_text);
                                                        if (textView2 != null) {
                                                            i = C5419R.id.chat_list_item_embed_image;
                                                            SimpleDraweeView simpleDraweeView3 = (SimpleDraweeView) view.findViewById(C5419R.id.chat_list_item_embed_image);
                                                            if (simpleDraweeView3 != null) {
                                                                i = C5419R.id.chat_list_item_embed_image_icons;
                                                                ImageView imageView = (ImageView) view.findViewById(C5419R.id.chat_list_item_embed_image_icons);
                                                                if (imageView != null) {
                                                                    i = C5419R.id.chat_list_item_embed_image_thumbnail;
                                                                    SimpleDraweeView simpleDraweeView4 = (SimpleDraweeView) view.findViewById(C5419R.id.chat_list_item_embed_image_thumbnail);
                                                                    if (simpleDraweeView4 != null) {
                                                                        i = C5419R.id.chat_list_item_embed_provider;
                                                                        TextView textView3 = (TextView) view.findViewById(C5419R.id.chat_list_item_embed_provider);
                                                                        if (textView3 != null) {
                                                                            i = C5419R.id.chat_list_item_embed_spoiler;
                                                                            FrameLayout frameLayout = (FrameLayout) view.findViewById(C5419R.id.chat_list_item_embed_spoiler);
                                                                            if (frameLayout != null) {
                                                                                i = C5419R.id.chat_list_item_embed_title;
                                                                                LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) view.findViewById(C5419R.id.chat_list_item_embed_title);
                                                                                if (linkifiedTextView2 != null) {
                                                                                    i = C5419R.id.embed_image_container;
                                                                                    CardView cardView = (CardView) view.findViewById(C5419R.id.embed_image_container);
                                                                                    if (cardView != null) {
                                                                                        i = C5419R.id.embed_inline_media;
                                                                                        InlineMediaView inlineMediaView = (InlineMediaView) view.findViewById(C5419R.id.embed_inline_media);
                                                                                        if (inlineMediaView != null) {
                                                                                            WidgetChatListAdapterItemEmbedBinding widgetChatListAdapterItemEmbedBinding = new WidgetChatListAdapterItemEmbedBinding((ConstraintLayout) view, viewFindViewById, viewFindViewById2, simpleDraweeView, textView, barrier, barrier2, materialCardView, constraintLayout, linkifiedTextView, viewFindViewById3, linearLayout, simpleDraweeView2, textView2, simpleDraweeView3, imageView, simpleDraweeView4, textView3, frameLayout, linkifiedTextView2, cardView, inlineMediaView);
                                                                                            C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemEmbedBinding, "WidgetChatListAdapterIte…bedBinding.bind(itemView)");
                                                                                            this.binding = widgetChatListAdapterItemEmbedBinding;
                                                                                            C80451 c80451 = C80451.INSTANCE;
                                                                                            C12238m.checkNotNullExpressionValue(textView3, "binding.chatListItemEmbedProvider");
                                                                                            c80451.invoke2(textView3);
                                                                                            C12238m.checkNotNullExpressionValue(linkifiedTextView2, "binding.chatListItemEmbedTitle");
                                                                                            c80451.invoke2((TextView) linkifiedTextView2);
                                                                                            C12238m.checkNotNullExpressionValue(textView, "binding.chatListItemEmbedAuthorText");
                                                                                            c80451.invoke2(textView);
                                                                                            C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.chatListItemEmbedDescription");
                                                                                            c80451.invoke2((TextView) linkifiedTextView);
                                                                                            C12238m.checkNotNullExpressionValue(textView2, "binding.chatListItemEmbedFooterText");
                                                                                            c80451.invoke2(textView2);
                                                                                            this.userSettings = StoreStream.INSTANCE.getUserSettings();
                                                                                            View view2 = this.itemView;
                                                                                            C12238m.checkNotNullExpressionValue(view2, "itemView");
                                                                                            this.embedTinyIconSize = (int) view2.getResources().getDimension(C5419R.dimen.embed_tiny_icon_size);
                                                                                            View view3 = this.itemView;
                                                                                            C12238m.checkNotNullExpressionValue(view3, "itemView");
                                                                                            this.embedThumbnailMaxSize = (int) view3.getResources().getDimension(C5419R.dimen.embed_thumbnail_max_size);
                                                                                            EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
                                                                                            View view4 = this.itemView;
                                                                                            C12238m.checkNotNullExpressionValue(view4, "itemView");
                                                                                            Context context = view4.getContext();
                                                                                            C12238m.checkNotNullExpressionValue(context, "itemView.context");
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

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemEmbed.adapter;
    }

    private final void configureEmbedAuthor(EmbedAuthor author) {
        if (author != null) {
            TextView textView = this.binding.f16184e;
            C12238m.checkNotNullExpressionValue(textView, "binding.chatListItemEmbedAuthorText");
            textView.setText(author.getName());
            Companion companion = INSTANCE;
            TextView textView2 = this.binding.f16184e;
            C12238m.checkNotNullExpressionValue(textView2, "binding.chatListItemEmbedAuthorText");
            companion.bindUrlOnClick(textView2, author.getUrl(), author.getName());
            TextView textView3 = this.binding.f16184e;
            C12238m.checkNotNullExpressionValue(textView3, "binding.chatListItemEmbedAuthorText");
            textView3.setVisibility(0);
        } else {
            TextView textView4 = this.binding.f16184e;
            C12238m.checkNotNullExpressionValue(textView4, "binding.chatListItemEmbedAuthorText");
            textView4.setVisibility(8);
        }
        if ((author != null ? author.getProxyIconUrl() : null) == null) {
            SimpleDraweeView simpleDraweeView = this.binding.f16183d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatListItemEmbedAuthorIcon");
            simpleDraweeView.setVisibility(8);
            return;
        }
        SimpleDraweeView simpleDraweeView2 = this.binding.f16183d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatListItemEmbedAuthorIcon");
        simpleDraweeView2.setVisibility(0);
        SimpleDraweeView simpleDraweeView3 = this.binding.f16183d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.chatListItemEmbedAuthorIcon");
        int i = this.embedTinyIconSize;
        configureEmbedImage$default(this, simpleDraweeView3, i, i, i, author.getProxyIconUrl(), 0, 32, null);
    }

    private final void configureEmbedDescription(Model model, MessageRenderContext renderContext) {
        Map<Integer, Set<String>> visibleSpoilerEmbedMap;
        if (model.getParsedDescription() == null) {
            LinkifiedTextView linkifiedTextView = this.binding.f16187h;
            C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.chatListItemEmbedDescription");
            linkifiedTextView.setVisibility(8);
            return;
        }
        long id2 = model.getEmbedEntry().getMessage().getId();
        int embedIndex = model.getEmbedEntry().getEmbedIndex();
        long myId = model.getMyId();
        StoreMessageState.State messageState = model.getEmbedEntry().getMessageState();
        new MessagePreprocessor(myId, (messageState == null || (visibleSpoilerEmbedMap = messageState.getVisibleSpoilerEmbedMap()) == null) ? null : INSTANCE.getEmbedFieldVisibleIndices(visibleSpoilerEmbedMap, embedIndex, EMBED_TYPE_DESC), null, false, null, 28, null).process(model.getParsedDescription());
        this.binding.f16187h.setDraweeSpanStringBuilder(AstRenderer.render(model.getParsedDescription(), renderContext.copy((14335 & 1) != 0 ? renderContext.getContext() : null, (14335 & 2) != 0 ? renderContext.getMyId() : 0L, (14335 & 4) != 0 ? renderContext.getIsAnimationEnabled() : false, (14335 & 8) != 0 ? renderContext.getUserNames() : null, (14335 & 16) != 0 ? renderContext.getChannelNames() : null, (14335 & 32) != 0 ? renderContext.getRoles() : null, (14335 & 64) != 0 ? renderContext.getLinkColorAttrResId() : 0, (14335 & 128) != 0 ? renderContext.getOnClickUrl() : null, (14335 & 256) != 0 ? renderContext.getOnLongPressUrl() : null, (14335 & 512) != 0 ? renderContext.getSpoilerColorRes() : 0, (14335 & 1024) != 0 ? renderContext.getSpoilerRevealedColorRes() : 0, (14335 & 2048) != 0 ? renderContext.getSpoilerOnClick() : new C80481(id2, embedIndex), (14335 & 4096) != 0 ? renderContext.getUserMentionOnClick() : null, (14335 & 8192) != 0 ? renderContext.getChannelMentionOnClick() : null)));
        LinkifiedTextView linkifiedTextView2 = this.binding.f16187h;
        C12238m.checkNotNullExpressionValue(linkifiedTextView2, "binding.chatListItemEmbedDescription");
        linkifiedTextView2.setVisibility(0);
    }

    private final void configureEmbedDivider(Integer color) {
        int themedColor;
        View view = this.binding.f16188i;
        if (color != null) {
            themedColor = ColorUtils.setAlphaComponent(color.intValue(), 255);
        } else {
            C12238m.checkNotNullExpressionValue(view, "binding.chatListItemEmbedDivider");
            themedColor = ColorCompat.getThemedColor(view.getContext(), C5419R.attr.colorBackgroundModifierAccent);
        }
        view.setBackgroundColor(themedColor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v6, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r5v7, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r6v7, types: [android.widget.LinearLayout] */
    private final void configureEmbedFields(Model model, MessageRenderContext renderContext) {
        ?? childAt;
        List<Model.ParsedField> parsedFields = model.getParsedFields();
        this.binding.f16189j.removeAllViews();
        if (parsedFields == null) {
            LinearLayout linearLayout = this.binding.f16189j;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.chatListItemEmbedFields");
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout2 = this.binding.f16189j;
        C12238m.checkNotNullExpressionValue(linearLayout2, "binding.chatListItemEmbedFields");
        linearLayout2.setVisibility(0);
        LinearLayout linearLayout3 = this.binding.f16189j;
        C12238m.checkNotNullExpressionValue(linearLayout3, "binding.chatListItemEmbedFields");
        Context context = linearLayout3.getContext();
        long id2 = model.getEmbedEntry().getMessage().getId();
        int embedIndex = model.getEmbedEntry().getEmbedIndex();
        StoreMessageState.State messageState = model.getEmbedEntry().getMessageState();
        C80491 c80491 = new C80491(model, messageState != null ? messageState.getVisibleSpoilerEmbedMap() : null, embedIndex, renderContext, id2);
        int size = parsedFields.size();
        for (int i = 0; i < size; i++) {
            LinearLayout linearLayout4 = this.binding.f16189j;
            C12238m.checkNotNullExpressionValue(linearLayout4, "binding.chatListItemEmbedFields");
            int childCount = linearLayout4.getChildCount();
            int i2 = C5419R.id.chat_list_item_embed_field_value;
            if (i >= childCount) {
                View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.widget_chat_list_adapter_item_embed_field, (ViewGroup) this.binding.f16189j, false);
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewInflate.findViewById(C5419R.id.chat_list_item_embed_field_name);
                if (linkifiedTextView != null) {
                    LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) viewInflate.findViewById(C5419R.id.chat_list_item_embed_field_value);
                    if (linkifiedTextView2 != null) {
                        childAt = (LinearLayout) viewInflate;
                        C12238m.checkNotNullExpressionValue(new C1091y4(childAt, linkifiedTextView, linkifiedTextView2), "WidgetChatListAdapterIte…edFields, false\n        )");
                    }
                } else {
                    i2 = C5419R.id.chat_list_item_embed_field_name;
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
            }
            childAt = this.binding.f16189j.getChildAt(i);
            ((SimpleDraweeSpanTextView) childAt.findViewById(C5419R.id.chat_list_item_embed_field_name)).setDraweeSpanStringBuilder(c80491.invoke((Collection<? extends Node<MessageRenderContext>>) parsedFields.get(i).getParsedName(), C1643a.m871q("f_name:", i)));
            ((SimpleDraweeSpanTextView) childAt.findViewById(C5419R.id.chat_list_item_embed_field_value)).setDraweeSpanStringBuilder(c80491.invoke((Collection<? extends Node<MessageRenderContext>>) parsedFields.get(i).getParsedValue(), "f_value:" + i));
            this.binding.f16189j.addView(childAt);
        }
    }

    private final void configureEmbedImage(final MessageEmbed embed) {
        Integer num;
        EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
        final RenderableEmbedMedia previewImage = embedResourceUtils.getPreviewImage(embed);
        if (previewImage == null) {
            CardView cardView = this.binding.f16198s;
            C12238m.checkNotNullExpressionValue(cardView, "binding.embedImageContainer");
            cardView.setVisibility(8);
            return;
        }
        boolean zShouldRenderMedia = shouldRenderMedia();
        Integer num2 = previewImage.width;
        boolean z2 = num2 != null && C11210a.getSign(num2.intValue()) == 1 && (num = previewImage.height) != null && C11210a.getSign(num.intValue()) == 1;
        if (zShouldRenderMedia && z2) {
            SimpleDraweeView simpleDraweeView = this.binding.f16192m;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatListItemEmbedImage");
            int i = this.maxEmbedImageWidth;
            int i2 = i / 2;
            Integer num3 = previewImage.width;
            int iIntValue = num3 != null ? num3.intValue() : 0;
            Integer num4 = previewImage.height;
            configureEmbedImage(simpleDraweeView, i, iIntValue, num4 != null ? num4.intValue() : 0, previewImage.url, i2);
            CardView cardView2 = this.binding.f16198s;
            C12238m.checkNotNullExpressionValue(cardView2, "binding.embedImageContainer");
            cardView2.setVisibility(0);
        } else {
            CardView cardView3 = this.binding.f16198s;
            C12238m.checkNotNullExpressionValue(cardView3, "binding.embedImageContainer");
            cardView3.setVisibility(8);
        }
        ImageView imageView = this.binding.f16193n;
        C12238m.checkNotNullExpressionValue(imageView, "binding.chatListItemEmbedImageIcons");
        imageView.setVisibility(embedResourceUtils.isPlayable(embed) && zShouldRenderMedia ? 0 : 8);
        this.binding.f16192m.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$configureEmbedImage$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String externalOpenUrl = EmbedResourceUtils.INSTANCE.getExternalOpenUrl(embed);
                if (externalOpenUrl != null) {
                    UriHandler.handleOrUntrusted(C1643a.m885x(view, "view", "view.context"), externalOpenUrl, embed.getTitle());
                } else {
                    WidgetMedia.INSTANCE.launch(C1643a.m885x(view, "view", "view.context"), embed);
                }
            }
        });
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
            TextView textView = this.binding.f16195p;
            C12238m.checkNotNullExpressionValue(textView, "binding.chatListItemEmbedProvider");
            textView.setVisibility(8);
            return;
        }
        String name = provider.getName();
        TextView textView2 = this.binding.f16195p;
        C12238m.checkNotNullExpressionValue(textView2, "binding.chatListItemEmbedProvider");
        textView2.setText(name);
        Companion companion = INSTANCE;
        TextView textView3 = this.binding.f16195p;
        C12238m.checkNotNullExpressionValue(textView3, "binding.chatListItemEmbedProvider");
        companion.bindUrlOnClick(textView3, provider.getUrl(), provider.getName());
        TextView textView4 = this.binding.f16195p;
        C12238m.checkNotNullExpressionValue(textView4, "binding.chatListItemEmbedProvider");
        textView4.setVisibility(0);
    }

    private final void configureEmbedThumbnail(MessageEmbed embed) {
        boolean z2 = embed.getType() == EmbedType.LINK || embed.getType() == EmbedType.HTML || embed.getType() == EmbedType.RICH;
        EmbedThumbnail thumbnail = embed.getThumbnail();
        if (!z2 || thumbnail == null) {
            SimpleDraweeView simpleDraweeView = this.binding.f16194o;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatListItemEmbedImageThumbnail");
            simpleDraweeView.setVisibility(8);
        } else {
            SimpleDraweeView simpleDraweeView2 = this.binding.f16194o;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatListItemEmbedImageThumbnail");
            simpleDraweeView2.setVisibility(0);
            SimpleDraweeView simpleDraweeView3 = this.binding.f16194o;
            C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.chatListItemEmbedImageThumbnail");
            configureEmbedImage$default(this, thumbnail, simpleDraweeView3, this.embedThumbnailMaxSize, 0, 8, null);
        }
    }

    private final void configureEmbedTitle(Model model, MessageRenderContext renderContext) {
        int themedColor;
        Map<Integer, Set<String>> visibleSpoilerEmbedMap;
        MessageEmbed embed = model.getEmbedEntry().getEmbed();
        String title = embed.getTitle();
        if (title == null) {
            LinkifiedTextView linkifiedTextView = this.binding.f16197r;
            C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.chatListItemEmbedTitle");
            linkifiedTextView.setVisibility(8);
            return;
        }
        int embedIndex = model.getEmbedEntry().getEmbedIndex();
        List list = Parser.parse$default(UI_THREAD_TITLES_PARSER, title, MessageParseState.INSTANCE.getInitialState(), null, 4, null);
        long myId = model.getMyId();
        StoreMessageState.State messageState = model.getEmbedEntry().getMessageState();
        new MessagePreprocessor(myId, (messageState == null || (visibleSpoilerEmbedMap = messageState.getVisibleSpoilerEmbedMap()) == null) ? null : INSTANCE.getEmbedFieldVisibleIndices(visibleSpoilerEmbedMap, embedIndex, EMBED_TYPE_TITLE), null, false, null, 28, null).process(list);
        this.binding.f16197r.setDraweeSpanStringBuilder(AstRenderer.render(list, renderContext.copy((14335 & 1) != 0 ? renderContext.getContext() : null, (14335 & 2) != 0 ? renderContext.getMyId() : 0L, (14335 & 4) != 0 ? renderContext.getIsAnimationEnabled() : false, (14335 & 8) != 0 ? renderContext.getUserNames() : null, (14335 & 16) != 0 ? renderContext.getChannelNames() : null, (14335 & 32) != 0 ? renderContext.getRoles() : null, (14335 & 64) != 0 ? renderContext.getLinkColorAttrResId() : 0, (14335 & 128) != 0 ? renderContext.getOnClickUrl() : null, (14335 & 256) != 0 ? renderContext.getOnLongPressUrl() : null, (14335 & 512) != 0 ? renderContext.getSpoilerColorRes() : 0, (14335 & 1024) != 0 ? renderContext.getSpoilerRevealedColorRes() : 0, (14335 & 2048) != 0 ? renderContext.getSpoilerOnClick() : new C80511(model, embedIndex), (14335 & 4096) != 0 ? renderContext.getUserMentionOnClick() : null, (14335 & 8192) != 0 ? renderContext.getChannelMentionOnClick() : null)));
        LinkifiedTextView linkifiedTextView2 = this.binding.f16197r;
        if (embed.getUrl() != null) {
            LinkifiedTextView linkifiedTextView3 = this.binding.f16197r;
            C12238m.checkNotNullExpressionValue(linkifiedTextView3, "binding.chatListItemEmbedTitle");
            themedColor = ColorCompat.getThemedColor(linkifiedTextView3, C5419R.attr.colorTextLink);
        } else {
            LinkifiedTextView linkifiedTextView4 = this.binding.f16197r;
            C12238m.checkNotNullExpressionValue(linkifiedTextView4, "binding.chatListItemEmbedTitle");
            themedColor = ColorCompat.getThemedColor(linkifiedTextView4, C5419R.attr.primary_100);
        }
        linkifiedTextView2.setTextColor(themedColor);
        Companion companion = INSTANCE;
        LinkifiedTextView linkifiedTextView5 = this.binding.f16197r;
        C12238m.checkNotNullExpressionValue(linkifiedTextView5, "binding.chatListItemEmbedTitle");
        companion.bindUrlOnClick(linkifiedTextView5, embed.getUrl(), embed.getTitle());
        LinkifiedTextView linkifiedTextView6 = this.binding.f16197r;
        C12238m.checkNotNullExpressionValue(linkifiedTextView6, "binding.chatListItemEmbedTitle");
        linkifiedTextView6.setVisibility(0);
    }

    private final void configureFooter(EmbedFooter footer, UtcDateTime timestamp) {
        CharSequence text = null;
        String text2 = footer != null ? footer.getText() : null;
        if (text2 == null || text2.length() == 0) {
            SimpleDraweeView simpleDraweeView = this.binding.f16190k;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatListItemEmbedFooterIcon");
            simpleDraweeView.setVisibility(8);
        } else {
            SimpleDraweeView simpleDraweeView2 = this.binding.f16190k;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatListItemEmbedFooterIcon");
            simpleDraweeView2.setVisibility((footer != null ? footer.getProxyIconUrl() : null) != null ? 0 : 8);
            SimpleDraweeView simpleDraweeView3 = this.binding.f16190k;
            C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.chatListItemEmbedFooterIcon");
            int i = this.embedTinyIconSize;
            configureEmbedImage$default(this, simpleDraweeView3, i, i, i, footer != null ? footer.getProxyIconUrl() : null, 0, 32, null);
        }
        CharSequence readableTimeString$default = timestamp != null ? TimeUtils.toReadableTimeString$default(C1643a.m821I(this.binding.f16191l, "binding.chatListItemEmbedFooterText", "binding.chatListItemEmbedFooterText.context"), timestamp.getDateTimeMillis(), null, 4, null) : null;
        TextView textView = this.binding.f16191l;
        if (footer != null && readableTimeString$default != null) {
            text = footer.getText() + " | " + readableTimeString$default;
        } else if (footer != null) {
            text = footer.getText();
        } else if (readableTimeString$default != null) {
            text = readableTimeString$default;
        }
        textView.setText(text);
        CharSequence text3 = textView.getText();
        C12238m.checkNotNullExpressionValue(text3, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        textView.setVisibility(text3.length() > 0 ? 0 : 8);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0061  */
    private final void configureInlineEmbed(final MessageEmbed embed, boolean autoPlayGifs) {
        RenderableEmbedMedia previewImage;
        boolean z2;
        if (!shouldRenderMedia()) {
            InlineMediaView inlineMediaView = this.binding.f16199t;
            C12238m.checkNotNullExpressionValue(inlineMediaView, "binding.embedInlineMedia");
            inlineMediaView.setVisibility(8);
            return;
        }
        EmbedVideo video = embed.getVideo();
        if (video != null) {
            C12238m.checkNotNullParameter(video, "$this$asRenderableEmbedMedia");
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
                InlineMediaView inlineMediaView2 = this.binding.f16199t;
                C12238m.checkNotNullExpressionValue(inlineMediaView2, "binding.embedInlineMedia");
                Resources resources = inlineMediaView2.getResources();
                C12238m.checkNotNullExpressionValue(resources, "binding.embedInlineMedia.resources");
                Pair pairCalculateScaledSize = embedResourceUtils.calculateScaledSize(iIntValue, iIntValue2, i, i2, resources, (32 & 32) != 0 ? 0 : 0);
                int iIntValue3 = ((Number) pairCalculateScaledSize.component1()).intValue();
                int iIntValue4 = ((Number) pairCalculateScaledSize.component2()).intValue();
                InlineMediaView inlineMediaView3 = this.binding.f16199t;
                C12238m.checkNotNullExpressionValue(inlineMediaView3, "binding.embedInlineMedia");
                inlineMediaView3.setVisibility(0);
                this.binding.f16199t.updateUIWithEmbed(embed, Integer.valueOf(iIntValue3), Integer.valueOf(iIntValue4), autoPlayGifs);
            } else {
                InlineMediaView inlineMediaView4 = this.binding.f16199t;
                C12238m.checkNotNullExpressionValue(inlineMediaView4, "binding.embedInlineMedia");
                inlineMediaView4.setVisibility(8);
            }
        } else {
            InlineMediaView inlineMediaView5 = this.binding.f16199t;
            C12238m.checkNotNullExpressionValue(inlineMediaView5, "binding.embedInlineMedia");
            inlineMediaView5.setVisibility(8);
        }
        final InlineMediaView inlineMediaView6 = this.binding.f16199t;
        inlineMediaView6.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$configureInlineEmbed$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetMedia.Companion companion = WidgetMedia.INSTANCE;
                InlineMediaView inlineMediaView7 = inlineMediaView6;
                C12238m.checkNotNullExpressionValue(inlineMediaView7, "this");
                Context context = inlineMediaView7.getContext();
                C12238m.checkNotNullExpressionValue(context, "this.context");
                companion.launch(context, embed);
            }
        });
    }

    private final void configureUI(final Model model) {
        final EmbedEntry embedEntry = model.getEmbedEntry();
        MessageEmbed embed = embedEntry.getEmbed();
        MessageRenderContext messageRenderContextCreateRenderContext = model.createRenderContext(C1643a.m885x(this.itemView, "itemView", "itemView.context"), ((WidgetChatListAdapter) this.adapter).getEventHandler());
        if (model.getIsSpoilerHidden()) {
            ViewExtensions.fadeIn$default(this.binding.f16196q, 50L, null, C80531.INSTANCE, null, 10, null);
        } else {
            ViewExtensions.fadeOut$default(this.binding.f16196q, 200L, C80542.INSTANCE, null, 4, null);
        }
        this.binding.f16196q.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (WidgetChatListAdapterItemEmbed.access$getAdapter$p(WidgetChatListAdapterItemEmbed.this).getData().getIsSpoilerClickAllowed()) {
                    StoreStream.INSTANCE.getMessageState().revealSpoilerEmbed(model.getEmbedEntry().getMessage().getId(), embedEntry.getEmbedIndex());
                } else {
                    WidgetChatListAdapterItemEmbed.access$getAdapter$p(WidgetChatListAdapterItemEmbed.this).getEventHandler().onMessageClicked(model.getEmbedEntry().getMessage(), embedEntry.isThreadStarterMessage());
                }
            }
        });
        try {
            if (EmbedResourceUtils.INSTANCE.isInlineEmbed(embed)) {
                ConstraintLayout constraintLayout = this.binding.f16186g;
                C12238m.checkNotNullExpressionValue(constraintLayout, "binding.chatListItemEmbedContent");
                constraintLayout.setVisibility(8);
                View view = this.binding.f16188i;
                C12238m.checkNotNullExpressionValue(view, "binding.chatListItemEmbedDivider");
                view.setVisibility(8);
                SimpleDraweeView simpleDraweeView = this.binding.f16194o;
                C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatListItemEmbedImageThumbnail");
                simpleDraweeView.setVisibility(8);
                InlineMediaView inlineMediaView = this.binding.f16199t;
                C12238m.checkNotNullExpressionValue(inlineMediaView, "binding.embedInlineMedia");
                inlineMediaView.setVisibility(0);
                configureInlineEmbed(embed, embedEntry.getAutoPlayGifs());
                MaterialCardView materialCardView = this.binding.f16185f;
                View view2 = this.itemView;
                C12238m.checkNotNullExpressionValue(view2, "itemView");
                materialCardView.setCardBackgroundColor(ColorCompat.getColor(view2, C5419R.color.transparent));
                MaterialCardView materialCardView2 = this.binding.f16185f;
                C12238m.checkNotNullExpressionValue(materialCardView2, "binding.chatListItemEmbedContainerCard");
                materialCardView2.setStrokeWidth(0);
            } else {
                ConstraintLayout constraintLayout2 = this.binding.f16186g;
                C12238m.checkNotNullExpressionValue(constraintLayout2, "binding.chatListItemEmbedContent");
                constraintLayout2.setVisibility(0);
                View view3 = this.binding.f16188i;
                C12238m.checkNotNullExpressionValue(view3, "binding.chatListItemEmbedDivider");
                view3.setVisibility(0);
                InlineMediaView inlineMediaView2 = this.binding.f16199t;
                C12238m.checkNotNullExpressionValue(inlineMediaView2, "binding.embedInlineMedia");
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
                MaterialCardView materialCardView3 = this.binding.f16185f;
                View view4 = this.itemView;
                C12238m.checkNotNullExpressionValue(view4, "itemView");
                materialCardView3.setCardBackgroundColor(ColorCompat.getThemedColor(view4, C5419R.attr.colorBackgroundSecondary));
                MaterialCardView materialCardView4 = this.binding.f16185f;
                C12238m.checkNotNullExpressionValue(materialCardView4, "binding.chatListItemEmbedContainerCard");
                MaterialCardView materialCardView5 = this.binding.f16185f;
                C12238m.checkNotNullExpressionValue(materialCardView5, "binding.chatListItemEmbedContainerCard");
                materialCardView4.setStrokeWidth(materialCardView5.getResources().getDimensionPixelSize(C5419R.dimen.chat_embed_card_stroke_width));
            }
            View view5 = this.itemView;
            C12238m.checkNotNullExpressionValue(view5, "itemView");
            view5.setVisibility(0);
        } catch (Exception e) {
            View view6 = this.itemView;
            C12238m.checkNotNullExpressionValue(view6, "itemView");
            view6.setVisibility(8);
            Logger.e$default(AppLog.f14950g, "Unable to render embed.", e, null, 4, null);
        }
    }

    private final List<Model.ParsedField> parseFields(List<EmbedField> fields, Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> nameParser, Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> valueParser) {
        if (fields == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(fields, 10));
        for (EmbedField embedField : fields) {
            String name = embedField.getName();
            MessageParseState.Companion companion = MessageParseState.INSTANCE;
            arrayList.add(new Model.ParsedField(Parser.parse$default(nameParser, name, companion.getInitialState(), null, 4, null), Parser.parse$default(valueParser, embedField.getValue(), companion.getInitialState(), null, 4, null)));
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

    @Override // com.discord.widgets.chat.list.FragmentLifecycleListener
    public void onPause() {
        this.binding.f16199t.onPause();
    }

    @Override // com.discord.widgets.chat.list.FragmentLifecycleListener
    public void onResume() {
        this.binding.f16199t.onResume();
    }

    public static /* synthetic */ void configureEmbedImage$default(WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed, ImageView imageView, int i, int i2, int i3, String str, int i4, int i5, Object obj) {
        widgetChatListAdapterItemEmbed.configureEmbedImage(imageView, i, i2, i3, str, (i5 & 32) != 0 ? 0 : i4);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, final ChatListEntry data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        EmbedEntry embedEntry = (EmbedEntry) data;
        View view = this.itemView;
        C12238m.checkNotNullExpressionValue(view, "itemView");
        ViewExtensions.setOnLongClickListenerConsumeClick(view, new C80561(data));
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed.onConfigure.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetChatListAdapterItemEmbed.access$getAdapter$p(WidgetChatListAdapterItemEmbed.this).getEventHandler().onMessageClicked(((EmbedEntry) data).getMessage(), ((EmbedEntry) data).isThreadStarterMessage());
            }
        });
        Message message = embedEntry.getMessage();
        View view2 = this.binding.f16182c;
        C12238m.checkNotNullExpressionValue(view2, "binding.chatListAdapterItemHighlightedBg");
        View view3 = this.binding.f16181b;
        C12238m.checkNotNullExpressionValue(view3, "binding.chatListAdapterItemGutterBg");
        configureCellHighlight(message, view2, view3);
        String description = embedEntry.getEmbed().getDescription();
        Model model = new Model(embedEntry, description != null ? Parser.parse$default(UI_THREAD_VALUES_PARSER, description, MessageParseState.INSTANCE.getInitialState(), null, 4, null) : null, parseFields(embedEntry.getEmbed().m8101d(), UI_THREAD_TITLES_PARSER, UI_THREAD_VALUES_PARSER), null, null, null, 0L, 120, null);
        configureUI(model);
        Observable observableM11100Z = INSTANCE.getModel(model).m11100Z(1);
        C12238m.checkNotNullExpressionValue(observableM11100Z, "getModel(initialModel)\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(observableM11100Z), (Class<?>) WidgetChatListAdapterItemEmbed.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C80583()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C80594());
    }

    /* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
    public static final /* data */ class Model {
        private final Map<Long, String> channelNames;
        private final EmbedEntry embedEntry;
        private final boolean isEmbedUrlFoundInVisibleSpoilerNode;
        private final boolean isSpoilerHidden;
        private final long myId;
        private final Collection<Node<MessageRenderContext>> parsedDescription;
        private final List<ParsedField> parsedFields;
        private final Map<Long, GuildRole> roles;
        private final List<SpoilerNode<?>> spoilers;
        private final Map<Long, String> userNames;

        /* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
        public static final /* data */ class ParsedField {
            private final Collection<Node<MessageRenderContext>> parsedName;
            private final Collection<Node<MessageRenderContext>> parsedValue;

            /* JADX WARN: Multi-variable type inference failed */
            public ParsedField(Collection<? extends Node<MessageRenderContext>> collection, Collection<? extends Node<MessageRenderContext>> collection2) {
                C12238m.checkNotNullParameter(collection, "parsedName");
                C12238m.checkNotNullParameter(collection2, "parsedValue");
                this.parsedName = collection;
                this.parsedValue = collection2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ParsedField copy$default(ParsedField parsedField, Collection collection, Collection collection2, int i, Object obj) {
                if ((i & 1) != 0) {
                    collection = parsedField.parsedName;
                }
                if ((i & 2) != 0) {
                    collection2 = parsedField.parsedValue;
                }
                return parsedField.copy(collection, collection2);
            }

            public final Collection<Node<MessageRenderContext>> component1() {
                return this.parsedName;
            }

            public final Collection<Node<MessageRenderContext>> component2() {
                return this.parsedValue;
            }

            public final ParsedField copy(Collection<? extends Node<MessageRenderContext>> parsedName, Collection<? extends Node<MessageRenderContext>> parsedValue) {
                C12238m.checkNotNullParameter(parsedName, "parsedName");
                C12238m.checkNotNullParameter(parsedValue, "parsedValue");
                return new ParsedField(parsedName, parsedValue);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ParsedField)) {
                    return false;
                }
                ParsedField parsedField = (ParsedField) other;
                return C12238m.areEqual(this.parsedName, parsedField.parsedName) && C12238m.areEqual(this.parsedValue, parsedField.parsedValue);
            }

            public final Collection<Node<MessageRenderContext>> getParsedName() {
                return this.parsedName;
            }

            public final Collection<Node<MessageRenderContext>> getParsedValue() {
                return this.parsedValue;
            }

            public int hashCode() {
                Collection<Node<MessageRenderContext>> collection = this.parsedName;
                int iHashCode = (collection != null ? collection.hashCode() : 0) * 31;
                Collection<Node<MessageRenderContext>> collection2 = this.parsedValue;
                return iHashCode + (collection2 != null ? collection2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("ParsedField(parsedName=");
                sbM833U.append(this.parsedName);
                sbM833U.append(", parsedValue=");
                sbM833U.append(this.parsedValue);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX WARN: Code duplicated, block: B:23:0x009c  */
        /* JADX WARN: Multi-variable type inference failed */
        public Model(EmbedEntry embedEntry, Collection<? extends Node<MessageRenderContext>> collection, List<ParsedField> list, Map<Long, String> map, Map<Long, String> map2, Map<Long, GuildRole> map3, long j) {
            boolean z2;
            boolean z3;
            Set<Integer> visibleSpoilerNodeIndices;
            C12238m.checkNotNullParameter(embedEntry, "embedEntry");
            this.embedEntry = embedEntry;
            this.parsedDescription = collection;
            this.parsedFields = list;
            this.channelNames = map;
            this.userNames = map2;
            this.roles = map3;
            this.myId = j;
            Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parserCreateTitlesParser = WidgetChatListAdapterItemEmbed.INSTANCE.createTitlesParser();
            String content = embedEntry.getMessage().getContent();
            List list2 = Parser.parse$default(parserCreateTitlesParser, content == null ? "" : content, MessageParseState.INSTANCE.getInitialState(), null, 4, null);
            MessagePreprocessor messagePreprocessor = new MessagePreprocessor(j, embedEntry.getMessageState());
            messagePreprocessor.process(list2);
            List<SpoilerNode<?>> spoilers = messagePreprocessor.getSpoilers();
            this.spoilers = spoilers;
            if (spoilers == null) {
                z2 = false;
            } else {
                StoreMessageState.State messageState = embedEntry.getMessageState();
                if (messageState == null || (visibleSpoilerNodeIndices = messageState.getVisibleSpoilerNodeIndices()) == null) {
                    z3 = false;
                } else {
                    ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(visibleSpoilerNodeIndices, 10));
                    Iterator<T> it = visibleSpoilerNodeIndices.iterator();
                    while (it.hasNext()) {
                        arrayList.add(this.spoilers.get(((Number) it.next()).intValue()));
                    }
                    final String url = embedEntry.getEmbed().getUrl();
                    try {
                        C1460d.m530i2(arrayList, new InterfaceC1307a() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$Model$isEmbedUrlFoundInVisibleSpoilerNode$1$2$1
                            @Override // p007b.p008a.p050t.p052b.p055c.InterfaceC1307a
                            public final void processNode(Node<Object> node) {
                                if ((node instanceof UrlNode) && C12103t.equals(((UrlNode) node).getUrl(), url, true)) {
                                    throw new RuntimeException() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$Model$isEmbedUrlFoundInVisibleSpoilerNode$1$2$MatchFoundException
                                    };
                                }
                            }
                        });
                        z3 = false;
                    } catch (C8047x934ab9d4 unused) {
                        z3 = true;
                    }
                }
                if (z3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            this.isEmbedUrlFoundInVisibleSpoilerNode = z2;
            this.isSpoilerHidden = !isSpoilerEmbedRevealed(this.embedEntry) && isSpoilerEmbed();
        }

        private final boolean isSpoilerEmbed() {
            boolean z2;
            List<SpoilerNode<?>> list = this.spoilers;
            if (list != null) {
                if (!list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z2 = false;
                            break;
                        }
                        if (C12106w.contains$default((CharSequence) ((SpoilerNode) it.next()).getContent(), (CharSequence) "http", false, 2, (Object) null)) {
                            z2 = true;
                            break;
                        }
                    }
                } else {
                    z2 = false;
                    break;
                }
                if (z2 && !this.isEmbedUrlFoundInVisibleSpoilerNode) {
                    return true;
                }
            }
            return false;
        }

        private final boolean isSpoilerEmbedRevealed(EmbedEntry embedEntry) {
            Map<Integer, Set<String>> visibleSpoilerEmbedMap;
            StoreMessageState.State messageState = embedEntry.getMessageState();
            return (messageState == null || (visibleSpoilerEmbedMap = messageState.getVisibleSpoilerEmbedMap()) == null || !visibleSpoilerEmbedMap.containsKey(Integer.valueOf(embedEntry.getEmbedIndex()))) ? false : true;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final EmbedEntry getEmbedEntry() {
            return this.embedEntry;
        }

        public final Collection<Node<MessageRenderContext>> component2() {
            return this.parsedDescription;
        }

        public final List<ParsedField> component3() {
            return this.parsedFields;
        }

        public final Map<Long, String> component4() {
            return this.channelNames;
        }

        public final Map<Long, String> component5() {
            return this.userNames;
        }

        public final Map<Long, GuildRole> component6() {
            return this.roles;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final long getMyId() {
            return this.myId;
        }

        public final Model copy(EmbedEntry embedEntry, Collection<? extends Node<MessageRenderContext>> parsedDescription, List<ParsedField> parsedFields, Map<Long, String> channelNames, Map<Long, String> userNames, Map<Long, GuildRole> roles, long myId) {
            C12238m.checkNotNullParameter(embedEntry, "embedEntry");
            return new Model(embedEntry, parsedDescription, parsedFields, channelNames, userNames, roles, myId);
        }

        public final MessageRenderContext createRenderContext(Context androidContext, WidgetChatListAdapter.EventHandler eventHandler) {
            C12238m.checkNotNullParameter(androidContext, "androidContext");
            C12238m.checkNotNullParameter(eventHandler, "eventHandler");
            return new MessageRenderContext(androidContext, this.myId, this.embedEntry.getAllowAnimatedEmojis(), this.userNames, this.channelNames, this.roles, 0, null, new WidgetChatListAdapterItemEmbed$Model$createRenderContext$1(eventHandler), 0, 0, null, null, null, 16064, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return C12238m.areEqual(this.embedEntry, model.embedEntry) && C12238m.areEqual(this.parsedDescription, model.parsedDescription) && C12238m.areEqual(this.parsedFields, model.parsedFields) && C12238m.areEqual(this.channelNames, model.channelNames) && C12238m.areEqual(this.userNames, model.userNames) && C12238m.areEqual(this.roles, model.roles) && this.myId == model.myId;
        }

        public final Map<Long, String> getChannelNames() {
            return this.channelNames;
        }

        public final EmbedEntry getEmbedEntry() {
            return this.embedEntry;
        }

        public final long getMyId() {
            return this.myId;
        }

        public final Collection<Node<MessageRenderContext>> getParsedDescription() {
            return this.parsedDescription;
        }

        public final List<ParsedField> getParsedFields() {
            return this.parsedFields;
        }

        public final Map<Long, GuildRole> getRoles() {
            return this.roles;
        }

        public final Map<Long, String> getUserNames() {
            return this.userNames;
        }

        public int hashCode() {
            EmbedEntry embedEntry = this.embedEntry;
            int iHashCode = (embedEntry != null ? embedEntry.hashCode() : 0) * 31;
            Collection<Node<MessageRenderContext>> collection = this.parsedDescription;
            int iHashCode2 = (iHashCode + (collection != null ? collection.hashCode() : 0)) * 31;
            List<ParsedField> list = this.parsedFields;
            int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
            Map<Long, String> map = this.channelNames;
            int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, String> map2 = this.userNames;
            int iHashCode5 = (iHashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, GuildRole> map3 = this.roles;
            return C0002b.m3a(this.myId) + ((iHashCode5 + (map3 != null ? map3.hashCode() : 0)) * 31);
        }

        /* JADX INFO: renamed from: isSpoilerHidden, reason: from getter */
        public final boolean getIsSpoilerHidden() {
            return this.isSpoilerHidden;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(embedEntry=");
            sbM833U.append(this.embedEntry);
            sbM833U.append(", parsedDescription=");
            sbM833U.append(this.parsedDescription);
            sbM833U.append(", parsedFields=");
            sbM833U.append(this.parsedFields);
            sbM833U.append(", channelNames=");
            sbM833U.append(this.channelNames);
            sbM833U.append(", userNames=");
            sbM833U.append(this.userNames);
            sbM833U.append(", roles=");
            sbM833U.append(this.roles);
            sbM833U.append(", myId=");
            return C1643a.m815C(sbM833U, this.myId, ")");
        }

        public /* synthetic */ Model(EmbedEntry embedEntry, Collection collection, List list, Map map, Map map2, Map map3, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(embedEntry, collection, list, (i & 8) != 0 ? null : map, (i & 16) != 0 ? null : map2, (i & 32) != 0 ? null : map3, (i & 64) != 0 ? 0L : j);
        }
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
        InlineMediaView inlineMediaView = this.binding.f16199t;
        C12238m.checkNotNullExpressionValue(inlineMediaView, "binding.embedInlineMedia");
        Resources resources = inlineMediaView.getResources();
        C12238m.checkNotNullExpressionValue(resources, "binding.embedInlineMedia.resources");
        Pair<Integer, Integer> pairCalculateScaledSize = embedResourceUtils.calculateScaledSize(width, height, maxWidth, maxWidth, resources, minWidth);
        int iIntValue = pairCalculateScaledSize.component1().intValue();
        int iIntValue2 = pairCalculateScaledSize.component2().intValue();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams.width != iIntValue || layoutParams.height != iIntValue2) {
            layoutParams.width = iIntValue;
            layoutParams.height = iIntValue2;
            view.requestLayout();
        }
        MGImages.setImage$default(view, EmbedResourceUtils.getPreviewUrls$default(embedResourceUtils, imageProxyUrl, iIntValue, iIntValue2, false, 8, null), 0, 0, false, null, null, null, 252, null);
    }
}

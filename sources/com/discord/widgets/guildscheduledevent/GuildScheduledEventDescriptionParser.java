package com.discord.widgets.guildscheduledevent;

import b.d.b.a.outline;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.TagsBuilder;
import com.discord.utilities.textprocessing.TagsBuilder2;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.view.text.LinkifiedTextView;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.functions.Func3;

/* JADX INFO: compiled from: GuildScheduledEventDescriptionParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDescriptionParser {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(GuildScheduledEventDescriptionParser2.INSTANCE);
    private DescriptionCache savedDescriptionCache;
    private final WeakReference<LinkifiedTextView> weakRefTextView;

    /* JADX INFO: compiled from: GuildScheduledEventDescriptionParser.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> getINSTANCE() {
            Lazy lazy = GuildScheduledEventDescriptionParser.INSTANCE$delegate;
            Companion companion = GuildScheduledEventDescriptionParser.INSTANCE;
            return (Parser) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GuildScheduledEventDescriptionParser.kt */
    public static abstract class DescriptionCache {
        private final List<Node<MessageRenderContext>> maybeAst;
        private final String maybeDescription;

        /* JADX INFO: compiled from: GuildScheduledEventDescriptionParser.kt */
        public static final /* data */ class HasDescription extends DescriptionCache {
            private final List<Node<MessageRenderContext>> ast;
            private final String description;
            private final Set<Integer> shownSpoilerIndices;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HasDescription(String str, List<Node<MessageRenderContext>> list, Set<Integer> set) {
                super(str, list, null);
                Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
                Intrinsics3.checkNotNullParameter(list, "ast");
                Intrinsics3.checkNotNullParameter(set, "shownSpoilerIndices");
                this.description = str;
                this.ast = list;
                this.shownSpoilerIndices = set;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ HasDescription copy$default(HasDescription hasDescription, String str, List list, Set set, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = hasDescription.description;
                }
                if ((i & 2) != 0) {
                    list = hasDescription.ast;
                }
                if ((i & 4) != 0) {
                    set = hasDescription.shownSpoilerIndices;
                }
                return hasDescription.copy(str, list, set);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getDescription() {
                return this.description;
            }

            public final List<Node<MessageRenderContext>> component2() {
                return this.ast;
            }

            public final Set<Integer> component3() {
                return this.shownSpoilerIndices;
            }

            public final HasDescription copy(String description, List<Node<MessageRenderContext>> ast, Set<Integer> shownSpoilerIndices) {
                Intrinsics3.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
                Intrinsics3.checkNotNullParameter(ast, "ast");
                Intrinsics3.checkNotNullParameter(shownSpoilerIndices, "shownSpoilerIndices");
                return new HasDescription(description, ast, shownSpoilerIndices);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HasDescription)) {
                    return false;
                }
                HasDescription hasDescription = (HasDescription) other;
                return Intrinsics3.areEqual(this.description, hasDescription.description) && Intrinsics3.areEqual(this.ast, hasDescription.ast) && Intrinsics3.areEqual(this.shownSpoilerIndices, hasDescription.shownSpoilerIndices);
            }

            public final List<Node<MessageRenderContext>> getAst() {
                return this.ast;
            }

            public final String getDescription() {
                return this.description;
            }

            public final Set<Integer> getShownSpoilerIndices() {
                return this.shownSpoilerIndices;
            }

            public int hashCode() {
                String str = this.description;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                List<Node<MessageRenderContext>> list = this.ast;
                int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
                Set<Integer> set = this.shownSpoilerIndices;
                return iHashCode2 + (set != null ? set.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("HasDescription(description=");
                sbU.append(this.description);
                sbU.append(", ast=");
                sbU.append(this.ast);
                sbU.append(", shownSpoilerIndices=");
                return outline.N(sbU, this.shownSpoilerIndices, ")");
            }
        }

        /* JADX INFO: compiled from: GuildScheduledEventDescriptionParser.kt */
        public static final class NoDescription extends DescriptionCache {
            public static final NoDescription INSTANCE = new NoDescription();

            /* JADX WARN: Multi-variable type inference failed */
            private NoDescription() {
                super(null, 0 == true ? 1 : 0, 0 == true ? 1 : 0);
            }
        }

        private DescriptionCache(String str, List<Node<MessageRenderContext>> list) {
            this.maybeDescription = str;
            this.maybeAst = list;
        }

        public final List<Node<MessageRenderContext>> getMaybeAst() {
            return this.maybeAst;
        }

        public final String getMaybeDescription() {
            return this.maybeDescription;
        }

        public /* synthetic */ DescriptionCache(String str, List list, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, list);
        }
    }

    /* JADX INFO: compiled from: GuildScheduledEventDescriptionParser.kt */
    public static final /* data */ class MessageRenderContextModel {
        private final Map<Long, String> channelNames;
        private final Map<Long, GuildRole> roles;
        private final Map<Long, String> userNames;

        public MessageRenderContextModel() {
            this(null, null, null, 7, null);
        }

        public MessageRenderContextModel(Map<Long, String> map, Map<Long, String> map2, Map<Long, GuildRole> map3) {
            this.channelNames = map;
            this.userNames = map2;
            this.roles = map3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MessageRenderContextModel copy$default(MessageRenderContextModel messageRenderContextModel, Map map, Map map2, Map map3, int i, Object obj) {
            if ((i & 1) != 0) {
                map = messageRenderContextModel.channelNames;
            }
            if ((i & 2) != 0) {
                map2 = messageRenderContextModel.userNames;
            }
            if ((i & 4) != 0) {
                map3 = messageRenderContextModel.roles;
            }
            return messageRenderContextModel.copy(map, map2, map3);
        }

        public final Map<Long, String> component1() {
            return this.channelNames;
        }

        public final Map<Long, String> component2() {
            return this.userNames;
        }

        public final Map<Long, GuildRole> component3() {
            return this.roles;
        }

        public final MessageRenderContextModel copy(Map<Long, String> channelNames, Map<Long, String> userNames, Map<Long, GuildRole> roles) {
            return new MessageRenderContextModel(channelNames, userNames, roles);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MessageRenderContextModel)) {
                return false;
            }
            MessageRenderContextModel messageRenderContextModel = (MessageRenderContextModel) other;
            return Intrinsics3.areEqual(this.channelNames, messageRenderContextModel.channelNames) && Intrinsics3.areEqual(this.userNames, messageRenderContextModel.userNames) && Intrinsics3.areEqual(this.roles, messageRenderContextModel.roles);
        }

        public final Map<Long, String> getChannelNames() {
            return this.channelNames;
        }

        public final Map<Long, GuildRole> getRoles() {
            return this.roles;
        }

        public final Map<Long, String> getUserNames() {
            return this.userNames;
        }

        public int hashCode() {
            Map<Long, String> map = this.channelNames;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            Map<Long, String> map2 = this.userNames;
            int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, GuildRole> map3 = this.roles;
            return iHashCode2 + (map3 != null ? map3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("MessageRenderContextModel(channelNames=");
            sbU.append(this.channelNames);
            sbU.append(", userNames=");
            sbU.append(this.userNames);
            sbU.append(", roles=");
            return outline.M(sbU, this.roles, ")");
        }

        public /* synthetic */ MessageRenderContextModel(Map map, Map map2, Map map3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : map2, (i & 4) != 0 ? null : map3);
        }
    }

    public GuildScheduledEventDescriptionParser(LinkifiedTextView linkifiedTextView) {
        Intrinsics3.checkNotNullParameter(linkifiedTextView, "textView");
        this.weakRefTextView = new WeakReference<>(linkifiedTextView);
        this.savedDescriptionCache = DescriptionCache.NoDescription.INSTANCE;
    }

    private final Observable<MessageRenderContextModel> getRenderContext(long guildId) {
        TagsBuilder2 tagsBuilder2Build = new TagsBuilder().build();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<MessageRenderContextModel> observableI = Observable.i(companion.getChannels().observeNames(), Observable.j(companion.getGuilds().observeComputed(guildId), companion.getUsers().observeUsernames(tagsBuilder2Build.getUsers()), new Func2<Map<Long, ? extends GuildMember>, Map<Long, ? extends String>, HashMap<Long, String>>() { // from class: com.discord.widgets.guildscheduledevent.GuildScheduledEventDescriptionParser.getRenderContext.1
            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ HashMap<Long, String> call(Map<Long, ? extends GuildMember> map, Map<Long, ? extends String> map2) {
                return call2((Map<Long, GuildMember>) map, (Map<Long, String>) map2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final HashMap<Long, String> call2(Map<Long, GuildMember> map, Map<Long, String> map2) {
                Intrinsics3.checkNotNullExpressionValue(map, "members");
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
                    Intrinsics3.checkNotNull(nick);
                    map3.put(key, nick);
                }
                return map3;
            }
        }), companion.getGuilds().observeRoles(guildId), new Func3<Map<Long, ? extends String>, HashMap<Long, String>, Map<Long, ? extends GuildRole>, MessageRenderContextModel>() { // from class: com.discord.widgets.guildscheduledevent.GuildScheduledEventDescriptionParser.getRenderContext.2
            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ MessageRenderContextModel call(Map<Long, ? extends String> map, HashMap<Long, String> map2, Map<Long, ? extends GuildRole> map3) {
                return call2((Map<Long, String>) map, map2, (Map<Long, GuildRole>) map3);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final MessageRenderContextModel call2(Map<Long, String> map, HashMap<Long, String> map2, Map<Long, GuildRole> map3) {
                return new MessageRenderContextModel(map, map2, map3);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…      roles\n      )\n    }");
        return observableI;
    }

    private final void handleSpoilerClicked(SpoilerNode<?> spoilerNode, long guildId) {
        DescriptionCache descriptionCache = this.savedDescriptionCache;
        if (!(descriptionCache instanceof DescriptionCache.HasDescription)) {
            descriptionCache = null;
        }
        DescriptionCache.HasDescription hasDescription = (DescriptionCache.HasDescription) descriptionCache;
        if (hasDescription != null) {
            hasDescription.getShownSpoilerIndices().add(Integer.valueOf(spoilerNode.getId()));
            updateAstForSpoiler(hasDescription.getAst(), hasDescription.getShownSpoilerIndices());
            configureDescription(hasDescription.getDescription(), guildId);
        }
    }

    private final List<Node<MessageRenderContext>> parseAndSaveDescription(String description) {
        if (Intrinsics3.areEqual(this.savedDescriptionCache.getMaybeDescription(), description)) {
            return this.savedDescriptionCache.getMaybeAst();
        }
        if (description == null) {
            DescriptionCache.NoDescription noDescription = DescriptionCache.NoDescription.INSTANCE;
            this.savedDescriptionCache = noDescription;
            return noDescription.getMaybeAst();
        }
        DescriptionCache.HasDescription hasDescription = new DescriptionCache.HasDescription(description, Parser.parse$default(INSTANCE.getINSTANCE(), description, MessageParseState.INSTANCE.getInitialState(), null, 4, null), new LinkedHashSet());
        this.savedDescriptionCache = hasDescription;
        return hasDescription.getMaybeAst();
    }

    private final void updateAstForSpoiler(List<Node<MessageRenderContext>> ast, Set<Integer> visibleSpoilerNodeIndices) {
        new MessagePreprocessor(-1L, visibleSpoilerNodeIndices, null, false, null, 28, null).process(ast);
    }

    public final void configureDescription(String description, long guildId) {
        List<Node<MessageRenderContext>> andSaveDescription = parseAndSaveDescription(description);
        LinkifiedTextView linkifiedTextView = this.weakRefTextView.get();
        if (linkifiedTextView != null) {
            if (andSaveDescription == null || !(!andSaveDescription.isEmpty())) {
                linkifiedTextView.setVisibility(8);
                return;
            }
            linkifiedTextView.setVisibility(0);
            Observable<MessageRenderContextModel> observableZ = getRenderContext(guildId).z();
            Intrinsics3.checkNotNullExpressionValue(observableZ, "getRenderContext(guildId)\n            .first()");
            ObservableExtensionsKt.appSubscribe(observableZ, (Class<?>) LinkifiedTextView.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new GuildScheduledEventDescriptionParser3(linkifiedTextView, this, andSaveDescription, guildId));
        }
    }
}

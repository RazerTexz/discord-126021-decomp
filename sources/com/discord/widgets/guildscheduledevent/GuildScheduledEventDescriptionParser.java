package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.Tags;
import com.discord.utilities.textprocessing.TagsBuilder;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.view.text.LinkifiedTextView;
import d0.g;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: GuildScheduledEventDescriptionParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDescriptionParser {
    public static final GuildScheduledEventDescriptionParser$Companion Companion = new GuildScheduledEventDescriptionParser$Companion(null);
    private static final Lazy INSTANCE$delegate = g.lazy(GuildScheduledEventDescriptionParser$Companion$INSTANCE$2.INSTANCE);
    private GuildScheduledEventDescriptionParser$DescriptionCache savedDescriptionCache;
    private final WeakReference<LinkifiedTextView> weakRefTextView;

    public GuildScheduledEventDescriptionParser(LinkifiedTextView linkifiedTextView) {
        m.checkNotNullParameter(linkifiedTextView, "textView");
        this.weakRefTextView = new WeakReference<>(linkifiedTextView);
        this.savedDescriptionCache = GuildScheduledEventDescriptionParser$DescriptionCache$NoDescription.INSTANCE;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public static final /* synthetic */ void access$handleSpoilerClicked(GuildScheduledEventDescriptionParser guildScheduledEventDescriptionParser, SpoilerNode spoilerNode, long j) {
        guildScheduledEventDescriptionParser.handleSpoilerClicked(spoilerNode, j);
    }

    private final Observable<GuildScheduledEventDescriptionParser$MessageRenderContextModel> getRenderContext(long guildId) {
        Tags tagsBuild = new TagsBuilder().build();
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<GuildScheduledEventDescriptionParser$MessageRenderContextModel> observableI = Observable.i(storeStream$Companion.getChannels().observeNames(), Observable.j(storeStream$Companion.getGuilds().observeComputed(guildId), storeStream$Companion.getUsers().observeUsernames(tagsBuild.getUsers()), GuildScheduledEventDescriptionParser$getRenderContext$1.INSTANCE), storeStream$Companion.getGuilds().observeRoles(guildId), GuildScheduledEventDescriptionParser$getRenderContext$2.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…      roles\n      )\n    }");
        return observableI;
    }

    private final void handleSpoilerClicked(SpoilerNode<?> spoilerNode, long guildId) {
        GuildScheduledEventDescriptionParser$DescriptionCache guildScheduledEventDescriptionParser$DescriptionCache = this.savedDescriptionCache;
        if (!(guildScheduledEventDescriptionParser$DescriptionCache instanceof GuildScheduledEventDescriptionParser$DescriptionCache$HasDescription)) {
            guildScheduledEventDescriptionParser$DescriptionCache = null;
        }
        GuildScheduledEventDescriptionParser$DescriptionCache$HasDescription guildScheduledEventDescriptionParser$DescriptionCache$HasDescription = (GuildScheduledEventDescriptionParser$DescriptionCache$HasDescription) guildScheduledEventDescriptionParser$DescriptionCache;
        if (guildScheduledEventDescriptionParser$DescriptionCache$HasDescription != null) {
            guildScheduledEventDescriptionParser$DescriptionCache$HasDescription.getShownSpoilerIndices().add(Integer.valueOf(spoilerNode.getId()));
            updateAstForSpoiler(guildScheduledEventDescriptionParser$DescriptionCache$HasDescription.getAst(), guildScheduledEventDescriptionParser$DescriptionCache$HasDescription.getShownSpoilerIndices());
            configureDescription(guildScheduledEventDescriptionParser$DescriptionCache$HasDescription.getDescription(), guildId);
        }
    }

    private final List<Node<MessageRenderContext>> parseAndSaveDescription(String description) {
        if (m.areEqual(this.savedDescriptionCache.getMaybeDescription(), description)) {
            return this.savedDescriptionCache.getMaybeAst();
        }
        if (description == null) {
            GuildScheduledEventDescriptionParser$DescriptionCache$NoDescription guildScheduledEventDescriptionParser$DescriptionCache$NoDescription = GuildScheduledEventDescriptionParser$DescriptionCache$NoDescription.INSTANCE;
            this.savedDescriptionCache = guildScheduledEventDescriptionParser$DescriptionCache$NoDescription;
            return guildScheduledEventDescriptionParser$DescriptionCache$NoDescription.getMaybeAst();
        }
        GuildScheduledEventDescriptionParser$DescriptionCache$HasDescription guildScheduledEventDescriptionParser$DescriptionCache$HasDescription = new GuildScheduledEventDescriptionParser$DescriptionCache$HasDescription(description, Parser.parse$default(GuildScheduledEventDescriptionParser$Companion.access$getINSTANCE$p(Companion), description, MessageParseState.Companion.getInitialState(), null, 4, null), new LinkedHashSet());
        this.savedDescriptionCache = guildScheduledEventDescriptionParser$DescriptionCache$HasDescription;
        return guildScheduledEventDescriptionParser$DescriptionCache$HasDescription.getMaybeAst();
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
            Observable<GuildScheduledEventDescriptionParser$MessageRenderContextModel> observableZ = getRenderContext(guildId).z();
            m.checkNotNullExpressionValue(observableZ, "getRenderContext(guildId)\n            .first()");
            ObservableExtensionsKt.appSubscribe$default(observableZ, LinkifiedTextView.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildScheduledEventDescriptionParser$configureDescription$$inlined$apply$lambda$1(linkifiedTextView, this, andSaveDescription, guildId), 62, (Object) null);
        }
    }
}

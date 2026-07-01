package com.discord.widgets.chat.list.adapter;

import android.view.View;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.Tags;
import com.discord.utilities.textprocessing.TagsBuilder;
import com.discord.widgets.chat.list.entries.EmbedEntry;
import d0.g0.s;
import d0.g0.t;
import d0.g0.y;
import d0.z.d.m;
import j0.l.a.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed$Companion {
    private WidgetChatListAdapterItemEmbed$Companion() {
    }

    public static final /* synthetic */ void access$bindUrlOnClick(WidgetChatListAdapterItemEmbed$Companion widgetChatListAdapterItemEmbed$Companion, View view, String str, String str2) {
        widgetChatListAdapterItemEmbed$Companion.bindUrlOnClick(view, str, str2);
    }

    public static final /* synthetic */ List access$getEmbedFieldVisibleIndices(WidgetChatListAdapterItemEmbed$Companion widgetChatListAdapterItemEmbed$Companion, Map map, int i, String str) {
        return widgetChatListAdapterItemEmbed$Companion.getEmbedFieldVisibleIndices(map, i, str);
    }

    public static final /* synthetic */ Observable access$getModel(WidgetChatListAdapterItemEmbed$Companion widgetChatListAdapterItemEmbed$Companion, WidgetChatListAdapterItemEmbed$Model widgetChatListAdapterItemEmbed$Model) {
        return widgetChatListAdapterItemEmbed$Companion.getModel(widgetChatListAdapterItemEmbed$Model);
    }

    private final void bindUrlOnClick(View view, String str, String str2) {
        if (str != null) {
            view.setOnClickListener(new WidgetChatListAdapterItemEmbed$Companion$bindUrlOnClick$1(str, str2));
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
                if (t.startsWith$default((String) obj, str, false, 2, null)) {
                    arrayList2.add(obj);
                }
            }
            arrayList = new ArrayList();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Integer intOrNull = s.toIntOrNull(y.drop((String) it.next(), str.length() + 1));
                if (intOrNull != null) {
                    arrayList.add(intOrNull);
                }
            }
        }
        return arrayList;
    }

    private final Observable<WidgetChatListAdapterItemEmbed$Model> getModel(WidgetChatListAdapterItemEmbed$Model initialModel) {
        EmbedEntry embedEntry = initialModel.getEmbedEntry();
        Collection<Node<MessageRenderContext>> parsedDescription = initialModel.getParsedDescription();
        List<WidgetChatListAdapterItemEmbed$Model$ParsedField> parsedFields = initialModel.getParsedFields();
        TagsBuilder tagsBuilder = new TagsBuilder();
        if (parsedDescription != null) {
            tagsBuilder.processAst(parsedDescription);
        }
        if (parsedFields != null) {
            for (WidgetChatListAdapterItemEmbed$Model$ParsedField widgetChatListAdapterItemEmbed$Model$ParsedField : parsedFields) {
                tagsBuilder.processAst(widgetChatListAdapterItemEmbed$Model$ParsedField.getParsedName());
                tagsBuilder.processAst(widgetChatListAdapterItemEmbed$Model$ParsedField.getParsedValue());
            }
        }
        Tags tagsBuild = tagsBuilder.build();
        if (tagsBuild.getIsEmpty()) {
            Observable observable = d.k;
            m.checkNotNullExpressionValue(observable, "Observable.never()");
            return observable;
        }
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableH = Observable.h(storeStream$Companion.getUsers().observeMeId(), storeStream$Companion.getChannels().observeNames(tagsBuild.getChannels()), Observable.j(storeStream$Companion.getGuilds().observeComputed(embedEntry.getGuildId(), tagsBuild.getUsers()), storeStream$Companion.getUsers().observeUsernames(tagsBuild.getUsers()), WidgetChatListAdapterItemEmbed$Companion$getModel$1.INSTANCE), storeStream$Companion.getGuilds().observeRoles(embedEntry.getGuildId(), tagsBuild.getRoles()), new WidgetChatListAdapterItemEmbed$Companion$getModel$2(embedEntry, parsedDescription, parsedFields));
        m.checkNotNullExpressionValue(observableH, "Observable\n          .co… roles, myId)\n          }");
        Observable<WidgetChatListAdapterItemEmbed$Model> observableR = ObservableExtensionsKt.computationLatest(observableH).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
        return observableR;
    }

    public final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> createTitlesParser() {
        return DiscordParser.createParser$default(false, false, false, false, false, 28, null);
    }

    public final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> getUI_THREAD_TITLES_PARSER() {
        return WidgetChatListAdapterItemEmbed.access$getUI_THREAD_TITLES_PARSER$cp();
    }

    public final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> getUI_THREAD_VALUES_PARSER() {
        return WidgetChatListAdapterItemEmbed.access$getUI_THREAD_VALUES_PARSER$cp();
    }

    public /* synthetic */ WidgetChatListAdapterItemEmbed$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

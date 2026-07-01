package com.discord.widgets.chat.input.autocomplete;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import rx.functions.Func4;

/* JADX INFO: compiled from: InputAutocompletables.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputAutocompletables$observeChannelAutocompletables$1$1<T1, T2, T3, T4, R> implements Func4<Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>>> {
    public static final ChatInputAutocompletables$observeChannelAutocompletables$1$1 INSTANCE = new ChatInputAutocompletables$observeChannelAutocompletables$1$1();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> call(Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map2, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map3, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map4) {
        return call2(map, map2, map3, map4);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<LeadingIdentifier, Set<Autocompletable>> call2(Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map2, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map3, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        m.checkNotNullExpressionValue(map, "commands");
        InputAutocompletablesKt.access$merge(linkedHashMap, map);
        m.checkNotNullExpressionValue(map2, "emojis");
        InputAutocompletablesKt.access$merge(linkedHashMap, map2);
        m.checkNotNullExpressionValue(map3, "channels");
        InputAutocompletablesKt.access$merge(linkedHashMap, map3);
        m.checkNotNullExpressionValue(map4, "users");
        InputAutocompletablesKt.access$merge(linkedHashMap, map4);
        return linkedHashMap;
    }
}

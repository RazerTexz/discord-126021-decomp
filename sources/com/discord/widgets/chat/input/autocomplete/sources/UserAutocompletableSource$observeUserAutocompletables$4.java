package com.discord.widgets.chat.input.autocomplete.sources;

import androidx.core.app.NotificationCompat;
import java.util.List;
import rx.functions.Func2;

/* JADX INFO: compiled from: UserMentionableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAutocompletableSource$observeUserAutocompletables$4<T1, T2, R> implements Func2<List<Long>, Long, List<Long>> {
    public static final UserAutocompletableSource$observeUserAutocompletables$4 INSTANCE = new UserAutocompletableSource$observeUserAutocompletables$4();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ List<Long> call(List<Long> list, Long l) {
        return call2(list, l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<Long> call2(List<Long> list, Long l) {
        list.add(l);
        return list;
    }
}

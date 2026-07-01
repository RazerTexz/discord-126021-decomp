package com.discord.widgets.guilds;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.stores.StoreGuildsSorted$Entry;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildFolderSettingsViewModel$Companion$observeStoreState$1<T1, T2, R> implements Func2<List<? extends ModelGuildFolder>, List<? extends StoreGuildsSorted$Entry>, WidgetGuildFolderSettingsViewModel$StoreState> {
    public final /* synthetic */ long $folderId;

    public WidgetGuildFolderSettingsViewModel$Companion$observeStoreState$1(long j) {
        this.$folderId = j;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetGuildFolderSettingsViewModel$StoreState call(List<? extends ModelGuildFolder> list, List<? extends StoreGuildsSorted$Entry> list2) {
        return call2((List<ModelGuildFolder>) list, list2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGuildFolderSettingsViewModel$StoreState call2(List<ModelGuildFolder> list, List<? extends StoreGuildsSorted$Entry> list2) {
        Object next;
        Long id2;
        m.checkNotNullExpressionValue(list, "guildFolders");
        Iterator<T> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            id2 = ((ModelGuildFolder) next).getId();
        } while (!(id2 != null && id2.longValue() == this.$folderId));
        ModelGuildFolder modelGuildFolder = (ModelGuildFolder) next;
        if (modelGuildFolder == null) {
            return WidgetGuildFolderSettingsViewModel$StoreState$Invalid.INSTANCE;
        }
        m.checkNotNullExpressionValue(list2, "sortedGuilds");
        return new WidgetGuildFolderSettingsViewModel$StoreState$Valid(modelGuildFolder, list2);
    }
}

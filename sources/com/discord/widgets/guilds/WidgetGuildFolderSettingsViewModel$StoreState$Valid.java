package com.discord.widgets.guilds;

import b.d.b.a.a;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.stores.StoreGuildsSorted$Entry;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildFolderSettingsViewModel$StoreState$Valid extends WidgetGuildFolderSettingsViewModel$StoreState {
    private final ModelGuildFolder folder;
    private final List<StoreGuildsSorted$Entry> sortedGuilds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetGuildFolderSettingsViewModel$StoreState$Valid(ModelGuildFolder modelGuildFolder, List<? extends StoreGuildsSorted$Entry> list) {
        super(null);
        m.checkNotNullParameter(modelGuildFolder, "folder");
        m.checkNotNullParameter(list, "sortedGuilds");
        this.folder = modelGuildFolder;
        this.sortedGuilds = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGuildFolderSettingsViewModel$StoreState$Valid copy$default(WidgetGuildFolderSettingsViewModel$StoreState$Valid widgetGuildFolderSettingsViewModel$StoreState$Valid, ModelGuildFolder modelGuildFolder, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            modelGuildFolder = widgetGuildFolderSettingsViewModel$StoreState$Valid.folder;
        }
        if ((i & 2) != 0) {
            list = widgetGuildFolderSettingsViewModel$StoreState$Valid.sortedGuilds;
        }
        return widgetGuildFolderSettingsViewModel$StoreState$Valid.copy(modelGuildFolder, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelGuildFolder getFolder() {
        return this.folder;
    }

    public final List<StoreGuildsSorted$Entry> component2() {
        return this.sortedGuilds;
    }

    public final WidgetGuildFolderSettingsViewModel$StoreState$Valid copy(ModelGuildFolder folder, List<? extends StoreGuildsSorted$Entry> sortedGuilds) {
        m.checkNotNullParameter(folder, "folder");
        m.checkNotNullParameter(sortedGuilds, "sortedGuilds");
        return new WidgetGuildFolderSettingsViewModel$StoreState$Valid(folder, sortedGuilds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildFolderSettingsViewModel$StoreState$Valid)) {
            return false;
        }
        WidgetGuildFolderSettingsViewModel$StoreState$Valid widgetGuildFolderSettingsViewModel$StoreState$Valid = (WidgetGuildFolderSettingsViewModel$StoreState$Valid) other;
        return m.areEqual(this.folder, widgetGuildFolderSettingsViewModel$StoreState$Valid.folder) && m.areEqual(this.sortedGuilds, widgetGuildFolderSettingsViewModel$StoreState$Valid.sortedGuilds);
    }

    public final ModelGuildFolder getFolder() {
        return this.folder;
    }

    public final List<StoreGuildsSorted$Entry> getSortedGuilds() {
        return this.sortedGuilds;
    }

    public int hashCode() {
        ModelGuildFolder modelGuildFolder = this.folder;
        int iHashCode = (modelGuildFolder != null ? modelGuildFolder.hashCode() : 0) * 31;
        List<StoreGuildsSorted$Entry> list = this.sortedGuilds;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(folder=");
        sbU.append(this.folder);
        sbU.append(", sortedGuilds=");
        return a.L(sbU, this.sortedGuilds, ")");
    }
}

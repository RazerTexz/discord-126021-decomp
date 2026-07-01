package com.discord.widgets.guilds.contextmenu;

import b.d.b.a.a;
import com.discord.models.domain.ModelGuildFolder;
import d0.z.d.m;
import java.util.Set;

/* JADX INFO: compiled from: FolderContextMenuViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FolderContextMenuViewModel$StoreState$Valid extends FolderContextMenuViewModel$StoreState {
    private final ModelGuildFolder folder;
    private final Set<Long> unreadGuildIds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FolderContextMenuViewModel$StoreState$Valid(ModelGuildFolder modelGuildFolder, Set<Long> set) {
        super(null);
        m.checkNotNullParameter(modelGuildFolder, "folder");
        m.checkNotNullParameter(set, "unreadGuildIds");
        this.folder = modelGuildFolder;
        this.unreadGuildIds = set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FolderContextMenuViewModel$StoreState$Valid copy$default(FolderContextMenuViewModel$StoreState$Valid folderContextMenuViewModel$StoreState$Valid, ModelGuildFolder modelGuildFolder, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            modelGuildFolder = folderContextMenuViewModel$StoreState$Valid.folder;
        }
        if ((i & 2) != 0) {
            set = folderContextMenuViewModel$StoreState$Valid.unreadGuildIds;
        }
        return folderContextMenuViewModel$StoreState$Valid.copy(modelGuildFolder, set);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelGuildFolder getFolder() {
        return this.folder;
    }

    public final Set<Long> component2() {
        return this.unreadGuildIds;
    }

    public final FolderContextMenuViewModel$StoreState$Valid copy(ModelGuildFolder folder, Set<Long> unreadGuildIds) {
        m.checkNotNullParameter(folder, "folder");
        m.checkNotNullParameter(unreadGuildIds, "unreadGuildIds");
        return new FolderContextMenuViewModel$StoreState$Valid(folder, unreadGuildIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FolderContextMenuViewModel$StoreState$Valid)) {
            return false;
        }
        FolderContextMenuViewModel$StoreState$Valid folderContextMenuViewModel$StoreState$Valid = (FolderContextMenuViewModel$StoreState$Valid) other;
        return m.areEqual(this.folder, folderContextMenuViewModel$StoreState$Valid.folder) && m.areEqual(this.unreadGuildIds, folderContextMenuViewModel$StoreState$Valid.unreadGuildIds);
    }

    public final ModelGuildFolder getFolder() {
        return this.folder;
    }

    public final Set<Long> getUnreadGuildIds() {
        return this.unreadGuildIds;
    }

    public int hashCode() {
        ModelGuildFolder modelGuildFolder = this.folder;
        int iHashCode = (modelGuildFolder != null ? modelGuildFolder.hashCode() : 0) * 31;
        Set<Long> set = this.unreadGuildIds;
        return iHashCode + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(folder=");
        sbU.append(this.folder);
        sbU.append(", unreadGuildIds=");
        return a.N(sbU, this.unreadGuildIds, ")");
    }
}

package com.discord.widgets.guilds.contextmenu;

import b.d.b.a.a;
import com.discord.models.domain.ModelGuildFolder;
import d0.z.d.m;

/* JADX INFO: compiled from: FolderContextMenuViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FolderContextMenuViewModel$ViewState$Valid extends FolderContextMenuViewModel$ViewState {
    private final ModelGuildFolder folder;
    private final boolean showMarkAsRead;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FolderContextMenuViewModel$ViewState$Valid(ModelGuildFolder modelGuildFolder, boolean z2) {
        super(null);
        m.checkNotNullParameter(modelGuildFolder, "folder");
        this.folder = modelGuildFolder;
        this.showMarkAsRead = z2;
    }

    public static /* synthetic */ FolderContextMenuViewModel$ViewState$Valid copy$default(FolderContextMenuViewModel$ViewState$Valid folderContextMenuViewModel$ViewState$Valid, ModelGuildFolder modelGuildFolder, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            modelGuildFolder = folderContextMenuViewModel$ViewState$Valid.folder;
        }
        if ((i & 2) != 0) {
            z2 = folderContextMenuViewModel$ViewState$Valid.showMarkAsRead;
        }
        return folderContextMenuViewModel$ViewState$Valid.copy(modelGuildFolder, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelGuildFolder getFolder() {
        return this.folder;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShowMarkAsRead() {
        return this.showMarkAsRead;
    }

    public final FolderContextMenuViewModel$ViewState$Valid copy(ModelGuildFolder folder, boolean showMarkAsRead) {
        m.checkNotNullParameter(folder, "folder");
        return new FolderContextMenuViewModel$ViewState$Valid(folder, showMarkAsRead);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FolderContextMenuViewModel$ViewState$Valid)) {
            return false;
        }
        FolderContextMenuViewModel$ViewState$Valid folderContextMenuViewModel$ViewState$Valid = (FolderContextMenuViewModel$ViewState$Valid) other;
        return m.areEqual(this.folder, folderContextMenuViewModel$ViewState$Valid.folder) && this.showMarkAsRead == folderContextMenuViewModel$ViewState$Valid.showMarkAsRead;
    }

    public final ModelGuildFolder getFolder() {
        return this.folder;
    }

    public final boolean getShowMarkAsRead() {
        return this.showMarkAsRead;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        ModelGuildFolder modelGuildFolder = this.folder;
        int iHashCode = (modelGuildFolder != null ? modelGuildFolder.hashCode() : 0) * 31;
        boolean z2 = this.showMarkAsRead;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(folder=");
        sbU.append(this.folder);
        sbU.append(", showMarkAsRead=");
        return a.O(sbU, this.showMarkAsRead, ")");
    }
}

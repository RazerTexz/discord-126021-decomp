package com.discord.models.sticker.dto;

import b.d.b.a.outline;
import com.discord.models.store.dto.ModelStoreDirectoryLayout;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: ModelStickerStoreDirectory.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelStickerStoreDirectory {
    private final List<ModelStickerPack> stickerPacks;
    private final ModelStoreDirectoryLayout storeDirectoryLayout;

    public ModelStickerStoreDirectory(List<ModelStickerPack> list, ModelStoreDirectoryLayout modelStoreDirectoryLayout) {
        Intrinsics3.checkNotNullParameter(list, "stickerPacks");
        this.stickerPacks = list;
        this.storeDirectoryLayout = modelStoreDirectoryLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelStickerStoreDirectory copy$default(ModelStickerStoreDirectory modelStickerStoreDirectory, List list, ModelStoreDirectoryLayout modelStoreDirectoryLayout, int i, Object obj) {
        if ((i & 1) != 0) {
            list = modelStickerStoreDirectory.stickerPacks;
        }
        if ((i & 2) != 0) {
            modelStoreDirectoryLayout = modelStickerStoreDirectory.storeDirectoryLayout;
        }
        return modelStickerStoreDirectory.copy(list, modelStoreDirectoryLayout);
    }

    public final List<ModelStickerPack> component1() {
        return this.stickerPacks;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ModelStoreDirectoryLayout getStoreDirectoryLayout() {
        return this.storeDirectoryLayout;
    }

    public final ModelStickerStoreDirectory copy(List<ModelStickerPack> stickerPacks, ModelStoreDirectoryLayout storeDirectoryLayout) {
        Intrinsics3.checkNotNullParameter(stickerPacks, "stickerPacks");
        return new ModelStickerStoreDirectory(stickerPacks, storeDirectoryLayout);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelStickerStoreDirectory)) {
            return false;
        }
        ModelStickerStoreDirectory modelStickerStoreDirectory = (ModelStickerStoreDirectory) other;
        return Intrinsics3.areEqual(this.stickerPacks, modelStickerStoreDirectory.stickerPacks) && Intrinsics3.areEqual(this.storeDirectoryLayout, modelStickerStoreDirectory.storeDirectoryLayout);
    }

    public final List<ModelStickerPack> getStickerPacks() {
        return this.stickerPacks;
    }

    public final ModelStoreDirectoryLayout getStoreDirectoryLayout() {
        return this.storeDirectoryLayout;
    }

    public int hashCode() {
        List<ModelStickerPack> list = this.stickerPacks;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        ModelStoreDirectoryLayout modelStoreDirectoryLayout = this.storeDirectoryLayout;
        return iHashCode + (modelStoreDirectoryLayout != null ? modelStoreDirectoryLayout.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelStickerStoreDirectory(stickerPacks=");
        sbU.append(this.stickerPacks);
        sbU.append(", storeDirectoryLayout=");
        sbU.append(this.storeDirectoryLayout);
        sbU.append(")");
        return sbU.toString();
    }
}

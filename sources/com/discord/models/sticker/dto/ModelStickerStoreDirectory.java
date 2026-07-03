package com.discord.models.sticker.dto;

import com.discord.models.store.dto.ModelStoreDirectoryLayout;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ModelStickerStoreDirectory.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelStickerStoreDirectory {
    private final List<ModelStickerPack> stickerPacks;
    private final ModelStoreDirectoryLayout storeDirectoryLayout;

    public ModelStickerStoreDirectory(List<ModelStickerPack> list, ModelStoreDirectoryLayout modelStoreDirectoryLayout) {
        C12238m.checkNotNullParameter(list, "stickerPacks");
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
        C12238m.checkNotNullParameter(stickerPacks, "stickerPacks");
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
        return C12238m.areEqual(this.stickerPacks, modelStickerStoreDirectory.stickerPacks) && C12238m.areEqual(this.storeDirectoryLayout, modelStickerStoreDirectory.storeDirectoryLayout);
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
        StringBuilder sbM833U = C1643a.m833U("ModelStickerStoreDirectory(stickerPacks=");
        sbM833U.append(this.stickerPacks);
        sbM833U.append(", storeDirectoryLayout=");
        sbM833U.append(this.storeDirectoryLayout);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}

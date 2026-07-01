package com.discord.models.gifpicker.dto;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: GifCategoryDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GifCategoryDto {
    private final String name;
    private final String src;

    public GifCategoryDto(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "src");
        this.name = str;
        this.src = str2;
    }

    public static /* synthetic */ GifCategoryDto copy$default(GifCategoryDto gifCategoryDto, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gifCategoryDto.name;
        }
        if ((i & 2) != 0) {
            str2 = gifCategoryDto.src;
        }
        return gifCategoryDto.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSrc() {
        return this.src;
    }

    public final GifCategoryDto copy(String name, String src) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(src, "src");
        return new GifCategoryDto(name, src);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GifCategoryDto)) {
            return false;
        }
        GifCategoryDto gifCategoryDto = (GifCategoryDto) other;
        return Intrinsics3.areEqual(this.name, gifCategoryDto.name) && Intrinsics3.areEqual(this.src, gifCategoryDto.src);
    }

    public final String getName() {
        return this.name;
    }

    public final String getSrc() {
        return this.src;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.src;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GifCategoryDto(name=");
        sbU.append(this.name);
        sbU.append(", src=");
        return outline.J(sbU, this.src, ")");
    }
}

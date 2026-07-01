package com.discord.models.gifpicker.dto;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: GifCategoryDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GifCategoryDto {
    private final String name;
    private final String src;

    public GifCategoryDto(String str, String str2) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(str2, "src");
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
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(src, "src");
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
        return m.areEqual(this.name, gifCategoryDto.name) && m.areEqual(this.src, gifCategoryDto.src);
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
        StringBuilder sbU = a.U("GifCategoryDto(name=");
        sbU.append(this.name);
        sbU.append(", src=");
        return a.J(sbU, this.src, ")");
    }
}

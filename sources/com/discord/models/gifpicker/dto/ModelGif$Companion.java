package com.discord.models.gifpicker.dto;

import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModelGif.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelGif$Companion {
    private ModelGif$Companion() {
    }

    public final ModelGif createFromGifDto(GifDto gifDto) {
        m.checkNotNullParameter(gifDto, "gifDto");
        return new ModelGif(gifDto.getSrc(), gifDto.getUrl(), gifDto.getWidth(), gifDto.getHeight());
    }

    public /* synthetic */ ModelGif$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

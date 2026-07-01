package com.discord.widgets.nux;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildTemplatesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GuildTemplateViewType {
    public static final GuildTemplateViewType$Companion Companion = new GuildTemplateViewType$Companion(null);
    private static final int TEMPLATE = 1;
    private static final int TEXT = 0;
    private final int viewType;

    private GuildTemplateViewType(int i) {
        this.viewType = i;
    }

    public static final /* synthetic */ int access$getTEMPLATE$cp() {
        return TEMPLATE;
    }

    public static final /* synthetic */ int access$getTEXT$cp() {
        return TEXT;
    }

    public final int getViewType() {
        return this.viewType;
    }

    public /* synthetic */ GuildTemplateViewType(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}

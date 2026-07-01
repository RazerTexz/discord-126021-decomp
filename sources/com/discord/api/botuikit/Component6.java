package com.discord.api.botuikit;


/* JADX INFO: renamed from: com.discord.api.botuikit.ComponentType, reason: use source file name */
/* JADX INFO: compiled from: Component.kt */
/* JADX INFO: loaded from: classes.dex */
public enum Component6 {
    UNKNOWN(0, Component9.class),
    ACTION_ROW(1, ActionRowComponent.class),
    BUTTON(2, ButtonComponent.class),
    SELECT(3, SelectComponent.class),
    TEXT(4, TextComponent.class);

    private final Class<? extends Component> clazz;
    private final int type;

    Component6(int i, Class cls) {
        this.type = i;
        this.clazz = cls;
    }

    public final Class<? extends Component> getClazz() {
        return this.clazz;
    }

    public final int getType() {
        return this.type;
    }
}

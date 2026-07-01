package com.discord.api.botuikit;


/* JADX INFO: compiled from: Component.kt */
/* JADX INFO: loaded from: classes.dex */
public enum ComponentType {
    UNKNOWN(0, UnknownComponent.class),
    ACTION_ROW(1, ActionRowComponent.class),
    BUTTON(2, ButtonComponent.class),
    SELECT(3, SelectComponent.class),
    TEXT(4, TextComponent.class);

    private final Class<? extends Component> clazz;
    private final int type;

    ComponentType(int i, Class cls) {
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

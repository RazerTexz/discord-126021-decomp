package com.discord.utilities.directories;


/* JADX INFO: compiled from: DirectoryUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum DirectoryUtils$DirectoryServerMenuOptions {
    Edit(2131891808, 2131231726),
    Remove(2131891806, 2131231708),
    Report(2131894778, 2131231796);

    private final int iconRes;
    private final int titleRes;

    DirectoryUtils$DirectoryServerMenuOptions(int i, int i2) {
        this.titleRes = i;
        this.iconRes = i2;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }
}

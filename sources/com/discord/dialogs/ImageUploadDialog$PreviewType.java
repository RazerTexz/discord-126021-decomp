package com.discord.dialogs;

import com.discord.widgets.chat.AutocompleteSelectionTypes;

/* JADX INFO: compiled from: ImageUploadDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public enum ImageUploadDialog$PreviewType {
    EMOJI(2131165401),
    USER_AVATAR(2131165290),
    GUILD_AVATAR(2131165302),
    GUILD_SUBSCRIPTION_ROLE_AVATAR(2131165292);

    private final int previewSizeDimenId;

    ImageUploadDialog$PreviewType(int i) {
        this.previewSizeDimenId = i;
    }

    public final int getPreviewSizeDimenId() {
        return this.previewSizeDimenId;
    }
}

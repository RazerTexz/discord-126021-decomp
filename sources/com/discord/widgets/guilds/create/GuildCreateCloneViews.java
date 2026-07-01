package com.discord.widgets.guilds.create;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: GuildCreateCloneViews.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface GuildCreateCloneViews {
    public static final GuildCreateCloneViews$Companion Companion = GuildCreateCloneViews$Companion.$$INSTANCE;

    TextView getGuidelinesTextView();

    LoadingButton getGuildCreateButton();

    ViewGroup getGuildCreateIconUploader();

    TextInputLayout getGuildCreateName();

    SimpleDraweeView getIconUploaderImage();

    Group getIconUploaderPlaceholderGroup();

    ScreenTitleView getScreenTitleView();
}

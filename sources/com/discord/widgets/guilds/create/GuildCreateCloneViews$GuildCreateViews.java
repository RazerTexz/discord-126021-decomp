package com.discord.widgets.guilds.create;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import b.a.i.r0;
import com.discord.databinding.WidgetGuildCreateBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildCreateCloneViews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildCreateCloneViews$GuildCreateViews implements GuildCreateCloneViews {
    private final TextView guidelinesTextView;
    private final LoadingButton guildCreateButton;
    private final ViewGroup guildCreateIconUploader;
    private final TextInputLayout guildCreateName;
    private final SimpleDraweeView iconUploaderImage;
    private final Group iconUploaderPlaceholderGroup;
    private final ScreenTitleView screenTitleView;

    public GuildCreateCloneViews$GuildCreateViews(WidgetGuildCreateBinding widgetGuildCreateBinding) {
        m.checkNotNullParameter(widgetGuildCreateBinding, "binding");
        LoadingButton loadingButton = widgetGuildCreateBinding.f2412b;
        m.checkNotNullExpressionValue(loadingButton, "binding.guildCreateButton");
        this.guildCreateButton = loadingButton;
        TextInputLayout textInputLayout = widgetGuildCreateBinding.e;
        m.checkNotNullExpressionValue(textInputLayout, "binding.guildCreateName");
        this.guildCreateName = textInputLayout;
        SimpleDraweeView simpleDraweeView = widgetGuildCreateBinding.d.f190b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildCreateIconUploader.iconUploaderImage");
        this.iconUploaderImage = simpleDraweeView;
        Group group = widgetGuildCreateBinding.d.c;
        m.checkNotNullExpressionValue(group, "binding.guildCreateIconUploader.placeholderGroup");
        this.iconUploaderPlaceholderGroup = group;
        r0 r0Var = widgetGuildCreateBinding.d;
        m.checkNotNullExpressionValue(r0Var, "binding.guildCreateIconUploader");
        ConstraintLayout constraintLayout = r0Var.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.guildCreateIconUploader.root");
        this.guildCreateIconUploader = constraintLayout;
        LinkifiedTextView linkifiedTextView = widgetGuildCreateBinding.c;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.guildCreateGuidelines");
        this.guidelinesTextView = linkifiedTextView;
        ScreenTitleView screenTitleView = widgetGuildCreateBinding.f;
        m.checkNotNullExpressionValue(screenTitleView, "binding.guildCreateScreenTitle");
        this.screenTitleView = screenTitleView;
    }

    @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
    public TextView getGuidelinesTextView() {
        return this.guidelinesTextView;
    }

    @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
    public LoadingButton getGuildCreateButton() {
        return this.guildCreateButton;
    }

    @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
    public ViewGroup getGuildCreateIconUploader() {
        return this.guildCreateIconUploader;
    }

    @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
    public TextInputLayout getGuildCreateName() {
        return this.guildCreateName;
    }

    @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
    public SimpleDraweeView getIconUploaderImage() {
        return this.iconUploaderImage;
    }

    @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
    public Group getIconUploaderPlaceholderGroup() {
        return this.iconUploaderPlaceholderGroup;
    }

    @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
    public ScreenTitleView getScreenTitleView() {
        return this.screenTitleView;
    }
}

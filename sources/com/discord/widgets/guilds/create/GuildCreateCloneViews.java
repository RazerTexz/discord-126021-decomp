package com.discord.widgets.guilds.create;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.discord.databinding.WidgetGuildCloneBinding;
import com.discord.databinding.WidgetGuildCreateBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputLayout;
import p007b.p008a.p025i.C1038r0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildCreateCloneViews.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface GuildCreateCloneViews {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: GuildCreateCloneViews.kt */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final GuildCreateCloneViews from(WidgetGuildCreateBinding binding) {
            C12238m.checkNotNullParameter(binding, "binding");
            return new GuildCreateViews(binding);
        }

        public final GuildCreateCloneViews from(WidgetGuildCloneBinding binding) {
            C12238m.checkNotNullParameter(binding, "binding");
            return new GuildCloneViews(binding);
        }
    }

    /* JADX INFO: compiled from: GuildCreateCloneViews.kt */
    public static final class GuildCloneViews implements GuildCreateCloneViews {
        private final TextView guidelinesTextView;
        private final LoadingButton guildCreateButton;
        private final ViewGroup guildCreateIconUploader;
        private final TextInputLayout guildCreateName;
        private final SimpleDraweeView iconUploaderImage;
        private final Group iconUploaderPlaceholderGroup;
        private final ScreenTitleView screenTitleView;

        public GuildCloneViews(WidgetGuildCloneBinding widgetGuildCloneBinding) {
            C12238m.checkNotNullParameter(widgetGuildCloneBinding, "binding");
            LoadingButton loadingButton = widgetGuildCloneBinding.f16752b;
            C12238m.checkNotNullExpressionValue(loadingButton, "binding.guildCreateButton");
            this.guildCreateButton = loadingButton;
            TextInputLayout textInputLayout = widgetGuildCloneBinding.f16756f;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.guildCreateName");
            this.guildCreateName = textInputLayout;
            SimpleDraweeView simpleDraweeView = widgetGuildCloneBinding.f16755e.f1174b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildCreateIconUploader.iconUploaderImage");
            this.iconUploaderImage = simpleDraweeView;
            Group group = widgetGuildCloneBinding.f16755e.f1175c;
            C12238m.checkNotNullExpressionValue(group, "binding.guildCreateIconUploader.placeholderGroup");
            this.iconUploaderPlaceholderGroup = group;
            C1038r0 c1038r0 = widgetGuildCloneBinding.f16755e;
            C12238m.checkNotNullExpressionValue(c1038r0, "binding.guildCreateIconUploader");
            ConstraintLayout constraintLayout = c1038r0.f1173a;
            C12238m.checkNotNullExpressionValue(constraintLayout, "binding.guildCreateIconUploader.root");
            this.guildCreateIconUploader = constraintLayout;
            LinkifiedTextView linkifiedTextView = widgetGuildCloneBinding.f16754d;
            C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.guildCreateGuidelines");
            this.guidelinesTextView = linkifiedTextView;
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

    /* JADX INFO: compiled from: GuildCreateCloneViews.kt */
    public static final class GuildCreateViews implements GuildCreateCloneViews {
        private final TextView guidelinesTextView;
        private final LoadingButton guildCreateButton;
        private final ViewGroup guildCreateIconUploader;
        private final TextInputLayout guildCreateName;
        private final SimpleDraweeView iconUploaderImage;
        private final Group iconUploaderPlaceholderGroup;
        private final ScreenTitleView screenTitleView;

        public GuildCreateViews(WidgetGuildCreateBinding widgetGuildCreateBinding) {
            C12238m.checkNotNullParameter(widgetGuildCreateBinding, "binding");
            LoadingButton loadingButton = widgetGuildCreateBinding.f16769b;
            C12238m.checkNotNullExpressionValue(loadingButton, "binding.guildCreateButton");
            this.guildCreateButton = loadingButton;
            TextInputLayout textInputLayout = widgetGuildCreateBinding.f16772e;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.guildCreateName");
            this.guildCreateName = textInputLayout;
            SimpleDraweeView simpleDraweeView = widgetGuildCreateBinding.f16771d.f1174b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildCreateIconUploader.iconUploaderImage");
            this.iconUploaderImage = simpleDraweeView;
            Group group = widgetGuildCreateBinding.f16771d.f1175c;
            C12238m.checkNotNullExpressionValue(group, "binding.guildCreateIconUploader.placeholderGroup");
            this.iconUploaderPlaceholderGroup = group;
            C1038r0 c1038r0 = widgetGuildCreateBinding.f16771d;
            C12238m.checkNotNullExpressionValue(c1038r0, "binding.guildCreateIconUploader");
            ConstraintLayout constraintLayout = c1038r0.f1173a;
            C12238m.checkNotNullExpressionValue(constraintLayout, "binding.guildCreateIconUploader.root");
            this.guildCreateIconUploader = constraintLayout;
            LinkifiedTextView linkifiedTextView = widgetGuildCreateBinding.f16770c;
            C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.guildCreateGuidelines");
            this.guidelinesTextView = linkifiedTextView;
            ScreenTitleView screenTitleView = widgetGuildCreateBinding.f16773f;
            C12238m.checkNotNullExpressionValue(screenTitleView, "binding.guildCreateScreenTitle");
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

    TextView getGuidelinesTextView();

    LoadingButton getGuildCreateButton();

    ViewGroup getGuildCreateIconUploader();

    TextInputLayout getGuildCreateName();

    SimpleDraweeView getIconUploaderImage();

    Group getIconUploaderPlaceholderGroup();

    ScreenTitleView getScreenTitleView();
}

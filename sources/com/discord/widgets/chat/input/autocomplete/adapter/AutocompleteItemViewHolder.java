package com.discord.widgets.chat.input.autocomplete.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.api.user.User;
import com.discord.databinding.WidgetChatInputAutocompleteItemBinding;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.presence.Presence;
import com.discord.stores.StoreApplicationCommandsKt;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.chat.input.autocomplete.ApplicationCommandAutocompletable;
import com.discord.widgets.chat.input.autocomplete.ApplicationCommandChoiceAutocompletable;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.ChannelAutocompletable;
import com.discord.widgets.chat.input.autocomplete.EmojiAutocompletable;
import com.discord.widgets.chat.input.autocomplete.GlobalRoleAutocompletable;
import com.discord.widgets.chat.input.autocomplete.RoleAutocompletable;
import com.discord.widgets.chat.input.autocomplete.UserAutocompletable;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import java.util.Collections;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AutocompleteItemViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteItemViewHolder extends RecyclerView.ViewHolder {
    private final WidgetChatInputAutocompleteItemBinding binding;
    private final int defaultItemTextColor;
    private final Function1<Autocompletable, Unit> onItemSelected;

    /* JADX INFO: compiled from: AutocompleteItemViewHolder.kt */
    public final class EmojiAutocompleteRenderContext implements EmojiNode.RenderContext {
        private final Context context;
        private final boolean isAnimationEnabled;
        public final /* synthetic */ AutocompleteItemViewHolder this$0;

        public EmojiAutocompleteRenderContext(AutocompleteItemViewHolder autocompleteItemViewHolder, boolean z2, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            this.this$0 = autocompleteItemViewHolder;
            this.isAnimationEnabled = z2;
            this.context = context;
        }

        @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
        public Context getContext() {
            return this.context;
        }

        @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
        /* JADX INFO: renamed from: isAnimationEnabled, reason: from getter */
        public boolean getIsAnimationEnabled() {
            return this.isAnimationEnabled;
        }

        @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
        public void onEmojiClicked(EmojiNode.EmojiIdAndType emojiIdAndType) {
            Intrinsics3.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
            EmojiNode.RenderContext.DefaultImpls.onEmojiClicked(this, emojiIdAndType);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AutocompleteItemViewHolder(WidgetChatInputAutocompleteItemBinding widgetChatInputAutocompleteItemBinding, Function1<? super Autocompletable, Unit> function1) {
        super(widgetChatInputAutocompleteItemBinding.a);
        Intrinsics3.checkNotNullParameter(widgetChatInputAutocompleteItemBinding, "binding");
        Intrinsics3.checkNotNullParameter(function1, "onItemSelected");
        this.binding = widgetChatInputAutocompleteItemBinding;
        this.onItemSelected = function1;
        TextView textView = widgetChatInputAutocompleteItemBinding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        this.defaultItemTextColor = textView.getCurrentTextColor();
    }

    private final void bindChannel(ChannelAutocompletable channelAutocompletable) {
        int i;
        Channel channel = channelAutocompletable.getChannel();
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        textView.setText(channel.getName());
        if (ChannelUtils.J(channel)) {
            i = R.drawable.ic_channel_voice;
        } else if (ChannelUtils.H(channel)) {
            i = R.drawable.ic_thread;
        } else {
            i = ChannelUtils.v(channel) ? R.drawable.ic_channel_text : R.drawable.ic_guild_folder;
        }
        SimpleDraweeView simpleDraweeView = this.binding.f2302b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.chatInputItemAvatar");
        int color = ColorCompat.getColor(simpleDraweeView, R.color.primary_500);
        SimpleDraweeView simpleDraweeView2 = this.binding.f2302b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatInputItemAvatar");
        simpleDraweeView2.setVisibility(0);
        int iDpToPixels = DimenUtils.dpToPixels(6);
        this.binding.f2302b.setPadding(iDpToPixels, iDpToPixels, iDpToPixels, iDpToPixels);
        MGImages mGImages = MGImages.INSTANCE;
        SimpleDraweeView simpleDraweeView3 = this.binding.f2302b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.chatInputItemAvatar");
        MGImages.setImage$default(mGImages, simpleDraweeView3, i, (MGImages.ChangeDetector) null, 4, (Object) null);
        this.binding.f2302b.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }

    public final void bind(final Autocompletable autocompletable) {
        Intrinsics3.checkNotNullParameter(autocompletable, "autocompletable");
        clearBinding();
        if (autocompletable instanceof ApplicationCommandChoiceAutocompletable) {
            bindCommandChoice((ApplicationCommandChoiceAutocompletable) autocompletable);
        } else if (autocompletable instanceof ApplicationCommandAutocompletable) {
            bindCommand((ApplicationCommandAutocompletable) autocompletable);
        } else if (autocompletable instanceof ChannelAutocompletable) {
            bindChannel((ChannelAutocompletable) autocompletable);
        } else if (autocompletable instanceof EmojiAutocompletable) {
            bindEmoji((EmojiAutocompletable) autocompletable);
        } else if (autocompletable instanceof GlobalRoleAutocompletable) {
            bindGlobalRole((GlobalRoleAutocompletable) autocompletable);
        } else if (autocompletable instanceof RoleAutocompletable) {
            bindRole((RoleAutocompletable) autocompletable);
        } else {
            if (!(autocompletable instanceof UserAutocompletable)) {
                throw new IllegalStateException("Cannot bind autocompletable. Not configured");
            }
            bindUser((UserAutocompletable) autocompletable);
        }
        this.binding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.autocomplete.adapter.AutocompleteItemViewHolder.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AutocompleteItemViewHolder.this.onItemSelected.invoke(autocompletable);
            }
        });
    }

    public final void bindCommand(ApplicationCommandAutocompletable commandAutocompletable) {
        String name;
        Intrinsics3.checkNotNullParameter(commandAutocompletable, "commandAutocompletable");
        ApplicationCommand command = commandAutocompletable.getCommand();
        Application application = commandAutocompletable.getApplication();
        if (!commandAutocompletable.getHasPermissionToUse()) {
            ConstraintLayout constraintLayout = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            constraintLayout.setEnabled(false);
            ConstraintLayout constraintLayout2 = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.root");
            constraintLayout2.setAlpha(0.3f);
        }
        StringBuilder sbQ = outline.Q(MentionUtils.SLASH_CHAR);
        sbQ.append(command.getName());
        String string = sbQ.toString();
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        textView.setText(string);
        ConstraintLayout constraintLayout3 = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout3, "binding.root");
        Resources resources = constraintLayout3.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "binding.root.resources");
        String descriptionText = StoreApplicationCommandsKt.getDescriptionText(command, resources);
        if (descriptionText != null && (!StringsJVM.isBlank(descriptionText))) {
            TextView textView2 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatInputItemDescription");
            textView2.setVisibility(0);
            TextView textView3 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.chatInputItemDescription");
            textView3.setText(Strings4.trim(descriptionText).toString());
        }
        if (application != null) {
            TextView textView4 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.chatInputItemNameRight");
            textView4.setVisibility(0);
            User bot = application.getBot();
            if (bot == null || (name = bot.getUsername()) == null) {
                name = application.getName();
            }
            TextView textView5 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.chatInputItemNameRight");
            Locale locale = Locale.getDefault();
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.getDefault()");
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String upperCase = name.toUpperCase(locale);
            Intrinsics3.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            textView5.setText(upperCase);
            ConstraintLayout constraintLayout4 = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout4, "binding.root");
            TextView textView6 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView6, "binding.chatInputItemDescription");
            CharSequence charSequenceD = FormatUtils.d(constraintLayout4, R.string.command_accessibility_desc_command_item, new Object[]{command.getName(), textView6.getText(), application.getName()}, (4 & 4) != 0 ? FormatUtils.c.j : null);
            ConstraintLayout constraintLayout5 = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout5, "binding.root");
            constraintLayout5.setContentDescription(charSequenceD);
        }
        if (commandAutocompletable.getShowAvatar()) {
            SimpleDraweeView simpleDraweeView = this.binding.f2302b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.chatInputItemAvatar");
            simpleDraweeView.setVisibility(0);
            if (application != null) {
                SimpleDraweeView simpleDraweeView2 = this.binding.f2302b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatInputItemAvatar");
                IconUtils.setApplicationIcon(simpleDraweeView2, application);
                return;
            }
            ConstraintLayout constraintLayout6 = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout6, "binding.root");
            int themedColor = ColorCompat.getThemedColor(constraintLayout6, R.attr.colorTextMuted);
            MGImages mGImages = MGImages.INSTANCE;
            SimpleDraweeView simpleDraweeView3 = this.binding.f2302b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.chatInputItemAvatar");
            MGImages.setImage$default(mGImages, simpleDraweeView3, R.drawable.ic_slash_command_24dp, (MGImages.ChangeDetector) null, 4, (Object) null);
            this.binding.f2302b.setColorFilter(themedColor, PorterDuff.Mode.SRC_ATOP);
        }
    }

    public final void bindCommandChoice(ApplicationCommandChoiceAutocompletable commandChoiceAutocompletable) {
        Intrinsics3.checkNotNullParameter(commandChoiceAutocompletable, "commandChoiceAutocompletable");
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        textView.setText(commandChoiceAutocompletable.getChoice().getName());
    }

    public final void bindEmoji(EmojiAutocompletable emojiAutocompletable) {
        Intrinsics3.checkNotNullParameter(emojiAutocompletable, "emojiAutocompletable");
        Emoji emoji = emojiAutocompletable.getEmoji();
        String firstName = emoji.getFirstName();
        Intrinsics3.checkNotNullExpressionValue(firstName, "emoji.firstName");
        EmojiNode.EmojiIdAndType.Unicode unicode = new EmojiNode.EmojiIdAndType.Unicode(firstName);
        String firstName2 = emoji.getFirstName();
        Intrinsics3.checkNotNullExpressionValue(firstName2, "emoji.firstName");
        EmojiNode emojiNode = new EmojiNode(firstName2, new AutocompleteItemViewHolder2(emoji), unicode, 0, 0, 24, null);
        boolean animationsEnabled = emojiAutocompletable.getAnimationsEnabled();
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.chatInputItemEmoji");
        Context context = simpleDraweeSpanTextView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.chatInputItemEmoji.context");
        EmojiAutocompleteRenderContext emojiAutocompleteRenderContext = new EmojiAutocompleteRenderContext(this, animationsEnabled, context);
        Set setSingleton = Collections.singleton(emojiNode);
        Intrinsics3.checkNotNullExpressionValue(setSingleton, "Collections.singleton(emojiNode)");
        DraweeSpanStringBuilder draweeSpanStringBuilderRender = AstRenderer.render(setSingleton, emojiAutocompleteRenderContext);
        StringBuilder sbQ = outline.Q(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        sbQ.append(emoji.getFirstName());
        sbQ.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        String string = sbQ.toString();
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        textView.setText(string);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView2, "binding.chatInputItemEmoji");
        simpleDraweeSpanTextView2.setVisibility(0);
        this.binding.d.setDraweeSpanStringBuilder(draweeSpanStringBuilderRender);
    }

    public final void bindGlobalRole(GlobalRoleAutocompletable roleAutocompletable) {
        Intrinsics3.checkNotNullParameter(roleAutocompletable, "roleAutocompletable");
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        textView.setText(roleAutocompletable.getText());
        SimpleDraweeView simpleDraweeView = this.binding.f2302b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.chatInputItemAvatar");
        simpleDraweeView.setVisibility(0);
        ConstraintLayout constraintLayout = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
        Context context = constraintLayout.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
        Resources resources = context.getResources();
        ConstraintLayout constraintLayout2 = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.root");
        Context context2 = constraintLayout2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "binding.root.context");
        Drawable drawable = ResourcesCompat.getDrawable(resources, R.drawable.ic_mentions_white_24dp, context2.getTheme());
        if (drawable != null) {
            TextView textView2 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatInputItemName");
            this.binding.f2302b.setColorFilter(ColorCompat.getColor(textView2, R.color.status_grey_500), PorterDuff.Mode.SRC_ATOP);
            MGImages mGImages = MGImages.INSTANCE;
            SimpleDraweeView simpleDraweeView2 = this.binding.f2302b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatInputItemAvatar");
            Intrinsics3.checkNotNullExpressionValue(drawable, "it");
            MGImages.setImage$default(mGImages, simpleDraweeView2, drawable, (MGImages.ChangeDetector) null, 4, (Object) null);
        }
    }

    public final void bindRole(RoleAutocompletable roleAutocompletable) {
        Intrinsics3.checkNotNullParameter(roleAutocompletable, "roleAutocompletable");
        GuildRole role = roleAutocompletable.getRole();
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        int opaqueColor = RoleUtils.getOpaqueColor(role, ColorCompat.getColor(textView, R.color.status_grey_500));
        TextView textView2 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatInputItemName");
        textView2.setText(roleAutocompletable.getRole().getName());
        this.binding.e.setTextColor(opaqueColor);
        SimpleDraweeView simpleDraweeView = this.binding.f2302b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.chatInputItemAvatar");
        simpleDraweeView.setVisibility(0);
        ConstraintLayout constraintLayout = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
        Context context = constraintLayout.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
        Resources resources = context.getResources();
        ConstraintLayout constraintLayout2 = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.root");
        Context context2 = constraintLayout2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "binding.root.context");
        Drawable drawable = ResourcesCompat.getDrawable(resources, R.drawable.ic_mentions_white_24dp, context2.getTheme());
        if (drawable != null) {
            this.binding.f2302b.setColorFilter(opaqueColor, PorterDuff.Mode.SRC_ATOP);
            MGImages mGImages = MGImages.INSTANCE;
            SimpleDraweeView simpleDraweeView2 = this.binding.f2302b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatInputItemAvatar");
            Intrinsics3.checkNotNullExpressionValue(drawable, "it");
            MGImages.setImage$default(mGImages, simpleDraweeView2, drawable, (MGImages.ChangeDetector) null, 4, (Object) null);
        }
    }

    public final void bindUser(UserAutocompletable userAutocompletable) {
        Intrinsics3.checkNotNullParameter(userAutocompletable, "userAutocompletable");
        com.discord.models.user.User user = userAutocompletable.getUser();
        UserUtils userUtils = UserUtils.INSTANCE;
        CharSequence userNameWithDiscriminator$default = UserUtils.getUserNameWithDiscriminator$default(userUtils, user, null, null, 3, null);
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        String nickname = userAutocompletable.getNickname();
        if (nickname == null) {
            nickname = user.getUsername();
        }
        textView.setText(nickname);
        TextView textView2 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatInputItemNameRight");
        textView2.setVisibility(0);
        TextView textView3 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.chatInputItemNameRight");
        textView3.setText(userNameWithDiscriminator$default);
        SimpleDraweeView simpleDraweeView = this.binding.f2302b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.chatInputItemAvatar");
        simpleDraweeView.setVisibility(0);
        SimpleDraweeView simpleDraweeView2 = this.binding.f2302b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatInputItemAvatar");
        IconUtils.setIcon$default(simpleDraweeView2, user, R.dimen.avatar_size_standard, null, null, userAutocompletable.getGuildMember(), 24, null);
        Presence presence = userAutocompletable.getPresence();
        if (presence != null) {
            StatusView statusView = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(statusView, "binding.chatInputItemStatus");
            statusView.setVisibility(userUtils.isStatusVisible(user, presence, true) ? 0 : 8);
            this.binding.g.setPresence(presence);
        }
    }

    public final void clearBinding() {
        ConstraintLayout constraintLayout = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
        constraintLayout.setEnabled(true);
        ConstraintLayout constraintLayout2 = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.root");
        constraintLayout2.setAlpha(1.0f);
        TextView textView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatInputItemNameRight");
        textView.setText((CharSequence) null);
        TextView textView2 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatInputItemNameRight");
        textView2.setVisibility(8);
        TextView textView3 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.chatInputItemName");
        textView3.setText((CharSequence) null);
        this.binding.e.setTextColor(this.defaultItemTextColor);
        TextView textView4 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.chatInputItemDescription");
        textView4.setText((CharSequence) null);
        TextView textView5 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.chatInputItemDescription");
        textView5.setVisibility(8);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.chatInputItemEmoji");
        simpleDraweeSpanTextView.setText((CharSequence) null);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView2, "binding.chatInputItemEmoji");
        simpleDraweeSpanTextView2.setVisibility(8);
        StatusView statusView = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(statusView, "binding.chatInputItemStatus");
        statusView.setVisibility(8);
        SimpleDraweeView simpleDraweeView = this.binding.f2302b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.chatInputItemAvatar");
        simpleDraweeView.setVisibility(8);
        this.binding.f2302b.setImageURI((String) null);
        this.binding.f2302b.setPadding(0, 0, 0, 0);
        this.binding.f2302b.clearColorFilter();
        ConstraintLayout constraintLayout3 = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout3, "binding.root");
        constraintLayout3.setContentDescription(null);
    }

    public final int getDefaultItemTextColor() {
        return this.defaultItemTextColor;
    }
}

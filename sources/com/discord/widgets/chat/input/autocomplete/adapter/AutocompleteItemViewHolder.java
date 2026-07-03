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
import com.discord.C5419R;
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
import com.discord.widgets.chat.input.MentionUtilsKt;
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
import java.util.Collections;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.C12238m;

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
            C12238m.checkNotNullParameter(context, "context");
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
            C12238m.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
            EmojiNode.RenderContext.DefaultImpls.onEmojiClicked(this, emojiIdAndType);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AutocompleteItemViewHolder(WidgetChatInputAutocompleteItemBinding widgetChatInputAutocompleteItemBinding, Function1<? super Autocompletable, Unit> function1) {
        super(widgetChatInputAutocompleteItemBinding.f16087a);
        C12238m.checkNotNullParameter(widgetChatInputAutocompleteItemBinding, "binding");
        C12238m.checkNotNullParameter(function1, "onItemSelected");
        this.binding = widgetChatInputAutocompleteItemBinding;
        this.onItemSelected = function1;
        TextView textView = widgetChatInputAutocompleteItemBinding.f16091e;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        this.defaultItemTextColor = textView.getCurrentTextColor();
    }

    private final void bindChannel(ChannelAutocompletable channelAutocompletable) {
        int i;
        Channel channel = channelAutocompletable.getChannel();
        TextView textView = this.binding.f16091e;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        textView.setText(channel.getName());
        if (ChannelUtils.m7675J(channel)) {
            i = C5419R.drawable.ic_channel_voice;
        } else if (ChannelUtils.m7673H(channel)) {
            i = C5419R.drawable.ic_thread;
        } else {
            i = ChannelUtils.m7698v(channel) ? C5419R.drawable.ic_channel_text : C5419R.drawable.ic_guild_folder;
        }
        SimpleDraweeView simpleDraweeView = this.binding.f16088b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatInputItemAvatar");
        int color = ColorCompat.getColor(simpleDraweeView, C5419R.color.primary_500);
        SimpleDraweeView simpleDraweeView2 = this.binding.f16088b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatInputItemAvatar");
        simpleDraweeView2.setVisibility(0);
        int iDpToPixels = DimenUtils.dpToPixels(6);
        this.binding.f16088b.setPadding(iDpToPixels, iDpToPixels, iDpToPixels, iDpToPixels);
        MGImages mGImages = MGImages.INSTANCE;
        SimpleDraweeView simpleDraweeView3 = this.binding.f16088b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.chatInputItemAvatar");
        MGImages.setImage$default(mGImages, simpleDraweeView3, i, (MGImages.ChangeDetector) null, 4, (Object) null);
        this.binding.f16088b.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }

    public final void bind(final Autocompletable autocompletable) {
        C12238m.checkNotNullParameter(autocompletable, "autocompletable");
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
        this.binding.f16087a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.autocomplete.adapter.AutocompleteItemViewHolder.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AutocompleteItemViewHolder.this.onItemSelected.invoke(autocompletable);
            }
        });
    }

    public final void bindCommand(ApplicationCommandAutocompletable commandAutocompletable) {
        String name;
        C12238m.checkNotNullParameter(commandAutocompletable, "commandAutocompletable");
        ApplicationCommand command = commandAutocompletable.getCommand();
        Application application = commandAutocompletable.getApplication();
        if (!commandAutocompletable.getHasPermissionToUse()) {
            ConstraintLayout constraintLayout = this.binding.f16087a;
            C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            constraintLayout.setEnabled(false);
            ConstraintLayout constraintLayout2 = this.binding.f16087a;
            C12238m.checkNotNullExpressionValue(constraintLayout2, "binding.root");
            constraintLayout2.setAlpha(0.3f);
        }
        StringBuilder sbM829Q = C1643a.m829Q(MentionUtilsKt.SLASH_CHAR);
        sbM829Q.append(command.getName());
        String string = sbM829Q.toString();
        TextView textView = this.binding.f16091e;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        textView.setText(string);
        ConstraintLayout constraintLayout3 = this.binding.f16087a;
        C12238m.checkNotNullExpressionValue(constraintLayout3, "binding.root");
        Resources resources = constraintLayout3.getResources();
        C12238m.checkNotNullExpressionValue(resources, "binding.root.resources");
        String descriptionText = StoreApplicationCommandsKt.getDescriptionText(command, resources);
        if (descriptionText != null && (!C12103t.isBlank(descriptionText))) {
            TextView textView2 = this.binding.f16089c;
            C12238m.checkNotNullExpressionValue(textView2, "binding.chatInputItemDescription");
            textView2.setVisibility(0);
            TextView textView3 = this.binding.f16089c;
            C12238m.checkNotNullExpressionValue(textView3, "binding.chatInputItemDescription");
            textView3.setText(C12106w.trim(descriptionText).toString());
        }
        if (application != null) {
            TextView textView4 = this.binding.f16092f;
            C12238m.checkNotNullExpressionValue(textView4, "binding.chatInputItemNameRight");
            textView4.setVisibility(0);
            User bot = application.getBot();
            if (bot == null || (name = bot.getUsername()) == null) {
                name = application.getName();
            }
            TextView textView5 = this.binding.f16092f;
            C12238m.checkNotNullExpressionValue(textView5, "binding.chatInputItemNameRight");
            Locale locale = Locale.getDefault();
            C12238m.checkNotNullExpressionValue(locale, "Locale.getDefault()");
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String upperCase = name.toUpperCase(locale);
            C12238m.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            textView5.setText(upperCase);
            ConstraintLayout constraintLayout4 = this.binding.f16087a;
            C12238m.checkNotNullExpressionValue(constraintLayout4, "binding.root");
            TextView textView6 = this.binding.f16089c;
            C12238m.checkNotNullExpressionValue(textView6, "binding.chatInputItemDescription");
            CharSequence charSequenceM212d = C1107b.m212d(constraintLayout4, C5419R.string.command_accessibility_desc_command_item, new Object[]{command.getName(), textView6.getText(), application.getName()}, (4 & 4) != 0 ? C1107b.c.f1492j : null);
            ConstraintLayout constraintLayout5 = this.binding.f16087a;
            C12238m.checkNotNullExpressionValue(constraintLayout5, "binding.root");
            constraintLayout5.setContentDescription(charSequenceM212d);
        }
        if (commandAutocompletable.getShowAvatar()) {
            SimpleDraweeView simpleDraweeView = this.binding.f16088b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatInputItemAvatar");
            simpleDraweeView.setVisibility(0);
            if (application != null) {
                SimpleDraweeView simpleDraweeView2 = this.binding.f16088b;
                C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatInputItemAvatar");
                IconUtils.setApplicationIcon(simpleDraweeView2, application);
                return;
            }
            ConstraintLayout constraintLayout6 = this.binding.f16087a;
            C12238m.checkNotNullExpressionValue(constraintLayout6, "binding.root");
            int themedColor = ColorCompat.getThemedColor(constraintLayout6, C5419R.attr.colorTextMuted);
            MGImages mGImages = MGImages.INSTANCE;
            SimpleDraweeView simpleDraweeView3 = this.binding.f16088b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.chatInputItemAvatar");
            MGImages.setImage$default(mGImages, simpleDraweeView3, C5419R.drawable.ic_slash_command_24dp, (MGImages.ChangeDetector) null, 4, (Object) null);
            this.binding.f16088b.setColorFilter(themedColor, PorterDuff.Mode.SRC_ATOP);
        }
    }

    public final void bindCommandChoice(ApplicationCommandChoiceAutocompletable commandChoiceAutocompletable) {
        C12238m.checkNotNullParameter(commandChoiceAutocompletable, "commandChoiceAutocompletable");
        TextView textView = this.binding.f16091e;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        textView.setText(commandChoiceAutocompletable.getChoice().getName());
    }

    public final void bindEmoji(EmojiAutocompletable emojiAutocompletable) {
        C12238m.checkNotNullParameter(emojiAutocompletable, "emojiAutocompletable");
        Emoji emoji = emojiAutocompletable.getEmoji();
        String firstName = emoji.getFirstName();
        C12238m.checkNotNullExpressionValue(firstName, "emoji.firstName");
        EmojiNode.EmojiIdAndType.Unicode unicode = new EmojiNode.EmojiIdAndType.Unicode(firstName);
        String firstName2 = emoji.getFirstName();
        C12238m.checkNotNullExpressionValue(firstName2, "emoji.firstName");
        EmojiNode emojiNode = new EmojiNode(firstName2, new AutocompleteItemViewHolder$bindEmoji$emojiNode$1(emoji), unicode, 0, 0, 24, null);
        boolean animationsEnabled = emojiAutocompletable.getAnimationsEnabled();
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.f16090d;
        C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.chatInputItemEmoji");
        Context context = simpleDraweeSpanTextView.getContext();
        C12238m.checkNotNullExpressionValue(context, "binding.chatInputItemEmoji.context");
        EmojiAutocompleteRenderContext emojiAutocompleteRenderContext = new EmojiAutocompleteRenderContext(this, animationsEnabled, context);
        Set setSingleton = Collections.singleton(emojiNode);
        C12238m.checkNotNullExpressionValue(setSingleton, "Collections.singleton(emojiNode)");
        DraweeSpanStringBuilder draweeSpanStringBuilderRender = AstRenderer.render(setSingleton, emojiAutocompleteRenderContext);
        StringBuilder sbM829Q = C1643a.m829Q(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        sbM829Q.append(emoji.getFirstName());
        sbM829Q.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        String string = sbM829Q.toString();
        TextView textView = this.binding.f16091e;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        textView.setText(string);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = this.binding.f16090d;
        C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView2, "binding.chatInputItemEmoji");
        simpleDraweeSpanTextView2.setVisibility(0);
        this.binding.f16090d.setDraweeSpanStringBuilder(draweeSpanStringBuilderRender);
    }

    public final void bindGlobalRole(GlobalRoleAutocompletable roleAutocompletable) {
        C12238m.checkNotNullParameter(roleAutocompletable, "roleAutocompletable");
        TextView textView = this.binding.f16091e;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        textView.setText(roleAutocompletable.getText());
        SimpleDraweeView simpleDraweeView = this.binding.f16088b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatInputItemAvatar");
        simpleDraweeView.setVisibility(0);
        ConstraintLayout constraintLayout = this.binding.f16087a;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        Context context = constraintLayout.getContext();
        C12238m.checkNotNullExpressionValue(context, "binding.root.context");
        Resources resources = context.getResources();
        ConstraintLayout constraintLayout2 = this.binding.f16087a;
        C12238m.checkNotNullExpressionValue(constraintLayout2, "binding.root");
        Context context2 = constraintLayout2.getContext();
        C12238m.checkNotNullExpressionValue(context2, "binding.root.context");
        Drawable drawable = ResourcesCompat.getDrawable(resources, C5419R.drawable.ic_mentions_white_24dp, context2.getTheme());
        if (drawable != null) {
            TextView textView2 = this.binding.f16091e;
            C12238m.checkNotNullExpressionValue(textView2, "binding.chatInputItemName");
            this.binding.f16088b.setColorFilter(ColorCompat.getColor(textView2, C5419R.color.status_grey_500), PorterDuff.Mode.SRC_ATOP);
            MGImages mGImages = MGImages.INSTANCE;
            SimpleDraweeView simpleDraweeView2 = this.binding.f16088b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatInputItemAvatar");
            C12238m.checkNotNullExpressionValue(drawable, "it");
            MGImages.setImage$default(mGImages, simpleDraweeView2, drawable, (MGImages.ChangeDetector) null, 4, (Object) null);
        }
    }

    public final void bindRole(RoleAutocompletable roleAutocompletable) {
        C12238m.checkNotNullParameter(roleAutocompletable, "roleAutocompletable");
        GuildRole role = roleAutocompletable.getRole();
        TextView textView = this.binding.f16091e;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        int opaqueColor = RoleUtils.getOpaqueColor(role, ColorCompat.getColor(textView, C5419R.color.status_grey_500));
        TextView textView2 = this.binding.f16091e;
        C12238m.checkNotNullExpressionValue(textView2, "binding.chatInputItemName");
        textView2.setText(roleAutocompletable.getRole().getName());
        this.binding.f16091e.setTextColor(opaqueColor);
        SimpleDraweeView simpleDraweeView = this.binding.f16088b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatInputItemAvatar");
        simpleDraweeView.setVisibility(0);
        ConstraintLayout constraintLayout = this.binding.f16087a;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        Context context = constraintLayout.getContext();
        C12238m.checkNotNullExpressionValue(context, "binding.root.context");
        Resources resources = context.getResources();
        ConstraintLayout constraintLayout2 = this.binding.f16087a;
        C12238m.checkNotNullExpressionValue(constraintLayout2, "binding.root");
        Context context2 = constraintLayout2.getContext();
        C12238m.checkNotNullExpressionValue(context2, "binding.root.context");
        Drawable drawable = ResourcesCompat.getDrawable(resources, C5419R.drawable.ic_mentions_white_24dp, context2.getTheme());
        if (drawable != null) {
            this.binding.f16088b.setColorFilter(opaqueColor, PorterDuff.Mode.SRC_ATOP);
            MGImages mGImages = MGImages.INSTANCE;
            SimpleDraweeView simpleDraweeView2 = this.binding.f16088b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatInputItemAvatar");
            C12238m.checkNotNullExpressionValue(drawable, "it");
            MGImages.setImage$default(mGImages, simpleDraweeView2, drawable, (MGImages.ChangeDetector) null, 4, (Object) null);
        }
    }

    public final void bindUser(UserAutocompletable userAutocompletable) {
        C12238m.checkNotNullParameter(userAutocompletable, "userAutocompletable");
        com.discord.models.user.User user = userAutocompletable.getUser();
        UserUtils userUtils = UserUtils.INSTANCE;
        CharSequence userNameWithDiscriminator$default = UserUtils.getUserNameWithDiscriminator$default(userUtils, user, null, null, 3, null);
        TextView textView = this.binding.f16091e;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        String nickname = userAutocompletable.getNickname();
        if (nickname == null) {
            nickname = user.getUsername();
        }
        textView.setText(nickname);
        TextView textView2 = this.binding.f16092f;
        C12238m.checkNotNullExpressionValue(textView2, "binding.chatInputItemNameRight");
        textView2.setVisibility(0);
        TextView textView3 = this.binding.f16092f;
        C12238m.checkNotNullExpressionValue(textView3, "binding.chatInputItemNameRight");
        textView3.setText(userNameWithDiscriminator$default);
        SimpleDraweeView simpleDraweeView = this.binding.f16088b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatInputItemAvatar");
        simpleDraweeView.setVisibility(0);
        SimpleDraweeView simpleDraweeView2 = this.binding.f16088b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatInputItemAvatar");
        IconUtils.setIcon$default(simpleDraweeView2, user, C5419R.dimen.avatar_size_standard, null, null, userAutocompletable.getGuildMember(), 24, null);
        Presence presence = userAutocompletable.getPresence();
        if (presence != null) {
            StatusView statusView = this.binding.f16093g;
            C12238m.checkNotNullExpressionValue(statusView, "binding.chatInputItemStatus");
            statusView.setVisibility(userUtils.isStatusVisible(user, presence, true) ? 0 : 8);
            this.binding.f16093g.setPresence(presence);
        }
    }

    public final void clearBinding() {
        ConstraintLayout constraintLayout = this.binding.f16087a;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        constraintLayout.setEnabled(true);
        ConstraintLayout constraintLayout2 = this.binding.f16087a;
        C12238m.checkNotNullExpressionValue(constraintLayout2, "binding.root");
        constraintLayout2.setAlpha(1.0f);
        TextView textView = this.binding.f16092f;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatInputItemNameRight");
        textView.setText((CharSequence) null);
        TextView textView2 = this.binding.f16092f;
        C12238m.checkNotNullExpressionValue(textView2, "binding.chatInputItemNameRight");
        textView2.setVisibility(8);
        TextView textView3 = this.binding.f16091e;
        C12238m.checkNotNullExpressionValue(textView3, "binding.chatInputItemName");
        textView3.setText((CharSequence) null);
        this.binding.f16091e.setTextColor(this.defaultItemTextColor);
        TextView textView4 = this.binding.f16089c;
        C12238m.checkNotNullExpressionValue(textView4, "binding.chatInputItemDescription");
        textView4.setText((CharSequence) null);
        TextView textView5 = this.binding.f16089c;
        C12238m.checkNotNullExpressionValue(textView5, "binding.chatInputItemDescription");
        textView5.setVisibility(8);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.f16090d;
        C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.chatInputItemEmoji");
        simpleDraweeSpanTextView.setText((CharSequence) null);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = this.binding.f16090d;
        C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView2, "binding.chatInputItemEmoji");
        simpleDraweeSpanTextView2.setVisibility(8);
        StatusView statusView = this.binding.f16093g;
        C12238m.checkNotNullExpressionValue(statusView, "binding.chatInputItemStatus");
        statusView.setVisibility(8);
        SimpleDraweeView simpleDraweeView = this.binding.f16088b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatInputItemAvatar");
        simpleDraweeView.setVisibility(8);
        this.binding.f16088b.setImageURI((String) null);
        this.binding.f16088b.setPadding(0, 0, 0, 0);
        this.binding.f16088b.clearColorFilter();
        ConstraintLayout constraintLayout3 = this.binding.f16087a;
        C12238m.checkNotNullExpressionValue(constraintLayout3, "binding.root");
        constraintLayout3.setContentDescription(null);
    }

    public final int getDefaultItemTextColor() {
        return this.defaultItemTextColor;
    }
}

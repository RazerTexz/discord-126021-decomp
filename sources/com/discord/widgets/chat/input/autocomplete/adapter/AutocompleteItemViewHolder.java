package com.discord.widgets.chat.input.autocomplete.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.a.k.b;
import b.d.b.a.a;
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
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType$Unicode;
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
import d0.g0.t;
import d0.g0.w;
import d0.z.d.m;
import java.util.Collections;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AutocompleteItemViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteItemViewHolder extends RecyclerView$ViewHolder {
    private final WidgetChatInputAutocompleteItemBinding binding;
    private final int defaultItemTextColor;
    private final Function1<Autocompletable, Unit> onItemSelected;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AutocompleteItemViewHolder(WidgetChatInputAutocompleteItemBinding widgetChatInputAutocompleteItemBinding, Function1<? super Autocompletable, Unit> function1) {
        super(widgetChatInputAutocompleteItemBinding.a);
        m.checkNotNullParameter(widgetChatInputAutocompleteItemBinding, "binding");
        m.checkNotNullParameter(function1, "onItemSelected");
        this.binding = widgetChatInputAutocompleteItemBinding;
        this.onItemSelected = function1;
        TextView textView = widgetChatInputAutocompleteItemBinding.e;
        m.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        this.defaultItemTextColor = textView.getCurrentTextColor();
    }

    public static final /* synthetic */ Function1 access$getOnItemSelected$p(AutocompleteItemViewHolder autocompleteItemViewHolder) {
        return autocompleteItemViewHolder.onItemSelected;
    }

    private final void bindChannel(ChannelAutocompletable channelAutocompletable) {
        int i;
        Channel channel = channelAutocompletable.getChannel();
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        textView.setText(channel.getName());
        if (ChannelUtils.J(channel)) {
            i = 2131231639;
        } else if (ChannelUtils.H(channel)) {
            i = 2131232193;
        } else {
            i = ChannelUtils.v(channel) ? 2131231630 : 2131231834;
        }
        SimpleDraweeView simpleDraweeView = this.binding.f2302b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatInputItemAvatar");
        int color = ColorCompat.getColor(simpleDraweeView, 2131100178);
        SimpleDraweeView simpleDraweeView2 = this.binding.f2302b;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatInputItemAvatar");
        simpleDraweeView2.setVisibility(0);
        int iDpToPixels = DimenUtils.dpToPixels(6);
        this.binding.f2302b.setPadding(iDpToPixels, iDpToPixels, iDpToPixels, iDpToPixels);
        MGImages mGImages = MGImages.INSTANCE;
        SimpleDraweeView simpleDraweeView3 = this.binding.f2302b;
        m.checkNotNullExpressionValue(simpleDraweeView3, "binding.chatInputItemAvatar");
        MGImages.setImage$default(mGImages, simpleDraweeView3, i, (MGImages$ChangeDetector) null, 4, (Object) null);
        this.binding.f2302b.setColorFilter(color, PorterDuff$Mode.SRC_ATOP);
    }

    public final void bind(Autocompletable autocompletable) {
        m.checkNotNullParameter(autocompletable, "autocompletable");
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
        this.binding.a.setOnClickListener(new AutocompleteItemViewHolder$bind$1(this, autocompletable));
    }

    public final void bindCommand(ApplicationCommandAutocompletable commandAutocompletable) {
        String name;
        m.checkNotNullParameter(commandAutocompletable, "commandAutocompletable");
        ApplicationCommand command = commandAutocompletable.getCommand();
        Application application = commandAutocompletable.getApplication();
        if (!commandAutocompletable.getHasPermissionToUse()) {
            ConstraintLayout constraintLayout = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            constraintLayout.setEnabled(false);
            ConstraintLayout constraintLayout2 = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout2, "binding.root");
            constraintLayout2.setAlpha(0.3f);
        }
        StringBuilder sbQ = a.Q(MentionUtilsKt.SLASH_CHAR);
        sbQ.append(command.getName());
        String string = sbQ.toString();
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        textView.setText(string);
        ConstraintLayout constraintLayout3 = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout3, "binding.root");
        Resources resources = constraintLayout3.getResources();
        m.checkNotNullExpressionValue(resources, "binding.root.resources");
        String descriptionText = StoreApplicationCommandsKt.getDescriptionText(command, resources);
        if (descriptionText != null && (!t.isBlank(descriptionText))) {
            TextView textView2 = this.binding.c;
            m.checkNotNullExpressionValue(textView2, "binding.chatInputItemDescription");
            textView2.setVisibility(0);
            TextView textView3 = this.binding.c;
            m.checkNotNullExpressionValue(textView3, "binding.chatInputItemDescription");
            textView3.setText(w.trim(descriptionText).toString());
        }
        if (application != null) {
            TextView textView4 = this.binding.f;
            m.checkNotNullExpressionValue(textView4, "binding.chatInputItemNameRight");
            textView4.setVisibility(0);
            User bot = application.getBot();
            if (bot == null || (name = bot.getUsername()) == null) {
                name = application.getName();
            }
            TextView textView5 = this.binding.f;
            m.checkNotNullExpressionValue(textView5, "binding.chatInputItemNameRight");
            Locale locale = Locale.getDefault();
            m.checkNotNullExpressionValue(locale, "Locale.getDefault()");
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String upperCase = name.toUpperCase(locale);
            m.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            textView5.setText(upperCase);
            ConstraintLayout constraintLayout4 = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout4, "binding.root");
            TextView textView6 = this.binding.c;
            m.checkNotNullExpressionValue(textView6, "binding.chatInputItemDescription");
            CharSequence charSequenceJ = b.j(constraintLayout4, 2131887713, new Object[]{command.getName(), textView6.getText(), application.getName()}, null, 4);
            ConstraintLayout constraintLayout5 = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout5, "binding.root");
            constraintLayout5.setContentDescription(charSequenceJ);
        }
        if (commandAutocompletable.getShowAvatar()) {
            SimpleDraweeView simpleDraweeView = this.binding.f2302b;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatInputItemAvatar");
            simpleDraweeView.setVisibility(0);
            if (application != null) {
                SimpleDraweeView simpleDraweeView2 = this.binding.f2302b;
                m.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatInputItemAvatar");
                IconUtils.setApplicationIcon(simpleDraweeView2, application);
                return;
            }
            ConstraintLayout constraintLayout6 = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout6, "binding.root");
            int themedColor = ColorCompat.getThemedColor(constraintLayout6, 2130969056);
            MGImages mGImages = MGImages.INSTANCE;
            SimpleDraweeView simpleDraweeView3 = this.binding.f2302b;
            m.checkNotNullExpressionValue(simpleDraweeView3, "binding.chatInputItemAvatar");
            MGImages.setImage$default(mGImages, simpleDraweeView3, 2131232129, (MGImages$ChangeDetector) null, 4, (Object) null);
            this.binding.f2302b.setColorFilter(themedColor, PorterDuff$Mode.SRC_ATOP);
        }
    }

    public final void bindCommandChoice(ApplicationCommandChoiceAutocompletable commandChoiceAutocompletable) {
        m.checkNotNullParameter(commandChoiceAutocompletable, "commandChoiceAutocompletable");
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        textView.setText(commandChoiceAutocompletable.getChoice().getName());
    }

    public final void bindEmoji(EmojiAutocompletable emojiAutocompletable) {
        m.checkNotNullParameter(emojiAutocompletable, "emojiAutocompletable");
        Emoji emoji = emojiAutocompletable.getEmoji();
        String firstName = emoji.getFirstName();
        m.checkNotNullExpressionValue(firstName, "emoji.firstName");
        EmojiNode$EmojiIdAndType$Unicode emojiNode$EmojiIdAndType$Unicode = new EmojiNode$EmojiIdAndType$Unicode(firstName);
        String firstName2 = emoji.getFirstName();
        m.checkNotNullExpressionValue(firstName2, "emoji.firstName");
        EmojiNode emojiNode = new EmojiNode(firstName2, new AutocompleteItemViewHolder$bindEmoji$emojiNode$1(emoji), emojiNode$EmojiIdAndType$Unicode, 0, 0, 24, null);
        boolean animationsEnabled = emojiAutocompletable.getAnimationsEnabled();
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.chatInputItemEmoji");
        Context context = simpleDraweeSpanTextView.getContext();
        m.checkNotNullExpressionValue(context, "binding.chatInputItemEmoji.context");
        AutocompleteItemViewHolder$EmojiAutocompleteRenderContext autocompleteItemViewHolder$EmojiAutocompleteRenderContext = new AutocompleteItemViewHolder$EmojiAutocompleteRenderContext(this, animationsEnabled, context);
        Set setSingleton = Collections.singleton(emojiNode);
        m.checkNotNullExpressionValue(setSingleton, "Collections.singleton(emojiNode)");
        DraweeSpanStringBuilder draweeSpanStringBuilderRender = AstRenderer.render(setSingleton, autocompleteItemViewHolder$EmojiAutocompleteRenderContext);
        StringBuilder sbQ = a.Q(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        sbQ.append(emoji.getFirstName());
        sbQ.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        String string = sbQ.toString();
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        textView.setText(string);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeSpanTextView2, "binding.chatInputItemEmoji");
        simpleDraweeSpanTextView2.setVisibility(0);
        this.binding.d.setDraweeSpanStringBuilder(draweeSpanStringBuilderRender);
    }

    public final void bindGlobalRole(GlobalRoleAutocompletable roleAutocompletable) {
        m.checkNotNullParameter(roleAutocompletable, "roleAutocompletable");
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        textView.setText(roleAutocompletable.getText());
        SimpleDraweeView simpleDraweeView = this.binding.f2302b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatInputItemAvatar");
        simpleDraweeView.setVisibility(0);
        ConstraintLayout constraintLayout = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        Context context = constraintLayout.getContext();
        m.checkNotNullExpressionValue(context, "binding.root.context");
        Resources resources = context.getResources();
        ConstraintLayout constraintLayout2 = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout2, "binding.root");
        Context context2 = constraintLayout2.getContext();
        m.checkNotNullExpressionValue(context2, "binding.root.context");
        Drawable drawable = ResourcesCompat.getDrawable(resources, 2131231914, context2.getTheme());
        if (drawable != null) {
            TextView textView2 = this.binding.e;
            m.checkNotNullExpressionValue(textView2, "binding.chatInputItemName");
            this.binding.f2302b.setColorFilter(ColorCompat.getColor(textView2, 2131100328), PorterDuff$Mode.SRC_ATOP);
            MGImages mGImages = MGImages.INSTANCE;
            SimpleDraweeView simpleDraweeView2 = this.binding.f2302b;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatInputItemAvatar");
            m.checkNotNullExpressionValue(drawable, "it");
            MGImages.setImage$default(mGImages, simpleDraweeView2, drawable, (MGImages$ChangeDetector) null, 4, (Object) null);
        }
    }

    public final void bindRole(RoleAutocompletable roleAutocompletable) {
        m.checkNotNullParameter(roleAutocompletable, "roleAutocompletable");
        GuildRole role = roleAutocompletable.getRole();
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        int opaqueColor = RoleUtils.getOpaqueColor(role, ColorCompat.getColor(textView, 2131100328));
        TextView textView2 = this.binding.e;
        m.checkNotNullExpressionValue(textView2, "binding.chatInputItemName");
        textView2.setText(roleAutocompletable.getRole().getName());
        this.binding.e.setTextColor(opaqueColor);
        SimpleDraweeView simpleDraweeView = this.binding.f2302b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatInputItemAvatar");
        simpleDraweeView.setVisibility(0);
        ConstraintLayout constraintLayout = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        Context context = constraintLayout.getContext();
        m.checkNotNullExpressionValue(context, "binding.root.context");
        Resources resources = context.getResources();
        ConstraintLayout constraintLayout2 = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout2, "binding.root");
        Context context2 = constraintLayout2.getContext();
        m.checkNotNullExpressionValue(context2, "binding.root.context");
        Drawable drawable = ResourcesCompat.getDrawable(resources, 2131231914, context2.getTheme());
        if (drawable != null) {
            this.binding.f2302b.setColorFilter(opaqueColor, PorterDuff$Mode.SRC_ATOP);
            MGImages mGImages = MGImages.INSTANCE;
            SimpleDraweeView simpleDraweeView2 = this.binding.f2302b;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatInputItemAvatar");
            m.checkNotNullExpressionValue(drawable, "it");
            MGImages.setImage$default(mGImages, simpleDraweeView2, drawable, (MGImages$ChangeDetector) null, 4, (Object) null);
        }
    }

    public final void bindUser(UserAutocompletable userAutocompletable) {
        m.checkNotNullParameter(userAutocompletable, "userAutocompletable");
        com.discord.models.user.User user = userAutocompletable.getUser();
        UserUtils userUtils = UserUtils.INSTANCE;
        CharSequence userNameWithDiscriminator$default = UserUtils.getUserNameWithDiscriminator$default(userUtils, user, null, null, 3, null);
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.chatInputItemName");
        String nickname = userAutocompletable.getNickname();
        if (nickname == null) {
            nickname = user.getUsername();
        }
        textView.setText(nickname);
        TextView textView2 = this.binding.f;
        m.checkNotNullExpressionValue(textView2, "binding.chatInputItemNameRight");
        textView2.setVisibility(0);
        TextView textView3 = this.binding.f;
        m.checkNotNullExpressionValue(textView3, "binding.chatInputItemNameRight");
        textView3.setText(userNameWithDiscriminator$default);
        SimpleDraweeView simpleDraweeView = this.binding.f2302b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatInputItemAvatar");
        simpleDraweeView.setVisibility(0);
        SimpleDraweeView simpleDraweeView2 = this.binding.f2302b;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatInputItemAvatar");
        IconUtils.setIcon$default(simpleDraweeView2, user, 2131165300, null, null, userAutocompletable.getGuildMember(), 24, null);
        Presence presence = userAutocompletable.getPresence();
        if (presence != null) {
            StatusView statusView = this.binding.g;
            m.checkNotNullExpressionValue(statusView, "binding.chatInputItemStatus");
            statusView.setVisibility(userUtils.isStatusVisible(user, presence, true) ? 0 : 8);
            this.binding.g.setPresence(presence);
        }
    }

    public final void clearBinding() {
        ConstraintLayout constraintLayout = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        constraintLayout.setEnabled(true);
        ConstraintLayout constraintLayout2 = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout2, "binding.root");
        constraintLayout2.setAlpha(1.0f);
        TextView textView = this.binding.f;
        m.checkNotNullExpressionValue(textView, "binding.chatInputItemNameRight");
        textView.setText((CharSequence) null);
        TextView textView2 = this.binding.f;
        m.checkNotNullExpressionValue(textView2, "binding.chatInputItemNameRight");
        textView2.setVisibility(8);
        TextView textView3 = this.binding.e;
        m.checkNotNullExpressionValue(textView3, "binding.chatInputItemName");
        textView3.setText((CharSequence) null);
        this.binding.e.setTextColor(this.defaultItemTextColor);
        TextView textView4 = this.binding.c;
        m.checkNotNullExpressionValue(textView4, "binding.chatInputItemDescription");
        textView4.setText((CharSequence) null);
        TextView textView5 = this.binding.c;
        m.checkNotNullExpressionValue(textView5, "binding.chatInputItemDescription");
        textView5.setVisibility(8);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.chatInputItemEmoji");
        simpleDraweeSpanTextView.setText((CharSequence) null);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeSpanTextView2, "binding.chatInputItemEmoji");
        simpleDraweeSpanTextView2.setVisibility(8);
        StatusView statusView = this.binding.g;
        m.checkNotNullExpressionValue(statusView, "binding.chatInputItemStatus");
        statusView.setVisibility(8);
        SimpleDraweeView simpleDraweeView = this.binding.f2302b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatInputItemAvatar");
        simpleDraweeView.setVisibility(8);
        this.binding.f2302b.setImageURI((String) null);
        this.binding.f2302b.setPadding(0, 0, 0, 0);
        this.binding.f2302b.clearColorFilter();
        ConstraintLayout constraintLayout3 = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout3, "binding.root");
        constraintLayout3.setContentDescription(null);
    }

    public final int getDefaultItemTextColor() {
        return this.defaultItemTextColor;
    }
}

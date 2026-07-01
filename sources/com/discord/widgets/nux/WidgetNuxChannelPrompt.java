package com.discord.widgets.nux;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetNuxChannelPromptBinding;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetFeatureFlag;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare$Companion;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$Companion;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNuxChannelPrompt extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetNuxChannelPrompt.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNuxChannelPromptBinding;", 0)};
    public static final WidgetNuxChannelPrompt$Companion Companion = new WidgetNuxChannelPrompt$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    public WidgetNuxChannelPrompt() {
        super(R$layout.widget_nux_channel_prompt);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetNuxChannelPrompt$binding$2.INSTANCE, null, 2, null);
        this.validationManager = g.lazy(new WidgetNuxChannelPrompt$validationManager$2(this));
        this.loggingConfig = new LoggingConfig(false, null, WidgetNuxChannelPrompt$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$finishActivity(WidgetNuxChannelPrompt widgetNuxChannelPrompt, long j) {
        widgetNuxChannelPrompt.finishActivity(j);
    }

    public static final /* synthetic */ WidgetNuxChannelPromptBinding access$getBinding$p(WidgetNuxChannelPrompt widgetNuxChannelPrompt) {
        return widgetNuxChannelPrompt.getBinding();
    }

    public static final /* synthetic */ void access$handleGuild(WidgetNuxChannelPrompt widgetNuxChannelPrompt, Guild guild) {
        widgetNuxChannelPrompt.handleGuild(guild);
    }

    public static final /* synthetic */ void access$handleSubmit(WidgetNuxChannelPrompt widgetNuxChannelPrompt, long j) {
        widgetNuxChannelPrompt.handleSubmit(j);
    }

    private final void finishActivity(long guildId) {
        if (GuildInviteShareSheetFeatureFlag.Companion.getINSTANCE().isEnabled()) {
            WidgetGuildInviteShareSheet$Companion.enqueueNoticeForHomeTab$default(WidgetGuildInviteShareSheet.Companion, null, guildId, "Guild Create", 1, null);
            j.c(requireContext(), false, null, 6);
        } else {
            WidgetGuildInviteShare$Companion widgetGuildInviteShare$Companion = WidgetGuildInviteShare.Companion;
            Context contextRequireContext = requireContext();
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetGuildInviteShare$Companion.launch$default(widgetGuildInviteShare$Companion, contextRequireContext, parentFragmentManager, guildId, null, true, null, null, "Guild Create", 96, null);
        }
        requireActivity().finish();
    }

    private final WidgetNuxChannelPromptBinding getBinding() {
        return (WidgetNuxChannelPromptBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void handleGuild(Guild guild) {
        if (guild == null) {
            return;
        }
        String forGuild$default = IconUtils.getForGuild$default(Long.valueOf(guild.getId()), guild.getIcon(), null, true, Integer.valueOf(IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(2131165293))), 4, null);
        if (forGuild$default != null) {
            TextView textView = getBinding().d;
            m.checkNotNullExpressionValue(textView, "binding.nufChannelPromptGuildIconName");
            textView.setVisibility(8);
            SimpleDraweeView simpleDraweeView = getBinding().c;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.nufChannelPromptGuildIcon");
            IconUtils.setIcon$default(simpleDraweeView, forGuild$default, 0, (Function1) null, (MGImages$ChangeDetector) null, 28, (Object) null);
        } else {
            TextView textView2 = getBinding().d;
            m.checkNotNullExpressionValue(textView2, "binding.nufChannelPromptGuildIconName");
            textView2.setVisibility(0);
            TextView textView3 = getBinding().d;
            m.checkNotNullExpressionValue(textView3, "binding.nufChannelPromptGuildIconName");
            textView3.setText(guild.getShortName());
            SimpleDraweeView simpleDraweeView2 = getBinding().c;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.nufChannelPromptGuildIcon");
            IconUtils.setIcon$default(simpleDraweeView2, IconUtils.DEFAULT_ICON, 0, (Function1) null, (MGImages$ChangeDetector) null, 28, (Object) null);
        }
        TextView textView4 = getBinding().e;
        m.checkNotNullExpressionValue(textView4, "binding.nufChannelPromptGuildName");
        textView4.setText(guild.getName());
    }

    private final void handleSubmit(long guildId) {
        getBinding().f2504b.setIsLoading(true);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreStream.Companion.getChannels().observeDefaultChannel(guildId), 0L, false, 3, null), WidgetNuxChannelPrompt.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetNuxChannelPrompt$handleSubmit$1(this, guildId), 62, (Object) null);
    }

    public static final void launch(Context context, long j) {
        Companion.launch(context, j);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    public final void handleError(Error error) {
        m.checkNotNullParameter(error, "error");
        getBinding().f2504b.setIsLoading(false);
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        if (response.getMessages().isEmpty()) {
            error.setShowErrorToasts(true);
            return;
        }
        ValidationManager validationManager = getValidationManager();
        Error$Response response2 = error.getResponse();
        m.checkNotNullExpressionValue(response2, "error.response");
        Map<String, List<String>> messages = response2.getMessages();
        m.checkNotNullExpressionValue(messages, "error.response.messages");
        error.setShowErrorToasts(!validationManager.setErrors(messages).isEmpty());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", 0L);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.Companion.getGuilds().observeGuild(longExtra), this, null, 2, null), WidgetNuxChannelPrompt.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetNuxChannelPrompt$onViewBound$1(this), 62, (Object) null);
        getBinding().f.setOnClickListener(new WidgetNuxChannelPrompt$onViewBound$2(this, longExtra));
        AppFragment.setOnBackPressed$default(this, new WidgetNuxChannelPrompt$onViewBound$3(this, longExtra), 0, 2, null);
        getBinding().f2504b.setIsLoading(false);
        getBinding().f2504b.setOnClickListener(new WidgetNuxChannelPrompt$onViewBound$4(this, longExtra));
        TextInputLayout textInputLayout = getBinding().g;
        m.checkNotNullExpressionValue(textInputLayout, "binding.nufChannelPromptTopicWrap");
        ViewExtensions.setOnImeActionDone(textInputLayout, true, new WidgetNuxChannelPrompt$onViewBound$5(this));
    }
}

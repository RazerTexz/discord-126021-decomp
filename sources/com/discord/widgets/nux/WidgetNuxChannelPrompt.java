package com.discord.widgets.nux;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionChannelCreate;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetNuxChannelPromptBinding;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetFeatureFlag;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNuxChannelPrompt extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetNuxChannelPrompt.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNuxChannelPromptBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            C0870j.m156d(context, WidgetNuxChannelPrompt.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$handleSubmit$1 */
    /* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
    public static final class C91071 extends AbstractC12240o implements Function1<Channel, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$handleSubmit$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Channel, TrackNetworkMetadataReceiver> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TrackNetworkMetadataReceiver invoke(Channel channel) {
                List<PermissionOverwrite> listM7655v;
                return new TrackNetworkActionChannelCreate((channel == null || (listM7655v = channel.m7655v()) == null) ? null : Boolean.valueOf(!listM7655v.isEmpty()), channel != null ? Long.valueOf(channel.getType()) : null, channel != null ? Long.valueOf(channel.getId()) : null, channel != null ? Long.valueOf(channel.getParentId()) : null, Long.valueOf(C91071.this.$guildId));
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$handleSubmit$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Channel, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
                invoke2(channel);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Channel channel) {
                C91071 c91071 = C91071.this;
                WidgetNuxChannelPrompt.this.finishActivity(c91071.$guildId);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C91071(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            if (channel == null) {
                WidgetNuxChannelPrompt.this.getBinding().f17317b.setIsLoading(false);
                return;
            }
            TextInputLayout textInputLayout = WidgetNuxChannelPrompt.this.getBinding().f17322g;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.nufChannelPromptTopicWrap");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(RestAPI.INSTANCE.getApi().createGuildChannel(this.$guildId, new RestAPIParams.CreateGuildChannel(0, null, textOrEmpty, Long.valueOf(channel.getParentId()), null, C1107b.m213e(WidgetNuxChannelPrompt.this, C5419R.string.nuf_channel_prompt_channel_topic_template, new Object[]{textOrEmpty}, (4 & 4) != 0 ? C1107b.a.f1490j : null).toString())), new AnonymousClass1()), false, 1, null), WidgetNuxChannelPrompt.this, null, 2, null).m11108k(C0879o.f566a.m184g(WidgetNuxChannelPrompt.this.requireContext(), new AnonymousClass2(), new Action1<Error>() { // from class: com.discord.widgets.nux.WidgetNuxChannelPrompt.handleSubmit.1.3
                @Override // p658rx.functions.Action1
                public final void call(Error error) {
                    WidgetNuxChannelPrompt widgetNuxChannelPrompt = WidgetNuxChannelPrompt.this;
                    C12238m.checkNotNullExpressionValue(error, "error");
                    widgetNuxChannelPrompt.handleError(error);
                }
            }));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
    public static final class C91081 extends AbstractC12240o implements Function1<Guild, Unit> {
        public C91081() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            WidgetNuxChannelPrompt.this.handleGuild(guild);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$onViewBound$5 */
    /* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
    public static final class C91125 extends AbstractC12240o implements Function1<TextView, Unit> {
        public C91125() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            C12238m.checkNotNullParameter(textView, "it");
            WidgetNuxChannelPrompt.this.getBinding().f17317b.performClick();
        }
    }

    public WidgetNuxChannelPrompt() {
        super(C5419R.layout.widget_nux_channel_prompt);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetNuxChannelPrompt$binding$2.INSTANCE, null, 2, null);
        this.validationManager = C12083g.lazy(new WidgetNuxChannelPrompt$validationManager$2(this));
        this.loggingConfig = new LoggingConfig(false, null, WidgetNuxChannelPrompt$loggingConfig$1.INSTANCE, 3);
    }

    private final void finishActivity(long guildId) {
        if (GuildInviteShareSheetFeatureFlag.INSTANCE.getINSTANCE().isEnabled()) {
            WidgetGuildInviteShareSheet.Companion.enqueueNoticeForHomeTab$default(WidgetGuildInviteShareSheet.INSTANCE, null, guildId, "Guild Create", 1, null);
            C0870j.m155c(requireContext(), false, null, 6);
        } else {
            WidgetGuildInviteShare.Companion companion = WidgetGuildInviteShare.INSTANCE;
            Context contextRequireContext = requireContext();
            FragmentManager parentFragmentManager = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.launch(contextRequireContext, parentFragmentManager, guildId, (16 & 8) != 0 ? null : null, (16 & 16) != 0 ? false : true, (16 & 32) != 0 ? null : null, (16 & 64) != 0 ? null : null, "Guild Create");
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
        String forGuild$default = IconUtils.getForGuild$default(Long.valueOf(guild.getId()), guild.getIcon(), null, true, Integer.valueOf(IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(C5419R.dimen.avatar_size_large))), 4, null);
        if (forGuild$default != null) {
            TextView textView = getBinding().f17319d;
            C12238m.checkNotNullExpressionValue(textView, "binding.nufChannelPromptGuildIconName");
            textView.setVisibility(8);
            SimpleDraweeView simpleDraweeView = getBinding().f17318c;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.nufChannelPromptGuildIcon");
            IconUtils.setIcon$default(simpleDraweeView, forGuild$default, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        } else {
            TextView textView2 = getBinding().f17319d;
            C12238m.checkNotNullExpressionValue(textView2, "binding.nufChannelPromptGuildIconName");
            textView2.setVisibility(0);
            TextView textView3 = getBinding().f17319d;
            C12238m.checkNotNullExpressionValue(textView3, "binding.nufChannelPromptGuildIconName");
            textView3.setText(guild.getShortName());
            SimpleDraweeView simpleDraweeView2 = getBinding().f17318c;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.nufChannelPromptGuildIcon");
            IconUtils.setIcon$default(simpleDraweeView2, IconUtils.DEFAULT_ICON, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        }
        TextView textView4 = getBinding().f17320e;
        C12238m.checkNotNullExpressionValue(textView4, "binding.nufChannelPromptGuildName");
        textView4.setText(guild.getName());
    }

    private final void handleSubmit(long guildId) {
        getBinding().f17317b.setIsLoading(true);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreStream.INSTANCE.getChannels().observeDefaultChannel(guildId), 0L, false, 3, null), (Class<?>) WidgetNuxChannelPrompt.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C91071(guildId));
    }

    public static final void launch(Context context, long j) {
        INSTANCE.launch(context, j);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    public final void handleError(Error error) {
        C12238m.checkNotNullParameter(error, "error");
        getBinding().f17317b.setIsLoading(false);
        Error.Response response = error.getResponse();
        C12238m.checkNotNullExpressionValue(response, "error.response");
        if (response.getMessages().isEmpty()) {
            error.setShowErrorToasts(true);
            return;
        }
        ValidationManager validationManager = getValidationManager();
        Error.Response response2 = error.getResponse();
        C12238m.checkNotNullExpressionValue(response2, "error.response");
        Map<String, List<String>> messages = response2.getMessages();
        C12238m.checkNotNullExpressionValue(messages, "error.response.messages");
        error.setShowErrorToasts(!validationManager.setErrors(messages).isEmpty());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        final long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", 0L);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getGuilds().observeGuild(longExtra), this, null, 2, null), (Class<?>) WidgetNuxChannelPrompt.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C91081());
        getBinding().f17321f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.nux.WidgetNuxChannelPrompt.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetNuxChannelPrompt.this.finishActivity(longExtra);
            }
        });
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.nux.WidgetNuxChannelPrompt.onViewBound.3
            @Override // p658rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                WidgetNuxChannelPrompt.this.finishActivity(longExtra);
                return Boolean.TRUE;
            }
        }, 0, 2, null);
        getBinding().f17317b.setIsLoading(false);
        getBinding().f17317b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.nux.WidgetNuxChannelPrompt.onViewBound.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetNuxChannelPrompt.this.handleSubmit(longExtra);
            }
        });
        TextInputLayout textInputLayout = getBinding().f17322g;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.nufChannelPromptTopicWrap");
        ViewExtensions.setOnImeActionDone(textInputLayout, true, new C91125());
    }
}

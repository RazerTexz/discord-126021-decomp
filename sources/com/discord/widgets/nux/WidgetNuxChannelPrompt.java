package com.discord.widgets.nux;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppScreen2;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionChannelCreate;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetNuxChannelPromptBinding;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetFeatureFlag;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNuxChannelPrompt extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetNuxChannelPrompt.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNuxChannelPromptBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AppLogger2 loggingConfig;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            AppScreen2.d(context, WidgetNuxChannelPrompt.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$handleSubmit$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$handleSubmit$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
        public static final class C03021 extends Lambda implements Function1<Channel, TrackNetworkMetadata2> {
            public C03021() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TrackNetworkMetadata2 invoke(Channel channel) {
                List<PermissionOverwrite> listV;
                return new TrackNetworkActionChannelCreate((channel == null || (listV = channel.v()) == null) ? null : Boolean.valueOf(!listV.isEmpty()), channel != null ? Long.valueOf(channel.getType()) : null, channel != null ? Long.valueOf(channel.getId()) : null, channel != null ? Long.valueOf(channel.getParentId()) : null, Long.valueOf(AnonymousClass1.this.$guildId));
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$handleSubmit$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
                invoke2(channel);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Channel channel) {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                WidgetNuxChannelPrompt.this.finishActivity(anonymousClass1.$guildId);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            if (channel == null) {
                WidgetNuxChannelPrompt.this.getBinding().f2504b.setIsLoading(false);
                return;
            }
            TextInputLayout textInputLayout = WidgetNuxChannelPrompt.this.getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.nufChannelPromptTopicWrap");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallState5.logNetworkAction(RestAPI.INSTANCE.getApi().createGuildChannel(this.$guildId, new RestAPIParams.CreateGuildChannel(0, null, textOrEmpty, Long.valueOf(channel.getParentId()), null, FormatUtils.e(WidgetNuxChannelPrompt.this, R.string.nuf_channel_prompt_channel_topic_template, new Object[]{textOrEmpty}, (4 & 4) != 0 ? FormatUtils.a.j : null).toString())), new C03021()), false, 1, null), WidgetNuxChannelPrompt.this, null, 2, null).k(o.a.g(WidgetNuxChannelPrompt.this.requireContext(), new AnonymousClass2(), new Action1<Error>() { // from class: com.discord.widgets.nux.WidgetNuxChannelPrompt.handleSubmit.1.3
                @Override // rx.functions.Action1
                public final void call(Error error) {
                    WidgetNuxChannelPrompt widgetNuxChannelPrompt = WidgetNuxChannelPrompt.this;
                    Intrinsics3.checkNotNullExpressionValue(error, "error");
                    widgetNuxChannelPrompt.handleError(error);
                }
            }));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Guild, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            WidgetNuxChannelPrompt.this.handleGuild(guild);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$onViewBound$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<TextView, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "it");
            WidgetNuxChannelPrompt.this.getBinding().f2504b.performClick();
        }
    }

    public WidgetNuxChannelPrompt() {
        super(R.layout.widget_nux_channel_prompt);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetNuxChannelPrompt2.INSTANCE, null, 2, null);
        this.validationManager = LazyJVM.lazy(new WidgetNuxChannelPrompt4(this));
        this.loggingConfig = new AppLogger2(false, null, WidgetNuxChannelPrompt3.INSTANCE, 3);
    }

    private final void finishActivity(long guildId) {
        if (GuildInviteShareSheetFeatureFlag.INSTANCE.getINSTANCE().isEnabled()) {
            WidgetGuildInviteShareSheet.Companion.enqueueNoticeForHomeTab$default(WidgetGuildInviteShareSheet.INSTANCE, null, guildId, "Guild Create", 1, null);
            AppScreen2.c(requireContext(), false, null, 6);
        } else {
            WidgetGuildInviteShare.Companion companion = WidgetGuildInviteShare.INSTANCE;
            Context contextRequireContext = requireContext();
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
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
        String forGuild$default = IconUtils.getForGuild$default(Long.valueOf(guild.getId()), guild.getIcon(), null, true, Integer.valueOf(IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(R.dimen.avatar_size_large))), 4, null);
        if (forGuild$default != null) {
            TextView textView = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.nufChannelPromptGuildIconName");
            textView.setVisibility(8);
            SimpleDraweeView simpleDraweeView = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.nufChannelPromptGuildIcon");
            IconUtils.setIcon$default(simpleDraweeView, forGuild$default, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        } else {
            TextView textView2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.nufChannelPromptGuildIconName");
            textView2.setVisibility(0);
            TextView textView3 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.nufChannelPromptGuildIconName");
            textView3.setText(guild.getShortName());
            SimpleDraweeView simpleDraweeView2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.nufChannelPromptGuildIcon");
            IconUtils.setIcon$default(simpleDraweeView2, IconUtils.DEFAULT_ICON, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        }
        TextView textView4 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.nufChannelPromptGuildName");
        textView4.setText(guild.getName());
    }

    private final void handleSubmit(long guildId) {
        getBinding().f2504b.setIsLoading(true);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreStream.INSTANCE.getChannels().observeDefaultChannel(guildId), 0L, false, 3, null), (Class<?>) WidgetNuxChannelPrompt.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(guildId));
    }

    public static final void launch(Context context, long j) {
        INSTANCE.launch(context, j);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    public final void handleError(Error error) {
        Intrinsics3.checkNotNullParameter(error, "error");
        getBinding().f2504b.setIsLoading(false);
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        if (response.getMessages().isEmpty()) {
            error.setShowErrorToasts(true);
            return;
        }
        ValidationManager validationManager = getValidationManager();
        Error.Response response2 = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
        Map<String, List<String>> messages = response2.getMessages();
        Intrinsics3.checkNotNullExpressionValue(messages, "error.response.messages");
        error.setShowErrorToasts(!validationManager.setErrors(messages).isEmpty());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        final long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", 0L);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getGuilds().observeGuild(longExtra), this, null, 2, null), (Class<?>) WidgetNuxChannelPrompt.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        getBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.nux.WidgetNuxChannelPrompt.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetNuxChannelPrompt.this.finishActivity(longExtra);
            }
        });
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.nux.WidgetNuxChannelPrompt.onViewBound.3
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                WidgetNuxChannelPrompt.this.finishActivity(longExtra);
                return Boolean.TRUE;
            }
        }, 0, 2, null);
        getBinding().f2504b.setIsLoading(false);
        getBinding().f2504b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.nux.WidgetNuxChannelPrompt.onViewBound.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetNuxChannelPrompt.this.handleSubmit(longExtra);
            }
        });
        TextInputLayout textInputLayout = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.nufChannelPromptTopicWrap");
        ViewExtensions.setOnImeActionDone(textInputLayout, true, new AnonymousClass5());
    }
}

package com.discord.widgets.guilds.invite;

import android.content.Context;
import androidx.core.view.PointerIconCompat;
import androidx.fragment.app.FragmentManager;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleOwnerKt;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppFragment;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreStream;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.coroutines.AppCoroutineScopeKt;
import com.discord.utilities.error.Error;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.stage.StageChannelJoinHelper;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$Companion;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$Companion;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$FeatureContext;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: InviteJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InviteJoinHelper {
    public static final InviteJoinHelper INSTANCE = new InviteJoinHelper();

    private InviteJoinHelper() {
    }

    public static final /* synthetic */ void access$navigateToChannel(InviteJoinHelper inviteJoinHelper, Context context, AppFragment appFragment, ModelInvite modelInvite) {
        inviteJoinHelper.navigateToChannel(context, appFragment, modelInvite);
    }

    public static final /* synthetic */ void access$navigateToGuild(InviteJoinHelper inviteJoinHelper, ModelInvite modelInvite) {
        inviteJoinHelper.navigateToGuild(modelInvite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Job joinViaInvite$default(InviteJoinHelper inviteJoinHelper, ModelInvite modelInvite, Class cls, AppFragment appFragment, String str, Function2 function2, Function2 function3, Function2 function4, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, int i, Object obj) {
        return inviteJoinHelper.joinViaInvite(modelInvite, cls, appFragment, str, (i & 16) != 0 ? new InviteJoinHelper$joinViaInvite$1(null) : function2, (i & 32) != 0 ? new InviteJoinHelper$joinViaInvite$2(null) : function3, (i & 64) != 0 ? new InviteJoinHelper$joinViaInvite$3(null) : function4, (i & 128) != 0 ? null : captchaHelper$CaptchaPayload);
    }

    private final void navigateToChannel(Context context, AppFragment appFragment, ModelInvite modelInvite) {
        Channel channel = modelInvite.getChannel();
        if (channel != null) {
            ChannelSelector.Companion.getInstance().findAndSet(context, channel.getId());
            m.checkNotNullExpressionValue(channel, "channel");
            if (ChannelUtils.J(channel)) {
                if (TextInVoiceFeatureFlag.Companion.getINSTANCE().isEnabled(Long.valueOf(channel.getGuildId()))) {
                    WidgetCallPreviewFullscreen$Companion.launch$default(WidgetCallPreviewFullscreen.Companion, context, channel.getId(), null, 4, null);
                    return;
                }
                WidgetVoiceBottomSheet$Companion widgetVoiceBottomSheet$Companion = WidgetVoiceBottomSheet.Companion;
                FragmentManager parentFragmentManager = appFragment.getParentFragmentManager();
                m.checkNotNullExpressionValue(parentFragmentManager, "appFragment.parentFragmentManager");
                widgetVoiceBottomSheet$Companion.show(parentFragmentManager, channel.getId(), true, WidgetVoiceBottomSheet$FeatureContext.HOME);
                return;
            }
            if (ChannelUtils.D(channel)) {
                StageChannelJoinHelper stageChannelJoinHelper = StageChannelJoinHelper.INSTANCE;
                Context contextRequireContext = appFragment.requireContext();
                FragmentManager parentFragmentManager2 = appFragment.getParentFragmentManager();
                m.checkNotNullExpressionValue(parentFragmentManager2, "appFragment.parentFragmentManager");
                StageChannelJoinHelper.connectToStage$default(stageChannelJoinHelper, contextRequireContext, parentFragmentManager2, channel.getId(), false, false, null, null, null, null, null, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null);
            }
        }
    }

    private final void navigateToGuild(ModelInvite modelInvite) {
        Guild guild = modelInvite.guild;
        if (guild != null) {
            StoreStream.Companion.getGuildSelected().set(guild.getId());
        }
        GuildScheduledEvent guildScheduledEvent = modelInvite.getGuildScheduledEvent();
        if (guildScheduledEvent != null) {
            WidgetGuildScheduledEventDetailsBottomSheet.Companion.enqueue(guildScheduledEvent.getId());
        }
    }

    public final Job joinViaInvite(ModelInvite invite, Class<?> javaClass, AppFragment fragment, String location, Function2<? super Error, ? super Continuation<? super Unit>, ? extends Object> onInvitePostError, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> onInvitePostSuccess, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> onInviteFlowFinished, CaptchaHelper$CaptchaPayload captchaPayload) {
        m.checkNotNullParameter(invite, "invite");
        m.checkNotNullParameter(javaClass, "javaClass");
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        m.checkNotNullParameter(onInvitePostError, "onInvitePostError");
        m.checkNotNullParameter(onInvitePostSuccess, "onInvitePostSuccess");
        m.checkNotNullParameter(onInviteFlowFinished, "onInviteFlowFinished");
        LifecycleOwner viewLifecycleOwner = fragment.getViewLifecycleOwner();
        m.checkNotNullExpressionValue(viewLifecycleOwner, "fragment.viewLifecycleOwner");
        return AppCoroutineScopeKt.appLaunch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), javaClass, (CoroutineContext) null, (CoroutineStart) null, new InviteJoinHelper$joinViaInvite$4(fragment, invite, location, onInvitePostSuccess, captchaPayload, javaClass, onInvitePostError, onInviteFlowFinished, null), 6, (Object) null);
    }
}

package com.discord.utilities.guilds;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.discord.app.AppFragment;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.widgets.guilds.invite.InviteJoinHelper;
import com.discord.widgets.guilds.join.GuildJoinHelperKt;
import com.discord.widgets.guilds.join.InviteArgs;
import com.discord.widgets.guilds.join.JoinArgs;
import com.discord.widgets.guilds.join.WidgetGuildJoinCaptchaBottomSheet;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p018d.C0876m;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import retrofit2.HttpException;

/* JADX INFO: compiled from: GuildCaptchaUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildCaptchaUtilsKt {
    private static final String REQUEST_KEY_GUILD_CAPTCHA = "REQUEST_KEY_GUILD_CAPTCHA";

    /* JADX INFO: renamed from: com.discord.utilities.guilds.GuildCaptchaUtilsKt$handleHttpException$1 */
    /* JADX INFO: compiled from: GuildCaptchaUtils.kt */
    public static final class C67651 extends AbstractC12240o implements Function2<AppFragment, CaptchaHelper.CaptchaPayload, Unit> {
        public final /* synthetic */ InviteArgs $args;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67651(InviteArgs inviteArgs) {
            super(2);
            this.$args = inviteArgs;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
            invoke2(appFragment, captchaPayload);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
            C12238m.checkNotNullParameter(appFragment, "newFragment");
            C12238m.checkNotNullParameter(captchaPayload, "captchaPayload");
            InviteJoinHelper.INSTANCE.joinViaInvite(this.$args.getInvite(), this.$args.getJavaClass(), appFragment, this.$args.getLocation(), this.$args.getOnInvitePostError(), this.$args.getOnInvitePostSuccess(), this.$args.getOnInviteFlowFinished(), captchaPayload);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.guilds.GuildCaptchaUtilsKt$handleHttpException$2 */
    /* JADX INFO: compiled from: GuildCaptchaUtils.kt */
    public static final class C67662 extends AbstractC12240o implements Function2<AppFragment, CaptchaHelper.CaptchaPayload, Unit> {
        public final /* synthetic */ JoinArgs $args;
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67662(Context context, JoinArgs joinArgs) {
            super(2);
            this.$context = context;
            this.$args = joinArgs;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
            invoke2(appFragment, captchaPayload);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
            C12238m.checkNotNullParameter(appFragment, "<anonymous parameter 0>");
            C12238m.checkNotNullParameter(captchaPayload, "captchaPayload");
            Context context = this.$context;
            long guildId = this.$args.getGuildId();
            boolean zIsLurker = this.$args.isLurker();
            String sessionId = this.$args.getSessionId();
            Long directoryChannelId = this.$args.getDirectoryChannelId();
            GuildJoinHelperKt.joinGuild(context, guildId, zIsLurker, (944 & 8) != 0 ? null : sessionId, (944 & 16) != 0 ? null : directoryChannelId, (944 & 32) != 0 ? null : null, this.$args.getErrorClass(), (944 & 128) != 0 ? null : this.$args.getSubscriptionHandler(), (944 & 256) != 0 ? null : this.$args.getErrorHandler(), (944 & 512) != 0 ? null : captchaPayload, this.$args.getOnNext());
        }
    }

    public static final void handleHttpException(Error error, Fragment fragment, InviteArgs inviteArgs) {
        C12238m.checkNotNullParameter(error, "error");
        C12238m.checkNotNullParameter(fragment, "fragment");
        C12238m.checkNotNullParameter(inviteArgs, "args");
        if (error.getThrowable() instanceof HttpException) {
            String bodyText = error.getBodyText();
            if (C12238m.areEqual(bodyText != null ? Boolean.valueOf(C12106w.contains$default((CharSequence) bodyText, (CharSequence) CaptchaHelper.CAPTCHA_KEY, false, 2, (Object) null)) : null, Boolean.TRUE)) {
                WidgetGuildJoinCaptchaBottomSheet.INSTANCE.enqueue(REQUEST_KEY_GUILD_CAPTCHA, new C67651(inviteArgs), CaptchaErrorBody.INSTANCE.createFromError(error));
                return;
            }
            Error.Response response = error.getResponse();
            C12238m.checkNotNullExpressionValue(response, "error.response");
            List list = (List) C12163u.firstOrNull(response.getMessages().values());
            String str = list != null ? (String) C12163u.firstOrNull(list) : null;
            if (str != null) {
                C0876m.m172j(fragment, str, 0, 4);
            }
        }
    }

    public static final void handleHttpException(Error error, Context context, JoinArgs joinArgs) {
        String str;
        C12238m.checkNotNullParameter(error, "error");
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(joinArgs, "args");
        if (error.getThrowable() instanceof HttpException) {
            String bodyText = error.getBodyText();
            if (C12238m.areEqual(bodyText != null ? Boolean.valueOf(C12106w.contains$default((CharSequence) bodyText, (CharSequence) CaptchaHelper.CAPTCHA_KEY, false, 2, (Object) null)) : null, Boolean.TRUE)) {
                WidgetGuildJoinCaptchaBottomSheet.INSTANCE.enqueue(REQUEST_KEY_GUILD_CAPTCHA, new C67662(context, joinArgs), CaptchaErrorBody.INSTANCE.createFromError(error));
                return;
            }
            Error.Response response = error.getResponse();
            C12238m.checkNotNullExpressionValue(response, "error.response");
            List list = (List) C12163u.firstOrNull(response.getMessages().values());
            if (list == null || (str = (String) C12163u.firstOrNull(list)) == null) {
                return;
            }
            C0876m.m170h(context, str, 0, null, 12);
        }
    }
}

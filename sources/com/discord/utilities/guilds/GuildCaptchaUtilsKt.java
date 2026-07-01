package com.discord.utilities.guilds;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.widgets.guilds.join.InviteArgs;
import com.discord.widgets.guilds.join.JoinArgs;
import com.discord.widgets.guilds.join.WidgetGuildJoinCaptchaBottomSheet;
import d0.g0.w;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import retrofit2.HttpException;

/* JADX INFO: compiled from: GuildCaptchaUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildCaptchaUtilsKt {
    private static final String REQUEST_KEY_GUILD_CAPTCHA = "REQUEST_KEY_GUILD_CAPTCHA";

    public static final void handleHttpException(Error error, Fragment fragment, InviteArgs inviteArgs) {
        m.checkNotNullParameter(error, "error");
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(inviteArgs, "args");
        if (error.getThrowable() instanceof HttpException) {
            String bodyText = error.getBodyText();
            if (m.areEqual(bodyText != null ? Boolean.valueOf(w.contains$default((CharSequence) bodyText, (CharSequence) CaptchaHelper.CAPTCHA_KEY, false, 2, (Object) null)) : null, Boolean.TRUE)) {
                WidgetGuildJoinCaptchaBottomSheet.Companion.enqueue(REQUEST_KEY_GUILD_CAPTCHA, new GuildCaptchaUtilsKt$handleHttpException$1(inviteArgs), CaptchaErrorBody.Companion.createFromError(error));
                return;
            }
            Error$Response response = error.getResponse();
            m.checkNotNullExpressionValue(response, "error.response");
            List list = (List) u.firstOrNull(response.getMessages().values());
            String str = list != null ? (String) u.firstOrNull(list) : null;
            if (str != null) {
                b.a.d.m.j(fragment, str, 0, 4);
            }
        }
    }

    public static final void handleHttpException(Error error, Context context, JoinArgs joinArgs) {
        String str;
        m.checkNotNullParameter(error, "error");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(joinArgs, "args");
        if (error.getThrowable() instanceof HttpException) {
            String bodyText = error.getBodyText();
            if (m.areEqual(bodyText != null ? Boolean.valueOf(w.contains$default((CharSequence) bodyText, (CharSequence) CaptchaHelper.CAPTCHA_KEY, false, 2, (Object) null)) : null, Boolean.TRUE)) {
                WidgetGuildJoinCaptchaBottomSheet.Companion.enqueue(REQUEST_KEY_GUILD_CAPTCHA, new GuildCaptchaUtilsKt$handleHttpException$2(context, joinArgs), CaptchaErrorBody.Companion.createFromError(error));
                return;
            }
            Error$Response response = error.getResponse();
            m.checkNotNullExpressionValue(response, "error.response");
            List list = (List) u.firstOrNull(response.getMessages().values());
            if (list == null || (str = (String) u.firstOrNull(list)) == null) {
                return;
            }
            b.a.d.m.h(context, str, 0, null, 12);
        }
    }
}
